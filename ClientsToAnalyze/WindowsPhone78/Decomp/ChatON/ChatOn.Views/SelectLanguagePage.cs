using System;
using System.Diagnostics;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class SelectLanguagePage : PhoneApplicationPage
{
	private bool _isNew = true;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal StackPanel ContentPanel;

	internal TextBlock SelectedLanguage;

	private bool _contentLoaded;

	public SelectLanguagePage()
	{
		InitializeComponent();
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).Text = ResContainer.IDS_CHATON_SK_OK;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			if (((Page)this).NavigationService.BackStack.Count() > 0)
			{
				string originalString = ((Page)this).NavigationService.BackStack.First().Source.OriginalString;
				if (originalString.Contains("MainPage.xaml"))
				{
					((Page)this).NavigationService.RemoveBackEntry();
				}
			}
			_isNew = false;
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void Select_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		SelectCountryCodePage.SelectionCompleted += SelectCountryCodePage_SelectionCompleted;
		PageNavigationService.OpenSelectCountryCodePage((PhoneApplicationPage)(object)this, isLanguage: true);
	}

	private void SelectCountryCodePage_SelectionCompleted(object sender, object arg)
	{
		SelectCountryCodePage.SelectionCompleted -= SelectCountryCodePage_SelectionCompleted;
		CountryCode countryCode = arg as CountryCode;
		SelectedLanguage.Text = countryCode.Name;
		RegistrationService.RegisterAccount(countryCode.MCC);
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).IsEnabled = true;
	}

	private void OK_Click(object sender, EventArgs e)
	{
		PageNavigationService.OpenDisclaimerPage((PhoneApplicationPage)(object)this);
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
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/SelectLanguagePage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (StackPanel)((FrameworkElement)this).FindName("ContentPanel");
			SelectedLanguage = (TextBlock)((FrameworkElement)this).FindName("SelectedLanguage");
		}
	}
}
