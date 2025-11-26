using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class InputPhoneNumberPage : Page, IComponentConnector
{
	private SSMService _ssmService;

	private CountryCode _countryCode;

	private bool _sendACS;

	private bool IsProcessed;

	private string code;

	private string phoneNumber;

	private bool IsNextHasClicked;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton NextButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton VoceButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton SMSButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel ACSPanel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SelectCountryCodeText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox CountryCodeText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SubText2;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox InputPhoneNumber;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock InitText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SubText3;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button NextBtn;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public InputPhoneNumberPage()
	{
		InitializeComponent();
		_ssmService = new SSMService();
		_ssmService.GetServerAddress3Completed += _ssmService_GetServerAddress3Completed;
		_ssmService.GetSMSTokenCompleted += _ssmService_GetSMSTokenCompleted;
		_ssmService.SendSMSCompleted += _ssmService_SendSMSCompleted;
		_ssmService.CheckRegParamCompleted += _ssmService_CheckRegParamCompleted;
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		if (userAccount.IMSI.Contains("310") || userAccount.IMSI.Contains("440"))
		{
			((UIElement)NextButton).put_Visibility((Visibility)1);
			((UIElement)SMSButton).put_Visibility((Visibility)0);
			((UIElement)VoceButton).put_Visibility((Visibility)0);
			string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_YOU_WILL_RECEIVE_A_PD_DIGIT_VERIFICATION_CODE_VIA_SMS_OR_VOICE_CALL_SELECT_PREFERRED_METHOD");
			resourceString = resourceString.Replace("%d", "4");
			InitText.put_Text(resourceString);
		}
		else
		{
			string resourceString2 = Utility.GetResourceString("IDS_CHATON_BODY_YOU_WILL_RECEIVE_A_PD_DIGIT_VERIFICATION_CODE_VIA_SMS");
			resourceString2 = resourceString2.Replace("%d", "4");
			InitText.put_Text(resourceString2);
		}
		pageTitle.put_Text(Utility.GetResourceString("IDS_CHATON_HEADER_REGISTRATION"));
		SelectCountryCodeText.put_Text(Utility.GetResourceString("IDS_CHATON_POP_SELECT_COUNTRY_OR_REGION_CODE"));
		SubText2.put_Text(Utility.GetResourceString("IDS_CHATON_MBODY_REGISTER_YOUR_PHONE_NUMBER"));
		SubText3.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_AREA_CODE_REQUIRED"));
		NextButton.Text = Utility.GetResourceString("IDS_CHATON_SK_NEXT");
		((ContentControl)NextBtn).put_Content((object)Utility.GetResourceString("IDS_CHATON_SK_NEXT"));
	}

	private async void _ssmService_CheckRegParamCompleted(object sender, SSMCompletedEventArgs e)
	{
		IsNextHasClicked = false;
		if (e.StatusCode == HttpStatusCode.NoContent || e.StatusCode != HttpStatusCode.OK)
		{
			return;
		}
		if (e.Xml != null)
		{
			if (RegistrationService.ParseCheckParam(e.Xml))
			{
				if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_PHONE_NUMBER_ALREADY_REGISTERED_TO_ANOTHER_DEVICE_IF_YOU_PROCEED_WITH_THE_CURRENT_DEVICE_MSG")))
				{
					if (!IsProcessed)
					{
						IsProcessed = true;
						RegistrationService.RegisterAccount(phoneNumber, code, _countryCode.MCC);
						_ssmService.GetMSISDNFromServerAddress3Async();
					}
				}
				else
				{
					LoadingIndicator.StopLoading();
				}
			}
			else
			{
				RegistrationService.RegisterAccount(phoneNumber, code, _countryCode.MCC);
				_ssmService.GetMSISDNFromServerAddress3Async();
			}
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
	}

	private void InputPhoneNumber_Loaded(object sender, RoutedEventArgs e)
	{
		if (InputPhoneNumber.Text.Length > 0)
		{
			((Control)NextBtn).put_IsEnabled(true);
		}
		((Control)InputPhoneNumber).Focus((FocusState)2);
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e.Parameter != null)
		{
			_countryCode = null;
			if ((_countryCode = e.Parameter as CountryCode) != null)
			{
				CountryCodeText.put_Text(_countryCode.Name + " " + _countryCode.Code);
				if (_countryCode.Code == "+55")
				{
					((UIElement)SubText3).put_Visibility((Visibility)0);
				}
				else
				{
					((UIElement)SubText3).put_Visibility((Visibility)1);
				}
			}
		}
		if (!string.IsNullOrEmpty(RegistrationService.TempMcc) && e.Parameter == null)
		{
			CountryCode countryCodeByMCC = SelectCountryCodePageViewModel.GetCountryCodeByMCC(RegistrationService.TempMcc);
			CountryCodeText.put_Text(countryCodeByMCC.Name + " " + countryCodeByMCC.Code);
			_countryCode = countryCodeByMCC;
		}
		if (!string.IsNullOrEmpty(ChatOnService.Instance.CurrentInputPhoneNumber))
		{
			InputPhoneNumber.put_Text(ChatOnService.Instance.CurrentInputPhoneNumber);
		}
	}

	private async void _ssmService_GetServerAddress3Completed(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		IsProcessed = false;
		if (e.StatusCode == HttpStatusCode.NoContent)
		{
			return;
		}
		if (!string.IsNullOrEmpty(e.ErrorMessage))
		{
			if (e.ErrorMessage.Contains("13003") || e.ErrorMessage.Contains("13002"))
			{
				MessageDialog val = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_INVALID_PHONE_NUMBER_FORMAT"));
				val.ShowAsync();
			}
		}
		else if (e.Error != null)
		{
			if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"), showCancel: true, Utility.GetResourceString("IDS_CHATON_BODY_ERROR")))
			{
				await CheckAndRunNextStep();
			}
		}
		else if (_sendACS)
		{
			((Page)this).Frame.Navigate(typeof(SelectACSOptionPage));
		}
		else
		{
			UserAccountInfo userAccount = RegistrationService.GetUserAccount();
			sendSMS(userAccount);
		}
	}

	private async Task CheckAndRunNextStep()
	{
		if (!IsNextHasClicked)
		{
			code = _countryCode.Code.Remove(0, 1);
			phoneNumber = InputPhoneNumber.Text;
			if (LoadingIndicator.ActiveIndicator != null)
			{
				LoadingIndicator.StopLoading();
			}
			LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
			if (!code.StartsWith("+"))
			{
				_ = "+" + code;
			}
			else
			{
				_ = code;
			}
			phoneNumber = (phoneNumber.StartsWith("0") ? phoneNumber.Remove(0, 1) : phoneNumber);
			string parameter = code + phoneNumber;
			_ssmService.CheckRegParamAsync(parameter, isUpdateMsisdn: true);
			IsNextHasClicked = true;
		}
	}

	private async Task<bool> CheckInputData(CountryCode codeInfo)
	{
		if (codeInfo == null)
		{
			MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_BODY_ENTER_COUNTRY_CODE"));
			await dialog.ShowAsync();
			return false;
		}
		if (string.IsNullOrEmpty(InputPhoneNumber.Text))
		{
			MessageDialog dialog2 = new MessageDialog(Utility.GetResourceString("IDS_CHATON_BODY_ENTER_PHONE_NUMBER"));
			await dialog2.ShowAsync();
			return false;
		}
		return true;
	}

	private async void NextButtoni_Click_1(object sender, RoutedEventArgs e)
	{
		if (await CheckInputData(_countryCode))
		{
			CheckAndRunNextStep();
		}
	}

	private void CountryCodeText_GotFocus_1(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.Navigate(typeof(SelectLanguagePage), (object)true);
	}

	private void backButton_Click_1(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.Navigate(typeof(PivotPage));
	}

	private void InputPhoneNumber_TextChanged_1(object sender, TextChangedEventArgs e)
	{
		ChatOnService.Instance.CurrentInputPhoneNumber = InputPhoneNumber.Text;
		if (InputPhoneNumber.Text.Length > 5)
		{
			((Control)NextBtn).put_IsEnabled(true);
		}
		else
		{
			((Control)NextBtn).put_IsEnabled(false);
		}
	}

	private async void SMSButton_Click_1(object sender, RoutedEventArgs e)
	{
		_sendACS = false;
		if (await CheckInputData(_countryCode))
		{
			CheckAndRunNextStep();
		}
	}

	private async void VoceButton_Click_1(object sender, RoutedEventArgs e)
	{
		_sendACS = true;
		if (await CheckInputData(_countryCode))
		{
			CheckAndRunNextStep();
		}
	}

	private void _ssmService_SendSMSCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0060: Unknown result type (might be due to invalid IL or missing references)
		//IL_0066: Expected O, but got Unknown
		//IL_00de: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e4: Expected O, but got Unknown
		if (!string.IsNullOrEmpty(e.ErrorMessage))
		{
			if (e.ErrorMessage.Contains("CSS-12005"))
			{
				LoadingIndicator.StopLoading();
				string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS");
				resourceString = resourceString.Replace("%d", "{0:d}");
				resourceString = string.Format(resourceString, new object[1] { 24 });
				MessageDialog val = new MessageDialog(resourceString);
				val.ShowAsync();
			}
			else if (e.ErrorMessage.Contains("CSS-12002"))
			{
				_ssmService.GetSMSToken();
			}
			else if (e.ErrorMessage.Contains("11005"))
			{
				LoadingIndicator.StopLoading();
				string resourceString2 = Utility.GetResourceString("IDS_CHATON_POP_RETRY_IN_PD_MINUTES");
				resourceString2 = resourceString2.Replace("%d", "{0:d}");
				resourceString2 = string.Format(resourceString2, new object[1] { 3 });
				MessageDialog val2 = new MessageDialog(resourceString2);
				val2.ShowAsync();
			}
		}
		else if (e.Error != null)
		{
			LoadingIndicator.StopLoading();
			SSMService.ShowCommonErrorMessage(e);
		}
		else
		{
			LoadingIndicator.StopLoading();
			SettingService.SetCodeSentTime(DateTime.Now.Ticks);
			((Page)this).Frame.Navigate(typeof(InputVerificationCodePage));
		}
	}

	private void _ssmService_GetSMSTokenCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_005d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00cd: Expected O, but got Unknown
		if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("CSS-12005"))
		{
			LoadingIndicator.StopLoading();
			string resourceString = Utility.GetResourceString("IDS_CHATON_POP_YOU_HAVE_REACHED_YOUR_DAILY_SMS_LIMIT_RETRY_IN_PD_HOURS");
			resourceString = resourceString.Replace("%d", "{0:d}");
			resourceString = string.Format(resourceString, new object[1] { 24 });
			MessageDialog val = new MessageDialog(resourceString);
			val.ShowAsync();
		}
		else if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("CSS-11005"))
		{
			LoadingIndicator.StopLoading();
			string resourceString2 = Utility.GetResourceString("IDS_CHATON_POP_RETRY_IN_PD_MINUTES");
			resourceString2 = resourceString2.Replace("%d", "{0:d}");
			resourceString2 = string.Format(resourceString2, new object[1] { 3 });
			MessageDialog val2 = new MessageDialog(resourceString2);
			val2.ShowAsync();
		}
		else if (e.Error != null)
		{
			LoadingIndicator.StopLoading();
			SSMService.ShowCommonErrorMessage(e);
		}
		else
		{
			_ssmService.SendSMS();
		}
	}

	private void sendSMS(UserAccountInfo account)
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
		_ssmService.GetSMSToken();
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
		//IL_00dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Expected O, but got Unknown
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Expected O, but got Unknown
		//IL_011f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0129: Expected O, but got Unknown
		//IL_0135: Unknown result type (might be due to invalid IL or missing references)
		//IL_013f: Expected O, but got Unknown
		//IL_014b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0155: Expected O, but got Unknown
		//IL_0161: Unknown result type (might be due to invalid IL or missing references)
		//IL_016b: Expected O, but got Unknown
		//IL_0177: Unknown result type (might be due to invalid IL or missing references)
		//IL_0181: Expected O, but got Unknown
		//IL_018d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0197: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///InputPhoneNumberPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			NextButton = (ImageButton)((FrameworkElement)this).FindName("NextButton");
			VoceButton = (ImageButton)((FrameworkElement)this).FindName("VoceButton");
			SMSButton = (ImageButton)((FrameworkElement)this).FindName("SMSButton");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			ACSPanel = (StackPanel)((FrameworkElement)this).FindName("ACSPanel");
			SelectCountryCodeText = (TextBlock)((FrameworkElement)this).FindName("SelectCountryCodeText");
			CountryCodeText = (TextBox)((FrameworkElement)this).FindName("CountryCodeText");
			SubText2 = (TextBlock)((FrameworkElement)this).FindName("SubText2");
			InputPhoneNumber = (TextBox)((FrameworkElement)this).FindName("InputPhoneNumber");
			InitText = (TextBlock)((FrameworkElement)this).FindName("InitText");
			SubText3 = (TextBlock)((FrameworkElement)this).FindName("SubText3");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
			NextBtn = (Button)((FrameworkElement)this).FindName("NextBtn");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0030: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		//IL_0055: Unknown result type (might be due to invalid IL or missing references)
		//IL_005f: Expected O, but got Unknown
		//IL_0071: Unknown result type (might be due to invalid IL or missing references)
		//IL_007b: Expected O, but got Unknown
		//IL_008d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0097: Expected O, but got Unknown
		//IL_00a9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b3: Expected O, but got Unknown
		//IL_00b9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bf: Expected O, but got Unknown
		//IL_00de: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e8: Expected O, but got Unknown
		//IL_00ee: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f4: Expected O, but got Unknown
		//IL_0113: Unknown result type (might be due to invalid IL or missing references)
		//IL_011d: Expected O, but got Unknown
		//IL_0120: Unknown result type (might be due to invalid IL or missing references)
		//IL_0127: Expected O, but got Unknown
		//IL_0148: Unknown result type (might be due to invalid IL or missing references)
		//IL_0152: Expected O, but got Unknown
		//IL_0155: Unknown result type (might be due to invalid IL or missing references)
		//IL_015c: Expected O, but got Unknown
		//IL_017d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0187: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val5 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(InputPhoneNumber_Loaded));
			break;
		}
		case 2:
			((ImageButton)target).Click += new RoutedEventHandler(NextButtoni_Click_1);
			break;
		case 3:
			((ImageButton)target).Click += new RoutedEventHandler(VoceButton_Click_1);
			break;
		case 4:
			((ImageButton)target).Click += new RoutedEventHandler(SMSButton_Click_1);
			break;
		case 5:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_GotFocus)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_GotFocus)), new RoutedEventHandler(CountryCodeText_GotFocus_1));
			break;
		}
		case 6:
		{
			TextBox val3 = (TextBox)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TextChangedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(TextBox.add_TextChanged)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(TextBox.remove_TextChanged)), new TextChangedEventHandler(InputPhoneNumber_TextChanged_1));
			break;
		}
		case 7:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click_1));
			break;
		}
		case 8:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(NextButtoni_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
