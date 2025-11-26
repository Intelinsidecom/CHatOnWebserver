using System;
using System.Globalization;

namespace Microsoft.Phone.Controls;

public class TimePicker : DateTimePickerBase
{
	private string _fallbackValueStringFormat;

	protected override string ValueStringFormatFallback
	{
		get
		{
			if (_fallbackValueStringFormat == null)
			{
				string text = CultureInfo.CurrentCulture.DateTimeFormat.LongTimePattern.Replace(":ss", "");
				_fallbackValueStringFormat = "{0:" + text + "}";
			}
			return _fallbackValueStringFormat;
		}
	}

	public TimePicker()
	{
		base.DefaultStyleKey = typeof(TimePicker);
		base.Value = DateTime.Now;
	}
}
