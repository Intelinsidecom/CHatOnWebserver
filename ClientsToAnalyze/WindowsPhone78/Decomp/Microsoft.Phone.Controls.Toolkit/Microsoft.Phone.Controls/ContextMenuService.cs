using System;
using System.Windows;

namespace Microsoft.Phone.Controls;

public static class ContextMenuService
{
	public static readonly DependencyProperty ContextMenuProperty = DependencyProperty.RegisterAttached("ContextMenu", typeof(ContextMenu), typeof(ContextMenuService), new PropertyMetadata(null, OnContextMenuChanged));

	public static ContextMenu GetContextMenu(DependencyObject element)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		return (ContextMenu)element.GetValue(ContextMenuProperty);
	}

	public static void SetContextMenu(DependencyObject element, ContextMenu value)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		element.SetValue(ContextMenuProperty, value);
	}

	private static void OnContextMenuChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		if (o is FrameworkElement owner)
		{
			if (e.OldValue is ContextMenu contextMenu)
			{
				contextMenu.Owner = null;
			}
			if (e.NewValue is ContextMenu contextMenu2)
			{
				contextMenu2.Owner = owner;
			}
		}
	}
}
