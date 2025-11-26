using System.Device.Location;
using System.Windows;

namespace Microsoft.Phone.Controls.Maps.Core;

public class NullMode : MapMode
{
	public NullMode()
	{
		base.Center = new GeoCoordinate(0.0, 0.0);
	}

	public override void SetView(GeoCoordinate center, double zoomLevel, double heading, double pitch, bool animate)
	{
		Center = center;
		ZoomLevel = zoomLevel;
		Heading = heading;
		Pitch = pitch;
		OnTargetViewChanged();
	}

	public override void SetView(LocationRect boundingRectangle, bool animate)
	{
		OnTargetViewChanged();
	}

	public override Point LocationToViewportPoint(GeoCoordinate location)
	{
		return default(Point);
	}

	public override bool TryLocationToViewportPoint(GeoCoordinate location, out Point viewportPoint)
	{
		viewportPoint = default(Point);
		return true;
	}

	public override GeoCoordinate ViewportPointToLocation(Point viewportPoint)
	{
		return new GeoCoordinate(0.0, 0.0);
	}

	public override bool TryViewportPointToLocation(Point viewportPoint, out GeoCoordinate location)
	{
		location = new GeoCoordinate(0.0, 0.0);
		return true;
	}
}
