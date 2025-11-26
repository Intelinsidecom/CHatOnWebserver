using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Media;

namespace Microsoft.Phone.Controls;

internal static class TreeHelpers
{
	public static IEnumerable<FrameworkElement> GetVisualAncestors(this FrameworkElement node)
	{
		try
		{
			int num = default(int);
			bool flag = default(bool);
			FrameworkElement parent = default(FrameworkElement);
			switch (num)
			{
			default:
				if (!flag)
				{
					parent = node.GetVisualParent();
					goto IL_0076;
				}
				yield break;
			case 1:
				if (!flag)
				{
					parent = parent.GetVisualParent();
					goto IL_0076;
				}
				yield break;
			case -1:
				yield break;
				IL_0076:
				if (parent != null)
				{
					/*Error near IL_0096: Unexpected return in MoveNext()*/;
				}
				break;
			}
		}
		catch (Exception)
		{
			throw;
		}
	}

	public static FrameworkElement GetVisualParent(this FrameworkElement node)
	{
		return VisualTreeHelper.GetParent(node) as FrameworkElement;
	}
}
