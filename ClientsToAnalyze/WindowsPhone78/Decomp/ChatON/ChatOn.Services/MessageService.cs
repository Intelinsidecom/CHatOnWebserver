using System;
using System.Collections.Generic;
using System.Linq;
using System.Xml.Linq;
using ChatOn.Infrastructure;
using ChatOn.Models;
using com.sec.ssm.common;

namespace ChatOn.Services;

public class MessageService
{
	private DataService _dataService;

	private SSMService _ssmService;

	public MessageService(DataService dataService, SSMService ssmService)
	{
		_dataService = dataService;
		_ssmService = ssmService;
	}

	public static string GetMediaFileNameFromMessage(Message msg)
	{
		if (msg.Type == "text")
		{
			return null;
		}
		string text = msg.Text;
		string[] array = Utility.Split(text, '\n');
		return array[3];
	}

	internal IList<Message> ParseFromXml(XElement xe)
	{
		_ = DateTime.Now.Ticks;
		NotificationObject.IsBlockChangedNotification = true;
		NotificationObject.IsBlockChangingNotification = true;
		List<Message> list = new List<Message>();
		IEnumerable<XElement> enumerable = from item in xe.Descendants("msg")
			select (item);
		foreach (XElement item in enumerable)
		{
			Message message = new Message();
			message.ActivityState = Message.State.Received;
			message.Type = item.Attribute("type").Value;
			if (message.Type == "msg")
			{
				message.Type = "text";
			}
			message.Text = item.Value;
			message.Tid = item.Attribute("tid").Value;
			if (item.Attribute("time") != null)
			{
				message.Time = long.Parse(item.Attribute("time").Value);
			}
			if (item.Attribute("sender") != null)
			{
				message.Sender = item.Attribute("sender").Value;
			}
			if (item.Attribute("chattype") != null)
			{
				message.ChatType = (ChatType)int.Parse(item.Attribute("chattype").Value);
			}
			if (item.Attribute("sessionid") != null)
			{
				message.SessionID = item.Attribute("sessionid").Value;
			}
			if (item.Attribute("address") != null)
			{
				message.Address = item.Attribute("address").Value;
			}
			if (item.Attribute("port") != null)
			{
				message.Port = int.Parse(item.Attribute("port").Value);
			}
			if (item.Attribute("receiver") != null)
			{
				message.Receiver = item.Attribute("receiver").Value;
			}
			if (item.Attribute("id") != null)
			{
				message.NumberID = long.Parse(item.Attribute("id").Value);
			}
			list.Add(message);
		}
		NotificationObject.IsBlockChangedNotification = false;
		NotificationObject.IsBlockChangingNotification = false;
		_dataService.UnreadMessages = list;
		return list;
	}
}
