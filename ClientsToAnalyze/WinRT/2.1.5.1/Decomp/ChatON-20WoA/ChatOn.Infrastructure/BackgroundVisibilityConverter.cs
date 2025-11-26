using System;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Media;

namespace ChatOn.Infrastructure;

public class BackgroundVisibilityConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected O, but got Unknown
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		SolidColorBrush val = (SolidColorBrush)value;
		if (val == null)
		{
			return (object)(Visibility)1;
		}
		if (val.Color != new SolidColorBrush(Color.FromArgb(0, byte.MaxValue, byte.MaxValue, byte.MaxValue)).Color)
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
