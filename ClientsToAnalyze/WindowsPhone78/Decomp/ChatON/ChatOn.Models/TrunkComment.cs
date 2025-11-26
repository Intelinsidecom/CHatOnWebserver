using System.Data.Linq;
using System.Data.Linq.Mapping;
using System.Windows.Media.Imaging;
using ChatOn.Infrastructure;

namespace ChatOn.Models;

[Table]
public class TrunkComment : NotificationObject
{
	[Column(IsVersion = true)]
	private Binary _version;

	private string _sessionID;

	private string _cid = "";

	private string _itemId = "";

	private string _regdttm = "";

	private string _content = "";

	private string _writerId = "";

	private string _orgname = "";

	private string _orgnum = "";

	private string _name = "";

	private string _thumburl = "";

	private BitmapImage _thumbImage;

	private bool _isDownloading;

	[Column(IsPrimaryKey = true)]
	public string Cid
	{
		get
		{
			return _cid;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Cid);
			}
			_cid = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Cid);
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

	[Column]
	public string ItemId
	{
		get
		{
			return _itemId;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => ItemId);
			}
			_itemId = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => ItemId);
			}
		}
	}

	[Column]
	public string WriterId
	{
		get
		{
			return _writerId;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => WriterId);
			}
			_writerId = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => WriterId);
			}
		}
	}

	[Column]
	public string Orgnum
	{
		get
		{
			return _orgnum;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Orgnum);
			}
			_orgnum = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Orgnum);
			}
		}
	}

	[Column]
	public string TrunkImgUri
	{
		get
		{
			return _thumburl;
		}
		set
		{
			_thumburl = value;
			NotifyPropertyChanged(() => TrunkImgUri);
		}
	}

	[Column]
	public string Content
	{
		get
		{
			return _content;
		}
		set
		{
			_content = value;
			NotifyPropertyChanged(() => Content);
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
			_regdttm = value;
			NotifyPropertyChanged(() => Regdttm);
		}
	}

	[Column]
	public string Orgname
	{
		get
		{
			return _orgname;
		}
		set
		{
			_orgname = value;
			NotifyPropertyChanged(() => Orgname);
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
			_name = value;
			NotifyPropertyChanged(() => Name);
		}
	}

	public BitmapImage ThumbImage
	{
		get
		{
			return _thumbImage;
		}
		set
		{
			_thumbImage = value;
			NotifyPropertyChanged(() => ThumbImage);
		}
	}
}
