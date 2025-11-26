using System;
using System.Windows;
using Microsoft.Phone.Controls.Properties;

namespace Microsoft.Phone.Controls;

public class RoutedPropertyChangingEventArgs<T> : RoutedEventArgs
{
	private bool _cancel;

	public DependencyProperty Property { get; private set; }

	public T OldValue { get; private set; }

	public T NewValue { get; set; }

	public bool IsCancelable { get; private set; }

	public bool Cancel
	{
		get
		{
			return _cancel;
		}
		set
		{
			if (IsCancelable)
			{
				_cancel = value;
			}
			else if (value)
			{
				throw new InvalidOperationException(Microsoft.Phone.Controls.Properties.Resources.RoutedPropertyChangingEventArgs_CancelSet_InvalidOperation);
			}
		}
	}

	public bool InCoercion { get; set; }

	public RoutedPropertyChangingEventArgs(DependencyProperty property, T oldValue, T newValue, bool isCancelable)
	{
		Property = property;
		OldValue = oldValue;
		NewValue = newValue;
		IsCancelable = isCancelable;
		Cancel = false;
	}
}
