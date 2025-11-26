using System;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class TfeTileSource : TileSource
{
	internal TfeCoverageMap TileCoverageMap { private get; set; }

	public bool CoverageMapLoaded
	{
		get
		{
			if (TileCoverageMap != null)
			{
				return TileCoverageMap.Loaded;
			}
			return false;
		}
	}

	public int MinZoomLevel
	{
		get
		{
			if (TileCoverageMap != null)
			{
				return TileCoverageMap.MinZoomLevel;
			}
			return -1;
		}
	}

	public int MaxZoomLevel
	{
		get
		{
			if (TileCoverageMap != null)
			{
				return TileCoverageMap.MaxZoomLevel;
			}
			return -1;
		}
	}

	public TfeTileSource()
	{
	}

	public TfeTileSource(string uriFormat, Uri coverageMapUri)
		: base(uriFormat)
	{
		SetCoverageMapUri(coverageMapUri);
	}

	public void SetCoverageMapUri(Uri coverageMapUri)
	{
		if (coverageMapUri != null)
		{
			TfeCoverageMap.GetInstance(coverageMapUri, TfeCoverageMapLoaded);
		}
		else
		{
			TileCoverageMap = null;
		}
	}

	public bool Covers(QuadKey quadKey)
	{
		if (TileCoverageMap != null)
		{
			return TileCoverageMap.Covers(quadKey);
		}
		return true;
	}

	public int GetMaximumZoomLevel(QuadKey quadKey)
	{
		if (TileCoverageMap != null)
		{
			return TileCoverageMap.GetMaximumZoomLevel(quadKey);
		}
		return -1;
	}

	private void TfeCoverageMapLoaded(TfeCoverageMap coverageMap, object userState)
	{
		TileCoverageMap = coverageMap;
	}
}
