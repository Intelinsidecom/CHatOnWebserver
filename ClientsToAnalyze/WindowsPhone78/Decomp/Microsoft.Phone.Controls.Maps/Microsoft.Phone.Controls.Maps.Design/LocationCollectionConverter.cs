using System;
using System.ComponentModel;
using System.Device.Location;
using System.Globalization;

namespace Microsoft.Phone.Controls.Maps.Design;

public class LocationCollectionConverter : TypeConverter
{
	public override bool CanConvertFrom(ITypeDescriptorContext context, Type sourceType)
	{
		return sourceType == typeof(string);
	}

	public override object ConvertFrom(ITypeDescriptorContext context, CultureInfo culture, object value)
	{
		if (value is string text)
		{
			LocationCollection locationCollection = new LocationCollection();
			LocationConverter locationConverter = new LocationConverter();
			int num = -1;
			for (int i = 0; i < text.Length + 1; i++)
			{
				if (i >= text.Length || char.IsWhiteSpace(text[i]))
				{
					int num2 = num + 1;
					int num3 = i - num2;
					if (num3 >= 1)
					{
						string value2 = text.Substring(num2, num3);
						locationCollection.Add((GeoCoordinate)locationConverter.ConvertFrom(value2));
					}
					num = i;
				}
			}
			return locationCollection;
		}
		throw new NotSupportedException(ExceptionStrings.TypeConverter_InvalidLocationCollection);
	}
}
