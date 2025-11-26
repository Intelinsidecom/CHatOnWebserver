using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Data.Linq;
using System.Data.Linq.Mapping;
using System.Diagnostics;
using System.Linq;
using ChatOn.Infrastructure;
using com.sec.ssm.common;

namespace ChatOn.Models;

[Table]
public class Chat : NotificationObject
{
	[Column(IsVersion = true)]
	private Binary _version;

	private Guid _chatID;

	private int _unreadMessageCount;

	private int _unreadTrunkMessageCount;

	private DateTime _date = DateTime.UtcNow;

	private string _sender;

	private string _members = "";

	private string _sessionID = "";

	private string _address;

	private int _port;

	private ChatType _chatType;

	private bool _isChanged;

	private int _chatTitleParam;

	private bool? _isValidSession = true;

	private string _ansData = "";

	private string _title = "";

	private string _subTitle = "";

	private List<Message> _messages;

	private Message _lastMessage;

	private ObservableCollection<Message> _messageItems;

	private List<string> _memberList;

	private int _addedPosition;

	private Buddy _singleChatBuddy;

	private bool _isDeletionMode;

	private List<AnsInfo> _ansInfo;

	private string _memberCountText = "";

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

	[Column(IsPrimaryKey = true)]
	public Guid ChatID
	{
		get
		{
			return _chatID;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => ChatID);
			}
			_chatID = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => ChatID);
			}
		}
	}

	[Column]
	public DateTime Date
	{
		get
		{
			return _date;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Date);
			}
			_date = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => Date);
			}
		}
	}

	[Column]
	public int UnreadMessageCount
	{
		get
		{
			return _unreadMessageCount;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => UnreadMessageCount);
			}
			_unreadMessageCount = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => UnreadMessageCount);
			}
		}
	}

	[Column]
	public int UnreadTrunkMessageCount
	{
		get
		{
			return _unreadTrunkMessageCount;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => UnreadTrunkMessageCount);
			}
			_unreadTrunkMessageCount = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => UnreadTrunkMessageCount);
			}
		}
	}

	[Column]
	public string Sender
	{
		get
		{
			return _sender;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Sender);
			}
			_sender = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => Sender);
			}
		}
	}

	[Column]
	public string Members
	{
		get
		{
			return _members;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Members);
			}
			_members = value;
		}
	}

	[Column]
	public string SessionID
	{
		get
		{
			return _sessionID;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => SessionID);
			}
			_sessionID = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => SessionID);
			}
		}
	}

	[Column]
	public string Address
	{
		get
		{
			return _address;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Address);
			}
			_address = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => Address);
			}
		}
	}

	[Column]
	public int Port
	{
		get
		{
			return _port;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Port);
			}
			_port = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => Port);
			}
		}
	}

	[Column]
	public ChatType ChatType
	{
		get
		{
			return _chatType;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => ChatType);
			}
			_chatType = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => ChatType);
			}
		}
	}

	[Column]
	public bool IsChanged
	{
		get
		{
			return _isChanged;
		}
		set
		{
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanging(() => IsChanged);
			}
			_isChanged = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => IsChanged);
			}
		}
	}

	[Column]
	public int ChatTitleParam
	{
		get
		{
			return _chatTitleParam;
		}
		set
		{
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanging(() => ChatTitleParam);
			}
			_chatTitleParam = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => ChatTitleParam);
			}
		}
	}

	[Column]
	public bool? IsValidSession
	{
		get
		{
			return _isValidSession;
		}
		set
		{
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanging(() => IsValidSession);
			}
			_isValidSession = value;
		}
	}

	[Column]
	public string AnsData
	{
		get
		{
			return _ansData;
		}
		set
		{
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanging(() => AnsData);
			}
			_ansData = value;
		}
	}

	public string Title
	{
		get
		{
			return _title;
		}
		set
		{
			_title = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => Title);
			}
		}
	}

	public string SubTitle
	{
		get
		{
			return _subTitle;
		}
		set
		{
			_subTitle = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => SubTitle);
			}
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
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => MemberCountText);
			}
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
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => SingleChatBuddy);
			}
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
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => IsDeletionMode);
			}
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
		}
	}

	public Chat()
	{
		_chatID = Guid.NewGuid();
		_messages = new List<Message>();
		_messageItems = new ObservableCollection<Message>();
		_memberList = new List<string>();
		_ansInfo = new List<AnsInfo>();
		_isChanged = false;
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
		if (_messageItems.Count > 50)
		{
			_messageItems.Remove(_messageItems.First());
			_addedPosition--;
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
			if (_addedPosition - _messageItems.Count == 0 && num <= _addedPosition)
			{
				_messageItems.Insert(num, msg);
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
		if (msg.Time != 0)
		{
			Date = Utility.GetDateTimeFromMiliseconds(msg.Time);
		}
	}

	internal void LoadMemberList()
	{
		string[] array = Utility.Split(_members);
		string[] array2 = array;
		foreach (string item in array2)
		{
			_memberList.Add(item);
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
		foreach (Message messageItem in _messageItems)
		{
			messageItem.ShowCheckbox = _isDeletionMode;
			if (messageItem.Time != 0)
			{
				DateTime dateTimeFromMiliseconds = Utility.GetDateTimeFromMiliseconds(messageItem.Time);
				if (dateTime.Day != dateTimeFromMiliseconds.Day || dateTime.Month != dateTimeFromMiliseconds.Month || dateTime.Year != dateTimeFromMiliseconds.Year)
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
	}

	internal int LoadMessageItems(bool isPrev)
	{
		int num = 0;
		int num2 = 30;
		if (_addedPosition == 0)
		{
			num2 = 10;
		}
		if (isPrev)
		{
			if (_messageItems.Count > 50)
			{
				int num3 = _messageItems.Count - 50;
				for (int i = 0; i < num3; i++)
				{
					_messageItems.Remove(_messageItems.Last());
				}
			}
			for (int j = 0; j < num2; j++)
			{
				int num4 = _messages.Count - _addedPosition - 1;
				if (num4 < 0)
				{
					break;
				}
				_messageItems.Insert(0, _messages[num4]);
				_addedPosition++;
				num++;
			}
		}
		else
		{
			if (_messageItems.Count > 50)
			{
				int num5 = _messageItems.Count - 50;
				for (int k = 0; k < num5; k++)
				{
					_messageItems.Remove(_messageItems.First());
					_addedPosition--;
				}
			}
			for (int l = 0; l < num2; l++)
			{
				int num6 = _messages.Count - _addedPosition + _messageItems.Count;
				if (num6 >= _messages.Count)
				{
					break;
				}
				_messageItems.Add(_messages[num6]);
				num++;
			}
		}
		AddDateHeaderAndCheckbox();
		return num;
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
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		Stopwatch val = new Stopwatch();
		val.Start();
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
		val.Stop();
	}
}
