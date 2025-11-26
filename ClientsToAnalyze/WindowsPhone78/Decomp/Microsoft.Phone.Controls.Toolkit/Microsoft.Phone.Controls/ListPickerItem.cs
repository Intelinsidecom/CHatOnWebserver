using System.Windows;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls;

[TemplateVisualState(GroupName = "SelectionStates", Name = "Unselected")]
[TemplateVisualState(GroupName = "SelectionStates", Name = "Selected")]
public class ListPickerItem : ContentControl
{
	private const string SelectionStatesGroupName = "SelectionStates";

	private const string SelectionStatesUnselectedStateName = "Unselected";

	private const string SelectionStatesSelectedStateName = "Selected";

	private bool _isSelected;

	internal bool IsSelected
	{
		get
		{
			return _isSelected;
		}
		set
		{
			_isSelected = value;
			VisualStateManager.GoToState(this, _isSelected ? "Selected" : "Unselected", useTransitions: true);
		}
	}

	public ListPickerItem()
	{
		base.DefaultStyleKey = typeof(ListPickerItem);
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		VisualStateManager.GoToState(this, IsSelected ? "Selected" : "Unselected", useTransitions: false);
	}
}
