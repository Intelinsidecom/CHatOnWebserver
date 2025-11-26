using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class StringToUriConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value == null)
		{
			return null;
		}
		string text = (string)value;
		if (string.IsNullOrEmpty(text))
		{
			return null;
		}
		return new Uri(text);
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
