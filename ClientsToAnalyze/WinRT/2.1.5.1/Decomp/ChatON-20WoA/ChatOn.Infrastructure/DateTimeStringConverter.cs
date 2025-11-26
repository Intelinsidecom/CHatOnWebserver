using System;
using System.Globalization;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class DateTimeStringConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		DateTime dateTime = (DateTime)value;
		string result = "";
		if (parameter is string text)
		{
			result = dateTime.ToString(text, DateTimeFormatInfo.CurrentInfo);
		}
		return result;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
