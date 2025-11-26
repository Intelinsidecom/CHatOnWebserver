using System;
using System.Windows;

namespace Microsoft.Phone.Controls;

public static class TransitionService
{
	public static readonly DependencyProperty NavigationInTransitionProperty = DependencyProperty.RegisterAttached("NavigationInTransition", typeof(NavigationInTransition), typeof(TransitionService), null);

	public static readonly DependencyProperty NavigationOutTransitionProperty = DependencyProperty.RegisterAttached("NavigationOutTransition", typeof(NavigationOutTransition), typeof(TransitionService), null);

	public static NavigationInTransition GetNavigationInTransition(UIElement element)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		return (NavigationInTransition)element.GetValue(NavigationInTransitionProperty);
	}

	public static NavigationOutTransition GetNavigationOutTransition(UIElement element)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		return (NavigationOutTransition)element.GetValue(NavigationOutTransitionProperty);
	}

	public static void SetNavigationInTransition(UIElement element, NavigationInTransition value)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		element.SetValue(NavigationInTransitionProperty, value);
	}

	public static void SetNavigationOutTransition(UIElement element, NavigationOutTransition value)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		element.SetValue(NavigationOutTransitionProperty, value);
	}
}
