using System;
using System.Text;

namespace ChatOn.Infrastructure;

public static class Logger
{
	public static bool WriteToFile;

	public static async void Log(string message, LogType severity = LogType.Unknown)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append(DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss:ffff "));
		stringBuilder.Append("[" + severity.ToString() + "]");
		stringBuilder.Append(message);
	}
}
