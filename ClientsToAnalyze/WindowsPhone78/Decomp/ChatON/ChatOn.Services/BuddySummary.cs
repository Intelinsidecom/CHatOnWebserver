using ChatOn.Infrastructure;
using ChatOn.Models;

namespace ChatOn.Services;

public class BuddySummary : NotificationObject
{
	public enum ItemType
	{
		Index,
		Buddy,
		Group
	}

	private string _headerName;

	private BuddyListHeaderType _headerType;

	private Buddy _buddy;

	private BuddyGroup _group;

	private string _keyword;

	private ItemType _type;

	private bool _isSpecialBuddy;

	private int _count;

	public int Count
	{
		get
		{
			return _count;
		}
		set
		{
			_count = value;
		}
	}

	public bool IsSpecialBuddy
	{
		get
		{
			return _isSpecialBuddy;
		}
		set
		{
			_isSpecialBuddy = value;
		}
	}

	public ItemType Type
	{
		get
		{
			return _type;
		}
		set
		{
			_type = value;
		}
	}

	public BuddyListHeaderType HeaderType
	{
		get
		{
			return _headerType;
		}
		set
		{
			_headerType = value;
		}
	}

	public string HeaderName
	{
		get
		{
			return _headerName;
		}
		set
		{
			_headerName = value;
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
		}
	}

	public BuddyGroup Group
	{
		get
		{
			return _group;
		}
		set
		{
			_group = value;
		}
	}

	public string Keyword
	{
		get
		{
			return _keyword;
		}
		set
		{
			_keyword = value;
			NotifyPropertyChanged(() => Keyword);
		}
	}
}
