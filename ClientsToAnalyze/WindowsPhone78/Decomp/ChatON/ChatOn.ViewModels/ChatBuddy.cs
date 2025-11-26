using ChatOn.Models;

namespace ChatOn.ViewModels;

public class ChatBuddy
{
	private string _name;

	private string _phoneNumber;

	private Buddy _buddy;

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

	public Buddy Buddy
	{
		get
		{
			return _buddy;
		}
		set
		{
			_buddy = value;
		}
	}
}
