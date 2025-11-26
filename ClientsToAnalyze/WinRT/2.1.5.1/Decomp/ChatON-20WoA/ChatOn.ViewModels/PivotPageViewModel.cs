using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using System.Xml.Linq;
using ChatON_WoA.Controls;
using ChatON_WoA.DataModel;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Queue;
using ChatOn.Services;
using com.sec.ssm.common;
using Windows.ApplicationModel.Search;
using Windows.Foundation;
using Windows.Storage;
using Windows.System;
using Windows.UI;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.StartScreen;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.ViewModels;

public class PivotPageViewModel : NotificationObject
{
	public delegate void PivotPageEventHandler(object sender, object e);

	private readonly int SearchPaneMaxSuggestions;

	private PivotPage _page;

	private SSMService _ssmService;

	private BuddyService _buddyService;

	private MessageService _messageService;

	private ChatService _chatService;

	private DataService _dataService;

	private List<UserProfileImage> _profileImageList;

	private List<BuddySummary> _buddyItems;

	private List<BuddySummary> _tempList;

	private ObservableCollection<BuddySummary> _showingItems;

	private ObservableCollection<Chat> _chatItems;

	private ObservableCollection<BuddyListHeader> _headerItems;

	private int _selectedPivotIndex;

	private UserProfile _myProfile;

	private ObservableCollection<BuddiesSay> _memoList;

	private ObservableCollection<BuddiesSay> _memoListTemp;

	private ObservableCollection<InteractionRank> _buddyRankItems;

	private BitmapImage _profileImage;

	private DispatcherTimer _timer;

	private bool _isSocketConnecting;

	private bool _isExiting;

	private bool _isRenameMode;

	private int _selectedIndex;

	private int _newBuddyCount;

	private int _newChatCount;

	private int _newCommentCount;

	private int _newTrunkCommentCount;

	private Visibility _trunkButtonVisibility;

	private SearchPane _searchPane;

	public bool IsStartChatMode;

	private BuddySummary _lastBuddy;

	private List<string> _blockedList;

	private UserControl _lastOpenedDialog;

	public double PivotHeaderHeight;

	public double PivotFooterHeight;

	private List<string> _mappingList;

	private BuddyGroup _selectedGroup;

	private BuddyGroup _deletedGroup;

	private Visibility _emptyChatGrid;

	public List<string> MappingList
	{
		get
		{
			if (MyProfile.PhoneNumber != null)
			{
				string item = (MyProfile.PhoneNumber.Contains("+") ? MyProfile.PhoneNumber : ("+" + MyProfile.PhoneNumber));
				if (_mappingList != null && MyProfile != null && _mappingList.Contains(item))
				{
					_mappingList.Remove(MyProfile.PhoneNumber);
				}
			}
			return _mappingList;
		}
		set
		{
			_mappingList = value;
			NotifyPropertyChanged(() => MappingList);
		}
	}

	public bool IsEmptyMemoList
	{
		get
		{
			if (MemoList != null)
			{
				return MemoList.Count == 0;
			}
			return false;
		}
	}

	public bool IsEmptyRankList
	{
		get
		{
			if (BuddyRankItems != null)
			{
				return BuddyRankItems.Count == 0;
			}
			return false;
		}
	}

	public Visibility TrunkButtonVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _trunkButtonVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_trunkButtonVisibility = value;
			NotifyPropertyChanged(() => TrunkButtonVisibility);
		}
	}

	public UserControl LastOpenedDialog => _lastOpenedDialog;

	public int SelectedIndex
	{
		get
		{
			return _selectedIndex;
		}
		set
		{
			if (_selectedIndex != value)
			{
				_selectedIndex = value;
				if (_selectedIndex != 0)
				{
					ClearNewBuddies();
				}
				if (_selectedIndex != 1)
				{
					LoadChatList();
				}
				_ = _selectedIndex;
				_ = 1;
				TrunkButtonVisibility = (Visibility)1;
				NotifyPropertyChanged(() => SelectedIndex);
			}
		}
	}

	public int NewBuddyCount
	{
		get
		{
			if (_buddyService != null)
			{
				return _buddyService.NewlyAddedCount;
			}
			return 0;
		}
	}

	public int NewChatCount
	{
		get
		{
			return _newChatCount;
		}
		set
		{
			_newChatCount = value;
			NotifyPropertyChanged(() => NewChatCount);
		}
	}

	public int NewCommentCount
	{
		get
		{
			return _newCommentCount;
		}
		set
		{
			_newCommentCount = value;
			NotifyPropertyChanged(() => NewCommentCount);
		}
	}

	public int NewTrunkCommentCount
	{
		get
		{
			return _newTrunkCommentCount;
		}
		set
		{
			_newTrunkCommentCount = value;
			NotifyPropertyChanged(() => NewTrunkCommentCount);
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

	public ObservableCollection<BuddyListHeader> HeaderItems
	{
		get
		{
			return _headerItems;
		}
		set
		{
			_headerItems = value;
			NotifyPropertyChanged(() => HeaderItems);
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

	public ObservableCollection<Chat> ChatItems
	{
		get
		{
			return _chatItems;
		}
		set
		{
			_chatItems = value;
			if (_chatItems.Count > 0)
			{
				EmptyChatGridVisibility = (Visibility)1;
			}
			NotifyPropertyChanged(() => ChatItems);
			NotifyPropertyChanged(() => EmptyChatGridVisibility);
		}
	}

	public ObservableCollection<InteractionRank> BuddyRankItems
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

	public bool IsNewNotice { get; set; }

	public bool IsRenameMode
	{
		get
		{
			return _isRenameMode;
		}
		set
		{
			_isRenameMode = value;
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
			if (_selectedPivotIndex != 0 && _selectedPivotIndex != 1 && _selectedPivotIndex == 2)
			{
				UpdateMemoList();
			}
			NotifyPropertyChanged(() => SelectedPivotIndex);
		}
	}

	public ChatService ChatService => _chatService;

	public Visibility EmptyChatGridVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _emptyChatGrid;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_emptyChatGrid = value;
			NotifyPropertyChanged(() => EmptyChatGridVisibility);
		}
	}

	public event PivotPageEventHandler GetBuddyCompleted;

	public event PivotPageEventHandler UpdateGetBuddyCompleted;

	internal async Task UpdateMemoList()
	{
		foreach (BuddiesSay memo in MemoList)
		{
			memo.NotifyPropertyChanged("ProfileImage");
		}
		await Task.Run(delegate
		{
			_ssmService.GetMemoListAsync(RegistrationService.ChatOnID);
		});
	}

	internal void SyncContact()
	{
		SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
		_ssmService.GetBuddyListAsync();
	}

	public void UpdateSuggestionsCount()
	{
		int suggestionsCount = _dataService.RecommendeeItems.Where((UnknownUser p) => p._isUpdating).Count();
		_page.SetSuggestionsCount(suggestionsCount);
	}

	public void UpdateSuggestionsCount(int total)
	{
		_page.SetSuggestionsCount(total);
	}

	internal void UploadAddress()
	{
		Utility.ShowSystemTrayProgress((Page)(object)_page, Utility.GetResourceString("IDS_CHATON_BODY_LOADING_ING"));
		_buddyService.GetContactListAsync();
	}

	internal void ChangeBuddyListBy()
	{
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Expected O, but got Unknown
		UpdateList();
		ListBox val = new ListBox();
		((FrameworkElement)val).put_Margin(new Thickness(14.0, 0.0, 0.0, 0.0));
		((ItemsControl)val).put_ItemsSource((object)ShowingItems);
		_003F val2 = val;
		object obj = ((IDictionary<object, object>)((FrameworkElement)_page).Resources)[(object)"BuddyListItemTemplate"];
		((ItemsControl)val2).put_ItemTemplate((DataTemplate)((obj is DataTemplate) ? obj : null));
	}

	public PivotPageViewModel()
	{
		//IL_0061: Unknown result type (might be due to invalid IL or missing references)
		SearchPaneMaxSuggestions = 5;
		_tempList = new List<BuddySummary>();
		_showingItems = new ObservableCollection<BuddySummary>();
		_chatItems = new ObservableCollection<Chat>();
		_memoList = new ObservableCollection<BuddiesSay>();
		_memoListTemp = new ObservableCollection<BuddiesSay>();
		_buddyRankItems = new ObservableCollection<InteractionRank>();
		_lastBuddy = new BuddySummary();
		_blockedList = new List<string>();
		_emptyChatGrid = (Visibility)1;
		base._002Ector();
	}

	public PivotPageViewModel(PivotPage page)
	{
		//IL_0063: Unknown result type (might be due to invalid IL or missing references)
		//IL_033f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0345: Expected O, but got Unknown
		DispatchedHandler val = null;
		SearchPaneMaxSuggestions = 5;
		_tempList = new List<BuddySummary>();
		_showingItems = new ObservableCollection<BuddySummary>();
		_chatItems = new ObservableCollection<Chat>();
		_memoList = new ObservableCollection<BuddiesSay>();
		_memoListTemp = new ObservableCollection<BuddiesSay>();
		_buddyRankItems = new ObservableCollection<InteractionRank>();
		_lastBuddy = new BuddySummary();
		_blockedList = new List<string>();
		_emptyChatGrid = (Visibility)1;
		base._002Ector();
		_page = page;
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
		_ssmService.GetBlindListCompleted += _ssmService_GetBlindListCompleted;
		_ssmService.UploadBlindListCompleted += _ssmService_UploadBlindListCompleted;
		_ssmService.GetInteractionHideListCompleted += _ssmService_GetInteractionHideListCompleted;
		_ssmService.BlockBuddyCompleted += _ssmService_BlockBuddyCompleted;
		_ssmService.GetTrunkListCompleted += _ssmService_GetTrunkListCompleted;
		_ssmService.GetLatestVersionCompleted += _ssmService_GetLatestVersionCompleted;
		_ssmService.GetBuddyRecommendListCompleted += _ssmService_GetBuddyRecommendListCompleted;
		_ssmService.AddBuddyCompleted += _ssmService_AddBuddyCompleted;
		_ssmService.InvalidAccountDetected += _ssmService_InvalidAccountDetected;
		_ssmService.GetBuddyGroupListCompleted += _ssmService_GetBuddyGroupListCompleted;
		_ssmService.GetChatListInfoCompleted += _ssmService_GetChatListInfoCompleted;
		_ssmService.GetGroupPushCompleted += _ssmService_GetGroupPushCompleted;
		_ssmService.GetMappingInfoCompleted += _ssmService_GetMappingInfoCompleted;
		_ssmService.GetUserProfileImageHistoryCompleted += _ssmService_GetUserProfileImageHistoryCompleted;
		_ssmService.GetBlockListCompleted += _ssmService_GetBlockListCompleted;
		_buddyService = new BuddyService(_dataService, _ssmService);
		_buddyService.GetContactListCompleted += _buddyService_GetContactListCompleted;
		_ssmService.GetAllMessageCompleted += _ssmService_GetAllMessageCompleted;
		_chatService = new ChatService(_ssmService, _dataService, _buddyService, RegistrationService.ChatOnID);
		_messageService = new MessageService(_dataService, _ssmService);
		ChatOnService.Instance.UserProfile = RegistrationService.GetUserProfile();
		CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
		if (val == null)
		{
			val = (DispatchedHandler)async delegate
			{
				_ssmService.GetVersionAsync(forceUpdate: false);
				if (_selectedIndex == 1)
				{
					UpdateChatList();
				}
			};
		}
		dispatcher.RunAsync((CoreDispatcherPriority)(-1), val);
	}

	public void NotifyMemoList()
	{
		NotifyPropertyChanged(() => MyProfile);
		NotifyPropertyChanged(() => "");
		foreach (BuddiesSay memo in MemoList)
		{
			memo.NotifyPropertyChanged("");
		}
	}

	internal void ClearNewBuddies()
	{
		//IL_01b2: Unknown result type (might be due to invalid IL or missing references)
		//IL_01bc: Expected O, but got Unknown
		//IL_01dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_01e7: Expected O, but got Unknown
		try
		{
			if (_buddyItems == null)
			{
				return;
			}
			List<BuddySummary> list = new List<BuddySummary>();
			BuddyListHeader newHeaderItem = _headerItems.FirstOrDefault((BuddyListHeader x) => x.HeaderType == BuddyListHeaderType.New);
			List<BuddySummary> list2 = _showingItems.Where((BuddySummary x) => x.Type == BuddySummary.ItemType.Index).ToList();
			if (newHeaderItem != null && list2.Count > 0)
			{
				BuddySummary buddySummary = _showingItems.FirstOrDefault((BuddySummary x) => x.HeaderType == newHeaderItem.HeaderType && x.HeaderName == newHeaderItem.Title);
				if (buddySummary != null)
				{
					int num = _showingItems.IndexOf(buddySummary);
					BuddySummary nextHeader = list2[list2.IndexOf(buddySummary) + 1];
					BuddySummary item = _showingItems.FirstOrDefault((BuddySummary x) => x.HeaderType == nextHeader.HeaderType && x.HeaderName == nextHeader.HeaderName);
					int num2 = _showingItems.IndexOf(item);
					for (int num3 = num2 - 1; num3 >= num; num3--)
					{
						BuddySummary buddySummary2 = _showingItems[num3];
						if (buddySummary2 != null)
						{
							list.Add(buddySummary2);
						}
						BuddySummary item2 = _showingItems.FirstOrDefault((BuddySummary x) => x.Type == BuddySummary.ItemType.Index && x.HeaderType == BuddyListHeaderType.New);
						_showingItems.Remove(item2);
						_headerItems.Remove(newHeaderItem);
					}
					for (int num4 = 0; num4 < list.Count; num4++)
					{
						_showingItems.Remove(list.ElementAt(num4));
						list.ElementAt(num4).Background = new SolidColorBrush(Colors.Transparent);
						if (list.ElementAt(num4).Buddy != null)
						{
							list.ElementAt(num4).Buddy.Background = (Brush)new SolidColorBrush(Colors.Transparent);
						}
					}
					List<Buddy> list3 = _dataService.BuddyItems.Where((Buddy x) => x.IsNew).ToList();
					if (list3.Count > 0)
					{
						for (int num5 = 0; num5 < list3.Count; num5++)
						{
							list3.ElementAt(num5).IsNew = false;
						}
						_dataService.BuddyDBSubmitChanges();
					}
					_buddyService.NewlyAddedCount = 0;
				}
			}
			list.Clear();
			NotifyPropertyChanged(() => NewBuddyCount);
			NotifyPropertyChanged(() => ShowingItems);
			NotifyPropertyChanged(() => BuddyItems);
		}
		catch (Exception)
		{
		}
	}

	public unsafe void ActivateSearchPane()
	{
		_searchPane = SearchPane.GetForCurrentView();
		SearchPane searchPane = _searchPane;
		WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<SearchPane, SearchPaneSuggestionsRequestedEventArgs>, EventRegistrationToken>(searchPane, (nint)__ldftn(SearchPane.add_SuggestionsRequested)), new Action<EventRegistrationToken>(searchPane, (nint)__ldftn(SearchPane.remove_SuggestionsRequested)), _searchPane_SuggestionsRequested);
		SearchPane searchPane2 = _searchPane;
		WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<SearchPane, SearchPaneQuerySubmittedEventArgs>, EventRegistrationToken>(searchPane2, (nint)__ldftn(SearchPane.add_QuerySubmitted)), new Action<EventRegistrationToken>(searchPane2, (nint)__ldftn(SearchPane.remove_QuerySubmitted)), _searchPane_QuerySubmitted);
	}

	private void _searchPane_QuerySubmitted(SearchPane sender, SearchPaneQuerySubmittedEventArgs args)
	{
		if ((object)((Page)_page).Frame.CurrentSourcePageType == typeof(SearchBuddyPage) && ((Page)_page).Frame.CanGoBack)
		{
			((Page)_page).Frame.GoBack();
		}
		((Page)_page).Frame.Navigate(typeof(SearchBuddyPage), (object)args.QueryText);
	}

	private void _searchPane_SuggestionsRequested(SearchPane sender, SearchPaneSuggestionsRequestedEventArgs args)
	{
		foreach (Buddy buddyItem in _dataService.BuddyItems)
		{
			if (!string.IsNullOrEmpty(buddyItem.Name))
			{
				if (buddyItem.Name.IndexOf(sender.QueryText, StringComparison.CurrentCultureIgnoreCase) != -1)
				{
					args.Request.SearchSuggestionCollection.AppendQuerySuggestion(buddyItem.Name);
				}
				if (args.Request.SearchSuggestionCollection.Size >= SearchPaneMaxSuggestions)
				{
					break;
				}
			}
		}
	}

	internal bool CheckCriticalUpdate()
	{
		//IL_0032: Unknown result type (might be due to invalid IL or missing references)
		//IL_003c: Expected O, but got Unknown
		//IL_006b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0075: Expected O, but got Unknown
		if (_isExiting)
		{
			return true;
		}
		SSMServer serverInfo = SSMService.GetServerInfo();
		if (serverInfo.IsCritical)
		{
			((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
			{
				if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NEW_VERSION_AVAILABLE_UPDATE_REQUIRED_TO_CONTINUE_UPDATE_NOW_Q")))
				{
					string text = "6E04A0BD.3483954CEF3A0_ez4k4b2fwzhz";
					Launcher.LaunchUriAsync(new Uri("ms-windows-store:PDP?PFN=" + text));
				}
				else
				{
					Application.Current.Exit();
				}
			});
			return true;
		}
		if (!serverInfo.IsUpToDate)
		{
			((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
			{
				if (!SettingService.GetHadShownUpdate())
				{
					if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NEW_VERSION_AVAILABLE_INSTALL_NOW_Q")))
					{
						string text = "6E04A0BD.3483954CEF3A0_ez4k4b2fwzhz";
						Launcher.LaunchUriAsync(new Uri("ms-windows-store:PDP?PFN=" + text));
					}
					else
					{
						SettingService.SetHadShownUpdate(option: true);
					}
				}
			});
			return true;
		}
		return false;
	}

	public async Task UpdateUserProfile()
	{
		UserProfile profile = RegistrationService.GetUserProfile();
		if (profile.ProfileImage == null)
		{
			profile.ProfileImage = new BitmapImage(new Uri(MyProfile.ProfileImagePath));
			MyProfile.ProfileImage = new BitmapImage(new Uri(MyProfile.ProfileImagePath));
		}
		await GetUserProfileImageHistory();
		if (profile != null)
		{
			MyProfile.CopyFromDownloaded(profile);
		}
		LoadingIndicator.StopLoading();
	}

	public void OnStartChat()
	{
		SelectBuddyPage.ChatType = ChatType.GROUP;
		SelectBuddyPage.Mode = SelectBuddyMode.StartChat;
		SelectBuddyPage.SelectionCompleted += SelectBuddyPage_SelectionCompleted;
		SelectBuddyPage.SelectionCountLimit = ChatService.MAX_CHAT_MEMBERS - 1;
		SelectBuddyPage.IsExceptSpecialBuddies = false;
	}

	public void OnStartBroadcast()
	{
		SelectBuddyPage.ChatType = ChatType.BROADCAST;
		SelectBuddyPage.Mode = SelectBuddyMode.StartBroadcast;
		SelectBuddyPage.SelectionCompleted += SelectBuddyPage_SelectionCompleted;
		SelectBuddyPage.SelectionCountLimit = ChatService.MAX_BROADCAST_MEMBERS - 1;
		SelectBuddyPage.IsExceptSpecialBuddies = false;
	}

	private async void SelectBuddyPage_SelectionCompleted(object sender, object arg)
	{
		LoadingIndicator.StopLoading();
		SelectBuddyPage.SelectionCompleted -= SelectBuddyPage_SelectionCompleted;
		ObservableCollection<BuddySummary> observableCollection = arg as ObservableCollection<BuddySummary>;
		if (observableCollection.Count == 0)
		{
			((Page)(sender as SelectBuddyPage)).Frame.GoBack();
			return;
		}
		List<string> list = new List<string>();
		foreach (BuddySummary item in observableCollection)
		{
			list.Add(item.Buddy.PhoneNumber);
		}
		string member = string.Join(",", list);
		string chatOnID = RegistrationService.ChatOnID;
		ChatService chatService = new ChatService(_dataService, _buddyService, chatOnID);
		ChatType chatType = SelectBuddyPage.ChatType;
		if (chatType == ChatType.GROUP && list.Count() == 1)
		{
			chatType = ChatType.SINGLE;
		}
		SSMService.GetServerInfo();
		Chat chat = chatService.StartChat(disconnect: false, list[0], member, chatType);
		((Page)(sender as SelectBuddyPage)).Frame.Navigate(typeof(PivotPage));
		_page.OpenChat(chat);
		UpdateChatList();
	}

	public void UpdateChatUnreadCount()
	{
		NewChatCount = _chatService.UpdateTileUnreadCount();
		NotifyPropertyChanged(() => NewChatCount);
	}

	public void UpdateTrunkUnreadCount()
	{
		NewTrunkCommentCount = _chatService.UpdateTrunkUnreadCount();
	}

	public void UpdateTrunkUnreadCount(Chat chat)
	{
		NewTrunkCommentCount = _chatService.UpdateTrunkUnreadCount(chat);
	}

	private async Task ShowAddBuddyFromPeople()
	{
		if (SettingService.IsShowAddBuddyFromPeoplePopup())
		{
			SettingService.SetShowAddBuddyFromPeoplePopup(value: false);
			if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("WP7_CHATON_ADD_FROM_PEOPLE_LIST")))
			{
				_buddyService.GetContactListAsync();
			}
		}
	}

	public void ShowBuddyOrTellFriends()
	{
		if (_dataService.BuddyItems.Count() < 1)
		{
			_page.ShowBuddyListFrame(showBuddyList: false);
		}
		else
		{
			if (_selectedIndex != 0)
			{
				return;
			}
			if (_dataService.BuddyItems.Count() > 0)
			{
				if (!_isRenameMode)
				{
					_page.ShowBuddyListFrame(showBuddyList: true);
				}
				_isRenameMode = false;
			}
			else
			{
				_page.ShowBuddyListFrame(showBuddyList: false);
			}
			if (BuddyItems.Count() == 0)
			{
				_page.ShowBuddyListFrame(showBuddyList: false);
			}
		}
	}

	internal async Task GetUnreadMessage()
	{
		await Task.Run(delegate
		{
			_ssmService.GetUnReadMessageListAsync();
		});
	}

	internal async Task<Chat> StartChat(Buddy buddy)
	{
		Chat result = _chatService.StartChat(disconnect: false, buddy.PhoneNumber, buddy.PhoneNumber, ChatType.SINGLE);
		UpdateChatList();
		return result;
	}

	private void timer_Tick(object sender, object e)
	{
		((DispatcherTimer)((sender is DispatcherTimer) ? sender : null)).Stop();
		SocketService.Instance.Disconnect();
	}

	internal void LoadProfileData()
	{
		//IL_004d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0057: Expected O, but got Unknown
		UserProfile userProfile = RegistrationService.GetUserProfile();
		userProfile.PhoneNumber = RegistrationService.GetUserAccount().MSISDN;
		if (MyProfile == null)
		{
			MyProfile = userProfile;
			if (!string.IsNullOrEmpty(MyProfile.ProfileImagePath))
			{
				MyProfile.ProfileImage = new BitmapImage(new Uri(MyProfile.ProfileImagePath));
			}
		}
		else
		{
			MyProfile.CopyFromDownloaded(userProfile);
		}
	}

	internal void LoadProfileImage(bool hide = false)
	{
		//IL_0013: Unknown result type (might be due to invalid IL or missing references)
		//IL_001d: Expected O, but got Unknown
		//IL_0029: Unknown result type (might be due to invalid IL or missing references)
		//IL_0033: Expected O, but got Unknown
		if (hide)
		{
			ProfileImage = null;
		}
		else
		{
			ProfileImage = new BitmapImage(GetUserProfileImage());
		}
		MyProfile.ProfileImage = new BitmapImage(GetUserProfileImage());
		NotifyPropertyChanged("");
	}

	internal Uri GetUserProfileImage()
	{
		return _ssmService.GetUserProfileImageUri();
	}

	internal void LoadBuddiesData()
	{
		_buddyService.LoadBuddiesProfileImage(ShowingItems);
	}

	public async void UpdateList(bool skipLaunchArgs = false)
	{
		await ((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			//IL_02ed: Unknown result type (might be due to invalid IL or missing references)
			//IL_02f7: Expected O, but got Unknown
			//IL_02c1: Unknown result type (might be due to invalid IL or missing references)
			//IL_02cb: Expected O, but got Unknown
			try
			{
				_buddyService.MakeListByType(SettingService.GetListByType(), ref _buddyItems, ref _headerItems, IsoSettingHelper.Get("ShowBirthday", defaultValue: true), showGroup: true, exceptSpecialBuddies: false, includeMe: true, showAll: true);
				if (!skipLaunchArgs)
				{
					if (string.IsNullOrEmpty(ChatOnService.Instance.LaunchArg) && !ChatOnService.Instance.LaunchArg.Contains("msgType") && !ChatOnService.Instance.LaunchArg.Contains("chatType") && !ChatOnService.Instance.LaunchArg.Contains("sessionID"))
					{
						ShowBuddyOrTellFriends();
					}
					else
					{
						OpenChatUsingArg();
					}
				}
				string text = "";
				foreach (BuddySummary buddy in _buddyItems)
				{
					if (buddy.Buddy != null)
					{
						_ = buddy.Buddy.PhoneNumber == text;
					}
					if (buddy.Buddy != null)
					{
						_ = buddy.Buddy.PhoneNumber == text;
					}
					BuddySummary buddySummary = _showingItems.FirstOrDefault((BuddySummary x) => (x.Buddy != null && x.Buddy.Equals(buddy.Buddy) && x.HeaderType.Equals(buddy.HeaderType)) || (x.Group != null && x.Group.Equals(buddy.Group) && x.HeaderType.Equals(buddy.HeaderType)) || (!x.Type.Equals(BuddySummary.ItemType.Buddy) && !x.Type.Equals(BuddySummary.ItemType.Group) && x.HeaderName != null && x.HeaderName.Equals(buddy.HeaderName)));
					if (buddySummary != null)
					{
						if (!buddySummary.Type.Equals(BuddySummary.ItemType.Buddy) && !buddySummary.Type.Equals(BuddySummary.ItemType.Group) && buddySummary.HeaderName != null && buddySummary.HeaderName.Equals(buddy.HeaderName) && buddySummary.Count != buddy.Count)
						{
							buddySummary.Count = buddy.Count;
						}
						if (buddySummary.ItemIndex != buddy.ItemIndex)
						{
							ShowingItems.Remove(buddySummary);
							buddySummary.ItemIndex = buddy.ItemIndex;
							ShowingItems.Insert(buddy.ItemIndex, buddySummary);
						}
					}
					else if (buddy.Buddy != null && buddy.Buddy.PhoneNumber.Equals(RegistrationService.ChatOnID))
					{
						if (!string.IsNullOrEmpty(SettingService.GetProfileImageFileName()))
						{
							StorageFolder localFolder = ApplicationData.Current.LocalFolder;
							buddy.Buddy.ProfileImage = new BitmapImage(new Uri(new Uri("ms-appx://"), localFolder.Path + "\\" + SettingService.GetProfileImageFileName()));
						}
						else
						{
							buddy.Buddy.ProfileImage = new BitmapImage(new Uri(new Uri("ms-appx://"), "/Images/chat_info_single.png"));
						}
						ShowingItems.Insert(1, buddy);
					}
					else if (buddy.ItemIndex >= 0)
					{
						BuddySummary buddySummary2 = _showingItems.FirstOrDefault((BuddySummary x) => x.Type == BuddySummary.ItemType.Index && ((x.HeaderName != null && x.HeaderName.Equals(buddy.HeaderName)) || x.HeaderType == buddy.HeaderType));
						if (buddySummary2 != null)
						{
							int num = _showingItems.IndexOf(buddySummary2);
							_ = buddySummary2.Count;
							if (buddy.ItemIndex <= num && buddy.Type != BuddySummary.ItemType.Index)
							{
								int nextInsertedIndex = GetNextInsertedIndex(buddy);
								buddy.ItemIndex = nextInsertedIndex;
								ShowingItems.Insert(nextInsertedIndex, buddy);
							}
							else
							{
								ShowingItems.Insert(buddy.ItemIndex, buddy);
							}
						}
						else
						{
							ShowingItems.Insert(buddy.ItemIndex, buddy);
						}
					}
				}
				List<BuddySummary> headers = ShowingItems.Where((BuddySummary x) => x.Type == BuddySummary.ItemType.Index).ToList();
				int i;
				for (i = 0; i < headers.Count; i++)
				{
					if (headers.ElementAt(i).HeaderType != BuddyListHeaderType.All && headers.ElementAt(i).HeaderType != BuddyListHeaderType.New && headers.ElementAt(i).HeaderType != BuddyListHeaderType.Me && headers.ElementAt(i).HeaderType != BuddyListHeaderType.Favorite && headers.ElementAt(i).HeaderType != BuddyListHeaderType.Group && headers.ElementAt(i).HeaderType != BuddyListHeaderType.Birthday && ShowingItems.Where((BuddySummary x) => x.Buddy != null && x.Buddy.IndexString == headers.ElementAt(i).HeaderName).Count() == 0)
					{
						BuddySummary item = ShowingItems.FirstOrDefault((BuddySummary x) => x.Type == BuddySummary.ItemType.Index && x.HeaderName == headers.ElementAt(i).HeaderName);
						ShowingItems.Remove(item);
					}
				}
				_showingItems.Where((BuddySummary x) => x.HeaderType == BuddyListHeaderType.New).ToList();
				_buddyService.LoadLocalBuddyProfileImage();
				NotifyPropertyChanged(() => NewBuddyCount);
				NotifyPropertyChanged(() => BuddyItems);
				NotifyPropertyChanged(() => ShowingItems);
				NotifyPropertyChanged(() => HeaderItems);
			}
			catch
			{
			}
		});
	}

	public int GetNextInsertedIndex(BuddySummary item)
	{
		List<BuddySummary> list = new List<BuddySummary>();
		int num = 0;
		list = _showingItems.Where((BuddySummary x) => x.Buddy != null && (x.HeaderType == item.HeaderType || (x.HeaderName != null && x.HeaderName.Equals(item.HeaderName)))).ToList();
		list.Add(item);
		if (item.Buddy != null)
		{
			list = new List<BuddySummary>(list.OrderBy((BuddySummary x) => x.Buddy.Name));
		}
		else
		{
			list.OrderBy((BuddySummary x) => x.Group.Name);
		}
		int num2 = list.IndexOf(item);
		if (num2 > 0)
		{
			return _showingItems.IndexOf(list[num2 - 1]) + 1;
		}
		BuddySummary item2 = ShowingItems.FirstOrDefault((BuddySummary x) => x.HeaderType == item.HeaderType || (x.HeaderName != null && x.HeaderName.Equals(item.HeaderName)));
		return ShowingItems.IndexOf(item2) + 1;
	}

	public void AddFavorite(Buddy buddy)
	{
		//IL_0035: Unknown result type (might be due to invalid IL or missing references)
		//IL_003f: Expected O, but got Unknown
		//IL_005e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0068: Expected O, but got Unknown
		try
		{
			BuddySummary buddySummary = new BuddySummary();
			buddySummary.Type = BuddySummary.ItemType.Buddy;
			buddySummary.Buddy = buddy;
			buddySummary.IsSpecialBuddy = false;
			buddySummary.Background = new SolidColorBrush(Color.FromArgb(byte.MaxValue, byte.MaxValue, 250, 135));
			buddySummary.Buddy.Background = (Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, byte.MaxValue, 250, 135));
			buddySummary.HeaderType = BuddyListHeaderType.Favorite;
			BuddySummary buddySummary2 = ShowingItems.FirstOrDefault((BuddySummary x) => x.HeaderType == BuddyListHeaderType.Favorite);
			if (buddySummary2 != null)
			{
				int favoriteIndex = GetFavoriteIndex(buddy);
				ShowingItems.Insert(favoriteIndex, buddySummary);
				if (BuddyListPage.ActiveInstance != null)
				{
					BuddyListPage.ActiveInstance.SelectBuddy(buddySummary, status: true);
				}
			}
			else
			{
				BuddySummary item = ShowingItems.FirstOrDefault((BuddySummary x) => x.HeaderType == BuddyListHeaderType.Me);
				int num = ShowingItems.IndexOf(item) + 1;
				BuddySummary buddySummary3 = new BuddySummary();
				buddySummary3.HeaderType = BuddyListHeaderType.Favorite;
				buddySummary3.HeaderName = Utility.GetResourceString("IDS_CHATON_BUTTON_FAVOURITE");
				buddySummary3.Type = BuddySummary.ItemType.Index;
				buddySummary3.Count = 1;
				BuddyListHeader buddyListHeader = new BuddyListHeader();
				buddyListHeader.Index = num;
				buddyListHeader.HeaderType = BuddyListHeaderType.Favorite;
				buddyListHeader.Title = Utility.GetResourceString("IDS_CHATON_BUTTON_FAVOURITE");
				HeaderItems.Insert(0, buddyListHeader);
				ShowingItems.Insert(num, buddySummary3);
				if (BuddyListPage.ActiveInstance != null)
				{
					BuddyListPage.ActiveInstance.SelectBuddy(buddySummary, status: true);
				}
				int index = num + 1;
				ShowingItems.Insert(index, buddySummary);
				if (BuddyListPage.ActiveInstance != null)
				{
					BuddyListPage.ActiveInstance.SelectBuddy(buddySummary, status: true);
				}
				NotifyPropertyChanged(() => HeaderItems);
			}
			string resourceString = Utility.GetResourceString("IDS_CHATON_POP_PS_ADDED_TO_FAVOURITES");
			string newValue = ((!string.IsNullOrEmpty(buddy.ProfileName)) ? buddy.ProfileName : buddy.Name);
			resourceString = resourceString.Replace("%s", newValue);
			Utility.ShowSimpleToastNotification(resourceString);
		}
		catch (Exception)
		{
			Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_FAILED_TO_ADD_TO_FAVOURITES"));
		}
	}

	private int GetFavoriteIndex(Buddy buddy)
	{
		int num = 0;
		List<BuddySummary> source = ShowingItems.Where((BuddySummary x) => x.HeaderType == BuddyListHeaderType.Favorite && x.Buddy != null).ToList();
		List<string> list = source.Select((BuddySummary x) => x.Buddy.Name).ToList();
		list.Add(buddy.Name);
		list.Sort();
		int num2 = list.IndexOf(buddy.Name);
		if (num2 == 0)
		{
			BuddySummary item = ShowingItems.FirstOrDefault((BuddySummary x) => x.HeaderType == BuddyListHeaderType.Favorite);
			return ShowingItems.IndexOf(item) + 1;
		}
		string prevBuddyName = list[num2 - 1];
		BuddySummary item2 = source.LastOrDefault((BuddySummary x) => x.Buddy.Name == prevBuddyName);
		return ShowingItems.IndexOf(item2) + 1;
	}

	public void RemoveFavorite(Buddy buddy)
	{
		try
		{
			List<BuddySummary> source = ShowingItems.Where((BuddySummary p) => p.HeaderType == BuddyListHeaderType.Favorite && p.Type == BuddySummary.ItemType.Buddy).ToList();
			List<BuddySummary> list = ShowingItems.Where((BuddySummary p) => p.HeaderType == BuddyListHeaderType.Favorite && p.Buddy == buddy).ToList();
			if (list != null && list.Count > 0)
			{
				for (int num = 0; num < list.Count; num++)
				{
					BuddyItems.Remove(list[num]);
					ShowingItems.Remove(list[num]);
				}
				NotifyPropertyChanged(() => BuddyItems);
				NotifyPropertyChanged(() => ShowingItems);
			}
			List<BuddySummary> source2 = ShowingItems.Where((BuddySummary x) => x.HeaderType == BuddyListHeaderType.Favorite && x.Type == BuddySummary.ItemType.Index).ToList();
			BuddyListHeader item = HeaderItems.FirstOrDefault((BuddyListHeader x) => x.HeaderType == BuddyListHeaderType.Favorite);
			if (source.Count() == 1)
			{
				ShowingItems.Remove(source2.FirstOrDefault());
				HeaderItems.Remove(item);
			}
			NotifyPropertyChanged(() => ShowingItems);
			NotifyPropertyChanged(() => HeaderItems);
			string newValue = ((!string.IsNullOrEmpty(buddy.ProfileName)) ? buddy.ProfileName : buddy.Name);
			string resourceString = Utility.GetResourceString("IDS_CHATON_OPT_REMOVE_FROM_FAVOURITES");
			resourceString = resourceString.Replace("%s", newValue);
			Utility.ShowSimpleToastNotification(resourceString);
		}
		catch (Exception)
		{
			Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_FAILED_TO_REMOVE_FROM_FAVOURITES"));
		}
	}

	public async void OpenChatUsingArg()
	{
		string param = ChatOnService.Instance.LaunchArg;
		if (param.Contains("Group"))
		{
			DispatchedHandler val = null;
			Guid guid = default(Guid);
			ref Guid reference = ref guid;
			reference = new Guid(param.Replace("Group", ""));
			BuddyGroup group = _dataService.BuddyGroups.FirstOrDefault((BuddyGroup c) => c.GroupID == guid);
			if (group == null)
			{
				return;
			}
			CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)delegate
				{
					_page.OpenChat(group);
				};
			}
			await dispatcher.RunAsync((CoreDispatcherPriority)0, val);
			ChatOnService.Instance.LaunchArg = "";
			return;
		}
		if (param.Contains("WNS?IP="))
		{
			string[] p = param.Split('?', '&');
			string sessionID = "";
			string senderNumber = "";
			string address = "";
			int port = 0;
			ChatType type = ChatType.SINGLE;
			string[] array = p;
			foreach (string text in array)
			{
				string[] array2 = text.Split('=');
				if (array2[0] == "IP")
				{
					address = array2[1];
				}
				else if (array2[0] == "PORT")
				{
					port = int.Parse(array2[1]);
				}
				else if (array2[0] == "msgID")
				{
					long.Parse(array2[1]);
				}
				else if (array2[0] == "senderID")
				{
					senderNumber = array2[1];
				}
				else if (array2[0] == "msgType")
				{
					int.Parse(array2[1]);
				}
				else if (array2[0] == "chatType")
				{
					type = (ChatType)int.Parse(array2[1]);
				}
				else if (array2[0] == "sessionID")
				{
					sessionID = array2[1];
				}
				else if (array2[0] == "rc")
				{
					int.Parse(array2[1]);
				}
			}
			Buddy buddy = _buddyService.GetBuddy(senderNumber);
			if (senderNumber.Substring(0, 4) == "0999" || (buddy != null && buddy.IsSpecialBuddy))
			{
				_page.ShowBuddyListFrame(showBuddyList: true);
				return;
			}
			SSMService ssmService = new SSMService();
			DataService dataService = new DataService();
			BuddyService buddyService = new BuddyService(dataService, ssmService);
			ChatService chatService = new ChatService(dataService, buddyService, RegistrationService.GetUserNumber());
			Chat chat = chatService.StartChat(disconnect: false, senderNumber, senderNumber, (type != ChatType.BROADCAST) ? type : ChatType.SINGLE, sessionID);
			chat.Address = address;
			chat.Port = port;
			chat.IsChanged = true;
			chatService.UpdateChatSummary(chat);
			_buddyService.LoadBuddiesProfileImage(ShowingItems);
			await ((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
			{
				if (Window.Current != null)
				{
					UIElement content = Window.Current.Content;
					Frame val2 = (Frame)(object)((content is Frame) ? content : null);
					if (val2 != null && (object)val2.CurrentSourcePageType != typeof(PivotPage) && val2.CanGoBack)
					{
						do
						{
							val2.GoBack();
						}
						while ((object)val2.CurrentSourcePageType != typeof(PivotPage) && val2.CanGoBack);
					}
				}
				_page.OpenChat(chat);
			});
			ChatOnService.Instance.LaunchArg = "";
			return;
		}
		Buddy buddy2 = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == param);
		await ((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			if (Window.Current != null)
			{
				UIElement content = Window.Current.Content;
				Frame val2 = (Frame)(object)((content is Frame) ? content : null);
				if (val2 != null && (object)val2.CurrentSourcePageType != typeof(PivotPage) && val2.CanGoBack)
				{
					val2.GoBack();
				}
			}
			if (buddy2 != null)
			{
				_page.OpenChat(buddy2);
			}
		});
		ChatOnService.Instance.LaunchArg = "";
	}

	internal async void GetBuddyList()
	{
		await Task.Run(delegate
		{
			try
			{
				if (!SettingService.IsFirstTimeBuddySyncFinished())
				{
					SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
				}
				_ssmService.GetBuddyListAsync();
			}
			catch
			{
			}
		});
	}

	internal async Task GetBuddyListAsync()
	{
		await Task.Run(delegate
		{
			try
			{
				if (!SettingService.IsFirstTimeBuddySyncFinished())
				{
					SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
				}
				_ssmService.GetBuddyListAsync();
			}
			catch
			{
			}
		});
	}

	internal void OpenProfileDialog(BuddySummary item)
	{
		//IL_00e1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00eb: Expected O, but got Unknown
		//IL_016e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0178: Expected O, but got Unknown
		BuddySummary buddySummary = _showingItems.FirstOrDefault((BuddySummary s) => s.Type == BuddySummary.ItemType.BuddyProfile || s.Type == BuddySummary.ItemType.GroupProfile);
		bool flag = false;
		BuddySummary sum = new BuddySummary();
		if (item.Buddy != null)
		{
			if (item.Buddy.PhoneNumber == RegistrationService.ChatOnID)
			{
				return;
			}
			sum.Buddy = item.Buddy;
			sum.Type = BuddySummary.ItemType.BuddyProfile;
			if (buddySummary != null && buddySummary.Buddy == item.Buddy)
			{
				flag = true;
			}
		}
		else
		{
			sum.Group = item.Group;
			sum.Type = BuddySummary.ItemType.GroupProfile;
			if (buddySummary != null && buddySummary.Group == item.Group)
			{
				flag = true;
			}
		}
		foreach (BuddySummary showingItem in _showingItems)
		{
			showingItem.Background = new SolidColorBrush(Colors.Transparent);
		}
		if (flag)
		{
			_showingItems.Remove(buddySummary);
			return;
		}
		int num = 0;
		foreach (BuddySummary showingItem2 in _showingItems)
		{
			if (showingItem2.ColSpan <= item.ColSpan)
			{
				num++;
				continue;
			}
			break;
		}
		item.Background = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
		_showingItems.Insert(num, sum);
		buddySummary = _showingItems.FirstOrDefault((BuddySummary s) => (s.Type == BuddySummary.ItemType.BuddyProfile || s.Type == BuddySummary.ItemType.GroupProfile) && s != sum);
		_showingItems.Remove(buddySummary);
	}

	private async void AddUnknownBuddyPage_BuddyAdded(object sender, object arg)
	{
		foreach (Chat chat in _dataService.ChatItems)
		{
			await Task.Run(() => _chatService.UpdateChatSummary(chat, ((DependencyObject)PivotPage.ActiveInstance).Dispatcher));
		}
	}

	internal void TellFriends()
	{
		BuddyService.TellFriends();
	}

	internal void EditProfieImage()
	{
		if (!string.IsNullOrEmpty(_myProfile.ProfileImagePath))
		{
			PageNavigationService.OpenProfileImageViewerPage((Page)(object)_page);
		}
	}

	internal void UpdateChatList()
	{
		int i;
		for (i = _chatItems.Count() - 1; i >= 0; i--)
		{
			Chat chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c != null && c.ChatID == _chatItems[i].ChatID);
			if (chat == null)
			{
				_chatItems.RemoveAt(i);
			}
		}
		foreach (Chat chat2 in _dataService.ChatItems)
		{
			if (chat2 != null)
			{
				Chat chat3 = _chatItems.FirstOrDefault((Chat c) => c != null && c.ChatID == chat2.ChatID);
				chat2.UpdateChatSummary(_buddyService);
				if (chat3 == null)
				{
					_chatItems.Add(chat2);
				}
			}
		}
		if (ChatItems.Count > 0)
		{
			EmptyChatGridVisibility = (Visibility)1;
		}
		_dataService.SortChatItems();
		_dataService.ChatDBSubmitChanges();
		_dataService.SortShowingChatItems(ref _chatItems);
		NotifyPropertyChanged(() => ChatItems);
		NotifyPropertyChanged(() => EmptyChatGridVisibility);
	}

	internal Buddy GetBuddyFromNumber(string number)
	{
		return _buddyService.GetBuddy(number);
	}

	internal async void OpenUnknownBuddyPopup(string number)
	{
		if (!(number == RegistrationService.ChatOnID))
		{
			UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == number);
			if (unknownUser == null)
			{
				unknownUser = new UnknownUser();
				unknownUser.PhoneNumber = number;
				unknownUser.Name = Utility.GetResourceString("IDS_CHATON_BODY_UNKNOWN");
				_dataService.AddUnknownUser(unknownUser);
			}
			unknownUser.LoadProfileImage(applyTheme: true);
			unknownUser.SetMessage(unknownUser.Name);
			UnknownBuddyProfileDialog unknownBuddyProfileDialog = new UnknownBuddyProfileDialog();
			unknownBuddyProfileDialog.BuddyInfo = unknownUser;
			((FrameworkElement)unknownBuddyProfileDialog).put_HorizontalAlignment((HorizontalAlignment)1);
			((FrameworkElement)unknownBuddyProfileDialog).put_VerticalAlignment((VerticalAlignment)1);
			PivotPage.ActiveInstance.OpenDialog((UserControl)(object)unknownBuddyProfileDialog);
		}
	}

	internal void DeleteMemo(BuddiesSay memo)
	{
		_page.ShowLoading();
		_ssmService.DeleteMemoAsync(memo.PhoneNumber, memo.TimeStamp, fromMyProfile: true);
	}

	internal async Task<Chat> StartGroupChat(BuddyGroup group)
	{
		string[] p = Utility.Split(group.Members);
		return await _chatService.StartChatFromBuddyGroup(ChatType.GROUP, group, p[0]);
	}

	private void _socketService_OnSocketError(object sender, object arg)
	{
		//IL_0029: Unknown result type (might be due to invalid IL or missing references)
		//IL_0033: Expected O, but got Unknown
		SocketService.Instance.OnSocketError -= _socketService_OnSocketError;
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			if (_isSocketConnecting)
			{
				_isSocketConnecting = false;
			}
		});
	}

	private void _socketService_Connected(object sender, SocketEventArgs e)
	{
		SocketService.Instance.Connected -= _socketService_Connected;
		SocketService.Instance.SendCloseMsg();
	}

	private void _ssmService_GetTrunkListCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0035: Unknown result type (might be due to invalid IL or missing references)
		//IL_003f: Expected O, but got Unknown
		if (e.Xml == null)
		{
			return;
		}
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)(-1), (DispatchedHandler)delegate
		{
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
			NewTrunkCommentCount = _chatService.UpdateTrunkUnreadCount();
			NotifyPropertyChanged(() => NewTrunkCommentCount);
		});
	}

	private async void _ssmService_BlockBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK)
		{
			string resultString = e.ResultString;
			if (!string.IsNullOrEmpty(resultString) || !string.IsNullOrEmpty(resultString))
			{
				Buddy buddy = _buddyService.GetBuddy(resultString);
				if (buddy != null)
				{
					_buddyService.BlockBuddy(buddy);
					ChatOnService.Instance.IsBuddiesUpdated = true;
					ChatOnService.Instance.ReUpdateInteraction = true;
					RemoveBuddyFromShowingItems(buddy);
					UpdateList();
				}
			}
		}
		else
		{
			await SSMService.ShowCommonErrorMessage(e);
		}
	}

	private unsafe void _socketService_EndChatReplyReceived(object sender, object arg)
	{
		//IL_0046: Unknown result type (might be due to invalid IL or missing references)
		//IL_0050: Expected O, but got Unknown
		//IL_00a1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a7: Expected O, but got Unknown
		DispatchedHandler val = null;
		SocketService.Instance.EndChatReplyReceived -= _socketService_EndChatReplyReceived;
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
		});
		EndChatReply endChatReply = null;
		if (!(arg is EndChatReply endChatReply2) || (endChatReply2.Result.ResultCode != 1000 && endChatReply2.Result.ResultCode != 3006))
		{
			return;
		}
		CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
		if (val == null)
		{
			val = (DispatchedHandler)async delegate
			{
				_chatService.CloseChat((sender as SocketService).Chat);
				SocketService.Instance.Disconnect();
				DispatcherTimer val2 = new DispatcherTimer();
				val2.put_Interval(TimeSpan.FromMilliseconds(500.0));
				WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val2, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(DispatcherTimer.remove_Tick)), timer_Tick);
				val2.Start();
			};
		}
		dispatcher.RunAsync((CoreDispatcherPriority)0, val);
	}

	private void _ssmService_InvalidAccountDetected(object sender, SSMCompletedEventArgs e)
	{
	}

	private async void _ssmService_AddBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (await BuddyService.ShowAddBuddyResult(e, e.Param as string))
		{
			ChatOnService.Instance.IsBuddiesUpdated = true;
			List<Buddy> list = _buddyService.AddBuddyFromXml(e.Xml);
			if (list.Count > 0)
			{
				list[0].LoadProfileImage(_ssmService.GetBuddyProfileImageUri(list[0].PhoneNumber));
			}
			PivotPage.ActiveInstance.ViewModel.UpdateList();
		}
	}

	private void _ssmService_GetInteractionCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)(-1), (DispatchedHandler)async delegate
		{
			if (e.StatusCode != HttpStatusCode.NoContent && e.StatusCode == HttpStatusCode.OK && e.Xml != null)
			{
				await Task.Factory.StartNew(delegate
				{
					_buddyService.ApplyRankFromXml(e.Xml, ((DependencyObject)_page).Dispatcher);
				});
				_dataService.BuddyDBSubmitChanges();
			}
		});
	}

	private void _ssmService_UploadAddressCompleted(object sender, SSMCompletedEventArgs e)
	{
		SyncLoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			_buddyService.SetContactsUploadedFlag();
		}
		GetBuddyList();
	}

	private void _ssmService_GetMyProfileCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			try
			{
				if (e.Xml != null)
				{
					UserProfile downloadedProfile = RegistrationService.ParseUserProfileFromXml(e.Xml);
					MyProfile.CopyFromDownloaded(downloadedProfile);
				}
				else if (MyProfile == null)
				{
					MyProfile = new UserProfile();
				}
				UserAccountInfo account = RegistrationService.GetUserAccount();
				if (string.IsNullOrEmpty(_myProfile.Name))
				{
					_myProfile.Name = account.Name;
				}
				if (string.IsNullOrEmpty(_myProfile.PhoneNumber))
				{
					_myProfile.PhoneNumber = account.MSISDN;
				}
				if (MyProfile.ImageStatus == 1)
				{
					new Uri("about:blank");
					Uri currentProfileUri = (string.IsNullOrEmpty(MyProfile.ProfileImagePath) ? MyProfile.ProfileImage.UriSource : new Uri(MyProfile.ProfileImagePath));
					UserProfileImage profielUri = _profileImageList.FirstOrDefault((UserProfileImage x) => x.IsRepresent);
					Uri downloadedProfileImage;
					if (profielUri != null)
					{
						downloadedProfileImage = await Utility.GetLocalImageAsync(profielUri.ProfileImageUri, Guid.NewGuid().ToString());
						MyProfile.ProfileImageId = profielUri.ProfileImageId;
					}
					else
					{
						downloadedProfileImage = await Utility.GetLocalImageAsync(_ssmService.GetUserProfileImageUri(), Guid.NewGuid().ToString());
					}
					if (currentProfileUri != null && currentProfileUri.AbsoluteUri != "about:blank")
					{
						Uri currentProfileImage = new Uri($"ms-appdata://{new object[2]
						{
							currentProfileUri.LocalPath,
							UriKind.Absolute
						}}");
						if (await Utility.FilesAreEqual(downloadedProfileImage, currentProfileImage))
						{
							await Utility.DeleteFileFromLocalUri(downloadedProfileImage);
						}
						else
						{
							MyProfile.ProfileImage = new BitmapImage(downloadedProfileImage);
							MyProfile.ProfileImagePath = downloadedProfileImage.Segments.LastOrDefault();
							await Utility.DeleteFileFromLocalUri(currentProfileImage);
						}
					}
					else
					{
						MyProfile.ProfileImage = new BitmapImage(downloadedProfileImage);
					}
					BuddySummary itemMeShow = _showingItems.FirstOrDefault((BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber.Equals(RegistrationService.ChatOnID) && !((object)x.Buddy.ProfileImage).Equals((object)MyProfile.ProfileImage));
					string imageUri = ((!MyProfile.ProfileImage.UriSource.ToString().Contains("ms-appdata:/local/")) ? MyProfile.ProfileImage.UriSource.ToString() : MyProfile.ProfileImage.UriSource.ToString().Replace("ms-appdata:/local/", "ms-appdata:///local/"));
					itemMeShow.Buddy.Name = MyProfile.Name;
					itemMeShow.Buddy.ProfileName = MyProfile.Name;
					itemMeShow.Buddy.Status = MyProfile.Status;
					itemMeShow.Buddy.ProfileImage = new BitmapImage(new Uri(imageUri));
					NotifyPropertyChanged(() => ShowingItems);
				}
				MyProfile.ProfileImagePath = MyProfile.ProfileImage.UriSource.ToString();
				string[] fileNameParseResult = MyProfile.ProfileImagePath.Split('/');
				SettingService.SetProfileImageFileName(fileNameParseResult[fileNameParseResult.Length - 1]);
				RegistrationService.SaveUserProfile(MyProfile);
			}
			catch (Exception)
			{
			}
		});
	}

	private void _ssmService_GetMemoListCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			if (e.StatusCode != HttpStatusCode.NoContent && e.Xml != null)
			{
				ObservableCollection<BuddiesSay> observableCollection = new ObservableCollection<BuddiesSay>();
				observableCollection = _buddyService.ParseMemoFromXml(e.Xml, out var _);
				foreach (BuddiesSay item in observableCollection.OrderBy((BuddiesSay p) => p.TimeStamp))
				{
					ObservableCollection<BuddiesSay> memoList = MemoList;
					Func<BuddiesSay, bool> predicate = (BuddiesSay p) => p.TimeStamp == item.TimeStamp && p.Message == item.Message;
					if (memoList.Where(predicate).Count() == 0)
					{
						int index = 0;
						foreach (BuddiesSay memo in MemoList)
						{
							if (memo.TimeStamp > item.TimeStamp)
							{
								break;
							}
						}
						item.Message = item.Message;
						MemoList.Insert(index, item);
					}
				}
				IEnumerable<string> source = MemoList.Select((BuddiesSay x) => x.PhoneNumber).Distinct();
				_ssmService.CheckBuddySayProfileCompleted += _ssmService_CheckBuddySayProfileCompleted;
				for (int num = 0; num < source.Count(); num++)
				{
					_ssmService.CheckBuddySayProfileAsync(source.ElementAt(num));
				}
				NotifyPropertyChanged("");
			}
		});
	}

	private void _ssmService_CheckBuddySayProfileCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.NoContent || e.Xml == null)
		{
			return;
		}
		Buddy buddyFromNumber = GetBuddyFromNumber(e.ResultString);
		Buddy buddyInfo = _buddyService.ParseCheckBuddyInfos(e.Xml, buddyFromNumber);
		switch (buddyInfo.ImgStatus)
		{
		case Buddy.ProfileImgStatus.None:
			buddyInfo.IsDownloading = false;
			buddyInfo.ProfileImage = null;
			buddyInfo.ThumbProfileImage = null;
			buddyInfo.NotifyPropertyChanged("");
			_dataService.BuddyDBSubmitChanges();
			break;
		case Buddy.ProfileImgStatus.Deleted:
			buddyInfo.IsDownloading = false;
			buddyInfo.ProfileImage = null;
			buddyInfo.ThumbProfileImage = null;
			buddyInfo.NotifyPropertyChanged("");
			_dataService.BuddyDBSubmitChanges();
			break;
		case Buddy.ProfileImgStatus.Updated:
		{
			QueueEngine queueEngine = ((IDictionary<object, object>)Application.Current.Resources)[(object)"QueueEngine"] as QueueEngine;
			GetBuddyProfileImage_QueueItem getBuddyProfileImage_QueueItem = new GetBuddyProfileImage_QueueItem(_ssmService, buddyInfo.PhoneNumber);
			getBuddyProfileImage_QueueItem.InvokeBack = delegate(object o, Exception ex)
			{
				if (ex == null && o != null)
				{
					buddyInfo.IsDownloading = false;
					buddyInfo.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
					buddyInfo.ThumbProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
					buddyInfo.NotifyPropertyChanged("ProfileImage");
					buddyInfo.ImgStatus = Buddy.ProfileImgStatus.NoChanges;
					buddyInfo.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
					_dataService.BuddyDBSubmitChanges();
					if (MyPage.ActiveInstance != null)
					{
						MyPage.ActiveInstance.UpdateBuddyProfileImage(buddyInfo);
					}
				}
			};
			queueEngine?.Add(getBuddyProfileImage_QueueItem);
			break;
		}
		case Buddy.ProfileImgStatus.NoChanges:
			break;
		}
	}

	private async void _ssmService_DeleteMemoCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error != null)
		{
			MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"));
			await dialog.ShowAsync();
			return;
		}
		long timeStamp = (long)e.Value;
		BuddiesSay memo = MemoList.FirstOrDefault((BuddiesSay c) => c.TimeStamp == timeStamp);
		if (memo != null)
		{
			MemoList.Remove(memo);
		}
		NotifyPropertyChanged("");
	}

	private async void _ssmService_GetBlindListCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.NoContent)
		{
			return;
		}
		if (e.Error != null && e.StatusCode != HttpStatusCode.NoContent)
		{
			await SSMService.ShowCommonErrorMessage(e);
		}
		else
		{
			if (e.Xml == null)
			{
				return;
			}
			List<string> blindList = _buddyService.ParseBlindListFromXml(e.Xml);
			List<string> wholeBuddies = new List<string>();
			foreach (Buddy buddyItem in _dataService.BuddyItems)
			{
				wholeBuddies.Add(buddyItem.PhoneNumber);
			}
			if (blindList.Count > 0)
			{
				foreach (string item in blindList)
				{
					wholeBuddies.Remove(item);
				}
			}
			PageNavigationService.OpenSelectBuddyPage((Page)(object)_page);
		}
	}

	private void _ssmService_UploadBlindListCompleted(object sender, SSMCompletedEventArgs e)
	{
		Utility.SafetyGoBack((Page)(object)_page);
	}

	private void _ssmService_GetInteractionHideListCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode != HttpStatusCode.NoContent && e.Xml != null)
		{
			_buddyService.ApplyInteractionHideListFromXml(e.Xml);
		}
	}

	private void _buddyService_GetContactListCompleted(object sender, BuddyManagerEventArgs e)
	{
		_ssmService.UploadAddressListAsync(e.Result);
	}

	private async void _ssmService_GetBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		await ((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			if (this.GetBuddyCompleted != null)
			{
				this.GetBuddyCompleted(this, e);
			}
			try
			{
				if (SyncLoadingIndicator.ActiveIndicator != null)
				{
					SyncLoadingIndicator.StopLoading();
				}
				if (e.StatusCode == HttpStatusCode.NoContent || (e.StatusCode == (HttpStatusCode)0 && e.Error == null && string.IsNullOrEmpty(e.ErrorMessage)))
				{
					if (this.UpdateGetBuddyCompleted != null)
					{
						this.UpdateGetBuddyCompleted(this, e);
					}
					LoadBuddiesData();
					await Task.Run(delegate
					{
						_ssmService.GetBuddyGroupListAsync();
					});
					return;
				}
				if (e.Xml != null)
				{
					_buddyService.AddBuddyFromXml(e.Xml);
					if (!SettingService.IsFirstTimeBuddySyncFinished())
					{
						SettingService.SetFirstTimeBuddySyncFinished(option: true);
					}
					_buddyService.RemoveEmptyBuddyGroup();
					ChatOnService.Instance.IsBuddiesUpdated = true;
					UpdateList();
				}
				else if (!string.IsNullOrEmpty(e.ErrorMessage))
				{
					if (e.ErrorMessage.Contains("CCS-00012") || e.ErrorMessage.Contains("CCS-00011"))
					{
						MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NUMBER_ALREADY_IN_USE_REGISTER_AGAIN_WITH_ANOTHER_NUMBER"));
						await dialog.ShowAsync();
						await Utility.DeleteAllTile();
						ChatOnService.Instance.DeleteDatabase();
						await ApplicationData.Current.ClearAsync();
						MessageDialog dialog2 = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_APPLICATION_WILL_BE_CLOSED"));
						await dialog2.ShowAsync();
						Application.Current.Exit();
						return;
					}
					if (e.ErrorMessage.Contains("CCS-00900"))
					{
						MessageDialog dialog3 = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_ERROR_OCCURRED_TRY_AGAIN"));
						await dialog3.ShowAsync();
					}
				}
				else if (e.Error != null)
				{
					try
					{
						MessageDialog dialog4 = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"));
						await dialog4.ShowAsync();
					}
					catch (Exception)
					{
					}
				}
				LoadBuddiesData();
			}
			catch (Exception)
			{
			}
			if (this.UpdateGetBuddyCompleted != null)
			{
				this.UpdateGetBuddyCompleted(this, e);
			}
			await Task.Run(delegate
			{
				_ssmService.GetBuddyGroupListAsync();
			});
		});
		await Task.Run(delegate
		{
			_ssmService.GetMappingInfoAsync();
		});
	}

	public async void UpdateAllChatSummary()
	{
		await Task.Run(delegate
		{
			_chatService.UpdateAllChatSummary(((DependencyObject)PivotPage.ActiveInstance).Dispatcher);
		});
	}

	public void DeleteAllSpecialBuddyChat()
	{
		//IL_0013: Unknown result type (might be due to invalid IL or missing references)
		//IL_001d: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			List<Chat> list = _dataService.ChatItems.Where((Chat x) => x.SingleChatBuddy != null && x.SingleChatBuddy.IsSpecialBuddy).ToList();
			foreach (Chat item in list)
			{
				item.UnreadMessageCount = 0;
				item.UnreadTrunkMessageCount = 0;
				UpdateChatUnreadCount();
				UpdateTrunkUnreadCount();
				_dataService.DeleteChat(item);
			}
		});
	}

	private async void _ssmService_GetBuddyRecommendListCompleted(object sender, SSMCompletedEventArgs e)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			if (e.Xml != null)
			{
				List<UnknownUser> result = await _buddyService.ParseRecommendBuddyFromXml(e.Xml);
				((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
				{
					UpdateSuggestionsCount(result.Count);
				});
			}
			else
			{
				UpdateSuggestionsCount(0);
			}
		}
		catch (Exception)
		{
		}
	}

	private async void _ssmService_GetLatestVersionCompleted(object sender, SSMCompletedEventArgs e)
	{
		try
		{
			if (e.StatusCode == HttpStatusCode.NoContent)
			{
				return;
			}
			if (e.StatusCode != HttpStatusCode.OK)
			{
				await SSMService.ShowCommonErrorMessage(e);
			}
			else
			{
				if (CheckCriticalUpdate())
				{
					return;
				}
				CheckTermsAndConditionsUpdate();
			}
			if (ChatOnService.Instance.IsProfileUpdated)
			{
				await UpdateUserProfile();
			}
			await Task.Run(delegate
			{
				_ssmService.GetChatListInfoAsync();
			});
		}
		catch (Exception)
		{
		}
	}

	private void _ssmService_GetVersionCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ssmService.GetVersionCompleted -= _ssmService_GetVersionCompleted;
		SSMServer serverInfo = SSMService.GetServerInfo();
		if (string.IsNullOrEmpty(serverInfo.Key))
		{
			_ssmService.GetVersionCompleted += _ssmService_GetVersionCompleted;
			_ssmService.GetVersionAsync(forceUpdate: false);
		}
		else
		{
			_ssmService.GetLatestVersionAsync();
		}
	}

	private async void _ssmService_UnreadMessageCompleted(object sender, SSMCompletedEventArgs e)
	{
		await ((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			try
			{
				if (e.Xml != null)
				{
					_messageService.ParseFromXml(e.Xml);
					List<Message> list = await _chatService.ReflectUnreadMessage();
					UpdateChatUnreadCount();
					await _ssmService.SetReadMessageAsync(list);
					UpdateChatList();
				}
				else if (e.StatusCode != HttpStatusCode.OK && e.StatusCode != HttpStatusCode.NoContent)
				{
					await SSMService.ShowCommonErrorMessage(e);
				}
				else
				{
					UpdateChatUnreadCount();
				}
				_dataService.ChatDBSubmitChanges();
				_dataService.BuddyDBSubmitChanges();
				_dataService.ContactDBSubmitChanges();
				_dataService.MessageDBSubmitChanges();
			}
			catch (Exception)
			{
			}
		});
	}

	internal bool CheckTermsAndConditionsUpdate()
	{
		//IL_0026: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Expected O, but got Unknown
		DispatchedHandler val = null;
		SSMServer serverInfo = SSMService.GetServerInfo();
		if (serverInfo.IsTermsUpdated)
		{
			CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)async delegate
				{
					MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_TERMS_AND_CONDITIONS_AND_PRIVACY_POLICY_HAVE_BEEN_UPDATED"));
					await dialog.ShowAsync();
					PageNavigationService.OpenDisclaimerPage((Page)(object)_page);
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
			return true;
		}
		return false;
	}

	private void _ssmService_GetBuddyGroupListCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			if (e.Xml != null)
			{
				List<string> list = _buddyService.ParseBuddyGroupFromXml(e.Xml);
				List<BuddyGroup> existingGroups = _dataService.BuddyGroups.ToList();
				int i;
				for (i = 0; i < existingGroups.Count; i++)
				{
					if (!list.Any((string x) => x == existingGroups.ElementAt(i).Name))
					{
						Utility.Split(existingGroups.ElementAt(i).Members);
						_dataService.DeleteGroup(existingGroups.ElementAt(i));
						BuddySummary buddySummary = _showingItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.Equals(existingGroups.ElementAt(i)));
						if (buddySummary != null)
						{
							_showingItems.Remove(buddySummary);
						}
					}
				}
				if (existingGroups.Count != list.Count)
				{
					int i2;
					for (i2 = 0; i2 < existingGroups.Count; i2++)
					{
						if (!list.Contains(existingGroups.ElementAt(i2).Name))
						{
							_dataService.DeleteGroup(existingGroups.ElementAt(i2));
							BuddySummary buddySummary2 = _showingItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.Equals(existingGroups.ElementAt(i2)));
							if (buddySummary2 != null)
							{
								_showingItems.Remove(buddySummary2);
							}
						}
					}
				}
				_dataService.GroupDBSubmitChanges();
				if (ChatOnService.Instance.IsBuddiesUpdated)
				{
					ChatOnService.Instance.IsBuddiesUpdated = false;
					List<BuddySummary> list2 = _showingItems.Where((BuddySummary x) => x.Type == BuddySummary.ItemType.Group && x.Group != null).ToList();
					if (list2.Count == 0)
					{
						BuddyListHeader item = _headerItems.FirstOrDefault((BuddyListHeader x) => x.HeaderType == BuddyListHeaderType.Group);
						BuddySummary item2 = _showingItems.FirstOrDefault((BuddySummary x) => x.HeaderType == BuddyListHeaderType.Group);
						HeaderItems.Remove(item);
						ShowingItems.Remove(item2);
						NotifyPropertyChanged(() => HeaderItems);
						NotifyPropertyChanged(() => ShowingItems);
					}
				}
				_buddyService.LoadBuddyGroupProfileImage();
			}
			else if (e.Error != null)
			{
				await SSMService.ShowCommonErrorMessage(e);
			}
			else
			{
				List<BuddyGroup> existingGroups2 = _dataService.BuddyGroups.ToList();
				if (existingGroups2.Count > 0)
				{
					int i3;
					for (i3 = 0; i3 < existingGroups2.Count; i3++)
					{
						_dataService.DeleteGroup(existingGroups2.ElementAt(i3));
						BuddySummary buddySummary3 = _showingItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.Equals(existingGroups2.ElementAt(i3)));
						if (buddySummary3 != null)
						{
							_showingItems.Remove(buddySummary3);
						}
					}
					_dataService.GroupDBSubmitChanges();
					List<BuddySummary> list3 = _showingItems.Where((BuddySummary x) => x.Type == BuddySummary.ItemType.Group && x.Group != null).ToList();
					if (list3.Count == 0)
					{
						BuddyListHeader item3 = _headerItems.FirstOrDefault((BuddyListHeader x) => x.HeaderType == BuddyListHeaderType.Group);
						BuddySummary item4 = _showingItems.FirstOrDefault((BuddySummary x) => x.HeaderType == BuddyListHeaderType.Group);
						HeaderItems.Remove(item3);
						ShowingItems.Remove(item4);
						NotifyPropertyChanged(() => HeaderItems);
						NotifyPropertyChanged(() => ShowingItems);
					}
				}
			}
		});
	}

	private void _ssmService_GetChatListInfoCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			if (e.StatusCode == HttpStatusCode.OK)
			{
				if (e.Xml != null)
				{
					await Task.Run(delegate
					{
						_chatService.ApplyChatInfoAllusingJoinTime(e.Xml, ((DependencyObject)PivotPage.ActiveInstance).Dispatcher);
					});
				}
				await GetUnreadMessage();
				await UpdateTrunkList();
				_ssmService.GetGroupPushAsync();
				if (SettingService.GetShowSuggestions())
				{
					await Task.Run(delegate
					{
						_ssmService.GetBuddyRecommendListAsync();
					});
				}
				SSMService.SetUpdateAllBuddyListFlag();
				if (ChatItems.Count > 0)
				{
					EmptyChatGridVisibility = (Visibility)1;
				}
				else
				{
					EmptyChatGridVisibility = (Visibility)0;
				}
				if (ChatOnService.Instance.ReUpdateBuddyList)
				{
					GetBuddyList();
				}
				SSMServer serverInfo = SSMService.GetServerInfo();
				_dataService.CheckAniconPackagesExpired(serverInfo.GetEstimatedServerTime());
				_chatService.UpdateGroupChatProfiles();
			}
			else if (e.Error != null)
			{
				EmptyChatGridVisibility = (Visibility)1;
				await SSMService.ShowCommonErrorMessage(e);
			}
		});
	}

	public async Task UpdateTrunkList()
	{
		await _chatService.GetTrunkListAsync();
	}

	private async void _ssmService_GetGroupPushCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode != HttpStatusCode.NoContent)
		{
			if (e.Xml != null)
			{
				_chatService.ApplyGroupPushSettings(e.Xml);
			}
			else if (e.Error != null)
			{
				await SSMService.ShowCommonErrorMessage(e);
			}
		}
	}

	private async void _ssmService_GetMappingInfoCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			//IL_0071: Unknown result type (might be due to invalid IL or missing references)
			//IL_0077: Expected O, but got Unknown
			DispatchedHandler val = null;
			if (e.StatusCode == HttpStatusCode.OK && e.Xml != null)
			{
				MappingList = ParseFromXml(e.Xml);
			}
			else if (e.StatusCode != HttpStatusCode.NoContent)
			{
				CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
				if (val == null)
				{
					val = (DispatchedHandler)async delegate
					{
						await SSMService.ShowCommonErrorMessage(e);
					};
				}
				dispatcher.RunAsync((CoreDispatcherPriority)0, val);
			}
		});
	}

	private List<string> ParseFromXml(XElement xe)
	{
		List<string> list = new List<string>();
		IEnumerable<XElement> source = from item in xe.Descendants("MappingInfo")
			select (item);
		for (int num = 0; num < source.Count(); num++)
		{
			if (source.ElementAt(num).Attribute("phoneNumber") != null)
			{
				list.Add("+" + source.ElementAt(num).Attribute("phoneNumber").Value);
			}
		}
		return list;
	}

	public void DeleteGroup(BuddyGroup group)
	{
		//IL_00a2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ac: Expected O, but got Unknown
		//IL_00b2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bc: Expected O, but got Unknown
		PopupControl popupControl = new PopupControl();
		((FrameworkElement)popupControl).put_HorizontalAlignment((HorizontalAlignment)2);
		((FrameworkElement)popupControl).put_VerticalAlignment((VerticalAlignment)1);
		((FrameworkElement)popupControl).put_Margin(new Thickness(0.0, 30.0, 390.0, 0.0));
		((FrameworkElement)popupControl).put_Width(450.0);
		((FrameworkElement)popupControl).put_Height(150.0);
		popupControl.OKButtonText = Utility.GetResourceString("IDS_CHATON_BUTTON2_DELETE");
		popupControl.CancelButtonText = Utility.GetResourceString("IDS_CHATON_BUTTON_CANCEL");
		popupControl.ShowCancel = true;
		popupControl.CancelButtonBackground = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 244, 244, 244));
		popupControl.CancelButtonForeground = new SolidColorBrush(Colors.Black);
		string text = "";
		text = ((group.Name.Length >= 16) ? (group.Name.Substring(0, 15) + "...") : group.Name.Substring(0, group.Name.Length));
		popupControl.DetailText = Utility.GetResourceString("IDS_CHATON_BODY_PS_WILL_BE_DELETED").Replace("%s", text);
		popupControl.TitleText = Utility.GetResourceString("IDS_CHATON_BUTTON2_DELETE");
		_deletedGroup = group;
		popupControl.ChatOnPopupCompleted += DeleteDialog_ChatONPopupCompleted;
		_page.OpenDialog((UserControl)(object)popupControl);
	}

	internal async Task<bool> DeleteGroupTile(BuddyGroup _group)
	{
		bool result = false;
		IReadOnlyList<SecondaryTile> tileList = await SecondaryTile.FindAllAsync();
		if (tileList.Count == 0)
		{
			return true;
		}
		foreach (SecondaryTile tile in tileList)
		{
			if (SecondaryTile.Exists(tile.TileId) && tile.TileId == "Group" + _group.GroupID.ToString())
			{
				SecondaryTile tileToBeDeleted = new SecondaryTile(tile.TileId);
				while (!result)
				{
					result = await tileToBeDeleted.RequestDeleteAsync();
				}
			}
			else
			{
				result = true;
			}
		}
		if (_deletedGroup == null)
		{
			_deletedGroup = _group;
		}
		return result;
	}

	public void DeleteDialog_ChatONPopupCompleted(object sender, object e)
	{
		//IL_003e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0044: Expected O, but got Unknown
		DispatchedHandler val = null;
		PopupControl popupControl = null;
		if (!(sender is PopupControl popupControl2))
		{
			return;
		}
		popupControl2.ChatOnPopupCompleted -= DeleteDialog_ChatONPopupCompleted;
		if (!(bool)e)
		{
			return;
		}
		CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
		if (val == null)
		{
			val = (DispatchedHandler)async delegate
			{
				try
				{
					if (await DeleteGroupTile(_deletedGroup))
					{
						_ssmService.UpdateBuddyGroupCompleted += async delegate(object s2, SSMCompletedEventArgs e2)
						{
							LoadingIndicator.StopLoading();
							if (e2.StatusCode != HttpStatusCode.OK)
							{
								await SSMService.ShowCommonErrorMessage(e2);
							}
							else
							{
								try
								{
									_dataService.DeleteGroup(_deletedGroup);
									_dataService.GroupDBSubmitChanges();
									BuddySummary item = ShowingItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.Id == _deletedGroup.Id);
									BuddySummary item2 = BuddyItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.Id == _deletedGroup.Id);
									BuddyItems.Remove(item2);
									ShowingItems.Remove(item);
									BuddySummary groupIndex = ShowingItems.FirstOrDefault((BuddySummary x) => x.Type == BuddySummary.ItemType.Index && x.HeaderType == BuddyListHeaderType.Group);
									if (ShowingItems.Count((BuddySummary x) => x.Group != null) == 0)
									{
										ShowingItems.Remove(groupIndex);
									}
									else
									{
										groupIndex.Count = _dataService.BuddyGroups.Count();
										BuddyListHeader buddyListHeader = HeaderItems.FirstOrDefault((BuddyListHeader x) => x.Title == groupIndex.HeaderName && x.HeaderType == BuddyListHeaderType.Group);
										buddyListHeader.TotalMember = _dataService.BuddyGroups.Count();
									}
								}
								catch (Exception)
								{
								}
							}
							_deletedGroup = null;
							if (_lastOpenedDialog != null)
							{
								((UIElement)_lastOpenedDialog).put_Visibility((Visibility)1);
							}
						};
						PivotPage.ActiveInstance.ShowLoading();
						_ssmService.UpdateBuddyGroupAsync(_buddyService.MakeGroupMemberListParam(_deletedGroup, delete: true));
						if (BuddyListPage.ActiveInstance != null)
						{
							BuddyListPage.ActiveInstance.CloseProfileDialog();
						}
					}
				}
				catch (Exception)
				{
				}
			};
		}
		dispatcher.RunAsync((CoreDispatcherPriority)0, val);
	}

	public void DeleteGroupWithoutPopUp(BuddyGroup group)
	{
		_ssmService.UpdateBuddyGroupCompleted += async delegate(object s2, SSMCompletedEventArgs e2)
		{
			LoadingIndicator.StopLoading();
			if (e2.StatusCode != HttpStatusCode.OK)
			{
				await SSMService.ShowCommonErrorMessage(e2);
			}
			else
			{
				_dataService.DeleteGroup(group);
				_dataService.GroupDBSubmitChanges();
				BuddySummary item = ShowingItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.Id == group.Id);
				BuddySummary item2 = BuddyItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.Id == group.Id);
				BuddyItems.Remove(item2);
				ShowingItems.Remove(item);
				BuddySummary groupIndex = ShowingItems.FirstOrDefault((BuddySummary x) => x.Type == BuddySummary.ItemType.Index && x.HeaderType == BuddyListHeaderType.Group);
				if (ShowingItems.Count((BuddySummary x) => x.Group != null) == 0)
				{
					ShowingItems.Remove(groupIndex);
				}
				else
				{
					groupIndex.Count = _dataService.BuddyGroups.Count();
					BuddyListHeader buddyListHeader = HeaderItems.FirstOrDefault((BuddyListHeader x) => x.Title == groupIndex.HeaderName && x.HeaderType == BuddyListHeaderType.Group);
					buddyListHeader.TotalMember = _dataService.BuddyGroups.Count();
				}
			}
			if (_lastOpenedDialog != null)
			{
				((UIElement)_lastOpenedDialog).put_Visibility((Visibility)1);
			}
		};
		_ssmService.UpdateBuddyGroupAsync(_buddyService.MakeGroupMemberListParam(group, delete: true));
		if (BuddyListPage.ActiveInstance != null)
		{
			BuddyListPage.ActiveInstance.CloseProfileDialog();
		}
	}

	internal static List<string> GenerateDummyBuddies()
	{
		string text = "+821099990";
		List<string> list = new List<string>();
		for (int i = 801; i < 1001; i++)
		{
			if (i < 10)
			{
				list.Add(text + "00" + i);
			}
			else if (i < 100)
			{
				list.Add(text + "0" + i);
			}
			else
			{
				list.Add(text + i);
			}
		}
		return list;
	}

	internal static void AddDummyBuddies(List<string> numbers)
	{
		SSMService sSMService = new SSMService();
		sSMService.AddBuddyCompleted += ssmService_AddBuddyCompleted;
		foreach (string number in numbers)
		{
			sSMService.AddBuddyAsync(number);
		}
	}

	private static void ssmService_AddBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
	}

	internal void CloseBuddyProfile(Grid grid)
	{
		if (_lastBuddy.Group != null || _lastBuddy.Buddy != null)
		{
			((ICollection<UIElement>)((Panel)grid).Children).Clear();
		}
	}

	internal void OpenBuddyProfileDialog(BuddySummary sum, Grid grid, bool isRename = false)
	{
		if (sum.Type == BuddySummary.ItemType.Buddy)
		{
			BuddyProfileDialog buddyProfileDialog = (BuddyProfileDialog)(object)(_lastOpenedDialog = (UserControl)(object)new BuddyProfileDialog());
			buddyProfileDialog.DialogClosedTapped += profileDialog_Unloaded;
			if (isRename)
			{
				buddyProfileDialog.IsRenameMode = true;
			}
			Buddy buddy = (buddyProfileDialog.BuddyInfo = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == sum.Buddy.PhoneNumber));
			((UIElement)grid).put_Visibility((Visibility)0);
			if (((ICollection<UIElement>)((Panel)grid).Children).Count == 0)
			{
				((ICollection<UIElement>)((Panel)grid).Children).Add((UIElement)(object)buddyProfileDialog);
				_lastBuddy = sum;
				if (BuddyListPage.ActiveInstance != null)
				{
					BuddyListPage.ActiveInstance.SwitchAppBar(isOpen: false);
				}
			}
			else if (_lastBuddy.Group != null || (_lastBuddy.Buddy != null && _lastBuddy.Buddy.BuddyID != buddy.BuddyID))
			{
				((ICollection<UIElement>)((Panel)grid).Children).Clear();
				((ICollection<UIElement>)((Panel)grid).Children).Add((UIElement)(object)buddyProfileDialog);
				_lastBuddy = sum;
				if (BuddyListPage.ActiveInstance != null)
				{
					BuddyListPage.ActiveInstance.SwitchAppBar(isOpen: false);
				}
			}
			else
			{
				((ICollection<UIElement>)((Panel)grid).Children).Clear();
				((UIElement)grid).put_Visibility((Visibility)1);
				if (BuddyListPage.ActiveInstance != null)
				{
					BuddyListPage.ActiveInstance.SwitchAppBar(isOpen: true);
				}
			}
			return;
		}
		GroupProfileDialog groupProfileDialog = (GroupProfileDialog)(object)(_lastOpenedDialog = (UserControl)(object)new GroupProfileDialog());
		if (isRename)
		{
			groupProfileDialog.IsRenameMode = true;
		}
		groupProfileDialog.DialogClosedTapped += profileDialog_Unloaded;
		groupProfileDialog.parentPage = (Page)(object)_page;
		groupProfileDialog.BuddyProfileTapped += _dialog_BuddyProfileTapped;
		BuddyGroup buddyGroup = _dataService.BuddyGroups.FirstOrDefault((BuddyGroup c) => c.GroupID == sum.Group.GroupID);
		groupProfileDialog.DisplayContainer = grid;
		groupProfileDialog.GroupInfo = buddyGroup;
		((UIElement)grid).put_Visibility((Visibility)0);
		if (((ICollection<UIElement>)((Panel)grid).Children).Count == 0)
		{
			((ICollection<UIElement>)((Panel)grid).Children).Add((UIElement)(object)groupProfileDialog);
			_lastBuddy = sum;
			if (BuddyListPage.ActiveInstance != null)
			{
				BuddyListPage.ActiveInstance.SwitchAppBar(isOpen: false);
			}
		}
		else if (_lastBuddy.Buddy != null || (_lastBuddy.Group != null && _lastBuddy.Group.GroupID != buddyGroup.GroupID))
		{
			((ICollection<UIElement>)((Panel)grid).Children).Clear();
			((ICollection<UIElement>)((Panel)grid).Children).Add((UIElement)(object)groupProfileDialog);
			_lastBuddy = sum;
			if (BuddyListPage.ActiveInstance != null)
			{
				BuddyListPage.ActiveInstance.SwitchAppBar(isOpen: false);
			}
		}
		else
		{
			((ICollection<UIElement>)((Panel)grid).Children).Clear();
			((UIElement)grid).put_Visibility((Visibility)1);
			if (BuddyListPage.ActiveInstance != null)
			{
				BuddyListPage.ActiveInstance.SwitchAppBar(isOpen: true);
			}
		}
	}

	private void _dialog_BuddyProfileTapped(object sender, ProfileDialogEventArgs e)
	{
		CloseProfileDialog();
		BuddySummary buddySummary = new BuddySummary();
		buddySummary.Type = BuddySummary.ItemType.Buddy;
		buddySummary.Buddy = e.Buddy;
		BuddySummary item = buddySummary;
		if (BuddyListPage.ActiveInstance != null)
		{
			BuddyListPage.ActiveInstance.OpenBuddyProfileDialog(item);
		}
	}

	private void profileDialog_Unloaded(object sender, ProfileDialogEventArgs routedEventArgs)
	{
		CloseProfileDialog();
	}

	private void CloseProfileDialog()
	{
		if (BuddyListPage.ActiveInstance == null)
		{
			_lastBuddy = null;
			return;
		}
		if (_lastBuddy.Buddy != null)
		{
			BuddyListPage.ActiveInstance.SelectBuddy(_lastBuddy, status: false);
		}
		_lastBuddy = null;
		BuddyListPage.ActiveInstance.MakeArrowVisibility(IsShow: false, _lastBuddy);
		BuddyListPage.ActiveInstance.CloseProfileDialog();
	}

	public void BlockBuddyList(List<string> BuddyList)
	{
		_ssmService.BlockBuddyListCompleted += _ssmService_BlockBuddyListCompleted;
		_blockedList = BuddyList;
		_ssmService.BlockBuddyListAsync(BuddyList, isBlock: true);
	}

	private async void _ssmService_BlockBuddyListCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			foreach (string number in _blockedList)
			{
				IEnumerable<Buddy> buddyItems = _dataService.BuddyItems;
				Func<Buddy, bool> predicate = (Buddy c) => c.PhoneNumber == number;
				Buddy buddy = buddyItems.FirstOrDefault(predicate);
				if (buddy != null)
				{
					_buddyService.BlockBuddy(buddy);
					ChatOnService.Instance.IsBuddiesUpdated = true;
					ChatOnService.Instance.ReUpdateInteraction = true;
					RemoveBuddyFromShowingItems(buddy);
					UpdateList();
					Chat chat = _dataService.ChatItems.FirstOrDefault((Chat x) => x.SingleChatBuddy != null && x.SingleChatBuddy.PhoneNumber == buddy.PhoneNumber && !x.IsValidSession);
					if (chat != null)
					{
						chat.IsValidSession = true;
					}
				}
			}
			_dataService.BuddyDBSubmitChanges();
			ChatOnService.Instance.IsBuddiesUpdated = true;
			ChatOnService.Instance.ReUpdateInteraction = true;
			PivotPage.ActiveInstance.ViewModel.UpdateList();
		}
		else
		{
			await SSMService.ShowCommonErrorMessage(e);
		}
	}

	public void UnHighlitSelectedBuddy()
	{
		if (BuddyListPage.ActiveInstance != null)
		{
			BuddyListPage.ActiveInstance.MakeArrowVisibility(IsShow: false, _lastBuddy);
		}
	}

	public void UnHilightChats()
	{
		//IL_003f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0049: Expected O, but got Unknown
		IEnumerable<Chat> enumerable = ChatItems.Where((Chat x) => x.Background != null && x.Background.Color != Colors.Transparent);
		foreach (Chat item in enumerable)
		{
			item.Background = new SolidColorBrush(Colors.Transparent);
		}
	}

	public void GetAllMessageAllChat()
	{
	}

	private void _ssmService_GetAllMessageCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)(-1), (DispatchedHandler)delegate
		{
			try
			{
				if (e.StatusCode != HttpStatusCode.NoContent && e.StatusCode == HttpStatusCode.OK && e.Xml != null)
				{
					MessageService messageService = new MessageService(_dataService, _ssmService);
					Chat chat = _dataService.ChatItems.Where((Chat x) => x.SessionID == e.Param.ToString()).FirstOrDefault();
					bool isHasMore;
					List<Message> list = messageService.ParseAllMessageFromXml(e.Xml, chat, out isHasMore);
					if (list.Count != 0)
					{
						chat.LastSyncTid = long.Parse(list.Last().Tid) - 1;
						foreach (Message item in list)
						{
							_chatService.AddMessageToShow(chat, item, addToDB: true, toPrev: true);
							if (item.Time != 0 && item.Type != "noti")
							{
								chat.LastMessage = item;
							}
						}
						if (isHasMore)
						{
							chat.PrevMsgStatus = Chat.PrevMsgLoadingStatus.Loading;
						}
						else
						{
							chat.PrevMsgStatus = Chat.PrevMsgLoadingStatus.None;
						}
						_dataService.MessageDBSubmitChanges();
						_dataService.ChatDBSubmitChanges();
					}
				}
			}
			catch
			{
			}
		});
	}

	internal void LoadChatList()
	{
		//IL_0013: Unknown result type (might be due to invalid IL or missing references)
		//IL_001d: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			await Task.Run(delegate
			{
				_chatService.UpdateAllChatSummary(((DependencyObject)_page).Dispatcher);
			});
			RemoveUnusedChats();
			UpdateChatList();
		});
	}

	private void RemoveUnusedChats()
	{
		List<Chat> list = _dataService.ChatItems.Where((Chat c) => (!c.IsChanged || string.IsNullOrEmpty(c.Address)) && (DateTime.Now - c.Date).TotalSeconds > 10.0 && !c.ChatType.Equals(ChatType.BROADCAST) && c.LastMessage == null).ToList();
		if (list.Count == 0)
		{
			return;
		}
		foreach (Chat item in list)
		{
			if (ChatOnService.Instance.RecentChat != null && ChatOnService.Instance.RecentChat == item)
			{
				break;
			}
			_dataService.DeleteChat(item);
			if (ChatOnService.Instance != null && ChatListPage.ActiveInstance != null && ChatOnService.Instance.RecentChat == item)
			{
				ChatListPage.ActiveInstance.IsInChatMode = false;
				ChatListPage.ActiveInstance.MakeSelectChatNoticeGridVisible();
				if (ChatDetailPage.ActiveInstance != null)
				{
					ChatDetailPage.ActiveInstance.ViewModel.AppBarVisibility = (Visibility)1;
					ChatDetailPage.ActiveInstance.ViewModel.Chat = null;
				}
				ChatOnService.Instance.RecentChat = null;
			}
		}
	}

	internal void RemoveBuddyFromShowingItems(Buddy buddy)
	{
		try
		{
			List<BuddySummary> removedItems = ShowingItems.Where((BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber == buddy.PhoneNumber).ToList();
			if (removedItems.Count == 0)
			{
				return;
			}
			if (removedItems.Count == 1)
			{
				ShowingItems.Remove(removedItems.FirstOrDefault());
			}
			int i;
			for (i = 0; i < removedItems.Count; i++)
			{
				List<BuddySummary> source = _showingItems.Where((BuddySummary x) => x.HeaderType == removedItems.ElementAt(i).HeaderType).ToList();
				List<BuddyListHeader> source2 = HeaderItems.Where((BuddyListHeader x) => x.HeaderType == removedItems.ElementAt(i).HeaderType).ToList();
				if (removedItems.ElementAt(i).IsNormalBuddyType())
				{
					source = source.Where((BuddySummary x) => x.HeaderName != null && x.HeaderName.Equals(removedItems.ElementAt(i).Buddy.IndexString)).ToList();
					source2 = source2.Where((BuddyListHeader x) => x.Title != null && x.Title.Equals(removedItems.ElementAt(i).Buddy.IndexString)).ToList();
				}
				BuddySummary buddySummary = source.FirstOrDefault();
				if (source2.Count() > 0)
				{
					BuddyListHeader buddyListHeader = source2.FirstOrDefault();
					if (buddyListHeader.TotalMember <= 1)
					{
						ShowingItems.Remove(source.FirstOrDefault());
						buddyListHeader.TotalMember = 0;
						buddyListHeader.Index = -1;
					}
					else
					{
						buddySummary.Count--;
						buddyListHeader.TotalMember--;
					}
				}
				else
				{
					buddySummary.Count = 0;
					_showingItems.Remove(buddySummary);
				}
				if (removedItems.ElementAt(i).HeaderType == BuddyListHeaderType.New)
				{
					_buddyService.NewlyAddedCount--;
					NotifyPropertyChanged(() => NewBuddyCount);
				}
				ShowingItems.Remove(removedItems.ElementAt(i));
			}
		}
		catch (Exception)
		{
		}
	}

	internal async Task GetUserProfileImageHistory()
	{
		await Task.Run(delegate
		{
			_ssmService.GetUserProfileImageHistoryAsync();
		});
	}

	private void _ssmService_GetUserProfileImageHistoryCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			if (!string.IsNullOrEmpty(e.ResultString))
			{
				_profileImageList = _buddyService.ParseImageListHistoryfromXml(e.Xml);
				await Task.Run(delegate
				{
					_ssmService.GetUserProfileAsync();
				});
			}
			else
			{
				BuddySummary buddySummary = _showingItems.FirstOrDefault((BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber.Equals(RegistrationService.ChatOnID) && !((object)x.Buddy.ProfileImage).Equals((object)MyProfile.ProfileImage));
				if (buddySummary != null)
				{
					buddySummary.Buddy.ProfileName = MyProfile.Name;
					buddySummary.Buddy.Name = MyProfile.Name;
					if (!string.IsNullOrEmpty(MyProfile.ProfileImagePath))
					{
						MyProfile.ProfileImage = new BitmapImage(new Uri(MyProfile.ProfileImagePath));
						buddySummary.Buddy.ProfileImage = MyProfile.ProfileImage;
					}
					NotifyPropertyChanged(() => ShowingItems);
					NotifyPropertyChanged("");
				}
			}
		});
	}

	internal async void UpdateBlockListAsync()
	{
		await Task.Run(delegate
		{
			_ssmService.GetBlockBuddyListAsync();
		});
	}

	private void _ssmService_GetBlockListCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0047: Unknown result type (might be due to invalid IL or missing references)
		//IL_0051: Expected O, but got Unknown
		if (e.StatusCode != HttpStatusCode.OK || e.Xml == null)
		{
			return;
		}
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			try
			{
				List<Buddy> list = new List<Buddy>();
				ObservableCollection<BlockBuddyInfo> observableCollection = _buddyService.ParseBlockListFromXml(e.Xml);
				foreach (BlockBuddyInfo blockBuddyInfo in observableCollection)
				{
					IEnumerable<Buddy> buddyItems = _dataService.BuddyItems;
					Func<Buddy, bool> predicate = (Buddy x) => x.PhoneNumber == blockBuddyInfo.Number;
					Buddy buddy = buddyItems.FirstOrDefault(predicate);
					UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser x) => x.PhoneNumber == blockBuddyInfo.Number);
					if (unknownUser != null)
					{
						unknownUser.IsBlocked = true;
						_dataService.UnknownUserDBSubmitChanges();
					}
					if (buddy == null || !buddy.IsBlocked)
					{
						if (buddy == null)
						{
							buddy = _buddyService.AddBlockedBuddy(blockBuddyInfo);
						}
						buddy.IsBlocked = true;
						list.Add(buddy);
					}
				}
				CheckBlockChat(observableCollection);
				if (list.Count != 0)
				{
					foreach (Buddy item in list)
					{
						_buddyService.RemoveBuddyFromGroup(item.PhoneNumber);
						RemoveBuddyFromShowingItems(item);
					}
					_dataService.BuddyDBSubmitChanges();
				}
			}
			catch (Exception)
			{
			}
		});
	}

	internal void CheckBlockChat(ICollection<BlockBuddyInfo> _blockedList)
	{
		try
		{
			foreach (BlockBuddyInfo blockBuddyInfo in _blockedList)
			{
				IEnumerable<Chat> chatItems = _dataService.ChatItems;
				Func<Chat, bool> predicate = (Chat x) => x.ChatType == ChatType.SINGLE && x.Members.Contains(blockBuddyInfo.Number);
				Chat chat = chatItems.FirstOrDefault(predicate);
				if (chat != null)
				{
					chat.IsValidSession = false;
				}
			}
			List<Buddy> list = _dataService.BuddyItems.Where((Buddy x) => x.IsBlocked).ToList();
			foreach (Buddy blockedBuddy in list)
			{
				Func<BlockBuddyInfo, bool> predicate2 = (BlockBuddyInfo x) => x.Name == blockedBuddy.Name;
				if (!_blockedList.Any(predicate2))
				{
					Chat chat2 = null;
					chat2 = _dataService.ChatItems.FirstOrDefault((Chat x) => ((x.SingleChatBuddy != null && x.SingleChatBuddy.PhoneNumber == blockedBuddy.PhoneNumber) || (x.ChatType == ChatType.SINGLE && x.Members.Contains(blockedBuddy.PhoneNumber))) && !x.IsValidSession);
					if (chat2 != null)
					{
						chat2.IsValidSession = true;
					}
					UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser x) => x.PhoneNumber == blockedBuddy.PhoneNumber);
					if (unknownUser != null)
					{
						unknownUser.IsBlocked = false;
					}
					blockedBuddy.IsBlocked = false;
				}
			}
			List<Chat> list2 = _dataService.ChatItems.Where((Chat x) => !string.IsNullOrEmpty(x.SessionID) && !x.IsValidSession && x.ChatType == ChatType.SINGLE).ToList();
			foreach (Chat chatInvalid in list2)
			{
				if (chatInvalid != null && !_blockedList.Any((BlockBuddyInfo x) => x.Name == chatInvalid.SingleChatBuddy.Name))
				{
					chatInvalid.IsValidSession = true;
					UnknownUser unknownUser2 = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser x) => x.PhoneNumber == chatInvalid.SingleChatBuddy.PhoneNumber);
					if (unknownUser2 != null)
					{
						unknownUser2.IsBlocked = false;
					}
					Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy x) => x.PhoneNumber == chatInvalid.SingleChatBuddy.PhoneNumber);
					if (buddy != null)
					{
						buddy.IsBlocked = false;
					}
				}
			}
			_dataService.ChatDBSubmitChanges();
			_dataService.BuddyDBSubmitChanges();
			_dataService.UnknownUserDBSubmitChanges();
		}
		catch (Exception)
		{
		}
	}

	internal void RemoveMembers(BuddyGroup group)
	{
		string[] array = Utility.Split(group.Members);
		_selectedGroup = group;
		if (array != null)
		{
			List<string> list = new List<string>();
			foreach (Buddy buddy in _dataService.BuddyItems)
			{
				Func<string, bool> predicate = (string n) => n == buddy.PhoneNumber;
				if (string.IsNullOrEmpty(array.FirstOrDefault(predicate)))
				{
					list.Add(buddy.PhoneNumber);
				}
			}
			SelectBuddyPage.ExceptionNumbers = list;
		}
		SelectBuddyPage.isRemoveMode = true;
		SelectBuddyPage.Mode = SelectBuddyMode.RemoveMember;
		SelectBuddyPage.IsExceptSpecialBuddies = true;
		SelectBuddyPage.SelectionCompleted += SelectBuddyToRemove_SelectionCompleted;
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
	}

	private void SelectBuddyToRemove_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= SelectBuddyToRemove_SelectionCompleted;
		List<BuddySummary> list = (arg as ObservableCollection<BuddySummary>).ToList();
		if (list.Count() == 0)
		{
			if (sender is SelectBuddyPage)
			{
				((Page)(sender as SelectBuddyPage)).Frame.GoBack();
			}
			return;
		}
		_ssmService.UpdateBuddyGroupCompleted += async delegate(object s2, SSMCompletedEventArgs e2)
		{
			LoadingIndicator.StopLoading();
			if (e2.StatusCode == HttpStatusCode.OK)
			{
				string[] members = Utility.Split(_selectedGroup.Members);
				List<string> memberList = new List<string>(members);
				foreach (BuddySummary item in list)
				{
					memberList.Remove(item.Buddy.PhoneNumber);
				}
				_selectedGroup.Members = string.Join(",", memberList);
				if (memberList.Count < 1)
				{
					await DeleteGroupTile(_selectedGroup);
					_dataService.DeleteGroup(_selectedGroup);
					BuddySummary deletedItem = PivotPage.ActiveInstance.ViewModel.ShowingItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.Equals(_selectedGroup));
					if (deletedItem != null)
					{
						PivotPage.ActiveInstance.ViewModel.ShowingItems.Remove(deletedItem);
					}
					List<BuddySummary> Groups = PivotPage.ActiveInstance.ViewModel.ShowingItems.Where((BuddySummary x) => x.Group != null).ToList();
					BuddySummary GroupHeader = PivotPage.ActiveInstance.ViewModel.ShowingItems.FirstOrDefault((BuddySummary x) => x.Type == BuddySummary.ItemType.Index && x.HeaderType == BuddyListHeaderType.Group);
					if (Groups.Count < 1)
					{
						PivotPage.ActiveInstance.ViewModel.ShowingItems.Remove(GroupHeader);
					}
				}
				_dataService.GroupDBSubmitChanges();
				try
				{
					((Page)SelectBuddyPage.ActiveInstance).Frame.GoBack();
					return;
				}
				catch (Exception)
				{
					return;
				}
			}
			await SSMService.ShowCommonErrorMessage(e2);
		};
		_ssmService.UpdateBuddyGroupAsync(_buddyService.MakeGroupMemberListParam(_selectedGroup, list, added: false));
	}

	internal void AddMembers(BuddyGroup group)
	{
		string[] collection = Utility.Split(group.Members);
		_selectedGroup = group;
		SelectBuddyPage.ExceptionNumbers = new List<string>(collection);
		SelectBuddyPage.IsExceptSpecialBuddies = true;
		SelectBuddyPage.SelectionCountLimit = ChatService.MAX_CHAT_MEMBERS - 1;
		SelectBuddyPage.SelectionCompleted += SelectBuddyToAdd_SelectionCompleted;
		SelectBuddyPage.isRemoveMode = false;
		SelectBuddyPage.Mode = SelectBuddyMode.AddMember;
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
	}

	private void SelectBuddyToAdd_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= SelectBuddyToAdd_SelectionCompleted;
		ObservableCollection<BuddySummary> list = arg as ObservableCollection<BuddySummary>;
		if (list.Count() == 0)
		{
			if (sender is SelectBuddyPage)
			{
				((Page)(sender as SelectBuddyPage)).Frame.GoBack();
			}
			return;
		}
		List<BuddySummary> addedBuddies = list.ToList();
		_ssmService.UpdateBuddyGroupCompleted += async delegate(object s2, SSMCompletedEventArgs e2)
		{
			LoadingIndicator.StopLoading();
			if (e2.StatusCode == HttpStatusCode.OK)
			{
				string[] collection = Utility.Split(_selectedGroup.Members);
				if (string.IsNullOrEmpty(_selectedGroup.Members))
				{
					collection = new string[0];
				}
				List<string> list2 = new List<string>(collection);
				foreach (BuddySummary item in list)
				{
					_ = item.Buddy.IsBlocked;
					list2.Add(item.Buddy.PhoneNumber);
				}
				foreach (BuddySummary buddySummary in addedBuddies)
				{
					if (!_selectedGroup.Members.Contains(buddySummary.Buddy.PhoneNumber))
					{
						Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy x) => x.PhoneNumber == buddySummary.Buddy.PhoneNumber);
						if (buddy != null && !buddy.IsBlocked)
						{
							list2.Add(buddy.PhoneNumber);
						}
					}
				}
				list2.Reverse();
				_selectedGroup.Members = string.Join(",", list2);
				NotifyPropertyChanged("");
				_dataService.GroupDBSubmitChanges();
				((Page)SelectBuddyPage.ActiveInstance).Frame.GoBack();
			}
			else
			{
				await SSMService.ShowCommonErrorMessage(e2);
			}
		};
		_ssmService.UpdateBuddyGroupAsync(_buddyService.MakeGroupMemberListParam(_selectedGroup, list));
	}

	public void CheckNotice()
	{
		string languageParam = Utility.GetLanguageParam();
		ObservableCollection<ListNotice> NoticeList = new ObservableCollection<ListNotice>();
		_ssmService.CheckNoticeCompleted += delegate(object s, SSMCompletedEventArgs e)
		{
			if (e.StatusCode == HttpStatusCode.OK && !string.IsNullOrEmpty(e.Param as string))
			{
				Notice notice = JSONHelper.Deserialize<Notice>(e.Param as string);
				NoticeList = notice.list;
				DateTime dateTime = DateTime.Parse(NoticeList[0].created);
				int num = Convert.ToInt32((DateTime.Now - dateTime).TotalDays);
				if (num <= 2)
				{
					IsNewNotice = true;
					NotifyPropertyChanged(() => IsNewNotice);
				}
				else
				{
					IsNewNotice = false;
					NotifyPropertyChanged(() => IsNewNotice);
				}
			}
		};
		_ssmService.CheckNoticeAsync(languageParam);
	}

	public void GetChatListInfoAsync()
	{
		Task.Run(delegate
		{
			_ssmService.GetChatListInfoAsync();
		}).Wait(3000);
	}

	internal void UpdateMessageList(Buddy buddy)
	{
		if (ChatDetailPage.ActiveInstance != null && ChatDetailPage.ActiveInstance.ViewModel != null)
		{
			ChatDetailPage.ActiveInstance.ViewModel.UpdateMessageProfile(buddy);
		}
	}
}
