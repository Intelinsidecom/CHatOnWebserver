using System;
using System.Data.Linq;
using System.Data.Linq.Mapping;
using ChatOn.Infrastructure;

namespace ChatOn.Models;

[Table]
public class MyContact : NotificationObject
{
	[Column(IsVersion = true)]
	private Binary _version;

	private Guid _contactID;

	private string _displayName;

	private string _phoneNumber;

	private bool _uploaded;

	[Column(IsPrimaryKey = true)]
	public Guid ContactID
	{
		get
		{
			return _contactID;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => ContactID);
			}
			_contactID = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => ContactID);
			}
		}
	}

	[Column]
	public string DisplayName
	{
		get
		{
			return _displayName;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => DisplayName);
			}
			_displayName = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => DisplayName);
			}
		}
	}

	[Column]
	public string PhoneNumber
	{
		get
		{
			return _phoneNumber;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => PhoneNumber);
			}
			_phoneNumber = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => PhoneNumber);
			}
		}
	}

	[Column]
	public bool Uploaded
	{
		get
		{
			return _uploaded;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Uploaded);
			}
			_uploaded = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Uploaded);
			}
		}
	}

	public MyContact()
	{
		_contactID = Guid.NewGuid();
	}

	public MyContact(string name, string number)
	{
		_contactID = Guid.NewGuid();
		_displayName = name;
		_phoneNumber = number;
	}
}
