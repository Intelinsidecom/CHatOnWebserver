using System;

namespace Microsoft.Phone.Controls;

internal class TwelveHourDataSource : DataSource
{
	protected override DateTime? GetRelativeTo(DateTime relativeDate, int delta)
	{
		int num = 12;
		int num2 = (num + relativeDate.Hour + delta) % num;
		num2 += ((num <= relativeDate.Hour) ? num : 0);
		return new DateTime(relativeDate.Year, relativeDate.Month, relativeDate.Day, num2, relativeDate.Minute, 0);
	}
}
