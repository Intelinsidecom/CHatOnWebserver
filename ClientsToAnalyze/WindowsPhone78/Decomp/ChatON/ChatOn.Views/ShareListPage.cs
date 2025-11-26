using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using System.Windows.Shapes;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class ShareListPage : PhoneApplicationPage
{
	private ShareListPageViewModel _viewModel;

	private bool _runAnimation;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal ListBox ShareList;

	internal Rectangle UploadingBgRect;

	internal ProgressBar UploadingProgress;

	private bool _contentLoaded;

	public ShareListPage()
	{
		InitializeComponent();
		_viewModel = new ShareListPageViewModel((PhoneApplicationPage)(object)this);
		((FrameworkElement)this).DataContext = _viewModel;
		ApplicationTitle.Text = ResContainer.IDS_CHATON_BODY_SHARE.ToUpper();
		_runAnimation = true;
	}

	private void shareListItemTap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		ShareItem shareItem = (sender as FrameworkElement).DataContext as ShareItem;
		shareItem.Execute();
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
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/ShareListPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			ShareList = (ListBox)((FrameworkElement)this).FindName("ShareList");
			UploadingBgRect = (Rectangle)((FrameworkElement)this).FindName("UploadingBgRect");
			UploadingProgress = (ProgressBar)((FrameworkElement)this).FindName("UploadingProgress");
		}
	}
}
