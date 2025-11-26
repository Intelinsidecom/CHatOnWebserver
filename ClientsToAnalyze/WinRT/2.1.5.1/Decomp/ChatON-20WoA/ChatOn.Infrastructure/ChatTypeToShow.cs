using System;
using com.sec.ssm.common;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class ChatTypeToShow : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value != null && (ChatType)value == ChatType.BROADCAST && (string)parameter != "!")
		{
			return (object)(Visibility)0;
		}
		if (value != null && (ChatType)value != ChatType.BROADCAST && (string)parameter == "!")
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
