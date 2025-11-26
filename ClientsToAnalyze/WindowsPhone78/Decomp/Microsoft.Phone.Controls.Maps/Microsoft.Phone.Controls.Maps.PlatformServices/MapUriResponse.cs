using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DataContract(Name = "MapUriResponse", Namespace = "http://dev.virtualearth.net/webservices/v1/imagery")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DebuggerStepThrough]
internal class MapUriResponse : ResponseBase
{
	private string UriField;

	[DataMember]
	internal string Uri
	{
		get
		{
			return UriField;
		}
		set
		{
			if (!object.ReferenceEquals(UriField, value))
			{
				UriField = value;
				RaisePropertyChanged("Uri");
			}
		}
	}
}
