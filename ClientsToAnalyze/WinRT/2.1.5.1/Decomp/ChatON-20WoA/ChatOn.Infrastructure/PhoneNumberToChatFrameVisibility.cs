using System;
using System.Linq;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class PhoneNumberToChatFrameVisibility : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (value == null)
		{
			return null;
		}
		DataService dataService = new DataService();
		Buddy buddy = dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == value as string);
		if (buddy != null && buddy.ImgStatus != Buddy.ProfileImgStatus.None)
		{
			return (object)(Visibility)0;
		}
		return (object)(Visibility)1;
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
