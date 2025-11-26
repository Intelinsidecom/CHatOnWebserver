using System.Windows;

namespace Microsoft.Phone.Gestures;

internal abstract class InputDeltaArgs : InputBaseArgs
{
	public abstract Point DeltaTranslation { get; }

	public abstract Point CumulativeTranslation { get; }

	public abstract Point ExpansionVelocity { get; }

	public abstract Point LinearVelocity { get; }

	protected InputDeltaArgs(UIElement source, Point origin)
		: base(source, origin)
	{
	}
}
