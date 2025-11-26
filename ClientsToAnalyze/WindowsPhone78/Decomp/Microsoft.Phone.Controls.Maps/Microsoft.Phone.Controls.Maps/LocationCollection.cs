using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Device.Location;
using Microsoft.Phone.Controls.Maps.Design;

namespace Microsoft.Phone.Controls.Maps;

[TypeConverter(typeof(LocationCollectionConverter))]
public class LocationCollection : ObservableCollection<GeoCoordinate>
{
}
