using System.ComponentModel;
using Microsoft.Phone.Controls.Maps.Design;

namespace Microsoft.Phone.Controls.Maps;

[TypeConverter(typeof(PositionOriginConverter))]
public struct PositionOrigin
{
	private double x;

	private double y;

	public static readonly PositionOrigin TopLeft = new PositionOrigin(0.0, 0.0);

	public static readonly PositionOrigin TopCenter = new PositionOrigin(0.5, 0.0);

	public static readonly PositionOrigin TopRight = new PositionOrigin(1.0, 0.0);

	public static readonly PositionOrigin CenterLeft = new PositionOrigin(0.0, 0.5);

	public static readonly PositionOrigin Center = new PositionOrigin(0.5, 0.5);

	public static readonly PositionOrigin CenterRight = new PositionOrigin(1.0, 0.5);

	public static readonly PositionOrigin BottomLeft = new PositionOrigin(0.0, 1.0);

	public static readonly PositionOrigin BottomCenter = new PositionOrigin(0.5, 1.0);

	public static readonly PositionOrigin BottomRight = new PositionOrigin(1.0, 1.0);

	public double X
	{
		get
		{
			return x;
		}
		set
		{
			x = value;
		}
	}

	public double Y
	{
		get
		{
			return y;
		}
		set
		{
			y = value;
		}
	}

	public PositionOrigin(double horizontalOrigin, double verticalOrigin)
	{
		x = horizontalOrigin;
		y = verticalOrigin;
	}

	public override int GetHashCode()
	{
		return x.GetHashCode() ^ y.GetHashCode();
	}

	public override bool Equals(object obj)
	{
		if (obj is PositionOrigin)
		{
			return Equals((PositionOrigin)obj);
		}
		return false;
	}

	public bool Equals(PositionOrigin origin)
	{
		if (x == origin.x)
		{
			return y == origin.y;
		}
		return false;
	}

	public static bool operator ==(PositionOrigin origin1, PositionOrigin origin2)
	{
		return origin1.Equals(origin2);
	}

	public static bool operator !=(PositionOrigin origin1, PositionOrigin origin2)
	{
		return !origin1.Equals(origin2);
	}
}
