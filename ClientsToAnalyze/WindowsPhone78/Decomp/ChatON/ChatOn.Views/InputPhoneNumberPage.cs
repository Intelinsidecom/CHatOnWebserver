using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class InputPhoneNumberPage : PhoneApplicationPage
{
	private string _code;

	private SSMService _ssmService;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal StackPanel ContentPanel;

	internal TextBlock SelectedCountryCode;

	internal TextBox InputPhoneNumber;

	private bool _contentLoaded;

	public InputPhoneNumberPage()
	{
		InitializeComponent();
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).Text = ResContainer.IDS_CHATON_SK_OK;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		((ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null)).Text = ResContainer.IDS_CHATON_SK_CANCEL;
		_ssmService = new SSMService();
		_ssmService.GetServerAddress3Completed += _ssmService_GetServerAddress3Completed;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void _ssmService_GetServerAddress3Completed(object sender, SSMCompletedEventArgs e)
	{
		if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("13003"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_INVALID_PHONE_NUMBER_FORMAT);
		}
		else if (e.Error != null)
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else
		{
			PageNavigationService.OpenInputVerificationCodePage((PhoneApplicationPage)(object)this, null);
		}
		LoadingIndicator.StopLoading();
	}

	private void SelectCountryCodePage_SelectionCompleted(object sender, object arg)
	{
		SelectCountryCodePage.SelectionCompleted -= SelectCountryCodePage_SelectionCompleted;
		CountryCode countryCode = arg as CountryCode;
		_code = countryCode.Code;
		SelectedCountryCode.Text = countryCode.Name + "(" + countryCode.Code + ")";
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void Cancel_Click(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void SelectCountryCode_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		SelectCountryCodePage.SelectionCompleted += SelectCountryCodePage_SelectionCompleted;
		PageNavigationService.OpenSelectCountryCodePage((PhoneApplicationPage)(object)this, isLanguage: false);
	}

	private void OK_Click(object sender, EventArgs e)
	{
		if (string.IsNullOrEmpty(_code))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_BODY_ENTER_COUNTRY_CODE);
			return;
		}
		if (string.IsNullOrEmpty(InputPhoneNumber.Text))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_BODY_ENTER_PHONE_NUMBER);
			return;
		}
		string code = _code.Remove(0, 1);
		string text = InputPhoneNumber.Text;
		RegistrationService.RegisterAccount(text, code);
		InputPhoneNumber.IsEnabled = false;
		InputPhoneNumber.IsEnabled = true;
		_ssmService.GetServerAddress3Async();
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
		LayoutRoot.Children.Add(value);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/InputPhoneNumberPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (StackPanel)((FrameworkElement)this).FindName("ContentPanel");
			SelectedCountryCode = (TextBlock)((FrameworkElement)this).FindName("SelectedCountryCode");
			InputPhoneNumber = (TextBox)((FrameworkElement)this).FindName("InputPhoneNumber");
		}
	}
}
