using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.ViewModels;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class SettingsPage : Page, IComponentConnector
{
	private static SettingsPage _activeInstance;

	private SettingsPageViewModel _viewModel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Frame Current;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Frame PopupFrame;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView SelectMenu;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock ConnectedDevice;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock ManageAccount;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock DownloadSetting;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock GeneralSetting;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock NotificationSetting;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock PrivacySetting;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock ChatSetting;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock BuddySetting;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static SettingsPage ActiveInstance => _activeInstance;

	public SettingsPage()
	{
		InitializeComponent();
		_activeInstance = this;
		_viewModel = new SettingsPageViewModel(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		Current.Navigate(typeof(ManageBuddiesPage));
		_viewModel.SelectedIndex = 1;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_001b: Invalid comparison between Unknown and I4
		string text = e.Parameter as string;
		if (!string.IsNullOrEmpty(text) && (int)e.NavigationMode != 1)
		{
			if (text == "Download")
			{
				OnTabSetting(DownloadSetting);
				Current.Navigate(typeof(DownloadSettingPage));
			}
			else if (text == "Manage Account")
			{
				OnTabSetting(ManageAccount);
				Current.Navigate(typeof(ManageAccountPage));
			}
		}
		if (PivotPage.ActiveInstance != null)
		{
			PivotPage.ActiveInstance.ViewModel.CheckNotice();
		}
		((Selector)SelectMenu).put_SelectedIndex(_viewModel.SelectedIndex - 1);
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
	}

	private void TextBlock_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		OnTabSetting(sender);
		Current.Navigate(typeof(AboutPage));
	}

	private void TextBlock_Tapped_2(object sender, TappedRoutedEventArgs e)
	{
		OnTabSetting(sender);
		Current.Navigate(typeof(ManageBuddiesPage));
	}

	private void TextBlock_Tapped_3(object sender, TappedRoutedEventArgs e)
	{
		OnTabSetting(sender);
		Current.Navigate(typeof(PrivacyPage));
	}

	private void OnTabSetting(object sender)
	{
		string s = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).Tag as string;
		int selectedIndex = int.Parse(s);
		_viewModel.SelectedIndex = selectedIndex;
	}

	internal void ShowBlockListPage()
	{
		((UIElement)PopupFrame).put_Visibility((Visibility)0);
		PopupFrame.Navigate(typeof(BlockListPage));
	}

	internal void ShowHiddenInteractionPage()
	{
		((UIElement)PopupFrame).put_Visibility((Visibility)0);
		PopupFrame.Navigate(typeof(HiddenInteractionPage));
	}

	internal void ShowBlindListPage()
	{
		((UIElement)PopupFrame).put_Visibility((Visibility)0);
		PopupFrame.Navigate(typeof(BlindListPage));
	}

	internal void ClosePopup()
	{
		((UIElement)PopupFrame).put_Visibility((Visibility)1);
	}

	private void GeneralSetting_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		OnTabSetting(sender);
		Current.Navigate(typeof(GeneralSettingPage));
	}

	private void ChatSetting_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		OnTabSetting(sender);
		Current.Navigate(typeof(ChatSettingPage));
	}

	internal void OpenDialog(UserControl dialog, EventHandler closedEventHandler = null)
	{
		CustomPopup customPopup = new CustomPopup((Page)(object)this, (Panel)(object)LayoutRoot, (FrameworkElement)(object)dialog);
		if (closedEventHandler != null)
		{
			customPopup.Closed += closedEventHandler;
		}
	}

	private void DownloadSetting_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		OnTabSetting(sender);
		Current.Navigate(typeof(DownloadSettingPage));
	}

	private void NotificationSetting_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		OnTabSetting(sender);
		Current.Navigate(typeof(NotificationSettingPage));
	}

	internal void ShowLoading()
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
	}

	internal void StopLoading()
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
	}

	private void backButton_Click_1(object sender, RoutedEventArgs e)
	{
		while ((object)((Page)this).Frame.CurrentSourcePageType == typeof(SearchBuddyPage) || (object)((Page)this).Frame.CurrentSourcePageType == typeof(SelectBuddyPage) || (object)((Page)this).Frame.CurrentSourcePageType == typeof(SettingsPage))
		{
			Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
		}
	}

	internal void OpenConnectedDeviceItem()
	{
		OnTabSetting(ConnectedDevice);
		Current.Navigate(typeof(MultiDeviceInfoPage));
	}

	internal void OpenSamsungAccountItem()
	{
	}

	internal void OpenManageAccountItem()
	{
		OnTabSetting(ManageAccount);
		Current.Navigate(typeof(ManageAccountPage));
	}

	private void ConnectedSetting_Tapped(object sender, TappedRoutedEventArgs e)
	{
		OpenConnectedDeviceItem();
	}

	private void SamsungAccountSetting_Tapped(object sender, TappedRoutedEventArgs e)
	{
		OpenSamsungAccountItem();
	}

	private void ManageAccountSetting_Tapped(object sender, TappedRoutedEventArgs e)
	{
		OpenManageAccountItem();
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
		//IL_0161: Unknown result type (might be due to invalid IL or missing references)
		//IL_016b: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SettingsPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			Current = (Frame)((FrameworkElement)this).FindName("Current");
			PopupFrame = (Frame)((FrameworkElement)this).FindName("PopupFrame");
			SelectMenu = (ListView)((FrameworkElement)this).FindName("SelectMenu");
			ConnectedDevice = (TextBlock)((FrameworkElement)this).FindName("ConnectedDevice");
			ManageAccount = (TextBlock)((FrameworkElement)this).FindName("ManageAccount");
			DownloadSetting = (TextBlock)((FrameworkElement)this).FindName("DownloadSetting");
			GeneralSetting = (TextBlock)((FrameworkElement)this).FindName("GeneralSetting");
			NotificationSetting = (TextBlock)((FrameworkElement)this).FindName("NotificationSetting");
			PrivacySetting = (TextBlock)((FrameworkElement)this).FindName("PrivacySetting");
			ChatSetting = (TextBlock)((FrameworkElement)this).FindName("ChatSetting");
			BuddySetting = (TextBlock)((FrameworkElement)this).FindName("BuddySetting");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
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
			UIElement val10 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(TextBlock_Tapped_2));
			break;
		}
		case 2:
		{
			UIElement val9 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ChatSetting_Tapped_1));
			break;
		}
		case 3:
		{
			UIElement val8 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(TextBlock_Tapped_3));
			break;
		}
		case 4:
		{
			UIElement val7 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(NotificationSetting_Tapped_1));
			break;
		}
		case 5:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(GeneralSetting_Tapped_1));
			break;
		}
		case 6:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(DownloadSetting_Tapped_1));
			break;
		}
		case 7:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ManageAccountSetting_Tapped));
			break;
		}
		case 8:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ConnectedSetting_Tapped));
			break;
		}
		case 9:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(DownloadSetting_Tapped_1));
			break;
		}
		case 10:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
