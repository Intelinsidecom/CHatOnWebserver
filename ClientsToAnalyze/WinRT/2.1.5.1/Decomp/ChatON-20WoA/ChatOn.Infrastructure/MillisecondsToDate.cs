using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class MillisecondsToDate : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value == null)
		{
			return null;
		}
		if ((long)value == 0)
		{
			return null;
		}
		DateTime dateTimeFromMiliseconds = Utility.GetDateTimeFromMiliseconds((long)value);
		string text = parameter as string;
		if (!string.IsNullOrEmpty(text))
		{
			return dateTimeFromMiliseconds.ToString(text);
		}
		return dateTimeFromMiliseconds.ToString();
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
