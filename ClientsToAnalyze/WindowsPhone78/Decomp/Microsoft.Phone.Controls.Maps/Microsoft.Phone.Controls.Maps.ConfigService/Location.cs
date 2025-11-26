using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.ConfigService;

[DebuggerStepThrough]
[KnownType(typeof(UserLocation))]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DataContract(Name = "Location", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[KnownType(typeof(GeocodeLocation))]
internal class Location : INotifyPropertyChanged
{
	private double AltitudeField;

	private double LatitudeField;

	private double LongitudeField;

	[DataMember]
	internal double Altitude
	{
		get
		{
			return AltitudeField;
		}
		set
		{
			if (!AltitudeField.Equals(value))
			{
				AltitudeField = value;
				RaisePropertyChanged("Altitude");
			}
		}
	}

	[DataMember]
	internal double Latitude
	{
		get
		{
			return LatitudeField;
		}
		set
		{
			if (!LatitudeField.Equals(value))
			{
				LatitudeField = value;
				RaisePropertyChanged("Latitude");
			}
		}
	}

	[DataMember]
	internal double Longitude
	{
		get
		{
			return LongitudeField;
		}
		set
		{
			if (!LongitudeField.Equals(value))
			{
				LongitudeField = value;
				RaisePropertyChanged("Longitude");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
