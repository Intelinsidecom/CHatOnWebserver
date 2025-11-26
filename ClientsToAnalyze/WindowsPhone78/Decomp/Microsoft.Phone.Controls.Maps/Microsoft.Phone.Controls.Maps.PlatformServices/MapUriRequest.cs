using System.CodeDom.Compiler;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.PlatformServices;

[GeneratedCode("System.Runtime.Serialization", "4.0.0.0")]
[DataContract(Name = "MapUriRequest", Namespace = "http://dev.virtualearth.net/webservices/v1/imagery")]
[DebuggerStepThrough]
internal class MapUriRequest : RequestBase
{
	private Location CenterField;

	private Location MajorRoutesDestinationField;

	private MapUriOptions OptionsField;

	private Collection<Pushpin> PushpinsField;

	[DataMember]
	internal Location Center
	{
		get
		{
			return CenterField;
		}
		set
		{
			if (!object.ReferenceEquals(CenterField, value))
			{
				CenterField = value;
				RaisePropertyChanged("Center");
			}
		}
	}

	[DataMember]
	internal Location MajorRoutesDestination
	{
		get
		{
			return MajorRoutesDestinationField;
		}
		set
		{
			if (!object.ReferenceEquals(MajorRoutesDestinationField, value))
			{
				MajorRoutesDestinationField = value;
				RaisePropertyChanged("MajorRoutesDestination");
			}
		}
	}

	[DataMember]
	internal MapUriOptions Options
	{
		get
		{
			return OptionsField;
		}
		set
		{
			if (!object.ReferenceEquals(OptionsField, value))
			{
				OptionsField = value;
				RaisePropertyChanged("Options");
			}
		}
	}

	[DataMember]
	internal Collection<Pushpin> Pushpins
	{
		get
		{
			return PushpinsField;
		}
		set
		{
			if (!object.ReferenceEquals(PushpinsField, value))
			{
				PushpinsField = value;
				RaisePropertyChanged("Pushpins");
			}
		}
	}
}
