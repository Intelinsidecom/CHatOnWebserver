using SDatabase;

namespace ChatOn.Models;

public class UnknownUserDataContext : SDBDataContext
{
	public SDBTable<UnknownUser> _unknownUsers = new SDBTable<UnknownUser>();

	[SDBRow("UnknownUsers")]
	public SDBTable<UnknownUser> UnknownUsers
	{
		get
		{
			return _unknownUsers;
		}
		set
		{
			_unknownUsers = value;
		}
	}

	public UnknownUserDataContext(string baseFileName)
		: base(baseFileName)
	{
	}
}
