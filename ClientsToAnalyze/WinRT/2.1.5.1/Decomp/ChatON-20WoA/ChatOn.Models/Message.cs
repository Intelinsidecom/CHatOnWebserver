using System;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using ChatOn.Services;
using com.sec.ssm.common;
using SDatabase;
using Windows.Storage;
using Windows.Storage.FileProperties;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Models;

public class Message : SDBData
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
		Received,
		Downloading
	}

	public enum ItemType
	{
		Date,
		BuddyMessage,
		MyMessage,
		Noti
	}

	private const string MESSAGE_DISPLAY_TIME_FORMAT = "t";

	private Guid _messageID;

	private string _tid = "";

	private long _numberID;

	private string _sender = "";

	private string _receiver = "";

	private string _text = "";

	private long _time;

	private string _sessionID = "";

	private string _type = "";

	private string _address = "";

	private int _port;

	private ChatType _chatType;

	private State _state;

	private Guid _chatID;

	private string _mediaFilePath = "";

	private Chat _chat;

	private int _progressValue;

	private bool _isDownloading;

	private object _tag;

	private bool _showDate;

	private bool _showMoreButton;

	private bool _isThumbnailDownloading;

	private bool _isChecked;

	private bool _isChecked2;

	private bool _showCheckbox;

	private int _blockNotificationCount;

	private int _receiverCount;

	private BitmapImage _thumbImage;

	private BitmapImage _profileImage;

	private static string MEDIA_MESSAGE_TYPE = "media";

	private bool _hasShownPreview;

	public bool HasShownPreview
	{
		get
		{
			return _hasShownPreview;
		}
		set
		{
			_hasShownPreview = value;
			NotifyPropertyChanged(() => HasShownPreview);
		}
	}

	public BitmapImage FlagImage
	{
		get
		{
			if (_chat.ChatType != ChatType.SINGLE)
			{
				return null;
			}
			DataService dataService = new DataService();
			Buddy buddy = dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == _sender);
			if (buddy != null)
			{
				return null;
			}
			return dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == _sender)?.FlagImage;
		}
	}

	public BitmapImage ProfileImage
	{
		get
		{
			DataService dataService = new DataService();
			Buddy buddy = dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == _sender);
			if (buddy != null)
			{
				return buddy.ProfileImage;
			}
			UnknownUser unknownUser = dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == _sender);
			if (unknownUser == null)
			{
				unknownUser = new UnknownUser();
				unknownUser.PhoneNumber = _sender;
				dataService.AddUnknownUser(unknownUser);
			}
			unknownUser.LoadFlagImageCompleted += user_LoadFlagImageCompleted;
			unknownUser.LoadProfileImageCompleted += user_LoadProfileImageCompleted;
			unknownUser.LoadProfileImage();
			return unknownUser.ProfileImage;
		}
		set
		{
			_profileImage = value;
			NotifyPropertyChanged(() => ProfileImage);
		}
	}

	[SDBColumn]
	public Guid MessageID
	{
		get
		{
			return _messageID;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _messageID != value)
			{
				SetDataUpdated();
			}
			_messageID = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => MessageID);
			}
		}
	}

	[SDBColumn]
	public string Tid
	{
		get
		{
			return _tid;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _tid != value)
			{
				SetDataUpdated();
			}
			_tid = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Tid);
			}
		}
	}

	[SDBColumn]
	public long NumberID
	{
		get
		{
			return _numberID;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _numberID != value)
			{
				SetDataUpdated();
			}
			_numberID = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => NumberID);
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
	public string Receiver
	{
		get
		{
			return _receiver;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _receiver != value)
			{
				SetDataUpdated();
			}
			_receiver = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Receiver);
			}
		}
	}

	[SDBColumn(Encrypt = true)]
	public string Text
	{
		get
		{
			return _text;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _text != value)
			{
				SetDataUpdated();
			}
			_text = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Text);
			}
		}
	}

	[SDBColumn]
	public long Time
	{
		get
		{
			return _time;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _time != value)
			{
				SetDataUpdated();
			}
			_time = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Time);
			}
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
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => SessionID);
			}
		}
	}

	[SDBColumn]
	public string Type
	{
		get
		{
			return _type;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _type != value)
			{
				SetDataUpdated();
			}
			_type = value;
			if (!SDBData.SkipPropertyChangedNoti)
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
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Address);
			}
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
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Port);
			}
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
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => ChatType);
			}
		}
	}

	[SDBColumn]
	public State ActivityState
	{
		get
		{
			return _state;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _state != value)
			{
				SetDataUpdated();
			}
			_state = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => ActivityState);
			}
			NotifyPropertyChanged("");
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
	public string MediaFilePath
	{
		get
		{
			return _mediaFilePath;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && MediaFilePath != value)
			{
				SetDataUpdated();
			}
			_mediaFilePath = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => MediaFilePath);
				NotifyPropertyChanged(() => IsReadyToDownload);
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
			foreach (string number in array2)
			{
				if (_chat != null)
				{
					if (num == 1 && number == "")
					{
						return 0;
					}
					AnsInfo ansInfo = _chat.AnsInfo.FirstOrDefault((AnsInfo c) => c.PhoneNumber == number);
					if (ansInfo != null && ansInfo.Time >= _time)
					{
						num--;
					}
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
			NotifyPropertyChanged(() => ProgressValue);
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
			NotifyPropertyChanged(() => IsDownloading);
			NotifyPropertyChanged(() => IsReadyToDownload);
			NotifyPropertyChanged("");
		}
	}

	public bool IsReadyToDownload
	{
		get
		{
			CheckMediaPathFileAsync();
			if (_isDownloading)
			{
				return false;
			}
			if (_state != State.Received)
			{
				return false;
			}
			if (!string.IsNullOrEmpty(_mediaFilePath))
			{
				return false;
			}
			if (_type != MEDIA_MESSAGE_TYPE)
			{
				return false;
			}
			string[] array = Utility.Split(_text, '\n');
			if (array.Length > 0 && (array[0] == "geo" || (array[0] == "mixed" && array[1] == "geo")))
			{
				return false;
			}
			if (array.Length > 0 && array[0] == "mixed" && !_text.Contains("/download/anicon") && (array[1] == "image" || array[1] == "video" || array[1] == "audio"))
			{
				return true;
			}
			if (_text.Contains("/download/anicon"))
			{
				return false;
			}
			return true;
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
			if (value != _showDate)
			{
				_showDate = value;
				NotifyPropertyChanged(() => ShowDate);
			}
		}
	}

	public bool ShowMoreButton
	{
		get
		{
			return _showMoreButton;
		}
		set
		{
			if (value != _showMoreButton)
			{
				_showMoreButton = value;
				NotifyPropertyChanged(() => ShowMoreButton);
			}
		}
	}

	public BitmapImage ThumbImage
	{
		get
		{
			if (_thumbImage != null)
			{
				return _thumbImage;
			}
			if (_isThumbnailDownloading)
			{
				return _thumbImage;
			}
			if (_type != MEDIA_MESSAGE_TYPE)
			{
				return null;
			}
			if (string.IsNullOrEmpty(_text))
			{
				return null;
			}
			string[] array = Utility.Split(_text, '\n');
			if (array[0] == "video")
			{
				LoadVideoThumbnail();
				return _thumbImage;
			}
			if (array[0] == "mixed")
			{
				if (array[1] == "image")
				{
					LoadMixedImageThumbnail();
					return _thumbImage;
				}
				if (array[1] == "video")
				{
					LoadMixedVideoThumbnail();
					return _thumbImage;
				}
			}
			if (array[0] != "image")
			{
				return null;
			}
			LoadImageThumbnail();
			return _thumbImage;
		}
		set
		{
			_thumbImage = value;
			NotifyPropertyChanged(() => ThumbImage);
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
			if (_isChecked != value)
			{
				_isChecked = value;
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
			NotifyPropertyChanged(() => IsChecked2);
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
			if (value != _showCheckbox)
			{
				_showCheckbox = value;
				NotifyPropertyChanged(() => ShowCheckbox);
			}
		}
	}

	public BitmapImage MediaIconUri
	{
		get
		{
			//IL_00ab: Unknown result type (might be due to invalid IL or missing references)
			//IL_00b1: Expected O, but got Unknown
			//IL_00ca: Unknown result type (might be due to invalid IL or missing references)
			//IL_00d0: Expected O, but got Unknown
			//IL_0118: Unknown result type (might be due to invalid IL or missing references)
			//IL_011e: Expected O, but got Unknown
			//IL_00e9: Unknown result type (might be due to invalid IL or missing references)
			//IL_00ef: Expected O, but got Unknown
			//IL_0128: Unknown result type (might be due to invalid IL or missing references)
			//IL_012e: Expected O, but got Unknown
			//IL_0108: Unknown result type (might be due to invalid IL or missing references)
			//IL_010e: Expected O, but got Unknown
			//IL_0138: Unknown result type (might be due to invalid IL or missing references)
			//IL_013e: Expected O, but got Unknown
			//IL_0148: Unknown result type (might be due to invalid IL or missing references)
			//IL_014e: Expected O, but got Unknown
			if (_type != MEDIA_MESSAGE_TYPE)
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
			switch (array[0])
			{
			case "video":
				return new BitmapImage(new Uri("ms-appx:///Images/chat_video.png"));
			case "mixed":
				if (array[1] == "video")
				{
					return new BitmapImage(new Uri("ms-appx:///Images/chat_video.png"));
				}
				if (array[1] == "audio")
				{
					return new BitmapImage(new Uri("ms-appx:///Images/chat_play.png"));
				}
				if (array[1] == "geo")
				{
					return new BitmapImage(new Uri("ms-appx:///Images/chat_map.png"));
				}
				break;
			case "audio":
				return new BitmapImage(new Uri("ms-appx:///Images/chat_play.png"));
			case "contact":
				return new BitmapImage(new Uri("ms-appx:///Images/chat_contact.png"));
			case "calendar":
				return new BitmapImage(new Uri("ms-appx:///Images/chat_calendar.png"));
			case "geo":
				return new BitmapImage(new Uri("ms-appx:///Images/chat_map.png"));
			}
			return null;
		}
	}

	public Visibility TextVisibility
	{
		get
		{
			if (!(_type == "text"))
			{
				return (Visibility)1;
			}
			return (Visibility)0;
		}
	}

	public Visibility PhotoVisibility
	{
		get
		{
			if (!string.IsNullOrEmpty(_text))
			{
				if (!(_type != MEDIA_MESSAGE_TYPE))
				{
					string[] array = Utility.Split(_text, '\n');
					if (array.Length > 0 && array[0] == "image")
					{
						if (!_text.Contains("/download/anicon"))
						{
							return (Visibility)0;
						}
						return (Visibility)1;
					}
					if (array.Length > 0 && array[0] == "mixed")
					{
						if (array[1] == "image")
						{
							if (!_text.Contains("/download/anicon"))
							{
								return (Visibility)0;
							}
							return (Visibility)1;
						}
						if (array[1] == "video")
						{
							return (Visibility)0;
						}
					}
					else if (array.Length > 0 && array[0] == "video")
					{
						return (Visibility)0;
					}
					return (Visibility)1;
				}
				return (Visibility)1;
			}
			return (Visibility)1;
		}
	}

	public bool VideoIconVisibility
	{
		get
		{
			if (string.IsNullOrEmpty(_text))
			{
				return false;
			}
			if (_type != MEDIA_MESSAGE_TYPE)
			{
				return false;
			}
			string[] array = Utility.Split(_text, '\n');
			if (array.Length > 0 && array[0] == "mixed" && array[1] == "video" && !string.IsNullOrEmpty(_mediaFilePath) && !IsDownloading)
			{
				return true;
			}
			if (array.Length > 0 && array[0] == "video" && !string.IsNullOrEmpty(_mediaFilePath) && !IsDownloading)
			{
				return true;
			}
			return false;
		}
	}

	public Visibility MediaIconVisibility
	{
		get
		{
			if (!string.IsNullOrEmpty(_text))
			{
				if (!(_type != MEDIA_MESSAGE_TYPE))
				{
					string[] array = Utility.Split(_text, '\n');
					if (array.Length > 0 && array[0] == "video" && !string.IsNullOrEmpty(_mediaFilePath))
					{
						return (Visibility)1;
					}
					if (array.Length > 0 && array[0] == "mixed")
					{
						if (!(array[1] == "image") && !(array[1] == "geo"))
						{
							return (Visibility)1;
						}
						return (Visibility)0;
					}
					if (array.Length > 0 && array[0] != "image")
					{
						return (Visibility)0;
					}
					return (Visibility)1;
				}
				return (Visibility)1;
			}
			return (Visibility)1;
		}
	}

	public Visibility AniconVisibility
	{
		get
		{
			if (!string.IsNullOrEmpty(_text))
			{
				if (!(_type != MEDIA_MESSAGE_TYPE))
				{
					if (!Text.Contains("/download/anicon"))
					{
						return (Visibility)1;
					}
					return (Visibility)0;
				}
				return (Visibility)1;
			}
			return (Visibility)1;
		}
	}

	public Visibility BubbleImageVisibility
	{
		get
		{
			if (!string.IsNullOrEmpty(_text))
			{
				if (!(_type != MEDIA_MESSAGE_TYPE))
				{
					if (!Text.Contains("/download/anicon"))
					{
						return (Visibility)0;
					}
					return (Visibility)1;
				}
				return (Visibility)0;
			}
			return (Visibility)0;
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
			if (_type != MEDIA_MESSAGE_TYPE)
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

	public string DisplayTime
	{
		get
		{
			if (_time == 0)
			{
				return null;
			}
			DateTime dateTimeFromMiliseconds = Utility.GetDateTimeFromMiliseconds(_time);
			if (!string.IsNullOrEmpty("t"))
			{
				return dateTimeFromMiliseconds.ToString("t");
			}
			return dateTimeFromMiliseconds.ToString();
		}
	}

	public ItemType ItemTypeValue
	{
		get
		{
			if ((_type != "noti" && _state == State.Sent) || _state == State.Typed || _state == State.Uploading || _state == State.UploadingFailed || _state == State.SendingFailed || _state == State.CannotResend)
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

	public string ProfileName { get; set; }

	private void user_LoadProfileImageCompleted(object sender, object e)
	{
		UnknownUser unknownUser = null;
		if (sender is UnknownUser unknownUser2)
		{
			unknownUser2.LoadProfileImageCompleted -= user_LoadProfileImageCompleted;
			ProfileImage = unknownUser2.ProfileImage;
		}
	}

	private void user_LoadFlagImageCompleted(object sender, object e)
	{
		UnknownUser unknownUser = null;
		if (sender is UnknownUser unknownUser2)
		{
			unknownUser2.LoadFlagImageCompleted -= user_LoadFlagImageCompleted;
			NotifyPropertyChanged("FlagImage");
		}
	}

	internal void NotifyIsDownloadingUpdated()
	{
		NotifyPropertyChanged(() => IsDownloading);
		NotifyPropertyChanged(() => IsReadyToDownload);
	}

	public Message()
	{
		_messageID = Guid.NewGuid();
	}

	private unsafe void _thumbImage_ImageOpened(object sender, RoutedEventArgs e)
	{
		//IL_0018: Unknown result type (might be due to invalid IL or missing references)
		//IL_0022: Expected O, but got Unknown
		WindowsRuntimeMarshal.RemoveEventHandler<RoutedEventHandler>(new Action<EventRegistrationToken>(_thumbImage, (nint)__ldftn(BitmapImage.remove_ImageOpened)), new RoutedEventHandler(_thumbImage_ImageOpened));
		_isThumbnailDownloading = false;
		string text = "thumb_" + MessageService.GetMediaFileNameFromMessage(this);
		int newWidth = 239;
		int newHeight = 239;
		Utility.GetPhotoSizeByRatio(((BitmapSource)_thumbImage).PixelWidth, ((BitmapSource)_thumbImage).PixelHeight, ref newWidth, ref newHeight);
		Utility.SaveToJpeg(string.Concat(_chatID, "\\", text), _thumbImage, newWidth, newHeight);
	}

	public async Task LoadVideoThumbnail()
	{
		if (string.IsNullOrEmpty(_mediaFilePath))
		{
			return;
		}
		string thumbFileName = _mediaFilePath.Replace("mp4", "jpg");
		string[] p = Utility.Split(thumbFileName, '\\');
		string folderName = p[0];
		thumbFileName = p[1];
		thumbFileName = "thumb_" + thumbFileName;
		BitmapImage img = await Utility.LoadImage(thumbFileName, folderName);
		if (img != null)
		{
			_thumbImage = img;
			NotifyPropertyChanged(() => ThumbImage);
			NotifyPropertyChanged(() => PhotoVisibility);
			NotifyPropertyChanged(() => VideoIconVisibility);
			NotifyPropertyChanged(() => MediaIconVisibility);
		}
		else
		{
			StorageFile file = await Utility.IsFileExist(_mediaFilePath);
			if (file != null && await Utility.CreateVideoThumbnail2(file, thumbFileName, folderName, (ThumbnailMode)1) != null)
			{
				LoadVideoThumbnail();
			}
		}
	}

	public async Task LoadMixedVideoThumbnail()
	{
		if (!string.IsNullOrEmpty(_mediaFilePath))
		{
			string thumbFileName = _mediaFilePath.Replace("mp4", "jpg");
			string[] p = Utility.Split(thumbFileName, '\\');
			string folderName = p[0];
			thumbFileName = p[1];
			thumbFileName = "thumb_" + thumbFileName;
			BitmapImage img = await Utility.LoadImage(thumbFileName, folderName);
			if (img != null)
			{
				_thumbImage = img;
				NotifyPropertyChanged(() => ThumbImage);
				NotifyPropertyChanged(() => PhotoVisibility);
				NotifyPropertyChanged(() => VideoIconVisibility);
				NotifyPropertyChanged(() => MediaIconVisibility);
			}
			else
			{
				StorageFile file = await Utility.IsFileExist(_mediaFilePath);
				if (file != null && await Utility.CreateVideoThumbnail2(file, thumbFileName, folderName, (ThumbnailMode)1) != null)
				{
					LoadVideoThumbnail();
				}
			}
		}
		else if (!IsDownloading)
		{
			string[] array = Utility.Split(_text, '\n');
			string server = array[2];
			string fileName = array[3];
			string buddyUid = array[4];
			SSMService sSMService = new SSMService();
			sSMService.Tag = this;
			sSMService.DownloadFileCompleted += ssmService_DownloadFileCompleted;
			sSMService.DownloadFileUsingBackground(server, fileName, buddyUid);
			IsDownloading = true;
			Tag = sSMService;
		}
	}

	private void ssmService_DownloadFileCompleted(object sender, SSMCompletedEventArgs e)
	{
		DataService dataService = new DataService();
		string text = Text;
		string[] array = Utility.Split(text, '\n');
		IsDownloading = false;
		if (array[0] == "video" || array[0] == "audio" || array[0] == "image" || array[0] == "contact" || array[0] == "calendar")
		{
			string text2 = array[3];
			string text3 = Chat.ChatID.ToString();
			MediaFilePath = text3 + "\\" + text2;
			if (array[0] == "video")
			{
				LoadVideoThumbnail();
			}
			dataService.MessageDBSubmitChanges();
		}
		else if (array[0] == "mixed" && (array[1] == "image" || array[1] == "video" || array[1] == "audio"))
		{
			string text4 = array[3];
			string text5 = Chat.ChatID.ToString();
			MediaFilePath = text5 + "\\" + text4;
			if (array[1] == "video")
			{
				LoadVideoThumbnail();
			}
			dataService.MessageDBSubmitChanges();
		}
	}

	public async Task LoadImageThumbnail(string path = "")
	{
		if (!string.IsNullOrEmpty(MediaFilePath))
		{
			string[] p = Utility.Split(MediaFilePath, '\\');
			if (await Utility.LoadImage(p[1], p[0]) != null)
			{
				string s = "thumb_" + p[1];
				BitmapImage imgTumb = await Utility.LoadImage(s, p[0]);
				if (imgTumb == null || ((BitmapSource)imgTumb).PixelHeight == 0 || ((BitmapSource)imgTumb).PixelWidth == 0)
				{
					return;
				}
			}
		}
		string[] info = Utility.Split(_text, '\n');
		SSMServer server = SSMService.GetServerInfo();
		UserAccountInfo account = RegistrationService.GetUserAccount();
		string address = info[2] + "?uid=" + account.Uid + "&param=";
		string param = Utility.HexEncode(Utility.Encrypt(data: "imei=" + account.IMEI + "&buddyid=" + info[4] + "&filename=" + info[3] + "&size=239", fullkey: server.Key));
		_isThumbnailDownloading = true;
		Uri uri = null;
		try
		{
			uri = new Uri(address + param);
		}
		catch (Exception)
		{
		}
		try
		{
			ThumbImage = await Utility.LoadOrSaveWebImage("thumb_" + info[3], uri, _chatID.ToString());
		}
		catch (Exception ex2)
		{
			Logger.Log("Failed to Get Thumb Image Message => " + ex2.Message, LogType.Error);
		}
		_isThumbnailDownloading = false;
	}

	public async Task LoadMixedImageThumbnail(string path = "")
	{
		if (!string.IsNullOrEmpty(path))
		{
			string[] p = Utility.Split(path, '\\');
			BitmapImage img = await Utility.LoadImage(p[1], p[0]);
			if (img != null)
			{
				ThumbImage = img;
				return;
			}
		}
		string[] info = Utility.Split(_text, '\n');
		SSMServer server = SSMService.GetServerInfo();
		UserAccountInfo account = RegistrationService.GetUserAccount();
		string address = info[2] + "?uid=" + account.Uid + "&param=";
		string param = Utility.HexEncode(Utility.Encrypt(data: "imei=" + account.IMEI + "&buddyid=" + info[4] + "&filename=" + info[3] + "&size=239", fullkey: server.Key));
		_isThumbnailDownloading = true;
		Uri uri = null;
		try
		{
			uri = new Uri(address + param);
		}
		catch (Exception)
		{
		}
		try
		{
			ThumbImage = await Utility.LoadOrSaveWebImage("thumb_" + info[3], uri, _chatID.ToString());
		}
		catch (Exception)
		{
		}
		_isThumbnailDownloading = false;
	}

	internal void NotifySenderUpdated()
	{
		NotifyPropertyChanged(() => Sender);
	}

	internal void NotifyAnswerBackUpdated()
	{
		NotifyPropertyChanged(() => AnswerBackCount);
	}

	internal void NotifyImageUpdated()
	{
		NotifyPropertyChanged(() => ProfileImage);
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
		if (num != 0 && x.ActivityState != State.Downloading && y.ActivityState != State.Downloading && x.ActivityState != State.Uploading && y.ActivityState != State.Uploading)
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

	internal bool IsNotiMessage()
	{
		return Type == "noti";
	}

	internal bool IncompletedMediaMessage()
	{
		if (Text == "Multimedia")
		{
			return Type == MEDIA_MESSAGE_TYPE;
		}
		return false;
	}

	internal bool IsUnforwardedMessageFormat()
	{
		if (Type == MEDIA_MESSAGE_TYPE)
		{
			if (!Text.Contains("contact"))
			{
				return Text.Contains("calendar");
			}
			return true;
		}
		return false;
	}

	public async Task CheckMediaPathFileAsync()
	{
		await Task.Run(async delegate
		{
			if (!string.IsNullOrEmpty(_mediaFilePath) && await Utility.IsFileExistCheck(name: Utility.Split(_mediaFilePath, '\\')[1], folderPath: _chatID.ToString()) == null)
			{
				IsDownloading = false;
				MediaFilePath = "";
			}
		});
	}
}
