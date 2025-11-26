using System;
using System.Globalization;
using System.Text;
using System.Windows.Data;
using Microsoft.Phone.Controls.Properties;

namespace Microsoft.Phone.Controls;

public class DailyDateTimeConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
	{
		if (!(value is DateTime))
		{
			throw new ArgumentException(Microsoft.Phone.Controls.Properties.Resources.InvalidDateTimeArgument);
		}
		StringBuilder stringBuilder = new StringBuilder(string.Empty);
		DateTime dateTime = (DateTime)value;
		DateTime now = DateTime.Now;
		if (DateTimeFormatHelper.IsFutureDateTime(now, dateTime))
		{
			throw new NotSupportedException(Microsoft.Phone.Controls.Properties.Resources.NonSupportedDateTime);
		}
		if (DateTimeFormatHelper.IsAtLeastOneWeekOld(now, dateTime))
		{
			stringBuilder.Append(DateTimeFormatHelper.GetShortDate(dateTime));
		}
		else
		{
			stringBuilder.AppendFormat(CultureInfo.CurrentCulture, "{0} {1}", DateTimeFormatHelper.GetAbbreviatedDay(dateTime), DateTimeFormatHelper.GetSuperShortTime(dateTime));
		}
		return stringBuilder.ToString();
	}

	public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
	{
		throw new NotImplementedException();
	}
}
