using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class LowerCaseConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value == null)
		{
			return null;
		}
		return ((string)value).ToLower();
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
