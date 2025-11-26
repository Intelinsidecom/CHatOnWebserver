using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class InternationalPhonenumberConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		string text = value as string;
		if (string.IsNullOrEmpty(text))
		{
			return "";
		}
		if (text[0] != '+')
		{
			text = text.Insert(0, "+");
		}
		return text;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
