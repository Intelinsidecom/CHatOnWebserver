using System.Collections.Generic;
using ChatON_WoA.Views;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace ChatON_WoA.Common;

public class SelectBuddyTemplateSelector : DataTemplateSelector
{
	protected override DataTemplate SelectTemplateCore(object item, DependencyObject container)
	{
		//IL_0038: Unknown result type (might be due to invalid IL or missing references)
		//IL_003e: Expected O, but got Unknown
		//IL_001e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0024: Expected O, but got Unknown
		if (item is BuddySummary)
		{
			return (DataTemplate)((IDictionary<object, object>)((FrameworkElement)SelectBuddyPage.ActiveInstance).Resources)[(object)"BuddyListItemTemplate"];
		}
		return (DataTemplate)((IDictionary<object, object>)((FrameworkElement)SelectBuddyPage.ActiveInstance).Resources)[(object)"ZoomedOutIndexItemTemplate"];
	}
}
