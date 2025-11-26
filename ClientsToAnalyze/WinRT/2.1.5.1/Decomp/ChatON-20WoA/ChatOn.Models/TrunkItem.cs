using ChatOn.Infrastructure;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Models;

public class TrunkItem : NotificationObject
{
	public enum ItemType
	{
		None,
		Image,
		Video,
		LoadBtn
	}

	private ItemType _itemType;

	private string _uid = "";

	private string _imei = "";

	private string _sessionID = "";

	private string _itemId = "";

	private string _regdttm = "";

	private string _lastcmtdttm = "";

	private string _totcmtcnt = "";

	private int _unreadcmtcnt;

	private string _senderid = "";

	private string _orgnumber = "";

	private string _name = "";

	private string _thumburl = "";

	private string _trunkDownUri = "";

	private BitmapImage _thunbImg;

	private string _cachedFileName;

	private Visibility _videoVisiable = (Visibility)1;

	private Visibility _bubbleVisiable;

	private Visibility _unreadVisible = (Visibility)1;

	private bool _isDownloading = true;

	public Visibility BubbleVisiable
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _bubbleVisiable;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_bubbleVisiable = value;
			NotifyPropertyChanged(() => BubbleVisiable);
		}
	}

	public ItemType iType
	{
		get
		{
			return _itemType;
		}
		set
		{
			_itemType = value;
			NotifyPropertyChanged(() => iType);
		}
	}

	public string Uid
	{
		get
		{
			return _uid;
		}
		set
		{
			_uid = value;
			NotifyPropertyChanged(() => Uid);
		}
	}

	public string IMEI
	{
		get
		{
			return _imei;
		}
		set
		{
			_imei = value;
			NotifyPropertyChanged(() => IMEI);
		}
	}

	public string TrunkItemID
	{
		get
		{
			return _itemId;
		}
		set
		{
			_itemId = value;
			NotifyPropertyChanged(() => TrunkItemID);
		}
	}

	public string Regdttm
	{
		get
		{
			return _regdttm;
		}
		set
		{
			_regdttm = value;
			NotifyPropertyChanged(() => Regdttm);
		}
	}

	public string SessionID
	{
		get
		{
			return _sessionID;
		}
		set
		{
			_sessionID = value;
			NotifyPropertyChanged(() => SessionID);
		}
	}

	public string Lastcmtdttm
	{
		get
		{
			return _lastcmtdttm;
		}
		set
		{
			_lastcmtdttm = value;
			NotifyPropertyChanged(() => Lastcmtdttm);
		}
	}

	public string Senderid
	{
		get
		{
			return _senderid;
		}
		set
		{
			_senderid = value;
			NotifyPropertyChanged(() => Senderid);
		}
	}

	public string Orgnumber
	{
		get
		{
			return _orgnumber;
		}
		set
		{
			_orgnumber = value;
			NotifyPropertyChanged(() => Orgnumber);
		}
	}

	public string Name
	{
		get
		{
			return _name;
		}
		set
		{
			_name = value;
			NotifyPropertyChanged(() => Name);
		}
	}

	public string Totcmtcnt
	{
		get
		{
			return _totcmtcnt;
		}
		set
		{
			//IL_001b: Unknown result type (might be due to invalid IL or missing references)
			_totcmtcnt = value;
			if (_totcmtcnt == "0")
			{
				_bubbleVisiable = (Visibility)1;
			}
			NotifyPropertyChanged(() => Totcmtcnt);
		}
	}

	public string TrunkThumbUri
	{
		get
		{
			if (_thumburl.Contains("http://https://"))
			{
				return _thumburl.Replace("https://", "");
			}
			return _thumburl;
		}
		set
		{
			_thumburl = value;
			NotifyPropertyChanged(() => TrunkThumbUri);
		}
	}

	public int Unreadcmtcnt
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

	public string TrunkDownUri
	{
		get
		{
			if (_trunkDownUri.Contains("http://https://"))
			{
				return _trunkDownUri.Replace("https://", "");
			}
			return _trunkDownUri;
		}
		set
		{
			_trunkDownUri = value;
			NotifyPropertyChanged(() => TrunkDownUri);
		}
	}

	public Visibility Video_Visible
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _videoVisiable;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_videoVisiable = value;
			NotifyPropertyChanged(() => Video_Visible);
		}
	}

	public Visibility Unread_Visible
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _unreadVisible;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_unreadVisible = value;
			NotifyPropertyChanged(() => Unread_Visible);
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
		}
	}

	public string CachedFileName
	{
		get
		{
			return _cachedFileName;
		}
		set
		{
			_cachedFileName = value;
		}
	}
}
