using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Data.Linq;
using System.IO;
using System.Windows.Media.Imaging;
using ChatOn.Models;
using ChatOn.Views;
using Microsoft.Phone.UserData;

namespace ChatOn.Services;

public class ChatOnService
{
	private static ChatOnService _instance;

	private ContactDataContext _contactDB;

	private BuddyDataContext _buddyDB;

	private ChatDataContext _chatDB;

	private MessageDataContext _messageDB;

	private TrunkDataContext _trunkDB;

	private TrunkCommentDataContext _trunkCommentDB;

	private BitmapImage _profileImage;

	private bool _isBuddiesUpdated;

	private bool _reUpdateBuddyList;

	private bool _reUpdateInteraction;

	private bool _isProfileImageUpdated;

	private bool _reUpdateChatList;

	private Stream _streamToShare;

	private Stream _streamToCrop;

	private string _fileNameToShare;

	private Appointment _appointment;

	private ChatDetailPage _chatDetailPage;

	private PivotPage _pivotPage;

	private ChatChooserPage _chatChooserPage;

	private SelectBuddyPage _selectBuddyPage;

	private List<BackgroundFileRequestInfo> _transferRequestInfoList;

	private ObservableCollection<Buddy> _buddyItems;

	private List<BuddyGroup> _groupItems;

	private List<UnknownUser> _unknownUserItems;

	private List<MyContact> _contactItems;

	private ObservableCollection<Chat> _chatItems;

	private List<Message> _messageItems;

	private List<Message> _unreadMessages;

	private List<TrunkItem> _trunkItems;

	private List<TrunkComment> _trunkComments;

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

	public List<BackgroundFileRequestInfo> TransferRequestInfoList
	{
		get
		{
			return _transferRequestInfoList;
		}
		set
		{
			_transferRequestInfoList = value;
		}
	}

	public ChatChooserPage ChatChooserPage
	{
		get
		{
			return _chatChooserPage;
		}
		set
		{
			_chatChooserPage = value;
		}
	}

	public SelectBuddyPage SelectBuddyPage
	{
		get
		{
			return _selectBuddyPage;
		}
		set
		{
			_selectBuddyPage = value;
		}
	}

	public PivotPage PivotPage
	{
		get
		{
			return _pivotPage;
		}
		set
		{
			_pivotPage = value;
		}
	}

	public ChatDetailPage ChatDetailPage
	{
		get
		{
			return _chatDetailPage;
		}
		set
		{
			_chatDetailPage = value;
		}
	}

	public ContactDataContext ContactDB => _contactDB;

	public BuddyDataContext BuddyDB => _buddyDB;

	public ChatDataContext ChatDB => _chatDB;

	public MessageDataContext MessageDB => _messageDB;

	public TrunkDataContext TrunkDB => _trunkDB;

	public TrunkCommentDataContext TrunkCommentDB => _trunkCommentDB;

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

	public BitmapImage ProfileImage
	{
		get
		{
			return _profileImage;
		}
		set
		{
			_profileImage = value;
		}
	}

	public Appointment Appointment
	{
		get
		{
			return _appointment;
		}
		set
		{
			_appointment = value;
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

	public ObservableCollection<Chat> ChatItems
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

	public void CreateDatabase()
	{
		_buddyDB = new BuddyDataContext("isostore:/buddyDB.sdf");
		if (!((DataContext)_buddyDB).DatabaseExists())
		{
			((DataContext)_buddyDB).CreateDatabase();
		}
		_messageDB = new MessageDataContext("isostore:/messageDB.sdf");
		if (!((DataContext)_messageDB).DatabaseExists())
		{
			((DataContext)_messageDB).CreateDatabase();
		}
		_chatDB = new ChatDataContext("isostore:/chatDB.sdf");
		if (!((DataContext)_chatDB).DatabaseExists())
		{
			((DataContext)_chatDB).CreateDatabase();
		}
		_contactDB = new ContactDataContext("isostore:/contactDB.sdf");
		if (!((DataContext)_contactDB).DatabaseExists())
		{
			((DataContext)_contactDB).CreateDatabase();
		}
		_trunkDB = new TrunkDataContext("isostore:/trunkDB.sdf");
		if (!((DataContext)_trunkDB).DatabaseExists())
		{
			((DataContext)_trunkDB).CreateDatabase();
		}
		_trunkCommentDB = new TrunkCommentDataContext("isostore:/trunkCommentDB.sdf");
		if (!((DataContext)_trunkCommentDB).DatabaseExists())
		{
			((DataContext)_trunkCommentDB).CreateDatabase();
		}
	}

	public void DeleteDatabase(bool dispose = true)
	{
		((DataContext)_buddyDB).DeleteDatabase();
		((DataContext)_messageDB).DeleteDatabase();
		((DataContext)_chatDB).DeleteDatabase();
		((DataContext)_contactDB).DeleteDatabase();
		((DataContext)_trunkDB).DeleteDatabase();
		((DataContext)_trunkCommentDB).DeleteDatabase();
		if (dispose)
		{
			((DataContext)_buddyDB).Dispose();
			((DataContext)_messageDB).Dispose();
			((DataContext)_chatDB).Dispose();
			((DataContext)_contactDB).Dispose();
			((DataContext)_trunkDB).Dispose();
			((DataContext)_trunkCommentDB).Dispose();
		}
	}

	internal void LoadData()
	{
		new DataService().LoadAll();
	}
}
