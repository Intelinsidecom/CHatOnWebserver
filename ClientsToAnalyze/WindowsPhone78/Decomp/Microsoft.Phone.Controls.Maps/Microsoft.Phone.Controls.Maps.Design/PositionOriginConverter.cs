using System;
using System.ComponentModel;
using System.Globalization;
using System.Reflection;

namespace Microsoft.Phone.Controls.Maps.Design;

public class PositionOriginConverter : TypeConverter
{
	public override bool CanConvertFrom(ITypeDescriptorContext context, Type sourceType)
	{
		return sourceType == typeof(string);
	}

	public override object ConvertFrom(ITypeDescriptorContext context, CultureInfo culture, object value)
	{
		if (value is string text)
		{
			string[] array = text.Split(',');
			if (array.Length == 2)
			{
				return new PositionOrigin(double.Parse(array[0], CultureInfo.InvariantCulture), double.Parse(array[1], CultureInfo.InvariantCulture));
			}
			FieldInfo field = typeof(PositionOrigin).GetField(text, BindingFlags.IgnoreCase | BindingFlags.Static | BindingFlags.Public);
			if (field != null)
			{
				return field.GetValue(null);
			}
			throw new FormatException(ExceptionStrings.TypeConverter_InvalidPositionOriginFormat);
		}
		throw new NotSupportedException(ExceptionStrings.TypeConverter_InvalidPositionOriginFormat);
	}
}
