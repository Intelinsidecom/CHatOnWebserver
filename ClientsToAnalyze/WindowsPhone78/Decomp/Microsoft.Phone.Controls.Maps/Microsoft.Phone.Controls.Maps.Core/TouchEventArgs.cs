using System;
using System.Windows.Input;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class TouchEventArgs : EventArgs
{
	public TouchPoint TouchPoint { get; private set; }

	internal TouchEventArgs(TouchPoint touchPoint)
	{
		TouchPoint = touchPoint;
	}
}
