using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace Microsoft.Phone.Controls.Primitives;

public class PanoramaPanel : Panel
{
	internal class ItemStop
	{
		public int Index { get; private set; }

		public int Position { get; private set; }

		public PanoramaItem Item { get; private set; }

		public ItemStop(PanoramaItem item, int index, int position)
		{
			Item = item;
			Index = index;
			Position = position;
		}
	}

	private const int SnapThresholdDivisor = 3;

	private Panorama _owner;

	private readonly List<PanoramaItem> _visibleChildren = new List<PanoramaItem>();

	private readonly List<ItemStop> _itemStops = new List<ItemStop>();

	private PanoramaItem _selectedItem;

	internal IList<PanoramaItem> VisibleChildren => _visibleChildren;

	private Panorama Owner
	{
		get
		{
			return _owner;
		}
		set
		{
			if (_owner != value)
			{
				if (_owner != null)
				{
					_owner.Panel = null;
				}
				_owner = value;
				if (_owner != null)
				{
					_owner.Panel = this;
				}
			}
		}
	}

	public PanoramaPanel()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_STARTUP, PerfLog.PanoramaPanel);
		base.SizeChanged += PanoramaPanel_SizeChanged;
		base.Loaded += PanoramaPanel_Loaded;
		base.Unloaded += PanoramaPanel_UnLoaded;
	}

	private void PanoramaPanel_Loaded(object sender, RoutedEventArgs e)
	{
		base.Loaded -= PanoramaPanel_Loaded;
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_STARTUP, PerfLog.PanoramaPanel);
	}

	private void PanoramaPanel_UnLoaded(object sender, RoutedEventArgs e)
	{
		_owner = null;
	}

	private void PanoramaPanel_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		Owner.ItemsWidth = (int)e.NewSize.Width;
	}

	protected override Size MeasureOverride(Size availableSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_MEASURE, PerfLog.PanoramaPanel);
		if (_owner == null)
		{
			FindOwner();
		}
		int defaultItemIndex = GetDefaultItemIndex();
		Size result = new Size(0.0, availableSize.Height);
		int adjustedViewportWidth = Owner.AdjustedViewportWidth;
		int num = (int)Math.Min(availableSize.Height, Owner.ViewportHeight);
		Size size = new Size(adjustedViewportWidth, num);
		Size size2 = new Size(double.PositiveInfinity, num);
		int count = base.Children.Count;
		_visibleChildren.Clear();
		for (int i = 0; i < count; i++)
		{
			int index = (i + defaultItemIndex) % count;
			PanoramaItem panoramaItem = (PanoramaItem)base.Children[index];
			if (panoramaItem.Visibility == Visibility.Visible)
			{
				_visibleChildren.Add(panoramaItem);
				panoramaItem.Measure((panoramaItem.Orientation == Orientation.Vertical) ? size : size2);
				if (panoramaItem.Orientation == Orientation.Vertical)
				{
					result.Width += adjustedViewportWidth;
				}
				else
				{
					result.Width += Math.Max(adjustedViewportWidth, panoramaItem.DesiredSize.Width);
				}
			}
		}
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_MEASURE, PerfLog.PanoramaPanel);
		return result;
	}

	protected override Size ArrangeOverride(Size finalSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_ARRANGE, PerfLog.PanoramaPanel);
		_itemStops.Clear();
		double num = 0.0;
		Rect finalRect = new Rect(0.0, 0.0, 0.0, finalSize.Height);
		for (int i = 0; i < _visibleChildren.Count; i++)
		{
			PanoramaItem panoramaItem = _visibleChildren[i];
			int num2 = (panoramaItem.StartPosition = (int)num);
			finalRect.X = num2;
			_itemStops.Add(new ItemStop(panoramaItem, i, panoramaItem.StartPosition));
			if (panoramaItem.Orientation == Orientation.Vertical)
			{
				finalRect.Width = Owner.AdjustedViewportWidth;
			}
			else
			{
				finalRect.Width = Math.Max(Owner.AdjustedViewportWidth, panoramaItem.DesiredSize.Width);
				if (finalRect.Width > (double)Owner.AdjustedViewportWidth)
				{
					_itemStops.Add(new ItemStop(panoramaItem, i, panoramaItem.StartPosition + (int)finalRect.Width - Owner.AdjustedViewportWidth));
				}
			}
			panoramaItem.ItemWidth = (int)finalRect.Width;
			panoramaItem.Arrange(finalRect);
			num += finalRect.Width;
		}
		Owner.RequestAdjustSelection();
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_ARRANGE, PerfLog.PanoramaPanel);
		return finalSize;
	}

	private int GetDefaultItemIndex()
	{
		PanoramaItem defaultItemContainer = Owner.GetDefaultItemContainer();
		int num = ((defaultItemContainer != null) ? base.Children.IndexOf(defaultItemContainer) : 0);
		if (num < 0)
		{
			num = 0;
		}
		return num;
	}

	private void GetItemsInView(int offset, int viewportWidth, out int leftIndex, out int leftInView, out int centerIndex, out int rightIndex, out int rightInView)
	{
		leftIndex = (leftInView = (centerIndex = (rightIndex = (rightInView = -1))));
		int count = VisibleChildren.Count;
		if (count == 0)
		{
			return;
		}
		for (int i = 0; i < count; i++)
		{
			PanoramaItem panoramaItem = _visibleChildren[i];
			int num = panoramaItem.StartPosition + offset;
			int num2 = num + panoramaItem.ItemWidth - 1;
			if (num <= 0 && num2 >= 0)
			{
				leftIndex = i;
				leftInView = Math.Min(viewportWidth, panoramaItem.ItemWidth + num);
			}
			if (num < viewportWidth && num2 >= viewportWidth)
			{
				rightIndex = i;
				rightInView = Math.Min(viewportWidth, viewportWidth - num);
			}
			if (num > 0 && num2 < viewportWidth)
			{
				centerIndex = i;
			}
			if (i == 0 && leftInView == -1)
			{
				leftInView = num;
			}
			if (i == count - 1 && rightInView == -1)
			{
				rightInView = viewportWidth - num2 - 1;
			}
		}
	}

	internal void GetStops(int offset, int totalWidth, out ItemStop previous, out ItemStop current, out ItemStop next)
	{
		int num2;
		int num3;
		int num = (num2 = (num3 = -1));
		next = (current = (previous = null));
		if (VisibleChildren.Count == 0)
		{
			return;
		}
		int num4 = -offset % totalWidth;
		int num5 = 0;
		foreach (ItemStop itemStop in _itemStops)
		{
			if (itemStop.Position < num4)
			{
				num = num5;
			}
			else
			{
				if (itemStop.Position > num4)
				{
					num3 = num5;
					break;
				}
				if (itemStop.Position == num4)
				{
					num2 = num5;
				}
			}
			num5++;
		}
		if (num == -1)
		{
			num = _itemStops.Count - 1;
		}
		if (num3 == -1)
		{
			num3 = 0;
		}
		previous = _itemStops[num];
		current = ((num2 != -1) ? _itemStops[num2] : null);
		next = _itemStops[num3];
	}

	internal void GetSnapOffset(int offset, int viewportWidth, int direction, out int snapTo, out int newDirection, out PanoramaItem newSelection, out bool wraparound)
	{
		int num = viewportWidth / 3;
		wraparound = false;
		snapTo = offset;
		newDirection = direction;
		newSelection = _selectedItem;
		if (VisibleChildren.Count == 0)
		{
			return;
		}
		foreach (ItemStop itemStop in _itemStops)
		{
			if (itemStop.Position == -offset)
			{
				newSelection = itemStop.Item;
				return;
			}
		}
		GetItemsInView(offset, viewportWidth, out var leftIndex, out var leftInView, out var centerIndex, out var rightIndex, out var rightInView);
		if (leftIndex == rightIndex && leftIndex != -1)
		{
			newSelection = (_selectedItem = _visibleChildren[leftIndex]);
			return;
		}
		bool flag = false;
		if (leftIndex == -1)
		{
			flag = true;
			leftIndex = _visibleChildren.Count - 1;
		}
		bool flag2 = false;
		if (rightIndex == -1)
		{
			flag2 = true;
			rightIndex = 0;
		}
		int num2;
		if (direction < 0)
		{
			if (rightInView > num)
			{
				num2 = GetBestIndex(centerIndex, rightIndex, leftIndex);
				newDirection = -1;
			}
			else
			{
				num2 = GetBestIndex(leftIndex, centerIndex, rightIndex);
				newDirection = 1;
			}
		}
		else if (direction > 0)
		{
			if (leftInView > num)
			{
				num2 = GetBestIndex(leftIndex, centerIndex, rightIndex);
				newDirection = 1;
			}
			else
			{
				num2 = GetBestIndex(centerIndex, rightIndex, leftIndex);
				newDirection = -1;
			}
		}
		else if (centerIndex != -1)
		{
			num2 = centerIndex;
			newDirection = -1;
		}
		else if (leftInView > rightInView)
		{
			num2 = leftIndex;
			newDirection = -1;
		}
		else
		{
			num2 = rightIndex;
			newDirection = 1;
		}
		_selectedItem = _visibleChildren[num2];
		if (newDirection < 0)
		{
			snapTo = GetLeftAlignedOffset(_selectedItem, viewportWidth);
		}
		else
		{
			snapTo = GetRightAlignedOffset(_selectedItem, viewportWidth);
		}
		newSelection = _selectedItem;
		if ((num2 == leftIndex && flag) || (num2 == rightIndex && flag2))
		{
			wraparound = true;
		}
	}

	private static int GetBestIndex(int n0, int n1, int n2)
	{
		if (n0 >= 0)
		{
			return n0;
		}
		if (n1 >= 0)
		{
			return n1;
		}
		if (n2 >= 0)
		{
			return n2;
		}
		throw new InvalidOperationException("No best index.");
	}

	private static int GetLeftAlignedOffset(PanoramaItem movingTo, int viewportWidth)
	{
		return -movingTo.StartPosition;
	}

	private static int GetRightAlignedOffset(PanoramaItem movingTo, int viewportWidth)
	{
		if (movingTo.Orientation != Orientation.Vertical)
		{
			return -movingTo.ItemWidth + viewportWidth - movingTo.StartPosition - 48;
		}
		return -movingTo.StartPosition;
	}

	private void FindOwner()
	{
		Panorama panorama = null;
		FrameworkElement frameworkElement = this;
		do
		{
			frameworkElement = (FrameworkElement)VisualTreeHelper.GetParent(frameworkElement);
			panorama = frameworkElement as Panorama;
		}
		while (frameworkElement != null && panorama == null);
		Owner = panorama;
	}

	internal void NotifyDefaultItemChanged()
	{
		InvalidateMeasure();
		InvalidateArrange();
		UpdateLayout();
	}

	internal void ShowLastItemOnLeft()
	{
		ResetItemPositions();
		if (VisibleChildren.Count > 0)
		{
			PanoramaItem panoramaItem = VisibleChildren[VisibleChildren.Count - 1];
			panoramaItem.RenderTransform = new TranslateTransform
			{
				X = 0.0 - base.ActualWidth
			};
		}
	}

	internal void ShowFirstItemOnRight()
	{
		ResetItemPositions();
		if (VisibleChildren.Count > 0)
		{
			PanoramaItem panoramaItem = VisibleChildren[0];
			panoramaItem.RenderTransform = new TranslateTransform
			{
				X = base.ActualWidth
			};
		}
	}

	internal void ResetItemPositions()
	{
		foreach (PanoramaItem visibleChild in VisibleChildren)
		{
			visibleChild.RenderTransform = null;
		}
	}
}
