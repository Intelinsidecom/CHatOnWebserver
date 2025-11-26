using System;
using System.Collections.Generic;
using ChatON_WoA.Views;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class DefaultMessageMarginConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		if ((int)ApplicationView.Value == 2)
		{
			if (ChatDetailPage.SnappedActiveInstance != null)
			{
				return ((IDictionary<object, object>)((FrameworkElement)ChatDetailPage.SnappedActiveInstance).Resources)[(object)"DefaultSnapMessageGrid"];
			}
		}
		else if (ChatDetailPage.ActiveInstance != null)
		{
			return ((IDictionary<object, object>)((FrameworkElement)ChatDetailPage.ActiveInstance).Resources)[(object)"DefaultMessageGrid"];
		}
		return ((IDictionary<object, object>)((FrameworkElement)ChatDetailPage.ActiveInstance).Resources)[(object)"DefaultMessageGrid"];
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
