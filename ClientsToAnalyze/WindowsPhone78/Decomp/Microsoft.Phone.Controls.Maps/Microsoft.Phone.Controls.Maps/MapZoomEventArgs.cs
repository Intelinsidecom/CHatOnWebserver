using System.Windows;

namespace Microsoft.Phone.Controls.Maps;

public class MapZoomEventArgs : MapInputEventArgs
{
	public double ZoomDelta { get; internal set; }

	internal MapZoomEventArgs(Point viewportPoint, double zoomDelta)
		: base(viewportPoint)
	{
		ZoomDelta = zoomDelta;
	}
}
