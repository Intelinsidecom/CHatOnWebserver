using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.ConfigService;

[DataContract(Name = "MapControlConfigurationResponse", Namespace = "http://dev.virtualearth.net/webservices/v1/mapcontrolconfiguration")]
[DebuggerStepThrough]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal class MapControlConfigurationResponse : ResponseBase
{
	private string ConfigurationField;

	[DataMember]
	internal string Configuration
	{
		get
		{
			return ConfigurationField;
		}
		set
		{
			if (!object.ReferenceEquals(ConfigurationField, value))
			{
				ConfigurationField = value;
				RaisePropertyChanged("Configuration");
			}
		}
	}
}
