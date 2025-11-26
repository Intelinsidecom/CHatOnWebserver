using ChatOn.Infrastructure;
using Windows.UI.Xaml;

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
			if (_name.Length == 1)
			{
				Background = "#FFFA8719";
			}
			else
			{
				Background = "Transparent";
			}
		}
	}

	public string Background { get; set; }

	public string Foreground
	{
		get
		{
			if (_name.Length == 1)
			{
				return "#FF328195";
			}
			return "#FF000000";
		}
	}

	public Visibility ShowRectangle
	{
		get
		{
			if (_name.Length != 1)
			{
				return (Visibility)1;
			}
			return (Visibility)0;
		}
	}

	public bool isTapEnabled
	{
		get
		{
			if (_name.Length == 1)
			{
				return false;
			}
			return true;
		}
	}

	public CountryCode()
	{
	}

	public CountryCode(string name, string code, string MCC)
	{
		_name = name;
		_code = code;
		_mcc = MCC;
		_keyword = "";
	}

	public override string ToString()
	{
		if (string.IsNullOrEmpty(_code))
		{
			return _name;
		}
		return _name + " " + _code;
	}
}
