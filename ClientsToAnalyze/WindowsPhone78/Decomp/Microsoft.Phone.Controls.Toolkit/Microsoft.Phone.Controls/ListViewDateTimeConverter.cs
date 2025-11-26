using System;
using System.Globalization;
using System.Windows.Data;
using Microsoft.Phone.Controls.Properties;

namespace Microsoft.Phone.Controls;

public class ListViewDateTimeConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
	{
		if (!(value is DateTime dateTime))
		{
			throw new ArgumentException(Microsoft.Phone.Controls.Properties.Resources.InvalidDateTimeArgument);
		}
		DateTime now = DateTime.Now;
		if (DateTimeFormatHelper.IsFutureDateTime(now, dateTime))
		{
			throw new NotSupportedException(Microsoft.Phone.Controls.Properties.Resources.NonSupportedDateTime);
		}
		if (DateTimeFormatHelper.IsAnOlderWeek(now, dateTime))
		{
			return DateTimeFormatHelper.GetMonthAndDay(dateTime);
		}
		if (DateTimeFormatHelper.IsPastDayOfWeek(now, dateTime))
		{
			return DateTimeFormatHelper.GetAbbreviatedDay(dateTime);
		}
		return DateTimeFormatHelper.GetSuperShortTime(dateTime);
	}

	public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
	{
		throw new NotImplementedException();
	}
}
