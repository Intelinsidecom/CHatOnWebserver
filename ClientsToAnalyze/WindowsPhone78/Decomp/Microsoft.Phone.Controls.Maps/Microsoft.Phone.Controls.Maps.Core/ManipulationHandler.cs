using System;
using System.Windows;
using System.Windows.Input;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class ManipulationHandler
{
	private const ushort TapDistanceThreshold = 30;

	private const ushort DoubleTapTimeThreshold = 500;

	private const ushort TapAndHoldTimeThreshold = 2000;

	private const ushort DragThresholdForFlick = 3;

	private bool isTap;

	private bool isTapPending;

	private Timeout lastTap;

	private Point lastTapOrigin;

	private long lastTapTimestamp;

	private long tapStartTimestamp;

	private UIElement root;

	private Point lastTranslation;

	public event EventHandler<GestureEventArgs> Tap;

	public event EventHandler<GestureEventArgs> DoubleTap;

	public event EventHandler<GestureEventArgs> TapAndHold;

	public event EventHandler<GestureEventArgs> Pan;

	public event EventHandler<GestureEventArgs> Flick;

	public event EventHandler<GestureEventArgs> Pinch;

	public event EventHandler<GestureEventArgs> Stretch;

	private static bool IsDoubleTap(Point previousPoint, long previousTimestamp, Point currentPoint, long currentTimestamp)
	{
		if (!PhysicsHelper.ExceedsThreshold(TimeSpan.FromTicks(currentTimestamp - previousTimestamp), 500L) && !PhysicsHelper.ExceedsThreshold(PhysicsHelper.Delta(previousPoint, currentPoint), 30L))
		{
			return true;
		}
		return false;
	}

	public ManipulationHandler(UIElement element)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		element.ManipulationStarted += OnManipulationStarted;
		element.ManipulationCompleted += OnManipulationCompleted;
		element.ManipulationDelta += OnManipulationDelta;
		root = element;
	}

	internal void Unload()
	{
		if (lastTap != null)
		{
			lastTap.Cancel();
		}
	}

	private void OnManipulationStarted(object sender, ManipulationStartedEventArgs e)
	{
		if (!e.Handled)
		{
			e.Handled = true;
			isTap = true;
			tapStartTimestamp = DateTime.Now.Ticks;
		}
	}

	private void OnManipulationDelta(object sender, ManipulationDeltaEventArgs e)
	{
		DateTime now = DateTime.Now;
		if (e.Handled)
		{
			return;
		}
		e.Handled = true;
		UIElement uIElement = e.OriginalSource as UIElement;
		UIElement uIElement2 = sender as UIElement;
		if (uIElement == null || uIElement2 == null)
		{
			return;
		}
		Point origin = uIElement.TransformToVisual(uIElement2).Transform(e.ManipulationOrigin);
		bool flag = false;
		bool flag2 = false;
		if (e.DeltaManipulation.Scale.X > 0.0 && e.DeltaManipulation.Scale.Y > 0.0 && (Math.Abs(1.0 - e.DeltaManipulation.Scale.X) > 0.02 || Math.Abs(1.0 - e.DeltaManipulation.Scale.Y) > 0.02))
		{
			flag = true;
		}
		if (!flag && (Math.Abs(e.DeltaManipulation.Translation.X) > 2.0 || Math.Abs(e.DeltaManipulation.Translation.Y) > 2.0))
		{
			flag2 = Math.Abs(e.CumulativeManipulation.Translation.X) > 30.0 || Math.Abs(e.CumulativeManipulation.Translation.Y) > 30.0;
		}
		if (flag || flag2)
		{
			isTap = false;
			if (lastTap != null)
			{
				lastTap.DoItNow();
				lastTap = null;
			}
		}
		if (isTap && PhysicsHelper.ExceedsThreshold(TimeSpan.FromTicks(now.Ticks - tapStartTimestamp), 2000L))
		{
			FireTapAndHoldEvent(sender, new TapAndHoldGestureEventArgs
			{
				Origin = origin
			});
			isTap = false;
			e.Complete();
		}
		if (flag)
		{
			if (e.DeltaManipulation.Scale.X < 1.0 || e.DeltaManipulation.Scale.Y < 1.0)
			{
				FirePinchEvent(sender, new PinchGestureEventArgs
				{
					Origin = origin,
					Scale = e.DeltaManipulation.Scale
				});
			}
			else
			{
				FireStretchEvent(sender, new StretchGestureEventArgs
				{
					Origin = origin,
					Scale = e.DeltaManipulation.Scale
				});
			}
		}
		else if (flag2)
		{
			FirePanEvent(sender, new PanGestureEventArgs
			{
				Origin = origin,
				Translation = e.DeltaManipulation.Translation
			});
		}
		lastTranslation = e.DeltaManipulation.Translation;
	}

	private void OnManipulationCompleted(object sender, ManipulationCompletedEventArgs e)
	{
		DateTime now = DateTime.Now;
		if (e.Handled)
		{
			return;
		}
		e.Handled = true;
		UIElement uIElement = e.OriginalSource as UIElement;
		UIElement uIElement2 = sender as UIElement;
		if (uIElement == null || uIElement2 == null)
		{
			return;
		}
		Point origin = uIElement.TransformToVisual(uIElement2).Transform(e.ManipulationOrigin);
		if (isTap)
		{
			if (isTapPending && IsDoubleTap(lastTapOrigin, lastTapTimestamp, origin, now.Ticks))
			{
				if (lastTap != null)
				{
					lastTap.Cancel();
					lastTap = null;
				}
				isTapPending = false;
				FireDoubleTapEvent(sender, new DoubleTapGestureEventArgs
				{
					Origin = origin
				});
			}
			else
			{
				if (lastTap != null)
				{
					lastTap.DoItNow();
					lastTap = null;
				}
				isTapPending = true;
				lastTapTimestamp = now.Ticks;
				lastTapOrigin = origin;
				lastTap = new Timeout(delegate
				{
					FireTapEvent(sender, new TapGestureEventArgs
					{
						Origin = origin
					});
				}, 600L);
			}
		}
		else
		{
			isTapPending = false;
		}
		if (e.IsInertial && (Math.Abs(lastTranslation.X) > 3.0 || Math.Abs(lastTranslation.Y) > 3.0) && e.TotalManipulation.Scale.X == 0.0 && e.TotalManipulation.Scale.Y == 0.0)
		{
			FireFlickEvent(sender, new FlickGestureEventArgs
			{
				Origin = origin,
				Velocity = e.FinalVelocities.LinearVelocity
			});
		}
	}

	private void FireTapEvent(object sender, GestureEventArgs e)
	{
		this.Tap?.Invoke(sender, e);
	}

	private void FireDoubleTapEvent(object sender, GestureEventArgs e)
	{
		this.DoubleTap?.Invoke(sender, e);
	}

	private void FireTapAndHoldEvent(object sender, GestureEventArgs e)
	{
		this.TapAndHold?.Invoke(sender, e);
	}

	private void FirePanEvent(object sender, GestureEventArgs e)
	{
		this.Pan?.Invoke(sender, e);
	}

	private void FireFlickEvent(object sender, GestureEventArgs e)
	{
		this.Flick?.Invoke(sender, e);
	}

	private void FirePinchEvent(object sender, GestureEventArgs e)
	{
		this.Pinch?.Invoke(sender, e);
	}

	private void FireStretchEvent(object sender, GestureEventArgs e)
	{
		this.Stretch?.Invoke(sender, e);
	}
}
