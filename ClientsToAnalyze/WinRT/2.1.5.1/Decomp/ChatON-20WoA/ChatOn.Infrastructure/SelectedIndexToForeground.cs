using System;
using Windows.UI;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Media;

namespace ChatOn.Infrastructure;

public class SelectedIndexToForeground : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_001c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0022: Expected O, but got Unknown
		int num = int.Parse(parameter as string);
		int num2 = (int)value;
		if (num == num2)
		{
			return (object)new SolidColorBrush(Colors.White);
		}
		return "Black";
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
