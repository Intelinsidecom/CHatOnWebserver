using System;
using System.Collections.Generic;
using System.Globalization;
using System.Xml;

namespace Microsoft.Phone.Controls.Maps.Core;

internal abstract class MapConfigurationProvider
{
	private const string RootNodeName = "configuration";

	private const string versionAttribute = "version";

	private const string cultureAttribute = "culture";

	private const string PropertyNodeName = "add";

	private const string KeyAttribute = "key";

	private const string ValueAttribute = "value";

	protected Dictionary<string, MapConfigurationSection> Sections { get; set; }

	public abstract event EventHandler<MapConfigurationLoadedEventArgs> Loaded;

	public abstract void LoadConfiguration();

	public abstract void GetConfigurationSection(string version, string sectionName, string culture, MapConfigurationCallback callback, object userState);

	protected static string GetConfigurationKey(string version, string sectionName, string culture)
	{
		if (string.IsNullOrEmpty(culture))
		{
			culture = string.Empty;
		}
		return string.Format(CultureInfo.InvariantCulture, "{0}_{1}_{2}", version, sectionName, culture).ToUpper(CultureInfo.InvariantCulture);
	}

	protected MapConfigurationSection GetSection(string version, string sectionName, string culture)
	{
		MapConfigurationSection result = null;
		if (Sections != null)
		{
			string configurationKey = GetConfigurationKey(version, sectionName, culture);
			if (Sections.ContainsKey(configurationKey))
			{
				result = Sections[configurationKey];
			}
			else if (!string.IsNullOrEmpty(culture))
			{
				configurationKey = GetConfigurationKey(version, sectionName, string.Empty);
				if (Sections.ContainsKey(configurationKey))
				{
					result = Sections[configurationKey];
				}
			}
		}
		return result;
	}

	protected bool ContainConfigurationSection(string version, string sectionName, string culture)
	{
		if (Sections != null)
		{
			return Sections.ContainsKey(GetConfigurationKey(version, sectionName, culture));
		}
		return false;
	}

	protected static Dictionary<string, MapConfigurationSection> ParseConfiguration(XmlReader sectionReader)
	{
		if (sectionReader == null)
		{
			throw new ConfigurationNotLoadedException(ExceptionStrings.ConfigurationException_NullXml);
		}
		Dictionary<string, MapConfigurationSection> dictionary = new Dictionary<string, MapConfigurationSection>();
		if (sectionReader.Read() && sectionReader.IsStartElement() && sectionReader.LocalName == "configuration")
		{
			while (sectionReader.Read())
			{
				if (sectionReader.IsStartElement() && sectionReader.LocalName != "configuration")
				{
					string text = sectionReader["version"];
					string localName = sectionReader.LocalName;
					string text2 = sectionReader["culture"];
					if (string.IsNullOrEmpty(localName) || string.IsNullOrEmpty(text))
					{
						throw new XmlException(ExceptionStrings.MapConfiguration_ParseConfiguration_InvalidSection_NoVersion);
					}
					string configurationKey = GetConfigurationKey(text, localName, text2);
					if (dictionary.ContainsKey(configurationKey))
					{
						throw new XmlException(string.Format(CultureInfo.InvariantCulture, ExceptionStrings.MapConfiguration_ParseConfiguration_DuplicateSection, localName, text, text2));
					}
					dictionary.Add(configurationKey, ParseConfigurationSection(sectionReader.ReadSubtree()));
				}
			}
			return dictionary;
		}
		throw new XmlException(string.Format(CultureInfo.InvariantCulture, ExceptionStrings.MapConfiguration_ParseConfiguration_InvalidRoot, sectionReader.LocalName));
	}

	private static MapConfigurationSection ParseConfigurationSection(XmlReader sectionReader)
	{
		Dictionary<string, string> dictionary = new Dictionary<string, string>();
		if (sectionReader.Read() && !sectionReader.IsEmptyElement)
		{
			while (sectionReader.Read())
			{
				if (!sectionReader.IsStartElement())
				{
					continue;
				}
				if (sectionReader.LocalName == "add")
				{
					string text = sectionReader["key"].ToUpper(CultureInfo.InvariantCulture);
					string value = sectionReader["value"];
					if (!string.IsNullOrEmpty(text) && !string.IsNullOrEmpty(value))
					{
						if (dictionary.ContainsKey(text))
						{
							throw new XmlException(string.Format(CultureInfo.InvariantCulture, ExceptionStrings.MapConfiguration_ParseConfiguration_DuplicateNodeKey, text));
						}
						dictionary.Add(text, value);
					}
					continue;
				}
				throw new XmlException(string.Format(CultureInfo.InvariantCulture, ExceptionStrings.MapConfiguration_ParseConfiguration_InvalidTag, sectionReader.LocalName));
			}
		}
		return new MapConfigurationSection(dictionary);
	}
}
