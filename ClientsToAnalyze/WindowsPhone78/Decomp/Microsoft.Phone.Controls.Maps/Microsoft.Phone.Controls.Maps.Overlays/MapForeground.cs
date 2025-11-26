using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Globalization;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Data;
using Microsoft.Phone.Controls.Maps.AutomationPeers;
using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps.Overlays;

[TemplatePart(Name = "LogoElement", Type = typeof(Logo))]
[TemplatePart(Name = "ZoomBarElement", Type = typeof(ZoomBar))]
[TemplatePart(Name = "ScaleElement", Type = typeof(Scale))]
[TemplatePart(Name = "CopyrightElement", Type = typeof(Copyright))]
public class MapForeground : Overlay
{
	internal const string ScaleElementName = "ScaleElement";

	internal const string CopyrightElementName = "CopyrightElement";

	internal const string LogoElementName = "LogoElement";

	internal const string ZoomBarElementName = "ZoomBarElement";

	private const int refreshMilliseconds = 500;

	private static readonly long refreshTicks = new TimeSpan(0, 0, 0, 0, 500).Ticks;

	private readonly MapBase targetMap;

	private Copyright copyright;

	private long lastOverlayRefresh;

	private double lastZoomLevel;

	private Logo logo;

	private MapMode previousMode;

	private Scale scale;

	private ZoomBar zoomBar;

	public static readonly DependencyProperty CultureProperty = DependencyProperty.Register("Culture", typeof(string), typeof(MapForeground), new PropertyMetadata(OnCultureChanged));

	public string Culture
	{
		get
		{
			return (string)GetValue(CultureProperty);
		}
		set
		{
			SetValue(CultureProperty, value);
		}
	}

	public Copyright Copyright
	{
		get
		{
			return copyright;
		}
		private set
		{
			if (copyright != null && value != null)
			{
				value.Visibility = copyright.Visibility;
				value.Attributions = copyright.Attributions;
				value.SetForBackground = copyright.SetForBackground;
			}
			copyright = value;
		}
	}

	public Logo Logo
	{
		get
		{
			return logo;
		}
		private set
		{
			if (logo != null && value != null)
			{
				value.Visibility = logo.Visibility;
			}
			logo = value;
		}
	}

	public Scale Scale
	{
		get
		{
			return scale;
		}
		private set
		{
			if (scale != null && value != null)
			{
				value.Visibility = scale.Visibility;
				value.MetersPerPixel = scale.MetersPerPixel;
				value.DistanceUnit = scale.DistanceUnit;
				value.Culture = scale.Culture;
				value.SetForBackground = scale.SetForBackground;
			}
			scale = value;
		}
	}

	public ZoomBar ZoomBar
	{
		get
		{
			return zoomBar;
		}
		private set
		{
			if (zoomBar != null && value != null)
			{
				value.Visibility = zoomBar.Visibility;
			}
			if (zoomBar != null)
			{
				zoomBar.ZoomMap -= ZoomBar_ZoomMap;
			}
			zoomBar = value;
			if (zoomBar != null)
			{
				zoomBar.ZoomMap += ZoomBar_ZoomMap;
			}
		}
	}

	internal MapForeground(MapBase map)
	{
		base.DefaultStyleKey = typeof(MapForeground);
		targetMap = map;
		logo = new Logo();
		copyright = new Copyright();
		scale = new Scale();
		zoomBar = new ZoomBar();
		zoomBar.ZoomMap += ZoomBar_ZoomMap;
		Attach();
	}

	private static void OnCultureChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		((MapForeground)d).OnCultureChanged(e.OldValue as CultureInfo, e.NewValue as CultureInfo);
	}

	protected virtual void OnCultureChanged(CultureInfo oldValue, CultureInfo newValue)
	{
		if (Scale != null && (Scale.Culture == null || Scale.Culture == oldValue))
		{
			Scale.Culture = newValue;
		}
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		Logo = GetTemplateChild("LogoElement") as Logo;
		Scale = GetTemplateChild("ScaleElement") as Scale;
		Copyright = GetTemplateChild("CopyrightElement") as Copyright;
		ZoomBar = GetTemplateChild("ZoomBarElement") as ZoomBar;
		Attach();
		FireTemplateApplied();
	}

	internal void UpdateScale()
	{
		lastOverlayRefresh = DateTime.Now.Ticks;
		lastZoomLevel = targetMap.ZoomLevel;
		if (Scale != null)
		{
			Scale.MetersPerPixel = targetMap.Mode.Scale;
		}
	}

	internal void Attach()
	{
		if (Logo != null)
		{
			Logo.SetBinding(UIElement.VisibilityProperty, new Binding
			{
				Mode = BindingMode.TwoWay,
				Source = targetMap,
				Path = new PropertyPath("LogoVisibility")
			});
		}
		if (Copyright != null)
		{
			Copyright.SetBinding(UIElement.VisibilityProperty, new Binding
			{
				Mode = BindingMode.TwoWay,
				Source = targetMap,
				Path = new PropertyPath("CopyrightVisibility")
			});
		}
		if (Scale != null)
		{
			Scale.SetBinding(UIElement.VisibilityProperty, new Binding
			{
				Mode = BindingMode.TwoWay,
				Source = targetMap,
				Path = new PropertyPath("ScaleVisibility")
			});
		}
		if (ZoomBar != null)
		{
			ZoomBar.SetBinding(UIElement.VisibilityProperty, new Binding
			{
				Mode = BindingMode.TwoWay,
				Source = targetMap,
				Path = new PropertyPath("ZoomBarVisibility")
			});
		}
		Refresh();
		targetMap.ViewChangeStart += Map_ViewChangeStart;
		targetMap.ViewChangeOnFrame += Map_ViewChangeOnFrame;
		targetMap.ViewChangeEnd += Map_ViewChangeEnd;
		targetMap.ModeChanged += Map_ModeChange;
		Map_ModeChange(targetMap, null);
	}

	private void Attributions_CollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
	{
		UpdateAttributions();
	}

	private void UpdateAttributions()
	{
		SyncAttributions(Copyright.Attributions, targetMap.Mode.Attributions);
	}

	private static void SyncAttributions(IList<AttributionInfo> list, IList<AttributionInfo> desired)
	{
		if (list == null)
		{
			return;
		}
		if (desired != null)
		{
			int num = 0;
			while (num < list.Count)
			{
				if (!desired.Contains(list[num]))
				{
					list.RemoveAt(num);
				}
				else
				{
					num++;
				}
			}
			{
				foreach (AttributionInfo item in desired)
				{
					if (!list.Contains(item))
					{
						list.Add(item);
					}
				}
				return;
			}
		}
		list.Clear();
	}

	private void Map_ViewChangeEnd(object sender, MapEventArgs e)
	{
		UpdateScale();
	}

	private void Map_ViewChangeStart(object sender, MapEventArgs e)
	{
		lastOverlayRefresh = DateTime.Now.Ticks;
	}

	private void Map_ViewChangeOnFrame(object sender, MapEventArgs e)
	{
		if (Math.Round(lastZoomLevel) != Math.Round(targetMap.ZoomLevel) || DateTime.Now.Ticks - lastOverlayRefresh >= refreshTicks)
		{
			UpdateScale();
		}
	}

	private void Map_ModeChange(object sender, MapEventArgs e)
	{
		if (previousMode != null)
		{
			previousMode.Attributions.CollectionChanged -= Attributions_CollectionChanged;
		}
		previousMode = targetMap.Mode;
		previousMode.Attributions.CollectionChanged += Attributions_CollectionChanged;
		UpdateAttributions();
		Refresh();
	}

	private void Refresh()
	{
		UpdateScale();
		if (Copyright != null)
		{
			Copyright.SetForBackground = targetMap.Mode.ModeBackground;
		}
		if (Scale != null)
		{
			Scale.SetForBackground = targetMap.Mode.ModeBackground;
		}
	}

	private void ZoomBar_ZoomMap(object sender, MapCommandEventArgs e)
	{
		if (e.Command != null)
		{
			e.Command.Execute(targetMap);
		}
	}

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new BaseAutomationPeer(this, "MapForeground");
	}
}
