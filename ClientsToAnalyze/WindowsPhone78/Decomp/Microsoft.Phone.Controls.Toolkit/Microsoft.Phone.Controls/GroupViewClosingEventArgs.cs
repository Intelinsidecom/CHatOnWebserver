using System;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls;

public class GroupViewClosingEventArgs : EventArgs
{
	public ItemsControl ItemsControl { get; private set; }

	public object SelectedGroup { get; private set; }

	public bool Cancel { get; set; }

	internal GroupViewClosingEventArgs(ItemsControl itemsControl, object selectedGroup)
	{
		ItemsControl = itemsControl;
		SelectedGroup = selectedGroup;
	}
}
