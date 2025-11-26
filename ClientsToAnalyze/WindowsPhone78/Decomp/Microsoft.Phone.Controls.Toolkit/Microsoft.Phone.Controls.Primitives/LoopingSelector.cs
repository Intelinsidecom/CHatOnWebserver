using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;

namespace Microsoft.Phone.Controls.Primitives;

[TemplatePart(Name = "CenteringTransform", Type = typeof(TranslateTransform))]
[TemplatePart(Name = "PanningTransform", Type = typeof(TranslateTransform))]
[TemplatePart(Name = "ItemsPanel", Type = typeof(Panel))]
public class LoopingSelector : Control
{
	private enum State
	{
		Normal,
		Expanded,
		Dragging,
		Snapping,
		Flicking
	}

	private const string ItemsPanelName = "ItemsPanel";

	private const string CenteringTransformName = "CenteringTransform";

	private const string PanningTransformName = "PanningTransform";

	private const double DragSensitivity = 12.0;

	private static readonly Duration _selectDuration = new Duration(TimeSpan.FromMilliseconds(500.0));

	private readonly IEasingFunction _selectEase = new ExponentialEase
	{
		EasingMode = EasingMode.EaseInOut
	};

	private static readonly Duration _panDuration = new Duration(TimeSpan.FromMilliseconds(100.0));

	private readonly IEasingFunction _panEase = new ExponentialEase();

	private DoubleAnimation _panelAnimation;

	private Storyboard _panelStoryboard;

	private Panel _itemsPanel;

	private TranslateTransform _panningTransform;

	private TranslateTransform _centeringTransform;

	private bool _isSelecting;

	private LoopingSelectorItem _selectedItem;

	private Queue<LoopingSelectorItem> _temporaryItemsPool;

	private double _minimumPanelScroll = -3.4028234663852886E+38;

	private double _maximumPanelScroll = 3.4028234663852886E+38;

	private int _additionalItemsCount;

	private bool _isAnimating;

	private double _dragTarget;

	private bool _isAllowedToDragVertically = true;

	private bool _isDragging;

	private State _state;

	public static readonly DependencyProperty DataSourceProperty = DependencyProperty.Register("DataSource", typeof(ILoopingSelectorDataSource), typeof(LoopingSelector), new PropertyMetadata(null, OnDataModelChanged));

	public static readonly DependencyProperty ItemTemplateProperty = DependencyProperty.Register("ItemTemplate", typeof(DataTemplate), typeof(LoopingSelector), new PropertyMetadata(null));

	public static readonly DependencyProperty IsExpandedProperty = DependencyProperty.Register("IsExpanded", typeof(bool), typeof(LoopingSelector), new PropertyMetadata(false, OnIsExpandedChanged));

	public ILoopingSelectorDataSource DataSource
	{
		get
		{
			return (ILoopingSelectorDataSource)GetValue(DataSourceProperty);
		}
		set
		{
			if (DataSource != null)
			{
				DataSource.SelectionChanged -= value_SelectionChanged;
			}
			SetValue(DataSourceProperty, value);
			if (value != null)
			{
				value.SelectionChanged += value_SelectionChanged;
			}
		}
	}

	public DataTemplate ItemTemplate
	{
		get
		{
			return (DataTemplate)GetValue(ItemTemplateProperty);
		}
		set
		{
			SetValue(ItemTemplateProperty, value);
		}
	}

	public Size ItemSize { get; set; }

	public Thickness ItemMargin { get; set; }

	public bool IsExpanded
	{
		get
		{
			return (bool)GetValue(IsExpandedProperty);
		}
		set
		{
			SetValue(IsExpandedProperty, value);
		}
	}

	private bool IsReady
	{
		get
		{
			if (base.ActualHeight > 0.0 && DataSource != null)
			{
				return _itemsPanel != null;
			}
			return false;
		}
	}

	private double ActualItemWidth => base.Padding.Left + base.Padding.Right + ItemSize.Width;

	private double ActualItemHeight => base.Padding.Top + base.Padding.Bottom + ItemSize.Height;

	public event DependencyPropertyChangedEventHandler IsExpandedChanged;

	private void value_SelectionChanged(object sender, SelectionChangedEventArgs e)
	{
		if (!IsReady || _isSelecting || e.AddedItems.Count != 1)
		{
			return;
		}
		object obj = e.AddedItems[0];
		foreach (LoopingSelectorItem child in _itemsPanel.Children)
		{
			if (child.DataContext == obj)
			{
				SelectAndSnapTo(child);
				return;
			}
		}
		UpdateData();
	}

	private static void OnDataModelChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		LoopingSelector loopingSelector = (LoopingSelector)obj;
		loopingSelector.UpdateData();
	}

	private void DataModel_SelectionChanged(object sender, SelectionChangedEventArgs e)
	{
		if (!IsReady || _isSelecting || e.AddedItems.Count != 1)
		{
			return;
		}
		object obj = e.AddedItems[0];
		foreach (LoopingSelectorItem child in _itemsPanel.Children)
		{
			if (child.DataContext == obj)
			{
				SelectAndSnapTo(child);
				break;
			}
		}
		UpdateData();
	}

	public LoopingSelector()
	{
		base.DefaultStyleKey = typeof(LoopingSelector);
		CreateEventHandlers();
	}

	private static void OnIsExpandedChanged(object sender, DependencyPropertyChangedEventArgs e)
	{
		LoopingSelector loopingSelector = (LoopingSelector)sender;
		loopingSelector.UpdateItemState();
		if (!loopingSelector.IsExpanded)
		{
			loopingSelector.SelectAndSnapToClosest();
		}
		if (loopingSelector._state == State.Normal || loopingSelector._state == State.Expanded)
		{
			loopingSelector._state = (loopingSelector.IsExpanded ? State.Expanded : State.Normal);
		}
		loopingSelector.IsExpandedChanged?.Invoke(loopingSelector, e);
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		_itemsPanel = (GetTemplateChild("ItemsPanel") as Panel) ?? new Canvas();
		_centeringTransform = (GetTemplateChild("CenteringTransform") as TranslateTransform) ?? new TranslateTransform();
		_panningTransform = (GetTemplateChild("PanningTransform") as TranslateTransform) ?? new TranslateTransform();
		CreateVisuals();
	}

	private void LoopingSelector_MouseLeftButtonDown(object sender, MouseButtonEventArgs e)
	{
		if (_isAnimating)
		{
			double y = _panningTransform.Y;
			StopAnimation();
			_panningTransform.Y = y;
			_isAnimating = false;
			_state = State.Dragging;
		}
	}

	private void LoopingSelector_MouseLeftButtonUp(object sender, MouseButtonEventArgs e)
	{
		if (_selectedItem != sender && _state == State.Dragging && !_isAnimating)
		{
			SelectAndSnapToClosest();
			_state = State.Expanded;
		}
	}

	private void OnTap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		if (_panningTransform != null)
		{
			SelectAndSnapToClosest();
			e.Handled = true;
		}
	}

	private void OnManipulationStarted(object sender, ManipulationStartedEventArgs e)
	{
		_isAllowedToDragVertically = true;
		_isDragging = false;
	}

	private void OnManipulationDelta(object sender, ManipulationDeltaEventArgs e)
	{
		if (_isDragging)
		{
			AnimatePanel(_panDuration, _panEase, _dragTarget += e.DeltaManipulation.Translation.Y);
			e.Handled = true;
		}
		else if (Math.Abs(e.CumulativeManipulation.Translation.X) > 12.0)
		{
			_isAllowedToDragVertically = false;
		}
		else if (_isAllowedToDragVertically && Math.Abs(e.CumulativeManipulation.Translation.Y) > 12.0)
		{
			_isDragging = true;
			_state = State.Dragging;
			e.Handled = true;
			_selectedItem = null;
			if (!IsExpanded)
			{
				IsExpanded = true;
			}
			_dragTarget = _panningTransform.Y;
			UpdateItemState();
		}
	}

	private void OnManipulationCompleted(object sender, ManipulationCompletedEventArgs e)
	{
		if (!_isDragging)
		{
			return;
		}
		if (e.IsInertial)
		{
			_state = State.Flicking;
			_selectedItem = null;
			if (!IsExpanded)
			{
				IsExpanded = true;
			}
			Point initialVelocity = new Point(0.0, e.FinalVelocities.LinearVelocity.Y);
			double stopTime = PhysicsConstants.GetStopTime(initialVelocity);
			Point stopPoint = PhysicsConstants.GetStopPoint(initialVelocity);
			IEasingFunction easingFunction = PhysicsConstants.GetEasingFunction(stopTime);
			AnimatePanel(new Duration(TimeSpan.FromSeconds(stopTime)), easingFunction, _panningTransform.Y + stopPoint.Y);
			e.Handled = true;
			_selectedItem = null;
			UpdateItemState();
		}
		if (_state == State.Dragging)
		{
			SelectAndSnapToClosest();
		}
		_state = State.Expanded;
	}

	private void LoopingSelector_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		_centeringTransform.Y = Math.Round(e.NewSize.Height / 2.0);
		base.Clip = new RectangleGeometry
		{
			Rect = new Rect(0.0, 0.0, e.NewSize.Width, e.NewSize.Height)
		};
		UpdateData();
	}

	private void wrapper_Click(object sender, EventArgs e)
	{
		if (_state == State.Normal)
		{
			_state = State.Expanded;
			IsExpanded = true;
		}
		else if (_state == State.Expanded)
		{
			if (!_isAnimating && sender == _selectedItem)
			{
				_state = State.Normal;
				IsExpanded = false;
			}
			else if (sender != _selectedItem && !_isAnimating)
			{
				SelectAndSnapTo((LoopingSelectorItem)sender);
			}
		}
	}

	private void SelectAndSnapTo(LoopingSelectorItem item)
	{
		if (item == null)
		{
			return;
		}
		if (_selectedItem != null)
		{
			_selectedItem.SetState(IsExpanded ? LoopingSelectorItem.State.Expanded : LoopingSelectorItem.State.Normal, useTransitions: true);
		}
		if (_selectedItem != item)
		{
			_selectedItem = item;
			base.Dispatcher.BeginInvoke(delegate
			{
				_isSelecting = true;
				DataSource.SelectedItem = item.DataContext;
				_isSelecting = false;
			});
		}
		_selectedItem.SetState(LoopingSelectorItem.State.Selected, useTransitions: true);
		TranslateTransform transform = item.Transform;
		if (transform != null)
		{
			double num = 0.0 - transform.Y - Math.Round(item.ActualHeight / 2.0);
			if (_panningTransform.Y != num)
			{
				AnimatePanel(_selectDuration, _selectEase, num);
			}
		}
	}

	private void UpdateData()
	{
		if (!IsReady)
		{
			return;
		}
		_temporaryItemsPool = new Queue<LoopingSelectorItem>(_itemsPanel.Children.Count);
		foreach (LoopingSelectorItem child in _itemsPanel.Children)
		{
			if (child.GetState() == LoopingSelectorItem.State.Selected)
			{
				child.SetState(LoopingSelectorItem.State.Normal, useTransitions: false);
			}
			_temporaryItemsPool.Enqueue(child);
			child.Remove();
		}
		_itemsPanel.Children.Clear();
		StopAnimation();
		_panningTransform.Y = 0.0;
		_minimumPanelScroll = -3.4028234663852886E+38;
		_maximumPanelScroll = 3.4028234663852886E+38;
		Balance();
	}

	private void AnimatePanel(Duration duration, IEasingFunction ease, double to)
	{
		double num = Math.Max(_minimumPanelScroll, Math.Min(_maximumPanelScroll, to));
		if (to != num)
		{
			double num2 = Math.Abs(_panningTransform.Y - to);
			double num3 = Math.Abs(_panningTransform.Y - num);
			double num4 = num3 / num2;
			duration = new Duration(TimeSpan.FromMilliseconds((double)duration.TimeSpan.Milliseconds * num4));
			to = num;
		}
		double y = _panningTransform.Y;
		StopAnimation();
		CompositionTarget.Rendering += AnimationPerFrameCallback;
		_panelAnimation.Duration = duration;
		_panelAnimation.EasingFunction = ease;
		_panelAnimation.From = y;
		_panelAnimation.To = to;
		_panelStoryboard.Begin();
		_panelStoryboard.SeekAlignedToLastTick(TimeSpan.Zero);
		_isAnimating = true;
	}

	private void StopAnimation()
	{
		_panelStoryboard.Stop();
		CompositionTarget.Rendering -= AnimationPerFrameCallback;
	}

	private void Brake(double newStoppingPoint)
	{
		double num = _panelAnimation.To.Value - _panelAnimation.From.Value;
		double num2 = newStoppingPoint - _panningTransform.Y;
		double num3 = num2 / num;
		Duration duration = new Duration(TimeSpan.FromMilliseconds((double)_panelAnimation.Duration.TimeSpan.Milliseconds * num3));
		AnimatePanel(duration, _panelAnimation.EasingFunction, newStoppingPoint);
	}

	private void Balance()
	{
		if (!IsReady)
		{
			return;
		}
		double actualItemWidth = ActualItemWidth;
		double actualItemHeight = ActualItemHeight;
		_additionalItemsCount = (int)Math.Round(base.ActualHeight * 1.5 / actualItemHeight);
		LoopingSelectorItem loopingSelectorItem = null;
		int num = -1;
		if (_itemsPanel.Children.Count == 0)
		{
			num = 0;
			loopingSelectorItem = (_selectedItem = CreateAndAddItem(_itemsPanel, DataSource.SelectedItem));
			loopingSelectorItem.Transform.Y = (0.0 - actualItemHeight) / 2.0;
			loopingSelectorItem.Transform.X = (base.ActualWidth - actualItemWidth) / 2.0;
			loopingSelectorItem.SetState(LoopingSelectorItem.State.Selected, useTransitions: false);
		}
		else
		{
			num = GetClosestItem();
			loopingSelectorItem = (LoopingSelectorItem)_itemsPanel.Children[num];
		}
		int i;
		LoopingSelectorItem loopingSelectorItem2 = GetFirstItem(loopingSelectorItem, out i);
		int j;
		LoopingSelectorItem loopingSelectorItem3 = GetLastItem(loopingSelectorItem, out j);
		if (i < j || i < _additionalItemsCount)
		{
			for (; i < _additionalItemsCount; i++)
			{
				object previous = DataSource.GetPrevious(loopingSelectorItem2.DataContext);
				if (previous == null)
				{
					_maximumPanelScroll = 0.0 - loopingSelectorItem2.Transform.Y - actualItemHeight / 2.0;
					if (_isAnimating && _panelAnimation.To.Value > _maximumPanelScroll)
					{
						Brake(_maximumPanelScroll);
					}
					break;
				}
				LoopingSelectorItem loopingSelectorItem4 = null;
				if (j > _additionalItemsCount)
				{
					loopingSelectorItem4 = loopingSelectorItem3;
					loopingSelectorItem3 = loopingSelectorItem3.Previous;
					loopingSelectorItem4.Remove();
					LoopingSelectorItem loopingSelectorItem5 = loopingSelectorItem4;
					object content = (loopingSelectorItem4.DataContext = previous);
					loopingSelectorItem5.Content = content;
				}
				else
				{
					loopingSelectorItem4 = CreateAndAddItem(_itemsPanel, previous);
					loopingSelectorItem4.Transform.X = (base.ActualWidth - actualItemWidth) / 2.0;
				}
				loopingSelectorItem4.Transform.Y = loopingSelectorItem2.Transform.Y - actualItemHeight;
				loopingSelectorItem4.InsertBefore(loopingSelectorItem2);
				loopingSelectorItem2 = loopingSelectorItem4;
			}
		}
		if (j < i || j < _additionalItemsCount)
		{
			for (; j < _additionalItemsCount; j++)
			{
				object next = DataSource.GetNext(loopingSelectorItem3.DataContext);
				if (next == null)
				{
					_minimumPanelScroll = 0.0 - loopingSelectorItem3.Transform.Y - actualItemHeight / 2.0;
					if (_isAnimating && _panelAnimation.To.Value < _minimumPanelScroll)
					{
						Brake(_minimumPanelScroll);
					}
					break;
				}
				LoopingSelectorItem loopingSelectorItem6 = null;
				if (i > _additionalItemsCount)
				{
					loopingSelectorItem6 = loopingSelectorItem2;
					loopingSelectorItem2 = loopingSelectorItem2.Next;
					loopingSelectorItem6.Remove();
					LoopingSelectorItem loopingSelectorItem7 = loopingSelectorItem6;
					object content2 = (loopingSelectorItem6.DataContext = next);
					loopingSelectorItem7.Content = content2;
				}
				else
				{
					loopingSelectorItem6 = CreateAndAddItem(_itemsPanel, next);
					loopingSelectorItem6.Transform.X = (base.ActualWidth - actualItemWidth) / 2.0;
				}
				loopingSelectorItem6.Transform.Y = loopingSelectorItem3.Transform.Y + actualItemHeight;
				loopingSelectorItem6.InsertAfter(loopingSelectorItem3);
				loopingSelectorItem3 = loopingSelectorItem6;
			}
		}
		_temporaryItemsPool = null;
	}

	private static LoopingSelectorItem GetFirstItem(LoopingSelectorItem item, out int count)
	{
		count = 0;
		while (item.Previous != null)
		{
			count++;
			item = item.Previous;
		}
		return item;
	}

	private static LoopingSelectorItem GetLastItem(LoopingSelectorItem item, out int count)
	{
		count = 0;
		while (item.Next != null)
		{
			count++;
			item = item.Next;
		}
		return item;
	}

	private void AnimationPerFrameCallback(object sender, EventArgs e)
	{
		Balance();
	}

	private int GetClosestItem()
	{
		if (!IsReady)
		{
			return -1;
		}
		double actualItemHeight = ActualItemHeight;
		int count = _itemsPanel.Children.Count;
		double y = _panningTransform.Y;
		double num = actualItemHeight / 2.0;
		int result = -1;
		double num2 = double.MaxValue;
		for (int i = 0; i < count; i++)
		{
			LoopingSelectorItem loopingSelectorItem = (LoopingSelectorItem)_itemsPanel.Children[i];
			double num3 = Math.Abs(loopingSelectorItem.Transform.Y + num + y);
			if (num3 <= num)
			{
				result = i;
				break;
			}
			if (num2 > num3)
			{
				num2 = num3;
				result = i;
			}
		}
		return result;
	}

	private void PanelStoryboardCompleted(object sender, EventArgs e)
	{
		CompositionTarget.Rendering -= AnimationPerFrameCallback;
		_isAnimating = false;
		if (_state != State.Dragging)
		{
			SelectAndSnapToClosest();
		}
	}

	private void SelectAndSnapToClosest()
	{
		if (IsReady)
		{
			int closestItem = GetClosestItem();
			if (closestItem != -1)
			{
				LoopingSelectorItem item = (LoopingSelectorItem)_itemsPanel.Children[closestItem];
				SelectAndSnapTo(item);
			}
		}
	}

	private void UpdateItemState()
	{
		if (!IsReady)
		{
			return;
		}
		bool isExpanded = IsExpanded;
		foreach (LoopingSelectorItem child in _itemsPanel.Children)
		{
			if (child == _selectedItem)
			{
				child.SetState(LoopingSelectorItem.State.Selected, useTransitions: true);
			}
			else
			{
				child.SetState(isExpanded ? LoopingSelectorItem.State.Expanded : LoopingSelectorItem.State.Normal, useTransitions: true);
			}
		}
	}

	private void CreateVisuals()
	{
		_panelAnimation = new DoubleAnimation();
		Storyboard.SetTarget(_panelAnimation, _panningTransform);
		Storyboard.SetTargetProperty(_panelAnimation, new PropertyPath("Y"));
		_panelStoryboard = new Storyboard();
		_panelStoryboard.Children.Add(_panelAnimation);
		_panelStoryboard.Completed += PanelStoryboardCompleted;
	}

	private void CreateEventHandlers()
	{
		base.SizeChanged += LoopingSelector_SizeChanged;
		base.ManipulationStarted += OnManipulationStarted;
		base.ManipulationCompleted += OnManipulationCompleted;
		base.ManipulationDelta += OnManipulationDelta;
		base.Tap += OnTap;
		AddHandler(UIElement.MouseLeftButtonDownEvent, new MouseButtonEventHandler(LoopingSelector_MouseLeftButtonDown), handledEventsToo: true);
		AddHandler(UIElement.MouseLeftButtonUpEvent, new MouseButtonEventHandler(LoopingSelector_MouseLeftButtonUp), handledEventsToo: true);
	}

	private LoopingSelectorItem CreateAndAddItem(Panel parent, object content)
	{
		bool flag = _temporaryItemsPool != null && _temporaryItemsPool.Count > 0;
		LoopingSelectorItem loopingSelectorItem = (flag ? _temporaryItemsPool.Dequeue() : new LoopingSelectorItem());
		if (!flag)
		{
			loopingSelectorItem.ContentTemplate = ItemTemplate;
			loopingSelectorItem.Width = ItemSize.Width;
			loopingSelectorItem.Height = ItemSize.Height;
			loopingSelectorItem.Padding = ItemMargin;
			loopingSelectorItem.Click += wrapper_Click;
		}
		object dataContext = (loopingSelectorItem.Content = content);
		loopingSelectorItem.DataContext = dataContext;
		parent.Children.Add(loopingSelectorItem);
		if (!flag)
		{
			loopingSelectorItem.ApplyTemplate();
		}
		return loopingSelectorItem;
	}
}
