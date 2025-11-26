using System;
using System.Data.Linq;
using System.Data.Linq.Mapping;
using System.Windows;
using System.Windows.Media.Imaging;
using ChatOn.Infrastructure;

namespace ChatOn.Models;

[Table]
public class Buddy : NotificationObject
{
	public enum BuddyType
	{
		Normal,
		Unknown
	}

	public enum ProfileImgLoadingStatus
	{
		Ready,
		Loading
	}

	public enum ProfileImgStatus
	{
		Updated = 1,
		Deleted,
		None,
		NoChanges
	}

	[Column(IsVersion = true)]
	private Binary _version;

	private Guid _buddyID;

	private string _name = "";

	private string _phoneNumber = "";

	private string _orgNumber = "";

	private string _status = "";

	private string _birthday = "";

	private string _email;

	private string _samsungEmail;

	private ProfileImgStatus _imgStatus = ProfileImgStatus.None;

	private BuddyType _type;

	private bool _isFavorite;

	private int _sentCount;

	private int _receivedCount;

	private bool _isHideInteraction;

	private int _rank;

	private bool _isShowPhoneNumber;

	private bool _isBlind;

	private bool _isBlocked;

	private string _profileName = "";

	private BitmapImage _profileImage;

	private ProfileImgLoadingStatus _imgLoadingStatus;

	private int _displayRank;

	private string _indexString = "";

	private bool _isChecked;

	private int _bestInteractionPoint;

	private bool _isNew;

	[Column(IsPrimaryKey = true)]
	public Guid BuddyID
	{
		get
		{
			return _buddyID;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => BuddyID);
			}
			_buddyID = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => BuddyID);
			}
		}
	}

	[Column]
	public string Name
	{
		get
		{
			return _name;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Name);
			}
			_name = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Name);
			}
		}
	}

	[Column]
	public string PhoneNumber
	{
		get
		{
			return _phoneNumber;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => PhoneNumber);
			}
			_phoneNumber = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => PhoneNumber);
			}
		}
	}

	[Column]
	public string OrgNumber
	{
		get
		{
			return _orgNumber;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => OrgNumber);
			}
			_orgNumber = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => OrgNumber);
			}
		}
	}

	[Column]
	public string Status
	{
		get
		{
			return _status;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Status);
			}
			_status = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Status);
			}
		}
	}

	[Column]
	public string Birthday
	{
		get
		{
			return _birthday;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Birthday);
			}
			_birthday = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Birthday);
			}
		}
	}

	[Column]
	public string Email
	{
		get
		{
			return _email;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Email);
			}
			_email = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Email);
			}
		}
	}

	[Column]
	public string SamsungEmail
	{
		get
		{
			return _samsungEmail;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => SamsungEmail);
			}
			_samsungEmail = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => SamsungEmail);
			}
		}
	}

	[Column]
	public ProfileImgStatus ImgStatus
	{
		get
		{
			return _imgStatus;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => ImgStatus);
			}
			_imgStatus = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => ImgStatus);
			}
		}
	}

	[Column]
	public BuddyType Type
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
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Type);
			}
		}
	}

	[Column]
	public bool IsFavorite
	{
		get
		{
			return _isFavorite;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => IsFavorite);
			}
			_isFavorite = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => IsFavorite);
			}
		}
	}

	[Column]
	public int SentCount
	{
		get
		{
			return _sentCount;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => SentCount);
			}
			_sentCount = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => SentCount);
			}
		}
	}

	[Column]
	public int ReceivedCount
	{
		get
		{
			return _receivedCount;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => ReceivedCount);
			}
			_receivedCount = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => ReceivedCount);
			}
		}
	}

	[Column]
	public bool IsHideInteraction
	{
		get
		{
			return _isHideInteraction;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => IsHideInteraction);
			}
			_isHideInteraction = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => IsHideInteraction);
			}
		}
	}

	[Column]
	public int Rank
	{
		get
		{
			return _rank;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Rank);
			}
			_rank = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Rank);
			}
		}
	}

	[Column]
	public bool IsShowPhoneNumber
	{
		get
		{
			return _isShowPhoneNumber;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => IsShowPhoneNumber);
			}
			_isShowPhoneNumber = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => IsShowPhoneNumber);
			}
		}
	}

	[Column]
	public bool IsBlind
	{
		get
		{
			return _isBlind;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => IsBlind);
			}
			_isBlind = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => IsBlind);
			}
		}
	}

	[Column]
	public bool IsBlocked
	{
		get
		{
			return _isBlocked;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => IsBlocked);
			}
			_isBlocked = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => IsBlocked);
			}
		}
	}

	[Column]
	public string ProfileName
	{
		get
		{
			return _profileName;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => ProfileName);
			}
			_profileName = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => ProfileName);
			}
		}
	}

	public int InteractionPoint => SentCount + ReceivedCount;

	public int BestInteractionPoint
	{
		get
		{
			return _bestInteractionPoint;
		}
		set
		{
			_bestInteractionPoint = value;
		}
	}

	public BitmapImage ProfileImage
	{
		get
		{
			if (_profileImage == null)
			{
				if (Utility.IsDarkTheme())
				{
					return new BitmapImage(new Uri("/ChatOn;component/Images/buddies_default.png", UriKind.Relative));
				}
				return new BitmapImage(new Uri("\\Images\\LightTheme\\buddies_default image.png", UriKind.Relative));
			}
			return _profileImage;
		}
		set
		{
			_profileImage = value;
			NotifyPropertyChanged(() => ProfileImage);
		}
	}

	public int DisplayRank
	{
		get
		{
			return _displayRank;
		}
		set
		{
			_displayRank = value;
			NotifyPropertyChanged(() => DisplayRank);
		}
	}

	public string IndexString
	{
		get
		{
			return _indexString;
		}
		set
		{
			_indexString = value;
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
			_isChecked = value;
			NotifyPropertyChanged(() => IsChecked);
		}
	}

	public bool IsNew
	{
		get
		{
			return _isNew;
		}
		set
		{
			_isNew = value;
		}
	}

	public Buddy()
	{
		_buddyID = Guid.NewGuid();
	}

	public Buddy(string name, string phoneNumber, string status = "", BuddyType type = BuddyType.Normal)
	{
		_name = name;
		_phoneNumber = phoneNumber;
		_buddyID = Guid.NewGuid();
		_status = status;
		_type = type;
	}

	public override bool Equals(object obj)
	{
		if (!(obj is Buddy))
		{
			return false;
		}
		Buddy buddy = obj as Buddy;
		return buddy._phoneNumber == _phoneNumber;
	}

	public bool LoadProfileImage()
	{
		if (_imgStatus == ProfileImgStatus.None || _imgStatus == ProfileImgStatus.Deleted)
		{
			Utility.DeleteFile("Cache\\" + _phoneNumber + ".jpg");
			ProfileImage = null;
			return true;
		}
		if (_imgStatus == ProfileImgStatus.Updated)
		{
			Utility.DeleteFile("Cache\\" + _phoneNumber + ".jpg");
			ImgStatus = ProfileImgStatus.NoChanges;
			return false;
		}
		BitmapImage bitmapImage = Utility.LoadJpeg("Cache\\thumb_" + _phoneNumber + ".jpg");
		if (bitmapImage != null)
		{
			ProfileImage = bitmapImage;
			return true;
		}
		return false;
	}

	public void LoadProfileImage(Uri uri)
	{
		if (_imgLoadingStatus == ProfileImgLoadingStatus.Ready)
		{
			_imgLoadingStatus = ProfileImgLoadingStatus.Loading;
			ProfileImage = new BitmapImage(uri);
			_profileImage.ImageOpened += _profileImage_ImageOpened;
		}
	}

	private void _profileImage_ImageOpened(object sender, RoutedEventArgs e)
	{
		_profileImage.ImageOpened -= _profileImage_ImageOpened;
		_imgLoadingStatus = ProfileImgLoadingStatus.Ready;
		Utility.SaveToJpeg("Cache\\thumb_" + _phoneNumber + ".jpg", _profileImage, 88, 88);
	}
}
