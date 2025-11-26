using ChatOn.Models;
using Windows.Storage;

namespace ChatON_WoA.ViewModels;

public class TrunkFullMode
{
	private int _commentCounter;

	private StorageFile _file;

	private TrunkItem _item;

	private Chat _chat;

	public int CommentCounter { get; set; }

	public StorageFile File
	{
		get
		{
			return _file;
		}
		set
		{
			_file = value;
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
}
