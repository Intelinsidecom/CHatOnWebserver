using ChatOn.Infrastructure;

namespace ChatOn.ViewModels;

public class CountryCode : NotificationObject
{
	private string _name;

	private string _code;

	private string _keyword;

	private string _mcc;

	public string MCC
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

	public string Keyword
	{
		get
		{
			return _keyword;
		}
		set
		{
			_keyword = value;
		}
	}

	public string Code
	{
		get
		{
			return _code;
		}
		set
		{
			_code = value;
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

	public CountryCode()
	{
	}

	public CountryCode(string name, string code)
	{
		_name = name;
		_code = code;
		_keyword = "";
	}
}
