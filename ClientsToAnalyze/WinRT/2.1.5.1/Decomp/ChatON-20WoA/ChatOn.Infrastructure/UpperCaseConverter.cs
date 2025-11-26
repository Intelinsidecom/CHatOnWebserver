using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class UpperCaseConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value == null)
		{
			return null;
		}
		return ((string)value).ToUpper();
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
