using System.Collections;
using System.Windows;

namespace Microsoft.Phone.Controls;

public class PopulatedEventArgs : RoutedEventArgs
{
	public IEnumerable Data { get; private set; }

	public PopulatedEventArgs(IEnumerable data)
	{
		Data = data;
	}
}
