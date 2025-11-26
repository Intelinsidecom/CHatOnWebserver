using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.CompilerServices;
using System.Windows;
using System.Windows.Media.Imaging;
using System.Windows.Threading;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Tasks;

namespace ChatOn.ViewModels;

public class ProfileEditPageViewModel : NotificationObject
{
	[CompilerGenerated]
	private sealed class _003CLoadData_003Ed__1
	{
		private int _003C_003E1__state;

		private bool _0024__disposing;

		public AsyncVoidMethodBuilder _0024builder;

		public Action _003C_003Et__MoveNextDelegate;

		public ProfileEditPageViewModel _003C_003E4__this;

		public SiteData _003Csite_003E5__2;

		private TaskAwaiter<bool> _003Ca1_003Et___0024await4;

		public void MoveNext()
		{
			try
			{
				bool flag = true;
				int num = _003C_003E1__state;
				if (num != 1)
				{
					if (_003C_003E1__state == -1)
					{
						return;
					}
					_003C_003E4__this.MyProfile = RegistrationService.GetUserProfile();
					List<SiteData>.Enumerator enumerator = MobileBlogService.Instance.SupportedSites.GetEnumerator();
					try
					{
						while (enumerator.MoveNext())
						{
							_003Csite_003E5__2 = enumerator.Current;
							if (_003Csite_003E5__2.ID.Contains("facebook"))
							{
								_003C_003E4__this._site = _003Csite_003E5__2;
								break;
							}
						}
					}
					finally
					{
						if (flag)
						{
							((IDisposable)enumerator/*cast due to .constrained prefix*/).Dispose();
						}
					}
					_003Ca1_003Et___0024await4 = MobileBlogService.Instance.CheckLogin(_003C_003E4__this._site.ID).GetAwaiter();
					if (!_003Ca1_003Et___0024await4.IsCompleted)
					{
						_003C_003E1__state = 1;
						flag = false;
						_003Ca1_003Et___0024await4.OnCompleted(_003C_003Et__MoveNextDelegate);
						return;
					}
				}
				else
				{
					_003C_003E1__state = 0;
				}
				bool result = _003Ca1_003Et___0024await4.GetResult();
				_003Ca1_003Et___0024await4 = default(TaskAwaiter<bool>);
				_003C_003E4__this._hasLoggedIn = result;
				if (_003C_003E4__this._hasLoggedIn)
				{
					_003C_003E4__this.FacebookAccount = ResContainer.WP7_CHATON_LOGGEDIN;
				}
				else
				{
					_003C_003E4__this.FacebookAccount = ResContainer.IDS_CHATON_BODY_SIGN_IN;
				}
			}
			catch (Exception exception)
			{
				_003C_003E1__state = -1;
				AsyncVoidMethodBuilder asyncVoidMethodBuilder = _0024builder;
				asyncVoidMethodBuilder.SetException(exception);
				return;
			}
			_003C_003E1__state = -1;
			AsyncVoidMethodBuilder asyncVoidMethodBuilder2 = _0024builder;
			asyncVoidMethodBuilder2.SetResult();
		}

		[DebuggerHidden]
		public void Dispose()
		{
			_0024__disposing = true;
			MoveNext();
			_003C_003E1__state = -1;
		}

		[DebuggerHidden]
		public _003CLoadData_003Ed__1(int _003C_003E1__state)
		{
			this._003C_003E1__state = _003C_003E1__state;
		}
	}

	private ProfileEditPage _page;

	private UserProfile _myProfile;

	private BitmapImage _profileImage;

	private PhotoChooserTask _photoChooser;

	private WriteableBitmap _tempProfileBitmap;

	private string _facebookAccount;

	private SiteData _site;

	private bool _hasLoggedIn;

	private bool _isFacebookSupported;

	public bool IsFacebookSupported
	{
		get
		{
			return _isFacebookSupported;
		}
		set
		{
			_isFacebookSupported = value;
			NotifyPropertyChanged(() => IsFacebookSupported);
		}
	}

	public BitmapImage ProfileImage
	{
		get
		{
			if (_profileImage == null)
			{
				if (Utility.IsDarkTheme())
				{
					return new BitmapImage(new Uri("/ChatOn;component/Images/my page_default image.png", UriKind.Relative));
				}
				return new BitmapImage(new Uri("/ChatOn;component/Images/LightTheme/my page_default image.png", UriKind.Relative));
			}
			return _profileImage;
		}
		set
		{
			_profileImage = value;
			NotifyPropertyChanged(() => ProfileImage);
		}
	}

	public UserProfile MyProfile
	{
		get
		{
			return _myProfile;
		}
		set
		{
			_myProfile = value;
			NotifyPropertyChanged(() => MyProfile);
		}
	}

	public string FacebookAccount
	{
		get
		{
			return _facebookAccount;
		}
		set
		{
			_facebookAccount = value;
			NotifyPropertyChanged(() => FacebookAccount);
		}
	}

	public ProfileEditPageViewModel(ProfileEditPage page)
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Expected O, but got Unknown
		_page = page;
		_photoChooser = new PhotoChooserTask();
		((ChooserBase<PhotoResult>)(object)_photoChooser).Completed += _photoChooser_Completed;
		if (ChatOnService.Instance.ProfileImage != null)
		{
			_profileImage = ChatOnService.Instance.ProfileImage;
		}
		IsFacebookSupported = true;
	}

	private void _photoChooser_Completed(object sender, PhotoResult e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Invalid comparison between Unknown and I4
		if ((int)((TaskEventArgs)e).TaskResult == 1)
		{
			((UIElement)(object)_page).Visibility = Visibility.Collapsed;
			ChatOnService.Instance.StreamToCrop = e.ChosenPhoto;
			((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
			{
				ImageCropPage.CropCompleted += ImageCropPage_CropCompleted;
				PageNavigationService.OpenImageCropPage((PhoneApplicationPage)(object)_page, 200, 200);
				DispatcherTimer dispatcherTimer = new DispatcherTimer();
				dispatcherTimer.Interval = TimeSpan.FromMilliseconds(200.0);
				dispatcherTimer.Tick += visibilityTimer_Tick;
				dispatcherTimer.Start();
			});
		}
	}

	private void visibilityTimer_Tick(object sender, EventArgs e)
	{
		((UIElement)(object)_page).Visibility = Visibility.Visible;
		(sender as DispatcherTimer).Stop();
	}

	private void ImageCropPage_CropCompleted(object sender, object arg)
	{
		_tempProfileBitmap = arg as WriteableBitmap;
		SSMService sSMService = new SSMService();
		sSMService.UploadProfileImageCompleted += ssmService_UploadProfileImageCompleted;
		sSMService.UploadProfileImageAsync(_tempProfileBitmap);
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
	}

	private void ssmService_UploadProfileImageCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error == null)
		{
			MyProfile.ProfileImagePath = RegistrationService.DefaultProfilePath;
			RegistrationService.SaveUserProfile(MyProfile);
			Utility.SaveToJpeg(MyProfile.ProfileImagePath, _tempProfileBitmap, _tempProfileBitmap.PixelWidth, _tempProfileBitmap.PixelHeight);
			ProfileImage = Utility.LoadJpeg(MyProfile.ProfileImagePath);
			ChatOnService.Instance.ProfileImage = ProfileImage;
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

	internal void LoadData()
	{
		_003CLoadData_003Ed__1 CS_0024_003C_003E8__locals28 = new _003CLoadData_003Ed__1(0);
		CS_0024_003C_003E8__locals28._003C_003E4__this = this;
		CS_0024_003C_003E8__locals28._003C_003Et__MoveNextDelegate = delegate
		{
			try
			{
				bool flag = true;
				int num = CS_0024_003C_003E8__locals28._003C_003E1__state;
				if (num != 1)
				{
					if (CS_0024_003C_003E8__locals28._003C_003E1__state == -1)
					{
						return;
					}
					CS_0024_003C_003E8__locals28._003C_003E4__this.MyProfile = RegistrationService.GetUserProfile();
					List<SiteData>.Enumerator enumerator = MobileBlogService.Instance.SupportedSites.GetEnumerator();
					try
					{
						while (enumerator.MoveNext())
						{
							CS_0024_003C_003E8__locals28._003Csite_003E5__2 = enumerator.Current;
							if (CS_0024_003C_003E8__locals28._003Csite_003E5__2.ID.Contains("facebook"))
							{
								CS_0024_003C_003E8__locals28._003C_003E4__this._site = CS_0024_003C_003E8__locals28._003Csite_003E5__2;
								break;
							}
						}
					}
					finally
					{
						if (flag)
						{
							((IDisposable)enumerator/*cast due to .constrained prefix*/).Dispose();
						}
					}
					CS_0024_003C_003E8__locals28._003Ca1_003Et___0024await4 = MobileBlogService.Instance.CheckLogin(CS_0024_003C_003E8__locals28._003C_003E4__this._site.ID).GetAwaiter();
					if (!CS_0024_003C_003E8__locals28._003Ca1_003Et___0024await4.IsCompleted)
					{
						CS_0024_003C_003E8__locals28._003C_003E1__state = 1;
						flag = false;
						CS_0024_003C_003E8__locals28._003Ca1_003Et___0024await4.OnCompleted(CS_0024_003C_003E8__locals28._003C_003Et__MoveNextDelegate);
						return;
					}
				}
				else
				{
					CS_0024_003C_003E8__locals28._003C_003E1__state = 0;
				}
				bool result = CS_0024_003C_003E8__locals28._003Ca1_003Et___0024await4.GetResult();
				CS_0024_003C_003E8__locals28._003Ca1_003Et___0024await4 = default(TaskAwaiter<bool>);
				CS_0024_003C_003E8__locals28._003C_003E4__this._hasLoggedIn = result;
				if (CS_0024_003C_003E8__locals28._003C_003E4__this._hasLoggedIn)
				{
					CS_0024_003C_003E8__locals28._003C_003E4__this.FacebookAccount = ResContainer.WP7_CHATON_LOGGEDIN;
				}
				else
				{
					CS_0024_003C_003E8__locals28._003C_003E4__this.FacebookAccount = ResContainer.IDS_CHATON_BODY_SIGN_IN;
				}
			}
			catch (Exception exception)
			{
				CS_0024_003C_003E8__locals28._003C_003E1__state = -1;
				AsyncVoidMethodBuilder asyncVoidMethodBuilder = CS_0024_003C_003E8__locals28._0024builder;
				asyncVoidMethodBuilder.SetException(exception);
				return;
			}
			CS_0024_003C_003E8__locals28._003C_003E1__state = -1;
			AsyncVoidMethodBuilder asyncVoidMethodBuilder2 = CS_0024_003C_003E8__locals28._0024builder;
			asyncVoidMethodBuilder2.SetResult();
		};
		CS_0024_003C_003E8__locals28._0024builder = AsyncVoidMethodBuilder.Create();
		CS_0024_003C_003E8__locals28.MoveNext();
	}

	internal void OpenPhotoChooser()
	{
		_photoChooser.ShowCamera = true;
		((ChooserBase<PhotoResult>)(object)_photoChooser).Show();
	}

	internal void OnClickFacebookAccount()
	{
		if (_hasLoggedIn)
		{
			PageNavigationService.OpenSNSAccountPage(_site.ID, (PhoneApplicationPage)(object)_page);
		}
		else
		{
			PageNavigationService.OpenLoginOauthPage(_site.ID, 1, (PhoneApplicationPage)(object)_page);
		}
	}
}
