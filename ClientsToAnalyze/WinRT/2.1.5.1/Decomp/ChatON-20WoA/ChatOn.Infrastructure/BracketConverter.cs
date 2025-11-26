using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class BracketConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		return "(" + value.ToString() + ")";
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
