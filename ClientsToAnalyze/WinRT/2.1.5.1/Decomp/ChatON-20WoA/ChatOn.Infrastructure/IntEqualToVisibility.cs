using System;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class IntEqualToVisibility : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		int num = int.Parse(parameter as string);
		int num2 = (int)value;
		if (num == num2)
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
