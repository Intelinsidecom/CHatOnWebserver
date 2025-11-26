using System.Windows;

namespace Microsoft.Phone.Controls;

public class RollTransition : TransitionElement
{
	public override ITransition GetTransition(UIElement element)
	{
		return Transitions.Roll(element);
	}
}
