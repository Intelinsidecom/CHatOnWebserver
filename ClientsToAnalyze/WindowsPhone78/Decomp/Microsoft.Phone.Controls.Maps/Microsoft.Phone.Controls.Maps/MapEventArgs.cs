using System;

namespace Microsoft.Phone.Controls.Maps;

public class MapEventArgs : EventArgs
{
	public bool Handled { get; set; }

	internal MapEventArgs()
	{
	}
}
