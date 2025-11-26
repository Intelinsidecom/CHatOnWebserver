using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using System.Xml.Linq;
using ChatON_WoA.Services;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.ApplicationModel.Contacts;
using Windows.Security.Authentication.Web;
using Windows.UI;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;

namespace ChatOn.Controls;

public class AddBuddyDialog : UserControl, IComponentConnector
{
	private const string _FACEBOOK_SITE = "facebook";

	private const string _TWITTER_SITE = "twitter";

	private const string _EX_SAMSUNG_ACCOUNT = "example@samsung.com";

	private CountryCode _code;

	private SSMService _ssmService;

	private DataService _dataService;

	private BuddyService _buddyService;

	public bool _isSearchByID;

	private string _searchingData;

	private Buddy _buddyToAdd;

	private bool _profileIsOn;

	private ObservableCollection<Buddy> _resultList = new ObservableCollection<Buddy>();

	private ObservableCollection<Buddy> _resultList2 = new ObservableCollection<Buddy>();

	private ObservableCollection<TellFriendsItem> _tellFriendsList = new ObservableCollection<TellFriendsItem>();

	private bool isSearchByIdProcessing;

	private int _totalEmailSync;

	private bool _isUploadPhoneDone;

	private IReadOnlyList<ContactInformation> _peopleContacts;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid PhoneNumberGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid PeopleGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid SearchIDGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid TellFriendGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView TellFriendsListBox;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text6;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text7;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView SearchIDResultList;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox InputID;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton AddFromPeopleButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text2;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text4;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text5;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox InputPhoneNumber;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SelectedCountryCode;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton PhonenumberButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton SearchButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton PeopleButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton TellFriendButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton CloseButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public ObservableCollection<Buddy> ResultList
	{
		get
		{
			return _resultList;
		}
		set
		{
			_resultList = value;
		}
	}

	public ObservableCollection<Buddy> ResultList2
	{
		get
		{
			return _resultList2;
		}
		set
		{
			_resultList2 = value;
		}
	}

	public ObservableCollection<TellFriendsItem> TellFriendsList
	{
		get
		{
			return _tellFriendsList;
		}
		set
		{
			_tellFriendsList = value;
		}
	}

	public bool _updateBuddyFromUploadAddressRunning { get; set; }

	public event ProfileDialogClosedEventHandler DialogClosedTapped;

	public void OnDialogClosed(object sender, ProfileDialogEventArgs e)
	{
		this.DialogClosedTapped?.Invoke(this, e);
	}

	public AddBuddyDialog()
	{
		InitializeComponent();
		string phoneNumberMCC = RegistrationService.GetUserAccount().PhoneNumberMCC;
		if (!string.IsNullOrEmpty(phoneNumberMCC))
		{
			_code = SelectCountryCodePageViewModel.GetCountryCodeByMCC(phoneNumberMCC);
			SelectedCountryCode.put_Text(_code.ToString());
		}
		else
		{
			SelectedCountryCode.put_Text(Utility.GetResourceString("IDS_CHATON_OPT_NONE"));
		}
		((FrameworkElement)this).put_DataContext((object)this);
		_dataService = new DataService();
		_ssmService = new SSMService();
		_ssmService.AddBuddyCompleted += _ssmService_AddBuddyCompleted;
		_ssmService.UploadAddressCompleted += _ssmService_UploadAddressCompleted;
		_ssmService.GetBuddyCompleted += _ssmService_GetBuddyCompleted;
		_buddyService = new BuddyService(_dataService, _ssmService);
		_buddyService.GetContactListCompleted += _buddyService_GetContactListCompleted;
		_buddyService.AddBuddyByPeopleEmailCompleted += _buddyService_AddBuddyByPeopleEmailCompleted;
		_buddyService.UpdateTotalContact += _buddyService_OnUpdateTotalContact;
		_buddyService.UpdateTotalEmail += _buddyService_UpdateTotalEmail;
		Text1.put_Text(Utility.GetResourceString("IDS_CHATON_BUTTON_ADD_BUDDY"));
		Text2.put_Text(Utility.GetResourceString("IDS_CHATON_MBODY_COUNTRY_OR_REGION_CODE"));
		Text4.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_PHONE_NUMBER"));
		Text5.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_RESULTS"));
		Text6.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_ENTER_SAMSUNG_ACCOUNT_ID_ABB"));
		Text7.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_RESULTS"));
		PhonenumberButton.Text = Utility.GetResourceString("IDS_CHATON_BODY_PHONE_NUMBER");
		SearchButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON_SEARCH");
		PeopleButton.Text = Utility.GetResourceString("WP7_CHATOIN_PEOPLE");
		TellFriendsItem item = new TellFriendsItem
		{
			Name = Utility.GetResourceString("IDS_CHATON_HEADER_TWITTER")
		};
		TellFriendsList.Add(item);
	}

	private void _buddyService_OnUpdateTotalContact(object sender, IReadOnlyList<ContactInformation> contacts)
	{
		_updateBuddyFromUploadAddressRunning = false;
		_peopleContacts = contacts;
	}

	private void _buddyService_UpdateTotalEmail(object sender, int total)
	{
		_totalEmailSync = total;
	}

	public unsafe AddBuddyDialog(int index)
	{
		//IL_025e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0268: Expected O, but got Unknown
		InitializeComponent();
		string phoneNumberMCC = RegistrationService.GetUserAccount().PhoneNumberMCC;
		if (!string.IsNullOrEmpty(phoneNumberMCC))
		{
			_code = SelectCountryCodePageViewModel.GetCountryCodeByMCC(phoneNumberMCC);
			SelectedCountryCode.put_Text(_code.ToString());
		}
		else
		{
			SelectedCountryCode.put_Text(Utility.GetResourceString("IDS_CHATON_OPT_NONE"));
		}
		((FrameworkElement)this).put_DataContext((object)this);
		_dataService = new DataService();
		_ssmService = new SSMService();
		_ssmService.AddBuddyCompleted += _ssmService_AddBuddyCompleted;
		_ssmService.UploadAddressCompleted += _ssmService_UploadAddressCompleted;
		_ssmService.GetBuddyCompleted += _ssmService_GetBuddyCompleted;
		_buddyService = new BuddyService(_dataService, _ssmService);
		_buddyService.GetContactListCompleted += _buddyService_GetContactListCompleted;
		_buddyService.AddBuddyByPeopleEmailCompleted += _buddyService_AddBuddyByPeopleEmailCompleted;
		_buddyService.UpdateTotalContact += _buddyService_OnUpdateTotalContact;
		_buddyService.UpdateTotalEmail += _buddyService_UpdateTotalEmail;
		Text1.put_Text(Utility.GetResourceString("IDS_CHATON_BUTTON_ADD_BUDDY"));
		Text2.put_Text(Utility.GetResourceString("IDS_CHATON_MBODY_COUNTRY_OR_REGION_CODE"));
		Text4.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_PHONE_NUMBER"));
		Text5.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_RESULTS"));
		Text6.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_ENTER_SAMSUNG_ACCOUNT_ID_ABB"));
		Text7.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_RESULTS"));
		PhonenumberButton.Text = Utility.GetResourceString("IDS_CHATON_BODY_PHONE_NUMBER");
		SearchButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON_SEARCH");
		PeopleButton.Text = Utility.GetResourceString("WP7_CHATOIN_PEOPLE");
		TellFriendsItem item = new TellFriendsItem
		{
			Name = Utility.GetResourceString("IDS_CHATON_HEADER_TWITTER")
		};
		TellFriendsList.Add(item);
		if (index == 3)
		{
			ShowTellFriendFrame();
			return;
		}
		TextBox inputPhoneNumber = InputPhoneNumber;
		WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(inputPhoneNumber, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(inputPhoneNumber, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(InputPhoneNumber_Loaded));
	}

	private void InputPhoneNumber_Loaded(object sender, RoutedEventArgs e)
	{
		((Control)InputPhoneNumber).Focus((FocusState)1);
	}

	private void _ssmService_GetBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			LoadingIndicator.StopLoading();
			if (e.StatusCode == HttpStatusCode.NoContent && _updateBuddyFromUploadAddressRunning)
			{
				DisplaySyncPopup();
			}
			if (e.Error != null || e.StatusCode != HttpStatusCode.OK)
			{
				await SSMService.ShowCommonErrorMessage(e);
			}
			else if (e.Xml != null)
			{
				List<Buddy> list = _buddyService.AddBuddyFromXml(e.Xml);
				if (list != null)
				{
					foreach (Buddy item in list)
					{
						string newValue = ((!string.IsNullOrEmpty(item.ProfileName)) ? item.ProfileName : item.Name);
						Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_PS_ADDED").Replace("%s", newValue));
					}
				}
				PivotPage.ActiveInstance.ViewModel.UpdateList();
			}
		});
	}

	private async void _ssmService_UploadAddressCompleted(object sender, SSMCompletedEventArgs e)
	{
		_isUploadPhoneDone = true;
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			LoadingIndicator.StopLoading();
		});
		_buddyService.SetContactsUploadedFlag();
		if (e.StatusCode == HttpStatusCode.NoContent)
		{
			DisplaySyncPopup();
			return;
		}
		if (e.Error != null || e.StatusCode != HttpStatusCode.OK)
		{
			await SSMService.ShowCommonErrorMessage(e);
			return;
		}
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
		});
		if (_totalEmailSync == 0)
		{
			_updateBuddyFromUploadAddressRunning = true;
			_ssmService.GetBuddyListAsync();
		}
	}

	private void _buddyService_GetContactListCompleted(object sender, BuddyManagerEventArgs e)
	{
		_ssmService.UploadAddressListAsync(e.Result);
	}

	private async void _ssmService_AddBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		try
		{
			if (string.IsNullOrEmpty(e.ErrorMessage) && HttpStatusCode.NoContent != e.StatusCode && e.StatusCode != HttpStatusCode.OK)
			{
				isSearchByIdProcessing = false;
				if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"), showCancel: true, Utility.GetResourceString("IDS_CHATON_BODY_ERROR")))
				{
					await CheckAndRunNextStep();
				}
			}
			else if (await BuddyService.ShowAddBuddyResult(e, _searchingData, _isSearchByID))
			{
				isSearchByIdProcessing = false;
				if ((bool)e.Value)
				{
					List<Buddy> newBuddies = _buddyService.AddBuddyFromXml(e.Xml, updateOnly: false, previewOnly: true);
					if (_isSearchByID)
					{
						if (!_resultList2.Contains(newBuddies[0]))
						{
							_resultList2.Add(newBuddies[0]);
							newBuddies[0].SamsungEmail = _searchingData;
							((UIElement)Text7).put_Visibility((Visibility)0);
							((UIElement)SearchIDResultList).put_Visibility((Visibility)0);
						}
					}
					else
					{
						((UIElement)Text5).put_Visibility((Visibility)0);
						_resultList.Add(newBuddies[0]);
					}
					return;
				}
				if (_totalEmailSync == 0)
				{
					LoadingIndicator.StopLoading();
				}
				if (e.StatusCode != HttpStatusCode.OK)
				{
					if (IsSyncPeopleCompleted())
					{
						DisplaySyncPopup();
						_ssmService.GetBuddyListAsync();
					}
					return;
				}
				ChatOnService.Instance.IsBuddiesUpdated = true;
				List<Buddy> buddies = _buddyService.AddBuddyFromXml(e.Xml);
				if (buddies.Count > 0)
				{
					if (_resultList2 != null && _resultList2.Contains(buddies.FirstOrDefault()))
					{
						_resultList2[0].IsNew = true;
					}
					if (_resultList != null && _resultList.Contains(buddies.FirstOrDefault()))
					{
						_resultList[0].IsNew = true;
					}
					await buddies[0].LoadProfileImage(_ssmService.GetBuddyProfileImageUri(buddies[0].PhoneNumber));
					Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_PS_ADDED").Replace("%s", buddies[0].Name));
				}
				_buddyToAdd = buddies.FirstOrDefault();
				if (_buddyToAdd != null)
				{
					_buddyToAdd.IsNew = true;
					Chat chat = _dataService.ChatItems.FirstOrDefault((Chat x) => x.Members.Contains(_buddyToAdd.PhoneNumber) && x.SingleChatBuddy == null && x.IsValidSession);
					if (chat != null)
					{
						chat.SingleChatBuddy = _buddyToAdd;
						_dataService.ChatDBSubmitChanges();
					}
					_dataService.BuddyDBSubmitChanges();
				}
				SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
				_ssmService.GetBuddyListAsync();
			}
			isSearchByIdProcessing = false;
		}
		catch (Exception)
		{
		}
	}

	private async Task AddBuddyToLocalStorage(SSMCompletedEventArgs e)
	{
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)1, (DispatchedHandler)async delegate
		{
			if (_totalEmailSync == 0)
			{
				LoadingIndicator.StopLoading();
			}
			if (e.StatusCode != HttpStatusCode.OK)
			{
				if (IsSyncPeopleCompleted())
				{
					DisplaySyncPopup();
					_ssmService.GetBuddyListAsync();
				}
			}
			else
			{
				ChatOnService.Instance.IsBuddiesUpdated = true;
				List<Buddy> newBuddies = _buddyService.AddBuddyFromXml(e.Xml);
				if (newBuddies.Count > 0 && GetTotalPeopleToSync() == 1)
				{
					await newBuddies[0].LoadProfileImage(_ssmService.GetBuddyProfileImageUri(newBuddies[0].PhoneNumber));
					Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_PS_ADDED").Replace("%s", newBuddies[0].Name));
				}
				_buddyToAdd = newBuddies.FirstOrDefault();
				if (_buddyToAdd != null)
				{
					_buddyToAdd.IsNew = true;
					Chat chat = _dataService.ChatItems.FirstOrDefault((Chat x) => x.Members.Contains(_buddyToAdd.PhoneNumber) && x.SingleChatBuddy == null && x.IsValidSession);
					if (chat != null)
					{
						chat.SingleChatBuddy = _buddyToAdd;
						_dataService.ChatDBSubmitChanges();
					}
					_dataService.BuddyDBSubmitChanges();
				}
				SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
				if (IsSyncPeopleCompleted())
				{
					DisplaySyncPopup(found: true);
					_ssmService.GetBuddyListAsync();
				}
			}
		});
	}

	private void DisplaySyncPopup(bool found = false)
	{
		int totalPeopleToSync = GetTotalPeopleToSync();
		int num = _peopleContacts.Sum((ContactInformation c) => c.Emails.Count);
		int num2 = _peopleContacts.Sum((ContactInformation c) => c.PhoneNumbers.Count);
		if (totalPeopleToSync > 1)
		{
			Utility.ShowSimpleToastNotification(Utility.GetResourceString("SS_CONTACT_SYNC"));
			return;
		}
		ContactInformation val = _peopleContacts.FirstOrDefault();
		bool flag = false;
		if (found)
		{
			return;
		}
		if (num == 1)
		{
			ContactField email = val.Emails.FirstOrDefault();
			flag = _dataService.BuddyItems.FirstOrDefault((Buddy x) => x.SamsungEmail == email.Value) != null;
		}
		else if (num2 == 1)
		{
			ContactField phone = val.PhoneNumbers.FirstOrDefault();
			flag = _dataService.BuddyItems.FirstOrDefault((Buddy x) => x.PhoneNumber.Contains(phone.Value)) != null;
		}
		if (flag)
		{
			Utility.ShowSimpleToastNotification(val.Name + " " + Utility.GetResourceString("IDS_CHATON_POP_ALREADY_ADDED"));
			return;
		}
		string empty = string.Empty;
		empty = Utility.GetResourceString("IDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER").Replace("%s", "{0:}");
		empty = string.Format(empty, new object[1] { val.Name });
		Utility.ShowSimpleToastNotification(empty);
	}

	private int GetTotalPeopleToSync()
	{
		int num = _peopleContacts.Sum((ContactInformation c) => c.Emails.Count);
		int num2 = _peopleContacts.Sum((ContactInformation c) => c.PhoneNumbers.Count);
		return num + num2;
	}

	private bool IsSyncPeopleCompleted()
	{
		if (_totalEmailSync == 0)
		{
			return _isUploadPhoneDone;
		}
		return false;
	}

	private async void _buddyService_AddBuddyByPeopleEmailCompleted(object sender, SSMCompletedEventArgs e)
	{
		_totalEmailSync--;
		await AddBuddyToLocalStorage(e);
	}

	private void Image_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		SearchByPhoneNumber();
	}

	private void SearchByPhoneNumber()
	{
		//IL_00e8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ee: Expected O, but got Unknown
		if (!string.IsNullOrEmpty(InputPhoneNumber.Text) && _code != null && !string.IsNullOrEmpty(_code.Code))
		{
			((Control)InputPhoneNumber).put_IsEnabled(false);
			((Control)InputPhoneNumber).put_IsEnabled(true);
			((UIElement)Text5).put_Visibility((Visibility)1);
			LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
			string text = InputPhoneNumber.Text;
			text = _code.Code + text;
			_isSearchByID = false;
			_searchingData = text;
			_resultList.Clear();
			_ssmService.AddBuddyAsync(text, isPrev: true);
		}
		else
		{
			string text2 = ((_code != null && !string.IsNullOrEmpty(_code.Code)) ? Utility.GetResourceString("IDS_CHATON_POP_INVALID_PHONE_NUMBER_FORMAT") : Utility.GetResourceString("IDS_CHATON_BODY_INVALID_COUNTRY_CODE"));
			MessageDialog val = new MessageDialog(text2);
			val.ShowAsync();
		}
	}

	private void Image_Tapped_2(object sender, TappedRoutedEventArgs e)
	{
		SearchByID();
	}

	private void SearchByID()
	{
		if (!isSearchByIdProcessing)
		{
			isSearchByIdProcessing = true;
			((UIElement)Text7).put_Visibility((Visibility)1);
			((UIElement)SearchIDResultList).put_Visibility((Visibility)1);
			_isUploadPhoneDone = true;
			LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
			_ssmService.GetUserPrivacyCompleted -= ssmService_GetUserPrivacyCompleted;
			_ssmService.GetUserPrivacyCompleted += ssmService_GetUserPrivacyCompleted;
			_ssmService.GetUserPrivacyAsync("emailsamsung", InputID.Text);
		}
	}

	private async void ssmService_GetUserPrivacyCompleted(object s, SSMCompletedEventArgs ex)
	{
		if (ex.StatusCode == HttpStatusCode.OK)
		{
			if (ex.Xml != null)
			{
				List<XElement> list = (from item in ex.Xml.Descendants("value")
					select (item)).ToList();
				if (bool.Parse(list[0].Value.ToString()))
				{
					_isSearchByID = true;
					_searchingData = InputID.Text;
					_resultList2.Clear();
					_ssmService.AddBuddyAsync(_searchingData.Trim(), isPrev: true);
				}
				else
				{
					_isSearchByID = true;
					_searchingData = InputID.Text;
					_resultList2.Clear();
					_ssmService.AddBuddyAsync(_searchingData.Trim(), isPrev: true);
					isSearchByIdProcessing = false;
				}
			}
		}
		else
		{
			try
			{
				if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"), showCancel: true, Utility.GetResourceString("IDS_CHATON_BODY_ERROR")))
				{
					await CheckAndRunNextStep();
				}
			}
			catch (Exception)
			{
			}
			finally
			{
				isSearchByIdProcessing = false;
			}
		}
		if (!isSearchByIdProcessing)
		{
			LoadingIndicator.StopLoading();
		}
	}

	private void Button_Click_1(object sender, RoutedEventArgs e)
	{
		Buddy buddy = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is Buddy buddy2)
		{
			_buddyToAdd = buddy2;
			if (LoadingIndicator.ActiveIndicator != null)
			{
				LoadingIndicator.StopLoading();
			}
			LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
			_isSearchByID = false;
			_searchingData = "+" + buddy2.PhoneNumber;
			_ssmService.AddBuddyAsync(_searchingData);
		}
	}

	private void Button_Click_2(object sender, RoutedEventArgs e)
	{
		Buddy buddy = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is Buddy buddy2)
		{
			_buddyToAdd = buddy2;
			if (LoadingIndicator.ActiveIndicator != null)
			{
				LoadingIndicator.StopLoading();
			}
			LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
			_isSearchByID = true;
			_searchingData = buddy2.SamsungEmail;
			_ssmService.AddBuddyAsync(_searchingData);
		}
	}

	private void IDButton_Click(object sender, RoutedEventArgs e)
	{
		((UIElement)PhoneNumberGrid).put_Visibility((Visibility)1);
		((UIElement)SearchIDGrid).put_Visibility((Visibility)0);
		((UIElement)PeopleGrid).put_Visibility((Visibility)1);
		((UIElement)TellFriendGrid).put_Visibility((Visibility)1);
	}

	private void PeopleButton_Click(object sender, RoutedEventArgs e)
	{
		((UIElement)PhoneNumberGrid).put_Visibility((Visibility)1);
		((UIElement)SearchIDGrid).put_Visibility((Visibility)1);
		((UIElement)PeopleGrid).put_Visibility((Visibility)0);
		((UIElement)TellFriendGrid).put_Visibility((Visibility)1);
	}

	private void PhoneNumberButton_Click(object sender, RoutedEventArgs e)
	{
		((UIElement)PhoneNumberGrid).put_Visibility((Visibility)0);
		((UIElement)SearchIDGrid).put_Visibility((Visibility)1);
		((UIElement)PeopleGrid).put_Visibility((Visibility)1);
		((UIElement)TellFriendGrid).put_Visibility((Visibility)1);
	}

	private void TellFriendButton_Click(object sender, RoutedEventArgs e)
	{
		ShowTellFriendFrame();
	}

	private void ShowTellFriendFrame()
	{
		((Selector)TellFriendsListBox).put_SelectedIndex(-1);
		((UIElement)PhoneNumberGrid).put_Visibility((Visibility)1);
		((UIElement)SearchIDGrid).put_Visibility((Visibility)1);
		((UIElement)PeopleGrid).put_Visibility((Visibility)1);
		((UIElement)TellFriendGrid).put_Visibility((Visibility)0);
	}

	private void PeopleList_Click(object sender, RoutedEventArgs e)
	{
		_buddyService.GetContactListAsync();
	}

	public static void OpenAddBuddyDialog(int index = 0)
	{
		AddBuddyDialog addBuddyDialog = new AddBuddyDialog(index);
		((FrameworkElement)addBuddyDialog).put_HorizontalAlignment((HorizontalAlignment)2);
		((FrameworkElement)addBuddyDialog).put_VerticalAlignment((VerticalAlignment)2);
		((FrameworkElement)addBuddyDialog).put_Margin(new Thickness(0.0, 0.0, 0.0, 100.0));
		PivotPage.ActiveInstance.OpenDialog((UserControl)(object)addBuddyDialog, closePrevPopup: true);
	}

	private void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		SelectCountryCodeDialog selectCountryCodeDialog = new SelectCountryCodeDialog();
		selectCountryCodeDialog.SelectionCompleted += dialog_SelectionCompleted;
		PivotPage.ActiveInstance.OpenDialog((UserControl)(object)selectCountryCodeDialog);
	}

	private void dialog_SelectionCompleted(object sender, object e)
	{
		SelectCountryCodeDialog selectCountryCodeDialog = null;
		if (sender is SelectCountryCodeDialog selectCountryCodeDialog2)
		{
			selectCountryCodeDialog2.SelectionCompleted -= dialog_SelectionCompleted;
			if (e is CountryCode)
			{
				_code = e as CountryCode;
				SelectedCountryCode.put_Text(_code.ToString());
				selectCountryCodeDialog2.Close();
			}
		}
	}

	private void TellFriendsListBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
	{
		switch (((Selector)TellFriendsListBox).SelectedIndex)
		{
		case 0:
			if (!SettingService.IsSignedOnToFacebook())
			{
				ConnectToFacebook();
				return;
			}
			PageNavigationService.OpenTellFriendsFacebookPage((Page)(object)PivotPage.ActiveInstance);
			break;
		case 1:
			if (!SettingService.GetSignedOnTwitter())
			{
				ConnectToTwitter();
				return;
			}
			PageNavigationService.OpenTellFriendsTwitterPage((Page)(object)PivotPage.ActiveInstance);
			break;
		}
		((Selector)TellFriendsListBox).put_SelectedIndex(-1);
	}

	private async void ConnectToMessenger()
	{
		ContactPicker picker = new ContactPicker();
		picker.put_CommitButtonText(Utility.GetResourceString("IDS_CHATON_SK_SELECT"));
		picker.put_SelectionMode((ContactSelectionMode)1);
		picker.DesiredFields.Add(KnownContactField.InstantMessage);
		await picker.PickSingleContactAsync();
	}

	private void ConnectToFacebook()
	{
		PageNavigationService.OpenSettingPage((Page)(object)PivotPage.ActiveInstance, "Manage Account");
	}

	private async void ConnectToTwitter()
	{
		try
		{
			string twitterLoginUrl = await TwitterService.GetTwitterLoginUrl();
			if (twitterLoginUrl == null)
			{
				return;
			}
			WebAuthenticationResult WebAuthenticationResult = await WebAuthenticationBroker.AuthenticateAsync((WebAuthenticationOptions)0, new Uri(twitterLoginUrl), new Uri(TwitterService.RedirectUri));
			if ((int)WebAuthenticationResult.ResponseStatus == 0)
			{
				if (string.IsNullOrEmpty(WebAuthenticationResult.ResponseData.ToString()))
				{
					return;
				}
				string oauth_token = null;
				string oauth_verifier = null;
				string[] keyValPairs = WebAuthenticationResult.ResponseData.ToString().Split('&');
				for (int i = 0; i < keyValPairs.Length; i++)
				{
					string[] array = keyValPairs[i].Split('=');
					switch (array[0].Replace(TwitterService.RedirectUri + "?", ""))
					{
					case "oauth_token":
						oauth_token = array[1];
						break;
					case "oauth_verifier":
						oauth_verifier = array[1];
						break;
					}
				}
				SettingService.SetTwitterOauthVerifier(oauth_verifier);
				if (await TwitterService.GetAccessToken(oauth_token, oauth_verifier))
				{
					SharetoTwitter();
				}
			}
			else
			{
				_ = WebAuthenticationResult.ResponseStatus;
				_ = 2;
			}
		}
		catch (Exception)
		{
			Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"), showCancel: true, Utility.GetResourceString("IDS_CHATON_BODY_ERROR"));
		}
		finally
		{
			LoadingIndicator.StopLoading();
		}
	}

	private async void SharetoTwitter()
	{
		if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_SHARE_CHATON_INVITATION_MESSAGE_Q"), showCancel: true, Utility.GetResourceString("IDS_CHATON_HEADER_TWITTER")))
		{
			if (LoadingIndicator.ActiveIndicator != null)
			{
				LoadingIndicator.StopLoading();
			}
			LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
			try
			{
				string postMessage = Utility.GetResourceString("IDS_CHATON_BODY_CHATON_INVITE_MESSAGE_ABB");
				postMessage = postMessage.Replace("\\n", "\n");
				await TwitterService.PostMessage(postMessage);
				await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_POSTED"), showCancel: false);
			}
			catch
			{
				Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_POSTING_FAILED"), showCancel: false);
			}
			LoadingIndicator.StopLoading();
		}
		PageNavigationService.OpenTellFriendsTwitterPage((Page)(object)PivotPage.ActiveInstance);
	}

	private void InputPhoneNumber_KeyUp_1(object sender, KeyRoutedEventArgs e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0008: Invalid comparison between Unknown and I4
		if ((int)e.Key == 13)
		{
			SearchByPhoneNumber();
		}
	}

	private void InputID_KeyUp_1(object sender, KeyRoutedEventArgs e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0008: Invalid comparison between Unknown and I4
		if ((int)e.Key == 13)
		{
			SearchByID();
		}
	}

	private void TellFriendsItemTapped(object sender, TappedRoutedEventArgs e)
	{
		TellFriendsItem tellFriendsItem = null;
		if (!(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is TellFriendsItem tellFriendsItem2))
		{
			return;
		}
		switch (tellFriendsItem2.Name.ToLower())
		{
		case "facebook":
			if (!SettingService.IsSignedOnToFacebook())
			{
				OpenFacebookLogin();
			}
			else
			{
				PageNavigationService.OpenTellFriendsFacebookPage((Page)(object)PivotPage.ActiveInstance);
			}
			break;
		case "twitter":
			if (!SettingService.GetSignedOnTwitter())
			{
				LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
				ConnectToTwitter();
			}
			else
			{
				PageNavigationService.OpenTellFriendsTwitterPage((Page)(object)PivotPage.ActiveInstance);
			}
			break;
		}
	}

	private async void OpenFacebookLogin()
	{
		try
		{
			string FacebookUrl = FacebookService.GetLoginUri().ToString();
			WebAuthenticationResult WebAuthenticationResult = await WebAuthenticationBroker.AuthenticateAsync((WebAuthenticationOptions)0, new Uri(FacebookUrl), new Uri(FacebookService.RedirectUri));
			if ((int)WebAuthenticationResult.ResponseStatus == 0)
			{
				if (!string.IsNullOrEmpty(WebAuthenticationResult.ResponseData.ToString()) && FacebookService.TryParseOAuthCallbackUri(new Uri(WebAuthenticationResult.ResponseData.ToString())) && FacebookService.OAuthResult.IsSuccess)
				{
					FacebookUser me = await FacebookService.GetMyInfomation();
					FacebookService.UserName = me.Name;
					SettingService.SetFacebookEmail(me.Name);
					SettingService.SetSignedOnToFacebook(isSignedOn: true);
					SharetoFacebook(me);
				}
			}
			else
			{
				_ = WebAuthenticationResult.ResponseStatus;
				_ = 2;
			}
		}
		catch (Exception)
		{
		}
	}

	public async void SharetoFacebook(FacebookUser user)
	{
		try
		{
			if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_SHARE_CHATON_INVITATION_MESSAGE_Q"), showCancel: true, Utility.GetResourceString("IDS_CHATON_BUTTON_FACEBOOK")))
			{
				try
				{
					string postMessage = Utility.GetResourceString("IDS_CHATON_BODY_CHATON_INVITE_MESSAGE_ABB");
					await FacebookService.PostMessage(message: postMessage.Replace("\\n", "\n"), receiverId: user.Id);
					await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_POSTED"), showCancel: false);
					((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)(-1), (DispatchedHandler)delegate
					{
						PageNavigationService.OpenTellFriendsFacebookPage((Page)(object)PivotPage.ActiveInstance);
					});
					return;
				}
				catch
				{
					Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_POSTING_FAILED"), showCancel: false);
					return;
				}
			}
			((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)(-1), (DispatchedHandler)delegate
			{
				PageNavigationService.OpenTellFriendsFacebookPage((Page)(object)PivotPage.ActiveInstance);
			});
		}
		catch (Exception)
		{
		}
	}

	private void InputID_GotFocus_1(object sender, RoutedEventArgs e)
	{
		//IL_0032: Unknown result type (might be due to invalid IL or missing references)
		//IL_003c: Expected O, but got Unknown
		if (InputID.Text == "example@samsung.com")
		{
			InputID.put_Text("");
			((Control)InputID).put_Foreground((Brush)new SolidColorBrush(Colors.Black));
		}
	}

	private void InputID_LostFocus_1(object sender, RoutedEventArgs e)
	{
		//IL_0037: Unknown result type (might be due to invalid IL or missing references)
		//IL_0041: Expected O, but got Unknown
		if (InputID.Text.Trim() == "")
		{
			InputID.put_Text("example@samsung.com");
			((Control)InputID).put_Foreground((Brush)new SolidColorBrush(Colors.Gray));
		}
	}

	private void Close_Click(object sender, RoutedEventArgs e)
	{
		((UIElement)this).put_Visibility((Visibility)1);
		if (PivotPage.ActiveInstance != null)
		{
			PivotPage.ActiveInstance.CloseAllPopup();
		}
		if (BuddyListPage.ActiveInstance != null)
		{
			BuddyListPage.ActiveInstance.StickyAppBar();
		}
	}

	private async Task CheckAndRunNextStep()
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
		if ((int)((UIElement)PhoneNumberGrid).Visibility == 0)
		{
			string text = InputPhoneNumber.Text;
			text = _code.Code + text;
			_ssmService.AddBuddyAsync(text, isPrev: true);
		}
		else if ((int)((UIElement)SearchIDGrid).Visibility == 0)
		{
			_ssmService.GetUserPrivacyAsync("emailsamsung", InputID.Text);
		}
		else if ((int)((UIElement)PeopleGrid).Visibility == 0)
		{
			_buddyService.GetContactListAsync();
		}
		else if ((int)((UIElement)TellFriendGrid).Visibility == 0)
		{
			if (!SettingService.GetSignedOnTwitter())
			{
				ConnectToTwitter();
			}
			else
			{
				PageNavigationService.OpenTellFriendsTwitterPage((Page)(object)PivotPage.ActiveInstance);
			}
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
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		//IL_011f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0129: Expected O, but got Unknown
		//IL_0135: Unknown result type (might be due to invalid IL or missing references)
		//IL_013f: Expected O, but got Unknown
		//IL_014b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0155: Expected O, but got Unknown
		//IL_0161: Unknown result type (might be due to invalid IL or missing references)
		//IL_016b: Expected O, but got Unknown
		//IL_0177: Unknown result type (might be due to invalid IL or missing references)
		//IL_0181: Expected O, but got Unknown
		//IL_01e5: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ef: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///AddBuddyDialog.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			PhoneNumberGrid = (Grid)((FrameworkElement)this).FindName("PhoneNumberGrid");
			PeopleGrid = (Grid)((FrameworkElement)this).FindName("PeopleGrid");
			SearchIDGrid = (Grid)((FrameworkElement)this).FindName("SearchIDGrid");
			TellFriendGrid = (Grid)((FrameworkElement)this).FindName("TellFriendGrid");
			TellFriendsListBox = (ListView)((FrameworkElement)this).FindName("TellFriendsListBox");
			Text6 = (TextBlock)((FrameworkElement)this).FindName("Text6");
			Text7 = (TextBlock)((FrameworkElement)this).FindName("Text7");
			SearchIDResultList = (ListView)((FrameworkElement)this).FindName("SearchIDResultList");
			InputID = (TextBox)((FrameworkElement)this).FindName("InputID");
			AddFromPeopleButton = (ImageButton)((FrameworkElement)this).FindName("AddFromPeopleButton");
			Text2 = (TextBlock)((FrameworkElement)this).FindName("Text2");
			Text4 = (TextBlock)((FrameworkElement)this).FindName("Text4");
			Text5 = (TextBlock)((FrameworkElement)this).FindName("Text5");
			InputPhoneNumber = (TextBox)((FrameworkElement)this).FindName("InputPhoneNumber");
			SelectedCountryCode = (TextBlock)((FrameworkElement)this).FindName("SelectedCountryCode");
			PhonenumberButton = (ImageButton)((FrameworkElement)this).FindName("PhonenumberButton");
			SearchButton = (ImageButton)((FrameworkElement)this).FindName("SearchButton");
			PeopleButton = (ImageButton)((FrameworkElement)this).FindName("PeopleButton");
			TellFriendButton = (ImageButton)((FrameworkElement)this).FindName("TellFriendButton");
			Text1 = (TextBlock)((FrameworkElement)this).FindName("Text1");
			CloseButton = (ImageButton)((FrameworkElement)this).FindName("CloseButton");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_004c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0052: Expected O, but got Unknown
		//IL_0071: Unknown result type (might be due to invalid IL or missing references)
		//IL_007b: Expected O, but got Unknown
		//IL_0081: Unknown result type (might be due to invalid IL or missing references)
		//IL_0087: Expected O, but got Unknown
		//IL_00a6: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b0: Expected O, but got Unknown
		//IL_00b6: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bc: Expected O, but got Unknown
		//IL_00db: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e5: Expected O, but got Unknown
		//IL_00eb: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f2: Expected O, but got Unknown
		//IL_0113: Unknown result type (might be due to invalid IL or missing references)
		//IL_011d: Expected O, but got Unknown
		//IL_0123: Unknown result type (might be due to invalid IL or missing references)
		//IL_012a: Expected O, but got Unknown
		//IL_014b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0155: Expected O, but got Unknown
		//IL_0156: Unknown result type (might be due to invalid IL or missing references)
		//IL_015d: Expected O, but got Unknown
		//IL_017e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0188: Expected O, but got Unknown
		//IL_0189: Unknown result type (might be due to invalid IL or missing references)
		//IL_0190: Expected O, but got Unknown
		//IL_01b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_01bb: Expected O, but got Unknown
		//IL_01c1: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c8: Expected O, but got Unknown
		//IL_01e9: Unknown result type (might be due to invalid IL or missing references)
		//IL_01f3: Expected O, but got Unknown
		//IL_0205: Unknown result type (might be due to invalid IL or missing references)
		//IL_020f: Expected O, but got Unknown
		//IL_0215: Unknown result type (might be due to invalid IL or missing references)
		//IL_021c: Expected O, but got Unknown
		//IL_023d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0247: Expected O, but got Unknown
		//IL_024d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0254: Expected O, but got Unknown
		//IL_0275: Unknown result type (might be due to invalid IL or missing references)
		//IL_027f: Expected O, but got Unknown
		//IL_0280: Unknown result type (might be due to invalid IL or missing references)
		//IL_0287: Expected O, but got Unknown
		//IL_02a8: Unknown result type (might be due to invalid IL or missing references)
		//IL_02b2: Expected O, but got Unknown
		//IL_02b8: Unknown result type (might be due to invalid IL or missing references)
		//IL_02bf: Expected O, but got Unknown
		//IL_02e0: Unknown result type (might be due to invalid IL or missing references)
		//IL_02ea: Expected O, but got Unknown
		//IL_02f9: Unknown result type (might be due to invalid IL or missing references)
		//IL_0303: Expected O, but got Unknown
		//IL_0312: Unknown result type (might be due to invalid IL or missing references)
		//IL_031c: Expected O, but got Unknown
		//IL_032b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0335: Expected O, but got Unknown
		//IL_0344: Unknown result type (might be due to invalid IL or missing references)
		//IL_034e: Expected O, but got Unknown
		//IL_035d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0367: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			UIElement val12 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val12, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val12, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(TellFriendsItemTapped));
			break;
		}
		case 2:
		{
			ButtonBase val11 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val11, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val11, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Button_Click_2));
			break;
		}
		case 3:
		{
			ButtonBase val10 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Button_Click_1));
			break;
		}
		case 4:
		{
			Selector val9 = (Selector)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SelectionChangedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(Selector.add_SelectionChanged)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(Selector.remove_SelectionChanged)), new SelectionChangedEventHandler(TellFriendsListBox_SelectionChanged));
			break;
		}
		case 5:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_GotFocus)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_GotFocus)), new RoutedEventHandler(InputID_GotFocus_1));
			UIElement val7 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(UIElement.add_LostFocus)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(UIElement.remove_LostFocus)), new RoutedEventHandler(InputID_LostFocus_1));
			UIElement val8 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<KeyEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(UIElement.add_KeyUp)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(UIElement.remove_KeyUp)), new KeyEventHandler(InputID_KeyUp_1));
			break;
		}
		case 6:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_2));
			break;
		}
		case 7:
			((ImageButton)target).Click += new RoutedEventHandler(PeopleList_Click);
			break;
		case 8:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 9:
		{
			FrameworkElement val2 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(InputPhoneNumber_Loaded));
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<KeyEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_KeyUp)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_KeyUp)), new KeyEventHandler(InputPhoneNumber_KeyUp_1));
			break;
		}
		case 10:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_1));
			break;
		}
		case 11:
			((ImageButton)target).Click += new RoutedEventHandler(PhoneNumberButton_Click);
			break;
		case 12:
			((ImageButton)target).Click += new RoutedEventHandler(IDButton_Click);
			break;
		case 13:
			((ImageButton)target).Click += new RoutedEventHandler(PeopleButton_Click);
			break;
		case 14:
			((ImageButton)target).Click += new RoutedEventHandler(TellFriendButton_Click);
			break;
		case 15:
			((ImageButton)target).Click += new RoutedEventHandler(Close_Click);
			break;
		}
		_contentLoaded = true;
	}
}
