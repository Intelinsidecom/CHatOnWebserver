using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Globalization;
using System.IO.IsolatedStorage;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Notification;
using Microsoft.Phone.Tasks;
using Microsoft.Xna.Framework;

namespace ChatOn.Views;

public class SettingPage : PhoneApplicationPage
{
	private SSMService _ssmService;

	private DataService _dataService;

	private BuddyService _buddyService;

	private bool _orgShowBirthday;

	internal Grid LayoutRoot;

	internal TextBlock CurrentFontSize;

	internal CheckBox ShowBirthdayCheck;

	internal CheckBox PushNoticationCheck;

	internal CheckBox AllowLocationCheck;

	internal HyperlinkButton linkPrivatePolicy;

	private bool _contentLoaded;

	public SettingPage()
	{
		InitializeComponent();
		_dataService = new DataService();
		_ssmService = new SSMService();
		_ssmService.DeRegisterUserCompleted += ssmService_DeRegisterUserCompleted;
		_ssmService.UploadAddressCompleted += _ssmService_UploadAddressCompleted;
		_ssmService.GetVersionCompleted += _ssmService_GetVersionCompleted;
		_ssmService.GetBlindListCompleted += _ssmService_GetBlindListCompleted;
		_ssmService.UploadBlindListCompleted += _ssmService_UploadBlindListCompleted;
		_buddyService = new BuddyService(_dataService, _ssmService);
		_buddyService.GetContactListCompleted += buddyService_GetContactListCompleted;
		ShowBirthdayCheck.IsChecked = SettingService.IsShowingBirthday();
		_orgShowBirthday = ShowBirthdayCheck.IsChecked.Value;
		((FrameworkElement)this).Loaded += SettingPage_Loaded;
		string uriString = $"http://static.bada.com/contents/legal/{Utility.GetLanguageCode(CultureInfo.CurrentUICulture.EnglishName)}/pp.txt";
		linkPrivatePolicy.NavigateUri = new Uri(uriString);
		SettingService.GetFontSizeType();
		UpdateFontSize();
	}

	private void _ssmService_UploadBlindListCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error != null)
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void _ssmService_GetBlindListCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error != null && e.StatusCode != HttpStatusCode.NoContent)
		{
			if (string.IsNullOrEmpty(e.ErrorMessage))
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
			}
			else if (e.ErrorMessage.Contains("CCS-00012"))
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
			}
			return;
		}
		if (e.Xml == null)
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
			return;
		}
		List<string> list = _buddyService.ParseBlindListFromXml(e.Xml);
		List<string> list2 = new List<string>();
		foreach (Buddy buddyItem in _dataService.BuddyItems)
		{
			list2.Add(buddyItem.PhoneNumber);
		}
		if (list.Count > 0)
		{
			foreach (string item in list)
			{
				list2.Remove(item);
			}
		}
		SelectBuddyPage.PreSelectedNumbers = list2;
		SelectBuddyPage.IsReturnAllMode = true;
		SelectBuddyPage.IsExceptSpecialBuddies = true;
		SelectBuddyPage.SelectionCompleted += BuddiesSay_SelectionCompleted;
		PageNavigationService.OpenSelectBuddyPage((PhoneApplicationPage)(object)this);
	}

	private void BuddiesSay_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= BuddiesSay_SelectionCompleted;
		List<BuddySummary> list = arg as List<BuddySummary>;
		string xmlString = SSMService.MakeBlindListParam(list);
		_ssmService.UploadBlindListAsync(xmlString);
		object content = ((ContentControl)(object)((App)Application.Current).RootFrame).Content;
		PhoneApplicationPage val = (PhoneApplicationPage)((content is PhoneApplicationPage) ? content : null);
		LoadingIndicator value = new LoadingIndicator(val);
		(val as SelectBuddyPage).LayoutRoot.Children.Add(value);
	}

	private void _ssmService_GetVersionCompleted(object sender, SSMCompletedEventArgs e)
	{
		((DependencyObject)this).Dispatcher.BeginInvoke(delegate
		{
			LoadingIndicator.StopLoading();
		});
	}

	private void SettingPage_Loaded(object sender, RoutedEventArgs e)
	{
		UpdateFontSize();
	}

	private void UpdateFontSize()
	{
		switch (SettingService.GetFontSizeType())
		{
		case 0:
			CurrentFontSize.Text = "50%";
			break;
		case 1:
			CurrentFontSize.Text = "70%";
			break;
		case 2:
			CurrentFontSize.Text = "100%";
			break;
		case 3:
			CurrentFontSize.Text = "150%";
			break;
		case 4:
			CurrentFontSize.Text = "200%";
			break;
		}
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		PushNoticationCheck.IsChecked = SettingService.IsUsingPushNotification();
		AllowLocationCheck.IsChecked = SettingService.IsAllowLocation();
		((Page)this).OnNavigatedTo(e);
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		if (_orgShowBirthday != ShowBirthdayCheck.IsChecked)
		{
			ChatOnService.Instance.IsBuddiesUpdated = true;
		}
		((Page)this).OnNavigatedFrom(e);
	}

	private void _ssmService_UploadAddressCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			ChatOnService.Instance.ReUpdateBuddyList = true;
		}
		else if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
	}

	private void BlockList_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		PageNavigationService.OpenBlockListPage((PhoneApplicationPage)(object)this);
	}

	private void HideInteraction_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		PageNavigationService.OpenInteractionHideListPage((PhoneApplicationPage)(object)this);
	}

	private void Help_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_0028: Expected O, but got Unknown
		string name = CultureInfo.CurrentCulture.Name;
		name = name.Replace('-', '_');
		string uriString = "http://www.chaton.com/mwv/faq.html?l=" + name;
		WebBrowserTask val = new WebBrowserTask();
		val.Uri = new Uri(uriString);
		val.Show();
	}

	private void About_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		PageNavigationService.OpenAboutPage((PhoneApplicationPage)(object)this);
	}

	private void DeleteAccount_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		if (MessageBoxResult.OK == MessageBox.Show(ResContainer.IDS_CHATON_BODY_DELETING_ACCOUNT_WILL_DELETE_ALL_DATA, ResContainer.IDS_CHATON_BODY_DELETE_ACCOUNT, MessageBoxButton.OKCancel))
		{
			LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
			LayoutRoot.Children.Add(value);
			_ssmService.DeRegisterUserAsync();
		}
	}

	private void ssmService_DeRegisterUserCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0095: Unknown result type (might be due to invalid IL or missing references)
		//IL_009b: Expected O, but got Unknown
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			Utility.DeleteAllTile();
			ChatOnService.Instance.DeleteDatabase();
			IsolatedStorageSettings.ApplicationSettings.Clear();
			IsolatedStorageFile userStoreForApplication = IsolatedStorageFile.GetUserStoreForApplication();
			string[] directoryNames = userStoreForApplication.GetDirectoryNames();
			string[] array = directoryNames;
			foreach (string text in array)
			{
				if (text == "Shared")
				{
					Utility.DeleteDirectory("Shared\\ShellContent");
				}
				else if (!(text == "PresetAudio"))
				{
					Utility.DeleteDirectory(text);
				}
			}
			userStoreForApplication.Dispose();
			MessageBox.Show(ResContainer.IDS_CHATON_POP_APPLICATION_WILL_BE_CLOSED);
			Game val = new Game();
			val.Exit();
		}
		else if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
	}

	private void SyncNow_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
		SSMService.SetForceUpdateInteraction();
		_buddyService.GetContactListAsync();
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
		LayoutRoot.Children.Add(value);
	}

	private void buddyService_GetContactListCompleted(object sender, BuddyManagerEventArgs e)
	{
		_ssmService.UploadAddressListAsync(e.Result);
	}

	private void ShowBirthdayCheck_Click(object sender, RoutedEventArgs e)
	{
		SettingService.SetShowingBirthday(ShowBirthdayCheck.IsChecked.Value);
	}

	private void SkinSetting_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		PageNavigationService.OpenSkinSettingPage((PhoneApplicationPage)(object)this);
	}

	private void FontSetting_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		PageNavigationService.OpenFontSettingPage((PhoneApplicationPage)(object)this);
	}

	private void TellFriends_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		PageNavigationService.OpenTellFriendsPage((PhoneApplicationPage)(object)this);
	}

	private void PushNoticationCheck_Click(object sender, RoutedEventArgs e)
	{
		if ((!(sender as CheckBox).IsChecked).Value)
		{
			PushService.Instance.StopService();
			return;
		}
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
		LayoutRoot.Children.Add(value);
		PushService.Instance.ResetChannelUpdatedEventHandler();
		PushService.Instance.PushChannelUpdated += SettingPage_PushChannelUpdated;
		PushService.Instance.PushChannelOpenFailed += SettingPage_PushChannelOpenFailed;
		PushService.Instance.InitService();
		if (PushService.Instance.IsEnable())
		{
			_ssmService.GetVersionAsync(forceUpdate: true);
		}
	}

	private void AllowLocationCheck_Click(object sender, RoutedEventArgs e)
	{
		if (AllowLocationCheck.IsChecked.Value)
		{
			PageNavigationService.OpenAllowLocationPage((PhoneApplicationPage)(object)this);
		}
		else
		{
			SettingService.SetAllowLocation(allow: false);
		}
	}

	private void SettingPage_PushChannelUpdated(object sender, NotificationChannelUriEventArgs e)
	{
		PushService.Instance.PushChannelUpdated -= SettingPage_PushChannelUpdated;
		_ssmService.GetVersionAsync(forceUpdate: true);
	}

	private void SettingPage_PushChannelOpenFailed(object sender, PushServiceEventArgs e)
	{
		PushService.Instance.PushChannelOpenFailed -= SettingPage_PushChannelOpenFailed;
		((DependencyObject)this).Dispatcher.BeginInvoke(delegate
		{
			LoadingIndicator.StopLoading();
			MessageBox.Show(e.ErrorDetail);
			PushService.Instance.StopService();
			PushNoticationCheck.IsChecked = false;
		});
	}

	private void BuddiesSay_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
		LayoutRoot.Children.Add(value);
		_ssmService.GetBlindListAsync();
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/SettingPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			CurrentFontSize = (TextBlock)((FrameworkElement)this).FindName("CurrentFontSize");
			ShowBirthdayCheck = (CheckBox)((FrameworkElement)this).FindName("ShowBirthdayCheck");
			PushNoticationCheck = (CheckBox)((FrameworkElement)this).FindName("PushNoticationCheck");
			AllowLocationCheck = (CheckBox)((FrameworkElement)this).FindName("AllowLocationCheck");
			linkPrivatePolicy = (HyperlinkButton)((FrameworkElement)this).FindName("linkPrivatePolicy");
		}
	}
}
