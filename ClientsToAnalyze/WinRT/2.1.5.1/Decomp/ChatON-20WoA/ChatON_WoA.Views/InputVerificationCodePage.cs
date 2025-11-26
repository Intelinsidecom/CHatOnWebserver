using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class InputVerificationCodePage : Page, IComponentConnector
{
	private SSMService _ssmService;

	private string _code;

	private bool _isACS;

	private string _language;

	private UserAccountInfo _account;

	private DispatcherTimer _timer;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SubText1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SubText2;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox InputNum;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SubText3;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock TimeDisplay;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SubText3_Copy;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button ContactUsButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button SMSBtn;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button VoiceBtn;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button NextBtn;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static CountryCode[] CodeData => SelectCountryCodePageViewModel.CodeData;

	public unsafe InputVerificationCodePage()
	{
		//IL_0149: Unknown result type (might be due to invalid IL or missing references)
		//IL_0153: Expected O, but got Unknown
		InitializeComponent();
		_account = RegistrationService.GetUserAccount();
		_ssmService = new SSMService();
		_ssmService.ValidateSMSAuthCompleted += _ssmService_ValidateSMSAuthCompleted;
		_ssmService.GetSMSTokenCompleted += _ssmService_GetSMSTokenCompleted;
		_ssmService.SendSMSCompleted += _ssmService_SendSMSCompleted;
		_ssmService.UpdateMSISDNCompleted += _ssmService_UpdateMSISDNCompleted;
		pageTitle.put_Text(Utility.GetResourceString("IDS_CHATON_HEADER_REGISTRATION"));
		string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_VERIFICATION_CODE_SENT_TO_PS");
		resourceString = resourceString.Replace("%s", "+" + RegistrationService.TempMSISDN);
		SubText1.put_Text(resourceString);
		SubText2.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_ENTER_VERIFICATION_CODE"));
		resourceString = Utility.GetResourceString("IDS_CHATON_BODY_IF_YOU_DO_NOT_RECEIVE_A_VERIFICATION_CODE_IN_PD_MINUTES_RESEND_VERIFICATION_CODE_REQUEST");
		resourceString = resourceString.Replace("%d", "3");
		SubText3.put_Text(resourceString);
		((ContentControl)SMSBtn).put_Content((object)Utility.GetResourceString("IDS_CHATON_SK_SMS"));
		((ContentControl)VoiceBtn).put_Content((object)Utility.GetResourceString("IDS_CHATON_ITAB_VOICE_CALL"));
		((ContentControl)NextBtn).put_Content((object)Utility.GetResourceString("IDS_CHATON_SK_NEXT"));
		((FrameworkElement)this).put_DataContext((object)this);
		_timer = new DispatcherTimer();
		DispatcherTimer timer = _timer;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(timer, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(timer, (nint)__ldftn(DispatcherTimer.remove_Tick)), _timer_Tick);
		_timer.put_Interval(TimeSpan.FromMilliseconds(100.0));
	}

	private void _timer_Tick(object sender, object e)
	{
		long codeSentTime = SettingService.GetCodeSentTime();
		TimeSpan timeSpan = TimeSpan.FromMinutes(3.0) - TimeSpan.FromTicks(DateTime.Now.Ticks - codeSentTime);
		TimeDisplay.put_Text(timeSpan.ToString("m\\:ss"));
		if (timeSpan.TotalSeconds <= 0.0)
		{
			StopTimer();
		}
	}

	private void StopTimer()
	{
		_timer.Stop();
		((UIElement)TimeDisplay).put_Visibility((Visibility)1);
		((UIElement)SMSBtn).put_Visibility((Visibility)0);
		((UIElement)VoiceBtn).put_Visibility((Visibility)0);
		SettingService.SetCodeSentTime(0L);
	}

	private void InputNum_Loaded(object sender, RoutedEventArgs e)
	{
		((Control)InputNum).Focus((FocusState)2);
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		StartTimer();
	}

	private void StartTimer()
	{
		long codeSentTime = SettingService.GetCodeSentTime();
		if (codeSentTime != 0)
		{
			((UIElement)TimeDisplay).put_Visibility((Visibility)0);
			_timer.Start();
			((UIElement)SMSBtn).put_Visibility((Visibility)1);
			((UIElement)VoiceBtn).put_Visibility((Visibility)1);
		}
	}

	private async void _ssmService_ValidateSMSAuthCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error == null)
		{
			((Page)this).Frame.Navigate(typeof(InputNamePage));
		}
		else if (!string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_INCORRECT_VERIFICATION_CODE"));
			await dialog.ShowAsync();
			if ((_account.MSISDN == "821011112228" || _account.MSISDN == "821011112229" || _account.MSISDN == "821011112226" || _account.MSISDN == "821011112227") && InputNum.Text == "2222")
			{
				((Page)this).Frame.Navigate(typeof(InputNamePage));
			}
		}
		else if (e.Error != null)
		{
			MessageDialog dialog2 = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"));
			await dialog2.ShowAsync();
		}
	}

	private void _ssmService_SendSMSCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0060: Unknown result type (might be due to invalid IL or missing references)
		//IL_0066: Expected O, but got Unknown
		//IL_00db: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e1: Expected O, but got Unknown
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
			StartTimer();
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

	private void SMSButton_Click_1(object sender, RoutedEventArgs e)
	{
		sendSMS(_account);
	}

	private void VoceButton_Click_1(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.Navigate(typeof(SelectACSOptionPage));
	}

	private void NextButton_Click_1(object sender, RoutedEventArgs e)
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
		_ssmService.UpdateMSISDNAsync(InputNum.Text, _isACS);
	}

	private void backButton_Click_1(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private void ContactUsButton_Click_1(object sender, RoutedEventArgs e)
	{
		Utility.OpenContactUs();
	}

	private async void _ssmService_UpdateMSISDNCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error == null)
		{
			RegistrationService.SaveMSISDN(RegistrationService.TempMSISDN);
			await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_BODY_ALL_CONTACTS_WILL_BE_IMPORTED_AND_ADDED_AS_BUDDIES"), showCancel: false, Utility.GetResourceString("IDS_CHATON_HEADER_CONTACT_SYNC"));
			ChatOnService.Instance.IsProfileUpdated = true;
			ChatOnService.Instance.ReUpdateBuddyList = true;
			ChatOnService.Instance.ReUpdateChatList = true;
			PageNavigationService.OpenPivotPage((Page)(object)this);
		}
		else if (!string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_INCORRECT_VERIFICATION_CODE"));
			await dialog.ShowAsync();
		}
		else if (e.Error != null)
		{
			MessageDialog dialog2 = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"));
			await dialog2.ShowAsync();
		}
	}

	private void InputNum_KeyUp(object sender, KeyRoutedEventArgs e)
	{
		if (InputNum.Text.Length > 0)
		{
			((UIElement)NextBtn).put_Visibility((Visibility)0);
		}
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
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///InputVerificationCodePage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			SubText1 = (TextBlock)((FrameworkElement)this).FindName("SubText1");
			SubText2 = (TextBlock)((FrameworkElement)this).FindName("SubText2");
			InputNum = (TextBox)((FrameworkElement)this).FindName("InputNum");
			SubText3 = (TextBlock)((FrameworkElement)this).FindName("SubText3");
			TimeDisplay = (TextBlock)((FrameworkElement)this).FindName("TimeDisplay");
			SubText3_Copy = (TextBlock)((FrameworkElement)this).FindName("SubText3_Copy");
			ContactUsButton = (Button)((FrameworkElement)this).FindName("ContactUsButton");
			SMSBtn = (Button)((FrameworkElement)this).FindName("SMSBtn");
			VoiceBtn = (Button)((FrameworkElement)this).FindName("VoiceBtn");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
			NextBtn = (Button)((FrameworkElement)this).FindName("NextBtn");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0028: Unknown result type (might be due to invalid IL or missing references)
		//IL_002e: Expected O, but got Unknown
		//IL_004d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0057: Expected O, but got Unknown
		//IL_0058: Unknown result type (might be due to invalid IL or missing references)
		//IL_005e: Expected O, but got Unknown
		//IL_007d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0087: Expected O, but got Unknown
		//IL_008d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0093: Expected O, but got Unknown
		//IL_00b2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bc: Expected O, but got Unknown
		//IL_00c2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c9: Expected O, but got Unknown
		//IL_00ea: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f4: Expected O, but got Unknown
		//IL_00fa: Unknown result type (might be due to invalid IL or missing references)
		//IL_0101: Expected O, but got Unknown
		//IL_0122: Unknown result type (might be due to invalid IL or missing references)
		//IL_012c: Expected O, but got Unknown
		//IL_012f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0136: Expected O, but got Unknown
		//IL_0157: Unknown result type (might be due to invalid IL or missing references)
		//IL_0161: Expected O, but got Unknown
		//IL_0164: Unknown result type (might be due to invalid IL or missing references)
		//IL_016b: Expected O, but got Unknown
		//IL_018c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0196: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val6 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(InputNum_Loaded));
			UIElement val7 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<KeyEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(UIElement.add_KeyUp)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(UIElement.remove_KeyUp)), new KeyEventHandler(InputNum_KeyUp));
			break;
		}
		case 2:
		{
			ButtonBase val5 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(ContactUsButton_Click_1));
			break;
		}
		case 3:
		{
			ButtonBase val4 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(SMSButton_Click_1));
			break;
		}
		case 4:
		{
			ButtonBase val3 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(VoceButton_Click_1));
			break;
		}
		case 5:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click_1));
			break;
		}
		case 6:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(NextButton_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
