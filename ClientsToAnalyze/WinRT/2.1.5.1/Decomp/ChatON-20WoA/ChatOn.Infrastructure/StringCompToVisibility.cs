using System;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class StringCompToVisibility : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		string text = parameter as string;
		string text2 = value as string;
		if (text == text2)
		{
			return (object)(Visibility)0;
		}
		return (object)(Visibility)1;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
