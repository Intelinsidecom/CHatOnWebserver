using System;
using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DataContract(Name = "RangeOfdateTime", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[DebuggerStepThrough]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal class RangeOfdateTime : INotifyPropertyChanged
{
	private DateTime FromField;

	private DateTime ToField;

	[DataMember]
	internal DateTime From
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
	internal DateTime To
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
