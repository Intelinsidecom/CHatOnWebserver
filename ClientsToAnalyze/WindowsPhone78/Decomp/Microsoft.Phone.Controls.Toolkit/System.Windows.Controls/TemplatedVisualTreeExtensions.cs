using System.Collections.Generic;
using System.Linq;

namespace System.Windows.Controls;

public static class TemplatedVisualTreeExtensions
{
	internal static T GetFirstLogicalChildByType<T>(this FrameworkElement parent, bool applyTemplates) where T : FrameworkElement
	{
		Queue<FrameworkElement> queue = new Queue<FrameworkElement>();
		queue.Enqueue(parent);
		while (queue.Count > 0)
		{
			FrameworkElement frameworkElement = queue.Dequeue();
			Control control = frameworkElement as Control;
			if (applyTemplates)
			{
				control?.ApplyTemplate();
			}
			if (frameworkElement is T && frameworkElement != parent)
			{
				return (T)frameworkElement;
			}
			foreach (FrameworkElement item in frameworkElement.GetVisualChildren().OfType<FrameworkElement>())
			{
				queue.Enqueue(item);
			}
		}
		return null;
	}

	internal static IEnumerable<T> GetLogicalChildrenByType<T>(this FrameworkElement parent, bool applyTemplates) where T : FrameworkElement
	{
		try
		{
			bool flag = true;
			int num = default(int);
			bool flag2 = default(bool);
			Queue<FrameworkElement> queue = default(Queue<FrameworkElement>);
			if (num != 1)
			{
				if (num != -1 && !flag2)
				{
					if (applyTemplates && parent is Control)
					{
						((Control)parent).ApplyTemplate();
					}
					queue = new Queue<FrameworkElement>(parent.GetVisualChildren().OfType<FrameworkElement>());
					goto IL_0141;
				}
				yield break;
			}
			if (flag2)
			{
				yield break;
			}
			goto IL_00f0;
			IL_00f0:
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
			goto IL_0141;
			IL_0141:
			if (queue.Count > 0)
			{
				element = queue.Dequeue();
				if (applyTemplates && element is Control)
				{
					((Control)element).ApplyTemplate();
				}
				if (element is T)
				{
					_ = (T)element;
					/*Error near IL_016a: Unexpected return in MoveNext()*/;
				}
				goto IL_00f0;
			}
		}
		catch (Exception)
		{
			throw;
		}
	}
}
