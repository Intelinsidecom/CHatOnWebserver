using System;
using System.Collections.Generic;
using System.Linq;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class PhoneNumbersToNames : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value == null)
		{
			return null;
		}
		string input = value as string;
		DataService dataService = new DataService();
		string[] array = Utility.Split(input);
		string text = "";
		int num = 0;
		string[] array2 = array;
		foreach (string number in array2)
		{
			IEnumerable<Buddy> buddyItems = dataService.BuddyItems;
			Func<Buddy, bool> predicate = (Buddy c) => c.PhoneNumber == number;
			Buddy buddy = buddyItems.FirstOrDefault(predicate);
			if (buddy != null)
			{
				text += buddy.Name;
				num++;
				if (num >= array.Length)
				{
					break;
				}
				text += ",";
			}
		}
		return text;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
