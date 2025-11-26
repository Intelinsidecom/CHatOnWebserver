using System;
using System.Globalization;

namespace Microsoft.Phone.Controls.Primitives;

public class DateTimeWrapper
{
	public DateTime DateTime { get; private set; }

	public string YearNumber => DateTime.ToString("yyyy", CultureInfo.CurrentCulture);

	public string MonthNumber => DateTime.ToString("MM", CultureInfo.CurrentCulture);

	public string MonthName => DateTime.ToString("MMMM", CultureInfo.CurrentCulture);

	public string DayNumber => DateTime.ToString("dd", CultureInfo.CurrentCulture);

	public string DayName => DateTime.ToString("dddd", CultureInfo.CurrentCulture);

	public string HourNumber => DateTime.ToString(CurrentCultureUsesTwentyFourHourClock() ? "%H" : "%h", CultureInfo.CurrentCulture);

	public string MinuteNumber => DateTime.ToString("mm", CultureInfo.CurrentCulture);

	public string AmPmString => DateTime.ToString("tt", CultureInfo.CurrentCulture);

	public DateTimeWrapper(DateTime dateTime)
	{
		DateTime = dateTime;
	}

	public static bool CurrentCultureUsesTwentyFourHourClock()
	{
		return !CultureInfo.CurrentCulture.DateTimeFormat.LongTimePattern.Contains("t");
	}
}
