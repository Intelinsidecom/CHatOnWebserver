using System;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls;

public class GroupViewOpenedEventArgs : EventArgs
{
	public ItemsControl ItemsControl { get; private set; }

	internal GroupViewOpenedEventArgs(ItemsControl itemsControl)
	{
		ItemsControl = itemsControl;
	}
}
