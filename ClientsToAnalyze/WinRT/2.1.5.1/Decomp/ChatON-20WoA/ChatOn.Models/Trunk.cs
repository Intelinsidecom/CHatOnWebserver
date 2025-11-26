using ChatOn.Infrastructure;

namespace ChatOn.Models;

public class Trunk : NotificationObject
{
	private string _sessionID;

	private string _lastupdttm = "";

	private string _lastcmtdttm = "";

	private int _totitemcnt;

	private int _loadItemCnt;

	private int _unreaditemcnt;

	public string TrunkID
	{
		get
		{
			return _sessionID;
		}
		set
		{
			_sessionID = value;
			NotifyPropertyChanged(() => TrunkID);
		}
	}

	public string LastUpdattm
	{
		get
		{
			return _lastupdttm;
		}
		set
		{
			_lastupdttm = value;
			NotifyPropertyChanged(() => LastUpdattm);
		}
	}

	public string LastCmtdttm
	{
		get
		{
			return _lastcmtdttm;
		}
		set
		{
			_lastcmtdttm = value;
			NotifyPropertyChanged(() => LastCmtdttm);
		}
	}

	public int TotaItemCnt
	{
		get
		{
			return _totitemcnt;
		}
		set
		{
			_totitemcnt = value;
			NotifyPropertyChanged(() => TotaItemCnt);
		}
	}

	public int LoadItemCount
	{
		get
		{
			return _loadItemCnt;
		}
		set
		{
			_loadItemCnt = value;
			NotifyPropertyChanged(() => LoadItemCount);
		}
	}

	public int UnreadItemCnt
	{
		get
		{
			return _unreaditemcnt;
		}
		set
		{
			_unreaditemcnt = value;
			NotifyPropertyChanged(() => UnreadItemCnt);
		}
	}
}
