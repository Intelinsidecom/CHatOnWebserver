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
			if (message.Sender == RegistrationService.ChatOnID)
			{
				message.ActivityState = Message.State.Sent;
			}
			list.Add(message);
		}
		_dataService.UnreadMessages = list;
		return list;
	}

	internal List<Message> ParseAllMessageFromXml(XElement xe, Chat chat, out bool isHasMore)
	{
		_ = DateTime.Now.Ticks;
		List<Message> list = new List<Message>();
		IEnumerable<XElement> enumerable = from item in xe.Descendants("messages")
			select (item);
		foreach (XElement item in enumerable)
		{
			Message message = new Message();
			message.ActivityState = Message.State.Received;
			message.Type = item.Element("type").Value;
			if (message.Type == "msg")
			{
				message.Type = "text";
			}
			message.Text = item.Element("msg").Value;
			message.Tid = item.Element("tid").Value;
			if (item.Element("time") != null)
			{
				message.Time = long.Parse(item.Element("time").Value);
			}
			if (item.Element("sender") != null)
			{
				message.Sender = item.Element("sender").Value;
			}
			if (message.Sender == RegistrationService.ChatOnID)
			{
				message.ActivityState = Message.State.Sent;
			}
			if (item.Element("id") != null)
			{
				message.NumberID = long.Parse(item.Element("id").Value);
			}
			if (chat.SessionID != null)
			{
				message.SessionID = chat.SessionID;
			}
			message.ChatID = chat.ChatID;
			message.Chat = chat;
			message.Receiver = "";
			message.ReceiverCount = 0;
			if (message.Type == "media" && message.Text.Contains("ams\n") && !message.Text.Contains("image") && !message.Text.Contains("video") && !message.Text.Contains("anicon") && !message.Text.Contains("audio") && !message.Text.Contains("mixed") && !message.Text.Contains("calendar") && !message.Text.Contains("geo") && !message.Text.Contains("contact"))
			{
				message.Text = message.Text.Replace("ams", "image");
			}
			if (message.Type == "media" && message.Text.Contains("ams\n"))
			{
				message.Text = message.Text.Replace("ams", "image");
			}
			if ((message.Type == "media" && message.Text.Contains("doc\n") && message.Text.Contains("doc\nxls")) || message.Text.Contains("doc\ndoc") || message.Text.Contains("doc\nppt") || message.Text.Contains("doc\npdf") || message.Text.Contains("doc\nhwp") || message.Text.Contains("doc\ngul"))
			{
				message.Text = Utility.GetResourceString("IDS_CHATON_BODY_UNSUPPORTED_FILE_TYPE");
				message.Type = "text";
			}
			list.Add(message);
		}
		isHasMore = false;
		if (xe.Element("has_more") != null)
		{
			isHasMore = bool.Parse(xe.Element("has_more").Value);
		}
		return list;
	}
}
