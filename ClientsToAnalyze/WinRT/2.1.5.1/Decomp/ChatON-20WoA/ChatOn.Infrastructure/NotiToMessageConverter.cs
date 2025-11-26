using System;
using System.Collections.Generic;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Xaml.Data;

namespace ChatOn.Infrastructure;

public class NotiToMessageConverter : IValueConverter
{
	public object Convert(object value, Type targetType, object parameter, string language)
	{
		if (!(value is Message message))
		{
			return null;
		}
		if (message.Type != "noti")
		{
			return null;
		}
		string text = message.Text;
		string text2 = "";
		string[] array = Utility.Split(text, '\n');
		List<string> list = new List<string>();
		bool flag = true;
		foreach (string text3 in array)
		{
			if (string.IsNullOrEmpty(text3))
			{
				break;
			}
			string[] array2 = Utility.Split(text3);
			if (array2[0] == "LEAVE")
			{
				flag = false;
			}
			list.Add(array2[2]);
		}
		if (flag)
		{
			if (string.IsNullOrEmpty(message.Sender) || message.Sender.Equals(RegistrationService.ChatOnID))
			{
				return text2 + Utility.sprintf(Utility.GetResourceString("IDS_CHATON_BODY_YOU_INVITED_PS"), string.Join(",", list));
			}
			string sender = message.Sender;
			SSMService ssmService = new SSMService();
			DataService dataService = new DataService();
			BuddyService buddyService = new BuddyService(dataService, ssmService);
			sender = buddyService.GetBuddyNameByNumber(sender, out var _);
			return text2 + Utility.sprintf(Utility.GetResourceString("IDS_CHATON_BODY_PS_INVITED_PS"), sender, string.Join(",", list));
		}
		return text2 + Utility.sprintf(Utility.GetResourceString("IDS_CHATON_BODY_PS_LEFT_THIS_CHAT"), string.Join(",", list));
	}

	public object ConvertBack(object value, Type targetType, object parameter, string language)
	{
		throw new NotImplementedException();
	}
}
