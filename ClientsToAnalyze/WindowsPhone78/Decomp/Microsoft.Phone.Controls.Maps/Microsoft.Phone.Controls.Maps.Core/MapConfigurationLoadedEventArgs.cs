using System;

namespace Microsoft.Phone.Controls.Maps.Core;

public class MapConfigurationLoadedEventArgs : EventArgs
{
	public Exception Error { get; private set; }

	public MapConfigurationLoadedEventArgs(Exception error)
	{
		Error = error;
	}
}
