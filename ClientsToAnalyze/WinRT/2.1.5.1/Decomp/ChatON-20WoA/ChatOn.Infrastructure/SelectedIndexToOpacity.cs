using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class SelectedIndexToOpacity : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		int num = int.Parse(parameter as string);
		int num2 = (int)value;
		if (num == num2)
		{
			return 1;
		}
		return 0.5;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
