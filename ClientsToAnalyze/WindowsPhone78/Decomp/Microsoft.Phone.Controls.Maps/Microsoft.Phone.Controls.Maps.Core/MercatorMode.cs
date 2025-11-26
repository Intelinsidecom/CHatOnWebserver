using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Device.Location;
using System.Windows;
using System.Windows.Media.Animation;

namespace Microsoft.Phone.Controls.Maps.Core;

public class MercatorMode : FlatMapMode
{
	private const int refreshMilliseconds = 500;

	internal const string configurationVersion = "v1";

	internal const string configurationSection = "WP7SLMapControl";

	internal static readonly Size LogicalAreaSizeInScreenSpaceAtLevel1 = new Size(512.0, 512.0);

	private static readonly TimeSpan panningRefreshTime = new TimeSpan(0, 0, 0, 0, 100);

	private static readonly TimeSpan fullRefreshTime = new TimeSpan(0, 0, 0, 0);

	private static readonly long refreshTicks = new TimeSpan(0, 0, 0, 0, 500).Ticks;

	private readonly AttributionCollection attributions;

	private readonly ObservableCollection<AttributionInfo> attributionsBase;

	private readonly CopyrightManager copyright;

	private readonly Range<double> headingRange = new Range<double>(0.0, 0.0);

	private readonly Range<double> pitchRange = new Range<double>(-90.0, -90.0);

	private readonly Storyboard storyboardOnFrame;

	private readonly Range<double> zoomRange = new Range<double>(1.0, 21.0);

	private long lastOverlayRefresh = long.MaxValue;

	private bool projectionChangedFiredThisFrame;

	public override AttributionCollection Attributions => attributions;

	public override double Heading => 0.0;

	public override double Pitch => -90.0;

	public override double Scale
	{
		get
		{
			return MercatorUtility.ZoomToScale(LogicalAreaSizeInScreenSpaceAtLevel1, ZoomLevel, Center);
		}
		set
		{
			ZoomLevel = MercatorUtility.ScaleToZoom(LogicalAreaSizeInScreenSpaceAtLevel1, value, Center);
		}
	}

	public override double TargetScale => MercatorUtility.ZoomToScale(LogicalAreaSizeInScreenSpaceAtLevel1, TargetZoomLevel, TargetCenter);

	public override Range<double> ZoomRange => GetZoomRange(Center);

	public override Range<double> HeadingRange => headingRange;

	public override Range<double> PitchRange => pitchRange;

	public override LocationRect BoundingRectangle
	{
		get
		{
			Point topLeftLogicalPoint = ViewportPointToLogicalPoint(new Point(0.0, 0.0));
			Point bottomRightLogicalPoint = ViewportPointToLogicalPoint(new Point(base.ViewportSize.Width, base.ViewportSize.Height));
			return GetBoundingRectangle(topLeftLogicalPoint, bottomRightLogicalPoint);
		}
	}

	public override LocationRect TargetBoundingRectangle
	{
		get
		{
			Point topLeftLogicalPoint = base.TargetViewportDefinition.ViewportPointToLogicalPoint(new Point(0.0, 0.0));
			Point bottomRightLogicalPoint = base.TargetViewportDefinition.ViewportPointToLogicalPoint(new Point(base.ViewportSize.Width, base.ViewportSize.Height));
			return GetBoundingRectangle(topLeftLogicalPoint, bottomRightLogicalPoint);
		}
	}

	private Point CurrentLogicalCenter
	{
		get
		{
			Point viewportPoint = new Point(base.ViewportSize.Width / 2.0, base.ViewportSize.Height / 2.0);
			return base.CurrentViewportDefinition.ViewportPointToLogicalPoint(viewportPoint);
		}
	}

	public MercatorMode()
		: base(LogicalAreaSizeInScreenSpaceAtLevel1)
	{
		attributionsBase = new ObservableCollection<AttributionInfo>();
		attributions = new AttributionCollection(attributionsBase);
		storyboardOnFrame = new Storyboard();
		storyboardOnFrame.Completed += storyboardOnFrame_Completed;
		copyright = CopyrightManager.GetInstance();
	}

	protected override Point LocationToLogicalPoint(GeoCoordinate location)
	{
		return MercatorUtility.NormalizeLogicalPoint(MercatorUtility.LocationToLogicalPoint(location), CurrentLogicalCenter);
	}

	public override IEnumerable<Point> LocationToLogicalPoint(IEnumerable<GeoCoordinate> locations)
	{
		List<Point> list = new List<Point>();
		Point centerLogicalPoint = CurrentLogicalCenter;
		foreach (GeoCoordinate location in locations)
		{
			Point point = MercatorUtility.NormalizeLogicalPoint(MercatorUtility.LocationToLogicalPoint(location), centerLogicalPoint);
			list.Add(point);
			centerLogicalPoint = point;
		}
		return list;
	}

	public override Rect LocationRectToLogicalRect(LocationRect boundingRectangle)
	{
		GeoCoordinate geoCoordinate = new GeoCoordinate();
		geoCoordinate.Latitude = boundingRectangle.Center.Latitude + boundingRectangle.Height / 2.0;
		geoCoordinate.Longitude = boundingRectangle.Center.Longitude - boundingRectangle.Width / 2.0;
		Point point = MercatorUtility.LocationToLogicalPoint(geoCoordinate);
		GeoCoordinate geoCoordinate2 = new GeoCoordinate();
		geoCoordinate2.Latitude = boundingRectangle.Center.Latitude - boundingRectangle.Height / 2.0;
		geoCoordinate2.Longitude = boundingRectangle.Center.Longitude + boundingRectangle.Width / 2.0;
		Point point2 = MercatorUtility.LocationToLogicalPoint(geoCoordinate2);
		Point logicalPoint = MercatorUtility.LocationToLogicalPoint(boundingRectangle.Center);
		Point point3 = MercatorUtility.NormalizeLogicalPoint(logicalPoint, CurrentLogicalCenter);
		double num = point3.X - logicalPoint.X;
		double num2 = point3.Y - logicalPoint.Y;
		point.X += num;
		point.Y += num2;
		point2.X += num;
		point2.Y += num2;
		return new Rect(point, point2);
	}

	protected override GeoCoordinate LogicalPointToLocation(Point logicalPoint)
	{
		return MercatorUtility.NormalizeLocation(MercatorUtility.LogicalPointToLocation(logicalPoint));
	}

	public override bool ConstrainView(GeoCoordinate center, ref double zoomLevel, ref double heading, ref double pitch)
	{
		bool flag = false;
		GeoCoordinate geoCoordinate = MercatorUtility.NormalizeLocation(center);
		if (geoCoordinate != center)
		{
			flag = true;
			center.Latitude = geoCoordinate.Latitude;
			center.Longitude = geoCoordinate.Longitude;
			center.Altitude = geoCoordinate.Altitude;
		}
		double num = zoomLevel;
		Range<double> range = GetZoomRange(geoCoordinate);
		zoomLevel = Math.Min(zoomLevel, range.To);
		zoomLevel = Math.Max(zoomLevel, range.From);
		if (!flag)
		{
			return num != zoomLevel;
		}
		return true;
	}

	protected override void OnProjectionChanged(ProjectionUpdateLevel updateLevel)
	{
		base.OnProjectionChanged(updateLevel);
		UpdateAttribution(updateLevel);
	}

	protected virtual Range<double> GetZoomRange(GeoCoordinate center)
	{
		return zoomRange;
	}

	internal Range<double> GetZoomRange(TfeTileSource tileSource, GeoCoordinate center)
	{
		Range<double> range = zoomRange;
		double fromValue = range.From;
		double num = range.To;
		if (tileSource != null && tileSource.CoverageMapLoaded)
		{
			Point point = LocationToLogicalPoint(center);
			if (point.X < 0.0 || point.X > 1.0)
			{
				point.X -= Math.Floor(point.X);
			}
			if (point.Y < 0.0)
			{
				point.Y = 0.0;
			}
			else if (point.Y > 1.0)
			{
				point.Y = 1.0;
			}
			int num2 = (int)Math.Floor(tileSource.MaxZoomLevel);
			double num3 = Math.Pow(2.0, num2) - 1.0;
			QuadKey quadKey = new QuadKey((int)Math.Round(point.X * num3), (int)Math.Round(point.Y * num3), num2);
			num = Math.Min(num, tileSource.GetMaximumZoomLevel(quadKey));
		}
		return new Range<double>(fromValue, num);
	}

	internal virtual void UpdateAttribution()
	{
	}

	internal void UpdateAttribution(IList<string> copyrightStrings)
	{
		Collection<string> collection = new Collection<string>(copyrightStrings);
		Collection<AttributionInfo> collection2 = new Collection<AttributionInfo>();
		foreach (AttributionInfo item in attributionsBase)
		{
			if (collection.Contains(item.Text))
			{
				collection.Remove(item.Text);
			}
			else
			{
				collection2.Add(item);
			}
		}
		foreach (AttributionInfo item2 in collection2)
		{
			attributionsBase.Remove(item2);
		}
		foreach (string item3 in collection)
		{
			attributionsBase.Add(new AttributionInfo
			{
				Text = item3
			});
		}
	}

	internal void UpdateAttribution(ProjectionUpdateLevel updateLevel)
	{
		projectionChangedFiredThisFrame = true;
		long ticks = DateTime.Now.Ticks;
		if (ticks - lastOverlayRefresh >= refreshTicks)
		{
			lastOverlayRefresh = ticks;
			UpdateAttribution();
			return;
		}
		if (lastOverlayRefresh > ticks)
		{
			lastOverlayRefresh = ticks;
		}
		if (updateLevel == ProjectionUpdateLevel.Full)
		{
			storyboardOnFrame.Duration = fullRefreshTime;
		}
		else
		{
			storyboardOnFrame.Duration = panningRefreshTime;
		}
		storyboardOnFrame.Begin();
	}

	internal static bool TryParseSubdomains(string subdomainString, out string[][] subdomains)
	{
		bool result = false;
		if (!string.IsNullOrEmpty(subdomainString))
		{
			string[] array = subdomainString.Split(' ');
			subdomains = new string[array.Length][];
			for (int i = 0; i < array.Length; i++)
			{
				subdomains[i] = array[i].Split(',');
			}
			result = true;
		}
		else
		{
			subdomains = null;
		}
		return result;
	}

	private void storyboardOnFrame_Completed(object sender, EventArgs e)
	{
		if (projectionChangedFiredThisFrame)
		{
			projectionChangedFiredThisFrame = false;
			storyboardOnFrame.Begin();
		}
		else
		{
			lastOverlayRefresh = long.MaxValue;
			UpdateAttribution();
		}
	}

	private LocationRect GetBoundingRectangle(Point topLeftLogicalPoint, Point bottomRightLogicalPoint)
	{
		GeoCoordinate geoCoordinate = LogicalPointToLocation(topLeftLogicalPoint);
		GeoCoordinate geoCoordinate2 = LogicalPointToLocation(bottomRightLogicalPoint);
		GeoCoordinate geoCoordinate3 = LogicalPointToLocation(new Point((bottomRightLogicalPoint.X + topLeftLogicalPoint.X) / 2.0, 0.0));
		geoCoordinate3.Latitude = (geoCoordinate.Latitude + geoCoordinate2.Latitude) / 2.0;
		double height = geoCoordinate.Latitude - geoCoordinate2.Latitude;
		double num = bottomRightLogicalPoint.X - topLeftLogicalPoint.X;
		num = ((num <= 1.0) ? (num * 360.0) : 360.0);
		return new LocationRect(geoCoordinate3, num, height);
	}
}
