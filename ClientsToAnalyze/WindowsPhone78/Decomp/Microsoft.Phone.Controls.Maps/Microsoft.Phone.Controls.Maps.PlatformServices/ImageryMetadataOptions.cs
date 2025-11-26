using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DataContract(Name = "ImageryMetadataOptions", Namespace = "http://dev.virtualearth.net/webservices/v1/imagery")]
[DebuggerStepThrough]
internal class ImageryMetadataOptions : INotifyPropertyChanged
{
	private Heading HeadingField;

	private Location LocationField;

	private bool ReturnImageryProvidersField;

	private UriScheme UriSchemeField;

	private int? ZoomLevelField;

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
	internal Location Location
	{
		get
		{
			return LocationField;
		}
		set
		{
			if (!object.ReferenceEquals(LocationField, value))
			{
				LocationField = value;
				RaisePropertyChanged("Location");
			}
		}
	}

	[DataMember]
	internal bool ReturnImageryProviders
	{
		get
		{
			return ReturnImageryProvidersField;
		}
		set
		{
			if (!ReturnImageryProvidersField.Equals(value))
			{
				ReturnImageryProvidersField = value;
				RaisePropertyChanged("ReturnImageryProviders");
			}
		}
	}

	[DataMember]
	internal UriScheme UriScheme
	{
		get
		{
			return UriSchemeField;
		}
		set
		{
			if (!UriSchemeField.Equals(value))
			{
				UriSchemeField = value;
				RaisePropertyChanged("UriScheme");
			}
		}
	}

	[DataMember]
	internal int? ZoomLevel
	{
		get
		{
			return ZoomLevelField;
		}
		set
		{
			if (!ZoomLevelField.Equals(value))
			{
				ZoomLevelField = value;
				RaisePropertyChanged("ZoomLevel");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
