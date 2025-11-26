using System;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class ReverseVisibility : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		if ((int)(Visibility)value == 0)
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
