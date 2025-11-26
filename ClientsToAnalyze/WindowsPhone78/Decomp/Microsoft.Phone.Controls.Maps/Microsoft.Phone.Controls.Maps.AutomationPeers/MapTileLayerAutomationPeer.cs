using System;
using System.Globalization;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Automation.Provider;

namespace Microsoft.Phone.Controls.Maps.AutomationPeers;

public class MapTileLayerAutomationPeer : BaseAutomationPeer, IValueProvider
{
	private readonly MapTileLayer tileLayer;

	public bool IsReadOnly => true;

	public string Value
	{
		get
		{
			if (tileLayer != null)
			{
				return string.Format(CultureInfo.InvariantCulture, "IsIdle={0}", tileLayer.IsIdle);
			}
			return "Invalid MapTileLayer object";
		}
	}

	public MapTileLayerAutomationPeer(FrameworkElement element)
		: base(element, "MapTileLayer")
	{
		tileLayer = element as MapTileLayer;
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
