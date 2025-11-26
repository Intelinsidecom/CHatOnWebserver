using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Input;
using System.Windows.Shapes;

namespace Microsoft.Phone.Controls;

[TemplatePart(Name = "InnerHintPanel", Type = typeof(Rectangle))]
[TemplateVisualState(Name = "Exposed", GroupName = "SelectionEnabledStates")]
[TemplatePart(Name = "OutterCover", Type = typeof(Grid))]
[TemplatePart(Name = "InfoPresenter", Type = typeof(ContentControl))]
[TemplateVisualState(Name = "Opened", GroupName = "SelectionEnabledStates")]
[TemplatePart(Name = "OutterHintPanel", Type = typeof(Rectangle))]
[TemplateVisualState(Name = "Closed", GroupName = "SelectionEnabledStates")]
public class MultiselectItem : ContentControl
{
	private const string SelectionEnabledStates = "SelectionEnabledStates";

	private const string Closed = "Closed";

	private const string Exposed = "Exposed";

	private const string Opened = "Opened";

	private const string SelectBox = "SelectBox";

	private const string OutterHintPanel = "OutterHintPanel";

	private const string InnerHintPanel = "InnerHintPanel";

	private const string OutterCover = "OutterCover";

	private const string InfoPresenter = "InfoPresenter";

	private const double _deltaLimitX = 0.0;

	private const double _deltaLimitY = 0.4;

	private Rectangle _outterHintPanel;

	private Rectangle _innerHintPanel;

	private Grid _outterCover;

	private ContentControl _infoPresenter;

	private MultiselectList _parent;

	private double _manipulationDeltaX;

	private double _manipulationDeltaY;

	internal bool _isBeingVirtualized;

	internal bool _canTriggerSelectionChanged = true;

	public static readonly DependencyProperty IsSelectedProperty = DependencyProperty.Register("IsSelected", typeof(bool), typeof(MultiselectItem), new PropertyMetadata(false, OnIsSelectedPropertyChanged));

	internal static readonly DependencyProperty StateProperty = DependencyProperty.Register("State", typeof(SelectionEnabledState), typeof(MultiselectItem), new PropertyMetadata(SelectionEnabledState.Closed, null));

	public static readonly DependencyProperty HintPanelHeightProperty = DependencyProperty.Register("HintPanelHeight", typeof(double), typeof(MultiselectItem), new PropertyMetadata(double.NaN, null));

	public static readonly DependencyProperty ContentInfoProperty = DependencyProperty.Register("ContentInfo", typeof(object), typeof(MultiselectItem), new PropertyMetadata(null, OnContentInfoPropertyChanged));

	public static readonly DependencyProperty ContentInfoTemplateProperty = DependencyProperty.Register("ContentInfoTemplate", typeof(DataTemplate), typeof(MultiselectItem), new PropertyMetadata(null, OnContentInfoTemplatePropertyChanged));

	public bool IsSelected
	{
		get
		{
			return (bool)GetValue(IsSelectedProperty);
		}
		set
		{
			SetValue(IsSelectedProperty, value);
		}
	}

	internal SelectionEnabledState State
	{
		get
		{
			return (SelectionEnabledState)GetValue(StateProperty);
		}
		set
		{
			SetValue(StateProperty, value);
		}
	}

	public double HintPanelHeight
	{
		get
		{
			return (double)GetValue(HintPanelHeightProperty);
		}
		set
		{
			SetValue(HintPanelHeightProperty, value);
		}
	}

	public object ContentInfo
	{
		get
		{
			return GetValue(ContentInfoProperty);
		}
		set
		{
			SetValue(ContentInfoProperty, value);
		}
	}

	public DataTemplate ContentInfoTemplate
	{
		get
		{
			return (DataTemplate)GetValue(ContentInfoTemplateProperty);
		}
		set
		{
			SetValue(ContentInfoTemplateProperty, value);
		}
	}

	public event RoutedEventHandler Selected;

	public event RoutedEventHandler Unselected;

	private static void OnIsSelectedPropertyChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		MultiselectItem multiselectItem = (MultiselectItem)obj;
		RoutedEventArgs e2 = new RoutedEventArgs();
		bool flag = (bool)e.NewValue;
		if (flag)
		{
			multiselectItem.OnSelected(e2);
		}
		else
		{
			multiselectItem.OnUnselected(e2);
		}
		if (multiselectItem._parent == null || multiselectItem._isBeingVirtualized)
		{
			return;
		}
		if (flag)
		{
			multiselectItem._parent.SelectedItems.Add(multiselectItem.Content);
			if (multiselectItem._canTriggerSelectionChanged)
			{
				multiselectItem._parent.OnSelectionChanged(new object[0], new object[1] { multiselectItem.Content });
			}
		}
		else
		{
			multiselectItem._parent.SelectedItems.Remove(multiselectItem.Content);
			if (multiselectItem._canTriggerSelectionChanged)
			{
				multiselectItem._parent.OnSelectionChanged(new object[1] { multiselectItem.Content }, new object[0]);
			}
		}
	}

	private static void OnHintPanelHeightPropertyChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		MultiselectItem multiselectItem = (MultiselectItem)obj;
		if (multiselectItem._outterHintPanel != null)
		{
			if (double.IsNaN((double)e.NewValue))
			{
				multiselectItem._outterHintPanel.VerticalAlignment = VerticalAlignment.Stretch;
			}
			else
			{
				multiselectItem._outterHintPanel.VerticalAlignment = VerticalAlignment.Top;
			}
		}
		if (multiselectItem._innerHintPanel != null)
		{
			if (double.IsNaN(multiselectItem.HintPanelHeight))
			{
				multiselectItem._innerHintPanel.VerticalAlignment = VerticalAlignment.Stretch;
			}
			else
			{
				multiselectItem._innerHintPanel.VerticalAlignment = VerticalAlignment.Top;
			}
		}
	}

	private static void OnContentInfoPropertyChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		MultiselectItem multiselectItem = (MultiselectItem)obj;
		multiselectItem.OnContentInfoChanged(e.OldValue, e.NewValue);
	}

	private static void OnContentInfoTemplatePropertyChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		MultiselectItem multiselectItem = (MultiselectItem)obj;
		DataTemplate oldContentInfoTemplate = e.OldValue as DataTemplate;
		DataTemplate newContentInfoTemplate = e.NewValue as DataTemplate;
		multiselectItem.OnContentInfoTemplateChanged(oldContentInfoTemplate, newContentInfoTemplate);
	}

	public override void OnApplyTemplate()
	{
		_parent = ItemsControlExtensions.GetParentItemsControl<MultiselectList>(this);
		if (_innerHintPanel != null)
		{
			_innerHintPanel.ManipulationStarted -= HintPanel_ManipulationStarted;
			_innerHintPanel.ManipulationDelta -= HintPanel_ManipulationDelta;
			_innerHintPanel.ManipulationCompleted -= HintPanel_ManipulationCompleted;
		}
		if (_outterHintPanel != null)
		{
			_outterHintPanel.ManipulationStarted -= HintPanel_ManipulationStarted;
			_outterHintPanel.ManipulationDelta -= HintPanel_ManipulationDelta;
			_outterHintPanel.ManipulationCompleted -= HintPanel_ManipulationCompleted;
		}
		if (_outterCover != null)
		{
			_outterCover.Tap -= Cover_Tap;
		}
		_innerHintPanel = GetTemplateChild("InnerHintPanel") as Rectangle;
		_outterHintPanel = GetTemplateChild("OutterHintPanel") as Rectangle;
		_outterCover = GetTemplateChild("OutterCover") as Grid;
		_infoPresenter = GetTemplateChild("InfoPresenter") as ContentControl;
		base.OnApplyTemplate();
		if (_innerHintPanel != null)
		{
			_innerHintPanel.ManipulationStarted += HintPanel_ManipulationStarted;
			_innerHintPanel.ManipulationDelta += HintPanel_ManipulationDelta;
			_innerHintPanel.ManipulationCompleted += HintPanel_ManipulationCompleted;
		}
		if (_outterHintPanel != null)
		{
			_outterHintPanel.ManipulationStarted += HintPanel_ManipulationStarted;
			_outterHintPanel.ManipulationDelta += HintPanel_ManipulationDelta;
			_outterHintPanel.ManipulationCompleted += HintPanel_ManipulationCompleted;
		}
		if (_outterCover != null)
		{
			_outterCover.Tap += Cover_Tap;
		}
		if (ContentInfo == null && _parent != null && _parent.ItemInfoTemplate != null)
		{
			_infoPresenter.ContentTemplate = _parent.ItemInfoTemplate;
			Binding binding = new Binding();
			SetBinding(ContentInfoProperty, binding);
		}
		if (_outterHintPanel != null)
		{
			if (double.IsNaN(HintPanelHeight))
			{
				_outterHintPanel.VerticalAlignment = VerticalAlignment.Stretch;
			}
			else
			{
				_outterHintPanel.VerticalAlignment = VerticalAlignment.Top;
			}
		}
		if (_innerHintPanel != null)
		{
			if (double.IsNaN(HintPanelHeight))
			{
				_innerHintPanel.VerticalAlignment = VerticalAlignment.Stretch;
			}
			else
			{
				_innerHintPanel.VerticalAlignment = VerticalAlignment.Top;
			}
		}
		UpdateVisualState(useTransitions: false);
	}

	public MultiselectItem()
	{
		base.DefaultStyleKey = typeof(MultiselectItem);
	}

	internal void UpdateVisualState(bool useTransitions)
	{
		VisualStateManager.GoToState(this, State switch
		{
			SelectionEnabledState.Closed => "Closed", 
			SelectionEnabledState.Exposed => "Exposed", 
			SelectionEnabledState.Opened => "Opened", 
			_ => "Closed", 
		}, useTransitions);
	}

	private void RaiseEvent(RoutedEventHandler handler, RoutedEventArgs args)
	{
		handler?.Invoke(this, args);
	}

	protected virtual void OnSelected(RoutedEventArgs e)
	{
		if (_parent == null)
		{
			State = SelectionEnabledState.Opened;
			UpdateVisualState(useTransitions: true);
		}
		RaiseEvent(this.Selected, e);
	}

	protected virtual void OnUnselected(RoutedEventArgs e)
	{
		if (_parent == null)
		{
			State = SelectionEnabledState.Closed;
			UpdateVisualState(useTransitions: true);
		}
		RaiseEvent(this.Unselected, e);
	}

	protected virtual void OnContentInfoChanged(object oldContentInfo, object newContentInfo)
	{
	}

	protected virtual void OnContentInfoTemplateChanged(DataTemplate oldContentInfoTemplate, DataTemplate newContentInfoTemplate)
	{
	}

	private void HintPanel_ManipulationStarted(object sender, ManipulationStartedEventArgs e)
	{
		State = SelectionEnabledState.Exposed;
		UpdateVisualState(useTransitions: true);
	}

	private void HintPanel_ManipulationDelta(object sender, ManipulationDeltaEventArgs e)
	{
		_manipulationDeltaX = e.DeltaManipulation.Translation.X;
		_manipulationDeltaY = e.DeltaManipulation.Translation.Y;
		if (_manipulationDeltaX < 0.0)
		{
			_manipulationDeltaX *= -1.0;
		}
		if (_manipulationDeltaY < 0.0)
		{
			_manipulationDeltaY *= -1.0;
		}
		if (_manipulationDeltaX > 0.0 || _manipulationDeltaY >= 0.4)
		{
			State = SelectionEnabledState.Closed;
			UpdateVisualState(useTransitions: true);
		}
	}

	private void HintPanel_ManipulationCompleted(object sender, ManipulationCompletedEventArgs e)
	{
		if (_manipulationDeltaX == 0.0 && _manipulationDeltaY < 0.4)
		{
			IsSelected = true;
		}
		_manipulationDeltaX = 0.0;
		_manipulationDeltaY = 0.0;
	}

	private void Cover_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		IsSelected = !IsSelected;
	}
}
