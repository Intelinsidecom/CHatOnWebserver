using System.CodeDom.Compiler;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DataContract(Name = "MapStyle", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal enum MapStyle
{
	[EnumMember]
	Road,
	[EnumMember]
	Aerial,
	[EnumMember]
	AerialWithLabels,
	[EnumMember]
	Birdseye,
	[EnumMember]
	BirdseyeWithLabels
}
