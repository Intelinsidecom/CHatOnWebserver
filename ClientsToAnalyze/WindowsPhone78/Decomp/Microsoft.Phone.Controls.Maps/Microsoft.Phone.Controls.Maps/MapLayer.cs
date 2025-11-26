using System;
using System.Device.Location;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Controls;
using System.Windows.Media;
using Microsoft.Phone.Controls.Maps.AutomationPeers;
using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps;

public sealed class MapLayer : MapLayerBase, IProjectable
{
	private Guid lastProjectPassTag;

	private ProjectionUpdateLevel pendingUpdate = ProjectionUpdateLevel.Full;

	public static readonly DependencyProperty PositionProperty = DependencyProperty.RegisterAttached("Position", typeof(GeoCoordinate), typeof(MapLayer), new PropertyMetadata(OnPositionChanged));

	public static readonly DependencyProperty PositionRectangleProperty = DependencyProperty.RegisterAttached("PositionRectangle", typeof(LocationRect), typeof(MapLayer), new PropertyMetadata(OnPositionRectangleChanged));

	public static readonly DependencyProperty PositionOriginProperty = DependencyProperty.RegisterAttached("PositionOrigin", typeof(PositionOrigin), typeof(MapLayer), new PropertyMetadata(OnPositionOriginChanged));

	public static readonly DependencyProperty PositionOffsetProperty = DependencyProperty.RegisterAttached("PositionOffset", typeof(Point), typeof(MapLayer), new PropertyMetadata(OnPositionOffsetChanged));

	private static readonly DependencyProperty ProjectionUpdatedTag = DependencyProperty.RegisterAttached("ProjectionUpdatedTagProperty", typeof(Guid), typeof(MapLayer), null);

	public MapBase ParentMap
	{
		get
		{
			if (base.Parent is IProjectable projectable)
			{
				return projectable.ParentMap;
			}
			if (base.Parent is MapBase result)
			{
				return result;
			}
			if (VisualTreeHelper.GetParent(this) is ItemsPresenter reference && VisualTreeHelper.GetParent(reference) is IProjectable projectable2)
			{
				return projectable2.ParentMap;
			}
			return null;
		}
	}

	public override void AddChild(UIElement element, GeoCoordinate location)
	{
		base.Children.Add(element);
		element.SetValue(PositionProperty, location);
	}

	public override void AddChild(UIElement element, GeoCoordinate location, Point offset)
	{
		base.Children.Add(element);
		element.SetValue(PositionProperty, location);
		element.SetValue(PositionOffsetProperty, offset);
	}

	public override void AddChild(UIElement element, GeoCoordinate location, PositionOrigin origin)
	{
		base.Children.Add(element);
		element.SetValue(PositionProperty, location);
		element.SetValue(PositionOriginProperty, origin);
	}

	public override void AddChild(UIElement element, LocationRect locationRect)
	{
		base.Children.Add(element);
		element.SetValue(PositionRectangleProperty, locationRect);
	}

	public static GeoCoordinate GetPosition(DependencyObject dependencyObject)
	{
		GeoCoordinate geoCoordinate = (GeoCoordinate)dependencyObject.GetValue(PositionProperty);
		if (geoCoordinate == null && dependencyObject is ContentPresenter && VisualTreeHelper.GetChildrenCount(dependencyObject) > 0)
		{
			DependencyObject child = VisualTreeHelper.GetChild(dependencyObject, 0);
			if (child != null)
			{
				geoCoordinate = GetPosition(child);
			}
		}
		return geoCoordinate;
	}

	public static void SetPosition(DependencyObject dependencyObject, GeoCoordinate position)
	{
		dependencyObject.SetValue(PositionProperty, position);
	}

	private static void OnPositionChanged(DependencyObject dependencyObject, DependencyPropertyChangedEventArgs ea)
	{
		InvalidateParentLayout(dependencyObject);
	}

	public static LocationRect GetPositionRectangle(DependencyObject dependencyObject)
	{
		LocationRect locationRect = (LocationRect)dependencyObject.GetValue(PositionRectangleProperty);
		if (locationRect == null && dependencyObject is ContentPresenter && VisualTreeHelper.GetChildrenCount(dependencyObject) > 0)
		{
			DependencyObject child = VisualTreeHelper.GetChild(dependencyObject, 0);
			if (child != null)
			{
				locationRect = GetPositionRectangle(child);
			}
		}
		return locationRect;
	}

	public static void SetPositionRectangle(DependencyObject dependencyObject, LocationRect rect)
	{
		dependencyObject.SetValue(PositionRectangleProperty, rect);
	}

	private static void OnPositionRectangleChanged(DependencyObject dependencyObject, DependencyPropertyChangedEventArgs ea)
	{
		InvalidateParentLayout(dependencyObject);
	}

	public static PositionOrigin GetPositionOrigin(DependencyObject dependencyObject)
	{
		PositionOrigin result = (PositionOrigin)dependencyObject.GetValue(PositionOriginProperty);
		if (dependencyObject is ContentPresenter && VisualTreeHelper.GetChildrenCount(dependencyObject) > 0)
		{
			DependencyObject child = VisualTreeHelper.GetChild(dependencyObject, 0);
			if (child != null)
			{
				result = GetPositionOrigin(child);
			}
		}
		return result;
	}

	public static void SetPositionOrigin(DependencyObject dependencyObject, PositionOrigin origin)
	{
		dependencyObject.SetValue(PositionOriginProperty, origin);
	}

	private static void OnPositionOriginChanged(DependencyObject dependencyObject, DependencyPropertyChangedEventArgs ea)
	{
		InvalidateParentLayout(dependencyObject);
	}

	public static Point GetPositionOffset(DependencyObject dependencyObject)
	{
		Point result = (Point)dependencyObject.GetValue(PositionOffsetProperty);
		if (dependencyObject is ContentPresenter && VisualTreeHelper.GetChildrenCount(dependencyObject) > 0)
		{
			DependencyObject child = VisualTreeHelper.GetChild(dependencyObject, 0);
			if (child != null)
			{
				result = GetPositionOffset(child);
			}
		}
		return result;
	}

	public static void SetPositionOffset(DependencyObject dependencyObject, Point point)
	{
		dependencyObject.SetValue(PositionOffsetProperty, point);
	}

	private static void OnPositionOffsetChanged(DependencyObject dependencyObject, DependencyPropertyChangedEventArgs ea)
	{
		InvalidateParentLayout(dependencyObject);
	}

	public void ProjectionUpdated(ProjectionUpdateLevel updateLevel)
	{
		if (updateLevel != ProjectionUpdateLevel.None)
		{
			InvalidateArrange();
			InvalidateMeasure();
			pendingUpdate |= updateLevel;
		}
	}

	protected override Size MeasureOverride(Size availableSize)
	{
		MapBase parentMap = ParentMap;
		if (parentMap != null)
		{
			Guid guid = lastProjectPassTag;
			lastProjectPassTag = Guid.NewGuid();
			foreach (UIElement child in base.Children)
			{
				if (child is IProjectable projectable)
				{
					ProjectionUpdateLevel projectionUpdateLevel = pendingUpdate;
					if ((Guid)child.GetValue(ProjectionUpdatedTag) != guid)
					{
						projectionUpdateLevel = ProjectionUpdateLevel.Full;
					}
					if (projectionUpdateLevel != ProjectionUpdateLevel.None)
					{
						projectable.ProjectionUpdated(projectionUpdateLevel);
					}
					child.SetValue(ProjectionUpdatedTag, lastProjectPassTag);
				}
			}
			pendingUpdate = ProjectionUpdateLevel.None;
			foreach (UIElement child2 in base.Children)
			{
				LocationRect positionRectangle = GetPositionRectangle(child2);
				if (positionRectangle != null)
				{
					Rect rect = parentMap.Mode.LocationToViewportPoint(positionRectangle);
					child2.Measure(new Size(rect.Width, rect.Height));
					continue;
				}
				if (child2 is ContentPresenter && VisualTreeHelper.GetChildrenCount(child2) > 0 && VisualTreeHelper.GetChild(child2, 0) is IProjectable projectable2)
				{
					projectable2.ProjectionUpdated(ProjectionUpdateLevel.Full);
					if (projectable2 is UIElement uIElement)
					{
						uIElement.InvalidateMeasure();
					}
				}
				child2.Measure(parentMap.ViewportSize);
			}
			return parentMap.ViewportSize;
		}
		return new Size(0.0, 0.0);
	}

	protected override Size ArrangeOverride(Size finalSize)
	{
		MapBase parentMap = ParentMap;
		if (parentMap != null)
		{
			foreach (UIElement child in base.Children)
			{
				Rect finalRect = new Rect(0.0, 0.0, parentMap.ViewportSize.Width, parentMap.ViewportSize.Height);
				LocationRect positionRectangle = GetPositionRectangle(child);
				if (positionRectangle != null)
				{
					finalRect = parentMap.Mode.LocationToViewportPoint(positionRectangle);
				}
				else
				{
					GeoCoordinate position = GetPosition(child);
					if (position != null && parentMap.TryLocationToViewportPoint(position, out var viewportPoint))
					{
						PositionOrigin positionOrigin = GetPositionOrigin(child);
						viewportPoint.X -= positionOrigin.X * child.DesiredSize.Width;
						viewportPoint.Y -= positionOrigin.Y * child.DesiredSize.Height;
						if (Math.Abs(viewportPoint.X) > 100000.0)
						{
							viewportPoint.X = Math.Sign(viewportPoint.X) * 100000;
						}
						if (Math.Abs(viewportPoint.Y) > 100000.0)
						{
							viewportPoint.Y = Math.Sign(viewportPoint.Y) * 100000;
						}
						finalRect = new Rect(viewportPoint.X, viewportPoint.Y, child.DesiredSize.Width, child.DesiredSize.Height);
					}
				}
				Point positionOffset = GetPositionOffset(child);
				finalRect.X += positionOffset.X;
				finalRect.Y += positionOffset.Y;
				child.Arrange(finalRect);
			}
		}
		return parentMap?.ViewportSize ?? new Size(0.0, 0.0);
	}

	private static void InvalidateParentLayout(DependencyObject dependencyObject)
	{
		if (dependencyObject is FrameworkElement frameworkElement)
		{
			MapLayer mapLayer = frameworkElement.Parent as MapLayer;
			if (mapLayer == null && frameworkElement.Parent is ContentPresenter contentPresenter)
			{
				mapLayer = contentPresenter.Parent as MapLayer;
			}
			if (mapLayer != null)
			{
				mapLayer.InvalidateMeasure();
				mapLayer.InvalidateArrange();
			}
		}
	}

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new BaseAutomationPeer(this, "MapLayer");
	}
}
