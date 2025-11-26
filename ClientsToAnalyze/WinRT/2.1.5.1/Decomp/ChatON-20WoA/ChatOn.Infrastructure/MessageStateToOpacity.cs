using System;
using ChatOn.Models;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class MessageStateToOpacity : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		Message.State state = (Message.State)value;
		if (state == Message.State.Typed || state == Message.State.Uploading)
		{
			return 0.5;
		}
		return 1;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
