using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.ConfigService;

[DebuggerStepThrough]
[DataContract(Name = "SizeOfint", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal class SizeOfint : INotifyPropertyChanged
{
	private int HeightField;

	private int WidthField;

	[DataMember]
	internal int Height
	{
		get
		{
			return HeightField;
		}
		set
		{
			if (!HeightField.Equals(value))
			{
				HeightField = value;
				RaisePropertyChanged("Height");
			}
		}
	}

	[DataMember]
	internal int Width
	{
		get
		{
			return WidthField;
		}
		set
		{
			if (!WidthField.Equals(value))
			{
				WidthField = value;
				RaisePropertyChanged("Width");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
