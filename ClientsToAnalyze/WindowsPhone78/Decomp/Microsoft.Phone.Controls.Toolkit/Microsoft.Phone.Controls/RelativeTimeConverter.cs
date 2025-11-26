using System;
using System.Globalization;
using System.Windows.Data;
using Microsoft.Phone.Controls.LocalizedResources;
using Microsoft.Phone.Controls.Properties;

namespace Microsoft.Phone.Controls;

public class RelativeTimeConverter : IValueConverter
{
	private const double Minute = 60.0;

	private const double Hour = 3600.0;

	private const double Day = 86400.0;

	private const double Week = 604800.0;

	private const double Month = 2635200.0;

	private const double Year = 31536000.0;

	private const string DefaultCulture = "en-US";

	private string[] PluralHourStrings;

	private string[] PluralMinuteStrings;

	private string[] PluralSecondStrings;

	private void SetLocalizationCulture(CultureInfo culture)
	{
		if (!culture.Name.Equals("en-US", StringComparison.Ordinal))
		{
			ControlResources.Culture = culture;
		}
		PluralHourStrings = new string[4]
		{
			ControlResources.XHoursAgo_2To4,
			ControlResources.XHoursAgo_EndsIn1Not11,
			ControlResources.XHoursAgo_EndsIn2To4Not12To14,
			ControlResources.XHoursAgo_Other
		};
		PluralMinuteStrings = new string[4]
		{
			ControlResources.XMinutesAgo_2To4,
			ControlResources.XMinutesAgo_EndsIn1Not11,
			ControlResources.XMinutesAgo_EndsIn2To4Not12To14,
			ControlResources.XMinutesAgo_Other
		};
		PluralSecondStrings = new string[4]
		{
			ControlResources.XSecondsAgo_2To4,
			ControlResources.XSecondsAgo_EndsIn1Not11,
			ControlResources.XSecondsAgo_EndsIn2To4Not12To14,
			ControlResources.XSecondsAgo_Other
		};
	}

	private static string GetPluralMonth(int month)
	{
		if (month >= 2 && month <= 4)
		{
			return string.Format(CultureInfo.CurrentUICulture, ControlResources.XMonthsAgo_2To4, month.ToString(ControlResources.Culture));
		}
		if (month >= 5 && month <= 12)
		{
			return string.Format(CultureInfo.CurrentUICulture, ControlResources.XMonthsAgo_5To12, month.ToString(ControlResources.Culture));
		}
		throw new ArgumentException(Microsoft.Phone.Controls.Properties.Resources.InvalidNumberOfMonths);
	}

	private static string GetPluralTimeUnits(int units, string[] resources)
	{
		int num = units % 10;
		int num2 = units % 100;
		if (units <= 1)
		{
			throw new ArgumentException(Microsoft.Phone.Controls.Properties.Resources.InvalidNumberOfTimeUnits);
		}
		if (units >= 2 && units <= 4)
		{
			return string.Format(CultureInfo.CurrentUICulture, resources[0], units.ToString(ControlResources.Culture));
		}
		if (num == 1 && num2 != 11)
		{
			return string.Format(CultureInfo.CurrentUICulture, resources[1], units.ToString(ControlResources.Culture));
		}
		if (num >= 2 && num <= 4 && (num2 < 12 || num2 > 14))
		{
			return string.Format(CultureInfo.CurrentUICulture, resources[2], units.ToString(ControlResources.Culture));
		}
		return string.Format(CultureInfo.CurrentUICulture, resources[3], units.ToString(ControlResources.Culture));
	}

	private static string GetDayOfWeek(DayOfWeek dow)
	{
		return dow switch
		{
			DayOfWeek.Monday => ControlResources.Monday, 
			DayOfWeek.Tuesday => ControlResources.Tuesday, 
			DayOfWeek.Wednesday => ControlResources.Wednesday, 
			DayOfWeek.Thursday => ControlResources.Thursday, 
			DayOfWeek.Friday => ControlResources.Friday, 
			DayOfWeek.Saturday => ControlResources.Saturday, 
			DayOfWeek.Sunday => ControlResources.Sunday, 
			_ => ControlResources.Sunday, 
		};
	}

	private static string GetOnDayOfWeek(DayOfWeek dow)
	{
		if (dow == DayOfWeek.Tuesday)
		{
			return string.Format(CultureInfo.CurrentUICulture, ControlResources.OnDayOfWeek_Tuesday, GetDayOfWeek(dow));
		}
		return string.Format(CultureInfo.CurrentUICulture, ControlResources.OnDayOfWeek_Other, GetDayOfWeek(dow));
	}

	public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
	{
		if (!(value is DateTime dateTime))
		{
			throw new ArgumentException(Microsoft.Phone.Controls.Properties.Resources.InvalidDateTimeArgument);
		}
		DateTime now = DateTime.Now;
		TimeSpan timeSpan = now - dateTime;
		SetLocalizationCulture(culture);
		if (DateTimeFormatHelper.IsFutureDateTime(now, dateTime))
		{
			throw new NotSupportedException(Microsoft.Phone.Controls.Properties.Resources.NonSupportedDateTime);
		}
		if (timeSpan.TotalSeconds > 31536000.0)
		{
			return ControlResources.OverAYearAgo;
		}
		if (timeSpan.TotalSeconds > 3952800.0)
		{
			int month = (int)((timeSpan.TotalSeconds + 1317600.0) / 2635200.0);
			return GetPluralMonth(month);
		}
		if (timeSpan.TotalSeconds >= 2116800.0)
		{
			return ControlResources.AboutAMonthAgo;
		}
		if (timeSpan.TotalSeconds >= 604800.0)
		{
			int num = (int)(timeSpan.TotalSeconds / 604800.0);
			if (num > 1)
			{
				return string.Format(CultureInfo.CurrentUICulture, ControlResources.XWeeksAgo_2To4, num.ToString(ControlResources.Culture));
			}
			return ControlResources.AboutAWeekAgo;
		}
		if (timeSpan.TotalSeconds >= 432000.0)
		{
			return string.Format(CultureInfo.CurrentUICulture, ControlResources.LastDayOfWeek, GetDayOfWeek(dateTime.DayOfWeek));
		}
		if (timeSpan.TotalSeconds >= 86400.0)
		{
			return GetOnDayOfWeek(dateTime.DayOfWeek);
		}
		if (timeSpan.TotalSeconds >= 7200.0)
		{
			int units = (int)(timeSpan.TotalSeconds / 3600.0);
			return GetPluralTimeUnits(units, PluralHourStrings);
		}
		if (timeSpan.TotalSeconds >= 3600.0)
		{
			return ControlResources.AboutAnHourAgo;
		}
		if (timeSpan.TotalSeconds >= 120.0)
		{
			int units2 = (int)(timeSpan.TotalSeconds / 60.0);
			return GetPluralTimeUnits(units2, PluralMinuteStrings);
		}
		if (timeSpan.TotalSeconds >= 60.0)
		{
			return ControlResources.AboutAMinuteAgo;
		}
		int units3 = (((double)(int)timeSpan.TotalSeconds > 1.0) ? ((int)timeSpan.TotalSeconds) : 2);
		return GetPluralTimeUnits(units3, PluralSecondStrings);
	}

	public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
	{
		throw new NotImplementedException();
	}
}
