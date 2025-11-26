using System;
using ChatOn.Models;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class MessageStateToSubTextVisibility : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		Message.State state = (Message.State)value;
		if (state == Message.State.Sent || state == Message.State.GotAnswerBack || state == Message.State.Received)
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
