using System.Device.Location;

namespace ChatOn.Models;

public class AttachedLocation : Attachment
{
	private GeoCoordinate _location;

	public GeoCoordinate LocationInfo
	{
		get
		{
			return _location;
		}
		set
		{
			_location = value;
		}
	}

	public AttachedLocation()
	{
		base.AttachedMediaType = MediaType.LOCATION;
		base.ContentType = "application/x-map";
	}
}
