using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DebuggerStepThrough]
[KnownType(typeof(ImageryMetadataRequest))]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[KnownType(typeof(MapUriRequest))]
[DataContract(Name = "RequestBase", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
internal class RequestBase : INotifyPropertyChanged
{
	private Credentials CredentialsField;

	private string CultureField;

	private ExecutionOptions ExecutionOptionsField;

	private UserProfile UserProfileField;

	[DataMember]
	internal Credentials Credentials
	{
		get
		{
			return CredentialsField;
		}
		set
		{
			if (!object.ReferenceEquals(CredentialsField, value))
			{
				CredentialsField = value;
				RaisePropertyChanged("Credentials");
			}
		}
	}

	[DataMember]
	internal string Culture
	{
		get
		{
			return CultureField;
		}
		set
		{
			if (!object.ReferenceEquals(CultureField, value))
			{
				CultureField = value;
				RaisePropertyChanged("Culture");
			}
		}
	}

	[DataMember]
	internal ExecutionOptions ExecutionOptions
	{
		get
		{
			return ExecutionOptionsField;
		}
		set
		{
			if (!object.ReferenceEquals(ExecutionOptionsField, value))
			{
				ExecutionOptionsField = value;
				RaisePropertyChanged("ExecutionOptions");
			}
		}
	}

	[DataMember]
	internal UserProfile UserProfile
	{
		get
		{
			return UserProfileField;
		}
		set
		{
			if (!object.ReferenceEquals(UserProfileField, value))
			{
				UserProfileField = value;
				RaisePropertyChanged("UserProfile");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
