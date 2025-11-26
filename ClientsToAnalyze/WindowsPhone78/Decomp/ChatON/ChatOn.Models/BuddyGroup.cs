using System;
using System.Data.Linq;
using System.Data.Linq.Mapping;
using ChatOn.Infrastructure;

namespace ChatOn.Models;

[Table]
public class BuddyGroup : NotificationObject
{
	[Column(IsVersion = true)]
	private Binary _version;

	private Guid _groupID;

	private string _name = "";

	private string _members = "";

	[Column(IsPrimaryKey = true)]
	public Guid GroupID
	{
		get
		{
			return _groupID;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => GroupID);
			}
			_groupID = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => GroupID);
			}
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
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Name);
			}
			_name = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Name);
			}
		}
	}

	[Column]
	public string Members
	{
		get
		{
			return _members;
		}
		set
		{
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanging(() => Members);
			}
			_members = value;
			if (!NotificationObject.IsBlockChangingNotification)
			{
				NotifyPropertyChanged(() => Members);
			}
		}
	}

	public BuddyGroup()
	{
		_groupID = Guid.NewGuid();
	}
}
