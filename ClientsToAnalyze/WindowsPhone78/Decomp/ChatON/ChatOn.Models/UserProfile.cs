using System;

namespace ChatOn.Models;

public class UserProfile
{
	private string _name;

	private string _phoneNumber;

	private string _status;

	private string _profileImagePath;

	private DateTime _birthday;

	private int _birthdayDisplayType = 2;

	private int _imageStatus;

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

	public string Status
	{
		get
		{
			return _status;
		}
		set
		{
			_status = value;
		}
	}

	public DateTime Birthday
	{
		get
		{
			return _birthday;
		}
		set
		{
			_birthday = value;
		}
	}

	public string DisplayBirthday
	{
		get
		{
			if (BirthdayDisplayType == 2)
			{
				return "";
			}
			if (BirthdayDisplayType == 1)
			{
				return _birthday.ToString("m");
			}
			return _birthday.ToString("d");
		}
	}

	public int BirthdayDisplayType
	{
		get
		{
			return _birthdayDisplayType;
		}
		set
		{
			_birthdayDisplayType = value;
		}
	}

	public int ImageStatus
	{
		get
		{
			return _imageStatus;
		}
		set
		{
			_imageStatus = value;
		}
	}

	public string ProfileImagePath
	{
		get
		{
			return _profileImagePath;
		}
		set
		{
			_profileImagePath = value;
		}
	}
}
