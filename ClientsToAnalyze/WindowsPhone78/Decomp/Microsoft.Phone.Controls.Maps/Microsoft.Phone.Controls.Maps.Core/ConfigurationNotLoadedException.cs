using System;

namespace Microsoft.Phone.Controls.Maps.Core;

public class ConfigurationNotLoadedException : Exception
{
	public ConfigurationNotLoadedException()
	{
	}

	public ConfigurationNotLoadedException(string message)
		: base(message)
	{
	}

	public ConfigurationNotLoadedException(string message, Exception innerException)
		: base(message, innerException)
	{
	}
}
