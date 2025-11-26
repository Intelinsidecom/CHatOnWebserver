using System.Collections.Generic;
using Windows.Storage;

namespace ChatOn.Infrastructure;

public static class IsoSettingHelper
{
	private static ApplicationDataContainer isolatedSettings = ApplicationData.Current.LocalSettings;

	private static object _isoSettingLock = new object();

	public static T Get<T>(string keyName, T defaultValue)
	{
		if (((IDictionary<string, object>)isolatedSettings.Values)[keyName] != null)
		{
			return (T)((IDictionary<string, object>)isolatedSettings.Values)[keyName];
		}
		return defaultValue;
	}

	public static void Set(string keyName, object value)
	{
		((IDictionary<string, object>)isolatedSettings.Values)[keyName] = value;
	}
}
