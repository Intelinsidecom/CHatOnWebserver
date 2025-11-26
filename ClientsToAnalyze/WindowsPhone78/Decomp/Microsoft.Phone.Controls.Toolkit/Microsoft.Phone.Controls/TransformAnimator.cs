using System;
using System.Linq;
using System.Windows;
using System.Windows.Media;
using System.Windows.Media.Animation;

namespace Microsoft.Phone.Controls;

internal sealed class TransformAnimator
{
	private static readonly PropertyPath TranslateXPropertyPath = new PropertyPath("X");

	private readonly Storyboard _sbRunning = new Storyboard();

	private readonly DoubleAnimation _daRunning = new DoubleAnimation();

	private TranslateTransform _transform;

	private Action _oneTimeAction;

	public double CurrentOffset => _transform.X;

	public TransformAnimator(TranslateTransform translateTransform)
	{
		_transform = translateTransform;
		_sbRunning.Completed += OnCompleted;
		_sbRunning.Children.Add(_daRunning);
		Storyboard.SetTarget(_daRunning, _transform);
		Storyboard.SetTargetProperty(_daRunning, TranslateXPropertyPath);
	}

	public void GoTo(double targetOffset, Duration duration)
	{
		GoTo(targetOffset, duration, null, null);
	}

	public void GoTo(double targetOffset, Duration duration, Action completionAction)
	{
		GoTo(targetOffset, duration, null, completionAction);
	}

	public void GoTo(double targetOffset, Duration duration, IEasingFunction easingFunction)
	{
		GoTo(targetOffset, duration, easingFunction, null);
	}

	public void GoTo(double targetOffset, Duration duration, IEasingFunction easingFunction, Action completionAction)
	{
		_daRunning.To = targetOffset;
		_daRunning.Duration = duration;
		_daRunning.EasingFunction = easingFunction;
		_sbRunning.Begin();
		_sbRunning.SeekAlignedToLastTick(TimeSpan.Zero);
		_oneTimeAction = completionAction;
	}

	public void UpdateEasingFunction(IEasingFunction ease)
	{
		if (_daRunning != null && _daRunning.EasingFunction != ease)
		{
			_daRunning.EasingFunction = ease;
		}
	}

	public void UpdateDuration(Duration duration)
	{
		if (_daRunning != null)
		{
			_daRunning.Duration = duration;
		}
	}

	private void OnCompleted(object sender, EventArgs e)
	{
		Action oneTimeAction = _oneTimeAction;
		if (oneTimeAction != null && _sbRunning.GetCurrentState() != ClockState.Active)
		{
			_oneTimeAction = null;
			oneTimeAction();
		}
	}

	public static void EnsureAnimator(FrameworkElement targetElement, ref Microsoft.Phone.Controls.TransformAnimator animator)
	{
		if (animator == null)
		{
			TranslateTransform translateTransform = GetTranslateTransform(targetElement);
			if (translateTransform != null)
			{
				animator = new Microsoft.Phone.Controls.TransformAnimator(translateTransform);
			}
		}
		if (animator == null)
		{
			throw new InvalidOperationException("The animation system could not be prepared for the target element.");
		}
	}

	public static TranslateTransform GetTranslateTransform(UIElement container)
	{
		if (container == null)
		{
			throw new ArgumentNullException("container");
		}
		TranslateTransform translateTransform = container.RenderTransform as TranslateTransform;
		if (translateTransform == null)
		{
			if (container.RenderTransform == null)
			{
				translateTransform = (TranslateTransform)(container.RenderTransform = new TranslateTransform());
			}
			else if (container.RenderTransform is TransformGroup)
			{
				TransformGroup transformGroup = container.RenderTransform as TransformGroup;
				translateTransform = (from t in transformGroup.Children
					where t is TranslateTransform
					select (TranslateTransform)t).FirstOrDefault();
				if (translateTransform == null)
				{
					translateTransform = new TranslateTransform();
					transformGroup.Children.Add(translateTransform);
				}
			}
			else
			{
				TransformGroup transformGroup2 = new TransformGroup();
				Transform renderTransform = container.RenderTransform;
				container.RenderTransform = null;
				transformGroup2.Children.Add(renderTransform);
				translateTransform = new TranslateTransform();
				transformGroup2.Children.Add(translateTransform);
				container.RenderTransform = transformGroup2;
			}
		}
		return translateTransform;
	}
}
