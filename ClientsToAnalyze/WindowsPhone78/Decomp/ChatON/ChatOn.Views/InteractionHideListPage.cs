using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.Models;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class InteractionHideListPage : PhoneApplicationPage
{
	private InteractionHideListPageViewModel _viewModel;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	private bool _contentLoaded;

	public InteractionHideListPage()
	{
		InitializeComponent();
		_viewModel = new InteractionHideListPageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
	}

	private void Show_Click(object sender, RoutedEventArgs e)
	{
		Buddy buddy = (sender as FrameworkElement).DataContext as Buddy;
		_viewModel.ShowBuddyInteraction(buddy);
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedTo(e);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/InteractionHideListPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
		}
	}
}
