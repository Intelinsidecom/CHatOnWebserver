using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DebuggerStepThrough]
[DataContract(Name = "Heading", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal class Heading : INotifyPropertyChanged
{
	private double OrientationField;

	[DataMember]
	internal double Orientation
	{
		get
		{
			return OrientationField;
		}
		set
		{
			if (!OrientationField.Equals(value))
			{
				OrientationField = value;
				RaisePropertyChanged("Orientation");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
