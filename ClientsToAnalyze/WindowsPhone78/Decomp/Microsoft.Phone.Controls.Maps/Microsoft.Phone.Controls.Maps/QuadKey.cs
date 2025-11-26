using System;

namespace Microsoft.Phone.Controls.Maps;

public struct QuadKey
{
	public int ZoomLevel { get; set; }

	public int X { get; set; }

	public int Y { get; set; }

	public string Key => QuadPixelToQuadKey(X, Y, ZoomLevel);

	public QuadKey(int x, int y, int zoomLevel)
	{
		this = default(QuadKey);
		ZoomLevel = zoomLevel;
		X = x;
		Y = y;
	}

	public QuadKey(string quadKey)
	{
		this = default(QuadKey);
		QuadKeyToQuadPixel(quadKey, out var x, out var y, out var zoomLevel);
		ZoomLevel = zoomLevel;
		X = x;
		Y = y;
	}

	private static string QuadPixelToQuadKey(int x, int y, int zoomLevel)
	{
		int num = (int)Math.Pow(2.0, zoomLevel);
		string text = "";
		if (y < 0 || y >= num)
		{
			return null;
		}
		while (x < 0)
		{
			x += num;
		}
		while (x > num)
		{
			x -= num;
		}
		for (int i = 1; i <= zoomLevel; i++)
		{
			switch (2 * (y % 2) + x % 2)
			{
			case 0:
				text = "0" + text;
				break;
			case 1:
				text = "1" + text;
				break;
			case 2:
				text = "2" + text;
				break;
			case 3:
				text = "3" + text;
				break;
			}
			x /= 2;
			y /= 2;
		}
		return text;
	}

	private static void QuadKeyToQuadPixel(string quadKey, out int x, out int y, out int zoomLevel)
	{
		x = 0;
		y = 0;
		zoomLevel = 0;
		if (string.IsNullOrEmpty(quadKey))
		{
			return;
		}
		zoomLevel = quadKey.Length;
		for (int i = 0; i < quadKey.Length; i++)
		{
			switch (quadKey[i])
			{
			case '0':
				x *= 2;
				y *= 2;
				break;
			case '1':
				x = x * 2 + 1;
				y *= 2;
				break;
			case '2':
				x *= 2;
				y = y * 2 + 1;
				break;
			case '3':
				x = x * 2 + 1;
				y = y * 2 + 1;
				break;
			}
		}
	}

	public static bool operator ==(QuadKey tile1, QuadKey tile2)
	{
		if (tile1.X == tile2.X && tile1.Y == tile2.Y)
		{
			return tile1.ZoomLevel == tile2.ZoomLevel;
		}
		return false;
	}

	public static bool operator !=(QuadKey tile1, QuadKey tile2)
	{
		return !(tile1 == tile2);
	}

	public override bool Equals(object obj)
	{
		if (obj == null || !(obj is QuadKey quadKey))
		{
			return false;
		}
		return this == quadKey;
	}

	public override int GetHashCode()
	{
		return X.GetHashCode() ^ Y.GetHashCode() ^ ZoomLevel.GetHashCode();
	}
}
