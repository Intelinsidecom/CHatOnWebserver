namespace ChatOn.Services;

public class UserAccountInfo
{
	private string _imei = "";

	private string _imsi = "";

	private string _msisdn = "";

	private string _model = "";

	private string _uid = "";

	private string _name = "";

	private string _version = "";

	private string _countryCode = "";

	private string _phoneNumber = "";

	private string _smsToken = "";

	private string _acsToken = "";

	private string _mcc = "";

	public string Version
	{
		get
		{
			return _version;
		}
		set
		{
			_version = value;
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
		}
	}

	public string IMSI
	{
		get
		{
			return _imsi;
		}
		set
		{
			_imsi = value;
		}
	}

	public string MSISDN
	{
		get
		{
			return _msisdn;
		}
		set
		{
			_msisdn = value;
		}
	}

	public string Model
	{
		get
		{
			return _model;
		}
		set
		{
			_model = value;
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
		}
	}

	public string CountryCode
	{
		get
		{
			return _countryCode;
		}
		set
		{
			_countryCode = value;
		}
	}

	public string PhoneNumber
	{
		get
		{
			return _phoneNumber;
		}
		set
		{
			_phoneNumber = value;
		}
	}

	public string SMSToken
	{
		get
		{
			return _smsToken;
		}
		set
		{
			_smsToken = value;
		}
	}

	public string ACSToken
	{
		get
		{
			return _acsToken;
		}
		set
		{
			_acsToken = value;
		}
	}

	public string Mcc
	{
		get
		{
			return _mcc;
		}
		set
		{
			_mcc = value;
		}
	}
}
