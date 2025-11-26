using System;
using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.ConfigService;

[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[KnownType(typeof(MapControlConfigurationResponse))]
[DataContract(Name = "ResponseBase", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[DebuggerStepThrough]
internal class ResponseBase : INotifyPropertyChanged
{
	private Uri BrandLogoUriField;

	private ResponseSummary ResponseSummaryField;

	[DataMember]
	internal Uri BrandLogoUri
	{
		get
		{
			return BrandLogoUriField;
		}
		set
		{
			if (!object.ReferenceEquals(BrandLogoUriField, value))
			{
				BrandLogoUriField = value;
				RaisePropertyChanged("BrandLogoUri");
			}
		}
	}

	[DataMember]
	internal ResponseSummary ResponseSummary
	{
		get
		{
			return ResponseSummaryField;
		}
		set
		{
			if (!object.ReferenceEquals(ResponseSummaryField, value))
			{
				ResponseSummaryField = value;
				RaisePropertyChanged("ResponseSummary");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
