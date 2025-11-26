using System;
using System.ComponentModel;
using System.Globalization;
using System.Reflection;

namespace Microsoft.Phone.Controls.Maps.Design;

public class MapModeConverter : TypeConverter
{
	public override bool CanConvertFrom(ITypeDescriptorContext context, Type sourceType)
	{
		return sourceType == typeof(string);
	}

	public override object ConvertFrom(ITypeDescriptorContext context, CultureInfo culture, object value)
	{
		if (value is string b)
		{
			PropertyInfo[] properties = typeof(MapModes).GetProperties();
			foreach (PropertyInfo propertyInfo in properties)
			{
				if (string.Equals(propertyInfo.Name, b, StringComparison.OrdinalIgnoreCase) || string.Equals(propertyInfo.PropertyType.FullName, b, StringComparison.OrdinalIgnoreCase))
				{
					return propertyInfo.GetValue(null, null);
				}
			}
			throw new FormatException(ExceptionStrings.TypeConverter_InvalidMapMode);
		}
		throw new NotSupportedException(ExceptionStrings.TypeConverter_InvalidMapMode);
	}
}
