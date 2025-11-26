using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.ConfigService;

[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DataContract(Name = "UserLocation", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[DebuggerStepThrough]
internal class UserLocation : Location
{
	private Confidence ConfidenceField;

	[DataMember]
	internal Confidence Confidence
	{
		get
		{
			return ConfidenceField;
		}
		set
		{
			if (!ConfidenceField.Equals(value))
			{
				ConfidenceField = value;
				RaisePropertyChanged("Confidence");
			}
		}
	}
}
