using System;
using System.Device.Location;
using System.Windows;
using System.Windows.Input;
using System.Windows.Media.Animation;
using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps;

public class AerialMode : MercatorMode
{
	private const string lowDPIMarketsKey = "LowDPIMarkets";

	private const string aerialUriFromatKey = "AerialUriFormat";

	private const string aerialWithLabelsUriFormatKey = "AerialWithLabelsUriFormat";

	private const string aerialWithLabelsLowDPIUriFormatKey = "AerialWithLabelsLowDPIUriFormat";

	private const string aerialLabelsUriFormatKey = "AerialLabelsUriFormat";

	private const string aerialLabelsLowDPIUriFormatKey = "AerialLabelsLowDPIUriFormat";

	private const string aerialSubdomainsKey = "AerialUriSubdomains";

	private const string aerialWithLabelsSubdomainsKey = "AerialWithLabelsUriSubdomains";

	private const string aerialLabelsSubdomainsKey = "AerialLabelsUriSubdomains";

	private const string aerialCoverageMapKey = "AerialCoverageMap";

	private readonly MapTileLayer baseTileLayer;

	private readonly TfeTileSource baseTileSource;

	private readonly MapLayer contentLayer;

	private readonly CopyrightManager copyright;

	private readonly TimeSpan fadeInTime = new TimeSpan(0, 0, 0, 0, 150);

	private readonly TimeSpan fadeOutTime = new TimeSpan(0, 0, 0, 0, 1000);

	private readonly TimeSpan labelsTimeout = new TimeSpan(0, 0, 0, 0, 1100);

	private readonly MapTileLayer overlayTileLayer;

	private string[] lowDPIMarkets = new string[0];

	private readonly TfeTileSource overlayTileSource;

	private bool addedToMap;

	private string[][] aerialLabelsSubdomains;

	private string aerialLabelsUriFormat;

	private string aerialLabelsLowDPIUriFormat;

	private string[][] aerialSubdomains;

	private string aerialTileUriFormat;

	private string[][] aerialWithLabelsSubdomains;

	private string aerialWithLabelsUriFormat;

	private string aerialWithLabelsLowDPIUriFormat;

	private Uri coverageMapUri;

	private bool fadingLabels;

	private bool labels;

	private Storyboard labelsFadeOut;

	private bool restrictMaxZoomLevel;

	private bool configurationLoaded;

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

	public bool ShouldDisplayLabels
	{
		get
		{
			return labels;
		}
		set
		{
			labels = value;
			UpdateTileLayers();
		}
	}

	public bool ShouldDisplayFadingLabels
	{
		get
		{
			return fadingLabels;
		}
		set
		{
			fadingLabels = value;
			UpdateTileLayers();
		}
	}

	public int UpSampleLevelDelta
	{
		get
		{
			return baseTileLayer.UpSampleLevelDelta;
		}
		set
		{
			baseTileLayer.UpSampleLevelDelta = value;
		}
	}

	public override UIElement Content => contentLayer;

	public override bool IsDownloading
	{
		get
		{
			if (baseTileLayer == null || !baseTileLayer.IsDownloading)
			{
				if (ShouldDisplayLabels && overlayTileLayer != null)
				{
					return overlayTileLayer.IsDownloading;
				}
				return false;
			}
			return true;
		}
	}

	public override bool IsIdle
	{
		get
		{
			if (configurationLoaded)
			{
				if (baseTileLayer == null || !baseTileLayer.IsIdle)
				{
					if (ShouldDisplayLabels && overlayTileLayer != null)
					{
						return overlayTileLayer.IsIdle;
					}
					return false;
				}
				return true;
			}
			return false;
		}
	}

	public AerialMode()
		: this(labels: false)
	{
	}

	public AerialMode(bool labels)
	{
		restrictMaxZoomLevel = false;
		this.labels = labels;
		baseTileLayer = new MapTileLayer(this);
		baseTileLayer.UpSampleLevelDelta = 7;
		baseTileLayer.IsHitTestVisible = true;
		baseTileSource = new TfeTileSource();
		baseTileLayer.TileSources.Add(baseTileSource);
		overlayTileLayer = new MapTileLayer(this);
		overlayTileLayer.UpSampleLevelDelta = 0;
		overlayTileLayer.IsHitTestVisible = true;
		overlayTileSource = new TfeTileSource();
		overlayTileLayer.TileSources.Add(overlayTileSource);
		contentLayer = new MapLayer();
		contentLayer.Children.Add(baseTileLayer);
		UpdateTileLayers();
		copyright = CopyrightManager.GetInstance();
		MapConfiguration.GetSection("v1", "WP7SLMapControl", null, AsynchronousConfigurationLoaded);
	}

	protected override Range<double> GetZoomRange(GeoCoordinate center)
	{
		return GetZoomRange(baseTileSource, center);
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
		MapStyle style = ((!ShouldDisplayLabels) ? MapStyle.Aerial : MapStyle.AerialWithLabels);
		copyright.RequestCopyrightString(style, Center, ZoomLevel, CredentialsProvider, base.Culture, CopyrightCallback);
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

	private void AsynchronousConfigurationLoaded(MapConfigurationSection config, object userState)
	{
		if (config != null)
		{
			string text = config["LowDPIMarkets"];
			if (!string.IsNullOrEmpty(text))
			{
				lowDPIMarkets = text.Split(';');
			}
			aerialTileUriFormat = config["AerialUriFormat"];
			aerialLabelsUriFormat = config["AerialLabelsUriFormat"];
			aerialLabelsLowDPIUriFormat = config["AerialLabelsLowDPIUriFormat"];
			aerialWithLabelsUriFormat = config["AerialWithLabelsUriFormat"];
			aerialWithLabelsLowDPIUriFormat = config["AerialWithLabelsLowDPIUriFormat"];
			aerialSubdomains = ((config.Contains("AerialUriSubdomains") && MercatorMode.TryParseSubdomains(config["AerialUriSubdomains"], out var subdomains)) ? subdomains : null);
			aerialWithLabelsSubdomains = ((config.Contains("AerialWithLabelsUriSubdomains") && MercatorMode.TryParseSubdomains(config["AerialWithLabelsUriSubdomains"], out subdomains)) ? subdomains : null);
			aerialLabelsSubdomains = ((config.Contains("AerialLabelsUriSubdomains") && MercatorMode.TryParseSubdomains(config["AerialLabelsUriSubdomains"], out subdomains)) ? subdomains : null);
			UpdateTileLayers();
			if (config.Contains("AerialCoverageMap"))
			{
				coverageMapUri = new Uri(config["AerialCoverageMap"].Replace("{UriScheme}", "HTTP"), UriKind.Absolute);
				if (addedToMap)
				{
					SetupMode();
				}
			}
		}
		configurationLoaded = true;
	}

	private void SetupMode()
	{
		UpdateTileLayers();
		UpdateAttribution(ProjectionUpdateLevel.None);
		SetTfeCoverageMap();
	}

	private void SetTfeCoverageMap()
	{
		baseTileSource.SetCoverageMapUri(restrictMaxZoomLevel ? coverageMapUri : null);
	}

	private void UpdateTileLayers()
	{
		if (ShouldDisplayLabels)
		{
			bool flag = false;
			if (base.Culture != null)
			{
				string text = base.Culture.Name.ToLowerInvariant();
				string[] array = lowDPIMarkets;
				foreach (string text2 in array)
				{
					if (!string.IsNullOrEmpty(text2) && text2.ToLowerInvariant() == text)
					{
						flag = true;
						break;
					}
				}
			}
			if (ShouldDisplayFadingLabels)
			{
				string uriFormat = ((flag && !string.IsNullOrEmpty(aerialLabelsLowDPIUriFormat)) ? aerialLabelsLowDPIUriFormat : aerialLabelsUriFormat);
				SetUriFormat(baseTileSource, aerialTileUriFormat, aerialSubdomains);
				AddOverlayTileLayer();
				SetUriFormat(overlayTileSource, uriFormat, aerialLabelsSubdomains);
				EnableFadingLabels();
			}
			else
			{
				string uriFormat2 = ((flag && !string.IsNullOrEmpty(aerialWithLabelsLowDPIUriFormat)) ? aerialWithLabelsLowDPIUriFormat : aerialWithLabelsUriFormat);
				SetUriFormat(baseTileSource, uriFormat2, aerialWithLabelsSubdomains);
				RemoveOverlayTileLayer();
				DisableFadingLabels();
			}
		}
		else
		{
			SetUriFormat(baseTileSource, aerialTileUriFormat, aerialSubdomains);
			RemoveOverlayTileLayer();
			DisableFadingLabels();
		}
	}

	private void SetUriFormat(TfeTileSource tileSource, string uriFormat, string[][] subdomains)
	{
		if (!string.IsNullOrEmpty(uriFormat))
		{
			tileSource.UriFormat = uriFormat.Replace("{Culture}", base.Culture.Name);
			tileSource.SetSubdomains(subdomains);
		}
	}

	private void AddOverlayTileLayer()
	{
		if (!contentLayer.Children.Contains(overlayTileLayer))
		{
			contentLayer.Children.Add(overlayTileLayer);
		}
	}

	private void RemoveOverlayTileLayer()
	{
		if (contentLayer.Children.Contains(overlayTileLayer))
		{
			contentLayer.Children.Remove(overlayTileLayer);
		}
	}

	private void EnableFadingLabels()
	{
		if (labelsFadeOut == null)
		{
			labelsFadeOut = new Storyboard();
			DoubleAnimationUsingKeyFrames doubleAnimationUsingKeyFrames = new DoubleAnimationUsingKeyFrames();
			doubleAnimationUsingKeyFrames.KeyFrames.Add(new LinearDoubleKeyFrame
			{
				Value = 1.0,
				KeyTime = fadeInTime
			});
			doubleAnimationUsingKeyFrames.KeyFrames.Add(new LinearDoubleKeyFrame
			{
				Value = 1.0,
				KeyTime = fadeInTime + labelsTimeout
			});
			doubleAnimationUsingKeyFrames.KeyFrames.Add(new LinearDoubleKeyFrame
			{
				Value = 0.0,
				KeyTime = fadeInTime + labelsTimeout + fadeOutTime
			});
			Storyboard.SetTarget(doubleAnimationUsingKeyFrames, overlayTileLayer);
			Storyboard.SetTargetProperty(doubleAnimationUsingKeyFrames, new PropertyPath(UIElement.OpacityProperty));
			labelsFadeOut.Children.Add(doubleAnimationUsingKeyFrames);
		}
		base.ProjectionChanged += MapMode_ProjectionChangedForFadingLabels;
		contentLayer.MouseMove += ContentLayer_MouseMoveForFadingLabels;
		overlayTileLayer.Opacity = 1.0;
	}

	private void DisableFadingLabels()
	{
		base.ProjectionChanged -= MapMode_ProjectionChangedForFadingLabels;
		contentLayer.MouseMove -= ContentLayer_MouseMoveForFadingLabels;
		if (labelsFadeOut != null)
		{
			labelsFadeOut.Stop();
		}
		overlayTileLayer.Opacity = 1.0;
	}

	private void MapMode_ProjectionChangedForFadingLabels(object sender, ProjectionChangedEventArgs e)
	{
		ShowLabels();
	}

	private void ContentLayer_MouseMoveForFadingLabels(object sender, MouseEventArgs e)
	{
		ShowLabels();
	}

	private void ShowLabels()
	{
		if (labelsFadeOut != null)
		{
			labelsFadeOut.Begin();
		}
		else
		{
			overlayTileLayer.Opacity = 1.0;
		}
		if (!overlayTileLayer.IsIdle)
		{
			overlayTileLayer.Dispatcher.BeginInvoke(ShowLabels);
		}
	}
}
