using System.Windows;
using System.Windows.Automation.Peers;

namespace Microsoft.Phone.Controls.Maps.AutomationPeers;

public class BaseAutomationPeer : FrameworkElementAutomationPeer
{
	private readonly string className;

	public BaseAutomationPeer(FrameworkElement element, string className)
		: base(element)
	{
		this.className = className;
	}

	protected override string GetClassNameCore()
	{
		return className;
	}

	protected override string GetNameCore()
	{
		return className;
	}

	protected override AutomationControlType GetAutomationControlTypeCore()
	{
		return AutomationControlType.Custom;
	}
}
