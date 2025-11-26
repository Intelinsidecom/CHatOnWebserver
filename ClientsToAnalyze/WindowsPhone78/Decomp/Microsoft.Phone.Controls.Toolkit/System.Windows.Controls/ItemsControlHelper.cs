using System.Windows.Media;

namespace System.Windows.Controls;

internal sealed class ItemsControlHelper
{
	private Panel _itemsHost;

	private ScrollViewer _scrollHost;

	private ItemsControl ItemsControl { get; set; }

	internal Panel ItemsHost
	{
		get
		{
			if (_itemsHost == null && ItemsControl != null && ItemsControl.ItemContainerGenerator != null)
			{
				DependencyObject dependencyObject = ItemsControl.ItemContainerGenerator.ContainerFromIndex(0);
				if (dependencyObject != null)
				{
					_itemsHost = VisualTreeHelper.GetParent(dependencyObject) as Panel;
				}
			}
			return _itemsHost;
		}
	}

	internal ScrollViewer ScrollHost
	{
		get
		{
			if (_scrollHost == null)
			{
				Panel itemsHost = ItemsHost;
				if (itemsHost != null)
				{
					DependencyObject dependencyObject = itemsHost;
					while (dependencyObject != ItemsControl && dependencyObject != null)
					{
						if (dependencyObject is ScrollViewer scrollHost)
						{
							_scrollHost = scrollHost;
							break;
						}
						dependencyObject = VisualTreeHelper.GetParent(dependencyObject);
					}
				}
			}
			return _scrollHost;
		}
	}

	internal ItemsControlHelper(ItemsControl control)
	{
		ItemsControl = control;
	}

	internal void OnApplyTemplate()
	{
		_itemsHost = null;
		_scrollHost = null;
	}

	internal static void PrepareContainerForItemOverride(DependencyObject element, Style parentItemContainerStyle)
	{
		Control control = element as Control;
		if (parentItemContainerStyle != null && control != null && control.Style == null)
		{
			control.SetValue(FrameworkElement.StyleProperty, parentItemContainerStyle);
		}
	}

	internal void UpdateItemContainerStyle(Style itemContainerStyle)
	{
		if (itemContainerStyle == null)
		{
			return;
		}
		Panel itemsHost = ItemsHost;
		if (itemsHost == null || itemsHost.Children == null)
		{
			return;
		}
		foreach (UIElement child in itemsHost.Children)
		{
			FrameworkElement frameworkElement = child as FrameworkElement;
			if (frameworkElement.Style == null)
			{
				frameworkElement.Style = itemContainerStyle;
			}
		}
	}

	internal void ScrollIntoView(FrameworkElement element)
	{
		ScrollViewer scrollHost = ScrollHost;
		if (scrollHost != null)
		{
			GeneralTransform generalTransform = null;
			try
			{
				generalTransform = element.TransformToVisual(scrollHost);
			}
			catch (ArgumentException)
			{
				return;
			}
			Rect rect = new Rect(generalTransform.Transform(default(Point)), generalTransform.Transform(new Point(element.ActualWidth, element.ActualHeight)));
			double num = scrollHost.VerticalOffset;
			double num2 = 0.0;
			double viewportHeight = scrollHost.ViewportHeight;
			double bottom = rect.Bottom;
			if (viewportHeight < bottom)
			{
				num2 = bottom - viewportHeight;
				num += num2;
			}
			double top = rect.Top;
			if (top - num2 < 0.0)
			{
				num -= num2 - top;
			}
			scrollHost.ScrollToVerticalOffset(num);
			double num3 = scrollHost.HorizontalOffset;
			double num4 = 0.0;
			double viewportWidth = scrollHost.ViewportWidth;
			double right = rect.Right;
			if (viewportWidth < right)
			{
				num4 = right - viewportWidth;
				num3 += num4;
			}
			double left = rect.Left;
			if (left - num4 < 0.0)
			{
				num3 -= num4 - left;
			}
			scrollHost.ScrollToHorizontalOffset(num3);
		}
	}
}
