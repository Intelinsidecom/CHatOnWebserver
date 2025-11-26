using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Res;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class ImageViewerPage : PhoneApplicationPage
{
	private bool _isNew = true;

	private string _filePath;

	internal Grid LayoutRoot;

	internal Image SourceImage;

	private bool _contentLoaded;

	public ImageViewerPage()
	{
		InitializeComponent();
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_SAVE;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_BUTTON_CLOSE;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
			if (queryString.ContainsKey("source"))
			{
				_filePath = queryString["source"];
				SourceImage.Source = Utility.LoadJpeg(_filePath);
				((PhoneApplicationPage)this).ApplicationBar.IsVisible = true;
			}
			else if (queryString.ContainsKey("profileImage"))
			{
				string text = queryString["profileImage"];
				_filePath = "Cache\\" + text + ".jpg";
				SSMService sSMService = new SSMService();
				SourceImage.Source = new BitmapImage(sSMService.GetBuddyProfileImageUri(text, isThumbnail: false));
				SourceImage.ImageOpened += SourceImage_ImageOpened;
				SourceImage.ImageFailed += SourceImage_ImageFailed;
				LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this, ResContainer.IDS_CHATON_POP_DOWNLOADING_ING);
				LayoutRoot.Children.Add(value);
			}
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void SourceImage_ImageFailed(object sender, ExceptionRoutedEventArgs e)
	{
		_ = e.ErrorException;
	}

	private void SourceImage_ImageOpened(object sender, RoutedEventArgs e)
	{
		BitmapImage bitmapImage = (sender as Image).Source as BitmapImage;
		Utility.SaveToJpeg(_filePath, bitmapImage, bitmapImage.PixelWidth, bitmapImage.PixelHeight);
		LoadingIndicator.StopLoading();
	}

	private void Save_Click(object sender, EventArgs e)
	{
		Utility.SaveImageToMediaLibrary(_filePath);
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void Close_Click(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/ImageViewerPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			SourceImage = (Image)((FrameworkElement)this).FindName("SourceImage");
		}
	}
}
