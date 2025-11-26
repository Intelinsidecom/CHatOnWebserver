using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class CountToDoubleValue : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value == null)
		{
			return 0;
		}
		double num = double.Parse(parameter as string);
		if ((int)value == 0)
		{
			return 0;
		}
		return num;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
