using System.Windows;

namespace Microsoft.Phone.Controls.Maps.Core;

internal abstract class ScaleGestureEventArgs : GestureEventArgs
{
	public Point Scale { get; set; }
}
