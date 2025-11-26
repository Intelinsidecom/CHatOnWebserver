using System.Data.Linq;

namespace ChatOn.Models;

public class BuddyDataContext : DataContext
{
	public Table<Buddy> Buddies;

	public Table<BuddyGroup> Groups;

	public Table<UnknownUser> UnknownUsers;

	public BuddyDataContext(string fileOrConnection)
		: base(fileOrConnection)
	{
	}
}
