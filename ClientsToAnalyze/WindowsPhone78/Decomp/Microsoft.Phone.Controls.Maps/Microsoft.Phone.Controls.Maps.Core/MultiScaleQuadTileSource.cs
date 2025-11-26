using System;
using System.Collections.Generic;
using System.Windows.Media;

namespace Microsoft.Phone.Controls.Maps.Core;

internal sealed class MultiScaleQuadTileSource : MultiScaleTileSource
{
	private struct TileInfo
	{
		public int X { get; set; }

		public int Y { get; set; }

		public int Layer { get; set; }
	}

	private const int minZoomLevel = 1;

	private const int maxZoomLevel = 22;

	private const int numberOfEdgeTilesAtMaxZoomLevel = 4194304;

	private readonly List<TileInfo>[] fakeNoTile;

	private readonly TileSourceCollection tileSources;

	private readonly int zoomLevelDelta;

	private int minTileZoomLevel;

	public TileSourceCollection TileSources => tileSources;

	public int MinTileZoomLevel
	{
		get
		{
			return minTileZoomLevel;
		}
		set
		{
			int num = minTileZoomLevel;
			minTileZoomLevel = value;
			if (minTileZoomLevel < num)
			{
				RefreshInvalidTiles();
			}
		}
	}

	public MultiScaleQuadTileSource(TileSource tileSource, int tileWidth, int tileHeight)
		: this(tileWidth, tileHeight)
	{
		if (tileSource != null)
		{
			tileSources.Add(tileSource);
		}
	}

	public MultiScaleQuadTileSource(TileSourceCollection tileSources, int tileWidth, int tileHeight)
		: this(tileWidth, tileHeight)
	{
		if (tileSources == null)
		{
			return;
		}
		foreach (TileSource tileSource in tileSources)
		{
			this.tileSources.Add(tileSource);
		}
	}

	private MultiScaleQuadTileSource(int tileWidth, int tileHeight)
		: base(4194304 * tileWidth, 4194304 * tileHeight, tileWidth, tileHeight, 0)
	{
		tileSources = new TileSourceCollection();
		zoomLevelDelta = (int)Math.Log(tileWidth, 2.0);
		base.TileBlendTime = new TimeSpan(0, 0, 0, 0, 250);
		fakeNoTile = new List<TileInfo>[23];
		for (int i = 0; i < fakeNoTile.Length; i++)
		{
			fakeNoTile[i] = new List<TileInfo>();
		}
	}

	protected override void GetTileLayers(int tileLevel, int tilePositionX, int tilePositionY, IList<object> tileImageLayerSources)
	{
		int num = tileLevel - zoomLevelDelta;
		int num2 = MinTileZoomLevel;
		if (num < 1 || num > 22)
		{
			return;
		}
		int num3 = 0;
		foreach (TileSource tileSource in tileSources)
		{
			Uri item;
			if (num < num2)
			{
				item = null;
				fakeNoTile[num].Add(new TileInfo
				{
					X = tilePositionX,
					Y = tilePositionY,
					Layer = num3
				});
			}
			else
			{
				item = tileSource.GetUri(tilePositionX, tilePositionY, num);
			}
			tileImageLayerSources.Add(item);
			num3++;
		}
	}

	private void RefreshInvalidTiles()
	{
		int num = ((MinTileZoomLevel < 1) ? 1 : MinTileZoomLevel);
		for (int i = num; i < fakeNoTile.Length; i++)
		{
			List<TileInfo> list = fakeNoTile[i];
			foreach (TileInfo item in list)
			{
				InvalidateTileLayer(i + zoomLevelDelta, item.X, item.Y, item.Layer);
			}
			list.Clear();
		}
	}
}
