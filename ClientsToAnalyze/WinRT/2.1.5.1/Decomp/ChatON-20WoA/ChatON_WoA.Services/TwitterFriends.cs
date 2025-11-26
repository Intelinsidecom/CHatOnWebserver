using System.Runtime.Serialization;

namespace ChatON_WoA.Services;

[DataContract]
public class TwitterFriends
{
	private TwitterUser[] _friends;

	[DataMember(Name = "users")]
	public TwitterUser[] Friends
	{
		get
		{
			return _friends;
		}
		set
		{
			_friends = value;
		}
	}

	[DataMember(Name = "next_cursor_str")]
	public string NextCursor { get; set; }
}
