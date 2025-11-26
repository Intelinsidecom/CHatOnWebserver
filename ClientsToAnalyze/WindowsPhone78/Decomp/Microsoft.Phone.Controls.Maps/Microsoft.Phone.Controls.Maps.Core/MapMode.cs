using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Device.Location;
using System.Globalization;
using System.Linq;
using System.Windows;

namespace Microsoft.Phone.Controls.Maps.Core;

public abstract class MapMode
{
	private static readonly Range<double> defaultZoomRange = new Range<double>(1.0, 21.0);

	private static readonly Range<double> defaultHeadingRange = new Range<double>(0.0, 360.0);

	private static readonly Range<double> defaultPitchRange = new Range<double>(-90.0, 90.0);

	private readonly AttributionCollection attributions = new AttributionCollection(new ObservableCollection<AttributionInfo>());

	private CultureInfo culture;

	public CultureInfo Culture
	{
		get
		{
			if (culture != null)
			{
				return culture;
			}
			return CultureInfo.CurrentUICulture;
		}
		set
		{
			culture = value;
			OnCultureChanged();
		}
	}

	public virtual GeoCoordinate Center { get; set; }

	public virtual GeoCoordinate TargetCenter => Center;

	public virtual double ZoomLevel { get; set; }

	public virtual double TargetZoomLevel => ZoomLevel;

	public virtual double Heading { get; set; }

	public virtual double TargetHeading => Heading;

	public virtual double Pitch { get; set; }

	public virtual double TargetPitch => Pitch;

	public virtual double Scale { get; set; }

	public virtual double TargetScale => Scale;

	public virtual Range<double> ZoomRange => defaultZoomRange;

	public virtual Range<double> HeadingRange => defaultHeadingRange;

	public virtual Range<double> PitchRange => defaultPitchRange;

	public virtual LocationRect BoundingRectangle => LocationRect.CreateLocationRect(ViewportPointToLocation(new Point(0.0, 0.0)), ViewportPointToLocation(new Point(0.0, ViewportSize.Height)), ViewportPointToLocation(new Point(ViewportSize.Width, ViewportSize.Height)), ViewportPointToLocation(new Point(ViewportSize.Width, 0.0)));

	public virtual LocationRect TargetBoundingRectangle => BoundingRectangle;

	public virtual AttributionCollection Attributions => attributions;

	public Size ViewportSize { get; set; }

	public AnimationLevel AnimationLevel { get; set; }

	public virtual CredentialsProvider CredentialsProvider { get; set; }

	public virtual bool IsDownloading => false;

	public virtual bool IsIdle => true;

	public virtual UIElement Content => null;

	public virtual UIElement ForegroundContent => null;

	public virtual ModeBackground ModeBackground => ModeBackground.Dark;

	public event EventHandler<MapEventArgs> TargetViewChanged;

	public event EventHandler<ProjectionChangedEventArgs> ProjectionChanged;

	public abstract void SetView(GeoCoordinate center, double zoomLevel, double heading, double pitch, bool animate);

	public abstract void SetView(LocationRect boundingRectangle, bool animate);

	public abstract Point LocationToViewportPoint(GeoCoordinate location);

	public virtual IEnumerable<Point> LocationToViewportPoint(IEnumerable<GeoCoordinate> locations)
	{
		return locations.Select((GeoCoordinate location) => LocationToViewportPoint(location));
	}

	public virtual Rect LocationToViewportPoint(LocationRect boundingRectangle)
	{
		Point point = LocationToViewportPoint(boundingRectangle.Northwest);
		Point point2 = LocationToViewportPoint(boundingRectangle.Southeast);
		return new Rect(point, point2);
	}

	public abstract bool TryLocationToViewportPoint(GeoCoordinate location, out Point viewportPoint);

	public abstract GeoCoordinate ViewportPointToLocation(Point viewportPoint);

	public abstract bool TryViewportPointToLocation(Point viewportPoint, out GeoCoordinate location);

	public virtual void OnMapDrag(MapDragEventArgs e)
	{
	}

	public virtual void OnMapFlick(MapFlickEventArgs e)
	{
	}

	public virtual void OnMapZoom(MapZoomEventArgs e)
	{
	}

	public virtual void Activating(MapMode previousMode, MapLayerBase modeLayer, MapLayerBase modeForegroundLayer)
	{
	}

	public virtual void Activated(MapLayerBase modeLayer, MapLayerBase modeForegroundLayer)
	{
	}

	public virtual void Deactivating()
	{
	}

	public virtual void ViewportSizeChanged(Size viewportSize)
	{
		ViewportSize = viewportSize;
	}

	protected virtual void OnTargetViewChanged()
	{
		this.TargetViewChanged?.Invoke(this, new MapEventArgs());
	}

	protected virtual void OnProjectionChanged(ProjectionUpdateLevel updateLevel)
	{
		this.ProjectionChanged?.Invoke(this, new ProjectionChangedEventArgs(updateLevel));
	}

	protected virtual void OnCultureChanged()
	{
	}
}
