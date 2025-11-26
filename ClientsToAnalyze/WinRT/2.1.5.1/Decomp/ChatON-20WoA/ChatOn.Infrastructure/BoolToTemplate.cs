using System;
using System.Collections.Generic;
using ChatON_WoA.Views;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class BoolToTemplate : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_0030: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Invalid comparison between Unknown and I4
		UIElement content = Window.Current.Content;
		object content2 = ((ContentControl)((content is Frame) ? content : null)).Content;
		Page val = (Page)((content2 is Page) ? content2 : null);
		if (val == null)
		{
			return null;
		}
		string key = parameter as string;
		if ((bool)value)
		{
			if ((int)ApplicationView.Value != 2)
			{
				if (ChatDetailPage.ActiveInstance != null)
				{
					object obj = ((IDictionary<object, object>)((FrameworkElement)ChatDetailPage.ActiveInstance).Resources)[(object)key];
					return (obj is DataTemplate) ? obj : null;
				}
			}
			else if (ChatDetailPage.SnappedActiveInstance != null)
			{
				object obj2 = ((IDictionary<object, object>)((FrameworkElement)ChatDetailPage.SnappedActiveInstance).Resources)[(object)key];
				return (obj2 is DataTemplate) ? obj2 : null;
			}
		}
		return null;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
