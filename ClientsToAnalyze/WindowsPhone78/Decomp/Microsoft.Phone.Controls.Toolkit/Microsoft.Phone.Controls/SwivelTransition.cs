using System.Windows;

namespace Microsoft.Phone.Controls;

public class SwivelTransition : TransitionElement
{
	public static readonly DependencyProperty ModeProperty = DependencyProperty.Register("Mode", typeof(SwivelTransitionMode), typeof(SwivelTransition), null);

	public SwivelTransitionMode Mode
	{
		get
		{
			return (SwivelTransitionMode)GetValue(ModeProperty);
		}
		set
		{
			SetValue(ModeProperty, value);
		}
	}

	public override ITransition GetTransition(UIElement element)
	{
		return Transitions.Swivel(element, Mode);
	}
}
