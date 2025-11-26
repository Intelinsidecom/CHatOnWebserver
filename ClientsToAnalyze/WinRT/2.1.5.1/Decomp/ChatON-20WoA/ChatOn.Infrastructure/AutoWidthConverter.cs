using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class AutoWidthConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		int num = int.Parse(value.ToString());
		if (num > 99)
		{
			return int.Parse(parameter as string) + (num.ToString().Length - 2) * 7;
		}
		return parameter;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
