using System;
using System.Linq;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Models;

public class BuddiesSay : NotificationObject
{
	private string _name;

	private string _phoneNumber;

	private string _message;

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
			NotifyPropertyChanged(() => PhoneNumber);
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
			DataService dataService = new DataService();
			Buddy buddy = dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == PhoneNumber);
			if (buddy != null)
			{
				return buddy.ProfileImage;
			}
			if (PhoneNumber == RegistrationService.ChatOnID)
			{
				UserProfile userProfile = RegistrationService.GetUserProfile();
				if (userProfile != null)
				{
					return PivotPage.ActiveInstance.ViewModel.MyProfile.ProfileImage;
				}
				return null;
			}
			UnknownUser unknownUser = dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == PhoneNumber);
			if (unknownUser == null)
			{
				unknownUser = new UnknownUser();
				unknownUser.PhoneNumber = PhoneNumber;
				dataService.AddUnknownUser(unknownUser);
			}
			unknownUser.LoadProfileImageCompleted += user_LoadProfileImageCompleted;
			unknownUser.LoadProfileImage();
			return unknownUser.ProfileImage;
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

	private void user_LoadProfileImageCompleted(object sender, object e)
	{
		UnknownUser unknownUser = null;
		if (sender is UnknownUser unknownUser2)
		{
			unknownUser2.LoadProfileImageCompleted -= user_LoadProfileImageCompleted;
			NotifyPropertyChanged("ProfileImage");
		}
	}

	public BuddiesSay(string name, string number, string message, BitmapImage img, long timeStamp)
	{
		_name = name;
		_phoneNumber = number;
		_message = message;
		_timeStamp = timeStamp;
		_date = Utility.GetDateTimeFromMiliseconds(_timeStamp);
		NotifyPropertyChanged("");
	}
}
