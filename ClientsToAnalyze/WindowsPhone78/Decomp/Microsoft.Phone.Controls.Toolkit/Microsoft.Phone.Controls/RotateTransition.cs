using System.Windows;

namespace Microsoft.Phone.Controls;

public class RotateTransition : TransitionElement
{
	public static readonly DependencyProperty ModeProperty = DependencyProperty.Register("Mode", typeof(RotateTransitionMode), typeof(RotateTransition), null);

	public RotateTransitionMode Mode
	{
		get
		{
			return (RotateTransitionMode)GetValue(ModeProperty);
		}
		set
		{
			SetValue(ModeProperty, value);
		}
	}

	public override ITransition GetTransition(UIElement element)
	{
		return Transitions.Rotate(element, Mode);
	}
}
