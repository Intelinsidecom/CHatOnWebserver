using System.Collections.Generic;
using System.Linq;
using System.Windows.Media;

namespace System.Windows.Controls;

internal static class VisualTreeExtensions
{
	internal static IEnumerable<DependencyObject> GetVisualChildren(this DependencyObject parent)
	{
		try
		{
			int num = default(int);
			bool flag = default(bool);
			int childCount = default(int);
			int counter = default(int);
			switch (num)
			{
			default:
				if (!flag)
				{
					childCount = VisualTreeHelper.GetChildrenCount(parent);
					counter = 0;
					goto IL_008b;
				}
				yield break;
			case 1:
				if (!flag)
				{
					counter++;
					goto IL_008b;
				}
				yield break;
			case -1:
				yield break;
				IL_008b:
				if (counter < childCount)
				{
					VisualTreeHelper.GetChild(parent, counter);
					/*Error near IL_00b1: Unexpected return in MoveNext()*/;
				}
				break;
			}
		}
		catch (Exception)
		{
			throw;
		}
	}

	internal static IEnumerable<FrameworkElement> GetLogicalChildrenBreadthFirst(this FrameworkElement parent)
	{
		try
		{
			bool flag = true;
			int num = default(int);
			bool flag2 = default(bool);
			Queue<FrameworkElement> queue = default(Queue<FrameworkElement>);
			switch (num)
			{
			default:
				if (!flag2)
				{
					queue = new Queue<FrameworkElement>(parent.GetVisualChildren().OfType<FrameworkElement>());
					goto IL_00e0;
				}
				yield break;
			case 1:
			{
				if (flag2)
				{
					yield break;
				}
				FrameworkElement element = default(FrameworkElement);
				IEnumerator<FrameworkElement> enumerator = element.GetVisualChildren().OfType<FrameworkElement>().GetEnumerator();
				try
				{
					while (enumerator.MoveNext())
					{
						FrameworkElement visualChild = enumerator.Current;
						queue.Enqueue(visualChild);
					}
				}
				finally
				{
					if (flag)
					{
						enumerator?.Dispose();
					}
				}
				goto IL_00e0;
			}
			case -1:
				yield break;
				IL_00e0:
				if (queue.Count > 0)
				{
					queue.Dequeue();
					/*Error near IL_0109: Unexpected return in MoveNext()*/;
				}
				break;
			}
		}
		catch (Exception)
		{
			throw;
		}
	}
}
