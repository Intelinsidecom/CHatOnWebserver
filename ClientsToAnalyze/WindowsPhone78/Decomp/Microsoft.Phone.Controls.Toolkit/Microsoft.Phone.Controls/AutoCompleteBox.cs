using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Threading;

namespace Microsoft.Phone.Controls;

[TemplateVisualState(Name = "Normal", GroupName = "CommonStates")]
[ContentProperty("ItemsSource")]
[TemplatePart(Name = "SelectionAdapter", Type = typeof(ISelectionAdapter))]
[TemplatePart(Name = "Selector", Type = typeof(Selector))]
[TemplatePart(Name = "Text", Type = typeof(TextBox))]
[TemplatePart(Name = "Popup", Type = typeof(Popup))]
[StyleTypedProperty(Property = "TextBoxStyle", StyleTargetType = typeof(TextBox))]
[StyleTypedProperty(Property = "ItemContainerStyle", StyleTargetType = typeof(ListBox))]
[TemplateVisualState(Name = "MouseOver", GroupName = "CommonStates")]
[TemplateVisualState(Name = "Pressed", GroupName = "CommonStates")]
[TemplateVisualState(Name = "Disabled", GroupName = "CommonStates")]
[TemplateVisualState(Name = "Focused", GroupName = "FocusStates")]
[TemplateVisualState(Name = "Unfocused", GroupName = "FocusStates")]
[TemplateVisualState(Name = "PopupClosed", GroupName = "PopupStates")]
[TemplateVisualState(Name = "PopupOpened", GroupName = "PopupStates")]
[TemplateVisualState(Name = "Valid", GroupName = "ValidationStates")]
[TemplateVisualState(Name = "InvalidFocused", GroupName = "ValidationStates")]
[TemplateVisualState(Name = "InvalidUnfocused", GroupName = "ValidationStates")]
public class AutoCompleteBox : Control, IUpdateVisualState
{
	private const string ElementSelectionAdapter = "SelectionAdapter";

	private const string ElementSelector = "Selector";

	private const string ElementPopup = "Popup";

	private const string ElementTextBox = "Text";

	private const string ElementTextBoxStyle = "TextBoxStyle";

	private const string ElementItemContainerStyle = "ItemContainerStyle";

	private List<object> _items;

	private ObservableCollection<object> _view;

	private int _ignoreTextPropertyChange;

	private bool _ignorePropertyChange;

	private bool _ignoreTextSelectionChange;

	private bool _skipSelectedItemTextUpdate;

	private int _textSelectionStart;

	private bool _inputtingText;

	private bool _userCalledPopulate;

	private bool _popupHasOpened;

	private DispatcherTimer _delayTimer;

	private bool _allowWrite;

	private BindingEvaluator<string> _valueBindingEvaluator;

	private WeakEventListener<AutoCompleteBox, object, NotifyCollectionChangedEventArgs> _collectionChangedWeakEventListener;

	public static readonly DependencyProperty MinimumPrefixLengthProperty = DependencyProperty.Register("MinimumPrefixLength", typeof(int), typeof(AutoCompleteBox), new PropertyMetadata(1, OnMinimumPrefixLengthPropertyChanged));

	public static readonly DependencyProperty MinimumPopulateDelayProperty = DependencyProperty.Register("MinimumPopulateDelay", typeof(int), typeof(AutoCompleteBox), new PropertyMetadata(OnMinimumPopulateDelayPropertyChanged));

	public static readonly DependencyProperty IsTextCompletionEnabledProperty = DependencyProperty.Register("IsTextCompletionEnabled", typeof(bool), typeof(AutoCompleteBox), new PropertyMetadata(false, null));

	public static readonly DependencyProperty ItemTemplateProperty = DependencyProperty.Register("ItemTemplate", typeof(DataTemplate), typeof(AutoCompleteBox), new PropertyMetadata(null));

	public static readonly DependencyProperty ItemContainerStyleProperty = DependencyProperty.Register("ItemContainerStyle", typeof(Style), typeof(AutoCompleteBox), new PropertyMetadata(null, null));

	public static readonly DependencyProperty TextBoxStyleProperty = DependencyProperty.Register("TextBoxStyle", typeof(Style), typeof(AutoCompleteBox), new PropertyMetadata(null));

	public static readonly DependencyProperty MaxDropDownHeightProperty = DependencyProperty.Register("MaxDropDownHeight", typeof(double), typeof(AutoCompleteBox), new PropertyMetadata(double.PositiveInfinity, OnMaxDropDownHeightPropertyChanged));

	public static readonly DependencyProperty IsDropDownOpenProperty = DependencyProperty.Register("IsDropDownOpen", typeof(bool), typeof(AutoCompleteBox), new PropertyMetadata(false, OnIsDropDownOpenPropertyChanged));

	public static readonly DependencyProperty ItemsSourceProperty = DependencyProperty.Register("ItemsSource", typeof(IEnumerable), typeof(AutoCompleteBox), new PropertyMetadata(OnItemsSourcePropertyChanged));

	public static readonly DependencyProperty SelectedItemProperty = DependencyProperty.Register("SelectedItem", typeof(object), typeof(AutoCompleteBox), new PropertyMetadata(OnSelectedItemPropertyChanged));

	public static readonly DependencyProperty TextProperty = DependencyProperty.Register("Text", typeof(string), typeof(AutoCompleteBox), new PropertyMetadata(string.Empty, OnTextPropertyChanged));

	public static readonly DependencyProperty SearchTextProperty = DependencyProperty.Register("SearchText", typeof(string), typeof(AutoCompleteBox), new PropertyMetadata(string.Empty, OnSearchTextPropertyChanged));

	public static readonly DependencyProperty FilterModeProperty = DependencyProperty.Register("FilterMode", typeof(AutoCompleteFilterMode), typeof(AutoCompleteBox), new PropertyMetadata(AutoCompleteFilterMode.StartsWith, OnFilterModePropertyChanged));

	public static readonly DependencyProperty ItemFilterProperty = DependencyProperty.Register("ItemFilter", typeof(AutoCompleteFilterPredicate<object>), typeof(AutoCompleteBox), new PropertyMetadata(OnItemFilterPropertyChanged));

	public static readonly DependencyProperty TextFilterProperty = DependencyProperty.Register("TextFilter", typeof(AutoCompleteFilterPredicate<string>), typeof(AutoCompleteBox), new PropertyMetadata(AutoCompleteSearch.GetFilter(AutoCompleteFilterMode.StartsWith)));

	public static readonly DependencyProperty InputScopeProperty = DependencyProperty.Register("InputScope", typeof(InputScope), typeof(AutoCompleteBox), null);

	private TextBox _text;

	private ISelectionAdapter _adapter;

	internal InteractionHelper Interaction { get; set; }

	public int MinimumPrefixLength
	{
		get
		{
			return (int)GetValue(MinimumPrefixLengthProperty);
		}
		set
		{
			SetValue(MinimumPrefixLengthProperty, value);
		}
	}

	public int MinimumPopulateDelay
	{
		get
		{
			return (int)GetValue(MinimumPopulateDelayProperty);
		}
		set
		{
			SetValue(MinimumPopulateDelayProperty, value);
		}
	}

	public bool IsTextCompletionEnabled
	{
		get
		{
			return (bool)GetValue(IsTextCompletionEnabledProperty);
		}
		set
		{
			SetValue(IsTextCompletionEnabledProperty, value);
		}
	}

	public DataTemplate ItemTemplate
	{
		get
		{
			return GetValue(ItemTemplateProperty) as DataTemplate;
		}
		set
		{
			SetValue(ItemTemplateProperty, value);
		}
	}

	public Style ItemContainerStyle
	{
		get
		{
			return GetValue(ItemContainerStyleProperty) as Style;
		}
		set
		{
			SetValue(ItemContainerStyleProperty, value);
		}
	}

	public Style TextBoxStyle
	{
		get
		{
			return GetValue(TextBoxStyleProperty) as Style;
		}
		set
		{
			SetValue(TextBoxStyleProperty, value);
		}
	}

	public double MaxDropDownHeight
	{
		get
		{
			return (double)GetValue(MaxDropDownHeightProperty);
		}
		set
		{
			SetValue(MaxDropDownHeightProperty, value);
		}
	}

	public bool IsDropDownOpen
	{
		get
		{
			return (bool)GetValue(IsDropDownOpenProperty);
		}
		set
		{
			SetValue(IsDropDownOpenProperty, value);
		}
	}

	public IEnumerable ItemsSource
	{
		get
		{
			return GetValue(ItemsSourceProperty) as IEnumerable;
		}
		set
		{
			SetValue(ItemsSourceProperty, value);
		}
	}

	public object SelectedItem
	{
		get
		{
			return GetValue(SelectedItemProperty);
		}
		set
		{
			SetValue(SelectedItemProperty, value);
		}
	}

	public string Text
	{
		get
		{
			return GetValue(TextProperty) as string;
		}
		set
		{
			SetValue(TextProperty, value);
		}
	}

	public string SearchText
	{
		get
		{
			return (string)GetValue(SearchTextProperty);
		}
		private set
		{
			try
			{
				_allowWrite = true;
				SetValue(SearchTextProperty, value);
			}
			finally
			{
				_allowWrite = false;
			}
		}
	}

	public AutoCompleteFilterMode FilterMode
	{
		get
		{
			return (AutoCompleteFilterMode)GetValue(FilterModeProperty);
		}
		set
		{
			SetValue(FilterModeProperty, value);
		}
	}

	public AutoCompleteFilterPredicate<object> ItemFilter
	{
		get
		{
			return GetValue(ItemFilterProperty) as AutoCompleteFilterPredicate<object>;
		}
		set
		{
			SetValue(ItemFilterProperty, value);
		}
	}

	public AutoCompleteFilterPredicate<string> TextFilter
	{
		get
		{
			return GetValue(TextFilterProperty) as AutoCompleteFilterPredicate<string>;
		}
		set
		{
			SetValue(TextFilterProperty, value);
		}
	}

	public InputScope InputScope
	{
		get
		{
			return (InputScope)GetValue(InputScopeProperty);
		}
		set
		{
			SetValue(InputScopeProperty, value);
		}
	}

	private PopupHelper DropDownPopup { get; set; }

	private static bool IsCompletionEnabled
	{
		get
		{
			if (PhoneHelper.TryGetPhoneApplicationFrame(out var phoneApplicationFrame))
			{
				return phoneApplicationFrame.IsPortrait();
			}
			return false;
		}
	}

	internal TextBox TextBox
	{
		get
		{
			return _text;
		}
		set
		{
			if (_text != null)
			{
				_text.SelectionChanged -= OnTextBoxSelectionChanged;
				_text.TextChanged -= OnTextBoxTextChanged;
			}
			_text = value;
			if (_text != null)
			{
				_text.SelectionChanged += OnTextBoxSelectionChanged;
				_text.TextChanged += OnTextBoxTextChanged;
				if (Text != null)
				{
					UpdateTextValue(Text);
				}
			}
		}
	}

	protected internal ISelectionAdapter SelectionAdapter
	{
		get
		{
			return _adapter;
		}
		set
		{
			if (_adapter != null)
			{
				_adapter.SelectionChanged -= OnAdapterSelectionChanged;
				_adapter.Commit -= OnAdapterSelectionComplete;
				_adapter.Cancel -= OnAdapterSelectionCanceled;
				_adapter.Cancel -= OnAdapterSelectionComplete;
				_adapter.ItemsSource = null;
			}
			_adapter = value;
			if (_adapter != null)
			{
				_adapter.SelectionChanged += OnAdapterSelectionChanged;
				_adapter.Commit += OnAdapterSelectionComplete;
				_adapter.Cancel += OnAdapterSelectionCanceled;
				_adapter.Cancel += OnAdapterSelectionComplete;
				_adapter.ItemsSource = _view;
			}
		}
	}

	public Binding ValueMemberBinding
	{
		get
		{
			if (_valueBindingEvaluator == null)
			{
				return null;
			}
			return _valueBindingEvaluator.ValueBinding;
		}
		set
		{
			_valueBindingEvaluator = new BindingEvaluator<string>(value);
		}
	}

	public string ValueMemberPath
	{
		get
		{
			if (ValueMemberBinding == null)
			{
				return null;
			}
			return ValueMemberBinding.Path.Path;
		}
		set
		{
			ValueMemberBinding = ((value == null) ? null : new Binding(value));
		}
	}

	public event RoutedEventHandler TextChanged;

	public event PopulatingEventHandler Populating;

	public event PopulatedEventHandler Populated;

	public event RoutedPropertyChangingEventHandler<bool> DropDownOpening;

	public event RoutedPropertyChangedEventHandler<bool> DropDownOpened;

	public event RoutedPropertyChangingEventHandler<bool> DropDownClosing;

	public event RoutedPropertyChangedEventHandler<bool> DropDownClosed;

	public event SelectionChangedEventHandler SelectionChanged;

	private static void OnMinimumPrefixLengthPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		int num = (int)e.NewValue;
		if (num < 0 && num != -1)
		{
			throw new ArgumentOutOfRangeException("MinimumPrefixLength");
		}
	}

	private static void OnMinimumPopulateDelayPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		AutoCompleteBox autoCompleteBox = d as AutoCompleteBox;
		if (autoCompleteBox._ignorePropertyChange)
		{
			autoCompleteBox._ignorePropertyChange = false;
			return;
		}
		int num = (int)e.NewValue;
		if (num < 0)
		{
			autoCompleteBox._ignorePropertyChange = true;
			d.SetValue(e.Property, e.OldValue);
		}
		if (autoCompleteBox._delayTimer != null)
		{
			autoCompleteBox._delayTimer.Stop();
			if (num == 0)
			{
				autoCompleteBox._delayTimer = null;
			}
		}
		if (num > 0 && autoCompleteBox._delayTimer == null)
		{
			autoCompleteBox._delayTimer = new DispatcherTimer();
			autoCompleteBox._delayTimer.Tick += autoCompleteBox.PopulateDropDown;
		}
		if (num > 0 && autoCompleteBox._delayTimer != null)
		{
			autoCompleteBox._delayTimer.Interval = TimeSpan.FromMilliseconds(num);
		}
	}

	private static void OnMaxDropDownHeightPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		AutoCompleteBox autoCompleteBox = d as AutoCompleteBox;
		if (autoCompleteBox._ignorePropertyChange)
		{
			autoCompleteBox._ignorePropertyChange = false;
			return;
		}
		double num = (double)e.NewValue;
		if (num < 0.0)
		{
			autoCompleteBox._ignorePropertyChange = true;
			autoCompleteBox.SetValue(e.Property, e.OldValue);
		}
		autoCompleteBox.OnMaxDropDownHeightChanged(num);
	}

	private static void OnIsDropDownOpenPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		AutoCompleteBox autoCompleteBox = d as AutoCompleteBox;
		if (autoCompleteBox._ignorePropertyChange)
		{
			autoCompleteBox._ignorePropertyChange = false;
			return;
		}
		bool oldValue = (bool)e.OldValue;
		if ((bool)e.NewValue)
		{
			autoCompleteBox.TextUpdated(autoCompleteBox.Text, userInitiated: true);
		}
		else
		{
			autoCompleteBox.ClosingDropDown(oldValue);
		}
		autoCompleteBox.UpdateVisualState(useTransitions: true);
	}

	private static void OnItemsSourcePropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		AutoCompleteBox autoCompleteBox = d as AutoCompleteBox;
		autoCompleteBox.OnItemsSourceChanged((IEnumerable)e.OldValue, (IEnumerable)e.NewValue);
	}

	private static void OnSelectedItemPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		AutoCompleteBox autoCompleteBox = d as AutoCompleteBox;
		if (autoCompleteBox._ignorePropertyChange)
		{
			autoCompleteBox._ignorePropertyChange = false;
			return;
		}
		if (autoCompleteBox._skipSelectedItemTextUpdate)
		{
			autoCompleteBox._skipSelectedItemTextUpdate = false;
		}
		else
		{
			autoCompleteBox.OnSelectedItemChanged(e.NewValue);
		}
		List<object> list = new List<object>();
		if (e.OldValue != null)
		{
			list.Add(e.OldValue);
		}
		List<object> list2 = new List<object>();
		if (e.NewValue != null)
		{
			list2.Add(e.NewValue);
		}
		autoCompleteBox.OnSelectionChanged(new SelectionChangedEventArgs(list, list2));
	}

	private void OnSelectedItemChanged(object newItem)
	{
		string value = ((newItem != null) ? FormatValue(newItem, clearDataContext: true) : SearchText);
		UpdateTextValue(value);
		if (TextBox != null && Text != null)
		{
			TextBox.SelectionStart = Text.Length;
		}
	}

	private static void OnTextPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		AutoCompleteBox autoCompleteBox = d as AutoCompleteBox;
		autoCompleteBox.TextUpdated((string)e.NewValue, userInitiated: false);
	}

	private static void OnSearchTextPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		AutoCompleteBox autoCompleteBox = d as AutoCompleteBox;
		if (autoCompleteBox._ignorePropertyChange)
		{
			autoCompleteBox._ignorePropertyChange = false;
		}
		else if (!autoCompleteBox._allowWrite)
		{
			autoCompleteBox._ignorePropertyChange = true;
			autoCompleteBox.SetValue(e.Property, e.OldValue);
		}
	}

	private static void OnFilterModePropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		AutoCompleteBox autoCompleteBox = d as AutoCompleteBox;
		AutoCompleteFilterMode autoCompleteFilterMode = (AutoCompleteFilterMode)e.NewValue;
		if (autoCompleteFilterMode != AutoCompleteFilterMode.Contains && autoCompleteFilterMode != AutoCompleteFilterMode.ContainsCaseSensitive && autoCompleteFilterMode != AutoCompleteFilterMode.ContainsOrdinal && autoCompleteFilterMode != AutoCompleteFilterMode.ContainsOrdinalCaseSensitive && autoCompleteFilterMode != AutoCompleteFilterMode.Custom && autoCompleteFilterMode != AutoCompleteFilterMode.Equals && autoCompleteFilterMode != AutoCompleteFilterMode.EqualsCaseSensitive && autoCompleteFilterMode != AutoCompleteFilterMode.EqualsOrdinal && autoCompleteFilterMode != AutoCompleteFilterMode.EqualsOrdinalCaseSensitive && autoCompleteFilterMode != AutoCompleteFilterMode.None && autoCompleteFilterMode != AutoCompleteFilterMode.StartsWith && autoCompleteFilterMode != AutoCompleteFilterMode.StartsWithCaseSensitive && autoCompleteFilterMode != AutoCompleteFilterMode.StartsWithOrdinal && autoCompleteFilterMode != AutoCompleteFilterMode.StartsWithOrdinalCaseSensitive)
		{
			autoCompleteBox.SetValue(e.Property, e.OldValue);
		}
		AutoCompleteFilterMode filterMode = (AutoCompleteFilterMode)e.NewValue;
		autoCompleteBox.TextFilter = AutoCompleteSearch.GetFilter(filterMode);
	}

	private static void OnItemFilterPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		AutoCompleteBox autoCompleteBox = d as AutoCompleteBox;
		if (!(e.NewValue is AutoCompleteFilterPredicate<object>))
		{
			autoCompleteBox.FilterMode = AutoCompleteFilterMode.None;
			return;
		}
		autoCompleteBox.FilterMode = AutoCompleteFilterMode.Custom;
		autoCompleteBox.TextFilter = null;
	}

	public AutoCompleteBox()
	{
		base.DefaultStyleKey = typeof(AutoCompleteBox);
		RoutedEventHandler value = delegate
		{
			ApplyTemplate();
		};
		base.Loaded += value;
		base.Loaded += delegate
		{
			if (PhoneHelper.TryGetPhoneApplicationFrame(out var phoneApplicationFrame))
			{
				phoneApplicationFrame.OrientationChanged += delegate
				{
					IsDropDownOpen = false;
				};
			}
		};
		base.IsEnabledChanged += ControlIsEnabledChanged;
		Interaction = new InteractionHelper(this);
		ClearView();
	}

	protected override Size ArrangeOverride(Size finalSize)
	{
		Size result = base.ArrangeOverride(finalSize);
		if (DropDownPopup != null)
		{
			DropDownPopup.Arrange(finalSize);
		}
		return result;
	}

	public override void OnApplyTemplate()
	{
		if (TextBox != null)
		{
			TextBox.RemoveHandler(UIElement.KeyDownEvent, new KeyEventHandler(OnUIElementKeyDown));
			TextBox.RemoveHandler(UIElement.KeyUpEvent, new KeyEventHandler(OnUIElementKeyUp));
		}
		if (DropDownPopup != null)
		{
			DropDownPopup.Closed -= DropDownPopup_Closed;
			DropDownPopup.FocusChanged -= OnDropDownFocusChanged;
			DropDownPopup.UpdateVisualStates -= OnDropDownPopupUpdateVisualStates;
			DropDownPopup.BeforeOnApplyTemplate();
			DropDownPopup = null;
		}
		base.OnApplyTemplate();
		if (GetTemplateChild("Popup") is Popup popup)
		{
			DropDownPopup = new PopupHelper(this, popup);
			DropDownPopup.MaxDropDownHeight = MaxDropDownHeight;
			DropDownPopup.AfterOnApplyTemplate();
			DropDownPopup.Closed += DropDownPopup_Closed;
			DropDownPopup.FocusChanged += OnDropDownFocusChanged;
			DropDownPopup.UpdateVisualStates += OnDropDownPopupUpdateVisualStates;
		}
		SelectionAdapter = GetSelectionAdapterPart();
		TextBox = GetTemplateChild("Text") as TextBox;
		if (TextBox != null)
		{
			TextBox.AddHandler(UIElement.KeyDownEvent, new KeyEventHandler(OnUIElementKeyDown), handledEventsToo: true);
			TextBox.AddHandler(UIElement.KeyUpEvent, new KeyEventHandler(OnUIElementKeyUp), handledEventsToo: true);
		}
		Interaction.OnApplyTemplateBase();
		if (IsDropDownOpen && DropDownPopup != null && !DropDownPopup.IsOpen)
		{
			OpeningDropDown(oldValue: false);
		}
	}

	private void OnDropDownPopupUpdateVisualStates(object sender, EventArgs e)
	{
		UpdateVisualState(useTransitions: true);
	}

	private void OnDropDownFocusChanged(object sender, EventArgs e)
	{
		FocusChanged(HasFocus());
	}

	private void ClosingDropDown(bool oldValue)
	{
		bool flag = false;
		if (DropDownPopup != null)
		{
			flag = DropDownPopup.UsesClosingVisualState;
		}
		RoutedPropertyChangingEventArgs<bool> e = new RoutedPropertyChangingEventArgs<bool>(IsDropDownOpenProperty, oldValue, newValue: false, isCancelable: true);
		OnDropDownClosing(e);
		if (_view == null || _view.Count == 0)
		{
			flag = false;
		}
		if (e.Cancel)
		{
			_ignorePropertyChange = true;
			SetValue(IsDropDownOpenProperty, oldValue);
		}
		else if (!flag)
		{
			CloseDropDown(oldValue, newValue: false);
		}
		UpdateVisualState(useTransitions: true);
	}

	private void OpeningDropDown(bool oldValue)
	{
		if (IsCompletionEnabled)
		{
			RoutedPropertyChangingEventArgs<bool> e = new RoutedPropertyChangingEventArgs<bool>(IsDropDownOpenProperty, oldValue, newValue: true, isCancelable: true);
			OnDropDownOpening(e);
			if (e.Cancel)
			{
				_ignorePropertyChange = true;
				SetValue(IsDropDownOpenProperty, oldValue);
			}
			else
			{
				OpenDropDown(oldValue, newValue: true);
			}
			UpdateVisualState(useTransitions: true);
		}
	}

	private void DropDownPopup_Closed(object sender, EventArgs e)
	{
		if (IsDropDownOpen)
		{
			IsDropDownOpen = false;
		}
		if (_popupHasOpened)
		{
			OnDropDownClosed(new RoutedPropertyChangedEventArgs<bool>(oldValue: true, newValue: false));
		}
	}

	private void FocusChanged(bool hasFocus)
	{
		if (hasFocus)
		{
			if (TextBox != null && TextBox.SelectionLength == 0)
			{
				TextBox.Focus();
			}
		}
		else
		{
			IsDropDownOpen = false;
			_userCalledPopulate = false;
		}
	}

	protected bool HasFocus()
	{
		DependencyObject dependencyObject = FocusManager.GetFocusedElement() as DependencyObject;
		while (dependencyObject != null)
		{
			if (object.ReferenceEquals(dependencyObject, this))
			{
				return true;
			}
			DependencyObject parent = VisualTreeHelper.GetParent(dependencyObject);
			if (parent == null && dependencyObject is FrameworkElement frameworkElement)
			{
				parent = frameworkElement.Parent;
			}
			dependencyObject = parent;
		}
		return false;
	}

	protected override void OnGotFocus(RoutedEventArgs e)
	{
		base.OnGotFocus(e);
		FocusChanged(HasFocus());
	}

	protected override void OnLostFocus(RoutedEventArgs e)
	{
		base.OnLostFocus(e);
		FocusChanged(HasFocus());
	}

	private void ControlIsEnabledChanged(object sender, DependencyPropertyChangedEventArgs e)
	{
		if (!(bool)e.NewValue)
		{
			IsDropDownOpen = false;
		}
	}

	protected virtual ISelectionAdapter GetSelectionAdapterPart()
	{
		ISelectionAdapter selectionAdapter = null;
		if (GetTemplateChild("Selector") is Selector selector)
		{
			selectionAdapter = selector as ISelectionAdapter;
			if (selectionAdapter == null)
			{
				selectionAdapter = new SelectorSelectionAdapter(selector);
			}
		}
		if (selectionAdapter == null)
		{
			selectionAdapter = GetTemplateChild("SelectionAdapter") as ISelectionAdapter;
		}
		return selectionAdapter;
	}

	private void PopulateDropDown(object sender, EventArgs e)
	{
		if (_delayTimer != null)
		{
			_delayTimer.Stop();
		}
		SearchText = Text;
		PopulatingEventArgs e2 = new PopulatingEventArgs(SearchText);
		OnPopulating(e2);
		if (!e2.Cancel)
		{
			PopulateComplete();
		}
	}

	protected virtual void OnPopulating(PopulatingEventArgs e)
	{
		this.Populating?.Invoke(this, e);
	}

	protected virtual void OnPopulated(PopulatedEventArgs e)
	{
		this.Populated?.Invoke(this, e);
	}

	protected virtual void OnSelectionChanged(SelectionChangedEventArgs e)
	{
		this.SelectionChanged?.Invoke(this, e);
	}

	protected virtual void OnDropDownOpening(RoutedPropertyChangingEventArgs<bool> e)
	{
		this.DropDownOpening?.Invoke(this, e);
	}

	protected virtual void OnDropDownOpened(RoutedPropertyChangedEventArgs<bool> e)
	{
		this.DropDownOpened?.Invoke(this, e);
	}

	protected virtual void OnDropDownClosing(RoutedPropertyChangingEventArgs<bool> e)
	{
		this.DropDownClosing?.Invoke(this, e);
	}

	protected virtual void OnDropDownClosed(RoutedPropertyChangedEventArgs<bool> e)
	{
		this.DropDownClosed?.Invoke(this, e);
	}

	private string FormatValue(object value, bool clearDataContext)
	{
		string result = FormatValue(value);
		if (clearDataContext && _valueBindingEvaluator != null)
		{
			_valueBindingEvaluator.ClearDataContext();
		}
		return result;
	}

	protected virtual string FormatValue(object value)
	{
		if (_valueBindingEvaluator != null)
		{
			return _valueBindingEvaluator.GetDynamicValue(value) ?? string.Empty;
		}
		if (value != null)
		{
			return value.ToString();
		}
		return string.Empty;
	}

	protected virtual void OnTextChanged(RoutedEventArgs e)
	{
		this.TextChanged?.Invoke(this, e);
	}

	private void OnTextBoxTextChanged(object sender, TextChangedEventArgs e)
	{
		TextUpdated(_text.Text, userInitiated: true);
	}

	private void OnTextBoxSelectionChanged(object sender, RoutedEventArgs e)
	{
		if (!_ignoreTextSelectionChange && !_inputtingText)
		{
			_textSelectionStart = _text.SelectionStart;
		}
	}

	private void OnUIElementKeyDown(object sender, KeyEventArgs e)
	{
		_inputtingText = true;
	}

	private void OnUIElementKeyUp(object sender, KeyEventArgs e)
	{
		_inputtingText = false;
	}

	private void UpdateTextValue(string value)
	{
		UpdateTextValue(value, null);
	}

	private void UpdateTextValue(string value, bool? userInitiated)
	{
		if ((!userInitiated.HasValue || userInitiated == true) && Text != value)
		{
			_ignoreTextPropertyChange++;
			Text = value;
			OnTextChanged(new RoutedEventArgs());
		}
		if ((!userInitiated.HasValue || userInitiated == false) && TextBox != null && TextBox.Text != value)
		{
			_ignoreTextPropertyChange++;
			TextBox.Text = value ?? string.Empty;
			if (Text == value || Text == null)
			{
				OnTextChanged(new RoutedEventArgs());
			}
		}
	}

	private void TextUpdated(string newText, bool userInitiated)
	{
		if (_ignoreTextPropertyChange > 0)
		{
			_ignoreTextPropertyChange--;
			return;
		}
		if (newText == null)
		{
			newText = string.Empty;
		}
		if (IsTextCompletionEnabled && TextBox != null && TextBox.SelectionLength > 0 && TextBox.SelectionStart != TextBox.Text.Length)
		{
			return;
		}
		bool flag = newText.Length >= MinimumPrefixLength && MinimumPrefixLength >= 0;
		_userCalledPopulate = flag && userInitiated;
		UpdateTextValue(newText, userInitiated);
		if (flag)
		{
			_ignoreTextSelectionChange = true;
			if (_delayTimer != null)
			{
				_delayTimer.Start();
			}
			else
			{
				PopulateDropDown(this, EventArgs.Empty);
			}
			return;
		}
		SearchText = string.Empty;
		if (SelectedItem != null)
		{
			_skipSelectedItemTextUpdate = true;
		}
		SelectedItem = null;
		if (IsDropDownOpen)
		{
			IsDropDownOpen = false;
		}
	}

	public void PopulateComplete()
	{
		RefreshView();
		PopulatedEventArgs e = new PopulatedEventArgs(new ReadOnlyCollection<object>(_view));
		OnPopulated(e);
		if (SelectionAdapter != null && SelectionAdapter.ItemsSource != _view)
		{
			SelectionAdapter.ItemsSource = _view;
		}
		bool flag = _userCalledPopulate && _view.Count > 0;
		if (flag != IsDropDownOpen)
		{
			_ignorePropertyChange = true;
			IsDropDownOpen = flag;
		}
		if (IsDropDownOpen)
		{
			OpeningDropDown(oldValue: false);
			if (DropDownPopup != null)
			{
				DropDownPopup.Arrange(null);
			}
		}
		else
		{
			ClosingDropDown(oldValue: true);
		}
		UpdateTextCompletion(_userCalledPopulate);
	}

	private void UpdateTextCompletion(bool userInitiated)
	{
		object obj = null;
		string text = Text;
		if (_view.Count > 0)
		{
			if (IsTextCompletionEnabled && TextBox != null && userInitiated)
			{
				int length = TextBox.Text.Length;
				int selectionStart = TextBox.SelectionStart;
				if (selectionStart == text.Length && selectionStart > _textSelectionStart)
				{
					object obj2 = ((FilterMode == AutoCompleteFilterMode.StartsWith || FilterMode == AutoCompleteFilterMode.StartsWithCaseSensitive) ? _view[0] : TryGetMatch(text, _view, AutoCompleteSearch.GetFilter(AutoCompleteFilterMode.StartsWith)));
					if (obj2 != null)
					{
						obj = obj2;
						string text2 = FormatValue(obj2, clearDataContext: true);
						int length2 = Math.Min(text2.Length, Text.Length);
						if (AutoCompleteSearch.Equals(Text.Substring(0, length2), text2.Substring(0, length2)))
						{
							UpdateTextValue(text2);
							TextBox.SelectionStart = length;
							TextBox.SelectionLength = text2.Length - length;
						}
					}
				}
			}
			else
			{
				obj = TryGetMatch(text, _view, AutoCompleteSearch.GetFilter(AutoCompleteFilterMode.EqualsCaseSensitive));
			}
		}
		if (SelectedItem != obj)
		{
			_skipSelectedItemTextUpdate = true;
		}
		SelectedItem = obj;
		if (_ignoreTextSelectionChange)
		{
			_ignoreTextSelectionChange = false;
			if (TextBox != null && !_inputtingText)
			{
				_textSelectionStart = TextBox.SelectionStart;
			}
		}
	}

	private object TryGetMatch(string searchText, ObservableCollection<object> view, AutoCompleteFilterPredicate<string> predicate)
	{
		if (view != null && view.Count > 0)
		{
			foreach (object item in view)
			{
				if (predicate(searchText, FormatValue(item)))
				{
					return item;
				}
			}
		}
		return null;
	}

	private void ClearView()
	{
		if (_view == null)
		{
			_view = new ObservableCollection<object>();
		}
		else
		{
			_view.Clear();
		}
	}

	private void RefreshView()
	{
		if (_items == null)
		{
			ClearView();
			return;
		}
		string search = Text ?? string.Empty;
		bool flag = TextFilter != null;
		bool flag2 = FilterMode == AutoCompleteFilterMode.Custom && TextFilter == null;
		int num = 0;
		int num2 = _view.Count;
		List<object> items = _items;
		foreach (object item in items)
		{
			bool flag3 = !flag && !flag2;
			if (!flag3)
			{
				flag3 = (flag ? TextFilter(search, FormatValue(item)) : ItemFilter(search, item));
			}
			if (num2 > num && flag3 && _view[num] == item)
			{
				num++;
			}
			else if (flag3)
			{
				if (num2 > num && _view[num] != item)
				{
					_view.RemoveAt(num);
					_view.Insert(num, item);
					num++;
					continue;
				}
				if (num == num2)
				{
					_view.Add(item);
				}
				else
				{
					_view.Insert(num, item);
				}
				num++;
				num2++;
			}
			else if (num2 > num && _view[num] == item)
			{
				_view.RemoveAt(num);
				num2--;
			}
		}
		if (_valueBindingEvaluator != null)
		{
			_valueBindingEvaluator.ClearDataContext();
		}
	}

	private void OnItemsSourceChanged(IEnumerable oldValue, IEnumerable newValue)
	{
		if (oldValue is INotifyCollectionChanged && _collectionChangedWeakEventListener != null)
		{
			_collectionChangedWeakEventListener.Detach();
			_collectionChangedWeakEventListener = null;
		}
		INotifyCollectionChanged newValueINotifyCollectionChanged = newValue as INotifyCollectionChanged;
		if (newValueINotifyCollectionChanged != null)
		{
			_collectionChangedWeakEventListener = new WeakEventListener<AutoCompleteBox, object, NotifyCollectionChangedEventArgs>(this);
			_collectionChangedWeakEventListener.OnEventAction = delegate(AutoCompleteBox instance, object source, NotifyCollectionChangedEventArgs eventArgs)
			{
				instance.ItemsSourceCollectionChanged(source, eventArgs);
			};
			_collectionChangedWeakEventListener.OnDetachAction = delegate(WeakEventListener<AutoCompleteBox, object, NotifyCollectionChangedEventArgs> weakEventListener)
			{
				newValueINotifyCollectionChanged.CollectionChanged -= weakEventListener.OnEvent;
			};
			newValueINotifyCollectionChanged.CollectionChanged += _collectionChangedWeakEventListener.OnEvent;
		}
		_items = ((newValue == null) ? null : new List<object>(newValue.Cast<object>().ToList()));
		ClearView();
		if (SelectionAdapter != null && SelectionAdapter.ItemsSource != _view)
		{
			SelectionAdapter.ItemsSource = _view;
		}
		if (IsDropDownOpen)
		{
			RefreshView();
		}
	}

	private void ItemsSourceCollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
	{
		if (e.Action == NotifyCollectionChangedAction.Remove && e.OldItems != null)
		{
			for (int i = 0; i < e.OldItems.Count; i++)
			{
				_items.RemoveAt(e.OldStartingIndex);
			}
		}
		if (e.Action == NotifyCollectionChangedAction.Add && e.NewItems != null && _items.Count >= e.NewStartingIndex)
		{
			for (int j = 0; j < e.NewItems.Count; j++)
			{
				_items.Insert(e.NewStartingIndex + j, e.NewItems[j]);
			}
		}
		if (e.Action == NotifyCollectionChangedAction.Replace && e.NewItems != null && e.OldItems != null)
		{
			for (int k = 0; k < e.NewItems.Count; k++)
			{
				_items[e.NewStartingIndex] = e.NewItems[k];
			}
		}
		if (e.Action == NotifyCollectionChangedAction.Remove || e.Action == NotifyCollectionChangedAction.Replace)
		{
			for (int l = 0; l < e.OldItems.Count; l++)
			{
				_view.Remove(e.OldItems[l]);
			}
		}
		if (e.Action == NotifyCollectionChangedAction.Reset)
		{
			ClearView();
			if (ItemsSource != null)
			{
				_items = new List<object>(ItemsSource.Cast<object>().ToList());
			}
		}
		RefreshView();
	}

	private void OnAdapterSelectionChanged(object sender, SelectionChangedEventArgs e)
	{
		SelectedItem = _adapter.SelectedItem;
	}

	private void OnAdapterSelectionComplete(object sender, RoutedEventArgs e)
	{
		IsDropDownOpen = false;
		UpdateTextCompletion(userInitiated: false);
		if (TextBox != null)
		{
			TextBox.Select(TextBox.Text.Length, 0);
			TextBox.Focus();
		}
	}

	private void OnAdapterSelectionCanceled(object sender, RoutedEventArgs e)
	{
		UpdateTextValue(SearchText);
		UpdateTextCompletion(userInitiated: false);
	}

	private void OnMaxDropDownHeightChanged(double newValue)
	{
		if (DropDownPopup != null)
		{
			DropDownPopup.MaxDropDownHeight = newValue;
			DropDownPopup.Arrange(null);
		}
		UpdateVisualState(useTransitions: true);
	}

	private void OpenDropDown(bool oldValue, bool newValue)
	{
		if (DropDownPopup != null)
		{
			DropDownPopup.IsOpen = true;
		}
		_popupHasOpened = true;
		OnDropDownOpened(new RoutedPropertyChangedEventArgs<bool>(oldValue, newValue));
	}

	private void CloseDropDown(bool oldValue, bool newValue)
	{
		if (_popupHasOpened)
		{
			if (SelectionAdapter != null)
			{
				SelectionAdapter.SelectedItem = null;
			}
			if (DropDownPopup != null)
			{
				DropDownPopup.IsOpen = false;
			}
			OnDropDownClosed(new RoutedPropertyChangedEventArgs<bool>(oldValue, newValue));
		}
	}

	protected override void OnKeyDown(KeyEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		base.OnKeyDown(e);
		if (e.Handled || !base.IsEnabled)
		{
			return;
		}
		if (IsDropDownOpen)
		{
			if (SelectionAdapter != null)
			{
				SelectionAdapter.HandleKeyDown(e);
				if (e.Handled)
				{
					return;
				}
			}
			if (e.Key == Key.Escape)
			{
				OnAdapterSelectionCanceled(this, new RoutedEventArgs());
				e.Handled = true;
			}
		}
		else if (e.Key == Key.Down)
		{
			IsDropDownOpen = true;
			e.Handled = true;
		}
		switch (e.Key)
		{
		case Key.F4:
			IsDropDownOpen = !IsDropDownOpen;
			e.Handled = true;
			break;
		case Key.Enter:
			OnAdapterSelectionComplete(this, new RoutedEventArgs());
			e.Handled = true;
			break;
		}
	}

	void IUpdateVisualState.UpdateVisualState(bool useTransitions)
	{
		UpdateVisualState(useTransitions);
	}

	internal virtual void UpdateVisualState(bool useTransitions)
	{
		VisualStateManager.GoToState(this, IsDropDownOpen ? "PopupOpened" : "PopupClosed", useTransitions);
		Interaction.UpdateVisualStateBase(useTransitions);
	}
}
