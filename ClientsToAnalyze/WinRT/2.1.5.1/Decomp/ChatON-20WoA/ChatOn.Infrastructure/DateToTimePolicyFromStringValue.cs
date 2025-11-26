using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class DateToTimePolicyFromStringValue : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value == null)
		{
			return null;
		}
		if (string.IsNullOrEmpty(value as string))
		{
			return null;
		}
		DateTime dateTime = DateTime.Parse(value as string);
		if (dateTime.Year == DateTime.Today.Year && dateTime.Month == DateTime.Today.Month && dateTime.Day == DateTime.Today.Day)
		{
			return dateTime.ToString("t");
		}
		if (dateTime.Year < DateTime.Today.Year)
		{
			return dateTime.ToString("d");
		}
		return dateTime.ToString("m");
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
