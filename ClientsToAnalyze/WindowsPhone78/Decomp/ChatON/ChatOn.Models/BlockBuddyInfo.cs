using System;
using ChatOn.Infrastructure;

namespace ChatOn.Models;

public class BlockBuddyInfo : NotificationObject
{
	private string _name;

	private string _number;

	private Uri _profileImageUri;

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
			return _profileImageUri;
		}
		set
		{
			_profileImageUri = value;
			NotifyPropertyChanged(() => ProfileImageUri);
		}
	}
}
