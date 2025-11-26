using System.CodeDom.Compiler;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DebuggerStepThrough]
[DataContract(Name = "MapUriOptions", Namespace = "http://dev.virtualearth.net/webservices/v1/imagery")]
internal class MapUriOptions : INotifyPropertyChanged
{
	private Collection<string> DisplayLayersField;

	private SizeOfint ImageSizeField;

	private ImageType ImageTypeField;

	private bool PreventIconCollisionField;

	private MapStyle StyleField;

	private UriScheme UriSchemeField;

	private int? ZoomLevelField;

	[DataMember]
	internal Collection<string> DisplayLayers
	{
		get
		{
			return DisplayLayersField;
		}
		set
		{
			if (!object.ReferenceEquals(DisplayLayersField, value))
			{
				DisplayLayersField = value;
				RaisePropertyChanged("DisplayLayers");
			}
		}
	}

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
	internal ImageType ImageType
	{
		get
		{
			return ImageTypeField;
		}
		set
		{
			if (!ImageTypeField.Equals(value))
			{
				ImageTypeField = value;
				RaisePropertyChanged("ImageType");
			}
		}
	}

	[DataMember]
	internal bool PreventIconCollision
	{
		get
		{
			return PreventIconCollisionField;
		}
		set
		{
			if (!PreventIconCollisionField.Equals(value))
			{
				PreventIconCollisionField = value;
				RaisePropertyChanged("PreventIconCollision");
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
