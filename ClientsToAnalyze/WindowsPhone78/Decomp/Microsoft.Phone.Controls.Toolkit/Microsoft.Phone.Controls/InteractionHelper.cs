using System.Windows;
using System.Windows.Controls;

namespace Microsoft.Phone.Controls;

internal sealed class InteractionHelper
{
	private const double SequentialClickThresholdInMilliseconds = 500.0;

	private const double SequentialClickThresholdInPixelsSquared = 9.0;

	private IUpdateVisualState _updateVisualState;

	public Control Control { get; private set; }

	public bool IsFocused { get; private set; }

	public bool IsMouseOver { get; private set; }

	public bool IsReadOnly { get; private set; }

	public bool IsPressed { get; private set; }

	public InteractionHelper(Control control)
	{
		Control = control;
		_updateVisualState = control as IUpdateVisualState;
		control.Loaded += OnLoaded;
		control.IsEnabledChanged += OnIsEnabledChanged;
	}

	private void UpdateVisualState(bool useTransitions)
	{
		if (_updateVisualState != null)
		{
			_updateVisualState.UpdateVisualState(useTransitions);
		}
	}

	public void UpdateVisualStateBase(bool useTransitions)
	{
		if (!Control.IsEnabled)
		{
			VisualStates.GoToState(Control, useTransitions, "Disabled", "Normal");
		}
		else if (IsReadOnly)
		{
			VisualStates.GoToState(Control, useTransitions, "ReadOnly", "Normal");
		}
		else if (IsPressed)
		{
			VisualStates.GoToState(Control, useTransitions, "Pressed", "MouseOver", "Normal");
		}
		else if (IsMouseOver)
		{
			VisualStates.GoToState(Control, useTransitions, "MouseOver", "Normal");
		}
		else
		{
			VisualStates.GoToState(Control, useTransitions, "Normal");
		}
		if (IsFocused)
		{
			VisualStates.GoToState(Control, useTransitions, "Focused", "Unfocused");
		}
		else
		{
			VisualStates.GoToState(Control, useTransitions, "Unfocused");
		}
	}

	private void OnLoaded(object sender, RoutedEventArgs e)
	{
		UpdateVisualState(useTransitions: false);
	}

	private void OnIsEnabledChanged(object sender, DependencyPropertyChangedEventArgs e)
	{
		if (!(bool)e.NewValue)
		{
			IsPressed = false;
			IsMouseOver = false;
			IsFocused = false;
		}
		UpdateVisualState(useTransitions: true);
	}

	public void OnIsReadOnlyChanged(bool value)
	{
		IsReadOnly = value;
		if (!value)
		{
			IsPressed = false;
			IsMouseOver = false;
			IsFocused = false;
		}
		UpdateVisualState(useTransitions: true);
	}

	public void OnApplyTemplateBase()
	{
		UpdateVisualState(useTransitions: false);
	}
}
