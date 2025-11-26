using System.CodeDom.Compiler;
using System.ComponentModel;
using System.Diagnostics;
using System.Globalization;
using System.Resources;
using System.Runtime.CompilerServices;

namespace Microsoft.Phone.Controls.Properties;

[GeneratedCode("System.Resources.Tools.StronglyTypedResourceBuilder", "4.0.0.0")]
[CompilerGenerated]
[DebuggerNonUserCode]
internal class Resources
{
	private static ResourceManager resourceMan;

	private static CultureInfo resourceCulture;

	[EditorBrowsable(EditorBrowsableState.Advanced)]
	internal static ResourceManager ResourceManager
	{
		get
		{
			if (object.ReferenceEquals(resourceMan, null))
			{
				ResourceManager resourceManager = new ResourceManager("Microsoft.Phone.Controls.Properties.Resources", typeof(Microsoft.Phone.Controls.Properties.Resources).Assembly);
				resourceMan = resourceManager;
			}
			return resourceMan;
		}
	}

	[EditorBrowsable(EditorBrowsableState.Advanced)]
	internal static CultureInfo Culture
	{
		get
		{
			return resourceCulture;
		}
		set
		{
			resourceCulture = value;
		}
	}

	internal static string AutoComplete_OnFilterModePropertyChanged_InvalidValue => ResourceManager.GetString("AutoComplete_OnFilterModePropertyChanged_InvalidValue", resourceCulture);

	internal static string AutoComplete_OnMaxDropDownHeightPropertyChanged_InvalidValue => ResourceManager.GetString("AutoComplete_OnMaxDropDownHeightPropertyChanged_InvalidValue", resourceCulture);

	internal static string AutoComplete_OnMinimumPopulateDelayPropertyChanged_InvalidValue => ResourceManager.GetString("AutoComplete_OnMinimumPopulateDelayPropertyChanged_InvalidValue", resourceCulture);

	internal static string AutoComplete_OnSearchTextPropertyChanged_InvalidWrite => ResourceManager.GetString("AutoComplete_OnSearchTextPropertyChanged_InvalidWrite", resourceCulture);

	internal static string InvalidDateTimeArgument => ResourceManager.GetString("InvalidDateTimeArgument", resourceCulture);

	internal static string InvalidExpanderViewOperation => ResourceManager.GetString("InvalidExpanderViewOperation", resourceCulture);

	internal static string InvalidNumberOfMonths => ResourceManager.GetString("InvalidNumberOfMonths", resourceCulture);

	internal static string InvalidNumberOfTimeUnits => ResourceManager.GetString("InvalidNumberOfTimeUnits", resourceCulture);

	internal static string InvalidSelectedIndex => ResourceManager.GetString("InvalidSelectedIndex", resourceCulture);

	internal static string InvalidSelectedItem => ResourceManager.GetString("InvalidSelectedItem", resourceCulture);

	internal static string NonSupportedDateTime => ResourceManager.GetString("NonSupportedDateTime", resourceCulture);

	internal static string Off => ResourceManager.GetString("Off", resourceCulture);

	internal static string On => ResourceManager.GetString("On", resourceCulture);

	internal static string RoutedPropertyChangingEventArgs_CancelSet_InvalidOperation => ResourceManager.GetString("RoutedPropertyChangingEventArgs_CancelSet_InvalidOperation", resourceCulture);

	internal static string TypeConverters_Convert_CannotConvert => ResourceManager.GetString("TypeConverters_Convert_CannotConvert", resourceCulture);

	internal static string TypeConverters_ConvertFrom_CannotConvertFromType => ResourceManager.GetString("TypeConverters_ConvertFrom_CannotConvertFromType", resourceCulture);

	internal static string UnexpectedType => ResourceManager.GetString("UnexpectedType", resourceCulture);

	internal static string WrapPanel_OnItemHeightOrWidthPropertyChanged_InvalidValue => ResourceManager.GetString("WrapPanel_OnItemHeightOrWidthPropertyChanged_InvalidValue", resourceCulture);

	internal static string WrapPanel_OnOrientationPropertyChanged_InvalidValue => ResourceManager.GetString("WrapPanel_OnOrientationPropertyChanged_InvalidValue", resourceCulture);

	internal Resources()
	{
	}
}
