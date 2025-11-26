using System;
using ChatOn.Infrastructure;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Models;

public class BlockBuddyInfo : NotificationObject
{
	private string _name;

	private string _number;

	private Uri _profileImageUri;

	private string _status;

	private bool _isIsChecked;

	private bool _isDeleteMode;

	private SolidColorBrush _background;

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

	public string Number
	{
		get
		{
			return _number;
		}
		set
		{
			_number = value;
			NotifyPropertyChanged(() => Number);
		}
	}

	public Uri ProfileImageUri
	{
		get
		{
			if (_profileImageUri == null)
			{
				return new Uri("ms-appx:///Images/chat_info_single.png");
			}
			return _profileImageUri;
		}
		set
		{
			_profileImageUri = value;
			NotifyPropertyChanged(() => ProfileImageUri);
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

	public bool IsChecked
	{
		get
		{
			return _isIsChecked;
		}
		set
		{
			_isIsChecked = value;
			NotifyPropertyChanged(() => IsChecked);
		}
	}

	public SolidColorBrush Background
	{
		get
		{
			return _background;
		}
		set
		{
			_background = value;
			NotifyPropertyChanged(() => Background);
		}
	}

	public bool IsDeleteMode
	{
		get
		{
			return _isDeleteMode;
		}
		set
		{
			_isDeleteMode = value;
			NotifyPropertyChanged(() => IsDeleteMode);
		}
	}
}
