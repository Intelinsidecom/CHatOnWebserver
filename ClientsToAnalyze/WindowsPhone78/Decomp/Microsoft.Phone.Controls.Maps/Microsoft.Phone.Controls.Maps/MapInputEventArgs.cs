using System;
using System.Windows;

namespace Microsoft.Phone.Controls.Maps;

public class MapInputEventArgs : EventArgs
{
	public bool Handled { get; set; }

	public Point ViewportPoint { get; internal set; }

	internal MapInputEventArgs(Point viewportPoint)
	{
		ViewportPoint = viewportPoint;
	}
}
