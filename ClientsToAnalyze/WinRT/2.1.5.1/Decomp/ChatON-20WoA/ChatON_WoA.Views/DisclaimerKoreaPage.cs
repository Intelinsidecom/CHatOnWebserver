using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.System;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class DisclaimerKoreaPage : Page, IComponentConnector
{
	private string _termsUri;

	private string _consentUri;

	private string _privacyUri;

	private SSMService _ssmService;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private CheckBox Check1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private CheckBox Check2;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button AcceptButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public DisclaimerKoreaPage()
	{
		InitializeComponent();
		_ssmService = new SSMService();
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		_ssmService.AcceptDisclaimerCompleted += _ssmService_AcceptDisclaimerCompleted;
		_ssmService.GetServerAddressForWebCompleted += _ssmService_GetServerAddressForWebCompleted;
		_termsUri = "http://smm.samsung.com/mwv/disclaimer.html?c=" + userAccount.Mcc;
		_consentUri = _termsUri + "&f=PUA";
		_privacyUri = _termsUri + "&f=PP";
		((ContentControl)AcceptButton).put_Content((object)Utility.GetResourceString("IDS_CHATON_BUTTON_ACCEPT"));
	}

	private void DisclaimerKoreaPage_Loaded(object sender, RoutedEventArgs e)
	{
		OnSizeChanged();
	}

	private void AcceptButton_Click_1(object sender, RoutedEventArgs e)
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
		if (string.IsNullOrEmpty(RegistrationService.ChatOnID))
		{
			_ssmService.GetServerAddressForWeb();
		}
		else
		{
			_ssmService.AcceptDisclaimer();
		}
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		Launcher.LaunchUriAsync(new Uri(_termsUri));
	}

	private void Grid_Tapped_2(object sender, TappedRoutedEventArgs e)
	{
		Launcher.LaunchUriAsync(new Uri(_consentUri));
	}

	private void Grid_Tapped_3(object sender, TappedRoutedEventArgs e)
	{
		Launcher.LaunchUriAsync(new Uri(_privacyUri));
	}

	private void Check1_Click_1(object sender, RoutedEventArgs e)
	{
		if (((ToggleButton)Check1).IsChecked.Value && ((ToggleButton)Check2).IsChecked.Value)
		{
			((Control)AcceptButton).put_IsEnabled(true);
		}
		else
		{
			((Control)AcceptButton).put_IsEnabled(false);
		}
	}

	protected unsafe override void OnNavigatedTo(NavigationEventArgs e)
	{
		//IL_0025: Unknown result type (might be due to invalid IL or missing references)
		//IL_002f: Expected O, but got Unknown
		Window current = Window.Current;
		WindowsRuntimeMarshal.AddEventHandler(new Func<WindowSizeChangedEventHandler, EventRegistrationToken>(current, (nint)__ldftn(Window.add_SizeChanged)), new Action<EventRegistrationToken>(current, (nint)__ldftn(Window.remove_SizeChanged)), new WindowSizeChangedEventHandler(Current_SizeChanged));
	}

	private void Current_SizeChanged(object sender, WindowSizeChangedEventArgs e)
	{
		OnSizeChanged(e.Size.Width);
	}

	private void OnSizeChanged(double size = 0.0)
	{
		if (size == 0.0)
		{
			if (((FrameworkElement)LayoutRoot).ActualWidth < 1100.0)
			{
				((FrameworkElement)AcceptButton).put_Margin(new Thickness(0.0, 0.0, 5.0, 35.0));
			}
			else
			{
				((FrameworkElement)AcceptButton).put_Margin(new Thickness(0.0, 0.0, 100.0, 35.0));
			}
		}
		else if (size < 1100.0)
		{
			((FrameworkElement)AcceptButton).put_Margin(new Thickness(0.0, 0.0, 5.0, 35.0));
		}
		else
		{
			((FrameworkElement)AcceptButton).put_Margin(new Thickness(0.0, 0.0, 100.0, 35.0));
		}
	}

	protected unsafe override void OnNavigatedFrom(NavigationEventArgs e)
	{
		//IL_0017: Unknown result type (might be due to invalid IL or missing references)
		//IL_0021: Expected O, but got Unknown
		WindowsRuntimeMarshal.RemoveEventHandler<WindowSizeChangedEventHandler>(new Action<EventRegistrationToken>(Window.Current, (nint)__ldftn(Window.remove_SizeChanged)), new WindowSizeChangedEventHandler(Current_SizeChanged));
	}

	private void _ssmService_GetServerAddressForWebCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_004e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0054: Expected O, but got Unknown
		//IL_002e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0034: Expected O, but got Unknown
		LoadingIndicator.StopLoading();
		if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("13003"))
		{
			MessageDialog val = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_INVALID_PHONE_NUMBER_FORMAT"));
			val.ShowAsync();
			return;
		}
		if (e.Error != null)
		{
			MessageDialog val2 = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"));
			val2.ShowAsync();
			return;
		}
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
		_ssmService.AcceptDisclaimer();
	}

	private void _ssmService_AcceptDisclaimerCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008b: Expected O, but got Unknown
		//IL_0071: Unknown result type (might be due to invalid IL or missing references)
		//IL_0077: Expected O, but got Unknown
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			if (string.IsNullOrEmpty(RegistrationService.ChatOnID))
			{
				PageNavigationService.OpenInputNamePage((Page)(object)this, null);
			}
			else
			{
				Utility.SafetyGoBack((Page)(object)this);
			}
		}
		else if (e.ErrorMessage.Contains("CCS-73004"))
		{
			if (string.IsNullOrEmpty(RegistrationService.ChatOnID))
			{
				PageNavigationService.OpenInputNamePage((Page)(object)this, null);
			}
			else
			{
				Utility.SafetyGoBack((Page)(object)this);
			}
		}
		else if (e.ErrorMessage.Contains("CCS-73002"))
		{
			MessageDialog val = new MessageDialog("no matching mcc iso or disclaimerUID");
			val.ShowAsync();
		}
		else
		{
			MessageDialog val2 = new MessageDialog(e.ErrorMessage);
			val2.ShowAsync();
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
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///DisclaimerKoreaPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			Check1 = (CheckBox)((FrameworkElement)this).FindName("Check1");
			Check2 = (CheckBox)((FrameworkElement)this).FindName("Check2");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
			AcceptButton = (Button)((FrameworkElement)this).FindName("AcceptButton");
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
		//IL_0065: Unknown result type (might be due to invalid IL or missing references)
		//IL_006b: Expected O, but got Unknown
		//IL_008a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0094: Expected O, but got Unknown
		//IL_009a: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a0: Expected O, but got Unknown
		//IL_00bf: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c9: Expected O, but got Unknown
		//IL_00cf: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d6: Expected O, but got Unknown
		//IL_00f7: Unknown result type (might be due to invalid IL or missing references)
		//IL_0101: Expected O, but got Unknown
		//IL_0107: Unknown result type (might be due to invalid IL or missing references)
		//IL_010e: Expected O, but got Unknown
		//IL_012f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0139: Expected O, but got Unknown
		//IL_013f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0146: Expected O, but got Unknown
		//IL_0167: Unknown result type (might be due to invalid IL or missing references)
		//IL_0171: Expected O, but got Unknown
		//IL_0174: Unknown result type (might be due to invalid IL or missing references)
		//IL_017b: Expected O, but got Unknown
		//IL_019c: Unknown result type (might be due to invalid IL or missing references)
		//IL_01a6: Expected O, but got Unknown
		//IL_01a9: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b0: Expected O, but got Unknown
		//IL_01d1: Unknown result type (might be due to invalid IL or missing references)
		//IL_01db: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val8 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(DisclaimerKoreaPage_Loaded));
			break;
		}
		case 2:
		{
			UIElement val7 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 3:
		{
			ButtonBase val6 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Check1_Click_1));
			break;
		}
		case 4:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_2));
			break;
		}
		case 5:
		{
			ButtonBase val4 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Check1_Click_1));
			break;
		}
		case 6:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_3));
			break;
		}
		case 7:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		case 8:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(AcceptButton_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
