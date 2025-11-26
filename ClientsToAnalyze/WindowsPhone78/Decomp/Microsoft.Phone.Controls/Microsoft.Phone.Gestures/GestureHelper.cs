using System;
using System.Windows;
using System.Windows.Media;
using Microsoft.Phone.Controls;

namespace Microsoft.Phone.Gestures;

internal abstract class GestureHelper
{
	private enum DragLock
	{
		Unset,
		Free,
		Vertical,
		Horizontal
	}

	private DragLock _dragLock;

	private bool _dragging;

	private WeakReference _gestureSource;

	private Point _gestureOrigin;

	private readonly Size DeadZoneInPixels = new Size(12.0, 12.0);

	protected bool ShouldHandleAllDrags { get; private set; }

	protected UIElement Target { get; private set; }

	public event EventHandler<GestureEventArgs> GestureStart;

	public event EventHandler<FlickEventArgs> Flick;

	public event EventHandler<EventArgs> GestureEnd;

	public event EventHandler<DragEventArgs> HorizontalDrag;

	public event EventHandler<DragEventArgs> VerticalDrag;

	public static GestureHelper Create(UIElement target)
	{
		return Create(target, shouldHandleAllDrags: true);
	}

	public static GestureHelper Create(UIElement target, bool shouldHandleAllDrags)
	{
		GestureHelper gestureHelper = new ManipulationGestureHelper(target, shouldHandleAllDrags);
		gestureHelper.Start();
		return gestureHelper;
	}

	protected GestureHelper(UIElement target, bool shouldHandleAllDrags)
	{
		Target = target;
		ShouldHandleAllDrags = shouldHandleAllDrags;
	}

	protected abstract void HookEvents();

	public void Start()
	{
		HookEvents();
	}

	protected void NotifyDown(InputBaseArgs args)
	{
		GestureEventArgs args2 = new GestureEventArgs();
		_gestureSource = new WeakReference(args.Source);
		_gestureOrigin = args.Origin;
		_dragLock = DragLock.Unset;
		_dragging = false;
		RaiseGestureStart(args2);
	}

	protected void NotifyMove(InputDeltaArgs args)
	{
		if (Math.Abs(args.CumulativeTranslation.X) > DeadZoneInPixels.Width || Math.Abs(args.CumulativeTranslation.Y) > DeadZoneInPixels.Height)
		{
			if (!_dragging)
			{
				ReleaseMouseCaptureAtGestureOrigin();
			}
			_dragging = true;
			if (_dragLock == DragLock.Unset)
			{
				double num = AngleFromVector(args.CumulativeTranslation.X, args.CumulativeTranslation.Y) % 180.0;
				if (num <= 45.0 || num >= 135.0)
				{
					_dragLock = DragLock.Horizontal;
				}
				else if (num > 45.0 && num < 135.0)
				{
					_dragLock = DragLock.Vertical;
				}
				else
				{
					_dragLock = DragLock.Free;
				}
			}
		}
		if (_dragging)
		{
			RaiseDragEvents(args);
		}
	}

	private void ReleaseMouseCaptureAtGestureOrigin()
	{
		if (_gestureSource == null || !(_gestureSource.Target is FrameworkElement frameworkElement))
		{
			return;
		}
		GeneralTransform generalTransform = frameworkElement.TransformToVisual(null);
		Point intersectingPoint = generalTransform.Transform(_gestureOrigin);
		foreach (UIElement item in VisualTreeHelper.FindElementsInHostCoordinates(intersectingPoint, Application.Current.RootVisual))
		{
			item.ReleaseMouseCapture();
		}
	}

	protected void NotifyUp(InputCompletedArgs args)
	{
		EventArgs args2 = EventArgs.Empty;
		_dragLock = DragLock.Unset;
		_dragging = false;
		if (args.IsInertial)
		{
			double num = AngleFromVector(args.FinalLinearVelocity.X, args.FinalLinearVelocity.Y);
			if (num <= 45.0 || num >= 315.0)
			{
				num = 0.0;
			}
			else if (num >= 135.0 && num <= 225.0)
			{
				num = 180.0;
			}
			FlickEventArgs e = new FlickEventArgs();
			e.Angle = num;
			FlickEventArgs args3 = e;
			ReleaseMouseCaptureAtGestureOrigin();
			RaiseFlick(args3);
		}
		else if (args.TotalTranslation.X != 0.0 || args.TotalTranslation.Y != 0.0)
		{
			DragEventArgs e2 = new DragEventArgs();
			e2.CumulativeDistance = args.TotalTranslation;
			DragEventArgs e3 = e2;
			e3.MarkAsFinalTouchManipulation();
			args2 = e3;
		}
		RaiseGestureEnd(args2);
	}

	private void RaiseGestureStart(GestureEventArgs args)
	{
		SafeRaise.Raise(this.GestureStart, this, args);
	}

	private void RaiseFlick(FlickEventArgs args)
	{
		SafeRaise.Raise(this.Flick, this, args);
	}

	private void RaiseGestureEnd(EventArgs args)
	{
		SafeRaise.Raise(this.GestureEnd, this, args);
	}

	private void RaiseDragEvents(InputDeltaArgs args)
	{
		DragEventArgs args2 = new DragEventArgs(args);
		if (args.DeltaTranslation.X != 0.0 && _dragLock == DragLock.Horizontal)
		{
			RaiseHorizontalDrag(args2);
		}
		else if (args.DeltaTranslation.Y != 0.0 && _dragLock == DragLock.Vertical)
		{
			RaiseVerticalDrag(args2);
		}
	}

	private void RaiseHorizontalDrag(DragEventArgs args)
	{
		SafeRaise.Raise(this.HorizontalDrag, this, args);
	}

	private void RaiseVerticalDrag(DragEventArgs args)
	{
		SafeRaise.Raise(this.VerticalDrag, this, args);
	}

	private static double AngleFromVector(double x, double y)
	{
		double num = Math.Atan2(y, x);
		if (num < 0.0)
		{
			num = Math.PI * 2.0 + num;
		}
		return num * 360.0 / (Math.PI * 2.0);
	}
}
