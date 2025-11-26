using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DataContract(Name = "ImageryMetadataBirdseyeResult", Namespace = "http://dev.virtualearth.net/webservices/v1/imagery")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DebuggerStepThrough]
internal class ImageryMetadataBirdseyeResult : ImageryMetadataResult
{
	private Heading HeadingField;

	private int TilesXField;

	private int TilesYField;

	[DataMember]
	internal Heading Heading
	{
		get
		{
			return HeadingField;
		}
		set
		{
			if (!object.ReferenceEquals(HeadingField, value))
			{
				HeadingField = value;
				RaisePropertyChanged("Heading");
			}
		}
	}

	[DataMember]
	internal int TilesX
	{
		get
		{
			return TilesXField;
		}
		set
		{
			if (!TilesXField.Equals(value))
			{
				TilesXField = value;
				RaisePropertyChanged("TilesX");
			}
		}
	}

	[DataMember]
	internal int TilesY
	{
		get
		{
			return TilesYField;
		}
		set
		{
			if (!TilesYField.Equals(value))
			{
				TilesYField = value;
				RaisePropertyChanged("TilesY");
			}
		}
	}
}
