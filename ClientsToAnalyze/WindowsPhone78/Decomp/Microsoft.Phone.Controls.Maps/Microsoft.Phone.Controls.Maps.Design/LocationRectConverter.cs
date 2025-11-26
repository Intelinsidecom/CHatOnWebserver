using System;
using System.ComponentModel;
using System.Globalization;

namespace Microsoft.Phone.Controls.Maps.Design;

public class LocationRectConverter : TypeConverter
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
			if (array.Length == 4)
			{
				return new LocationRect(double.Parse(array[0], CultureInfo.InvariantCulture), double.Parse(array[1], CultureInfo.InvariantCulture), double.Parse(array[2], CultureInfo.InvariantCulture), double.Parse(array[3], CultureInfo.InvariantCulture));
			}
			throw new FormatException(ExceptionStrings.TypeConverter_InvalidLocationRectFormat);
		}
		throw new NotSupportedException(ExceptionStrings.TypeConverter_InvalidLocationRectFormat);
	}
}
