using System;
using System.Collections.Specialized;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Animation;
using Microsoft.Phone.Controls.Properties;

namespace Microsoft.Phone.Controls;

[TemplatePart(Name = "ExpandedToCollapsedKeyFrame", Type = typeof(EasingDoubleKeyFrame))]
[TemplateVisualState(Name = "Collapsed", GroupName = "ExpansionStates")]
[TemplateVisualState(Name = "Expanded", GroupName = "ExpansionStates")]
[TemplatePart(Name = "CollapsedToExpandedKeyFrame", Type = typeof(EasingDoubleKeyFrame))]
[TemplateVisualState(Name = "Expandable", GroupName = "ExpandabilityStates")]
[TemplatePart(Name = "ExpandedStateAnimation", Type = typeof(DoubleAnimation))]
[TemplatePart(Name = "Presenter", Type = typeof(ItemsPresenter))]
[TemplateVisualState(Name = "NonExpandable", GroupName = "ExpandabilityStates")]
[TemplatePart(Name = "ExpanderPanel", Type = typeof(Grid))]
public class ExpanderView : HeaderedItemsControl
{
	public const string ExpansionStates = "ExpansionStates";

	public const string ExpandabilityStates = "ExpandabilityStates";

	public const string CollapsedState = "Collapsed";

	public const string ExpandedState = "Expanded";

	public const string ExpandableState = "Expandable";

	public const string NonExpandableState = "NonExpandable";

	private const string Presenter = "Presenter";

	private const string ExpanderPanel = "ExpanderPanel";

	private const string ExpandedStateAnimation = "ExpandedStateAnimation";

	private const string CollapsedToExpandedKeyFrame = "CollapsedToExpandedKeyFrame";

	private const string ExpandedToCollapsedKeyFrame = "ExpandedToCollapsedKeyFrame";

	private const int KeyTimeStep = 35;

	private const int InitialKeyTime = 225;

	private const int FinalKeyTime = 250;

	private ItemsPresenter _presenter;

	private Grid _expanderPanel;

	private DoubleAnimation _expandedStateAnimation;

	private EasingDoubleKeyFrame _collapsedToExpandedFrame;

	private EasingDoubleKeyFrame _expandedToCollapsedFrame;

	public static readonly DependencyProperty ExpanderProperty = DependencyProperty.Register("Expander", typeof(object), typeof(ExpanderView), new PropertyMetadata(null, OnExpanderPropertyChanged));

	public static readonly DependencyProperty ExpanderTemplateProperty = DependencyProperty.Register("ExpanderTemplate", typeof(DataTemplate), typeof(ExpanderView), new PropertyMetadata(null, OnExpanderTemplatePropertyChanged));

	public static readonly DependencyProperty NonExpandableHeaderProperty = DependencyProperty.Register("NonExpandableHeader", typeof(object), typeof(ExpanderView), new PropertyMetadata(null, OnNonExpandableHeaderPropertyChanged));

	public static readonly DependencyProperty NonExpandableHeaderTemplateProperty = DependencyProperty.Register("NonExpandableHeaderTemplate", typeof(DataTemplate), typeof(ExpanderView), new PropertyMetadata(null, OnNonExpandableHeaderTemplatePropertyChanged));

	public static readonly DependencyProperty IsExpandedProperty = DependencyProperty.Register("IsExpanded", typeof(bool), typeof(ExpanderView), new PropertyMetadata(false, OnIsExpandedPropertyChanged));

	public static readonly DependencyProperty HasItemsProperty = DependencyProperty.Register("HasItems", typeof(bool), typeof(ExpanderView), new PropertyMetadata(false, null));

	public static readonly DependencyProperty IsNonExpandableProperty = DependencyProperty.Register("IsNonExpandable", typeof(bool), typeof(ExpanderView), new PropertyMetadata(false, OnIsNonExpandablePropertyChanged));

	public object Expander
	{
		get
		{
			return GetValue(ExpanderProperty);
		}
		set
		{
			SetValue(ExpanderProperty, value);
		}
	}

	public DataTemplate ExpanderTemplate
	{
		get
		{
			return (DataTemplate)GetValue(ExpanderTemplateProperty);
		}
		set
		{
			SetValue(ExpanderTemplateProperty, value);
		}
	}

	public object NonExpandableHeader
	{
		get
		{
			return GetValue(NonExpandableHeaderProperty);
		}
		set
		{
			SetValue(NonExpandableHeaderProperty, value);
		}
	}

	public DataTemplate NonExpandableHeaderTemplate
	{
		get
		{
			return (DataTemplate)GetValue(NonExpandableHeaderTemplateProperty);
		}
		set
		{
			SetValue(NonExpandableHeaderTemplateProperty, value);
		}
	}

	public bool IsExpanded
	{
		get
		{
			return (bool)GetValue(IsExpandedProperty);
		}
		set
		{
			if (!IsNonExpandable)
			{
				SetValue(IsExpandedProperty, value);
				return;
			}
			throw new InvalidOperationException(Microsoft.Phone.Controls.Properties.Resources.InvalidExpanderViewOperation);
		}
	}

	public bool HasItems
	{
		get
		{
			return (bool)GetValue(HasItemsProperty);
		}
		set
		{
			SetValue(HasItemsProperty, value);
		}
	}

	public bool IsNonExpandable
	{
		get
		{
			return (bool)GetValue(IsNonExpandableProperty);
		}
		set
		{
			SetValue(IsNonExpandableProperty, value);
		}
	}

	public event RoutedEventHandler Expanded;

	public event RoutedEventHandler Collapsed;

	private static void OnExpanderPropertyChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		ExpanderView expanderView = (ExpanderView)obj;
		expanderView.OnExpanderChanged(e.OldValue, e.NewValue);
	}

	private static void OnExpanderTemplatePropertyChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		ExpanderView expanderView = (ExpanderView)obj;
		expanderView.OnExpanderTemplateChanged((DataTemplate)e.OldValue, (DataTemplate)e.NewValue);
	}

	private static void OnNonExpandableHeaderPropertyChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		ExpanderView expanderView = (ExpanderView)obj;
		expanderView.OnNonExpandableHeaderChanged(e.OldValue, e.NewValue);
	}

	private static void OnNonExpandableHeaderTemplatePropertyChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		ExpanderView expanderView = (ExpanderView)obj;
		expanderView.OnNonExpandableHeaderTemplateChanged((DataTemplate)e.OldValue, (DataTemplate)e.NewValue);
	}

	private static void OnIsExpandedPropertyChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		ExpanderView expanderView = (ExpanderView)obj;
		RoutedEventArgs e2 = new RoutedEventArgs();
		if ((bool)e.NewValue)
		{
			expanderView.OnExpanded(e2);
		}
		else
		{
			expanderView.OnCollapsed(e2);
		}
		expanderView.UpdateVisualState(useTransitions: true);
	}

	private static void OnIsNonExpandablePropertyChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		ExpanderView expanderView = (ExpanderView)obj;
		if ((bool)e.NewValue && expanderView.IsExpanded)
		{
			expanderView.IsExpanded = false;
		}
		expanderView.UpdateVisualState(useTransitions: true);
	}

	public override void OnApplyTemplate()
	{
		if (_expanderPanel != null)
		{
			_expanderPanel.Tap -= OnExpanderPanelTap;
		}
		base.OnApplyTemplate();
		_expanderPanel = GetTemplateChild("ExpanderPanel") as Grid;
		_expandedStateAnimation = (GetTemplateChild("Expanded") as VisualState).Storyboard.Children[0] as DoubleAnimation;
		_expandedToCollapsedFrame = GetTemplateChild("ExpandedToCollapsedKeyFrame") as EasingDoubleKeyFrame;
		_collapsedToExpandedFrame = GetTemplateChild("CollapsedToExpandedKeyFrame") as EasingDoubleKeyFrame;
		_presenter = GetTemplateChild("Presenter") as ItemsPresenter;
		if (_expanderPanel != null)
		{
			_expanderPanel.Tap += OnExpanderPanelTap;
		}
		UpdateVisualState(useTransitions: false);
	}

	public ExpanderView()
	{
		base.DefaultStyleKey = typeof(ExpanderView);
		base.SizeChanged += ExpanderView_SizeChanged;
	}

	private void ExpanderView_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		if (_presenter != null)
		{
			UIElement uIElement = VisualTreeHelper.GetParent(_presenter) as UIElement;
			while (!(uIElement is ExpanderView))
			{
				uIElement = VisualTreeHelper.GetParent(uIElement) as UIElement;
			}
			GeneralTransform generalTransform = uIElement.TransformToVisual(_presenter);
			Point point = generalTransform.Transform(new Point(0.0, 0.0));
			_presenter.Width = uIElement.RenderSize.Width + point.X;
		}
	}

	internal virtual void UpdateVisualState(bool useTransitions)
	{
		if (_presenter != null)
		{
			if (_expandedStateAnimation != null)
			{
				_expandedStateAnimation.To = _presenter.DesiredSize.Height;
			}
			if (_collapsedToExpandedFrame != null)
			{
				_collapsedToExpandedFrame.Value = _presenter.DesiredSize.Height;
			}
			if (_expandedToCollapsedFrame != null)
			{
				_expandedToCollapsedFrame.Value = _presenter.DesiredSize.Height;
			}
		}
		string stateName;
		if (IsExpanded)
		{
			stateName = "Expanded";
			if (useTransitions)
			{
				AnimateContainerDropDown();
			}
		}
		else
		{
			stateName = "Collapsed";
		}
		VisualStateManager.GoToState(this, stateName, useTransitions);
		string stateName2 = ((!IsNonExpandable) ? "Expandable" : "NonExpandable");
		VisualStateManager.GoToState(this, stateName2, useTransitions);
	}

	private void RaiseEvent(RoutedEventHandler handler, RoutedEventArgs args)
	{
		handler?.Invoke(this, args);
	}

	internal void AnimateContainerDropDown()
	{
		for (int i = 0; i < base.Items.Count && base.ItemContainerGenerator.ContainerFromIndex(i) is FrameworkElement frameworkElement; i++)
		{
			Storyboard storyboard = new Storyboard();
			QuadraticEase quadraticEase = new QuadraticEase();
			quadraticEase.EasingMode = EasingMode.EaseOut;
			IEasingFunction easingFunction = quadraticEase;
			int num = 225 + 35 * i;
			int num2 = 250 + 35 * i;
			TranslateTransform target = (TranslateTransform)(frameworkElement.RenderTransform = new TranslateTransform());
			DoubleAnimationUsingKeyFrames doubleAnimationUsingKeyFrames = new DoubleAnimationUsingKeyFrames();
			EasingDoubleKeyFrame easingDoubleKeyFrame = new EasingDoubleKeyFrame();
			easingDoubleKeyFrame.EasingFunction = easingFunction;
			easingDoubleKeyFrame.KeyTime = TimeSpan.FromMilliseconds(0.0);
			easingDoubleKeyFrame.Value = -150.0;
			EasingDoubleKeyFrame easingDoubleKeyFrame2 = new EasingDoubleKeyFrame();
			easingDoubleKeyFrame2.EasingFunction = easingFunction;
			easingDoubleKeyFrame2.KeyTime = TimeSpan.FromMilliseconds(num);
			easingDoubleKeyFrame2.Value = 0.0;
			EasingDoubleKeyFrame easingDoubleKeyFrame3 = new EasingDoubleKeyFrame();
			easingDoubleKeyFrame3.EasingFunction = easingFunction;
			easingDoubleKeyFrame3.KeyTime = TimeSpan.FromMilliseconds(num2);
			easingDoubleKeyFrame3.Value = 0.0;
			doubleAnimationUsingKeyFrames.KeyFrames.Add(easingDoubleKeyFrame);
			doubleAnimationUsingKeyFrames.KeyFrames.Add(easingDoubleKeyFrame2);
			doubleAnimationUsingKeyFrames.KeyFrames.Add(easingDoubleKeyFrame3);
			Storyboard.SetTarget(doubleAnimationUsingKeyFrames, target);
			Storyboard.SetTargetProperty(doubleAnimationUsingKeyFrames, new PropertyPath(TranslateTransform.YProperty));
			storyboard.Children.Add(doubleAnimationUsingKeyFrames);
			DoubleAnimationUsingKeyFrames doubleAnimationUsingKeyFrames2 = new DoubleAnimationUsingKeyFrames();
			EasingDoubleKeyFrame easingDoubleKeyFrame4 = new EasingDoubleKeyFrame();
			easingDoubleKeyFrame4.EasingFunction = easingFunction;
			easingDoubleKeyFrame4.KeyTime = TimeSpan.FromMilliseconds(0.0);
			easingDoubleKeyFrame4.Value = 0.0;
			EasingDoubleKeyFrame easingDoubleKeyFrame5 = new EasingDoubleKeyFrame();
			easingDoubleKeyFrame5.EasingFunction = easingFunction;
			easingDoubleKeyFrame5.KeyTime = TimeSpan.FromMilliseconds(num - 150);
			easingDoubleKeyFrame5.Value = 0.0;
			EasingDoubleKeyFrame easingDoubleKeyFrame6 = new EasingDoubleKeyFrame();
			easingDoubleKeyFrame6.EasingFunction = easingFunction;
			easingDoubleKeyFrame6.KeyTime = TimeSpan.FromMilliseconds(num2);
			easingDoubleKeyFrame6.Value = 1.0;
			doubleAnimationUsingKeyFrames2.KeyFrames.Add(easingDoubleKeyFrame4);
			doubleAnimationUsingKeyFrames2.KeyFrames.Add(easingDoubleKeyFrame5);
			doubleAnimationUsingKeyFrames2.KeyFrames.Add(easingDoubleKeyFrame6);
			Storyboard.SetTarget(doubleAnimationUsingKeyFrames2, frameworkElement);
			Storyboard.SetTargetProperty(doubleAnimationUsingKeyFrames2, new PropertyPath(UIElement.OpacityProperty));
			storyboard.Children.Add(doubleAnimationUsingKeyFrames2);
			storyboard.Begin();
		}
	}

	protected override void OnItemsChanged(NotifyCollectionChangedEventArgs e)
	{
		base.OnItemsChanged(e);
		HasItems = base.Items.Count > 0;
	}

	private void OnExpanderPanelTap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		if (!IsNonExpandable)
		{
			IsExpanded = !IsExpanded;
		}
	}

	protected virtual void OnExpanderChanged(object oldExpander, object newExpander)
	{
	}

	protected virtual void OnExpanderTemplateChanged(DataTemplate oldTemplate, DataTemplate newTemplate)
	{
	}

	protected virtual void OnNonExpandableHeaderChanged(object oldHeader, object newHeader)
	{
	}

	protected virtual void OnNonExpandableHeaderTemplateChanged(DataTemplate oldTemplate, DataTemplate newTemplate)
	{
	}

	protected virtual void OnExpanded(RoutedEventArgs e)
	{
		RaiseEvent(this.Expanded, e);
	}

	protected virtual void OnCollapsed(RoutedEventArgs e)
	{
		RaiseEvent(this.Collapsed, e);
	}
}
