using System;

namespace ChatOn.Controls;

public class AniconInstaller
{
	public string ID;

	public event EventHandler InstallCompleted;

	public void RunEventHandler()
	{
		if (this.InstallCompleted != null)
		{
			this.InstallCompleted(this, null);
		}
	}
}
