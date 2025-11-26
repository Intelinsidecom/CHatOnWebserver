using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using ChatOn.Infrastructure;
using ChatOn.Services;
using com.sec.ssm.common;
using SDatabase;
using Windows.Storage;
using Windows.UI;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Models;

public class Chat : SDBData
{
	public enum PrevMsgLoadingStatus
	{
		InitialLoading = 1,
		Loading = 2,
		Empty = 3,
		None = 0
	}

	private Guid _chatID;

	private int _unreadMessageCount;

	private int _unreadTrunkMessageCount;

	private DateTime _date = DateTime.UtcNow;

	private string _sender;

	private string _members = "";

	private string _sessionID = "";

	private string _address = "";

	private int _port;

	private ChatType _chatType;

	private bool _isChanged;

	private int _chatTitleParam;

	private bool _isValidSession = true;

	private string _ansData = "";

	private string _name = "";

	private string _imagePath = "";

	private long _lastMergedTimeStamp;

	private string _oldSessionID = "";

	private string _fileAddress = "";

	private string _filePath = "";

	private PrevMsgLoadingStatus _prevMsgStatus = PrevMsgLoadingStatus.InitialLoading;

	private string _title = "";

	private string _subTitle = "";

	private List<Message> _messages;

	private Message _lastMessage;

	private ObservableCollection<Message> _messageItems;

	private List<string> _memberList;

	private int _addedPosition;

	private Buddy _singleChatBuddy;

	private bool _isDeletionMode;

	private bool _isInfoAvailableMode;

	private List<AnsInfo> _ansInfo;

	private string _memberCountText = "";

	private BitmapImage _profileImage;

	private bool _isAlert = true;

	private int MAX_SHOW = 200;

	private long _lastSyncTid;

	private DataService _dataService;

	private ChatService _chatService;

	private BuddyService _buddyService;

	private SSMService _ssmService;

	private SolidColorBrush _background = colorTransparent;

	public static SolidColorBrush colorTransparent = new SolidColorBrush(Colors.Transparent);

	private static SolidColorBrush colorWhite = new SolidColorBrush(Colors.White);

	private static SolidColorBrush colorGray = new SolidColorBrush(Colors.Gray);

	private static SolidColorBrush colorBlack = new SolidColorBrush(Colors.Black);

	public static SolidColorBrush colorOrange = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));

	private SolidColorBrush _nameForeground = colorBlack;

	private Brush _subTitleForeground = (Brush)(object)colorGray;

	private string _chatTypeText;

	private string _customTitle;

	public static BitmapImage DEFAULT_GROUP_CHAT_PROFILE = new BitmapImage(new Uri("ms-appx:///Images/chat_info_group.png"));

	private static BitmapImage DEFAULT_SINGLE_CHAT_PROFILE = new BitmapImage(new Uri("ms-appx:///Images/chat_info_single.png"));

	public bool IsAlert
	{
		get
		{
			return _isAlert;
		}
		set
		{
			_isAlert = value;
			NotifyPropertyChanged(() => IsAlert);
		}
	}

	public SolidColorBrush Background
	{
		get
		{
			return _background;
		}
		set
		{
			if (_background != value)
			{
				_background = value;
				if (_background.Color != Colors.Transparent)
				{
					NameForeground = colorWhite;
					SubTitleForeground = (Brush)(object)colorWhite;
				}
				else
				{
					NameForeground = colorBlack;
					SubTitleForeground = (Brush)(object)colorGray;
				}
				NotifyPropertyChanged(() => Background);
			}
		}
	}

	public SolidColorBrush NameForeground
	{
		get
		{
			return _nameForeground;
		}
		set
		{
			_nameForeground = value;
			NotifyPropertyChanged(() => NameForeground);
		}
	}

	public Brush SubTitleForeground
	{
		get
		{
			return _subTitleForeground;
		}
		set
		{
			_subTitleForeground = value;
			NotifyPropertyChanged(() => SubTitleForeground);
		}
	}

	public List<AnsInfo> AnsInfo
	{
		get
		{
			return _ansInfo;
		}
		set
		{
			_ansInfo = value;
		}
	}

	public string ChatTypeText
	{
		get
		{
			return _chatTypeText;
		}
		set
		{
			_chatTypeText = value;
			NotifyPropertyChanged(() => ChatTypeText);
		}
	}

	[SDBColumn]
	public Guid ChatID
	{
		get
		{
			return _chatID;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _chatID != value)
			{
				SetDataUpdated();
			}
			_chatID = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => ChatID);
			}
		}
	}

	[SDBColumn]
	public DateTime Date
	{
		get
		{
			return _date;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _date != value)
			{
				SetDataUpdated();
			}
			_date = value;
			NotifyPropertyChanged("");
			if (SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Date);
			}
		}
	}

	public DateTime? DisplayDate
	{
		get
		{
			if (Messages.Count == 0 && string.IsNullOrEmpty(_address) && _port == 0 && (DateTime.Now - _date).TotalSeconds < 30.0)
			{
				return _date;
			}
			if (Messages.Count == 0 || Messages.Count((Message x) => x.ItemTypeValue == Message.ItemType.MyMessage || x.ItemTypeValue == Message.ItemType.BuddyMessage) == 0)
			{
				return null;
			}
			return _date;
		}
	}

	[SDBColumn]
	public int UnreadMessageCount
	{
		get
		{
			if (Messages.Count == 0)
			{
				return 0;
			}
			return _unreadMessageCount;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _unreadMessageCount != value)
			{
				SetDataUpdated();
			}
			_unreadMessageCount = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => UnreadMessageCount);
			}
		}
	}

	[SDBColumn]
	public int UnreadTrunkMessageCount
	{
		get
		{
			if (Messages.Count == 0)
			{
				return 0;
			}
			return _unreadTrunkMessageCount;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _unreadTrunkMessageCount != value)
			{
				SetDataUpdated();
			}
			_unreadTrunkMessageCount = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => UnreadTrunkMessageCount);
			}
		}
	}

	[SDBColumn(Encrypt = true)]
	public string Sender
	{
		get
		{
			return _sender;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _sender != value)
			{
				SetDataUpdated();
			}
			_sender = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Sender);
			}
		}
	}

	[SDBColumn(Encrypt = true)]
	public string Members
	{
		get
		{
			return _members;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _members != value)
			{
				SetDataUpdated();
			}
			_members = value;
		}
	}

	[SDBColumn]
	public string SessionID
	{
		get
		{
			return _sessionID;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _sessionID != value)
			{
				SetDataUpdated();
			}
			_sessionID = value;
		}
	}

	[SDBColumn]
	public string Address
	{
		get
		{
			return _address;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _address != value)
			{
				SetDataUpdated();
			}
			_address = value;
		}
	}

	[SDBColumn]
	public int Port
	{
		get
		{
			return _port;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _port != value)
			{
				SetDataUpdated();
			}
			_port = value;
		}
	}

	[SDBColumn]
	public ChatType ChatType
	{
		get
		{
			return _chatType;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _chatType != value)
			{
				SetDataUpdated();
			}
			_chatType = value;
			if (ChatType == ChatType.BROADCAST)
			{
				_chatTypeText = Utility.GetResourceString("IDS_CHATON_HEADER_BROADCAST");
			}
			else if (ChatType == ChatType.GROUP)
			{
				_chatTypeText = Utility.GetResourceString("IDS_CHATON_HEADER_GROUP_CHAT");
			}
			else if (ChatType == ChatType.SINGLE)
			{
				_chatTypeText = Utility.GetResourceString("IDS_CHATON_HEADER_CHAT");
			}
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => ChatType);
			}
		}
	}

	[SDBColumn]
	public bool IsChanged
	{
		get
		{
			return _isChanged;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _isChanged != value)
			{
				SetDataUpdated();
			}
			_isChanged = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => IsChanged);
			}
		}
	}

	[SDBColumn]
	public int ChatTitleParam
	{
		get
		{
			return _chatTitleParam;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _chatTitleParam != value)
			{
				SetDataUpdated();
			}
			_chatTitleParam = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => ChatTitleParam);
			}
		}
	}

	[SDBColumn]
	public bool IsValidSession
	{
		get
		{
			return _isValidSession;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _isValidSession != value)
			{
				SetDataUpdated();
			}
			_isValidSession = value;
			NotifyPropertyChanged(() => IsValidSession);
		}
	}

	[SDBColumn(Encrypt = true)]
	public string AnsData
	{
		get
		{
			return _ansData;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _ansData != value)
			{
				SetDataUpdated();
			}
			_ansData = value;
		}
	}

	[SDBColumn]
	public string Name
	{
		get
		{
			return _name;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _name != value)
			{
				SetDataUpdated();
			}
			_name = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Name);
				NotifyPropertyChanged(() => Title);
			}
		}
	}

	[SDBColumn]
	public string ImagePath
	{
		get
		{
			return _imagePath;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _imagePath != value)
			{
				SetDataUpdated();
			}
			_imagePath = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => ImagePath);
			}
			NotifyPropertyChanged(() => ProfileImage);
		}
	}

	[SDBColumn]
	public long LastMergedTimeStamp
	{
		get
		{
			return _lastMergedTimeStamp;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _lastMergedTimeStamp != value)
			{
				SetDataUpdated();
			}
			_lastMergedTimeStamp = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => LastMergedTimeStamp);
			}
		}
	}

	[SDBColumn]
	public string OldSessionID
	{
		get
		{
			return _oldSessionID;
		}
		set
		{
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => OldSessionID);
			}
			_oldSessionID = value;
		}
	}

	public string CustomTitle
	{
		get
		{
			return _customTitle;
		}
		set
		{
			_customTitle = value;
			NotifyPropertyChanged(() => CustomTitle);
		}
	}

	public string Title
	{
		get
		{
			if (!string.IsNullOrEmpty(_customTitle))
			{
				return _customTitle;
			}
			if (!string.IsNullOrEmpty(_name))
			{
				return _name;
			}
			return _title;
		}
		set
		{
			_title = value;
			NotifyPropertyChanged(() => Title);
			NotifyPropertyChanged(() => SubTitle);
		}
	}

	public string SubTitle
	{
		get
		{
			if (Messages.Count == 0)
			{
				return string.Empty;
			}
			Message message = (from x in Messages
				where x.Type != "noti" && (x.ActivityState == Message.State.Sent || x.ActivityState == Message.State.Received)
				orderby x.Time descending
				select x).FirstOrDefault();
			if (message == null)
			{
				return string.Empty;
			}
			return _chatService.GetLastMessageFormat(message);
		}
	}

	public string MemberCountText
	{
		get
		{
			return _memberCountText;
		}
		set
		{
			_memberCountText = value;
			NotifyPropertyChanged(() => MemberCountText);
		}
	}

	public List<Message> Messages
	{
		get
		{
			return _messages;
		}
		set
		{
			_messages = value;
		}
	}

	public ObservableCollection<Message> MessageItems
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

	public List<string> MemberList
	{
		get
		{
			return _memberList;
		}
		set
		{
			_memberList = value;
		}
	}

	public Buddy SingleChatBuddy
	{
		get
		{
			return _singleChatBuddy;
		}
		set
		{
			_singleChatBuddy = value;
			NotifyPropertyChanged(() => SingleChatBuddy);
		}
	}

	public bool IsDeletionMode
	{
		get
		{
			return _isDeletionMode;
		}
		set
		{
			_isDeletionMode = value;
			NotifyPropertyChanged(() => IsDeletionMode);
		}
	}

	public bool IsInfoAvailableMode
	{
		get
		{
			return _isInfoAvailableMode;
		}
		set
		{
			_isInfoAvailableMode = value;
			NotifyPropertyChanged(() => IsInfoAvailableMode);
		}
	}

	public Message LastMessage
	{
		get
		{
			return _lastMessage;
		}
		set
		{
			_lastMessage = value;
			NotifyPropertyChanged(() => DisplayDate);
			NotifyPropertyChanged(() => SubTitle);
		}
	}

	public BitmapImage ProfileImage
	{
		get
		{
			//IL_00e5: Unknown result type (might be due to invalid IL or missing references)
			//IL_00ef: Expected O, but got Unknown
			SSMService ssmService = new SSMService();
			DataService dataService = new DataService();
			new BuddyService(dataService, ssmService);
			switch (_chatType)
			{
			case ChatType.SINGLE:
			{
				if (MemberList.Count == 0)
				{
					return DEFAULT_SINGLE_CHAT_PROFILE;
				}
				Buddy buddy = dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == MemberList[0]);
				if (buddy != null)
				{
					return buddy.ThumbProfileImage;
				}
				UnknownUser unknownUser = dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == MemberList[0]);
				if (unknownUser == null)
				{
					unknownUser = new UnknownUser();
					unknownUser.PhoneNumber = MemberList[0];
					dataService.AddUnknownUser(unknownUser);
				}
				unknownUser.LoadProfileImageCompleted += user_LoadProfileImageCompleted;
				unknownUser.LoadProfileImage(applyTheme: true);
				return unknownUser.ProfileImage;
			}
			case ChatType.BROADCAST:
				_profileImage = new BitmapImage(new Uri("ms-appx:///Images/chat_info_broadcast.png"));
				break;
			case ChatType.GROUP:
				if (_profileImage == null)
				{
					_profileImage = DEFAULT_GROUP_CHAT_PROFILE;
				}
				break;
			}
			return _profileImage;
		}
		set
		{
			_profileImage = value;
			NotifyPropertyChanged(() => ProfileImage);
		}
	}

	[SDBColumn]
	public PrevMsgLoadingStatus PrevMsgStatus
	{
		get
		{
			return _prevMsgStatus;
		}
		set
		{
			_prevMsgStatus = value;
			NotifyPropertyChanged(() => PrevMsgStatus);
		}
	}

	[SDBColumn]
	public long LastSyncTid
	{
		get
		{
			return _lastSyncTid;
		}
		set
		{
			_lastSyncTid = value;
			NotifyPropertyChanged(() => LastSyncTid);
		}
	}

	[SDBColumn]
	public string FileAddress
	{
		get
		{
			return _fileAddress;
		}
		set
		{
			_fileAddress = value;
			NotifyPropertyChanged(() => FileAddress);
		}
	}

	[SDBColumn]
	public string FilePath
	{
		get
		{
			return _filePath;
		}
		set
		{
			_filePath = value;
			NotifyPropertyChanged(() => FilePath);
		}
	}

	public bool IsDownloadingProfile { get; set; }

	private void user_LoadProfileImageCompleted(object sender, object e)
	{
		UnknownUser unknownUser = null;
		if (sender is UnknownUser unknownUser2)
		{
			unknownUser2.LoadProfileImageCompleted -= user_LoadProfileImageCompleted;
			NotifyChatProfileImageUpdated();
		}
	}

	internal void NotifyChatProfileImageUpdated()
	{
		NotifyPropertyChanged(() => ProfileImage);
	}

	public Chat()
	{
		_chatID = Guid.NewGuid();
		_messages = new List<Message>();
		_messageItems = new ObservableCollection<Message>();
		_memberList = new List<string>();
		_ansInfo = new List<AnsInfo>();
		_isChanged = false;
		_dataService = new DataService();
		_ssmService = new SSMService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.ChatOnID);
	}

	public void AddMessage(Message msg)
	{
		msg.ChatID = _chatID;
		msg.Chat = this;
		if (_messageItems.Count > 0 && _messages.Count > 0 && _messages.Last() != _messageItems.Last())
		{
			ClearMessageItems();
			LoadMessageItems(isPrev: true);
		}
		int num = 400;
		if (_messageItems.Count > num)
		{
			for (int i = 0; i < num / 4; i++)
			{
				_messageItems.Remove(_messageItems.First());
				_addedPosition--;
			}
		}
		int num2 = -1;
		if (msg.ActivityState != Message.State.Typed && msg.ActivityState != Message.State.Uploading)
		{
			for (int j = 0; j < _messages.Count; j++)
			{
				if (msg.Time < _messages[j].Time)
				{
					num2 = j;
					break;
				}
			}
		}
		if (num2 == -1)
		{
			_messages.Add(msg);
			_messageItems.Add(msg);
			_addedPosition++;
		}
		else
		{
			_messages.Insert(num2, msg);
			if (_addedPosition - _messageItems.Count == 0 && num2 <= _addedPosition)
			{
				_messageItems.Insert(num2, msg);
				_addedPosition++;
			}
		}
		ReflectMessageInfo(msg);
	}

	public void ReflectMessageInfo(Message msg)
	{
		if (!string.IsNullOrEmpty(msg.SessionID))
		{
			SessionID = msg.SessionID;
		}
		if (!string.IsNullOrEmpty(msg.Address))
		{
			Address = msg.Address;
			Port = msg.Port;
		}
		if (msg.Time != 0 && msg.Type != "noti")
		{
			Date = Utility.GetDateTimeFromMiliseconds(msg.Time);
		}
	}

	internal void LoadMemberList()
	{
		string[] array = Utility.Split(_members);
		string[] array2 = array;
		foreach (string text in array2)
		{
			if (!string.IsNullOrEmpty(text))
			{
				_memberList.Add(text);
			}
		}
	}

	internal bool IsRemainLoadingItems()
	{
		if (_addedPosition >= _messages.Count)
		{
			return false;
		}
		return true;
	}

	internal void AddDateHeaderAndCheckbox()
	{
		DateTime dateTime = default(DateTime);
		if (_messageItems == null)
		{
			return;
		}
		foreach (Message messageItem in _messageItems)
		{
			messageItem.ShowMoreButton = false;
			messageItem.ShowCheckbox = _isDeletionMode;
			if (messageItem.Time != 0)
			{
				DateTime dateTimeFromMiliseconds = Utility.GetDateTimeFromMiliseconds(messageItem.Time);
				if ((dateTime.Day != dateTimeFromMiliseconds.Day || dateTime.Month != dateTimeFromMiliseconds.Month || dateTime.Year != dateTimeFromMiliseconds.Year) && messageItem.ActivityState != Message.State.SendingFailed && messageItem.ActivityState != Message.State.UploadingFailed)
				{
					messageItem.ShowDate = true;
				}
				else
				{
					messageItem.ShowDate = false;
				}
				dateTime = dateTimeFromMiliseconds;
			}
		}
		if ((_prevMsgStatus != PrevMsgLoadingStatus.None || _messageItems.Count < Messages.Count) && _messageItems.Count > 0)
		{
			_messageItems[0].ShowMoreButton = false;
		}
	}

	public async void ReplaceCoruptMessage(Message message)
	{
		if (string.IsNullOrEmpty(message.MediaFilePath))
		{
			return;
		}
		string[] parse = message.MediaFilePath.Split('\\');
		string folder = parse[0];
		string fileName = parse[1];
		if (await Utility.IsFileExistCheck(folder, fileName) != null)
		{
			return;
		}
		try
		{
			StorageFile file = await Utility.IsFileExist(folder, fileName);
			if (file != null)
			{
				await file.DeleteAsync();
			}
		}
		catch (Exception)
		{
		}
		message.MediaFilePath = string.Empty;
		int idx;
		for (idx = 0; idx < _messageItems.Count && !(_messageItems[idx].MessageID == message.MessageID); idx++)
		{
		}
		DeleteMessage(message);
		InsertMessageIfNotExists(idx, message);
		NotifyPropertyChanged(() => MessageItems);
	}

	internal Message LoadMessageItems(bool isPrev)
	{
		int num = 0;
		int num2 = 30;
		if (_addedPosition == 0)
		{
			num2 = ((_unreadMessageCount > 10) ? 10 : ((_unreadMessageCount < 0) ? 10 : (10 - _unreadMessageCount)));
		}
		Message result = null;
		if (isPrev)
		{
			for (int i = 0; i < num2; i++)
			{
				int num3 = _messages.Count - _addedPosition - 1;
				if (num3 < 0)
				{
					break;
				}
				ReplaceCoruptMessage(_messages[num3]);
				InsertMessageIfNotExists(0, _messages[num3]);
				_addedPosition++;
				num++;
				if (i == 0)
				{
					result = _messages[num3];
				}
			}
		}
		else
		{
			for (int j = 0; j < num2; j++)
			{
				int num4 = _messages.Count - _addedPosition + MessageItems.Count;
				if (num4 >= _messages.Count)
				{
					break;
				}
				ReplaceCoruptMessage(_messages[num4]);
				AddMessageIfNotExsist(_messages[num4]);
				if (j == 0)
				{
					result = _messages[num4];
				}
				num++;
			}
		}
		AddDateHeaderAndCheckbox();
		NotifyPropertyChanged(() => MessageItems);
		return result;
	}

	internal void ClearMessageItems()
	{
		_messageItems.Clear();
		_addedPosition = 0;
	}

	internal void DeleteMessage(Message msg)
	{
		_messages.Remove(msg);
		_messageItems.Remove(msg);
		if (_addedPosition > 0)
		{
			_addedPosition--;
		}
	}

	internal void SortMessage()
	{
		Stopwatch stopwatch = new Stopwatch();
		stopwatch.Start();
		List<Message> list = new List<Message>(MessageItems);
		list.Sort(Message.CompareByTime);
		_messages.Sort(Message.CompareByTime);
		int num;
		do
		{
			num = 0;
			for (num = MessageItems.Count() - 1; num >= 0; num--)
			{
				if (MessageItems[num].MessageID != list[num].MessageID)
				{
					MessageItems.Remove(list[num]);
					MessageItems.Insert(num, list[num]);
					break;
				}
			}
		}
		while (num > 0);
		stopwatch.Stop();
	}

	public async void LoadProfileImage()
	{
		if (await Utility.IsFileExist(_chatID.ToString(), _imagePath) != null)
		{
			if (!string.IsNullOrEmpty(_imagePath) && _imagePath.Contains("http"))
			{
				ProfileImage = new BitmapImage(new Uri(_imagePath));
				return;
			}
			StorageFolder localFolder = ApplicationData.Current.LocalFolder;
			ProfileImage = new BitmapImage(new Uri(new Uri("ms-appx://"), localFolder.Path + "\\" + _chatID.ToString() + "\\" + _imagePath));
		}
	}

	public void RemoveLatestMessagesForPrevMessagesByMemoryLimit()
	{
		if (_messageItems.Count > MAX_SHOW)
		{
			int num = _messageItems.Count - MAX_SHOW;
			for (int i = 0; i < num; i++)
			{
				_messageItems.Remove(_messageItems.Last());
			}
		}
	}

	public void AddMessage(Message msg, bool toPrev = false)
	{
		msg.ChatID = _chatID;
		msg.Chat = this;
		if (_messageItems.Count > 0 && _messages.Count > 0 && _messages.Last() != _messageItems.Last())
		{
			ClearMessageItems();
			LoadMessageItems(isPrev: true);
		}
		int num = -1;
		if (msg.ActivityState != Message.State.Typed && msg.ActivityState != Message.State.Uploading)
		{
			for (int i = 0; i < _messages.Count; i++)
			{
				if (msg.Time < _messages[i].Time)
				{
					num = i;
					break;
				}
			}
		}
		if (num == -1)
		{
			_messages.Add(msg);
			_messageItems.Add(msg);
			_addedPosition++;
		}
		else
		{
			_messages.Insert(num, msg);
			if (_addedPosition - _messageItems.Count == 0 && _messages.Count - num <= _addedPosition)
			{
				_messageItems.Insert(_messageItems.Count - (_messages.Count - num), msg);
				_addedPosition++;
			}
		}
		ReflectMessageInfo(msg);
	}

	public bool IsGroupChat()
	{
		_ = ChatType;
		return ChatType == ChatType.GROUP;
	}

	internal bool IsSingleChat()
	{
		return ChatType == ChatType.SINGLE;
	}

	private void InsertMessageIfNotExists(int index, Message message)
	{
		if (MessageItems.FirstOrDefault((Message x) => x.NumberID == message.NumberID) == null)
		{
			MessageItems.Insert(index, message);
		}
	}

	private void AddMessageIfNotExsist(Message message)
	{
		if (MessageItems.FirstOrDefault((Message x) => x.NumberID == message.NumberID) == null)
		{
			MessageItems.Add(message);
		}
	}

	internal void BuddyProfileUpdated()
	{
		if (Title == SingleChatBuddy.Name)
		{
			return;
		}
		Title = SingleChatBuddy.Name;
		NotifyPropertyChanged(() => Sender);
		foreach (Message messageItem in MessageItems)
		{
			messageItem.NotifySenderUpdated();
			NotifyPropertyChanged(() => Title);
		}
	}

	internal bool IsBoradcastChat()
	{
		return ChatType == ChatType.BROADCAST;
	}

	internal void UpdateChatSummary(BuddyService _buddyService)
	{
		Message message = Messages.OrderByDescending((Message x) => x.Time).FirstOrDefault((Message x) => x.Type != "noti" && x.Type != "ans" && (x.ActivityState == Message.State.Sent || x.ActivityState == Message.State.Received));
		if (message == null)
		{
			return;
		}
		ReflectMessageInfo(message);
		string text = "";
		if (message.ActivityState != Message.State.Received)
		{
			text = Utility.GetResourceString("IDS_CHATON_POP_ME_C_PS_ABB");
			text = text.Replace("%s", "");
		}
		else if (IsGroupChat())
		{
			text = _buddyService.GetBuddyNameByNumber(message.Sender, out var _) + ": ";
		}
		if (message.Type == "media")
		{
			string[] array = Utility.Split(message.Text, '\n');
			if (array[0] == "image" && !message.Text.Contains("download/anicon"))
			{
				text += Utility.GetResourceString("IDS_CHATON_SK3_IMAGE");
			}
			else if (array[0] == "image" && message.Text.Contains("download/anicon"))
			{
				text += Utility.GetResourceString("IDS_CHATON_TAB4_ANICON");
			}
			if (array[0] == "mixed")
			{
				if (string.IsNullOrEmpty(array[1]))
				{
					if (array[1] == "image" && message.Text.Contains("download/anicon"))
					{
						text += Utility.GetResourceString("IDS_CHATON_TAB4_ANICON");
					}
					else if (array[1] == "image" && !message.Text.Contains("download/anicon"))
					{
						text += Utility.GetResourceString("IDS_CHATON_SK3_IMAGE");
					}
					else if (array[1] == "audio")
					{
						text += Utility.GetResourceString("IDS_CHATON_HEADER_AUDIO");
					}
					else if (array[1] == "video")
					{
						text += Utility.GetResourceString("IDS_CHATON_HEADER_VIDEO");
					}
					else if (array[1] == "contact")
					{
						text += Utility.GetResourceString("IDS_CHATON_SK3_CONTACT");
					}
					else if (array[1] == "geo")
					{
						text += Utility.GetResourceString("IDS_CHATON_BUTTON_MAP");
					}
				}
				text += Utility.GetResourceString("IDS_CHATON_SK3_IMAGE");
			}
			else if (array[0] == "audio")
			{
				text += Utility.GetResourceString("IDS_CHATON_HEADER_AUDIO");
			}
			else if (array[0] == "video")
			{
				text += Utility.GetResourceString("IDS_CHATON_HEADER_VIDEO");
			}
			else if (array[0] == "contact")
			{
				text += Utility.GetResourceString("IDS_CHATON_SK3_CONTACT");
			}
			else if (array[0] == "calendar")
			{
				text += Utility.GetResourceString("IDS_CHATON_SK3_CALENDAR");
			}
			else if (array[0] == "geo")
			{
				text += Utility.GetResourceString("IDS_CHATON_BUTTON_MAP");
			}
			else if (message.IncompletedMediaMessage())
			{
				text += message.Text;
			}
		}
		else
		{
			text += message.Text;
		}
		NotifyPropertyChanged(() => SubTitle);
	}

	internal bool IsNewChat()
	{
		if (string.IsNullOrWhiteSpace(_sessionID))
		{
			return !IsBoradcastChat();
		}
		return false;
	}
}
