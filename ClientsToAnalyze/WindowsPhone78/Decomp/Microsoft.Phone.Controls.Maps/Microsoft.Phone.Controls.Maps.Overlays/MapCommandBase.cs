using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps.Overlays;

public abstract class MapCommandBase
{
	public abstract void Execute(MapBase map);
}
