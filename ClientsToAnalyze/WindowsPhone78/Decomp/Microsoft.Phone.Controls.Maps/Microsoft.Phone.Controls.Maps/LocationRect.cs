using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Device.Location;
using Microsoft.Phone.Controls.Maps.Design;

namespace Microsoft.Phone.Controls.Maps;

[TypeConverter(typeof(LocationRectConverter))]
public class LocationRect : IFormattable
{
	private const double MaxLatitude = 90.0;

	private const double MinLatitude = -90.0;

	private const double MaxLongitude = 180.0;

	private const double MinLongitude = -180.0;

	private GeoCoordinate center;

	private double halfHeight;

	private double halfWidth;

	public double North
	{
		get
		{
			return center.Latitude + halfHeight;
		}
		set
		{
			Init(value, West, South, East);
		}
	}

	public double West
	{
		get
		{
			if (halfWidth != 180.0)
			{
				return NormalizeLongitude(center.Longitude - halfWidth);
			}
			return -180.0;
		}
		set
		{
			Init(North, value, South, East);
		}
	}

	public double South
	{
		get
		{
			return center.Latitude - halfHeight;
		}
		set
		{
			Init(North, West, value, East);
		}
	}

	public double East
	{
		get
		{
			if (halfWidth != 180.0)
			{
				return NormalizeLongitude(center.Longitude + halfWidth);
			}
			return 180.0;
		}
		set
		{
			Init(North, West, South, value);
		}
	}

	public GeoCoordinate Center => center;

	public double Width => halfWidth * 2.0;

	public double Height => halfHeight * 2.0;

	public GeoCoordinate Northwest
	{
		get
		{
			GeoCoordinate geoCoordinate = new GeoCoordinate();
			geoCoordinate.Latitude = North;
			geoCoordinate.Longitude = West;
			return geoCoordinate;
		}
		set
		{
			if (center == null)
			{
				Init(value.Latitude, value.Longitude, value.Latitude, value.Longitude);
			}
			else
			{
				Init(value.Latitude, value.Longitude, South, East);
			}
		}
	}

	public GeoCoordinate Northeast
	{
		get
		{
			GeoCoordinate geoCoordinate = new GeoCoordinate();
			geoCoordinate.Latitude = North;
			geoCoordinate.Longitude = East;
			return geoCoordinate;
		}
		set
		{
			if (center == null)
			{
				Init(value.Latitude, value.Longitude, value.Latitude, value.Longitude);
			}
			else
			{
				Init(value.Latitude, West, South, value.Longitude);
			}
		}
	}

	public GeoCoordinate Southeast
	{
		get
		{
			GeoCoordinate geoCoordinate = new GeoCoordinate();
			geoCoordinate.Latitude = South;
			geoCoordinate.Longitude = East;
			return geoCoordinate;
		}
		set
		{
			if (center == null)
			{
				Init(value.Latitude, value.Longitude, value.Latitude, value.Longitude);
			}
			else
			{
				Init(North, West, value.Latitude, value.Longitude);
			}
		}
	}

	public GeoCoordinate Southwest
	{
		get
		{
			GeoCoordinate geoCoordinate = new GeoCoordinate();
			geoCoordinate.Latitude = South;
			geoCoordinate.Longitude = West;
			return geoCoordinate;
		}
		set
		{
			if (center == null)
			{
				Init(value.Latitude, value.Longitude, value.Latitude, value.Longitude);
			}
			else
			{
				Init(North, value.Longitude, value.Latitude, East);
			}
		}
	}

	public LocationRect()
	{
		center = new GeoCoordinate(0.0, 0.0);
	}

	public LocationRect(GeoCoordinate center, double width, double height)
	{
		this.center = center;
		halfWidth = width / 2.0;
		halfHeight = height / 2.0;
	}

	public LocationRect(double north, double west, double south, double east)
		: this()
	{
		Init(north, west, south, east);
	}

	public LocationRect(LocationRect rect)
	{
		center = new GeoCoordinate(rect.center.Latitude, rect.center.Longitude, rect.center.Altitude);
		halfHeight = rect.halfHeight;
		halfWidth = rect.halfWidth;
	}

	public static LocationRect CreateLocationRect(params GeoCoordinate[] locations)
	{
		return CreateLocationRect((IEnumerable<GeoCoordinate>)locations);
	}

	public static LocationRect CreateLocationRect(IEnumerable<GeoCoordinate> locations)
	{
		if (locations != null)
		{
			double num = -90.0;
			double num2 = 90.0;
			double num3 = 180.0;
			double num4 = -180.0;
			foreach (GeoCoordinate location in locations)
			{
				num = Math.Max(num, location.Latitude);
				num2 = Math.Min(num2, location.Latitude);
				num3 = Math.Min(num3, location.Longitude);
				num4 = Math.Max(num4, location.Longitude);
			}
			return new LocationRect(num, num3, num2, num4);
		}
		return new LocationRect();
	}

	private void Init(double north, double west, double south, double east)
	{
		if (west > east)
		{
			east += 360.0;
		}
		center = new GeoCoordinate
		{
			Latitude = (south + north) / 2.0,
			Longitude = NormalizeLongitude((west + east) / 2.0)
		};
		halfHeight = (north - south) / 2.0;
		halfWidth = Math.Abs(east - west) / 2.0;
	}

	string IFormattable.ToString(string format, IFormatProvider provider)
	{
		return string.Format(provider, "{0:" + format + "} {1:" + format + "}", Northwest, Southeast);
	}

	public bool Equals(LocationRect value)
	{
		return this == value;
	}

	public override int GetHashCode()
	{
		return center.GetHashCode() ^ halfWidth.GetHashCode() ^ halfHeight.GetHashCode();
	}

	public override bool Equals(object obj)
	{
		if (!(obj is LocationRect locationRect))
		{
			return false;
		}
		if (center == locationRect.center && halfWidth == locationRect.halfWidth)
		{
			return halfHeight == locationRect.halfHeight;
		}
		return false;
	}

	public bool Intersects(LocationRect rect)
	{
		double num = Math.Abs(center.Latitude - rect.center.Latitude);
		double num2 = Math.Abs(center.Longitude - rect.center.Longitude);
		if (num2 > 180.0)
		{
			num2 = 360.0 - num2;
		}
		if (num <= halfHeight + rect.halfHeight)
		{
			return num2 <= halfWidth + rect.halfWidth;
		}
		return false;
	}

	public LocationRect Intersection(LocationRect rect)
	{
		LocationRect result = new LocationRect();
		if (Intersects(rect))
		{
			double num = center.Longitude - halfWidth;
			double num2 = rect.center.Longitude - rect.halfWidth;
			double num3 = center.Longitude + halfWidth;
			double num4 = rect.center.Longitude + rect.halfWidth;
			if (Math.Abs(center.Longitude - rect.center.Longitude) > 180.0)
			{
				if (center.Longitude < rect.center.Longitude)
				{
					num += 360.0;
					num3 += 360.0;
				}
				else
				{
					num2 += 360.0;
					num4 += 360.0;
				}
			}
			double num5 = Math.Max(num, num2);
			double num6 = Math.Min(num3, num4);
			double num7 = Math.Min(North, rect.North);
			double num8 = Math.Max(South, rect.South);
			GeoCoordinate geoCoordinate = new GeoCoordinate();
			geoCoordinate.Latitude = (num7 + num8) / 2.0;
			geoCoordinate.Longitude = NormalizeLongitude((num5 + num6) / 2.0);
			result = new LocationRect(geoCoordinate, num6 - num5, num7 - num8);
		}
		return result;
	}

	public override string ToString()
	{
		return ((IFormattable)this).ToString((string)null, (IFormatProvider)null);
	}

	public string ToString(IFormatProvider provider)
	{
		return ((IFormattable)this).ToString((string)null, provider);
	}

	private static double NormalizeLongitude(double longitude)
	{
		if (longitude < -180.0 || longitude > 180.0)
		{
			return longitude - Math.Floor((longitude + 180.0) / 360.0) * 360.0;
		}
		return longitude;
	}
}
