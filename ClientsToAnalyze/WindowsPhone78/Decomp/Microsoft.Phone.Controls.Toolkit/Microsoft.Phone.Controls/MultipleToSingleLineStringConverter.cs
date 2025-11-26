using System;
using System.Globalization;
using System.Windows.Data;

namespace Microsoft.Phone.Controls;

internal class MultipleToSingleLineStringConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
	{
		return ((string)value).Replace(Environment.NewLine, " ");
	}

	public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
	{
		throw new NotSupportedException();
	}
}
