using System;
using System.ComponentModel;
using System.Globalization;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Media;

namespace Microsoft.Phone.Controls;

[TemplateVisualState(Name = "Disabled", GroupName = "CommonStates")]
[TemplateVisualState(Name = "Normal", GroupName = "CommonStates")]
[TemplatePart(Name = "Switch", Type = typeof(ToggleButton))]
public class ToggleSwitch : ContentControl
{
	private const string CommonStates = "CommonStates";

	private const string NormalState = "Normal";

	private const string DisabledState = "Disabled";

	private const string SwitchPart = "Switch";

	public static readonly DependencyProperty HeaderProperty = DependencyProperty.Register("Header", typeof(object), typeof(ToggleSwitch), new PropertyMetadata(null));

	public static readonly DependencyProperty HeaderTemplateProperty = DependencyProperty.Register("HeaderTemplate", typeof(DataTemplate), typeof(ToggleSwitch), new PropertyMetadata(null));

	public static readonly DependencyProperty SwitchForegroundProperty = DependencyProperty.Register("SwitchForeground", typeof(Brush), typeof(ToggleSwitch), null);

	public static readonly DependencyProperty IsCheckedProperty = DependencyProperty.Register("IsChecked", typeof(bool?), typeof(ToggleSwitch), new PropertyMetadata(false, OnIsCheckedChanged));

	private ToggleButton _toggleButton;

	private bool _wasContentSet;

	public object Header
	{
		get
		{
			return GetValue(HeaderProperty);
		}
		set
		{
			SetValue(HeaderProperty, value);
		}
	}

	public DataTemplate HeaderTemplate
	{
		get
		{
			return (DataTemplate)GetValue(HeaderTemplateProperty);
		}
		set
		{
			SetValue(HeaderTemplateProperty, value);
		}
	}

	public Brush SwitchForeground
	{
		get
		{
			return (Brush)GetValue(SwitchForegroundProperty);
		}
		set
		{
			SetValue(SwitchForegroundProperty, value);
		}
	}

	[TypeConverter(typeof(NullableBoolConverter))]
	public bool? IsChecked
	{
		get
		{
			return (bool?)GetValue(IsCheckedProperty);
		}
		set
		{
			SetValue(IsCheckedProperty, value);
		}
	}

	public event EventHandler<RoutedEventArgs> Checked;

	public event EventHandler<RoutedEventArgs> Unchecked;

	public event EventHandler<RoutedEventArgs> Indeterminate;

	public event EventHandler<RoutedEventArgs> Click;

	private static void OnIsCheckedChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		ToggleSwitch toggleSwitch = (ToggleSwitch)d;
		if (toggleSwitch._toggleButton != null)
		{
			toggleSwitch._toggleButton.IsChecked = (bool?)e.NewValue;
		}
	}

	public ToggleSwitch()
	{
		base.DefaultStyleKey = typeof(ToggleSwitch);
	}

	private void SetDefaultContent()
	{
		Binding binding = new Binding("IsChecked");
		binding.Source = this;
		binding.Converter = new OffOnConverter();
		Binding binding2 = binding;
		SetBinding(ContentControl.ContentProperty, binding2);
	}

	private void ChangeVisualState(bool useTransitions)
	{
		if (base.IsEnabled)
		{
			VisualStateManager.GoToState(this, "Normal", useTransitions);
		}
		else
		{
			VisualStateManager.GoToState(this, "Disabled", useTransitions);
		}
	}

	protected override void OnContentChanged(object oldContent, object newContent)
	{
		base.OnContentChanged(oldContent, newContent);
		_wasContentSet = true;
		if (DesignerProperties.IsInDesignTool && newContent == null && GetBindingExpression(ContentControl.ContentProperty) == null)
		{
			SetDefaultContent();
		}
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		if (!_wasContentSet && GetBindingExpression(ContentControl.ContentProperty) == null)
		{
			SetDefaultContent();
		}
		if (_toggleButton != null)
		{
			_toggleButton.Checked -= CheckedHandler;
			_toggleButton.Unchecked -= UncheckedHandler;
			_toggleButton.Indeterminate -= IndeterminateHandler;
			_toggleButton.Click -= ClickHandler;
		}
		_toggleButton = GetTemplateChild("Switch") as ToggleButton;
		if (_toggleButton != null)
		{
			_toggleButton.Checked += CheckedHandler;
			_toggleButton.Unchecked += UncheckedHandler;
			_toggleButton.Indeterminate += IndeterminateHandler;
			_toggleButton.Click += ClickHandler;
			_toggleButton.IsChecked = IsChecked;
		}
		base.IsEnabledChanged += delegate
		{
			ChangeVisualState(useTransitions: true);
		};
		ChangeVisualState(useTransitions: false);
	}

	private void CheckedHandler(object sender, RoutedEventArgs e)
	{
		IsChecked = true;
		Microsoft.Phone.Controls.SafeRaise.Raise(this.Checked, this, e);
	}

	private void UncheckedHandler(object sender, RoutedEventArgs e)
	{
		IsChecked = false;
		Microsoft.Phone.Controls.SafeRaise.Raise(this.Unchecked, this, e);
	}

	private void IndeterminateHandler(object sender, RoutedEventArgs e)
	{
		IsChecked = null;
		Microsoft.Phone.Controls.SafeRaise.Raise(this.Indeterminate, this, e);
	}

	private void ClickHandler(object sender, RoutedEventArgs e)
	{
		Microsoft.Phone.Controls.SafeRaise.Raise(this.Click, this, e);
	}

	public override string ToString()
	{
		return string.Format(CultureInfo.InvariantCulture, "{{ToggleSwitch IsChecked={0}, Content={1}}}", IsChecked, base.Content);
	}
}
