using System;
using System.Windows;

namespace Microsoft.Phone.Controls;

public class DatePicker : DateTimePickerBase
{
	public static Visibility DaySelectorVisibility;

	public DatePicker()
	{
		base.DefaultStyleKey = typeof(DatePicker);
		base.Value = DateTime.Now.Date;
	}
}
