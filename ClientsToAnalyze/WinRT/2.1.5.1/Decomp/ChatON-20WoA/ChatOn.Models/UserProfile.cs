using System;
using System.Collections.Generic;
using ChatOn.Infrastructure;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Models;

public class UserProfile : NotificationObject
{
	private string _name;

	private string _phoneNumber;

	private string _status;

	private DateTime _birthday;

	private int _birthdayDisplayType = 2;

	private bool _showYear;

	private BitmapImage _profileImage;

	private string _profileImagePath;

	private int _imageStatus;

	private List<UserProfileImage> _profileImageHistroy = new List<UserProfileImage>();

	private string _email;

	private string _profileImageId;

	public bool ShowYear
	{
		get
		{
			return _showYear;
		}
		set
		{
			_showYear = value;
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
			NotifyPropertyChanged(() => Name);
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
			NotifyPropertyChanged("");
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
			NotifyPropertyChanged(() => Birthday);
			NotifyPropertyChanged(() => DisplayBirthday);
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
				return _birthday.ToString("MMM d");
			}
			return _birthday.ToString("MMM d, yyyy");
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
			NotifyPropertyChanged(() => DisplayBirthday);
		}
	}

	public BitmapImage ProfileImage
	{
		get
		{
			//IL_001c: Unknown result type (might be due to invalid IL or missing references)
			//IL_0022: Expected O, but got Unknown
			if (_profileImage == null)
			{
				return new BitmapImage(new Uri(new Uri("ms-appx://"), "/Images/chat_info_single.png"));
			}
			return _profileImage;
		}
		set
		{
			_profileImage = value;
			NotifyPropertyChanged(() => ProfileImage);
		}
	}

	public List<UserProfileImage> ProfileImageHistory
	{
		get
		{
			return _profileImageHistroy;
		}
		set
		{
			_profileImageHistroy = value;
			NotifyPropertyChanged(() => ProfileImageHistory);
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

	public string Email
	{
		get
		{
			return _email;
		}
		set
		{
			_email = value;
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

	public string ProfileImageId
	{
		get
		{
			return _profileImageId;
		}
		set
		{
			_profileImageId = value;
		}
	}

	internal void CopyFromDownloaded(UserProfile downloadedProfile)
	{
		Name = downloadedProfile.Name;
		Birthday = downloadedProfile.Birthday;
		Status = downloadedProfile.Status;
		Email = downloadedProfile.Email;
		ImageStatus = downloadedProfile.ImageStatus;
		BirthdayDisplayType = downloadedProfile.BirthdayDisplayType;
		ShowYear = downloadedProfile.ShowYear;
		NotifyPropertyChanged("");
	}
}
