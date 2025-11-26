using System.Data.Linq;

namespace ChatOn.Models;

public class TrunkCommentDataContext : DataContext
{
	public Table<TrunkComment> TrunkComment;

	public TrunkCommentDataContext(string fileOrConnection)
		: base(fileOrConnection)
	{
	}
}
