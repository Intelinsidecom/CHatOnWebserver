using ChatOn.Infrastructure;
using ChatOn.Models;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.ViewModels;

public class ChatBuddy : NotificationObject
{
	private string _name;

	private string _phoneNumber;

	private Buddy _buddy;

	private string _status;

	private BitmapImage _profileImage;

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

	public Buddy Buddy
	{
		get
		{
			return _buddy;
		}
		set
		{
			_buddy = value;
			NotifyPropertyChanged(() => Buddy);
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
			NotifyPropertyChanged(() => Status);
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
			NotifyPropertyChanged(() => ProfileImage);
		}
	}

	public void NotifyAllPropertiesChanged()
	{
		NotifyPropertyChanged(() => Name);
		NotifyPropertyChanged(() => Status);
		NotifyPropertyChanged(() => ProfileImage);
	}
}
