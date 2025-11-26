using System;
using System.Collections;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.ComponentModel;

namespace Microsoft.Phone.Controls.Maps.Core;

public class TileSourceCollection : ObservableCollection<TileSource>
{
	public event EventHandler<TileSourcePropertyChangedEventArgs> ItemPropertyChanged;

	public TileSourceCollection()
	{
		base.CollectionChanged += TileSourceCollection_CollectionChanged;
	}

	private void TileSourceCollection_CollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
	{
		AddTileSourceEventHandler(e.NewItems);
		RemoveTileSourceEventHandler(e.OldItems);
	}

	private void AddTileSourceEventHandler(IList tileSources)
	{
		if (tileSources == null)
		{
			return;
		}
		foreach (TileSource tileSource in tileSources)
		{
			tileSource.PropertyChanged += TileSource_PropertyChanged;
		}
	}

	private void RemoveTileSourceEventHandler(IList tileSources)
	{
		if (tileSources == null)
		{
			return;
		}
		foreach (TileSource tileSource in tileSources)
		{
			tileSource.PropertyChanged -= TileSource_PropertyChanged;
		}
	}

	private void TileSource_PropertyChanged(object sender, PropertyChangedEventArgs e)
	{
		EventHandler<TileSourcePropertyChangedEventArgs> itemPropertyChanged = this.ItemPropertyChanged;
		if (itemPropertyChanged != null)
		{
			TileSourcePropertyChangedEventArgs e2 = new TileSourcePropertyChangedEventArgs((TileSource)sender, e.PropertyName);
			itemPropertyChanged(this, e2);
		}
	}
}
