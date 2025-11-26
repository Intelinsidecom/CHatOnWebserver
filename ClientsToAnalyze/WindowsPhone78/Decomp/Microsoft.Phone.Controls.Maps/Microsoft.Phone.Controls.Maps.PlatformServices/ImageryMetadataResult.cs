using System.CodeDom.Compiler;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DebuggerStepThrough]
[DataContract(Name = "ImageryMetadataResult", Namespace = "http://dev.virtualearth.net/webservices/v1/imagery")]
[KnownType(typeof(ImageryMetadataBirdseyeResult))]
internal class ImageryMetadataResult : INotifyPropertyChanged
{
	private SizeOfint ImageSizeField;

	private string ImageUriField;

	private Collection<string> ImageUriSubdomainsField;

	private Collection<ImageryProvider> ImageryProvidersField;

	private RangeOfdateTime VintageField;

	private RangeOfint ZoomRangeField;

	[DataMember]
	internal SizeOfint ImageSize
	{
		get
		{
			return ImageSizeField;
		}
		set
		{
			if (!object.ReferenceEquals(ImageSizeField, value))
			{
				ImageSizeField = value;
				RaisePropertyChanged("ImageSize");
			}
		}
	}

	[DataMember]
	internal string ImageUri
	{
		get
		{
			return ImageUriField;
		}
		set
		{
			if (!object.ReferenceEquals(ImageUriField, value))
			{
				ImageUriField = value;
				RaisePropertyChanged("ImageUri");
			}
		}
	}

	[DataMember]
	internal Collection<string> ImageUriSubdomains
	{
		get
		{
			return ImageUriSubdomainsField;
		}
		set
		{
			if (!object.ReferenceEquals(ImageUriSubdomainsField, value))
			{
				ImageUriSubdomainsField = value;
				RaisePropertyChanged("ImageUriSubdomains");
			}
		}
	}

	[DataMember]
	internal Collection<ImageryProvider> ImageryProviders
	{
		get
		{
			return ImageryProvidersField;
		}
		set
		{
			if (!object.ReferenceEquals(ImageryProvidersField, value))
			{
				ImageryProvidersField = value;
				RaisePropertyChanged("ImageryProviders");
			}
		}
	}

	[DataMember]
	internal RangeOfdateTime Vintage
	{
		get
		{
			return VintageField;
		}
		set
		{
			if (!object.ReferenceEquals(VintageField, value))
			{
				VintageField = value;
				RaisePropertyChanged("Vintage");
			}
		}
	}

	[DataMember]
	internal RangeOfint ZoomRange
	{
		get
		{
			return ZoomRangeField;
		}
		set
		{
			if (!object.ReferenceEquals(ZoomRangeField, value))
			{
				ZoomRangeField = value;
				RaisePropertyChanged("ZoomRange");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
