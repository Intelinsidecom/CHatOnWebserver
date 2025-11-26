using System.Windows;

namespace Microsoft.Phone.Controls.Maps;

public class MapDragEventArgs : MapInputEventArgs
{
	public Point DragDelta { get; internal set; }

	internal MapDragEventArgs(Point viewportPoint, Point delta)
		: base(viewportPoint)
	{
		DragDelta = delta;
	}
}
