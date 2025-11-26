using System;
using System.Windows;

namespace Microsoft.Phone.Controls.Maps.Core;

internal abstract class GestureEventArgs : EventArgs
{
	public Point Origin { get; internal set; }

	public abstract GestureType GestureType { get; }
}
