using System;
using System.Windows.Media.Imaging;

namespace ChatOn.Models;

public class BuddiesSay
{
	private string _name;

	private string _phoneNumber;

	private string _message;

	private BitmapImage _profileImage;

	private DateTime _date;

	private long _timeStamp;

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

	public string Message
	{
		get
		{
			return _message;
		}
		set
		{
			_message = value;
		}
	}

	public BitmapImage ProfileImage
	{
		get
		{
			return _profileImage;
		}
		set
		{
			_profileImage = value;
		}
	}

	public DateTime Date
	{
		get
		{
			return _date;
		}
		set
		{
			_date = value;
		}
	}

	public long TimeStamp
	{
		get
		{
			return _timeStamp;
		}
		set
		{
			_timeStamp = value;
		}
	}

	public BuddiesSay(string name, string number, string message, BitmapImage img, long timeStamp)
	{
		_name = name;
		_phoneNumber = number;
		_message = message;
		_profileImage = img;
		_timeStamp = timeStamp;
		_date = Utility.GetDateTimeFromMiliseconds(_timeStamp);
	}
}
