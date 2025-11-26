using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DataContract(Name = "RangeOfint", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[DebuggerStepThrough]
internal class RangeOfint : INotifyPropertyChanged
{
	private int FromField;

	private int ToField;

	[DataMember]
	internal int From
	{
		get
		{
			return FromField;
		}
		set
		{
			if (!FromField.Equals(value))
			{
				FromField = value;
				RaisePropertyChanged("From");
			}
		}
	}

	[DataMember]
	internal int To
	{
		get
		{
			return ToField;
		}
		set
		{
			if (!ToField.Equals(value))
			{
				ToField = value;
				RaisePropertyChanged("To");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
