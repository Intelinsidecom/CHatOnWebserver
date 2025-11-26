using System;
using ChatOn.Models;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class MessageStateToTimeVisibility : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		Message.State state = (Message.State)value;
		if (state == Message.State.Uploading || state == Message.State.UploadingFailed || state == Message.State.Downloading)
		{
			return (object)(Visibility)1;
		}
		if ((bool)parameter)
		{
			return (object)(Visibility)1;
		}
		return (object)(Visibility)0;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
