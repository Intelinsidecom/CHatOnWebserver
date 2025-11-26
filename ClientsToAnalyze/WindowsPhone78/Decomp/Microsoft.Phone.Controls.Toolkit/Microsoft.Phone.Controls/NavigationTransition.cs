using System.Windows;

namespace Microsoft.Phone.Controls;

public class NavigationTransition : DependencyObject
{
	public static readonly DependencyProperty BackwardProperty = DependencyProperty.Register("Backward", typeof(TransitionElement), typeof(NavigationTransition), null);

	public static readonly DependencyProperty ForwardProperty = DependencyProperty.Register("Forward", typeof(TransitionElement), typeof(NavigationTransition), null);

	public TransitionElement Backward
	{
		get
		{
			return (TransitionElement)GetValue(BackwardProperty);
		}
		set
		{
			SetValue(BackwardProperty, value);
		}
	}

	public TransitionElement Forward
	{
		get
		{
			return (TransitionElement)GetValue(ForwardProperty);
		}
		set
		{
			SetValue(ForwardProperty, value);
		}
	}

	public event RoutedEventHandler BeginTransition;

	public event RoutedEventHandler EndTransition;

	internal void OnBeginTransition()
	{
		if (this.BeginTransition != null)
		{
			this.BeginTransition(this, new RoutedEventArgs());
		}
	}

	internal void OnEndTransition()
	{
		if (this.EndTransition != null)
		{
			this.EndTransition(this, new RoutedEventArgs());
		}
	}
}
