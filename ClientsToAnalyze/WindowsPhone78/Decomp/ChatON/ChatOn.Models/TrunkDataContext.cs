using System.Data.Linq;

namespace ChatOn.Models;

public class TrunkDataContext : DataContext
{
	public Table<TrunkItem> TrunkItem;

	public TrunkDataContext(string fileOrConnection)
		: base(fileOrConnection)
	{
	}
}
