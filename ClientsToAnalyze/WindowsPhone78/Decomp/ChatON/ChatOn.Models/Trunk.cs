using System.Data.Linq;
using System.Data.Linq.Mapping;
using ChatOn.Infrastructure;

namespace ChatOn.Models;

[Table]
public class Trunk : NotificationObject
{
	[Column(IsVersion = true)]
	private Binary _version;

	private string _sessionID;

	private string _lastupdttm = "";

	private string _lastcmtdttm = "";

	private int _totitemcnt;

	private int _loadItemCnt;

	private int _unreaditemcnt;

	[Column]
	public string TrunkID
	{
		get
		{
			return _sessionID;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => TrunkID);
			}
			_sessionID = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => TrunkID);
			}
		}
	}

	[Column]
	public string LastUpdattm
	{
		get
		{
			return _lastupdttm;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => LastUpdattm);
			}
			_lastupdttm = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => LastUpdattm);
			}
		}
	}

	[Column]
	public string LastCmtdttm
	{
		get
		{
			return _lastcmtdttm;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => LastCmtdttm);
			}
			_lastcmtdttm = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => LastCmtdttm);
			}
		}
	}

	[Column]
	public int TotaItemCnt
	{
		get
		{
			return _totitemcnt;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => TotaItemCnt);
			}
			_totitemcnt = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => TotaItemCnt);
			}
		}
	}

	[Column]
	public int LoadItemCount
	{
		get
		{
			return _loadItemCnt;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => LoadItemCount);
			}
			_loadItemCnt = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => LoadItemCount);
			}
		}
	}

	[Column]
	public int UnreadItemCnt
	{
		get
		{
			return _unreaditemcnt;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => UnreadItemCnt);
			}
			_unreaditemcnt = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => UnreadItemCnt);
			}
		}
	}
}
