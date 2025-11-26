using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.Storage;
using Windows.System;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;

namespace ChatON_WoA.Views;

public sealed class AboutPage : Page, IComponentConnector
{
	private UserAccountInfo account;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock CurrentVersion;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock LatestVersion;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button OpenSourceButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button UpgradeButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SinaDisplay;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtChatOn;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtAbout;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public AboutPage()
	{
		InitializeComponent();
		account = RegistrationService.GetUserAccount();
	}

	private void AboutPage_Loaded(object sender, RoutedEventArgs e)
	{
		UpdatePage();
	}

	private void UpdatePage()
	{
		SSMServer serverInfo = SSMService.GetServerInfo();
		((Control)UpgradeButton).put_IsEnabled(false);
		CurrentVersion.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_CURRENT_VERSION") + " " + Utility.GetAssemblyVersion());
		if (!string.IsNullOrEmpty(serverInfo.NewVersion))
		{
			((Control)UpgradeButton).put_IsEnabled(serverInfo.NewVersion != Utility.GetAssemblyVersion());
			LatestVersion.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_LATEST_VERSION") + " " + serverInfo.NewVersion);
		}
		else
		{
			LatestVersion.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_LATEST_VERSION") + " " + Utility.GetAssemblyVersion());
		}
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		if (userAccount.CountryCode == "86" || userAccount.Mcc == "460")
		{
			((UIElement)SinaDisplay).put_Visibility((Visibility)0);
		}
		else
		{
			((UIElement)SinaDisplay).put_Visibility((Visibility)1);
		}
		((ContentControl)OpenSourceButton).put_Content((object)Utility.GetResourceString("IDS_CHATON_BODY_OPEN_SOURCE_LICENCES_ABB"));
		txtChatOn.put_Text("Chat your way");
		((ContentControl)UpgradeButton).put_Content((object)Utility.GetResourceString("IDS_CHATON_SK_UPGRADE"));
		txtAbout.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_ABOUT_CHATON"));
	}

	private void TermsButton_Click_1(object sender, RoutedEventArgs e)
	{
		Launcher.LaunchUriAsync(new Uri("http://smm.samsung.com/mwv/disclaimer.html?c=" + account.Mcc));
	}

	private void ConsentButton_Click_1(object sender, RoutedEventArgs e)
	{
		Launcher.LaunchUriAsync(new Uri("http://smm.samsung.com/mwv/disclaimer.html?c=" + account.Mcc + "&f=PP"));
	}

	private async void OpenSourceButton_Click_1(object sender, RoutedEventArgs e)
	{
		Launcher.LaunchFileAsync((IStorageFile)(object)(await StorageFile.GetFileFromApplicationUriAsync(new Uri("ms-appx:///Assets/Magellan-ChatOn.html"))));
	}

	private void backButton_Click_1(object sender, RoutedEventArgs e)
	{
		DependencyObject parent = ((FrameworkElement)this).Parent;
		Popup val = (Popup)(object)((parent is Popup) ? parent : null);
		if (val != null)
		{
			val.put_IsOpen(false);
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///AboutPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			CurrentVersion = (TextBlock)((FrameworkElement)this).FindName("CurrentVersion");
			LatestVersion = (TextBlock)((FrameworkElement)this).FindName("LatestVersion");
			OpenSourceButton = (Button)((FrameworkElement)this).FindName("OpenSourceButton");
			UpgradeButton = (Button)((FrameworkElement)this).FindName("UpgradeButton");
			SinaDisplay = (TextBlock)((FrameworkElement)this).FindName("SinaDisplay");
			txtChatOn = (TextBlock)((FrameworkElement)this).FindName("txtChatOn");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			txtAbout = (TextBlock)((FrameworkElement)this).FindName("txtAbout");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_001c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0022: Expected O, but got Unknown
		//IL_0041: Unknown result type (might be due to invalid IL or missing references)
		//IL_004b: Expected O, but got Unknown
		//IL_004e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0054: Expected O, but got Unknown
		//IL_0073: Unknown result type (might be due to invalid IL or missing references)
		//IL_007d: Expected O, but got Unknown
		//IL_0080: Unknown result type (might be due to invalid IL or missing references)
		//IL_0086: Expected O, but got Unknown
		//IL_00a5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00af: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val3 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(AboutPage_Loaded));
			break;
		}
		case 2:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(OpenSourceButton_Click_1));
			break;
		}
		case 3:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
