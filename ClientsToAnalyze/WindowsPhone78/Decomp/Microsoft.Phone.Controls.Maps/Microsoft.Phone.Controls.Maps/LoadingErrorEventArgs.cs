using System;

namespace Microsoft.Phone.Controls.Maps;

public class LoadingErrorEventArgs : MapEventArgs
{
	public Exception LoadingException { get; internal set; }

	internal LoadingErrorEventArgs(Exception loadingException)
	{
		LoadingException = loadingException;
	}
}
