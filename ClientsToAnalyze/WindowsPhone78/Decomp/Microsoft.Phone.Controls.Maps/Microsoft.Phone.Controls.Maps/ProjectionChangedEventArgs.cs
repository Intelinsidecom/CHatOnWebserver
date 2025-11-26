using System;

namespace Microsoft.Phone.Controls.Maps;

public class ProjectionChangedEventArgs : EventArgs
{
	public ProjectionUpdateLevel UpdateLevel { get; internal set; }

	internal ProjectionChangedEventArgs(ProjectionUpdateLevel updateLevel)
	{
		UpdateLevel = updateLevel;
	}
}
