using System;
using System.Collections.Generic;
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

public class PrivacyPageViewModel : NotificationObject
{
	private PrivacyPage _page;

	private SSMService _ssmService;

	private DataService _dataService;

	private BuddyService _buddyService;

	private bool _isShowPhonenumber;

	private Visibility _isShowAddBirthDay;

	private Buddy _buddyToShow;

	private List<string> _blindList;

	private UserProfile _myProfile;

	private bool _uploadSetting = true;

	private int _selectedType;

	protected Visibility IsShowAddBirthDay
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _isShowAddBirthDay;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_isShowAddBirthDay = value;
			NotifyPropertyChanged(() => IsShowAddBirthDay);
		}
	}

	public UserProfile MyProfile
	{
		get
		{
			if (_myProfile == null)
			{
				return RegistrationService.GetUserProfile();
			}
			return _myProfile;
		}
		set
		{
			_myProfile = value;
			NotifyPropertyChanged(() => MyProfile);
		}
	}

	public int SelectedType
	{
		get
		{
			return _selectedType;
		}
		set
		{
			_selectedType = value;
			NotifyPropertyChanged(() => SelectedType);
			if (_uploadSetting)
			{
				UploadProfileOption();
			}
			_uploadSetting = true;
			_page.ToggleProfileImageDesc(_selectedType);
		}
	}

	public PrivacyPageViewModel(PrivacyPage page)
	{
		_page = page;
		_ssmService = new SSMService();
		_ssmService.GetUserPrivacyCompleted += _ssmService_GetUserPrivacyCompleted;
		_ssmService.SetUserPrivacyCompleted += _ssmService_SetUserPrivacyCompleted;
		_ssmService.UploadBlindListCompleted += _ssmService_UploadBlindListCompleted;
		_ssmService.GetBlindListAsync();
		_ssmService.UpdateUserProfileCompleted += _ssmService_UpdateUserProfileCompleted;
		_ssmService.GetBlindListCompleted += _ssmService_GetBlindListCompleted;
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_ = from d in _dataService.BuddyItems
			where d.IsHideInteraction
			orderby d.Name
			select d;
		MyProfile = RegistrationService.GetUserProfile();
		LoadBirthdayVisibility();
	}

	private void _ssmService_UploadBlindListCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode != HttpStatusCode.OK)
		{
			SSMService.ShowCommonErrorMessage(e);
		}
	}

	private void LoadBirthdayVisibility()
	{
		IsShowAddBirthDay = (Visibility)1;
	}

	public void UpdateUserPrivacy()
	{
		_page.ShowLoading();
		Task.Factory.StartNew(delegate
		{
			if (!string.IsNullOrEmpty(RegistrationService.GetUserNumber()))
			{
				_ssmService.GetUserPrivacyAsync("phonenumber|emailsamsung|showprofileimage");
			}
			else
			{
				_ssmService.GetUserPrivacyAsync("emailsamsung|showprofileimage");
			}
		});
	}

	private void _ssmService_UpdateUserProfileCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			ChatOnService.Instance.IsProfileUpdated = true;
			RegistrationService.SaveUserProfile(_myProfile);
		}
		else
		{
			_page.OnUpdateBirthdayFailed();
			SSMService.ShowCommonErrorMessage(e);
		}
	}

	internal void Save(bool ShowBirthday, DateTime birthday, int bitrhdayParam, bool ShowYear)
	{
		MyProfile.Birthday = birthday;
		MyProfile.ShowYear = ShowYear;
		if (ShowBirthday)
		{
			_page.ShowLoading();
			MyProfile.BirthdayDisplayType = bitrhdayParam;
			_ssmService.UpdateUserProfileAsync(SSMService.MakeBirthdayParam(birthday, bitrhdayParam));
		}
		else
		{
			RegistrationService.SaveUserProfile(_myProfile);
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
	}

	private void _ssmService_GetBlindListCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if ((e.Error != null && e.StatusCode != HttpStatusCode.NoContent) || e.Xml == null)
		{
			SSMService.ShowCommonErrorMessage(e);
		}
		else
		{
			_blindList = _buddyService.ParseBlindListFromXml(e.Xml);
		}
	}

	private void _ssmService_SetUserPrivacyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode != HttpStatusCode.OK)
		{
			_isShowPhonenumber = !_isShowPhonenumber;
			_page.ToggleShowPhoneNumber(_isShowPhonenumber);
		}
	}

	private void _ssmService_GetUserPrivacyCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		LoadingIndicator.StopLoading();
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			if (e.StatusCode == HttpStatusCode.OK && e.Xml != null)
			{
				IEnumerable<XElement> enumerable = from item in e.Xml.Descendants("privacy")
					select (item);
				{
					foreach (XElement item in enumerable)
					{
						if (item.Attribute("name").Value == "phonenumber")
						{
							bool isOn = bool.Parse(item.Attribute("value").Value);
							_page.ToggleShowPhoneNumber(isOn);
						}
						else if (item.Attribute("name").Value == "emailsamsung")
						{
							bool samsungaccountOption = bool.Parse(item.Attribute("value").Value);
							ToggleSamsungAccountOption(samsungaccountOption);
						}
						else if (item.Attribute("name").Value == "showprofileimage")
						{
							bool flag = bool.Parse(item.Attribute("value").Value);
							_uploadSetting = false;
							SelectedType = (flag ? 1 : 0);
						}
					}
					return;
				}
			}
			SSMService.ShowCommonErrorMessage(e);
			_page.DisableToggleShowPhonenumberControl();
		});
	}

	internal void OnToggleShowPhonenumber(bool isOn)
	{
		if (_isShowPhonenumber != isOn)
		{
			_isShowPhonenumber = isOn;
			_ssmService.SetUserPrivacyAsync(isOn);
		}
	}

	internal void ToggleSamsungAccountOption(bool SamsungaccountOption)
	{
		_page.ToggleTextShowOption(SamsungaccountOption);
		_ssmService.SetUserPrivacyCompleted += delegate(object s2, SSMCompletedEventArgs e2)
		{
			LoadingIndicator.StopLoading();
			if (e2.StatusCode != HttpStatusCode.OK)
			{
				_page.ToggleTextShowOption(SamsungaccountOption);
				SSMService.ShowCommonErrorMessage(e2);
			}
		};
		_ssmService.SetUserPrivacyAsync(SamsungaccountOption, "emailsamsung");
	}

	private void UploadProfileOption()
	{
		_page.ShowLoading();
		SSMService sSMService = new SSMService();
		sSMService.SetUserPrivacyCompleted += delegate(object s2, SSMCompletedEventArgs e2)
		{
			LoadingIndicator.StopLoading();
			if (e2.StatusCode != HttpStatusCode.OK)
			{
				_uploadSetting = false;
				SelectedType = ((_selectedType == 0) ? 1 : 0);
				SSMService.ShowCommonErrorMessage(e2);
			}
		};
		sSMService.SetUserPrivacyAsync((_selectedType != 0) ? true : false, "showprofileimage");
	}

	internal void OnToggleBuddySay(bool isToogle)
	{
		LoadingIndicator.StopLoading();
		if (!isToogle)
		{
			IEnumerable<string> phoneNumbers = _dataService.BuddyItems.Select((Buddy x) => x.PhoneNumber);
			string xmlString = SSMService.MakeBlindListParam(phoneNumbers, isBlind: true);
			_ssmService.UploadBlindListAsync(xmlString);
			SSMService.SaveBuddySayBlindSetting(isBlind: false);
		}
		else
		{
			IEnumerable<string> phoneNumbers2 = _dataService.BuddyItems.Select((Buddy x) => x.PhoneNumber);
			string xmlString2 = SSMService.MakeBlindListParam(phoneNumbers2, isBlind: false);
			_ssmService.UploadBlindListAsync(xmlString2);
			SSMService.SaveBuddySayBlindSetting(isBlind: true);
		}
	}
}
