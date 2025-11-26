using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.ConfigService;

[DebuggerStepThrough]
[DataContract(Name = "SearchPoint", Namespace = "http://dev.virtualearth.net/webservices/v1/search")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal class SearchPoint : ShapeBase
{
	private Location PointField;

	[DataMember]
	internal Location Point
	{
		get
		{
			return PointField;
		}
		set
		{
			if (!object.ReferenceEquals(PointField, value))
			{
				PointField = value;
				RaisePropertyChanged("Point");
			}
		}
	}
}
