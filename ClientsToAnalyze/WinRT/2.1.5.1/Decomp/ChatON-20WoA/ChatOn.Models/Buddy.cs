using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using SDatabase;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Models;

public class Buddy : SDBData
{
	public enum BuddyType
	{
		Normal,
		Unknown
	}

	public enum ProfileImgStatus
	{
		Updated = 1,
		Deleted,
		None,
		NoChanges
	}

	private Guid _buddyID;

	private string _name = "";

	private string _phoneNumber = "";

	private string _sainfo = "";

	private string _orgNumber = "";

	private string _status = "";

	private string _birthday = "";

	private string _email;

	private string _samsungEmail;

	private ProfileImgStatus _imgStatus = ProfileImgStatus.None;

	private BuddyType _type;

	private bool _isFavorite;

	private bool _isSpecialBuddies;

	private int _sentCount;

	private int _receivedCount;

	private bool _isHideInteraction;

	private int _rank;

	private bool _isShowPhoneNumber;

	private bool _isBlind;

	private bool _isBlindText;

	private bool _isBlocked;

	private string _profileName = "";

	private string _MSISDNS;

	private BitmapImage _thumbprofileImage;

	private BitmapImage _profileImage;

	private int _displayRank;

	private string _indexString = "";

	private bool _isChecked;

	private int _bestInteractionPoint;

	private bool _isNew;

	private Brush _statusForeground = (Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 33, 146, 151));

	private Brush _background = (Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, byte.MaxValue, 250, 135));

	private bool? _isDownloading = true;

	private bool _isInteractionDeleteMode;

	private List<string> _phoneNumberList = new List<string>();

	public static readonly BitmapImage DEFAULT_BUDDY_PROFILE_IMAGE = new BitmapImage(new Uri("ms-appx:///Images/chat_info_single.png"));

	[SDBColumn]
	public Guid BuddyID
	{
		get
		{
			return _buddyID;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _buddyID != value)
			{
				SetDataUpdated();
			}
			_buddyID = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => BuddyID);
			}
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
			}
		}
	}

	[SDBColumn(Encrypt = true)]
	public string PhoneNumber
	{
		get
		{
			return _phoneNumber;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _phoneNumber != value)
			{
				SetDataUpdated();
			}
			_phoneNumber = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => PhoneNumber);
			}
		}
	}

	[SDBColumn]
	public string Sainfo
	{
		get
		{
			return _sainfo;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _sainfo != value)
			{
				SetDataUpdated();
			}
			_sainfo = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Sainfo);
			}
		}
	}

	[SDBColumn(Encrypt = true)]
	public string OrgNumber
	{
		get
		{
			return _orgNumber;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _orgNumber != value)
			{
				SetDataUpdated();
			}
			_orgNumber = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => OrgNumber);
			}
		}
	}

	[SDBColumn]
	public string Status
	{
		get
		{
			return _status;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _status != value)
			{
				SetDataUpdated();
			}
			_status = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Status);
			}
		}
	}

	[SDBColumn]
	public string Birthday
	{
		get
		{
			return _birthday;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _birthday != value)
			{
				SetDataUpdated();
			}
			_birthday = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Birthday);
			}
		}
	}

	[SDBColumn]
	public string Email
	{
		get
		{
			return _email;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _email != value)
			{
				SetDataUpdated();
			}
			_email = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Email);
			}
		}
	}

	[SDBColumn]
	public string SamsungEmail
	{
		get
		{
			return _samsungEmail;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _samsungEmail != value)
			{
				SetDataUpdated();
			}
			_samsungEmail = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => SamsungEmail);
			}
		}
	}

	[SDBColumn]
	public ProfileImgStatus ImgStatus
	{
		get
		{
			return _imgStatus;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _imgStatus != value)
			{
				SetDataUpdated();
			}
			_imgStatus = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => ImgStatus);
			}
		}
	}

	[SDBColumn]
	public BuddyType Type
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
			}
		}
	}

	[SDBColumn]
	public bool IsFavorite
	{
		get
		{
			return _isFavorite;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _isFavorite != value)
			{
				SetDataUpdated();
			}
			_isFavorite = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => IsFavorite);
			}
		}
	}

	[SDBColumn]
	public int SentCount
	{
		get
		{
			return _sentCount;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _sentCount != value)
			{
				SetDataUpdated();
			}
			_sentCount = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => SentCount);
			}
		}
	}

	[SDBColumn]
	public int ReceivedCount
	{
		get
		{
			return _receivedCount;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _receivedCount != value)
			{
				SetDataUpdated();
			}
			_receivedCount = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => ReceivedCount);
			}
		}
	}

	[SDBColumn]
	public bool IsHideInteraction
	{
		get
		{
			return _isHideInteraction;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _isHideInteraction != value)
			{
				SetDataUpdated();
			}
			_isHideInteraction = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => IsHideInteraction);
			}
		}
	}

	[SDBColumn]
	public int Rank
	{
		get
		{
			return _rank;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _rank != value)
			{
				SetDataUpdated();
			}
			_rank = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => Rank);
			}
		}
	}

	[SDBColumn]
	public bool IsShowPhoneNumber
	{
		get
		{
			return _isShowPhoneNumber;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _isShowPhoneNumber != value)
			{
				SetDataUpdated();
			}
			_isShowPhoneNumber = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => IsShowPhoneNumber);
			}
			NotifyPropertyChanged(() => PhoneNumberList);
		}
	}

	[SDBColumn]
	public bool IsBlind
	{
		get
		{
			return _isBlind;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _isBlind != value)
			{
				SetDataUpdated();
			}
			_isBlind = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => IsBlind);
			}
		}
	}

	public bool IsBlindText
	{
		get
		{
			return _isBlindText;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _isBlindText != value)
			{
				SetDataUpdated();
			}
			_isBlindText = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => IsBlindText);
			}
		}
	}

	[SDBColumn]
	public bool IsBlocked
	{
		get
		{
			return _isBlocked;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _isBlocked != value)
			{
				SetDataUpdated();
			}
			_isBlocked = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => IsBlocked);
			}
		}
	}

	[SDBColumn]
	public string ProfileName
	{
		get
		{
			return _profileName;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _profileName != value)
			{
				SetDataUpdated();
			}
			_profileName = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => ProfileName);
			}
		}
	}

	[SDBColumn]
	public string MSISDNS
	{
		get
		{
			return _MSISDNS;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _MSISDNS != value)
			{
				SetDataUpdated();
			}
			_MSISDNS = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => MSISDNS);
			}
		}
	}

	public bool HasMultipleNumbers
	{
		get
		{
			if (!IsShowPhoneNumber)
			{
				return false;
			}
			if (string.IsNullOrEmpty(_MSISDNS))
			{
				return false;
			}
			string[] array = Utility.Split(_MSISDNS, '|');
			if (array.Length > 1)
			{
				return true;
			}
			return false;
		}
	}

	[SDBColumn]
	public bool IsSpecialBuddy
	{
		get
		{
			return _isSpecialBuddies;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _isSpecialBuddies != value)
			{
				SetDataUpdated();
			}
			_isSpecialBuddies = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => IsSpecialBuddy);
			}
		}
	}

	public Visibility OrgPhoneNumberVisible
	{
		get
		{
			if (!HasMultipleNumbers)
			{
				if (IsShowPhoneNumber)
				{
					if (!string.IsNullOrEmpty(OrgNumber))
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

	public List<string> PhoneNumberList
	{
		get
		{
			if (!HasMultipleNumbers)
			{
				return _phoneNumberList;
			}
			string[] p = Utility.Split(_MSISDNS, '|');
			if (p.Length - 1 != _phoneNumberList.Count)
			{
				int i;
				for (i = 0; i < p.Length; i++)
				{
					if (p[i].Length < 15)
					{
						string value = _phoneNumberList.Find((string x) => x.Contains(p[i]));
						if (string.IsNullOrEmpty(value) || p[i].Length > 15)
						{
							_phoneNumberList.Add("+" + p[i]);
						}
					}
				}
			}
			return _phoneNumberList;
		}
		set
		{
			_phoneNumberList = value;
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

	public BitmapImage ThumbProfileImage
	{
		get
		{
			if (_thumbprofileImage == null)
			{
				return DEFAULT_BUDDY_PROFILE_IMAGE;
			}
			return _thumbprofileImage;
		}
		set
		{
			_thumbprofileImage = value;
			NotifyPropertyChanged(() => ThumbProfileImage);
		}
	}

	public BitmapImage ProfileImage
	{
		get
		{
			if (_profileImage == null)
			{
				return DEFAULT_BUDDY_PROFILE_IMAGE;
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
			NotifyPropertyChanged(() => IsNew);
		}
	}

	public Brush StatusForeground
	{
		get
		{
			return _statusForeground;
		}
		set
		{
			_statusForeground = value;
			NotifyPropertyChanged(() => StatusForeground);
		}
	}

	public Brush Background
	{
		get
		{
			//IL_000d: Unknown result type (might be due to invalid IL or missing references)
			//IL_0013: Expected O, but got Unknown
			if (!IsNew)
			{
				return (Brush)new SolidColorBrush(Colors.Transparent);
			}
			return _background;
		}
		set
		{
			_background = value;
			NotifyPropertyChanged(() => Background);
		}
	}

	public bool IsDownloading
	{
		get
		{
			return _isDownloading.Value;
		}
		set
		{
			_isDownloading = value;
			NotifyPropertyChanged(() => IsDownloading);
		}
	}

	public bool IsInteractionDeleteMode
	{
		get
		{
			return _isInteractionDeleteMode;
		}
		set
		{
			_isInteractionDeleteMode = value;
			NotifyPropertyChanged(() => IsInteractionDeleteMode);
		}
	}

	public Buddy()
	{
		//IL_0076: Unknown result type (might be due to invalid IL or missing references)
		//IL_0080: Expected O, but got Unknown
		//IL_009a: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a4: Expected O, but got Unknown
		_buddyID = Guid.NewGuid();
	}

	public Buddy(string name, string phoneNumber, string status = "", BuddyType type = BuddyType.Normal)
	{
		//IL_0076: Unknown result type (might be due to invalid IL or missing references)
		//IL_0080: Expected O, but got Unknown
		//IL_009a: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a4: Expected O, but got Unknown
		_name = name;
		_phoneNumber = phoneNumber;
		_buddyID = Guid.NewGuid();
		_status = status;
		_type = type;
		IsDownloading = true;
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

	public async Task LoadProfileImage(Uri uri)
	{
		if (_imgStatus == ProfileImgStatus.None)
		{
			ProfileImage = null;
			ThumbProfileImage = null;
			IsDownloading = false;
			return;
		}
		if (_imgStatus == ProfileImgStatus.Deleted)
		{
			await Utility.DeleteFile(string.Concat(_buddyID, ".jpg"), "Cache");
			await Utility.DeleteFile(string.Concat("thumb_", _buddyID, ".jpg"), "Cache");
			IsDownloading = false;
			ProfileImage = null;
			ThumbProfileImage = null;
			return;
		}
		if (_imgStatus == ProfileImgStatus.Updated)
		{
			await Utility.DeleteFile(string.Concat(_buddyID, ".jpg"), "Cache");
			await Utility.DeleteFile(string.Concat("thumb_", _buddyID, ".jpg"), "Cache");
			ImgStatus = ProfileImgStatus.NoChanges;
		}
		IsDownloading = true;
		ThumbProfileImage = await Utility.LoadOrSaveWebImage(string.Concat("thumb_", _buddyID, ".jpg"), uri, "Cache");
		ProfileImage = await Utility.LoadOrSaveWebImage(string.Concat(_buddyID, ".jpg"), uri, "Cache");
		IsDownloading = false;
	}
}
