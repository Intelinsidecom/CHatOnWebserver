using System;
using System.Windows;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls;

public class FlickGestureEventArgs : GestureEventArgs
{
	private Point _velocity;

	public double HorizontalVelocity => _velocity.X;

	public double VerticalVelocity => _velocity.Y;

	public double Angle => MathHelpers.GetAngle(_velocity.X, _velocity.Y);

	public Orientation Direction
	{
		get
		{
			if (!(Math.Abs(_velocity.X) >= Math.Abs(_velocity.Y)))
			{
				return Orientation.Vertical;
			}
			return Orientation.Horizontal;
		}
	}

	internal FlickGestureEventArgs(Point hostOrigin, Point velocity)
		: base(hostOrigin, hostOrigin)
	{
		_velocity = velocity;
	}
}
