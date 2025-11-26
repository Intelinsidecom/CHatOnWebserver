using System;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using System.Xml.Linq;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Core;
using Windows.UI.Xaml;

namespace ChatOn.ViewModels;

public class EditProfilePageViewModel : NotificationObject
{
	private EditProfilePage _page;

	private UserProfile _myProfile;

	private SSMService _ssmService;

	private string _phoneNumber;

	private bool _isShowPhoneNumber;

	private bool _processBirthDay;

	public bool IsShowPhoneNumber
	{
		get
		{
			return _isShowPhoneNumber;
		}
		set
		{
			_isShowPhoneNumber = value;
			NotifyPropertyChanged(() => IsShowPhoneNumber);
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

	public string PhoneNumber
	{
		get
		{
			return _phoneNumber;
		}
		set
		{
			_phoneNumber = value;
			NotifyPropertyChanged(() => PhoneNumber);
		}
	}

	public bool IsTogglePhoneNumberActive
	{
		get
		{
			UserProfile userProfile = RegistrationService.GetUserProfile();
			if (string.IsNullOrEmpty(userProfile.PhoneNumber))
			{
				return false;
			}
			return true;
		}
	}

	public bool IsEnableBirthDay => MyProfile.BirthdayDisplayType != 2;

	public EditProfilePageViewModel(EditProfilePage page)
	{
		_page = page;
		MyProfile = RegistrationService.GetUserProfile();
		PhoneNumber = MyProfile.PhoneNumber;
		_ssmService = new SSMService();
		_ssmService.UpdateUserProfileCompleted += _ssmService_UpdateUserProfileCompleted;
		_ssmService.GetUserPrivacyCompleted += _ssmService_GetUserPrivacyCompleted;
		_ssmService.SetUserPrivacyCompleted += _ssmService_SetUserPrivacyCompleted;
		TaskFactory factory = Task.Factory;
		Action action = delegate
		{
			_ssmService.GetUserPrivacyAsync();
		};
		factory.StartNew(action);
	}

	private async void _ssmService_SetUserPrivacyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode != HttpStatusCode.OK)
		{
			await SSMService.ShowCommonErrorMessage(e);
		}
	}

	private void _ssmService_GetUserPrivacyCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			if (e.StatusCode != HttpStatusCode.OK || e.Xml == null)
			{
				await SSMService.ShowCommonErrorMessage(e);
			}
			else
			{
				XElement xElement = e.Xml.Element("value");
				bool isShowPhoneNumber = bool.Parse(xElement.Value);
				IsShowPhoneNumber = isShowPhoneNumber;
				NotifyPropertyChanged(() => IsShowPhoneNumber);
			}
		});
	}

	internal async void Save(string name, string status, DateTime birthday, int bitrhdayParam, bool showYear)
	{
		if (string.IsNullOrEmpty(name.Trim()))
		{
			return;
		}
		if (Utility.IsEmojiIconIncluded(name) || Utility.IsEmojiIconIncluded(status))
		{
			await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("WP7_FST_EMOJI_NOT_SUPPORTED"), showCancel: false);
			return;
		}
		if (status == Utility.GetResourceString("IDS_CHATON_BODY_ENTER_STATUS_MESSAGE"))
		{
			status = string.Empty;
		}
		_page.ShowLoading();
		_myProfile.Name = name;
		_myProfile.Status = status;
		_myProfile.BirthdayDisplayType = bitrhdayParam;
		_myProfile.Birthday = birthday;
		_myProfile.ShowYear = showYear;
		_ssmService.UpdateUserProfileAsync(SSMService.MakeAllUserProfileParam(name, status, birthday, bitrhdayParam));
	}

	private async void _ssmService_UpdateUserProfileCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			ChatOnService.Instance.IsProfileUpdated = true;
			RegistrationService.SaveUserProfile(_myProfile);
			BuddySummary item = PivotPage.ActiveInstance.ViewModel.BuddyItems.FirstOrDefault((BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber.Equals(RegistrationService.ChatOnID));
			BuddySummary item2 = PivotPage.ActiveInstance.ViewModel.ShowingItems.FirstOrDefault((BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber.Equals(RegistrationService.ChatOnID));
			PivotPage.ActiveInstance.ViewModel.BuddyItems.Remove(item);
			PivotPage.ActiveInstance.ViewModel.ShowingItems.Remove(item2);
			PivotPage.ActiveInstance.ViewModel.UpdateList();
			PivotPage.ActiveInstance.ViewModel.MyProfile.CopyFromDownloaded(_myProfile);
			NotifyPropertyChanged(() => PivotPage.ActiveInstance.ViewModel.MyProfile);
			if (_page.IsToggleShowPhonenumberOn != _isShowPhoneNumber)
			{
				_ssmService.SetUserPrivacyAsync(_page.IsToggleShowPhonenumberOn);
			}
			else if (_processBirthDay)
			{
				_processBirthDay = false;
			}
		}
		else
		{
			await SSMService.ShowCommonErrorMessage(e);
		}
	}

	internal void SaveShowBirthday(bool isShow)
	{
		_page.ShowLoading();
		_myProfile = RegistrationService.GetUserProfile();
		if (isShow)
		{
			if (_myProfile.ShowYear)
			{
				_myProfile.BirthdayDisplayType = 0;
			}
			else
			{
				_myProfile.BirthdayDisplayType = 1;
			}
		}
		else
		{
			_myProfile.BirthdayDisplayType = 2;
		}
		_ssmService.UpdateUserProfileAsync(SSMService.MakeBirthdayParam(_myProfile.Birthday, _myProfile.BirthdayDisplayType));
		_processBirthDay = true;
		NotifyPropertyChanged("");
	}
}
