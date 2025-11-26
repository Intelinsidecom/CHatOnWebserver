using System;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class WidthToGridColConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_001d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0023: Invalid comparison between Unknown and I4
		if (value == null)
		{
			return 2;
		}
		double num = (double)value;
		if (num < 300.0 && (int)ApplicationView.Value == 2)
		{
			return 1;
		}
		return 2;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
