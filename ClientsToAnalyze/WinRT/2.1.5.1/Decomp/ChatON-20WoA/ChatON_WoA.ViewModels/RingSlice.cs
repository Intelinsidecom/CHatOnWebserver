using System;
using System.Collections.Generic;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.Foundation;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Shapes;

namespace ChatON_WoA.ViewModels;

public class RingSlice : Path
{
	private bool _isUpdating;

	public static readonly DependencyProperty StartAngleProperty = DependencyProperty.Register("StartAngle", typeof(double), typeof(RingSlice), new PropertyMetadata((object)0.0, new PropertyChangedCallback(OnStartAngleChanged)));

	public static readonly DependencyProperty EndAngleProperty = DependencyProperty.Register("EndAngle", typeof(double), typeof(RingSlice), new PropertyMetadata((object)0.0, new PropertyChangedCallback(OnEndAngleChanged)));

	public static readonly DependencyProperty RadiusProperty = DependencyProperty.Register("Radius", typeof(double), typeof(RingSlice), new PropertyMetadata((object)0.0, new PropertyChangedCallback(OnRadiusChanged)));

	public static readonly DependencyProperty InnerRadiusProperty = DependencyProperty.Register("InnerRadius", typeof(double), typeof(RingSlice), new PropertyMetadata((object)0.0, new PropertyChangedCallback(OnInnerRadiusChanged)));

	public static readonly DependencyProperty CenterProperty = DependencyProperty.Register("Center", typeof(Point?), typeof(RingSlice), new PropertyMetadata((object)null, new PropertyChangedCallback(OnCenterChanged)));

	public double StartAngle
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(StartAngleProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(StartAngleProperty, (object)value);
		}
	}

	public double EndAngle
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(EndAngleProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(EndAngleProperty, (object)value);
		}
	}

	public double Radius
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(RadiusProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(RadiusProperty, (object)value);
		}
	}

	public double InnerRadius
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(InnerRadiusProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(InnerRadiusProperty, (object)value);
		}
	}

	public Point? Center
	{
		get
		{
			return (Point?)((DependencyObject)this).GetValue(CenterProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(CenterProperty, (object)value);
		}
	}

	private static void OnStartAngleChanged(DependencyObject sender, DependencyPropertyChangedEventArgs e)
	{
		RingSlice ringSlice = (RingSlice)(object)sender;
		double oldStartAngle = (double)e.OldValue;
		double newStartAngle = (double)e.NewValue;
		ringSlice.OnStartAngleChanged(oldStartAngle, newStartAngle);
	}

	private void OnStartAngleChanged(double oldStartAngle, double newStartAngle)
	{
		UpdatePath();
	}

	private static void OnEndAngleChanged(DependencyObject sender, DependencyPropertyChangedEventArgs e)
	{
		RingSlice ringSlice = (RingSlice)(object)sender;
		double oldEndAngle = (double)e.OldValue;
		double newEndAngle = (double)e.NewValue;
		ringSlice.OnEndAngleChanged(oldEndAngle, newEndAngle);
	}

	private void OnEndAngleChanged(double oldEndAngle, double newEndAngle)
	{
		UpdatePath();
	}

	private static void OnRadiusChanged(DependencyObject sender, DependencyPropertyChangedEventArgs e)
	{
		RingSlice ringSlice = (RingSlice)(object)sender;
		double oldRadius = (double)e.OldValue;
		double newRadius = (double)e.NewValue;
		ringSlice.OnRadiusChanged(oldRadius, newRadius);
	}

	private void OnRadiusChanged(double oldRadius, double newRadius)
	{
		double num;
		((FrameworkElement)this).put_Height(num = 2.0 * Radius);
		((FrameworkElement)this).put_Width(num);
		UpdatePath();
	}

	private static void OnInnerRadiusChanged(DependencyObject sender, DependencyPropertyChangedEventArgs e)
	{
		RingSlice ringSlice = (RingSlice)(object)sender;
		double oldInnerRadius = (double)e.OldValue;
		double newInnerRadius = (double)e.NewValue;
		ringSlice.OnInnerRadiusChanged(oldInnerRadius, newInnerRadius);
	}

	private void OnInnerRadiusChanged(double oldInnerRadius, double newInnerRadius)
	{
		if (newInnerRadius < 0.0)
		{
			throw new ArgumentException("InnerRadius can't be a negative value.", "InnerRadius");
		}
		UpdatePath();
	}

	private static void OnCenterChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		RingSlice ringSlice = (RingSlice)(object)d;
		Point? oldCenter = (Point?)e.OldValue;
		Point? center = ringSlice.Center;
		ringSlice.OnCenterChanged(oldCenter, center);
	}

	private void OnCenterChanged(Point? oldCenter, Point? newCenter)
	{
		UpdatePath();
	}

	public unsafe RingSlice()
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		WindowsRuntimeMarshal.AddEventHandler(new Func<SizeChangedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.add_SizeChanged)), new Action<EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.remove_SizeChanged)), new SizeChangedEventHandler(OnSizeChanged));
	}

	private void OnSizeChanged(object sender, SizeChangedEventArgs sizeChangedEventArgs)
	{
		UpdatePath();
	}

	public void BeginUpdate()
	{
		_isUpdating = true;
	}

	public void EndUpdate()
	{
		_isUpdating = false;
		UpdatePath();
	}

	private void UpdatePath()
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_000f: Expected O, but got Unknown
		//IL_000f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0015: Expected O, but got Unknown
		//IL_00d1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d7: Expected O, but got Unknown
		//IL_017d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0184: Expected O, but got Unknown
		//IL_01f0: Unknown result type (might be due to invalid IL or missing references)
		//IL_01f7: Expected O, but got Unknown
		if (!_isUpdating)
		{
			PathGeometry val = new PathGeometry();
			PathFigure val2 = new PathFigure();
			val2.put_IsClosed(true);
			Point point = Center ?? new Point(Radius + ((Shape)this).StrokeThickness / 2.0, Radius + ((Shape)this).StrokeThickness / 2.0);
			val2.put_StartPoint(new Point(point.X + Math.Sin(StartAngle * Math.PI / 180.0) * InnerRadius, point.Y - Math.Cos(StartAngle * Math.PI / 180.0) * InnerRadius));
			ArcSegment val3 = new ArcSegment();
			val3.put_IsLargeArc(EndAngle - StartAngle >= 180.0);
			val3.put_Point(new Point(point.X + Math.Sin(EndAngle * Math.PI / 180.0) * InnerRadius, point.Y - Math.Cos(EndAngle * Math.PI / 180.0) * InnerRadius));
			val3.put_Size(new Size(InnerRadius, InnerRadius));
			val3.put_SweepDirection((SweepDirection)1);
			LineSegment val4 = new LineSegment();
			val4.put_Point(new Point(point.X + Math.Sin(EndAngle * Math.PI / 180.0) * Radius, point.Y - Math.Cos(EndAngle * Math.PI / 180.0) * Radius));
			LineSegment item = val4;
			ArcSegment val5 = new ArcSegment();
			val5.put_IsLargeArc(EndAngle - StartAngle >= 180.0);
			val5.put_Point(new Point(point.X + Math.Sin(StartAngle * Math.PI / 180.0) * Radius, point.Y - Math.Cos(StartAngle * Math.PI / 180.0) * Radius));
			val5.put_Size(new Size(Radius, Radius));
			val5.put_SweepDirection((SweepDirection)0);
			((ICollection<PathSegment>)val2.Segments).Add((PathSegment)(object)val3);
			((ICollection<PathSegment>)val2.Segments).Add((PathSegment)(object)item);
			((ICollection<PathSegment>)val2.Segments).Add((PathSegment)(object)val5);
			((ICollection<PathFigure>)val.Figures).Add(val2);
			((UIElement)this).InvalidateArrange();
			((Path)this).put_Data((Geometry)(object)val);
		}
	}
}
