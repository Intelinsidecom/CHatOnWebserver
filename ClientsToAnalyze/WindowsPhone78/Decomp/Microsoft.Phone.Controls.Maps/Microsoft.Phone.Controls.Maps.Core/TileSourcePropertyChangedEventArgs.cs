using System;

namespace Microsoft.Phone.Controls.Maps.Core;

public class TileSourcePropertyChangedEventArgs : EventArgs
{
	private readonly string propertyName;

	private readonly TileSource tileSource;

	public TileSource TileSource => tileSource;

	public string PropertyName => propertyName;

	public TileSourcePropertyChangedEventArgs(TileSource source, string property)
	{
		tileSource = source;
		propertyName = property;
	}
}
