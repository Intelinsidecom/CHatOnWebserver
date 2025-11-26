using System;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Infrastructure;

public class IsFavoriteToIconUri : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_0024: Unknown result type (might be due to invalid IL or missing references)
		//IL_002a: Expected O, but got Unknown
		//IL_0014: Unknown result type (might be due to invalid IL or missing references)
		//IL_001a: Expected O, but got Unknown
		if ((bool)value)
		{
			return (object)new BitmapImage(new Uri("ms-appx:///Images/star.png"));
		}
		return (object)new BitmapImage(new Uri("ms-appx:///Images/button_favorite_press.png"));
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
