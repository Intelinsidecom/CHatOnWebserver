using System;
using System.Windows;
using Microsoft.Xna.Framework;

namespace Microsoft.Phone.Controls;

internal static class MathHelpers
{
	public static double GetAngle(double deltaX, double deltaY)
	{
		double num = Math.Atan2(deltaY, deltaX);
		if (num < 0.0)
		{
			num = Math.PI * 2.0 + num;
		}
		return num * 360.0 / (Math.PI * 2.0);
	}

	public static double GetDistance(Point p0, Point p1)
	{
		double num = p0.X - p1.X;
		double num2 = p0.Y - p1.Y;
		return Math.Sqrt(num * num + num2 * num2);
	}

	public static Point ToPoint(this Vector2 v)
	{
		return new Point(v.X, v.Y);
	}
}
