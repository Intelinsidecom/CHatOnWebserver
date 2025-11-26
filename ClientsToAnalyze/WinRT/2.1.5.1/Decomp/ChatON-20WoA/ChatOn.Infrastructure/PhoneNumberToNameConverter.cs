using System;
using ChatOn.Services;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class PhoneNumberToNameConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value == null)
		{
			return null;
		}
		string number = value as string;
		SSMService ssmService = new SSMService();
		DataService dataService = new DataService();
		BuddyService buddyService = new BuddyService(dataService, ssmService);
		bool unknown;
		return buddyService.GetBuddyNameByNumber(number, out unknown);
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
