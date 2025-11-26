using System;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Controls;
using System.Windows.Media;
using Microsoft.Phone.Controls.Maps.AutomationPeers;
using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps;

public class MapItemsControl : ItemsControl, IProjectable
{
	private ItemsPresenter ip;

	private MapLayer ml;

	public MapBase ParentMap
	{
		get
		{
			if (base.Parent is IProjectable projectable)
			{
				return projectable.ParentMap;
			}
			return base.Parent as MapBase;
		}
	}

	public MapItemsControl()
	{
		base.DefaultStyleKey = typeof(MapItemsControl);
	}

	public void ProjectionUpdated(ProjectionUpdateLevel updateLevel)
	{
		if (updateLevel != ProjectionUpdateLevel.None)
		{
			InvalidateArrange();
			InvalidateMeasure();
		}
	}

	public override void OnApplyTemplate()
	{
		((FrameworkElement)this).OnApplyTemplate();
		if (VisualTreeHelper.GetChildrenCount(this) > 0)
		{
			ip = VisualTreeHelper.GetChild(this, 0) as ItemsPresenter;
			if (ip != null)
			{
				ip.LayoutUpdated += ip_LayoutUpdated;
			}
		}
	}

	protected override Size ArrangeOverride(Size finalSize)
	{
		if (ml != null)
		{
			ml.InvalidateArrange();
		}
		return base.ArrangeOverride(finalSize);
	}

	protected override Size MeasureOverride(Size availableSize)
	{
		if (ml != null)
		{
			ml.InvalidateMeasure();
		}
		return base.MeasureOverride(availableSize);
	}

	private void ip_LayoutUpdated(object sender, EventArgs e)
	{
		ip.LayoutUpdated -= ip_LayoutUpdated;
		if (VisualTreeHelper.GetChildrenCount(ip) > 0)
		{
			ml = VisualTreeHelper.GetChild(ip, 0) as MapLayer;
		}
	}

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new BaseAutomationPeer(this, "MapItemsControl");
	}
}
