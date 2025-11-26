using System;
using SDatabase;

namespace ChatOn.Models;

public class MyContact : SDBData
{
	private Guid _contactID;

	private string _displayName;

	private string _phoneNumber;

	private bool _uploaded;

	[SDBColumn]
	public Guid ContactID
	{
		get
		{
			return _contactID;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _contactID != value)
			{
				SetDataUpdated();
			}
			_contactID = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => ContactID);
			}
		}
	}

	[SDBColumn(Encrypt = true)]
	public string DisplayName
	{
		get
		{
			return _displayName;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _displayName != value)
			{
				SetDataUpdated();
			}
			_displayName = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => DisplayName);
			}
		}
	}

	[SDBColumn(Encrypt = true)]
	public string PhoneNumber
	{
		get
		{
			return _phoneNumber;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _phoneNumber != value)
			{
				SetDataUpdated();
			}
			_phoneNumber = value;
			if (!SDBData.SkipPropertyChangedNoti)
			{
				NotifyPropertyChanged(() => PhoneNumber);
			}
		}
	}

	[SDBColumn]
	public bool Uploaded
	{
		get
		{
			return _uploaded;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _uploaded != value)
			{
				SetDataUpdated();
			}
			_uploaded = value;
			if (!SDBData.SkipPropertyChangedNoti)
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
