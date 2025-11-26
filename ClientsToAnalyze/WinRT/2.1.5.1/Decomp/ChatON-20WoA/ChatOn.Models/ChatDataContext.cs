using SDatabase;

namespace ChatOn.Models;

public class ChatDataContext : SDBDataContext
{
	public SDBTable<Chat> _chats = new SDBTable<Chat>();

	[SDBRow("Chats")]
	public SDBTable<Chat> Chats
	{
		get
		{
			return _chats;
		}
		set
		{
			_chats = value;
		}
	}

	public ChatDataContext(string baseFileName)
		: base(baseFileName)
	{
	}
}
