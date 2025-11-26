using System;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class PinchStretchEventArgs : EventArgs
{
	internal PinchStretchData Data { get; set; }

	internal PinchStretchEventArgs(PinchStretchData data)
	{
		Data = data;
	}
}
