using System.Collections.Generic;
using System.Device.Location;
using System.Globalization;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class CopyrightResult
{
	public IList<string> CopyrightStrings { get; private set; }

	public CultureInfo Culture { get; private set; }

	public GeoCoordinate Location { get; private set; }

	public double ZoomLevel { get; private set; }

	internal CopyrightResult(IList<string> copyrightStrings, CultureInfo culture, GeoCoordinate location, double zoomLevel)
	{
		CopyrightStrings = copyrightStrings;
		Culture = culture;
		Location = location;
		ZoomLevel = zoomLevel;
	}
}
