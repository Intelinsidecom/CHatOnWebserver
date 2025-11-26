using System.Runtime.Serialization;

namespace ChatON_WoA.Services;

[DataContract]
public class FacebookFriends
{
	private FacebookUser[] _friends;

	[DataMember(Name = "data")]
	public FacebookUser[] Friends
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
}
