using System;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class TouchHandlers
{
	public EventHandler<TouchEventArgs> TouchDown { get; set; }

	public EventHandler<TouchEventArgs> CapturedTouchUp { get; set; }

	public EventHandler<TouchReportedEventArgs> CapturedTouchReported { get; set; }

	public EventHandler<TouchEventArgs> LostTouchCapture { get; set; }
}
