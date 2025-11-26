using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.System;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;

namespace ChatON_WoA.Views;

public sealed class DisclaimerPage : Page, IComponentConnector
{
	private string _termsUri;

	private string _privacyUri;

	private SSMService _ssmService;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock TermsText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private HyperlinkButton TermsLink;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private HyperlinkButton PrivacyLink;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button AcceptButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public DisclaimerPage()
	{
		InitializeComponent();
		_ssmService = new SSMService();
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		_ssmService.AcceptDisclaimerCompleted += _ssmService_AcceptDisclaimerCompleted;
		_ssmService.GetServerAddressForWebCompleted += _ssmService_GetServerAddressForWebCompleted;
		_termsUri = "http://smm.samsung.com/mwv/disclaimer.html?c=" + userAccount.Mcc;
		_privacyUri = _termsUri + "&f=PP";
		TermsText.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_YOUR_USE_OF_CHATON_SERVICES_IS_GOVERNED_BY_THE_CHATON_TERMS_OF_SERVICE_AND_PRIVACY_POLICY"));
		pageTitle.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_TERMS_AND_PRIVACY"));
		((ContentControl)TermsLink).put_Content((object)Utility.GetResourceString("IDS_CHATON_SK1_TERMS_AND_CONDITIONS"));
		((ContentControl)PrivacyLink).put_Content((object)Utility.GetResourceString("IDS_CHATON_SK1_PRIVACY_POLICY"));
		((ContentControl)AcceptButton).put_Content((object)Utility.GetResourceString("IDS_CHATON_BUTTON_ACCEPT"));
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

	private void TermsLink_Click_1(object sender, RoutedEventArgs e)
	{
		Launcher.LaunchUriAsync(new Uri(_termsUri));
	}

	private void PrivacyLink_Click_1(object sender, RoutedEventArgs e)
	{
		Launcher.LaunchUriAsync(new Uri(_privacyUri));
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///DisclaimerPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TermsText = (TextBlock)((FrameworkElement)this).FindName("TermsText");
			TermsLink = (HyperlinkButton)((FrameworkElement)this).FindName("TermsLink");
			PrivacyLink = (HyperlinkButton)((FrameworkElement)this).FindName("PrivacyLink");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
			AcceptButton = (Button)((FrameworkElement)this).FindName("AcceptButton");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
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
			ButtonBase val4 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(TermsLink_Click_1));
			break;
		}
		case 2:
		{
			ButtonBase val3 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(PrivacyLink_Click_1));
			break;
		}
		case 3:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		case 4:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(AcceptButton_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
