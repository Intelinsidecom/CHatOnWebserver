namespace ChatOn.Services;

public class BuddyManagerEventArgs
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

	public BuddyManagerEventArgs(string result)
	{
		_result = result;
	}
}
