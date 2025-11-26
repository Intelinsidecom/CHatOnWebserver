namespace Microsoft.Phone.Controls.Maps.Core;

internal static class BezierHelper
{
	private const double SmoothBy = 0.4;

	public static double GetSmoothedValue(double progress, double beforeFrom, double from, double to, double afterTo)
	{
		if (double.IsNaN(beforeFrom) && double.IsNaN(afterTo))
		{
			return Bezier(progress, from, to);
		}
		if (double.IsNaN(beforeFrom) && !double.IsNaN(afterTo))
		{
			return Bezier(progress, from, from + 0.09999999999999998 * (afterTo - from) - ((from + afterTo) / 2.0 - to), to);
		}
		if (!double.IsNaN(beforeFrom) && double.IsNaN(afterTo))
		{
			return Bezier(progress, from, beforeFrom + 0.9 * (to - beforeFrom) - ((beforeFrom + to) / 2.0 - from), to);
		}
		return Bezier(progress, from, beforeFrom + 0.9 * (to - beforeFrom) - ((beforeFrom + to) / 2.0 - from), from + 0.09999999999999998 * (afterTo - from) - ((from + afterTo) / 2.0 - to), to);
	}

	private static double Bezier(double progress, double p0, double p1, double p2, double p3)
	{
		double num = progress * progress;
		double num2 = num * progress;
		return num2 * (p3 + 3.0 * (p1 - p2) - p0) + 3.0 * num * (p0 - 2.0 * p1 + p2) + 3.0 * progress * (p1 - p0) + p0;
	}

	private static double Bezier(double progress, double p0, double p1, double p2)
	{
		double num = progress * progress;
		return num * (p0 - 2.0 * p1 + p2) + 2.0 * progress * (p1 - p0) + p0;
	}

	private static double Bezier(double progress, double p0, double p1)
	{
		return p0 + progress * (p1 - p0);
	}
}
