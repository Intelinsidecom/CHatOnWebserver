using System;
using System.ComponentModel;
using System.Device.Location;
using System.Globalization;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Controls;
using System.Windows.Markup;
using System.Windows.Media;
using Microsoft.Phone.Controls.Maps.AutomationPeers;
using Microsoft.Phone.Controls.Maps.Design;

namespace Microsoft.Phone.Controls.Maps.Core;

[ContentProperty("Children")]
public abstract class MapBase : ContentControl
{
	private MapLayer rootLayer;

	private MapLayer userContentLayer;

	public static readonly DependencyProperty LogoVisibilityProperty = DependencyProperty.Register("LogoVisibility", typeof(Visibility), typeof(MapBase), new PropertyMetadata(OnOverlayVisibilityChangedCallback));

	public static readonly DependencyProperty CopyrightVisibilityProperty = DependencyProperty.Register("CopyrightVisibility", typeof(Visibility), typeof(MapBase), new PropertyMetadata(OnOverlayVisibilityChangedCallback));

	public static readonly DependencyProperty ScaleVisibilityProperty = DependencyProperty.Register("ScaleVisibility", typeof(Visibility), typeof(MapBase), new PropertyMetadata(OnOverlayVisibilityChangedCallback));

	public static readonly DependencyProperty ZoomBarVisibilityProperty = DependencyProperty.Register("ZoomBarVisibility", typeof(Visibility), typeof(MapBase), new PropertyMetadata(OnOverlayVisibilityChangedCallback));

	public static readonly DependencyProperty CultureProperty = DependencyProperty.Register("Culture", typeof(CultureInfo), typeof(MapBase), new PropertyMetadata(CultureInfo.CurrentUICulture, OnCultureChangedCallback));

	public static readonly DependencyProperty CredentialsProviderProperty = DependencyProperty.Register("CredentialsProvider", typeof(CredentialsProvider), typeof(MapBase), new PropertyMetadata(OnCredentialsProviderChangedCallback));

	public static readonly DependencyProperty ModeProperty = DependencyProperty.Register("Mode", typeof(MapMode), typeof(MapBase), new PropertyMetadata(OnModeChangedCallback));

	public static readonly DependencyProperty AnimationLevelProperty = DependencyProperty.Register("AnimationLevel", typeof(AnimationLevel), typeof(MapBase), new PropertyMetadata(AnimationLevel.None, OnAnimationLevelChangedCallback));

	public static readonly DependencyProperty CenterProperty = DependencyProperty.Register("Center", typeof(GeoCoordinate), typeof(MapBase), new PropertyMetadata(new GeoCoordinate(0.0, 0.0), OnCenterChangedCallback));

	public static readonly DependencyProperty ZoomLevelProperty = DependencyProperty.Register("ZoomLevel", typeof(double), typeof(MapBase), new PropertyMetadata(2.0, OnZoomLevelChangedCallback));

	public static readonly DependencyProperty HeadingProperty = DependencyProperty.Register("Heading", typeof(double), typeof(MapBase), new PropertyMetadata(OnHeadingChangedCallback));

	public static readonly DependencyProperty PitchProperty = DependencyProperty.Register("Pitch", typeof(double), typeof(MapBase), new PropertyMetadata(OnPitchChangedCallback));

	public UIElementCollection Children => userContentLayer.Children;

	public Visibility LogoVisibility
	{
		get
		{
			return (Visibility)GetValue(LogoVisibilityProperty);
		}
		set
		{
			SetValue(LogoVisibilityProperty, value);
		}
	}

	public Visibility CopyrightVisibility
	{
		get
		{
			return (Visibility)GetValue(CopyrightVisibilityProperty);
		}
		set
		{
			SetValue(CopyrightVisibilityProperty, value);
		}
	}

	public Visibility ScaleVisibility
	{
		get
		{
			return (Visibility)GetValue(ScaleVisibilityProperty);
		}
		set
		{
			SetValue(ScaleVisibilityProperty, value);
		}
	}

	public Visibility ZoomBarVisibility
	{
		get
		{
			return (Visibility)GetValue(ZoomBarVisibilityProperty);
		}
		set
		{
			SetValue(ZoomBarVisibilityProperty, value);
		}
	}

	public CultureInfo Culture
	{
		get
		{
			return (CultureInfo)GetValue(CultureProperty);
		}
		set
		{
			SetValue(CultureProperty, value);
		}
	}

	public CredentialsProvider CredentialsProvider
	{
		get
		{
			return (CredentialsProvider)GetValue(CredentialsProviderProperty);
		}
		set
		{
			SetValue(CredentialsProviderProperty, value);
		}
	}

	public virtual MapMode Mode
	{
		get
		{
			return (MapMode)GetValue(ModeProperty);
		}
		set
		{
			SetValue(ModeProperty, value);
		}
	}

	public AnimationLevel AnimationLevel
	{
		get
		{
			return (AnimationLevel)GetValue(AnimationLevelProperty);
		}
		set
		{
			SetValue(AnimationLevelProperty, value);
		}
	}

	[TypeConverter(typeof(LocationConverter))]
	public GeoCoordinate Center
	{
		get
		{
			return (GeoCoordinate)GetValue(CenterProperty);
		}
		set
		{
			SetValue(CenterProperty, value);
		}
	}

	public abstract GeoCoordinate TargetCenter { get; }

	public double ZoomLevel
	{
		get
		{
			return (double)GetValue(ZoomLevelProperty);
		}
		set
		{
			SetValue(ZoomLevelProperty, value);
		}
	}

	public abstract double TargetZoomLevel { get; }

	public double Heading
	{
		get
		{
			return (double)GetValue(HeadingProperty);
		}
		set
		{
			SetValue(HeadingProperty, value);
		}
	}

	public abstract double TargetHeading { get; }

	public double Pitch
	{
		get
		{
			return (double)GetValue(PitchProperty);
		}
		set
		{
			SetValue(PitchProperty, value);
		}
	}

	public abstract double TargetPitch { get; }

	public abstract bool IsDownloading { get; }

	public abstract bool IsIdle { get; }

	public abstract Size ViewportSize { get; }

	public abstract LocationRect BoundingRectangle { get; }

	public abstract LocationRect TargetBoundingRectangle { get; }

	protected MapLayer RootLayer => rootLayer;

	public abstract event EventHandler<MapEventArgs> ViewChangeOnFrame;

	public abstract event EventHandler<MapEventArgs> TargetViewChanged;

	public abstract event EventHandler<MapEventArgs> ViewChangeStart;

	public abstract event EventHandler<MapEventArgs> ViewChangeEnd;

	public abstract event EventHandler<MapEventArgs> ModeChanged;

	public abstract event EventHandler<LoadingErrorEventArgs> LoadingError;

	public abstract event EventHandler<MapDragEventArgs> MapPan;

	public abstract event EventHandler<MapZoomEventArgs> MapZoom;

	public abstract event EventHandler MapResolved;

	protected MapBase()
	{
		base.DefaultStyleKey = typeof(MapBase);
		rootLayer = new MapLayer();
		base.Content = rootLayer;
		userContentLayer = new MapLayer();
		rootLayer.Children.Add(userContentLayer);
		rootLayer.Background = new SolidColorBrush(Colors.Transparent);
	}

	private static void OnOverlayVisibilityChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		((MapBase)d).OnOverlayVisibilityChanged(e);
	}

	protected virtual void OnOverlayVisibilityChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
	}

	private static void OnCultureChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs eventArgs)
	{
		((MapBase)d).OnCultureChanged(eventArgs);
	}

	protected virtual void OnCultureChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
	}

	private static void OnCredentialsProviderChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs eventArgs)
	{
		((MapBase)d).OnCredentialsProviderChanged(eventArgs);
	}

	protected virtual void OnCredentialsProviderChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
	}

	private static void OnModeChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs eventArgs)
	{
		((MapBase)d).OnModeChanged(eventArgs);
	}

	protected virtual void OnModeChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
	}

	private static void OnAnimationLevelChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs eventArgs)
	{
		((MapBase)d).OnAnimationLevelChanged(eventArgs);
	}

	protected virtual void OnAnimationLevelChanged(DependencyPropertyChangedEventArgs eventArgs)
	{
	}

	protected internal virtual void ProjectionUpdated(ProjectionUpdateLevel updateLevel)
	{
	}

	public abstract void SetMode(MapMode newMode, bool transferSettings);

	public abstract bool TryViewportPointToLocation(Point viewportPoint, out GeoCoordinate location);

	public abstract GeoCoordinate ViewportPointToLocation(Point viewportPoint);

	public abstract bool TryLocationToViewportPoint(GeoCoordinate location, out Point viewportPoint);

	public abstract Point LocationToViewportPoint(GeoCoordinate location);

	public abstract void SetView(GeoCoordinate center, double zoomLevel);

	public abstract void SetView(GeoCoordinate center, double zoomLevel, double heading);

	public abstract void SetView(GeoCoordinate center, double zoomLevel, double heading, double pitch);

	public abstract void SetView(LocationRect boundingRectangle);

	private static void OnCenterChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs eventArgs)
	{
		((MapBase)d).OnCenterChanged(eventArgs);
	}

	protected abstract void OnCenterChanged(DependencyPropertyChangedEventArgs eventArgs);

	private static void OnZoomLevelChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs eventArgs)
	{
		((MapBase)d).OnZoomLevelChanged(eventArgs);
	}

	protected abstract void OnZoomLevelChanged(DependencyPropertyChangedEventArgs eventArgs);

	private static void OnHeadingChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs eventArgs)
	{
		((MapBase)d).OnHeadingChanged(eventArgs);
	}

	protected abstract void OnHeadingChanged(DependencyPropertyChangedEventArgs eventArgs);

	private static void OnPitchChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs eventArgs)
	{
		((MapBase)d).OnPitchChanged(eventArgs);
	}

	protected abstract void OnPitchChanged(DependencyPropertyChangedEventArgs eventArgs);

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new MapBaseAutomationPeer(this);
	}
}
