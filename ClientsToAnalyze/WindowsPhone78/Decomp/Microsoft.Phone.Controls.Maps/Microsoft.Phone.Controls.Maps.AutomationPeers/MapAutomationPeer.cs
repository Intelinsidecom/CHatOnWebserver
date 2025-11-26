using System.Windows;
using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps.AutomationPeers;

public class MapAutomationPeer : MapBaseAutomationPeer
{
	public MapAutomationPeer(Map element)
		: base(element, "Map")
	{
	}

	public void DoubleTap(Point viewportPoint)
	{
		((Map)base.Map).InputManager.OnTouchZoom(new MapZoomEventArgs(viewportPoint, 1.0));
	}

	public void Drag(Point viewportPoint, Point dragDelta)
	{
		((Map)base.Map).InputManager.OnTouchDrag(new MapDragEventArgs(viewportPoint, dragDelta));
	}

	public void Flick(Point viewportPoint, Point velocity)
	{
		((Map)base.Map).InputManager.OnTouchFlick(new MapFlickEventArgs(viewportPoint, velocity));
	}

	public void Zoom(Point viewportPoint, double zoomDelta)
	{
		((Map)base.Map).InputManager.OnTouchZoom(new MapZoomEventArgs(viewportPoint, zoomDelta));
	}

	public void Scale(Point viewportPoint, double scaleDelta)
	{
		((Map)base.Map).InputManager.PinchStretchReported(base.Map, new PinchStretchEventArgs(new PinchStretchData
		{
			CenterPoint = viewportPoint,
			Scale = scaleDelta
		}));
	}
}
