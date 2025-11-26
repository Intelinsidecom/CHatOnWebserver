using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using ChatOn.Infrastructure;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class InvitationPage : PhoneApplicationPage
{
	private string _siteName;

	private string _postText;

	private PageOpenModes.LoginMode _mode;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal Image ImageCard1;

	internal Button BtnCard1;

	internal Image ImageCard2;

	internal Button BtnCard2;

	internal Image ImageCard3;

	internal Button BtnCard3;

	private bool _contentLoaded;

	public InvitationPage()
	{
		InitializeComponent();
		BtnCard1.Tag = ImageCard1;
		BtnCard2.Tag = ImageCard2;
		BtnCard3.Tag = ImageCard3;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
		if (queryString.ContainsKey("SITE"))
		{
			_siteName = queryString["SITE"];
		}
		if (queryString.ContainsKey("MODE"))
		{
			_mode = (PageOpenModes.LoginMode)int.Parse(queryString["MODE"]);
			switch (_mode)
			{
			case PageOpenModes.LoginMode.INVITATION:
				ApplicationTitle.Text = ResContainer.IDS_CHATON_BUTTON_INVITATION_CARD.ToUpper();
				_postText = ResContainer.IDS_CHATON_BUTTON_INVITATION_CARD + " www.chaton.com\n\n" + ResContainer.IDS_CHATON_BODY_THE_CHATON_LOGO_IS_DIFFERENT_FOR_CANADA;
				break;
			case PageOpenModes.LoginMode.TELLFRIENDS:
				if (((Page)this).NavigationService.BackStack.First().Source.OriginalString.Contains("LoginOauthPage"))
				{
					((Page)this).NavigationService.RemoveBackEntry();
				}
				ApplicationTitle.Text = ResContainer.IDS_CHATON_BODY_TELL_FRIENDS.ToUpper();
				_postText = ResContainer.IDS_CHATON_POP_HI_LETS_KEEP_IN_TOUCH_USING_CHATON_SEE_YOU_THERE_MSG;
				_postText = _postText.Replace("\\n", "\n");
				break;
			}
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void PostButton_Click(object sender, RoutedEventArgs e)
	{
		Image image = (sender as Button).Tag as Image;
		WriteableBitmap writeableBitmap = new WriteableBitmap(image, null);
		MemoryStream memoryStream = new MemoryStream();
		Extensions.SaveJpeg(writeableBitmap, (Stream)memoryStream, (int)image.ActualWidth, (int)image.ActualHeight, 0, 100);
		memoryStream.Seek(0L, SeekOrigin.Begin);
		byte[] array = new byte[memoryStream.Length];
		memoryStream.Read(array, 0, array.Length);
		memoryStream.Close();
		MobileBlogService.Instance.UploadPhotoCompleted += _mbService_UploadPhotoCompleted;
		MobileBlogService.Instance.UploadPhoto(_siteName.ToLower(), _postText, null, array);
		Utility.ShowSystemTrayProgress((PhoneApplicationPage)(object)this, ResContainer.IDS_CHATON_POP_UPLOADING_ING);
	}

	private void _mbService_UploadPhotoCompleted(bool fSuccess)
	{
		MobileBlogService.Instance.UploadPhotoCompleted -= _mbService_UploadPhotoCompleted;
		((DependencyObject)this).Dispatcher.BeginInvoke(delegate
		{
			Utility.ShowSystemTrayProgress((PhoneApplicationPage)(object)this, "");
			if (fSuccess)
			{
				MessageBox.Show(ResContainer.WP7_CHATON_UPLOADINGCOMPLETED, _siteName, MessageBoxButton.OK);
				((Page)this).NavigationService.RemoveBackEntry();
				Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
			}
			else
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_UPLOADING_FAILED, _siteName, MessageBoxButton.OK);
			}
		});
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/InvitationPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			ImageCard1 = (Image)((FrameworkElement)this).FindName("ImageCard1");
			BtnCard1 = (Button)((FrameworkElement)this).FindName("BtnCard1");
			ImageCard2 = (Image)((FrameworkElement)this).FindName("ImageCard2");
			BtnCard2 = (Button)((FrameworkElement)this).FindName("BtnCard2");
			ImageCard3 = (Image)((FrameworkElement)this).FindName("ImageCard3");
			BtnCard3 = (Button)((FrameworkElement)this).FindName("BtnCard3");
		}
	}
}
