using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DebuggerStepThrough]
[DataContract(Name = "Pushpin", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal class Pushpin : INotifyPropertyChanged
{
	private string IconStyleField;

	private string LabelField;

	private Location LocationField;

	[DataMember]
	internal string IconStyle
	{
		get
		{
			return IconStyleField;
		}
		set
		{
			if (!object.ReferenceEquals(IconStyleField, value))
			{
				IconStyleField = value;
				RaisePropertyChanged("IconStyle");
			}
		}
	}

	[DataMember]
	internal string Label
	{
		get
		{
			return LabelField;
		}
		set
		{
			if (!object.ReferenceEquals(LabelField, value))
			{
				LabelField = value;
				RaisePropertyChanged("Label");
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

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
