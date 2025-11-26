using System;

namespace Microsoft.Phone.Controls.Primitives;

internal class SelectedIndexChangedEventArgs : EventArgs
{
	public int SelectedIndex { get; private set; }

	public SelectedIndexChangedEventArgs(int index)
	{
		SelectedIndex = index;
	}
}
