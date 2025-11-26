using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using System.Threading.Tasks;
using ChatON_WoA.DataModel;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Models;
using SDatabase;

namespace ChatOn.Services;

public class ChatOnService
{
	public enum SettingType
	{
		About,
		ManageBuddies,
		DisplaySettings,
		Privacy,
		Notifications,
		General,
		Downloads,
		SamsungAccount,
		SyncNow
	}

	private static ChatOnService _instance;

	private int DatabaseVersion = SettingService.GetDatabaseVersion();

	public SettingType CurrentSettingType;

	private ContactDataContext _contactDB;

	private BuddyDataContext _buddyDB;

	private BuddyGroupDataContext _buddyGroupDB;

	private UnknownUserDataContext _unknownUserDB;

	private RecommendeeDataContext _recommendeeDB;

	private ChatDataContext _chatDB;

	private MessageDataContext _messageDB;

	private AniconDataContext _aniconDB;

	private BuddyDataContext _newBuddyDB;

	private ChatDataContext _newChatDB;

	private UnknownUserDataContext _newunknownUserDB;

	private InteractionRankContext _interactionRankDb;

	private bool _isBuddiesUpdated;

	private bool _reUpdateBuddyList;

	private bool _reUpdateInteraction;

	private bool _isProfileImageUpdated;

	private bool _isProfileUpdated;

	private bool _isChatsUpdated;

	private bool _isChatStyleUpdated;

	private bool _isChatFontOrBubbleUpdated;

	private bool _isUnreadTrunkCommentUpdated;

	private bool _isRecommendeeUpdated;

	private Stream _streamToShare;

	private Stream _streamToCrop;

	private string _fileNameToShare;

	private Chat _recentChat;

	private ChatDetailPage _activeFullViewChatDetailPage;

	private UserProfile _userProfile;

	public ObservableCollection<Chat> InActiveChat = new ObservableCollection<Chat>();

	public bool IsGetAllMessage;

	private ObservableCollection<Anicon> _anicons = new ObservableCollection<Anicon>();

	private List<AniconPackage> _downloadingPackages = new List<AniconPackage>();

	private string _currentInputPhoneNumber;

	private string _tempGuid;

	private string _launchArg;

	private string _searchArg;

	private bool _reUpdateChatList;

	private ObservableCollection<Buddy> _buddyItems = new ObservableCollection<Buddy>();

	private List<BuddyGroup> _groupItems = new List<BuddyGroup>();

	private List<UnknownUser> _unknownUserItems = new List<UnknownUser>();

	private List<UnknownUser> _recommendeeItems = new List<UnknownUser>();

	private List<MyContact> _contactItems = new List<MyContact>();

	private List<Chat> _chatItems = new List<Chat>();

	private List<Message> _messageItems = new List<Message>();

	private List<Message> _unreadMessages = new List<Message>();

	private List<TrunkItem> _trunkItems = new List<TrunkItem>();

	private List<TrunkComment> _trunkComments = new List<TrunkComment>();

	private ObservableCollection<OfflineAniconPackage> _aniconPackages = new ObservableCollection<OfflineAniconPackage>();

	private List<Anicon> _receivedAnicons = new List<Anicon>();

	private List<InteractionRank> _interactionRanks = new List<InteractionRank>();

	public UserProfile UserProfile
	{
		get
		{
			return _userProfile;
		}
		set
		{
			_userProfile = value;
		}
	}

	public ObservableCollection<Anicon> Anicons
	{
		get
		{
			return _anicons;
		}
		set
		{
			_anicons = value;
		}
	}

	public List<AniconPackage> DownloadingPackages
	{
		get
		{
			return _downloadingPackages;
		}
		set
		{
			_downloadingPackages = value;
		}
	}

	public ChatDetailPage ActiveFullViewChatDetailPage
	{
		get
		{
			return _activeFullViewChatDetailPage;
		}
		set
		{
			_activeFullViewChatDetailPage = value;
		}
	}

	public string SearchArg
	{
		get
		{
			return _searchArg;
		}
		set
		{
			_searchArg = value;
		}
	}

	public string LaunchArg
	{
		get
		{
			return _launchArg;
		}
		set
		{
			_launchArg = value;
		}
	}

	public string TempGuid
	{
		get
		{
			return _tempGuid;
		}
		set
		{
			_tempGuid = value;
		}
	}

	public string CurrentInputPhoneNumber
	{
		get
		{
			return _currentInputPhoneNumber;
		}
		set
		{
			_currentInputPhoneNumber = value;
		}
	}

	public bool IsProfileImageUpdated
	{
		get
		{
			return _isProfileImageUpdated;
		}
		set
		{
			_isProfileImageUpdated = value;
		}
	}

	public bool IsProfileUpdated
	{
		get
		{
			return _isProfileUpdated;
		}
		set
		{
			_isProfileUpdated = value;
		}
	}

	public bool IsUnreadTrunkCommentUpdated
	{
		get
		{
			return _isUnreadTrunkCommentUpdated;
		}
		set
		{
			_isUnreadTrunkCommentUpdated = value;
		}
	}

	public ContactDataContext ContactDB => _contactDB;

	public BuddyDataContext BuddyDB
	{
		get
		{
			if (_newBuddyDB != null)
			{
				return _newBuddyDB;
			}
			return _buddyDB;
		}
	}

	public BuddyGroupDataContext BuddyGroupDB => _buddyGroupDB;

	public UnknownUserDataContext UnknownUserDB
	{
		get
		{
			if (_newunknownUserDB != null)
			{
				return _newunknownUserDB;
			}
			return _unknownUserDB;
		}
	}

	public RecommendeeDataContext RecommendeeDB => _recommendeeDB;

	public ChatDataContext ChatDB
	{
		get
		{
			if (_newChatDB != null)
			{
				return _newChatDB;
			}
			return _chatDB;
		}
	}

	public MessageDataContext MessageDB => _messageDB;

	public AniconDataContext AniconDB => _aniconDB;

	public InteractionRankContext InteractionRankDb
	{
		get
		{
			if (_interactionRankDb != null)
			{
				return _interactionRankDb;
			}
			return _interactionRankDb;
		}
	}

	public string FileNameToShare
	{
		get
		{
			return _fileNameToShare;
		}
		set
		{
			_fileNameToShare = value;
		}
	}

	public Stream StreamToCrop
	{
		get
		{
			return _streamToCrop;
		}
		set
		{
			_streamToCrop = value;
		}
	}

	public Stream StreamToShare
	{
		get
		{
			return _streamToShare;
		}
		set
		{
			_streamToShare = value;
		}
	}

	public Chat RecentChat
	{
		get
		{
			return _recentChat;
		}
		set
		{
			_recentChat = value;
		}
	}

	public bool ReUpdateInteraction
	{
		get
		{
			return _reUpdateInteraction;
		}
		set
		{
			_reUpdateInteraction = value;
		}
	}

	public bool ReUpdateBuddyList
	{
		get
		{
			return _reUpdateBuddyList;
		}
		set
		{
			_reUpdateBuddyList = value;
		}
	}

	public bool IsBuddiesUpdated
	{
		get
		{
			return _isBuddiesUpdated;
		}
		set
		{
			_isBuddiesUpdated = value;
		}
	}

	public bool IsChatsUpdated
	{
		get
		{
			return _isChatsUpdated;
		}
		set
		{
			_isChatsUpdated = value;
		}
	}

	public bool IsChatStyleUpdated
	{
		get
		{
			return _isChatStyleUpdated;
		}
		set
		{
			_isChatStyleUpdated = value;
		}
	}

	public bool IsChatFontOrBubbleUpdated
	{
		get
		{
			return _isChatFontOrBubbleUpdated;
		}
		set
		{
			_isChatFontOrBubbleUpdated = value;
		}
	}

	public bool IsRecommendeeUpdated
	{
		get
		{
			return _isRecommendeeUpdated;
		}
		set
		{
			_isRecommendeeUpdated = value;
		}
	}

	public bool ReUpdateChatList
	{
		get
		{
			return _reUpdateChatList;
		}
		set
		{
			_reUpdateChatList = value;
		}
	}

	public List<Anicon> ReceivedAnicons
	{
		get
		{
			return _receivedAnicons;
		}
		set
		{
			_receivedAnicons = value;
		}
	}

	public ObservableCollection<OfflineAniconPackage> AniconPackages
	{
		get
		{
			return _aniconPackages;
		}
		set
		{
			_aniconPackages = value;
		}
	}

	public ObservableCollection<Buddy> BuddyItems
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

	public List<BuddyGroup> GroupItems
	{
		get
		{
			return _groupItems;
		}
		set
		{
			_groupItems = value;
		}
	}

	public List<UnknownUser> UnknownUserItems
	{
		get
		{
			return _unknownUserItems;
		}
		set
		{
			_unknownUserItems = value;
		}
	}

	public List<UnknownUser> RecommendeeItems
	{
		get
		{
			return _recommendeeItems;
		}
		set
		{
			_recommendeeItems = value;
		}
	}

	public List<MyContact> ContactItems
	{
		get
		{
			return _contactItems;
		}
		set
		{
			_contactItems = value;
		}
	}

	public List<Chat> ChatItems
	{
		get
		{
			return _chatItems;
		}
		set
		{
			_chatItems = value;
		}
	}

	public List<Message> MessageItems
	{
		get
		{
			return _messageItems;
		}
		set
		{
			_messageItems = value;
		}
	}

	public List<Message> UnreadMessages
	{
		get
		{
			return _unreadMessages;
		}
		set
		{
			_unreadMessages = value;
		}
	}

	public List<TrunkItem> TrunkItems
	{
		get
		{
			return _trunkItems;
		}
		set
		{
			_trunkItems = value;
		}
	}

	public List<TrunkComment> TrunkComments
	{
		get
		{
			return _trunkComments;
		}
		set
		{
			_trunkComments = value;
		}
	}

	public List<InteractionRank> InteractionRanks
	{
		get
		{
			return _interactionRanks;
		}
		set
		{
			_interactionRanks = value;
		}
	}

	public static ChatOnService Instance
	{
		get
		{
			if (_instance == null)
			{
				_instance = new ChatOnService();
			}
			return _instance;
		}
	}

	public event EventHandler DatabaseLoaded;

	public async Task CreateDatabase()
	{
		_buddyDB = new BuddyDataContext("buddyDB.sdb");
		if (!(await _buddyDB.DatabaseExists()))
		{
			await _buddyDB.CreateDatabase();
		}
		else if (DatabaseVersion >= 1)
		{
			await _buddyDB.LoadDatabase();
		}
		else
		{
			await _buddyDB.DeleteDatabase();
			await _buddyDB.SubmitChanges();
			_newBuddyDB = new BuddyDataContext("buddyDB.sdb");
			await _newBuddyDB.CreateDatabase();
			foreach (Buddy data in _buddyDB.Buddies.DataList)
			{
				data.MSISDNS = string.Empty;
				data.IsSpecialBuddy = false;
				_newBuddyDB.Buddies.InsertOnSubmit(data);
			}
			await _newBuddyDB.SubmitChanges();
			await _newBuddyDB.LoadDatabase();
			_buddyDB = new BuddyDataContext("buddyDB.sdb");
		}
		_buddyGroupDB = new BuddyGroupDataContext("buddyGroupDB.sdb");
		if (await _buddyGroupDB.DatabaseExists())
		{
			await _buddyGroupDB.LoadDatabase();
		}
		else
		{
			await _buddyGroupDB.CreateDatabase();
		}
		_unknownUserDB = new UnknownUserDataContext("unknownUserDB.sdb");
		if (!(await _unknownUserDB.DatabaseExists()))
		{
			await _unknownUserDB.CreateDatabase();
		}
		else if (DatabaseVersion >= 1)
		{
			await _unknownUserDB.LoadDatabase();
		}
		else
		{
			await _unknownUserDB.DeleteDatabase();
			await _unknownUserDB.SubmitChanges();
			_newunknownUserDB = new UnknownUserDataContext("unknownUserDB.sdb");
			await _newunknownUserDB.CreateDatabase();
			foreach (UnknownUser data2 in _newunknownUserDB.UnknownUsers.DataList)
			{
				data2.IsDeregistered = false;
				_newunknownUserDB.UnknownUsers.InsertOnSubmit(data2);
			}
			await _newunknownUserDB.SubmitChanges();
			await _newunknownUserDB.LoadDatabase();
			_unknownUserDB = new UnknownUserDataContext("unknownUserDB.sdb");
		}
		_recommendeeDB = new RecommendeeDataContext("recommendeeDB.sdb");
		if (await _recommendeeDB.DatabaseExists())
		{
			await _recommendeeDB.LoadDatabase();
		}
		else
		{
			await _recommendeeDB.CreateDatabase();
		}
		_messageDB = new MessageDataContext("messageDB.sdb");
		if (await _messageDB.DatabaseExists())
		{
			await _messageDB.LoadDatabase();
		}
		else
		{
			await _messageDB.CreateDatabase();
		}
		_chatDB = new ChatDataContext("chatDB.sdb");
		if (!(await _chatDB.DatabaseExists()))
		{
			SettingService.SetDatabaseVersion(1);
			await _chatDB.CreateDatabase();
		}
		else if (DatabaseVersion >= 1)
		{
			await _chatDB.LoadDatabase();
		}
		else
		{
			await _chatDB.DeleteDatabase();
			await _chatDB.SubmitChanges();
			_newChatDB = new ChatDataContext("chatDB.sdb");
			await _newChatDB.CreateDatabase();
			foreach (Chat data3 in _chatDB.Chats.DataList)
			{
				data3.LastMergedTimeStamp = Utility.GetTimeStamp();
				data3.OldSessionID = string.Empty;
				data3.PrevMsgStatus = Chat.PrevMsgLoadingStatus.InitialLoading;
				data3.LastSyncTid = 0L;
				data3.FileAddress = "";
				data3.FilePath = "";
				_newChatDB.Chats.InsertOnSubmit(data3);
			}
			await _newChatDB.SubmitChanges();
			await _newChatDB.LoadDatabase();
			SettingService.SetDatabaseVersion(1);
			_chatDB = new ChatDataContext("chatDB.sdb");
		}
		_contactDB = new ContactDataContext("contactDB.sdb");
		if (await _contactDB.DatabaseExists())
		{
			await _contactDB.LoadDatabase();
		}
		else
		{
			await _contactDB.CreateDatabase();
		}
		_aniconDB = new AniconDataContext("aniconDB.sdb");
		try
		{
			if (await _aniconDB.DatabaseExists())
			{
				await _aniconDB.LoadDatabase();
			}
			else
			{
				await _aniconDB.CreateDatabase();
			}
		}
		catch (Exception)
		{
			_aniconDB.DeleteDatabase();
			_aniconDB.CreateDatabase();
		}
		_interactionRankDb = new InteractionRankContext("interactionRankDb.sdb");
		if (!(await _interactionRankDb.DatabaseExists()))
		{
			await _interactionRankDb.CreateDatabase();
		}
		else
		{
			await _interactionRankDb.LoadDatabase();
		}
	}

	public void DeleteDatabase(bool dispose = true)
	{
		_buddyDB.DeleteDatabase();
		_messageDB.DeleteDatabase();
		_chatDB.DeleteDatabase();
		_contactDB.DeleteDatabase();
	}

	internal async Task LoadData()
	{
		SDBData.SkipDataUpdatedNoti = true;
		SDBData.SkipPropertyChangedNoti = true;
		await CreateDatabase();
		new DataService().LoadAll();
		SDBData.SkipDataUpdatedNoti = false;
		SDBData.SkipPropertyChangedNoti = false;
		if (this.DatabaseLoaded != null)
		{
			this.DatabaseLoaded(this, null);
		}
	}

	internal void DeleteIsolatedStorage()
	{
	}
}
