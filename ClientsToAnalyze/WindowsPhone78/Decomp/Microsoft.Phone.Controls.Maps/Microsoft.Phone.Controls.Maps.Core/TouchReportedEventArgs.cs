using System;
using System.Collections.Generic;
using System.Windows;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class TouchReportedEventArgs : EventArgs
{
	public IEnumerable<Point> TouchPoints { get; private set; }

	internal TouchReportedEventArgs(IEnumerable<Point> touchPoints)
	{
		TouchPoints = touchPoints;
	}
}
