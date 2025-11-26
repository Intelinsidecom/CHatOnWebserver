namespace ChatOn.Services;

public class SocketEventArgs
{
	private string _result;

	public string Result
	{
		get
		{
			return _result;
		}
		set
		{
			_result = value;
		}
	}

	public SocketEventArgs(string result)
	{
		_result = result;
	}
}
