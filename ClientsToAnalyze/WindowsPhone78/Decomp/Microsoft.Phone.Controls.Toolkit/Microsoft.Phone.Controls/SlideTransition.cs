using System.Windows;

namespace Microsoft.Phone.Controls;

public class SlideTransition : TransitionElement
{
	public static readonly DependencyProperty ModeProperty = DependencyProperty.Register("Mode", typeof(SlideTransitionMode), typeof(SlideTransition), null);

	public SlideTransitionMode Mode
	{
		get
		{
			return (SlideTransitionMode)GetValue(ModeProperty);
		}
		set
		{
			SetValue(ModeProperty, value);
		}
	}

	public override ITransition GetTransition(UIElement element)
	{
		return Transitions.Slide(element, Mode);
	}
}
