using System;
using System.Xml;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class MapConfigurationFromFile : MapConfigurationProvider
{
	private readonly XmlReader config;

	public override event EventHandler<MapConfigurationLoadedEventArgs> Loaded;

	public MapConfigurationFromFile(XmlReader config)
	{
		this.config = config;
	}

	public override void LoadConfiguration()
	{
		try
		{
			base.Sections = MapConfigurationProvider.ParseConfiguration(config);
			if (Loaded != null)
			{
				Loaded(this, new MapConfigurationLoadedEventArgs(null));
			}
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
		callback?.Invoke(GetSection(version, sectionName, culture), userState);
	}
}
