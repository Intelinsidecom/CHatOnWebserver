using System;
using ChatOn.Models;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class MessageStateToVisibility : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		string text = parameter as string;
		if (!(value is Message message))
		{
			return (object)(Visibility)1;
		}
		if (text == "buddy" && message.ActivityState == Message.State.Received)
		{
			return (object)(Visibility)0;
		}
		if (text == "me" && message.ActivityState != Message.State.Received)
		{
			return (object)(Visibility)0;
		}
		if (text == "image" && message.Type == "media")
		{
			string[] array = Utility.Split(message.Text, '\n');
			if (array[0] == "image")
			{
				return (object)(Visibility)0;
			}
		}
		else
		{
			if (text == "media" && message.Type == "media")
			{
				return (object)(Visibility)0;
			}
			if (text == "text" && message.Type == "text")
			{
				return (object)(Visibility)0;
			}
		}
		return (object)(Visibility)1;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
