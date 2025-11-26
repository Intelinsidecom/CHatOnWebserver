using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Input;
using System.Windows.Media;
using Microsoft.Phone.Controls.Primitives;
using Microsoft.Phone.Shell;

namespace Microsoft.Phone.Controls;

[TemplatePart(Name = "TemplatedListBox", Type = typeof(TemplatedListBox))]
public class LongListSelector : Control
{
	internal enum ItemType
	{
		Unknown,
		Item,
		GroupHeader,
		GroupFooter,
		ListHeader,
		ListFooter
	}

	internal class ItemTuple
	{
		public ItemType ItemType { get; set; }

		public object Group { get; set; }

		public object Item { get; set; }
	}

	private class GroupSelectedEventArgs : EventArgs
	{
		public object Group { get; private set; }

		public GroupSelectedEventArgs(object group)
		{
			Group = group;
		}
	}

	private delegate void GroupSelectedEventHandler(object sender, GroupSelectedEventArgs e);

	private class LongListSelectorItemsControl : ItemsControl
	{
		public event GroupSelectedEventHandler GroupSelected;

		protected override void PrepareContainerForItemOverride(DependencyObject element, object item)
		{
			base.PrepareContainerForItemOverride(element, item);
			((UIElement)element).Tap += LongListSelectorItemsControl_Tap;
		}

		protected override void ClearContainerForItemOverride(DependencyObject element, object item)
		{
			base.ClearContainerForItemOverride(element, item);
			((UIElement)element).Tap -= LongListSelectorItemsControl_Tap;
		}

		private void LongListSelectorItemsControl_Tap(object sender, System.Windows.Input.GestureEventArgs e)
		{
			if (sender is ContentPresenter contentPresenter)
			{
				GroupSelectedEventHandler groupSelected = this.GroupSelected;
				if (groupSelected != null)
				{
					GroupSelectedEventArgs e2 = new GroupSelectedEventArgs(contentPresenter.Content);
					groupSelected(this, e2);
				}
			}
		}
	}

	private const string TemplatedListBoxName = "TemplatedListBox";

	private const double BufferSizeDefault = 1.0;

	private const string ScrollingState = "Scrolling";

	private const string NotScrollingState = "NotScrolling";

	private const string CompressionTop = "CompressionTop";

	private const string CompressionBottom = "CompressionBottom";

	private const string NoVerticalCompression = "NoVerticalCompression";

	private TemplatedListBox _listBox;

	private VisualStateGroup _scrollGroup;

	private INotifyCollectionChanged _rootCollection;

	private List<INotifyCollectionChanged> _groupCollections = new List<INotifyCollectionChanged>();

	public static readonly DependencyProperty ItemsSourceProperty = DependencyProperty.Register("ItemsSource", typeof(IEnumerable), typeof(LongListSelector), new PropertyMetadata(null, OnItemsSourceChanged));

	public static readonly DependencyProperty ListHeaderProperty = DependencyProperty.Register("ListHeader", typeof(object), typeof(LongListSelector), new PropertyMetadata(null));

	public static readonly DependencyProperty ListHeaderTemplateProperty = DependencyProperty.Register("ListHeaderTemplate", typeof(DataTemplate), typeof(LongListSelector), new PropertyMetadata(null, OnDataTemplateChanged));

	public static readonly DependencyProperty ListFooterProperty = DependencyProperty.Register("ListFooter", typeof(object), typeof(LongListSelector), new PropertyMetadata(null));

	public static readonly DependencyProperty ListFooterTemplateProperty = DependencyProperty.Register("ListFooterTemplate", typeof(DataTemplate), typeof(LongListSelector), new PropertyMetadata(null, OnDataTemplateChanged));

	public static readonly DependencyProperty GroupHeaderProperty = DependencyProperty.Register("GroupHeaderTemplate", typeof(DataTemplate), typeof(LongListSelector), new PropertyMetadata(null, OnDataTemplateChanged));

	public static readonly DependencyProperty GroupFooterProperty = DependencyProperty.Register("GroupFooterTemplate", typeof(DataTemplate), typeof(LongListSelector), new PropertyMetadata(null, OnDataTemplateChanged));

	public static readonly DependencyProperty ItemsTemplateProperty = DependencyProperty.Register("ItemTemplate", typeof(DataTemplate), typeof(LongListSelector), new PropertyMetadata(null, OnDataTemplateChanged));

	public static readonly DependencyProperty DisplayAllGroupsProperty = DependencyProperty.Register("DisplayAllGroups", typeof(bool), typeof(LongListSelector), new PropertyMetadata(false, OnDisplayAllGroupsChanged));

	public static readonly DependencyProperty GroupItemTemplateProperty = DependencyProperty.Register("GroupItemTemplate", typeof(DataTemplate), typeof(LongListSelector), new PropertyMetadata(null));

	public static readonly DependencyProperty GroupItemsPanelProperty = DependencyProperty.Register("GroupItemsPanel", typeof(ItemsPanelTemplate), typeof(LongListSelector), new PropertyMetadata(null));

	[Obsolete("BufferSizeProperty no longer affect items virtualization")]
	public static readonly DependencyProperty BufferSizeProperty = DependencyProperty.Register("BufferSize", typeof(double), typeof(LongListSelector), new PropertyMetadata(1.0, OnBufferSizeChanged));

	[Obsolete("MaximumFlickVelocityProperty is not used anymore.")]
	public static readonly DependencyProperty MaximumFlickVelocityProperty = DependencyProperty.Register("MaximumFlickVelocity", typeof(double), typeof(LongListSelector), new PropertyMetadata(MotionParameters.MaximumSpeed));

	public static readonly DependencyProperty ShowListHeaderProperty = DependencyProperty.Register("ShowListHeader", typeof(bool), typeof(LongListSelector), new PropertyMetadata(true, OnShowListHeaderChanged));

	public static readonly DependencyProperty ShowListFooterProperty = DependencyProperty.Register("ShowListFooter", typeof(bool), typeof(LongListSelector), new PropertyMetadata(true, OnShowListFooterChanged));

	private PhoneApplicationPage _page;

	private bool _systemTrayVisible;

	private bool _applicationBarVisible;

	private Border _border;

	private LongListSelectorItemsControl _itemsControl;

	private Popup _groupSelectorPopup;

	private static readonly double _screenWidth = Application.Current.Host.Content.ActualWidth;

	private static readonly double _screenHeight = Application.Current.Host.Content.ActualHeight;

	public bool IsFlatList { get; set; }

	public object SelectedItem
	{
		get
		{
			if (_listBox != null && _listBox.SelectedItem != null)
			{
				ItemTuple itemTuple = (ItemTuple)_listBox.SelectedItem;
				if (itemTuple.ItemType == ItemType.Item)
				{
					return itemTuple.Item;
				}
			}
			return null;
		}
		set
		{
			if (_listBox == null)
			{
				return;
			}
			if (value == null)
			{
				_listBox.SelectedItem = null;
				return;
			}
			foreach (ItemTuple item in _listBox.ItemsSource)
			{
				if (item.Item == value)
				{
					_listBox.SelectedItem = item;
					break;
				}
			}
		}
	}

	[Obsolete("IsBouncy is always set to true.")]
	public bool IsBouncy
	{
		get
		{
			return true;
		}
		set
		{
		}
	}

	private bool HasListHeader
	{
		get
		{
			if (ListHeaderTemplate == null)
			{
				return ListHeader is UIElement;
			}
			return true;
		}
	}

	private bool HasListFooter
	{
		get
		{
			if (ListFooterTemplate == null)
			{
				return ListFooter is UIElement;
			}
			return true;
		}
	}

	public bool IsScrolling { get; private set; }

	public IEnumerable ItemsSource
	{
		get
		{
			return (IEnumerable)GetValue(ItemsSourceProperty);
		}
		set
		{
			SetValue(ItemsSourceProperty, value);
		}
	}

	public object ListHeader
	{
		get
		{
			return GetValue(ListHeaderProperty);
		}
		set
		{
			SetValue(ListHeaderProperty, value);
		}
	}

	public DataTemplate ListHeaderTemplate
	{
		get
		{
			return (DataTemplate)GetValue(ListHeaderTemplateProperty);
		}
		set
		{
			SetValue(ListHeaderTemplateProperty, value);
		}
	}

	public object ListFooter
	{
		get
		{
			return GetValue(ListFooterProperty);
		}
		set
		{
			SetValue(ListFooterProperty, value);
		}
	}

	public DataTemplate ListFooterTemplate
	{
		get
		{
			return (DataTemplate)GetValue(ListFooterTemplateProperty);
		}
		set
		{
			SetValue(ListFooterTemplateProperty, value);
		}
	}

	public DataTemplate GroupHeaderTemplate
	{
		get
		{
			return (DataTemplate)GetValue(GroupHeaderProperty);
		}
		set
		{
			SetValue(GroupHeaderProperty, value);
		}
	}

	public DataTemplate GroupFooterTemplate
	{
		get
		{
			return (DataTemplate)GetValue(GroupFooterProperty);
		}
		set
		{
			SetValue(GroupFooterProperty, value);
		}
	}

	public DataTemplate ItemTemplate
	{
		get
		{
			return (DataTemplate)GetValue(ItemsTemplateProperty);
		}
		set
		{
			SetValue(ItemsTemplateProperty, value);
		}
	}

	public bool DisplayAllGroups
	{
		get
		{
			return (bool)GetValue(DisplayAllGroupsProperty);
		}
		set
		{
			SetValue(DisplayAllGroupsProperty, value);
		}
	}

	public DataTemplate GroupItemTemplate
	{
		get
		{
			return (DataTemplate)GetValue(GroupItemTemplateProperty);
		}
		set
		{
			SetValue(GroupItemTemplateProperty, value);
		}
	}

	public ItemsPanelTemplate GroupItemsPanel
	{
		get
		{
			return (ItemsPanelTemplate)GetValue(GroupItemsPanelProperty);
		}
		set
		{
			SetValue(GroupItemsPanelProperty, value);
		}
	}

	[Obsolete("BufferSize no longer affect items virtualization")]
	public double BufferSize
	{
		get
		{
			return (double)GetValue(BufferSizeProperty);
		}
		set
		{
			SetValue(BufferSizeProperty, value);
		}
	}

	[Obsolete("MaximumFlickVelocity is not used anymore.")]
	public double MaximumFlickVelocity
	{
		get
		{
			return (double)GetValue(MaximumFlickVelocityProperty);
		}
		set
		{
			SetValue(MaximumFlickVelocityProperty, value);
		}
	}

	public bool ShowListHeader
	{
		get
		{
			return (bool)GetValue(ShowListHeaderProperty);
		}
		set
		{
			SetValue(ShowListHeaderProperty, value);
		}
	}

	public bool ShowListFooter
	{
		get
		{
			return (bool)GetValue(ShowListFooterProperty);
		}
		set
		{
			SetValue(ShowListFooterProperty, value);
		}
	}

	public event SelectionChangedEventHandler SelectionChanged;

	public event EventHandler ScrollingStarted;

	public event EventHandler ScrollingCompleted;

	public event EventHandler<GroupViewOpenedEventArgs> GroupViewOpened;

	public event EventHandler<GroupViewClosingEventArgs> GroupViewClosing;

	public event EventHandler<LinkUnlinkEventArgs> Link;

	public event EventHandler<LinkUnlinkEventArgs> Unlink;

	public event EventHandler StretchingBottom;

	public event EventHandler StretchingCompleted;

	public event EventHandler StretchingTop;

	private static void OnItemsSourceChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		((LongListSelector)obj).OnItemsSourceChanged();
	}

	private static void OnBufferSizeChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		double num = (double)e.NewValue;
		if (num < 0.0)
		{
			throw new ArgumentOutOfRangeException("BufferSize");
		}
	}

	private static void OnShowListHeaderChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		LongListSelector longListSelector = (LongListSelector)obj;
		if (longListSelector._listBox != null)
		{
			Collection<ItemTuple> tuples = (Collection<ItemTuple>)longListSelector._listBox.ItemsSource;
			if (longListSelector.ShowListHeader)
			{
				longListSelector.AddListHeader(tuples);
			}
			else
			{
				RemoveListHeader(tuples);
			}
		}
	}

	private static void OnShowListFooterChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		LongListSelector longListSelector = (LongListSelector)obj;
		if (longListSelector._listBox != null)
		{
			Collection<ItemTuple> tuples = (Collection<ItemTuple>)longListSelector._listBox.ItemsSource;
			if (longListSelector.ShowListFooter)
			{
				longListSelector.AddListFooter(tuples);
			}
			else
			{
				RemoveListFooter(tuples);
			}
		}
	}

	public LongListSelector()
	{
		base.DefaultStyleKey = typeof(LongListSelector);
	}

	public void ScrollTo(object item)
	{
		if (_listBox == null || item == null)
		{
			return;
		}
		ObservableCollection<ItemTuple> observableCollection = (ObservableCollection<ItemTuple>)_listBox.ItemsSource;
		ItemTuple item2 = observableCollection[observableCollection.Count - 1];
		_listBox.ScrollIntoView(item2);
		UpdateLayout();
		foreach (ItemTuple item3 in _listBox.ItemsSource)
		{
			if (item3.Item != null && item3.Item.Equals(item))
			{
				_listBox.ScrollIntoView(item3);
				break;
			}
		}
	}

	public void ScrollToGroup(object group)
	{
		ScrollTo(group);
	}

	public void DisplayGroupView()
	{
		if (GroupItemTemplate != null && !IsFlatList)
		{
			OpenPopup();
		}
	}

	public void CloseGroupView()
	{
		ClosePopup(null, raiseEvent: false);
	}

	[Obsolete("AnimateTo(...) call ScrollTo(...) to jump without animation to the given item.")]
	public void AnimateTo(object item)
	{
		ScrollTo(item);
	}

	[Obsolete("GetItemsWithContainers(...) always returns an empty collection of items. Rely on Link/Unlink to know an item get realized or unrealized.")]
	public ICollection<object> GetItemsWithContainers(bool onlyItemsInView, bool getContainers)
	{
		return new Collection<object>();
	}

	[Obsolete("GetItemsInView() always returns an empty collection of items. Rely on Link/Unlink to know an item get realized or unrealized.")]
	public ICollection<object> GetItemsInView()
	{
		return GetItemsWithContainers(onlyItemsInView: true, getContainers: false);
	}

	private void OnItemsSourceChanged()
	{
		LoadDataIntoListBox();
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		if (_listBox != null)
		{
			_listBox.SelectionChanged -= OnSelectionChanged;
			_listBox.Link -= OnLink;
			_listBox.Unlink -= OnUnlink;
		}
		if (_scrollGroup != null)
		{
			_scrollGroup.CurrentStateChanging -= OnScrollStateChanging;
		}
		_listBox = (GetTemplateChild("TemplatedListBox") as TemplatedListBox) ?? new TemplatedListBox();
		_listBox.ListHeaderTemplate = ListHeaderTemplate;
		_listBox.ListFooterTemplate = ListFooterTemplate;
		_listBox.GroupHeaderTemplate = GroupHeaderTemplate;
		_listBox.GroupFooterTemplate = GroupFooterTemplate;
		_listBox.ItemTemplate = ItemTemplate;
		_listBox.SelectionChanged += OnSelectionChanged;
		_listBox.Link += OnLink;
		_listBox.Unlink += OnUnlink;
		ScrollViewer firstLogicalChildByType = _listBox.GetFirstLogicalChildByType<ScrollViewer>(applyTemplates: true);
		if (firstLogicalChildByType != null && VisualTreeHelper.GetChild(firstLogicalChildByType, 0) is FrameworkElement)
		{
			_scrollGroup = VisualStates.TryGetVisualStateGroup(firstLogicalChildByType, "ScrollStates");
			if (_scrollGroup != null)
			{
				_scrollGroup.CurrentStateChanging += OnScrollStateChanging;
			}
		}
		LoadDataIntoListBox();
	}

	private void LoadDataIntoListBox()
	{
		if (_listBox == null)
		{
			return;
		}
		ObservableCollection<ItemTuple> observableCollection = new ObservableCollection<ItemTuple>();
		AddListHeader(observableCollection);
		UnsubscribleFromAllCollections();
		if (IsFlatList)
		{
			if (ItemsSource != null)
			{
				foreach (object item in ItemsSource)
				{
					observableCollection.Add(new ItemTuple
					{
						Item = item,
						ItemType = ItemType.Item
					});
				}
			}
		}
		else
		{
			IEnumerable itemsSource = ItemsSource;
			if (itemsSource != null)
			{
				foreach (object item2 in itemsSource)
				{
					AddGroup(item2, observableCollection);
				}
			}
		}
		AddListFooter(observableCollection);
		_rootCollection = ItemsSource as INotifyCollectionChanged;
		if (_rootCollection != null)
		{
			_rootCollection.CollectionChanged += OnCollectionChanged;
		}
		_listBox.ItemsSource = observableCollection;
	}

	private void AddListHeader(IList<ItemTuple> tuples)
	{
		if (HasListHeader && ShowListHeader && (tuples.Count == 0 || tuples[0].ItemType != ItemType.ListHeader))
		{
			tuples.Insert(0, new ItemTuple
			{
				Item = ListHeader,
				ItemType = ItemType.ListHeader
			});
		}
	}

	private void AddListHeader()
	{
		AddListHeader((ObservableCollection<ItemTuple>)_listBox.ItemsSource);
	}

	private static void RemoveListHeader(IList<ItemTuple> tuples)
	{
		if (tuples.Count > 0 && tuples[0].ItemType == ItemType.ListHeader)
		{
			tuples.RemoveAt(0);
		}
	}

	private void RemoveListHeader()
	{
		RemoveListHeader((ObservableCollection<ItemTuple>)_listBox.ItemsSource);
	}

	private void AddListFooter(IList<ItemTuple> tuples)
	{
		if (HasListFooter && ShowListFooter && (tuples.Count == 0 || tuples[tuples.Count - 1].ItemType != ItemType.ListFooter))
		{
			tuples.Add(new ItemTuple
			{
				Item = ListFooter,
				ItemType = ItemType.ListFooter
			});
		}
	}

	private void AddListFooter()
	{
		AddListFooter((ObservableCollection<ItemTuple>)_listBox.ItemsSource);
	}

	private static void RemoveListFooter(IList<ItemTuple> tuples)
	{
		ItemTuple itemTuple = tuples[tuples.Count - 1];
		if (itemTuple != null && itemTuple.ItemType == ItemType.ListFooter)
		{
			tuples.RemoveAt(tuples.Count - 1);
		}
	}

	private void RemoveListFooter()
	{
		RemoveListFooter((ObservableCollection<ItemTuple>)_listBox.ItemsSource);
	}

	private void AddGroup(object groupToAdd, IList tuples)
	{
		if (!(groupToAdd is IEnumerable enumerable))
		{
			return;
		}
		bool flag = false;
		if (GroupHeaderTemplate != null)
		{
			tuples.Add(new ItemTuple
			{
				Item = enumerable,
				ItemType = ItemType.GroupHeader
			});
		}
		foreach (object item in enumerable)
		{
			tuples.Add(new ItemTuple
			{
				Item = item,
				ItemType = ItemType.Item,
				Group = enumerable
			});
			flag = true;
		}
		if (flag || DisplayAllGroups)
		{
			if (GroupFooterTemplate != null)
			{
				tuples.Add(new ItemTuple
				{
					Item = enumerable,
					ItemType = ItemType.GroupFooter
				});
			}
		}
		else if (GroupHeaderTemplate != null)
		{
			tuples.RemoveAt(tuples.Count - 1);
		}
		if (enumerable is INotifyCollectionChanged notifyCollectionChanged && !_groupCollections.Contains(notifyCollectionChanged))
		{
			notifyCollectionChanged.CollectionChanged += OnCollectionChanged;
			_groupCollections.Add(notifyCollectionChanged);
		}
	}

	private void AddGroupHeadersAndFooters(bool addHeaders, bool addFooters)
	{
		int num = 0;
		if (HasListHeader && ShowListHeader)
		{
			num++;
		}
		IEnumerable itemsSource = ItemsSource;
		ObservableCollection<ItemTuple> observableCollection = (ObservableCollection<ItemTuple>)_listBox.ItemsSource;
		if (itemsSource == null)
		{
			return;
		}
		foreach (object item in itemsSource)
		{
			if (item is IEnumerable enumerable)
			{
				int itemsCountFromGroup = GetItemsCountFromGroup(enumerable);
				if (addHeaders && GroupHeaderTemplate != null && itemsCountFromGroup > 0)
				{
					observableCollection.Insert(num, new ItemTuple
					{
						Item = item,
						ItemType = ItemType.GroupHeader
					});
				}
				num += itemsCountFromGroup;
				if (addFooters && GroupFooterTemplate != null && itemsCountFromGroup > 0)
				{
					observableCollection.Insert(num - 1, new ItemTuple
					{
						Item = item,
						ItemType = ItemType.GroupFooter
					});
				}
			}
		}
	}

	private void AddGroupHeaders()
	{
		AddGroupHeadersAndFooters(addHeaders: true, addFooters: false);
	}

	private void AddGroupFooters()
	{
		AddGroupHeadersAndFooters(addHeaders: false, addFooters: true);
	}

	private void RemoveAllGroupHeadersAndFooters(bool removeHeaders, bool removeFooters)
	{
		ObservableCollection<ItemTuple> observableCollection = (ObservableCollection<ItemTuple>)_listBox.ItemsSource;
		for (int i = 0; i < observableCollection.Count; i++)
		{
			if ((removeHeaders && observableCollection[i].ItemType == ItemType.GroupHeader) || (removeFooters && observableCollection[i].ItemType == ItemType.GroupFooter))
			{
				observableCollection.RemoveAt(i--);
			}
		}
	}

	private void RemoveAllGroupHeaders()
	{
		RemoveAllGroupHeadersAndFooters(removeHeaders: true, removeFooters: false);
	}

	private void RemoveAllGroupFooters()
	{
		RemoveAllGroupHeadersAndFooters(removeHeaders: false, removeFooters: true);
	}

	private void UnsubscribleFromAllCollections()
	{
		if (_rootCollection != null)
		{
			_rootCollection.CollectionChanged -= OnCollectionChanged;
		}
		foreach (INotifyCollectionChanged groupCollection in _groupCollections)
		{
			groupCollection.CollectionChanged -= OnCollectionChanged;
		}
		_rootCollection = null;
		_groupCollections.Clear();
	}

	private void InsertNewGroups(IList newGroups, int newGroupsIndex)
	{
		ObservableCollection<ItemTuple> observableCollection = (ObservableCollection<ItemTuple>)_listBox.ItemsSource;
		List<ItemTuple> list = new List<ItemTuple>();
		foreach (object newGroup in newGroups)
		{
			AddGroup(newGroup, list);
		}
		if (list.Count <= 0)
		{
			return;
		}
		int groupIndexInListBox = GetGroupIndexInListBox(newGroupsIndex);
		foreach (ItemTuple item in list)
		{
			observableCollection.Insert(groupIndexInListBox++, item);
		}
	}

	private void InsertNewItems(IList newItems, int newItemsIndex, IEnumerable group)
	{
		ObservableCollection<ItemTuple> observableCollection = (ObservableCollection<ItemTuple>)_listBox.ItemsSource;
		List<ItemTuple> list = new List<ItemTuple>();
		foreach (object newItem in newItems)
		{
			list.Add(new ItemTuple
			{
				Group = group,
				Item = newItem,
				ItemType = ItemType.Item
			});
		}
		if (group != null)
		{
			int num = 0;
			bool flag = ((IList)group).Count == newItems.Count && !DisplayAllGroups;
			{
				foreach (object item in ItemsSource)
				{
					if (item == group)
					{
						int num2 = GetGroupIndexInListBox(num);
						if (GroupHeaderTemplate != null)
						{
							if (flag)
							{
								observableCollection.Insert(num2, new ItemTuple
								{
									ItemType = ItemType.GroupHeader,
									Item = group
								});
							}
							num2++;
						}
						num2 += newItemsIndex;
						foreach (ItemTuple item2 in list)
						{
							observableCollection.Insert(num2++, item2);
						}
						if (flag && GroupFooterTemplate != null)
						{
							observableCollection.Insert(num2++, new ItemTuple
							{
								ItemType = ItemType.GroupFooter,
								Item = group
							});
						}
					}
					num++;
				}
				return;
			}
		}
		int num3 = newItemsIndex;
		if (HasListHeader && ShowListHeader)
		{
			num3++;
		}
		foreach (ItemTuple item3 in list)
		{
			observableCollection.Insert(num3++, item3);
		}
	}

	private void RemoveOldGroups(IList oldGroups, int oldGroupsIndex)
	{
		ObservableCollection<ItemTuple> observableCollection = (ObservableCollection<ItemTuple>)_listBox.ItemsSource;
		int num = 0;
		if (oldGroupsIndex > 0)
		{
			num = GetGroupIndexInListBox(oldGroupsIndex - 1);
			if (((IList)ItemsSource)[oldGroupsIndex - 1] is IEnumerable enumerable)
			{
				num += GetItemsCountFromGroup(enumerable);
			}
		}
		else if (HasListHeader && ShowListHeader)
		{
			num++;
		}
		int itemsCountFromGroups = GetItemsCountFromGroups(oldGroups);
		for (int i = 0; i < itemsCountFromGroups; i++)
		{
			observableCollection.RemoveAt(num);
		}
		foreach (INotifyCollectionChanged oldGroup in oldGroups)
		{
			oldGroup.CollectionChanged -= OnCollectionChanged;
		}
	}

	private void RemoveOldItems(IList oldItems, int oldItemsIndex, IEnumerable group)
	{
		ObservableCollection<ItemTuple> observableCollection = (ObservableCollection<ItemTuple>)_listBox.ItemsSource;
		if (group != null)
		{
			int num = 0;
			{
				foreach (object item in ItemsSource)
				{
					if (item == group)
					{
						int groupIndexInListBox = GetGroupIndexInListBox(num);
						groupIndexInListBox += oldItemsIndex;
						if (GroupHeaderTemplate != null)
						{
							groupIndexInListBox++;
						}
						for (int i = 0; i < oldItems.Count; i++)
						{
							observableCollection.RemoveAt(groupIndexInListBox);
						}
						if (((IList)group).Count == 0 && !DisplayAllGroups)
						{
							if (GroupFooterTemplate != null)
							{
								observableCollection.RemoveAt(groupIndexInListBox);
							}
							if (GroupHeaderTemplate != null)
							{
								observableCollection.RemoveAt(groupIndexInListBox - 1);
							}
						}
					}
					num++;
				}
				return;
			}
		}
		int num2 = oldItemsIndex;
		if (HasListHeader && ShowListHeader)
		{
			num2++;
		}
		for (int j = 0; j < oldItems.Count; j++)
		{
			observableCollection.RemoveAt(num2);
		}
	}

	private int GetGroupIndexInListBox(int indexInLLS)
	{
		int num = 0;
		int num2 = 0;
		if (HasListHeader && ShowListHeader)
		{
			num++;
		}
		IEnumerable itemsSource = ItemsSource;
		if (itemsSource != null)
		{
			foreach (object item in itemsSource)
			{
				if (indexInLLS != num2)
				{
					num2++;
					if (item is IEnumerable enumerable)
					{
						num += GetItemsCountFromGroup(enumerable);
					}
					continue;
				}
				break;
			}
		}
		return num;
	}

	private int GetItemsCountFromGroups(IEnumerable groups)
	{
		int num = 0;
		foreach (object group in groups)
		{
			if (group is IEnumerable enumerable)
			{
				num += GetItemsCountFromGroup(enumerable);
			}
		}
		return num;
	}

	private int GetItemsCountFromGroup(IEnumerable group)
	{
		int num = 0;
		num = ((!(group is IList list)) ? (num + group.Cast<object>().Count()) : (num + list.Count));
		bool flag = num > 1;
		if (GroupHeaderTemplate != null)
		{
			num++;
		}
		if ((flag || DisplayAllGroups) && GroupFooterTemplate != null)
		{
			num++;
		}
		else if (GroupHeaderTemplate != null)
		{
			num--;
		}
		return num;
	}

	private void UpdateItemsTemplate(ItemType itemType, DataTemplate newTemplate)
	{
		if (_listBox == null)
		{
			return;
		}
		IEnumerable<TemplatedListBoxItem> logicalChildrenByType = _listBox.GetLogicalChildrenByType<TemplatedListBoxItem>(applyTemplates: false);
		foreach (TemplatedListBoxItem item in logicalChildrenByType)
		{
			ItemTuple tuple = item.Tuple;
			if (tuple.ItemType == itemType)
			{
				item.ContentTemplate = newTemplate;
			}
		}
		switch (itemType)
		{
		case ItemType.ListHeader:
			_listBox.ListHeaderTemplate = newTemplate;
			break;
		case ItemType.ListFooter:
			_listBox.ListFooterTemplate = newTemplate;
			break;
		case ItemType.GroupHeader:
			_listBox.GroupHeaderTemplate = newTemplate;
			break;
		case ItemType.GroupFooter:
			_listBox.GroupFooterTemplate = newTemplate;
			break;
		case ItemType.Item:
			_listBox.ItemTemplate = newTemplate;
			break;
		}
	}

	private static void OnDataTemplateChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		LongListSelector longListSelector = (LongListSelector)o;
		if (longListSelector._listBox == null)
		{
			return;
		}
		DataTemplate newTemplate = (DataTemplate)e.NewValue;
		if (e.Property == ListHeaderTemplateProperty)
		{
			longListSelector.UpdateItemsTemplate(ItemType.ListHeader, newTemplate);
			if (e.OldValue == null)
			{
				longListSelector.AddListHeader();
			}
			else if (e.NewValue == null && !longListSelector.HasListHeader)
			{
				longListSelector.RemoveListHeader();
			}
		}
		else if (e.Property == ListFooterTemplateProperty)
		{
			longListSelector.UpdateItemsTemplate(ItemType.ListFooter, newTemplate);
			if (e.OldValue == null)
			{
				longListSelector.AddListFooter();
			}
			else if (e.NewValue == null && !longListSelector.HasListHeader)
			{
				longListSelector.RemoveListFooter();
			}
		}
		else if (e.Property == GroupHeaderProperty)
		{
			longListSelector.UpdateItemsTemplate(ItemType.GroupHeader, newTemplate);
			if (e.OldValue == null)
			{
				longListSelector.AddGroupHeaders();
			}
			else if (e.NewValue == null)
			{
				longListSelector.RemoveAllGroupHeaders();
			}
		}
		else if (e.Property == GroupFooterProperty)
		{
			longListSelector.UpdateItemsTemplate(ItemType.GroupFooter, newTemplate);
			if (e.OldValue == null)
			{
				longListSelector.AddGroupFooters();
			}
			else if (e.NewValue == null)
			{
				longListSelector.RemoveAllGroupFooters();
			}
		}
		else if (e.Property == ItemsTemplateProperty)
		{
			longListSelector.UpdateItemsTemplate(ItemType.Item, newTemplate);
		}
	}

	private static void OnDisplayAllGroupsChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		((LongListSelector)obj).LoadDataIntoListBox();
	}

	private void OnSelectionChanged(object sender, SelectionChangedEventArgs e)
	{
		ItemTuple itemTuple = null;
		foreach (ItemTuple addedItem in e.AddedItems)
		{
			if (addedItem.ItemType == ItemType.GroupHeader)
			{
				itemTuple = addedItem;
				break;
			}
		}
		if (itemTuple != null)
		{
			SelectedItem = null;
			DisplayGroupView();
			return;
		}
		SelectionChangedEventHandler selectionChanged = this.SelectionChanged;
		if (selectionChanged == null)
		{
			return;
		}
		List<ItemTuple> list = new List<ItemTuple>();
		List<ItemTuple> list2 = new List<ItemTuple>();
		foreach (ItemTuple addedItem2 in e.AddedItems)
		{
			if (addedItem2.ItemType == ItemType.Item)
			{
				list.Add(addedItem2);
			}
		}
		foreach (ItemTuple removedItem in e.RemovedItems)
		{
			if (removedItem.ItemType == ItemType.Item)
			{
				list2.Add(removedItem);
			}
		}
		selectionChanged(this, new SelectionChangedEventArgs(list2, list));
	}

	private void OnCollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
	{
		IEnumerable enumerable = sender as IEnumerable;
		switch (e.Action)
		{
		case NotifyCollectionChangedAction.Add:
			if (sender == _rootCollection)
			{
				if (IsFlatList)
				{
					InsertNewItems(e.NewItems, e.NewStartingIndex, null);
				}
				else
				{
					InsertNewGroups(e.NewItems, e.NewStartingIndex);
				}
			}
			else
			{
				InsertNewItems(e.NewItems, e.NewStartingIndex, enumerable);
			}
			break;
		case NotifyCollectionChangedAction.Remove:
			if (sender == _rootCollection)
			{
				if (IsFlatList)
				{
					RemoveOldItems(e.OldItems, e.OldStartingIndex, null);
				}
				else
				{
					RemoveOldGroups(e.OldItems, e.OldStartingIndex);
				}
			}
			else
			{
				RemoveOldItems(e.OldItems, e.OldStartingIndex, enumerable);
			}
			break;
		case NotifyCollectionChangedAction.Replace:
		case NotifyCollectionChangedAction.Reset:
			LoadDataIntoListBox();
			break;
		case (NotifyCollectionChangedAction)3:
			break;
		}
	}

	private void OnScrollStateChanging(object sender, VisualStateChangedEventArgs e)
	{
		IsScrolling = e.NewState.Name == "Scrolling";
		if (e.NewState.Name == "Scrolling" && this.ScrollingStarted != null)
		{
			this.ScrollingStarted(this, null);
		}
		else if (e.NewState.Name == "NotScrolling" && this.ScrollingStarted != null)
		{
			this.ScrollingCompleted(this, null);
		}
		else if (e.NewState.Name == "CompressionTop" && this.StretchingTop != null)
		{
			this.StretchingTop(this, null);
		}
		else if (e.NewState.Name == "CompressionBottom" && this.StretchingBottom != null)
		{
			this.StretchingBottom(this, null);
		}
		else if (e.NewState.Name == "NoVerticalCompression" && this.StretchingCompleted != null)
		{
			this.StretchingCompleted(this, null);
		}
	}

	private void OnLink(object sender, LinkUnlinkEventArgs e)
	{
		if (this.Link != null)
		{
			this.Link(this, e);
		}
	}

	private void OnUnlink(object sender, LinkUnlinkEventArgs e)
	{
		if (this.Unlink != null)
		{
			this.Unlink(this, e);
		}
	}

	private void OpenPopup()
	{
		SaveSystemState(newSystemTrayVisible: false, newApplicationBarVisible: false);
		BuildPopup();
		AttachToPageEvents();
		_groupSelectorPopup.IsOpen = true;
		UpdateLayout();
	}

	private void popup_Opened(object sender, EventArgs e)
	{
		Microsoft.Phone.Controls.SafeRaise.Raise(this.GroupViewOpened, this, () => new GroupViewOpenedEventArgs(_itemsControl));
	}

	private bool ClosePopup(object selectedGroup, bool raiseEvent)
	{
		if (raiseEvent)
		{
			GroupViewClosingEventArgs args = null;
			Microsoft.Phone.Controls.SafeRaise.Raise(this.GroupViewClosing, this, () => args = new GroupViewClosingEventArgs(_itemsControl, selectedGroup));
			if (args != null && args.Cancel)
			{
				return false;
			}
		}
		if (_groupSelectorPopup != null)
		{
			RestoreSystemState();
			_groupSelectorPopup.IsOpen = false;
			DetachFromPageEvents();
			_groupSelectorPopup.Child = null;
			_border = null;
			_itemsControl = null;
			_groupSelectorPopup = null;
		}
		return true;
	}

	private void BuildPopup()
	{
		_groupSelectorPopup = new Popup();
		_groupSelectorPopup.Opened += popup_Opened;
		Color color = (Color)base.Resources["PhoneBackgroundColor"];
		_border = new Border
		{
			Background = new SolidColorBrush(Color.FromArgb(160, color.R, color.G, color.B))
		};
		_border.ManipulationStarted += delegate(object o, ManipulationStartedEventArgs e)
		{
			e.Handled = true;
		};
		_border.ManipulationCompleted += delegate(object o, ManipulationCompletedEventArgs e)
		{
			e.Handled = true;
		};
		_border.ManipulationDelta += delegate(object o, ManipulationDeltaEventArgs e)
		{
			e.Handled = true;
		};
		EventHandler<System.Windows.Input.GestureEventArgs> value = delegate(object o, System.Windows.Input.GestureEventArgs e)
		{
			e.Handled = true;
		};
		_border.Tap += value;
		_border.DoubleTap += value;
		_border.Hold += value;
		_itemsControl = new LongListSelectorItemsControl();
		_itemsControl.ItemTemplate = GroupItemTemplate;
		_itemsControl.ItemsPanel = GroupItemsPanel;
		_itemsControl.ItemsSource = ItemsSource;
		_itemsControl.GroupSelected += itemsControl_GroupSelected;
		_groupSelectorPopup.Child = _border;
		ScrollViewer scrollViewer = new ScrollViewer();
		scrollViewer.HorizontalScrollBarVisibility = ScrollBarVisibility.Disabled;
		ScrollViewer scrollViewer2 = scrollViewer;
		_itemsControl.HorizontalAlignment = HorizontalAlignment.Center;
		_itemsControl.Margin = new Thickness(0.0, 12.0, 0.0, 0.0);
		_border.Child = scrollViewer2;
		scrollViewer2.Content = _itemsControl;
		SetItemsControlSize();
	}

	private void SetItemsControlSize()
	{
		Rect transformedRect = GetTransformedRect();
		if (_border != null)
		{
			_border.RenderTransform = GetTransform();
			_border.Width = transformedRect.Width;
			_border.Height = transformedRect.Height;
		}
	}

	private void itemsControl_GroupSelected(object sender, GroupSelectedEventArgs e)
	{
		if (ClosePopup(e.Group, raiseEvent: true))
		{
			ScrollToGroup(e.Group);
		}
	}

	private void AttachToPageEvents()
	{
		UIElement rootVisual = Application.Current.RootVisual;
		PhoneApplicationFrame val = (PhoneApplicationFrame)(object)((rootVisual is PhoneApplicationFrame) ? rootVisual : null);
		if (val != null)
		{
			ref PhoneApplicationPage page = ref _page;
			object content = ((ContentControl)(object)val).Content;
			page = (PhoneApplicationPage)((content is PhoneApplicationPage) ? content : null);
			if (_page != null)
			{
				_page.BackKeyPress += page_BackKeyPress;
				_page.OrientationChanged += page_OrientationChanged;
			}
		}
	}

	private void DetachFromPageEvents()
	{
		if (_page != null)
		{
			_page.BackKeyPress -= page_BackKeyPress;
			_page.OrientationChanged -= page_OrientationChanged;
			_page = null;
		}
	}

	private void page_BackKeyPress(object sender, CancelEventArgs e)
	{
		e.Cancel = true;
		ClosePopup(null, raiseEvent: true);
	}

	private void page_OrientationChanged(object sender, OrientationChangedEventArgs e)
	{
		SetItemsControlSize();
	}

	private static Rect GetTransformedRect()
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		bool flag = IsLandscape(GetPageOrientation());
		return new Rect(0.0, 0.0, flag ? _screenHeight : _screenWidth, flag ? _screenWidth : _screenHeight);
	}

	private static Transform GetTransform()
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		//IL_000a: Invalid comparison between Unknown and I4
		//IL_000c: Unknown result type (might be due to invalid IL or missing references)
		//IL_000f: Invalid comparison between Unknown and I4
		//IL_0011: Unknown result type (might be due to invalid IL or missing references)
		//IL_0014: Invalid comparison between Unknown and I4
		PageOrientation pageOrientation = GetPageOrientation();
		PageOrientation val = pageOrientation;
		if ((int)val != 2 && (int)val != 18)
		{
			if ((int)val == 34)
			{
				CompositeTransform compositeTransform = new CompositeTransform();
				compositeTransform.Rotation = -90.0;
				compositeTransform.TranslateY = _screenHeight;
				return compositeTransform;
			}
			return null;
		}
		CompositeTransform compositeTransform2 = new CompositeTransform();
		compositeTransform2.Rotation = 90.0;
		compositeTransform2.TranslateX = _screenWidth;
		return compositeTransform2;
	}

	private static bool IsLandscape(PageOrientation orientation)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0002: Invalid comparison between Unknown and I4
		//IL_0004: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Invalid comparison between Unknown and I4
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_000c: Invalid comparison between Unknown and I4
		if ((int)orientation != 2 && (int)orientation != 18)
		{
			return (int)orientation == 34;
		}
		return true;
	}

	private static PageOrientation GetPageOrientation()
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		UIElement rootVisual = Application.Current.RootVisual;
		PhoneApplicationFrame val = (PhoneApplicationFrame)(object)((rootVisual is PhoneApplicationFrame) ? rootVisual : null);
		if (val == null)
		{
			return (PageOrientation)0;
		}
		object content = ((ContentControl)(object)val).Content;
		PhoneApplicationPage val2 = (PhoneApplicationPage)((content is PhoneApplicationPage) ? content : null);
		return val2.Orientation;
	}

	private void SaveSystemState(bool newSystemTrayVisible, bool newApplicationBarVisible)
	{
		_systemTrayVisible = SystemTray.IsVisible;
		SystemTray.IsVisible = newSystemTrayVisible;
		UIElement rootVisual = Application.Current.RootVisual;
		PhoneApplicationFrame val = (PhoneApplicationFrame)(object)((rootVisual is PhoneApplicationFrame) ? rootVisual : null);
		if (val != null)
		{
			object content = ((ContentControl)(object)val).Content;
			PhoneApplicationPage val2 = (PhoneApplicationPage)((content is PhoneApplicationPage) ? content : null);
			if (val2 != null && val2.ApplicationBar != null)
			{
				_applicationBarVisible = val2.ApplicationBar.IsVisible;
				val2.ApplicationBar.IsVisible = newApplicationBarVisible;
			}
		}
	}

	private void RestoreSystemState()
	{
		SystemTray.IsVisible = _systemTrayVisible;
		UIElement rootVisual = Application.Current.RootVisual;
		PhoneApplicationFrame val = (PhoneApplicationFrame)(object)((rootVisual is PhoneApplicationFrame) ? rootVisual : null);
		if (val != null)
		{
			object content = ((ContentControl)(object)val).Content;
			PhoneApplicationPage val2 = (PhoneApplicationPage)((content is PhoneApplicationPage) ? content : null);
			if (val2 != null && val2.ApplicationBar != null)
			{
				val2.ApplicationBar.IsVisible = _applicationBarVisible;
			}
		}
	}
}
