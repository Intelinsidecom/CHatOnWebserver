using System.Windows;

namespace Microsoft.Phone.Controls;

public class PinchStartedGestureEventArgs : MultiTouchGestureEventArgs
{
	public double Distance => MathHelpers.GetDistance(base.TouchPosition, base.TouchPosition2);

	public double Angle => MathHelpers.GetAngle(base.TouchPosition2.X - base.TouchPosition.X, base.TouchPosition2.Y - base.TouchPosition.Y);

	internal PinchStartedGestureEventArgs(Point gestureOrigin, Point gestureOrigin2, Point pinch, Point pinch2)
		: base(gestureOrigin, gestureOrigin2, pinch, pinch2)
	{
	}
}
