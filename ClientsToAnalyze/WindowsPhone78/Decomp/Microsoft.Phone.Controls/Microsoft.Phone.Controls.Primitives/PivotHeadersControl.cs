using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;

namespace Microsoft.Phone.Controls.Primitives;

[StyleTypedProperty(Property = "ItemContainerStyle", StyleTargetType = typeof(PivotHeaderItem))]
[TemplatePart(Name = "Canvas", Type = typeof(Canvas))]
public class PivotHeadersControl : TemplatedItemsControl<PivotHeaderItem>
{
	private class AnimationInstruction
	{
		public int _previousIndex;

		public int _index;

		public IEasingFunction _ease;

		public double _width;

		public double _durationInSeconds;

		public AnimationInstruction(int previous, int next)
		{
			_previousIndex = previous;
			_index = next;
		}
	}

	private const string CanvasName = "Canvas";

	private const double PivotSeconds = 0.5;

	private bool _isDesign;

	private Canvas _canvas;

	private Dictionary<Control, double> _sizes;

	private Dictionary<Control, TranslateTransform> _translations;

	private Dictionary<Control, OpacityAnimator> _opacities;

	private Image _leftMirror;

	private TranslateTransform _leftMirrorTranslation;

	private TransformAnimator _canvasAnimator;

	internal readonly IEasingFunction QuarticEase = new QuarticEase();

	internal bool _cancelClick;

	private bool _activeSelectionChange;

	private bool _isAnimating;

	private Queue<AnimationInstruction> _queuedAnimations;

	internal bool _wasClicked;

	private Pivot _pivot;

	private double _animatingWidth;

	private DateTime _currentItemAnimationStarted;

	internal static readonly DependencyProperty SelectedIndexProperty = DependencyProperty.Register("SelectedIndex", typeof(int), typeof(PivotHeadersControl), new PropertyMetadata(0, OnSelectedIndexPropertyChanged));

	public static readonly DependencyProperty VisualFirstIndexProperty = DependencyProperty.Register("VisualFirstIndex", typeof(int), typeof(PivotHeadersControl), new PropertyMetadata(0, OnVisualFirstIndexPropertyChanged));

	private bool _ignorePropertyChange;

	private int _previousVisualFirstIndex;

	internal int SelectedIndex
	{
		get
		{
			return (int)GetValue(SelectedIndexProperty);
		}
		set
		{
			SetValue(SelectedIndexProperty, value);
		}
	}

	public int VisualFirstIndex
	{
		get
		{
			return (int)GetValue(VisualFirstIndexProperty);
		}
		set
		{
			SetValue(VisualFirstIndexProperty, value);
		}
	}

	internal AnimationDirection AnimationDirection { get; set; }

	internal event EventHandler<SelectedIndexChangedEventArgs> SelectedIndexChanged;

	protected override Size ArrangeOverride(Size finalSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PIVOT_ARRANGE, PerfLog.PivotHeadersControl);
		Size result = base.ArrangeOverride(finalSize);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PIVOT_ARRANGE, PerfLog.PivotHeadersControl);
		return result;
	}

	protected override Size MeasureOverride(Size availableSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PIVOT_MEASURE, PerfLog.PivotHeadersControl);
		Size result = base.MeasureOverride(availableSize);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PIVOT_MEASURE, PerfLog.PivotHeadersControl);
		return result;
	}

	private static void OnSelectedIndexPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		PivotHeadersControl pivotHeadersControl = d as PivotHeadersControl;
		int index = (int)e.NewValue;
		int previousIndex = (int)e.OldValue;
		if (!pivotHeadersControl._activeSelectionChange)
		{
			pivotHeadersControl.SelectOne(previousIndex, index);
		}
	}

	private static void OnVisualFirstIndexPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		PivotHeadersControl pivotHeadersControl = d as PivotHeadersControl;
		if (pivotHeadersControl._ignorePropertyChange)
		{
			pivotHeadersControl._ignorePropertyChange = false;
			return;
		}
		int num = (int)e.NewValue;
		pivotHeadersControl._previousVisualFirstIndex = (int)e.OldValue;
		int count = pivotHeadersControl.Items.Count;
		if (count > 0 && num >= count)
		{
			pivotHeadersControl._ignorePropertyChange = true;
			d.SetValue(e.Property, 0);
		}
		pivotHeadersControl.UpdateItemsLayout();
	}

	public PivotHeadersControl()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PIVOT_STARTUP, PerfLog.PivotHeadersControl);
		base.DefaultStyleKey = typeof(PivotHeadersControl);
		_leftMirror = new Image();
		_leftMirror.CacheMode = new BitmapCache();
		_sizes = new Dictionary<Control, double>();
		_translations = new Dictionary<Control, TranslateTransform>();
		_opacities = new Dictionary<Control, OpacityAnimator>();
		_isDesign = DesignerProperties.IsInDesignTool;
		_queuedAnimations = new Queue<AnimationInstruction>();
		base.Loaded += PivotHeadersControl_Loaded;
	}

	private void PivotHeadersControl_Loaded(object sender, RoutedEventArgs e)
	{
		base.Loaded -= PivotHeadersControl_Loaded;
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PIVOT_STARTUP, PerfLog.PanoramaItem);
	}

	public override void OnApplyTemplate()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PIVOT_APPLYTEMPLATE, PerfLog.PivotHeadersControl);
		_pivot = null;
		if (_canvas != null)
		{
			_canvas.Children.Remove(_leftMirror);
			_leftMirror = null;
		}
		((FrameworkElement)this).OnApplyTemplate();
		_canvas = GetTemplateChild("Canvas") as Canvas;
		if (_canvas != null)
		{
			_canvas.Children.Add(_leftMirror);
			_leftMirrorTranslation = TransformAnimator.GetTranslateTransform(_leftMirror);
			if (!double.IsNaN(_leftMirror.ActualWidth) && _leftMirror.ActualWidth > 0.0)
			{
				_leftMirrorTranslation.X = 0.0 - _leftMirror.ActualWidth;
			}
		}
		if (base.Items.Count > 0)
		{
			VisualFirstIndex = SelectedIndex;
		}
		DependencyObject dependencyObject = this;
		do
		{
			dependencyObject = VisualTreeHelper.GetParent(dependencyObject);
			_pivot = dependencyObject as Pivot;
		}
		while (_pivot == null && dependencyObject != null);
		if (_pivot != null)
		{
			_pivot._clickedHeadersControl = this;
		}
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PIVOT_APPLYTEMPLATE, PerfLog.PivotHeadersControl);
	}

	protected override void OnItemsChanged(NotifyCollectionChangedEventArgs e)
	{
		base.OnItemsChanged(e);
		if (base.Items.Count > 0)
		{
			UpdateItemsLayout();
			return;
		}
		VisualFirstIndex = 0;
		SelectedIndex = 0;
	}

	protected override void ClearContainerForItemOverride(DependencyObject element, object item)
	{
		base.ClearContainerForItemOverride(element, item);
		PivotHeaderItem pivotHeaderItem = (PivotHeaderItem)element;
		pivotHeaderItem.ParentHeadersControl = null;
		pivotHeaderItem.Item = null;
		if (!object.ReferenceEquals(element, item))
		{
			pivotHeaderItem.Item = item;
		}
		if (item is Control control)
		{
			control.SizeChanged -= OnHeaderSizeChanged;
			_sizes.Remove(control);
			_translations.Remove(control);
		}
	}

	protected override void PrepareContainerForItemOverride(DependencyObject element, object item)
	{
		base.PrepareContainerForItemOverride(element, item);
		PivotHeaderItem pivotHeaderItem = (PivotHeaderItem)element;
		pivotHeaderItem.ParentHeadersControl = this;
		int num = base.ItemContainerGenerator.IndexFromContainer(element);
		if (num != -1)
		{
			pivotHeaderItem.IsSelected = SelectedIndex == num;
		}
		if (item is Control control)
		{
			control.SizeChanged += OnHeaderSizeChanged;
		}
	}

	private void OnHeaderSizeChanged(object sender, SizeChangedEventArgs e)
	{
		double width = e.NewSize.Width;
		double height = e.NewSize.Height;
		if (double.IsNaN(base.Height) || height > base.Height)
		{
			base.Height = height;
		}
		_sizes[(Control)sender] = width;
		UpdateItemsLayout();
		if (_leftMirrorTranslation.X == 0.0)
		{
			UpdateLeftMirrorImage(SelectedIndex);
		}
	}

	internal void OnHeaderItemClicked(PivotHeaderItem item)
	{
		if (!_isAnimating)
		{
			if (_cancelClick)
			{
				_cancelClick = false;
				return;
			}
			_wasClicked = true;
			item.IsSelected = true;
		}
	}

	internal void NotifyHeaderItemSelected(PivotHeaderItem item, bool isSelected)
	{
		if (isSelected)
		{
			int num = base.ItemContainerGenerator.IndexFromContainer(item);
			int selectedIndex = SelectedIndex;
			SelectOne(selectedIndex, num);
			SelectedIndex = num;
		}
	}

	private void SelectOne(int previousIndex, int index)
	{
		if (_activeSelectionChange)
		{
			return;
		}
		UpdateLeftMirrorImage(index);
		if (index < 0 || index >= base.Items.Count)
		{
			return;
		}
		try
		{
			_activeSelectionChange = true;
			for (int i = 0; i < base.Items.Count; i++)
			{
				PivotHeaderItem pivotHeaderItem = (PivotHeaderItem)base.ItemContainerGenerator.ContainerFromIndex(i);
				if (pivotHeaderItem != null)
				{
					pivotHeaderItem.IsSelected = index == i;
				}
			}
		}
		finally
		{
			SafeRaise.Raise(this.SelectedIndexChanged, this, new SelectedIndexChangedEventArgs(index));
			_activeSelectionChange = false;
			BeginAnimate(previousIndex, index);
		}
	}

	internal void RestoreHeaderPosition(Duration duration)
	{
		if (_canvas != null && !_isAnimating)
		{
			TransformAnimator.EnsureAnimator(_canvas, ref _canvasAnimator);
			if (_canvasAnimator != null)
			{
				_canvasAnimator.GoTo(0.0, duration);
			}
		}
	}

	internal void PanHeader(double cumulative, double contentWidth, Duration duration)
	{
		if (!_isAnimating && _canvas != null)
		{
			TransformAnimator.EnsureAnimator(_canvas, ref _canvasAnimator);
			if (_canvasAnimator != null)
			{
				double num = ((cumulative < 0.0) ? GetItemWidth(SelectedIndex) : GetLeftMirrorWidth(SelectedIndex));
				_canvasAnimator.GoTo(cumulative / contentWidth * num, duration);
			}
		}
	}

	private void BeginAnimate(int previousIndex, int newIndex)
	{
		if (_isDesign || _canvas == null)
		{
			VisualFirstIndex = newIndex;
			return;
		}
		if ((newIndex != RollingIncrement(previousIndex) && newIndex != RollingDecrement(previousIndex)) || _wasClicked)
		{
			_wasClicked = false;
			int num = previousIndex;
			while (num != newIndex)
			{
				int num2 = RollingIncrement(num);
				AnimationInstruction animationInstruction = new AnimationInstruction(num, num2);
				animationInstruction._width = GetItemWidth(num);
				if (animationInstruction._width > 0.0)
				{
					_queuedAnimations.Enqueue(animationInstruction);
				}
				num = num2;
			}
			UpdateActiveAndQueuedAnimations();
		}
		else
		{
			if (_queuedAnimations.Count == 0 && !_isAnimating)
			{
				BeginAnimateInternal(previousIndex, newIndex, QuarticEase, null);
				return;
			}
			AnimationInstruction animationInstruction2 = new AnimationInstruction(previousIndex, newIndex);
			animationInstruction2._ease = QuarticEase;
			animationInstruction2._width = GetItemWidth(previousIndex);
			_queuedAnimations.Enqueue(animationInstruction2);
			UpdateActiveAndQueuedAnimations();
		}
		if (!_isAnimating)
		{
			AnimateComplete();
		}
	}

	private void UpdateActiveAndQueuedAnimations()
	{
		TransformAnimator.EnsureAnimator(_canvas, ref _canvasAnimator);
		if (_canvasAnimator == null)
		{
			return;
		}
		double num = 0.0;
		foreach (AnimationInstruction queuedAnimation in _queuedAnimations)
		{
			num += queuedAnimation._width;
		}
		if (_isAnimating && _animatingWidth > 0.0)
		{
			num += _animatingWidth;
		}
		int num2 = 0;
		foreach (AnimationInstruction queuedAnimation2 in _queuedAnimations)
		{
			num2++;
			queuedAnimation2._durationInSeconds = queuedAnimation2._width / ((num == 0.0) ? 1.0 : num) * 0.5;
			queuedAnimation2._ease = ((num2 == _queuedAnimations.Count) ? QuarticEase : null);
			if (_isAnimating)
			{
				_canvasAnimator.UpdateEasingFunction(null);
			}
		}
		if (_isAnimating)
		{
			double totalSeconds = (DateTime.Now - _currentItemAnimationStarted).TotalSeconds;
			double num3 = totalSeconds / 0.5;
			double num4 = _animatingWidth * num3 / ((num == 0.0) ? 1.0 : num);
			_canvasAnimator.UpdateDuration(new Duration(TimeSpan.FromSeconds(num4 * num3 * 0.5)));
		}
	}

	private void BeginAnimateInternal(int previousIndex, int newIndex, IEasingFunction ease, Duration? optionalDuration)
	{
		if (previousIndex == newIndex || previousIndex < 0 || previousIndex >= base.Items.Count || _isDesign || _canvas == null)
		{
			if (VisualFirstIndex != newIndex)
			{
				VisualFirstIndex = newIndex;
			}
			AnimateComplete();
			return;
		}
		TransformAnimator.EnsureAnimator(_canvas, ref _canvasAnimator);
		_isAnimating = true;
		bool flag = ((base.Items.Count != 2) ? (newIndex == RollingIncrement(previousIndex)) : (AnimationDirection == AnimationDirection.Left));
		int index = (flag ? previousIndex : newIndex);
		double num = (_animatingWidth = GetItemWidth(index));
		_currentItemAnimationStarted = DateTime.Now;
		double targetOffset = 0.0 - num + (flag ? 0.0 : _canvasAnimator.CurrentOffset);
		double num2 = ((num == 0.0) ? num : ((num - Math.Abs(_canvasAnimator.CurrentOffset)) / num));
		if (num2 == 0.0)
		{
			num2 = 1.0;
		}
		Duration currentSampleDuration = (optionalDuration.HasValue ? optionalDuration.Value : new Duration(TimeSpan.FromSeconds(0.25 + Math.Abs(num2 * 0.25))));
		if (flag)
		{
			_canvasAnimator.GoTo(targetOffset, currentSampleDuration, ease, delegate
			{
				VisualFirstIndex = newIndex;
				_canvasAnimator.GoTo(0.0, Pivot.ZeroDuration, AnimateComplete);
			});
		}
		else
		{
			VisualFirstIndex = newIndex;
			_canvasAnimator.GoTo(targetOffset, Pivot.ZeroDuration, delegate
			{
				_canvasAnimator.GoTo(0.0, currentSampleDuration, ease, AnimateComplete);
			});
		}
	}

	private void AnimateComplete()
	{
		if (_queuedAnimations.Count == 0)
		{
			_isAnimating = false;
		}
		else
		{
			AnimationInstruction animationInstruction = _queuedAnimations.Dequeue();
			BeginAnimateInternal(optionalDuration: new Duration(TimeSpan.FromSeconds(animationInstruction._durationInSeconds)), previousIndex: animationInstruction._previousIndex, newIndex: animationInstruction._index, ease: animationInstruction._ease);
		}
	}

	private double GetLeftMirrorWidth(int index)
	{
		return GetItemWidth(GetPreviousVisualIndex(index));
	}

	private double GetNextHeaderWidth()
	{
		int num = VisualFirstIndex + 1;
		if (num >= base.Items.Count)
		{
			num = 0;
		}
		return GetItemWidth(num);
	}

	private double GetItemWidth(int index)
	{
		Control control = GetItemFromIndex(index) as Control;
		double value = 0.0;
		if (control != null && !_sizes.TryGetValue(control, out value))
		{
			value = control.ActualWidth;
			if (!double.IsNaN(value))
			{
				_sizes[control] = value;
			}
		}
		return value;
	}

	private int GetPreviousVisualIndex(int indexOfInterest)
	{
		int num = indexOfInterest - 1;
		if (num >= 0)
		{
			return num;
		}
		return base.Items.Count - 1;
	}

	private void UpdateLeftMirrorImage(int visualRootIndex)
	{
		if (_leftMirrorTranslation == null || _sizes == null || _leftMirror == null)
		{
			return;
		}
		if (base.Items.Count <= 1)
		{
			_leftMirror = null;
			return;
		}
		int previousVisualIndex = GetPreviousVisualIndex(visualRootIndex);
		if (!(GetItemFromIndex(previousVisualIndex) is PivotHeaderItem pivotHeaderItem) || !_sizes.ContainsKey(pivotHeaderItem))
		{
			return;
		}
		double num = _sizes[pivotHeaderItem];
		pivotHeaderItem.UpdateVisualStateToUnselected();
		try
		{
			WriteableBitmap source = new WriteableBitmap(pivotHeaderItem, new TranslateTransform());
			_leftMirror.Source = source;
		}
		catch (Exception)
		{
			_leftMirror.Source = null;
		}
		finally
		{
			pivotHeaderItem.RestoreVisualStates();
			_leftMirrorTranslation.X = 0.0 - num;
		}
	}

	private void UpdateItemsLayout()
	{
		int count = base.Items.Count;
		double offset = 0.0;
		int visualFirstIndex = VisualFirstIndex;
		for (int i = visualFirstIndex; i < base.Items.Count; i++)
		{
			FadeInItemIfNeeded(i, visualFirstIndex, _previousVisualFirstIndex, count);
			SetItemPosition(i, ref offset);
		}
		if (VisualFirstIndex > 0)
		{
			for (int j = 0; j < VisualFirstIndex; j++)
			{
				FadeInItemIfNeeded(j, visualFirstIndex, _previousVisualFirstIndex, count);
				SetItemPosition(j, ref offset);
			}
		}
	}

	private void FadeInItemIfNeeded(int index, int visualFirstIndex, int previousVisualFirstIndex, int itemCount)
	{
		if (!_isDesign && RollingIncrement(index) == visualFirstIndex && index == previousVisualFirstIndex)
		{
			if (itemCount > 1 && (itemCount != 2 || AnimationDirection != AnimationDirection.Right))
			{
				double num = 0.0;
				for (int num2 = RollingIncrement(index); num2 != index; num2 = RollingIncrement(num2))
				{
					num += GetItemWidth(num2);
				}
				if (num < base.ActualWidth)
				{
					FadeIn(index);
				}
			}
		}
		else if (GetItemFromIndex(index) is UIElement uIElement)
		{
			uIElement.Opacity = 1.0;
		}
	}

	private object GetItemFromIndex(int index)
	{
		if (base.Items.Count > index)
		{
			return base.Items[index];
		}
		return null;
	}

	private int RollingIncrement(int index)
	{
		index++;
		if (index >= base.Items.Count)
		{
			return 0;
		}
		return index;
	}

	private int RollingDecrement(int index)
	{
		index--;
		if (index >= 0)
		{
			return index;
		}
		return base.Items.Count - 1;
	}

	private void FadeIn(int index)
	{
		Control control = (Control)base.Items[index];
		if (!_opacities.TryGetValue(control, out var oa))
		{
			OpacityAnimator.EnsureAnimator(control, ref oa);
			_opacities[control] = oa;
		}
		if (oa != null)
		{
			oa.GoTo(0.0, Pivot.ZeroDuration, delegate
			{
				oa.GoTo(1.0, new Duration(TimeSpan.FromSeconds(0.125)));
			});
		}
	}

	private void SetItemPosition(int i, ref double offset)
	{
		if (GetItemFromIndex(i) is Control control)
		{
			if (!_sizes.TryGetValue(control, out var value))
			{
				value = 0.0;
			}
			if (!_translations.TryGetValue(control, out var value2))
			{
				value2 = TransformAnimator.GetTranslateTransform(control);
				_translations[control] = value2;
			}
			value2.X = offset;
			offset += value;
		}
	}
}
