using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace ChatON_WoA.ViewModels;

internal class SyncIntroPageViewModel : NotificationObject
{
	private SyncIntroPage _page;

	private int _currentIndex;

	public Visibility btnSigninVisibility { get; set; }

	public Visibility btnNextVisibility { get; set; }

	public int CurrentIndex
	{
		get
		{
			return _currentIndex;
		}
		set
		{
			_currentIndex = value;
			NotifyPropertyChanged(() => CurrentIndex);
		}
	}

	public SyncIntroPageViewModel(SyncIntroPage page)
	{
		_page = page;
		btnSigninVisibility = (Visibility)0;
		btnNextVisibility = (Visibility)1;
	}

	public void ChangeSyncIntroImage(bool bNext)
	{
		if (bNext)
		{
			CurrentIndex++;
			if (CurrentIndex > 1)
			{
				CurrentIndex = 0;
			}
		}
		else
		{
			CurrentIndex--;
			if (CurrentIndex < 0)
			{
				CurrentIndex = 1;
			}
		}
	}

	public void SkipSyncSamsungAccount()
	{
		if (string.IsNullOrEmpty(RegistrationService.ChatOnID))
		{
			PageNavigationService.OpenSelectLanguagePage((Page)(object)_page);
		}
		else
		{
			Utility.SafetyGoBack((Page)(object)_page);
		}
	}

	public void CheckStatusSignin()
	{
		if (SettingService.GetSignedOnSamsungAccount())
		{
			btnSigninVisibility = (Visibility)1;
			btnNextVisibility = (Visibility)0;
			NotifyPropertyChanged("");
		}
		else
		{
			btnSigninVisibility = (Visibility)0;
			btnNextVisibility = (Visibility)1;
			NotifyPropertyChanged("");
		}
	}
}
