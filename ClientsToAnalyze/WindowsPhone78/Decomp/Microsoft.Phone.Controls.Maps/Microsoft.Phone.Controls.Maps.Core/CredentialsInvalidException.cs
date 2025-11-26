using System;

namespace Microsoft.Phone.Controls.Maps.Core;

public class CredentialsInvalidException : Exception
{
	public CredentialsInvalidException()
	{
	}

	public CredentialsInvalidException(string message)
		: base(message)
	{
	}

	public CredentialsInvalidException(string message, Exception innerException)
		: base(message, innerException)
	{
	}
}
