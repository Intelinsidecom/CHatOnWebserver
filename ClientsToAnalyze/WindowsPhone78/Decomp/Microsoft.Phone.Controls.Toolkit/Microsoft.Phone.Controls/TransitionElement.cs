using System.Windows;

namespace Microsoft.Phone.Controls;

public abstract class TransitionElement : DependencyObject
{
	public abstract ITransition GetTransition(UIElement element);
}
