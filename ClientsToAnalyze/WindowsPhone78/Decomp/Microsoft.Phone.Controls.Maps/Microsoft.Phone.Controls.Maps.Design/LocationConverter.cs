using System;
using System.ComponentModel;
using System.Device.Location;
using System.Globalization;

namespace Microsoft.Phone.Controls.Maps.Design;

public class LocationConverter : TypeConverter
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
			switch (array.Length)
			{
			case 2:
			{
				if (double.TryParse(array[0], NumberStyles.Float, CultureInfo.InvariantCulture, out var result4) && double.TryParse(array[1], NumberStyles.Float, CultureInfo.InvariantCulture, out var result5))
				{
					GeoCoordinate geoCoordinate2 = new GeoCoordinate();
					geoCoordinate2.Latitude = result4;
					geoCoordinate2.Longitude = result5;
					return geoCoordinate2;
				}
				break;
			}
			case 3:
			{
				if (double.TryParse(array[0], NumberStyles.Float, CultureInfo.InvariantCulture, out var result6) && double.TryParse(array[1], NumberStyles.Float, CultureInfo.InvariantCulture, out var result7) && double.TryParse(array[2], NumberStyles.Float, CultureInfo.InvariantCulture, out var result8))
				{
					GeoCoordinate geoCoordinate3 = new GeoCoordinate();
					geoCoordinate3.Latitude = result6;
					geoCoordinate3.Longitude = result7;
					geoCoordinate3.Altitude = result8;
					return geoCoordinate3;
				}
				break;
			}
			case 4:
			{
				if (double.TryParse(array[0], NumberStyles.Float, CultureInfo.InvariantCulture, out var result) && double.TryParse(array[1], NumberStyles.Float, CultureInfo.InvariantCulture, out var result2) && double.TryParse(array[2], NumberStyles.Float, CultureInfo.InvariantCulture, out var result3))
				{
					GeoCoordinate geoCoordinate = new GeoCoordinate();
					geoCoordinate.Latitude = result;
					geoCoordinate.Longitude = result2;
					geoCoordinate.Altitude = result3;
					return geoCoordinate;
				}
				break;
			}
			}
			throw new FormatException(ExceptionStrings.TypeConverter_InvalidLocationFormat);
		}
		throw new NotSupportedException(ExceptionStrings.TypeConverter_InvalidLocationFormat);
	}
}
