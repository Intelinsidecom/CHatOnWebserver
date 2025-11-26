using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class ManageBuddiesPage : Page, IComponentConnector
{
	private SSMService _ssmService;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button BlockListButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ToggleSwitch ToggleSuggestions;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public ManageBuddiesPage()
	{
		InitializeComponent();
		_ssmService = new SSMService();
		_ssmService.GetUserPrivacyCompleted += _ssmService_GetUserPrivacyCompleted;
		_ssmService.GetUserPrivacyAsync("recommendationbuddy");
	}

	private void _ssmService_GetUserPrivacyCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Xml != null)
		{
			bool flag = true;
			if (e.Xml.Element("value") != null)
			{
				flag = bool.Parse(e.Xml.Element("value").Value);
			}
			ToggleSuggestions.put_IsOn(flag);
		}
		else
		{
			ToggleSuggestions.put_IsOn(SettingService.GetShowSuggestions());
		}
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		SettingsPage.ActiveInstance.StopLoading();
		((Page)this).OnNavigatedFrom(e);
	}

	private void ToggleSuggestions_Toggled_1(object sender, RoutedEventArgs e)
	{
		SettingsPage.ActiveInstance.ShowLoading();
		SettingService.SetShowSuggestions(ToggleSuggestions.IsOn);
		UpdateSuggestion(ToggleSuggestions.IsOn);
	}

	private void BlockListButton_Click_1(object sender, RoutedEventArgs e)
	{
		SettingsPage.ActiveInstance.ShowBlockListPage();
	}

	private void UpdateSuggestion(bool isOn)
	{
		SSMService sSMService = new SSMService();
		sSMService.SetUserPrivacyCompleted += delegate
		{
			LoadingIndicator.StopLoading();
		};
		sSMService.SetUserPrivacyAsync(isOn, "recommendationbuddy");
	}

	private void HideListButton_Click_1(object sender, RoutedEventArgs e)
	{
		SettingsPage.ActiveInstance.ShowHiddenInteractionPage();
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///ManageBuddiesPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			BlockListButton = (Button)((FrameworkElement)this).FindName("BlockListButton");
			ToggleSuggestions = (ToggleSwitch)((FrameworkElement)this).FindName("ToggleSuggestions");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_001b: Expected O, but got Unknown
		//IL_003a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0044: Expected O, but got Unknown
		//IL_0047: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		//IL_006c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0076: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(BlockListButton_Click_1));
			break;
		}
		case 2:
		{
			ToggleSwitch val = (ToggleSwitch)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ToggleSwitch.add_Toggled)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ToggleSwitch.remove_Toggled)), new RoutedEventHandler(ToggleSuggestions_Toggled_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
