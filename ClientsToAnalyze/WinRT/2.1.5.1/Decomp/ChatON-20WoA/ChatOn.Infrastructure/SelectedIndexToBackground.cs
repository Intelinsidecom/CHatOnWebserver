using System;
using Windows.UI;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Media;

namespace ChatOn.Infrastructure;

public class SelectedIndexToBackground : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0033: Expected O, but got Unknown
		int num = int.Parse(parameter as string);
		int num2 = (int)value;
		if (num == num2)
		{
			return (object)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
		}
		return "Transparent";
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
