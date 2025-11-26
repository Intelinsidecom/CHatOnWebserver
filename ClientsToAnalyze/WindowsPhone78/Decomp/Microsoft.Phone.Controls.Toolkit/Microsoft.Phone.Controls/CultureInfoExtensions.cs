using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Globalization;
using System.Linq;

namespace Microsoft.Phone.Controls;

public static class CultureInfoExtensions
{
	private static string[] CulturesWithTFWeekends = new string[1] { "ar-SA" };

	private static string[] CulturesWithFSWeekends = new string[2] { "he-IL", "ar-EG" };

	public static ReadOnlyCollection<string> Weekdays(this CultureInfo culture)
	{
		DayOfWeek[] array = (CulturesWithTFWeekends.Contains(culture.Name) ? new DayOfWeek[5]
		{
			DayOfWeek.Monday,
			DayOfWeek.Tuesday,
			DayOfWeek.Wednesday,
			DayOfWeek.Saturday,
			DayOfWeek.Sunday
		} : ((!CulturesWithFSWeekends.Contains(culture.Name)) ? new DayOfWeek[5]
		{
			DayOfWeek.Monday,
			DayOfWeek.Tuesday,
			DayOfWeek.Wednesday,
			DayOfWeek.Thursday,
			DayOfWeek.Friday
		} : new DayOfWeek[5]
		{
			DayOfWeek.Monday,
			DayOfWeek.Tuesday,
			DayOfWeek.Wednesday,
			DayOfWeek.Thursday,
			DayOfWeek.Sunday
		}));
		List<string> list = new List<string>();
		DayOfWeek[] array2 = array;
		foreach (DayOfWeek dayofweek in array2)
		{
			list.Add(culture.DateTimeFormat.GetDayName(dayofweek));
		}
		return new ReadOnlyCollection<string>(list);
	}

	public static ReadOnlyCollection<string> Weekends(this CultureInfo culture)
	{
		DayOfWeek[] array2;
		if (CulturesWithTFWeekends.Contains(culture.Name))
		{
			DayOfWeek[] array = new DayOfWeek[2]
			{
				DayOfWeek.Thursday,
				DayOfWeek.Friday
			};
			array2 = array;
		}
		else if (CulturesWithFSWeekends.Contains(culture.Name))
		{
			DayOfWeek[] array3 = new DayOfWeek[2]
			{
				DayOfWeek.Friday,
				DayOfWeek.Saturday
			};
			array2 = array3;
		}
		else
		{
			DayOfWeek[] array4 = new DayOfWeek[2]
			{
				DayOfWeek.Saturday,
				DayOfWeek.Sunday
			};
			array2 = array4;
		}
		List<string> list = new List<string>();
		DayOfWeek[] array5 = array2;
		foreach (DayOfWeek dayofweek in array5)
		{
			list.Add(culture.DateTimeFormat.GetDayName(dayofweek));
		}
		return new ReadOnlyCollection<string>(list);
	}
}
