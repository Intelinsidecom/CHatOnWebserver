using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Globalization;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text.RegularExpressions;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.UI;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;

namespace ChatON_WoA.Views;

public sealed class EditProfilePage : Page, IComponentConnector
{
	private EditProfilePageViewModel _viewModel;

	private bool _isFocused;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LeftCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton SaveButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton CancelButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text5;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private DateChooser DateChooserControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private CheckBox ToggleShowYear;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text6;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ToggleSwitch ToggleShowBirthday;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox InputName;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text2;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox InputStatus;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text3;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock PhoneNumberText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text4;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ToggleSwitch ToggleShowPhoneNumber;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public bool IsToggleShowPhonenumberOn => ToggleShowPhoneNumber.IsOn;

	public bool IsToggleShowBirthdayOn => ToggleShowBirthday.IsOn;

	public bool IsToggleShowYear => ((ToggleButton)ToggleShowYear).IsChecked.Value;

	public EditProfilePage()
	{
		InitializeComponent();
		_viewModel = new EditProfilePageViewModel(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		InputName.put_Text(_viewModel.MyProfile.Name);
		InputStatus.put_Text(_viewModel.MyProfile.Status);
		ToggleShowBirthday.put_IsOn(_viewModel.MyProfile.BirthdayDisplayType != 2);
		((ToggleButton)ToggleShowYear).put_IsChecked((bool?)_viewModel.MyProfile.ShowYear);
		DateTime currentDate = DateTime.Today;
		if (_viewModel.MyProfile.Birthday.Ticks != 0)
		{
			currentDate = _viewModel.MyProfile.Birthday;
		}
		DateChooserControl.Load(currentDate);
		pageTitle.put_Text(Utility.GetResourceString("IDS_CHATON_HEADER_EDIT_PROFILE"));
		Text1.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_NAME"));
		Text2.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_STATUS_MESSAGE"));
		Text3.put_Text(Utility.GetResourceString("IDS_CHATON_ITAB_PHONE_NUMBER"));
		Text4.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_ALL_CHATON_USERS_CAN_SEE_YOUR_PHONE_NUMBER_INCLUDING_BUDDIES_WHO_HAVENT_SEEN_IT_BEFORE"));
		Text5.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_BIRTHDAY"));
		Text6.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_I_WOULD_LIKE_MY_BIRTHDAY_TO_BE_VISIBLE_TO_ALL_CHATON_USERS"));
		((ContentControl)ToggleShowYear).put_Content((object)Utility.GetResourceString("IDS_CHATON_BODY_SHOW_YEAR_ABB"));
		SaveButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON_SAVE");
		CancelButton.Text = Utility.GetResourceString("IDS_CHATON_OPT_CANCEL_ABB");
		ShowEnterStatusMessage();
	}

	private void EditProfilePage_Loaded(object sender, RoutedEventArgs e)
	{
		_ = CultureInfo.CurrentUICulture.TextInfo.CultureName;
	}

	private void ShowEnterStatusMessage()
	{
		//IL_0038: Unknown result type (might be due to invalid IL or missing references)
		//IL_0042: Expected O, but got Unknown
		if (string.IsNullOrWhiteSpace(_viewModel.MyProfile.Status))
		{
			InputStatus.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_ENTER_STATUS_MESSAGE"));
			((Control)InputStatus).put_Foreground((Brush)new SolidColorBrush(Colors.Gray));
		}
	}

	private void backButton_Click_1(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private void Save_Click(object sender, RoutedEventArgs e)
	{
		int bitrhdayParam = 2;
		if (IsToggleShowBirthdayOn && IsToggleShowYear)
		{
			bitrhdayParam = 0;
		}
		else if (IsToggleShowBirthdayOn)
		{
			bitrhdayParam = 1;
		}
		_viewModel.Save(InputName.Text.Trim(), InputStatus.Text.Trim(), DateChooserControl.SelectedDate, bitrhdayParam, IsToggleShowYear);
	}

	private void Cancel_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	public void ShowLoading(string text = "Loading...")
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot, text);
	}

	private void InputStatus_OnGotFocus(object sender, RoutedEventArgs e)
	{
		//IL_0031: Unknown result type (might be due to invalid IL or missing references)
		//IL_0051: Unknown result type (might be due to invalid IL or missing references)
		//IL_005b: Expected O, but got Unknown
		Brush foreground = ((Control)InputStatus).Foreground;
		if (((SolidColorBrush)((foreground is SolidColorBrush) ? foreground : null)).Color == Colors.Gray)
		{
			InputStatus.put_Text("");
			new AccessibilitySettings();
			((Control)InputStatus).put_Foreground((Brush)((IDictionary<object, object>)Application.Current.Resources)[(object)"TextBoxForegroundThemeBrush"]);
		}
		_isFocused = true;
	}

	private void InputStatus_OnLostFocus(object sender, RoutedEventArgs e)
	{
		_isFocused = false;
		if (string.IsNullOrEmpty(InputStatus.Text))
		{
			ShowEnterStatusMessage();
		}
	}

	private void ToggleShowBirthday_OnToggled(object sender, RoutedEventArgs e)
	{
		RegistrationService.GetUserProfile();
		_viewModel.SaveShowBirthday(ToggleShowBirthday.IsOn);
	}

	private void InputStatus_TextChanged(object sender, TextChangedEventArgs e)
	{
		try
		{
			string text = ((TextBox)((sender is TextBox) ? sender : null)).Text;
			if (Utility.IsEmojiIconIncluded(text))
			{
				((TextBox)((sender is TextBox) ? sender : null)).put_Text(Utility.RemoveEmoji(text));
				((TextBox)((sender is TextBox) ? sender : null)).Select(((TextBox)((sender is TextBox) ? sender : null)).Text.Length, 0);
			}
		}
		catch (Exception)
		{
		}
	}

	private void InputName_TextChanged(object sender, TextChangedEventArgs e)
	{
		InputName.put_Text(Regex.Replace(InputName.Text, "(?:\\r\\n|\\r(?!\\n)|(?!<\\r)\\n){1,}", " "));
		if (string.IsNullOrEmpty(InputName.Text.Trim()))
		{
			((Control)SaveButton).put_IsEnabled(false);
			SaveButton.Text = string.Empty;
		}
		else
		{
			((Control)SaveButton).put_IsEnabled(true);
			SaveButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON_SAVE");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
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
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
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
		//IL_01a3: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ad: Expected O, but got Unknown
		//IL_01b9: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c3: Expected O, but got Unknown
		//IL_01cf: Unknown result type (might be due to invalid IL or missing references)
		//IL_01d9: Expected O, but got Unknown
		//IL_01e5: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ef: Expected O, but got Unknown
		//IL_01fb: Unknown result type (might be due to invalid IL or missing references)
		//IL_0205: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///EditProfilePage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			LeftCommands = (StackPanel)((FrameworkElement)this).FindName("LeftCommands");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			SaveButton = (ImageButton)((FrameworkElement)this).FindName("SaveButton");
			CancelButton = (ImageButton)((FrameworkElement)this).FindName("CancelButton");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			Text5 = (TextBlock)((FrameworkElement)this).FindName("Text5");
			DateChooserControl = (DateChooser)((FrameworkElement)this).FindName("DateChooserControl");
			ToggleShowYear = (CheckBox)((FrameworkElement)this).FindName("ToggleShowYear");
			Text6 = (TextBlock)((FrameworkElement)this).FindName("Text6");
			ToggleShowBirthday = (ToggleSwitch)((FrameworkElement)this).FindName("ToggleShowBirthday");
			Text1 = (TextBlock)((FrameworkElement)this).FindName("Text1");
			InputName = (TextBox)((FrameworkElement)this).FindName("InputName");
			Text2 = (TextBlock)((FrameworkElement)this).FindName("Text2");
			InputStatus = (TextBox)((FrameworkElement)this).FindName("InputStatus");
			Text3 = (TextBlock)((FrameworkElement)this).FindName("Text3");
			PhoneNumberText = (TextBlock)((FrameworkElement)this).FindName("PhoneNumberText");
			Text4 = (TextBlock)((FrameworkElement)this).FindName("Text4");
			ToggleShowPhoneNumber = (ToggleSwitch)((FrameworkElement)this).FindName("ToggleShowPhoneNumber");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0032: Expected O, but got Unknown
		//IL_0051: Unknown result type (might be due to invalid IL or missing references)
		//IL_005b: Expected O, but got Unknown
		//IL_006d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0077: Expected O, but got Unknown
		//IL_0089: Unknown result type (might be due to invalid IL or missing references)
		//IL_0093: Expected O, but got Unknown
		//IL_0099: Unknown result type (might be due to invalid IL or missing references)
		//IL_009f: Expected O, but got Unknown
		//IL_00be: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c8: Expected O, but got Unknown
		//IL_00ce: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d4: Expected O, but got Unknown
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		//IL_0103: Unknown result type (might be due to invalid IL or missing references)
		//IL_010a: Expected O, but got Unknown
		//IL_012b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0135: Expected O, but got Unknown
		//IL_0136: Unknown result type (might be due to invalid IL or missing references)
		//IL_013d: Expected O, but got Unknown
		//IL_015e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0168: Expected O, but got Unknown
		//IL_0169: Unknown result type (might be due to invalid IL or missing references)
		//IL_0170: Expected O, but got Unknown
		//IL_0191: Unknown result type (might be due to invalid IL or missing references)
		//IL_019b: Expected O, but got Unknown
		//IL_019e: Unknown result type (might be due to invalid IL or missing references)
		//IL_01a5: Expected O, but got Unknown
		//IL_01c6: Unknown result type (might be due to invalid IL or missing references)
		//IL_01d0: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val7 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(EditProfilePage_Loaded));
			break;
		}
		case 2:
			((ImageButton)target).Click += new RoutedEventHandler(Save_Click);
			break;
		case 3:
			((ImageButton)target).Click += new RoutedEventHandler(Cancel_Click);
			break;
		case 4:
		{
			ToggleSwitch val6 = (ToggleSwitch)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(ToggleSwitch.add_Toggled)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(ToggleSwitch.remove_Toggled)), new RoutedEventHandler(ToggleShowBirthday_OnToggled));
			break;
		}
		case 5:
		{
			TextBox val5 = (TextBox)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TextChangedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(TextBox.add_TextChanged)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(TextBox.remove_TextChanged)), new TextChangedEventHandler(InputName_TextChanged));
			break;
		}
		case 6:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_GotFocus)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_GotFocus)), new RoutedEventHandler(InputStatus_OnGotFocus));
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_LostFocus)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_LostFocus)), new RoutedEventHandler(InputStatus_OnLostFocus));
			TextBox val4 = (TextBox)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TextChangedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(TextBox.add_TextChanged)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(TextBox.remove_TextChanged)), new TextChangedEventHandler(InputStatus_TextChanged));
			break;
		}
		case 7:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
