using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DataContract(Name = "Circle", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[DebuggerStepThrough]
internal class Circle : ShapeBase
{
	private Location CenterField;

	private DistanceUnit DistanceUnitField;

	private double RadiusField;

	[DataMember]
	internal Location Center
	{
		get
		{
			return CenterField;
		}
		set
		{
			if (!object.ReferenceEquals(CenterField, value))
			{
				CenterField = value;
				RaisePropertyChanged("Center");
			}
		}
	}

	[DataMember]
	internal DistanceUnit DistanceUnit
	{
		get
		{
			return DistanceUnitField;
		}
		set
		{
			if (!DistanceUnitField.Equals(value))
			{
				DistanceUnitField = value;
				RaisePropertyChanged("DistanceUnit");
			}
		}
	}

	[DataMember]
	internal double Radius
	{
		get
		{
			return RadiusField;
		}
		set
		{
			if (!RadiusField.Equals(value))
			{
				RadiusField = value;
				RaisePropertyChanged("Radius");
			}
		}
	}
}
