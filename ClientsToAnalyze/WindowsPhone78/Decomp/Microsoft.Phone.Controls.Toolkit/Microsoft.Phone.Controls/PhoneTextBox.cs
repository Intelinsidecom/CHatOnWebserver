using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;

namespace Microsoft.Phone.Controls;

[TemplateVisualState(Name = "LengthIndicatorVisible", GroupName = "LengthIndicatorStates")]
[TemplateVisualState(Name = "Disabled", GroupName = "CommonStates")]
[TemplateVisualState(Name = "ReadOnly", GroupName = "CommonStates")]
[TemplateVisualState(Name = "Focused", GroupName = "FocusStates")]
[TemplateVisualState(Name = "Unfocused", GroupName = "FocusStates")]
[TemplatePart(Name = "Text", Type = typeof(TextBox))]
[TemplatePart(Name = "HintContent", Type = typeof(ContentControl))]
[TemplatePart(Name = "LengthIndicator", Type = typeof(TextBlock))]
[TemplateVisualState(Name = "LengthIndicatorHidden", GroupName = "LengthIndicatorStates")]
public class PhoneTextBox : TextBox
{
	private const string RootGridName = "RootGrid";

	private const string TextBoxName = "Text";

	private const string HintContentName = "HintContent";

	private const string HintBorderName = "HintBorder";

	private const string LengthIndicatorName = "LengthIndicator";

	private const string ActionIconCanvasName = "ActionIconCanvas";

	private const string MeasurementTextBlockName = "MeasurementTextBlock";

	private const string ActionIconBorderName = "ActionIconBorder";

	private const string LengthIndicatorStates = "LengthIndicatorStates";

	private const string LengthIndicatorVisibleState = "LengthIndicatorVisible";

	private const string LengthIndicatorHiddenState = "LengthIndicatorHidden";

	private const string CommonStates = "CommonStates";

	private const string DisabledState = "Disabled";

	private const string ReadOnlyState = "ReadOnly";

	private const string FocusStates = "FocusStates";

	private const string FocusedState = "Focused";

	private const string UnfocusedState = "Unfocused";

	private Grid RootGrid;

	private TextBox TextBox;

	private TextBlock MeasurementTextBlock;

	private Brush ForegroundBrushInactive = (Brush)Application.Current.Resources["PhoneTextBoxReadOnlyBrush"];

	private Brush ForegroundBrushEdit;

	private ContentControl HintContent;

	private Border HintBorder;

	private TextBlock LengthIndicator;

	private Border ActionIconBorder;

	private bool _ignorePropertyChange;

	private bool _ignoreFocus;

	public static readonly DependencyProperty HintProperty = DependencyProperty.Register("Hint", typeof(string), typeof(PhoneTextBox), new PropertyMetadata(OnHintPropertyChanged));

	public static readonly DependencyProperty HintStyleProperty = DependencyProperty.Register("HintStyle", typeof(Style), typeof(PhoneTextBox), null);

	public static readonly DependencyProperty ActualHintVisibilityProperty = DependencyProperty.Register("ActualHintVisibility", typeof(Visibility), typeof(PhoneTextBox), null);

	public static readonly DependencyProperty LengthIndicatorVisibleProperty = DependencyProperty.Register("LengthIndicatorVisible", typeof(bool), typeof(PhoneTextBox), null);

	public static readonly DependencyProperty LengthIndicatorThresholdProperty = DependencyProperty.Register("LengthIndicatorThreshold", typeof(int), typeof(PhoneTextBox), new PropertyMetadata(OnLengthIndicatorThresholdChanged));

	public static readonly DependencyProperty DisplayedMaxLengthProperty = DependencyProperty.Register("DisplayedMaxLength", typeof(int), typeof(PhoneTextBox), new PropertyMetadata(DisplayedMaxLengthChanged));

	public static readonly DependencyProperty ActionIconProperty = DependencyProperty.Register("ActionIcon", typeof(ImageSource), typeof(PhoneTextBox), new PropertyMetadata(OnActionIconChanged));

	public string Hint
	{
		get
		{
			return GetValue(HintProperty) as string;
		}
		set
		{
			SetValue(HintProperty, value);
		}
	}

	public Style HintStyle
	{
		get
		{
			return GetValue(HintStyleProperty) as Style;
		}
		set
		{
			SetValue(HintStyleProperty, value);
		}
	}

	public Visibility ActualHintVisibility
	{
		get
		{
			return (Visibility)GetValue(ActualHintVisibilityProperty);
		}
		set
		{
			SetValue(ActualHintVisibilityProperty, value);
		}
	}

	public bool LengthIndicatorVisible
	{
		get
		{
			return (bool)GetValue(LengthIndicatorVisibleProperty);
		}
		set
		{
			SetValue(LengthIndicatorVisibleProperty, value);
		}
	}

	public int LengthIndicatorTheshold
	{
		get
		{
			return (int)GetValue(LengthIndicatorThresholdProperty);
		}
		set
		{
			SetValue(LengthIndicatorThresholdProperty, value);
		}
	}

	public int DisplayedMaxLength
	{
		get
		{
			return (int)GetValue(DisplayedMaxLengthProperty);
		}
		set
		{
			SetValue(DisplayedMaxLengthProperty, value);
		}
	}

	public ImageSource ActionIcon
	{
		get
		{
			return GetValue(ActionIconProperty) as ImageSource;
		}
		set
		{
			SetValue(ActionIconProperty, value);
		}
	}

	public event EventHandler ActionIconTapped;

	private static void OnHintPropertyChanged(DependencyObject sender, DependencyPropertyChangedEventArgs args)
	{
		if (sender is PhoneTextBox { HintContent: not null } phoneTextBox)
		{
			phoneTextBox.UpdateHintVisibility();
		}
	}

	private void UpdateHintVisibility()
	{
		if (HintContent != null)
		{
			if (string.IsNullOrEmpty(base.Text))
			{
				ActualHintVisibility = Visibility.Visible;
				base.Foreground = ForegroundBrushInactive;
			}
			else
			{
				ActualHintVisibility = Visibility.Collapsed;
			}
		}
	}

	protected override void OnLostFocus(RoutedEventArgs e)
	{
		UpdateHintVisibility();
		base.OnLostFocus(e);
	}

	protected override void OnGotFocus(RoutedEventArgs e)
	{
		if (_ignoreFocus)
		{
			_ignoreFocus = false;
			UIElement rootVisual = Application.Current.RootVisual;
			Frame val = (Frame)(object)((rootVisual is Frame) ? rootVisual : null);
			((Control)(object)val).Focus();
			return;
		}
		base.Foreground = ForegroundBrushEdit;
		if (HintContent != null)
		{
			ActualHintVisibility = Visibility.Collapsed;
		}
		base.OnGotFocus(e);
	}

	private static void OnLengthIndicatorThresholdChanged(DependencyObject sender, DependencyPropertyChangedEventArgs args)
	{
		PhoneTextBox phoneTextBox = sender as PhoneTextBox;
		if (phoneTextBox._ignorePropertyChange)
		{
			phoneTextBox._ignorePropertyChange = false;
		}
		else if (phoneTextBox.LengthIndicatorTheshold < 0)
		{
			phoneTextBox._ignorePropertyChange = true;
			phoneTextBox.SetValue(LengthIndicatorThresholdProperty, args.OldValue);
			throw new ArgumentOutOfRangeException("LengthIndicatorThreshold", "The length indicator visibility threshold must be greater than zero.");
		}
	}

	private static void DisplayedMaxLengthChanged(DependencyObject sender, DependencyPropertyChangedEventArgs args)
	{
		PhoneTextBox phoneTextBox = sender as PhoneTextBox;
		if (phoneTextBox.DisplayedMaxLength > phoneTextBox.MaxLength && phoneTextBox.MaxLength > 0)
		{
			throw new ArgumentOutOfRangeException("DisplayedMaxLength", "The displayed maximum length cannot be greater than the MaxLength.");
		}
	}

	private void UpdateLengthIndicatorVisibility()
	{
		if (RootGrid == null || LengthIndicator == null)
		{
			return;
		}
		LengthIndicator.Text = $"{base.Text.Length}/{((DisplayedMaxLength > 0) ? DisplayedMaxLength : base.MaxLength)}";
		if (LengthIndicatorVisible)
		{
			if (base.Text.Length >= LengthIndicatorTheshold)
			{
				VisualStateManager.GoToState(this, "LengthIndicatorVisible", useTransitions: false);
			}
			else
			{
				VisualStateManager.GoToState(this, "LengthIndicatorHidden", useTransitions: false);
			}
		}
		else
		{
			VisualStateManager.GoToState(this, "LengthIndicatorHidden", useTransitions: false);
		}
	}

	private static void OnActionIconChanged(DependencyObject sender, DependencyPropertyChangedEventArgs args)
	{
		if (sender is PhoneTextBox phoneTextBox)
		{
			phoneTextBox.UpdateActionIconVisibility();
		}
	}

	private void UpdateActionIconVisibility()
	{
		if (ActionIconBorder == null)
		{
			return;
		}
		if (ActionIcon == null)
		{
			ActionIconBorder.Visibility = Visibility.Collapsed;
			HintBorder.Padding = new Thickness(0.0);
			return;
		}
		ActionIconBorder.Visibility = Visibility.Visible;
		if (base.TextWrapping != TextWrapping.Wrap)
		{
			HintBorder.Padding = new Thickness(0.0, 0.0, 48.0, 0.0);
		}
	}

	private void ActionIconTappedHandler(object sender, RoutedEventArgs e)
	{
		_ignoreFocus = true;
		this.ActionIconTapped?.Invoke(sender, e);
	}

	private void ResizeTextBox()
	{
		if (ActionIcon != null && base.TextWrapping == TextWrapping.Wrap)
		{
			MeasurementTextBlock.Width = base.ActualWidth;
			if (MeasurementTextBlock.ActualHeight > base.ActualHeight - 72.0)
			{
				base.Height = base.ActualHeight + 72.0;
			}
			else if (base.ActualHeight > MeasurementTextBlock.ActualHeight + 144.0)
			{
				base.Height = base.ActualHeight - 72.0;
			}
		}
	}

	public PhoneTextBox()
	{
		base.DefaultStyleKey = typeof(PhoneTextBox);
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		if (TextBox != null)
		{
			TextBox.TextChanged -= HandleTextChanged;
		}
		if (ActionIconBorder != null)
		{
			ActionIconBorder.MouseLeftButtonDown -= ActionIconTappedHandler;
		}
		RootGrid = GetTemplateChild("RootGrid") as Grid;
		TextBox = GetTemplateChild("Text") as TextBox;
		ForegroundBrushEdit = base.Foreground;
		HintContent = GetTemplateChild("HintContent") as ContentControl;
		HintBorder = GetTemplateChild("HintBorder") as Border;
		if (HintContent != null)
		{
			UpdateHintVisibility();
		}
		LengthIndicator = GetTemplateChild("LengthIndicator") as TextBlock;
		ActionIconBorder = GetTemplateChild("ActionIconBorder") as Border;
		if (RootGrid != null && LengthIndicator != null)
		{
			UpdateLengthIndicatorVisibility();
		}
		if (TextBox != null)
		{
			TextBox.TextChanged += HandleTextChanged;
		}
		if (ActionIconBorder != null)
		{
			ActionIconBorder.MouseLeftButtonDown += ActionIconTappedHandler;
			UpdateActionIconVisibility();
		}
		MeasurementTextBlock = GetTemplateChild("MeasurementTextBlock") as TextBlock;
	}

	private void HandleTextChanged(object sender, RoutedEventArgs e)
	{
		UpdateLengthIndicatorVisibility();
		ResizeTextBox();
	}
}
