using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DebuggerStepThrough]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DataContract(Name = "GeocodeLocation", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
internal class GeocodeLocation : Location
{
	private string CalculationMethodField;

	[DataMember]
	internal string CalculationMethod
	{
		get
		{
			return CalculationMethodField;
		}
		set
		{
			if (!object.ReferenceEquals(CalculationMethodField, value))
			{
				CalculationMethodField = value;
				RaisePropertyChanged("CalculationMethod");
			}
		}
	}
}
