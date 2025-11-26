using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class LongToDateOnUpdatesConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value == null)
		{
			return null;
		}
		DateTime dateTimeFromMiliseconds = Utility.GetDateTimeFromMiliseconds(long.Parse((string)value));
		return dateTimeFromMiliseconds.ToString("yyyy/MM/dd") + "\r\n" + dateTimeFromMiliseconds.ToString("HH:mm");
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
