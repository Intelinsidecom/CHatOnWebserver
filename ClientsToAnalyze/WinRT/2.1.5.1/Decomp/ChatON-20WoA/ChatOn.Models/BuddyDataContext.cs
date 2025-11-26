using SDatabase;

namespace ChatOn.Models;

public class BuddyDataContext : SDBDataContext
{
	private SDBTable<Buddy> _buddies = new SDBTable<Buddy>();

	[SDBRow("Buddies")]
	public SDBTable<Buddy> Buddies
	{
		get
		{
			return _buddies;
		}
		set
		{
			_buddies = value;
		}
	}

	public BuddyDataContext(string baseFileName)
		: base(baseFileName)
	{
	}
}
