using System.Runtime.Serialization;

namespace ChatOn_WoA.Services;

public class SerializerData
{
	[DataContract]
	public class AuthReponseData
	{
		[DataMember]
		public string code { get; set; }

		[DataMember]
		public string code_expires_in { get; set; }

		[DataMember]
		public string serviceID { get; set; }

		[DataMember]
		public string error_code { get; set; }

		[DataMember]
		public string error_description { get; set; }

		[DataMember]
		public string error { get; set; }
	}

	[DataContract]
	public class AccessTokenRePonseData
	{
		[DataMember]
		public string access_token { get; set; }

		[DataMember]
		public string token_type { get; set; }

		[DataMember]
		public string access_token_expires_in { get; set; }

		[DataMember]
		public string expires_in { get; set; }

		[DataMember]
		public string refresh_token { get; set; }

		[DataMember]
		public string refresh_token_expires_in { get; set; }

		[DataMember]
		public string userId { get; set; }
	}
}
