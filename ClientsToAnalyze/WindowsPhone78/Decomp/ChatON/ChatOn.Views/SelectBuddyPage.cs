using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.ViewModels;
using com.sec.ssm.common;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class SelectBuddyPage : PhoneApplicationPage
{
	public delegate void SelectBuddyPageEventHandler(object sender, object arg);

	private bool _isNew = true;

	private bool _isRunningAnimation;

	private SelectBuddyPageViewModel _viewModel;

	private static List<string> _exceptionNumbers;

	private static List<string> _preSelectedNumbers;

	private static ChatType _chatType;

	private static bool _isReturnAllMode;

	private static bool _isExceptSpecialBuddies = false;

	private static int _selectionCountLimit = 0;

	internal Grid LayoutRoot;

	internal TextBlock ApplicationTitle;

	internal ScrollViewer SelectedBuddyScroll;

	internal ItemsControl SelectedBuddyList;

	internal ListBox BuddyList;

	internal ListBox SearchResultList;

	internal TextBox InputBox;

	internal StackPanel SearchPanel;

	private bool _contentLoaded;

	public static int SelectionCountLimit
	{
		get
		{
			return _selectionCountLimit;
		}
		set
		{
			_selectionCountLimit = value;
		}
	}

	public static List<string> ExceptionNumbers
	{
		get
		{
			return _exceptionNumbers;
		}
		set
		{
			_exceptionNumbers = value;
		}
	}

	public static List<string> PreSelectedNumbers
	{
		get
		{
			return _preSelectedNumbers;
		}
		set
		{
			_preSelectedNumbers = value;
		}
	}

	public static ChatType ChatType
	{
		get
		{
			return _chatType;
		}
		set
		{
			_chatType = value;
		}
	}

	public static bool IsReturnAllMode
	{
		get
		{
			return _isReturnAllMode;
		}
		set
		{
			_isReturnAllMode = value;
		}
	}

	public static bool IsExceptSpecialBuddies
	{
		get
		{
			return _isExceptSpecialBuddies;
		}
		set
		{
			_isExceptSpecialBuddies = value;
		}
	}

	public static event SelectBuddyPageEventHandler SelectionCompleted;

	public SelectBuddyPage()
	{
		InitializeComponent();
		_viewModel = new SelectBuddyPageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_DONE;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_BUTTON_CANCEL;
		ChatOnService.Instance.SelectBuddyPage = this;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			if (SelectBuddyPage.SelectionCompleted == null)
			{
				((DependencyObject)this).Dispatcher.BeginInvoke(delegate
				{
					Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
				});
			}
			else
			{
				string originalString = ((Page)this).NavigationService.BackStack.First().Source.OriginalString;
				if (originalString.Contains("AddGroupPage.xaml"))
				{
					((Page)this).NavigationService.RemoveBackEntry();
				}
				_isNew = false;
			}
		}
		((Page)this).OnNavigatedTo(e);
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (e.NavigationMode == NavigationMode.Back)
		{
			_isReturnAllMode = false;
			_isExceptSpecialBuddies = false;
			_exceptionNumbers = null;
			_preSelectedNumbers = null;
			SelectBuddyPage.SelectionCompleted = null;
		}
		((Page)this).OnNavigatedFrom(e);
	}

	protected override void OnBackKeyPress(CancelEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (LoadingIndicator.HandleBackKey())
		{
			e.Cancel = true;
		}
		if (ListIndexSelector.HandleBackKey())
		{
			e.Cancel = true;
		}
		if (_isRunningAnimation)
		{
			e.Cancel = true;
		}
		((PhoneApplicationPage)this).OnBackKeyPress(e);
	}

	private void SearchPanel_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		SearchPanel.Visibility = Visibility.Collapsed;
		InputBox.Visibility = Visibility.Visible;
		InputBox.Focus();
	}

	private void Item_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		BuddySummary buddySummary = (sender as FrameworkElement).DataContext as BuddySummary;
		buddySummary.Buddy.IsChecked = !buddySummary.Buddy.IsChecked;
		_viewModel.UpdateSelectedBuddyItems(buddySummary);
	}

	private void CheckBox_Click(object sender, RoutedEventArgs e)
	{
		BuddySummary sum = (sender as FrameworkElement).DataContext as BuddySummary;
		_viewModel.UpdateSelectedBuddyItems(sum);
	}

	private void DoneButton_Click(object sender, EventArgs e)
	{
		if (!_isReturnAllMode && _viewModel.SelectedBuddyItems.Count == 0)
		{
			if (SelectBuddyPage.SelectionCompleted != null)
			{
				SelectBuddyPage.SelectionCompleted(this, _viewModel.SelectedBuddyItems);
			}
			return;
		}
		_isRunningAnimation = true;
		bool flag = false;
		for (int i = 0; i < BuddyList.Items.Count; i++)
		{
			if (BuddyList.ItemContainerGenerator.ContainerFromIndex(i) is FrameworkElement { DataContext: BuddySummary dataContext } frameworkElement && (dataContext.Buddy == null || !dataContext.Buddy.IsChecked))
			{
				DependencyObject child = VisualTreeHelper.GetChild(frameworkElement, 0);
				child = VisualTreeHelper.GetChild(child, 0);
				child = VisualTreeHelper.GetChild(child, 0);
				child = VisualTreeHelper.GetChild(child, 0);
				Storyboard storyboard = (child as FrameworkElement).Resources["Storyboard1"] as Storyboard;
				if (!flag)
				{
					storyboard.Completed += sb_Completed;
					flag = true;
				}
				storyboard.Begin();
			}
		}
	}

	private void sb_Completed(object sender, EventArgs e)
	{
		if (_isReturnAllMode)
		{
			if (SelectBuddyPage.SelectionCompleted != null)
			{
				SelectBuddyPage.SelectionCompleted(this, _viewModel.BuddyItems);
			}
		}
		else if (SelectBuddyPage.SelectionCompleted != null)
		{
			SelectBuddyPage.SelectionCompleted(this, _viewModel.SelectedBuddyItems);
		}
	}

	private void CancelButton_Click(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void Button_Click(object sender, RoutedEventArgs e)
	{
		BuddySummary buddySummary = (sender as FrameworkElement).DataContext as BuddySummary;
		buddySummary.Buddy.IsChecked = false;
		_viewModel.UpdateSelectedBuddyItems(buddySummary);
	}

	private void InputBox_TextChanged(object sender, TextChangedEventArgs e)
	{
		TextBox textBox = sender as TextBox;
		_viewModel.Keyword = textBox.Text;
	}

	private void GroupItem_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		BuddySummary buddySummary = (sender as FrameworkElement).DataContext as BuddySummary;
		string[] array = Utility.Split(buddySummary.Group.Members);
		string[] array2 = array;
		foreach (string text in array2)
		{
			foreach (BuddySummary buddyItem in _viewModel.BuddyItems)
			{
				if (buddyItem.Buddy != null && buddyItem.Buddy.PhoneNumber == text && !buddyItem.Buddy.IsChecked)
				{
					buddyItem.Buddy.IsChecked = true;
					_viewModel.UpdateSelectedBuddyItems(buddyItem);
					break;
				}
			}
		}
	}

	private void ListIndex_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		_viewModel.ShowIndexSelector();
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/SelectBuddyPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			SelectedBuddyScroll = (ScrollViewer)((FrameworkElement)this).FindName("SelectedBuddyScroll");
			SelectedBuddyList = (ItemsControl)((FrameworkElement)this).FindName("SelectedBuddyList");
			BuddyList = (ListBox)((FrameworkElement)this).FindName("BuddyList");
			SearchResultList = (ListBox)((FrameworkElement)this).FindName("SearchResultList");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
			SearchPanel = (StackPanel)((FrameworkElement)this).FindName("SearchPanel");
		}
	}
}
