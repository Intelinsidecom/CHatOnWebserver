using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;

namespace Microsoft.Phone.Controls.Primitives;

[TemplateVisualState(Name = "Selected", GroupName = "SelectionStates")]
[TemplateVisualState(Name = "Unselected", GroupName = "SelectionStates")]
public class PivotHeaderItem : ContentControl
{
	private const string SelectedState = "Selected";

	private const string UnselectedState = "Unselected";

	private const string SelectionStatesGroup = "SelectionStates";

	public static readonly DependencyProperty IsSelectedProperty = DependencyProperty.Register("IsSelected", typeof(bool), typeof(PivotHeaderItem), new PropertyMetadata(false, OnIsSelectedPropertyChanged));

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

	internal PivotHeadersControl ParentHeadersControl { get; set; }

	internal object Item { get; set; }

	private static void OnIsSelectedPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		PivotHeaderItem pivotHeaderItem = d as PivotHeaderItem;
		if (pivotHeaderItem.ParentHeadersControl != null)
		{
			pivotHeaderItem.ParentHeadersControl.NotifyHeaderItemSelected(pivotHeaderItem, (bool)e.NewValue);
			pivotHeaderItem.UpdateVisualStates(useTransitions: true);
		}
	}

	public PivotHeaderItem()
	{
		base.DefaultStyleKey = typeof(PivotHeaderItem);
	}

	protected override void OnMouseLeftButtonUp(MouseButtonEventArgs e)
	{
		base.OnMouseLeftButtonUp(e);
		if (e != null && !e.Handled)
		{
			e.Handled = true;
			if (ParentHeadersControl != null)
			{
				ParentHeadersControl.OnHeaderItemClicked(this);
			}
		}
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		UpdateVisualStates(useTransitions: false);
	}

	internal void UpdateVisualStateToUnselected()
	{
		VisualStateManager.GoToState(this, "Unselected", useTransitions: false);
	}

	internal void RestoreVisualStates()
	{
		UpdateVisualStates(useTransitions: false);
	}

	private void UpdateVisualStates(bool useTransitions)
	{
		VisualStateManager.GoToState(this, IsSelected ? "Selected" : "Unselected", useTransitions);
	}
}
