using System.Windows;
using System.Windows.Data;

namespace Microsoft.Phone.Controls;

internal class BindingEvaluator<T> : FrameworkElement
{
	private Binding _binding;

	public static readonly DependencyProperty ValueProperty = DependencyProperty.Register("Value", typeof(T), typeof(BindingEvaluator<T>), new PropertyMetadata(default(T)));

	public T Value
	{
		get
		{
			return (T)GetValue(ValueProperty);
		}
		set
		{
			SetValue(ValueProperty, value);
		}
	}

	public Binding ValueBinding
	{
		get
		{
			return _binding;
		}
		set
		{
			_binding = value;
			SetBinding(ValueProperty, _binding);
		}
	}

	public BindingEvaluator()
	{
	}

	public BindingEvaluator(Binding binding)
	{
		SetBinding(ValueProperty, binding);
	}

	public void ClearDataContext()
	{
		base.DataContext = null;
	}

	public T GetDynamicValue(object o, bool clearDataContext)
	{
		base.DataContext = o;
		T value = Value;
		if (clearDataContext)
		{
			base.DataContext = null;
		}
		return value;
	}

	public T GetDynamicValue(object o)
	{
		base.DataContext = o;
		return Value;
	}
}
