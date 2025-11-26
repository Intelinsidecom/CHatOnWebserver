using System.Windows;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class FlickGestureEventArgs : GestureEventArgs
{
	public override GestureType GestureType => GestureType.Flick;

	public Point Velocity { get; set; }
}
