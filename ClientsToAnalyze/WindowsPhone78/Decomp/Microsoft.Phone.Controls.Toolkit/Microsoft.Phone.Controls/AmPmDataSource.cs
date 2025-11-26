using System;

namespace Microsoft.Phone.Controls;

internal class AmPmDataSource : DataSource
{
	protected override DateTime? GetRelativeTo(DateTime relativeDate, int delta)
	{
		int num = 24;
		int num2 = relativeDate.Hour + delta * (num / 2);
		if (num2 < 0 || num <= num2)
		{
			return null;
		}
		return new DateTime(relativeDate.Year, relativeDate.Month, relativeDate.Day, num2, relativeDate.Minute, 0);
	}
}
