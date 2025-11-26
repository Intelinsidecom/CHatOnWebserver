using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatON_WoA.Services;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.Storage;
using Windows.Storage.Streams;
using Windows.UI.Core;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Controls;

public class AniconPlayer : UserControl, IComponentConnector
{
	public static readonly DependencyProperty SourceIDProperty = DependencyProperty.RegisterAttached("SourceID", typeof(string), typeof(AniconPlayer), new PropertyMetadata((object)null, new PropertyChangedCallback(SourceChanged)));

	private int _currentIndex;

	private DispatcherTimer timer = new DispatcherTimer();

	private Anicon _source;

	private bool _isDownloading;

	private string _sourceID;

	private int _count;

	private bool _isLoaded;

	private bool _isFirst = true;

	private static List<AniconInstaller> _installingAnicons = new List<AniconInstaller>();

	private static object _installLock = new object();

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image CurrentFrameImage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ProgressRing ProgressControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image ImgRefresh;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public string SourceID
	{
		get
		{
			return (string)((DependencyObject)this).GetValue(SourceIDProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(SourceIDProperty, (object)value);
		}
	}

	private static void SourceChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		if (obj is AniconPlayer aniconPlayer)
		{
			aniconPlayer._sourceID = e.NewValue as string;
			if (aniconPlayer._isLoaded)
			{
				aniconPlayer.Play();
			}
		}
	}

	public unsafe AniconPlayer()
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected O, but got Unknown
		InitializeComponent();
		_currentIndex = 0;
		_isDownloading = false;
		DispatcherTimer val = timer;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(val, (nint)__ldftn(DispatcherTimer.remove_Tick)), timer_Tick);
	}

	private void AniconPlayer_Loaded(object sender, RoutedEventArgs e)
	{
		if (_isFirst)
		{
			Play();
		}
		_isLoaded = true;
		_isFirst = false;
	}

	private void AniconPlayer_Unloaded(object sender, RoutedEventArgs e)
	{
		timer.Stop();
		_isLoaded = false;
	}

	public void Play()
	{
		//IL_01b3: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ba: Expected O, but got Unknown
		//IL_023b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0242: Expected O, but got Unknown
		DispatchedHandler val = null;
		DispatchedHandler val2 = null;
		if (string.IsNullOrEmpty(SourceID))
		{
			return;
		}
		ProgressControl.put_IsActive(true);
		Init();
		DataService dataService = new DataService();
		foreach (OfflineAniconPackage aninconPackage in dataService.AninconPackages)
		{
			_source = aninconPackage.AniconList.FirstOrDefault((Anicon c) => c.ID == SourceID);
			if (_source != null)
			{
				break;
			}
		}
		if (_source == null)
		{
			_source = dataService.ReceivedAnicons.FirstOrDefault((Anicon c) => c.ID == SourceID);
			if (_source != null && !_source.IsLoaded)
			{
				_source.LoadCompleted += anicon_LoadCompleted;
			}
			else if (_source == null)
			{
				if (_isDownloading)
				{
					return;
				}
				_isDownloading = true;
				AniconInstaller aniconInstaller = null;
				aniconInstaller = new AniconInstaller();
				aniconInstaller.ID = _sourceID;
				lock (_installLock)
				{
					_installingAnicons.Add(aniconInstaller);
				}
				SSMService ssmService = new SSMService();
				ssmService.DownloadAniconCompleted += ssmService_DownloadAniconCompleted;
				Task.Run(delegate
				{
					ssmService.DownloadAnicon(_sourceID);
				});
			}
		}
		if (_source == null)
		{
			return;
		}
		if (!Utility.CheckForInternetConnection())
		{
			CoreDispatcher dispatcher = ((DependencyObject)this).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)async delegate
				{
					((UIElement)ImgRefresh).put_Visibility((Visibility)0);
					ProgressControl.put_IsActive(false);
					AniconInstaller aniconInstaller2 = _installingAnicons.FirstOrDefault((AniconInstaller c) => c.ID == _sourceID);
					if (aniconInstaller2 != null)
					{
						_installingAnicons.Remove(aniconInstaller2);
					}
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)1, val);
		}
		else if (!_source.IsLoaded)
		{
			_source.LoadCompleted += anicon_LoadCompleted;
			if (_source.IsLoading)
			{
				return;
			}
			_source.IsLoading = true;
			if (Task.Run(() => _source.Load(_sourceID)).Wait(30000))
			{
				return;
			}
			CoreDispatcher dispatcher2 = ((DependencyObject)this).Dispatcher;
			if (val2 == null)
			{
				val2 = (DispatchedHandler)async delegate
				{
					((UIElement)ImgRefresh).put_Visibility((Visibility)0);
					ProgressControl.put_IsActive(false);
					AniconInstaller aniconInstaller2 = _installingAnicons.FirstOrDefault((AniconInstaller c) => c.ID == _sourceID);
					if (aniconInstaller2 != null)
					{
						_installingAnicons.Remove(aniconInstaller2);
					}
				};
			}
			dispatcher2.RunAsync((CoreDispatcherPriority)1, val2);
		}
		else
		{
			ProgressControl.put_IsActive(false);
			timer.Start();
		}
	}

	private void CheckError()
	{
		_ = _source.DelegateImageFile;
	}

	private void installer_InstallCompleted(object sender, EventArgs e)
	{
		if (!(sender is AniconInstaller))
		{
			return;
		}
		(sender as AniconInstaller).InstallCompleted -= installer_InstallCompleted;
		DataService dataService = new DataService();
		_source = dataService.ReceivedAnicons.FirstOrDefault((Anicon c) => c.ID == SourceID);
		if (_source != null)
		{
			if (!_source.IsLoaded)
			{
				_source.LoadCompleted += anicon_LoadCompleted;
				return;
			}
			ProgressControl.put_IsActive(false);
			timer.Start();
		}
	}

	private void Init()
	{
		timer.put_Interval(TimeSpan.FromMilliseconds(100.0));
		timer.Stop();
		_currentIndex = 0;
		_source = null;
		_count = 0;
	}

	private async void ssmService_DownloadAniconCompleted(object sender, SSMCompletedEventArgs e)
	{
		DispatchedHandler val = null;
		if (e.Xml == null)
		{
			_isDownloading = false;
			CoreDispatcher dispatcher = ((DependencyObject)this).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)async delegate
				{
					((UIElement)ImgRefresh).put_Visibility((Visibility)0);
					ProgressControl.put_IsActive(false);
					AniconInstaller aniconInstaller = _installingAnicons.FirstOrDefault((AniconInstaller c) => c.ID == _sourceID);
					if (aniconInstaller != null)
					{
						_installingAnicons.Remove(aniconInstaller);
					}
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)1, val);
			return;
		}
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)(-1), (DispatchedHandler)async delegate
		{
			Init();
			Anicon anicon = AniconService.GetAniconInfo(e.Xml);
			DataService dataService = new DataService();
			Anicon findedAnicon = dataService.ReceivedAnicons.FirstOrDefault((Anicon c) => c.ID == anicon.ID);
			if (findedAnicon != null)
			{
				if (!findedAnicon.IsLoaded)
				{
					_source = findedAnicon;
					findedAnicon.LoadCompleted += anicon_LoadCompleted;
					return;
				}
				anicon = findedAnicon;
				_isDownloading = false;
				timer.Start();
				ProgressControl.put_IsActive(false);
			}
			else
			{
				anicon.LoadCompleted += anicon_LoadCompleted;
				await Task.Run(() => anicon.Load("received"));
			}
			_source = anicon;
		});
	}

	private async void anicon_LoadCompleted(object sender, EventArgs e)
	{
		DispatchedHandler val = null;
		DispatchedHandler val2 = null;
		DispatchedHandler val3 = null;
		if (sender is Anicon)
		{
			(sender as Anicon).LoadCompleted -= anicon_LoadCompleted;
			if (_source != null)
			{
				CoreDispatcher dispatcher = ((DependencyObject)this).Dispatcher;
				if (val == null)
				{
					val = (DispatchedHandler)async delegate
					{
						DataService dataService = new DataService
						{
							ReceivedAnicons = { sender as Anicon }
						};
						_ = sender is Anicon;
						lock (_installLock)
						{
							_installingAnicons.FirstOrDefault((AniconInstaller c) => c.ID == _sourceID)?.RunEventHandler();
						}
						_isDownloading = false;
						ProgressControl.put_IsActive(false);
						timer.Start();
					};
				}
				dispatcher.RunAsync((CoreDispatcherPriority)(-1), val);
			}
			else if (!Utility.CheckForInternetConnection())
			{
				CoreDispatcher dispatcher2 = ((DependencyObject)this).Dispatcher;
				if (val2 == null)
				{
					val2 = (DispatchedHandler)async delegate
					{
						((UIElement)ImgRefresh).put_Visibility((Visibility)0);
						ProgressControl.put_IsActive(false);
					};
				}
				dispatcher2.RunAsync((CoreDispatcherPriority)1, val2);
			}
			else
			{
				Anicon anicon = sender as Anicon;
				anicon.LoadCompleted += anicon_LoadCompleted;
				await Task.Run(() => anicon.Load("received"));
			}
		}
		else
		{
			if (_source != null || Utility.CheckForInternetConnection())
			{
				return;
			}
			CoreDispatcher dispatcher3 = ((DependencyObject)this).Dispatcher;
			if (val3 == null)
			{
				val3 = (DispatchedHandler)async delegate
				{
					((UIElement)ImgRefresh).put_Visibility((Visibility)0);
					ProgressControl.put_IsActive(false);
				};
			}
			dispatcher3.RunAsync((CoreDispatcherPriority)1, val3);
		}
	}

	private void timer_Tick(object sender, object e)
	{
		//IL_0047: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		DispatchedHandler val = null;
		try
		{
			timer.Stop();
			if (_source == null || _source.ImageFileList.Count == 0 || _count >= 5)
			{
				return;
			}
			CoreDispatcher dispatcher = ((DependencyObject)this).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)async delegate
				{
					int num = default(int);
					_ = num;
					_ = 0;
					try
					{
						if (_isLoaded)
						{
							if (_currentIndex >= _source.ImageFileList.Count)
							{
								_currentIndex = 0;
								_count++;
							}
							string imgUri = _source.ImageUrlList[_currentIndex];
							string[] p = GetParams(imgUri);
							int delay = int.Parse(p[2]);
							IRandomAccessStream fs = await _source.ImageFileList[_currentIndex].OpenAsync((FileAccessMode)0);
							if (fs != null)
							{
								BitmapImage img = new BitmapImage();
								((BitmapSource)img).SetSource(fs);
								CurrentFrameImage.put_Source((ImageSource)(object)img);
								_currentIndex++;
								timer.Stop();
								timer.put_Interval(TimeSpan.FromMilliseconds(delay));
								timer.Start();
								((UIElement)this).UpdateLayout();
							}
						}
					}
					catch (Exception)
					{
					}
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		}
		catch
		{
		}
	}

	private static string[] GetParams(string imgUri)
	{
		string[] array = Utility.Split(imgUri, '?');
		array = Utility.Split(array[0], '/');
		string input = array[array.Length - 1];
		array = Utility.Split(input, '.');
		string input2 = array[0];
		return Utility.Split(input2, '_');
	}

	private void LayoutRoot_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
	}

	private void Refresh_Click(object sender, TappedRoutedEventArgs e)
	{
		Play();
		((UIElement)ImgRefresh).put_Visibility((Visibility)1);
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///AniconPlayer.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			CurrentFrameImage = (Image)((FrameworkElement)this).FindName("CurrentFrameImage");
			ProgressControl = (ProgressRing)((FrameworkElement)this).FindName("ProgressControl");
			ImgRefresh = (Image)((FrameworkElement)this).FindName("ImgRefresh");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_001c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0022: Expected O, but got Unknown
		//IL_0041: Unknown result type (might be due to invalid IL or missing references)
		//IL_004b: Expected O, but got Unknown
		//IL_004c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0052: Expected O, but got Unknown
		//IL_0071: Unknown result type (might be due to invalid IL or missing references)
		//IL_007b: Expected O, but got Unknown
		//IL_007e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0084: Expected O, but got Unknown
		//IL_00a3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ad: Expected O, but got Unknown
		//IL_00b0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b7: Expected O, but got Unknown
		//IL_00d8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e2: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val3 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.add_Unloaded)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.remove_Unloaded)), new RoutedEventHandler(AniconPlayer_Unloaded));
			FrameworkElement val4 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(AniconPlayer_Loaded));
			break;
		}
		case 2:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(LayoutRoot_Tapped_1));
			break;
		}
		case 3:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Refresh_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
