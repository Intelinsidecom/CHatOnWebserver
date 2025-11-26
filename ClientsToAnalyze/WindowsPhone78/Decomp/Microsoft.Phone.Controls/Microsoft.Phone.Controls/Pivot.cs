using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Media;
using System.Windows.Media.Animation;
using Microsoft.Phone.Controls.Primitives;
using Microsoft.Phone.Gestures;

namespace Microsoft.Phone.Controls;

[TemplatePart(Name = "PivotItemPresenter", Type = typeof(ItemsPresenter))]
[StyleTypedProperty(Property = "ItemContainerStyle", StyleTargetType = typeof(PivotItem))]
[TemplatePart(Name = "HeadersListElement", Type = typeof(PivotHeadersControl))]
public class Pivot : TemplatedItemsControl<PivotItem>
{
	private const string ElementHeadersRowDefinitionName = "HeadersRowDefinition";

	private const string HeadersListElement = "HeadersListElement";

	private const string PivotItemPresenterElement = "PivotItemPresenter";

	internal const string ItemContainerStyleName = "ItemContainerStyle";

	private const double pixelsPerSecondTemporary = 600.0;

	internal const double PivotAnimationSeconds = 0.25;

	private static readonly TimeSpan PivotAnimationTimeSpan = TimeSpan.FromSeconds(0.25);

	internal static readonly Duration PivotAnimationDuration = new Duration(PivotAnimationTimeSpan);

	internal static readonly Duration ZeroDuration = new Duration(TimeSpan.Zero);

	internal readonly IEasingFunction QuarticEase = new QuarticEase();

	private PivotHeadersControl _headers;

	private ItemsPresenter _itemsPresenter;

	private Panel _itemsPanel;

	private AnimationDirection? _animationHint = null;

	private bool _updatingHeaderItems;

	private bool _ignorePropertyChange;

	internal PivotHeadersControl _clickedHeadersControl;

	private bool _animating;

	private bool _isHorizontalDragging;

	private double _actualWidth;

	private bool _isDesignTime;

	private bool _skippedLoadingPivotItem;

	private bool _skippedSwapVisibleContent;

	private bool _templateApplied;

	private Queue<int> _queuedIndexChanges;

	private TransformAnimator _panAnimator;

	public static readonly DependencyProperty HeaderTemplateProperty = DependencyProperty.Register("HeaderTemplate", typeof(DataTemplate), typeof(Pivot), new PropertyMetadata(null));

	public static readonly DependencyProperty SelectedIndexProperty = DependencyProperty.Register("SelectedIndex", typeof(int), typeof(Pivot), new PropertyMetadata(OnSelectedIndexPropertyChanged));

	public static readonly DependencyProperty SelectedItemProperty = DependencyProperty.Register("SelectedItem", typeof(object), typeof(Pivot), new PropertyMetadata(null, OnSelectedItemPropertyChanged));

	public static readonly DependencyProperty TitleProperty = DependencyProperty.Register("Title", typeof(object), typeof(Pivot), new PropertyMetadata(null));

	public static readonly DependencyProperty TitleTemplateProperty = DependencyProperty.Register("TitleTemplate", typeof(DataTemplate), typeof(Pivot), new PropertyMetadata(null));

	public DataTemplate HeaderTemplate
	{
		get
		{
			return GetValue(HeaderTemplateProperty) as DataTemplate;
		}
		set
		{
			SetValue(HeaderTemplateProperty, value);
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

	public object Title
	{
		get
		{
			return GetValue(TitleProperty);
		}
		set
		{
			SetValue(TitleProperty, value);
		}
	}

	public DataTemplate TitleTemplate
	{
		get
		{
			return GetValue(TitleTemplateProperty) as DataTemplate;
		}
		set
		{
			SetValue(TitleTemplateProperty, value);
		}
	}

	private bool EnoughItemsForManipulation => base.Items.Count > 1;

	public event EventHandler<PivotItemEventArgs> LoadingPivotItem;

	public event EventHandler<PivotItemEventArgs> LoadedPivotItem;

	public event EventHandler<PivotItemEventArgs> UnloadingPivotItem;

	public event EventHandler<PivotItemEventArgs> UnloadedPivotItem;

	public event SelectionChangedEventHandler SelectionChanged;

	private static void OnSelectedIndexPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		Pivot pivot = d as Pivot;
		if (pivot._ignorePropertyChange)
		{
			pivot._ignorePropertyChange = false;
		}
		else
		{
			pivot.UpdateSelectedIndex((int)e.OldValue, (int)e.NewValue);
		}
	}

	private static void OnSelectedItemPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		Pivot pivot = d as Pivot;
		if (pivot._ignorePropertyChange)
		{
			pivot._ignorePropertyChange = false;
		}
		else
		{
			pivot.UpdateSelectedItem(e.OldValue, e.NewValue);
		}
	}

	public Pivot()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PIVOT_STARTUP, PerfLog.Pivot);
		base.DefaultStyleKey = typeof(Pivot);
		base.SizeChanged += OnSizeChanged;
		GestureHelper gestureHelper = GestureHelper.Create(this);
		gestureHelper.GestureStart += OnGestureStart;
		gestureHelper.HorizontalDrag += OnHorizontalDrag;
		gestureHelper.Flick += OnFlick;
		gestureHelper.GestureEnd += OnGesturesComplete;
		_isDesignTime = DesignerProperties.IsInDesignTool;
		_queuedIndexChanges = new Queue<int>(5);
		base.Loaded += Pivot_Loaded;
	}

	private void Pivot_Loaded(object sender, RoutedEventArgs e)
	{
		base.Loaded -= Pivot_Loaded;
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PIVOT_STARTUP, PerfLog.Pivot);
	}

	public override void OnApplyTemplate()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PIVOT_APPLYTEMPLATE, PerfLog.Pivot);
		if (_headers != null)
		{
			_headers.SelectedIndexChanged -= OnHeaderSelectionChanged;
		}
		((FrameworkElement)this).OnApplyTemplate();
		_itemsPresenter = GetTemplateChild("PivotItemPresenter") as ItemsPresenter;
		_headers = GetTemplateChild("HeadersListElement") as PivotHeadersControl;
		if (_headers != null)
		{
			_headers.SelectedIndexChanged += OnHeaderSelectionChanged;
			UpdateHeaders();
		}
		if (base.Items.Count > 0)
		{
			if (SelectedIndex < 0)
			{
				SelectedIndex = 0;
			}
			else
			{
				UpdateSelectedIndex(-1, SelectedIndex);
			}
		}
		UpdateVisibleContent(SelectedIndex);
		SetSelectedHeaderIndex(SelectedIndex);
		_templateApplied = true;
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PIVOT_APPLYTEMPLATE, PerfLog.Pivot);
	}

	protected override Size ArrangeOverride(Size finalSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PIVOT_ARRANGE, PerfLog.Pivot);
		Size result = base.ArrangeOverride(finalSize);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PIVOT_ARRANGE, PerfLog.Pivot);
		return result;
	}

	protected override Size MeasureOverride(Size availableSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PIVOT_MEASURE, PerfLog.Pivot);
		Size result = base.MeasureOverride(availableSize);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PIVOT_MEASURE, PerfLog.Pivot);
		return result;
	}

	protected virtual void OnLoadingPivotItem(PivotItem item)
	{
		if (item != null && item.Visibility == Visibility.Collapsed)
		{
			item.Visibility = Visibility.Visible;
		}
		SafeRaise.Raise(this.LoadingPivotItem, this, () => new PivotItemEventArgs(item));
	}

	protected virtual void OnLoadedPivotItem(PivotItem item)
	{
		SafeRaise.Raise(this.LoadedPivotItem, this, () => new PivotItemEventArgs(item));
		OptimizeVisuals();
	}

	private void OptimizeVisuals()
	{
		int selectedIndex = SelectedIndex;
		if (selectedIndex < 0 || base.Items.Count <= 1)
		{
			return;
		}
		PivotItem next = GetContainer(base.Items[RollingIncrement(selectedIndex)]);
		PivotItem previous = GetContainer(base.Items[RollingDecrement(selectedIndex)]);
		bool flag = true;
		if (next != null && previous != null && next.Visibility == previous.Visibility && previous.Visibility == Visibility.Visible)
		{
			flag = false;
		}
		if (!flag)
		{
			return;
		}
		base.Dispatcher.BeginInvoke(delegate
		{
			if (next != null && next.Visibility == Visibility.Collapsed)
			{
				next.Visibility = Visibility.Visible;
			}
			if (previous != next)
			{
				base.Dispatcher.BeginInvoke(delegate
				{
					if (previous != null && previous.Visibility == Visibility.Collapsed)
					{
						previous.Visibility = Visibility.Visible;
					}
				});
			}
		});
	}

	protected virtual void OnUnloadingPivotItem(PivotItemEventArgs e)
	{
		this.UnloadingPivotItem?.Invoke(this, e);
	}

	protected virtual void OnUnloadedPivotItem(PivotItemEventArgs e)
	{
		this.UnloadedPivotItem?.Invoke(this, e);
	}

	protected override void OnItemsChanged(NotifyCollectionChangedEventArgs e)
	{
		int selectedIndex = SelectedIndex;
		int? num = null;
		int count = base.Items.Count;
		if (e != null)
		{
			switch (e.Action)
			{
			case NotifyCollectionChangedAction.Add:
				if (_templateApplied && e.NewStartingIndex == selectedIndex)
				{
					num = selectedIndex;
				}
				break;
			case NotifyCollectionChangedAction.Remove:
				num = selectedIndex;
				if (selectedIndex == e.OldStartingIndex || selectedIndex >= count)
				{
					num = 0;
				}
				break;
			}
		}
		if (num.HasValue)
		{
			_animationHint = ((!(num < selectedIndex)) ? AnimationDirection.Left : AnimationDirection.Right);
			SetSelectedIndexInternal(num.Value);
		}
		UpdateHeaders();
		OptimizeVisuals();
		base.OnItemsChanged(e);
		UpdateLayout();
	}

	protected override void PrepareContainerForItemOverride(DependencyObject element, object item)
	{
		base.PrepareContainerForItemOverride(element, item);
		PivotItem pivotItem = element as PivotItem;
		int selectedIndex = SelectedIndex;
		if (selectedIndex >= 0 && base.Items.Count > selectedIndex)
		{
			object obj = base.Items[selectedIndex];
			if (item == obj)
			{
				if (pivotItem != null && _skippedLoadingPivotItem)
				{
					OnLoadingPivotItem(pivotItem);
					if (_skippedSwapVisibleContent)
					{
						OnLoadedPivotItem(pivotItem);
					}
				}
				return;
			}
		}
		if (pivotItem != null)
		{
			UpdateItemVisibility(pivotItem, toVisible: false);
			if (pivotItem.Visibility == Visibility.Visible)
			{
				pivotItem.Visibility = Visibility.Collapsed;
			}
		}
	}

	private void UpdateSelectedIndex(int oldIndex, int newIndex)
	{
		object selectedItem = null;
		int count = base.Items.Count;
		if (newIndex >= 0 && newIndex < count)
		{
			selectedItem = base.Items[newIndex];
		}
		else if (count > 0 && !_isDesignTime)
		{
			_ignorePropertyChange = true;
			SelectedIndex = oldIndex;
			throw new ArgumentException("SelectedIndex");
		}
		if (newIndex < 0 && base.Items.Count > 0 && !_isDesignTime)
		{
			_ignorePropertyChange = true;
			SelectedIndex = 0;
			throw new ArgumentException("SelectedIndex");
		}
		SelectedItem = selectedItem;
	}

	private void SetSelectedIndexInternal(int newIndex)
	{
		_ignorePropertyChange = true;
		SelectedIndex = newIndex - 1;
		SelectedIndex = newIndex;
	}

	private void UpdateSelectedItem(object oldValue, object newValue)
	{
		if (newValue == null && base.Items.Count > 0 && !_isDesignTime)
		{
			_ignorePropertyChange = true;
			SelectedItem = oldValue;
			throw new ArgumentException("SelectedItem");
		}
		int num = base.Items.IndexOf(oldValue);
		int num2 = base.Items.IndexOf(newValue);
		if (!_animationHint.HasValue && num != -1 && num2 != -1)
		{
			_animationHint = ((RollingIncrement(num2) != num) ? AnimationDirection.Left : AnimationDirection.Right);
		}
		PivotItem container = GetContainer(newValue);
		PivotItem container2 = GetContainer(oldValue);
		BeginAnimateContent(num2, container2, _animationHint.GetValueOrDefault());
		SetSelectedHeaderIndex(num2);
		if (SelectedIndex != num2)
		{
			SetSelectedIndexInternal(num2);
		}
		if (oldValue != null)
		{
			OnUnloadingPivotItem(new PivotItemEventArgs(container2));
		}
		if (container != null)
		{
			OnLoadingPivotItem(container);
		}
		else
		{
			_skippedLoadingPivotItem = true;
		}
		OnSelectionChanged(new SelectionChangedEventArgs(new List<object> { oldValue }, new List<object> { newValue }));
	}

	private void SetSelectedHeaderIndex(int selectedIndex)
	{
		try
		{
			_updatingHeaderItems = true;
			if (_headers != null && base.Items.Count > 0)
			{
				_headers.SelectedIndex = selectedIndex;
			}
		}
		finally
		{
			_updatingHeaderItems = false;
		}
	}

	private int RollingIncrement(int index)
	{
		index++;
		if (index >= base.Items.Count)
		{
			return 0;
		}
		return index;
	}

	private int RollingDecrement(int index)
	{
		index--;
		if (index >= 0)
		{
			return index;
		}
		return base.Items.Count - 1;
	}

	protected virtual void OnSelectionChanged(SelectionChangedEventArgs e)
	{
		this.SelectionChanged?.Invoke(this, e);
	}

	private void OnGestureStart(object sender, GestureEventArgs e)
	{
		_isHorizontalDragging = false;
		if (_clickedHeadersControl != null)
		{
			_clickedHeadersControl._wasClicked = false;
			_clickedHeadersControl._cancelClick = false;
		}
	}

	private void OnGesturesComplete(object sender, EventArgs e)
	{
		if (EnoughItemsForManipulation)
		{
			if (e is Microsoft.Phone.Gestures.DragEventArgs e2 && _isHorizontalDragging)
			{
				double x = e2.CumulativeDistance.X;
				double num = Math.Abs(x);
				if (x != 0.0 && num >= _actualWidth / 3.0)
				{
					NavigateByIndexChange((x <= 0.0) ? 1 : (-1));
				}
			}
			if (!_animating && _headers != null && _itemsPresenter != null)
			{
				TransformAnimator.EnsureAnimator(_itemsPresenter, ref _panAnimator);
				_panAnimator.GoTo(CalculateContentDestination(AnimationDirection.Center), PivotAnimationDuration, QuarticEase);
				_headers.RestoreHeaderPosition(PivotAnimationDuration);
			}
		}
		_isHorizontalDragging = false;
	}

	private void OnFlick(object sender, FlickEventArgs e)
	{
		if (_clickedHeadersControl != null)
		{
			_clickedHeadersControl._wasClicked = false;
			_clickedHeadersControl._cancelClick = true;
		}
		if (EnoughItemsForManipulation)
		{
			int num = (int)e.Angle;
			if (num == 0 || num == 180)
			{
				NavigateByIndexChange((num == 180) ? 1 : (-1));
			}
		}
	}

	private void OnHorizontalDrag(object sender, Microsoft.Phone.Gestures.DragEventArgs e)
	{
		_isHorizontalDragging = true;
		if (_clickedHeadersControl != null)
		{
			_clickedHeadersControl._cancelClick = true;
		}
		if (!_animating && EnoughItemsForManipulation && _itemsPresenter != null)
		{
			TransformAnimator.EnsureAnimator(_itemsPresenter, ref _panAnimator);
			double num = Math.Abs(e.DeltaDistance.X);
			if (!e.IsTouchComplete && !_animating && _panAnimator != null && _headers != null)
			{
				TimeSpan timeSpan = TimeSpan.FromSeconds(num / 600.0);
				_panAnimator.GoTo(e.CumulativeDistance.X, new Duration(timeSpan));
				_headers.PanHeader(e.CumulativeDistance.X, _actualWidth, new Duration(timeSpan));
			}
		}
	}

	private PivotHeaderItem CreateHeaderBindingControl(object item)
	{
		PivotHeaderItem pivotHeaderItem = new PivotHeaderItem();
		pivotHeaderItem.ContentTemplate = HeaderTemplate;
		PivotHeaderItem pivotHeaderItem2 = pivotHeaderItem;
		Binding binding = new Binding();
		binding.Source = item;
		Binding binding2 = binding;
		if (item is PivotItem)
		{
			binding2.Path = new PropertyPath("Header");
		}
		try
		{
			binding2.Mode = BindingMode.OneWay;
			pivotHeaderItem2.SetBinding(ContentControl.ContentProperty, binding2);
			return pivotHeaderItem2;
		}
		catch
		{
			if (_isDesignTime)
			{
				return null;
			}
			throw;
		}
	}

	private void UpdateHeaders()
	{
		if (_headers != null)
		{
			List<PivotHeaderItem> list = new List<PivotHeaderItem>();
			int count = base.Items.Count;
			for (int i = 0; i < count; i++)
			{
				object item = base.Items[i];
				list.Add(CreateHeaderBindingControl(item));
			}
			try
			{
				_updatingHeaderItems = true;
				_headers.ItemsSource = ((count == 0) ? null : list);
			}
			finally
			{
				_updatingHeaderItems = false;
			}
		}
	}

	private void OnHeaderSelectionChanged(object s, SelectedIndexChangedEventArgs e)
	{
		if (!_updatingHeaderItems)
		{
			_animationHint = AnimationDirection.Left;
			SelectedIndex = e.SelectedIndex;
		}
	}

	private void NavigateByIndexChange(int indexDelta)
	{
		if (_animating && _queuedIndexChanges != null)
		{
			_queuedIndexChanges.Enqueue(indexDelta);
			return;
		}
		int selectedIndex = SelectedIndex;
		if (selectedIndex != -1)
		{
			_animationHint = ((indexDelta > 0) ? AnimationDirection.Left : AnimationDirection.Right);
			selectedIndex += indexDelta;
			if (selectedIndex >= base.Items.Count)
			{
				selectedIndex = 0;
			}
			else if (selectedIndex < 0)
			{
				selectedIndex = base.Items.Count - 1;
			}
			if (_clickedHeadersControl != null)
			{
				_clickedHeadersControl._wasClicked = false;
				_clickedHeadersControl._cancelClick = true;
			}
			SelectedIndex = selectedIndex;
		}
	}

	private int GetPreviousIndex()
	{
		int count = base.Items.Count;
		if (count > 0)
		{
			int num = SelectedIndex - 1;
			if (num < 0)
			{
				num = count - 1;
			}
			return num;
		}
		return 0;
	}

	private int GetNextIndex()
	{
		int count = base.Items.Count;
		if (count > 0)
		{
			int num = SelectedIndex + 1;
			if (num > count)
			{
				num = 0;
			}
			return num;
		}
		return 0;
	}

	private void UpdateVisibleContent(int index)
	{
		if (TryHasItemsHost())
		{
			for (int i = 0; i < _itemsPanel.Children.Count; i++)
			{
				UIElement element = _itemsPanel.Children[i];
				UpdateItemVisibility(element, i == index);
			}
		}
	}

	private bool TryHasItemsHost()
	{
		if (_itemsPanel != null)
		{
			return true;
		}
		if (base.ItemContainerGenerator != null)
		{
			DependencyObject dependencyObject = base.ItemContainerGenerator.ContainerFromIndex(0);
			if (dependencyObject != null)
			{
				_itemsPanel = VisualTreeHelper.GetParent(dependencyObject) as Panel;
				return _itemsPanel != null;
			}
		}
		return false;
	}

	protected virtual void UpdateItemVisibility(UIElement element, bool toVisible)
	{
		if (element == null)
		{
			return;
		}
		element.Opacity = (toVisible ? 1 : 0);
		element.IsHitTestVisible = toVisible;
		if (toVisible && element.Visibility == Visibility.Collapsed)
		{
			element.Visibility = Visibility.Visible;
		}
		if (_isDesignTime)
		{
			TranslateTransform translateTransform = TransformAnimator.GetTranslateTransform(element);
			if (translateTransform != null)
			{
				translateTransform.X = (toVisible ? 0.0 : (0.0 - base.ActualWidth));
			}
		}
	}

	private double CalculateContentDestination(AnimationDirection direction)
	{
		double result = 0.0;
		double actualWidth = base.ActualWidth;
		switch (direction)
		{
		case AnimationDirection.Left:
			result = 0.0 - actualWidth;
			break;
		case AnimationDirection.Right:
			result = actualWidth;
			break;
		}
		return result;
	}

	private static AnimationDirection InvertAnimationDirection(AnimationDirection direction)
	{
		return direction switch
		{
			AnimationDirection.Left => AnimationDirection.Right, 
			AnimationDirection.Right => AnimationDirection.Left, 
			_ => direction, 
		};
	}

	private void BeginAnimateContent(int newIndex, PivotItem oldItem, AnimationDirection animationDirection)
	{
		if (_isDesignTime)
		{
			SwapVisibleContent(oldItem, newIndex);
		}
		else if (_itemsPresenter != null)
		{
			_animating = true;
			TransformAnimator.EnsureAnimator(_itemsPresenter, ref _panAnimator);
			GetContainer(SelectedItem)?.MoveTo(AnimationDirection.Center);
			if (_headers != null && animationDirection != AnimationDirection.Center)
			{
				_headers.AnimationDirection = animationDirection;
			}
			_panAnimator.GoTo(CalculateContentDestination(animationDirection), PivotAnimationDuration, delegate
			{
				_panAnimator.GoTo(CalculateContentDestination(InvertAnimationDirection(animationDirection)), ZeroDuration);
				SwapVisibleContent(oldItem, newIndex);
				GetContainer(SelectedItem)?.MoveTo(animationDirection);
				_panAnimator.GoTo(0.0, PivotAnimationDuration, QuarticEase, delegate
				{
					_animationHint = null;
					_animating = false;
					ProcessQueuedChanges();
				});
			});
		}
		else
		{
			_skippedSwapVisibleContent = true;
		}
	}

	private void SwapVisibleContent(PivotItem oldItem, int newIndex)
	{
		if (oldItem != null)
		{
			OnUnloadedPivotItem(new PivotItemEventArgs(oldItem));
		}
		UpdateVisibleContent(newIndex);
		OnLoadedPivotItem(GetContainer(SelectedItem));
	}

	private void ProcessQueuedChanges()
	{
		if (_queuedIndexChanges != null && _queuedIndexChanges.Count > 0 && !_animating)
		{
			int indexDelta = _queuedIndexChanges.Dequeue();
			NavigateByIndexChange(indexDelta);
		}
	}

	private void OnSizeChanged(object sender, SizeChangedEventArgs e)
	{
		_actualWidth = base.ActualWidth;
		base.Clip = new RectangleGeometry
		{
			Rect = new Rect(0.0, 0.0, _actualWidth, base.ActualHeight)
		};
		if (_isDesignTime)
		{
			UpdateVisibleContent(SelectedIndex);
		}
	}
}
