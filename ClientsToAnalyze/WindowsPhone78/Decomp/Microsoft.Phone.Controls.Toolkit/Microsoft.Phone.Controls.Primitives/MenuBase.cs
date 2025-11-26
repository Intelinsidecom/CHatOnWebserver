using System.Windows;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls.Primitives;

[StyleTypedProperty(Property = "ItemContainerStyle", StyleTargetType = typeof(MenuItem))]
public abstract class MenuBase : ItemsControl
{
	public static readonly DependencyProperty ItemContainerStyleProperty = DependencyProperty.Register("ItemContainerStyle", typeof(Style), typeof(MenuBase), null);

	public Style ItemContainerStyle
	{
		get
		{
			return (Style)GetValue(ItemContainerStyleProperty);
		}
		set
		{
			SetValue(ItemContainerStyleProperty, value);
		}
	}

	protected override bool IsItemItsOwnContainerOverride(object item)
	{
		if (!(item is MenuItem))
		{
			return item is Separator;
		}
		return true;
	}

	protected override DependencyObject GetContainerForItemOverride()
	{
		return new MenuItem();
	}

	protected override void PrepareContainerForItemOverride(DependencyObject element, object item)
	{
		base.PrepareContainerForItemOverride(element, item);
		if (!(element is MenuItem menuItem))
		{
			return;
		}
		menuItem.ParentMenuBase = this;
		if (menuItem != item)
		{
			DataTemplate itemTemplate = base.ItemTemplate;
			Style itemContainerStyle = ItemContainerStyle;
			if (itemTemplate != null)
			{
				menuItem.SetValue(ItemsControl.ItemTemplateProperty, itemTemplate);
			}
			if (itemContainerStyle != null && HasDefaultValue(menuItem, HeaderedItemsControl.ItemContainerStyleProperty))
			{
				menuItem.SetValue(HeaderedItemsControl.ItemContainerStyleProperty, itemContainerStyle);
			}
			if (HasDefaultValue(menuItem, HeaderedItemsControl.HeaderProperty))
			{
				menuItem.Header = item;
			}
			if (itemTemplate != null)
			{
				menuItem.SetValue(HeaderedItemsControl.HeaderTemplateProperty, itemTemplate);
			}
			if (itemContainerStyle != null)
			{
				menuItem.SetValue(FrameworkElement.StyleProperty, itemContainerStyle);
			}
		}
	}

	private static bool HasDefaultValue(Control control, DependencyProperty property)
	{
		return control.ReadLocalValue(property) == DependencyProperty.UnsetValue;
	}
}
