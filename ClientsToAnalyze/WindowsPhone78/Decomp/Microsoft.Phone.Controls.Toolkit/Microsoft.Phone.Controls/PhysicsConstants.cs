using System;
using System.Windows;
using System.Windows.Media.Animation;

namespace Microsoft.Phone.Controls;

internal static class PhysicsConstants
{
	internal static double GetStopTime(Point initialVelocity)
	{
		double num = Math.Min(Math.Sqrt(initialVelocity.X * initialVelocity.X + initialVelocity.Y * initialVelocity.Y), MotionParameters.MaximumSpeed);
		if (MotionParameters.ParkingSpeed >= num)
		{
			return 0.0;
		}
		return Math.Log(MotionParameters.ParkingSpeed / num) / Math.Log(MotionParameters.Friction);
	}

	internal static Point GetStopPoint(Point initialVelocity)
	{
		double num = Math.Sqrt(initialVelocity.X * initialVelocity.X + initialVelocity.Y * initialVelocity.Y);
		Point initialVelocity2 = initialVelocity;
		if (num > MotionParameters.MaximumSpeed && num > 0.0)
		{
			initialVelocity2.X *= MotionParameters.MaximumSpeed / num;
			initialVelocity2.Y *= MotionParameters.MaximumSpeed / num;
		}
		double num2 = (Math.Pow(MotionParameters.Friction, GetStopTime(initialVelocity2)) - 1.0) / Math.Log(MotionParameters.Friction);
		return new Point(initialVelocity2.X * num2, initialVelocity2.Y * num2);
	}

	internal static IEasingFunction GetEasingFunction(double stopTime)
	{
		ExponentialEase exponentialEase = new ExponentialEase();
		exponentialEase.Exponent = stopTime * Math.Log(MotionParameters.Friction);
		exponentialEase.EasingMode = EasingMode.EaseIn;
		return exponentialEase;
	}
}
