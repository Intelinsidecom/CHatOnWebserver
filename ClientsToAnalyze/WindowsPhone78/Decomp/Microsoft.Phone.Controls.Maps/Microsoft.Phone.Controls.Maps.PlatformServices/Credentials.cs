using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DataContract(Name = "Credentials", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[DebuggerStepThrough]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal class Credentials : INotifyPropertyChanged
{
	private string ApplicationIdField;

	private string TokenField;

	[DataMember]
	internal string ApplicationId
	{
		get
		{
			return ApplicationIdField;
		}
		set
		{
			if (!object.ReferenceEquals(ApplicationIdField, value))
			{
				ApplicationIdField = value;
				RaisePropertyChanged("ApplicationId");
			}
		}
	}

	[DataMember]
	internal string Token
	{
		get
		{
			return TokenField;
		}
		set
		{
			if (!object.ReferenceEquals(TokenField, value))
			{
				TokenField = value;
				RaisePropertyChanged("Token");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
