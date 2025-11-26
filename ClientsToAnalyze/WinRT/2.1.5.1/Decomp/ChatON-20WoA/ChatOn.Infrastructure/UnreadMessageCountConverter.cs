using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class UnreadMessageCountConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		int num = int.Parse(value.ToString());
		if (num > 99)
		{
			return 99 + "+";
		}
		return num;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
