using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using System.Windows.Shapes;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class ShareDetailPage : PhoneApplicationPage
{
	private ShareDetailPageViewModel _viewModel;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal ScrollViewer ContentPanel;

	internal Image UploadImage;

	internal TextBox UploadTextbox;

	internal Rectangle UploadingBgRect;

	internal ProgressBar UploadingProgress;

	private bool _contentLoaded;

	public ShareDetailPage()
	{
		InitializeComponent();
		((FrameworkElement)this).Loaded += ShareDetailPage_Loaded;
		_viewModel = new ShareDetailPageViewModel((PhoneApplicationPage)(object)this);
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_DONE;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_BUTTON_CANCEL;
		ApplicationTitle.Text = ResContainer.IDS_CHATON_BODY_SHARE.ToUpper();
	}

	private void ShareDetailPage_Loaded(object sender, RoutedEventArgs e)
	{
		UploadTextbox.Focus();
	}

	private void doneButton_Click(object sender, EventArgs e)
	{
		UploadTextbox.IsEnabled = false;
		UploadTextbox.IsEnabled = true;
		_viewModel.UploadPhoto(UploadTextbox.Text);
	}

	private void cancelButton_Click(object sender, EventArgs e)
	{
		((Page)this).NavigationService.GoBack();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (e.NavigationMode == NavigationMode.Back)
		{
			Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
			return;
		}
		((Page)this).NavigationService.RemoveBackEntry();
		string fileNameToShare = ChatOnService.Instance.FileNameToShare;
		UploadImage.Source = Utility.LoadJpeg(fileNameToShare);
		_viewModel.OnNavigatedTo();
		((Page)this).OnNavigatedTo(e);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/ShareDetailPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (ScrollViewer)((FrameworkElement)this).FindName("ContentPanel");
			UploadImage = (Image)((FrameworkElement)this).FindName("UploadImage");
			UploadTextbox = (TextBox)((FrameworkElement)this).FindName("UploadTextbox");
			UploadingBgRect = (Rectangle)((FrameworkElement)this).FindName("UploadingBgRect");
			UploadingProgress = (ProgressBar)((FrameworkElement)this).FindName("UploadingProgress");
		}
	}
}
