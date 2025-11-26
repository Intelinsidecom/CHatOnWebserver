using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace Microsoft.Phone.Controls;

internal static class ItemsControlExtensions
{
	public static T GetParentItemsControl<T>(DependencyObject element) where T : ItemsControl
	{
		DependencyObject parent = VisualTreeHelper.GetParent(element);
		while (!(parent is T) && parent != null)
		{
			parent = VisualTreeHelper.GetParent(parent);
		}
		return (T)parent;
	}

	public static IList<WeakReference> GetItemsInViewPort(ItemsControl list)
	{
		IList<WeakReference> list2 = new List<WeakReference>();
		ScrollViewer scrollViewer = VisualTreeHelper.GetChild(list, 0) as ScrollViewer;
		list.UpdateLayout();
		if (scrollViewer == null)
		{
			return list2;
		}
		int i;
		Rect rect;
		for (i = 0; i < list.Items.Count; i++)
		{
			FrameworkElement frameworkElement = (FrameworkElement)list.ItemContainerGenerator.ContainerFromIndex(i);
			if (frameworkElement != null)
			{
				GeneralTransform generalTransform = null;
				try
				{
					generalTransform = frameworkElement.TransformToVisual(scrollViewer);
				}
				catch (ArgumentException)
				{
					return list2;
				}
				rect = new Rect(generalTransform.Transform(default(Point)), generalTransform.Transform(new Point(frameworkElement.ActualWidth, frameworkElement.ActualHeight)));
				if (rect.Bottom > 0.0)
				{
					list2.Add(new WeakReference(frameworkElement));
					i++;
					break;
				}
			}
		}
		for (; i < list.Items.Count; i++)
		{
			FrameworkElement frameworkElement = (FrameworkElement)list.ItemContainerGenerator.ContainerFromIndex(i);
			GeneralTransform generalTransform = null;
			try
			{
				generalTransform = frameworkElement.TransformToVisual(scrollViewer);
			}
			catch (ArgumentException)
			{
				return list2;
			}
			rect = new Rect(generalTransform.Transform(default(Point)), generalTransform.Transform(new Point(frameworkElement.ActualWidth, frameworkElement.ActualHeight)));
			if (!(rect.Top < scrollViewer.ActualHeight))
			{
				break;
			}
			list2.Add(new WeakReference(frameworkElement));
		}
		return list2;
	}
}
