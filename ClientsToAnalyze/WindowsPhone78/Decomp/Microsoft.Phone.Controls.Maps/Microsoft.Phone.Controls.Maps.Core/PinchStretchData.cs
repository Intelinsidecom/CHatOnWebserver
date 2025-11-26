using System.Windows;

namespace Microsoft.Phone.Controls.Maps.Core;

internal struct PinchStretchData
{
	internal double Scale;

	internal Point ContactPoint1 { get; set; }

	internal Point ContactPoint1Delta { get; set; }

	internal Point ContactPoint2 { get; set; }

	internal Point ContactPoint2Delta { get; set; }

	internal Point CenterPoint { get; set; }

	internal Point CenterPointDelta { get; set; }
}
