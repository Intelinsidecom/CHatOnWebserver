using System.Device.Location;
using System.Windows;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls.Maps;

public abstract class MapLayerBase : Panel
{
	public abstract void AddChild(UIElement element, GeoCoordinate location);

	public abstract void AddChild(UIElement element, GeoCoordinate location, Point offset);

	public abstract void AddChild(UIElement element, GeoCoordinate location, PositionOrigin origin);

	public abstract void AddChild(UIElement element, LocationRect locationRect);
}
