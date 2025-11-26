using System;
using System.ComponentModel;
using System.Windows;
using Microsoft.Phone.Controls.Maps.Core;
using Microsoft.Phone.Controls.Maps.Design;

namespace Microsoft.Phone.Controls.Maps;

public class LocationRectTileSource : TileSource
{
	[TypeConverter(typeof(LocationRectConverter))]
	public LocationRect BoundingRectangle { get; set; }

	[TypeConverter(typeof(RangeConverter))]
	public Range<double> ZoomRange { get; set; }

	public LocationRectTileSource()
	{
	}

	public LocationRectTileSource(string uriFormat, LocationRect boundingRectangle, Range<double> zoomRange)
		: base(uriFormat)
	{
		BoundingRectangle = boundingRectangle;
		ZoomRange = zoomRange;
	}

	public override Uri GetUri(int x, int y, int zoomLevel)
	{
		Uri result = null;
		if (Covers(x, y, zoomLevel))
		{
			result = base.GetUri(x, y, zoomLevel);
		}
		return result;
	}

	private bool Covers(int x, int y, int zoomLevel)
	{
		bool flag = true;
		if (ZoomRange != null)
		{
			flag = (double)zoomLevel >= ZoomRange.From && (double)zoomLevel <= ZoomRange.To;
		}
		if (flag && BoundingRectangle != null)
		{
			flag = BoundingRectangle.Intersects(GetBoundingRectangle(x, y, zoomLevel));
		}
		return flag;
	}

	private static LocationRect GetBoundingRectangle(int x, int y, int zoomLevel)
	{
		double num = 1.0 / Math.Pow(2.0, zoomLevel);
		Rect rect = new Rect((double)x * num, (double)y * num, num, num);
		return LocationRect.CreateLocationRect(MercatorUtility.LogicalPointToLocation(new Point(rect.Left, rect.Top)), MercatorUtility.LogicalPointToLocation(new Point(rect.Right, rect.Bottom)));
	}
}
