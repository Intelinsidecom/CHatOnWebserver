using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class ResourceStringLowerCaseConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		return Utility.GetResourceString(parameter as string).ToLower();
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
