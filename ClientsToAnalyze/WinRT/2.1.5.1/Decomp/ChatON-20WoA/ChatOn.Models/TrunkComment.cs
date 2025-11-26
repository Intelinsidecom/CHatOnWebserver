using System;
using ChatOn.Infrastructure;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Models;

public class TrunkComment : NotificationObject
{
	private string _sessionID;

	private string _cid = "";

	private string _itemId = "";

	private DateTime _regdttm;

	private string _content = "";

	private string _writerId = "";

	private string _orgname = "";

	private string _orgnum = "";

	private string _name = "";

	private string _thumburl = "";

	private BitmapImage _thumbImage;

	private bool _isDownloading;

	public string Cid
	{
		get
		{
			return _cid;
		}
		set
		{
			_cid = value;
			NotifyPropertyChanged(() => Cid);
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

	public string ItemId
	{
		get
		{
			return _itemId;
		}
		set
		{
			_itemId = value;
			NotifyPropertyChanged(() => ItemId);
		}
	}

	public string WriterId
	{
		get
		{
			return _writerId;
		}
		set
		{
			_writerId = value;
			NotifyPropertyChanged(() => WriterId);
		}
	}

	public string Orgnum
	{
		get
		{
			return _orgnum;
		}
		set
		{
			_orgnum = value;
			NotifyPropertyChanged(() => Orgnum);
		}
	}

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

	public DateTime Regdttm
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
			if (_thumbImage != null)
			{
				return _thumbImage;
			}
			return Buddy.DEFAULT_BUDDY_PROFILE_IMAGE;
		}
		set
		{
			_thumbImage = value;
			NotifyPropertyChanged(() => ThumbImage);
		}
	}

	private void user_LoadProfileImageCompleted(object sender, object e)
	{
		UnknownUser unknownUser = null;
		if (sender is UnknownUser unknownUser2)
		{
			unknownUser2.LoadProfileImageCompleted -= user_LoadProfileImageCompleted;
			ThumbImage = unknownUser2.ProfileImage;
		}
	}
}
