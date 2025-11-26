using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.ConfigService;

[DataContract(Name = "GeocodeLocation", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[DebuggerStepThrough]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
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
