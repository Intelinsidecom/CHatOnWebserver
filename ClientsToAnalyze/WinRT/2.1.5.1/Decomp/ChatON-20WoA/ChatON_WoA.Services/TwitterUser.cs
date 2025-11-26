using System.Runtime.Serialization;

namespace ChatON_WoA.Services;

[DataContract]
public class TwitterUser
{
	[DataMember(Name = "profile_image_url")]
	public string ProfileImgSrc { get; set; }

	[DataMember(Name = "name")]
	public string Name { get; set; }

	[DataMember(Name = "screen_name")]
	public string ScreenName { get; set; }

	[DataMember(Name = "id")]
	public string Id { get; set; }
}
