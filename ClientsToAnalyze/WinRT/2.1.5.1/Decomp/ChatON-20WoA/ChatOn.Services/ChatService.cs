using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using System.Xml.Linq;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Queue;
using com.sec.ssm.common;
using Windows.Storage;
using Windows.UI;
using Windows.UI.Core;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Services;

public class ChatService
{
	public static int MAX_TEXT_LENGTH = 2000;

	public static int MAX_CHAT_MEMBERS = 200;

	public static int MAX_BROADCAST_MEMBERS = 201;

	private readonly SSMService _ssmService;

	private DataService _dataService;

	private BuddyService _buddyService;

	private string _myNumber;

	private object _thisLock = new object();

	private HttpClient UpdateChatProfileImageClient;

	private HttpClient UpdateGroupChatProfileImageUrlClient;

	private HttpClient GetAllMessageAsyncClient;

	public bool IsGetAllMessage;

	public bool IsGetTrunkList;

	private HttpClient GetTrunkListAsyncClient;

	public ChatService(DataService dataService, BuddyService buddyService, string myNumber)
	{
		_dataService = dataService;
		_buddyService = buddyService;
		_myNumber = myNumber;
	}

	public ChatService(SSMService ssmService, DataService dataService, BuddyService buddyService, string myNumber)
	{
		_ssmService = ssmService;
		_dataService = dataService;
		_buddyService = buddyService;
		_myNumber = myNumber;
	}

	public Chat StartChat(bool disconnect, string sender, string member, ChatType chatType, string sessionID = "")
	{
		if (disconnect)
		{
			SocketService.Instance.Disconnect();
		}
		if (chatType == ChatType.SINGLE)
		{
			Chat chat = null;
			chat = ((!(sender == RegistrationService.ChatOnID) || string.IsNullOrEmpty(sessionID)) ? _dataService.ChatItems.FirstOrDefault((Chat c) => c.Members.Contains(sender) && c.ChatType == chatType && c.IsValidSession) : _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID.Equals(sessionID) && c.ChatType == chatType && c.IsValidSession));
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
			foreach (string text in array2)
			{
				if (!(text == _myNumber))
				{
					EnterMember(chat3, text);
				}
			}
		}
		if (!string.IsNullOrEmpty(sessionID))
		{
			chat3.SessionID = sessionID;
		}
		chat3.Date = DateTime.Now;
		_dataService.AddChat(chat3);
		UpdateChatSummary(chat3);
		return chat3;
	}

	public void CloseChat(Chat chat)
	{
		if (!string.IsNullOrEmpty(chat.ChatID.ToString()))
		{
			Utility.DeleteDirectory(chat.ChatID.ToString());
		}
		_dataService.DeleteChat(chat);
	}

	public void AddMessageToShow(Chat chat, Message msg, bool addToDB = true, bool toPrev = false)
	{
		lock (_thisLock)
		{
			if (chat == null)
			{
				if (!string.IsNullOrEmpty(msg.SessionID))
				{
					chat = _dataService.ChatItems.FirstOrDefault((Chat x) => x.SessionID == msg.SessionID);
				}
				if (chat == null)
				{
					return;
				}
			}
			if (chat.SessionID != msg.SessionID && !string.IsNullOrEmpty(msg.SessionID))
			{
				Chat chat2 = _dataService.ChatItems.FirstOrDefault((Chat x) => x.SessionID == msg.SessionID);
				if (chat2 != null)
				{
					chat = chat2;
				}
			}
			if (chat.IsSingleChat() && !chat.Members.Contains(msg.Sender))
			{
				Chat chat3 = _dataService.ChatItems.FirstOrDefault((Chat x) => x.SessionID == msg.SessionID && x.Members.Contains(msg.Sender));
				if (chat3 != null)
				{
					chat = chat3;
				}
			}
			if (toPrev)
			{
				Message message = chat.MessageItems.FirstOrDefault((Message m) => m.NumberID == msg.NumberID || m.Tid == msg.Tid || (m.Text == msg.Text && m.Time == msg.Time));
				if (message != null && message.Chat != null)
				{
					return;
				}
			}
		}
		lock (_thisLock)
		{
			Message message2 = chat.MessageItems.FirstOrDefault((Message m) => m.NumberID == msg.NumberID || (m.Text == msg.Text && m.Time == msg.Time));
			if (message2 != null && message2.Chat != null)
			{
				return;
			}
			Message message3 = _dataService.MessageItems.FirstOrDefault((Message m) => m.SessionID == chat.SessionID && m.NumberID == msg.NumberID);
			if (addToDB && message3 == null)
			{
				_dataService.AddMessage(msg);
			}
			if (chat.MessageItems.Count == 0 || chat.Messages.Count == 0)
			{
				chat.AddMessage(msg, toPrev);
			}
			else if (msg.Time > chat.MessageItems[0].Time)
			{
				chat.AddMessage(msg, toPrev);
			}
			else
			{
				int num = chat.MessageItems.Count;
				foreach (Message messageItem in chat.MessageItems)
				{
					if (msg.Time <= messageItem.Time)
					{
						num--;
						continue;
					}
					break;
				}
				if (num != 0 || chat.Messages.Count - chat.MessageItems.Count <= 10)
				{
					if (toPrev)
					{
						Message message4 = chat.Messages.FirstOrDefault((Message x) => x.Time == msg.Time && x.Text == msg.Text);
						if (message4 == null)
						{
							chat.Messages.Insert(num, msg);
						}
					}
					if (chat.MessageItems.Count > chat.Messages.Count)
					{
						Message message5 = chat.Messages.FirstOrDefault((Message x) => x.Time == msg.Time && x.Text == msg.Text);
						if (message5 == null)
						{
							chat.Messages.Insert(num, msg);
						}
					}
					chat.MessageItems.Insert(num, msg);
				}
			}
			Message message6 = chat.Messages.OrderByDescending((Message x) => x.Time).FirstOrDefault((Message x) => x.Type != "noti");
			if (message6 != null)
			{
				chat.ReflectMessageInfo(msg);
			}
		}
	}

	public void DisplaySendMessage(Chat chat, Message msg, bool addToDB = true, bool toPrev = false)
	{
		lock (_thisLock)
		{
			if (chat == null)
			{
				if (!string.IsNullOrEmpty(msg.SessionID))
				{
					chat = _dataService.ChatItems.FirstOrDefault((Chat x) => x.SessionID == msg.SessionID);
				}
				if (chat == null)
				{
					return;
				}
			}
			if (chat.SessionID != msg.SessionID && !string.IsNullOrEmpty(msg.SessionID))
			{
				Chat chat2 = _dataService.ChatItems.FirstOrDefault((Chat x) => x.SessionID == msg.SessionID);
				if (chat2 != null)
				{
					chat = chat2;
				}
			}
			if (chat.IsSingleChat() && !chat.Members.Contains(msg.Sender))
			{
				Chat chat3 = _dataService.ChatItems.FirstOrDefault((Chat x) => x.SessionID == msg.SessionID && x.Members.Contains(msg.Sender));
				if (chat3 != null)
				{
					chat = chat3;
				}
			}
			if (toPrev)
			{
				Message message = chat.MessageItems.FirstOrDefault((Message m) => m.NumberID == msg.NumberID || m.Tid == msg.Tid || (m.Text == msg.Text && m.Time == msg.Time));
				if (message != null && message.Chat != null)
				{
					return;
				}
			}
		}
		lock (_thisLock)
		{
			Message message2 = chat.MessageItems.FirstOrDefault((Message m) => m.NumberID == msg.NumberID || (m.Text == msg.Text && m.Time == msg.Time));
			if (message2 == null || message2.Chat == null)
			{
				if (addToDB)
				{
					_dataService.AddMessage(msg);
				}
				chat.AddMessage(msg, toPrev);
				Message message3 = chat.Messages.OrderByDescending((Message x) => x.Time).FirstOrDefault((Message x) => x.Type != "noti");
				if (message3 != null)
				{
					chat.ReflectMessageInfo(msg);
				}
			}
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
			try
			{
				int num = 0;
				int i;
				for (i = chat.Messages.Count - 1; i >= 0; i--)
				{
					if (chat.Messages[i].IsChecked)
					{
						Message message = chat.MessageItems.FirstOrDefault((Message x) => x.MessageID == chat.Messages[i].MessageID);
						if (message != null)
						{
							chat.MessageItems.Remove(message);
						}
						_dataService.DeleteMessage(chat.Messages[i], isSubmit: false);
						chat.DeleteMessage(chat.Messages[i]);
						num++;
					}
				}
				if (chat.Messages.Count == 0)
				{
					chat.LastMessage = null;
					chat.ClearMessageItems();
					chat.NotifyPropertyChanged("");
				}
				_dataService.ChatDBSubmitChanges();
				_dataService.MessageDBSubmitChanges();
			}
			catch
			{
			}
		}
		UpdateChatSummary(chat);
	}

	public void DeleteAllMessages(Chat chat)
	{
		lock (_thisLock)
		{
			try
			{
				List<Message> list = new List<Message>();
				list = _dataService.MessageItems.Where((Message p) => p.ChatID == chat.ChatID).ToList();
				foreach (Message item in list)
				{
					_dataService.DeleteMessage(item);
					if (chat.MessageItems.Contains(item))
					{
						chat.MessageItems.Remove(item);
					}
					if (chat.Messages.Contains(item))
					{
						chat.Messages.Remove(item);
					}
				}
				chat.LastMessage = null;
				chat.ClearMessageItems();
				chat.NotifyPropertyChanged("");
				list.Clear();
				_dataService.ChatDBSubmitChanges();
				_dataService.MessageDBSubmitChanges();
			}
			catch
			{
			}
		}
		UpdateChatSummary(chat);
	}

	public bool IsCheckedToDelete(Chat chat)
	{
		if (chat == null)
		{
			return false;
		}
		lock (_thisLock)
		{
			for (int num = chat.Messages.Count - 1; num >= 0; num--)
			{
				if (chat.Messages[num].IsChecked)
				{
					return true;
				}
			}
			return false;
		}
	}

	internal void ReflectAnswerBackMessage(Chat chat, string number, long time)
	{
		if (chat != null)
		{
			if (chat.LastMessage == null)
			{
				time = Utility.GetTimeStamp();
			}
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
	}

	internal void ReflectAnswerBackMessage(Message msg, string number, long time)
	{
		if (time == 0)
		{
			time = Utility.GetTimeStamp();
		}
		Chat chat = null;
		chat = ((msg.Chat == null) ? _dataService.GetChat(msg.ChatID) : msg.Chat);
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

	internal void ResetUnreadMessage()
	{
		foreach (Chat chatItem in _dataService.ChatItems)
		{
			chatItem.UnreadMessageCount = 0;
		}
	}

	internal async Task<Chat> ReflectUnreadMessage(Message msg)
	{
		if (!string.IsNullOrEmpty(msg.Tid))
		{
			Message message = _dataService.MessageItems.FirstOrDefault((Message m) => m.Tid == msg.Tid || (m.Text == msg.Text && m.Time == msg.Time));
			if (message != null && message.Chat != null)
			{
				if (string.IsNullOrEmpty(message.Tid))
				{
					message.Tid = msg.Tid;
				}
				return null;
			}
		}
		Chat chat = null;
		if (msg.ChatType != ChatType.BROADCAST && !string.IsNullOrEmpty(msg.SessionID))
		{
			chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == msg.SessionID);
		}
		else if (msg.ChatType == ChatType.BROADCAST && string.IsNullOrEmpty(msg.SessionID))
		{
			chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.Sender == msg.Sender && c.ChatType == ChatType.SINGLE);
			msg.SessionID = chat.SessionID;
		}
		if (chat != null)
		{
			if (msg.Type != "ans")
			{
				if (msg.Type != "noti")
				{
					int num = chat.Messages.Count((Message p) => p.NumberID == msg.NumberID && p.Text == msg.Text);
					if (num == 0)
					{
						Message message2 = chat.Messages.FirstOrDefault((Message p) => p.NumberID == msg.NumberID);
						if (message2 != null && msg.IncompletedMediaMessage())
						{
							return chat;
						}
						if (message2 != null)
						{
							if (!string.IsNullOrWhiteSpace(msg.Text))
							{
								message2.Text = msg.Text;
							}
							message2.Tid = msg.Tid;
							message2.Time = msg.Time;
							msg = message2;
							num = 1;
						}
					}
					if (num == 0 && msg.Sender != RegistrationService.ChatOnID)
					{
						chat.UnreadMessageCount++;
					}
					msg.ActivityState = Message.State.Received;
					if (msg.Sender == RegistrationService.ChatOnID)
					{
						msg.ActivityState = Message.State.Sent;
					}
				}
				msg.ChatID = chat.ChatID;
				if (msg.Type != "media" && !msg.Text.Contains("Multimedia"))
				{
					AddMessageToShow(chat, msg);
				}
				else if (msg.Type == "media" && !msg.Text.Contains("Multimedia"))
				{
					AddMessageToShow(chat, msg);
				}
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
			Message message3 = _dataService.FirstOrDefaultMessage((Message m) => m.NumberID == msg.NumberID);
			if (message3 != null)
			{
				ReflectAnswerBackMessage(message3.Chat, msg.Receiver, msg.Time);
				message3.NotifyAnswerBackUpdated();
			}
		}
		else if (msg.Type != "noti")
		{
			chat = StartChat(disconnect: false, msg.Sender, msg.Receiver, (msg.ChatType != ChatType.BROADCAST) ? msg.ChatType : ChatType.SINGLE);
			msg.Chat = chat;
			msg.ChatID = chat.Id;
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
		if (chat.MemberList.IndexOf(number) == -1 && !(number == _myNumber) && !string.IsNullOrEmpty(number))
		{
			chat.MemberList.Add(number);
			chat.Members = string.Join(",", new List<string>(chat.MemberList.OrderBy((string x) => x)));
		}
	}

	internal void EnterMember(Chat chat, List<ChatMember> chatMember)
	{
		chatMember = new List<ChatMember>(chatMember.OrderBy((ChatMember x) => x.Time));
		foreach (ChatMember item in chatMember)
		{
			if (chat.MemberList.IndexOf(item.PhoneNumber) != -1 || item.PhoneNumber == _myNumber || string.IsNullOrEmpty(item.PhoneNumber))
			{
				break;
			}
			chat.MemberList.Add(item.PhoneNumber);
			chat.Members = string.Join(",", new List<string>(chat.MemberList.OrderBy((string x) => x)));
		}
	}

	internal void LeaveMember(Chat chat, string number)
	{
		chat.MemberList.Remove(number);
		chat.Members = string.Join(",", chat.MemberList);
		UpdateChatSummary(chat);
	}

	internal void UpdateChatSummary(Chat chat)
	{
		try
		{
			if (chat == null)
			{
				return;
			}
			ChatOnService.Instance.ReUpdateChatList = true;
			if (chat.LastMessage != null)
			{
				Message message = chat.LastMessage;
				if (message.ActivityState != Message.State.Sent || message.ActivityState != Message.State.Received)
				{
					for (int num = chat.Messages.Count - 1; num >= 0; num--)
					{
						if (chat.Messages[num].ActivityState == Message.State.Sent || chat.Messages[num].ActivityState == Message.State.Received)
						{
							message = chat.Messages[num];
							break;
						}
					}
				}
				Message message2;
				if (message == null)
				{
					message2 = (from x in chat.Messages
						where x.Type != "noti"
						orderby x.Time descending
						select x).FirstOrDefault();
					if (message2 != null && (message2.ActivityState == Message.State.Sent || message2.ActivityState == Message.State.Received))
					{
						chat.Date = Utility.GetDateTimeFromMiliseconds(message2.Time);
						chat.LastMessage = message2;
					}
				}
				if (message != null && message.Type != "noti")
				{
					message.Chat = chat;
				}
				message2 = (from x in chat.Messages
					where x.Type != "noti"
					orderby x.Time descending
					select x).FirstOrDefault();
				if (message2 != null && (message2.ActivityState == Message.State.Sent || message2.ActivityState == Message.State.Received))
				{
					chat.Date = Utility.GetDateTimeFromMiliseconds(message2.Time);
					chat.LastMessage = message2;
				}
			}
			else
			{
				Message message3 = (from x in chat.Messages
					where x.Type != "noti"
					orderby x.Time descending
					select x).FirstOrDefault();
				if (message3 != null && (message3.ActivityState == Message.State.Sent || message3.ActivityState == Message.State.Received))
				{
					chat.Date = Utility.GetDateTimeFromMiliseconds(message3.Time);
					chat.LastMessage = message3;
				}
			}
			if (chat.ChatType == ChatType.GROUP)
			{
				if (chat.MemberList.Count == 0 || (chat.MemberList.Count == 1 && string.IsNullOrEmpty(chat.MemberList[0])))
				{
					chat.Title = Utility.GetResourceString("IDS_CHATON_BODY_NO_BUDDIES");
					chat.MemberCountText = "";
				}
				else
				{
					List<string> list = new List<string>();
					foreach (string member in chat.MemberList)
					{
						list.Add(_buddyService.GetBuddyNameByNumber(member, out var _));
					}
					string text = string.Join(", ", list);
					text = text.Replace("\n", "");
					chat.Title = text;
					chat.MemberCountText = "(" + (chat.MemberList.Count + 1) + ")";
					if (chat.LastMessage != null && chat.LastMessage.ReceiverCount > 0)
					{
						chat.MemberCountText = "(" + (chat.LastMessage.ReceiverCount + 1) + ")";
					}
				}
			}
			else if (chat.ChatType == ChatType.BROADCAST)
			{
				if (chat.MemberList.Count == 0 || (chat.MemberList.Count == 1 && string.IsNullOrEmpty(chat.MemberList[0])))
				{
					chat.Title = Utility.GetResourceString("IDS_CHATON_BODY_NO_BUDDIES");
					chat.MemberCountText = "";
				}
				else
				{
					List<string> list2 = new List<string>();
					foreach (string member2 in chat.MemberList)
					{
						list2.Add(_buddyService.GetBuddyNameByNumber(member2, out var _));
					}
					list2.Sort();
					string text2 = string.Join(", ", list2);
					text2 = text2.Replace("\n", "");
					chat.Title = "Broadcast: " + text2;
					chat.MemberCountText = "(" + chat.MemberList.Count + ")";
					if (chat.LastMessage != null && chat.LastMessage.ReceiverCount > 0)
					{
						chat.MemberCountText = "(" + (chat.LastMessage.ReceiverCount + 1) + ")";
					}
				}
			}
			else if (chat.MemberList.Count > 0)
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
			if (!string.IsNullOrEmpty(chat.CustomTitle))
			{
				chat.Name = chat.CustomTitle;
			}
			if (string.IsNullOrEmpty(chat.Title) && chat.ChatType == ChatType.SINGLE)
			{
				chat.Title = Utility.GetResourceString("IDS_CHATON_BODY_UNKNOWN");
			}
		}
		catch (Exception)
		{
		}
	}

	public string GetLastMessageFormat(Message msg)
	{
		string text = "";
		if (msg.Chat == null)
		{
			return text;
		}
		if (msg.ActivityState != Message.State.Received)
		{
			text = Utility.GetResourceString("IDS_CHATON_POP_ME_C_PS_ABB");
			text = text.Replace("%s", "");
		}
		else
		{
			_ = msg.Chat.ChatType;
			if (msg.Chat.ChatType == ChatType.GROUP)
			{
				text = _buddyService.GetBuddyNameByNumber(msg.Sender, out var _) + ": ";
			}
		}
		if (msg.Type == "media")
		{
			string[] array = Utility.Split(msg.Text, '\n');
			if (array[0] == "image" && !msg.Text.Contains("download/anicon"))
			{
				text += Utility.GetResourceString("IDS_CHATON_SK3_IMAGE");
			}
			else if (array[0] == "image" && msg.Text.Contains("download/anicon"))
			{
				text += Utility.GetResourceString("IDS_CHATON_TAB4_ANICON");
			}
			if (array[0] == "mixed")
			{
				if (string.IsNullOrEmpty(array[1]))
				{
					if (array[1] == "image" && msg.Text.Contains("download/anicon"))
					{
						text += Utility.GetResourceString("IDS_CHATON_TAB4_ANICON");
					}
					else if (array[1] == "image" && !msg.Text.Contains("download/anicon"))
					{
						text += Utility.GetResourceString("IDS_CHATON_SK3_IMAGE");
					}
					else if (array[1] == "audio")
					{
						text += Utility.GetResourceString("IDS_CHATON_HEADER_AUDIO");
					}
					else if (array[1] == "video")
					{
						text += Utility.GetResourceString("IDS_CHATON_HEADER_VIDEO");
					}
					else if (array[1] == "contact")
					{
						text += Utility.GetResourceString("IDS_CHATON_SK3_CONTACT");
					}
					else if (array[1] == "geo")
					{
						text += Utility.GetResourceString("IDS_CHATON_BUTTON_MAP");
					}
				}
				text += Utility.GetResourceString("IDS_CHATON_SK3_IMAGE");
			}
			else if (array[0] == "audio")
			{
				text += Utility.GetResourceString("IDS_CHATON_HEADER_AUDIO");
			}
			else if (array[0] == "video")
			{
				text += Utility.GetResourceString("IDS_CHATON_HEADER_VIDEO");
			}
			else if (array[0] == "contact")
			{
				text += Utility.GetResourceString("IDS_CHATON_SK3_CONTACT");
			}
			else if (array[0] == "calendar")
			{
				text += Utility.GetResourceString("IDS_CHATON_SK3_CALENDAR");
			}
			else if (array[0] == "geo")
			{
				text += Utility.GetResourceString("IDS_CHATON_BUTTON_MAP");
			}
			else if (string.IsNullOrEmpty(text))
			{
				text += msg.Text;
			}
		}
		else
		{
			text += msg.Text;
		}
		return text;
	}

	internal async Task UpdateChatSummary(Chat chat, CoreDispatcher dispatcher)
	{
		await dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			if (chat != null)
			{
				ChatOnService.Instance.ReUpdateChatList = true;
				if (chat.LastMessage != null)
				{
					Message message = chat.LastMessage;
					if (message.ActivityState != Message.State.Sent || message.ActivityState != Message.State.Received)
					{
						for (int num = chat.Messages.Count - 1; num >= 0; num--)
						{
							if (chat.Messages[num].ActivityState == Message.State.Sent || chat.Messages[num].ActivityState == Message.State.Received)
							{
								message = chat.Messages[num];
								break;
							}
						}
					}
					Message message2;
					if (message == null)
					{
						message2 = (from x in chat.Messages
							where x.Type != "noti"
							orderby x.Time descending
							select x).FirstOrDefault();
						if (message2 != null && (message2.ActivityState == Message.State.Sent || message2.ActivityState == Message.State.Received))
						{
							chat.Date = Utility.GetDateTimeFromMiliseconds(message2.Time);
							chat.LastMessage = message2;
						}
					}
					if (message != null)
					{
						_ = message.Type != "noti";
					}
					message2 = (from x in chat.Messages
						where x.Type != "noti"
						orderby x.Time descending
						select x).FirstOrDefault();
					if (message2 != null && (message2.ActivityState == Message.State.Sent || message2.ActivityState == Message.State.Received))
					{
						chat.Date = Utility.GetDateTimeFromMiliseconds(message2.Time);
						chat.LastMessage = message2;
					}
				}
				else
				{
					Message message3 = (from x in chat.Messages
						where x.Type != "noti"
						orderby x.Time descending
						select x).FirstOrDefault();
					if (message3 != null && (message3.ActivityState == Message.State.Sent || message3.ActivityState == Message.State.Received))
					{
						chat.Date = Utility.GetDateTimeFromMiliseconds(message3.Time);
						chat.LastMessage = message3;
					}
				}
				if (chat.ChatType == ChatType.GROUP)
				{
					if (chat.MemberList.Count == 0 || (chat.MemberList.Count == 1 && string.IsNullOrEmpty(chat.MemberList[0])))
					{
						chat.Title = Utility.GetResourceString("IDS_CHATON_BODY_NO_BUDDIES");
						chat.MemberCountText = "";
					}
					else
					{
						List<string> nameList = new List<string>();
						bool isUnknown;
						await Task.Run(delegate
						{
							foreach (string member in chat.MemberList)
							{
								nameList.Add(_buddyService.GetBuddyNameByNumber(member, out isUnknown));
							}
						});
						string msg = string.Join(", ", nameList);
						msg = msg.Replace("\n", "");
						chat.Title = msg;
						chat.MemberCountText = "(" + (chat.MemberList.Count + 1) + ")";
						if (chat.LastMessage != null && chat.LastMessage.ReceiverCount > 0)
						{
							chat.MemberCountText = "(" + (chat.LastMessage.ReceiverCount + 1) + ")";
						}
					}
				}
				else if (chat.ChatType == ChatType.BROADCAST)
				{
					if (chat.MemberList.Count == 0 || (chat.MemberList.Count == 1 && string.IsNullOrEmpty(chat.MemberList[0])))
					{
						chat.Title = Utility.GetResourceString("IDS_CHATON_BODY_NO_BUDDIES");
						chat.MemberCountText = "";
					}
					else
					{
						List<string> list = new List<string>();
						foreach (string member2 in chat.MemberList)
						{
							list.Add(_buddyService.GetBuddyNameByNumber(member2, out var _));
						}
						list.Sort();
						string text = string.Join(", ", list);
						text = text.Replace("\n", "");
						chat.Title = "Broadcast: " + text;
						chat.MemberCountText = "(" + chat.MemberList.Count + ")";
						if (chat.LastMessage != null && chat.LastMessage.ReceiverCount > 0)
						{
							chat.MemberCountText = "(" + (chat.LastMessage.ReceiverCount + 1) + ")";
						}
					}
				}
				else if (chat.MemberList.Count > 0)
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
				if (!string.IsNullOrEmpty(chat.CustomTitle))
				{
					chat.Name = chat.CustomTitle;
				}
				if (string.IsNullOrEmpty(chat.Title) && chat.ChatType == ChatType.SINGLE)
				{
					chat.Title = Utility.GetResourceString("IDS_CHATON_BODY_UNKNOWN");
				}
			}
		});
	}

	internal void UpdateAllChatSummary()
	{
		try
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
			LoadingIndicator.StopLoading();
		}
		catch (Exception)
		{
		}
		finally
		{
			LoadingIndicator.StopLoading();
		}
	}

	internal async void UpdateAllChatSummary(CoreDispatcher dispatcher)
	{
		try
		{
			int num = default(int);
			_ = num;
			_ = 0;
			try
			{
				if (_dataService.ChatItems == null)
				{
					return;
				}
				foreach (Chat chat in _dataService.ChatItems)
				{
					TaskFactory factory = Task.Factory;
					Func<Task> function = () => UpdateChatSummary(chat, dispatcher);
					await factory.StartNew(function);
				}
				UpdateTileUnreadCount();
			}
			catch (Exception)
			{
			}
		}
		finally
		{
			dispatcher.RunAsync((CoreDispatcherPriority)(-1), (DispatchedHandler)delegate
			{
				LoadingIndicator.StopLoading();
			});
		}
	}

	internal int UpdateTileUnreadCount()
	{
		int num = 0;
		foreach (Chat chatItem in _dataService.ChatItems)
		{
			if (chatItem.Messages.Count > 0)
			{
				num += chatItem.UnreadMessageCount;
			}
		}
		Utility.UpdateMainTileCount(num);
		return num;
	}

	internal int UpdateTrunkUnreadCount()
	{
		int num = 0;
		foreach (Chat chatItem in _dataService.ChatItems)
		{
			num += chatItem.UnreadTrunkMessageCount;
		}
		return num;
	}

	internal int UpdateTrunkUnreadCount(Chat chat)
	{
		int num = 0;
		return chat.UnreadTrunkMessageCount;
	}

	internal void UpdateDateHeaderCheckBox(Chat chat, Message dateHeaderMsg = null)
	{
		lock (_thisLock)
		{
			IEnumerable<IGrouping<string, Message>> enumerable = from d in chat.Messages
				group d by Utility.GetDateTimeFromMiliseconds(d.Time).ToString("d");
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

	internal bool SetFailedMessage(Chat chat, Message uploadingMsg, bool isBlockNotify)
	{
		bool flag = false;
		if (chat == null)
		{
			return false;
		}
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
			}
			flag = true;
			if (isBlockNotify)
			{
				messageItem.BlockNotificationCount--;
			}
		}
		if (flag)
		{
			_dataService.MessageDBSubmitChanges();
		}
		return flag;
	}

	internal void NotifyFailedMessages(Chat chat)
	{
		if (chat == null)
		{
			return;
		}
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
		if (chat == null)
		{
			return null;
		}
		long ticks = DateTime.UtcNow.Ticks;
		Message message;
		lock (_thisLock)
		{
			message = chat.Messages.FirstOrDefault((Message c) => c.NumberID == id);
			if (message == null)
			{
				message = chat.MessageItems.FirstOrDefault((Message c) => c.NumberID == id);
			}
		}
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
		return message;
	}

	internal void NotifyAnswerbackCountChanged(Chat chat)
	{
		if (chat == null)
		{
			return;
		}
		foreach (Message messageItem in chat.MessageItems)
		{
			if (messageItem.ActivityState != Message.State.Uploading && messageItem.ActivityState != Message.State.UploadingFailed && messageItem.ActivityState != Message.State.CannotResend && messageItem.ActivityState != Message.State.Received)
			{
				messageItem.NotifyPropertyChanged("AnswerBackCount");
			}
		}
	}

	private static int CompareByTime(Message x, Message y)
	{
		if (x.Time == 0 && y.Time == 0)
		{
			return 0;
		}
		if (x.Time == 0)
		{
			return 1;
		}
		if (y.Time == 0)
		{
			return -1;
		}
		return x.Time.CompareTo(y.Time);
	}

	internal void SortAllMessages(Chat chat)
	{
		lock (_thisLock)
		{
			chat.Messages.Sort(CompareByTime);
		}
	}

	internal void GetLastMessage(Chat chat)
	{
		if (chat == null)
		{
			return;
		}
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

	internal async Task<Chat> StartChatFromBuddyGroup(ChatType type, BuddyGroup group, string firstBuddyNumber)
	{
		Chat chat = null;
		if (type == ChatType.GROUP && group.DirectChatID != Guid.Empty)
		{
			chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.ChatID == group.DirectChatID);
			if (chat != null)
			{
				string[] array = Utility.Split(group.Members);
				string[] array2 = Utility.Split(chat.Members);
				if (array.Length == array2.Length)
				{
					string[] array3 = array2;
					foreach (string n in array3)
					{
						Func<string, bool> predicate = (string c) => c == n;
						if (string.IsNullOrEmpty(array.FirstOrDefault(predicate)))
						{
							chat = null;
							break;
						}
					}
					if (1 == 0)
					{
					}
				}
				else
				{
					chat = null;
				}
			}
		}
		if (chat == null)
		{
			chat = StartChat(disconnect: false, firstBuddyNumber, group.Members, type);
			if (type == ChatType.GROUP)
			{
				string imagepath = (group.ImagePath.Contains(".jpg") ? group.ImagePath : (group.ImagePath + ".jpg"));
				if (!string.IsNullOrEmpty(imagepath))
				{
					StorageFile file = await Utility.IsFileExist("Group", imagepath);
					if (file != null)
					{
						await Utility.CopyFileAsync(file, imagepath, chat.ChatID.ToString());
						chat.ImagePath = imagepath;
						chat.LoadProfileImage();
					}
				}
				else
				{
					chat.ImagePath = "";
					chat.LoadProfileImage();
				}
				_dataService.ChatDBSubmitChanges();
				group.DirectChatID = chat.ChatID;
				_dataService.GroupDBSubmitChanges();
			}
		}
		return chat;
	}

	internal async void ApplyChatInfoAll(XElement xe, CoreDispatcher dispatcher)
	{
		await dispatcher.RunAsync((CoreDispatcherPriority)1, (DispatchedHandler)delegate
		{
			IEnumerable<XElement> enumerable = from item in xe.Descendants("chatroominfodetail")
				select (item);
			ChatOnService.Instance.InActiveChat.Clear();
			foreach (XElement item in enumerable)
			{
				string text = "";
				int num = int.Parse(item.Attribute("chattype").Value);
				IEnumerable<XElement> enumerable2 = from m in item.Descendants("chatroommemberinfo")
					select (m);
				string text2 = "";
				string text3 = "";
				string text4 = "";
				string text5 = "";
				int num2 = 0;
				long num3 = Utility.GetTimeStamp();
				bool flag = true;
				new List<ChatMember>();
				if (item.Attribute("createtime") != null)
				{
					num3 = long.Parse(item.Attribute("createtime").Value);
				}
				foreach (XElement item2 in enumerable2)
				{
					if (item2.Attribute("userid") != null)
					{
						string id = item2.Attribute("userid").Value;
						bool flag2 = bool.Parse(item2.Attribute("insession").Value);
						if (id != RegistrationService.ChatOnID)
						{
							if ((num == 1 && !flag2) || id.Substring(0, 4) == "0999")
							{
								continue;
							}
							if (!string.IsNullOrEmpty(text))
							{
								text += ",";
							}
							text += id;
							string value = item2.Attribute("name").Value;
							UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == id);
							if (unknownUser != null)
							{
								unknownUser.Name = value;
							}
							else
							{
								unknownUser = new UnknownUser(value, id);
								_dataService.AddUnknownUser(unknownUser);
							}
						}
						else
						{
							flag = flag2;
							if (!flag)
							{
								break;
							}
							if (item2.Attribute("title") != null)
							{
								text2 = item2.Attribute("title").Value;
							}
							if (item2.Attribute("starttime") != null)
							{
								num3 = long.Parse(item2.Attribute("starttime").Value);
							}
							if (item2.Attribute("profileimageaddr") != null && item2.Attribute("profileimagepath") != null)
							{
								string value2 = item2.Attribute("profileimageaddr").Value;
								string value3 = item2.Attribute("profileimagepath").Value;
								text4 = value2;
								text5 = value3;
								UserAccountInfo userAccount = RegistrationService.GetUserAccount();
								text3 = ((!(value2.Substring(value2.Length - 1, 1) == "/")) ? (value2 + "/" + value3) : (value2 + value3));
								text3 = text3 + "?uid=" + userAccount.Uid + "&imei=" + userAccount.IMEI;
							}
						}
						num2++;
					}
				}
				Chat chat = null;
				string sessionid = item.Attribute("sessionid").Value;
				if (!flag)
				{
					chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == sessionid);
					if (chat != null)
					{
						ChatOnService.Instance.InActiveChat.Add(chat);
					}
				}
				else
				{
					string[] array = Utility.Split(text);
					string sender = array[0];
					int port = int.Parse(item.Attribute("port").Value);
					string value4 = item.Attribute("ip").Value;
					string oldSession = "";
					if (item.Attribute("oldsessionid") != null)
					{
						oldSession = item.Attribute("oldsessionid").Value;
						chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == oldSession);
						if (chat != null)
						{
							chat.OldSessionID = oldSession;
						}
					}
					else
					{
						chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == sessionid);
					}
					if (chat == null)
					{
						chat = StartChat(disconnect: false, sender, text, (ChatType)num);
					}
					chat.SessionID = sessionid;
					chat.Port = port;
					chat.Address = value4;
					chat.IsChanged = true;
					if (chat == null || (chat != null && chat.Messages.Count == 0))
					{
						if (num3.ToString().Length > 15)
						{
							chat.Date = Utility.GetDateTimefromEpoch(num3);
						}
						else
						{
							chat.Date = Utility.GetDateTimeFromMiliseconds(num3);
						}
					}
					if (chat != null)
					{
						if (!string.IsNullOrEmpty(text3))
						{
							chat.ImagePath = text3;
						}
						if (!string.IsNullOrEmpty(text4) && !string.IsNullOrEmpty(text5))
						{
							chat.FileAddress = text4;
							chat.FilePath = text5;
						}
						if (!string.IsNullOrEmpty(text2))
						{
							chat.CustomTitle = text2;
							chat.Name = text2;
							UpdateChatSummary(chat);
						}
						_dataService.ChatDBSubmitChanges();
					}
					if (!string.IsNullOrEmpty(text))
					{
						ClearMember(chat);
						string[] array2 = array;
						foreach (string number in array2)
						{
							EnterMember(chat, number);
						}
					}
				}
			}
		});
	}

	internal async void ApplyChatInfoAllusingJoinTime(XElement xe, CoreDispatcher dispatcher)
	{
		await dispatcher.RunAsync((CoreDispatcherPriority)1, (DispatchedHandler)delegate
		{
			IEnumerable<XElement> enumerable = from item in xe.Descendants("chatroominfodetail")
				select (item);
			ChatOnService.Instance.InActiveChat.Clear();
			List<ChatMember> list = new List<ChatMember>();
			foreach (XElement item in enumerable)
			{
				string text = "";
				int num = int.Parse(item.Attribute("chattype").Value);
				IEnumerable<XElement> enumerable2 = from m in item.Descendants("chatroommemberinfo")
					select (m);
				string text2 = "";
				string text3 = "";
				string text4 = "";
				string text5 = "";
				int num2 = 0;
				long num3 = Utility.GetTimeStamp();
				bool flag = true;
				long time = 0L;
				list.Clear();
				if (item.Attribute("createtime") != null)
				{
					num3 = long.Parse(item.Attribute("createtime").Value);
				}
				foreach (XElement item2 in enumerable2)
				{
					if (item2.Attribute("userid") != null)
					{
						string id = item2.Attribute("userid").Value;
						bool flag2 = bool.Parse(item2.Attribute("insession").Value);
						if (id != RegistrationService.ChatOnID)
						{
							if (num == 1 && !flag2)
							{
								continue;
							}
							if (!string.IsNullOrEmpty(text))
							{
								text += ",";
							}
							text += id;
							if (item2.Attribute("starttime") != null)
							{
								time = long.Parse(item2.Attribute("starttime").Value);
							}
							list.Add(new ChatMember
							{
								Time = time,
								PhoneNumber = id
							});
							string value = item2.Attribute("name").Value;
							UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == id);
							if (unknownUser != null)
							{
								unknownUser.Name = value;
							}
							else
							{
								unknownUser = new UnknownUser(value, id);
								_dataService.AddUnknownUser(unknownUser);
							}
						}
						else
						{
							flag = flag2;
							if (!flag)
							{
								break;
							}
							if (item2.Attribute("title") != null)
							{
								text2 = item2.Attribute("title").Value;
							}
							if (item2.Attribute("starttime") != null)
							{
								num3 = long.Parse(item2.Attribute("starttime").Value);
							}
							if (item2.Attribute("starttime") != null)
							{
								time = long.Parse(item2.Attribute("starttime").Value);
							}
							if (item2.Attribute("profileimageaddr") != null && item2.Attribute("profileimagepath") != null)
							{
								string value2 = item2.Attribute("profileimageaddr").Value;
								string value3 = item2.Attribute("profileimagepath").Value;
								text4 = value2;
								text5 = value3;
								UserAccountInfo userAccount = RegistrationService.GetUserAccount();
								text3 = ((!(value2.Substring(value2.Length - 1, 1) == "/")) ? (value2 + "/" + value3) : (value2 + value3));
								text3 = text3 + "?uid=" + userAccount.Uid + "&imei=" + userAccount.IMEI;
							}
						}
						num2++;
					}
				}
				Chat chat = null;
				string sessionid = item.Attribute("sessionid").Value;
				if (!flag)
				{
					chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == sessionid);
					if (chat != null)
					{
						ChatOnService.Instance.InActiveChat.Add(chat);
					}
				}
				else
				{
					string[] array = Utility.Split(text);
					string sender = array[0];
					int port = int.Parse(item.Attribute("port").Value);
					string value4 = item.Attribute("ip").Value;
					string oldSession = "";
					if (item.Attribute("oldsessionid") != null)
					{
						oldSession = item.Attribute("oldsessionid").Value;
						chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == oldSession);
						if (chat != null)
						{
							chat.OldSessionID = oldSession;
						}
					}
					else
					{
						chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == sessionid);
					}
					if (chat == null)
					{
						chat = StartChat(disconnect: false, sender, text, (ChatType)num);
					}
					chat.SessionID = sessionid;
					chat.Port = port;
					chat.Address = value4;
					chat.IsChanged = true;
					if (chat == null || (chat != null && chat.Messages.Count == 0))
					{
						if (num3.ToString().Length > 15)
						{
							chat.Date = Utility.GetDateTimefromEpoch(num3);
						}
						else
						{
							chat.Date = Utility.GetDateTimeFromMiliseconds(num3);
						}
					}
					if (chat != null)
					{
						if (!string.IsNullOrEmpty(text3))
						{
							chat.ImagePath = text3;
						}
						if (!string.IsNullOrEmpty(text4) && !string.IsNullOrEmpty(text5))
						{
							chat.FileAddress = text4;
							chat.FilePath = text5;
						}
						if (!string.IsNullOrEmpty(text2))
						{
							chat.CustomTitle = text2;
							chat.Name = text2;
							UpdateChatSummary(chat);
						}
						_dataService.ChatDBSubmitChanges();
					}
					if (!string.IsNullOrEmpty(text))
					{
						ClearMember(chat);
						EnterMember(chat, list);
					}
				}
			}
		});
	}

	internal async void ApplyChatInfoAllusingJoinTime(XElement xe)
	{
		IEnumerable<XElement> enumerable = from item in xe.Descendants("chatroominfodetail")
			select (item);
		ChatOnService.Instance.InActiveChat.Clear();
		List<ChatMember> list = new List<ChatMember>();
		foreach (XElement item in enumerable)
		{
			string text = "";
			int num = int.Parse(item.Attribute("chattype").Value);
			IEnumerable<XElement> enumerable2 = from m in item.Descendants("chatroommemberinfo")
				select (m);
			string text2 = "";
			string text3 = "";
			string text4 = "";
			string text5 = "";
			int num2 = 0;
			long num3 = Utility.GetTimeStamp();
			bool flag = true;
			long time = 0L;
			list.Clear();
			if (item.Attribute("createtime") != null)
			{
				num3 = long.Parse(item.Attribute("createtime").Value);
			}
			foreach (XElement item2 in enumerable2)
			{
				if (item2.Attribute("userid") == null)
				{
					continue;
				}
				string id = item2.Attribute("userid").Value;
				bool flag2 = bool.Parse(item2.Attribute("insession").Value);
				if (id != RegistrationService.ChatOnID)
				{
					if (num == 1 && !flag2)
					{
						continue;
					}
					if (!string.IsNullOrEmpty(text))
					{
						text += ",";
					}
					text += id;
					if (item2.Attribute("starttime") != null)
					{
						time = long.Parse(item2.Attribute("starttime").Value);
					}
					list.Add(new ChatMember
					{
						Time = time,
						PhoneNumber = id
					});
					string value = item2.Attribute("name").Value;
					UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == id);
					if (unknownUser != null)
					{
						unknownUser.Name = value;
					}
					else
					{
						unknownUser = new UnknownUser(value, id);
						_dataService.AddUnknownUser(unknownUser);
					}
				}
				else
				{
					flag = flag2;
					if (!flag)
					{
						break;
					}
					if (item2.Attribute("title") != null)
					{
						text2 = item2.Attribute("title").Value;
					}
					if (item2.Attribute("starttime") != null)
					{
						num3 = long.Parse(item2.Attribute("starttime").Value);
					}
					if (item2.Attribute("starttime") != null)
					{
						time = long.Parse(item2.Attribute("starttime").Value);
					}
					if (item2.Attribute("profileimageaddr") != null && item2.Attribute("profileimagepath") != null)
					{
						string value2 = item2.Attribute("profileimageaddr").Value;
						string value3 = item2.Attribute("profileimagepath").Value;
						text4 = value2;
						text5 = value3;
						UserAccountInfo userAccount = RegistrationService.GetUserAccount();
						text3 = ((!(value2.Substring(value2.Length - 1, 1) == "/")) ? (value2 + "/" + value3) : (value2 + value3));
						text3 = text3 + "?uid=" + userAccount.Uid + "&imei=" + userAccount.IMEI;
					}
				}
				num2++;
			}
			string sessionid = item.Attribute("sessionid").Value;
			Chat chat;
			if (!flag)
			{
				chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == sessionid);
				if (chat != null)
				{
					ChatOnService.Instance.InActiveChat.Add(chat);
				}
				continue;
			}
			string[] array = Utility.Split(text);
			string sender = array[0];
			int port = int.Parse(item.Attribute("port").Value);
			string value4 = item.Attribute("ip").Value;
			string oldSession = "";
			if (item.Attribute("oldsessionid") != null)
			{
				oldSession = item.Attribute("oldsessionid").Value;
				chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == oldSession);
				if (chat != null)
				{
					chat.OldSessionID = oldSession;
				}
			}
			else
			{
				chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == sessionid);
			}
			if (chat == null)
			{
				chat = StartChat(disconnect: false, sender, text, (ChatType)num);
			}
			chat.SessionID = sessionid;
			chat.Port = port;
			chat.Address = value4;
			chat.IsChanged = true;
			if (chat == null || (chat != null && chat.Messages.Count == 0))
			{
				if (num3.ToString().Length > 15)
				{
					chat.Date = Utility.GetDateTimefromEpoch(num3);
				}
				else
				{
					chat.Date = Utility.GetDateTimeFromMiliseconds(num3);
				}
			}
			if (chat != null)
			{
				if (!string.IsNullOrEmpty(text3))
				{
					chat.ImagePath = text3;
				}
				if (!string.IsNullOrEmpty(text4) && !string.IsNullOrEmpty(text5))
				{
					chat.FileAddress = text4;
					chat.FilePath = text5;
				}
				if (!string.IsNullOrEmpty(text2))
				{
					chat.CustomTitle = text2;
					chat.Name = text2;
					UpdateChatSummary(chat);
				}
				_dataService.ChatDBSubmitChanges();
			}
			if (!string.IsNullOrEmpty(text))
			{
				ClearMember(chat);
				EnterMember(chat, list);
			}
		}
	}

	internal async void ApplyChatInfoAll(XElement xe)
	{
		IEnumerable<XElement> enumerable = from item in xe.Descendants("chatroominfodetail")
			select (item);
		ChatOnService.Instance.InActiveChat.Clear();
		foreach (XElement item in enumerable)
		{
			string text = "";
			int num = int.Parse(item.Attribute("chattype").Value);
			IEnumerable<XElement> enumerable2 = from m in item.Descendants("chatroommemberinfo")
				select (m);
			string text2 = "";
			string text3 = "";
			string text4 = "";
			string text5 = "";
			int num2 = 0;
			long num3 = Utility.GetTimeStamp();
			bool flag = true;
			if (item.Attribute("createtime") != null)
			{
				num3 = long.Parse(item.Attribute("createtime").Value);
			}
			foreach (XElement item2 in enumerable2)
			{
				if (item2.Attribute("userid") == null)
				{
					continue;
				}
				string id = item2.Attribute("userid").Value;
				bool flag2 = bool.Parse(item2.Attribute("insession").Value);
				if (id != RegistrationService.ChatOnID)
				{
					if ((num == 1 && !flag2) || id.Substring(0, 4) == "0999")
					{
						continue;
					}
					if (!string.IsNullOrEmpty(text))
					{
						text += ",";
					}
					text += id;
					string value = item2.Attribute("name").Value;
					UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == id);
					if (unknownUser != null)
					{
						unknownUser.Name = value;
					}
					else
					{
						unknownUser = new UnknownUser(value, id);
						_dataService.AddUnknownUser(unknownUser);
					}
				}
				else
				{
					flag = flag2;
					if (!flag)
					{
						break;
					}
					if (item2.Attribute("title") != null)
					{
						text2 = item2.Attribute("title").Value;
					}
					if (item2.Attribute("profileimageaddr") != null && item2.Attribute("profileimagepath") != null)
					{
						string value2 = item2.Attribute("profileimageaddr").Value;
						string value3 = item2.Attribute("profileimagepath").Value;
						text4 = value2;
						text5 = value3;
						UserAccountInfo userAccount = RegistrationService.GetUserAccount();
						text3 = ((!(value2.Substring(value2.Length - 1, 1) == "/")) ? (value2 + "/" + value3) : (value2 + value3));
						text3 = text3 + "?uid=" + userAccount.Uid + "&imei=" + userAccount.IMEI;
					}
				}
				num2++;
			}
			string sessionid = item.Attribute("sessionid").Value;
			Chat chat;
			if (!flag)
			{
				chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == sessionid);
				if (chat != null)
				{
					ChatOnService.Instance.InActiveChat.Add(chat);
				}
				continue;
			}
			string[] array = Utility.Split(text);
			string sender = array[0];
			int port = int.Parse(item.Attribute("port").Value);
			string value4 = item.Attribute("ip").Value;
			string oldSession = "";
			if (item.Attribute("oldsessionid") != null)
			{
				oldSession = item.Attribute("oldsessionid").Value;
				chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == oldSession);
				if (chat != null)
				{
					chat.OldSessionID = oldSession;
				}
			}
			else
			{
				chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == sessionid);
			}
			if (chat == null)
			{
				chat = StartChat(disconnect: false, sender, text, (ChatType)num);
			}
			chat.SessionID = sessionid;
			chat.Port = port;
			chat.Address = value4;
			chat.IsChanged = true;
			chat.Background = new SolidColorBrush(Colors.Transparent);
			if (chat == null || (chat != null && chat.Messages.Count == 0))
			{
				if (num3.ToString().Length > 15)
				{
					chat.Date = Utility.GetDateTimefromEpoch(num3);
				}
				else
				{
					chat.Date = Utility.GetDateTimeFromMiliseconds(num3);
				}
			}
			if (chat != null)
			{
				if (!string.IsNullOrEmpty(text3))
				{
					chat.ImagePath = text3;
				}
				if (!string.IsNullOrEmpty(text4) && !string.IsNullOrEmpty(text5))
				{
					chat.FileAddress = text4;
					chat.FilePath = text5;
				}
				if (!string.IsNullOrEmpty(text2))
				{
					chat.CustomTitle = text2;
					chat.Name = text2;
					UpdateChatSummary(chat);
				}
				_dataService.ChatDBSubmitChanges();
			}
			if (!string.IsNullOrEmpty(text))
			{
				ClearMember(chat);
				string[] array2 = array;
				foreach (string number in array2)
				{
					EnterMember(chat, number);
				}
			}
		}
	}

	internal void ApplyGroupPushSettings(XElement xe)
	{
		IEnumerable<XElement> enumerable = from item in xe.Descendants("pushlist")
			select (item);
		foreach (XElement item in enumerable)
		{
			string sessionid = item.Attribute("sessionid").Value;
			Chat chat = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == sessionid);
			if (chat != null)
			{
				bool isAlert = int.Parse(item.Attribute("pushtype").Value) == 1;
				chat.IsAlert = isAlert;
			}
		}
	}

	internal void ApplyChatMemberList(Chat chat, XElement xe)
	{
		IEnumerable<XElement> enumerable = from item in xe.Descendants("members")
			select (item);
		foreach (XElement item in enumerable)
		{
			IEnumerable<XElement> enumerable2 = from m in item.Descendants("member")
				select (m);
			foreach (XElement item2 in enumerable2)
			{
				string value = item2.Value;
				if (value != RegistrationService.ChatOnID)
				{
					EnterMember(chat, value);
				}
			}
		}
	}

	internal void ParseChatRoomProfileImage(Chat chat, XElement xe)
	{
		//IL_00d8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e2: Expected O, but got Unknown
		IEnumerable<XElement> enumerable = from item in xe.Descendants("profileimagelist")
			select (item);
		foreach (XElement item in enumerable)
		{
			string sessionid = item.Attribute("sessionid").Value;
			Chat chat2 = _dataService.ChatItems.FirstOrDefault((Chat c) => c.SessionID == sessionid);
			if (chat2 != null)
			{
				string value = item.Attribute("profile_url").Value;
				string value2 = item.Attribute("profile_filename").Value;
				chat2.ImagePath = value + "/" + value2;
				chat2.ProfileImage = new BitmapImage(new Uri(chat2.ImagePath));
				_dataService.ChatDBSubmitChanges();
			}
		}
	}

	public async Task<List<Message>> ReflectUnreadMessage(string sessionID = "")
	{
		List<Message> oldSessionMessages = new List<Message>();
		foreach (Message msg in _dataService.UnreadMessages)
		{
			if (!(msg.Sender.Substring(0, 4) == "0999"))
			{
				await ReflectUnreadMessage(msg);
				oldSessionMessages.Add(msg);
			}
		}
		UpdateAllChatSummary(((DependencyObject)PivotPage.ActiveInstance).Dispatcher);
		_dataService.ChatDBSubmitChanges();
		_dataService.MessageDBSubmitChanges();
		return oldSessionMessages;
	}

	public async Task<List<Message>> ReflectAllMessage(string sessionID = "")
	{
		List<Message> oldSessionMessages = new List<Message>();
		_dataService.UnreadMessages.Sort((Message m2, Message m1) => m2.Time.CompareTo(m1.Time));
		foreach (Message msg in _dataService.UnreadMessages)
		{
			Chat chat = await ReflectUnreadMessage(msg);
			if (chat != null)
			{
				chat.SortMessage();
				AddMessageToShow(chat, msg);
				UpdateChatSummary(chat);
			}
		}
		_dataService.ChatDBSubmitChanges();
		_dataService.MessageDBSubmitChanges();
		return oldSessionMessages;
	}

	internal void CancelUpdateChatProfileImage()
	{
		if (UpdateChatProfileImageClient != null)
		{
			UpdateChatProfileImageClient.CancelPendingRequests();
			UpdateChatProfileImageClient.Dispose();
			UpdateChatProfileImageClient = null;
		}
	}

	internal async Task UpdateChatProfileImageAsync(Chat chat)
	{
		UpdateChatProfileImageClient = new HttpClient();
		UpdateChatProfileImageClient.Timeout = new TimeSpan(0, 0, 0, 30);
		string address = _ssmService.CreateCheckBuddyProfileAsync(chat.SingleChatBuddy.PhoneNumber);
		HttpResponseMessage result = null;
		try
		{
			result = await UpdateChatProfileImageClient.GetAsync(new Uri(address), HttpCompletionOption.ResponseContentRead);
		}
		catch (Exception)
		{
		}
		if (result == null || result.StatusCode != HttpStatusCode.OK)
		{
			return;
		}
		string xmlString = await result.Content.ReadAsStringAsync();
		XElement xmlResult = null;
		try
		{
			if (!string.IsNullOrEmpty(xmlString))
			{
				xmlResult = XElement.Load(new StringReader(xmlString));
			}
		}
		catch (Exception)
		{
		}
		if (xmlResult == null)
		{
			return;
		}
		Buddy buddyInfo = _buddyService.ParseCheckBuddyInfos(xmlResult, chat.SingleChatBuddy);
		chat.BuddyProfileUpdated();
		if (buddyInfo.ImgStatus != Buddy.ProfileImgStatus.Deleted)
		{
			QueueEngine queueEngine = ((IDictionary<object, object>)Application.Current.Resources)[(object)"QueueEngine"] as QueueEngine;
			GetBuddyProfileImage_QueueItem getBuddyProfileImage_QueueItem = new GetBuddyProfileImage_QueueItem(_ssmService, chat.SingleChatBuddy.PhoneNumber);
			getBuddyProfileImage_QueueItem.InvokeBack = delegate(object o, Exception ex3)
			{
				if (ex3 == null && o != null)
				{
					chat.SingleChatBuddy.IsDownloading = false;
					chat.SingleChatBuddy.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
					chat.SingleChatBuddy.ThumbProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
					chat.SingleChatBuddy.NotifyPropertyChanged("ProfileImage");
					chat.SingleChatBuddy.ImgStatus = Buddy.ProfileImgStatus.NoChanges;
					chat.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
					chat.NotifyChatProfileImageUpdated();
					_dataService.BuddyDBSubmitChanges();
					foreach (Message messageItem in chat.MessageItems)
					{
						messageItem.NotifyImageUpdated();
					}
				}
			};
			queueEngine?.Add(getBuddyProfileImage_QueueItem);
		}
		else if (buddyInfo.ImgStatus == Buddy.ProfileImgStatus.Deleted)
		{
			chat.SingleChatBuddy.IsDownloading = false;
			chat.SingleChatBuddy.ProfileImage = new BitmapImage(new Uri("ms-appx:///Images/chat_info_single.png"));
			chat.SingleChatBuddy.ThumbProfileImage = new BitmapImage(new Uri("ms-appx:///Images/chat_info_single.png"));
			chat.SingleChatBuddy.NotifyPropertyChanged("ProfileImage");
		}
	}

	internal void CancelUpdateGroupChatProfileImageUrl()
	{
		if (UpdateGroupChatProfileImageUrlClient != null)
		{
			UpdateGroupChatProfileImageUrlClient.CancelPendingRequests();
			UpdateGroupChatProfileImageUrlClient.Dispose();
			UpdateGroupChatProfileImageUrlClient = null;
		}
	}

	public async Task UpdateGroupChatProfileImageUrl(Chat chat)
	{
		if (!chat.IsGroupChat())
		{
			return;
		}
		UpdateGroupChatProfileImageUrlClient = new HttpClient();
		UpdateGroupChatProfileImageUrlClient.Timeout = new TimeSpan(0, 0, 0, 30);
		string address = _ssmService.CreateGetChatRoomProfileImageAsync(chat.SessionID, "", "");
		HttpResponseMessage result = null;
		try
		{
			result = await UpdateGroupChatProfileImageUrlClient.GetAsync(new Uri(address), HttpCompletionOption.ResponseContentRead);
		}
		catch (Exception)
		{
		}
		if (result == null || result.StatusCode != HttpStatusCode.OK)
		{
			return;
		}
		string xmlString = await result.Content.ReadAsStringAsync();
		XElement xmlResult = null;
		try
		{
			if (!string.IsNullOrEmpty(xmlString))
			{
				xmlResult = XElement.Load(new StringReader(xmlString));
			}
		}
		catch (Exception)
		{
		}
		if (xmlResult != null)
		{
			string url = ParseChatProfileImage(xmlResult);
			if (!string.IsNullOrEmpty(url))
			{
				chat.ImagePath = url;
			}
			_dataService.ChatDBSubmitChanges();
		}
	}

	internal string ParseChatProfileImage(XElement xe)
	{
		string result = "";
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		IEnumerable<XElement> enumerable = from item in xe.Descendants("profileimagelist")
			select (item);
		foreach (XElement item in enumerable)
		{
			string text = "";
			string text2 = "";
			if (item.Attribute("profile_url") != null)
			{
				text = item.Attribute("profile_url").Value;
			}
			if (item.Attribute("profile_url") != null)
			{
				text2 = item.Attribute("profile_filename").Value;
			}
			result = (string.IsNullOrEmpty(text) ? string.Empty : (text + text2 + "?uid=" + userAccount.Uid + "&imei=" + userAccount.IMEI));
		}
		return result;
	}

	internal void HandleBlockBuddy(Buddy buddy)
	{
		try
		{
			List<Chat> list = _dataService.ChatItems.Where((Chat x) => x.ChatType == ChatType.BROADCAST).ToList();
			foreach (Chat item in list)
			{
				if (item.MemberList.Contains(buddy.PhoneNumber))
				{
					item.MemberList.Remove(buddy.PhoneNumber);
					Message message = new Message();
					message.BlockNotificationCount++;
					message.Type = "noti";
					message.Text = ChangeStatus.LEAVE.ToString() + ',' + buddy.PhoneNumber + ',' + buddy.ProfileName + '\n';
					message.SessionID = item.SessionID;
					message.Time = Utility.GetTimeStamp();
					message.NumberID = SocketMessage.CreateMsgID();
					message.ActivityState = Message.State.Received;
					message.Sender = buddy.PhoneNumber;
					LeaveMember(item, buddy.PhoneNumber);
					_dataService.AddMessage(message);
					AddMessageToShow(item, message, addToDB: false);
					UpdateChatSummary(item);
					item.AddDateHeaderAndCheckbox();
					item.NotifyPropertyChanged("");
				}
			}
			_dataService.ChatDBSubmitChanges();
		}
		catch (Exception)
		{
		}
	}

	internal void HandleBuddyRename(Chat chat, Buddy buddy)
	{
		IEnumerable<Message> enumerable = chat.MessageItems.Where((Message x) => x.Sender == buddy.PhoneNumber);
		foreach (Message item in enumerable)
		{
			item.NotifySenderUpdated();
		}
	}

	internal void CancelCreateGetAllMessageAsync()
	{
		if (GetAllMessageAsyncClient != null)
		{
			GetAllMessageAsyncClient.CancelPendingRequests();
			GetAllMessageAsyncClient.Dispose();
			GetAllMessageAsyncClient = null;
			IsGetAllMessage = false;
		}
	}

	internal async Task GetAllMessageAsync(Chat chat, string sessionId, string tId, string count)
	{
		if (IsGetAllMessage)
		{
			return;
		}
		IsGetAllMessage = true;
		GetAllMessageAsyncClient = new HttpClient();
		GetAllMessageAsyncClient.Timeout = new TimeSpan(0, 0, 0, 30);
		string address = _ssmService.CreateGetAllMessageAsync(sessionId, tId, count);
		HttpResponseMessage result = null;
		try
		{
			result = await GetAllMessageAsyncClient.GetAsync(new Uri(address), HttpCompletionOption.ResponseContentRead);
		}
		catch (Exception)
		{
			IsGetAllMessage = false;
		}
		if (result == null)
		{
			IsGetAllMessage = false;
			return;
		}
		if (result.StatusCode != HttpStatusCode.OK)
		{
			if (result.StatusCode == HttpStatusCode.NoContent)
			{
				chat.PrevMsgStatus = Chat.PrevMsgLoadingStatus.None;
				_dataService.ChatDBSubmitChanges();
				string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_CANNOT_LOAD_OLDER_MESSAGES_MESSAGES_ARE_ONLY_KEPT_FOR_PD_DAYS");
				resourceString = resourceString.Replace("%d", "15");
				if ((int)ApplicationView.Value != 2)
				{
					if (ChatDetailPage.ActiveInstance != null)
					{
						ChatDetailPage.ActiveInstance.ShowSplashPopup(resourceString);
					}
				}
				else if (ChatDetailPage.SnappedActiveInstance != null)
				{
					ChatDetailPage.SnappedActiveInstance.ShowSplashPopup(resourceString);
				}
			}
			IsGetAllMessage = false;
			return;
		}
		string xmlString = await result.Content.ReadAsStringAsync();
		XElement xmlResult = null;
		try
		{
			if (!string.IsNullOrEmpty(xmlString))
			{
				xmlResult = XElement.Load(new StringReader(xmlString));
			}
		}
		catch (Exception)
		{
			IsGetAllMessage = false;
		}
		if (xmlResult == null)
		{
			IsGetAllMessage = false;
			return;
		}
		MessageService _msgService = new MessageService(_dataService, _ssmService);
		bool hasMore;
		List<Message> newMessages = _msgService.ParseAllMessageFromXml(xmlResult, chat, out hasMore);
		if (newMessages.Count == 0)
		{
			IsGetAllMessage = false;
			return;
		}
		chat.LastSyncTid = long.Parse(newMessages.Last().Tid) - 1;
		if (chat.LastMessage == null)
		{
			GetLastMessage(chat);
		}
		foreach (Message item in newMessages)
		{
			long time = item.Time;
			if (time > chat.LastMergedTimeStamp)
			{
				AddMessageToShow(chat, item, addToDB: true, toPrev: true);
			}
		}
		chat.AddDateHeaderAndCheckbox();
		UpdateChatSummary(chat);
		if (hasMore)
		{
			chat.PrevMsgStatus = Chat.PrevMsgLoadingStatus.Loading;
		}
		else
		{
			chat.PrevMsgStatus = Chat.PrevMsgLoadingStatus.None;
		}
		_dataService.MessageDBSubmitChanges();
		_dataService.ChatDBSubmitChanges();
		ChatOnService.Instance.ReUpdateChatList = true;
		PivotPage.ActiveInstance.ViewModel.UpdateChatList();
		IsGetAllMessage = false;
	}

	internal void CancelGetTrunkListAsync()
	{
		if (GetTrunkListAsyncClient != null)
		{
			GetTrunkListAsyncClient.CancelPendingRequests();
			GetTrunkListAsyncClient.Dispose();
			GetTrunkListAsyncClient = null;
		}
	}

	internal async Task GetTrunkListAsync()
	{
		if (IsGetTrunkList)
		{
			return;
		}
		IsGetTrunkList = true;
		TimeSpan time = SSMService.GetTrunkListSyncTimeSpan();
		if (time.Ticks >= 0 && time <= TimeSpan.FromSeconds(1.0))
		{
			IsGetTrunkList = false;
			return;
		}
		_ssmService.CreateGetTrunkListAsync(_dataService, out var address, out var param);
		try
		{
			HttpMessageHandler requestHandler = new HttpClientHandler();
			GetTrunkListAsyncClient = new HttpClient(requestHandler, disposeHandler: true);
			SSMService.SaveTrunkListSyncTime();
			StringContent content = new StringContent(param);
			content.Headers.ContentType = new MediaTypeHeaderValue("text/xml");
			HttpResponseMessage response = await GetTrunkListAsyncClient.PostAsync(address, content);
			if (response.StatusCode != HttpStatusCode.OK)
			{
				IsGetTrunkList = false;
			}
			string xmlString = await response.Content.ReadAsStringAsync();
			XElement xmlResult = null;
			try
			{
				if (!string.IsNullOrEmpty(xmlString))
				{
					xmlResult = XElement.Load(new StringReader(xmlString));
				}
			}
			catch (Exception)
			{
				IsGetTrunkList = false;
			}
			if (xmlResult == null)
			{
				IsGetTrunkList = false;
				return;
			}
			List<UnreadTrunkInfo> trunks = TrunkService.GetUnreadTrunkFromXml(xmlResult);
			foreach (UnreadTrunkInfo item in trunks)
			{
				foreach (Chat chatItem in _dataService.ChatItems)
				{
					if (chatItem.SessionID == item.SessionID)
					{
						chatItem.UnreadTrunkMessageCount = item.UnreadCount;
						break;
					}
				}
			}
			PivotPage.ActiveInstance.ViewModel.NewTrunkCommentCount = UpdateTrunkUnreadCount();
			IsGetTrunkList = false;
		}
		catch (Exception)
		{
		}
	}

	internal async void UpdateGroupChatProfiles()
	{
		List<Chat> groupChats = _dataService.ChatItems.Where((Chat x) => x.IsGroupChat()).ToList();
		try
		{
			foreach (Chat chat in groupChats)
			{
				await LoadGroupChatProfile(chat);
			}
		}
		catch (Exception)
		{
		}
	}

	public async Task LoadGroupChatProfile(Chat chat)
	{
		BitmapImage profileimage = await Utility.LoadImage(string.Concat("thumb_", chat.ChatID, ".jpg"), "Group");
		if (profileimage != null && (((BitmapSource)profileimage).PixelWidth == 0 || ((BitmapSource)profileimage).PixelHeight == 0))
		{
			await Utility.DeleteFile(string.Concat("thumb_", chat.ChatID, ".jpg"), "Group");
			profileimage = null;
		}
		if (profileimage == null)
		{
			QueueEngine queueEngine = ((IDictionary<object, object>)Application.Current.Resources)[(object)"QueueEngine"] as QueueEngine;
			GetGroupProfileImage_QueueItem getGroupProfileImage_QueueItem = new GetGroupProfileImage_QueueItem(_ssmService, chat, isthumbnail: true, forceupdate: false);
			Chat chat2 = chat;
			getGroupProfileImage_QueueItem.InvokeBack = delegate(object o, Exception ex)
			{
				if (ex == null && o != null)
				{
					chat2.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
					_dataService.ChatDBSubmitChanges();
				}
			};
			queueEngine.Add(getGroupProfileImage_QueueItem);
		}
		else
		{
			chat.ProfileImage = profileimage;
		}
		_dataService.ChatDBSubmitChanges();
	}
}
