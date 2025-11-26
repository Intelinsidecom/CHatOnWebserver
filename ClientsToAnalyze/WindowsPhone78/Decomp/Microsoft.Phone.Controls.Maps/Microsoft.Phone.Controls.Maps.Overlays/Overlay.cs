using System;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls.Maps.Overlays;

public abstract class Overlay : Control
{
	public event EventHandler TemplateApplied;

	protected void FireTemplateApplied()
	{
		this.TemplateApplied?.Invoke(this, EventArgs.Empty);
	}
}
