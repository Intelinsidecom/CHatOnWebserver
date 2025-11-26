using System;
using System.Device.Location;
using System.Windows;

namespace Microsoft.Phone.Controls.Maps.Core;

public static class MercatorUtility
{
	public const double MercatorLatitudeLimit = 85.051128;

	public const double EarthRadiusInMeters = 6378137.0;

	public const double EarthCircumferenceInMeters = Math.PI * 12756274.0;

	public static Point NormalizeLogicalPoint(Point logicalPoint, Point centerLogicalPoint)
	{
		if (logicalPoint.X < centerLogicalPoint.X - 0.5 || logicalPoint.X > centerLogicalPoint.X + 0.5)
		{
			return new Point(logicalPoint.X - Math.Floor(logicalPoint.X - centerLogicalPoint.X + 0.5), logicalPoint.Y);
		}
		return logicalPoint;
	}

	public static GeoCoordinate NormalizeLocation(GeoCoordinate location)
	{
		GeoCoordinate geoCoordinate = new GeoCoordinate();
		geoCoordinate.Latitude = NormalizeLatitude(location.Latitude);
		geoCoordinate.Longitude = NormalizeLongitude(location.Longitude);
		return geoCoordinate;
	}

	public static double NormalizeLatitude(double latitude)
	{
		return Math.Min(Math.Max(latitude, -85.051128), 85.051128);
	}

	public static double NormalizeLongitude(double longitude)
	{
		if (longitude < -180.0 || longitude > 180.0)
		{
			return longitude - Math.Floor((longitude + 180.0) / 360.0) * 360.0;
		}
		return longitude;
	}

	public static Point LocationToLogicalPoint(GeoCoordinate location)
	{
		double y;
		if (location.Latitude > 85.051128)
		{
			y = 0.0;
		}
		else if (location.Latitude < -85.051128)
		{
			y = 1.0;
		}
		else
		{
			double num = Math.Sin(location.Latitude * Math.PI / 180.0);
			y = 0.5 - Math.Log((1.0 + num) / (1.0 - num)) / (Math.PI * 4.0);
		}
		return new Point((location.Longitude + 180.0) / 360.0, y);
	}

	public static GeoCoordinate LogicalPointToLocation(Point logicalPoint)
	{
		GeoCoordinate geoCoordinate = new GeoCoordinate();
		geoCoordinate.Latitude = 90.0 - 360.0 * Math.Atan(Math.Exp((logicalPoint.Y * 2.0 - 1.0) * Math.PI)) / Math.PI;
		geoCoordinate.Longitude = NormalizeLongitude(360.0 * logicalPoint.X - 180.0);
		return geoCoordinate;
	}

	public static double ZoomToScale(Size logicalAreaSizeInScreenSpaceAtLevel1, double zoomLevel, GeoCoordinate location)
	{
		double num = Math.PI * 12756274.0 / (Math.Pow(2.0, zoomLevel - 1.0) * logicalAreaSizeInScreenSpaceAtLevel1.Width);
		return Math.Cos(DegreesToRadians(location.Latitude)) * num;
	}

	public static double ScaleToZoom(Size logicalAreaSizeInScreenSpaceAtLevel1, double scale, GeoCoordinate location)
	{
		double num = scale / Math.Cos(DegreesToRadians(location.Latitude));
		return Math.Log(Math.PI * 12756274.0 / (num * logicalAreaSizeInScreenSpaceAtLevel1.Width), 2.0) + 1.0;
	}

	public static double DegreesToRadians(double deg)
	{
		return deg * Math.PI / 180.0;
	}
}
