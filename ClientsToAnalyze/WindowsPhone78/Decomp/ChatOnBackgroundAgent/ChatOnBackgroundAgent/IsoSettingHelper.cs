using System;
using System.Collections.Generic;
using System.IO.IsolatedStorage;

namespace ChatOnBackgroundAgent;

public static class IsoSettingHelper
{
	private static IsolatedStorageSettings isolatedSettings = IsolatedStorageSettings.ApplicationSettings;

	public static T Get<T>(string keyName, T defaultValue)
	{
		try
		{
			if (isolatedSettings.Contains(keyName))
			{
				return (T)isolatedSettings[keyName];
			}
		}
		catch (ArgumentNullException)
		{
		}
		catch (KeyNotFoundException)
		{
			isolatedSettings.Remove(keyName);
		}
		return defaultValue;
	}

	public static void Set(string keyName, object value)
	{
		if (isolatedSettings.Contains(keyName))
		{
			if (isolatedSettings[keyName] != value)
			{
				isolatedSettings[keyName] = value;
				isolatedSettings.Save();
			}
		}
		else
		{
			isolatedSettings.Add(keyName, value);
			isolatedSettings.Save();
		}
	}
}
