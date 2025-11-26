using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Navigation;
using Microsoft.Phone.Controls.Properties;

namespace Microsoft.Phone.Controls;

[TemplatePart(Name = "ItemsPresenterTranslateTransform", Type = typeof(TranslateTransform))]
[TemplateVisualState(GroupName = "PickerStates", Name = "Normal")]
[TemplatePart(Name = "MultipleSelectionModeSummary", Type = typeof(TextBlock))]
[TemplateVisualState(GroupName = "PickerStates", Name = "Disabled")]
[TemplatePart(Name = "ItemsPresenter", Type = typeof(ItemsPresenter))]
[TemplateVisualState(GroupName = "PickerStates", Name = "Highlighted")]
[TemplatePart(Name = "ItemsPresenterHost", Type = typeof(Canvas))]
public class ListPicker : ItemsControl
{
	private const string ItemsPresenterPartName = "ItemsPresenter";

	private const string ItemsPresenterTranslateTransformPartName = "ItemsPresenterTranslateTransform";

	private const string ItemsPresenterHostPartName = "ItemsPresenterHost";

	private const string MultipleSelectionModeSummaryPartName = "MultipleSelectionModeSummary";

	private const string BorderPartName = "Border";

	private const string PickerStatesGroupName = "PickerStates";

	private const string PickerStatesNormalStateName = "Normal";

	private const string PickerStatesHighlightedStateName = "Highlighted";

	private const string PickerStatesDisabledStateName = "Disabled";

	private const double NormalModeOffset = 4.0;

	private readonly DoubleAnimation _heightAnimation = new DoubleAnimation();

	private readonly DoubleAnimation _translateAnimation = new DoubleAnimation();

	private readonly Storyboard _storyboard = new Storyboard();

	private PhoneApplicationFrame _frame;

	private PhoneApplicationPage _page;

	private FrameworkElement _itemsPresenterHostParent;

	private Canvas _itemsPresenterHostPart;

	private ItemsPresenter _itemsPresenterPart;

	private TranslateTransform _itemsPresenterTranslateTransformPart;

	private bool _updatingSelection;

	private int _deferredSelectedIndex = -1;

	private object _frameContentWhenOpened;

	private NavigationInTransition _savedNavigationInTransition;

	private NavigationOutTransition _savedNavigationOutTransition;

	private ListPickerPage _listPickerPage;

	private TextBlock _multipleSelectionModeSummary;

	private Border _border;

	private bool _hasPickerPageOpen;

	public static readonly DependencyProperty ListPickerModeProperty = DependencyProperty.Register("ListPickerMode", typeof(ListPickerMode), typeof(ListPicker), new PropertyMetadata(ListPickerMode.Normal, OnListPickerModeChanged));

	private static readonly DependencyProperty IsHighlightedProperty = DependencyProperty.Register("IsHighlighted", typeof(bool), typeof(ListPicker), new PropertyMetadata(false, OnIsHighlightedChanged));

	public static readonly DependencyProperty SelectedIndexProperty = DependencyProperty.Register("SelectedIndex", typeof(int), typeof(ListPicker), new PropertyMetadata(-1, OnSelectedIndexChanged));

	public static readonly DependencyProperty SelectedItemProperty = DependencyProperty.Register("SelectedItem", typeof(object), typeof(ListPicker), new PropertyMetadata(null, OnSelectedItemChanged));

	private static readonly DependencyProperty ShadowItemTemplateProperty = DependencyProperty.Register("ShadowItemTemplate", typeof(DataTemplate), typeof(ListPicker), new PropertyMetadata(null, OnShadowOrFullModeItemTemplateChanged));

	public static readonly DependencyProperty FullModeItemTemplateProperty = DependencyProperty.Register("FullModeItemTemplate", typeof(DataTemplate), typeof(ListPicker), new PropertyMetadata(null, OnShadowOrFullModeItemTemplateChanged));

	private static readonly DependencyProperty ActualFullModeItemTemplateProperty = DependencyProperty.Register("ActualFullModeItemTemplate", typeof(DataTemplate), typeof(ListPicker), null);

	public static readonly DependencyProperty HeaderProperty = DependencyProperty.Register("Header", typeof(object), typeof(ListPicker), null);

	public static readonly DependencyProperty HeaderTemplateProperty = DependencyProperty.Register("HeaderTemplate", typeof(DataTemplate), typeof(ListPicker), null);

	public static readonly DependencyProperty FullModeHeaderProperty = DependencyProperty.Register("FullModeHeader", typeof(object), typeof(ListPicker), null);

	public static readonly DependencyProperty ItemCountThresholdProperty = DependencyProperty.Register("ItemCountThreshold", typeof(int), typeof(ListPicker), new PropertyMetadata(5, OnItemCountThresholdChanged));

	public static readonly DependencyProperty PickerPageUriProperty = DependencyProperty.Register("PickerPageUri", typeof(Uri), typeof(ListPicker), null);

	public static readonly DependencyProperty ExpansionModeProperty = DependencyProperty.Register("ExpansionMode", typeof(ExpansionMode), typeof(ListPicker), new PropertyMetadata(ExpansionMode.ExpansionAllowed, null));

	public static readonly DependencyProperty SelectionModeProperty = DependencyProperty.Register("SelectionMode", typeof(SelectionMode), typeof(ListPicker), new PropertyMetadata(SelectionMode.Single, OnSelectionModeChanged));

	public static readonly DependencyProperty SelectedItemsProperty = DependencyProperty.Register("SelectedItems", typeof(IList), typeof(ListPicker), new PropertyMetadata(OnSelectedItemsChanged));

	public Func<IList, string> SummaryForSelectedItemsDelegate { get; set; }

	public ListPickerMode ListPickerMode
	{
		get
		{
			return (ListPickerMode)GetValue(ListPickerModeProperty);
		}
		private set
		{
			SetValue(ListPickerModeProperty, value);
		}
	}

	private bool IsHighlighted
	{
		get
		{
			return (bool)GetValue(IsHighlightedProperty);
		}
		set
		{
			SetValue(IsHighlightedProperty, value);
		}
	}

	public int SelectedIndex
	{
		get
		{
			return (int)GetValue(SelectedIndexProperty);
		}
		set
		{
			SetValue(SelectedIndexProperty, value);
		}
	}

	public object SelectedItem
	{
		get
		{
			return GetValue(SelectedItemProperty);
		}
		set
		{
			SetValue(SelectedItemProperty, value);
		}
	}

	public DataTemplate FullModeItemTemplate
	{
		get
		{
			return (DataTemplate)GetValue(FullModeItemTemplateProperty);
		}
		set
		{
			SetValue(FullModeItemTemplateProperty, value);
		}
	}

	public object Header
	{
		get
		{
			return GetValue(HeaderProperty);
		}
		set
		{
			SetValue(HeaderProperty, value);
		}
	}

	public DataTemplate HeaderTemplate
	{
		get
		{
			return (DataTemplate)GetValue(HeaderTemplateProperty);
		}
		set
		{
			SetValue(HeaderTemplateProperty, value);
		}
	}

	public object FullModeHeader
	{
		get
		{
			return GetValue(FullModeHeaderProperty);
		}
		set
		{
			SetValue(FullModeHeaderProperty, value);
		}
	}

	public int ItemCountThreshold
	{
		get
		{
			return (int)GetValue(ItemCountThresholdProperty);
		}
		private set
		{
			SetValue(ItemCountThresholdProperty, value);
		}
	}

	public Uri PickerPageUri
	{
		get
		{
			return (Uri)GetValue(PickerPageUriProperty);
		}
		set
		{
			SetValue(PickerPageUriProperty, value);
		}
	}

	public ExpansionMode ExpansionMode
	{
		get
		{
			return (ExpansionMode)GetValue(ExpansionModeProperty);
		}
		set
		{
			SetValue(ExpansionModeProperty, value);
		}
	}

	public SelectionMode SelectionMode
	{
		get
		{
			return (SelectionMode)GetValue(SelectionModeProperty);
		}
		set
		{
			SetValue(SelectionModeProperty, value);
		}
	}

	public IList SelectedItems
	{
		get
		{
			return (IList)GetValue(SelectedItemsProperty);
		}
		private set
		{
			SetValue(SelectedItemsProperty, value);
		}
	}

	public event SelectionChangedEventHandler SelectionChanged;

	private static void OnListPickerModeChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		((ListPicker)o).OnListPickerModeChanged((ListPickerMode)e.OldValue, (ListPickerMode)e.NewValue);
	}

	private void OnListPickerModeChanged(ListPickerMode oldValue, ListPickerMode newValue)
	{
		if (ListPickerMode.Expanded == oldValue)
		{
			if (_page != null)
			{
				_page.BackKeyPress -= HandlePageBackKeyPress;
				_page = null;
			}
			if (_frame != null)
			{
				((UIElement)(object)_frame).ManipulationStarted -= HandleFrameManipulationStarted;
				_frame = null;
			}
		}
		if (ListPickerMode.Expanded == newValue)
		{
			if (_frame == null)
			{
				ref PhoneApplicationFrame frame = ref _frame;
				UIElement rootVisual = Application.Current.RootVisual;
				frame = (PhoneApplicationFrame)(object)((rootVisual is PhoneApplicationFrame) ? rootVisual : null);
				if (_frame != null)
				{
					((UIElement)(object)_frame).AddHandler(UIElement.ManipulationStartedEvent, (Delegate)new EventHandler<ManipulationStartedEventArgs>(HandleFrameManipulationStarted), handledEventsToo: true);
				}
			}
			if (_frame != null)
			{
				ref PhoneApplicationPage page = ref _page;
				object content = ((ContentControl)(object)_frame).Content;
				page = (PhoneApplicationPage)((content is PhoneApplicationPage) ? content : null);
				if (_page != null)
				{
					_page.BackKeyPress += HandlePageBackKeyPress;
				}
			}
		}
		if (ListPickerMode.Full == oldValue)
		{
			ClosePickerPage();
		}
		if (ListPickerMode.Full == newValue)
		{
			OpenPickerPage();
		}
		SizeForAppropriateView(ListPickerMode.Full != oldValue);
		IsHighlighted = ListPickerMode.Expanded == newValue;
	}

	private static void OnIsHighlightedChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		(o as ListPicker).OnIsHighlightedChanged();
	}

	private void OnIsHighlightedChanged()
	{
		UpdateVisualStates(useTransitions: true);
	}

	private static void OnIsEnabledChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		(o as ListPicker).OnIsEnabledChanged();
	}

	private void OnIsEnabledChanged()
	{
		UpdateVisualStates(useTransitions: true);
	}

	private static void OnSelectedIndexChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		((ListPicker)o).OnSelectedIndexChanged((int)e.OldValue, (int)e.NewValue);
	}

	private void OnSelectedIndexChanged(int oldValue, int newValue)
	{
		if (base.Items.Count <= newValue || (0 < base.Items.Count && newValue < 0) || (base.Items.Count == 0 && newValue != -1))
		{
			if (base.Template == null && 0 <= newValue)
			{
				_deferredSelectedIndex = newValue;
				return;
			}
			throw new InvalidOperationException(Microsoft.Phone.Controls.Properties.Resources.InvalidSelectedIndex);
		}
		if (!_updatingSelection)
		{
			_updatingSelection = true;
			SelectedItem = ((-1 != newValue) ? base.Items[newValue] : null);
			_updatingSelection = false;
		}
		if (-1 != oldValue)
		{
			ListPickerItem listPickerItem = (ListPickerItem)base.ItemContainerGenerator.ContainerFromIndex(oldValue);
			if (listPickerItem != null)
			{
				listPickerItem.IsSelected = false;
			}
		}
	}

	private static void OnSelectedItemChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		((ListPicker)o).OnSelectedItemChanged(e.OldValue, e.NewValue);
	}

	private void OnSelectedItemChanged(object oldValue, object newValue)
	{
		int num = (num = ((newValue != null) ? base.Items.IndexOf(newValue) : (-1)));
		if (-1 == num && 0 < base.Items.Count)
		{
			throw new InvalidOperationException(Microsoft.Phone.Controls.Properties.Resources.InvalidSelectedItem);
		}
		if (!_updatingSelection)
		{
			_updatingSelection = true;
			SelectedIndex = num;
			_updatingSelection = false;
		}
		if (ListPickerMode != ListPickerMode.Normal)
		{
			ListPickerMode = ListPickerMode.Normal;
		}
		else
		{
			SizeForAppropriateView(animate: false);
		}
		SelectionChangedEventHandler selectionChanged = this.SelectionChanged;
		if (selectionChanged != null)
		{
			IList removedItems = ((oldValue == null) ? new object[0] : new object[1] { oldValue });
			IList addedItems = ((newValue == null) ? new object[0] : new object[1] { newValue });
			selectionChanged(this, new SelectionChangedEventArgs(removedItems, addedItems));
		}
	}

	private static void OnShadowOrFullModeItemTemplateChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		((ListPicker)o).OnShadowOrFullModeItemTemplateChanged();
	}

	private void OnShadowOrFullModeItemTemplateChanged()
	{
		SetValue(ActualFullModeItemTemplateProperty, FullModeItemTemplate ?? base.ItemTemplate);
	}

	private static void OnItemCountThresholdChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		((ListPicker)o).OnItemCountThresholdChanged((int)e.NewValue);
	}

	private void OnItemCountThresholdChanged(int newValue)
	{
		if (newValue < 0)
		{
			throw new ArgumentOutOfRangeException("ItemCountThreshold");
		}
	}

	private static void OnSelectionModeChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		((ListPicker)o).OnSelectionModeChanged((SelectionMode)e.NewValue);
	}

	private void OnSelectionModeChanged(SelectionMode newValue)
	{
		if (newValue == SelectionMode.Multiple || newValue == SelectionMode.Extended)
		{
			if (_multipleSelectionModeSummary != null && _itemsPresenterHostPart != null)
			{
				_multipleSelectionModeSummary.Visibility = Visibility.Visible;
				_itemsPresenterHostPart.Visibility = Visibility.Collapsed;
			}
		}
		else if (_multipleSelectionModeSummary != null && _itemsPresenterHostPart != null)
		{
			_multipleSelectionModeSummary.Visibility = Visibility.Collapsed;
			_itemsPresenterHostPart.Visibility = Visibility.Visible;
		}
	}

	private static void OnSelectedItemsChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		((ListPicker)o).OnSelectedItemsChanged((IList)e.OldValue, (IList)e.NewValue);
	}

	private void OnSelectedItemsChanged(IList oldValue, IList newValue)
	{
		UpdateSummary(newValue);
		SelectionChangedEventHandler selectionChanged = this.SelectionChanged;
		if (selectionChanged == null)
		{
			return;
		}
		IList list = new List<object>();
		if (oldValue != null)
		{
			foreach (object item in oldValue)
			{
				if (newValue == null || !newValue.Contains(item))
				{
					list.Add(item);
				}
			}
		}
		IList list2 = new List<object>();
		if (newValue != null)
		{
			foreach (object item2 in newValue)
			{
				if (oldValue == null || !oldValue.Contains(item2))
				{
					list2.Add(item2);
				}
			}
		}
		selectionChanged(this, new SelectionChangedEventArgs(list, list2));
	}

	public ListPicker()
	{
		base.DefaultStyleKey = typeof(ListPicker);
		Storyboard.SetTargetProperty(_heightAnimation, new PropertyPath(FrameworkElement.HeightProperty));
		Storyboard.SetTargetProperty(_translateAnimation, new PropertyPath(TranslateTransform.YProperty));
		Duration duration = TimeSpan.FromSeconds(0.2);
		_heightAnimation.Duration = duration;
		_translateAnimation.Duration = duration;
		IEasingFunction easingFunction = new ExponentialEase
		{
			EasingMode = EasingMode.EaseInOut,
			Exponent = 4.0
		};
		_heightAnimation.EasingFunction = easingFunction;
		_translateAnimation.EasingFunction = easingFunction;
		this.RegisterNotification("IsEnabled", OnIsEnabledChanged);
		base.Loaded += OnLoaded;
		base.Unloaded += OnUnloaded;
	}

	private void OnLoaded(object sender, RoutedEventArgs e)
	{
		UpdateVisualStates(useTransitions: true);
	}

	private void OnUnloaded(object sender, RoutedEventArgs e)
	{
		if (_frame != null)
		{
			((UIElement)(object)_frame).ManipulationStarted -= HandleFrameManipulationStarted;
			_frame = null;
		}
	}

	public override void OnApplyTemplate()
	{
		if (_itemsPresenterHostParent != null)
		{
			_itemsPresenterHostParent.SizeChanged -= HandleItemsPresenterHostParentSizeChanged;
		}
		_storyboard.Stop();
		((FrameworkElement)this).OnApplyTemplate();
		_itemsPresenterPart = GetTemplateChild("ItemsPresenter") as ItemsPresenter;
		_itemsPresenterTranslateTransformPart = GetTemplateChild("ItemsPresenterTranslateTransform") as TranslateTransform;
		_itemsPresenterHostPart = GetTemplateChild("ItemsPresenterHost") as Canvas;
		_itemsPresenterHostParent = ((_itemsPresenterHostPart != null) ? (_itemsPresenterHostPart.Parent as FrameworkElement) : null);
		_multipleSelectionModeSummary = GetTemplateChild("MultipleSelectionModeSummary") as TextBlock;
		_border = GetTemplateChild("Border") as Border;
		if (_itemsPresenterHostParent != null)
		{
			_itemsPresenterHostParent.SizeChanged += HandleItemsPresenterHostParentSizeChanged;
		}
		if (_itemsPresenterHostPart != null)
		{
			Storyboard.SetTarget(_heightAnimation, _itemsPresenterHostPart);
			if (!_storyboard.Children.Contains(_heightAnimation))
			{
				_storyboard.Children.Add(_heightAnimation);
			}
		}
		else if (_storyboard.Children.Contains(_heightAnimation))
		{
			_storyboard.Children.Remove(_heightAnimation);
		}
		if (_itemsPresenterTranslateTransformPart != null)
		{
			Storyboard.SetTarget(_translateAnimation, _itemsPresenterTranslateTransformPart);
			if (!_storyboard.Children.Contains(_translateAnimation))
			{
				_storyboard.Children.Add(_translateAnimation);
			}
		}
		else if (_storyboard.Children.Contains(_translateAnimation))
		{
			_storyboard.Children.Remove(_translateAnimation);
		}
		SetBinding(ShadowItemTemplateProperty, new Binding("ItemTemplate")
		{
			Source = this
		});
		if (-1 != _deferredSelectedIndex)
		{
			SelectedIndex = _deferredSelectedIndex;
			_deferredSelectedIndex = -1;
		}
		OnSelectionModeChanged(SelectionMode);
		OnSelectedItemsChanged(SelectedItems, SelectedItems);
	}

	protected override bool IsItemItsOwnContainerOverride(object item)
	{
		return item is ListPickerItem;
	}

	protected override DependencyObject GetContainerForItemOverride()
	{
		return new ListPickerItem();
	}

	protected override void PrepareContainerForItemOverride(DependencyObject element, object item)
	{
		base.PrepareContainerForItemOverride(element, item);
		ContentControl contentControl = (ContentControl)element;
		contentControl.ManipulationCompleted += HandleContainerManipulationCompleted;
		contentControl.SizeChanged += HandleListPickerItemSizeChanged;
		if (object.Equals(item, SelectedItem))
		{
			SizeForAppropriateView(animate: false);
		}
	}

	protected override void ClearContainerForItemOverride(DependencyObject element, object item)
	{
		base.ClearContainerForItemOverride(element, item);
		ContentControl contentControl = (ContentControl)element;
		contentControl.ManipulationCompleted -= HandleContainerManipulationCompleted;
		contentControl.SizeChanged -= HandleListPickerItemSizeChanged;
	}

	protected override void OnItemsChanged(NotifyCollectionChangedEventArgs e)
	{
		base.OnItemsChanged(e);
		if (0 < base.Items.Count && SelectedItem == null)
		{
			if (GetBindingExpression(SelectedIndexProperty) == null && GetBindingExpression(SelectedItemProperty) == null)
			{
				SelectedIndex = 0;
			}
		}
		else if (base.Items.Count == 0)
		{
			SelectedIndex = -1;
			ListPickerMode = ListPickerMode.Normal;
		}
		else if (base.Items.Count <= SelectedIndex)
		{
			SelectedIndex = base.Items.Count - 1;
		}
		else if (!object.Equals(base.Items[SelectedIndex], SelectedItem))
		{
			int num = base.Items.IndexOf(SelectedItem);
			if (-1 == num)
			{
				SelectedItem = base.Items[0];
			}
			else
			{
				SelectedIndex = num;
			}
		}
		base.Dispatcher.BeginInvoke(delegate
		{
			SizeForAppropriateView(animate: false);
		});
	}

	private bool IsValidManipulation(object OriginalSource, double x, double y)
	{
		for (DependencyObject dependencyObject = OriginalSource as DependencyObject; dependencyObject != null; dependencyObject = VisualTreeHelper.GetParent(dependencyObject))
		{
			if (_itemsPresenterHostPart == dependencyObject || _multipleSelectionModeSummary == dependencyObject || _border == dependencyObject)
			{
				double num = 11.0;
				if (x > 0.0 && y > 0.0 - num && x < _border.RenderSize.Width)
				{
					return y < _border.RenderSize.Height + num;
				}
				return false;
			}
		}
		return false;
	}

	protected override void OnManipulationStarted(ManipulationStartedEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		base.OnManipulationStarted(e);
		if (!base.IsEnabled)
		{
			e.Complete();
		}
		else if (IsValidManipulation(e.OriginalSource, e.ManipulationOrigin.X, e.ManipulationOrigin.Y))
		{
			IsHighlighted = true;
		}
	}

	protected override void OnManipulationDelta(ManipulationDeltaEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		base.OnManipulationDelta(e);
		if (!base.IsEnabled)
		{
			e.Complete();
		}
		else if (!IsValidManipulation(e.OriginalSource, e.ManipulationOrigin.X, e.ManipulationOrigin.Y))
		{
			IsHighlighted = false;
			e.Complete();
		}
	}

	protected override void OnManipulationCompleted(ManipulationCompletedEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		base.OnManipulationCompleted(e);
		if (base.IsEnabled)
		{
			IsHighlighted = false;
			if (IsValidManipulation(e.OriginalSource, e.ManipulationOrigin.X, e.ManipulationOrigin.Y) && 0 < base.Items.Count && Open())
			{
				e.Handled = true;
			}
		}
	}

	public bool Open()
	{
		if (SelectionMode == SelectionMode.Single)
		{
			if (ListPickerMode == ListPickerMode.Normal)
			{
				if (ExpansionMode == ExpansionMode.ExpansionAllowed && base.Items.Count <= ItemCountThreshold)
				{
					ListPickerMode = ListPickerMode.Expanded;
				}
				else
				{
					ListPickerMode = ListPickerMode.Full;
				}
				return true;
			}
			return false;
		}
		ListPickerMode = ListPickerMode.Full;
		return true;
	}

	private void HandleItemsPresenterHostParentSizeChanged(object sender, SizeChangedEventArgs e)
	{
		if (_itemsPresenterPart != null)
		{
			_itemsPresenterPart.Width = e.NewSize.Width;
		}
		_itemsPresenterHostParent.Clip = new RectangleGeometry
		{
			Rect = new Rect(default(Point), e.NewSize)
		};
	}

	private void HandleListPickerItemSizeChanged(object sender, SizeChangedEventArgs e)
	{
		ContentControl container = (ContentControl)sender;
		if (object.Equals(base.ItemContainerGenerator.ItemFromContainer(container), SelectedItem))
		{
			SizeForAppropriateView(animate: false);
		}
	}

	private void HandlePageBackKeyPress(object sender, CancelEventArgs e)
	{
		ListPickerMode = ListPickerMode.Normal;
		e.Cancel = true;
	}

	private void SizeForAppropriateView(bool animate)
	{
		switch (ListPickerMode)
		{
		case ListPickerMode.Normal:
			SizeForNormalMode(animate);
			break;
		case ListPickerMode.Expanded:
			SizeForExpandedMode();
			break;
		}
		_storyboard.Begin();
		if (!animate)
		{
			_storyboard.SkipToFill();
		}
	}

	private void SizeForNormalMode(bool animate)
	{
		ContentControl contentControl = (ContentControl)base.ItemContainerGenerator.ContainerFromItem(SelectedItem);
		if (contentControl != null)
		{
			if (0.0 < contentControl.ActualHeight)
			{
				SetContentHeight(contentControl.ActualHeight + contentControl.Margin.Top + contentControl.Margin.Bottom - 8.0);
			}
			if (_itemsPresenterTranslateTransformPart != null)
			{
				if (!animate)
				{
					_itemsPresenterTranslateTransformPart.Y = -4.0;
				}
				_translateAnimation.To = contentControl.Margin.Top - LayoutInformation.GetLayoutSlot(contentControl).Top - 4.0;
				_translateAnimation.From = (animate ? ((double?)null) : _translateAnimation.To);
			}
		}
		else
		{
			SetContentHeight(0.0);
		}
		ListPickerItem listPickerItem = (ListPickerItem)base.ItemContainerGenerator.ContainerFromIndex(SelectedIndex);
		if (listPickerItem != null)
		{
			listPickerItem.IsSelected = false;
		}
	}

	private void SizeForExpandedMode()
	{
		if (_itemsPresenterPart != null)
		{
			SetContentHeight(_itemsPresenterPart.ActualHeight);
		}
		if (_itemsPresenterTranslateTransformPart != null)
		{
			_translateAnimation.To = 0.0;
		}
		ListPickerItem listPickerItem = (ListPickerItem)base.ItemContainerGenerator.ContainerFromIndex(SelectedIndex);
		if (listPickerItem != null)
		{
			listPickerItem.IsSelected = true;
		}
	}

	private void SetContentHeight(double height)
	{
		if (_itemsPresenterHostPart != null && !double.IsNaN(height))
		{
			double height2 = _itemsPresenterHostPart.Height;
			_heightAnimation.From = (double.IsNaN(height2) ? height : height2);
			_heightAnimation.To = height;
		}
	}

	private void HandleFrameManipulationStarted(object sender, ManipulationStartedEventArgs e)
	{
		if (ListPickerMode.Expanded != ListPickerMode)
		{
			return;
		}
		DependencyObject dependencyObject = e.OriginalSource as DependencyObject;
		DependencyObject dependencyObject2 = (DependencyObject)(((object)_itemsPresenterHostPart) ?? ((object)this));
		while (dependencyObject != null)
		{
			if (dependencyObject2 == dependencyObject)
			{
				return;
			}
			dependencyObject = VisualTreeHelper.GetParent(dependencyObject);
		}
		ListPickerMode = ListPickerMode.Normal;
	}

	private void HandleContainerManipulationCompleted(object sender, ManipulationCompletedEventArgs e)
	{
		if (ListPickerMode.Expanded == ListPickerMode)
		{
			ContentControl container = (ContentControl)sender;
			SelectedItem = base.ItemContainerGenerator.ItemFromContainer(container);
			ListPickerMode = ListPickerMode.Normal;
			e.Handled = true;
		}
	}

	private void UpdateVisualStates(bool useTransitions)
	{
		if (!base.IsEnabled)
		{
			VisualStateManager.GoToState(this, "Disabled", useTransitions);
		}
		else if (IsHighlighted)
		{
			VisualStateManager.GoToState(this, "Highlighted", useTransitions);
		}
		else
		{
			VisualStateManager.GoToState(this, "Normal", useTransitions);
		}
	}

	private void UpdateSummary(IList newValue)
	{
		string text = null;
		if (SummaryForSelectedItemsDelegate != null)
		{
			text = SummaryForSelectedItemsDelegate(newValue);
		}
		if (text == null)
		{
			text = ((newValue != null && newValue.Count != 0) ? newValue[0].ToString() : " ");
		}
		if (string.IsNullOrEmpty(text))
		{
			text = " ";
		}
		if (_multipleSelectionModeSummary != null)
		{
			_multipleSelectionModeSummary.Text = text;
		}
	}

	private void OpenPickerPage()
	{
		//IL_00ae: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b8: Expected O, but got Unknown
		//IL_00c5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00cf: Expected O, but got Unknown
		if (null == PickerPageUri)
		{
			throw new ArgumentException("PickerPageUri");
		}
		if (_frame != null)
		{
			return;
		}
		ref PhoneApplicationFrame frame = ref _frame;
		UIElement rootVisual = Application.Current.RootVisual;
		frame = (PhoneApplicationFrame)(object)((rootVisual is PhoneApplicationFrame) ? rootVisual : null);
		if (_frame != null)
		{
			_frameContentWhenOpened = ((ContentControl)(object)_frame).Content;
			if (_frameContentWhenOpened is UIElement element)
			{
				_savedNavigationInTransition = TransitionService.GetNavigationInTransition(element);
				TransitionService.SetNavigationInTransition(element, null);
				_savedNavigationOutTransition = TransitionService.GetNavigationOutTransition(element);
				TransitionService.SetNavigationOutTransition(element, null);
			}
			((Frame)_frame).Navigated += HandleFrameNavigated;
			((Frame)_frame).NavigationStopped += new NavigationStoppedEventHandler(HandleFrameNavigationStoppedOrFailed);
			((Frame)_frame).NavigationFailed += new NavigationFailedEventHandler(HandleFrameNavigationStoppedOrFailed);
			_hasPickerPageOpen = true;
			((Frame)_frame).Navigate(PickerPageUri);
		}
	}

	private void ClosePickerPage()
	{
		//IL_002f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0039: Expected O, but got Unknown
		//IL_0046: Unknown result type (might be due to invalid IL or missing references)
		//IL_0050: Expected O, but got Unknown
		if (_frame != null)
		{
			((Frame)_frame).Navigated -= HandleFrameNavigated;
			((Frame)_frame).NavigationStopped -= new NavigationStoppedEventHandler(HandleFrameNavigationStoppedOrFailed);
			((Frame)_frame).NavigationFailed -= new NavigationFailedEventHandler(HandleFrameNavigationStoppedOrFailed);
			if (_frameContentWhenOpened is UIElement element)
			{
				TransitionService.SetNavigationInTransition(element, _savedNavigationInTransition);
				_savedNavigationInTransition = null;
				TransitionService.SetNavigationOutTransition(element, _savedNavigationOutTransition);
				_savedNavigationOutTransition = null;
			}
			_frame = null;
			_frameContentWhenOpened = null;
		}
		if (_listPickerPage != null)
		{
			if (SelectionMode == SelectionMode.Single && _listPickerPage.SelectedItem != null)
			{
				SelectedItem = _listPickerPage.SelectedItem;
			}
			else if ((SelectionMode == SelectionMode.Multiple || SelectionMode == SelectionMode.Extended) && _listPickerPage.SelectedItems != null)
			{
				SelectedItems = _listPickerPage.SelectedItems;
			}
			_listPickerPage = null;
		}
	}

	private void HandleFrameNavigated(object sender, NavigationEventArgs e)
	{
		if (e.Content == _frameContentWhenOpened)
		{
			ListPickerMode = ListPickerMode.Normal;
		}
		else
		{
			if (_listPickerPage != null || !_hasPickerPageOpen)
			{
				return;
			}
			_hasPickerPageOpen = false;
			_listPickerPage = e.Content as ListPickerPage;
			if (_listPickerPage == null)
			{
				return;
			}
			if (FullModeHeader != null)
			{
				_listPickerPage.HeaderText = (string)FullModeHeader;
			}
			else
			{
				_listPickerPage.HeaderText = (string)Header;
			}
			_listPickerPage.FullModeItemTemplate = FullModeItemTemplate;
			_listPickerPage.Items.Clear();
			if (base.Items != null)
			{
				foreach (object item in base.Items)
				{
					_listPickerPage.Items.Add(item);
				}
			}
			_listPickerPage.SelectionMode = SelectionMode;
			if (SelectionMode == SelectionMode.Single)
			{
				_listPickerPage.SelectedItem = SelectedItem;
				return;
			}
			_listPickerPage.SelectedItems.Clear();
			if (SelectedItems == null)
			{
				return;
			}
			foreach (object selectedItem in SelectedItems)
			{
				_listPickerPage.SelectedItems.Add(selectedItem);
			}
		}
	}

	private void HandleFrameNavigationStoppedOrFailed(object sender, EventArgs e)
	{
		ListPickerMode = ListPickerMode.Normal;
	}
}
