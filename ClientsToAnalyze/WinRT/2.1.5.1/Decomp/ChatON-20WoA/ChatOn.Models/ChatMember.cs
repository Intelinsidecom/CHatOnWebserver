namespace ChatOn.Models;

public class ChatMember
{
	private long _time;

	private string _phoneNumber;

	public long Time
	{
		get
		{
			return _time;
		}
		set
		{
			_time = value;
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
}
