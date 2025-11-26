using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class ResourceStringConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		return Utility.GetResourceString(parameter as string);
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
