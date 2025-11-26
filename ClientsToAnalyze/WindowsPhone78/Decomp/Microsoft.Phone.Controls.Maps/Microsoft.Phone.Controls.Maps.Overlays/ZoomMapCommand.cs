using System;
using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps.Overlays;

public class ZoomMapCommand : MapCommandBase
{
	private readonly bool zoomIn;

	public ZoomMapCommand(bool zoomIn)
	{
		this.zoomIn = zoomIn;
	}

	public override void Execute(MapBase map)
	{
		if (zoomIn)
		{
			map.ZoomLevel = Math.Round(map.ZoomLevel + 1.0);
		}
		else
		{
			map.ZoomLevel = Math.Round(map.ZoomLevel - 1.0);
		}
	}
}
