using System.CodeDom.Compiler;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DataContract(Name = "ImageType", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
internal enum ImageType
{
	[EnumMember]
	Default,
	[EnumMember]
	Png,
	[EnumMember]
	Jpeg,
	[EnumMember]
	Gif
}
