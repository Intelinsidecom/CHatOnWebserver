using System;
using System.Globalization;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class TextInfoToFlowDirection : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Unknown result type (might be due to invalid IL or missing references)
		//IL_0035: Unknown result type (might be due to invalid IL or missing references)
		FlowDirection val = (FlowDirection)0;
		TextInfo textInfo = CultureInfo.CurrentUICulture.TextInfo;
		if (textInfo != null && (textInfo.CultureName.StartsWith("ar") || textInfo.CultureName.StartsWith("he")))
		{
			val = (FlowDirection)1;
		}
		return val;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
