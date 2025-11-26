using System.Windows;
using ChatOn.Infrastructure;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.ViewModels;

public class ShareDetailPageViewModel : NotificationObject
{
	private ShareDetailPage _page;

	private string _site = string.Empty;

	public ShareDetailPageViewModel(PhoneApplicationPage page)
	{
		_page = page as ShareDetailPage;
	}

	public void UploadPhoto(string postText)
	{
		//IL_005d: Unknown result type (might be due to invalid IL or missing references)
		StartUploading();
		MobileBlogService.Instance.UploadPhotoCompleted += _mbService_UploadPhotoCompleted;
		MobileBlogService.Instance.UploadPhoto(_site.ToLower(), postText, ChatOnService.Instance.FileNameToShare, null);
		foreach (object button in ((PhoneApplicationPage)_page).ApplicationBar.Buttons)
		{
			((ApplicationBarIconButton)button).IsEnabled = false;
		}
	}

	private void _mbService_UploadPhotoCompleted(bool fSuccess)
	{
		MobileBlogService.Instance.UploadPhotoCompleted -= _mbService_UploadPhotoCompleted;
		if (fSuccess)
		{
			((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
			{
				StopUploading();
				MessageBox.Show(ResContainer.WP7_CHATON_UPLOADINGCOMPLETED);
				Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
			});
		}
		else
		{
			((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
			{
				StopUploading();
				MessageBox.Show(ResContainer.IDS_CHATON_POP_UPLOADING_FAILED);
				Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
			});
		}
	}

	public void OnNavigatedTo()
	{
		if (string.IsNullOrEmpty(_site))
		{
			_site = "facebook";
		}
	}

	private void StartUploading()
	{
		_page.UploadingBgRect.Visibility = Visibility.Visible;
		_page.UploadingProgress.Visibility = Visibility.Visible;
	}

	private void StopUploading()
	{
		_page.UploadingBgRect.Visibility = Visibility.Collapsed;
		_page.UploadingProgress.Visibility = Visibility.Collapsed;
	}
}
