using System;
using System.Collections.Specialized;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using Microsoft.Phone.Controls.Primitives;

namespace Microsoft.Phone.Controls;

[TemplateVisualState(Name = "Disabled", GroupName = "CommonStates")]
[StyleTypedProperty(Property = "ItemContainerStyle", StyleTargetType = typeof(MenuItem))]
[TemplateVisualState(Name = "Normal", GroupName = "CommonStates")]
[TemplateVisualState(Name = "Unfocused", GroupName = "FocusStates")]
[TemplateVisualState(Name = "Focused", GroupName = "FocusStates")]
public class MenuItem : HeaderedItemsControl
{
	private bool _isFocused;

	public static readonly DependencyProperty CommandProperty = DependencyProperty.Register("Command", typeof(ICommand), typeof(MenuItem), new PropertyMetadata(null, OnCommandChanged));

	public static readonly DependencyProperty CommandParameterProperty = DependencyProperty.Register("CommandParameter", typeof(object), typeof(MenuItem), new PropertyMetadata(null, OnCommandParameterChanged));

	internal MenuBase ParentMenuBase { get; set; }

	public ICommand Command
	{
		get
		{
			return (ICommand)GetValue(CommandProperty);
		}
		set
		{
			SetValue(CommandProperty, value);
		}
	}

	public object CommandParameter
	{
		get
		{
			return GetValue(CommandParameterProperty);
		}
		set
		{
			SetValue(CommandParameterProperty, value);
		}
	}

	public event RoutedEventHandler Click;

	private static void OnCommandChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		((MenuItem)o).OnCommandChanged((ICommand)e.OldValue, (ICommand)e.NewValue);
	}

	private void OnCommandChanged(ICommand oldValue, ICommand newValue)
	{
		if (oldValue != null)
		{
			oldValue.CanExecuteChanged -= HandleCanExecuteChanged;
		}
		if (newValue != null)
		{
			newValue.CanExecuteChanged += HandleCanExecuteChanged;
		}
		UpdateIsEnabled(changeVisualState: true);
	}

	private static void OnCommandParameterChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		((MenuItem)o).OnCommandParameterChanged();
	}

	private void OnCommandParameterChanged()
	{
		UpdateIsEnabled(changeVisualState: true);
	}

	public MenuItem()
	{
		base.DefaultStyleKey = typeof(MenuItem);
		base.IsEnabledChanged += HandleIsEnabledChanged;
		SetValue(TiltEffect.IsTiltEnabledProperty, true);
		base.Loaded += HandleLoaded;
		UpdateIsEnabled(changeVisualState: false);
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		ChangeVisualState(useTransitions: false);
	}

	protected override void OnGotFocus(RoutedEventArgs e)
	{
		base.OnGotFocus(e);
		_isFocused = true;
		ChangeVisualState(useTransitions: true);
	}

	protected override void OnLostFocus(RoutedEventArgs e)
	{
		base.OnLostFocus(e);
		_isFocused = false;
		ChangeVisualState(useTransitions: true);
	}

	protected override void OnMouseEnter(MouseEventArgs e)
	{
		base.OnMouseEnter(e);
		Focus();
		ChangeVisualState(useTransitions: true);
	}

	protected override void OnMouseLeave(MouseEventArgs e)
	{
		base.OnMouseLeave(e);
		if (ParentMenuBase != null)
		{
			ParentMenuBase.Focus();
		}
		ChangeVisualState(useTransitions: true);
	}

	protected override void OnMouseLeftButtonUp(MouseButtonEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (!e.Handled)
		{
			OnClick();
			e.Handled = true;
		}
		base.OnMouseLeftButtonUp(e);
	}

	protected override void OnKeyDown(KeyEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (!e.Handled && Key.Enter == e.Key)
		{
			OnClick();
			e.Handled = true;
		}
		base.OnKeyDown(e);
	}

	protected override void OnItemsChanged(NotifyCollectionChangedEventArgs e)
	{
		throw new NotImplementedException();
	}

	protected virtual void OnClick()
	{
		if (ParentMenuBase is ContextMenu contextMenu)
		{
			contextMenu.ChildMenuItemClicked();
		}
		this.Click?.Invoke(this, new RoutedEventArgs());
		if (Command != null && Command.CanExecute(CommandParameter))
		{
			Command.Execute(CommandParameter);
		}
	}

	private void HandleCanExecuteChanged(object sender, EventArgs e)
	{
		UpdateIsEnabled(changeVisualState: true);
	}

	private void UpdateIsEnabled(bool changeVisualState)
	{
		base.IsEnabled = Command == null || Command.CanExecute(CommandParameter);
		if (changeVisualState)
		{
			ChangeVisualState(useTransitions: true);
		}
	}

	private void HandleIsEnabledChanged(object sender, DependencyPropertyChangedEventArgs e)
	{
		ChangeVisualState(useTransitions: true);
	}

	private void HandleLoaded(object sender, RoutedEventArgs e)
	{
		ChangeVisualState(useTransitions: false);
	}

	protected virtual void ChangeVisualState(bool useTransitions)
	{
		if (!base.IsEnabled)
		{
			VisualStateManager.GoToState(this, "Disabled", useTransitions);
		}
		else
		{
			VisualStateManager.GoToState(this, "Normal", useTransitions);
		}
		if (_isFocused && base.IsEnabled)
		{
			VisualStateManager.GoToState(this, "Focused", useTransitions);
		}
		else
		{
			VisualStateManager.GoToState(this, "Unfocused", useTransitions);
		}
	}
}
