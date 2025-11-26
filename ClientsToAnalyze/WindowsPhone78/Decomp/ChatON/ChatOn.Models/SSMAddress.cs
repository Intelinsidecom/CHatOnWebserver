namespace ChatOn.Models;

public class SSMAddress
{
	private string _url = "";

	private string _port = "";

	public string Url
	{
		get
		{
			return _url;
		}
		set
		{
			_url = value;
		}
	}

	public string Port
	{
		get
		{
			return _port;
		}
		set
		{
			_port = value;
		}
	}

	public override string ToString()
	{
		return _url;
	}
}
