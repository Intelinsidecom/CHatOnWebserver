using System;
using System.Windows;
using System.Windows.Controls;
using Microsoft.Phone.Controls.Primitives;

namespace Microsoft.Phone.Controls;

[TemplateVisualState(Name = "Right", GroupName = "Position States")]
[TemplateVisualState(Name = "Left", GroupName = "Position States")]
[TemplateVisualState(Name = "Center", GroupName = "Position States")]
public class PivotItem : ContentControl
{
	private const string PivotPositionsGroupName = "Position States";

	private const string PivotStateCenter = "Center";

	private const string PivotStateLeft = "Left";

	private const string PivotStateRight = "Right";

	private const string ContentName = "Content";

	private AnimationDirection? _firstAnimation = null;

	private AnimationDirection _direction;

	public static readonly DependencyProperty HeaderProperty = DependencyProperty.Register("Header", typeof(object), typeof(PivotItem), new PropertyMetadata(null));

	public object Header
	{
		get
		{
			return GetValue(HeaderProperty);
		}
		set
		{
			SetValue(HeaderProperty, value);
		}
	}

	public PivotItem()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PIVOT_STARTUP, PerfLog.PivotItem);
		base.DefaultStyleKey = typeof(PivotItem);
		base.Loaded += PivotItem_Loaded;
	}

	private void PivotItem_Loaded(object sender, RoutedEventArgs e)
	{
		base.Loaded -= PivotItem_Loaded;
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PIVOT_STARTUP, PerfLog.PivotItem);
	}

	protected override Size ArrangeOverride(Size finalSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PIVOT_ARRANGE, PerfLog.PivotItem);
		Size result = base.ArrangeOverride(finalSize);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PIVOT_ARRANGE, PerfLog.PivotItem);
		return result;
	}

	protected override Size MeasureOverride(Size availableSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PIVOT_MEASURE, PerfLog.PivotItem);
		Size result = base.MeasureOverride(availableSize);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PIVOT_MEASURE, PerfLog.PivotItem);
		return result;
	}

	public override void OnApplyTemplate()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PIVOT_APPLYTEMPLATE, PerfLog.PivotItem);
		base.OnApplyTemplate();
		AnimationDirection? firstAnimation = _firstAnimation;
		MoveTo(AnimationDirection.Center);
		if (firstAnimation.HasValue)
		{
			MoveTo(firstAnimation.Value);
		}
		_firstAnimation = AnimationDirection.Center;
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PIVOT_APPLYTEMPLATE, PerfLog.PivotItem);
	}

	internal void MoveTo(AnimationDirection direction)
	{
		bool flag = direction != AnimationDirection.Center;
		_direction = direction;
		if (!_firstAnimation.HasValue && flag)
		{
			_firstAnimation = direction;
		}
		else
		{
			UpdateVisualStates(flag);
		}
	}

	private void UpdateVisualStates(bool useTransitions)
	{
		VisualStateManager.GoToState(this, StateNameFromAnimationDirection(_direction), useTransitions);
	}

	private static string StateNameFromAnimationDirection(AnimationDirection direction)
	{
		return direction switch
		{
			AnimationDirection.Center => "Center", 
			AnimationDirection.Left => "Left", 
			AnimationDirection.Right => "Right", 
			_ => throw new InvalidOperationException(), 
		};
	}
}
