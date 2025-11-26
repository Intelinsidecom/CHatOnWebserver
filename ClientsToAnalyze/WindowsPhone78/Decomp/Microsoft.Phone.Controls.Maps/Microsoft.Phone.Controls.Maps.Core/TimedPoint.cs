using System;
using System.Windows;

namespace Microsoft.Phone.Controls.Maps.Core;

internal struct TimedPoint
{
	private readonly Point p;

	private readonly DateTime stamp;

	public DateTime Timestamp => stamp;

	public Point Point => p;

	public TimedPoint(Point p, DateTime stamp)
	{
		this.p = p;
		this.stamp = stamp;
	}

	public double AgeInSeconds(DateTime now)
	{
		return now.Subtract(Timestamp).TotalSeconds;
	}
}
