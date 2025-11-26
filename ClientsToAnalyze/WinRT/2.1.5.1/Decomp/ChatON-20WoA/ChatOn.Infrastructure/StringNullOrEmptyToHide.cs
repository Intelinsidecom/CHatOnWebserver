using System;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class StringNullOrEmptyToHide : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		string value2 = value as string;
		string text = parameter as string;
		if (!string.IsNullOrEmpty(text) && text == "!")
		{
			if (!string.IsNullOrEmpty(value2))
			{
				return (object)(Visibility)1;
			}
		}
		else if (string.IsNullOrEmpty(value2))
		{
			return (object)(Visibility)1;
		}
		return (object)(Visibility)0;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
