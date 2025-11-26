using System;
using System.Globalization;
using System.Windows;
using System.Windows.Data;

namespace Microsoft.Phone.Controls;

internal class VisibilityConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
	{
		if ((bool)value ^ (bool)parameter)
		{
			return Visibility.Visible;
		}
		return Visibility.Collapsed;
	}

	public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
	{
		throw new NotSupportedException();
	}
}
