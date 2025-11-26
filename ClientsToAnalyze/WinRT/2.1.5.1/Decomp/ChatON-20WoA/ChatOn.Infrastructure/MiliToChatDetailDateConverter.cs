using System;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class MiliToChatDetailDateConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		DateTime dateTimeFromMiliseconds = Utility.GetDateTimeFromMiliseconds((long)value);
		if (dateTimeFromMiliseconds.Year == DateTime.Today.Year && dateTimeFromMiliseconds.Month == DateTime.Today.Month && dateTimeFromMiliseconds.Day == DateTime.Today.Day)
		{
			return Utility.GetResourceString("IDS_CHATON_BODY_TODAY");
		}
		return dateTimeFromMiliseconds.ToString("d");
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
