using System.Net;
using System.Windows;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class AddTextProfileInfoPageViewModel : NotificationObject
{
	private AddTextProfileInfoPage _page;

	private SSMService _ssmService;

	private string _inputText;

	private string _param;

	public string Param
	{
		get
		{
			return _param;
		}
		set
		{
			_param = value;
			UserProfile userProfile = RegistrationService.GetUserProfile();
			if (_param == "status")
			{
				InputText = userProfile.Status;
				_page.ApplicationTitle.Text = ResContainer.IDS_CHATON_BODY_EDIT_STATUS_MESSAGE.ToUpper();
				_page.InputBox.MaxLength = 40;
			}
			else if (_param == "name")
			{
				InputText = userProfile.Name;
				_page.ApplicationTitle.Text = ResContainer.IDS_CHATON_BODY_EDIT_NAME.ToUpper();
				_page.InputBox.MaxLength = 30;
			}
			_page.InputBox.SelectionStart = _page.InputBox.Text.Length;
		}
	}

	public string InputText
	{
		get
		{
			return _inputText;
		}
		set
		{
			_inputText = value;
			NotifyPropertyChanged(() => InputText);
		}
	}

	public AddTextProfileInfoPageViewModel(AddTextProfileInfoPage page)
	{
		_page = page;
		_ssmService = new SSMService();
		_ssmService.UpdateUserProfileCompleted += _ssmService_UpdateUserProfileCompleted;
	}

	private void _ssmService_UpdateUserProfileCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			UserProfile userProfile = RegistrationService.GetUserProfile();
			if (_param == "status")
			{
				userProfile.Status = _inputText;
			}
			else if (_param == "name")
			{
				userProfile.Name = _inputText;
			}
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
		else if (e.ErrorMessage.Contains("CCS-41900"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NO_RESPONSE_FROM_SERVER);
		}
		else
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
	}

	internal void Save()
	{
		UserProfile userProfile = RegistrationService.GetUserProfile();
		if (_param == "status")
		{
			if (userProfile.Status == _inputText)
			{
				Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
				return;
			}
			LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
			_page.LayoutRoot.Children.Add(value);
			_ssmService.UpdateUserProfileAsync(SSMService.MakeProfileParam(_param, _inputText));
		}
		else if (_param == "name")
		{
			if (userProfile.Name == _inputText)
			{
				Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
				return;
			}
			LoadingIndicator value2 = new LoadingIndicator((PhoneApplicationPage)(object)_page);
			_page.LayoutRoot.Children.Add(value2);
			_ssmService.UpdateUserProfileAsync(SSMService.MakeProfileParam(_param, _inputText));
		}
	}
}
