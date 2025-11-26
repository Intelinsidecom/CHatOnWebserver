using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DebuggerStepThrough]
[DataContract(Name = "Rectangle", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal class Rectangle : ShapeBase
{
	private Location NortheastField;

	private Location SouthwestField;

	[DataMember]
	internal Location Northeast
	{
		get
		{
			return NortheastField;
		}
		set
		{
			if (!object.ReferenceEquals(NortheastField, value))
			{
				NortheastField = value;
				RaisePropertyChanged("Northeast");
			}
		}
	}

	[DataMember]
	internal Location Southwest
	{
		get
		{
			return SouthwestField;
		}
		set
		{
			if (!object.ReferenceEquals(SouthwestField, value))
			{
				SouthwestField = value;
				RaisePropertyChanged("Southwest");
			}
		}
	}
}
