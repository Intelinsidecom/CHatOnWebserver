using System;
using System.ComponentModel;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Models;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class BlockListPage : PhoneApplicationPage
{
	private BlockListPageViewModel _viewModel;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	private bool _contentLoaded;

	public BlockListPage()
	{
		InitializeComponent();
		_viewModel = new BlockListPageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void UnBlock_Click(object sender, RoutedEventArgs e)
	{
		Buddy buddy = (sender as FrameworkElement).DataContext as Buddy;
		_viewModel.UnBlock(buddy);
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
		((PhoneApplicationPage)this).OnBackKeyPress(e);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/BlockListPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
		}
	}
}
