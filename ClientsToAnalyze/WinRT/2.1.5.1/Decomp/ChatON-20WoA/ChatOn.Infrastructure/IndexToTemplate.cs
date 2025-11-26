using System;
using System.Collections.Generic;
using System.Linq;
using ChatON_WoA.Views;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class IndexToTemplate : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		//IL_0092: Unknown result type (might be due to invalid IL or missing references)
		//IL_0098: Invalid comparison between Unknown and I4
		Page val = null;
		try
		{
			UIElement content = Window.Current.Content;
			object content2 = ((ContentControl)((content is Frame) ? content : null)).Content;
			val = (Page)((content2 is Page) ? content2 : null);
		}
		catch (Exception)
		{
			return null;
		}
		string text = parameter as string;
		string[] array = text.Split(',');
		int num = (int)value;
		if (val == null || array.Length == 0)
		{
			return null;
		}
		if (array.Last() == "PivotPage")
		{
			object obj = ((IDictionary<object, object>)((FrameworkElement)BuddyListPage.ActiveInstance).Resources)[(object)array[num]];
			return (obj is DataTemplate) ? obj : null;
		}
		if (array.Last() == "ChatDetailPage")
		{
			if ((int)ApplicationView.Value != 2)
			{
				if (ChatDetailPage.ActiveInstance != null)
				{
					object obj2 = ((IDictionary<object, object>)((FrameworkElement)ChatDetailPage.ActiveInstance).Resources)[(object)array[num]];
					return (obj2 is DataTemplate) ? obj2 : null;
				}
			}
			else if (ChatDetailPage.SnappedActiveInstance != null)
			{
				object obj3 = ((IDictionary<object, object>)((FrameworkElement)ChatDetailPage.SnappedActiveInstance).Resources)[(object)array[num]];
				return (obj3 is DataTemplate) ? obj3 : null;
			}
		}
		else if (array.Last() == "SelectBuddyPage")
		{
			object obj4 = ((IDictionary<object, object>)((FrameworkElement)SelectBuddyPage.ActiveInstance).Resources)[(object)array[num]];
			return (obj4 is DataTemplate) ? obj4 : null;
		}
		object obj5 = ((IDictionary<object, object>)((FrameworkElement)val).Resources)[(object)array[num]];
		return (obj5 is DataTemplate) ? obj5 : null;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
