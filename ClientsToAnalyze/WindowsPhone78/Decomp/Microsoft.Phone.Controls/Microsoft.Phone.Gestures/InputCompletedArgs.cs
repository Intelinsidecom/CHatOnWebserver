using System.Windows;

namespace Microsoft.Phone.Gestures;

internal abstract class InputCompletedArgs : InputBaseArgs
{
	public abstract Point TotalTranslation { get; }

	public abstract Point FinalLinearVelocity { get; }

	public abstract bool IsInertial { get; }

	protected InputCompletedArgs(UIElement source, Point origin)
		: base(source, origin)
	{
	}
}
