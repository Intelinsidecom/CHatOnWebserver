using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class AddBuddyPage : PhoneApplicationPage
{
	private string _code;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal StackPanel ContentPanel;

	internal TextBlock SelectedCountryCode;

	internal TextBox InputPhoneNumber;

	private bool _contentLoaded;

	public AddBuddyPage()
	{
		InitializeComponent();
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_DONE;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_BUTTON_CANCEL;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (string.IsNullOrEmpty(_code))
		{
			_code = "+" + RegistrationService.GetUserContryCode();
			CountryCode countryCode = SelectCountryCodePageViewModel.GetCountryCode(_code);
			SelectedCountryCode.Text = countryCode.Name + "(" + countryCode.Code + ")";
		}
		((Page)this).OnNavigatedTo(e);
	}

	protected override void OnBackKeyPress(CancelEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (LoadingIndicator.HandleBackKey())
		{
			e.Cancel = true;
		}
		((PhoneApplicationPage)this).OnBackKeyPress(e);
	}

	private void SelectCountryCodePage_SelectionCompleted(object sender, object arg)
	{
		SelectCountryCodePage.SelectionCompleted -= SelectCountryCodePage_SelectionCompleted;
		CountryCode countryCode = arg as CountryCode;
		_code = countryCode.Code;
		SelectedCountryCode.Text = countryCode.Name + "(" + countryCode.Code + ")";
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void OkButton_Click(object sender, EventArgs e)
	{
		if (!string.IsNullOrEmpty(InputPhoneNumber.Text))
		{
			InputPhoneNumber.IsEnabled = false;
			InputPhoneNumber.IsEnabled = true;
			LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
			LayoutRoot.Children.Add(value);
			string text = InputPhoneNumber.Text;
			text = (string.IsNullOrEmpty(_code) ? ("+" + RegistrationService.GetUserContryCode() + text) : (_code + text));
			SSMService sSMService = new SSMService();
			sSMService.AddBuddyCompleted += ssmService_AddBuddyCompleted;
			sSMService.AddBuddyAsync(text);
		}
	}

	private void ssmService_AddBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (!string.IsNullOrEmpty(e.ErrorMessage))
		{
			if (e.ErrorMessage.Contains("25005"))
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_ALREADY_YOUR_BUDDY);
			}
			else if (e.ErrorMessage.Contains("25004"))
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_CANNOT_ADD_YOURSELF);
			}
			else if (e.ErrorMessage.Contains("25008") || e.ErrorMessage.Contains("25002"))
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_INVALID_PHONE_NUMBER_FORMAT);
			}
			else if (e.ErrorMessage.Contains("25007"))
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_BUDDY_BLOCKED_TO_UNBLOCK_GO_TO_SETTINGS_BLOCK_LIST);
			}
		}
		else if (e.StatusCode == HttpStatusCode.OK)
		{
			if (e.Xml == null)
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
				return;
			}
			ChatOnService.Instance.IsBuddiesUpdated = true;
			DataService dataService = new DataService();
			SSMService sSMService = new SSMService();
			BuddyService buddyService = new BuddyService(dataService, sSMService);
			List<Buddy> list = buddyService.AddBuddyFromXml(e.Xml);
			if (list.Count > 0 && !list[0].LoadProfileImage())
			{
				list[0].LoadProfileImage(sSMService.GetBuddyProfileImageUri(list[0].PhoneNumber));
			}
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ADDED_TO_BUDDY_LIST);
			Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
		}
		else if (e.StatusCode == HttpStatusCode.NoContent)
		{
			string iDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER = ResContainer.IDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER;
			iDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER = iDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER.Replace("%s", "{0:}");
			iDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER = string.Format(iDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER, InputPhoneNumber.Text);
			MessageBox.Show(iDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER);
		}
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

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/AddBuddyPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (StackPanel)((FrameworkElement)this).FindName("ContentPanel");
			SelectedCountryCode = (TextBlock)((FrameworkElement)this).FindName("SelectedCountryCode");
			InputPhoneNumber = (TextBox)((FrameworkElement)this).FindName("InputPhoneNumber");
		}
	}
}
