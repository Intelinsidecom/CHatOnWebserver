using System.Data.Linq;

namespace ChatOn.Models;

public class MessageDataContext : DataContext
{
	public Table<Message> Messages;

	public MessageDataContext(string fileOrConnection)
		: base(fileOrConnection)
	{
	}
}
