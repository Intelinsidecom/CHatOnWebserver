using System;
using System.ComponentModel;
using System.Globalization;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Navigation;
using Microsoft.Phone.Controls.Primitives;

namespace Microsoft.Phone.Controls;

[TemplatePart(Name = "DateTimeButton", Type = typeof(ButtonBase))]
public class DateTimePickerBase : Control
{
	private const string ButtonPartName = "DateTimeButton";

	private ButtonBase _dateButtonPart;

	private PhoneApplicationFrame _frame;

	private object _frameContentWhenOpened;

	private NavigationInTransition _savedNavigationInTransition;

	private NavigationOutTransition _savedNavigationOutTransition;

	private IDateTimePickerPage _dateTimePickerPage;

	public static readonly DependencyProperty ValueProperty = DependencyProperty.Register("Value", typeof(DateTime?), typeof(DateTimePickerBase), new PropertyMetadata(null, OnValueChanged));

	public static readonly DependencyProperty ValueStringProperty = DependencyProperty.Register("ValueString", typeof(string), typeof(DateTimePickerBase), null);

	public static readonly DependencyProperty ValueStringFormatProperty = DependencyProperty.Register("ValueStringFormat", typeof(string), typeof(DateTimePickerBase), new PropertyMetadata(null, OnValueStringFormatChanged));

	public static readonly DependencyProperty HeaderProperty = DependencyProperty.Register("Header", typeof(object), typeof(DateTimePickerBase), null);

	public static readonly DependencyProperty HeaderTemplateProperty = DependencyProperty.Register("HeaderTemplate", typeof(DataTemplate), typeof(DateTimePickerBase), null);

	public static readonly DependencyProperty PickerPageUriProperty = DependencyProperty.Register("PickerPageUri", typeof(Uri), typeof(DateTimePickerBase), null);

	[TypeConverter(typeof(TimeTypeConverter))]
	public DateTime? Value
	{
		get
		{
			return (DateTime?)GetValue(ValueProperty);
		}
		set
		{
			SetValue(ValueProperty, value);
		}
	}

	public string ValueString
	{
		get
		{
			return (string)GetValue(ValueStringProperty);
		}
		private set
		{
			SetValue(ValueStringProperty, value);
		}
	}

	public string ValueStringFormat
	{
		get
		{
			return (string)GetValue(ValueStringFormatProperty);
		}
		set
		{
			SetValue(ValueStringFormatProperty, value);
		}
	}

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

	public Uri PickerPageUri
	{
		get
		{
			return (Uri)GetValue(PickerPageUriProperty);
		}
		set
		{
			SetValue(PickerPageUriProperty, value);
		}
	}

	protected virtual string ValueStringFormatFallback => "{0}";

	public event EventHandler<DateTimeValueChangedEventArgs> ValueChanged;

	private static void OnValueChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		((DateTimePickerBase)o).OnValueChanged((DateTime?)e.OldValue, (DateTime?)e.NewValue);
	}

	private void OnValueChanged(DateTime? oldValue, DateTime? newValue)
	{
		UpdateValueString();
		OnValueChanged(new DateTimeValueChangedEventArgs(oldValue, newValue));
	}

	protected virtual void OnValueChanged(DateTimeValueChangedEventArgs e)
	{
		this.ValueChanged?.Invoke(this, e);
	}

	private static void OnValueStringFormatChanged(DependencyObject o, DependencyPropertyChangedEventArgs e)
	{
		((DateTimePickerBase)o).OnValueStringFormatChanged();
	}

	private void OnValueStringFormatChanged()
	{
		UpdateValueString();
	}

	public override void OnApplyTemplate()
	{
		if (_dateButtonPart != null)
		{
			_dateButtonPart.Click -= HandleDateButtonClick;
		}
		base.OnApplyTemplate();
		_dateButtonPart = GetTemplateChild("DateTimeButton") as ButtonBase;
		if (_dateButtonPart != null)
		{
			_dateButtonPart.Click += HandleDateButtonClick;
		}
	}

	private void HandleDateButtonClick(object sender, RoutedEventArgs e)
	{
		OpenPickerPage();
	}

	private void UpdateValueString()
	{
		ValueString = string.Format(CultureInfo.CurrentCulture, ValueStringFormat ?? ValueStringFormatFallback, Value);
	}

	public void OpenPickerPage()
	{
		//IL_00ae: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b8: Expected O, but got Unknown
		//IL_00c5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00cf: Expected O, but got Unknown
		if (null == PickerPageUri)
		{
			throw new ArgumentException("PickerPageUri property must not be null.");
		}
		if (_frame != null)
		{
			return;
		}
		ref PhoneApplicationFrame frame = ref _frame;
		UIElement rootVisual = Application.Current.RootVisual;
		frame = (PhoneApplicationFrame)(object)((rootVisual is PhoneApplicationFrame) ? rootVisual : null);
		if (_frame != null)
		{
			_frameContentWhenOpened = ((ContentControl)(object)_frame).Content;
			if (_frameContentWhenOpened is UIElement element)
			{
				_savedNavigationInTransition = TransitionService.GetNavigationInTransition(element);
				TransitionService.SetNavigationInTransition(element, null);
				_savedNavigationOutTransition = TransitionService.GetNavigationOutTransition(element);
				TransitionService.SetNavigationOutTransition(element, null);
			}
			((Frame)_frame).Navigated += HandleFrameNavigated;
			((Frame)_frame).NavigationStopped += new NavigationStoppedEventHandler(HandleFrameNavigationStoppedOrFailed);
			((Frame)_frame).NavigationFailed += new NavigationFailedEventHandler(HandleFrameNavigationStoppedOrFailed);
			((Frame)_frame).Navigate(PickerPageUri);
		}
	}

	private void ClosePickerPage()
	{
		//IL_002f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0039: Expected O, but got Unknown
		//IL_0046: Unknown result type (might be due to invalid IL or missing references)
		//IL_0050: Expected O, but got Unknown
		if (_frame != null)
		{
			((Frame)_frame).Navigated -= HandleFrameNavigated;
			((Frame)_frame).NavigationStopped -= new NavigationStoppedEventHandler(HandleFrameNavigationStoppedOrFailed);
			((Frame)_frame).NavigationFailed -= new NavigationFailedEventHandler(HandleFrameNavigationStoppedOrFailed);
			if (_frameContentWhenOpened is UIElement element)
			{
				TransitionService.SetNavigationInTransition(element, _savedNavigationInTransition);
				_savedNavigationInTransition = null;
				TransitionService.SetNavigationOutTransition(element, _savedNavigationOutTransition);
				_savedNavigationOutTransition = null;
			}
			_frame = null;
			_frameContentWhenOpened = null;
		}
		if (_dateTimePickerPage != null)
		{
			if (_dateTimePickerPage.Value.HasValue)
			{
				Value = _dateTimePickerPage.Value.Value;
			}
			_dateTimePickerPage = null;
		}
	}

	private void HandleFrameNavigated(object sender, NavigationEventArgs e)
	{
		if (e.Content == _frameContentWhenOpened)
		{
			ClosePickerPage();
		}
		else if (_dateTimePickerPage == null)
		{
			_dateTimePickerPage = e.Content as IDateTimePickerPage;
			if (_dateTimePickerPage != null)
			{
				_dateTimePickerPage.Value = Value.GetValueOrDefault(DateTime.Now);
			}
		}
	}

	private void HandleFrameNavigationStoppedOrFailed(object sender, EventArgs e)
	{
		ClosePickerPage();
	}
}
