using System;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Infrastructure;

public class ChatTodayImageConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_0014: Unknown result type (might be due to invalid IL or missing references)
		//IL_001a: Invalid comparison between Unknown and I4
		//IL_0049: Unknown result type (might be due to invalid IL or missing references)
		//IL_004f: Invalid comparison between Unknown and I4
		//IL_0036: Unknown result type (might be due to invalid IL or missing references)
		//IL_003c: Expected O, but got Unknown
		//IL_0026: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Expected O, but got Unknown
		string text = parameter as string;
		if (text == "image")
		{
			if ((int)ApplicationView.Value != 2)
			{
				return (object)new BitmapImage(new Uri("ms-appx:///Images/chat_today.png"));
			}
			return (object)new BitmapImage(new Uri("ms-appx:///Images/chat_today_small.png"));
		}
		if (text == "ninegrid")
		{
			if ((int)ApplicationView.Value == 2)
			{
				return new Thickness(58.0, 2.0, 58.0, 2.0);
			}
			return new Thickness(180.0, 2.0, 180.0, 2.0);
		}
		return null;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
