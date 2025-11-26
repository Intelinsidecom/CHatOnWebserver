using System;
using System.Windows;
using System.Windows.Media.Animation;

namespace Microsoft.Phone.Controls;

internal sealed class OpacityAnimator
{
	private static readonly PropertyPath OpacityPropertyPath = new PropertyPath("Opacity");

	private readonly Storyboard _sbRunning = new Storyboard();

	private readonly DoubleAnimation _daRunning = new DoubleAnimation();

	private bool _suppressChangeNotification;

	private Action _oneTimeAction;

	public OpacityAnimator(UIElement target)
	{
		_sbRunning.Completed += OnCompleted;
		_sbRunning.Children.Add(_daRunning);
		Storyboard.SetTarget(_daRunning, target);
		Storyboard.SetTargetProperty(_daRunning, OpacityPropertyPath);
	}

	public void GoTo(double targetOpacity, Duration duration)
	{
		GoTo(targetOpacity, duration, null, null);
	}

	public void GoTo(double targetOpacity, Duration duration, Action completionAction)
	{
		GoTo(targetOpacity, duration, null, completionAction);
	}

	public void GoTo(double targetOpacity, Duration duration, IEasingFunction easingFunction, Action completionAction)
	{
		_daRunning.To = targetOpacity;
		_daRunning.Duration = duration;
		_daRunning.EasingFunction = easingFunction;
		_sbRunning.Begin();
		_suppressChangeNotification = true;
		_sbRunning.SeekAlignedToLastTick(TimeSpan.Zero);
		_oneTimeAction = completionAction;
	}

	private void OnCompleted(object sender, EventArgs e)
	{
		Action oneTimeAction = _oneTimeAction;
		if (oneTimeAction != null)
		{
			_oneTimeAction = null;
			oneTimeAction();
		}
		if (!_suppressChangeNotification)
		{
			_suppressChangeNotification = false;
		}
	}

	public static void EnsureAnimator(UIElement targetElement, ref OpacityAnimator animator)
	{
		if (animator == null)
		{
			animator = new OpacityAnimator(targetElement);
		}
		if (animator == null)
		{
			throw new InvalidOperationException("The animation system could not be prepared for the target element.");
		}
	}
}
