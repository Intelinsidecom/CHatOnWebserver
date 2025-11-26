using System;
using System.Collections;
using System.Linq;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Input;

namespace Microsoft.Phone.Controls;

public class SelectorSelectionAdapter : ISelectionAdapter
{
	private Selector _selector;

	private bool IgnoringSelectionChanged { get; set; }

	public Selector SelectorControl
	{
		get
		{
			return _selector;
		}
		set
		{
			if (_selector != null)
			{
				_selector.SelectionChanged -= OnSelectionChanged;
			}
			_selector = value;
			if (_selector != null)
			{
				_selector.SelectionChanged += OnSelectionChanged;
			}
		}
	}

	public object SelectedItem
	{
		get
		{
			if (SelectorControl != null)
			{
				return SelectorControl.SelectedItem;
			}
			return null;
		}
		set
		{
			IgnoringSelectionChanged = true;
			if (SelectorControl != null)
			{
				SelectorControl.SelectedItem = value;
			}
			if (value == null)
			{
				ResetScrollViewer();
			}
			IgnoringSelectionChanged = false;
		}
	}

	public IEnumerable ItemsSource
	{
		get
		{
			if (SelectorControl != null)
			{
				return SelectorControl.ItemsSource;
			}
			return null;
		}
		set
		{
			if (SelectorControl != null)
			{
				SelectorControl.ItemsSource = value;
			}
		}
	}

	public event SelectionChangedEventHandler SelectionChanged;

	public event RoutedEventHandler Commit;

	public event RoutedEventHandler Cancel;

	public SelectorSelectionAdapter()
	{
	}

	public SelectorSelectionAdapter(Selector selector)
	{
		SelectorControl = selector;
	}

	private void ResetScrollViewer()
	{
		if (SelectorControl != null)
		{
			SelectorControl.GetLogicalChildrenBreadthFirst().OfType<ScrollViewer>().FirstOrDefault()?.ScrollToVerticalOffset(0.0);
		}
	}

	private void OnSelectionChanged(object sender, SelectionChangedEventArgs e)
	{
		if (!IgnoringSelectionChanged)
		{
			this.SelectionChanged?.Invoke(sender, e);
			OnCommit();
		}
	}

	protected void SelectedIndexIncrement()
	{
		if (SelectorControl != null)
		{
			SelectorControl.SelectedIndex = ((SelectorControl.SelectedIndex + 1 >= SelectorControl.Items.Count) ? (-1) : (SelectorControl.SelectedIndex + 1));
		}
	}

	protected void SelectedIndexDecrement()
	{
		if (SelectorControl != null)
		{
			int selectedIndex = SelectorControl.SelectedIndex;
			if (selectedIndex >= 0)
			{
				SelectorControl.SelectedIndex--;
			}
			else if (selectedIndex == -1)
			{
				SelectorControl.SelectedIndex = SelectorControl.Items.Count - 1;
			}
		}
	}

	public void HandleKeyDown(KeyEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		switch (e.Key)
		{
		case Key.Enter:
			OnCommit();
			e.Handled = true;
			break;
		case Key.Up:
			SelectedIndexDecrement();
			e.Handled = true;
			break;
		case Key.Down:
			if ((ModifierKeys.Alt & Keyboard.Modifiers) == 0)
			{
				SelectedIndexIncrement();
				e.Handled = true;
			}
			break;
		case Key.Escape:
			OnCancel();
			e.Handled = true;
			break;
		}
	}

	protected virtual void OnCommit()
	{
		OnCommit(this, new RoutedEventArgs());
	}

	private void OnCommit(object sender, RoutedEventArgs e)
	{
		this.Commit?.Invoke(sender, e);
		AfterAdapterAction();
	}

	protected virtual void OnCancel()
	{
		OnCancel(this, new RoutedEventArgs());
	}

	private void OnCancel(object sender, RoutedEventArgs e)
	{
		this.Cancel?.Invoke(sender, e);
		AfterAdapterAction();
	}

	private void AfterAdapterAction()
	{
		IgnoringSelectionChanged = true;
		if (SelectorControl != null)
		{
			SelectorControl.SelectedItem = null;
			SelectorControl.SelectedIndex = -1;
		}
		IgnoringSelectionChanged = false;
	}

	public AutomationPeer CreateAutomationPeer()
	{
		if (_selector == null)
		{
			return null;
		}
		return FrameworkElementAutomationPeer.CreatePeerForElement(_selector);
	}
}
