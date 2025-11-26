using System;
using System.Windows;
using System.Windows.Shapes;

namespace Microsoft.Phone.Controls.Primitives;

public class PanningBackgroundLayer : PanningLayer
{
	protected override double PanRate
	{
		get
		{
			double result = 1.0;
			if (base.Owner != null && base.ContentPresenter != null)
			{
				result = (Math.Max(base.Owner.ViewportWidth, base.ContentPresenter.ActualWidth) - (double)(base.Owner.ViewportWidth / 5 * 4)) / (double)Math.Max(base.Owner.ViewportWidth, base.Owner.ItemsWidth);
			}
			return result;
		}
	}

	protected override void UpdateWrappingRectangles()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_UPDATEWRAPPING, "Background Panning Layer");
		Rectangle leftWraparound = base.LeftWraparound;
		Visibility visibility = (base.RightWraparound.Visibility = (base.IsStatic ? Visibility.Collapsed : Visibility.Visible));
		leftWraparound.Visibility = visibility;
		if (!base.IsStatic && base.Owner.Background != null)
		{
			Rectangle rightWraparound = base.RightWraparound;
			double height = (base.LeftWraparound.Height = base.ContentPresenter.ActualHeight);
			rightWraparound.Height = height;
			Rectangle rightWraparound2 = base.RightWraparound;
			double width = (base.LeftWraparound.Width = base.Owner.ViewportWidth);
			rightWraparound2.Width = width;
			Rectangle leftWraparound2 = base.LeftWraparound;
			Thickness margin = (base.RightWraparound.Margin = base.ContentPresenter.Margin);
			leftWraparound2.Margin = margin;
			base.RightWraparound.Fill = base.Owner.Background;
			base.LeftWraparound.Fill = base.Owner.Background;
		}
		if (base.LocalTransform != null)
		{
			double num2 = ((base.LeftWraparound.Visibility == Visibility.Visible) ? (0.0 - base.LeftWraparound.Width - base.LeftWraparound.Margin.Left) : 0.0);
			base.LocalTransform.X = (base.IsStatic ? 0.0 : (num2 - base.LeftWraparound.Margin.Right));
		}
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_UPDATEWRAPPING, "Background Panning Layer");
	}
}
