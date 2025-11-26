using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using Microsoft.Phone.Controls.Primitives;
using Microsoft.Phone.Shell;

namespace Microsoft.Phone.Controls;

[TemplateVisualState(GroupName = "VisibilityStates", Name = "OpenLandscape")]
[TemplateVisualState(GroupName = "VisibilityStates", Name = "OpenReversed")]
[TemplateVisualState(GroupName = "VisibilityStates", Name = "Closed")]
[TemplateVisualState(GroupName = "VisibilityStates", Name = "Open")]
[TemplateVisualState(GroupName = "VisibilityStates", Name = "OpenLandscapeReversed")]
public class ContextMenu : MenuBase
{
	private const double LandscapeWidth = 480.0;

	private const double SystemTrayLandscapeWidth = 72.0;

	private const double ApplicationBarLandscapeWidth = 72.0;

	private const double TotalBorderWidth = 8.0;

	private const string VisibilityGroupName = "VisibilityStates";

	private const string OpenVisibilityStateName = "Open";

	private const string OpenReversedVisibilityStateName = "OpenReversed";

	private const string ClosedVisibilityStateName = "Closed";

	private const string OpenLandscapeVisibilityStateName = "OpenLandscape";

	private const string OpenLandscapeReversedVisibilityStateName = "OpenLandscapeReversed";

	private StackPanel _outerPanel;

	private Grid _innerGrid;

	private PhoneApplicationPage _page;

	private readonly List<ApplicationBarIconButton> _applicationBarIconButtons = new List<ApplicationBarIconButton>();

	private Storyboard _backgroundResizeStoryboard;

	private List<Storyboard> _openingStoryboard;

	private bool _openingStoryboardPlaying;

	private DateTime _openingStoryboardReleaseThreshold;

	private PhoneApplicationFrame _rootVisual;

	private Point _mousePosition;

	private DependencyObject _owner;

	private Popup _popup;

	private Panel _overlay;

	private Point _popupAlignmentPoint;

	private bool _settingIsOpen;

	private bool _reversed;

	public static readonly DependencyProperty IsZoomEnabledProperty = DependencyProperty.Register("IsZoomEnabled", typeof(bool), typeof(ContextMenu), new PropertyMetadata(true));

	public static readonly DependencyProperty IsFadeEnabledProperty = DependencyProperty.Register("IsFadeEnabled", typeof(bool), typeof(ContextMenu), new PropertyMetadata(true));

	public static readonly DependencyProperty VerticalOffsetProperty = DependencyProperty.Register("VerticalOffset", typeof(double), typeof(ContextMenu), new PropertyMetadata(0.0, OnVerticalOffsetChanged));

	public static readonly DependencyProperty IsOpenProperty = DependencyProperty.Register("IsOpen", typeof(bool), typeof(ContextMenu), new PropertyMetadata(false, OnIsOpenChanged));

	public static readonly DependencyProperty RegionOfInterestProperty = DependencyProperty.Register("RegionOfInterest", typeof(Rect?), typeof(ContextMenu), null);

	private static readonly DependencyProperty ApplicationBarMirrorProperty = DependencyProperty.Register("ApplicationBarMirror", typeof(IApplicationBar), typeof(ContextMenu), new PropertyMetadata(OnApplicationBarMirrorChanged));

	internal DependencyObject Owner
	{
		get
		{
			return _owner;
		}
		set
		{
			if (_owner != null && _owner is FrameworkElement frameworkElement)
			{
				frameworkElement.Hold -= HandleOwnerHold;
				frameworkElement.Loaded -= HandleOwnerLoaded;
				frameworkElement.Unloaded -= HandleOwnerUnloaded;
				HandleOwnerUnloaded(null, null);
			}
			_owner = value;
			if (_owner == null || !(_owner is FrameworkElement frameworkElement2))
			{
				return;
			}
			frameworkElement2.Hold += HandleOwnerHold;
			frameworkElement2.Loaded += HandleOwnerLoaded;
			frameworkElement2.Unloaded += HandleOwnerUnloaded;
			DependencyObject dependencyObject = frameworkElement2;
			while (dependencyObject != null)
			{
				dependencyObject = VisualTreeHelper.GetParent(dependencyObject);
				if (dependencyObject != null && (object)dependencyObject == _rootVisual)
				{
					HandleOwnerLoaded(null, null);
					break;
				}
			}
		}
	}

	public bool IsZoomEnabled
	{
		get
		{
			return (bool)GetValue(IsZoomEnabledProperty);
		}
		set
		{
			SetValue(IsZoomEnabledProperty, value);
		}
	}

	public bool IsFadeEnabled
	{
		get
		{
			return (bool)GetValue(IsFadeEnabledProperty);
		}
		set
		{
			SetValue(IsFadeEnabledProperty, value);
		}
	}

	[TypeConverter(typeof(LengthConverter))]
	public double VerticalOffset
	{
		get
		{
			return (double)GetValue(VerticalOffsetProperty);
		}
		set
		{
			SetValue(VerticalOffsetProperty, value);
		}
	}

	public bool IsOpen
	{
		get
		{
			return (bool)GetValue(IsOpenProperty);
		}
		set
		{
			SetValue(IsOpenProperty, value);
		}
	}

	public Rect? RegionOfInterest
	{
		get
		{
			return (Rect?)GetValue(RegionOfInterestProperty);
		}
		set
		{
			SetValue(RegionOfInterestProperty, value);
		}
	}

	public event RoutedEventHandler Opened;

	public event RoutedEventHandler Closed;

	private static void OnVerticalOffsetChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		((ContextMenu)o).UpdateContextMenuPlacement();
	}

	private static void OnIsOpenChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		((ContextMenu)o).OnIsOpenChanged((bool)e.NewValue);
	}

	private void OnIsOpenChanged(bool newValue)
	{
		if (!_settingIsOpen)
		{
			if (newValue)
			{
				OpenPopup(_mousePosition);
			}
			else
			{
				ClosePopup();
			}
		}
	}

	protected virtual void OnOpened(RoutedEventArgs e)
	{
		UpdateContextMenuPlacement();
		SetRenderTransform();
		UpdateVisualStates(useTransitions: true);
		if (this.Opened != null)
		{
			this.Opened(this, e);
		}
	}

	private void SetRenderTransform()
	{
		//IL_000d: Unknown result type (might be due to invalid IL or missing references)
		if (DesignerProperties.IsInDesignTool || _rootVisual.Orientation.IsPortrait())
		{
			double num = 0.5;
			num = _popupAlignmentPoint.X / base.Width;
			if (_outerPanel != null)
			{
				_outerPanel.RenderTransformOrigin = new Point(num, 0.0);
			}
			if (_innerGrid != null)
			{
				double y = (_reversed ? 1 : 0);
				_innerGrid.RenderTransformOrigin = new Point(0.0, y);
			}
		}
		else
		{
			if (_outerPanel != null)
			{
				_outerPanel.RenderTransformOrigin = new Point(0.0, 0.5);
			}
			if (_innerGrid != null)
			{
				double x = (_reversed ? 1 : 0);
				_innerGrid.RenderTransformOrigin = new Point(x, 0.0);
			}
		}
	}

	protected virtual void OnClosed(RoutedEventArgs e)
	{
		UpdateVisualStates(useTransitions: true);
		if (this.Closed != null)
		{
			this.Closed(this, e);
		}
	}

	public ContextMenu()
	{
		base.DefaultStyleKey = typeof(ContextMenu);
		_openingStoryboard = new List<Storyboard>();
		base.LayoutUpdated += HandleLayoutUpdated;
	}

	public override void OnApplyTemplate()
	{
		//IL_01c5: Unknown result type (might be due to invalid IL or missing references)
		if (_openingStoryboard != null)
		{
			foreach (Storyboard item in _openingStoryboard)
			{
				item.Completed -= HandleStoryboardCompleted;
			}
			_openingStoryboard.Clear();
		}
		_openingStoryboardPlaying = false;
		((FrameworkElement)this).OnApplyTemplate();
		SetDefaultStyle();
		if (VisualTreeHelper.GetChild(this, 0) is FrameworkElement obj)
		{
			foreach (VisualStateGroup visualStateGroup in VisualStateManager.GetVisualStateGroups(obj))
			{
				if (!("VisibilityStates" == visualStateGroup.Name))
				{
					continue;
				}
				foreach (VisualState state in visualStateGroup.States)
				{
					if (("Open" == state.Name || "OpenLandscape" == state.Name || "OpenReversed" == state.Name || "OpenLandscapeReversed" == state.Name) && state.Storyboard != null)
					{
						_openingStoryboard.Add(state.Storyboard);
						state.Storyboard.Completed += HandleStoryboardCompleted;
					}
				}
			}
		}
		_outerPanel = GetTemplateChild("OuterPanel") as StackPanel;
		_innerGrid = GetTemplateChild("InnerGrid") as Grid;
		bool flag = DesignerProperties.IsInDesignTool || _rootVisual.Orientation.IsPortrait();
		SetRenderTransform();
		if (IsOpen)
		{
			if (_innerGrid != null)
			{
				_innerGrid.MinHeight = (flag ? 0.0 : ((FrameworkElement)(object)_rootVisual).ActualWidth);
			}
			UpdateVisualStates(useTransitions: true);
		}
	}

	private void SetDefaultStyle()
	{
		SolidColorBrush value;
		SolidColorBrush value2;
		if (DesignerProperties.IsInDesignTool || base.Resources.IsDarkThemeActive())
		{
			value = new SolidColorBrush(Colors.White);
			value2 = new SolidColorBrush(Colors.Black);
		}
		else
		{
			value = new SolidColorBrush(Colors.Black);
			value2 = new SolidColorBrush(Colors.White);
		}
		Style style = new Style(typeof(ContextMenu));
		Setter value3 = new Setter(Control.BackgroundProperty, value);
		Setter value4 = new Setter(Control.BorderBrushProperty, value2);
		if (base.Style == null)
		{
			style.Setters.Add(value3);
			style.Setters.Add(value4);
		}
		else
		{
			bool flag = false;
			bool flag2 = false;
			foreach (Setter setter in base.Style.Setters)
			{
				if (setter.Property == Control.BackgroundProperty)
				{
					flag = true;
				}
				else if (setter.Property == Control.BorderBrushProperty)
				{
					flag2 = true;
				}
				style.Setters.Add(new Setter(setter.Property, setter.Value));
			}
			if (!flag)
			{
				style.Setters.Add(value3);
			}
			if (!flag2)
			{
				style.Setters.Add(value4);
			}
		}
		base.Style = style;
	}

	private void HandleStoryboardCompleted(object sender, EventArgs e)
	{
		_openingStoryboardPlaying = false;
	}

	private void UpdateVisualStates(bool useTransitions)
	{
		//IL_003c: Unknown result type (might be due to invalid IL or missing references)
		string stateName;
		if (IsOpen)
		{
			if (_openingStoryboard != null)
			{
				_openingStoryboardPlaying = true;
				_openingStoryboardReleaseThreshold = DateTime.UtcNow.AddSeconds(0.3);
			}
			if (_rootVisual.Orientation.IsPortrait())
			{
				_outerPanel.Orientation = Orientation.Vertical;
				stateName = (_reversed ? "OpenReversed" : "Open");
			}
			else
			{
				_outerPanel.Orientation = Orientation.Horizontal;
				stateName = (_reversed ? "OpenLandscapeReversed" : "OpenLandscape");
			}
			if (_backgroundResizeStoryboard != null)
			{
				_backgroundResizeStoryboard.Begin();
			}
		}
		else
		{
			stateName = "Closed";
		}
		VisualStateManager.GoToState(this, stateName, useTransitions);
	}

	private bool PositionIsOnScreenRight(double position)
	{
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Invalid comparison between I4 and Unknown
		if (18 != (int)_rootVisual.Orientation)
		{
			return position < ((FrameworkElement)(object)_rootVisual).ActualHeight / 2.0;
		}
		return position > ((FrameworkElement)(object)_rootVisual).ActualHeight / 2.0;
	}

	protected override void OnMouseLeftButtonDown(MouseButtonEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		e.Handled = true;
		base.OnMouseLeftButtonDown(e);
	}

	protected override void OnKeyDown(KeyEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		switch (e.Key)
		{
		case Key.Up:
			FocusNextItem(down: false);
			e.Handled = true;
			break;
		case Key.Down:
			FocusNextItem(down: true);
			e.Handled = true;
			break;
		case Key.Escape:
			ClosePopup();
			e.Handled = true;
			break;
		}
		base.OnKeyDown(e);
	}

	private void HandleLayoutUpdated(object sender, EventArgs e)
	{
		if (Application.Current.RootVisual != null)
		{
			InitializeRootVisual();
			base.LayoutUpdated -= HandleLayoutUpdated;
		}
	}

	private void HandleRootVisualMouseMove(object sender, MouseEventArgs e)
	{
		_mousePosition = e.GetPosition(null);
	}

	private void HandleRootVisualManipulationCompleted(object sender, ManipulationCompletedEventArgs e)
	{
		if (_openingStoryboardPlaying && DateTime.UtcNow <= _openingStoryboardReleaseThreshold)
		{
			IsOpen = false;
		}
	}

	private void HandleOwnerHold(object sender, System.Windows.Input.GestureEventArgs e)
	{
		if (!IsOpen)
		{
			OpenPopup(e.GetPosition(null));
			e.Handled = true;
		}
	}

	private void HandlePopupIgnore(object sender, GestureEventArgs e)
	{
		e.Handled = true;
	}

	private static void OnApplicationBarMirrorChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		//IL_000d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0019: Unknown result type (might be due to invalid IL or missing references)
		//IL_0023: Expected O, but got Unknown
		//IL_0023: Expected O, but got Unknown
		((ContextMenu)o).OnApplicationBarMirrorChanged((IApplicationBar)e.OldValue, (IApplicationBar)e.NewValue);
	}

	private void OnApplicationBarMirrorChanged(IApplicationBar oldValue, IApplicationBar newValue)
	{
		if (oldValue != null)
		{
			oldValue.StateChanged -= HandleEventThatClosesContextMenu;
		}
		if (newValue != null)
		{
			newValue.StateChanged += HandleEventThatClosesContextMenu;
		}
	}

	private void HandleEventThatClosesContextMenu(object sender, EventArgs e)
	{
		IsOpen = false;
	}

	private void HandleOwnerLoaded(object sender, RoutedEventArgs e)
	{
		if (_page != null)
		{
			return;
		}
		InitializeRootVisual();
		if (_rootVisual != null)
		{
			ref PhoneApplicationPage page = ref _page;
			object content = ((ContentControl)(object)_rootVisual).Content;
			page = (PhoneApplicationPage)((content is PhoneApplicationPage) ? content : null);
			if (_page != null)
			{
				_page.BackKeyPress += HandlePageBackKeyPress;
				SetBinding(ApplicationBarMirrorProperty, new Binding
				{
					Source = _page,
					Path = new PropertyPath("ApplicationBar")
				});
			}
		}
	}

	private void HandleOwnerUnloaded(object sender, RoutedEventArgs e)
	{
		if (_rootVisual != null)
		{
			((UIElement)(object)_rootVisual).MouseMove -= HandleRootVisualMouseMove;
			((UIElement)(object)_rootVisual).ManipulationCompleted -= HandleRootVisualManipulationCompleted;
			_rootVisual.OrientationChanged -= HandleEventThatClosesContextMenu;
		}
		if (_page != null)
		{
			_page.BackKeyPress -= HandlePageBackKeyPress;
			ClearValue(ApplicationBarMirrorProperty);
			_page = null;
		}
	}

	private void HandlePageBackKeyPress(object sender, CancelEventArgs e)
	{
		if (IsOpen)
		{
			IsOpen = false;
			e.Cancel = true;
		}
	}

	private static GeneralTransform SafeTransformToVisual(UIElement element, UIElement visual)
	{
		try
		{
			return element.TransformToVisual(visual);
		}
		catch (ArgumentException)
		{
			return new TranslateTransform();
		}
	}

	private void InitializeRootVisual()
	{
		if (_rootVisual == null)
		{
			ref PhoneApplicationFrame rootVisual = ref _rootVisual;
			UIElement rootVisual2 = Application.Current.RootVisual;
			rootVisual = (PhoneApplicationFrame)(object)((rootVisual2 is PhoneApplicationFrame) ? rootVisual2 : null);
			if (_rootVisual != null)
			{
				((UIElement)(object)_rootVisual).MouseMove -= HandleRootVisualMouseMove;
				((UIElement)(object)_rootVisual).MouseMove += HandleRootVisualMouseMove;
				((UIElement)(object)_rootVisual).ManipulationCompleted -= HandleRootVisualManipulationCompleted;
				((UIElement)(object)_rootVisual).ManipulationCompleted += HandleRootVisualManipulationCompleted;
				_rootVisual.OrientationChanged -= HandleEventThatClosesContextMenu;
				_rootVisual.OrientationChanged += HandleEventThatClosesContextMenu;
			}
		}
	}

	private void FocusNextItem(bool down)
	{
		int count = base.Items.Count;
		int num = (down ? (-1) : count);
		if (FocusManager.GetFocusedElement() is MenuItem menuItem && this == menuItem.ParentMenuBase)
		{
			num = base.ItemContainerGenerator.IndexFromContainer(menuItem);
		}
		int num2 = num;
		do
		{
			num2 = (num2 + count + (down ? 1 : (-1))) % count;
		}
		while ((!(base.ItemContainerGenerator.ContainerFromIndex(num2) is MenuItem { IsEnabled: not false } menuItem2) || !menuItem2.Focus()) && num2 != num);
	}

	internal void ChildMenuItemClicked()
	{
		ClosePopup();
	}

	private void HandleContextMenuOrRootVisualSizeChanged(object sender, SizeChangedEventArgs e)
	{
		UpdateContextMenuPlacement();
	}

	private void HandleOverlayMouseButtonUp(object sender, MouseButtonEventArgs e)
	{
		List<UIElement> list = VisualTreeHelper.FindElementsInHostCoordinates(e.GetPosition(null), (UIElement)(object)_rootVisual) as List<UIElement>;
		if (!list.Contains(this))
		{
			ClosePopup();
		}
		e.Handled = true;
	}

	private void UpdateContextMenuPlacement()
	{
		//IL_0039: Unknown result type (might be due to invalid IL or missing references)
		if (_rootVisual == null || _overlay == null)
		{
			return;
		}
		Point point = new Point(_popupAlignmentPoint.X, _popupAlignmentPoint.Y);
		bool flag = _rootVisual.Orientation.IsPortrait();
		double width = (flag ? ((FrameworkElement)(object)_rootVisual).ActualWidth : ((FrameworkElement)(object)_rootVisual).ActualHeight);
		double height = (flag ? ((FrameworkElement)(object)_rootVisual).ActualHeight : ((FrameworkElement)(object)_rootVisual).ActualWidth);
		Rect rect = new Rect(0.0, 0.0, width, height);
		if (_page != null)
		{
			rect = SafeTransformToVisual((UIElement)(object)_page, (UIElement)(object)_rootVisual).TransformBounds(new Rect(0.0, 0.0, ((FrameworkElement)(object)_page).ActualWidth, ((FrameworkElement)(object)_page).ActualHeight));
		}
		if (flag && _rootVisual != null)
		{
			double y;
			double num;
			if (RegionOfInterest.HasValue)
			{
				y = RegionOfInterest.Value.Y;
				num = RegionOfInterest.Value.Height;
			}
			else if (Owner is FrameworkElement)
			{
				FrameworkElement frameworkElement = (FrameworkElement)Owner;
				GeneralTransform generalTransform = frameworkElement.TransformToVisual((UIElement)(object)_rootVisual);
				y = generalTransform.Transform(new Point(0.0, 0.0)).Y;
				num = frameworkElement.ActualHeight;
			}
			else
			{
				y = _popupAlignmentPoint.Y;
				num = 0.0;
			}
			point.Y = y + num;
			_reversed = false;
			if (point.Y > rect.Bottom - base.ActualHeight)
			{
				point.Y = y - base.ActualHeight;
				_reversed = true;
				if (point.Y < rect.Top)
				{
					point = _popupAlignmentPoint;
					_reversed = false;
					if (point.Y > rect.Bottom - base.ActualHeight)
					{
						_reversed = true;
						if (point.Y < rect.Top)
						{
							point.Y = rect.Bottom - base.ActualHeight;
							_reversed = true;
						}
					}
				}
			}
		}
		double x = point.X;
		double y2 = point.Y;
		y2 += VerticalOffset;
		if (flag)
		{
			x = rect.Left;
			base.Width = rect.Width;
			if (_innerGrid != null)
			{
				_innerGrid.Width = base.Width;
			}
		}
		else
		{
			if (PositionIsOnScreenRight(y2))
			{
				base.Width = (SystemTray.IsVisible ? 408.0 : 480.0);
				x = (SystemTray.IsVisible ? 72.0 : 0.0);
				_reversed = true;
			}
			else
			{
				base.Width = ((_page.ApplicationBar != null && _page.ApplicationBar.IsVisible) ? 408.0 : 480.0);
				x = rect.Width - base.Width + (SystemTray.IsVisible ? 72.0 : 0.0);
				_reversed = false;
			}
			if (_innerGrid != null)
			{
				_innerGrid.Width = base.Width - 8.0;
			}
			y2 = 0.0;
		}
		x = Math.Max(x, 0.0);
		Canvas.SetLeft(this, x);
		Canvas.SetTop(this, y2);
		_overlay.Width = width;
		_overlay.Height = height;
	}

	private void OpenPopup(Point position)
	{
		//IL_0013: Unknown result type (might be due to invalid IL or missing references)
		//IL_05bc: Unknown result type (might be due to invalid IL or missing references)
		//IL_05c1: Unknown result type (might be due to invalid IL or missing references)
		//IL_05c3: Unknown result type (might be due to invalid IL or missing references)
		//IL_05c7: Invalid comparison between Unknown and I4
		//IL_05c9: Unknown result type (might be due to invalid IL or missing references)
		//IL_05cd: Invalid comparison between Unknown and I4
		_popupAlignmentPoint = position;
		InitializeRootVisual();
		bool flag = _rootVisual.Orientation.IsPortrait();
		if (flag)
		{
			if (_innerGrid != null)
			{
				_innerGrid.MinHeight = 0.0;
			}
		}
		else if (_innerGrid != null)
		{
			_innerGrid.MinHeight = ((FrameworkElement)(object)_rootVisual).ActualWidth;
		}
		_overlay = new Canvas
		{
			Background = new SolidColorBrush(Colors.Transparent)
		};
		_overlay.MouseLeftButtonUp += HandleOverlayMouseButtonUp;
		GestureListener gestureListener = GestureService.GetGestureListener(_overlay);
		gestureListener.DoubleTap += HandlePopupIgnore;
		gestureListener.DragStarted += HandlePopupIgnore;
		gestureListener.DragDelta += HandlePopupIgnore;
		gestureListener.DragCompleted += HandlePopupIgnore;
		gestureListener.Flick += HandlePopupIgnore;
		gestureListener.Hold += HandlePopupIgnore;
		gestureListener.PinchStarted += HandlePopupIgnore;
		gestureListener.PinchDelta += HandlePopupIgnore;
		gestureListener.PinchCompleted += HandlePopupIgnore;
		gestureListener.Tap += HandlePopupIgnore;
		if (IsZoomEnabled && _rootVisual != null)
		{
			double num = (flag ? ((FrameworkElement)(object)_rootVisual).ActualWidth : ((FrameworkElement)(object)_rootVisual).ActualHeight);
			double num2 = (flag ? ((FrameworkElement)(object)_rootVisual).ActualHeight : ((FrameworkElement)(object)_rootVisual).ActualWidth);
			Rectangle rectangle = new Rectangle();
			rectangle.Width = num;
			rectangle.Height = num2;
			rectangle.Fill = (Brush)Application.Current.Resources["PhoneBackgroundBrush"];
			rectangle.CacheMode = new BitmapCache();
			UIElement value = rectangle;
			_overlay.Children.Insert(0, value);
			FrameworkElement frameworkElement = _owner as FrameworkElement;
			if (frameworkElement != null)
			{
				frameworkElement.Opacity = 0.0;
			}
			WriteableBitmap writeableBitmap = new WriteableBitmap((int)num, (int)num2);
			writeableBitmap.Render((UIElement)(object)_rootVisual, null);
			writeableBitmap.Invalidate();
			ScaleTransform scaleTransform = new ScaleTransform();
			scaleTransform.CenterX = num / 2.0;
			scaleTransform.CenterY = num2 / 2.0;
			Transform transform = scaleTransform;
			Image image = new Image();
			image.Source = writeableBitmap;
			image.RenderTransform = transform;
			image.CacheMode = new BitmapCache();
			UIElement value2 = image;
			_overlay.Children.Insert(1, value2);
			Rectangle rectangle2 = new Rectangle();
			rectangle2.Width = num;
			rectangle2.Height = num2;
			rectangle2.Fill = (Brush)Application.Current.Resources["PhoneBackgroundBrush"];
			rectangle2.Opacity = 0.0;
			rectangle2.CacheMode = new BitmapCache();
			UIElement uIElement = rectangle2;
			_overlay.Children.Insert(2, uIElement);
			if (frameworkElement != null)
			{
				((FrameworkElement)Owner).Opacity = 1.0;
				Point point = SafeTransformToVisual(frameworkElement, (UIElement)(object)_rootVisual).Transform(default(Point));
				Rectangle rectangle3 = new Rectangle();
				rectangle3.Width = frameworkElement.ActualWidth;
				rectangle3.Height = frameworkElement.ActualHeight;
				rectangle3.Fill = new SolidColorBrush(Colors.Transparent);
				rectangle3.CacheMode = new BitmapCache();
				UIElement uIElement2 = rectangle3;
				Canvas.SetLeft(uIElement2, point.X);
				Canvas.SetTop(uIElement2, point.Y);
				_overlay.Children.Insert(3, uIElement2);
				Image image2 = new Image();
				image2.Source = new WriteableBitmap(frameworkElement, null);
				UIElement uIElement3 = image2;
				Canvas.SetLeft(uIElement3, point.X);
				Canvas.SetTop(uIElement3, point.Y);
				_overlay.Children.Insert(4, uIElement3);
			}
			double value3 = 1.0;
			double value4 = 0.94;
			TimeSpan timeSpan = TimeSpan.FromSeconds(0.42);
			ExponentialEase exponentialEase = new ExponentialEase();
			exponentialEase.EasingMode = EasingMode.EaseInOut;
			IEasingFunction easingFunction = exponentialEase;
			_backgroundResizeStoryboard = new Storyboard();
			DoubleAnimation doubleAnimation = new DoubleAnimation();
			doubleAnimation.From = value3;
			doubleAnimation.To = value4;
			doubleAnimation.Duration = timeSpan;
			doubleAnimation.EasingFunction = easingFunction;
			DoubleAnimation doubleAnimation2 = doubleAnimation;
			Storyboard.SetTarget(doubleAnimation2, transform);
			Storyboard.SetTargetProperty(doubleAnimation2, new PropertyPath(ScaleTransform.ScaleXProperty));
			_backgroundResizeStoryboard.Children.Add(doubleAnimation2);
			DoubleAnimation doubleAnimation3 = new DoubleAnimation();
			doubleAnimation3.From = value3;
			doubleAnimation3.To = value4;
			doubleAnimation3.Duration = timeSpan;
			doubleAnimation3.EasingFunction = easingFunction;
			DoubleAnimation doubleAnimation4 = doubleAnimation3;
			Storyboard.SetTarget(doubleAnimation4, transform);
			Storyboard.SetTargetProperty(doubleAnimation4, new PropertyPath(ScaleTransform.ScaleYProperty));
			_backgroundResizeStoryboard.Children.Add(doubleAnimation4);
			if (IsFadeEnabled)
			{
				DoubleAnimation doubleAnimation5 = new DoubleAnimation();
				doubleAnimation5.From = 0.0;
				doubleAnimation5.To = 0.3;
				doubleAnimation5.Duration = timeSpan;
				doubleAnimation5.EasingFunction = easingFunction;
				DoubleAnimation doubleAnimation6 = doubleAnimation5;
				Storyboard.SetTarget(doubleAnimation6, uIElement);
				Storyboard.SetTargetProperty(doubleAnimation6, new PropertyPath(UIElement.OpacityProperty));
				_backgroundResizeStoryboard.Children.Add(doubleAnimation6);
			}
		}
		TransformGroup transformGroup = new TransformGroup();
		if (_rootVisual != null)
		{
			PageOrientation orientation = _rootVisual.Orientation;
			if ((int)orientation != 18)
			{
				if ((int)orientation == 34)
				{
					transformGroup.Children.Add(new RotateTransform
					{
						Angle = -90.0
					});
					transformGroup.Children.Add(new TranslateTransform
					{
						Y = ((FrameworkElement)(object)_rootVisual).ActualHeight
					});
				}
			}
			else
			{
				transformGroup.Children.Add(new RotateTransform
				{
					Angle = 90.0
				});
				transformGroup.Children.Add(new TranslateTransform
				{
					X = ((FrameworkElement)(object)_rootVisual).ActualWidth
				});
			}
		}
		_overlay.RenderTransform = transformGroup;
		if (_page != null && _page.ApplicationBar != null && _page.ApplicationBar.Buttons != null)
		{
			foreach (object button in _page.ApplicationBar.Buttons)
			{
				ApplicationBarIconButton val = (ApplicationBarIconButton)((button is ApplicationBarIconButton) ? button : null);
				if (val != null)
				{
					val.Click += HandleEventThatClosesContextMenu;
					_applicationBarIconButtons.Add(val);
				}
			}
		}
		_overlay.Children.Add(this);
		_popup = new Popup
		{
			Child = _overlay
		};
		gestureListener = GestureService.GetGestureListener(this);
		gestureListener.DoubleTap += HandlePopupIgnore;
		gestureListener.DragStarted += HandlePopupIgnore;
		gestureListener.DragDelta += HandlePopupIgnore;
		gestureListener.DragCompleted += HandlePopupIgnore;
		gestureListener.Flick += HandlePopupIgnore;
		gestureListener.Hold += HandlePopupIgnore;
		gestureListener.PinchStarted += HandlePopupIgnore;
		gestureListener.PinchDelta += HandlePopupIgnore;
		gestureListener.PinchCompleted += HandlePopupIgnore;
		gestureListener.Tap += HandlePopupIgnore;
		_popup.Opened += delegate
		{
			OnOpened(new RoutedEventArgs());
		};
		base.SizeChanged += HandleContextMenuOrRootVisualSizeChanged;
		if (_rootVisual != null)
		{
			((FrameworkElement)(object)_rootVisual).SizeChanged += HandleContextMenuOrRootVisualSizeChanged;
		}
		UpdateContextMenuPlacement();
		if (ReadLocalValue(FrameworkElement.DataContextProperty) == DependencyProperty.UnsetValue)
		{
			DependencyObject source = (DependencyObject)(((object)Owner) ?? ((object)_rootVisual));
			SetBinding(FrameworkElement.DataContextProperty, new Binding("DataContext")
			{
				Source = source
			});
		}
		_popup.IsOpen = true;
		Focus();
		_settingIsOpen = true;
		IsOpen = true;
		_settingIsOpen = false;
	}

	private void ClosePopup()
	{
		if (_backgroundResizeStoryboard != null)
		{
			foreach (DoubleAnimation child in _backgroundResizeStoryboard.Children)
			{
				double value = child.From.Value;
				child.From = child.To;
				child.To = value;
			}
			Popup popup = _popup;
			Panel overlay = _overlay;
			_backgroundResizeStoryboard.Completed += delegate
			{
				if (popup != null)
				{
					popup.IsOpen = false;
					popup.Child = null;
				}
				if (overlay != null)
				{
					overlay.Children.Clear();
				}
			};
			_backgroundResizeStoryboard.Begin();
			_backgroundResizeStoryboard = null;
			_popup = null;
			_overlay = null;
		}
		else
		{
			if (_popup != null)
			{
				_popup.IsOpen = false;
				_popup.Child = null;
				_popup = null;
			}
			if (_overlay != null)
			{
				_overlay.Children.Clear();
				_overlay = null;
			}
		}
		base.SizeChanged -= HandleContextMenuOrRootVisualSizeChanged;
		if (_rootVisual != null)
		{
			((FrameworkElement)(object)_rootVisual).SizeChanged -= HandleContextMenuOrRootVisualSizeChanged;
		}
		foreach (ApplicationBarIconButton applicationBarIconButton in _applicationBarIconButtons)
		{
			applicationBarIconButton.Click -= HandleEventThatClosesContextMenu;
		}
		_applicationBarIconButtons.Clear();
		_settingIsOpen = true;
		IsOpen = false;
		_settingIsOpen = false;
		OnClosed(new RoutedEventArgs());
	}
}
