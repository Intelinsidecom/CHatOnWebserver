using System.IO.IsolatedStorage;

namespace MemoryDiagnostic;

public static class SettingsHelper
{
	private static IsolatedStorageSettings isolatedSettings = IsolatedStorageSettings.ApplicationSettings;

	public static bool IsExistKey(string keyName)
	{
		return isolatedSettings.Contains(keyName);
	}

	public static bool RemovetKey(string keyName)
	{
		return isolatedSettings.Remove(keyName);
	}

	public static T Get<T>(string keyName, T defaultValue)
	{
		try
		{
			if (isolatedSettings.Contains(keyName))
			{
				return (T)isolatedSettings[keyName];
			}
		}
		catch
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
