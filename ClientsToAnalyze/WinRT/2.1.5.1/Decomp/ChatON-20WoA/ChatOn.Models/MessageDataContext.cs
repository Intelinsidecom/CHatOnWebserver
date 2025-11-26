using SDatabase;

namespace ChatOn.Models;

public class MessageDataContext : SDBDataContext
{
	public SDBTable<Message> _messages = new SDBTable<Message>();

	[SDBRow("Messages")]
	public SDBTable<Message> Messages
	{
		get
		{
			return _messages;
		}
		set
		{
			_messages = value;
		}
	}

	public MessageDataContext(string baseFileName)
		: base(baseFileName)
	{
	}
}
