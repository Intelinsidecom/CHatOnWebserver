using System.Windows;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls;

public class DragStartedGestureEventArgs : GestureEventArgs
{
	public Orientation Direction { get; private set; }

	internal DragStartedGestureEventArgs(Point gestureOrigin, Orientation direction)
		: base(gestureOrigin, gestureOrigin)
	{
		Direction = direction;
	}
}
