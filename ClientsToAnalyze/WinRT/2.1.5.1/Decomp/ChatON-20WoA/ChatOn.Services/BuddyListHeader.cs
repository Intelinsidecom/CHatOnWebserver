using ChatOn.Infrastructure;

namespace ChatOn.Services;

public class BuddyListHeader : NotificationObject
{
	private string _title;

	private int _index;

	private int _totalMember;

	public BuddyListHeaderType HeaderType { get; set; }

	public string Title { get; set; }

	public int Index
	{
		get
		{
			return _index;
		}
		set
		{
			_index = value;
			NotifyPropertyChanged(() => Index);
		}
	}

	public int TotalMember
	{
		get
		{
			return _totalMember;
		}
		set
		{
			_totalMember = value;
			NotifyPropertyChanged(() => TotalMember);
		}
	}
}
