using System;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace TestListViewScrolling;

public class ScrollAwareListView : ListView
{
	private bool _IsOnTop { get; set; }

	public bool IsOnTop
	{
		get
		{
			if (IsIntermediate)
			{
				return false;
			}
			return _IsOnTop;
		}
	}

	private bool _IsOnBottom { get; set; }

	public bool IsOnBottom
	{
		get
		{
			if (IsIntermediate)
			{
				return false;
			}
			return _IsOnBottom;
		}
	}

	private bool IsIntermediate { get; set; }

	public event EventHandler OnHitTopMost;

	public event EventHandler OnHitBottomMost;

	protected unsafe override void OnApplyTemplate()
	{
		((FrameworkElement)this).OnApplyTemplate();
		ScrollViewer firstDescendantOfType = ((DependencyObject)(object)this).GetFirstDescendantOfType<ScrollViewer>();
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<ScrollViewerViewChangedEventArgs>, EventRegistrationToken>(firstDescendantOfType, (nint)__ldftn(ScrollViewer.add_ViewChanged)), new Action<EventRegistrationToken>(firstDescendantOfType, (nint)__ldftn(ScrollViewer.remove_ViewChanged)), scrollviewer_ViewChanged);
	}

	private void scrollviewer_ViewChanged(object sender, ScrollViewerViewChangedEventArgs e)
	{
		IsIntermediate = e.IsIntermediate;
		bool isOnTop = _IsOnTop;
		_IsOnTop = ((ScrollViewer)((sender is ScrollViewer) ? sender : null)).VerticalOffset <= 2.0;
		if (_IsOnTop && !isOnTop && this.OnHitTopMost != null)
		{
			this.OnHitTopMost(this, new EventArgs());
		}
		isOnTop = _IsOnBottom;
		_IsOnBottom = ((ScrollViewer)((sender is ScrollViewer) ? sender : null)).VerticalOffset - ((ScrollViewer)((sender is ScrollViewer) ? sender : null)).ScrollableHeight == 0.0;
		if (_IsOnBottom && !isOnTop && this.OnHitBottomMost != null)
		{
			this.OnHitBottomMost(this, new EventArgs());
		}
	}
}
