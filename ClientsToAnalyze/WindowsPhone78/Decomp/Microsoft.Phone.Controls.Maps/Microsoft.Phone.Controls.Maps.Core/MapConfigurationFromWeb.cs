using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Net;
using System.Xml;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class MapConfigurationFromWeb : MapConfigurationProvider
{
	private readonly object configLock = new object();

	private readonly Uri configurationUri;

	private Collection<MapConfigurationGetSectionRequest> requestQueue;

	public override event EventHandler<MapConfigurationLoadedEventArgs> Loaded;

	public MapConfigurationFromWeb(Uri configurationUri)
	{
		this.configurationUri = configurationUri;
	}

	public override void LoadConfiguration()
	{
		try
		{
			requestQueue = new Collection<MapConfigurationGetSectionRequest>();
			WebClient webClient = new WebClient();
			webClient.OpenReadCompleted += LoadFromServer_OpenReadCompleted;
			webClient.OpenReadAsync(configurationUri);
		}
		catch (Exception error)
		{
			if (Loaded != null)
			{
				Loaded(this, new MapConfigurationLoadedEventArgs(error));
			}
		}
	}

	public override void GetConfigurationSection(string version, string sectionName, string culture, MapConfigurationCallback callback, object userState)
	{
		bool flag = base.Sections != null;
		if (!flag)
		{
			lock (configLock)
			{
				flag = base.Sections != null;
				if (!flag)
				{
					requestQueue.Add(new MapConfigurationGetSectionRequest(version, sectionName, culture, callback, userState));
				}
			}
		}
		if (flag)
		{
			callback?.Invoke(GetSection(version, sectionName, culture), userState);
		}
	}

	private void LoadFromServer_OpenReadCompleted(object sender, OpenReadCompletedEventArgs e)
	{
		try
		{
			if (e.Error != null || e.Result == null)
			{
				throw e.Error;
			}
			XmlReader sectionReader = XmlReader.Create(e.Result);
			Dictionary<string, MapConfigurationSection> sections = MapConfigurationProvider.ParseConfiguration(sectionReader);
			lock (configLock)
			{
				base.Sections = sections;
			}
			if (Loaded != null)
			{
				Loaded(this, new MapConfigurationLoadedEventArgs(null));
			}
		}
		catch (Exception error)
		{
			lock (configLock)
			{
				base.Sections = new Dictionary<string, MapConfigurationSection>();
			}
			if (Loaded != null)
			{
				Loaded(this, new MapConfigurationLoadedEventArgs(error));
			}
		}
		foreach (MapConfigurationGetSectionRequest item in requestQueue)
		{
			if (item.Callback != null)
			{
				item.Callback(GetSection(item.Version, item.SectionName, item.Culture), item.UserState);
			}
		}
		requestQueue = null;
	}
}
