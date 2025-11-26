using System;

namespace Microsoft.Phone.Controls.Maps.Overlays;

public class MapCommandEventArgs : EventArgs
{
	public MapCommandBase Command { get; private set; }

	public MapCommandEventArgs(MapCommandBase command)
	{
		Command = command;
	}
}
