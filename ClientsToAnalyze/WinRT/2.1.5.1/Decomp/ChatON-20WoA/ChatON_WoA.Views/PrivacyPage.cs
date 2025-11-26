using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.UI.Core;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class PrivacyPage : Page, IComponentConnector
{
	private PrivacyPageViewModel _viewModel;

	private bool _buddySaySettingLoaded;

	private static PrivacyPage _this;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock PhoneNumber;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ToggleSwitch ToggleShowNumberControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtShowMyProfile;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock ProfileImgDescription;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ComboBox ShowOptionProfilePicture;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SamsungAccountDescription;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ToggleSwitch SamsungAccountToggle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ToggleSwitch ToggleShowBirthdayControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button AddBirthdayButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ToggleSwitch ToggleBuddiesSayControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button BlindListButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ToggleSwitch TogglePasswordControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static PrivacyPage ActiveInstance => _this;

	public PrivacyPage()
	{
		InitializeComponent();
		_this = this;
		_viewModel = new PrivacyPageViewModel(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		UpdateTogglePasswordControl();
		if (!string.IsNullOrEmpty(RegistrationService.GetUserNumber()))
		{
			PhoneNumber.put_Text("+" + RegistrationService.GetUserNumber());
		}
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		SettingsPage.ActiveInstance.StopLoading();
		((Page)this).OnNavigatedFrom(e);
	}

	private unsafe void PrivacyPage_Loaded(object sender, RoutedEventArgs e)
	{
		//IL_0086: Unknown result type (might be due to invalid IL or missing references)
		//IL_0090: Expected O, but got Unknown
		if (!string.IsNullOrEmpty(RegistrationService.GetUserProfile().Email))
		{
			((Control)SamsungAccountToggle).put_IsEnabled(true);
		}
		if (!string.IsNullOrEmpty(RegistrationService.GetUserNumber()))
		{
			((Control)ToggleShowNumberControl).put_IsEnabled(true);
		}
		_viewModel.UpdateUserPrivacy();
		txtShowMyProfile.put_Text(Utility.GetResourceString("IDS_CHATON_MBODY_SHOW_MY_PROFILE_PICTURE"));
		LoadBirthdaySetting();
		LoadBuddySaySetting();
		Window current = Window.Current;
		WindowsRuntimeMarshal.AddEventHandler(new Func<WindowSizeChangedEventHandler, EventRegistrationToken>(current, (nint)__ldftn(Window.add_SizeChanged)), new Action<EventRegistrationToken>(current, (nint)__ldftn(Window.remove_SizeChanged)), new WindowSizeChangedEventHandler(Current_SizeChanged));
		((Control)ShowOptionProfilePicture).put_IsEnabled(true);
		((Control)ShowOptionProfilePicture).Focus((FocusState)1);
	}

	private void Current_SizeChanged(object sender, WindowSizeChangedEventArgs e)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		if ((int)ApplicationView.Value == 2)
		{
			((Control)ShowOptionProfilePicture).put_IsEnabled(false);
		}
	}

	private void LoadBuddySaySetting()
	{
		_buddySaySettingLoaded = true;
		bool buddySayBlindSetting = SSMService.GetBuddySayBlindSetting();
		ToggleBuddiesSayControl.put_IsOn(buddySayBlindSetting);
	}

	private void ToggleShowNumber_Toggled_1(object sender, RoutedEventArgs e)
	{
		_viewModel.OnToggleShowPhonenumber(ToggleShowNumberControl.IsOn);
	}

	private void ToggleShowBirthday_Toggled_1(object sender, RoutedEventArgs e)
	{
		UserProfile userProfile = RegistrationService.GetUserProfile();
		if (userProfile.BirthdayDisplayType != 2 != ToggleShowBirthdayControl.IsOn)
		{
			if (userProfile.Birthday.Ticks == 0 && ToggleShowBirthdayControl.IsOn)
			{
				OpenBirthdaySetting();
			}
			else
			{
				_viewModel.SaveShowBirthday(ToggleShowBirthdayControl.IsOn);
			}
		}
		if (ToggleShowBirthdayControl.IsOn)
		{
			DisplayBirthday();
		}
		else
		{
			((UIElement)AddBirthdayButton).put_Visibility((Visibility)1);
		}
	}

	public void DisplayBirthday()
	{
		((UIElement)AddBirthdayButton).put_Visibility((Visibility)0);
		string displayBirthday = _viewModel.MyProfile.DisplayBirthday;
		if (!string.IsNullOrWhiteSpace(displayBirthday))
		{
			((ContentControl)AddBirthdayButton).put_Content((object)displayBirthday);
		}
		else
		{
			((ContentControl)AddBirthdayButton).put_Content((object)Utility.GetResourceString("IDS_CHATON_BODY_ADD_BIRTHDAY"));
		}
	}

	private void TogglePassword_Toggled_1(object sender, RoutedEventArgs e)
	{
		string password = SettingService.GetPassword();
		if (TogglePasswordControl.IsOn)
		{
			if (string.IsNullOrEmpty(password))
			{
				PasswordSettingPopup passwordSettingPopup = new PasswordSettingPopup();
				((FrameworkElement)passwordSettingPopup).put_HorizontalAlignment((HorizontalAlignment)3);
				((FrameworkElement)passwordSettingPopup).put_VerticalAlignment((VerticalAlignment)0);
				((FrameworkElement)passwordSettingPopup).put_Margin(new Thickness(0.0, 100.0, 0.0, 0.0));
				passwordSettingPopup.CreateNewPassword();
				SettingsPage.ActiveInstance.OpenDialog((UserControl)(object)passwordSettingPopup, dialog_closed);
			}
		}
		else if (!string.IsNullOrEmpty(password))
		{
			PasswordSettingPopup passwordSettingPopup2 = new PasswordSettingPopup();
			((FrameworkElement)passwordSettingPopup2).put_HorizontalAlignment((HorizontalAlignment)3);
			((FrameworkElement)passwordSettingPopup2).put_VerticalAlignment((VerticalAlignment)0);
			((FrameworkElement)passwordSettingPopup2).put_Margin(new Thickness(0.0, 100.0, 0.0, 0.0));
			passwordSettingPopup2.DeletePassword();
			SettingsPage.ActiveInstance.OpenDialog((UserControl)(object)passwordSettingPopup2, dialog_closed);
		}
	}

	private void dialog_closed(object sender, EventArgs e)
	{
		UpdateTogglePasswordControl();
	}

	private void UpdateTogglePasswordControl()
	{
		string password = SettingService.GetPassword();
		if (string.IsNullOrEmpty(password))
		{
			TogglePasswordControl.put_IsOn(false);
		}
		else
		{
			TogglePasswordControl.put_IsOn(true);
		}
	}

	internal void ToggleNoBlindList(bool isOn)
	{
		ToggleBuddiesSayControl.put_IsOn(isOn);
	}

	internal void ToggleShowPhoneNumber(bool isOn)
	{
		ToggleShowNumberControl.put_IsOn(isOn);
	}

	internal void DisableToggleShowPhonenumberControl()
	{
		((Control)ToggleShowNumberControl).put_IsEnabled(false);
	}

	private void HiddenListButton_Click_1(object sender, RoutedEventArgs e)
	{
		SettingsPage.ActiveInstance.ShowHiddenInteractionPage();
	}

	private void BlinedListButton_Click_1(object sender, RoutedEventArgs e)
	{
		SettingsPage.ActiveInstance.ShowBlindListPage();
	}

	private void ChagePassword_Click(object sender, RoutedEventArgs e)
	{
		PasswordSettingPopup passwordSettingPopup = new PasswordSettingPopup();
		((FrameworkElement)passwordSettingPopup).put_HorizontalAlignment((HorizontalAlignment)3);
		((FrameworkElement)passwordSettingPopup).put_VerticalAlignment((VerticalAlignment)0);
		((FrameworkElement)passwordSettingPopup).put_Margin(new Thickness(0.0, 100.0, 0.0, 0.0));
		passwordSettingPopup.ChangePassword();
		SettingsPage.ActiveInstance.OpenDialog((UserControl)(object)passwordSettingPopup);
	}

	private void ChangeHint_Click_1(object sender, RoutedEventArgs e)
	{
		PasswordSettingPopup passwordSettingPopup = new PasswordSettingPopup();
		((FrameworkElement)passwordSettingPopup).put_HorizontalAlignment((HorizontalAlignment)3);
		((FrameworkElement)passwordSettingPopup).put_VerticalAlignment((VerticalAlignment)0);
		((FrameworkElement)passwordSettingPopup).put_Margin(new Thickness(0.0, 100.0, 0.0, 0.0));
		passwordSettingPopup.ChangeHint();
		SettingsPage.ActiveInstance.OpenDialog((UserControl)(object)passwordSettingPopup);
	}

	private void BirthdaySetting_Click_1(object sender, RoutedEventArgs e)
	{
		OpenBirthdaySetting();
	}

	private void OpenBirthdaySetting()
	{
		AddBirthdayDialog addBirthdayDialog = new AddBirthdayDialog();
		((FrameworkElement)addBirthdayDialog).put_HorizontalAlignment((HorizontalAlignment)1);
		((FrameworkElement)addBirthdayDialog).put_VerticalAlignment((VerticalAlignment)1);
		addBirthdayDialog.EditCompleted += dialog_EditCompleted;
		SettingsPage.ActiveInstance.OpenDialog((UserControl)(object)addBirthdayDialog);
	}

	private void dialog_EditCompleted(object sender, object e)
	{
		UserProfile userProfile = RegistrationService.GetUserProfile();
		bool flag = (bool)e;
		AddBirthdayDialog addBirthdayDialog = null;
		if (!(sender is AddBirthdayDialog addBirthdayDialog2))
		{
			return;
		}
		if (flag)
		{
			int bitrhdayParam = 2;
			if (ToggleShowBirthdayControl.IsOn && addBirthdayDialog2.IsShowYear)
			{
				bitrhdayParam = 0;
			}
			else if (ToggleShowBirthdayControl.IsOn)
			{
				bitrhdayParam = 1;
			}
			_viewModel.Save(ToggleShowBirthdayControl.IsOn, addBirthdayDialog2.SelectedDate, bitrhdayParam, addBirthdayDialog2.IsShowYear);
			DisplayBirthday();
		}
		else if (userProfile.Birthday.Ticks == 0)
		{
			ToggleShowBirthdayControl.put_IsOn(false);
		}
	}

	internal void ShowLoading()
	{
		SettingsPage.ActiveInstance.ShowLoading();
	}

	internal void OnUpdateBirthdayFailed()
	{
		LoadBirthdaySetting();
	}

	private void LoadBirthdaySetting()
	{
		UserProfile userProfile = RegistrationService.GetUserProfile();
		ToggleShowBirthdayControl.put_IsOn(userProfile.BirthdayDisplayType != 2);
		string text = _viewModel.MyProfile.Birthday.ToString("yyyy-MM-dd");
		if (!string.IsNullOrWhiteSpace(text) && !text.Equals("0001-01-01") && !ToggleShowBirthdayControl.IsOn)
		{
			((UIElement)AddBirthdayButton).put_Visibility((Visibility)1);
		}
	}

	private void ToggleShowSamsungAccount_Toggled_1(object sender, RoutedEventArgs e)
	{
		_viewModel.ToggleSamsungAccountOption(SamsungAccountToggle.IsOn);
	}

	internal void ToggleProfileImageDesc(int index)
	{
		if (index == 1)
		{
			ProfileImgDescription.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_ALL_CHATON_USERS_CAN_SEE_YOUR_PROFILE_IMAGE"));
		}
		else
		{
			ProfileImgDescription.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_ONLY_YOUR_BUDDIES_CAN_SEE_YOUR_PROFILE_IMAGE"));
		}
	}

	internal void ToggleTextShowOption(bool SamsungEmailOption)
	{
		SamsungAccountToggle.put_IsOn(SamsungEmailOption);
		SamsungAccountDescription.put_Text(SamsungEmailOption ? Utility.GetResourceString("IDS_CHATON_BODY_ALL_CHATON_USERS_CAN_SEARCH_YOUR_SAMSUNG_ACCOUNT") : Utility.GetResourceString("IDS_CHATON_BODY_NO_CHATON_USERS_CAN_SEE_OR_SEARCH_FOR_YOUR_SAMSUNG_ACCOUNT"));
	}

	private void BirthdayTextBlock_OnTapped(object sender, TappedRoutedEventArgs e)
	{
		OpenBirthdaySetting();
	}

	private void ToggleBuddiesSayControl_OnToggled(object sender, RoutedEventArgs e)
	{
		bool isOn = ToggleBuddiesSayControl.IsOn;
		_viewModel.OnToggleBuddySay(isOn);
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///PrivacyPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			PhoneNumber = (TextBlock)((FrameworkElement)this).FindName("PhoneNumber");
			ToggleShowNumberControl = (ToggleSwitch)((FrameworkElement)this).FindName("ToggleShowNumberControl");
			txtShowMyProfile = (TextBlock)((FrameworkElement)this).FindName("txtShowMyProfile");
			ProfileImgDescription = (TextBlock)((FrameworkElement)this).FindName("ProfileImgDescription");
			ShowOptionProfilePicture = (ComboBox)((FrameworkElement)this).FindName("ShowOptionProfilePicture");
			SamsungAccountDescription = (TextBlock)((FrameworkElement)this).FindName("SamsungAccountDescription");
			SamsungAccountToggle = (ToggleSwitch)((FrameworkElement)this).FindName("SamsungAccountToggle");
			ToggleShowBirthdayControl = (ToggleSwitch)((FrameworkElement)this).FindName("ToggleShowBirthdayControl");
			AddBirthdayButton = (Button)((FrameworkElement)this).FindName("AddBirthdayButton");
			ToggleBuddiesSayControl = (ToggleSwitch)((FrameworkElement)this).FindName("ToggleBuddiesSayControl");
			BlindListButton = (Button)((FrameworkElement)this).FindName("BlindListButton");
			TogglePasswordControl = (ToggleSwitch)((FrameworkElement)this).FindName("TogglePasswordControl");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0038: Unknown result type (might be due to invalid IL or missing references)
		//IL_003e: Expected O, but got Unknown
		//IL_005d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0067: Expected O, but got Unknown
		//IL_006d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0073: Expected O, but got Unknown
		//IL_0092: Unknown result type (might be due to invalid IL or missing references)
		//IL_009c: Expected O, but got Unknown
		//IL_00a2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a8: Expected O, but got Unknown
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
		//IL_00d7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00de: Expected O, but got Unknown
		//IL_00ff: Unknown result type (might be due to invalid IL or missing references)
		//IL_0109: Expected O, but got Unknown
		//IL_010f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0116: Expected O, but got Unknown
		//IL_0137: Unknown result type (might be due to invalid IL or missing references)
		//IL_0141: Expected O, but got Unknown
		//IL_0147: Unknown result type (might be due to invalid IL or missing references)
		//IL_014e: Expected O, but got Unknown
		//IL_016f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0179: Expected O, but got Unknown
		//IL_017f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0186: Expected O, but got Unknown
		//IL_01a7: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b1: Expected O, but got Unknown
		//IL_01b7: Unknown result type (might be due to invalid IL or missing references)
		//IL_01be: Expected O, but got Unknown
		//IL_01df: Unknown result type (might be due to invalid IL or missing references)
		//IL_01e9: Expected O, but got Unknown
		//IL_01ec: Unknown result type (might be due to invalid IL or missing references)
		//IL_01f3: Expected O, but got Unknown
		//IL_0214: Unknown result type (might be due to invalid IL or missing references)
		//IL_021e: Expected O, but got Unknown
		//IL_0221: Unknown result type (might be due to invalid IL or missing references)
		//IL_0228: Expected O, but got Unknown
		//IL_0249: Unknown result type (might be due to invalid IL or missing references)
		//IL_0253: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val10 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(PrivacyPage_Loaded));
			break;
		}
		case 2:
		{
			ToggleSwitch val9 = (ToggleSwitch)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(ToggleSwitch.add_Toggled)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(ToggleSwitch.remove_Toggled)), new RoutedEventHandler(ToggleShowNumber_Toggled_1));
			break;
		}
		case 3:
		{
			ToggleSwitch val8 = (ToggleSwitch)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(ToggleSwitch.add_Toggled)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(ToggleSwitch.remove_Toggled)), new RoutedEventHandler(ToggleShowSamsungAccount_Toggled_1));
			break;
		}
		case 4:
		{
			ToggleSwitch val7 = (ToggleSwitch)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(ToggleSwitch.add_Toggled)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(ToggleSwitch.remove_Toggled)), new RoutedEventHandler(ToggleShowBirthday_Toggled_1));
			break;
		}
		case 5:
		{
			ButtonBase val6 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(BirthdaySetting_Click_1));
			break;
		}
		case 6:
		{
			ToggleSwitch val5 = (ToggleSwitch)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(ToggleSwitch.add_Toggled)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(ToggleSwitch.remove_Toggled)), new RoutedEventHandler(ToggleBuddiesSayControl_OnToggled));
			break;
		}
		case 7:
		{
			ButtonBase val4 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(BlinedListButton_Click_1));
			break;
		}
		case 8:
		{
			ToggleSwitch val3 = (ToggleSwitch)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ToggleSwitch.add_Toggled)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ToggleSwitch.remove_Toggled)), new RoutedEventHandler(TogglePassword_Toggled_1));
			break;
		}
		case 9:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(ChagePassword_Click));
			break;
		}
		case 10:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(ChangeHint_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
