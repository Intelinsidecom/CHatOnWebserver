using System;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls.Primitives;

public interface ILoopingSelectorDataSource
{
	object SelectedItem { get; set; }

	event EventHandler<SelectionChangedEventArgs> SelectionChanged;

	object GetNext(object relativeTo);

	object GetPrevious(object relativeTo);
}
