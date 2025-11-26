using System.CodeDom.Compiler;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DataContract(Name = "ImageryMetadataResponse", Namespace = "http://dev.virtualearth.net/webservices/v1/imagery")]
[DebuggerStepThrough]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal class ImageryMetadataResponse : ResponseBase
{
	private Collection<ImageryMetadataResult> ResultsField;

	[DataMember]
	internal Collection<ImageryMetadataResult> Results
	{
		get
		{
			return ResultsField;
		}
		set
		{
			if (!object.ReferenceEquals(ResultsField, value))
			{
				ResultsField = value;
				RaisePropertyChanged("Results");
			}
		}
	}
}
