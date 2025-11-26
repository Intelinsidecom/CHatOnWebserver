using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using System.IO.IsolatedStorage;
using System.Net.NetworkInformation;
using System.ServiceModel;
using System.ServiceModel.Channels;
using System.Text;
using System.Windows.Threading;
using System.Xml;
using Microsoft.Phone.Controls.Maps.ConfigService;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class MapConfigurationFromService : MapConfigurationProvider
{
	private readonly object configLock = new object();

	private readonly Dictionary<string, Collection<MapConfigurationGetSectionRequest>> requestQueue;

	private readonly Collection<string> requestedSections;

	private readonly MapControlConfigurationServiceClient serviceClient;

	private MapControlConfigurationRequest configRequest;

	private string configRequestKey;

	private bool detectingNetworkChanged;

	private int retryLimit = 10;

	private bool isConfigLoaded;

	private DispatcherTimer networkChangePollTimer;

	public override event EventHandler<MapConfigurationLoadedEventArgs> Loaded;

	public MapConfigurationFromService(Uri address)
	{
		HttpTransportBindingElement httpTransportBindingElement = new HttpTransportBindingElement();
		CustomBinding binding = new CustomBinding(new BinaryMessageEncodingBindingElement(), httpTransportBindingElement);
		serviceClient = new MapControlConfigurationServiceClient(binding, new EndpointAddress(address));
		serviceClient.GetConfigurationCompleted += ServiceClient_GetConfigurationCompleted;
		base.Sections = new Dictionary<string, MapConfigurationSection>();
		requestQueue = new Dictionary<string, Collection<MapConfigurationGetSectionRequest>>();
		requestedSections = new Collection<string>();
	}

	public override void LoadConfiguration()
	{
	}

	public override void GetConfigurationSection(string version, string sectionName, string culture, MapConfigurationCallback callback, object userState)
	{
		bool flag = ContainConfigurationSection(version, sectionName, culture);
		if (!flag)
		{
			string configurationKey = MapConfigurationProvider.GetConfigurationKey(version, sectionName, culture);
			bool flag2;
			lock (configLock)
			{
				flag = ContainConfigurationSection(version, sectionName, culture) || requestedSections.Contains(configurationKey);
				flag2 = !flag && !requestQueue.ContainsKey(configurationKey);
				if (!requestQueue.ContainsKey(configurationKey))
				{
					requestQueue.Add(configurationKey, new Collection<MapConfigurationGetSectionRequest>());
				}
				if (!flag)
				{
					requestQueue[configurationKey].Add(new MapConfigurationGetSectionRequest(version, sectionName, culture, callback, userState));
				}
			}
			if (flag2)
			{
				MapControlConfigurationRequest mapControlConfigurationRequest = new MapControlConfigurationRequest();
				mapControlConfigurationRequest.ExecutionOptions = new ExecutionOptions();
				mapControlConfigurationRequest.ExecutionOptions.SuppressFaults = true;
				if (string.IsNullOrEmpty(culture))
				{
					mapControlConfigurationRequest.Culture = culture;
				}
				mapControlConfigurationRequest.Version = version;
				mapControlConfigurationRequest.SectionName = sectionName;
				configRequest = mapControlConfigurationRequest;
				configRequestKey = configurationKey;
				string filename = GetFilename(configurationKey);
				try
				{
					using IsolatedStorageFile isolatedStorageFile = IsolatedStorageFile.GetUserStoreForApplication();
					if (isolatedStorageFile.FileExists(filename))
					{
						using IsolatedStorageFileStream input = new IsolatedStorageFileStream(filename, FileMode.Open, isolatedStorageFile);
						try
						{
							LoadConfig(configurationKey, XmlReader.Create(input));
						}
						catch (XmlException)
						{
						}
					}
				}
				catch (IsolatedStorageException)
				{
				}
				MakeServiceRequest();
			}
		}
		if (flag)
		{
			callback?.Invoke(GetSection(version, sectionName, culture), userState);
		}
	}

	private void MakeServiceRequest()
	{
		if (NetworkInterface.GetIsNetworkAvailable())
		{
			retryLimit--;
			if (configRequest != null && configRequestKey != null)
			{
				serviceClient.GetConfigurationAsync(configRequest, configRequestKey);
			}
		}
		else if (!isConfigLoaded && !detectingNetworkChanged)
		{
			detectingNetworkChanged = true;
			if (networkChangePollTimer == null)
			{
				networkChangePollTimer = new DispatcherTimer
				{
					Interval = TimeSpan.FromSeconds(5.0)
				};
				networkChangePollTimer.Tick += NetworkChangePollTimer_Tick;
			}
			networkChangePollTimer.Start();
		}
	}

	private void NetworkChangePollTimer_Tick(object sender, EventArgs e)
	{
		if (NetworkInterface.GetIsNetworkAvailable())
		{
			detectingNetworkChanged = false;
			networkChangePollTimer.Stop();
			networkChangePollTimer.Tick -= NetworkChangePollTimer_Tick;
			networkChangePollTimer = null;
			MakeServiceRequest();
		}
	}

	private void ServiceClient_GetConfigurationCompleted(object sender, GetConfigurationCompletedEventArgs e)
	{
		string requestKey = e.UserState as string;
		if (e.Error != null)
		{
			if (Loaded != null)
			{
				Loaded(this, new MapConfigurationLoadedEventArgs(e.Error));
			}
			if (retryLimit > 0)
			{
				MakeServiceRequest();
			}
			else
			{
				CallRequests(requestKey);
			}
			return;
		}
		if (e.Result == null || e.Result.Configuration == null)
		{
			if (Loaded != null)
			{
				Loaded(this, new MapConfigurationLoadedEventArgs(new ConfigurationNotLoadedException(ExceptionStrings.MapConfiguration_WebService_InvalidResult)));
			}
			CallRequests(requestKey);
			return;
		}
		if (!isConfigLoaded)
		{
			LoadConfig(requestKey, XmlReader.Create(new StringReader(e.Result.Configuration)));
		}
		try
		{
			using IsolatedStorageFile isf = IsolatedStorageFile.GetUserStoreForApplication();
			using IsolatedStorageFileStream isolatedStorageFileStream = new IsolatedStorageFileStream(GetFilename(requestKey), FileMode.Create, isf);
			string configuration = e.Result.Configuration;
			try
			{
				isolatedStorageFileStream.Write(new UTF8Encoding().GetBytes(configuration), 0, configuration.Length);
			}
			catch (IOException)
			{
			}
		}
		catch (IsolatedStorageException)
		{
		}
	}

	private void LoadConfig(string requestKey, XmlReader config)
	{
		isConfigLoaded = true;
		Dictionary<string, MapConfigurationSection> dictionary = MapConfigurationProvider.ParseConfiguration(config);
		lock (configLock)
		{
			foreach (string key in dictionary.Keys)
			{
				if (!base.Sections.ContainsKey(key))
				{
					base.Sections[key] = dictionary[key];
				}
			}
			requestedSections.Add(requestKey);
		}
		if (Loaded != null)
		{
			Loaded(this, new MapConfigurationLoadedEventArgs(null));
		}
		CallRequests(requestKey);
	}

	private void CallRequests(string requestKey)
	{
		if (!requestQueue.ContainsKey(requestKey))
		{
			return;
		}
		Collection<MapConfigurationGetSectionRequest> collection = requestQueue[requestKey];
		requestQueue.Remove(requestKey);
		foreach (MapConfigurationGetSectionRequest item in collection)
		{
			if (item.Callback != null)
			{
				item.Callback(GetSection(item.Version, item.SectionName, item.Culture), item.UserState);
			}
		}
	}

	private string GetFilename(string requestKey)
	{
		return "MapControlConfiguration_" + requestKey + ".xml";
	}
}
