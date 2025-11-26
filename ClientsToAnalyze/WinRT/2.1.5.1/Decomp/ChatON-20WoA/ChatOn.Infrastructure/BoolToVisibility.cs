using System;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class BoolToVisibility : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		bool flag = true;
		string text = parameter as string;
		if (!string.IsNullOrEmpty(text) && text == "!")
		{
			flag = false;
		}
		if ((bool)value == flag)
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
