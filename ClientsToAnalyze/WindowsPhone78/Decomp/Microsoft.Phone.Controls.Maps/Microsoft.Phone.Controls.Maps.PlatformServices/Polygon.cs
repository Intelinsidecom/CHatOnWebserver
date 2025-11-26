using System.CodeDom.Compiler;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DebuggerStepThrough]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DataContract(Name = "Polygon", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
internal class Polygon : ShapeBase
{
	private Collection<Location> VerticesField;

	[DataMember]
	internal Collection<Location> Vertices
	{
		get
		{
			return VerticesField;
		}
		set
		{
			if (!object.ReferenceEquals(VerticesField, value))
			{
				VerticesField = value;
				RaisePropertyChanged("Vertices");
			}
		}
	}
}
