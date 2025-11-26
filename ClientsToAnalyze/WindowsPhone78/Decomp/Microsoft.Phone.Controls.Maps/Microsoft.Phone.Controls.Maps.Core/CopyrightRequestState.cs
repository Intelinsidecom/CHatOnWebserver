using System;
using System.Device.Location;
using System.Globalization;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class CopyrightRequestState
{
	internal CultureInfo Culture { get; private set; }

	internal MapStyle Style { get; private set; }

	internal GeoCoordinate Location { get; private set; }

	internal double ZoomLevel { get; private set; }

	internal Credentials Credentials { get; private set; }

	internal Action<CopyrightResult> CopyrightCallback { get; private set; }

	internal CopyrightRequestState(CultureInfo _culture, MapStyle _style, GeoCoordinate _location, double _zoomLevel, Credentials _credentials, Action<CopyrightResult> _copyrightCallback)
	{
		Culture = _culture;
		Style = _style;
		Location = _location;
		ZoomLevel = _zoomLevel;
		Credentials = _credentials;
		CopyrightCallback = _copyrightCallback;
	}
}
