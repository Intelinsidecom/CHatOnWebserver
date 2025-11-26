using System;
using System.ComponentModel;
using System.Globalization;
using System.Net;
using System.Net.NetworkInformation;
using System.Reflection;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Threading;
using Microsoft.Phone.Controls.Maps.AutomationPeers;
using Microsoft.Phone.Controls.Maps.Core;
using Microsoft.Phone.Controls.Maps.Design;
using Microsoft.Phone.Controls.Maps.Overlays;

namespace Microsoft.Phone.Controls.Maps;

public sealed class Map : MapCore
{
	private static class LogEntry
	{
		public const string StartSession = "0";

		public const string ChangeCredentials = "2";
	}

	private static readonly string version = GetVersion();

	private WeakEventListener<Map, object, PropertyChangedEventArgs> _weakMapCredentials;

	private LoadingErrorMessage loadingErrorMessage;

	private string logServiceUriFormat;

	private Guid sessionId = Guid.Empty;

	private DispatcherTimer timer;

	private DispatcherTimer networkChangePollTimer;

	public MapForeground MapForeground { get; private set; }

	[TypeConverter(typeof(MapModeConverter))]
	public override MapMode Mode
	{
		get
		{
			return base.Mode;
		}
		set
		{
			base.Mode = value;
		}
	}

	[TypeConverter(typeof(ApplicationIdCredentialsProviderConverter))]
	public new CredentialsProvider CredentialsProvider
	{
		get
		{
			return base.CredentialsProvider;
		}
		set
		{
			base.CredentialsProvider = value;
		}
	}

	public Map()
	{
		base.LoadingError += Map_LoadingError;
		base.CredentialsProvider = new ApplicationIdCredentialsProvider();
		Mode = new RoadMode();
		base.ScaleVisibility = Visibility.Collapsed;
		base.ZoomBarVisibility = Visibility.Collapsed;
		MapForeground = new MapForeground(this);
		base.RootLayer.Children.Add(MapForeground);
		RoutedEventHandler value = delegate
		{
			if (timer != null)
			{
				timer.Tick -= LogStartSession;
			}
			if (networkChangePollTimer != null)
			{
				networkChangePollTimer.Tick -= NetworkChangePollTimer_Tick;
			}
		};
		base.Unloaded += value;
	}

	~Map()
	{
		if (_weakMapCredentials != null)
		{
			_weakMapCredentials.Detach();
			_weakMapCredentials = null;
		}
	}

	protected override void OnCultureChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
		base.OnCultureChanged(eventArgs);
		if (MapForeground.Culture == null || eventArgs.OldValue as string == MapForeground.Culture)
		{
			MapForeground.Culture = eventArgs.NewValue as string;
		}
	}

	protected override void OnCredentialsProviderChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
		base.OnCredentialsProviderChanged(eventArgs);
		if (eventArgs.OldValue is INotifyPropertyChanged && _weakMapCredentials != null)
		{
			_weakMapCredentials.Detach();
			_weakMapCredentials = null;
		}
		INotifyPropertyChanged newCredentials = eventArgs.NewValue as INotifyPropertyChanged;
		if (newCredentials != null)
		{
			_weakMapCredentials = new WeakEventListener<Map, object, PropertyChangedEventArgs>(this);
			_weakMapCredentials.OnEventAction = delegate(Map instance, object source, PropertyChangedEventArgs leventArgs)
			{
				instance.Credentials_PropertyChanged(source, leventArgs);
			};
			_weakMapCredentials.OnDetachAction = delegate(WeakEventListener<Map, object, PropertyChangedEventArgs> weakEventListener)
			{
				newCredentials.PropertyChanged -= weakEventListener.OnEvent;
			};
			newCredentials.PropertyChanged += _weakMapCredentials.OnEvent;
		}
		Log("2");
	}

	protected override void OnFirstFrame()
	{
		base.OnFirstFrame();
		MapConfiguration.GetSection("v1", "WP7SLMapControl", null, ConfigurationLoadedAfterFirstFrame);
		if (!DesignerProperties.IsInDesignTool && !NetworkInterface.GetIsNetworkAvailable())
		{
			ThrowLoadingException(new ConfigurationNotLoadedException());
			networkChangePollTimer = new DispatcherTimer
			{
				Interval = TimeSpan.FromSeconds(5.0)
			};
			networkChangePollTimer.Tick += NetworkChangePollTimer_Tick;
			networkChangePollTimer.Start();
		}
	}

	private static string GetVersion()
	{
		string result = string.Empty;
		string[] array = Assembly.GetExecutingAssembly().FullName.Split(',');
		if (array.Length > 1)
		{
			result = array[1].Replace("Version=", string.Empty).Trim();
		}
		return result;
	}

	private void ConfigurationLoadedAfterFirstFrame(MapConfigurationSection config, object userState)
	{
		if (config != null)
		{
			logServiceUriFormat = config["LogServiceUriFormat"];
			if (!string.IsNullOrEmpty(logServiceUriFormat))
			{
				logServiceUriFormat = logServiceUriFormat.Replace("{UriScheme}", "HTTP");
				timer = new DispatcherTimer();
				timer.Interval = new TimeSpan(0, 0, 0, 5);
				timer.Tick += LogStartSession;
				timer.Start();
			}
		}
	}

	private void LogStartSession(object sender, EventArgs e)
	{
		timer.Stop();
		timer.Tick -= LogStartSession;
		timer = null;
		sessionId = Guid.NewGuid();
		Log("0");
	}

	private void Log(string entry)
	{
		if (CredentialsProvider != null)
		{
			CredentialsProvider.GetCredentials(delegate(Credentials credentials)
			{
				Log(entry, credentials);
			});
		}
	}

	private void Log(string entry, Credentials credentials)
	{
		try
		{
			if (!string.IsNullOrEmpty(logServiceUriFormat) && !DesignerProperties.GetIsInDesignMode(this) && sessionId != Guid.Empty && NetworkInterface.GetIsNetworkAvailable())
			{
				string requestUriString = string.Format(CultureInfo.InvariantCulture, logServiceUriFormat, entry, credentials, version, sessionId, base.Culture);
				HttpWebRequest httpWebRequest = (HttpWebRequest)WebRequest.Create(requestUriString);
				httpWebRequest.BeginGetResponse(LogResponse, httpWebRequest);
			}
		}
		catch (WebException)
		{
			OnCredentialsError();
		}
		catch (NotSupportedException)
		{
		}
	}

	private void LogResponse(IAsyncResult result)
	{
		bool flag = false;
		try
		{
			HttpWebRequest httpWebRequest = (HttpWebRequest)result.AsyncState;
			HttpWebResponse httpWebResponse = (HttpWebResponse)httpWebRequest.EndGetResponse(result);
			flag = httpWebResponse.StatusCode != HttpStatusCode.Unauthorized;
		}
		catch (WebException ex)
		{
			flag = !(ex.Response is HttpWebResponse httpWebResponse2) || httpWebResponse2.StatusCode != HttpStatusCode.Unauthorized;
		}
		if (flag)
		{
			base.Dispatcher.BeginInvoke(delegate
			{
				OnCredentialsValid();
			});
		}
		else
		{
			base.Dispatcher.BeginInvoke(delegate
			{
				OnCredentialsError();
			});
		}
	}

	private void NetworkChangePollTimer_Tick(object sender, EventArgs e)
	{
		if (!NetworkInterface.GetIsNetworkAvailable())
		{
			return;
		}
		networkChangePollTimer.Stop();
		networkChangePollTimer.Tick -= NetworkChangePollTimer_Tick;
		networkChangePollTimer = null;
		if (!(base.LoadingException is ConfigurationNotLoadedException))
		{
			return;
		}
		base.Dispatcher.BeginInvoke(delegate
		{
			base.LoadingException = null;
			if (loadingErrorMessage != null)
			{
				base.RootLayer.Children.Remove(loadingErrorMessage);
				loadingErrorMessage = null;
			}
		});
	}

	private void OnCredentialsError()
	{
		ThrowLoadingException(new CredentialsInvalidException());
	}

	private void OnCredentialsValid()
	{
		if (base.LoadingException is CredentialsInvalidException)
		{
			base.LoadingException = null;
			if (loadingErrorMessage != null)
			{
				base.RootLayer.Children.Remove(loadingErrorMessage);
				loadingErrorMessage = null;
			}
		}
	}

	private void Credentials_PropertyChanged(object sender, PropertyChangedEventArgs e)
	{
		Log("2");
	}

	private void Map_LoadingError(object sender, LoadingErrorEventArgs e)
	{
		if (loadingErrorMessage == null)
		{
			loadingErrorMessage = new LoadingErrorMessage();
			base.RootLayer.Children.Add(loadingErrorMessage);
		}
		if (e.LoadingException is UriSchemeNotSupportedException)
		{
			loadingErrorMessage.SetUriSchemeError(base.Culture);
		}
		else if (e.LoadingException is ConfigurationNotLoadedException)
		{
			loadingErrorMessage.SetConfigurationError(base.Culture);
		}
		else if (e.LoadingException is CredentialsInvalidException)
		{
			loadingErrorMessage.SetCredentialsError(base.Culture);
		}
	}

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new MapAutomationPeer(this);
	}
}
