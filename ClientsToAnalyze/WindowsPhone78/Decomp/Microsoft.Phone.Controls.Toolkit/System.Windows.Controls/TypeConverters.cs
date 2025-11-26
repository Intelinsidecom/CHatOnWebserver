using System.ComponentModel;
using System.Globalization;
using Microsoft.Phone.Controls.Properties;

namespace System.Windows.Controls;

internal static class TypeConverters
{
	internal static bool CanConvertTo<T>(Type destinationType)
	{
		if (destinationType == null)
		{
			throw new ArgumentNullException("destinationType");
		}
		if (destinationType != typeof(string))
		{
			return destinationType.IsAssignableFrom(typeof(T));
		}
		return true;
	}

	internal static object ConvertTo(TypeConverter converter, object value, Type destinationType)
	{
		if (destinationType == null)
		{
			throw new ArgumentNullException("destinationType");
		}
		if (value == null && !destinationType.IsValueType)
		{
			return null;
		}
		if (value != null && destinationType.IsAssignableFrom(value.GetType()))
		{
			return value;
		}
		throw new NotSupportedException(string.Format(CultureInfo.CurrentCulture, Microsoft.Phone.Controls.Properties.Resources.TypeConverters_Convert_CannotConvert, converter.GetType().Name, (value != null) ? value.GetType().FullName : "(null)", destinationType.GetType().Name));
	}
}
