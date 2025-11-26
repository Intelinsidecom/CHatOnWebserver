using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class NotificationSettingPage : Page, IComponentConnector
{
	private SSMService _ssmService;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ToggleSwitch TogglePush;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ToggleSwitch ToggleNewUpdates;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ToggleSwitch TogglePushMarketing;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public unsafe NotificationSettingPage()
	{
		//IL_004d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0057: Expected O, but got Unknown
		//IL_009d: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a7: Expected O, but got Unknown
		//IL_00dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Expected O, but got Unknown
		InitializeComponent();
		_ssmService = new SSMService();
		TogglePush.put_IsOn(SettingService.IsUsingPushNotification());
		ToggleSwitch togglePush = TogglePush;
		WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(togglePush, (nint)__ldftn(ToggleSwitch.add_Toggled)), new Action<EventRegistrationToken>(togglePush, (nint)__ldftn(ToggleSwitch.remove_Toggled)), new RoutedEventHandler(TogglePush_Toggled));
		((Control)ToggleNewUpdates).put_IsEnabled(SettingService.IsToggleNewUpdatesPushNotificationEnable());
		ToggleNewUpdates.put_IsOn(SettingService.IsUsingNewUpdatesPushNotification());
		ToggleSwitch toggleNewUpdates = ToggleNewUpdates;
		WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(toggleNewUpdates, (nint)__ldftn(ToggleSwitch.add_Toggled)), new Action<EventRegistrationToken>(toggleNewUpdates, (nint)__ldftn(ToggleSwitch.remove_Toggled)), new RoutedEventHandler(ToggleNewUpdates_Toggled));
		((Control)TogglePushMarketing).put_IsEnabled(SettingService.IsTogglePushMarketingNotificationEnable());
		ToggleSwitch togglePushMarketing = TogglePushMarketing;
		WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(togglePushMarketing, (nint)__ldftn(ToggleSwitch.add_Toggled)), new Action<EventRegistrationToken>(togglePushMarketing, (nint)__ldftn(ToggleSwitch.remove_Toggled)), new RoutedEventHandler(TogglePushPushMarketing_Toggled));
		SettingsPage.ActiveInstance.ShowLoading();
		_ssmService.GetUserPrivacyCompleted += _ssmService_GetUserPrivacyCompleted;
		_ssmService.GetUserPrivacyAsync("pushmarketing");
	}

	private void _ssmService_GetUserPrivacyCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ssmService.GetUserPrivacyCompleted -= _ssmService_GetUserPrivacyCompleted;
		LoadingIndicator.StopLoading();
		if (e.Xml != null)
		{
			bool flag = true;
			if (e.Xml.Element("value") != null)
			{
				flag = bool.Parse(e.Xml.Element("value").Value);
			}
			TogglePushMarketing.put_IsOn(flag);
		}
		else
		{
			TogglePushMarketing.put_IsOn(SettingService.IsUsingPushMarketingNotification());
		}
	}

	private void ToggleNewUpdates_Toggled(object sender, RoutedEventArgs e)
	{
		ToggleSwitch val = (ToggleSwitch)((sender is ToggleSwitch) ? sender : null);
		SettingsPage.ActiveInstance.ShowLoading();
		if (val.IsOn)
		{
			_ssmService.GetPushUpdateCompleted += _ssmService_GetPushUpdateCompleted;
			_ssmService.GetPushUpdates(isActive: true);
		}
		else
		{
			_ssmService.GetPushUpdateCompleted += _ssmService_GetPushUpdateCompleted;
			_ssmService.GetPushUpdates(isActive: false);
		}
	}

	private async void _ssmService_GetPushUpdateCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ssmService.GetPushUpdateCompleted -= _ssmService_GetPushUpdateCompleted;
		SettingsPage.ActiveInstance.StopLoading();
		if (e.StatusCode == HttpStatusCode.NoContent)
		{
			return;
		}
		if (e.StatusCode == HttpStatusCode.OK)
		{
			if (e.ResultString == "true")
			{
				ToggleNewUpdates.put_IsOn(true);
				SettingService.SetUsingNewUpdatesPushNotification(isUsed: true);
			}
			else
			{
				ToggleNewUpdates.put_IsOn(false);
				SettingService.SetUsingNewUpdatesPushNotification(isUsed: false);
			}
		}
		else if (e.Error != null)
		{
			ToggleNewUpdates.put_IsOn(SettingService.IsUsingNewUpdatesPushNotification());
			await SSMService.ShowCommonErrorMessage(e);
		}
	}

	private void TogglePushPushMarketing_Toggled(object sender, RoutedEventArgs e)
	{
		ToggleSwitch val = (ToggleSwitch)((sender is ToggleSwitch) ? sender : null);
		SettingsPage.ActiveInstance.ShowLoading();
		if (val.IsOn)
		{
			_ssmService.SetUserPrivacyCompleted += _ssmService_SetUserPrivacyTrueCompleted;
			_ssmService.SetUserPrivacyAsync(value: true, "pushmarketing");
		}
		else
		{
			_ssmService.SetUserPrivacyCompleted += _ssmService_SetUserPrivacyFalseCompleted;
			_ssmService.SetUserPrivacyAsync(value: false, "pushmarketing");
		}
	}

	private async void _ssmService_SetUserPrivacyTrueCompleted(object sender, SSMCompletedEventArgs e2)
	{
		_ssmService.SetUserPrivacyCompleted -= _ssmService_SetUserPrivacyTrueCompleted;
		SettingsPage.ActiveInstance.StopLoading();
		if (e2.StatusCode != HttpStatusCode.NoContent)
		{
			if (e2.StatusCode == HttpStatusCode.OK)
			{
				TogglePushMarketing.put_IsOn(true);
				SettingService.SetUsingPushMarketingNotification(isUsed: true);
			}
			else if (e2.Error != null)
			{
				TogglePushMarketing.put_IsOn(SettingService.IsUsingPushMarketingNotification());
				await SSMService.ShowCommonErrorMessage(e2);
			}
		}
	}

	private async void _ssmService_SetUserPrivacyFalseCompleted(object sender, SSMCompletedEventArgs e2)
	{
		_ssmService.SetUserPrivacyCompleted -= _ssmService_SetUserPrivacyFalseCompleted;
		SettingsPage.ActiveInstance.StopLoading();
		if (e2.StatusCode != HttpStatusCode.NoContent)
		{
			if (e2.StatusCode == HttpStatusCode.OK)
			{
				TogglePushMarketing.put_IsOn(false);
				SettingService.SetUsingPushMarketingNotification(isUsed: false);
			}
			else if (e2.Error != null)
			{
				TogglePushMarketing.put_IsOn(SettingService.IsUsingPushMarketingNotification());
				await SSMService.ShowCommonErrorMessage(e2);
			}
		}
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		SettingsPage.ActiveInstance.StopLoading();
		((Page)this).OnNavigatedFrom(e);
	}

	private async void TogglePush_Toggled(object sender, RoutedEventArgs e)
	{
		ToggleSwitch togglePush = (ToggleSwitch)((sender is ToggleSwitch) ? sender : null);
		if (togglePush.IsOn)
		{
			SettingsPage.ActiveInstance.ShowLoading();
			bool result = await PushService.Instance.InitService();
			if (result)
			{
				SSMService sSMService = new SSMService();
				sSMService.GetVersionCompleted += ssmService_GetVersionCompleted;
				sSMService.GetVersionAsync(forceUpdate: true);
			}
			else
			{
				LoadingIndicator.StopLoading();
				MessageDialog dialog = new MessageDialog(Utility.GetResourceString("WP7_CHATON_POP_CANNOT_FIND_PUSH"), Utility.GetResourceString("IDS_CHATON_BODY_PUSH_NOTIFICATIONS"));
				await dialog.ShowAsync();
				togglePush.put_IsOn(result);
			}
		}
		else
		{
			PushService.Instance.StopService();
			((Control)ToggleNewUpdates).put_IsEnabled(false);
			((Control)TogglePushMarketing).put_IsEnabled(false);
		}
	}

	private void ssmService_GetVersionCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_004f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0055: Expected O, but got Unknown
		DispatchedHandler val = null;
		(sender as SSMService).GetVersionCompleted -= ssmService_GetVersionCompleted;
		LoadingIndicator.StopLoading();
		((Control)ToggleNewUpdates).put_IsEnabled(true);
		((Control)TogglePushMarketing).put_IsEnabled(true);
		if (e.Error == null)
		{
			return;
		}
		CoreDispatcher dispatcher = ((DependencyObject)this).Dispatcher;
		if (val == null)
		{
			val = (DispatchedHandler)delegate
			{
				Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_FAILED_TO_REGISTER_FOR_PUSH_NOTIFICATIONS"), showCancel: false);
				SettingService.SetUsingPushNotification(isUsed: false);
				TogglePush.put_IsOn(false);
				SettingService.SetToggleNewUpdatesPushNotification(isUsed: false);
				SettingService.SetTogglePushMarketingNotification(isUsed: false);
				((Control)ToggleNewUpdates).put_IsEnabled(false);
				((Control)TogglePushMarketing).put_IsEnabled(false);
			};
		}
		dispatcher.RunAsync((CoreDispatcherPriority)0, val);
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///NotificationSettingPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			LayoutRoot = (StackPanel)((FrameworkElement)this).FindName("LayoutRoot");
			TogglePush = (ToggleSwitch)((FrameworkElement)this).FindName("TogglePush");
			ToggleNewUpdates = (ToggleSwitch)((FrameworkElement)this).FindName("ToggleNewUpdates");
			TogglePushMarketing = (ToggleSwitch)((FrameworkElement)this).FindName("TogglePushMarketing");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void Connect(int connectionId, object target)
	{
		_contentLoaded = true;
	}
}
