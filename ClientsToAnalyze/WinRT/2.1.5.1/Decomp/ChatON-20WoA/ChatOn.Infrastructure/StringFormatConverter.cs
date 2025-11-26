using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class StringFormatConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		string format = parameter as string;
		return string.Format(format, new object[1] { value });
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
