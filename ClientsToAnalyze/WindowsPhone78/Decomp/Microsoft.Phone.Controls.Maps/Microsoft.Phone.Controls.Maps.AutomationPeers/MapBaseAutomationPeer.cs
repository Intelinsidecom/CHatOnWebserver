using System;
using System.Globalization;
using System.Windows.Automation.Peers;
using System.Windows.Automation.Provider;
using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps.AutomationPeers;

public class MapBaseAutomationPeer : BaseAutomationPeer, IValueProvider
{
	private readonly MapBase map;

	protected MapBase Map => map;

	public bool IsReadOnly => true;

	public string Value
	{
		get
		{
			if (map != null)
			{
				return string.Format(CultureInfo.InvariantCulture, "ZoomLevel={0}|Latitude={1}|Longitude={2}|Heading={3}|Pitch={4}|MapMode={5}|Width={6}|Height={7}", map.ZoomLevel, map.Center.Latitude, map.Center.Longitude, map.Heading, map.Pitch, map.Mode, map.ActualWidth, map.ActualHeight);
			}
			return "Invalid map object";
		}
	}

	public MapBaseAutomationPeer(MapBase element)
		: this(element, "MapBase")
	{
	}

	public MapBaseAutomationPeer(MapBase element, string className)
		: base(element, className)
	{
		map = element;
	}

	public override object GetPattern(PatternInterface patternInterface)
	{
		if (patternInterface == PatternInterface.Value)
		{
			return this;
		}
		return base.GetPattern(patternInterface);
	}

	public void SetValue(string value)
	{
		throw new NotImplementedException();
	}
}
