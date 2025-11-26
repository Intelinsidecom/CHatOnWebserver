namespace ChatOn.Services;

public class BuddyListHeader
{
	private string _title;

	private int _index;

	private BuddyListHeaderType _headerType;

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

	public string Title
	{
		get
		{
			return _title;
		}
		set
		{
			_title = value;
		}
	}

	public int Index
	{
		get
		{
			return _index;
		}
		set
		{
			_index = value;
		}
	}
}
