using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Media.Imaging;
using System.Windows.Threading;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using com.sec.ssm.common;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using Microsoft.Phone.Tasks;
using Microsoft.Xna.Framework;

namespace ChatOn.ViewModels;

public class PivotPageViewModel : NotificationObject
{
	private PivotPage _page;

	private SSMService _ssmService;

	private BuddyService _buddyService;

	private MessageService _messageService;

	private ChatService _chatService;

	private DataService _dataService;

	private List<BuddySummary> _buddyItems;

	private List<BuddySummary> _tempList = new List<BuddySummary>();

	private ObservableCollection<BuddySummary> _showingItems = new ObservableCollection<BuddySummary>();

	private CollectionViewSource _chatItems = new CollectionViewSource();

	private List<BuddyListHeader> _headerItems;

	private int _selectedPivotIndex;

	private UserProfile _myProfile;

	private ObservableCollection<BuddiesSay> _memoList;

	private ObservableCollection<Buddy> _buddyRankItems;

	private PhotoChooserTask _photoChooser;

	private BitmapImage _profileImage;

	private DispatcherTimer _timer;

	private ListIndexSelector _selector;

	private WriteableBitmap _tempProfileBitmap;

	private bool _isSocketConnecting;

	private string _phoneNumberToBlock;

	private bool _isExiting;

	private SettingService.ListByType _buddyListType;

	private MarketplaceDetailTask _marketplaceDetailTask;

	public SettingService.ListByType BuddyListType
	{
		get
		{
			return _buddyListType;
		}
		set
		{
			_buddyListType = value;
			NotifyPropertyChanged(() => BuddyListType);
		}
	}

	public ObservableCollection<BuddiesSay> MemoList
	{
		get
		{
			return _memoList;
		}
		set
		{
			_memoList = value;
			NotifyPropertyChanged(() => MemoList);
		}
	}

	public UserProfile MyProfile
	{
		get
		{
			return _myProfile;
		}
		set
		{
			_myProfile = value;
			NotifyPropertyChanged(() => MyProfile);
		}
	}

	public List<BuddySummary> BuddyItems
	{
		get
		{
			return _buddyItems;
		}
		set
		{
			_buddyItems = value;
		}
	}

	public ObservableCollection<BuddySummary> ShowingItems
	{
		get
		{
			return _showingItems;
		}
		set
		{
			_showingItems = value;
		}
	}

	public CollectionViewSource ChatItems => _chatItems;

	public ObservableCollection<Buddy> BuddyRankItems
	{
		get
		{
			return _buddyRankItems;
		}
		set
		{
			_buddyRankItems = value;
			NotifyPropertyChanged(() => BuddyRankItems);
		}
	}

	public BitmapImage ProfileImage
	{
		get
		{
			return _profileImage;
		}
		set
		{
			_profileImage = value;
			NotifyPropertyChanged(() => ProfileImage);
		}
	}

	public int SelectedPivotIndex
	{
		get
		{
			return _selectedPivotIndex;
		}
		set
		{
			_selectedPivotIndex = value;
			if (_selectedPivotIndex == 0)
			{
				AddBuddyApplicationBarButton();
			}
			else if (_selectedPivotIndex == 1)
			{
				AddChatApplicationBarButton();
			}
			else if (_selectedPivotIndex == 2)
			{
				AddMyPageApplicationBarButton();
				_ssmService.GetMemoListAsync(RegistrationService.GetUserNumber());
			}
			NotifyPropertyChanged(() => SelectedPivotIndex);
		}
	}

	internal void ChangeBuddyListBy()
	{
		BuddyListType = ((SettingService.GetListByType() == SettingService.ListByType.ByBuddies) ? SettingService.ListByType.ByInteraction : SettingService.ListByType.ByBuddies);
		SettingService.SetListByType(BuddyListType);
		UpdateList();
		_page.BuddyGrid.Children.RemoveAt(1);
		ListBox listBox = new ListBox();
		listBox.Margin = new Thickness(14.0, 0.0, 0.0, 0.0);
		listBox.ItemsSource = ShowingItems;
		if (BuddyListType == SettingService.ListByType.ByBuddies)
		{
			listBox.ItemTemplate = ((FrameworkElement)(object)_page).Resources["BuddyListItemTemplate"] as DataTemplate;
		}
		else
		{
			listBox.ItemTemplate = ((FrameworkElement)(object)_page).Resources["BuddyListItemByInteractionTemplate"] as DataTemplate;
		}
		_page.BuddyGrid.Children.Add(listBox);
	}

	public PivotPageViewModel(PivotPage page)
	{
		//IL_002f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0039: Expected O, but got Unknown
		_page = page;
		_photoChooser = new PhotoChooserTask();
		((ChooserBase<PhotoResult>)(object)_photoChooser).Completed += photoChooser_Completed;
		_dataService = new DataService();
		_ssmService = new SSMService();
		_ssmService.UploadAddressCompleted += _ssmService_UploadAddressCompleted;
		_ssmService.GetBuddyCompleted += _ssmService_GetBuddyCompleted;
		_ssmService.UnreadMessageCompleted += _ssmService_UnreadMessageCompleted;
		_ssmService.GetVersionCompleted += _ssmService_GetVersionCompleted;
		_ssmService.GetMyProfileCompleted += _ssmService_GetMyProfileCompleted;
		_ssmService.GetMemoListCompleted += _ssmService_GetMemoListCompleted;
		_ssmService.DeleteMemoCompleted += _ssmService_DeleteMemoCompleted;
		_ssmService.GetInteractionCompleted += _ssmService_GetInteractionCompleted;
		_ssmService.UploadProfileImageCompleted += _ssmService_UploadProfileImageCompleted;
		_ssmService.GetBlindListCompleted += _ssmService_GetBlindListCompleted;
		_ssmService.UploadBlindListCompleted += _ssmService_UploadBlindListCompleted;
		_ssmService.GetInteractionHideListCompleted += _ssmService_GetInteractionHideListCompleted;
		_ssmService.BlockBuddyCompleted += _ssmService_BlockBuddyCompleted;
		_ssmService.GetTrunkListCompleted += _ssmService_GetTrunkListCompleted;
		_ssmService.GetLatestVersionCompleted += _ssmService_GetLatestVersionCompleted;
		_buddyService = new BuddyService(_dataService, _ssmService);
		_buddyService.GetContactListCompleted -= _buddyService_GetContactListCompleted;
		_buddyService.GetContactListCompleted += _buddyService_GetContactListCompleted;
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.GetUserNumber());
		_messageService = new MessageService(_dataService, _ssmService);
		_chatService.UpdateAllChatSummary();
		_chatItems.Source = _dataService.ChatItems;
		_chatItems.SortDescriptions.Add(new SortDescription("Date", ListSortDirection.Descending));
		_ssmService.GetVersionAsync(forceUpdate: false);
		_timer = new DispatcherTimer();
		_timer.Tick += _timer_Tick;
		_timer.Interval = TimeSpan.FromMilliseconds(40.0);
		BuddyListType = SettingService.GetListByType();
	}

	internal bool CheckCriticalUpdate()
	{
		if (_isExiting)
		{
			return true;
		}
		SSMServer serverInfo = SSMService.GetServerInfo();
		if (serverInfo.IsCritical)
		{
			((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
			{
				//IL_004a: Unknown result type (might be due to invalid IL or missing references)
				//IL_0050: Expected O, but got Unknown
				if (MessageBoxResult.OK == MessageBox.Show(ResContainer.IDS_CHATON_POP_NEW_VERSION_AVAILABLE_UPDATE_REQUIRED_TO_CONTINUE_UPDATE_NOW_Q, "", MessageBoxButton.OKCancel))
				{
					((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
					{
						//IL_0001: Unknown result type (might be due to invalid IL or missing references)
						//IL_000b: Expected O, but got Unknown
						_marketplaceDetailTask = new MarketplaceDetailTask();
						_marketplaceDetailTask.ContentIdentifier = Utility.GetProductID();
						_marketplaceDetailTask.ContentType = (MarketplaceContentType)1;
						_marketplaceDetailTask.Show();
					});
				}
				else
				{
					_isExiting = true;
					MessageBox.Show(ResContainer.IDS_CHATON_POP_APPLICATION_WILL_BE_CLOSED);
					Game val = new Game();
					val.Exit();
				}
			});
			return true;
		}
		return false;
	}

	private void _ssmService_GetLatestVersionCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode != HttpStatusCode.OK || !CheckCriticalUpdate())
		{
			UpdateUserProfile();
			UploadAddress();
			GetUnreadMessage();
			_ssmService.GetTrunkListAsync(_dataService);
		}
	}

	private void _ssmService_GetTrunkListCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Xml == null)
		{
			return;
		}
		List<UnreadTrunkInfo> unreadTrunkFromXml = TrunkService.GetUnreadTrunkFromXml(e.Xml);
		foreach (UnreadTrunkInfo item in unreadTrunkFromXml)
		{
			foreach (Chat chatItem in _dataService.ChatItems)
			{
				if (chatItem.SessionID == item.SessionID)
				{
					chatItem.UnreadTrunkMessageCount = item.UnreadCount;
					break;
				}
			}
		}
	}

	private void _ssmService_BlockBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			string text = e.ResultString;
			if (string.IsNullOrEmpty(text))
			{
				text = _phoneNumberToBlock;
				if (string.IsNullOrEmpty(text))
				{
					MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
					return;
				}
			}
			Buddy buddy = _buddyService.GetBuddy(text);
			if (buddy == null)
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
				return;
			}
			_buddyService.BlockBuddy(buddy);
			UpdateList();
			MakeBuddyRankList();
			MessageBox.Show(Utility.sprintf(ResContainer.IDS_CHATON_POP_PS_BLOCKED, buddy.Name));
		}
		else if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
		else
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
	}

	private void UpdateUserProfile()
	{
		UserProfile userProfile = RegistrationService.GetUserProfile();
		if (userProfile == null || string.IsNullOrEmpty(userProfile.PhoneNumber))
		{
			_ssmService.GetUserProfileAsync();
		}
		else
		{
			MyProfile = userProfile;
		}
		if (_profileImage == null && userProfile != null && !string.IsNullOrEmpty(userProfile.ProfileImagePath))
		{
			ProfileImage = Utility.LoadJpeg(userProfile.ProfileImagePath);
			ChatOnService.Instance.ProfileImage = ProfileImage;
		}
	}

	internal void AddBuddyApplicationBarButton()
	{
		//IL_0062: Unknown result type (might be due to invalid IL or missing references)
		//IL_0068: Expected O, but got Unknown
		//IL_0090: Unknown result type (might be due to invalid IL or missing references)
		//IL_0096: Expected O, but got Unknown
		//IL_0102: Unknown result type (might be due to invalid IL or missing references)
		//IL_0108: Expected O, but got Unknown
		//IL_00f5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fb: Expected O, but got Unknown
		//IL_0131: Unknown result type (might be due to invalid IL or missing references)
		//IL_0137: Expected O, but got Unknown
		//IL_0160: Unknown result type (might be due to invalid IL or missing references)
		//IL_0166: Expected O, but got Unknown
		//IL_018f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0195: Expected O, but got Unknown
		//IL_01be: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c4: Expected O, but got Unknown
		PivotPage page = _page;
		if (((PhoneApplicationPage)page).ApplicationBar.Buttons.Count != 2 || !(((ApplicationBarIconButton)/*isinst with value type is only supported in some contexts*/).Text == ResContainer.IDS_CHATON_BUTTON_SEARCH))
		{
			((PhoneApplicationPage)_page).ApplicationBar.Buttons.Clear();
			ApplicationBarIconButton val = new ApplicationBarIconButton(new Uri("\\icons\\appbtn_search.png", UriKind.Relative));
			val.Text = ResContainer.IDS_CHATON_BUTTON_SEARCH;
			val.Click += SearchButton_Click;
			ApplicationBarIconButton val2 = new ApplicationBarIconButton(new Uri("\\icons\\appbtn_add buddy.png", UriKind.Relative));
			val2.Text = ResContainer.IDS_CHATON_SK3_ADD_BUDDY;
			val2.Click += addBuddyButton_Click;
			((PhoneApplicationPage)page).ApplicationBar.Buttons.Add(val);
			((PhoneApplicationPage)page).ApplicationBar.Buttons.Add(val2);
			((PhoneApplicationPage)page).ApplicationBar.MenuItems.Clear();
			ApplicationBarMenuItem val3 = null;
			val3 = ((SettingService.GetListByType() == SettingService.ListByType.ByBuddies) ? new ApplicationBarMenuItem(ResContainer.IDS_CHATON_BUTTON2_LIST_BY_INTERACTION) : new ApplicationBarMenuItem(ResContainer.IDS_CHATON_BUTTON2_LIST_BY_BUDDY));
			val3.Click += listBy_Click;
			((PhoneApplicationPage)page).ApplicationBar.MenuItems.Add(val3);
			val3 = new ApplicationBarMenuItem(ResContainer.IDS_CHATON_HEADER_ADD_GROUP_ABB);
			val3.Click += editGroup_Click;
			((PhoneApplicationPage)page).ApplicationBar.MenuItems.Add(val3);
			val3 = new ApplicationBarMenuItem(ResContainer.IDS_CHATON_HEADER_GROUP_CHAT);
			val3.Click += GroupChatMenu_Click;
			((PhoneApplicationPage)page).ApplicationBar.MenuItems.Add(val3);
			val3 = new ApplicationBarMenuItem(ResContainer.IDS_CHATON_OPT_BROADCAST);
			val3.Click += broadCastButton_Click;
			((PhoneApplicationPage)page).ApplicationBar.MenuItems.Add(val3);
			val3 = new ApplicationBarMenuItem(ResContainer.IDS_CHATON_HEADER_SETTINGS);
			val3.Click += setting_Click;
			((PhoneApplicationPage)page).ApplicationBar.MenuItems.Add(val3);
		}
	}

	private void listBy_Click(object sender, EventArgs e)
	{
		ApplicationBarMenuItem val = (ApplicationBarMenuItem)((sender is ApplicationBarMenuItem) ? sender : null);
		ChangeBuddyListBy();
		if (SettingService.GetListByType() != SettingService.ListByType.ByBuddies)
		{
			val.Text = ResContainer.IDS_CHATON_BUTTON2_LIST_BY_BUDDY;
		}
		else
		{
			val.Text = ResContainer.IDS_CHATON_BUTTON2_LIST_BY_INTERACTION;
		}
	}

	private void addBuddyButton_Click(object sender, EventArgs e)
	{
		PageNavigationService.OpenAddBuddyPage((PhoneApplicationPage)(object)_page);
	}

	private void setting_Click(object sender, EventArgs e)
	{
		PageNavigationService.OpenSettingPage((PhoneApplicationPage)(object)_page);
	}

	private void SearchButton_Click(object sender, EventArgs e)
	{
		PageNavigationService.OpenSearchBuddyPage((PhoneApplicationPage)(object)_page);
	}

	private void editGroup_Click(object sender, EventArgs e)
	{
		PageNavigationService.OpenAddGroupPage((PhoneApplicationPage)(object)_page);
	}

	private void GroupChatMenu_Click(object sender, EventArgs e)
	{
		SelectBuddyPage.ChatType = ChatType.GROUP;
		SelectBuddyPage.SelectionCompleted += SelectBuddyPage_SelectionCompleted;
		SelectBuddyPage.SelectionCountLimit = ChatService.MAX_CHAT_MEMBERS - 1;
		PageNavigationService.OpenSelectBuddyPage((PhoneApplicationPage)(object)_page);
	}

	private void broadCastButton_Click(object sender, EventArgs e)
	{
		SelectBuddyPage.ChatType = ChatType.BROADCAST;
		SelectBuddyPage.SelectionCompleted += SelectBuddyPage_SelectionCompleted;
		SelectBuddyPage.SelectionCountLimit = ChatService.MAX_BROADCAST_MEMBERS - 1;
		PageNavigationService.OpenSelectBuddyPage((PhoneApplicationPage)(object)_page);
	}

	private void SelectBuddyPage_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= SelectBuddyPage_SelectionCompleted;
		ObservableCollection<BuddySummary> observableCollection = arg as ObservableCollection<BuddySummary>;
		if (observableCollection.Count == 0)
		{
			return;
		}
		List<string> list = new List<string>();
		foreach (BuddySummary item in observableCollection)
		{
			list.Add(item.Buddy.PhoneNumber);
		}
		string member = string.Join(",", list);
		string userNumber = RegistrationService.GetUserNumber();
		ChatService chatService = new ChatService(_dataService, _buddyService, userNumber);
		Chat chat = chatService.StartChat(list[0], member, SelectBuddyPage.ChatType);
		PageNavigationService.OpenChatDetailPage(chat, (PhoneApplicationPage)(object)_page);
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
	}

	private void BlindList_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= BlindList_SelectionCompleted;
		List<BuddySummary> list = arg as List<BuddySummary>;
		string xmlString = SSMService.MakeBlindListParam(list);
		_ssmService.UploadBlindListAsync(xmlString);
		object content = ((ContentControl)(object)((App)Application.Current).RootFrame).Content;
		PhoneApplicationPage val = (PhoneApplicationPage)((content is PhoneApplicationPage) ? content : null);
		LoadingIndicator value = new LoadingIndicator(val);
		(val as SelectBuddyPage).LayoutRoot.Children.Add(value);
	}

	internal void AddChatApplicationBarButton()
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_0028: Expected O, but got Unknown
		//IL_0050: Unknown result type (might be due to invalid IL or missing references)
		//IL_0056: Expected O, but got Unknown
		PivotPage page = _page;
		((PhoneApplicationPage)page).ApplicationBar.Buttons.Clear();
		ApplicationBarIconButton val = new ApplicationBarIconButton(new Uri("\\icons\\appbtn_group_chat.png", UriKind.Relative));
		val.Text = ResContainer.IDS_CHATON_SK2_GROUP_CHAT;
		val.Click += GroupChatMenu_Click;
		ApplicationBarIconButton val2 = new ApplicationBarIconButton(new Uri("\\icons\\appbtn_broadcast.png", UriKind.Relative));
		val2.Text = ResContainer.IDS_CHATON_SK2_BROADCAST;
		val2.Click += broadCastButton_Click;
		((PhoneApplicationPage)page).ApplicationBar.Buttons.Add(val);
		((PhoneApplicationPage)page).ApplicationBar.Buttons.Add(val2);
		((PhoneApplicationPage)page).ApplicationBar.MenuItems.Clear();
	}

	internal void AddMyPageApplicationBarButton()
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_0028: Expected O, but got Unknown
		PivotPage page = _page;
		((PhoneApplicationPage)page).ApplicationBar.Buttons.Clear();
		ApplicationBarIconButton val = new ApplicationBarIconButton(new Uri("\\icons\\appbtn_setting.png", UriKind.Relative));
		val.Text = ResContainer.IDS_CHATON_HEADER_SETTINGS;
		val.Click += settingButton_Click;
		((PhoneApplicationPage)page).ApplicationBar.Buttons.Add(val);
		((PhoneApplicationPage)page).ApplicationBar.MenuItems.Clear();
	}

	private void settingButton_Click(object sender, EventArgs e)
	{
		PageNavigationService.OpenSettingPage((PhoneApplicationPage)(object)_page);
	}

	private void blindListButton_Click(object sender, EventArgs e)
	{
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
		_ssmService.GetBlindListAsync();
	}

	private void _timer_Tick(object sender, EventArgs e)
	{
		if (_tempList.Count > 0)
		{
			BuddySummary item = _tempList.First();
			_showingItems.Add(item);
			_tempList.Remove(item);
		}
		else
		{
			_timer.Stop();
			_buddyService.UpdateTile();
		}
	}

	internal void MakeBuddyRankList()
	{
		ObservableCollection<Buddy> rankedBuddies = _buddyService.GetRankedBuddies();
		BuddyRankItems = rankedBuddies;
		if (SettingService.GetListByType() == SettingService.ListByType.ByInteraction)
		{
			UpdateList();
		}
	}

	private void _ssmService_GetVersionCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0040: Unknown result type (might be due to invalid IL or missing references)
		//IL_0046: Expected O, but got Unknown
		_ssmService.GetVersionCompleted -= _ssmService_GetVersionCompleted;
		SSMServer serverInfo = SSMService.GetServerInfo();
		if (string.IsNullOrEmpty(serverInfo.Key))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ERROR_OCCURRED_RESTARTING_CHATON_ING);
			Game val = new Game();
			val.Exit();
		}
		((PhoneApplicationPage)_page).ApplicationBar.IsVisible = true;
		_ssmService.GetLatestVersionAsync();
	}

	private void _ssmService_UnreadMessageCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Xml != null)
		{
			_messageService.ParseFromXml(e.Xml);
			_chatService.ReflectUnreadMessage();
			UpdateChatList();
		}
		else if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			_chatService.ResetUnreadMessage();
			_chatService.UpdateTileUnreadCount();
		}
		else if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
		_dataService.SubmitChanges();
	}

	private void _buddyService_GetContactListCompleted(object sender, BuddyManagerEventArgs e)
	{
		Utility.ShowSystemTrayProgress((PhoneApplicationPage)(object)_page, ResContainer.IDS_CHATON_POP_UPDATING_ING);
		_ssmService.UploadAddressListAsync(e.Result);
	}

	private void _ssmService_GetBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Xml != null)
		{
			_buddyService.AddBuddyFromXml(e.Xml);
			ChatOnService.Instance.IsBuddiesUpdated = true;
		}
		if (ChatOnService.Instance.IsBuddiesUpdated)
		{
			ChatOnService.Instance.IsBuddiesUpdated = false;
			UpdateList();
		}
		GetInteraction();
		_chatService.UpdateAllChatSummary();
		LoadBuddiesData();
		ShowBuddyOrTellFriends();
	}

	private void ShowBuddyOrTellFriends()
	{
		if (_buddyItems != null)
		{
			if (_buddyItems.Count == 0)
			{
				_page.TellFriendsPanel.Visibility = Visibility.Visible;
				_page.GetBuddyList().Visibility = Visibility.Collapsed;
			}
			else
			{
				_page.TellFriendsPanel.Visibility = Visibility.Collapsed;
				_page.GetBuddyList().Visibility = Visibility.Visible;
			}
		}
	}

	private void _ssmService_GetInteractionCompleted(object sender, SSMCompletedEventArgs e)
	{
		Utility.HideSystemTrayProgress((PhoneApplicationPage)(object)_page);
		if (e.StatusCode == HttpStatusCode.OK)
		{
			if (e.Xml != null)
			{
				_buddyService.ApplyRankFromXml(e.Xml);
				_dataService.SubmitChanges();
			}
			MakeBuddyRankList();
		}
	}

	private void _ssmService_UploadAddressCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK)
		{
			_buddyService.SetContactsUploadedFlag();
		}
		Utility.ShowSystemTrayProgress((PhoneApplicationPage)(object)_page, ResContainer.IDS_CHATON_POP_UPDATING_ING);
		GetBuddyList();
	}

	private void _ssmService_GetMyProfileCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Xml != null)
		{
			MyProfile = RegistrationService.ParseUserProfileFromXml(e.Xml);
		}
		else if (MyProfile == null)
		{
			MyProfile = new UserProfile();
		}
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		if (string.IsNullOrEmpty(_myProfile.Name))
		{
			_myProfile.Name = userAccount.Name;
		}
		if (string.IsNullOrEmpty(_myProfile.PhoneNumber))
		{
			_myProfile.PhoneNumber = userAccount.MSISDN;
		}
		RegistrationService.SaveUserProfile(MyProfile);
	}

	private void _ssmService_GetMemoListCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Xml != null)
		{
			MemoList = _buddyService.ParseMemoFromXml(e.Xml, out var _);
		}
	}

	private void _ssmService_DeleteMemoCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		long timeStamp = (long)e.Value;
		BuddiesSay buddiesSay = MemoList.FirstOrDefault((BuddiesSay c) => c.TimeStamp == timeStamp);
		if (buddiesSay != null)
		{
			MemoList.Remove(buddiesSay);
		}
	}

	private void _ssmService_UploadProfileImageCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error == null)
		{
			MyProfile.ProfileImagePath = RegistrationService.DefaultProfilePath;
			RegistrationService.SaveUserProfile(MyProfile);
			Utility.SaveToJpeg(MyProfile.ProfileImagePath, _tempProfileBitmap, _tempProfileBitmap.PixelWidth, _tempProfileBitmap.PixelHeight);
			ProfileImage = Utility.LoadJpeg(MyProfile.ProfileImagePath);
			ChatOnService.Instance.ProfileImage = ProfileImage;
			_page.ProfileImageStory.Begin();
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
		SelectBuddyPage.SelectionCompleted += BlindList_SelectionCompleted;
		PageNavigationService.OpenSelectBuddyPage((PhoneApplicationPage)(object)_page);
	}

	private void _ssmService_UploadBlindListCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
	}

	private void _ssmService_GetInteractionHideListCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Xml != null)
		{
			_buddyService.ApplyInteractionHideListFromXml(e.Xml);
		}
		_ssmService.GetInteractionAsync();
	}

	internal void UploadAddress()
	{
		Utility.ShowSystemTrayProgress((PhoneApplicationPage)(object)_page, ResContainer.IDS_CHATON_BODY_LOADING_ING);
		_buddyService.GetContactListAsync();
	}

	internal void GetUnreadMessage()
	{
		_ssmService.GetUnReadMessageListAsync();
	}

	internal void StartChat(Buddy buddy)
	{
		Chat chat = _chatService.StartChat(buddy.PhoneNumber, buddy.PhoneNumber, ChatType.SINGLE);
		PageNavigationService.OpenChatDetailPage(chat, (PhoneApplicationPage)(object)_page);
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
	}

	public void OpenPhotoChooser()
	{
		_photoChooser.ShowCamera = true;
		((ChooserBase<PhotoResult>)(object)_photoChooser).Show();
	}

	private void photoChooser_Completed(object sender, PhotoResult e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Invalid comparison between Unknown and I4
		if ((int)((TaskEventArgs)e).TaskResult == 1)
		{
			((UIElement)(object)_page).Visibility = Visibility.Collapsed;
			ChatOnService.Instance.StreamToCrop = e.ChosenPhoto;
			((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
			{
				ImageCropPage.CropCompleted += ImageCropPage_CropCompleted;
				PageNavigationService.OpenImageCropPage((PhoneApplicationPage)(object)_page, 200, 200);
				DispatcherTimer dispatcherTimer = new DispatcherTimer();
				dispatcherTimer.Interval = TimeSpan.FromMilliseconds(200.0);
				dispatcherTimer.Tick += visibilityTimer_Tick;
				dispatcherTimer.Start();
			});
		}
	}

	private void visibilityTimer_Tick(object sender, EventArgs e)
	{
		((UIElement)(object)_page).Visibility = Visibility.Visible;
		(sender as DispatcherTimer).Stop();
	}

	private void ImageCropPage_CropCompleted(object sender, object arg)
	{
		_tempProfileBitmap = arg as WriteableBitmap;
		_ssmService.UploadProfileImageAsync(_tempProfileBitmap);
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
	}

	internal void OpenBuddiesSayContexMenu(FrameworkElement element)
	{
		BuddiesSay tag = element.DataContext as BuddiesSay;
		LightContextMenu lightContextMenu = new LightContextMenu();
		LightMenuItem lightMenuItem = new LightMenuItem(ResContainer.IDS_CHATON_OPT_DELETE_ABB);
		lightMenuItem.OnExecute += deleteMemo_OnExecute;
		lightMenuItem.Tag = tag;
		lightContextMenu.MenuItems.Add(lightMenuItem);
		lightContextMenu.Open((PhoneApplicationPage)(object)_page, _page.LayoutRoot, element);
	}

	internal void OpenBuddyItemContexMenu(FrameworkElement element)
	{
		BuddySummary buddySummary = element.DataContext as BuddySummary;
		Buddy buddy = buddySummary.Buddy;
		if (buddy != null)
		{
			LightContextMenu lightContextMenu = new LightContextMenu();
			LightMenuItem lightMenuItem = new LightMenuItem(ResContainer.IDS_CHATON_OPT_VIEW_PROFILE);
			lightMenuItem.Tag = buddy;
			lightMenuItem.OnExecute += viewProfile_OnExecute;
			lightContextMenu.MenuItems.Add(lightMenuItem);
			if (buddy.IsShowPhoneNumber)
			{
				lightMenuItem = new LightMenuItem(ResContainer.IDS_CHATON_OPT_CALL);
				lightMenuItem.Tag = buddy;
				lightMenuItem.OnExecute += call_OnExecute;
				lightContextMenu.MenuItems.Add(lightMenuItem);
			}
			lightMenuItem = new LightMenuItem(ResContainer.IDS_CHATON_SK_CHAT_LITE);
			lightMenuItem.Tag = buddy;
			lightMenuItem.OnExecute += chat_OnExecute;
			lightContextMenu.MenuItems.Add(lightMenuItem);
			lightMenuItem = new LightMenuItem(ResContainer.WP7_CHATON_PIN_TO_START2);
			lightMenuItem.Tag = buddy;
			lightMenuItem.OnExecute += pinToStart_OnExecute;
			lightContextMenu.MenuItems.Add(lightMenuItem);
			lightMenuItem = (buddy.IsFavorite ? new LightMenuItem(ResContainer.IDS_CHATON_OPT2_REMOVE_FROM_FAVOURITES_ABB) : new LightMenuItem(ResContainer.IDS_CHATON_OPT_ADD_TO_FAVOURITES));
			lightMenuItem.Tag = buddy;
			lightMenuItem.OnExecute += addToFavorite_OnExecute;
			lightContextMenu.MenuItems.Add(lightMenuItem);
			lightMenuItem = new LightMenuItem(ResContainer.IDS_CHATON_OPT_BLOCK_BUDDY);
			lightMenuItem.Tag = buddy;
			lightMenuItem.OnExecute += blockBuddy_OnExecute;
			lightContextMenu.MenuItems.Add(lightMenuItem);
			lightContextMenu.Open((PhoneApplicationPage)(object)_page, _page.LayoutRoot, element);
		}
	}

	internal void OpenChatItemContexMenu(FrameworkElement element)
	{
		if (element.DataContext is Chat tag)
		{
			LightContextMenu lightContextMenu = new LightContextMenu();
			LightMenuItem lightMenuItem = new LightMenuItem(ResContainer.IDS_CHATON_OPT1_CLOSE_CHAT);
			lightMenuItem.Tag = tag;
			lightMenuItem.OnExecute += closeChat_OnExecute;
			lightContextMenu.MenuItems.Add(lightMenuItem);
			lightContextMenu.Open((PhoneApplicationPage)(object)_page, _page.LayoutRoot, element);
		}
	}

	private void closeChat_OnExecute(object sender, EventArgs e)
	{
		if (MessageBoxResult.OK == MessageBox.Show(ResContainer.IDS_CHATON_POP_CHAT_AND_TRUNK_WILL_BE_DELETED, ResContainer.IDS_CHATON_SK2_CLOSE_CHAT, MessageBoxButton.OKCancel))
		{
			Chat chat = (sender as LightMenuItem).Tag as Chat;
			if (!string.IsNullOrEmpty(chat.SessionID))
			{
				LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
				_page.LayoutRoot.Children.Add(value);
				SocketService.Instance.Reset();
				SocketService.Instance.Chat = chat;
				SocketService.Instance.ToEndChat = true;
				SocketService.Instance.EndChatReplyReceived += _socketService_EndChatReplyReceived;
				SocketService.Instance.Connected += _socketService_Connected;
				SocketService.Instance.OnSocketError += _socketService_OnSocketError;
				_isSocketConnecting = true;
				SocketService.Instance.Init();
			}
			else
			{
				_chatService.CloseChat(chat);
			}
		}
	}

	private void _socketService_OnSocketError(object sender, object arg)
	{
		SocketService.Instance.OnSocketError -= _socketService_OnSocketError;
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			if (_isSocketConnecting)
			{
				_isSocketConnecting = false;
				LoadingIndicator.StopLoading();
				MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
			}
		});
	}

	private void _socketService_Connected(object sender, SocketEventArgs e)
	{
		SocketService.Instance.Connected -= _socketService_Connected;
		SocketService.Instance.SendCloseMsg();
	}

	private void _socketService_EndChatReplyReceived(object sender, object arg)
	{
		SocketService.Instance.EndChatReplyReceived -= _socketService_EndChatReplyReceived;
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			LoadingIndicator.StopLoading();
		});
		EndChatReply endChatReply = arg as EndChatReply;
		if (endChatReply.Result.ResultCode == 1000 || endChatReply.Result.ResultCode == 3006 || endChatReply.Result.ResultCode == 3003)
		{
			((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
			{
				_chatService.CloseChat((sender as SocketService).Chat);
				DispatcherTimer dispatcherTimer = new DispatcherTimer();
				dispatcherTimer.Interval = TimeSpan.FromMilliseconds(500.0);
				dispatcherTimer.Tick += timer_Tick;
				dispatcherTimer.Start();
			});
		}
	}

	private void timer_Tick(object sender, EventArgs e)
	{
		(sender as DispatcherTimer).Stop();
		SocketService.Instance.Disconnect();
	}

	private void viewProfile_OnExecute(object sender, EventArgs e)
	{
		Buddy buddy = (sender as LightMenuItem).Tag as Buddy;
		OpenBuddyProfilePage(buddy.PhoneNumber);
	}

	private void call_OnExecute(object sender, EventArgs e)
	{
		Buddy buddy = (sender as LightMenuItem).Tag as Buddy;
		BuddyService.CallToBuddy(buddy);
	}

	private void chat_OnExecute(object sender, EventArgs e)
	{
		Buddy buddy = (sender as LightMenuItem).Tag as Buddy;
		StartChat(buddy);
	}

	private void blockBuddy_OnExecute(object sender, EventArgs e)
	{
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
		Buddy buddy = (sender as LightMenuItem).Tag as Buddy;
		_phoneNumberToBlock = buddy.PhoneNumber;
		_ssmService.BlockBuddyAsync(buddy.PhoneNumber);
	}

	private void addToFavorite_OnExecute(object sender, EventArgs e)
	{
		Buddy buddy = (sender as LightMenuItem).Tag as Buddy;
		buddy.IsFavorite = !buddy.IsFavorite;
		UpdateList();
		_dataService.SubmitChanges();
	}

	private void pinToStart_OnExecute(object sender, EventArgs e)
	{
		Buddy buddy = (sender as LightMenuItem).Tag as Buddy;
		BuddyService.PinToStart(buddy);
	}

	private void deleteMemo_OnExecute(object sender, EventArgs e)
	{
		BuddiesSay buddiesSay = (sender as LightMenuItem).Tag as BuddiesSay;
		_ssmService.DeleteMemoAsync(buddiesSay.PhoneNumber, buddiesSay.TimeStamp, fromMyProfile: true);
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
	}

	internal void LoadProfileData()
	{
		MyProfile = RegistrationService.GetUserProfile();
		ProfileImage = ChatOnService.Instance.ProfileImage;
		if (ChatOnService.Instance.IsProfileImageUpdated)
		{
			ChatOnService.Instance.IsProfileImageUpdated = false;
			_page.ProfileImageStory.Begin();
		}
	}

	internal void LoadBuddiesData()
	{
		_buddyService.LoadBuddiesProfileImage();
	}

	internal void UpdateList()
	{
		_showingItems.Clear();
		_buddyService.MakeListByType(SettingService.GetListByType(), ref _buddyItems, ref _headerItems, IsoSettingHelper.Get("ShowBirthday", defaultValue: true), showGroup: true);
		ShowBuddyOrTellFriends();
		_tempList.Clear();
		foreach (BuddySummary buddyItem in _buddyItems)
		{
			_tempList.Add(buddyItem);
		}
		_timer.Start();
	}

	internal void GetBuddyList()
	{
		_ssmService.GetBuddyListAsync();
	}

	internal void GetInteraction()
	{
		_ssmService.GetInteractionAsync();
	}

	internal void OpenBuddyProfilePage(string number)
	{
		Buddy buddy = _buddyService.GetBuddy(number);
		if (buddy != null)
		{
			if (buddy.IsBlocked)
			{
				SplashPopup.Show(_page.LayoutRoot, ResContainer.IDS_CHATON_POP_BUDDY_BLOCKED_TO_UNBLOCK_GO_TO_SETTINGS_BLOCK_LIST);
			}
			else
			{
				PageNavigationService.OpenBuddyProfilePage((PhoneApplicationPage)(object)_page, number);
			}
		}
		else
		{
			AddUnknownBuddyPage.BuddyAdded += AddUnknownBuddyPage_BuddyAdded;
			PageNavigationService.OpenAddUnknownBuddyPage((PhoneApplicationPage)(object)_page, number);
		}
	}

	private void AddUnknownBuddyPage_BuddyAdded(object sender, object arg)
	{
		foreach (Chat chatItem in _dataService.ChatItems)
		{
			_chatService.UpdateChatSummary(chatItem);
		}
	}

	internal void ShowIndexSelector()
	{
		if (_selector != null)
		{
			_selector.IndexSource = _headerItems;
			if (BuddyListType == SettingService.ListByType.ByBuddies)
			{
				_selector.ListType = ListIndexSelectorType.CharIndex;
			}
			else
			{
				_selector.ListType = ListIndexSelectorType.TitleIndex;
			}
			_selector.Open();
			return;
		}
		ListIndexSelector listIndexSelector = new ListIndexSelector((PhoneApplicationPage)(object)_page);
		listIndexSelector.IndexSource = _headerItems;
		ListIndexSelector listIndexSelector2 = listIndexSelector;
		listIndexSelector2.IndexSelected += selector_IndexSelected;
		if (BuddyListType == SettingService.ListByType.ByBuddies)
		{
			listIndexSelector2.ListType = ListIndexSelectorType.CharIndex;
		}
		else
		{
			listIndexSelector2.ListType = ListIndexSelectorType.TitleIndex;
		}
		listIndexSelector2.Open();
		_page.LayoutRoot.Children.Add(listIndexSelector2);
		_selector = listIndexSelector2;
	}

	private void selector_IndexSelected(object sender, object e)
	{
		BuddyListHeader buddyListHeader = e as BuddyListHeader;
		ScrollViewer scrollViewer = Utility.GetScrollViewer(_page.GetBuddyList());
		scrollViewer.ScrollToVerticalOffset(buddyListHeader.Index);
	}

	internal void TellFriends()
	{
		BuddyService.TellFriends();
	}

	internal void EditProfieImage()
	{
		if (string.IsNullOrEmpty(_myProfile.ProfileImagePath))
		{
			OpenPhotoChooser();
		}
		else
		{
			PageNavigationService.OpenProfileImageViewerPage((PhoneApplicationPage)(object)_page);
		}
	}

	internal void UpdateChatList()
	{
		_chatItems.View.Refresh();
	}

	internal void OpenBuddyProfile(FrameworkElement element)
	{
		BuddiesSay buddiesSay = element.DataContext as BuddiesSay;
		if (buddiesSay.PhoneNumber == RegistrationService.GetUserNumber())
		{
			return;
		}
		Buddy buddy = _buddyService.GetBuddy(buddiesSay.PhoneNumber);
		if (buddy != null)
		{
			if (buddy.IsBlocked)
			{
				SplashPopup.Show(_page.LayoutRoot, ResContainer.IDS_CHATON_POP_BUDDY_BLOCKED_TO_UNBLOCK_GO_TO_SETTINGS_BLOCK_LIST);
			}
			else
			{
				PageNavigationService.OpenBuddyProfilePage((PhoneApplicationPage)(object)_page, buddiesSay.PhoneNumber);
			}
		}
		else
		{
			AddUnknownBuddyPage.BuddyAdded += AddUnknownBuddyPage_BuddyAdded;
			PageNavigationService.OpenAddUnknownBuddyPage((PhoneApplicationPage)(object)_page, buddiesSay.PhoneNumber);
		}
	}

	internal bool CheckBuddyExist(string phoneNumber)
	{
		Buddy buddy = _buddyService.GetBuddy(phoneNumber);
		return buddy != null;
	}
}
