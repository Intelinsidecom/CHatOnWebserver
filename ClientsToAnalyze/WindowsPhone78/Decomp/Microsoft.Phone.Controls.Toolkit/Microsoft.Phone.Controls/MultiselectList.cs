using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Windows;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls;

[StyleTypedProperty(Property = "ItemContainerStyle", StyleTargetType = typeof(MultiselectList))]
public class MultiselectList : ItemsControl
{
	public static readonly DependencyProperty IsInSelectionModeProperty = DependencyProperty.Register("IsSelectionEnabled", typeof(bool), typeof(MultiselectList), new PropertyMetadata(false, OnIsSelectionEnabledPropertyChanged));

	public static readonly DependencyProperty ItemInfoTemplateProperty = DependencyProperty.Register("ItemInfoTemplate", typeof(DataTemplate), typeof(MultiselectList), new PropertyMetadata(null, null));

	public static readonly DependencyProperty ItemContainerStyleProperty = DependencyProperty.Register("ItemContainerStyle", typeof(Style), typeof(MultiselectList), new PropertyMetadata(null, null));

	public IList SelectedItems { get; private set; }

	public bool IsSelectionEnabled
	{
		get
		{
			return (bool)GetValue(IsInSelectionModeProperty);
		}
		set
		{
			SetValue(IsInSelectionModeProperty, value);
		}
	}

	public DataTemplate ItemInfoTemplate
	{
		get
		{
			return (DataTemplate)GetValue(ItemInfoTemplateProperty);
		}
		set
		{
			SetValue(ItemInfoTemplateProperty, value);
		}
	}

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

	public event SelectionChangedEventHandler SelectionChanged;

	public event DependencyPropertyChangedEventHandler IsSelectionEnabledChanged;

	private static void OnIsSelectionEnabledPropertyChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		MultiselectList multiselectList = (MultiselectList)obj;
		if ((bool)e.NewValue)
		{
			multiselectList.OpenSelection();
		}
		else
		{
			if (multiselectList.SelectedItems.Count > 0)
			{
				IList list = new List<object>();
				foreach (object selectedItem in multiselectList.SelectedItems)
				{
					list.Add(selectedItem);
				}
				for (int i = 0; i < multiselectList.Items.Count; i++)
				{
					if (multiselectList.SelectedItems.Count <= 0)
					{
						break;
					}
					MultiselectItem multiselectItem = (MultiselectItem)multiselectList.ItemContainerGenerator.ContainerFromIndex(i);
					if (multiselectItem != null && multiselectItem.IsSelected)
					{
						multiselectItem._canTriggerSelectionChanged = false;
						multiselectItem.IsSelected = false;
						multiselectItem._canTriggerSelectionChanged = true;
					}
				}
				multiselectList.SelectedItems.Clear();
				multiselectList.OnSelectionChanged(list, new object[0]);
			}
			multiselectList.CloseSelection();
		}
		multiselectList.IsSelectionEnabledChanged?.Invoke(obj, e);
	}

	public MultiselectList()
	{
		base.DefaultStyleKey = typeof(MultiselectList);
		SelectedItems = new List<object>();
	}

	internal void OnSelectionChanged(IList removedItems, IList addedItems)
	{
		if (SelectedItems.Count <= 0)
		{
			IsSelectionEnabled = false;
		}
		else if (SelectedItems.Count == 1 && removedItems.Count == 0)
		{
			IsSelectionEnabled = true;
		}
		this.SelectionChanged?.Invoke(this, new SelectionChangedEventArgs(removedItems, addedItems));
	}

	private void OpenSelection()
	{
		IList<WeakReference> itemsInViewPort = ItemsControlExtensions.GetItemsInViewPort(this);
		foreach (WeakReference item in itemsInViewPort)
		{
			MultiselectItem multiselectItem = (MultiselectItem)item.Target;
			multiselectItem.State = SelectionEnabledState.Opened;
			multiselectItem.UpdateVisualState(useTransitions: true);
		}
		base.Dispatcher.BeginInvoke(delegate
		{
			for (int i = 0; i < base.Items.Count; i++)
			{
				MultiselectItem multiselectItem2 = (MultiselectItem)base.ItemContainerGenerator.ContainerFromIndex(i);
				if (multiselectItem2 != null)
				{
					multiselectItem2.State = SelectionEnabledState.Opened;
					multiselectItem2.UpdateVisualState(useTransitions: false);
				}
			}
		});
	}

	private void CloseSelection()
	{
		IList<WeakReference> itemsInViewPort = ItemsControlExtensions.GetItemsInViewPort(this);
		foreach (WeakReference item in itemsInViewPort)
		{
			MultiselectItem multiselectItem = (MultiselectItem)item.Target;
			multiselectItem.State = SelectionEnabledState.Closed;
			multiselectItem.UpdateVisualState(useTransitions: true);
		}
		base.Dispatcher.BeginInvoke(delegate
		{
			for (int i = 0; i < base.Items.Count; i++)
			{
				MultiselectItem multiselectItem2 = (MultiselectItem)base.ItemContainerGenerator.ContainerFromIndex(i);
				if (multiselectItem2 != null)
				{
					multiselectItem2.State = SelectionEnabledState.Closed;
					multiselectItem2.UpdateVisualState(useTransitions: false);
				}
			}
		});
	}

	protected override DependencyObject GetContainerForItemOverride()
	{
		return new MultiselectItem();
	}

	protected override bool IsItemItsOwnContainerOverride(object item)
	{
		return item is MultiselectItem;
	}

	protected override void PrepareContainerForItemOverride(DependencyObject element, object item)
	{
		base.PrepareContainerForItemOverride(element, item);
		MultiselectItem multiselectItem = (MultiselectItem)element;
		multiselectItem.Style = ItemContainerStyle;
		multiselectItem._isBeingVirtualized = true;
		multiselectItem.IsSelected = SelectedItems.Contains(item);
		multiselectItem.State = (IsSelectionEnabled ? SelectionEnabledState.Opened : SelectionEnabledState.Closed);
		multiselectItem.UpdateVisualState(useTransitions: false);
		multiselectItem._isBeingVirtualized = false;
	}

	protected override void OnItemsChanged(NotifyCollectionChangedEventArgs e)
	{
		base.OnItemsChanged(e);
		if (SelectedItems.Count <= 0)
		{
			return;
		}
		IList list = new List<object>();
		for (int i = 0; i < SelectedItems.Count; i++)
		{
			object value = SelectedItems[i];
			if (!base.Items.Contains(value))
			{
				SelectedItems.Remove(value);
				list.Add(value);
				i--;
			}
		}
		OnSelectionChanged(list, new object[0]);
	}
}
