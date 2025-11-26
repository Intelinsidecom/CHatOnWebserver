using System;

namespace Microsoft.Phone.Controls;

public class PivotItemEventArgs : EventArgs
{
	public PivotItem Item { get; private set; }

	public PivotItemEventArgs()
	{
	}

	public PivotItemEventArgs(PivotItem item)
		: this()
	{
		Item = item;
	}
}
