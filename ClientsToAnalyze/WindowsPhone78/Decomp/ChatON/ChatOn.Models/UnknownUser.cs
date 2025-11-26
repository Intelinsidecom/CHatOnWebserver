using System;
using System.Data.Linq;
using System.Data.Linq.Mapping;
using ChatOn.Infrastructure;

namespace ChatOn.Models;

[Table]
public class UnknownUser : NotificationObject
{
	[Column(IsVersion = true)]
	private Binary _version;

	private Guid _unknownUserID;

	private string _phoneNumber;

	private string _name;

	[Column(IsPrimaryKey = true)]
	public Guid UnknownUserID
	{
		get
		{
			return _unknownUserID;
		}
		set
		{
			NotifyPropertyChanging(() => UnknownUserID);
			_unknownUserID = value;
			NotifyPropertyChanged(() => UnknownUserID);
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
			NotifyPropertyChanging(() => PhoneNumber);
			_phoneNumber = value;
			NotifyPropertyChanged(() => PhoneNumber);
		}
	}

	[Column]
	public string Name
	{
		get
		{
			return _name;
		}
		set
		{
			NotifyPropertyChanging(() => Name);
			_name = value;
			NotifyPropertyChanged(() => Name);
		}
	}

	public UnknownUser()
	{
		_unknownUserID = Guid.NewGuid();
	}

	public UnknownUser(string name, string number)
	{
		_unknownUserID = Guid.NewGuid();
		_name = name;
		_phoneNumber = number;
	}
}
