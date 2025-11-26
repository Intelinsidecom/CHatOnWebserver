using System;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Controls;
using Microsoft.Phone.Controls.Maps.AutomationPeers;

namespace Microsoft.Phone.Controls.Maps.Overlays;

[TemplatePart(Name = "ZoomOut", Type = typeof(Button))]
[TemplatePart(Name = "ZoomIn", Type = typeof(Button))]
public class ZoomBar : Overlay
{
	internal const string ZoomInElementName = "ZoomIn";

	internal const string ZoomOutElementName = "ZoomOut";

	private Button zoomIn;

	private Button zoomOut;

	public event EventHandler<MapCommandEventArgs> ZoomMap;

	public ZoomBar()
	{
		base.DefaultStyleKey = typeof(ZoomBar);
		zoomIn = new Button();
		zoomOut = new Button();
	}

	~ZoomBar()
	{
		this.ZoomMap = null;
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		zoomIn = GetTemplateChild("ZoomIn") as Button;
		zoomOut = GetTemplateChild("ZoomOut") as Button;
		if (zoomIn != null)
		{
			zoomIn.Click += ZoomIn_Click;
		}
		if (zoomOut != null)
		{
			zoomOut.Click += ZoomOut_Click;
		}
		FireTemplateApplied();
	}

	private void ZoomIn_Click(object sender, RoutedEventArgs e)
	{
		OnZoomMap(new ZoomMapCommand(zoomIn: true));
	}

	private void ZoomOut_Click(object sender, RoutedEventArgs e)
	{
		OnZoomMap(new ZoomMapCommand(zoomIn: false));
	}

	protected virtual void OnZoomMap(ZoomMapCommand command)
	{
		EventHandler<MapCommandEventArgs> zoomMap = this.ZoomMap;
		if (command != null)
		{
			zoomMap?.Invoke(this, new MapCommandEventArgs(command));
		}
	}

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new BaseAutomationPeer(this, "ZoomBar");
	}
}
