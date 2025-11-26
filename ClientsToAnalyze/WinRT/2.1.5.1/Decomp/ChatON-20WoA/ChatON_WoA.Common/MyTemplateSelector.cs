using System.Collections.Generic;
using ChatON_WoA.Views;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace ChatON_WoA.Common;

public class MyTemplateSelector : DataTemplateSelector
{
	protected override DataTemplate SelectTemplateCore(object item, DependencyObject container)
	{
		//IL_007a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0080: Expected O, but got Unknown
		//IL_0060: Unknown result type (might be due to invalid IL or missing references)
		//IL_0066: Expected O, but got Unknown
		//IL_003f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0045: Expected O, but got Unknown
		//IL_0025: Unknown result type (might be due to invalid IL or missing references)
		//IL_002b: Expected O, but got Unknown
		if (item is BuddySummary)
		{
			if (BuddyListPage.ActiveInstance == null)
			{
				return (DataTemplate)((IDictionary<object, object>)((FrameworkElement)SelectBuddyPage.ActiveInstance).Resources)[(object)"BuddyListItemTemplate"];
			}
			return (DataTemplate)((IDictionary<object, object>)((FrameworkElement)BuddyListPage.ActiveInstance).Resources)[(object)"BuddyListItemTemplate"];
		}
		if (BuddyListPage.ActiveInstance == null)
		{
			return (DataTemplate)((IDictionary<object, object>)((FrameworkElement)SelectBuddyPage.ActiveInstance).Resources)[(object)"ZoomedOutIndexItemTemplate"];
		}
		return (DataTemplate)((IDictionary<object, object>)((FrameworkElement)BuddyListPage.ActiveInstance).Resources)[(object)"ZoomedOutIndexItemTemplate"];
	}
}
