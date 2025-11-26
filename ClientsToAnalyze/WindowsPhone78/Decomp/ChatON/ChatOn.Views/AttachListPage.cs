using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using System.Windows.Shapes;
using ChatOn.Infrastructure;
using ChatOn.Services;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class AttachListPage : PhoneApplicationPage
{
	private AttachListPageViewModel _viewModel;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal ListBox AttachList;

	internal Rectangle UploadingBgRect;

	internal ProgressBar UploadingProgress;

	private bool _contentLoaded;

	public AttachListPage()
	{
		InitializeComponent();
		_viewModel = new AttachListPageViewModel((PhoneApplicationPage)(object)this);
		((FrameworkElement)this).DataContext = _viewModel;
	}

	private void attachListItemTap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		ToolItem toolItem = (sender as FrameworkElement).DataContext as ToolItem;
		toolItem.Execute();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e.NavigationMode == NavigationMode.Back && !AttachmentService.Instance.IsCropPageActive)
		{
			((UIElement)this).Visibility = Visibility.Collapsed;
			((Page)this).NavigationService.GoBack();
		}
		((Page)this).OnNavigatedTo(e);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/AttachListPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			AttachList = (ListBox)((FrameworkElement)this).FindName("AttachList");
			UploadingBgRect = (Rectangle)((FrameworkElement)this).FindName("UploadingBgRect");
			UploadingProgress = (ProgressBar)((FrameworkElement)this).FindName("UploadingProgress");
		}
	}
}
