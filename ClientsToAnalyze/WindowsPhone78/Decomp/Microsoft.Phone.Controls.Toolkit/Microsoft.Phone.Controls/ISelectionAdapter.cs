using System.Collections;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Controls;
using System.Windows.Input;

namespace Microsoft.Phone.Controls;

public interface ISelectionAdapter
{
	object SelectedItem { get; set; }

	IEnumerable ItemsSource { get; set; }

	event SelectionChangedEventHandler SelectionChanged;

	event RoutedEventHandler Commit;

	event RoutedEventHandler Cancel;

	void HandleKeyDown(KeyEventArgs e);

	AutomationPeer CreateAutomationPeer();
}
