using SDatabase;

namespace ChatOn.Models;

public class BuddyGroupDataContext : SDBDataContext
{
	public SDBTable<BuddyGroup> _groups = new SDBTable<BuddyGroup>();

	[SDBRow("Groups")]
	public SDBTable<BuddyGroup> Groups
	{
		get
		{
			return _groups;
		}
		set
		{
			_groups = value;
		}
	}

	public BuddyGroupDataContext(string baseFileName)
		: base(baseFileName)
	{
	}
}
