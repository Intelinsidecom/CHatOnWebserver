using System;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class SnapInputBoxMarginConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		if ((int)ApplicationView.Value == 2)
		{
			return new Thickness(-10.0, 1.0, 0.0, -3.0);
		}
		return new Thickness(10.0, 1.0, 10.0, -3.0);
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
