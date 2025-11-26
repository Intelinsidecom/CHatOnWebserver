using System.Collections.ObjectModel;
using System.Collections.Specialized;

namespace Microsoft.Phone.Controls.Maps;

public class AttributionCollection : ReadOnlyObservableCollection<AttributionInfo>
{
	public new event NotifyCollectionChangedEventHandler CollectionChanged;

	public AttributionCollection(ObservableCollection<AttributionInfo> list)
		: base(list)
	{
	}

	protected override void OnCollectionChanged(NotifyCollectionChangedEventArgs args)
	{
		base.OnCollectionChanged(args);
		if (this.CollectionChanged != null)
		{
			this.CollectionChanged(this, args);
		}
	}
}
