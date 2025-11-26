using System;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Media;

namespace ChatOn.Infrastructure;

public class StretchConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		int num = int.Parse(value.ToString());
		if (num > 99)
		{
			return (object)(Stretch)1;
		}
		return (object)(Stretch)0;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
