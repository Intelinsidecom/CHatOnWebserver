using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[KnownType(typeof(Rectangle))]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[KnownType(typeof(Circle))]
[DebuggerStepThrough]
[KnownType(typeof(Polygon))]
[DataContract(Name = "ShapeBase", Namespace = "http://dev.virtualearth.net/webservices/v1/common")]
[KnownType(typeof(SearchPoint))]
internal class ShapeBase : INotifyPropertyChanged
{
	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
