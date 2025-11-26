using System;
using System.ComponentModel;
using System.Device.Location;
using System.Globalization;
using System.Windows;
using System.Windows.Media;
using System.Windows.Threading;

namespace Microsoft.Phone.Controls.Maps.Core;

public class MapCore : MapBase
{
	private static Size optimalViewportSize = new Size(256.0, 256.0);

	private static readonly TimeSpan isIdlePollInterval = TimeSpan.FromSeconds(0.1);

	private readonly MapInputManager inputManager;

	private readonly MapLayer modeForegroundLayer;

	private readonly MapLayer modeLayer;

	private bool arranged;

	private MapMode currentMode;

	private bool isResized = true;

	private ProjectionUpdateLevel pendingUpdate;

	private AnimationLevel preLoadRealAnimationLevel;

	private bool updatingViewPropertyFromMode;

	private bool viewChanging;

	private Size viewportSize;

	private DispatcherTimer isIdlePollTimer;

	internal MapInputManager InputManager => inputManager;

	public override bool IsDownloading
	{
		get
		{
			if (currentMode != null)
			{
				return currentMode.IsDownloading;
			}
			return false;
		}
	}

	public override bool IsIdle
	{
		get
		{
			if (currentMode != null)
			{
				if (currentMode.IsIdle && !viewChanging)
				{
					return arranged;
				}
				return false;
			}
			return false;
		}
	}

	public override Size ViewportSize => viewportSize;

	public override GeoCoordinate TargetCenter => currentMode.TargetCenter;

	public override double TargetZoomLevel => currentMode.TargetZoomLevel;

	public override double TargetHeading => currentMode.TargetHeading;

	public override double TargetPitch => currentMode.TargetPitch;

	public override LocationRect BoundingRectangle => currentMode.BoundingRectangle;

	public override LocationRect TargetBoundingRectangle => currentMode.TargetBoundingRectangle;

	internal Point CenterPoint
	{
		get
		{
			return LocationToViewportPoint(base.Center);
		}
		set
		{
			base.Center = ViewportPointToLocation(value);
		}
	}

	protected internal Exception LoadingException { get; internal set; }

	private static long Timestamp => DateTime.UtcNow.Ticks;

	private event EventHandler<LoadingErrorEventArgs> loadingErrorEvent;

	public override event EventHandler<MapEventArgs> ViewChangeOnFrame;

	public override event EventHandler<MapEventArgs> TargetViewChanged;

	public override event EventHandler<MapEventArgs> ViewChangeStart;

	public override event EventHandler<MapEventArgs> ViewChangeEnd;

	public override event EventHandler<MapEventArgs> ModeChanged;

	public override event EventHandler<LoadingErrorEventArgs> LoadingError
	{
		add
		{
			if (LoadingException != null)
			{
				value?.Invoke(this, new LoadingErrorEventArgs(LoadingException));
			}
			this.loadingErrorEvent = (EventHandler<LoadingErrorEventArgs>)Delegate.Combine(this.loadingErrorEvent, value);
		}
		remove
		{
			this.loadingErrorEvent = (EventHandler<LoadingErrorEventArgs>)Delegate.Remove(this.loadingErrorEvent, value);
		}
	}

	public override event EventHandler<MapDragEventArgs> MapPan
	{
		add
		{
			inputManager.TouchDrag += value;
		}
		remove
		{
			inputManager.TouchDrag -= value;
		}
	}

	public override event EventHandler<MapZoomEventArgs> MapZoom
	{
		add
		{
			inputManager.TouchZoom += value;
		}
		remove
		{
			inputManager.TouchZoom -= value;
		}
	}

	public override event EventHandler MapResolved;

	protected MapCore()
	{
		base.RootLayer.Clip = new RectangleGeometry();
		viewportSize = optimalViewportSize;
		currentMode = new NullMode();
		currentMode.AnimationLevel = AnimationLevel.None;
		preLoadRealAnimationLevel = AnimationLevel.Full;
		modeLayer = new MapLayer();
		modeForegroundLayer = new MapLayer();
		base.RootLayer.Children.Insert(0, modeLayer);
		base.RootLayer.Children.Add(modeForegroundLayer);
		inputManager = new MapInputManager(this);
		base.SizeChanged += MapCore_SizeChanged;
		isIdlePollTimer = new DispatcherTimer
		{
			Interval = isIdlePollInterval
		};
		RoutedEventHandler value = delegate
		{
			if (isIdlePollTimer != null)
			{
				isIdlePollTimer.Tick -= isIdlePollTimer_Tick;
			}
		};
		base.Unloaded += value;
	}

	public override void SetMode(MapMode newMode, bool transferSettings)
	{
		if (transferSettings && newMode.Content != null && VisualTreeHelper.GetParent(newMode.Content) != null)
		{
			throw new ArgumentException(ExceptionStrings.InvalidMode);
		}
		GeoCoordinate targetCenter = currentMode.TargetCenter;
		double targetZoomLevel = currentMode.TargetZoomLevel;
		double targetHeading = currentMode.TargetHeading;
		double targetPitch = currentMode.TargetPitch;
		AnimationLevel animationLevel = currentMode.AnimationLevel;
		newMode.Activating(currentMode, modeLayer, modeForegroundLayer);
		currentMode.TargetViewChanged -= currentMode_TargetViewChanged;
		currentMode.ProjectionChanged -= currentMode_ProjectionChanged;
		currentMode.Deactivating();
		currentMode = newMode;
		currentMode.ViewportSizeChanged(ViewportSize);
		if (transferSettings)
		{
			modeLayer.Children.Clear();
			modeForegroundLayer.Children.Clear();
			if (currentMode.Content != null)
			{
				modeLayer.Children.Add(currentMode.Content);
			}
			if (currentMode.ForegroundContent != null)
			{
				modeForegroundLayer.Children.Add(currentMode.ForegroundContent);
			}
			currentMode.CredentialsProvider = base.CredentialsProvider;
			currentMode.Culture = base.Culture;
			currentMode.AnimationLevel = animationLevel;
			currentMode.Activated(modeLayer, modeForegroundLayer);
			currentMode.SetView(targetCenter, targetZoomLevel, targetHeading, targetPitch, animate: false);
			ProjectionUpdated(ProjectionUpdateLevel.Full);
		}
		else
		{
			currentMode.Activated(modeLayer, modeForegroundLayer);
		}
		currentMode.TargetViewChanged += currentMode_TargetViewChanged;
		currentMode.ProjectionChanged += currentMode_ProjectionChanged;
		UpdateViewFromMode();
		if (ModeChanged != null)
		{
			ModeChanged(this, new MapEventArgs());
		}
	}

	public override bool TryViewportPointToLocation(Point viewportPoint, out GeoCoordinate location)
	{
		return currentMode.TryViewportPointToLocation(viewportPoint, out location);
	}

	public override GeoCoordinate ViewportPointToLocation(Point viewportPoint)
	{
		return currentMode.ViewportPointToLocation(viewportPoint);
	}

	public override bool TryLocationToViewportPoint(GeoCoordinate location, out Point viewportPoint)
	{
		return currentMode.TryLocationToViewportPoint(location, out viewportPoint);
	}

	public override Point LocationToViewportPoint(GeoCoordinate location)
	{
		return currentMode.LocationToViewportPoint(location);
	}

	public override void SetView(GeoCoordinate center, double zoomLevel)
	{
		SetView(center, zoomLevel, currentMode.TargetHeading);
	}

	public override void SetView(GeoCoordinate center, double zoomLevel, double heading)
	{
		SetView(center, zoomLevel, heading, currentMode.TargetPitch);
	}

	public override void SetView(GeoCoordinate center, double zoomLevel, double heading, double pitch)
	{
		currentMode.SetView(center, zoomLevel, heading, pitch, arranged && base.AnimationLevel == AnimationLevel.Full && !DesignerProperties.GetIsInDesignMode(this));
	}

	public override void SetView(LocationRect boundingRectangle)
	{
		currentMode.SetView(boundingRectangle, arranged && base.AnimationLevel == AnimationLevel.Full && !DesignerProperties.GetIsInDesignMode(this));
	}

	protected override void OnCenterChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
		if (!updatingViewPropertyFromMode && eventArgs.NewValue != null)
		{
			GeoCoordinate geoCoordinate = eventArgs.NewValue as GeoCoordinate;
			currentMode.Center = geoCoordinate;
			if (currentMode.Center != geoCoordinate)
			{
				updatingViewPropertyFromMode = true;
				base.Center = currentMode.Center;
				updatingViewPropertyFromMode = false;
			}
		}
	}

	protected override void OnZoomLevelChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
		if (!updatingViewPropertyFromMode)
		{
			double num = (double)eventArgs.NewValue;
			currentMode.ZoomLevel = num;
			if (currentMode.ZoomLevel != num)
			{
				updatingViewPropertyFromMode = true;
				base.ZoomLevel = currentMode.ZoomLevel;
				updatingViewPropertyFromMode = false;
			}
		}
	}

	protected override void OnHeadingChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
		if (!updatingViewPropertyFromMode)
		{
			double num = (double)eventArgs.NewValue;
			currentMode.Heading = num;
			if (currentMode.Heading != num)
			{
				updatingViewPropertyFromMode = true;
				base.Heading = currentMode.Heading;
				updatingViewPropertyFromMode = false;
			}
		}
	}

	protected override void OnPitchChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
		if (!updatingViewPropertyFromMode)
		{
			double num = (double)eventArgs.NewValue;
			currentMode.Pitch = num;
			if (currentMode.Pitch != num)
			{
				updatingViewPropertyFromMode = true;
				base.Pitch = currentMode.Pitch;
				updatingViewPropertyFromMode = false;
			}
		}
	}

	protected internal override void ProjectionUpdated(ProjectionUpdateLevel updateLevel)
	{
		pendingUpdate |= updateLevel;
		if (pendingUpdate != ProjectionUpdateLevel.None)
		{
			InvalidateMeasure();
		}
	}

	private void currentMode_ProjectionChanged(object sender, ProjectionChangedEventArgs e)
	{
		UpdateViewFromMode();
		pendingUpdate |= e.UpdateLevel;
		if (pendingUpdate != ProjectionUpdateLevel.None)
		{
			InvalidateMeasure();
		}
	}

	private void UpdateViewFromMode()
	{
		updatingViewPropertyFromMode = true;
		if (base.Center != currentMode.Center)
		{
			base.Center = currentMode.Center;
		}
		if (base.ZoomLevel != currentMode.ZoomLevel)
		{
			base.ZoomLevel = currentMode.ZoomLevel;
		}
		if (base.Heading != currentMode.Heading)
		{
			base.Heading = currentMode.Heading;
		}
		if (base.Pitch != currentMode.Pitch)
		{
			base.Pitch = currentMode.Pitch;
		}
		updatingViewPropertyFromMode = false;
	}

	private void Update()
	{
		if (pendingUpdate != ProjectionUpdateLevel.None)
		{
			if (!viewChanging)
			{
				viewChanging = true;
				if (ViewChangeStart != null)
				{
					ViewChangeStart(this, new MapEventArgs());
				}
			}
			base.RootLayer.ProjectionUpdated(pendingUpdate);
			if (ViewChangeOnFrame != null)
			{
				ViewChangeOnFrame(this, new MapEventArgs());
			}
			base.Dispatcher.BeginInvoke(delegate
			{
				InvalidateMeasure();
			});
		}
		else if (viewChanging && pendingUpdate == ProjectionUpdateLevel.None)
		{
			viewChanging = false;
			if (ViewChangeEnd != null)
			{
				ViewChangeEnd(this, new MapEventArgs());
			}
			isIdlePollTimer.Tick += isIdlePollTimer_Tick;
			isIdlePollTimer.Start();
		}
		pendingUpdate = ProjectionUpdateLevel.None;
	}

	private void isIdlePollTimer_Tick(object sender, EventArgs e)
	{
		if (IsIdle)
		{
			isIdlePollTimer.Stop();
			isIdlePollTimer.Tick -= isIdlePollTimer_Tick;
			MapResolved?.Invoke(this, EventArgs.Empty);
		}
	}

	private void MapCore_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		((RectangleGeometry)base.RootLayer.Clip).Rect = new Rect(0.0, 0.0, e.NewSize.Width, e.NewSize.Height);
		isResized = true;
	}

	private void UpdateViewportSize(Size pendingSize)
	{
		if (pendingSize != viewportSize)
		{
			Size size = viewportSize;
			viewportSize = new Size((double.IsInfinity(pendingSize.Width) | double.IsNaN(pendingSize.Width)) ? optimalViewportSize.Width : pendingSize.Width, (double.IsInfinity(pendingSize.Height) | double.IsNaN(pendingSize.Height)) ? optimalViewportSize.Height : pendingSize.Height);
			if (size != viewportSize)
			{
				currentMode.ViewportSizeChanged(viewportSize);
			}
		}
	}

	protected override Size MeasureOverride(Size availableSize)
	{
		if (isResized)
		{
			UpdateViewportSize(availableSize);
			isResized = false;
		}
		Update();
		((UIElement)base.Content).Measure(ViewportSize);
		return new Size(Math.Min(optimalViewportSize.Width, availableSize.Width), Math.Min(optimalViewportSize.Height, availableSize.Height));
	}

	protected override Size ArrangeOverride(Size finalSize)
	{
		UpdateViewportSize(finalSize);
		((UIElement)base.Content).Arrange(new Rect(0.0, 0.0, ViewportSize.Width, ViewportSize.Height));
		if (!arranged)
		{
			arranged = true;
			OnFirstFrame();
		}
		return ViewportSize;
	}

	protected virtual void OnFirstFrame()
	{
		base.AnimationLevel = preLoadRealAnimationLevel;
	}

	protected override void OnCultureChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
		base.OnCultureChanged(eventArgs);
		if (eventArgs.NewValue is CultureInfo culture)
		{
			currentMode.Culture = culture;
		}
	}

	protected override void OnCredentialsProviderChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
		if (eventArgs.OldValue == currentMode.CredentialsProvider)
		{
			currentMode.CredentialsProvider = eventArgs.NewValue as CredentialsProvider;
		}
	}

	protected override void OnAnimationLevelChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
		AnimationLevel animationLevel = (AnimationLevel)eventArgs.NewValue;
		if (arranged && !DesignerProperties.GetIsInDesignMode(this))
		{
			currentMode.AnimationLevel = animationLevel;
		}
		else
		{
			preLoadRealAnimationLevel = animationLevel;
		}
	}

	protected override void OnModeChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
		MapMode newMode = eventArgs.NewValue as MapMode;
		SetMode(newMode, transferSettings: true);
	}

	internal void ThrowLoadingException(Exception e)
	{
		if (LoadingException == null && e != null)
		{
			LoadingException = e;
			this.loadingErrorEvent?.Invoke(this, new LoadingErrorEventArgs(LoadingException));
		}
	}

	private void currentMode_TargetViewChanged(object sender, MapEventArgs e)
	{
		TargetViewChanged?.Invoke(this, e);
	}
}
