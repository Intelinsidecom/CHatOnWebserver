using System;
using System.Windows;

namespace Microsoft.Phone.Controls;

public class MultiTouchGestureEventArgs : GestureEventArgs
{
	protected Point GestureOrigin2 { get; private set; }

	protected Point TouchPosition2 { get; private set; }

	internal MultiTouchGestureEventArgs(Point gestureOrigin, Point gestureOrigin2, Point position, Point position2)
		: base(gestureOrigin, position)
	{
		GestureOrigin2 = gestureOrigin2;
		TouchPosition2 = position2;
	}

	public Point GetPosition(UIElement relativeTo, int index)
	{
		return index switch
		{
			0 => GetPosition(relativeTo), 
			1 => GestureEventArgs.GetPosition(relativeTo, TouchPosition2), 
			_ => throw new ArgumentOutOfRangeException("index"), 
		};
	}
}
