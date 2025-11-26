using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls.Primitives;

public class TemplatedItemsControl<T> : ItemsControl where T : FrameworkElement, new()
{
	private readonly Dictionary<object, T> _itemToContainer = new Dictionary<object, T>();

	private readonly Dictionary<T, object> _containerToItem = new Dictionary<T, object>();

	public static readonly DependencyProperty ItemContainerStyleProperty = DependencyProperty.Register("ItemContainerStyle", typeof(Style), typeof(TemplatedItemsControl<T>), null);

	public Style ItemContainerStyle
	{
		get
		{
			return GetValue(ItemContainerStyleProperty) as Style;
		}
		set
		{
			SetValue(ItemContainerStyleProperty, value);
		}
	}

	protected override bool IsItemItsOwnContainerOverride(object item)
	{
		return item is T;
	}

	protected override DependencyObject GetContainerForItemOverride()
	{
		T val = new T();
		ApplyItemContainerStyle(val);
		return val;
	}

	protected override void PrepareContainerForItemOverride(DependencyObject element, object item)
	{
		ApplyItemContainerStyle(element);
		base.PrepareContainerForItemOverride(element, item);
		_itemToContainer[item] = (T)element;
		_containerToItem[(T)element] = item;
	}

	protected override void ClearContainerForItemOverride(DependencyObject element, object item)
	{
		base.ClearContainerForItemOverride(element, item);
		_itemToContainer.Remove(item);
		_containerToItem.Remove((T)element);
	}

	protected virtual void ApplyItemContainerStyle(DependencyObject container)
	{
		T val = container as T;
		if (val == null)
		{
			return;
		}
		DependencyProperty styleProperty = FrameworkElement.StyleProperty;
		if (val.ReadLocalValue(styleProperty) == DependencyProperty.UnsetValue)
		{
			Style itemContainerStyle = ItemContainerStyle;
			if (itemContainerStyle != null)
			{
				val.Style = itemContainerStyle;
				return;
			}
			DependencyProperty styleProperty2 = FrameworkElement.StyleProperty;
			val.ClearValue(styleProperty2);
		}
	}

	protected object GetItem(T container)
	{
		object value = null;
		if (container != null)
		{
			_containerToItem.TryGetValue(container, out value);
		}
		return value;
	}

	protected T GetContainer(object item)
	{
		T value = null;
		if (item != null)
		{
			_itemToContainer.TryGetValue(item, out value);
		}
		return value;
	}
}
