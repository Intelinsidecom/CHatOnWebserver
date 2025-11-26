using System;
using System.Collections.Generic;

namespace Microsoft.Phone.Controls.Maps.Core;

internal sealed class TfeZoomLevelRange
{
	private readonly List<int> generations = new List<int>();

	private readonly byte maxZoomLevel;

	private readonly byte minZoomLevel;

	private readonly List<string> regions = new List<string>();

	public int MinimumZoom => minZoomLevel;

	public int MaximumZoom => maxZoomLevel;

	public TfeZoomLevelRange(byte minZoomLevel, byte maxZoomLevel)
	{
		this.minZoomLevel = minZoomLevel;
		this.maxZoomLevel = maxZoomLevel;
	}

	public void AddRegion(string basequadKey, int generation)
	{
		regions.Add(basequadKey);
		generations.Add(generation);
	}

	public int GetGeneration(string quadKey)
	{
		if (quadKey.Length < minZoomLevel || quadKey.Length > maxZoomLevel)
		{
			return -1;
		}
		int num = regions.BinarySearch(quadKey);
		if (num >= 0)
		{
			return generations[num];
		}
		num = ~num;
		if (num == 0 || num > regions.Count)
		{
			return -1;
		}
		if (quadKey.StartsWith(regions[num - 1], StringComparison.Ordinal))
		{
			return generations[num - 1];
		}
		return -1;
	}
}
