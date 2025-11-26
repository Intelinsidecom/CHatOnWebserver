using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.ConfigService;

[DataContract(Name = "MapControlConfigurationRequest", Namespace = "http://dev.virtualearth.net/webservices/v1/mapcontrolconfiguration")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DebuggerStepThrough]
internal class MapControlConfigurationRequest : RequestBase
{
	private string SectionNameField;

	private string VersionField;

	[DataMember]
	internal string SectionName
	{
		get
		{
			return SectionNameField;
		}
		set
		{
			if (!object.ReferenceEquals(SectionNameField, value))
			{
				SectionNameField = value;
				RaisePropertyChanged("SectionName");
			}
		}
	}

	[DataMember]
	internal string Version
	{
		get
		{
			return VersionField;
		}
		set
		{
			if (!object.ReferenceEquals(VersionField, value))
			{
				VersionField = value;
				RaisePropertyChanged("Version");
			}
		}
	}
}
