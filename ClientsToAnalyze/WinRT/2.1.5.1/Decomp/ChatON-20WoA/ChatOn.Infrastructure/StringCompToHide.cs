using System;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class StringCompToHide : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_0018: Unknown result type (might be due to invalid IL or missing references)
		//IL_0044: Unknown result type (might be due to invalid IL or missing references)
		//IL_0033: Unknown result type (might be due to invalid IL or missing references)
		string input = parameter as string;
		string text = value as string;
		string[] array = Utility.Split(input);
		Visibility val = (Visibility)0;
		string[] array2 = array;
		foreach (string text2 in array2)
		{
			if (text2 == text)
			{
				val = (Visibility)1;
				break;
			}
		}
		return val;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
