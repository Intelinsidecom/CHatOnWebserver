using System;
using System.Device.Location;
using System.Windows;
using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps;

public class RoadMode : MercatorMode
{
	private const string lowDPIMarketsKey = "LowDPIMarkets";

	private const string subdomainsKey = "RoadUriSubdomains";

	private const string uriFormatKey = "RoadUriFormat";

	private const string uriLowDPIFormatKey = "RoadLowDPIUriFormat";

	private const string coverageMapKey = "RoadCoverageMap";

	private readonly MapTileLayer tileLayer;

	private readonly TfeTileSource tileSource;

	private bool addedToMap;

	private Uri coverageMapUri;

	private bool restrictMaxZoomLevel;

	private string[] lowDPIMarkets = new string[0];

	private string tileUriFormat;

	private string tileLowDPIUriFormat;

	private bool configurationLoaded;

	private CopyrightManager copyright;

	public bool ShouldRestrictMaxZoomLevel
	{
		get
		{
			return restrictMaxZoomLevel;
		}
		set
		{
			restrictMaxZoomLevel = value;
			SetTfeCoverageMap();
		}
	}

	public int UpSampleLevelDelta
	{
		get
		{
			return tileLayer.UpSampleLevelDelta;
		}
		set
		{
			tileLayer.UpSampleLevelDelta = value;
		}
	}

	public override UIElement Content => tileLayer;

	public override ModeBackground ModeBackground => ModeBackground.Light;

	public override bool IsDownloading
	{
		get
		{
			if (tileLayer != null)
			{
				return tileLayer.IsDownloading;
			}
			return false;
		}
	}

	public override bool IsIdle
	{
		get
		{
			if (configurationLoaded && tileLayer != null)
			{
				return tileLayer.IsIdle;
			}
			return false;
		}
	}

	public RoadMode()
	{
		restrictMaxZoomLevel = false;
		tileLayer = new MapTileLayer(this);
		tileLayer.UpSampleLevelDelta = 7;
		tileSource = new TfeTileSource();
		tileLayer.TileSources.Add(tileSource);
		copyright = CopyrightManager.GetInstance();
		MapConfiguration.GetSection("v1", "WP7SLMapControl", null, AsynchronousConfigurationLoaded);
	}

	protected override Range<double> GetZoomRange(GeoCoordinate center)
	{
		return GetZoomRange(tileSource, center);
	}

	private void AsynchronousConfigurationLoaded(MapConfigurationSection config, object userState)
	{
		if (config != null)
		{
			string text = config["LowDPIMarkets"];
			if (!string.IsNullOrEmpty(text))
			{
				lowDPIMarkets = text.Split(';');
			}
			tileUriFormat = config["RoadUriFormat"];
			tileLowDPIUriFormat = config["RoadLowDPIUriFormat"];
			if (config.Contains("RoadUriSubdomains") && MercatorMode.TryParseSubdomains(config["RoadUriSubdomains"], out var subdomains))
			{
				tileSource.SetSubdomains(subdomains);
			}
			UpdateTileSource();
			if (config.Contains("RoadCoverageMap"))
			{
				coverageMapUri = new Uri(config["RoadCoverageMap"].Replace("{UriScheme}", "HTTP"), UriKind.Absolute);
				if (addedToMap)
				{
					SetupMode();
				}
			}
		}
		configurationLoaded = true;
	}

	protected override void OnCultureChanged()
	{
		if (addedToMap)
		{
			SetupMode();
		}
	}

	internal override void UpdateAttribution()
	{
		copyright.RequestCopyrightString(MapStyle.Road, Center, ZoomLevel, CredentialsProvider, base.Culture, CopyrightCallback);
	}

	private void CopyrightCallback(CopyrightResult result)
	{
		if (result.Culture == base.Culture && result.Location == Center && result.ZoomLevel == ZoomLevel)
		{
			UpdateAttribution(result.CopyrightStrings);
		}
	}

	public override void Activating(MapMode previousMode, MapLayerBase modeLayer, MapLayerBase modeForegroundLayer)
	{
		base.Activating(previousMode, modeLayer, modeForegroundLayer);
		SetupMode();
		addedToMap = true;
	}

	private void SetupMode()
	{
		UpdateTileSource();
		UpdateAttribution(ProjectionUpdateLevel.None);
		SetTfeCoverageMap();
	}

	private void UpdateTileSource()
	{
		if (base.Culture == null)
		{
			return;
		}
		string text = base.Culture.Name.ToLowerInvariant();
		bool flag = false;
		string[] array = lowDPIMarkets;
		foreach (string text2 in array)
		{
			if (!string.IsNullOrEmpty(text2) && text2.ToLowerInvariant() == text)
			{
				flag = true;
				break;
			}
		}
		if (flag && !string.IsNullOrEmpty(tileLowDPIUriFormat))
		{
			tileSource.UriFormat = tileLowDPIUriFormat.Replace("{Culture}", base.Culture.Name);
		}
		else if (!string.IsNullOrEmpty(tileUriFormat))
		{
			tileSource.UriFormat = tileUriFormat.Replace("{Culture}", base.Culture.Name);
		}
	}

	private void SetTfeCoverageMap()
	{
		tileSource.SetCoverageMapUri(restrictMaxZoomLevel ? coverageMapUri : null);
	}
}
