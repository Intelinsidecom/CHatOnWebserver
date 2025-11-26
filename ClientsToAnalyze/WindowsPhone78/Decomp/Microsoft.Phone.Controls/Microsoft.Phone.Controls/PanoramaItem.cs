using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace Microsoft.Phone.Controls;

public class PanoramaItem : ContentControl
{
	public static readonly DependencyProperty HeaderProperty = DependencyProperty.Register("Header", typeof(object), typeof(PanoramaItem), null);

	public static readonly DependencyProperty HeaderTemplateProperty = DependencyProperty.Register("HeaderTemplate", typeof(DataTemplate), typeof(PanoramaItem), null);

	public static readonly DependencyProperty OrientationProperty = DependencyProperty.Register("Orientation", typeof(Orientation), typeof(PanoramaItem), new PropertyMetadata(Orientation.Vertical, OnOrientationChanged));

	internal int StartPosition { get; set; }

	internal int ItemWidth { get; set; }

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

	public Orientation Orientation
	{
		get
		{
			return (Orientation)GetValue(OrientationProperty);
		}
		set
		{
			SetValue(OrientationProperty, value);
		}
	}

	public PanoramaItem()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_STARTUP, PerfLog.PanoramaItem);
		base.DefaultStyleKey = typeof(PanoramaItem);
		base.Loaded += PanoramaItem_Loaded;
	}

	private void PanoramaItem_Loaded(object sender, RoutedEventArgs e)
	{
		base.Loaded -= PanoramaItem_Loaded;
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_STARTUP, PerfLog.PanoramaItem);
	}

	protected override Size MeasureOverride(Size availableSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_MEASURE, PerfLog.PanoramaItem);
		Size result = base.MeasureOverride(availableSize);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_MEASURE, PerfLog.PanoramaItem);
		return result;
	}

	protected override Size ArrangeOverride(Size finalSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_ARRANGE, PerfLog.PanoramaItem);
		Size result = base.ArrangeOverride(finalSize);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_ARRANGE, PerfLog.PanoramaItem);
		return result;
	}

	private static void OnOrientationChanged(DependencyObject obj, DependencyPropertyChangedEventArgs args)
	{
		PanoramaItem panoramaItem = (PanoramaItem)obj;
		panoramaItem.InvalidateMeasure();
		if (VisualTreeHelper.GetParent(panoramaItem) is FrameworkElement frameworkElement)
		{
			frameworkElement.InvalidateMeasure();
		}
	}
}
