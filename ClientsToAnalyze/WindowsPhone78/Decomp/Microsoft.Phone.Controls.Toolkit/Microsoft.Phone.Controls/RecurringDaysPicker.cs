using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Windows.Controls;
using Microsoft.Phone.Controls.LocalizedResources;

namespace Microsoft.Phone.Controls;

public class RecurringDaysPicker : ListPicker
{
	private const string CommaSpace = ", ";

	private const string EnglishLanguage = "en";

	private string[] DayNames = CultureInfo.CurrentCulture.DateTimeFormat.DayNames;

	private string[] ShortestDayNames = CultureInfo.CurrentCulture.DateTimeFormat.ShortestDayNames;

	public RecurringDaysPicker()
	{
		if (CultureInfo.CurrentCulture.Name.StartsWith("en", StringComparison.OrdinalIgnoreCase))
		{
			ShortestDayNames = new string[7] { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		}
		DayOfWeek firstDayOfWeek = CultureInfo.CurrentCulture.DateTimeFormat.FirstDayOfWeek;
		for (int i = 0; i < DayNames.Count(); i++)
		{
			base.Items.Add(DayNames[(int)(firstDayOfWeek + i) % DayNames.Count()]);
		}
		base.SelectionMode = SelectionMode.Multiple;
		base.SummaryForSelectedItemsDelegate = SummarizeDaysOfWeek;
	}

	protected string SummarizeDaysOfWeek(IList selection)
	{
		string result = ControlResources.RepeatsOnlyOnce;
		if (selection != null)
		{
			List<string> list = new List<string>();
			foreach (object item in selection)
			{
				list.Add((string)item);
			}
			result = DaysOfWeekToString(list);
		}
		return result;
	}

	private string DaysOfWeekToString(List<string> daysList)
	{
		List<string> list = new List<string>();
		foreach (string days in daysList)
		{
			if (!list.Contains(days))
			{
				list.Add(days);
			}
		}
		if (list.Count == 0)
		{
			return ControlResources.RepeatsOnlyOnce;
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append(HandleGroups(list, out var unhandledDays));
		if (stringBuilder.Length > 0)
		{
			stringBuilder.Append(", ");
		}
		DayOfWeek firstDayOfWeek = CultureInfo.CurrentCulture.DateTimeFormat.FirstDayOfWeek;
		for (int i = 0; i < DayNames.Count(); i++)
		{
			int num = (int)(firstDayOfWeek + i) % DayNames.Count();
			string value = DayNames[num];
			if (unhandledDays.Contains(value))
			{
				stringBuilder.Append(ShortestDayNames[num]);
				stringBuilder.Append(", ");
			}
		}
		stringBuilder.Length -= ", ".Length;
		return stringBuilder.ToString();
	}

	private static string HandleGroups(List<string> days, out IEnumerable<string> unhandledDays)
	{
		if (days.Count == 7)
		{
			unhandledDays = new List<string>();
			return ControlResources.RepeatsEveryDay;
		}
		ReadOnlyCollection<string> weekdays = CultureInfo.CurrentCulture.Weekdays();
		ReadOnlyCollection<string> weekends = CultureInfo.CurrentCulture.Weekends();
		if (days.Intersect(weekdays).Count() == weekdays.Count)
		{
			unhandledDays = days.Where((string day) => !weekdays.Contains(day));
			return ControlResources.RepeatsOnWeekdays;
		}
		if (days.Intersect(weekends).Count() == weekends.Count)
		{
			unhandledDays = days.Where((string day) => !weekends.Contains(day));
			return ControlResources.RepeatsOnWeekends;
		}
		unhandledDays = days;
		return string.Empty;
	}
}
