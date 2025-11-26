using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class GroupNameConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		string text = (string)value;
		if (text.Length > 15)
		{
			return text.Substring(0, 15) + "....";
		}
		return text;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
