using System.Collections.Generic;
using System.Linq;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Media;

namespace TestListViewScrolling;

public static class VisualTreeHelperExtensions
{
	public static T GetFirstDescendantOfType<T>(this DependencyObject start) where T : DependencyObject
	{
		return start.GetDescendantsOfType<T>().First();
	}

	public static IEnumerable<T> GetDescendantsOfType<T>(this DependencyObject start) where T : DependencyObject
	{
		Queue<DependencyObject> queue = new Queue<DependencyObject>();
		int count = VisualTreeHelper.GetChildrenCount(start);
		for (int i = 0; i < count; i++)
		{
			DependencyObject child = VisualTreeHelper.GetChild(start, i);
			if (child is T)
			{
				yield return (T)(object)child;
			}
			queue.Enqueue(child);
		}
		while (queue.Count > 0)
		{
			DependencyObject parent = queue.Dequeue();
			int count2 = VisualTreeHelper.GetChildrenCount(parent);
			for (int j = 0; j < count2; j++)
			{
				DependencyObject child2 = VisualTreeHelper.GetChild(parent, j);
				if (child2 is T)
				{
					yield return (T)(object)child2;
				}
				queue.Enqueue(child2);
			}
		}
	}
}
