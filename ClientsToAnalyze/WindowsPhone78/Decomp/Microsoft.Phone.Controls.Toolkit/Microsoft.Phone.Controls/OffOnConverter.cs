using System;
using System.Globalization;
using System.Windows.Data;
using Microsoft.Phone.Controls.Properties;

namespace Microsoft.Phone.Controls;

public class OffOnConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
	{
		if (targetType == null)
		{
			throw new ArgumentNullException("targetType");
		}
		if (targetType != typeof(object))
		{
			throw new ArgumentException(Microsoft.Phone.Controls.Properties.Resources.UnexpectedType, "targetType");
		}
		if (value is bool? || value == null)
		{
			if ((bool?)value != true)
			{
				return Microsoft.Phone.Controls.Properties.Resources.Off;
			}
			return Microsoft.Phone.Controls.Properties.Resources.On;
		}
		throw new ArgumentException(Microsoft.Phone.Controls.Properties.Resources.UnexpectedType, "value");
	}

	public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
	{
		throw new NotImplementedException();
	}
}
