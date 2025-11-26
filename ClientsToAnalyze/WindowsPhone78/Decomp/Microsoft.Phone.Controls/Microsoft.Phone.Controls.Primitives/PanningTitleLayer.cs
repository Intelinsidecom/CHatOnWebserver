using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Media.Imaging;

namespace Microsoft.Phone.Controls.Primitives;

public class PanningTitleLayer : PanningLayer
{
	private double WidthAdjustment => (double)base.Owner.ViewportWidth * 0.625;

	protected override double PanRate
	{
		get
		{
			double result = 1.0;
			if (base.Owner != null && base.ContentPresenter != null)
			{
				result = (Math.Max(base.Owner.ViewportWidth, base.ContentPresenter.ActualWidth + WidthAdjustment) - (double)(base.Owner.ViewportWidth / 5 * 4)) / (double)Math.Max(base.Owner.ViewportWidth, base.Owner.ItemsWidth);
			}
			return result;
		}
	}

	public override void Wraparound(int direction)
	{
		if (direction < 0)
		{
			int targetOffset = (int)((base.ActualOffset + base.ContentPresenter.ActualWidth + WidthAdjustment) / PanRate);
			GoTo(targetOffset, PanningLayer.Immediately, null);
		}
		else
		{
			int targetOffset2 = (int)((base.ActualOffset - base.ContentPresenter.ActualWidth - WidthAdjustment) / PanRate);
			GoTo(targetOffset2, PanningLayer.Immediately, null);
		}
	}

	protected override void UpdateWrappingRectangles()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_UPDATEWRAPPING, PerfLog.PanningLayer);
		bool flag = !(base.Content is ItemsPresenter) || base.Owner.Panel == null || base.Owner.Panel.VisibleChildren.Count < 3;
		base.RightWraparound.Visibility = ((base.IsStatic || !flag) ? Visibility.Collapsed : Visibility.Visible);
		if (!base.IsStatic && flag)
		{
			base.RightWraparound.Height = base.ContentPresenter.ActualHeight;
			base.RightWraparound.Width = base.Owner.ViewportWidth;
			WriteableBitmap writeableBitmap = new WriteableBitmap(base.Owner.ViewportWidth, (int)base.ContentPresenter.ActualHeight);
			TranslateTransform transform = new TranslateTransform();
			writeableBitmap.Render(base.ContentPresenter, transform);
			writeableBitmap.Invalidate();
			base.RightWraparound.Fill = new ImageBrush
			{
				ImageSource = writeableBitmap
			};
		}
		int num = (int)((double)base.Owner.ViewportWidth * 0.1);
		base.RightWraparound.Margin = new Thickness(WidthAdjustment + (double)num, 0.0, 0.0, 0.0);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_UPDATEWRAPPING, PerfLog.PanningLayer);
	}
}
