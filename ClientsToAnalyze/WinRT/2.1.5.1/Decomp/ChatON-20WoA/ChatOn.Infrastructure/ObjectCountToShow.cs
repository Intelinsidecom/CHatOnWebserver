using System;
using System.Collections;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class ObjectCountToShow : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value != null && (value as IList).Count > 0)
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
