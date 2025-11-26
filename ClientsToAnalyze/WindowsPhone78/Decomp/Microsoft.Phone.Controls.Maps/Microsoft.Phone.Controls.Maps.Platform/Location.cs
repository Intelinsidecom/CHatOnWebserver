using System;
using System.Device.Location;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.Platform;

[DataContract(Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
public class Location : IFormattable
{
	[DataMember]
	public double Latitude { get; set; }

	[DataMember]
	public double Longitude { get; set; }

	[DataMember]
	public double Altitude { get; set; }

	string IFormattable.ToString(string format, IFormatProvider provider)
	{
		return string.Format(provider, "{0:" + format + "},{1:" + format + "},{2:" + format + "}", Latitude, Longitude, Altitude);
	}

	public override string ToString()
	{
		return ((IFormattable)this).ToString((string)null, (IFormatProvider)null);
	}

	public string ToString(IFormatProvider provider)
	{
		return ((IFormattable)this).ToString((string)null, provider);
	}

	public static implicit operator GeoCoordinate(Location obj)
	{
		GeoCoordinate geoCoordinate = new GeoCoordinate();
		geoCoordinate.Latitude = obj.Latitude;
		geoCoordinate.Longitude = obj.Longitude;
		geoCoordinate.Altitude = obj.Altitude;
		return geoCoordinate;
	}

	public static implicit operator Location(GeoCoordinate obj)
	{
		Location location = new Location();
		location.Latitude = obj.Latitude;
		location.Longitude = obj.Longitude;
		location.Altitude = (double.IsNaN(obj.Altitude) ? 0.0 : obj.Altitude);
		return location;
	}
}
