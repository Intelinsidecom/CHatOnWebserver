using System;
using System.Windows;

namespace Microsoft.Phone.Controls;

public class PinchGestureEventArgs : MultiTouchGestureEventArgs
{
	public double DistanceRatio
	{
		get
		{
			double num = Math.Max(MathHelpers.GetDistance(base.GestureOrigin, base.GestureOrigin2), 1.0);
			double num2 = Math.Max(MathHelpers.GetDistance(base.TouchPosition, base.TouchPosition2), 1.0);
			return num2 / num;
		}
	}

	public double TotalAngleDelta
	{
		get
		{
			double angle = MathHelpers.GetAngle(base.GestureOrigin2.X - base.GestureOrigin.X, base.GestureOrigin2.Y - base.GestureOrigin.Y);
			double angle2 = MathHelpers.GetAngle(base.TouchPosition2.X - base.TouchPosition.X, base.TouchPosition2.Y - base.TouchPosition.Y);
			return angle2 - angle;
		}
	}

	internal PinchGestureEventArgs(Point gestureOrigin, Point gestureOrigin2, Point position, Point position2)
		: base(gestureOrigin, gestureOrigin2, position, position2)
	{
	}
}
