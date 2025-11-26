using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DataContract(Name = "ImageryMetadataRequest", Namespace = "http://dev.virtualearth.net/webservices/v1/imagery")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DebuggerStepThrough]
internal class ImageryMetadataRequest : RequestBase
{
	private ImageryMetadataOptions OptionsField;

	private MapStyle StyleField;

	[DataMember]
	internal ImageryMetadataOptions Options
	{
		get
		{
			return OptionsField;
		}
		set
		{
			if (!object.ReferenceEquals(OptionsField, value))
			{
				OptionsField = value;
				RaisePropertyChanged("Options");
			}
		}
	}

	[DataMember]
	internal MapStyle Style
	{
		get
		{
			return StyleField;
		}
		set
		{
			if (!StyleField.Equals(value))
			{
				StyleField = value;
				RaisePropertyChanged("Style");
			}
		}
	}
}
