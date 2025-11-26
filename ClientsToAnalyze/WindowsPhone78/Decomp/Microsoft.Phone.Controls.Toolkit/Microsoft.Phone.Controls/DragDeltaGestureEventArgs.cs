using System.Windows;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls;

public class DragDeltaGestureEventArgs : GestureEventArgs
{
	public double HorizontalChange { get; private set; }

	public double VerticalChange { get; private set; }

	public Orientation Direction { get; private set; }

	internal DragDeltaGestureEventArgs(Point gestureOrigin, Point currentPosition, Point change, Orientation direction)
		: base(gestureOrigin, currentPosition)
	{
		HorizontalChange = change.X;
		VerticalChange = change.Y;
		Direction = direction;
	}
}
