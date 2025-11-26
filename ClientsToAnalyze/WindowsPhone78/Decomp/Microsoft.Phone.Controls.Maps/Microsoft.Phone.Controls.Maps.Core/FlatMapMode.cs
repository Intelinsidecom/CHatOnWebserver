using System;
using System.Collections.Generic;
using System.Device.Location;
using System.Linq;
using System.Windows;
using System.Windows.Media.Animation;

namespace Microsoft.Phone.Controls.Maps.Core;

public abstract class FlatMapMode : MapMode
{
	internal struct FlatMapModeViewportDefinition
	{
		private bool isCalculated;

		private Size logicalAreaSizeInScreenSpaceAtLevel1;

		private Size pixelSize;

		private Point topLeftLogicalPoint;

		private double zoomLevelMinusOne;

		public Size LogicalAreaSizeInScreenSpaceAtLevel1
		{
			get
			{
				return logicalAreaSizeInScreenSpaceAtLevel1;
			}
			set
			{
				logicalAreaSizeInScreenSpaceAtLevel1 = value;
				isCalculated = false;
			}
		}

		public double ZoomLevel
		{
			get
			{
				return zoomLevelMinusOne + 1.0;
			}
			set
			{
				zoomLevelMinusOne = value - 1.0;
				isCalculated = false;
			}
		}

		public Point TopLeftLogicalPoint
		{
			get
			{
				return topLeftLogicalPoint;
			}
			set
			{
				topLeftLogicalPoint = value;
			}
		}

		public void SetTopLeftLogicalPoint(Point focusViewportPoint, Point focusLogicalPoint)
		{
			Recalculate();
			topLeftLogicalPoint = new Point(focusLogicalPoint.X - focusViewportPoint.X * pixelSize.Width, focusLogicalPoint.Y - focusViewportPoint.Y * pixelSize.Height);
		}

		public Point ViewportPointToLogicalPoint(Point viewportPoint)
		{
			Recalculate();
			return new Point(topLeftLogicalPoint.X + viewportPoint.X * pixelSize.Width, topLeftLogicalPoint.Y + viewportPoint.Y * pixelSize.Height);
		}

		public Point LogicalPointToViewportPoint(Point logicalPoint)
		{
			Recalculate();
			return new Point((logicalPoint.X - topLeftLogicalPoint.X) / pixelSize.Width, (logicalPoint.Y - topLeftLogicalPoint.Y) / pixelSize.Height);
		}

		private void Recalculate()
		{
			if (!isCalculated)
			{
				double num = Math.Pow(2.0, zoomLevelMinusOne);
				pixelSize.Width = 1.0 / (logicalAreaSizeInScreenSpaceAtLevel1.Width * num);
				pixelSize.Height = 1.0 / (logicalAreaSizeInScreenSpaceAtLevel1.Height * num);
				isCalculated = true;
			}
		}
	}

	private const double AnimationSnap = 0.0005;

	private const double AnimationExtensionRate = 0.1;

	private const double ZoomLevelSlowdownRangeForPan = 2.0;

	private const double KeyCountWeightCoefficientForAnimationDuration = 10.0;

	private const double SignificantZoomLevelChange = 0.5;

	private static readonly TimeSpan InitialAnimationProgress = new TimeSpan(0, 0, 0, 0, (int)Math.Round(16.666666666666668));

	private static readonly TimeSpan BaseAnimaitonDuration = new TimeSpan(0, 0, 0, 0, 1600);

	private static readonly double AnimationSpringWindup = Math.Log(2000.0, Math.E);

	private static double ZoomDeltaThresholdToSkipAnimation = 0.5;

	private readonly Storyboard animationStoryboard;

	private readonly List<FlatMapModeViewportDefinition> keyDefinitions = new List<FlatMapModeViewportDefinition>();

	private TimeSpan animationDuration;

	private DateTime animationStart;

	private FlatMapModeViewportDefinition currentViewportDefinition;

	private Size lastViewportSize;

	private Size logicalAreaSizeInScreenSpaceAtLevel1;

	private double nextKeyZoomLevel;

	private FlatMapModeViewportDefinition targetViewportDefinition;

	public override GeoCoordinate Center
	{
		get
		{
			Point viewportPoint = new Point(base.ViewportSize.Width / 2.0, base.ViewportSize.Height / 2.0);
			return ViewportPointToLocation(viewportPoint, currentViewportDefinition);
		}
		set
		{
			double zoomLevel = TargetZoomLevel;
			double heading = TargetHeading;
			double pitch = TargetPitch;
			ConstrainView(value, ref zoomLevel, ref heading, ref pitch);
			FlatMapModeViewportDefinition newView = ViewToDefinition(value, zoomLevel);
			SetView(newView, DoAnimation);
		}
	}

	public override GeoCoordinate TargetCenter
	{
		get
		{
			Point viewportPoint = new Point(base.ViewportSize.Width / 2.0, base.ViewportSize.Height / 2.0);
			return ViewportPointToLocation(viewportPoint, targetViewportDefinition);
		}
	}

	public override double ZoomLevel
	{
		get
		{
			return currentViewportDefinition.ZoomLevel;
		}
		set
		{
			GeoCoordinate targetCenter = TargetCenter;
			double zoomLevel = value;
			double heading = TargetHeading;
			double pitch = TargetPitch;
			ConstrainView(targetCenter, ref zoomLevel, ref heading, ref pitch);
			FlatMapModeViewportDefinition newView = ViewToDefinition(targetCenter, zoomLevel);
			SetView(newView, DoAnimation);
		}
	}

	public override double TargetZoomLevel => targetViewportDefinition.ZoomLevel;

	internal FlatMapModeViewportDefinition CurrentViewportDefinition => currentViewportDefinition;

	internal FlatMapModeViewportDefinition TargetViewportDefinition => targetViewportDefinition;

	private bool DoAnimation => base.AnimationLevel == AnimationLevel.Full;

	private bool DoUserInputAnimation => base.AnimationLevel != AnimationLevel.None;

	protected FlatMapMode(Size logicalAreaSizeInScreenSpaceAtLevel1)
	{
		this.logicalAreaSizeInScreenSpaceAtLevel1 = logicalAreaSizeInScreenSpaceAtLevel1;
		currentViewportDefinition.LogicalAreaSizeInScreenSpaceAtLevel1 = logicalAreaSizeInScreenSpaceAtLevel1;
		targetViewportDefinition.LogicalAreaSizeInScreenSpaceAtLevel1 = logicalAreaSizeInScreenSpaceAtLevel1;
		animationStoryboard = new Storyboard();
		animationStoryboard.Duration = new Duration(new TimeSpan(0L));
		animationStoryboard.Completed += AnimationTick;
	}

	public Point ViewportPointToLogicalPoint(Point viewportPoint)
	{
		return currentViewportDefinition.ViewportPointToLogicalPoint(viewportPoint);
	}

	public Point LogicalPointToViewportPoint(Point logicalPoint)
	{
		return currentViewportDefinition.LogicalPointToViewportPoint(logicalPoint);
	}

	protected abstract Point LocationToLogicalPoint(GeoCoordinate location);

	public virtual IEnumerable<Point> LocationToLogicalPoint(IEnumerable<GeoCoordinate> locations)
	{
		return locations.Select((GeoCoordinate location) => LocationToLogicalPoint(location));
	}

	public virtual Rect LocationRectToLogicalRect(LocationRect boundingRectangle)
	{
		Point point = LocationToLogicalPoint(boundingRectangle.Northwest);
		Point point2 = LocationToLogicalPoint(boundingRectangle.Southeast);
		return new Rect(point, point2);
	}

	protected abstract GeoCoordinate LogicalPointToLocation(Point logicalPoint);

	public virtual bool ConstrainView(GeoCoordinate center, ref double zoomLevel, ref double heading, ref double pitch)
	{
		return false;
	}

	private void ConstrainView(ref FlatMapModeViewportDefinition viewportDefinition)
	{
		DefinitionToView(viewportDefinition, out var center, out var zoomLevel);
		double heading = 0.0;
		double pitch = 0.0;
		ConstrainView(center, ref zoomLevel, ref heading, ref pitch);
		viewportDefinition = ViewToDefinition(center, zoomLevel);
	}

	public override void OnMapDrag(MapDragEventArgs e)
	{
		Point viewportPoint = new Point(0.0 - e.DragDelta.X, 0.0 - e.DragDelta.Y);
		Point point = new Point(e.ViewportPoint.X + e.DragDelta.X, e.ViewportPoint.Y + e.DragDelta.Y);
		currentViewportDefinition.TopLeftLogicalPoint = currentViewportDefinition.ViewportPointToLogicalPoint(viewportPoint);
		ConstrainView(ref currentViewportDefinition);
		double value = nextKeyZoomLevel - currentViewportDefinition.ZoomLevel;
		if (keyDefinitions.Count > 2 || Math.Abs(value) > 2.0)
		{
			keyDefinitions.Clear();
			keyDefinitions.Add(currentViewportDefinition);
			FlatMapModeViewportDefinition viewportDefinition = currentViewportDefinition;
			viewportDefinition.ZoomLevel = Math.Round(currentViewportDefinition.ZoomLevel + (double)Math.Sign(value) * Math.Min(Math.Abs(value), 2.0));
			ConstrainView(ref viewportDefinition);
			keyDefinitions.Add(viewportDefinition);
			animationDuration = BaseAnimaitonDuration;
			animationStart = DateTime.Now - InitialAnimationProgress;
			animationStoryboard.Begin();
		}
		for (int i = 0; i < keyDefinitions.Count; i++)
		{
			FlatMapModeViewportDefinition value2 = keyDefinitions[i];
			value2.SetTopLeftLogicalPoint(point, currentViewportDefinition.ViewportPointToLogicalPoint(point));
			keyDefinitions[i] = value2;
		}
		targetViewportDefinition = keyDefinitions[keyDefinitions.Count - 1];
		OnTargetViewChanged();
		OnProjectionChanged(ProjectionUpdateLevel.Linear);
		e.Handled = true;
	}

	public override void OnMapFlick(MapFlickEventArgs e)
	{
		Point velocity = e.Velocity;
		double angle = PhysicsHelper.GetAngleFromVelocity(velocity);
		double num = Math.Sqrt(velocity.X * velocity.X + velocity.Y * velocity.Y);
		if (num > 1.0)
		{
			num = Math.Min(num, Math.Abs(base.ViewportSize.Width / 2.0));
			num = Math.Min(num, Math.Abs(base.ViewportSize.Height / 2.0));
			velocity = new Point(num * Math.Cos(PhysicsHelper.DegreeToRadian(angle)), num * Math.Sin(PhysicsHelper.DegreeToRadian(angle)));
			FlatMapModeViewportDefinition viewportDefinition = currentViewportDefinition;
			viewportDefinition.SetTopLeftLogicalPoint(velocity, currentViewportDefinition.TopLeftLogicalPoint);
			if (targetViewportDefinition.ZoomLevel != currentViewportDefinition.ZoomLevel)
			{
				viewportDefinition.ZoomLevel = Math.Round(viewportDefinition.ZoomLevel);
			}
			ConstrainView(ref viewportDefinition);
			SetView(viewportDefinition, DoUserInputAnimation);
		}
		e.Handled = true;
	}

	public override void OnMapZoom(MapZoomEventArgs e)
	{
		bool animate = DoUserInputAnimation;
		FlatMapModeViewportDefinition viewportDefinition = currentViewportDefinition;
		viewportDefinition.ZoomLevel += e.ZoomDelta;
		ConstrainView(ref viewportDefinition);
		if (Math.Abs(e.ZoomDelta) < ZoomDeltaThresholdToSkipAnimation)
		{
			animate = false;
		}
		else
		{
			viewportDefinition.ZoomLevel = Math.Round(viewportDefinition.ZoomLevel);
		}
		viewportDefinition.SetTopLeftLogicalPoint(e.ViewportPoint, currentViewportDefinition.ViewportPointToLogicalPoint(e.ViewportPoint));
		ConstrainView(ref viewportDefinition);
		SetView(viewportDefinition, animate);
		e.Handled = true;
	}

	public override void SetView(GeoCoordinate center, double zoomLevel, double heading, double pitch, bool animate)
	{
		ConstrainView(center, ref zoomLevel, ref heading, ref pitch);
		base.Heading = heading;
		base.Pitch = pitch;
		FlatMapModeViewportDefinition newView = ViewToDefinition(center, zoomLevel);
		SetView(newView, animate);
	}

	public override void SetView(LocationRect boundingRectangle, bool animate)
	{
		Rect rect = LocationRectToLogicalRect(boundingRectangle);
		FlatMapModeViewportDefinition definitionByBounds = GetDefinitionByBounds(new Point[2]
		{
			new Point(rect.Left, rect.Top),
			new Point(rect.Right, rect.Bottom)
		});
		DefinitionToView(definitionByBounds, out var center, out var zoomLevel);
		SetView(center, zoomLevel, TargetHeading, TargetPitch, animate);
	}

	private void SetView(FlatMapModeViewportDefinition newView, bool animate)
	{
		lastViewportSize = base.ViewportSize;
		targetViewportDefinition = newView;
		keyDefinitions.Clear();
		keyDefinitions.Add(newView);
		if (!animate)
		{
			SnapToTarget();
		}
		else
		{
			keyDefinitions.Insert(0, currentViewportDefinition);
			Point viewportPoint = new Point(base.ViewportSize.Width / 2.0, base.ViewportSize.Height / 2.0);
			FlatMapModeViewportDefinition definitionByBounds = GetDefinitionByBounds(new Point[2]
			{
				keyDefinitions[0].ViewportPointToLogicalPoint(viewportPoint),
				keyDefinitions[1].ViewportPointToLogicalPoint(viewportPoint)
			});
			if (definitionByBounds.ZoomLevel < keyDefinitions[0].ZoomLevel && definitionByBounds.ZoomLevel < keyDefinitions[keyDefinitions.Count - 1].ZoomLevel)
			{
				keyDefinitions.Insert(1, definitionByBounds);
			}
			double num = (double)(keyDefinitions.Count - 2) * 10.0;
			for (int i = 0; i < keyDefinitions.Count - 1; i++)
			{
				num += Math.Max(Math.Abs(keyDefinitions[i + 1].ZoomLevel - keyDefinitions[i].ZoomLevel), 1.0);
			}
			animationDuration = new TimeSpan(BaseAnimaitonDuration.Ticks * (long)(0.1 * num + 0.9));
			animationStart = DateTime.Now - InitialAnimationProgress;
			animationStoryboard.Begin();
		}
		OnTargetViewChanged();
	}

	public override void ViewportSizeChanged(Size viewportSize)
	{
		base.ViewportSizeChanged(viewportSize);
		if (lastViewportSize != base.ViewportSize)
		{
			Point viewportPoint = new Point((lastViewportSize.Width - base.ViewportSize.Width) / 2.0, (lastViewportSize.Height - base.ViewportSize.Height) / 2.0);
			currentViewportDefinition.TopLeftLogicalPoint = currentViewportDefinition.ViewportPointToLogicalPoint(viewportPoint);
			for (int i = 0; i < keyDefinitions.Count; i++)
			{
				FlatMapModeViewportDefinition value = keyDefinitions[i];
				value.TopLeftLogicalPoint = value.ViewportPointToLogicalPoint(viewportPoint);
				keyDefinitions[i] = value;
			}
			if (keyDefinitions.Count > 0)
			{
				targetViewportDefinition = keyDefinitions[keyDefinitions.Count - 1];
			}
			else
			{
				targetViewportDefinition = currentViewportDefinition;
			}
			lastViewportSize = base.ViewportSize;
			OnProjectionChanged(ProjectionUpdateLevel.Linear);
		}
	}

	public override GeoCoordinate ViewportPointToLocation(Point viewportPoint)
	{
		if (TryViewportPointToLocation(viewportPoint, out var location))
		{
			return location;
		}
		throw new ArgumentException(ExceptionStrings.ViewportPointToLocation_DefaultException);
	}

	public override bool TryViewportPointToLocation(Point viewportPoint, out GeoCoordinate location)
	{
		location = ViewportPointToLocation(viewportPoint, currentViewportDefinition);
		return true;
	}

	public override Point LocationToViewportPoint(GeoCoordinate location)
	{
		if (TryLocationToViewportPoint(location, out var viewportPoint))
		{
			return viewportPoint;
		}
		throw new ArgumentException(ExceptionStrings.LocationToViewportPoint_DefaultException);
	}

	public override bool TryLocationToViewportPoint(GeoCoordinate location, out Point viewportPoint)
	{
		viewportPoint = LocationToViewportPoint(location, currentViewportDefinition);
		return true;
	}

	public override IEnumerable<Point> LocationToViewportPoint(IEnumerable<GeoCoordinate> locations)
	{
		return locations.Select((GeoCoordinate location) => LocationToViewportPoint(location, currentViewportDefinition));
	}

	public override Rect LocationToViewportPoint(LocationRect boundingRectangle)
	{
		return LocationToViewportPoint(boundingRectangle, currentViewportDefinition);
	}

	internal GeoCoordinate ViewportPointToLocation(Point viewportPoint, FlatMapModeViewportDefinition definition)
	{
		Point logicalPoint = definition.ViewportPointToLogicalPoint(viewportPoint);
		return LogicalPointToLocation(logicalPoint);
	}

	internal Point LocationToViewportPoint(GeoCoordinate location, FlatMapModeViewportDefinition definition)
	{
		Point logicalPoint = LocationToLogicalPoint(location);
		return definition.LogicalPointToViewportPoint(logicalPoint);
	}

	internal Rect LocationToViewportPoint(LocationRect boundingRectangle, FlatMapModeViewportDefinition definition)
	{
		Rect rect = LocationRectToLogicalRect(boundingRectangle);
		Point point = definition.LogicalPointToViewportPoint(new Point(rect.Left, rect.Top));
		Point point2 = definition.LogicalPointToViewportPoint(new Point(rect.Right, rect.Bottom));
		return new Rect(point, point2);
	}

	private void SnapToTarget()
	{
		animationStart = DateTime.MinValue;
		animationStoryboard.Stop();
		bool flag = currentViewportDefinition.ZoomLevel != targetViewportDefinition.ZoomLevel;
		currentViewportDefinition = targetViewportDefinition;
		nextKeyZoomLevel = currentViewportDefinition.ZoomLevel;
		OnProjectionChanged((!flag) ? ProjectionUpdateLevel.Linear : ProjectionUpdateLevel.Full);
	}

	private void AnimationTick(object sender, EventArgs e)
	{
		double num = (DateTime.Now - animationStart).TotalSeconds / animationDuration.TotalSeconds;
		if (num >= 1.0 || keyDefinitions.Count < 1)
		{
			SnapToTarget();
			return;
		}
		double num2 = (1.0 - Math.Exp((0.0 - num) * AnimationSpringWindup)) / 0.9995;
		int num3 = 0;
		double num4 = 0.0;
		double num5 = 0.0;
		for (int i = 0; i < keyDefinitions.Count - 1; i++)
		{
			num5 += Math.Max(Math.Abs(keyDefinitions[i + 1].ZoomLevel - keyDefinitions[i].ZoomLevel), 1.0);
		}
		double num6 = num2 * num5;
		double num7 = 0.0;
		for (int j = 0; j < keyDefinitions.Count - 1; j++)
		{
			double num8 = Math.Max(Math.Abs(keyDefinitions[j + 1].ZoomLevel - keyDefinitions[j].ZoomLevel), 1.0);
			if (num7 + num8 > num6)
			{
				num3 = j;
				num4 = (num6 - num7) / num8;
				break;
			}
			num7 += num8;
		}
		double num9 = keyDefinitions[num3].ZoomLevel - keyDefinitions[num3 + 1].ZoomLevel;
		if (Math.Abs(num9) > 0.5)
		{
			double num10 = Math.Pow(2.0, num9);
			num4 = (Math.Pow(num10, num4) - 1.0) / (num10 - 1.0);
		}
		FlatMapModeViewportDefinition flatMapModeViewportDefinition = keyDefinitions[keyDefinitions.Count - 1];
		flatMapModeViewportDefinition.ZoomLevel = Math.Log(1.0 / BezierHelper.GetSmoothedValue(num4, (num3 - 1 >= 0) ? (1.0 / Math.Pow(2.0, keyDefinitions[num3 - 1].ZoomLevel)) : double.NaN, 1.0 / Math.Pow(2.0, keyDefinitions[num3].ZoomLevel), 1.0 / Math.Pow(2.0, keyDefinitions[num3 + 1].ZoomLevel), (num3 + 2 <= keyDefinitions.Count - 1) ? (1.0 / Math.Pow(2.0, keyDefinitions[num3 + 2].ZoomLevel)) : double.NaN), 2.0);
		flatMapModeViewportDefinition.TopLeftLogicalPoint = new Point(BezierHelper.GetSmoothedValue(num4, (num3 - 1 >= 0) ? keyDefinitions[num3 - 1].TopLeftLogicalPoint.X : double.NaN, keyDefinitions[num3].TopLeftLogicalPoint.X, keyDefinitions[num3 + 1].TopLeftLogicalPoint.X, (num3 + 2 <= keyDefinitions.Count - 1) ? keyDefinitions[num3 + 2].TopLeftLogicalPoint.X : double.NaN), BezierHelper.GetSmoothedValue(num4, (num3 - 1 >= 0) ? keyDefinitions[num3 - 1].TopLeftLogicalPoint.Y : double.NaN, keyDefinitions[num3].TopLeftLogicalPoint.Y, keyDefinitions[num3 + 1].TopLeftLogicalPoint.Y, (num3 + 2 <= keyDefinitions.Count - 1) ? keyDefinitions[num3 + 2].TopLeftLogicalPoint.Y : double.NaN));
		bool flag = currentViewportDefinition.ZoomLevel != flatMapModeViewportDefinition.ZoomLevel;
		nextKeyZoomLevel = keyDefinitions[num3 + 1].ZoomLevel;
		currentViewportDefinition = flatMapModeViewportDefinition;
		OnProjectionChanged((!flag) ? ProjectionUpdateLevel.Linear : ProjectionUpdateLevel.Full);
		animationStoryboard.Begin();
	}

	private FlatMapModeViewportDefinition GetDefinitionByBounds(IList<Point> logicalPoints)
	{
		FlatMapModeViewportDefinition result = new FlatMapModeViewportDefinition
		{
			LogicalAreaSizeInScreenSpaceAtLevel1 = logicalAreaSizeInScreenSpaceAtLevel1
		};
		if (logicalPoints.Count > 0)
		{
			Rect rect = new Rect(logicalPoints[0], new Size(0.0, 0.0));
			for (int i = 1; i < logicalPoints.Count; i++)
			{
				rect.Union(logicalPoints[i]);
			}
			Size viewportSize = base.ViewportSize;
			result.ZoomLevel = Math.Min(Math.Log(2.0 * viewportSize.Width / (logicalAreaSizeInScreenSpaceAtLevel1.Width * rect.Width), 2.0), Math.Log(2.0 * viewportSize.Height / (logicalAreaSizeInScreenSpaceAtLevel1.Height * rect.Height), 2.0));
			result.ZoomLevel = Math.Floor(result.ZoomLevel);
			result.SetTopLeftLogicalPoint(new Point(viewportSize.Width / 2.0, viewportSize.Height / 2.0), new Point(rect.X + rect.Width / 2.0, rect.Y + rect.Height / 2.0));
			return result;
		}
		return result;
	}

	private FlatMapModeViewportDefinition ViewToDefinition(GeoCoordinate center, double zoomLevel)
	{
		FlatMapModeViewportDefinition result = default(FlatMapModeViewportDefinition);
		result.LogicalAreaSizeInScreenSpaceAtLevel1 = logicalAreaSizeInScreenSpaceAtLevel1;
		result.ZoomLevel = zoomLevel;
		result.SetTopLeftLogicalPoint(new Point(base.ViewportSize.Width / 2.0, base.ViewportSize.Height / 2.0), LocationToLogicalPoint(center));
		return result;
	}

	private void DefinitionToView(FlatMapModeViewportDefinition viewportDefinition, out GeoCoordinate center, out double zoomLevel)
	{
		Point logicalPoint = viewportDefinition.ViewportPointToLogicalPoint(new Point(base.ViewportSize.Width / 2.0, base.ViewportSize.Height / 2.0));
		center = LogicalPointToLocation(logicalPoint);
		zoomLevel = viewportDefinition.ZoomLevel;
	}
}
