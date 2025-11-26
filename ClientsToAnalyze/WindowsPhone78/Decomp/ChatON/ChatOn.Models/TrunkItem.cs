using System.Data.Linq;
using System.Data.Linq.Mapping;
using System.Windows;
using System.Windows.Media.Imaging;
using ChatOn.Infrastructure;

namespace ChatOn.Models;

[Table]
public class TrunkItem : NotificationObject
{
	public enum ItemType
	{
		None,
		Image,
		Video,
		LoadBtn
	}

	[Column(IsVersion = true)]
	private Binary _version;

	private ItemType _itemType;

	private string _uid = "";

	private string _imei = "";

	private string _sessionID = "";

	private string _itemId = "";

	private string _regdttm = "";

	private string _lastcmtdttm = "";

	private string _totcmtcnt = "";

	private string _unreadcmtcnt = "";

	private string _senderid = "";

	private string _orgnumber = "";

	private string _name = "";

	private string _thumburl = "";

	private string _trunkDonwUri = "";

	private BitmapImage _thunbImg;

	private Visibility _videoVisiable = Visibility.Collapsed;

	private Visibility _bubbleVisiable;

	private Visibility _unreadVisible = Visibility.Collapsed;

	[Column]
	public ItemType iType
	{
		get
		{
			return _itemType;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => iType);
			}
			_itemType = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => iType);
			}
		}
	}

	[Column]
	public string Uid
	{
		get
		{
			return _uid;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Uid);
			}
			_uid = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Uid);
			}
		}
	}

	[Column]
	public string IMEI
	{
		get
		{
			return _imei;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => IMEI);
			}
			_imei = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => IMEI);
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
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => SessionID);
			}
		}
	}

	[Column(IsPrimaryKey = true)]
	public string TrunkItemID
	{
		get
		{
			return _itemId;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => TrunkItemID);
			}
			_itemId = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => TrunkItemID);
			}
		}
	}

	[Column]
	public string Regdttm
	{
		get
		{
			return _regdttm;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Regdttm);
			}
			_regdttm = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Regdttm);
			}
		}
	}

	[Column]
	public string Lastcmtdttm
	{
		get
		{
			return _lastcmtdttm;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Lastcmtdttm);
			}
			_lastcmtdttm = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Lastcmtdttm);
			}
		}
	}

	[Column]
	public string Senderid
	{
		get
		{
			return _senderid;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Senderid);
			}
			_senderid = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Senderid);
			}
		}
	}

	[Column]
	public string Orgnumber
	{
		get
		{
			return _orgnumber;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Orgnumber);
			}
			_orgnumber = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Orgnumber);
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
	public string Totcmtcnt
	{
		get
		{
			return _totcmtcnt;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Totcmtcnt);
			}
			_totcmtcnt = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Totcmtcnt);
			}
		}
	}

	[Column]
	public string TrunkThumbUri
	{
		get
		{
			return _thumburl;
		}
		set
		{
			_thumburl = value;
			NotifyPropertyChanged(() => TrunkThumbUri);
		}
	}

	[Column]
	public string Unreadcmtcnt
	{
		get
		{
			return _unreadcmtcnt;
		}
		set
		{
			_unreadcmtcnt = value;
			NotifyPropertyChanged(() => Unreadcmtcnt);
		}
	}

	public BitmapImage TrunkThumbImg
	{
		get
		{
			return _thunbImg;
		}
		set
		{
			_thunbImg = value;
			NotifyPropertyChanged(() => TrunkThumbImg);
		}
	}

	public string TrunkDonwUri
	{
		get
		{
			return _trunkDonwUri;
		}
		set
		{
			_trunkDonwUri = value;
			NotifyPropertyChanged(() => TrunkDonwUri);
		}
	}

	public Visibility Video_Visible
	{
		get
		{
			return _videoVisiable;
		}
		set
		{
			_videoVisiable = value;
			NotifyPropertyChanged(() => Video_Visible);
		}
	}

	public Visibility Bubble_Visible
	{
		get
		{
			return _bubbleVisiable;
		}
		set
		{
			_bubbleVisiable = value;
			NotifyPropertyChanged(() => Bubble_Visible);
		}
	}

	public Visibility Unread_Visible
	{
		get
		{
			return _unreadVisible;
		}
		set
		{
			_unreadVisible = value;
			NotifyPropertyChanged(() => Unread_Visible);
		}
	}
}
