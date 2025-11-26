using System;
using System.ComponentModel;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Threading;
using ChatOn.Controls;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using Microsoft.Phone.Tasks;

namespace ChatOn.Views;

public class ProfileImageViewerPage : PhoneApplicationPage
{
	private bool _isNew = true;

	private PhotoChooserTask _photoChooser;

	private WriteableBitmap _tempProfileBitmap;

	private SSMService _ssmService;

	internal Grid LayoutRoot;

	internal Image SourceImage;

	private bool _contentLoaded;

	public ProfileImageViewerPage()
	{
		InitializeComponent();
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_OPT_EDIT;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_OPT_REMOVE;
		_ssmService = new SSMService();
		_ssmService.UploadProfileImageCompleted += _ssmService_UploadProfileImageCompleted;
		_ssmService.DeleteProfileImageCompleted += _ssmService_DeleteProfileImageCompleted;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			if (ChatOnService.Instance.ProfileImage == null)
			{
				((DependencyObject)this).Dispatcher.BeginInvoke(delegate
				{
					Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
				});
			}
			else
			{
				SourceImage.Source = ChatOnService.Instance.ProfileImage;
			}
		}
		((Page)this).OnNavigatedTo(e);
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

	private void Edit_Click(object sender, EventArgs e)
	{
		OpenPhotoChooser();
	}

	private void Remove_Click(object sender, EventArgs e)
	{
		_ssmService.DeleteUserProfileImageAsync();
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
		LayoutRoot.Children.Add(value);
	}

	public void OpenPhotoChooser()
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected O, but got Unknown
		_photoChooser = new PhotoChooserTask();
		_photoChooser.ShowCamera = true;
		((ChooserBase<PhotoResult>)(object)_photoChooser).Completed += _photoChooser_Completed;
		((ChooserBase<PhotoResult>)(object)_photoChooser).Show();
	}

	private void _photoChooser_Completed(object sender, PhotoResult e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Invalid comparison between Unknown and I4
		if ((int)((TaskEventArgs)e).TaskResult == 1)
		{
			((UIElement)this).Visibility = Visibility.Collapsed;
			((PhoneApplicationPage)this).ApplicationBar.IsVisible = false;
			ChatOnService.Instance.StreamToCrop = e.ChosenPhoto;
			((DependencyObject)this).Dispatcher.BeginInvoke(delegate
			{
				ImageCropPage.CropCompleted += ImageCropPage_CropCompleted;
				PageNavigationService.OpenImageCropPage((PhoneApplicationPage)(object)this, 200, 200);
				DispatcherTimer dispatcherTimer = new DispatcherTimer();
				dispatcherTimer.Interval = TimeSpan.FromMilliseconds(200.0);
				dispatcherTimer.Tick += visibilityTimer_Tick;
				dispatcherTimer.Start();
			});
		}
	}

	private void visibilityTimer_Tick(object sender, EventArgs e)
	{
		((UIElement)this).Visibility = Visibility.Visible;
		((PhoneApplicationPage)this).ApplicationBar.IsVisible = true;
		(sender as DispatcherTimer).Stop();
	}

	private void ImageCropPage_CropCompleted(object sender, object arg)
	{
		_tempProfileBitmap = arg as WriteableBitmap;
		_ssmService.UploadProfileImageAsync(_tempProfileBitmap);
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
		LayoutRoot.Children.Add(value);
	}

	private void _ssmService_UploadProfileImageCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error == null)
		{
			RegistrationService.SaveUserProfileImage(_tempProfileBitmap);
			ChatOnService.Instance.ProfileImage = Utility.LoadJpeg(RegistrationService.DefaultProfilePath);
			SourceImage.Source = ChatOnService.Instance.ProfileImage;
			ChatOnService.Instance.IsProfileImageUpdated = true;
		}
		else if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
	}

	private void _ssmService_DeleteProfileImageCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error == null)
		{
			RegistrationService.DeleteUserProfileImage();
			ChatOnService.Instance.ProfileImage = null;
			ChatOnService.Instance.IsProfileImageUpdated = true;
			Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
		}
		else if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/ProfileImageViewerPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			SourceImage = (Image)((FrameworkElement)this).FindName("SourceImage");
		}
	}
}
