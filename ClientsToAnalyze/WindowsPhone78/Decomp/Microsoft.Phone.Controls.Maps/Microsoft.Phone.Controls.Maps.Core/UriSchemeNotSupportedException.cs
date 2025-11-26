using System;

namespace Microsoft.Phone.Controls.Maps.Core;

public class UriSchemeNotSupportedException : Exception
{
	public UriSchemeNotSupportedException()
	{
	}

	public UriSchemeNotSupportedException(string message)
		: base(message)
	{
	}

	public UriSchemeNotSupportedException(string message, Exception innerException)
		: base(message, innerException)
	{
	}
}
