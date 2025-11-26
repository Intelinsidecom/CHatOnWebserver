using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Threading;
using Microsoft.Xna.Framework.Input.Touch;

namespace Microsoft.Phone.Controls;

public class GestureListener
{
	private static DispatcherTimer _timer;

	private static bool _isInTouch;

	private static List<UIElement> _elements;

	private static Point _gestureOrigin;

	private static bool _gestureOriginChanged;

	private static Orientation? _gestureOrientation;

	private static Point _cumulativeDelta;

	private static Point _cumulativeDelta2;

	private static Point _finalVelocity;

	private static Point _pinchOrigin;

	private static Point _pinchOrigin2;

	private static Point _lastSamplePosition;

	private static Point _lastSamplePosition2;

	private static bool _isPinching;

	private static bool _flicked;

	private static bool _isDragging;

	public event EventHandler<GestureEventArgs> GestureBegin;

	public event EventHandler<GestureEventArgs> GestureCompleted;

	public event EventHandler<GestureEventArgs> Tap;

	public event EventHandler<GestureEventArgs> DoubleTap;

	public event EventHandler<GestureEventArgs> Hold;

	public event EventHandler<DragStartedGestureEventArgs> DragStarted;

	public event EventHandler<DragDeltaGestureEventArgs> DragDelta;

	public event EventHandler<DragCompletedGestureEventArgs> DragCompleted;

	public event EventHandler<FlickGestureEventArgs> Flick;

	public event EventHandler<PinchStartedGestureEventArgs> PinchStarted;

	public event EventHandler<PinchGestureEventArgs> PinchDelta;

	public event EventHandler<PinchGestureEventArgs> PinchCompleted;

	static GestureListener()
	{
		Touch.FrameReported += Touch_FrameReported;
		TouchPanel.EnabledGestures = (GestureType)999;
		_timer = new DispatcherTimer
		{
			Interval = TimeSpan.FromMilliseconds(100.0)
		};
		_timer.Tick += OnTimerTick;
	}

	private static void Touch_FrameReported(object sender, TouchFrameEventArgs e)
	{
		bool flag = false;
		Point gestureOrigin = new Point(0.0, 0.0);
		foreach (TouchPoint touchPoint in e.GetTouchPoints(null))
		{
			if (touchPoint.Action != TouchAction.Up)
			{
				gestureOrigin = touchPoint.Position;
				flag = true;
				break;
			}
		}
		if (!_isInTouch && flag)
		{
			_gestureOrigin = gestureOrigin;
			TouchStart();
		}
		else if (_isInTouch && !flag)
		{
			TouchComplete();
		}
		else if (_isInTouch)
		{
			TouchDelta();
		}
		else
		{
			TouchStart();
		}
		_isInTouch = flag;
	}

	private static void TouchStart()
	{
		double num = (_cumulativeDelta2.Y = 0.0);
		double num3 = (_cumulativeDelta2.X = num);
		double x = (_cumulativeDelta.Y = num3);
		_cumulativeDelta.X = x;
		double x2 = (_finalVelocity.Y = 0.0);
		_finalVelocity.X = x2;
		_isDragging = (_flicked = false);
		_elements = new List<UIElement>(VisualTreeHelper.FindElementsInHostCoordinates(_gestureOrigin, Application.Current.RootVisual));
		_gestureOriginChanged = false;
		RaiseGestureEvent((GestureListener helper) => helper.GestureBegin, () => new GestureEventArgs(_gestureOrigin, _gestureOrigin), releaseMouseCapture: false);
		ProcessTouchPanelEvents();
		_timer.Start();
	}

	private static void TouchDelta()
	{
		ProcessTouchPanelEvents();
	}

	private static void TouchComplete()
	{
		ProcessTouchPanelEvents();
		RaiseGestureEvent((GestureListener helper) => helper.GestureCompleted, () => new GestureEventArgs(_gestureOrigin, _lastSamplePosition), releaseMouseCapture: false);
		_elements = null;
		_gestureOrientation = null;
		_timer.Stop();
	}

	private static void OnTimerTick(object sender, EventArgs e)
	{
		ProcessTouchPanelEvents();
	}

	private static void ProcessTouchPanelEvents()
	{
		//IL_0055: Unknown result type (might be due to invalid IL or missing references)
		//IL_005a: Unknown result type (might be due to invalid IL or missing references)
		//IL_005f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0072: Unknown result type (might be due to invalid IL or missing references)
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a4: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ae: Invalid comparison between Unknown and I4
		//IL_00ba: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00da: Invalid comparison between Unknown and I4
		//IL_0190: Unknown result type (might be due to invalid IL or missing references)
		//IL_0195: Unknown result type (might be due to invalid IL or missing references)
		//IL_0197: Unknown result type (might be due to invalid IL or missing references)
		//IL_019b: Invalid comparison between Unknown and I4
		//IL_01cd: Unknown result type (might be due to invalid IL or missing references)
		//IL_01d4: Invalid comparison between Unknown and I4
		//IL_019d: Unknown result type (might be due to invalid IL or missing references)
		//IL_01a0: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b6: Expected I4, but got Unknown
		//IL_01d9: Unknown result type (might be due to invalid IL or missing references)
		//IL_01e0: Invalid comparison between Unknown and I4
		//IL_01b6: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ba: Invalid comparison between Unknown and I4
		//IL_01e5: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ec: Invalid comparison between Unknown and I4
		//IL_01bf: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c3: Invalid comparison between Unknown and I4
		Point delta = default(Point);
		ref Point reference = ref delta;
		reference = new Point(0.0, 0.0);
		GeneralTransform deltaTransform = null;
		while (TouchPanel.IsGestureAvailable)
		{
			GestureSample val = TouchPanel.ReadGesture();
			Point samplePosition = ((GestureSample)(ref val)).Position.ToPoint();
			Point samplePosition2 = ((GestureSample)(ref val)).Position2.ToPoint();
			Point sampleDelta = ((GestureSample)(ref val)).Delta.ToPoint();
			GetTranslatedDelta(ref deltaTransform, ref sampleDelta, ref _cumulativeDelta, (int)((GestureSample)(ref val)).GestureType != 128);
			Point sampleDelta2 = ((GestureSample)(ref val)).Delta2.ToPoint();
			GetTranslatedDelta(ref deltaTransform, ref sampleDelta2, ref _cumulativeDelta2, (int)((GestureSample)(ref val)).GestureType != 128);
			if (_elements == null || _gestureOriginChanged)
			{
				_gestureOrigin = samplePosition;
				_elements = new List<UIElement>(VisualTreeHelper.FindElementsInHostCoordinates(_gestureOrigin, Application.Current.RootVisual));
				_gestureOriginChanged = false;
			}
			if (!_gestureOrientation.HasValue && (sampleDelta.X != 0.0 || sampleDelta.Y != 0.0))
			{
				_gestureOrientation = ((Math.Abs(sampleDelta.X) >= Math.Abs(sampleDelta.Y)) ? Orientation.Horizontal : Orientation.Vertical);
			}
			GestureType gestureType = ((GestureSample)(ref val)).GestureType;
			if ((int)gestureType <= 64)
			{
				switch (gestureType - 1)
				{
				case 0:
					RaiseGestureEvent((GestureListener helper) => helper.Tap, () => new GestureEventArgs(_gestureOrigin, samplePosition), releaseMouseCapture: false);
					continue;
				case 1:
					RaiseGestureEvent((GestureListener helper) => helper.DoubleTap, () => new GestureEventArgs(_gestureOrigin, samplePosition), releaseMouseCapture: false);
					continue;
				case 3:
					RaiseGestureEvent((GestureListener helper) => helper.Hold, () => new GestureEventArgs(_gestureOrigin, samplePosition), releaseMouseCapture: false);
					continue;
				case 2:
					continue;
				}
				if ((int)gestureType != 32)
				{
					if ((int)gestureType != 64)
					{
						continue;
					}
					if (!_isPinching)
					{
						_isPinching = true;
						_pinchOrigin = samplePosition;
						_pinchOrigin2 = samplePosition2;
						RaiseGestureEvent((GestureListener helper) => helper.PinchStarted, () => new PinchStartedGestureEventArgs(_pinchOrigin, _pinchOrigin2, _pinchOrigin, _pinchOrigin2), releaseMouseCapture: true);
					}
					_lastSamplePosition = samplePosition;
					_lastSamplePosition2 = samplePosition2;
					RaiseGestureEvent((GestureListener helper) => helper.PinchDelta, () => new PinchGestureEventArgs(_pinchOrigin, _pinchOrigin2, samplePosition, samplePosition2), releaseMouseCapture: false);
					continue;
				}
				if (sampleDelta.X == 0.0 && sampleDelta.Y == 0.0)
				{
					continue;
				}
				if (!_isDragging)
				{
					RaiseGestureEvent((GestureListener helper) => helper.DragStarted, () => new DragStartedGestureEventArgs(_gestureOrigin, _gestureOrientation.Value), releaseMouseCapture: true);
					_isDragging = true;
				}
				delta.X += sampleDelta.X;
				delta.Y += sampleDelta.Y;
				_lastSamplePosition = samplePosition;
			}
			else if ((int)gestureType != 128)
			{
				if ((int)gestureType != 256)
				{
					if ((int)gestureType == 512)
					{
						_isPinching = false;
						RaiseGestureEvent((GestureListener helper) => helper.PinchCompleted, () => new PinchGestureEventArgs(_pinchOrigin, _pinchOrigin2, _lastSamplePosition, _lastSamplePosition2), releaseMouseCapture: false);
						double num = (_cumulativeDelta2.Y = 0.0);
						double num3 = (_cumulativeDelta2.X = num);
						double x = (_cumulativeDelta.Y = num3);
						_cumulativeDelta.X = x;
						_gestureOriginChanged = true;
					}
					continue;
				}
				if (!_flicked && (delta.X != 0.0 || delta.Y != 0.0))
				{
					RaiseGestureEvent((GestureListener helper) => helper.DragDelta, () => new DragDeltaGestureEventArgs(_gestureOrigin, samplePosition, delta, _gestureOrientation.Value), releaseMouseCapture: false);
					ref Point reference2 = ref delta;
					double x2 = (delta.Y = 0.0);
					reference2.X = x2;
				}
				if (_isDragging)
				{
					RaiseGestureEvent((GestureListener helper) => helper.DragCompleted, () => new DragCompletedGestureEventArgs(_gestureOrigin, _lastSamplePosition, _cumulativeDelta, _gestureOrientation.Value, _finalVelocity), releaseMouseCapture: false);
					ref Point reference3 = ref delta;
					double x3 = (delta.Y = 0.0);
					reference3.X = x3;
				}
				double x4 = (_cumulativeDelta.Y = 0.0);
				_cumulativeDelta.X = x4;
				_flicked = (_isDragging = false);
				_gestureOriginChanged = true;
			}
			else
			{
				_flicked = true;
				_finalVelocity = sampleDelta;
				RaiseGestureEvent((GestureListener helper) => helper.Flick, () => new FlickGestureEventArgs(_gestureOrigin, sampleDelta), releaseMouseCapture: true);
			}
		}
		if (!_flicked && (delta.X != 0.0 || delta.Y != 0.0))
		{
			RaiseGestureEvent((GestureListener helper) => helper.DragDelta, () => new DragDeltaGestureEventArgs(_gestureOrigin, _lastSamplePosition, delta, _gestureOrientation.Value), releaseMouseCapture: false);
		}
	}

	private static void GetTranslatedDelta(ref GeneralTransform deltaTransform, ref Point sampleDelta, ref Point cumulativeDelta, bool addToCumulative)
	{
		if (sampleDelta.X != 0.0 || sampleDelta.Y != 0.0)
		{
			if (deltaTransform == null)
			{
				deltaTransform = GetInverseRootTransformNoOffset();
			}
			sampleDelta = deltaTransform.Transform(sampleDelta);
			if (addToCumulative)
			{
				cumulativeDelta.X += sampleDelta.X;
				cumulativeDelta.Y += sampleDelta.Y;
			}
		}
	}

	private static GeneralTransform GetInverseRootTransformNoOffset()
	{
		GeneralTransform inverse = Application.Current.RootVisual.TransformToVisual(null).Inverse;
		if (inverse is MatrixTransform { Matrix: var matrix } matrixTransform)
		{
			double offsetX = (matrix.OffsetY = 0.0);
			matrix.OffsetX = offsetX;
			matrixTransform.Matrix = matrix;
		}
		return inverse;
	}

	private static void RaiseGestureEvent<T>(Func<GestureListener, EventHandler<T>> eventGetter, Func<T> argsGetter, bool releaseMouseCapture) where T : GestureEventArgs
	{
		T args = null;
		FrameworkElement originalSource = null;
		bool flag = false;
		foreach (FrameworkElement element in _elements)
		{
			if (releaseMouseCapture)
			{
				element.ReleaseMouseCapture();
			}
			if (flag)
			{
				continue;
			}
			if (originalSource == null)
			{
				originalSource = element;
			}
			GestureListener gestureListenerInternal = GestureService.GetGestureListenerInternal(element, createIfMissing: false);
			if (gestureListenerInternal != null)
			{
				Microsoft.Phone.Controls.SafeRaise.Raise(eventGetter(gestureListenerInternal), element, delegate
				{
					if (args == null)
					{
						args = argsGetter();
						ref T reference = ref args;
						FrameworkElement originalSource2 = originalSource;
						reference.OriginalSource = originalSource2;
					}
					return args;
				});
			}
			if (args != null && args.Handled)
			{
				flag = true;
			}
		}
	}
}
