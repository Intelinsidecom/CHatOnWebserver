using System.Windows.Controls;

namespace Microsoft.Phone.Controls.Primitives;

internal class TemplatedListBoxItem : ListBoxItem
{
	public LongListSelector.ItemTuple Tuple { get; set; }
}
