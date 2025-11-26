using System;
using System.Globalization;
using System.Text;
using System.Windows.Data;
using Microsoft.Phone.Controls.Properties;

namespace Microsoft.Phone.Controls;

public class FullViewDateTimeConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
	{
		if (!(value is DateTime))
		{
			throw new ArgumentException(Microsoft.Phone.Controls.Properties.Resources.InvalidDateTimeArgument);
		}
		StringBuilder stringBuilder = new StringBuilder(string.Empty);
		DateTime dt = (DateTime)value;
		if (DateTimeFormatHelper.IsCurrentCultureJapanese() || DateTimeFormatHelper.IsCurrentCultureKorean())
		{
			stringBuilder.AppendFormat(CultureInfo.CurrentCulture, "{0} {1} {2}", DateTimeFormatHelper.GetMonthAndDay(dt), DateTimeFormatHelper.GetAbbreviatedDay(dt), DateTimeFormatHelper.GetShortTime(dt));
		}
		else if (DateTimeFormatHelper.IsCurrentCultureTurkish())
		{
			stringBuilder.AppendFormat(CultureInfo.CurrentCulture, "{0}, {1} {2}", DateTimeFormatHelper.GetMonthAndDay(dt), DateTimeFormatHelper.GetAbbreviatedDay(dt), DateTimeFormatHelper.GetShortTime(dt));
		}
		else
		{
			stringBuilder.AppendFormat(CultureInfo.CurrentCulture, "{0} {1}, {2}", DateTimeFormatHelper.GetAbbreviatedDay(dt), DateTimeFormatHelper.GetMonthAndDay(dt), DateTimeFormatHelper.GetShortTime(dt));
		}
		if (DateTimeFormatHelper.IsCurrentUICultureFrench())
		{
			stringBuilder.Replace(",", string.Empty);
		}
		return stringBuilder.ToString();
	}

	public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
	{
		throw new NotImplementedException();
	}
}
