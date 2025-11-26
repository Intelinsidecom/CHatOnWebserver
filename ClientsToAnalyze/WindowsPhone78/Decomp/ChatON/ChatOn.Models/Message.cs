using System;
using System.Data.Linq;
using System.Data.Linq.Mapping;
using System.Linq;
using System.Windows;
using System.Windows.Media.Imaging;
using ChatOn.Infrastructure;
using ChatOn.Services;
using com.sec.ssm.common;

namespace ChatOn.Models;

[Table]
public class Message : NotificationObject
{
	public enum State
	{
		Typed,
		Uploading,
		UploadingFailed,
		SendingFailed,
		Sent,
		CannotResend,
		GotAnswerBack,
		Received
	}

	public enum ItemType
	{
		Date,
		BuddyMessage,
		MyMessage,
		Noti
	}

	[Column(IsVersion = true)]
	private Binary _version;

	private Guid _messageID;

	private string _tid;

	private long _numberID;

	private string _sender = "";

	private string _receiver;

	private string _text;

	private long _time;

	private string _sessionID;

	private string _type;

	private string _address = "";

	private int _port;

	private ChatType _chatType;

	private State _state;

	private Guid _chatID;

	private string _mediaFilePath;

	private Chat _chat;

	private int _progressValue;

	private bool _isDownloading;

	private object _tag;

	private bool _showDate;

	private BitmapImage _thumbImage;

	private bool _isThumbnailDownloading;

	private bool _isChecked;

	private bool _isChecked2;

	private bool _showCheckbox;

	private int _blockNotificationCount;

	private int _receiverCount;

	[Column(IsPrimaryKey = true)]
	public Guid MessageID
	{
		get
		{
			return _messageID;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => MessageID);
			}
			_messageID = value;
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
			{
				NotifyPropertyChanged(() => MessageID);
			}
		}
	}

	[Column]
	public string Tid
	{
		get
		{
			return _tid;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Tid);
			}
			_tid = value;
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
			{
				NotifyPropertyChanged(() => Tid);
			}
		}
	}

	[Column]
	public long NumberID
	{
		get
		{
			return _numberID;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => NumberID);
			}
			_numberID = value;
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
			{
				NotifyPropertyChanged(() => NumberID);
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
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
			{
				NotifyPropertyChanged(() => Sender);
			}
		}
	}

	[Column]
	public string Receiver
	{
		get
		{
			return _receiver;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Sender);
			}
			_receiver = value;
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
			{
				NotifyPropertyChanged(() => Receiver);
			}
		}
	}

	[Column]
	public string Text
	{
		get
		{
			return _text;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Text);
			}
			_text = value;
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
			{
				NotifyPropertyChanged(() => Text);
			}
		}
	}

	[Column]
	public long Time
	{
		get
		{
			return _time;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Time);
			}
			_time = value;
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
			{
				NotifyPropertyChanged(() => Time);
			}
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
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
			{
				NotifyPropertyChanged(() => SessionID);
			}
		}
	}

	[Column]
	public string Type
	{
		get
		{
			return _type;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Type);
			}
			_type = value;
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
			{
				NotifyPropertyChanged(() => Type);
				NotifyPropertyChanged(() => TextVisibility);
				NotifyPropertyChanged(() => PhotoVisibility);
				NotifyPropertyChanged(() => MediaIconVisibility);
				NotifyPropertyChanged(() => ThumbImage);
				NotifyPropertyChanged(() => MediaIconUri);
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
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
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
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
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
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
			{
				NotifyPropertyChanged(() => ChatType);
			}
		}
	}

	[Column]
	public State ActivityState
	{
		get
		{
			return _state;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => ActivityState);
			}
			_state = value;
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
			{
				NotifyPropertyChanged(() => ActivityState);
			}
		}
	}

	[Column]
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
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
			{
				NotifyPropertyChanged(() => ChatID);
			}
		}
	}

	[Column]
	public string MediaFilePath
	{
		get
		{
			return _mediaFilePath;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => MediaFilePath);
			}
			_mediaFilePath = value;
			if (!NotificationObject.IsBlockChangedNotification && _blockNotificationCount == 0)
			{
				NotifyPropertyChanged(() => MediaFilePath);
			}
		}
	}

	public int AnswerBackCount
	{
		get
		{
			string[] array = Utility.Split(_receiver);
			int num = array.Length;
			if (_time == 0)
			{
				return num;
			}
			string[] array2 = array;
			string number;
			for (int i = 0; i < array2.Length; i++)
			{
				number = array2[i];
				AnsInfo ansInfo = _chat.AnsInfo.FirstOrDefault((AnsInfo c) => c.PhoneNumber == number);
				if (ansInfo != null && ansInfo.Time >= _time)
				{
					num--;
				}
			}
			return num;
		}
	}

	public Chat Chat
	{
		get
		{
			return _chat;
		}
		set
		{
			_chat = value;
		}
	}

	public int ProgressValue
	{
		get
		{
			return _progressValue;
		}
		set
		{
			_progressValue = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => ProgressValue);
			}
		}
	}

	public bool IsDownloading
	{
		get
		{
			return _isDownloading;
		}
		set
		{
			_isDownloading = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => IsDownloading);
			}
		}
	}

	public object Tag
	{
		get
		{
			return _tag;
		}
		set
		{
			_tag = value;
		}
	}

	public bool ShowDate
	{
		get
		{
			return _showDate;
		}
		set
		{
			if (value == _showDate)
			{
				return;
			}
			_showDate = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => ShowDate);
			}
		}
	}

	public BitmapImage ThumbImage
	{
		get
		{
			if (_isThumbnailDownloading)
			{
				return _thumbImage;
			}
			if (_type != "media")
			{
				return null;
			}
			if (string.IsNullOrEmpty(_text))
			{
				return null;
			}
			string[] array = Utility.Split(_text, '\n');
			if (array[0] != "image")
			{
				return null;
			}
			BitmapImage bitmapImage = Utility.LoadJpeg(_sessionID + "\\thumb_" + array[3]);
			if (bitmapImage == null)
			{
				if (_mediaFilePath != null)
				{
					string[] array2 = Utility.Split(_mediaFilePath, '\\');
					if (string.IsNullOrEmpty(array2[0]))
					{
						bitmapImage = Utility.LoadJpeg("thumb_" + array2[1]);
					}
					if (bitmapImage != null)
					{
						_thumbImage = bitmapImage;
						return _thumbImage;
					}
					ActivityState = State.CannotResend;
				}
				else
				{
					_isThumbnailDownloading = true;
					LoadImageThumbnail();
				}
			}
			else
			{
				_thumbImage = bitmapImage;
			}
			return _thumbImage;
		}
		set
		{
			_thumbImage = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => ThumbImage);
			}
		}
	}

	public bool IsChecked
	{
		get
		{
			return _isChecked;
		}
		set
		{
			if (_isChecked == value)
			{
				return;
			}
			_isChecked = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => IsChecked);
			}
		}
	}

	public bool IsChecked2
	{
		get
		{
			return _isChecked2;
		}
		set
		{
			_isChecked2 = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => IsChecked2);
			}
		}
	}

	public bool ShowCheckbox
	{
		get
		{
			return _showCheckbox;
		}
		set
		{
			if (value == _showCheckbox)
			{
				return;
			}
			_showCheckbox = value;
			if (!NotificationObject.IsBlockChangedNotification)
			{
				NotifyPropertyChanged(() => ShowCheckbox);
			}
		}
	}

	public Uri MediaIconUri
	{
		get
		{
			if (_type != "media")
			{
				return null;
			}
			if (string.IsNullOrEmpty(_text))
			{
				return null;
			}
			string[] array = Utility.Split(_text, '\n');
			if (array.Length == 0)
			{
				return null;
			}
			return array[0] switch
			{
				"video" => new Uri("\\Images\\chat_video.png", UriKind.Relative), 
				"audio" => new Uri("\\Images\\chat_recording.png", UriKind.Relative), 
				"contact" => new Uri("\\Images\\chat_contact.png", UriKind.Relative), 
				"calendar" => new Uri("\\Images\\chat_calendar.png", UriKind.Relative), 
				"geo" => new Uri("\\Images\\chat_map.png", UriKind.Relative), 
				_ => null, 
			};
		}
	}

	public Visibility TextVisibility
	{
		get
		{
			if (_type == "text")
			{
				return Visibility.Visible;
			}
			return Visibility.Collapsed;
		}
	}

	public Visibility PhotoVisibility
	{
		get
		{
			if (string.IsNullOrEmpty(_text))
			{
				return Visibility.Collapsed;
			}
			if (_type != "media")
			{
				return Visibility.Collapsed;
			}
			string[] array = Utility.Split(_text, '\n');
			if (array.Length > 0 && array[0] == "image")
			{
				return Visibility.Visible;
			}
			return Visibility.Collapsed;
		}
	}

	public Visibility MediaIconVisibility
	{
		get
		{
			if (string.IsNullOrEmpty(_text))
			{
				return Visibility.Collapsed;
			}
			if (_type != "media")
			{
				return Visibility.Collapsed;
			}
			string[] array = Utility.Split(_text, '\n');
			if (array.Length > 0 && array[0] != "image")
			{
				return Visibility.Visible;
			}
			return Visibility.Collapsed;
		}
	}

	public string MediaText
	{
		get
		{
			if (string.IsNullOrEmpty(_text))
			{
				return null;
			}
			if (_type != "media")
			{
				return null;
			}
			string[] array = Utility.Split(_text, '\n');
			if (array.Length > 0 && (array[0] == "calendar" || array[0] == "contact"))
			{
				return array[5];
			}
			return null;
		}
	}

	public ItemType ItemTypeValue
	{
		get
		{
			if (_state == State.Sent || _state == State.Typed || _state == State.Uploading || _state == State.UploadingFailed || _state == State.SendingFailed || _state == State.CannotResend)
			{
				return ItemType.MyMessage;
			}
			if (_type == "noti")
			{
				return ItemType.Noti;
			}
			return ItemType.BuddyMessage;
		}
	}

	public int BlockNotificationCount
	{
		get
		{
			if (_blockNotificationCount < 0)
			{
				_blockNotificationCount = 0;
			}
			return _blockNotificationCount;
		}
		set
		{
			_blockNotificationCount = value;
		}
	}

	public int ReceiverCount
	{
		get
		{
			return _receiverCount;
		}
		set
		{
			_receiverCount = value;
		}
	}

	public Message()
	{
		_messageID = Guid.NewGuid();
	}

	private void _thumbImage_ImageOpened(object sender, RoutedEventArgs e)
	{
		_thumbImage.ImageOpened -= _thumbImage_ImageOpened;
		_isThumbnailDownloading = false;
		string text = "thumb_" + MessageService.GetMediaFileNameFromMessage(this);
		int newWidth = 239;
		int newHeight = 239;
		Utility.GetPhotoSizeByRatio(_thumbImage.PixelWidth, _thumbImage.PixelHeight, ref newWidth, ref newHeight);
		Utility.SaveToJpeg(_sessionID + "\\" + text, _thumbImage, newWidth, newHeight);
	}

	private void LoadImageThumbnail()
	{
		string[] array = Utility.Split(_text, '\n');
		SSMServer serverInfo = SSMService.GetServerInfo();
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		string text = array[2] + "?uid=" + userAccount.Uid + "&param=";
		string data = "imei=" + userAccount.IMEI + "&buddyid=" + array[4] + "&filename=" + array[3] + "&size=239";
		data = Utility.HexEncode(Utility.Encrypt(serverInfo.Key, data));
		try
		{
			_thumbImage = new BitmapImage(new Uri(text + data));
			_thumbImage.ImageOpened += _thumbImage_ImageOpened;
		}
		catch (Exception)
		{
		}
	}

	internal void NotifySenderUpdated()
	{
		NotifyPropertyChanged(() => Sender);
	}

	internal int CompareActivityState(Message y)
	{
		if (_state == State.Sent || _state == State.Received || _state == State.GotAnswerBack)
		{
			if (y._state == State.Sent || y._state == State.Received || y._state == State.GotAnswerBack)
			{
				return 0;
			}
			return -1;
		}
		if (y._state == State.Sent || y._state == State.Received || y._state == State.GotAnswerBack)
		{
			return 1;
		}
		return 0;
	}

	internal static int CompareByTime(Message x, Message y)
	{
		int num = x.CompareActivityState(y);
		if (num != 0)
		{
			return num;
		}
		if (x.Time == 0 && y.Time == 0)
		{
			return 0;
		}
		if (x.Time == 0)
		{
			return 1;
		}
		if (y.Time == 0)
		{
			return -1;
		}
		return x.Time.CompareTo(y.Time);
	}
}
