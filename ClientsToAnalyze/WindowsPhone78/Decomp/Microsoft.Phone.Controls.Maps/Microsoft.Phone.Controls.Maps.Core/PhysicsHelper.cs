using System;
using System.Windows;
using System.Windows.Media.Animation;

namespace Microsoft.Phone.Controls.Maps.Core;

internal static class PhysicsHelper
{
	internal const float FrictionCoefficient = 500f;

	internal static IEasingFunction GetEasingFunction()
	{
		QuadraticEase quadraticEase = new QuadraticEase();
		quadraticEase.EasingMode = EasingMode.EaseOut;
		return quadraticEase;
	}

	internal static Point GetStopPoint(Point velocity, Point initialPosition)
	{
		double stopTime = GetStopTime(velocity);
		double num = Math.Sqrt(velocity.X * velocity.X + velocity.Y * velocity.Y);
		Point point = new Point(500.0 * velocity.X / num, 500.0 * velocity.Y / num);
		return new Point(initialPosition.X + stopTime * velocity.X - point.X * stopTime * stopTime / 2.0, initialPosition.Y + stopTime * velocity.Y - point.Y * stopTime * stopTime / 2.0);
	}

	internal static double GetStopTime(Point velocity)
	{
		return Math.Sqrt(velocity.X * velocity.X + velocity.Y * velocity.Y) / 500.0;
	}

	internal static int GetAngleFromVelocity(Point velocity)
	{
		double num = 0.0;
		double x = velocity.X;
		double y = velocity.Y;
		num = ((x == 0.0 && y == 0.0) ? 0.0 : ((x == 0.0) ? ((!(y > 0.0)) ? 270.0 : 90.0) : ((y != 0.0) ? RadianToDegree(Math.Atan2(y, x)) : ((!(x > 0.0)) ? 180.0 : 0.0))));
		return (int)num;
	}

	internal static double DegreeToRadian(double angle)
	{
		return Math.PI * angle / 180.0;
	}

	internal static double RadianToDegree(double angle)
	{
		return angle * (180.0 / Math.PI);
	}

	internal static bool ExceedsThreshold(Point delta, long threshold)
	{
		if (!(Math.Abs(delta.X) > (double)threshold))
		{
			return Math.Abs(delta.Y) > (double)threshold;
		}
		return true;
	}

	internal static bool ExceedsThreshold(TimeSpan delta, long threshold)
	{
		return delta > TimeSpan.FromMilliseconds(threshold);
	}

	internal static Point Delta(Point p1, Point p2)
	{
		return new Point(p1.X - p2.X, p1.Y - p2.Y);
	}

	internal static Point Center(Point p1, Point p2)
	{
		return new Point((p1.X + p2.X) / 2.0, (p1.Y + p2.Y) / 2.0);
	}

	internal static double Distance(Point p1, Point p2)
	{
		Point point = Delta(p1, p2);
		return Math.Sqrt(point.X * point.X + point.Y * point.Y);
	}

	internal static Point NextPoint(Point initial, Point velocity, TimeSpan duration)
	{
		return new Point(initial.X + velocity.X * duration.TotalSeconds, initial.Y + velocity.Y * duration.TotalSeconds);
	}
}
