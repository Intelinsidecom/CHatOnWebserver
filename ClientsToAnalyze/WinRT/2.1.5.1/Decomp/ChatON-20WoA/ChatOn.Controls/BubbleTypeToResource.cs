using System;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Controls;

public class BubbleTypeToResource : IValueConverter
{
	public static Thickness thickness1 = new Thickness(29.0, 16.0, 17.0, 32.0);

	public static Thickness thickness2 = new Thickness(18.0, 28.0, 10.0, 10.0);

	public static Thickness thickness3 = new Thickness(16.0, 29.0, 28.0, 18.0);

	public static Thickness thickness4 = new Thickness(10.0, 29.0, 20.0, 11.0);

	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value == null)
		{
			return null;
		}
		BubbleType bubbleType = (BubbleType)value;
		switch (parameter as string)
		{
		case "NineGrid":
		{
			if (bubbleType == BubbleType.Buddy || bubbleType == BubbleType.Settings)
			{
				int bubbleType2 = SettingService.GetBubbleType();
				if (bubbleType2 == 4)
				{
					return thickness1;
				}
				return thickness2;
			}
			int myBubbleType = SettingService.GetMyBubbleType();
			if (myBubbleType == 4)
			{
				return thickness3;
			}
			return thickness4;
		}
		case "Align":
			return bubbleType switch
			{
				BubbleType.Buddy => (object)(HorizontalAlignment)0, 
				BubbleType.Settings => (object)(HorizontalAlignment)1, 
				_ => (object)(HorizontalAlignment)2, 
			};
		case "Col":
			if (bubbleType == BubbleType.Buddy || bubbleType == BubbleType.Settings)
			{
				return 2;
			}
			return 0;
		default:
			return null;
		}
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
