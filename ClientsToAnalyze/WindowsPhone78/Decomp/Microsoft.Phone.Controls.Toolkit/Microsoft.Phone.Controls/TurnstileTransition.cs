using System.Windows;

namespace Microsoft.Phone.Controls;

public class TurnstileTransition : TransitionElement
{
	public static readonly DependencyProperty ModeProperty = DependencyProperty.Register("Mode", typeof(TurnstileTransitionMode), typeof(TurnstileTransition), null);

	public TurnstileTransitionMode Mode
	{
		get
		{
			return (TurnstileTransitionMode)GetValue(ModeProperty);
		}
		set
		{
			SetValue(ModeProperty, value);
		}
	}

	public override ITransition GetTransition(UIElement element)
	{
		return Transitions.Turnstile(element, Mode);
	}
}
