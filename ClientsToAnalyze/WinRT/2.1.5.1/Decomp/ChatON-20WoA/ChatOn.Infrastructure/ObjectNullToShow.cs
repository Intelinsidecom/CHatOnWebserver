using System;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class ObjectNullToShow : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value != null)
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
