using System.CodeDom.Compiler;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.ConfigService;

[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DataContract(Name = "Confidence", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
internal enum Confidence
{
	[EnumMember]
	High,
	[EnumMember]
	Medium,
	[EnumMember]
	Low
}
