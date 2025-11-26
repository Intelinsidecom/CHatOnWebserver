using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class AniconButtonTextConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if ((bool)value)
		{
			return Utility.GetResourceString("IDS_CHATON_BODY_DOWNLOAD");
		}
		return Utility.GetResourceString("IDS_CHATON_BUTTON_UNINSTALL_ABB");
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
