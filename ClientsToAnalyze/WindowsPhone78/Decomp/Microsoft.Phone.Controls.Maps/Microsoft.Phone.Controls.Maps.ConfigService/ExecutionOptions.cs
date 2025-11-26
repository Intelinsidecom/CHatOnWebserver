using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.ConfigService;

[DebuggerStepThrough]
[DataContract(Name = "ExecutionOptions", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
internal class ExecutionOptions : INotifyPropertyChanged
{
	private bool SuppressFaultsField;

	[DataMember]
	internal bool SuppressFaults
	{
		get
		{
			return SuppressFaultsField;
		}
		set
		{
			if (!SuppressFaultsField.Equals(value))
			{
				SuppressFaultsField = value;
				RaisePropertyChanged("SuppressFaults");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
