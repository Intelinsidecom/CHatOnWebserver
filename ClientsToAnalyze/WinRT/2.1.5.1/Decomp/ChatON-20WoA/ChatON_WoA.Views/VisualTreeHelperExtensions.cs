using System;
using System.Collections.Generic;
using System.Linq;
using Windows.Foundation;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Media;

namespace ChatON_WoA.Views;

public static class VisualTreeHelperExtensions
{
	public static T GetFirstDescendantOfType<T>(this DependencyObject start) where T : DependencyObject
	{
		return start.GetDescendantsOfType<T>().FirstOrDefault();
	}

	public static IEnumerable<T> GetDescendantsOfType<T>(this DependencyObject start) where T : DependencyObject
	{
		return start.GetDescendants().OfType<T>();
	}

	public static IEnumerable<DependencyObject> GetDescendants(this DependencyObject start)
	{
		Queue<DependencyObject> queue = new Queue<DependencyObject>();
		int count = VisualTreeHelper.GetChildrenCount(start);
		for (int i = 0; i < count; i++)
		{
			DependencyObject child = VisualTreeHelper.GetChild(start, i);
			yield return child;
			queue.Enqueue(child);
		}
		while (queue.Count > 0)
		{
			DependencyObject parent = queue.Dequeue();
			int count2 = VisualTreeHelper.GetChildrenCount(parent);
			for (int j = 0; j < count2; j++)
			{
				DependencyObject child2 = VisualTreeHelper.GetChild(parent, j);
				yield return child2;
				queue.Enqueue(child2);
			}
		}
	}

	public static T GetFirstAncestorOfType<T>(this DependencyObject start) where T : DependencyObject
	{
		return start.GetAncestorsOfType<T>().FirstOrDefault();
	}

	public static IEnumerable<T> GetAncestorsOfType<T>(this DependencyObject start) where T : DependencyObject
	{
		return start.GetAncestors().OfType<T>();
	}

	public static IEnumerable<DependencyObject> GetAncestors(this DependencyObject start)
	{
		for (DependencyObject parent = VisualTreeHelper.GetParent(start); parent != null; parent = VisualTreeHelper.GetParent(parent))
		{
			yield return parent;
		}
	}

	public static bool IsInVisualTree(this DependencyObject dob)
	{
		if (Window.Current.Content != null)
		{
			return dob.GetAncestors().Contains((DependencyObject)(object)Window.Current.Content);
		}
		return false;
	}

	public static Rect GetBoundingRect(this FrameworkElement dob, FrameworkElement relativeTo = null)
	{
		if (relativeTo == null)
		{
			UIElement content = Window.Current.Content;
			relativeTo = (FrameworkElement)(object)((content is FrameworkElement) ? content : null);
		}
		if (relativeTo == null)
		{
			throw new InvalidOperationException("Element not in visual tree.");
		}
		if (dob == relativeTo)
		{
			return new Rect(0.0, 0.0, relativeTo.ActualWidth, relativeTo.ActualHeight);
		}
		DependencyObject[] source = ((DependencyObject)(object)dob).GetAncestors().ToArray();
		if (!source.Contains((DependencyObject)(object)relativeTo))
		{
			throw new InvalidOperationException("Element not in visual tree.");
		}
		Point point = ((UIElement)dob).TransformToVisual((UIElement)(object)relativeTo).TransformPoint(default(Point));
		Point point2 = ((UIElement)dob).TransformToVisual((UIElement)(object)relativeTo).TransformPoint(new Point(dob.ActualWidth, dob.ActualHeight));
		return new Rect(point, point2);
	}
}
