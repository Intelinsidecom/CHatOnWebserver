using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class WidthToGridRowConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value == null)
		{
			return 1;
		}
		double num = (double)value;
		if (num < 320.0)
		{
			return 2;
		}
		return 1;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
