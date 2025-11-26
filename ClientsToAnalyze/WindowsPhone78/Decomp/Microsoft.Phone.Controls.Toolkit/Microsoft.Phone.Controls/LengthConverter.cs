using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Globalization;
using System.Windows.Controls;
using Microsoft.Phone.Controls.Properties;

namespace Microsoft.Phone.Controls;

public class LengthConverter : TypeConverter
{
	private static Dictionary<string, double> UnitToPixelConversions = new Dictionary<string, double>
	{
		{ "px", 1.0 },
		{ "in", 96.0 },
		{ "cm", 37.79527559055118 },
		{ "pt", 1.3333333333333333 }
	};

	public override bool CanConvertFrom(ITypeDescriptorContext typeDescriptorContext, Type sourceType)
	{
		switch (Type.GetTypeCode(sourceType))
		{
		case TypeCode.Int16:
		case TypeCode.UInt16:
		case TypeCode.Int32:
		case TypeCode.UInt32:
		case TypeCode.Int64:
		case TypeCode.UInt64:
		case TypeCode.Single:
		case TypeCode.Double:
		case TypeCode.Decimal:
		case TypeCode.String:
			return true;
		default:
			return false;
		}
	}

	public override object ConvertFrom(ITypeDescriptorContext typeDescriptorContext, CultureInfo cultureInfo, object source)
	{
		if (source == null)
		{
			string message = string.Format(CultureInfo.CurrentCulture, Microsoft.Phone.Controls.Properties.Resources.TypeConverters_ConvertFrom_CannotConvertFromType, GetType().Name, "null");
			throw new NotSupportedException(message);
		}
		if (source is string text)
		{
			if (string.Compare(text, "Auto", StringComparison.OrdinalIgnoreCase) == 0)
			{
				return double.NaN;
			}
			string text2 = text;
			double num = 1.0;
			foreach (KeyValuePair<string, double> unitToPixelConversion in UnitToPixelConversions)
			{
				if (text2.EndsWith(unitToPixelConversion.Key, StringComparison.Ordinal))
				{
					num = unitToPixelConversion.Value;
					text2 = text.Substring(0, text2.Length - unitToPixelConversion.Key.Length);
					break;
				}
			}
			try
			{
				return num * Convert.ToDouble(text2, cultureInfo);
			}
			catch (FormatException)
			{
				string message2 = string.Format(CultureInfo.CurrentCulture, Microsoft.Phone.Controls.Properties.Resources.TypeConverters_Convert_CannotConvert, GetType().Name, text, typeof(double).Name);
				throw new FormatException(message2);
			}
		}
		return Convert.ToDouble(source, cultureInfo);
	}

	public override bool CanConvertTo(ITypeDescriptorContext typeDescriptorContext, Type destinationType)
	{
		return System.Windows.Controls.TypeConverters.CanConvertTo<double>(destinationType);
	}

	public override object ConvertTo(ITypeDescriptorContext typeDescriptorContext, CultureInfo cultureInfo, object value, Type destinationType)
	{
		if (value is double num && destinationType == typeof(string))
		{
			if (!num.IsNaN())
			{
				return Convert.ToString(num, cultureInfo);
			}
			return "Auto";
		}
		return System.Windows.Controls.TypeConverters.ConvertTo(this, value, destinationType);
	}
}
