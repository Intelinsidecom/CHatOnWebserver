using System;
using ChatON_WoA.InfraStructure;
using ChatOn.Services;
using Windows.UI.Xaml.Data;

namespace ChatOn.Controls;

public class BubbleTypeToImageSource : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value == null)
		{
			return null;
		}
		int num = (int)value;
		ChatBubbleProvider instance = ChatBubbleProvider.Instance;
		if (num == 0 || num == 2)
		{
			SettingService.GetBubbleType();
			return instance.DefaultBuddyImage;
		}
		SettingService.GetMyBubbleType();
		return instance.DefaultMeImage;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
