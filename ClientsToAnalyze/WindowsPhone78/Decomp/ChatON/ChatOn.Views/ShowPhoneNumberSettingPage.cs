using System;
using System.Diagnostics;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using System.Xml.Linq;
using ChatOn.Controls;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Controls.Primitives;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class ShowPhoneNumberSettingPage : PhoneApplicationPage
{
	private SSMService _ssmService;

	private bool _orgValue;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal TextBlock PhoneNumberText;

	internal ToggleSwitchButton ToggleControl;

	internal TextBlock OnOffText;

	private bool _contentLoaded;

	public ShowPhoneNumberSettingPage()
	{
		InitializeComponent();
		PhoneNumberText.Text = RegistrationService.GetUserNumber();
		_ssmService = new SSMService();
		_ssmService.GetUserPrivacyCompleted += _ssmService_GetUserPrivacyCompleted;
		_ssmService.SetUserPrivacyCompleted += _ssmService_SetUserPrivacyCompleted;
		_ssmService.GetUserPrivacyAsync();
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
		LayoutRoot.Children.Add(value);
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_SAVE;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_BUTTON_CANCEL;
	}

	private void _ssmService_SetUserPrivacyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
			return;
		}
		if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
		ToggleControl.IsChecked = _orgValue;
		OnOffText.Text = (_orgValue ? ResContainer.IDS_CHATON_BODY_ON : ResContainer.IDS_CHATON_BODY_OFF);
	}

	private void _ssmService_GetUserPrivacyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK && e.Xml != null)
		{
			XElement xElement = e.Xml.Element("value");
			ToggleControl.IsChecked = bool.Parse(xElement.Value);
			_orgValue = ToggleControl.IsChecked.Value;
			OnOffText.Text = (_orgValue ? ResContainer.IDS_CHATON_BODY_ON : ResContainer.IDS_CHATON_BODY_OFF);
			return;
		}
		if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void SaveButton_Click(object sender, EventArgs e)
	{
		if (ToggleControl.IsChecked != _orgValue)
		{
			_ssmService.SetUserPrivacyAsync(ToggleControl.IsChecked.Value);
			LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
			LayoutRoot.Children.Add(value);
		}
		else
		{
			Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
		}
	}

	private void CancelButton_Click_1(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void ToggleControl_Click(object sender, RoutedEventArgs e)
	{
		OnOffText.Text = (ToggleControl.IsChecked.Value ? ResContainer.IDS_CHATON_BODY_ON : ResContainer.IDS_CHATON_BODY_OFF);
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedTo(e);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/ShowPhoneNumberSettingPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			PhoneNumberText = (TextBlock)((FrameworkElement)this).FindName("PhoneNumberText");
			ToggleControl = (ToggleSwitchButton)((FrameworkElement)this).FindName("ToggleControl");
			OnOffText = (TextBlock)((FrameworkElement)this).FindName("OnOffText");
		}
	}
}
