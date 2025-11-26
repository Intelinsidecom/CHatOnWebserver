using System;
using System.Globalization;
using System.Windows;
using System.Windows.Data;

namespace ChatOn.Infrastructure;

public class StringNullOrEmptyToHide : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
	{
		string value2 = value as string;
		string text = parameter as string;
		if (!string.IsNullOrEmpty(text) && text == "!")
		{
			if (!string.IsNullOrEmpty(value2))
			{
				return Visibility.Collapsed;
			}
		}
		else if (string.IsNullOrEmpty(value2))
		{
			return Visibility.Collapsed;
		}
		return Visibility.Visible;
	}

	public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
	{
		throw new NotImplementedException();
	}
}
