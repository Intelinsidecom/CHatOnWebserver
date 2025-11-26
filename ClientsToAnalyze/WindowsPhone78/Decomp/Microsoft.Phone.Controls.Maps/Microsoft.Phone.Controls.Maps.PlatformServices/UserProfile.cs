using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DebuggerStepThrough]
[DataContract(Name = "UserProfile", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal class UserProfile : INotifyPropertyChanged
{
	private Heading CurrentHeadingField;

	private UserLocation CurrentLocationField;

	private DeviceType DeviceTypeField;

	private DistanceUnit DistanceUnitField;

	private string IPAddressField;

	private ShapeBase MapViewField;

	private SizeOfint ScreenSizeField;

	[DataMember]
	internal Heading CurrentHeading
	{
		get
		{
			return CurrentHeadingField;
		}
		set
		{
			if (!object.ReferenceEquals(CurrentHeadingField, value))
			{
				CurrentHeadingField = value;
				RaisePropertyChanged("CurrentHeading");
			}
		}
	}

	[DataMember]
	internal UserLocation CurrentLocation
	{
		get
		{
			return CurrentLocationField;
		}
		set
		{
			if (!object.ReferenceEquals(CurrentLocationField, value))
			{
				CurrentLocationField = value;
				RaisePropertyChanged("CurrentLocation");
			}
		}
	}

	[DataMember]
	internal DeviceType DeviceType
	{
		get
		{
			return DeviceTypeField;
		}
		set
		{
			if (!DeviceTypeField.Equals(value))
			{
				DeviceTypeField = value;
				RaisePropertyChanged("DeviceType");
			}
		}
	}

	[DataMember]
	internal DistanceUnit DistanceUnit
	{
		get
		{
			return DistanceUnitField;
		}
		set
		{
			if (!DistanceUnitField.Equals(value))
			{
				DistanceUnitField = value;
				RaisePropertyChanged("DistanceUnit");
			}
		}
	}

	[DataMember]
	internal string IPAddress
	{
		get
		{
			return IPAddressField;
		}
		set
		{
			if (!object.ReferenceEquals(IPAddressField, value))
			{
				IPAddressField = value;
				RaisePropertyChanged("IPAddress");
			}
		}
	}

	[DataMember]
	internal ShapeBase MapView
	{
		get
		{
			return MapViewField;
		}
		set
		{
			if (!object.ReferenceEquals(MapViewField, value))
			{
				MapViewField = value;
				RaisePropertyChanged("MapView");
			}
		}
	}

	[DataMember]
	internal SizeOfint ScreenSize
	{
		get
		{
			return ScreenSizeField;
		}
		set
		{
			if (!object.ReferenceEquals(ScreenSizeField, value))
			{
				ScreenSizeField = value;
				RaisePropertyChanged("ScreenSize");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
