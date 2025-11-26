using System;
using System.Globalization;
using System.Text;
using System.Text.RegularExpressions;

namespace Microsoft.Phone.Controls;

internal static class DateTimeFormatHelper
{
	private const double Hour = 60.0;

	private const double Day = 1440.0;

	private const string SingleMeridiemDesignator = "t";

	private const string DoubleMeridiemDesignator = "tt";

	private static DateTimeFormatInfo formatInfo_GetSuperShortTime = null;

	private static DateTimeFormatInfo formatInfo_GetMonthAndDay = null;

	private static DateTimeFormatInfo formatInfo_GetShortTime = null;

	private static object lock_GetSuperShortTime = new object();

	private static object lock_GetMonthAndDay = new object();

	private static object lock_GetShortTime = new object();

	private static readonly Regex rxMonthAndDay = new Regex("(d{1,2}[^A-Za-z]M{1,3})|(M{1,3}[^A-Za-z]d{1,2})");

	private static readonly Regex rxSeconds = new Regex("([^A-Za-z]s{1,2})");

	public static int GetRelativeDayOfWeek(DateTime dt)
	{
		return (dt.DayOfWeek - CultureInfo.CurrentCulture.DateTimeFormat.FirstDayOfWeek + 7) % 7;
	}

	public static bool IsFutureDateTime(DateTime relative, DateTime given)
	{
		return relative < given;
	}

	public static bool IsAnOlderYear(DateTime relative, DateTime given)
	{
		return relative.Year > given.Year;
	}

	public static bool IsAnOlderWeek(DateTime relative, DateTime given)
	{
		if (IsAtLeastOneWeekOld(relative, given))
		{
			return true;
		}
		return GetRelativeDayOfWeek(given) > GetRelativeDayOfWeek(relative);
	}

	public static bool IsAtLeastOneWeekOld(DateTime relative, DateTime given)
	{
		return (double)(int)(relative - given).TotalMinutes >= 10080.0;
	}

	public static bool IsPastDayOfWeek(DateTime relative, DateTime given)
	{
		return GetRelativeDayOfWeek(relative) > GetRelativeDayOfWeek(given);
	}

	public static bool IsPastDayOfWeekWithWindow(DateTime relative, DateTime given)
	{
		if (IsPastDayOfWeek(relative, given))
		{
			return (double)(int)(relative - given).TotalMinutes > 180.0;
		}
		return false;
	}

	public static bool IsCurrentCultureJapanese()
	{
		return CultureInfo.CurrentCulture.Name.StartsWith("ja", StringComparison.OrdinalIgnoreCase);
	}

	public static bool IsCurrentCultureKorean()
	{
		return CultureInfo.CurrentCulture.Name.StartsWith("ko", StringComparison.OrdinalIgnoreCase);
	}

	public static bool IsCurrentCultureTurkish()
	{
		return CultureInfo.CurrentCulture.Name.StartsWith("tr", StringComparison.OrdinalIgnoreCase);
	}

	public static bool IsCurrentCultureHungarian()
	{
		return CultureInfo.CurrentCulture.Name.StartsWith("hu", StringComparison.OrdinalIgnoreCase);
	}

	public static bool IsCurrentUICultureFrench()
	{
		return CultureInfo.CurrentUICulture.Name.Equals("fr-FR", StringComparison.Ordinal);
	}

	public static string GetAbbreviatedDay(DateTime dt)
	{
		if (IsCurrentCultureJapanese() || IsCurrentCultureKorean())
		{
			return "(" + dt.ToString("ddd", CultureInfo.CurrentCulture) + ")";
		}
		return dt.ToString("ddd", CultureInfo.CurrentCulture);
	}

	public static string GetSuperShortTime(DateTime dt)
	{
		if (formatInfo_GetSuperShortTime == null)
		{
			lock (lock_GetSuperShortTime)
			{
				StringBuilder stringBuilder = new StringBuilder(string.Empty);
				formatInfo_GetSuperShortTime = (DateTimeFormatInfo)CultureInfo.CurrentCulture.DateTimeFormat.Clone();
				stringBuilder.Append(formatInfo_GetSuperShortTime.LongTimePattern);
				string value = rxSeconds.Match(stringBuilder.ToString()).Value;
				stringBuilder.Replace(" ", string.Empty);
				stringBuilder.Replace(value, string.Empty);
				if (!IsCurrentCultureJapanese() && !IsCurrentCultureKorean() && !IsCurrentCultureHungarian())
				{
					stringBuilder.Replace("tt", "t");
				}
				formatInfo_GetSuperShortTime.ShortTimePattern = stringBuilder.ToString();
			}
		}
		return dt.ToString("t", formatInfo_GetSuperShortTime).ToLowerInvariant();
	}

	public static string GetMonthAndDay(DateTime dt)
	{
		if (formatInfo_GetMonthAndDay == null)
		{
			lock (lock_GetMonthAndDay)
			{
				StringBuilder stringBuilder = new StringBuilder(string.Empty);
				formatInfo_GetMonthAndDay = (DateTimeFormatInfo)CultureInfo.CurrentCulture.DateTimeFormat.Clone();
				stringBuilder.Append(rxMonthAndDay.Match(formatInfo_GetMonthAndDay.ShortDatePattern).Value);
				if (stringBuilder.ToString().Contains("."))
				{
					stringBuilder.Append(".");
				}
				formatInfo_GetMonthAndDay.ShortDatePattern = stringBuilder.ToString();
			}
		}
		return dt.ToString("d", formatInfo_GetMonthAndDay);
	}

	public static string GetShortDate(DateTime dt)
	{
		return dt.ToString("d", CultureInfo.CurrentCulture);
	}

	public static string GetShortTime(DateTime dt)
	{
		if (formatInfo_GetShortTime == null)
		{
			lock (lock_GetShortTime)
			{
				StringBuilder stringBuilder = new StringBuilder(string.Empty);
				formatInfo_GetShortTime = (DateTimeFormatInfo)CultureInfo.CurrentCulture.DateTimeFormat.Clone();
				stringBuilder.Append(formatInfo_GetSuperShortTime.LongTimePattern);
				string value = rxSeconds.Match(stringBuilder.ToString()).Value;
				stringBuilder.Replace(value, string.Empty);
				formatInfo_GetShortTime.ShortTimePattern = stringBuilder.ToString();
			}
		}
		return dt.ToString("t", formatInfo_GetShortTime);
	}
}
