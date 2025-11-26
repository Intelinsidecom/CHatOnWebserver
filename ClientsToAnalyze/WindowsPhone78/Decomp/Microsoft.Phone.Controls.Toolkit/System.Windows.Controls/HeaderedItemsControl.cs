using System.Windows.Data;

namespace System.Windows.Controls;

[StyleTypedProperty(Property = "ItemContainerStyle", StyleTargetType = typeof(ContentPresenter))]
public class HeaderedItemsControl : ItemsControl
{
	public static readonly DependencyProperty HeaderProperty = DependencyProperty.Register("Header", typeof(object), typeof(HeaderedItemsControl), new PropertyMetadata(OnHeaderPropertyChanged));

	public static readonly DependencyProperty HeaderTemplateProperty = DependencyProperty.Register("HeaderTemplate", typeof(DataTemplate), typeof(HeaderedItemsControl), new PropertyMetadata(OnHeaderTemplatePropertyChanged));

	public static readonly DependencyProperty ItemContainerStyleProperty = DependencyProperty.Register("ItemContainerStyle", typeof(Style), typeof(HeaderedItemsControl), new PropertyMetadata(null, OnItemContainerStylePropertyChanged));

	internal bool HeaderIsItem { get; set; }

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
			return GetValue(HeaderTemplateProperty) as DataTemplate;
		}
		set
		{
			SetValue(HeaderTemplateProperty, value);
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

	internal ItemsControlHelper ItemsControlHelper { get; private set; }

	private static void OnHeaderPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		HeaderedItemsControl headeredItemsControl = d as HeaderedItemsControl;
		headeredItemsControl.OnHeaderChanged(e.OldValue, e.NewValue);
	}

	private static void OnHeaderTemplatePropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		HeaderedItemsControl headeredItemsControl = d as HeaderedItemsControl;
		DataTemplate oldHeaderTemplate = e.OldValue as DataTemplate;
		DataTemplate newHeaderTemplate = e.NewValue as DataTemplate;
		headeredItemsControl.OnHeaderTemplateChanged(oldHeaderTemplate, newHeaderTemplate);
	}

	private static void OnItemContainerStylePropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		HeaderedItemsControl headeredItemsControl = d as HeaderedItemsControl;
		Style itemContainerStyle = e.NewValue as Style;
		headeredItemsControl.ItemsControlHelper.UpdateItemContainerStyle(itemContainerStyle);
	}

	public HeaderedItemsControl()
	{
		base.DefaultStyleKey = typeof(HeaderedItemsControl);
		ItemsControlHelper = new ItemsControlHelper(this);
	}

	protected virtual void OnHeaderChanged(object oldHeader, object newHeader)
	{
	}

	protected virtual void OnHeaderTemplateChanged(DataTemplate oldHeaderTemplate, DataTemplate newHeaderTemplate)
	{
	}

	public override void OnApplyTemplate()
	{
		ItemsControlHelper.OnApplyTemplate();
		((FrameworkElement)this).OnApplyTemplate();
	}

	protected override void PrepareContainerForItemOverride(DependencyObject element, object item)
	{
		ItemsControlHelper.PrepareContainerForItemOverride(element, ItemContainerStyle);
		PreparePrepareHeaderedItemsControlContainerForItemOverride(element, item, this, ItemContainerStyle);
		base.PrepareContainerForItemOverride(element, item);
	}

	internal static void PreparePrepareHeaderedItemsControlContainerForItemOverride(DependencyObject element, object item, ItemsControl parent, Style parentItemContainerStyle)
	{
		if (element is HeaderedItemsControl control)
		{
			PrepareHeaderedItemsControlContainer(control, item, parent, parentItemContainerStyle);
		}
	}

	private static void PrepareHeaderedItemsControlContainer(HeaderedItemsControl control, object item, ItemsControl parentItemsControl, Style parentItemContainerStyle)
	{
		if (control == item)
		{
			return;
		}
		DataTemplate itemTemplate = parentItemsControl.ItemTemplate;
		if (itemTemplate != null)
		{
			control.SetValue(ItemsControl.ItemTemplateProperty, itemTemplate);
		}
		if (parentItemContainerStyle != null && HasDefaultValue(control, ItemContainerStyleProperty))
		{
			control.SetValue(ItemContainerStyleProperty, parentItemContainerStyle);
		}
		if (control.HeaderIsItem || HasDefaultValue(control, HeaderProperty))
		{
			control.Header = item;
			control.HeaderIsItem = true;
		}
		if (itemTemplate != null)
		{
			control.SetValue(HeaderTemplateProperty, itemTemplate);
		}
		if (parentItemContainerStyle != null && control.Style == null)
		{
			control.SetValue(FrameworkElement.StyleProperty, parentItemContainerStyle);
		}
		if (!(itemTemplate is HierarchicalDataTemplate hierarchicalDataTemplate))
		{
			return;
		}
		if (hierarchicalDataTemplate.ItemsSource != null && HasDefaultValue(control, ItemsControl.ItemsSourceProperty))
		{
			control.SetBinding(ItemsControl.ItemsSourceProperty, new Binding
			{
				Converter = hierarchicalDataTemplate.ItemsSource.Converter,
				ConverterCulture = hierarchicalDataTemplate.ItemsSource.ConverterCulture,
				ConverterParameter = hierarchicalDataTemplate.ItemsSource.ConverterParameter,
				Mode = hierarchicalDataTemplate.ItemsSource.Mode,
				NotifyOnValidationError = hierarchicalDataTemplate.ItemsSource.NotifyOnValidationError,
				Path = hierarchicalDataTemplate.ItemsSource.Path,
				Source = control.Header,
				ValidatesOnExceptions = hierarchicalDataTemplate.ItemsSource.ValidatesOnExceptions
			});
		}
		if (hierarchicalDataTemplate.IsItemTemplateSet && control.ItemTemplate == itemTemplate)
		{
			control.ClearValue(ItemsControl.ItemTemplateProperty);
			if (hierarchicalDataTemplate.ItemTemplate != null)
			{
				control.ItemTemplate = hierarchicalDataTemplate.ItemTemplate;
			}
		}
		if (hierarchicalDataTemplate.IsItemContainerStyleSet && control.ItemContainerStyle == parentItemContainerStyle)
		{
			control.ClearValue(ItemContainerStyleProperty);
			if (hierarchicalDataTemplate.ItemContainerStyle != null)
			{
				control.ItemContainerStyle = hierarchicalDataTemplate.ItemContainerStyle;
			}
		}
	}

	private static bool HasDefaultValue(Control control, DependencyProperty property)
	{
		return control.ReadLocalValue(property) == DependencyProperty.UnsetValue;
	}
}
