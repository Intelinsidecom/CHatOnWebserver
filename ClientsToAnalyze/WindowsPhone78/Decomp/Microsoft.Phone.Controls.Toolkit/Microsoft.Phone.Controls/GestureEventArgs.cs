using System;
using System.Windows;
using System.Windows.Media;

namespace Microsoft.Phone.Controls;

public class GestureEventArgs : EventArgs
{
	protected Point GestureOrigin { get; private set; }

	protected Point TouchPosition { get; private set; }

	public object OriginalSource { get; internal set; }

	public bool Handled { get; set; }

	internal GestureEventArgs(Point gestureOrigin, Point position)
	{
		GestureOrigin = gestureOrigin;
		TouchPosition = position;
	}

	public Point GetPosition(UIElement relativeTo)
	{
		return GetPosition(relativeTo, TouchPosition);
	}

	protected static Point GetPosition(UIElement relativeTo, Point point)
	{
		if (relativeTo == null)
		{
			relativeTo = Application.Current.RootVisual;
		}
		if (relativeTo != null)
		{
			GeneralTransform inverse = relativeTo.TransformToVisual(null).Inverse;
			return inverse.Transform(point);
		}
		return point;
	}
}
