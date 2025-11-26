using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.InfraStructure;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.InfraStructure;
using ChatOn.Services;
using Windows.Storage;
using Windows.System;
using Windows.UI;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class GeneralSettingPage : Page, IComponentConnector
{
	private SSMService _ssmService;

	private DataService _dataService;

	private BuddyService _buddyService;

	private IndeterminateProgressbar _progressControl = new IndeterminateProgressbar();

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtChatOnAccount;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button DeleteBtn;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public GeneralSettingPage()
	{
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)PivotPage.ActiveInstance.ViewModel);
		_ssmService = new SSMService();
		_ssmService.DeRegisterUserCompleted += _ssmService_DeRegisterUserCompleted;
		if (!string.IsNullOrEmpty(PivotPage.ActiveInstance.ViewModel.MyProfile.Email))
		{
			((ContentControl)DeleteBtn).put_Content((object)Utility.GetResourceString("IDS_CHATON_HEADER_DEREGISTER_DEVICE"));
		}
		else
		{
			((ContentControl)DeleteBtn).put_Content((object)Utility.GetResourceString("IDS_CHATON_BUTTON2_DELETE_ACCOUNT"));
		}
		txtChatOnAccount.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_CHATON_ACCOUNT_C_PS").Replace("%s", ""));
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		SettingsPage.ActiveInstance.StopLoading();
		((Page)this).OnNavigatedFrom(e);
	}

	private async void _ssmService_DeRegisterUserCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		try
		{
			bool isInvalidUser = false;
			if (!string.IsNullOrEmpty(e.ErrorMessage) && (e.ErrorMessage.Contains("CCS-00012") || e.ErrorMessage.Contains("CCS-00011")))
			{
				await SSMService.ShowCommonErrorMessage(e);
				isInvalidUser = true;
			}
			else if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("CCS-00013"))
			{
				await Utility.ShowCloseMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_THIS_DEVICE_WAS_RESET_OVER_THE_WEB_REGISTER_IT_AGAIN_TO_USE_IT"));
				isInvalidUser = true;
			}
			if (e.StatusCode == HttpStatusCode.OK || isInvalidUser)
			{
				Utility.UpdateMainTileCount(0);
				try
				{
					await ApplicationData.Current.ClearAsync((ApplicationDataLocality)0);
				}
				catch (Exception)
				{
				}
				try
				{
					string oldGuid = await Utility.GetDeviceUniqueID();
					StorageFolder folder = ApplicationData.Current.LocalFolder;
					FileIOHelper.WriteToFiles(await (await folder.CreateFolderAsync("ChatON", (CreationCollisionOption)3)).CreateFileAsync("guid.txt", (CreationCollisionOption)3), oldGuid);
				}
				catch (Exception)
				{
				}
				MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_APPLICATION_WILL_BE_CLOSED"));
				await dialog.ShowAsync();
				Application.Current.Exit();
			}
			else
			{
				await SSMService.ShowCommonErrorMessage(e);
			}
		}
		catch (Exception)
		{
		}
	}

	private void TextBlock_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		string languageParam = Utility.GetLanguageParam();
		string uriString = "http://smm.samsung.com/mwv/notice.html?l=" + languageParam + "&p=windows%20mobile";
		Launcher.LaunchUriAsync(new Uri(uriString));
	}

	private void TextBlock_Tapped_2(object sender, TappedRoutedEventArgs e)
	{
		string languageParam = Utility.GetLanguageParam();
		string uriString = "http://www.chaton.com/mwv/faq.html?l=" + languageParam + "&p=windows%20mobile";
		Launcher.LaunchUriAsync(new Uri(uriString));
	}

	private void TextBlock_Tapped_3(object sender, TappedRoutedEventArgs e)
	{
		Utility.OpenContactUs();
	}

	private async void Deregister_Clicked(object sender, RoutedEventArgs e)
	{
		PopupControl popupControl = new PopupControl();
		((FrameworkElement)popupControl).put_HorizontalAlignment((HorizontalAlignment)2);
		((FrameworkElement)popupControl).put_VerticalAlignment((VerticalAlignment)1);
		((FrameworkElement)popupControl).put_Margin(new Thickness(0.0, 0.0, 100.0, 0.0));
		((FrameworkElement)popupControl).put_Width(450.0);
		((FrameworkElement)popupControl).put_Height(210.0);
		popupControl.OKButtonText = Utility.GetResourceString("IDS_CHATON_BUTTON2_DELETE");
		popupControl.CancelButtonText = Utility.GetResourceString("IDS_CHATON_BUTTON_CANCEL");
		popupControl.ShowCancel = true;
		popupControl.CancelButtonBackground = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 244, 244, 244));
		popupControl.CancelButtonForeground = new SolidColorBrush(Colors.Black);
		popupControl.DetailText = Utility.GetResourceString("IDS_CHATON_BODY_ALL_YOUR_CHATON_DATA_WILL_BE_DELETED_FROM_THIS_DEVICE_HOWEVER_YOU_CAN_RESTORE_ALL_YOUR_BUDDIES_NOTI_MSG");
		popupControl.TitleText = Utility.GetResourceString("IDS_CHATON_BODY_DELETE_ACCOUNT");
		popupControl.ChatOnPopupCompleted += ChatOn_PopupCompleted;
		SettingsPage.ActiveInstance.OpenDialog((UserControl)(object)popupControl);
	}

	private async void ChatOn_PopupCompleted(object sender, object e)
	{
		PopupControl popupControl;
		PopupControl popup = (popupControl = sender as PopupControl);
		if (popupControl != null)
		{
			popup.ChatOnPopupCompleted -= ChatOn_PopupCompleted;
			if ((bool)e)
			{
				SettingsPage.ActiveInstance.ShowLoading();
				await Utility.ClearTileInformation();
				await Utility.DeleteAllTile();
				await _ssmService.DeRegisterUserAsync();
			}
		}
	}

	public void ShowProgress()
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			_progressControl.Show((Panel)(object)LayoutRoot);
		});
	}

	public void HideProgress()
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			_progressControl.Hide();
		});
	}

	private void SyncBuddy_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (string.IsNullOrEmpty(RegistrationService.GetUserAccount().MSISDN))
		{
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(InputPhoneNumberPage));
			return;
		}
		ShowProgress();
		PivotPage.ActiveInstance.ViewModel.GetBuddyCompleted += ViewModel_GetBuddyCompleted;
		PivotPage.ActiveInstance.ViewModel.GetBuddyList();
	}

	private void ViewModel_GetBuddyCompleted(object sender, object e)
	{
		PivotPage.ActiveInstance.ViewModel.GetBuddyCompleted -= ViewModel_GetBuddyCompleted;
		HideProgress();
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///GeneralSettingPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			txtChatOnAccount = (TextBlock)((FrameworkElement)this).FindName("txtChatOnAccount");
			DeleteBtn = (Button)((FrameworkElement)this).FindName("DeleteBtn");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Expected O, but got Unknown
		//IL_0045: Unknown result type (might be due to invalid IL or missing references)
		//IL_004f: Expected O, but got Unknown
		//IL_0055: Unknown result type (might be due to invalid IL or missing references)
		//IL_005b: Expected O, but got Unknown
		//IL_007a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0084: Expected O, but got Unknown
		//IL_0087: Unknown result type (might be due to invalid IL or missing references)
		//IL_008d: Expected O, but got Unknown
		//IL_00ac: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b6: Expected O, but got Unknown
		//IL_00b9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c0: Expected O, but got Unknown
		//IL_00e1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00eb: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(TextBlock_Tapped_2));
			break;
		}
		case 2:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(TextBlock_Tapped_3));
			break;
		}
		case 3:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Deregister_Clicked));
			break;
		}
		case 4:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(TextBlock_Tapped_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
