using System;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatON_WoA.Views;

public class UnreadCountToBubbleimage : IValueConverter
{
	public static BitmapImage orangeTrunkBubble = new BitmapImage(new Uri("ms-appx:///Images/trunk_bubble_orange.png"));

	public static BitmapImage grayTrunkBubble = new BitmapImage(new Uri("ms-appx:///Images/trunk_bubble_gray.png"));

	public object Convert(object value, Type targetType, object parameter, string language)
	{
		int num = (int)value;
		if (num > 0)
		{
			return orangeTrunkBubble;
		}
		return grayTrunkBubble;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
