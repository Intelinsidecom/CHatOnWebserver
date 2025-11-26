using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace ChatOn.Infrastructure;

public class VariableGridView : GridView
{
	protected override void PrepareContainerForItemOverride(DependencyObject element, object item)
	{
		if (item is IVariableSizedWrapGridItem variableSizedWrapGridItem)
		{
			element.SetValue(VariableSizedWrapGrid.ColumnSpanProperty, (object)1);
			element.SetValue(VariableSizedWrapGrid.RowSpanProperty, (object)variableSizedWrapGridItem.RowSpan);
			((ItemsControl)this).PrepareContainerForItemOverride(element, item);
		}
	}
}
