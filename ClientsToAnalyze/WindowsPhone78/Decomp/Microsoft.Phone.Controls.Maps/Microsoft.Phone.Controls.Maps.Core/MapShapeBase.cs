using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Controls;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Shapes;
using Microsoft.Phone.Controls.Maps.AutomationPeers;

namespace Microsoft.Phone.Controls.Maps.Core;

[TemplatePart(Name = "ContentGrid", Type = typeof(Grid))]
[ContentProperty("Content")]
[TemplatePart(Name = "EmbeddedShape", Type = typeof(Shape))]
public abstract class MapShapeBase : ContentControl, IProjectable
{
	internal const string ContentGridElementName = "ContentGrid";

	internal const string EmbeddedShapeElementName = "EmbeddedShape";

	private Grid contentGrid;

	private ProjectionUpdateLevel pendingUpdate = ProjectionUpdateLevel.Full;

	private Shape shape;

	private Point topLeftViewportPoint;

	private static readonly DependencyProperty LocationsProperty = DependencyProperty.Register("Locations", typeof(LocationCollection), typeof(MapShapeBase), new PropertyMetadata(Locations_Changed));

	public Brush Fill
	{
		get
		{
			return EmbeddedShape.Fill;
		}
		set
		{
			if (EmbeddedShape != null)
			{
				EmbeddedShape.Fill = value;
			}
		}
	}

	public Brush Stroke
	{
		get
		{
			return EmbeddedShape.Stroke;
		}
		set
		{
			if (EmbeddedShape != null)
			{
				EmbeddedShape.Stroke = value;
			}
		}
	}

	public double StrokeThickness
	{
		get
		{
			return EmbeddedShape.StrokeThickness;
		}
		set
		{
			if (EmbeddedShape != null)
			{
				EmbeddedShape.StrokeThickness = value;
			}
		}
	}

	public DoubleCollection StrokeDashArray
	{
		get
		{
			return EmbeddedShape.StrokeDashArray;
		}
		set
		{
			if (EmbeddedShape != null)
			{
				EmbeddedShape.StrokeDashArray = value;
			}
		}
	}

	public PenLineCap StrokeDashCap
	{
		get
		{
			return EmbeddedShape.StrokeDashCap;
		}
		set
		{
			if (EmbeddedShape != null)
			{
				EmbeddedShape.StrokeDashCap = value;
			}
		}
	}

	public double StrokeDashOffset
	{
		get
		{
			return EmbeddedShape.StrokeDashOffset;
		}
		set
		{
			if (EmbeddedShape != null)
			{
				EmbeddedShape.StrokeDashOffset = value;
			}
		}
	}

	public PenLineCap StrokeEndLineCap
	{
		get
		{
			return EmbeddedShape.StrokeEndLineCap;
		}
		set
		{
			if (EmbeddedShape != null)
			{
				EmbeddedShape.StrokeEndLineCap = value;
			}
		}
	}

	public PenLineJoin StrokeLineJoin
	{
		get
		{
			return EmbeddedShape.StrokeLineJoin;
		}
		set
		{
			if (EmbeddedShape != null)
			{
				EmbeddedShape.StrokeLineJoin = value;
			}
		}
	}

	public double StrokeMiterLimit
	{
		get
		{
			return EmbeddedShape.StrokeMiterLimit;
		}
		set
		{
			if (EmbeddedShape != null)
			{
				EmbeddedShape.StrokeMiterLimit = value;
			}
		}
	}

	public PenLineCap StrokeStartLineCap
	{
		get
		{
			return EmbeddedShape.StrokeStartLineCap;
		}
		set
		{
			if (EmbeddedShape != null)
			{
				EmbeddedShape.StrokeStartLineCap = value;
			}
		}
	}

	public LocationCollection Locations
	{
		get
		{
			return (LocationCollection)GetValue(LocationsProperty);
		}
		set
		{
			SetValue(LocationsProperty, value);
		}
	}

	protected abstract PointCollection ProjectedPoints { get; set; }

	protected Shape EmbeddedShape
	{
		get
		{
			return shape;
		}
		set
		{
			if (value != null)
			{
				SetEmbeddedShape(value);
			}
		}
	}

	public MapBase ParentMap
	{
		get
		{
			IProjectable projectable = base.Parent as IProjectable;
			if (projectable == null && VisualTreeHelper.GetParent(this) is ContentPresenter reference)
			{
				projectable = VisualTreeHelper.GetParent(reference) as IProjectable;
			}
			return projectable?.ParentMap;
		}
	}

	protected MapShapeBase()
	{
		base.UseLayoutRounding = false;
		contentGrid = new Grid();
	}

	private static void Locations_Changed(DependencyObject o, DependencyPropertyChangedEventArgs ea)
	{
		if (o is MapShapeBase mapShapeBase)
		{
			if (ea.OldValue is LocationCollection locationCollection)
			{
				locationCollection.CollectionChanged -= mapShapeBase.Locations_CollectionChanged;
			}
			if (ea.NewValue is LocationCollection locationCollection2)
			{
				locationCollection2.CollectionChanged += mapShapeBase.Locations_CollectionChanged;
			}
			mapShapeBase.ProjectionUpdated(ProjectionUpdateLevel.Full);
		}
	}

	private void Locations_CollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
	{
		ProjectionUpdated(ProjectionUpdateLevel.Full);
	}

	protected virtual void SetEmbeddedShape(Shape newShape)
	{
		if (shape != null)
		{
			newShape.Fill = shape.Fill;
			newShape.Stroke = shape.Stroke;
			newShape.StrokeThickness = shape.StrokeThickness;
			foreach (double item in shape.StrokeDashArray)
			{
				double value = item;
				newShape.StrokeDashArray.Add(value);
			}
			newShape.StrokeDashCap = shape.StrokeDashCap;
			newShape.StrokeDashOffset = shape.StrokeDashOffset;
			newShape.StrokeEndLineCap = shape.StrokeEndLineCap;
			newShape.StrokeLineJoin = shape.StrokeLineJoin;
			newShape.StrokeMiterLimit = shape.StrokeMiterLimit;
			newShape.StrokeStartLineCap = shape.StrokeStartLineCap;
		}
		else
		{
			contentGrid.Children.Add(newShape);
		}
		shape = newShape;
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		contentGrid = GetTemplateChild("ContentGrid") as Grid;
		EmbeddedShape = GetTemplateChild("EmbeddedShape") as Shape;
		if (contentGrid != null)
		{
			contentGrid.UseLayoutRounding = base.UseLayoutRounding;
		}
	}

	public void ProjectionUpdated(ProjectionUpdateLevel updateLevel)
	{
		if (updateLevel != ProjectionUpdateLevel.None)
		{
			InvalidateMeasure();
			InvalidateArrange();
			pendingUpdate |= updateLevel;
		}
	}

	protected override Size MeasureOverride(Size availableSize)
	{
		MapBase parentMap = ParentMap;
		if (pendingUpdate != ProjectionUpdateLevel.None && parentMap != null)
		{
			if (Locations != null)
			{
				if (pendingUpdate == ProjectionUpdateLevel.Full && Locations.Count > 0)
				{
					PointCollection pointCollection = new PointCollection();
					Point point = new Point(double.MaxValue, double.MaxValue);
					IEnumerable<Point> enumerable = parentMap.Mode.LocationToViewportPoint(Locations);
					foreach (Point item in enumerable)
					{
						point.X = Math.Min(point.X, item.X);
						point.Y = Math.Min(point.Y, item.Y);
						pointCollection.Add(item);
					}
					for (int i = 0; i < pointCollection.Count; i++)
					{
						pointCollection[i] = new Point(pointCollection[i].X - point.X, pointCollection[i].Y - point.Y);
					}
					ProjectedPoints = pointCollection;
				}
				if (ProjectedPoints.Count > 0 && Locations.Count > 0 && parentMap.TryLocationToViewportPoint(Locations[0], out var viewportPoint))
				{
					topLeftViewportPoint = new Point(viewportPoint.X - ProjectedPoints[0].X, viewportPoint.Y - ProjectedPoints[0].Y);
				}
			}
			else
			{
				ProjectedPoints.Clear();
			}
			pendingUpdate = ProjectionUpdateLevel.None;
		}
		contentGrid.Measure(new Size(double.MaxValue, double.MaxValue));
		return parentMap?.ViewportSize ?? new Size(0.0, 0.0);
	}

	protected override Size ArrangeOverride(Size finalSize)
	{
		contentGrid.Arrange(new Rect(topLeftViewportPoint.X, topLeftViewportPoint.Y, contentGrid.DesiredSize.Width + 1.0, contentGrid.DesiredSize.Height + 1.0));
		return ParentMap?.ViewportSize ?? new Size(0.0, 0.0);
	}

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new BaseAutomationPeer(this, "MapShape");
	}
}
