using System;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using Microsoft.Phone.Controls.Primitives;
using Microsoft.Phone.Gestures;

namespace Microsoft.Phone.Controls;

[StyleTypedProperty(Property = "ItemContainerStyle", StyleTargetType = typeof(PanoramaItem))]
[TemplatePart(Name = "TitleLayer", Type = typeof(PanningLayer))]
[TemplatePart(Name = "BackgroundLayer", Type = typeof(PanningLayer))]
[TemplatePart(Name = "ItemsLayer", Type = typeof(PanningLayer))]
public class Panorama : TemplatedItemsControl<PanoramaItem>
{
	internal const int Spacing = 48;

	internal const double PanningOpacity = 0.7;

	private const string BackgroundLayerElement = "BackgroundLayer";

	private const string TitleLayerElement = "TitleLayer";

	private const string ItemsLayerElement = "ItemsLayer";

	internal static readonly Duration Immediately = new Duration(TimeSpan.Zero);

	private static readonly Duration DefaultDuration = new Duration(TimeSpan.FromMilliseconds(800.0));

	private static readonly Duration EntranceDuration = DefaultDuration;

	private static readonly Duration FlickDuration = DefaultDuration;

	private static readonly Duration SnapDuration = DefaultDuration;

	private static readonly Duration PanDuration = new Duration(TimeSpan.FromMilliseconds(150.0));

	private int _cumulativeDragDelta;

	private int _flickDirection;

	private int _targetOffset;

	private bool _dragged;

	private int _frameCount;

	private bool _updateBackgroundPending = true;

	private bool _entranceAnimationPlayed;

	private PanningLayer _panningBackground;

	private PanningLayer _panningTitle;

	private PanningLayer _panningItems;

	private bool _adjustSelectedRequested;

	private bool _suppressSelectionChangedEvent;

	private bool _loaded;

	private float previousBackgroundWidth;

	public static readonly DependencyProperty TitleProperty = DependencyProperty.Register("Title", typeof(object), typeof(Panorama), null);

	public static readonly DependencyProperty TitleTemplateProperty = DependencyProperty.Register("TitleTemplate", typeof(DataTemplate), typeof(Panorama), null);

	public static readonly DependencyProperty HeaderTemplateProperty = DependencyProperty.Register("HeaderTemplate", typeof(DataTemplate), typeof(Panorama), null);

	public static readonly DependencyProperty SelectedItemProperty = DependencyProperty.Register("SelectedItem", typeof(object), typeof(Panorama), new PropertyMetadata(null, OnSelectionChanged));

	public static readonly DependencyProperty SelectedIndexProperty = DependencyProperty.Register("SelectedIndex", typeof(int), typeof(Panorama), new PropertyMetadata(-1));

	public static readonly DependencyProperty DefaultItemProperty = DependencyProperty.Register("DefaultItem", typeof(object), typeof(Panorama), new PropertyMetadata(null, OnDefaultItemChanged));

	private static readonly DependencyProperty BackgroundShadowProperty = DependencyProperty.Register("BackgroundShadow", typeof(Brush), typeof(Panorama), new PropertyMetadata(null, OnBackgroundShadowChanged));

	internal PanoramaPanel Panel { get; set; }

	internal int ItemsWidth { get; set; }

	internal int ViewportWidth { get; private set; }

	internal int ViewportHeight { get; private set; }

	internal int AdjustedViewportWidth => Math.Max(0, ViewportWidth - 48);

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
			return (DataTemplate)GetValue(TitleTemplateProperty);
		}
		set
		{
			SetValue(TitleTemplateProperty, value);
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

	public object SelectedItem
	{
		get
		{
			return GetValue(SelectedItemProperty);
		}
		private set
		{
			SetValue(SelectedItemProperty, value);
		}
	}

	public int SelectedIndex
	{
		get
		{
			return (int)GetValue(SelectedIndexProperty);
		}
		private set
		{
			SetValue(SelectedIndexProperty, value);
		}
	}

	public object DefaultItem
	{
		get
		{
			return GetValue(DefaultItemProperty);
		}
		set
		{
			SetValue(DefaultItemProperty, value);
			OnDefaultItemSet();
		}
	}

	public event EventHandler<SelectionChangedEventArgs> SelectionChanged;

	internal PanoramaItem GetDefaultItemContainer()
	{
		return GetContainer(DefaultItem);
	}

	public Panorama()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_STARTUP, PerfLog.Panorama);
		base.DefaultStyleKey = typeof(Panorama);
		GestureHelper gestureHelper = GestureHelper.Create(this, shouldHandleAllDrags: true);
		EventHandler<GestureEventArgs> value = delegate(object sender, GestureEventArgs args)
		{
			GestureStart(args);
		};
		gestureHelper.GestureStart += value;
		gestureHelper.HorizontalDrag += delegate(object sender, Microsoft.Phone.Gestures.DragEventArgs args)
		{
			HorizontalDrag(args);
		};
		gestureHelper.Flick += delegate(object sender, FlickEventArgs args)
		{
			Flick(args);
		};
		gestureHelper.GestureEnd += delegate
		{
			GestureEnd();
		};
		base.SizeChanged += OnSizeChanged;
		if (DesignerProperties.IsInDesignTool)
		{
			base.Loaded += OnLoaded;
			base.Unloaded += OnUnloaded;
		}
		else
		{
			CompositionTarget.Rendering += EntranceAnimationCallback;
		}
		base.Loaded += Panorama_Loaded;
	}

	private void Panorama_Loaded(object sender, RoutedEventArgs e)
	{
		base.Loaded -= Panorama_Loaded;
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_STARTUP, PerfLog.Panorama);
	}

	private void OnLoaded(object sender, RoutedEventArgs e)
	{
		_loaded = true;
	}

	private void OnUnloaded(object sender, RoutedEventArgs e)
	{
		_loaded = false;
	}

	public override void OnApplyTemplate()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_APPLYTEMPLATE, PerfLog.Panorama);
		((FrameworkElement)this).OnApplyTemplate();
		_panningBackground = GetTemplateChild("BackgroundLayer") as PanningLayer;
		_panningTitle = GetTemplateChild("TitleLayer") as PanningLayer;
		_panningItems = GetTemplateChild("ItemsLayer") as PanningLayer;
		if (_panningBackground != null)
		{
			_panningBackground.Owner = this;
		}
		if (_panningTitle != null)
		{
			_panningTitle.Owner = this;
		}
		if (_panningItems != null)
		{
			_panningItems.Owner = this;
		}
		Binding binding = new Binding("Background");
		binding.RelativeSource = new RelativeSource(RelativeSourceMode.Self);
		SetBinding(BackgroundShadowProperty, binding);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_APPLYTEMPLATE, PerfLog.Panorama);
	}

	protected override Size MeasureOverride(Size availableSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_MEASURE, PerfLog.Panorama);
		if (Application.Current.Host.Content.ActualWidth > 0.0)
		{
			ViewportWidth = (int)((!double.IsInfinity(availableSize.Width)) ? availableSize.Width : Application.Current.Host.Content.ActualWidth);
			ViewportHeight = (int)((!double.IsInfinity(availableSize.Height)) ? availableSize.Height : Application.Current.Host.Content.ActualHeight);
		}
		else
		{
			ViewportWidth = (int)Math.Min(availableSize.Width, 480.0);
			ViewportHeight = (int)Math.Min(availableSize.Height, 800.0);
		}
		base.MeasureOverride(new Size(double.PositiveInfinity, ViewportHeight));
		if (double.IsInfinity(availableSize.Width))
		{
			availableSize.Width = ViewportWidth;
		}
		if (double.IsInfinity(availableSize.Height))
		{
			availableSize.Height = ViewportHeight;
		}
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_MEASURE, PerfLog.Panorama);
		return availableSize;
	}

	protected override void OnItemsChanged(NotifyCollectionChangedEventArgs e)
	{
		base.OnItemsChanged(e);
		if (Panel != null)
		{
			Panel.ResetItemPositions();
		}
		RequestAdjustSelection();
	}

	internal void RequestAdjustSelection()
	{
		if (!_adjustSelectedRequested)
		{
			base.LayoutUpdated += LayoutUpdatedAdjustSelection;
			_adjustSelectedRequested = true;
		}
	}

	private void LayoutUpdatedAdjustSelection(object sender, EventArgs e)
	{
		_adjustSelectedRequested = false;
		base.LayoutUpdated -= LayoutUpdatedAdjustSelection;
		AdjustSelection();
	}

	private void AdjustSelection()
	{
		if (DesignerProperties.IsInDesignTool)
		{
			if (_loaded)
			{
				_targetOffset = 0;
				GoTo(_targetOffset, Immediately);
			}
			return;
		}
		object selectedItem = SelectedItem;
		object obj = null;
		bool flag = false;
		bool flag2 = false;
		if (Panel != null && Panel.VisibleChildren.Count > 0)
		{
			if (selectedItem == null)
			{
				obj = GetItem(Panel.VisibleChildren[0]);
			}
			else
			{
				PanoramaItem container = GetContainer(selectedItem);
				flag2 = _entranceAnimationPlayed;
				obj = ((container != null && Panel.VisibleChildren.Contains(container)) ? selectedItem : GetItem(Panel.VisibleChildren[0]));
			}
		}
		else
		{
			_targetOffset = 0;
			GoTo(_targetOffset, Immediately);
		}
		if (flag)
		{
			SelectedItem = obj;
		}
		else
		{
			SetSelectionInternal(obj);
		}
		UpdateItemPositions();
		if (flag2)
		{
			PanoramaItem container2 = GetContainer(obj);
			if (container2 != null)
			{
				_targetOffset = -container2.StartPosition;
				GoTo(_targetOffset, Immediately);
			}
		}
	}

	private void UpdateItemPositions()
	{
		bool flag = true;
		if (Panel == null)
		{
			return;
		}
		if (Panel.VisibleChildren.Count > 2 && SelectedItem != null)
		{
			PanoramaItem container = GetContainer(SelectedItem);
			if (container != null)
			{
				int num = Panel.VisibleChildren.IndexOf(container);
				if (num == Panel.VisibleChildren.Count - 1)
				{
					Panel.ShowFirstItemOnRight();
					flag = false;
				}
				else if (num == 0)
				{
					Panel.ShowLastItemOnLeft();
					flag = false;
				}
			}
		}
		if (flag)
		{
			Panel.ResetItemPositions();
		}
	}

	protected override Size ArrangeOverride(Size finalSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_ARRANGE, PerfLog.Panorama);
		Size size = finalSize;
		size.Width = base.DesiredSize.Width;
		base.ArrangeOverride(finalSize);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_ARRANGE, PerfLog.Panorama);
		return finalSize;
	}

	protected override void PrepareContainerForItemOverride(DependencyObject element, object item)
	{
		base.PrepareContainerForItemOverride(element, item);
		if (element is PanoramaItem panoramaItem)
		{
			if (panoramaItem.Content == null && panoramaItem != item)
			{
				panoramaItem.Content = item;
			}
			if (panoramaItem.HeaderTemplate == null && element.ReadLocalValue(PanoramaItem.HeaderTemplateProperty) == DependencyProperty.UnsetValue)
			{
				panoramaItem.HeaderTemplate = HeaderTemplate;
			}
			if (panoramaItem.Header == null && !(item is UIElement) && panoramaItem.ReadLocalValue(PanoramaItem.HeaderProperty) == DependencyProperty.UnsetValue)
			{
				panoramaItem.Header = item;
			}
		}
	}

	private void GestureStart(GestureEventArgs args)
	{
		_targetOffset = (int)_panningItems.ActualOffset;
		_flickDirection = 0;
		_cumulativeDragDelta = 0;
		_dragged = false;
	}

	private void HorizontalDrag(Microsoft.Phone.Gestures.DragEventArgs args)
	{
		if (_flickDirection == 0)
		{
			_cumulativeDragDelta = (int)args.CumulativeDistance.X;
			_targetOffset += (int)args.DeltaDistance.X;
			if (Math.Abs(_cumulativeDragDelta) <= ViewportWidth)
			{
				_dragged = true;
				GoTo(_targetOffset, PanDuration);
			}
		}
	}

	private void Flick(FlickEventArgs e)
	{
		if (e.Angle == 180.0)
		{
			_flickDirection = -1;
		}
		else if (e.Angle == 0.0)
		{
			_flickDirection = 1;
		}
	}

	private void GestureEnd()
	{
		if (_flickDirection == 0)
		{
			if (_dragged)
			{
				Panel.GetSnapOffset(_targetOffset, ViewportWidth, Math.Sign(_cumulativeDragDelta), out var snapTo, out var _, out var newSelection, out var wraparound);
				if (wraparound)
				{
					WrapAround(Math.Sign(_cumulativeDragDelta));
				}
				object item = GetItem(newSelection);
				if (item != null)
				{
					SelectedItem = item;
				}
				UpdateItemPositions();
				GoTo(snapTo, SnapDuration, delegate
				{
					_panningItems.Refresh();
				});
			}
		}
		else
		{
			ProcessFlick();
		}
	}

	private void ProcessFlick()
	{
		if (_flickDirection == 0)
		{
			return;
		}
		int offset = (int)_panningItems.ActualOffset;
		Panel.GetStops(offset, ItemsWidth, out var previous, out var current, out var next);
		if (previous != current || current != next || next != null)
		{
			_targetOffset = ((_flickDirection < 0) ? (-next.Position) : (-previous.Position));
			if (Math.Sign((double)_targetOffset - _panningItems.ActualOffset) != Math.Sign(_flickDirection))
			{
				WrapAround(Math.Sign(_flickDirection));
			}
			SelectedItem = GetItem((_flickDirection < 0) ? next.Item : previous.Item);
			UpdateItemPositions();
			GoTo(_targetOffset, FlickDuration, delegate
			{
				_panningItems.Refresh();
			});
		}
	}

	private void GoTo(int offset, Duration duration, Action completionAction)
	{
		if (_panningBackground != null)
		{
			_panningBackground.GoTo(offset, duration, null);
		}
		if (_panningTitle != null)
		{
			_panningTitle.GoTo(offset, duration, null);
		}
		if (_panningItems != null)
		{
			_panningItems.GoTo(offset, duration, completionAction);
		}
	}

	private void GoTo(int offset)
	{
		GoTo(offset, null);
	}

	private void GoTo(int offset, Action completionAction)
	{
		int num = Math.Abs((int)_panningItems.ActualOffset - offset);
		GoTo(offset, TimeSpan.FromMilliseconds(num * 2), completionAction);
	}

	private void GoTo(int offset, Duration duration)
	{
		GoTo(offset, duration, null);
	}

	private void WrapAround(int direction)
	{
		_panningBackground.Wraparound(direction);
		_panningTitle.Wraparound(direction);
		_panningItems.Wraparound(direction);
	}

	private void SetSelectionInternal(object selectedItem)
	{
		_suppressSelectionChangedEvent = true;
		SelectedItem = selectedItem;
		_suppressSelectionChangedEvent = false;
	}

	private static void OnSelectionChanged(DependencyObject obj, DependencyPropertyChangedEventArgs args)
	{
		if (!(obj is Panorama panorama))
		{
			return;
		}
		panorama.SelectedIndex = panorama.Items.IndexOf(args.NewValue);
		if (!panorama._suppressSelectionChangedEvent && panorama.Items.Contains(args.NewValue))
		{
			SafeRaise.Raise(panorama.SelectionChanged, panorama, () => new SelectionChangedEventArgs((args.OldValue == null) ? new object[0] : new object[1] { args.OldValue }, (args.NewValue == null) ? new object[0] : new object[1] { args.NewValue }));
		}
	}

	private static void OnDefaultItemChanged(DependencyObject obj, DependencyPropertyChangedEventArgs args)
	{
		((Panorama)obj).OnDefaultItemSet();
	}

	private void OnDefaultItemSet()
	{
		if (Panel != null)
		{
			Panel.NotifyDefaultItemChanged();
			if (Panel.VisibleChildren.Count > 0)
			{
				SelectedItem = DefaultItem;
			}
			if (Panel != null)
			{
				Panel.ResetItemPositions();
			}
			_panningItems.Refresh();
			UpdateItemPositions();
			GoTo(0, Immediately);
		}
	}

	private static void OnBackgroundShadowChanged(DependencyObject obj, DependencyPropertyChangedEventArgs args)
	{
		Panorama panorama = (Panorama)obj;
		if (!panorama._updateBackgroundPending)
		{
			panorama.UpdateBackground();
		}
	}

	private void UpdateBackground()
	{
		_updateBackgroundPending = false;
		_panningBackground.ContentPresenter.Height = ViewportHeight;
		if (base.Background is SolidColorBrush)
		{
			_panningBackground.ContentPresenter.Width = ViewportWidth;
			_panningBackground.IsStatic = true;
		}
		else if (base.Background is GradientBrush)
		{
			_panningBackground.ContentPresenter.Width = Math.Max(ItemsWidth, ViewportWidth);
			_panningBackground.IsStatic = _panningBackground.ContentPresenter.Width == (double)ViewportWidth;
		}
		else
		{
			if (!(base.Background is ImageBrush))
			{
				return;
			}
			ImageBrush imageBrush = (ImageBrush)base.Background;
			BitmapImage bmp = imageBrush.ImageSource as BitmapImage;
			if (_panningBackground.ContentPresenter != null && bmp != null)
			{
				if (!string.IsNullOrEmpty(bmp.UriSource.OriginalString))
				{
					if (bmp.PixelWidth == 0)
					{
						bmp.ImageOpened -= OnBackgroundImageOpened;
						bmp.ImageOpened += OnBackgroundImageOpened;
						base.Dispatcher.BeginInvoke(delegate
						{
							AsyncUpdateBackground(bmp);
						});
					}
					_panningBackground.ContentPresenter.Width = bmp.PixelWidth;
					if (previousBackgroundWidth == (float)bmp.PixelWidth || bmp.PixelHeight >= ViewportHeight)
					{
						_panningBackground.Refresh();
					}
					previousBackgroundWidth = bmp.PixelWidth;
				}
				else
				{
					_panningBackground.Refresh();
				}
			}
			_panningBackground.IsStatic = false;
		}
	}

	private void OnBackgroundImageOpened(object sender, RoutedEventArgs e)
	{
		AsyncUpdateBackground((BitmapImage)sender);
	}

	private void AsyncUpdateBackground(BitmapImage img)
	{
		img.ImageOpened -= OnBackgroundImageOpened;
		UpdateBackground();
	}

	private void OnSizeChanged(object sender, SizeChangedEventArgs e)
	{
		ViewportWidth = (int)e.NewSize.Width;
		ViewportHeight = (int)e.NewSize.Height;
		ItemsWidth = (int)Panel.ActualWidth;
		UpdateBackground();
		base.Clip = new RectangleGeometry
		{
			Rect = new Rect(0.0, 0.0, e.NewSize.Width, e.NewSize.Height)
		};
	}

	private void EntranceAnimationCallback(object sender, EventArgs e)
	{
		switch (_frameCount++)
		{
		case 0:
			GoTo(ViewportWidth, Immediately);
			break;
		case 1:
			GoTo(0, EntranceDuration);
			_entranceAnimationPlayed = true;
			CompositionTarget.Rendering -= EntranceAnimationCallback;
			break;
		}
	}
}
