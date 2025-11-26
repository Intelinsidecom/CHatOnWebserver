using System;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Media;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class AddBirthdayPageViewModel : NotificationObject
{
	private AddBirthdayPage _page;

	private DateTime _birthday;

	private DateTime _orgBirthday;

	private SSMService _ssmService;

	private int _selectedType;

	public int SelectedType
	{
		get
		{
			return _selectedType;
		}
		set
		{
			_selectedType = value;
			if (_selectedType == 2)
			{
				_page.DatePickerControl.Visibility = Visibility.Collapsed;
				_page.DateBlock.Foreground = new SolidColorBrush(Colors.Gray);
			}
			else
			{
				_page.DatePickerControl.Visibility = Visibility.Visible;
				_page.DateBlock.Foreground = new SolidColorBrush(Colors.Black);
			}
			if (_selectedType == 0)
			{
				_page.DateBlock.SetBinding(TextBlock.TextProperty, new Binding
				{
					Source = this,
					Path = new PropertyPath("Birthday"),
					Converter = new DateTimeStringConverter(),
					ConverterParameter = "d"
				});
			}
			else if (_selectedType == 1)
			{
				_page.DateBlock.SetBinding(TextBlock.TextProperty, new Binding
				{
					Source = this,
					Path = new PropertyPath("Birthday"),
					Converter = new DateTimeStringConverter(),
					ConverterParameter = "m"
				});
			}
		}
	}

	public DateTime Birthday
	{
		get
		{
			return _birthday;
		}
		set
		{
			_birthday = value;
			NotifyPropertyChanged(() => Birthday);
		}
	}

	public AddBirthdayPageViewModel(AddBirthdayPage page)
	{
		_page = page;
		SelectedType = 0;
		UserProfile userProfile = RegistrationService.GetUserProfile();
		if (userProfile != null)
		{
			_ = userProfile.Birthday;
			if (userProfile.Birthday.Ticks != 0)
			{
				_orgBirthday = userProfile.Birthday;
			}
			else
			{
				_orgBirthday = DateTime.Now;
			}
			Birthday = _orgBirthday;
			_page.DatePickerControl.Value = _birthday;
			SelectedType = userProfile.BirthdayDisplayType;
		}
		_ssmService = new SSMService();
		_ssmService.UpdateUserProfileCompleted += _ssmService_UpdateUserProfileCompleted;
	}

	private void _ssmService_UpdateUserProfileCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			UserProfile userProfile = RegistrationService.GetUserProfile();
			userProfile.BirthdayDisplayType = _selectedType;
			userProfile.Birthday = _birthday;
			RegistrationService.SaveUserProfile(userProfile);
			Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
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

	internal void Save()
	{
		UserProfile userProfile = RegistrationService.GetUserProfile();
		if (_birthday == _orgBirthday && userProfile.BirthdayDisplayType == _selectedType)
		{
			Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
			return;
		}
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
		_ssmService.UpdateUserProfileAsync(SSMService.MakeBirthdayParam(_birthday, _selectedType));
	}
}
