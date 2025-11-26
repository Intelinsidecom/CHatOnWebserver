using System.Windows;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class PanGestureEventArgs : GestureEventArgs
{
	public override GestureType GestureType => GestureType.Pan;

	public Point Translation { get; set; }
}
