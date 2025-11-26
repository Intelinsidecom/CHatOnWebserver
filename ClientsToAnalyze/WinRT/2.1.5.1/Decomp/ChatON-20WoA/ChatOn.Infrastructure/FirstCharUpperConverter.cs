using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class FirstCharUpperConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		return Utility.ToFirstCharUpper((string)value);
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
