using System;
using System.Collections.Generic;
using System.Linq;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using com.sec.ssm.common;

namespace ChatOn.Services;

public class ChatService
{
	public static int MAX_TEXT_LENGTH = 2000;

	public static int MAX_CHAT_MEMBERS = 50;

	public static int MAX_BROADCAST_MEMBERS = 101;

	private DataService _dataService;

	private BuddyService _buddyService;

	private string _myNumber;

	private object _thisLock = new object();

	public ChatService(DataService dataService, BuddyService buddyService, string myNumber)
	{
		_dataService = dataService;
		_buddyService = buddyService;
		_myNumber = string.Copy(myNumber);
	}

	public Chat StartChat(string sender, string member, ChatType chatType, string sessionID = "")
	{
		if (chatType == ChatType.SINGLE)
		{
			Chat chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.Members == sender && c.ChatType == chatType && c.IsValidSession.Value);
			if (chat != null)
			{
				return chat;
			}
		}
		else if ((chatType == ChatType.GROUP && !string.IsNullOrEmpty(sessionID)) | (chatType == ChatType.BROADCAST && !string.IsNullOrEmpty(sessionID)))
		{
			Chat chat2 = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == sessionID);
			if (chat2 != null)
			{
				return chat2;
			}
		}
		Chat chat3 = new Chat();
		chat3.ChatType = chatType;
		EnterMember(chat3, sender);
		if (string.IsNullOrEmpty(chat3.Sender))
		{
			chat3.Sender = sender;
		}
		if (!string.IsNullOrEmpty(member))
		{
			string[] array = Utility.Split(member);
			string[] array2 = array;
			foreach (string number in array2)
			{
				EnterMember(chat3, number);
			}
		}
		if (!string.IsNullOrEmpty(sessionID))
		{
			chat3.SessionID = sessionID;
		}
		_dataService.AddChat(chat3);
		UpdateChatSummary(chat3);
		return chat3;
	}

	public void CloseChat(Chat chat)
	{
		if (!string.IsNullOrEmpty(chat.SessionID))
		{
			Utility.DeleteDirectory(chat.SessionID);
		}
		_dataService.DeleteChat(chat);
	}

	public void AddMessageToShow(Chat chat, Message msg, bool addToDB = true)
	{
		lock (_thisLock)
		{
			chat.AddMessage(msg);
		}
		if (addToDB)
		{
			_dataService.AddMessage(msg);
		}
	}

	public void AddMessage(Chat chat, Message msg)
	{
		lock (_thisLock)
		{
			chat.Messages.Add(msg);
		}
	}

	public void DeleteMessage(Chat chat, Message msg)
	{
		lock (_thisLock)
		{
			chat.DeleteMessage(msg);
		}
		_dataService.DeleteMessage(msg);
	}

	public void DeleteSelectedMessages(Chat chat)
	{
		lock (_thisLock)
		{
			for (int num = chat.Messages.Count - 1; num >= 0; num--)
			{
				if (chat.Messages[num].IsChecked)
				{
					_dataService.DeleteMessage(chat.Messages[num], isSubmit: false);
					chat.DeleteMessage(chat.Messages[num]);
				}
			}
			_dataService.SubmitChanges();
		}
		UpdateChatSummary(chat);
	}

	internal void ReflectAnswerBackMessage(Chat chat, string number, long time)
	{
		if (time == 0)
		{
			time = chat.LastMessage.Time;
		}
		AnsInfo ansInfo = chat.AnsInfo.FirstOrDefault((AnsInfo c) => c.PhoneNumber == number);
		if (ansInfo == null)
		{
			chat.AnsInfo.Add(new AnsInfo
			{
				PhoneNumber = number,
				Time = time
			});
		}
		else
		{
			ansInfo.Time = time;
		}
		SaveAnsInfo(chat);
	}

	public void ReflectUnreadMessage(string sessionID = "")
	{
		ResetUnreadMessage();
		foreach (Message unreadMessage in _dataService.UnreadMessages)
		{
			ReflectUnreadMessage(unreadMessage);
		}
		UpdateAllChatSummary();
		_dataService.SubmitChanges();
	}

	internal void ResetUnreadMessage()
	{
		foreach (Chat chatItem in _dataService.ChatItems)
		{
			chatItem.UnreadMessageCount = 0;
		}
	}

	internal Chat ReflectUnreadMessage(Message msg)
	{
		if (!string.IsNullOrEmpty(msg.Tid))
		{
			Message message = _dataService.FirstOrDefaultMessage((Message m) => m.Tid == msg.Tid);
			if (message != null && message.Chat != null)
			{
				return null;
			}
		}
		Chat chat = null;
		if (msg.ChatType != ChatType.BROADCAST && !string.IsNullOrEmpty(msg.SessionID))
		{
			chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == msg.SessionID);
		}
		RegistrationService.GetUserNumber();
		if (chat != null)
		{
			if (msg.Type == "noti")
			{
				ClearMember(chat);
				string[] array = Utility.Split(msg.Receiver);
				string[] array2 = array;
				foreach (string number in array2)
				{
					EnterMember(chat, number);
				}
				string[] array3 = Utility.Split(msg.Text);
				if (array3[0] == "ENTER")
				{
					EnterMember(chat, msg.Sender);
					EnterMember(chat, array3[1]);
					_buddyService.SaveOrUpdateUnknownUser(array3[1], array3[2]);
				}
			}
			else if (msg.Type != "ans")
			{
				chat.UnreadMessageCount++;
				msg.ActivityState = Message.State.Received;
			}
			if (msg.Type != "ans")
			{
				if (chat.LastMessage == null)
				{
					chat.LastMessage = msg;
				}
				else if (chat.LastMessage.Time < msg.Time)
				{
					chat.LastMessage = msg;
				}
				chat.ReflectMessageInfo(msg);
			}
		}
		else if (msg.Type == "ans")
		{
			Message message2 = _dataService.FirstOrDefaultMessage((Message m) => m.NumberID == msg.NumberID);
			if (message2 != null)
			{
				ReflectAnswerBackMessage(message2.Chat, msg.Receiver, msg.Time);
			}
		}
		else if (msg.Type != "noti")
		{
			chat = StartChat(msg.Sender, msg.Receiver, (msg.ChatType != ChatType.BROADCAST) ? msg.ChatType : ChatType.SINGLE);
			if (!string.IsNullOrEmpty(msg.Receiver))
			{
				string[] array4 = Utility.Split(msg.Receiver);
				string[] array5 = array4;
				foreach (string number2 in array5)
				{
					EnterMember(chat, number2);
				}
				EnterMember(chat, msg.Sender);
			}
			chat.IsChanged = true;
			chat.ReflectMessageInfo(msg);
			chat.LastMessage = msg;
			chat.UnreadMessageCount++;
		}
		return chat;
	}

	internal static void ClearMember(Chat chat)
	{
		chat.MemberList.Clear();
		chat.Members = "";
	}

	internal void EnterMember(Chat chat, string number)
	{
		if (chat.MemberList.IndexOf(number) == -1 && !(number == _myNumber))
		{
			chat.MemberList.Add(number);
			chat.Members = string.Join(",", chat.MemberList);
		}
	}

	internal void UpdateChatSummary(Chat chat)
	{
		ChatOnService.Instance.ReUpdateChatList = true;
		long ticks = DateTime.UtcNow.Ticks;
		if (chat.LastMessage != null)
		{
			Message lastMessage = chat.LastMessage;
			if (lastMessage.Type != "noti")
			{
				string text = "";
				if (lastMessage.ActivityState != Message.State.Received)
				{
					text = ResContainer.IDS_CHATON_POP_ME_C_PS_ABB;
					text = text.Replace("%s", "");
				}
				else if (chat.ChatType == ChatType.GROUP)
				{
					text = _buddyService.GetBuddyNameByNumber(lastMessage.Sender, out var _) + ": ";
				}
				if (lastMessage.Type == "media")
				{
					string[] array = Utility.Split(lastMessage.Text, '\n');
					text = ((array[0] == "image") ? (text + ResContainer.IDS_CHATON_SK3_IMAGE) : ((array[0] == "audio") ? (text + ResContainer.IDS_CHATON_HEADER_AUDIO) : ((array[0] == "video") ? (text + ResContainer.IDS_CHATON_HEADER_VIDEO) : ((array[0] == "contact") ? (text + ResContainer.IDS_CHATON_SK3_CONTACT) : ((array[0] == "calendar") ? (text + ResContainer.IDS_CHATON_SK3_CALENDAR) : ((!(array[0] == "geo")) ? (text + lastMessage.Text) : (text + ResContainer.IDS_CHATON_BUTTON_MAP)))))));
				}
				else
				{
					text += lastMessage.Text;
				}
				chat.SubTitle = text;
			}
			chat.Date = Utility.GetDateTimeFromMiliseconds(lastMessage.Time);
		}
		else
		{
			chat.SubTitle = "";
		}
		if (chat.ChatType == ChatType.GROUP)
		{
			if (chat.MemberList.Count == 0)
			{
				chat.Title = ResContainer.IDS_CHATON_BODY_HNO_TITLE;
			}
			else
			{
				List<string> list = new List<string>();
				foreach (string member in chat.MemberList)
				{
					list.Add(_buddyService.GetBuddyNameByNumber(member, out var _));
				}
				list.Sort();
				string text2 = string.Join(", ", list);
				text2 = text2.Replace("\n", "");
				chat.Title = text2;
				chat.MemberCountText = "(" + (chat.MemberList.Count + 1) + ")";
				if (chat.LastMessage != null && chat.LastMessage.ReceiverCount > 0)
				{
					chat.MemberCountText = "(" + (chat.LastMessage.ReceiverCount + 1) + ")";
				}
			}
		}
		else if (chat.ChatType == ChatType.BROADCAST)
		{
			int num = IsoSettingHelper.Get("BoradcastIndex", 1);
			if (chat.ChatTitleParam == 0)
			{
				chat.ChatTitleParam = num;
				IsoSettingHelper.Set("BoradcastIndex", num + 1);
			}
			string iDS_CHATON_BODY_BROADCAST_PD_HPD = ResContainer.IDS_CHATON_BODY_BROADCAST_PD_HPD;
			chat.Title = Utility.sprintf(iDS_CHATON_BODY_BROADCAST_PD_HPD, chat.ChatTitleParam, chat.MemberList.Count);
		}
		else
		{
			Buddy buddy = _buddyService.GetBuddy(chat.MemberList[0]);
			if (buddy == null)
			{
				chat.Title = _buddyService.GetBuddyNameByNumber(chat.MemberList[0], out var _);
			}
			else
			{
				chat.Title = buddy.Name;
				chat.SingleChatBuddy = buddy;
			}
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
	}

	internal void UpdateAllChatSummary()
	{
		if (_dataService.ChatItems == null)
		{
			return;
		}
		foreach (Chat chatItem in _dataService.ChatItems)
		{
			UpdateChatSummary(chatItem);
		}
		UpdateTileUnreadCount();
	}

	internal void UpdateTileUnreadCount()
	{
		int num = 0;
		foreach (Chat chatItem in _dataService.ChatItems)
		{
			num += chatItem.UnreadMessageCount;
		}
		Utility.UpdateMainTileCount(num);
	}

	internal void UpdateDateHeaderCheckBox(Chat chat, Message dateHeaderMsg = null)
	{
		lock (_thisLock)
		{
			IEnumerable<IGrouping<string, Message>> enumerable = from d in chat.Messages
				group d by Utility.GetDateTimeFromMiliseconds(d.Time).ToShortDateString();
			foreach (IGrouping<string, Message> item in enumerable)
			{
				if (dateHeaderMsg != null && item.Contains(dateHeaderMsg))
				{
					foreach (Message item2 in item)
					{
						item2.IsChecked = dateHeaderMsg.IsChecked2;
					}
					continue;
				}
				bool isChecked = true;
				foreach (Message item3 in item)
				{
					if (!item3.IsChecked)
					{
						isChecked = false;
					}
				}
				foreach (Message item4 in item)
				{
					if (item4.ShowDate)
					{
						item4.IsChecked2 = isChecked;
					}
				}
			}
		}
	}

	internal bool SetFailedMessage(Chat chat, Message uploadingMsg, bool isBlockNotify, out bool isUploadingFailed)
	{
		bool result = false;
		isUploadingFailed = false;
		foreach (Message messageItem in chat.MessageItems)
		{
			if ((messageItem.ActivityState != Message.State.Typed && messageItem.ActivityState != Message.State.Uploading) || uploadingMsg == messageItem)
			{
				continue;
			}
			if (isBlockNotify)
			{
				if (messageItem.BlockNotificationCount < 0)
				{
					messageItem.BlockNotificationCount = 0;
				}
				messageItem.BlockNotificationCount++;
			}
			if (messageItem.ActivityState == Message.State.Typed)
			{
				messageItem.ActivityState = Message.State.SendingFailed;
			}
			else
			{
				messageItem.ActivityState = Message.State.UploadingFailed;
				isUploadingFailed = true;
			}
			result = true;
			if (isBlockNotify)
			{
				messageItem.BlockNotificationCount--;
			}
		}
		_dataService.MessageDBSubmitChanges();
		return result;
	}

	internal void NotifyFailedMessages(Chat chat)
	{
		foreach (Message messageItem in chat.MessageItems)
		{
			if (messageItem.ActivityState == Message.State.SendingFailed || messageItem.ActivityState == Message.State.UploadingFailed)
			{
				messageItem.NotifyPropertyChanged("ActivityState");
			}
		}
	}

	internal Message GetMessage(Chat chat, long id)
	{
		long ticks = DateTime.UtcNow.Ticks;
		Message result;
		lock (_thisLock)
		{
			result = chat.Messages.FirstOrDefault((Message c) => c.NumberID == id);
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
		return result;
	}

	internal void NotifyAnswerbackCountChanged(Chat chat)
	{
		foreach (Message messageItem in chat.MessageItems)
		{
			if (messageItem.ActivityState != Message.State.Uploading && messageItem.ActivityState != Message.State.UploadingFailed && messageItem.ActivityState != Message.State.CannotResend && messageItem.ActivityState != Message.State.Received)
			{
				messageItem.NotifyPropertyChanged("AnswerBackCount");
			}
		}
	}

	internal void SortAllMessages(Chat chat)
	{
		lock (_thisLock)
		{
			chat.Messages.Sort(Message.CompareByTime);
		}
	}

	internal void GetLastMessage(Chat chat)
	{
		lock (_thisLock)
		{
			for (int num = chat.Messages.Count - 1; num >= 0; num--)
			{
				Message message = chat.Messages[num];
				if (message.Time != 0 && !(message.Type == "ans") && !(message.Type == "noti"))
				{
					chat.LastMessage = message;
					break;
				}
			}
		}
	}

	internal bool IsLastMessageLoaded(Chat chat)
	{
		lock (_thisLock)
		{
			return chat.MessageItems.LastOrDefault() == chat.Messages.LastOrDefault();
		}
	}

	internal void SelectAllMessages(Chat chat, bool isSelectAll)
	{
		lock (_thisLock)
		{
			foreach (Message message in chat.Messages)
			{
				message.IsChecked = isSelectAll;
				message.IsChecked2 = isSelectAll;
			}
		}
	}

	internal void SelectReceivedMessages(Chat chat, bool isSelectReceived)
	{
		lock (_thisLock)
		{
			foreach (Message message in chat.Messages)
			{
				if (message.ActivityState == Message.State.Received)
				{
					message.IsChecked = isSelectReceived;
				}
			}
		}
	}

	internal void SelectSentMessages(Chat chat, bool isSelectSent)
	{
		lock (_thisLock)
		{
			foreach (Message message in chat.Messages)
			{
				if (message.ActivityState != Message.State.Received)
				{
					message.IsChecked = isSelectSent;
				}
			}
		}
	}

	internal bool IsEnableDeleteMessage(Chat chat)
	{
		lock (_thisLock)
		{
			foreach (Message message in chat.Messages)
			{
				if (message.IsChecked)
				{
					return true;
				}
			}
			return false;
		}
	}

	internal void LoadAnsInfo(Chat chat)
	{
		if (!string.IsNullOrEmpty(chat.AnsData))
		{
			chat.AnsInfo.Clear();
			string[] array = Utility.Split(chat.AnsData);
			for (int i = 0; i < array.Length / 2; i++)
			{
				chat.AnsInfo.Add(new AnsInfo
				{
					PhoneNumber = array[i],
					Time = long.Parse(array[i + array.Length / 2])
				});
			}
		}
	}

	internal void SaveAnsInfo(Chat chat)
	{
		if (chat.AnsInfo.Count == 0)
		{
			return;
		}
		chat.AnsData = "";
		foreach (AnsInfo item in chat.AnsInfo)
		{
			chat.AnsData = chat.AnsData + item.PhoneNumber + ",";
		}
		foreach (AnsInfo item2 in chat.AnsInfo)
		{
			chat.AnsData = chat.AnsData + item2.Time + ",";
		}
	}
}
