using System;
using ChatOn.Infrastructure;

namespace ChatON_WoA.DataModel;

public class AniconPackage : NotificationObject
{
	private string _id;

	private string _name;

	private string _thumbImageUri;

	private int _count;

	private long _size;

	private long _startDate;

	private long _endDate;

	private bool _isNeedDownload = true;

	private bool _isDownloading;

	private double _downloadPercent;

	private int _downloadRank;

	private bool _isEnableButtonCancel = true;

	private bool _isCancelDonwloadPackage;

	private bool _isEnableButtonUninstall = true;

	public string Character { get; set; }

	public bool IsEnableButtonCancel
	{
		get
		{
			return _isEnableButtonCancel;
		}
		set
		{
			_isEnableButtonCancel = value;
			NotifyPropertyChanged(() => IsEnableButtonCancel);
		}
	}

	public bool isCancelDownloadPackage
	{
		get
		{
			return _isCancelDonwloadPackage;
		}
		set
		{
			_isCancelDonwloadPackage = value;
			NotifyPropertyChanged(() => isCancelDownloadPackage);
		}
	}

	public bool IsEnableButtonUninstall
	{
		get
		{
			return _isEnableButtonUninstall;
		}
		set
		{
			_isEnableButtonUninstall = value;
			NotifyPropertyChanged(() => IsEnableButtonUninstall);
		}
	}

	public int DownloadRank
	{
		get
		{
			return _downloadRank;
		}
		set
		{
			_downloadRank = value;
		}
	}

	public double DownloadPercent
	{
		get
		{
			return _downloadPercent;
		}
		set
		{
			_downloadPercent = value;
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

	public bool IsNeedDownload
	{
		get
		{
			return _isNeedDownload;
		}
		set
		{
			_isNeedDownload = value;
			NotifyPropertyChanged(() => IsNeedDownload);
		}
	}

	public int Count
	{
		get
		{
			return _count;
		}
		set
		{
			_count = value;
		}
	}

	public long Size
	{
		get
		{
			return _size;
		}
		set
		{
			_size = value;
		}
	}

	public long StartDate
	{
		get
		{
			return _startDate;
		}
		set
		{
			_startDate = value;
		}
	}

	public DateTime StartDateTime => Utility.GetDateTimeFromMiliseconds(_startDate);

	public long EndDate
	{
		get
		{
			return _endDate;
		}
		set
		{
			_endDate = value;
		}
	}

	public string ID
	{
		get
		{
			return _id;
		}
		set
		{
			_id = value;
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

	public string ThumbImageUri
	{
		get
		{
			return _thumbImageUri;
		}
		set
		{
			_thumbImageUri = value;
			NotifyPropertyChanged(() => ThumbImageUri);
		}
	}

	public string GetSubInfoString => Utility.GetResourceString("IDS_CHATON_BODY_TOTAL_P1SD_HP2SD_KB_ABB").Replace("%1$d", _count.ToString()).Replace("%2$d", (_size / 1024).ToString());

	public void NotifyProgressChanged()
	{
		NotifyPropertyChanged(() => DownloadPercent);
	}
}
