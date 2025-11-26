using System.Data.Linq;

namespace ChatOn.Models;

public class ChatDataContext : DataContext
{
	public Table<Chat> Chats;

	public ChatDataContext(string fileOrConnection)
		: base(fileOrConnection)
	{
	}
}
