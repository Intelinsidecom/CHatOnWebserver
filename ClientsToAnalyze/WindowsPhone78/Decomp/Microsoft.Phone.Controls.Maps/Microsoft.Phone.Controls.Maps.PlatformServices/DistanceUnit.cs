using System.CodeDom.Compiler;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DataContract(Name = "DistanceUnit", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal enum DistanceUnit
{
	[EnumMember]
	Kilometer,
	[EnumMember]
	Mile
}
