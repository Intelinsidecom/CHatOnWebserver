using System.Windows;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls;

public class DragCompletedGestureEventArgs : GestureEventArgs
{
	public double HorizontalChange { get; private set; }

	public double VerticalChange { get; private set; }

	public Orientation Direction { get; private set; }

	public double HorizontalVelocity { get; private set; }

	public double VerticalVelocity { get; private set; }

	internal DragCompletedGestureEventArgs(Point gestureOrigin, Point currentPosition, Point change, Orientation direction, Point finalVelocity)
		: base(gestureOrigin, currentPosition)
	{
		HorizontalChange = change.X;
		VerticalChange = change.Y;
		Direction = direction;
		HorizontalVelocity = finalVelocity.X;
		VerticalVelocity = finalVelocity.Y;
	}
}
