using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps;

[DataContract(Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
public class Credentials
{
	[DataMember]
	public string ApplicationId { get; set; }

	public override bool Equals(object obj)
	{
		if (obj is Credentials credentials)
		{
			return this == credentials;
		}
		return false;
	}

	public override int GetHashCode()
	{
		return ApplicationId.GetHashCode();
	}

	public override string ToString()
	{
		if (!string.IsNullOrEmpty(ApplicationId))
		{
			return ApplicationId;
		}
		return string.Empty;
	}
}
