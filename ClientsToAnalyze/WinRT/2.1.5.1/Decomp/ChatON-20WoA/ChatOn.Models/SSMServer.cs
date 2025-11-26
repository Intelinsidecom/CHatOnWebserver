using System;

namespace ChatOn.Models;

public class SSMServer
{
	private SSMAddress _gldServer = new SSMAddress();

	private SSMAddress _msgServer = new SSMAddress();

	private SSMAddress _contactServer = new SSMAddress();

	private SSMAddress _fileServer = new SSMAddress();

	private SSMAddress _smsServer = new SSMAddress();

	private string _key = "";

	private string _newVersion = "";

	private string _downloadURL = "";

	private bool _isTermsUpdated;

	private bool _isUpToDate = true;

	private bool _isCritical;

	private long _utcTime;

	private int _utcTimeUpdatedTick;

	private string _disclaimerUID = string.Empty;

	public int UtcTimeUpdatedTick
	{
		get
		{
			return _utcTimeUpdatedTick;
		}
		set
		{
			_utcTimeUpdatedTick = value;
		}
	}

	public long UtcTime
	{
		get
		{
			return _utcTime;
		}
		set
		{
			_utcTime = value;
		}
	}

	public string NewVersion
	{
		get
		{
			return _newVersion;
		}
		set
		{
			_newVersion = value;
		}
	}

	public bool IsUpToDate
	{
		get
		{
			return _isUpToDate;
		}
		set
		{
			_isUpToDate = value;
		}
	}

	public string DownloadURL
	{
		get
		{
			return _downloadURL;
		}
		set
		{
			_downloadURL = value;
		}
	}

	public bool IsCritical
	{
		get
		{
			return _isCritical;
		}
		set
		{
			_isCritical = value;
		}
	}

	public bool IsTermsUpdated
	{
		get
		{
			return _isTermsUpdated;
		}
		set
		{
			_isTermsUpdated = value;
		}
	}

	public SSMAddress GldServer
	{
		get
		{
			return _gldServer;
		}
		set
		{
			_gldServer = value;
		}
	}

	public SSMAddress MsgServer
	{
		get
		{
			return _msgServer;
		}
		set
		{
			_msgServer = value;
		}
	}

	public SSMAddress ContactServer
	{
		get
		{
			return _contactServer;
		}
		set
		{
			_contactServer = value;
		}
	}

	public SSMAddress FileServer
	{
		get
		{
			return _fileServer;
		}
		set
		{
			_fileServer = value;
		}
	}

	public SSMAddress SMSServer
	{
		get
		{
			return _smsServer;
		}
		set
		{
			_smsServer = value;
		}
	}

	public string Key
	{
		get
		{
			return _key;
		}
		set
		{
			_key = value;
		}
	}

	public string DisclaimerUID
	{
		get
		{
			return _disclaimerUID;
		}
		set
		{
			_disclaimerUID = value;
		}
	}

	public long GetEstimatedServerTime()
	{
		if (_utcTime == 0)
		{
			return 0L;
		}
		return _utcTime + Environment.TickCount - _utcTimeUpdatedTick;
	}
}
