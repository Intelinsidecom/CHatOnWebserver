using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.Storage;
using Windows.UI;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class InputPasswordPage : Page, IComponentConnector
{
	private static InputPasswordPage _activeInstance;

	private int _count;

	private bool _isActivated;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock ErrorMessage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock HintMessage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel DeleteAccountPanel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button btnDelete;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private PasswordBox PasswordControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static InputPasswordPage ActiveInstance => _activeInstance;

	public InputPasswordPage()
	{
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)this);
	}

	private void InputPasswordPage_Loaded(object sender, RoutedEventArgs e)
	{
		((Control)PasswordControl).Focus((FocusState)2);
		OnSizeChanged();
	}

	private void Image_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		CheckPassword();
	}

	private void CheckPassword()
	{
		if (SettingService.GetPassword() != PasswordControl.Password)
		{
			_count++;
			if (_count >= 5)
			{
				HintMessage.put_Text(Utility.GetResourceString("IDS_CHATON_MBODY_PASSWORD_HINT") + ":" + SettingService.GetPasswordHint());
				ErrorMessage.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_IF_YOU_HAVE_FORGOTTEN_YOUR_PASSWORD_YOU_NEED_TO_DELETE_YOUR_CHATON_ACCOUNT_ALL_DATA_WILL_BE_DELETED_ABB"));
				((UIElement)btnDelete).put_Visibility((Visibility)0);
				((UIElement)DeleteAccountPanel).put_Visibility((Visibility)0);
			}
			else
			{
				ErrorMessage.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_INCORRECT_PASSWORD_TRY_AGAIN"));
			}
		}
		else
		{
			if (!_isActivated)
			{
				SettingService.SetCheckPassword(value: false);
			}
			((Page)this).Frame.GoBack();
			if (_isActivated && PivotPage.ActiveInstance != null)
			{
				PivotPage.ActiveInstance.UpdateView();
			}
		}
	}

	private void Current_SizeChanged(object sender, WindowSizeChangedEventArgs e)
	{
		OnSizeChanged();
	}

	private void OnSizeChanged()
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		if ((int)ApplicationView.Value == 2)
		{
			Grid.SetRow((FrameworkElement)(object)ErrorMessage, 3);
			((FrameworkElement)ErrorMessage).put_Margin(new Thickness(110.0, 30.0, 0.0, 0.0));
			Grid.SetRow((FrameworkElement)(object)DeleteAccountPanel, 4);
			((FrameworkElement)DeleteAccountPanel).put_Margin(new Thickness(110.0, 0.0, 0.0, 0.0));
			((FrameworkElement)PasswordControl).put_Width(200.0);
		}
		else
		{
			Grid.SetRow((FrameworkElement)(object)ErrorMessage, 1);
			((FrameworkElement)ErrorMessage).put_Margin(new Thickness(430.0, 0.0, 0.0, 0.0));
			Grid.SetRow((FrameworkElement)(object)DeleteAccountPanel, 2);
			((FrameworkElement)DeleteAccountPanel).put_Margin(new Thickness(500.0, 0.0, 0.0, 0.0));
			((FrameworkElement)PasswordControl).put_Width(300.0);
		}
	}

	protected unsafe override void OnNavigatedTo(NavigationEventArgs e)
	{
		//IL_0025: Unknown result type (might be due to invalid IL or missing references)
		//IL_002f: Expected O, but got Unknown
		//IL_0044: Unknown result type (might be due to invalid IL or missing references)
		//IL_004a: Invalid comparison between Unknown and I4
		Window current = Window.Current;
		WindowsRuntimeMarshal.AddEventHandler(new Func<WindowSizeChangedEventHandler, EventRegistrationToken>(current, (nint)__ldftn(Window.add_SizeChanged)), new Action<EventRegistrationToken>(current, (nint)__ldftn(Window.remove_SizeChanged)), new WindowSizeChangedEventHandler(Current_SizeChanged));
		string text = e.Parameter as string;
		if (!string.IsNullOrEmpty(text) && (int)e.NavigationMode != 1 && text == "Activated")
		{
			_isActivated = true;
			PasswordControl.put_Password("");
		}
		((UIElement)DeleteAccountPanel).put_Visibility((Visibility)0);
	}

	protected unsafe override void OnNavigatedFrom(NavigationEventArgs e)
	{
		//IL_0017: Unknown result type (might be due to invalid IL or missing references)
		//IL_0021: Expected O, but got Unknown
		WindowsRuntimeMarshal.RemoveEventHandler<WindowSizeChangedEventHandler>(new Action<EventRegistrationToken>(Window.Current, (nint)__ldftn(Window.remove_SizeChanged)), new WindowSizeChangedEventHandler(Current_SizeChanged));
	}

	private void PasswordControl_KeyUp_1(object sender, KeyRoutedEventArgs e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0008: Invalid comparison between Unknown and I4
		if ((int)e.Key == 13)
		{
			CheckPassword();
		}
	}

	internal void ShowLoading()
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
	}

	private async void Button_Click_1(object sender, RoutedEventArgs e)
	{
		UserProfile userProfile = RegistrationService.GetUserProfile();
		string text = Utility.GetResourceString("IDS_CHATON_POP_ALL_YOUR_CHATON_DATA_WILL_BE_DELETED") + "\n\n";
		if (!string.IsNullOrEmpty(userProfile.PhoneNumber))
		{
			text += Utility.GetResourceString("IDS_CHATON_BODY_CHATON_ACCOUNT_C_PS").Replace("%s", "\n" + userProfile.PhoneNumber);
		}
		PopupControl popupControl = new PopupControl();
		((FrameworkElement)popupControl).put_HorizontalAlignment((HorizontalAlignment)1);
		((FrameworkElement)popupControl).put_VerticalAlignment((VerticalAlignment)1);
		((FrameworkElement)popupControl).put_Margin(new Thickness(0.0, 0.0, 0.0, 0.0));
		((FrameworkElement)popupControl).put_Width(450.0);
		((FrameworkElement)popupControl).put_Height(210.0);
		popupControl.OKButtonText = Utility.GetResourceString("IDS_CHATON_BUTTON2_DELETE");
		popupControl.CancelButtonText = Utility.GetResourceString("IDS_CHATON_BUTTON_CANCEL");
		popupControl.ShowCancel = true;
		popupControl.CancelButtonBackground = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 244, 244, 244));
		popupControl.CancelButtonForeground = new SolidColorBrush(Colors.Black);
		popupControl.DetailText = text;
		popupControl.TitleText = Utility.GetResourceString("IDS_CHATON_BODY_DELETE_ACCOUNT");
		popupControl.ChatOnPopupCompleted += ChatOn_PopupCompleted;
		OpenDialog((UserControl)(object)popupControl);
	}

	internal void OpenDialog(UserControl dialog, EventHandler closedEventHandler = null)
	{
		CustomPopup customPopup = new CustomPopup((Page)(object)this, (Panel)(object)LayoutRoot, (FrameworkElement)(object)dialog);
		if (closedEventHandler != null)
		{
			customPopup.Closed += closedEventHandler;
		}
	}

	private async void ChatOn_PopupCompleted(object sender, object e)
	{
		if (sender is PopupControl popupControl)
		{
			popupControl.ChatOnPopupCompleted -= ChatOn_PopupCompleted;
			if ((bool)e)
			{
				ShowLoading();
				SSMService sSMService = new SSMService();
				sSMService.DeRegisterUserCompleted += ssmService_DeRegisterUserCompleted;
				sSMService.DeRegisterUserAsync();
			}
		}
	}

	private async void ssmService_DeRegisterUserCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		bool isInvalidUser = false;
		if (!string.IsNullOrEmpty(e.ErrorMessage) && (e.ErrorMessage.Contains("CCS-00012") || e.ErrorMessage.Contains("CCS-00011")))
		{
			await SSMService.ShowCommonErrorMessage(e);
			isInvalidUser = true;
		}
		if (e.StatusCode == HttpStatusCode.OK || isInvalidUser)
		{
			Utility.UpdateMainTileCount(0);
			await Utility.ClearTileInformation();
			await ApplicationData.Current.ClearAsync();
			MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_APPLICATION_WILL_BE_CLOSED"));
			await dialog.ShowAsync();
			Application.Current.Exit();
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
	}

	private void Button_Click_2(object sender, RoutedEventArgs e)
	{
		CheckPassword();
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
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///InputPasswordPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			ErrorMessage = (TextBlock)((FrameworkElement)this).FindName("ErrorMessage");
			HintMessage = (TextBlock)((FrameworkElement)this).FindName("HintMessage");
			DeleteAccountPanel = (StackPanel)((FrameworkElement)this).FindName("DeleteAccountPanel");
			btnDelete = (Button)((FrameworkElement)this).FindName("btnDelete");
			PasswordControl = (PasswordBox)((FrameworkElement)this).FindName("PasswordControl");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0024: Unknown result type (might be due to invalid IL or missing references)
		//IL_002a: Expected O, but got Unknown
		//IL_0049: Unknown result type (might be due to invalid IL or missing references)
		//IL_0053: Expected O, but got Unknown
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_005f: Expected O, but got Unknown
		//IL_007e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0088: Expected O, but got Unknown
		//IL_008e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0094: Expected O, but got Unknown
		//IL_00b3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bd: Expected O, but got Unknown
		//IL_00c0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c7: Expected O, but got Unknown
		//IL_00e8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f2: Expected O, but got Unknown
		//IL_00f5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fc: Expected O, but got Unknown
		//IL_011d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0127: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val5 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(InputPasswordPage_Loaded));
			break;
		}
		case 2:
		{
			ButtonBase val4 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Button_Click_2));
			break;
		}
		case 3:
		{
			ButtonBase val3 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Button_Click_1));
			break;
		}
		case 4:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<KeyEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_KeyUp)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_KeyUp)), new KeyEventHandler(PasswordControl_KeyUp_1));
			break;
		}
		case 5:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
