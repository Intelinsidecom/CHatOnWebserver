using System.Runtime.Serialization;

namespace ChatON_WoA.Services;

[DataContract]
public class FacebookUser
{
	public string ProfileImgSrc => $"https://graph.facebook.com/{Id}/picture";

	[DataMember(Name = "name")]
	public string Name { get; set; }

	[DataMember(Name = "id")]
	public string Id { get; set; }

	[DataMember(Name = "installed")]
	public bool Installed { get; set; }
}
