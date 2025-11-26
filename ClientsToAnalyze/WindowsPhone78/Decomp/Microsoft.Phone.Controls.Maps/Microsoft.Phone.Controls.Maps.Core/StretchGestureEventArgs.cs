namespace Microsoft.Phone.Controls.Maps.Core;

internal class StretchGestureEventArgs : ScaleGestureEventArgs
{
	public override GestureType GestureType => GestureType.Stretch;
}
