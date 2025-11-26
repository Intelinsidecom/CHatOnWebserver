using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[DebuggerStepThrough]
[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DataContract(Name = "CoverageArea", Namespace = "http://dev.virtualearth.net/webservices/v1/imagery")]
internal class CoverageArea : INotifyPropertyChanged
{
	private Rectangle BoundingRectangleField;

	private RangeOfint ZoomRangeField;

	[DataMember]
	internal Rectangle BoundingRectangle
	{
		get
		{
			return BoundingRectangleField;
		}
		set
		{
			if (!object.ReferenceEquals(BoundingRectangleField, value))
			{
				BoundingRectangleField = value;
				RaisePropertyChanged("BoundingRectangle");
			}
		}
	}

	[DataMember]
	internal RangeOfint ZoomRange
	{
		get
		{
			return ZoomRangeField;
		}
		set
		{
			if (!object.ReferenceEquals(ZoomRangeField, value))
			{
				ZoomRangeField = value;
				RaisePropertyChanged("ZoomRange");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
