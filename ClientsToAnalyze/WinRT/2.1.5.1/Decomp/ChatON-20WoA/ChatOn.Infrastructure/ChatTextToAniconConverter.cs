using System;
using System.Linq;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class ChatTextToAniconConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		string text = value as string;
		if (string.IsNullOrEmpty(text))
		{
			return null;
		}
		if (!text.Contains("/download/anicon"))
		{
			return null;
		}
		string[] array = Utility.Split(text, '\n');
		array = Utility.Split(array[2], '/');
		return array.Last();
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
