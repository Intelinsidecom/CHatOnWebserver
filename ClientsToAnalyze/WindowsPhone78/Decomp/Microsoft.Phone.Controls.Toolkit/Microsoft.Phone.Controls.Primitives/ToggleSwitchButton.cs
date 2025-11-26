using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Input;
using System.Windows.Media;

namespace Microsoft.Phone.Controls.Primitives;

[TemplateVisualState(Name = "Disabled", GroupName = "CommonStates")]
[TemplateVisualState(Name = "Checked", GroupName = "CheckStates")]
[TemplateVisualState(Name = "Dragging", GroupName = "CheckStates")]
[TemplateVisualState(Name = "Unchecked", GroupName = "CheckStates")]
[TemplatePart(Name = "SwitchRoot", Type = typeof(Grid))]
[TemplatePart(Name = "SwitchBackground", Type = typeof(UIElement))]
[TemplatePart(Name = "SwitchTrack", Type = typeof(Grid))]
[TemplatePart(Name = "SwitchThumb", Type = typeof(FrameworkElement))]
[TemplateVisualState(Name = "Normal", GroupName = "CommonStates")]
public class ToggleSwitchButton : ToggleButton
{
	private const string CommonStates = "CommonStates";

	private const string NormalState = "Normal";

	private const string DisabledState = "Disabled";

	private const string CheckStates = "CheckStates";

	private const string CheckedState = "Checked";

	private const string DraggingState = "Dragging";

	private const string UncheckedState = "Unchecked";

	private const string SwitchRootPart = "SwitchRoot";

	private const string SwitchBackgroundPart = "SwitchBackground";

	private const string SwitchTrackPart = "SwitchTrack";

	private const string SwitchThumbPart = "SwitchThumb";

	private const double _uncheckedTranslation = 0.0;

	public static readonly DependencyProperty SwitchForegroundProperty = DependencyProperty.Register("SwitchForeground", typeof(Brush), typeof(ToggleSwitchButton), new PropertyMetadata(null));

	private TranslateTransform _backgroundTranslation;

	private TranslateTransform _thumbTranslation;

	private Grid _root;

	private Grid _track;

	private FrameworkElement _thumb;

	private double _checkedTranslation;

	private double _dragTranslation;

	private bool _wasDragged;

	private bool _isDragging;

	public Brush SwitchForeground
	{
		get
		{
			return (Brush)GetValue(SwitchForegroundProperty);
		}
		set
		{
			SetValue(SwitchForegroundProperty, value);
		}
	}

	private double Translation
	{
		get
		{
			if (_backgroundTranslation != null)
			{
				return _backgroundTranslation.X;
			}
			return _thumbTranslation.X;
		}
		set
		{
			if (_backgroundTranslation != null)
			{
				_backgroundTranslation.X = value;
			}
			if (_thumbTranslation != null)
			{
				_thumbTranslation.X = value;
			}
		}
	}

	public ToggleSwitchButton()
	{
		base.DefaultStyleKey = typeof(ToggleSwitchButton);
	}

	private void ChangeVisualState(bool useTransitions)
	{
		if (base.IsEnabled)
		{
			VisualStateManager.GoToState(this, "Normal", useTransitions);
		}
		else
		{
			VisualStateManager.GoToState(this, "Disabled", useTransitions);
		}
		if (_isDragging)
		{
			VisualStateManager.GoToState(this, "Dragging", useTransitions);
		}
		else if (base.IsChecked == true)
		{
			VisualStateManager.GoToState(this, "Checked", useTransitions);
		}
		else
		{
			VisualStateManager.GoToState(this, "Unchecked", useTransitions);
		}
	}

	protected override void OnToggle()
	{
		base.IsChecked = base.IsChecked != true;
		ChangeVisualState(useTransitions: true);
	}

	public override void OnApplyTemplate()
	{
		if (_track != null)
		{
			_track.SizeChanged -= SizeChangedHandler;
		}
		if (_thumb != null)
		{
			_thumb.SizeChanged -= SizeChangedHandler;
		}
		if (_root != null)
		{
			_root.ManipulationStarted -= ManipulationStartedHandler;
			_root.ManipulationDelta -= ManipulationDeltaHandler;
			_root.ManipulationCompleted -= ManipulationCompletedHandler;
		}
		base.OnApplyTemplate();
		_root = GetTemplateChild("SwitchRoot") as Grid;
		UIElement uIElement = GetTemplateChild("SwitchBackground") as UIElement;
		_backgroundTranslation = ((uIElement == null) ? null : (uIElement.RenderTransform as TranslateTransform));
		_track = GetTemplateChild("SwitchTrack") as Grid;
		_thumb = GetTemplateChild("SwitchThumb") as Border;
		_thumbTranslation = ((_thumb == null) ? null : (_thumb.RenderTransform as TranslateTransform));
		if (_root != null && _track != null && _thumb != null && (_backgroundTranslation != null || _thumbTranslation != null))
		{
			_root.ManipulationStarted += ManipulationStartedHandler;
			_root.ManipulationDelta += ManipulationDeltaHandler;
			_root.ManipulationCompleted += ManipulationCompletedHandler;
			_track.SizeChanged += SizeChangedHandler;
			_thumb.SizeChanged += SizeChangedHandler;
		}
		ChangeVisualState(useTransitions: false);
	}

	private void ManipulationStartedHandler(object sender, ManipulationStartedEventArgs e)
	{
		e.Handled = true;
		_isDragging = true;
		_dragTranslation = Translation;
		ChangeVisualState(useTransitions: true);
		Translation = _dragTranslation;
	}

	private void ManipulationDeltaHandler(object sender, ManipulationDeltaEventArgs e)
	{
		e.Handled = true;
		double x = e.DeltaManipulation.Translation.X;
		Orientation orientation = ((Math.Abs(x) >= Math.Abs(e.DeltaManipulation.Translation.Y)) ? Orientation.Horizontal : Orientation.Vertical);
		if (orientation == Orientation.Horizontal && x != 0.0)
		{
			_wasDragged = true;
			_dragTranslation += x;
			Translation = Math.Max(0.0, Math.Min(_checkedTranslation, _dragTranslation));
		}
	}

	private void ManipulationCompletedHandler(object sender, ManipulationCompletedEventArgs e)
	{
		e.Handled = true;
		_isDragging = false;
		bool flag = false;
		if (_wasDragged)
		{
			double num = ((base.IsChecked == true) ? _checkedTranslation : 0.0);
			if (Translation != num)
			{
				flag = true;
			}
		}
		else
		{
			flag = true;
		}
		if (flag)
		{
			OnClick();
		}
		_wasDragged = false;
	}

	private void SizeChangedHandler(object sender, SizeChangedEventArgs e)
	{
		_track.Clip = new RectangleGeometry
		{
			Rect = new Rect(0.0, 0.0, _track.ActualWidth, _track.ActualHeight)
		};
		_checkedTranslation = _track.ActualWidth - _thumb.ActualWidth - _thumb.Margin.Left - _thumb.Margin.Right;
	}
}
