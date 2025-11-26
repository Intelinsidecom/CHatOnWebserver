namespace Microsoft.Phone.Controls.Maps.Core;

internal class PinchGestureEventArgs : ScaleGestureEventArgs
{
	public override GestureType GestureType => GestureType.Pinch;
}
