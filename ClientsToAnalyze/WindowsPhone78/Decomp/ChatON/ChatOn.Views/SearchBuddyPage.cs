using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Services;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class SearchBuddyPage : PhoneApplicationPage
{
	private SearchBuddyPageViewModel _viewModel;

	private bool _isNew = true;

	internal Grid LayoutRoot;

	internal TextBox InputBox;

	internal ListBox SearchResultList;

	private bool _contentLoaded;

	public SearchBuddyPage()
	{
		InitializeComponent();
		_viewModel = new SearchBuddyPageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
		((FrameworkElement)this).Loaded += SearchBuddyPage_Loaded;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void SearchBuddyPage_Loaded(object sender, RoutedEventArgs e)
	{
		if (_isNew)
		{
			InputBox.Focus();
			_isNew = false;
			_viewModel.UpdateBuddyList();
		}
		else if (ChatOnService.Instance.IsBuddiesUpdated)
		{
			_viewModel.UpdateBuddyList();
		}
	}

	private void InputBox_TextChanged(object sender, TextChangedEventArgs e)
	{
		TextBox textBox = sender as TextBox;
		_viewModel.Keyword = textBox.Text;
	}

	private void Image_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		BuddySummary buddySummary = (sender as FrameworkElement).DataContext as BuddySummary;
		PageNavigationService.OpenBuddyProfilePage((PhoneApplicationPage)(object)this, buddySummary.Buddy.PhoneNumber);
	}

	private void HilightedTextBlock_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		BuddySummary buddySummary = (sender as FrameworkElement).DataContext as BuddySummary;
		_viewModel.StartChat(buddySummary.Buddy);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/SearchBuddyPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
			SearchResultList = (ListBox)((FrameworkElement)this).FindName("SearchResultList");
		}
	}
}
