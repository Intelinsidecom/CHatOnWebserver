using ChatOn.Models;
using Windows.Storage;

namespace ChatOn.ViewModels;

public class TrunkItemParameter
{
	private Chat _chat;

	private TrunkItem _item;

	public Chat Chat
	{
		get
		{
			return _chat;
		}
		set
		{
			_chat = value;
		}
	}

	public TrunkItem Item
	{
		get
		{
			return _item;
		}
		set
		{
			_item = value;
		}
	}

	public StorageFile TempFile { get; set; }

	public Message Msg { get; set; }

	public string MediaType { get; set; }
}
