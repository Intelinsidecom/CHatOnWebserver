using System.ComponentModel;
using System.Globalization;
using Microsoft.Phone.Controls.Properties;

namespace System.Windows.Controls;

public class TimeTypeConverter : TypeConverter
{
	private static readonly string[] _timeFormats = new string[6] { "h:mm tt", "h:mm:ss tt", "HH:mm", "HH:mm:ss", "H:mm", "H:mm:ss" };

	private static readonly string[] _dateFormats = new string[1] { "M/d/yyyy" };

	public override bool CanConvertFrom(ITypeDescriptorContext typeDescriptorContext, Type sourceType)
	{
		return Type.GetTypeCode(sourceType) == TypeCode.String;
	}

	public override bool CanConvertTo(ITypeDescriptorContext typeDescriptorContext, Type destinationType)
	{
		if (Type.GetTypeCode(destinationType) != TypeCode.String)
		{
			return System.Windows.Controls.TypeConverters.CanConvertTo<DateTime?>(destinationType);
		}
		return true;
	}

	public override object ConvertFrom(ITypeDescriptorContext typeDescriptorContext, CultureInfo cultureInfo, object source)
	{
		if (source == null)
		{
			return null;
		}
		if (!(source is string text))
		{
			string message = string.Format(CultureInfo.CurrentCulture, Microsoft.Phone.Controls.Properties.Resources.TypeConverters_Convert_CannotConvert, GetType().Name, source, typeof(DateTime).Name);
			throw new InvalidCastException(message);
		}
		if (string.IsNullOrEmpty(text))
		{
			return null;
		}
		string[] timeFormats = _timeFormats;
		DateTime result;
		foreach (string format in timeFormats)
		{
			if (DateTime.TryParseExact(text, format, CultureInfo.InvariantCulture, DateTimeStyles.NoCurrentDateDefault, out result))
			{
				return DateTime.Now.Date.Add(result.TimeOfDay);
			}
		}
		string[] dateFormats = _dateFormats;
		foreach (string text2 in dateFormats)
		{
			string[] timeFormats2 = _timeFormats;
			foreach (string text3 in timeFormats2)
			{
				if (DateTime.TryParseExact(text, string.Format(CultureInfo.InvariantCulture, "{0} {1}", text2, text3), CultureInfo.InvariantCulture, DateTimeStyles.None, out result))
				{
					return result;
				}
			}
		}
		string[] dateFormats2 = _dateFormats;
		foreach (string format2 in dateFormats2)
		{
			if (DateTime.TryParseExact(text, format2, CultureInfo.InvariantCulture, DateTimeStyles.NoCurrentDateDefault, out result))
			{
				return result;
			}
		}
		string message2 = string.Format(CultureInfo.CurrentCulture, Microsoft.Phone.Controls.Properties.Resources.TypeConverters_Convert_CannotConvert, GetType().Name, text, typeof(DateTime).Name);
		throw new FormatException(message2);
	}

	public override object ConvertTo(ITypeDescriptorContext typeDescriptorContext, CultureInfo cultureInfo, object value, Type destinationType)
	{
		if (destinationType == typeof(string))
		{
			if (value == null)
			{
				return string.Empty;
			}
			if (value is DateTime dateTime)
			{
				return dateTime.ToString("HH:mm:ss", new CultureInfo("en-US"));
			}
		}
		return System.Windows.Controls.TypeConverters.ConvertTo(this, value, destinationType);
	}
}
