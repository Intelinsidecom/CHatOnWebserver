using System.Windows;

namespace Microsoft.Phone.Controls;

public class PopulatingEventArgs : RoutedEventArgs
{
	public string Parameter { get; private set; }

	public bool Cancel { get; set; }

	public PopulatingEventArgs(string parameter)
	{
		Parameter = parameter;
	}
}
