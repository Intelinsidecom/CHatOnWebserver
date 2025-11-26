using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class IntCompToBool : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		int num = (int)value;
		int num2 = int.Parse(parameter as string);
		return num == num2;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
