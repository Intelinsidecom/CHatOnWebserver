using System;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Controls;
using System.Windows.Media;
using Microsoft.Phone.Controls.Maps.AutomationPeers;
using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps;

[TemplatePart(Name = "ContentGrid", Type = typeof(Grid))]
public sealed class MapTileLayer : Control, IProjectable
{
	internal const string ContentGridElementName = "ContentGrid";

	private const double offsetPixels = 0.75;

	private readonly Collection<MultiScaleImage> msiCollection;

	private readonly MapMode parentMode;

	private readonly TileSourceCollection tileSources;

	private readonly WeakEventListener<MapTileLayer, object, NotifyCollectionChangedEventArgs> weakCollectionListener;

	private readonly WeakEventListener<MapTileLayer, object, TileSourcePropertyChangedEventArgs> weakItemListener;

	private Grid contentGrid;

	private int tileHeight = 256;

	private int tileWidth = 256;

	private bool updated;

	public static readonly DependencyProperty UpSampleLevelDeltaProperty = DependencyProperty.Register("UpSampleLevelDelta", typeof(int), typeof(MapTileLayer), new PropertyMetadata(int.MaxValue));

	public int TileWidth
	{
		get
		{
			return tileWidth;
		}
		set
		{
			tileWidth = value;
			RefreshSource();
		}
	}

	public int TileHeight
	{
		get
		{
			return tileHeight;
		}
		set
		{
			tileHeight = value;
			RefreshSource();
		}
	}

	public TileSourceCollection TileSources => tileSources;

	public int UpSampleLevelDelta
	{
		get
		{
			return (int)GetValue(UpSampleLevelDeltaProperty);
		}
		set
		{
			SetValue(UpSampleLevelDeltaProperty, value);
		}
	}

	internal bool IsDownloading
	{
		get
		{
			foreach (UIElement child in contentGrid.Children)
			{
				if (child is MultiScaleImage { Visibility: Visibility.Visible, IsDownloading: not false })
				{
					return true;
				}
			}
			return false;
		}
	}

	internal bool IsIdle
	{
		get
		{
			if (!updated)
			{
				return false;
			}
			foreach (UIElement child in contentGrid.Children)
			{
				if (child is MultiScaleImage { Visibility: Visibility.Visible, IsIdle: false })
				{
					return false;
				}
			}
			return true;
		}
	}

	public MapBase ParentMap
	{
		get
		{
			if (base.Parent is IProjectable projectable)
			{
				return projectable.ParentMap;
			}
			return base.Parent as MapBase;
		}
	}

	private MapMode ParentMode
	{
		get
		{
			if (parentMode != null)
			{
				return parentMode;
			}
			return ParentMap?.Mode;
		}
	}

	private Size ViewportSize
	{
		get
		{
			if (parentMode != null)
			{
				return parentMode.ViewportSize;
			}
			return ParentMap?.ViewportSize ?? new Size(0.0, 0.0);
		}
	}

	public MapTileLayer()
	{
		base.DefaultStyleKey = typeof(MapTileLayer);
		base.IsHitTestVisible = false;
		contentGrid = new Grid();
		tileSources = new TileSourceCollection();
		weakItemListener = new WeakEventListener<MapTileLayer, object, TileSourcePropertyChangedEventArgs>(this);
		weakItemListener.OnEventAction = delegate(MapTileLayer instance, object source, TileSourcePropertyChangedEventArgs eventArgs)
		{
			instance.TileSources_ItemPropertyChanged(source, eventArgs);
		};
		tileSources.ItemPropertyChanged += weakItemListener.OnEvent;
		weakCollectionListener = new WeakEventListener<MapTileLayer, object, NotifyCollectionChangedEventArgs>(this);
		weakCollectionListener.OnEventAction = delegate(MapTileLayer instance, object source, NotifyCollectionChangedEventArgs eventArgs)
		{
			instance.TileSources_CollectionChanged(source, eventArgs);
		};
		tileSources.CollectionChanged += weakCollectionListener.OnEvent;
		msiCollection = new Collection<MultiScaleImage>();
	}

	internal MapTileLayer(MapMode mode)
		: this()
	{
		parentMode = mode;
		parentMode.ProjectionChanged += ParentMode_ProjectionChanged;
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		contentGrid = GetTemplateChild("ContentGrid") as Grid;
	}

	internal void RefreshSource()
	{
		foreach (MultiScaleImage item in msiCollection)
		{
			item.Source = new MultiScaleQuadTileSource(TileSources, TileWidth, TileHeight);
		}
		InvalidateMeasure();
	}

	public void ProjectionUpdated(ProjectionUpdateLevel updateLevel)
	{
		if (parentMode == null)
		{
			InvalidateMeasure();
			InvalidateArrange();
		}
	}

	protected override Size MeasureOverride(Size availableSize)
	{
		UpdateMSI();
		contentGrid.Measure(ViewportSize);
		return ViewportSize;
	}

	private void ParentMode_ProjectionChanged(object sender, ProjectionChangedEventArgs e)
	{
		InvalidateMeasure();
		InvalidateArrange();
	}

	private MultiScaleImage CreateMSI()
	{
		MultiScaleImage multiScaleImage = new MultiScaleImage();
		multiScaleImage.ViewportWidth = 1.0;
		multiScaleImage.ViewportOrigin = default(Point);
		multiScaleImage.UseSprings = false;
		multiScaleImage.CacheMode = new BitmapCache();
		multiScaleImage.Source = new MultiScaleQuadTileSource(TileSources, TileWidth, TileHeight);
		return multiScaleImage;
	}

	private MultiScaleImage GetMSI(int key)
	{
		MultiScaleImage multiScaleImage = null;
		if (msiCollection.Count <= key)
		{
			multiScaleImage = CreateMSI();
			msiCollection.Add(multiScaleImage);
		}
		else
		{
			multiScaleImage = msiCollection[key];
		}
		if (!contentGrid.Children.Contains(multiScaleImage))
		{
			contentGrid.Children.Add(multiScaleImage);
		}
		return multiScaleImage;
	}

	private void UpdateMSI()
	{
		if (ParentMode is FlatMapMode flatMapMode)
		{
			contentGrid.Visibility = Visibility.Visible;
			Rect rect = new Rect(flatMapMode.ViewportPointToLogicalPoint(new Point(0.0, 0.0)), flatMapMode.ViewportPointToLogicalPoint(new Point(ViewportSize.Width, ViewportSize.Height)));
			double zoomLevel = flatMapMode.ZoomLevel;
			int num = (int)Math.Floor(zoomLevel);
			double blurFactor = Math.Pow(2.0, zoomLevel - (double)num);
			bool flag = Math.Round(zoomLevel) == zoomLevel;
			bool leftCenter = false;
			bool rightCenter = false;
			if (flag)
			{
				Size size = new Size(rect.Width / ViewportSize.Width, rect.Height / ViewportSize.Height);
				rect.X = Math.Round(rect.X / size.Width) * size.Width;
				rect.Y = Math.Round(rect.Y / size.Height) * size.Height;
			}
			double num2 = rect.X - Math.Floor((rect.X + rect.Width / 2.0 + 0.5) / 2.0) * 2.0;
			if (!flag)
			{
				if (0.0 > num2 + rect.Width / 2.0)
				{
					leftCenter = true;
				}
				else if (1.0 < num2 + rect.Width / 2.0)
				{
					rightCenter = true;
				}
			}
			int minTileZoomLevel = num - UpSampleLevelDelta;
			MultiScaleImage mSI = GetMSI(0);
			((MultiScaleQuadTileSource)mSI.Source).MinTileZoomLevel = minTileZoomLevel;
			mSI.ViewportWidth = rect.Width;
			mSI.ViewportOrigin = new Point(num2, rect.Y);
			mSI.BlurFactor = blurFactor;
			mSI.RenderTransform = GetRenderTransform(mSI, 0, flag, leftCenter, rightCenter);
			int i = 1;
			for (int j = 1; (double)j + num2 < 1.0; j++)
			{
				mSI = GetMSI(i);
				((MultiScaleQuadTileSource)mSI.Source).MinTileZoomLevel = minTileZoomLevel;
				mSI.ViewportWidth = rect.Width;
				mSI.ViewportOrigin = new Point(num2 + (double)j, rect.Y);
				mSI.BlurFactor = blurFactor;
				mSI.RenderTransform = GetRenderTransform(mSI, -j, flag, leftCenter, rightCenter);
				i++;
			}
			for (int j = 1; (double)j < rect.Width + num2; j++)
			{
				mSI = GetMSI(i);
				((MultiScaleQuadTileSource)mSI.Source).MinTileZoomLevel = minTileZoomLevel;
				mSI.ViewportWidth = rect.Width;
				mSI.ViewportOrigin = new Point(num2 - (double)j, rect.Y);
				mSI.BlurFactor = blurFactor;
				mSI.RenderTransform = GetRenderTransform(mSI, j, flag, leftCenter, rightCenter);
				i++;
			}
			for (; i < msiCollection.Count; i++)
			{
				mSI = msiCollection[i];
				contentGrid.Children.Remove(mSI);
			}
		}
		else
		{
			contentGrid.Visibility = Visibility.Collapsed;
		}
		updated = true;
	}

	private static Transform GetRenderTransform(MultiScaleImage msi, int offset, bool atIntegerZoom, bool leftCenter, bool rightCenter)
	{
		TranslateTransform translateTransform = null;
		if (!atIntegerZoom)
		{
			translateTransform = msi.RenderTransform as TranslateTransform;
			if (translateTransform == null)
			{
				translateTransform = (TranslateTransform)(msi.RenderTransform = new TranslateTransform());
			}
			if (leftCenter)
			{
				translateTransform.X = (double)(-offset - 1) * 0.75;
			}
			else if (rightCenter)
			{
				translateTransform.X = (double)(-offset + 1) * 0.75;
			}
			else
			{
				translateTransform.X = (double)(-offset) * 0.75;
			}
		}
		return translateTransform;
	}

	private void TileSources_ItemPropertyChanged(object sender, TileSourcePropertyChangedEventArgs e)
	{
		updated = false;
		try
		{
			contentGrid.Dispatcher.BeginInvoke(delegate
			{
				RefreshSource();
			});
		}
		catch (Exception)
		{
		}
	}

	private void TileSources_CollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
	{
		updated = false;
		try
		{
			contentGrid.Dispatcher.BeginInvoke(delegate
			{
				RefreshSource();
			});
		}
		catch (Exception)
		{
		}
	}

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new MapTileLayerAutomationPeer(this);
	}
}
