using System.Windows;

namespace Microsoft.Phone.Controls.Maps;

public class MapFlickEventArgs : MapInputEventArgs
{
	public Point Velocity { get; internal set; }

	internal MapFlickEventArgs(Point viewportPoint, Point velocity)
		: base(viewportPoint)
	{
		Velocity = velocity;
	}
}
