using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class InputVerificationCodePage : PhoneApplicationPage
{
	private SSMService _ssmService;

	private bool _isACS;

	private bool _isNew = true;

	private string _language;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal StackPanel ContentPanel;

	internal TextBlock InitText;

	internal TextBlock RemarkText;

	internal Button SMSButton;

	internal Button ACSButton;

	internal TextBlock BugReportText;

	internal Button BugReportButton;

	internal TextBox SendTo;

	internal TextBox InputNum;

	private bool _contentLoaded;

	public InputVerificationCodePage()
	{
		InitializeComponent();
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).Text = ResContainer.IDS_CHATON_SK_OK;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		((ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null)).Text = ResContainer.IDS_CHATON_SK_CANCEL;
		string iDS_CHATON_POP_IF_YOU_DO_NOT_RECEIVE_SMS_IN_PD_MINUTES_RESEND_VERIFICATION_CODE = ResContainer.IDS_CHATON_POP_IF_YOU_DO_NOT_RECEIVE_SMS_IN_PD_MINUTES_RESEND_VERIFICATION_CODE;
		iDS_CHATON_POP_IF_YOU_DO_NOT_RECEIVE_SMS_IN_PD_MINUTES_RESEND_VERIFICATION_CODE = iDS_CHATON_POP_IF_YOU_DO_NOT_RECEIVE_SMS_IN_PD_MINUTES_RESEND_VERIFICATION_CODE.Replace("%d", "{0:d}");
		iDS_CHATON_POP_IF_YOU_DO_NOT_RECEIVE_SMS_IN_PD_MINUTES_RESEND_VERIFICATION_CODE = string.Format(iDS_CHATON_POP_IF_YOU_DO_NOT_RECEIVE_SMS_IN_PD_MINUTES_RESEND_VERIFICATION_CODE, 3);
		RemarkText.Text = iDS_CHATON_POP_IF_YOU_DO_NOT_RECEIVE_SMS_IN_PD_MINUTES_RESEND_VERIFICATION_CODE;
		iDS_CHATON_POP_IF_YOU_DO_NOT_RECEIVE_SMS_IN_PD_MINUTES_RESEND_VERIFICATION_CODE = ResContainer.IDS_CHATON_BODY_YOU_WILL_RECEIVE_A_PD_DIGIT_VERIFICATION_CODE_VIA_SMS_OR_VOICE_CALL_SELECT_PREFERRED_METHOD;
		iDS_CHATON_POP_IF_YOU_DO_NOT_RECEIVE_SMS_IN_PD_MINUTES_RESEND_VERIFICATION_CODE = iDS_CHATON_POP_IF_YOU_DO_NOT_RECEIVE_SMS_IN_PD_MINUTES_RESEND_VERIFICATION_CODE.Replace("%d", "4");
		InitText.Text = iDS_CHATON_POP_IF_YOU_DO_NOT_RECEIVE_SMS_IN_PD_MINUTES_RESEND_VERIFICATION_CODE;
		_ssmService = new SSMService();
		_ssmService.GetSMSTokenCompleted += _ssmService_GetSMSTokenCompleted;
		_ssmService.GetACSTokenCompleted += _ssmService_GetACSTokenCompleted;
		_ssmService.ValidateSMSAuthCompleted += _ssmService_ValidateSMSAuthCompleted;
		_ssmService.SendSMSCompleted += _ssmService_SendSMSCompleted;
		_ssmService.SendACSCompleted += _ssmService_SendACSCompleted;
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		if (userAccount.IMSI.Contains("310") || userAccount.IMSI.Contains("440"))
		{
			ACSButton.IsEnabled = true;
		}
		SendTo.Text = "+" + RegistrationService.GetUserNumber();
	}

	private void showRemarkUI()
	{
		InitText.Visibility = Visibility.Collapsed;
		RemarkText.Visibility = Visibility.Visible;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			string originalString = ((Page)this).NavigationService.BackStack.First().Source.OriginalString;
			if (originalString.Contains("SelectACSOptionPage.xaml"))
			{
				((Page)this).NavigationService.RemoveBackEntry();
			}
			_isNew = false;
			IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
			if (queryString.ContainsKey("ACS"))
			{
				_isACS = true;
				_language = queryString["ACS"];
				UserAccountInfo userAccount = RegistrationService.GetUserAccount();
				sendACS(userAccount);
				SendTo.Text = "+" + RegistrationService.GetUserNumber();
				LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
				LayoutRoot.Children.Add(value);
			}
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void _ssmService_ValidateSMSAuthCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error == null)
		{
			PageNavigationService.OpenInputNamePage((PhoneApplicationPage)(object)this);
		}
		else if (!string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_INCORRECT_VERIFICATION_CODE);
		}
		else if (e.Error != null)
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
	}

	private void _ssmService_SendSMSCompleted(object sender, SSMCompletedEventArgs e)
	{
		showRemarkUI();
		if (!string.IsNullOrEmpty(e.ErrorMessage))
		{
			if (e.ErrorMessage.Contains("CSS-12005"))
			{
				LoadingIndicator.StopLoading();
				string iDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS = ResContainer.IDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS;
				iDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS = iDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS.Replace("%d", "{0:d}");
				iDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS = string.Format(iDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS, 24);
				MessageBox.Show(iDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS);
			}
			else if (e.ErrorMessage.Contains("CSS-12002"))
			{
				_ssmService.GetSMSToken();
			}
			else if (e.ErrorMessage.Contains("11005"))
			{
				LoadingIndicator.StopLoading();
				string iDS_CHATON_POP_RETRY_IN_PD_MINUTES = ResContainer.IDS_CHATON_POP_RETRY_IN_PD_MINUTES;
				iDS_CHATON_POP_RETRY_IN_PD_MINUTES = iDS_CHATON_POP_RETRY_IN_PD_MINUTES.Replace("%d", "{0:d}");
				iDS_CHATON_POP_RETRY_IN_PD_MINUTES = string.Format(iDS_CHATON_POP_RETRY_IN_PD_MINUTES, 3);
				MessageBox.Show(iDS_CHATON_POP_RETRY_IN_PD_MINUTES);
			}
			else
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
				LoadingIndicator.StopLoading();
			}
		}
		else if (e.Error != null)
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
			LoadingIndicator.StopLoading();
		}
		else
		{
			LoadingIndicator.StopLoading();
		}
	}

	private void _ssmService_SendACSCompleted(object sender, SSMCompletedEventArgs e)
	{
		showRemarkUI();
		if (!string.IsNullOrEmpty(e.ErrorMessage))
		{
			if (e.ErrorMessage.Contains("CSS-22005"))
			{
				LoadingIndicator.StopLoading();
				string iDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS = ResContainer.IDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS;
				iDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS = iDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS.Replace("%d", "{0:d}");
				iDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS = string.Format(iDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS, 24);
				MessageBox.Show(iDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS);
			}
			else if (e.ErrorMessage.Contains("CSS-22002"))
			{
				_ssmService.GetACSToken();
			}
			else
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
				LoadingIndicator.StopLoading();
			}
		}
		else if (e.Error != null)
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
			LoadingIndicator.StopLoading();
		}
		else
		{
			LoadingIndicator.StopLoading();
		}
	}

	private void _ssmService_GetSMSTokenCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("12005"))
		{
			LoadingIndicator.StopLoading();
			string iDS_CHATON_POP_YOU_HAVE_REACHED_YOUR_DAILY_SMS_LIMIT_RETRY_IN_PD_HOURS = ResContainer.IDS_CHATON_POP_YOU_HAVE_REACHED_YOUR_DAILY_SMS_LIMIT_RETRY_IN_PD_HOURS;
			iDS_CHATON_POP_YOU_HAVE_REACHED_YOUR_DAILY_SMS_LIMIT_RETRY_IN_PD_HOURS = iDS_CHATON_POP_YOU_HAVE_REACHED_YOUR_DAILY_SMS_LIMIT_RETRY_IN_PD_HOURS.Replace("%d", "{0:d}");
			iDS_CHATON_POP_YOU_HAVE_REACHED_YOUR_DAILY_SMS_LIMIT_RETRY_IN_PD_HOURS = string.Format(iDS_CHATON_POP_YOU_HAVE_REACHED_YOUR_DAILY_SMS_LIMIT_RETRY_IN_PD_HOURS, 24);
			MessageBox.Show(iDS_CHATON_POP_YOU_HAVE_REACHED_YOUR_DAILY_SMS_LIMIT_RETRY_IN_PD_HOURS);
		}
		else if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("11005"))
		{
			LoadingIndicator.StopLoading();
			string iDS_CHATON_POP_RETRY_IN_PD_MINUTES = ResContainer.IDS_CHATON_POP_RETRY_IN_PD_MINUTES;
			iDS_CHATON_POP_RETRY_IN_PD_MINUTES = iDS_CHATON_POP_RETRY_IN_PD_MINUTES.Replace("%d", "{0:d}");
			iDS_CHATON_POP_RETRY_IN_PD_MINUTES = string.Format(iDS_CHATON_POP_RETRY_IN_PD_MINUTES, 3);
			MessageBox.Show(iDS_CHATON_POP_RETRY_IN_PD_MINUTES);
		}
		else if (e.Error != null)
		{
			LoadingIndicator.StopLoading();
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else
		{
			_ssmService.SendSMS();
		}
	}

	private void _ssmService_GetACSTokenCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Error != null)
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else
		{
			_ssmService.SendACS(_language);
		}
	}

	private void DoneButton_Click(object sender, EventArgs e)
	{
		InputNum.IsEnabled = false;
		InputNum.IsEnabled = true;
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
		LayoutRoot.Children.Add(value);
		_ssmService.ValidateSMSAuth(InputNum.Text, _isACS);
	}

	private void CancelButton_Click(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void SMS_Click(object sender, RoutedEventArgs e)
	{
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		sendSMS(userAccount);
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
		LayoutRoot.Children.Add(value);
	}

	private void ACS_Click(object sender, RoutedEventArgs e)
	{
		PageNavigationService.OpenSelectACSOptionPage((PhoneApplicationPage)(object)this);
	}

	private void sendACS(UserAccountInfo account)
	{
		_ssmService.GetACSToken();
	}

	private void sendSMS(UserAccountInfo account)
	{
		_ssmService.GetSMSToken();
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/InputVerificationCodePage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (StackPanel)((FrameworkElement)this).FindName("ContentPanel");
			InitText = (TextBlock)((FrameworkElement)this).FindName("InitText");
			RemarkText = (TextBlock)((FrameworkElement)this).FindName("RemarkText");
			SMSButton = (Button)((FrameworkElement)this).FindName("SMSButton");
			ACSButton = (Button)((FrameworkElement)this).FindName("ACSButton");
			BugReportText = (TextBlock)((FrameworkElement)this).FindName("BugReportText");
			BugReportButton = (Button)((FrameworkElement)this).FindName("BugReportButton");
			SendTo = (TextBox)((FrameworkElement)this).FindName("SendTo");
			InputNum = (TextBox)((FrameworkElement)this).FindName("InputNum");
		}
	}
}
