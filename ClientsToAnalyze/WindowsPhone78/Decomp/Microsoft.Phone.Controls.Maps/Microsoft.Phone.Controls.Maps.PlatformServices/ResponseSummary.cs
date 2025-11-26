using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DebuggerStepThrough]
[DataContract(Name = "ResponseSummary", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal class ResponseSummary : INotifyPropertyChanged
{
	private AuthenticationResultCode AuthenticationResultCodeField;

	private string CopyrightField;

	private string FaultReasonField;

	private ResponseStatusCode StatusCodeField;

	private string TraceIdField;

	[DataMember]
	internal AuthenticationResultCode AuthenticationResultCode
	{
		get
		{
			return AuthenticationResultCodeField;
		}
		set
		{
			if (!AuthenticationResultCodeField.Equals(value))
			{
				AuthenticationResultCodeField = value;
				RaisePropertyChanged("AuthenticationResultCode");
			}
		}
	}

	[DataMember]
	internal string Copyright
	{
		get
		{
			return CopyrightField;
		}
		set
		{
			if (!object.ReferenceEquals(CopyrightField, value))
			{
				CopyrightField = value;
				RaisePropertyChanged("Copyright");
			}
		}
	}

	[DataMember]
	internal string FaultReason
	{
		get
		{
			return FaultReasonField;
		}
		set
		{
			if (!object.ReferenceEquals(FaultReasonField, value))
			{
				FaultReasonField = value;
				RaisePropertyChanged("FaultReason");
			}
		}
	}

	[DataMember]
	internal ResponseStatusCode StatusCode
	{
		get
		{
			return StatusCodeField;
		}
		set
		{
			if (!StatusCodeField.Equals(value))
			{
				StatusCodeField = value;
				RaisePropertyChanged("StatusCode");
			}
		}
	}

	[DataMember]
	internal string TraceId
	{
		get
		{
			return TraceIdField;
		}
		set
		{
			if (!object.ReferenceEquals(TraceIdField, value))
			{
				TraceIdField = value;
				RaisePropertyChanged("TraceId");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
