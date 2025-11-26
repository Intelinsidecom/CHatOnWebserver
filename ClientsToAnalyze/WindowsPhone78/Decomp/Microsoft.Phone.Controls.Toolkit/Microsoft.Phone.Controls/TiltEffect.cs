using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;

namespace Microsoft.Phone.Controls;

public class TiltEffect : DependencyObject
{
	private class LogarithmicEase : EasingFunctionBase
	{
		protected override double EaseInCore(double normalizedTime)
		{
			return Math.Log(normalizedTime + 1.0) / 0.693147181;
		}
	}

	private const double MaxAngle = 0.3;

	private const double MaxDepression = 25.0;

	private static Dictionary<DependencyObject, CacheMode> _originalCacheMode;

	private static readonly TimeSpan TiltReturnAnimationDelay;

	private static readonly TimeSpan TiltReturnAnimationDuration;

	private static FrameworkElement currentTiltElement;

	private static Storyboard tiltReturnStoryboard;

	private static DoubleAnimation tiltReturnXAnimation;

	private static DoubleAnimation tiltReturnYAnimation;

	private static DoubleAnimation tiltReturnZAnimation;

	private static Point currentTiltElementCenter;

	private static bool wasPauseAnimation;

	public static readonly DependencyProperty IsTiltEnabledProperty;

	public static readonly DependencyProperty SuppressTiltProperty;

	public static bool UseLogarithmicEase { get; set; }

	public static List<Type> TiltableItems { get; private set; }

	private TiltEffect()
	{
	}

	static TiltEffect()
	{
		_originalCacheMode = new Dictionary<DependencyObject, CacheMode>();
		TiltReturnAnimationDelay = TimeSpan.FromMilliseconds(200.0);
		TiltReturnAnimationDuration = TimeSpan.FromMilliseconds(100.0);
		wasPauseAnimation = false;
		IsTiltEnabledProperty = DependencyProperty.RegisterAttached("IsTiltEnabled", typeof(bool), typeof(TiltEffect), new PropertyMetadata(OnIsTiltEnabledChanged));
		SuppressTiltProperty = DependencyProperty.RegisterAttached("SuppressTilt", typeof(bool), typeof(TiltEffect), null);
		TiltableItems = new List<Type>
		{
			typeof(ButtonBase),
			typeof(ListBoxItem),
			typeof(MenuItem)
		};
	}

	public static bool GetIsTiltEnabled(DependencyObject source)
	{
		return (bool)source.GetValue(IsTiltEnabledProperty);
	}

	public static void SetIsTiltEnabled(DependencyObject source, bool value)
	{
		source.SetValue(IsTiltEnabledProperty, value);
	}

	public static bool GetSuppressTilt(DependencyObject source)
	{
		return (bool)source.GetValue(SuppressTiltProperty);
	}

	public static void SetSuppressTilt(DependencyObject source, bool value)
	{
		source.SetValue(SuppressTiltProperty, value);
	}

	private static void OnIsTiltEnabledChanged(DependencyObject target, DependencyPropertyChangedEventArgs args)
	{
		if (target is FrameworkElement frameworkElement)
		{
			if ((bool)args.NewValue)
			{
				frameworkElement.ManipulationStarted += TiltEffect_ManipulationStarted;
			}
			else
			{
				frameworkElement.ManipulationStarted -= TiltEffect_ManipulationStarted;
			}
		}
	}

	private static void TiltEffect_ManipulationStarted(object sender, ManipulationStartedEventArgs e)
	{
		TryStartTiltEffect(sender as FrameworkElement, e);
	}

	private static void TiltEffect_ManipulationDelta(object sender, ManipulationDeltaEventArgs e)
	{
		ContinueTiltEffect(sender as FrameworkElement, e);
	}

	private static void TiltEffect_ManipulationCompleted(object sender, ManipulationCompletedEventArgs e)
	{
		EndTiltEffect(currentTiltElement);
	}

	private static void TryStartTiltEffect(FrameworkElement source, ManipulationStartedEventArgs e)
	{
		FrameworkElement frameworkElement = e.OriginalSource as FrameworkElement;
		FrameworkElement frameworkElement2 = frameworkElement.Parent as FrameworkElement;
		if (frameworkElement.Tag != null || (frameworkElement2 != null && frameworkElement2.Tag != null))
		{
			if (frameworkElement.Tag == null)
			{
				frameworkElement = frameworkElement2;
			}
			string text = frameworkElement.Tag as string;
			if (!string.IsNullOrEmpty(text) && text == "tilt")
			{
				FrameworkElement frameworkElement3 = frameworkElement;
				FrameworkElement frameworkElement4 = e.ManipulationContainer as FrameworkElement;
				if (frameworkElement3 != null && frameworkElement4 != null)
				{
					Point touchPoint = frameworkElement4.TransformToVisual(frameworkElement3).Transform(e.ManipulationOrigin);
					Point centerPoint = new Point(frameworkElement3.ActualWidth / 2.0, frameworkElement3.ActualHeight / 2.0);
					Point centerToCenterDelta = GetCenterToCenterDelta(frameworkElement3, source);
					BeginTiltEffect(frameworkElement3, touchPoint, centerPoint, centerToCenterDelta);
				}
				return;
			}
		}
		foreach (FrameworkElement visualAncestor in (e.OriginalSource as FrameworkElement).GetVisualAncestors())
		{
			foreach (Type tiltableItem in TiltableItems)
			{
				if (!tiltableItem.IsAssignableFrom(visualAncestor.GetType()))
				{
					continue;
				}
				FrameworkElement frameworkElement5 = null;
				frameworkElement5 = ((!(visualAncestor.ReadLocalValue(SuppressTiltProperty) is bool)) ? visualAncestor.GetVisualAncestors().FirstOrDefault((FrameworkElement x) => x.ReadLocalValue(SuppressTiltProperty) is bool) : visualAncestor);
				if (frameworkElement5 == null || !(bool)frameworkElement5.ReadLocalValue(SuppressTiltProperty))
				{
					FrameworkElement frameworkElement6 = VisualTreeHelper.GetChild(visualAncestor, 0) as FrameworkElement;
					FrameworkElement frameworkElement7 = e.ManipulationContainer as FrameworkElement;
					if (frameworkElement6 != null && frameworkElement7 != null)
					{
						Point touchPoint2 = frameworkElement7.TransformToVisual(frameworkElement6).Transform(e.ManipulationOrigin);
						Point centerPoint2 = new Point(frameworkElement6.ActualWidth / 2.0, frameworkElement6.ActualHeight / 2.0);
						Point centerToCenterDelta2 = GetCenterToCenterDelta(frameworkElement6, source);
						BeginTiltEffect(frameworkElement6, touchPoint2, centerPoint2, centerToCenterDelta2);
					}
					return;
				}
			}
		}
	}

	private static Point GetCenterToCenterDelta(FrameworkElement element, FrameworkElement container)
	{
		//IL_0032: Unknown result type (might be due to invalid IL or missing references)
		//IL_0038: Unknown result type (might be due to invalid IL or missing references)
		//IL_003a: Invalid comparison between Unknown and I4
		Point point = new Point(element.ActualWidth / 2.0, element.ActualHeight / 2.0);
		PhoneApplicationFrame val = (PhoneApplicationFrame)(object)((container is PhoneApplicationFrame) ? container : null);
		Point point2 = ((val == null) ? new Point(container.ActualWidth / 2.0, container.ActualHeight / 2.0) : (((val.Orientation & 2) != 2) ? new Point(container.ActualWidth / 2.0, container.ActualHeight / 2.0) : new Point(container.ActualHeight / 2.0, container.ActualWidth / 2.0)));
		Point point3 = element.TransformToVisual(container).Transform(point);
		return new Point(point2.X - point3.X, point2.Y - point3.Y);
	}

	private static void BeginTiltEffect(FrameworkElement element, Point touchPoint, Point centerPoint, Point centerDelta)
	{
		if (tiltReturnStoryboard != null)
		{
			StopTiltReturnStoryboardAndCleanup();
		}
		if (PrepareControlForTilt(element, centerDelta))
		{
			currentTiltElement = element;
			currentTiltElementCenter = centerPoint;
			PrepareTiltReturnStoryboard(element);
			ApplyTiltEffect(currentTiltElement, touchPoint, currentTiltElementCenter);
		}
	}

	private static bool PrepareControlForTilt(FrameworkElement element, Point centerDelta)
	{
		if (element.Projection != null || (element.RenderTransform != null && element.RenderTransform.GetType() != typeof(MatrixTransform)))
		{
			return false;
		}
		_originalCacheMode[element] = element.CacheMode;
		element.CacheMode = new BitmapCache();
		TranslateTransform translateTransform = new TranslateTransform();
		translateTransform.X = centerDelta.X;
		translateTransform.Y = centerDelta.Y;
		element.RenderTransform = translateTransform;
		PlaneProjection planeProjection = new PlaneProjection();
		planeProjection.GlobalOffsetX = -1.0 * centerDelta.X;
		planeProjection.GlobalOffsetY = -1.0 * centerDelta.Y;
		element.Projection = planeProjection;
		element.ManipulationDelta += TiltEffect_ManipulationDelta;
		element.ManipulationCompleted += TiltEffect_ManipulationCompleted;
		return true;
	}

	private static void RevertPrepareControlForTilt(FrameworkElement element)
	{
		element.ManipulationDelta -= TiltEffect_ManipulationDelta;
		element.ManipulationCompleted -= TiltEffect_ManipulationCompleted;
		element.Projection = null;
		element.RenderTransform = null;
		if (_originalCacheMode.TryGetValue(element, out var value))
		{
			element.CacheMode = value;
			_originalCacheMode.Remove(element);
		}
		else
		{
			element.CacheMode = null;
		}
	}

	private static void PrepareTiltReturnStoryboard(FrameworkElement element)
	{
		if (tiltReturnStoryboard == null)
		{
			tiltReturnStoryboard = new Storyboard();
			tiltReturnStoryboard.Completed += TiltReturnStoryboard_Completed;
			tiltReturnXAnimation = new DoubleAnimation();
			Storyboard.SetTargetProperty(tiltReturnXAnimation, new PropertyPath(PlaneProjection.RotationXProperty));
			tiltReturnXAnimation.BeginTime = TiltReturnAnimationDelay;
			tiltReturnXAnimation.To = 0.0;
			tiltReturnXAnimation.Duration = TiltReturnAnimationDuration;
			tiltReturnYAnimation = new DoubleAnimation();
			Storyboard.SetTargetProperty(tiltReturnYAnimation, new PropertyPath(PlaneProjection.RotationYProperty));
			tiltReturnYAnimation.BeginTime = TiltReturnAnimationDelay;
			tiltReturnYAnimation.To = 0.0;
			tiltReturnYAnimation.Duration = TiltReturnAnimationDuration;
			tiltReturnZAnimation = new DoubleAnimation();
			Storyboard.SetTargetProperty(tiltReturnZAnimation, new PropertyPath(PlaneProjection.GlobalOffsetZProperty));
			tiltReturnZAnimation.BeginTime = TiltReturnAnimationDelay;
			tiltReturnZAnimation.To = 0.0;
			tiltReturnZAnimation.Duration = TiltReturnAnimationDuration;
			if (UseLogarithmicEase)
			{
				tiltReturnXAnimation.EasingFunction = new LogarithmicEase();
				tiltReturnYAnimation.EasingFunction = new LogarithmicEase();
				tiltReturnZAnimation.EasingFunction = new LogarithmicEase();
			}
			tiltReturnStoryboard.Children.Add(tiltReturnXAnimation);
			tiltReturnStoryboard.Children.Add(tiltReturnYAnimation);
			tiltReturnStoryboard.Children.Add(tiltReturnZAnimation);
		}
		Storyboard.SetTarget(tiltReturnXAnimation, element.Projection);
		Storyboard.SetTarget(tiltReturnYAnimation, element.Projection);
		Storyboard.SetTarget(tiltReturnZAnimation, element.Projection);
	}

	private static void ContinueTiltEffect(FrameworkElement element, ManipulationDeltaEventArgs e)
	{
		if (e.ManipulationContainer is FrameworkElement frameworkElement && element != null)
		{
			Point point = frameworkElement.TransformToVisual(element).Transform(e.ManipulationOrigin);
			if (!new Rect(0.0, 0.0, currentTiltElement.ActualWidth, currentTiltElement.ActualHeight).Contains(point))
			{
				PauseTiltEffect();
			}
			else
			{
				ApplyTiltEffect(currentTiltElement, e.ManipulationOrigin, currentTiltElementCenter);
			}
		}
	}

	private static void EndTiltEffect(FrameworkElement element)
	{
		if (element != null)
		{
			element.ManipulationCompleted -= TiltEffect_ManipulationCompleted;
			element.ManipulationDelta -= TiltEffect_ManipulationDelta;
		}
		if (tiltReturnStoryboard != null)
		{
			wasPauseAnimation = false;
			if (tiltReturnStoryboard.GetCurrentState() != ClockState.Active)
			{
				tiltReturnStoryboard.Begin();
			}
		}
		else
		{
			StopTiltReturnStoryboardAndCleanup();
		}
	}

	private static void TiltReturnStoryboard_Completed(object sender, EventArgs e)
	{
		if (wasPauseAnimation)
		{
			ResetTiltEffect(currentTiltElement);
		}
		else
		{
			StopTiltReturnStoryboardAndCleanup();
		}
	}

	private static void ResetTiltEffect(FrameworkElement element)
	{
		PlaneProjection planeProjection = element.Projection as PlaneProjection;
		planeProjection.RotationY = 0.0;
		planeProjection.RotationX = 0.0;
		planeProjection.GlobalOffsetZ = 0.0;
	}

	private static void StopTiltReturnStoryboardAndCleanup()
	{
		if (tiltReturnStoryboard != null)
		{
			tiltReturnStoryboard.Stop();
		}
		RevertPrepareControlForTilt(currentTiltElement);
	}

	private static void PauseTiltEffect()
	{
		if (tiltReturnStoryboard != null && !wasPauseAnimation)
		{
			tiltReturnStoryboard.Stop();
			wasPauseAnimation = true;
			tiltReturnStoryboard.Begin();
		}
	}

	private static void ResetTiltReturnStoryboard()
	{
		tiltReturnStoryboard.Stop();
		wasPauseAnimation = false;
	}

	private static void ApplyTiltEffect(FrameworkElement element, Point touchPoint, Point centerPoint)
	{
		ResetTiltReturnStoryboard();
		Point point = new Point(Math.Min(Math.Max(touchPoint.X / (centerPoint.X * 2.0), 0.0), 1.0), Math.Min(Math.Max(touchPoint.Y / (centerPoint.Y * 2.0), 0.0), 1.0));
		double num = Math.Abs(point.X - 0.5);
		double num2 = Math.Abs(point.Y - 0.5);
		double num3 = -Math.Sign(point.X - 0.5);
		double num4 = Math.Sign(point.Y - 0.5);
		double num5 = num + num2;
		double num6 = ((num + num2 > 0.0) ? (num / (num + num2)) : 0.0);
		double num7 = num5 * 0.3 * 180.0 / Math.PI;
		double num8 = (1.0 - num5) * 25.0;
		PlaneProjection planeProjection = element.Projection as PlaneProjection;
		planeProjection.RotationY = num7 * num6 * num3;
		planeProjection.RotationX = num7 * (1.0 - num6) * num4;
		planeProjection.GlobalOffsetZ = 0.0 - num8;
	}
}
