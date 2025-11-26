using System.Windows.Automation.Peers;
using Microsoft.Phone.Controls.Maps.AutomationPeers;

namespace Microsoft.Phone.Controls.Maps.Overlays;

public class Logo : Overlay
{
	public Logo()
	{
		base.DefaultStyleKey = typeof(Logo);
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		FireTemplateApplied();
	}

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new BaseAutomationPeer(this, "Logo");
	}
}
