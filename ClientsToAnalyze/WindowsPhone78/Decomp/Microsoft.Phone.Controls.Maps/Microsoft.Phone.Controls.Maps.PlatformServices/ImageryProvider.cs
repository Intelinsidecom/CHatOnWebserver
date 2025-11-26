using System.CodeDom.Compiler;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DataContract(Name = "ImageryProvider", Namespace = "http://dev.virtualearth.net/webservices/v1/imagery")]
[DebuggerStepThrough]
internal class ImageryProvider : INotifyPropertyChanged
{
	private string AttributionField;

	private Collection<CoverageArea> CoverageAreasField;

	[DataMember]
	internal string Attribution
	{
		get
		{
			return AttributionField;
		}
		set
		{
			if (!object.ReferenceEquals(AttributionField, value))
			{
				AttributionField = value;
				RaisePropertyChanged("Attribution");
			}
		}
	}

	[DataMember]
	internal Collection<CoverageArea> CoverageAreas
	{
		get
		{
			return CoverageAreasField;
		}
		set
		{
			if (!object.ReferenceEquals(CoverageAreasField, value))
			{
				CoverageAreasField = value;
				RaisePropertyChanged("CoverageAreas");
			}
		}
	}

	public event PropertyChangedEventHandler PropertyChanged;

	protected void RaisePropertyChanged(string propertyName)
	{
		this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
	}
}
