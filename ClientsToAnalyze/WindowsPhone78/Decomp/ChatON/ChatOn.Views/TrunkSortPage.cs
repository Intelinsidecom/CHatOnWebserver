using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class TrunkSortPage : PhoneApplicationPage
{
	private TrunkSortPageViewModel _viewModel;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal ListBox listBox1;

	private bool _contentLoaded;

	public TrunkSortPage()
	{
		InitializeComponent();
		_viewModel = new TrunkSortPageViewModel((PhoneApplicationPage)(object)this);
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

	private void BtnLatestComment(object sender, MouseButtonEventArgs e)
	{
		_viewModel.LatestComment();
	}

	private void BtnRecent(object sender, MouseButtonEventArgs e)
	{
		_viewModel.Recent();
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/TrunkSortPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			listBox1 = (ListBox)((FrameworkElement)this).FindName("listBox1");
		}
	}
}
