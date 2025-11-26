using System;
using System.ComponentModel;
using System.IO;
using System.Xml;

namespace Microsoft.Phone.Controls.Maps.Core;

public static class MapConfiguration
{
	private static MapConfigurationProvider configuration;

	private static string defaultServiceUriFormat = "{UriScheme}://dev.virtualearth.net/webservices/v1/MapControlConfigurationService/MapControlConfigurationService.svc/binaryHttp";

	public static event EventHandler<MapConfigurationLoadedEventArgs> Loaded;

	public static void SetServiceUri(Uri address)
	{
		LoadConfiguration(new MapConfigurationFromService(address));
	}

	public static void Load(XmlReader config)
	{
		LoadConfiguration(new MapConfigurationFromFile(config));
	}

	public static void Load(Uri address)
	{
		LoadConfiguration(new MapConfigurationFromWeb(address));
	}

	public static void GetSection(string version, string sectionName, string culture, MapConfigurationCallback callback)
	{
		GetSection(version, sectionName, culture, callback, null);
	}

	public static void GetSection(string version, string sectionName, string culture, MapConfigurationCallback callback, object userState)
	{
		if (configuration == null)
		{
			if (DesignerProperties.IsInDesignTool)
			{
				try
				{
					Stream manifestResourceStream = typeof(MapConfiguration).Assembly.GetManifestResourceStream("Microsoft.Phone.Controls.Maps.Data.DesignConfig.xml");
					if (manifestResourceStream != null)
					{
						XmlReader config = XmlReader.Create(manifestResourceStream);
						LoadConfiguration(new MapConfigurationFromFile(config));
					}
				}
				catch (XmlException)
				{
				}
			}
			else
			{
				Uri address = new Uri(defaultServiceUriFormat.Replace("{UriScheme}", "HTTP"), UriKind.Absolute);
				LoadConfiguration(new MapConfigurationFromService(address));
			}
		}
		if (string.IsNullOrEmpty(version))
		{
			throw new ArgumentException(ExceptionStrings.MapConfiguration_GetSection_NonNull, "version");
		}
		if (string.IsNullOrEmpty(sectionName))
		{
			throw new ArgumentException(ExceptionStrings.MapConfiguration_GetSection_NonNull, "sectionName");
		}
		configuration.GetConfigurationSection(version, sectionName, culture, callback, userState);
	}

	internal static void Reset()
	{
		MapConfiguration.Loaded = null;
		if (configuration != null)
		{
			configuration.Loaded -= provider_Loaded;
			configuration = null;
		}
	}

	private static void LoadConfiguration(MapConfigurationProvider provider)
	{
		if (configuration != null)
		{
			throw new ConfigurationNotLoadedException(ExceptionStrings.ConfigurationException_InvalidLoad);
		}
		configuration = provider;
		provider.Loaded += provider_Loaded;
		provider.LoadConfiguration();
	}

	private static void provider_Loaded(object sender, MapConfigurationLoadedEventArgs e)
	{
		MapConfiguration.Loaded?.Invoke(null, e);
	}
}
