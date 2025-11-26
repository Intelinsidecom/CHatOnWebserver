using System;
using System.Diagnostics;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class DisclaimerPage : PhoneApplicationPage
{
	private bool _isNew = true;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal TextBlock PageTitle;

	internal StackPanel ContentPanel;

	internal HyperlinkButton TermsLink;

	internal HyperlinkButton PrivacyLink;

	private bool _contentLoaded;

	public DisclaimerPage()
	{
		InitializeComponent();
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).Text = ResContainer.IDS_CHATON_SK_OK;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		((ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null)).Text = ResContainer.IDS_CHATON_SK_CANCEL;
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		string text = "http://smm.samsung.com/mwv/disclaimer.html?c=" + userAccount.Mcc;
		string uriString = text + "&f=PP";
		TermsLink.NavigateUri = new Uri(text);
		TermsLink.TargetName = "_blank";
		PrivacyLink.NavigateUri = new Uri(uriString);
		PrivacyLink.TargetName = "_blank";
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			string originalString = ((Page)this).NavigationService.BackStack.First().Source.OriginalString;
			if (originalString.Contains("MainPage.xaml"))
			{
				((Page)this).NavigationService.RemoveBackEntry();
			}
			_isNew = false;
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void Done_Click(object sender, EventArgs e)
	{
		PageNavigationService.OpenInputPhoneNumberPage((PhoneApplicationPage)(object)this);
	}

	private void Cancel_Click(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/DisclaimerPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			PageTitle = (TextBlock)((FrameworkElement)this).FindName("PageTitle");
			ContentPanel = (StackPanel)((FrameworkElement)this).FindName("ContentPanel");
			TermsLink = (HyperlinkButton)((FrameworkElement)this).FindName("TermsLink");
			PrivacyLink = (HyperlinkButton)((FrameworkElement)this).FindName("PrivacyLink");
		}
	}
}
