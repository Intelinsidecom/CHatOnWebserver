using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Device.Location;
using System.Globalization;
using System.IO;
using System.IO.IsolatedStorage;
using System.Linq;
using System.Threading;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Threading;
using ChatOn.AnimationMessage.Encoding;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using com.sec.ssm.common;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using Microsoft.Phone.Tasks;
using vitemapi;

namespace ChatOn.ViewModels;

public class ChatDetailPageViewModel : NotificationObject
{
	private class MessageNotificationInfo
	{
		private Message _msg;

		private string _name;

		public Message Msg
		{
			get
			{
				return _msg;
			}
			set
			{
				_msg = value;
			}
		}

		public string Name
		{
			get
			{
				return _name;
			}
			set
			{
				_name = value;
			}
		}

		public MessageNotificationInfo(Message msg, string propertyName)
		{
			_msg = msg;
			_name = propertyName;
		}
	}

	private ChatDetailPage _page;

	private Chat _chat;

	private RegistrationService _regService;

	private DataService _dataService;

	private ChatService _chatService;

	private BuddyService _buddyService;

	private MessageService _msgService;

	private SSMService _ssmService;

	private AttachmentService _attachmentService;

	private string _inputTextMsg = "";

	private BackgroundWorker _bw = new BackgroundWorker();

	private int _scrollCmdCount;

	private Message _currentViewMessage;

	private List<Buddy> _invitingBuddies = new List<Buddy>();

	private Visibility _emoticonChooserVisibiliey;

	private BitmapImage _backgroundImage;

	private bool _isSelectAll;

	private bool _isSelectReceived;

	private bool _isSelectSent;

	private bool _isConnected;

	private DispatcherTimer _timer;

	private int _initialUnreadMessagesCount;

	private bool _isFirst = true;

	private Message _uploadingMsg;

	private List<MessageNotificationInfo> _messagePropertyNotiList = new List<MessageNotificationInfo>();

	private bool _isClosing;

	private bool _isUploading;

	public bool IsConnected
	{
		get
		{
			return _isConnected;
		}
		set
		{
			_isConnected = value;
		}
	}

	public BitmapImage BackgroundImage
	{
		get
		{
			return _backgroundImage;
		}
		set
		{
			_backgroundImage = value;
			NotifyPropertyChanged(() => BackgroundImage);
		}
	}

	public Chat Chat
	{
		get
		{
			return _chat;
		}
		set
		{
			_chat = value;
			NotifyPropertyChanged(() => Chat);
		}
	}

	public string InputTextMsg
	{
		get
		{
			return _inputTextMsg;
		}
		set
		{
			_inputTextMsg = value;
		}
	}

	public ObservableCollection<Message> MessageItems
	{
		get
		{
			if (_chat != null)
			{
				return _chat.MessageItems;
			}
			return null;
		}
	}

	public Visibility EmoticonChooserVisibility
	{
		get
		{
			return _emoticonChooserVisibiliey;
		}
		set
		{
			_emoticonChooserVisibiliey = value;
			NotifyPropertyChanged(() => EmoticonChooserVisibility);
		}
	}

	public ChatDetailPageViewModel(ChatDetailPage page)
	{
		_page = page;
		_regService = new RegistrationService();
		_ssmService = new SSMService();
		_dataService = new DataService();
		_msgService = new MessageService(_dataService, _ssmService);
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.GetUserNumber());
		SocketService.Instance.Reset();
		SocketService.Instance.Connected += _socketService_Connected;
		SocketService.Instance.InitChatReplyReceived += _socketService_InitChatReplyReceived;
		SocketService.Instance.AllowChatReplyReceived += Instance_AllowChatReplyReceived;
		SocketService.Instance.ChatReplyReceived += _socketService_ChatReplyReceived;
		SocketService.Instance.DeliveryChatCompleted += _socketService_DeliveryChatCompleted;
		SocketService.Instance.AnnounceChangeReceived += _socketService_AnnounceChangeReceived;
		SocketService.Instance.EndChatReplyReceived += _socketService_EndChatReplyReceived;
		SocketService.Instance.AnswerBackReceived += _socketService_AnswerBackReceived;
		SocketService.Instance.NickNameReplyReceived += _socketService_NickNameReplyReceived;
		SocketService.Instance.InviteChatReplyReceived += _socketService_InviteChatReplyReceived;
		SocketService.Instance.OnSocketError += _socketService_OnSocketError;
		_attachmentService = AttachmentService.Instance;
		_emoticonChooserVisibiliey = Visibility.Collapsed;
		BackgroundImage = SettingService.GetSelectedBG();
		_timer = new DispatcherTimer();
		_timer.Interval = TimeSpan.FromSeconds(5.0);
		_timer.Tick += _timer_Tick;
	}

	private void Instance_AllowChatReplyReceived(object sender, object arg)
	{
		if (!_isFirst)
		{
			return;
		}
		_isFirst = false;
		foreach (string member in _chat.MemberList)
		{
			CheckAndRequestNickName(member);
		}
	}

	private void _timer_Tick(object sender, EventArgs e)
	{
		if (IsConnected)
		{
			EnableChatButtons();
			_timer.Stop();
		}
		Connect();
	}

	private void _socketService_OnSocketError(object sender, object arg)
	{
		IsConnected = false;
		_isUploading = false;
		_chatService.SetFailedMessage(_chat, null, isBlockNotify: true, out var _);
		_dataService.MessageDBSubmitChanges();
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			_chatService.NotifyFailedMessages(_chat);
			if (!SocketService.Instance.DisconnectRequested)
			{
				if (((PhoneApplicationPage)_page).ApplicationBar.Buttons.Count == 4)
				{
					foreach (object button in ((PhoneApplicationPage)_page).ApplicationBar.Buttons)
					{
						((ApplicationBarIconButton)((button is ApplicationBarIconButton) ? button : null)).IsEnabled = false;
					}
					object obj = ((PhoneApplicationPage)_page).ApplicationBar.MenuItems[0];
					((ApplicationBarMenuItem)((obj is ApplicationBarMenuItem) ? obj : null)).IsEnabled = false;
				}
				_timer.Start();
			}
		});
	}

	private void _socketService_InviteChatReplyReceived(object sender, object arg)
	{
		InviteChatReply msg = arg as InviteChatReply;
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			Message message = new Message
			{
				Type = "noti",
				Time = msg.MsgReceivedTime,
				NumberID = msg.MsgID,
				ActivityState = Message.State.Received
			};
			foreach (Buddy invitingBuddy in _invitingBuddies)
			{
				object text = message.Text;
				message.Text = string.Concat(text, ChangeStatus.ENTER.ToString(), ',', invitingBuddy.PhoneNumber, ',', invitingBuddy.Name, '\n');
				_chatService.EnterMember(_chat, invitingBuddy.PhoneNumber);
			}
			_invitingBuddies.Clear();
			_chatService.AddMessageToShow(_chat, message);
			_chatService.UpdateChatSummary(_chat);
			_chat.AddDateHeaderAndCheckbox();
			ScrollToRecentMessage();
		});
	}

	private void _socketService_NickNameReplyReceived(object sender, object arg)
	{
		NicknameReply nicknameMsg = arg as NicknameReply;
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			foreach (Nickname nickname in nicknameMsg.NicknameList)
			{
				if (_buddyService.SaveOrUpdateUnknownUser(nickname.User, nickname.Nickname_))
				{
					foreach (Message messageItem in _chat.MessageItems)
					{
						if (nickname.User == messageItem.Sender)
						{
							messageItem.NotifySenderUpdated();
						}
					}
				}
			}
			_chatService.UpdateChatSummary(_chat);
		});
	}

	private void _socketService_AnswerBackReceived(object sender, object arg)
	{
		AnswerBack answerBack = arg as AnswerBack;
		foreach (AnswerbackItem answerbackItems in answerBack.AnswerbackItemsList)
		{
			Message message = _chatService.GetMessage(_chat, answerbackItems.MsgID);
			long time = 0L;
			if (message != null)
			{
				time = message.Time;
			}
			_chatService.ReflectAnswerBackMessage(_chat, answerbackItems.Receiver, time);
			if (message != null && message.ActivityState != Message.State.Sent)
			{
				message.BlockNotificationCount++;
				message.ActivityState = Message.State.Sent;
				message.BlockNotificationCount--;
				_messagePropertyNotiList.Add(new MessageNotificationInfo(message, "ActivityState"));
			}
		}
		_dataService.SubmitChanges();
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			foreach (MessageNotificationInfo messagePropertyNoti in _messagePropertyNotiList)
			{
				messagePropertyNoti.Msg.NotifyPropertyChanged(messagePropertyNoti.Name);
			}
			_chatService.NotifyAnswerbackCountChanged(_chat);
		});
	}

	private void _socketService_EndChatReplyReceived(object sender, object arg)
	{
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			LoadingIndicator.StopLoading();
		});
		EndChatReply endChatReply = arg as EndChatReply;
		if (endChatReply.Result.ResultCode == 1000 || endChatReply.Result.ResultCode == 3006 || endChatReply.Result.ResultCode == 3003)
		{
			((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
			{
				CloseAndShowPivotPage();
			});
		}
	}

	private void _socketService_ChatReplyReceived(object sender, object arg)
	{
		_ = DateTime.UtcNow.Ticks;
		ChatReply msg = arg as ChatReply;
		Message savedMsg = _chatService.GetMessage(_chat, msg.MsgID);
		savedMsg.BlockNotificationCount++;
		savedMsg.SessionID = msg.SessionID;
		savedMsg.Time = msg.MsgReceivedTime;
		savedMsg.ActivityState = Message.State.Sent;
		HandleFailedMessage(msg.Result.ResultCode, savedMsg);
		savedMsg.BlockNotificationCount--;
		_dataService.MessageDBSubmitChanges();
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			ShowSendingError(msg.Result.ResultCode);
			savedMsg.NotifyPropertyChanged("Time");
			savedMsg.NotifyPropertyChanged("ActivityState");
			_chat.SortMessage();
			_chatService.GetLastMessage(_chat);
			NotificationObject.IsBlockChangedNotification = true;
			_chatService.UpdateChatSummary(_chat);
			NotificationObject.IsBlockChangedNotification = false;
			_chat.AddDateHeaderAndCheckbox();
		});
	}

	private void HandleFailedMessage(int ret, Message savedMsg)
	{
		if (ret != 1000 && ret != 1001)
		{
			savedMsg.ActivityState = Message.State.SendingFailed;
			if (ret == 6002)
			{
				_chat.IsValidSession = false;
			}
		}
	}

	private void _socketService_DeliveryChatCompleted(object sender, object arg)
	{
		DeliveryChat msg = arg as DeliveryChat;
		List<Message> newMessageList = new List<Message>();
		new List<Message>();
		List<string> members = null;
		foreach (InboxMessage inboxMessage in msg.InboxMessageList)
		{
			Message message = _chatService.GetMessage(_chat, inboxMessage.MsgID);
			if (inboxMessage.MsgType == MsgType.ANS)
			{
				if (message != null && message.ActivityState != Message.State.Sent)
				{
					message.BlockNotificationCount++;
					message.ActivityState = Message.State.Sent;
					message.BlockNotificationCount--;
					_messagePropertyNotiList.Add(new MessageNotificationInfo(message, "ActivityState"));
				}
				_chatService.ReflectAnswerBackMessage(_chat, inboxMessage.ReceiversList[0], inboxMessage.SentTime);
				continue;
			}
			if (inboxMessage.MsgType == MsgType.NOTI)
			{
				members = new List<string>(inboxMessage.ReceiversList);
				string[] array = Utility.Split(inboxMessage.ChatMsg);
				if (array[0] == "ENTER")
				{
					members.Add(inboxMessage.Sender);
					members.Add(array[1]);
				}
			}
			if (message == null)
			{
				Message message2 = new Message();
				message2.BlockNotificationCount++;
				message2.Type = inboxMessage.MsgType.ToString().ToLower();
				message2.SessionID = msg.SessionID;
				message2.Time = inboxMessage.SentTime;
				message2.Sender = inboxMessage.Sender;
				message2.Receiver = string.Join(",", inboxMessage.ReceiversList);
				message2.Text = inboxMessage.ChatMsg;
				message2.NumberID = inboxMessage.MsgID;
				message2.ActivityState = Message.State.Received;
				message2.ChatID = _chat.ChatID;
				message2.Chat = _chat;
				message2.BlockNotificationCount--;
				if (_chat.Messages.Count == 0 && newMessageList.Count == 0)
				{
					members = new List<string>(inboxMessage.ReceiversList);
					members.Add(message2.Sender);
				}
				newMessageList.Add(message2);
			}
		}
		if (newMessageList.Count < 10)
		{
			newMessageList.Sort((Message m2, Message m1) => m2.Time.CompareTo(m1.Time));
		}
		foreach (Message item in newMessageList)
		{
			_dataService.AddMessage(item);
		}
		_dataService.MessageDBSubmitChanges();
		_dataService.ChatDBSubmitChanges();
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			foreach (MessageNotificationInfo messagePropertyNoti in _messagePropertyNotiList)
			{
				messagePropertyNoti.Msg.NotifyPropertyChanged(messagePropertyNoti.Name);
			}
			_messagePropertyNotiList.Clear();
			_chatService.NotifyAnswerbackCountChanged(_chat);
			if (members != null)
			{
				ChatService.ClearMember(_chat);
				foreach (string item2 in members)
				{
					_chatService.EnterMember(_chat, item2);
					CheckAndRequestNickName(item2);
				}
			}
			bool flag = _chat.UnreadMessageCount > 0;
			if (newMessageList.Count < 10)
			{
				foreach (Message item3 in newMessageList)
				{
					if (item3.Type != "noti")
					{
						_chat.UnreadMessageCount--;
					}
					_chatService.AddMessageToShow(_chat, item3, addToDB: false);
				}
				_chatService.GetLastMessage(_chat);
				NotificationObject.IsBlockChangedNotification = true;
				_chatService.UpdateChatSummary(_chat);
				NotificationObject.IsBlockChangedNotification = false;
				_chat.AddDateHeaderAndCheckbox();
				ScrollToRecentMessage();
			}
			else
			{
				foreach (Message item4 in newMessageList)
				{
					if (item4.Type != "noti")
					{
						_chat.UnreadMessageCount--;
					}
					_chatService.AddMessage(_chat, item4);
				}
				_chat.ReflectMessageInfo(newMessageList.Last());
				_chatService.SortAllMessages(_chat);
				_chatService.GetLastMessage(_chat);
				NotificationObject.IsBlockChangedNotification = true;
				_chatService.UpdateChatSummary(_chat);
				NotificationObject.IsBlockChangedNotification = false;
				LoadMessages();
			}
			if (!msg.HasMoreResult && _chat.UnreadMessageCount > 0)
			{
				_chat.UnreadMessageCount = 0;
			}
			if (flag)
			{
				_chatService.UpdateTileUnreadCount();
				_dataService.ChatDBSubmitChanges();
			}
			if (_chat.UnreadMessageCount > 0)
			{
				string text = ResContainer.IDS_CHATON_BODY_LOADING_ING + (_initialUnreadMessagesCount - _chat.UnreadMessageCount) + "/" + _initialUnreadMessagesCount;
				if (LoadingIndicator.ActiveIndicator == null)
				{
					LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page, text, isCancelable: true);
					_page.LayoutRoot.Children.Add(value);
				}
				else
				{
					LoadingIndicator.ActiveIndicator.SetText(text);
				}
			}
			else
			{
				LoadingIndicator.StopLoading();
			}
		});
	}

	private void _socketService_AnnounceChangeReceived(object sender, object arg)
	{
		AnnounceChange msg = arg as AnnounceChange;
		Message newMsg = new Message();
		newMsg.BlockNotificationCount++;
		newMsg.Type = "noti";
		newMsg.SessionID = msg.SessionID;
		newMsg.Time = msg.SentTime;
		newMsg.NumberID = msg.MsgID;
		newMsg.ActivityState = Message.State.Received;
		newMsg.Sender = msg.Inviter;
		foreach (ChangeMemberList changeMemberList in msg.ChangeMemberListList)
		{
			Message message = newMsg;
			object text = message.Text;
			message.Text = string.Concat(text, changeMemberList.Status.ToString(), ',', changeMemberList.Member, ',', changeMemberList.Name, '\n');
		}
		newMsg.ChatID = _chat.ChatID;
		newMsg.BlockNotificationCount--;
		_dataService.AddMessage(newMsg);
		_chat.MemberList.Clear();
		string userNumber = RegistrationService.GetUserNumber();
		foreach (string groupMemberList in msg.GroupMemberListList)
		{
			if (!(groupMemberList == userNumber))
			{
				_chat.MemberList.Add(groupMemberList);
			}
		}
		_chat.Members = string.Join(",", _chat.MemberList);
		_dataService.SubmitChanges();
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			foreach (ChangeMemberList changeMemberList2 in msg.ChangeMemberListList)
			{
				_buddyService.SaveOrUpdateUnknownUser(changeMemberList2.Member, changeMemberList2.Name);
			}
			_chatService.AddMessageToShow(_chat, newMsg, addToDB: false);
			_chatService.UpdateChatSummary(_chat);
			_chat.AddDateHeaderAndCheckbox();
			ScrollToRecentMessage();
		});
	}

	private void _socketService_InitChatReplyReceived(object sender, object arg)
	{
		InitChatReply msg = arg as InitChatReply;
		Message savedMsg = _chatService.GetMessage(_chat, msg.MsgID);
		savedMsg.BlockNotificationCount++;
		savedMsg.SessionID = msg.SessionID;
		savedMsg.Time = msg.MsgReceivedTime;
		savedMsg.ActivityState = Message.State.Sent;
		HandleFailedMessage(msg.Result.ResultCode, savedMsg);
		savedMsg.BlockNotificationCount--;
		_dataService.SubmitChanges();
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			ShowSendingError(msg.Result.ResultCode);
			_chat.SortMessage();
			_chatService.GetLastMessage(_chat);
			_chatService.UpdateChatSummary(_chat);
			savedMsg.NotifyPropertyChanged("Time");
			savedMsg.NotifyPropertyChanged("ActivityState");
			_chat.AddDateHeaderAndCheckbox();
		});
	}

	private void ShowSendingError(int ret)
	{
		switch (ret)
		{
		case 6002:
			SplashPopup.Show(_page.LayoutRoot, ResContainer.IDS_CHATON_BODY_BUDDYS_INFORMATION_HAS_CHANGED_RETRY_CHAT_VIA_BUDDY_LIST);
			break;
		case 5009:
			SplashPopup.Show(_page.LayoutRoot, ResContainer.IDS_CHATON_POP_UNABLE_TO_SEND_BUDDY_BLOCKED);
			break;
		case 4002:
			SplashPopup.Show(_page.LayoutRoot, ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
			break;
		}
	}

	private void _socketService_Connected(object sender, SocketEventArgs e)
	{
		OnConnected();
	}

	private void OnConnected()
	{
		IsConnected = true;
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			EnableChatButtons();
		});
	}

	private void EnableChatButtons()
	{
		if (((PhoneApplicationPage)_page).ApplicationBar.Buttons.Count != 4)
		{
			return;
		}
		foreach (object button in ((PhoneApplicationPage)_page).ApplicationBar.Buttons)
		{
			((ApplicationBarIconButton)((button is ApplicationBarIconButton) ? button : null)).IsEnabled = true;
		}
		object obj = ((PhoneApplicationPage)_page).ApplicationBar.MenuItems[0];
		((ApplicationBarMenuItem)((obj is ApplicationBarMenuItem) ? obj : null)).IsEnabled = true;
		if (_isUploading)
		{
			DisableAttachButton();
		}
	}

	private void DisableAttachButton()
	{
		object obj = ((PhoneApplicationPage)_page).ApplicationBar.Buttons[1];
		((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).IsEnabled = false;
	}

	private void EnableAttachButton()
	{
		if (SocketService.Instance.IsConnected)
		{
			object obj = ((PhoneApplicationPage)_page).ApplicationBar.Buttons[1];
			((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).IsEnabled = true;
		}
	}

	internal void AttachFile()
	{
		_attachmentService.SessionID = Chat.SessionID;
		_attachmentService.ClearEventHandler();
		_attachmentService.AttachmentSelectCompleted += attachmentService_AttachmentSelectCompleted;
		PageNavigationService.OpenAttachListPage((PhoneApplicationPage)(object)_page);
	}

	private void attachmentService_AttachmentSelectCompleted(Attachment file)
	{
		_attachmentService.AttachmentSelectCompleted -= attachmentService_AttachmentSelectCompleted;
		switch (file.AttachedMediaType)
		{
		case Attachment.MediaType.PHOTO:
		case Attachment.MediaType.AMS:
		case Attachment.MediaType.CONTACT:
		case Attachment.MediaType.CALENDAR:
		{
			Message message = (_uploadingMsg = AddMediaMessage(file));
			_isUploading = true;
			DisableAttachButton();
			SSMService sSMService = new SSMService();
			sSMService.Tag = message;
			sSMService.UploadFileCompleted += ssmService_UploadFileCompleted;
			sSMService.UploadProgressChanged += ssmService_UploadProgressChanged;
			sSMService.UploadFileAsync(file);
			message.Tag = sSMService;
			break;
		}
		case Attachment.MediaType.LOCATION:
			SendLocation(file as AttachedLocation);
			break;
		}
	}

	private Message AddMediaMessage(Attachment file)
	{
		Message message = new Message();
		string text = string.Empty;
		string text2 = string.Empty;
		switch (file.AttachedMediaType)
		{
		case Attachment.MediaType.PHOTO:
		case Attachment.MediaType.AMS:
			text = "image\n";
			text2 = "jpg\n";
			break;
		case Attachment.MediaType.CALENDAR:
			text = "calendar\n";
			text2 = "VCS\n";
			break;
		case Attachment.MediaType.CONTACT:
			text = "contact\n";
			text2 = "VCF\n";
			break;
		}
		string text3 = text + text2;
		text3 += "dummy\n";
		text3 = text3 + file.FileName + "\n";
		text3 = text3 + RegistrationService.GetUserAccount().Uid + "\n";
		text3 += file.Title;
		message.MediaFilePath = file.FilePath;
		message.Text = text3;
		message.Sender = RegistrationService.GetUserNumber();
		message.NumberID = SocketMessage.CreateMsgID();
		message.ActivityState = Message.State.Uploading;
		message.Type = "media";
		message.SessionID = _chat.SessionID;
		message.Receiver = _chat.Members;
		_chatService.AddMessageToShow(_chat, message);
		_chatService.GetLastMessage(_chat);
		NotificationObject.IsBlockChangedNotification = true;
		_chatService.UpdateChatSummary(_chat);
		NotificationObject.IsBlockChangedNotification = false;
		_dataService.MessageDBSubmitChanges();
		ScrollToRecentMessage();
		return message;
	}

	private void ssmService_UploadFileCompleted(object sender, SSMCompletedEventArgs e)
	{
		Message msg = (sender as SSMService).Tag as Message;
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			if (_isClosing)
			{
				if (msg.ActivityState == Message.State.Uploading)
				{
					msg.ActivityState = Message.State.UploadingFailed;
					msg.ProgressValue = 0;
				}
				else
				{
					msg.ActivityState = Message.State.SendingFailed;
				}
			}
			else if (e == null)
			{
				msg.ActivityState = Message.State.UploadingFailed;
				MessageBox.Show(ResContainer.IDS_CHATON_POP_FAILED_TO_UPLOAD_FILE);
			}
			else
			{
				msg.ActivityState = Message.State.Typed;
			}
			_isUploading = false;
			_uploadingMsg = null;
			EnableAttachButton();
		});
		if (!_isClosing && e != null)
		{
			string empty = string.Empty;
			empty = ((e.BackTransferRequest == null) ? e.Value.ToString() : e.BackTransferRequest.RequestUri.OriginalString);
			string[] array = MakeMediaMessageInfo(empty);
			_chat.IsChanged = true;
			SendMediaMessage(array[0], array[1]);
		}
	}

	private string[] MakeMediaMessageInfo(string uploadResult)
	{
		string[] array = Utility.Split(uploadResult, '?');
		string[] array2 = Utility.Split(array[1], '&');
		string text = string.Empty;
		string text2 = string.Empty;
		string text3 = string.Empty;
		string text4 = Utility.Split(array2[2], '=')[1];
		if (array2[3].Contains("image"))
		{
			text = "image\n";
			text2 = "jpg\n";
			text3 = text4;
		}
		else if (array2[3].Contains("vcard"))
		{
			text = "contact\n";
			text2 = "VCF\n";
			string text5 = Utility.ByteArrayToStr(Utility.FileToByteArray(Chat.SessionID + "\\" + text4));
			vCard_t vCard_t = new vCard_t();
			vCard_t.pEncodedData = text5;
			vCard_t.nEncodedDataLen = text5.Length;
			List<Vitemnode> delTaglist = new List<Vitemnode>();
			vCardDecoder.DecodevCard(vCard_t, delTaglist);
			text3 = vCard_t.N.given + ' ' + vCard_t.N.family;
		}
		else if (array2[3].Contains("vcal"))
		{
			text = "calendar\n";
			text2 = "VCS\n";
			string text6 = Utility.ByteArrayToStr(Utility.FileToByteArray(Chat.SessionID + "\\" + text4));
			vCalendar_t vCalendar_t = new vCalendar_t();
			vCalendar_t.pEncodedData = text6;
			vCalendar_t.nEncodedDataLen = text6.Length;
			vCalDecoder.DecodevCal(vCalendar_t);
			text3 = vCalendar_t.SUMMARY;
		}
		string text7 = text + text2;
		text7 = text7 + array[0] + "\n";
		text7 = text7 + text4 + "\n";
		text7 = text7 + RegistrationService.GetUserAccount().Uid + "\n";
		text7 += text3;
		return new string[2] { text7, text4 };
	}

	private void ssmService_UploadProgressChanged(object sender, SSMCompletedEventArgs e)
	{
		Message message = (sender as SSMService).Tag as Message;
		message.ProgressValue = (int)e.Value;
	}

	private void SendLocation(AttachedLocation location)
	{
		string msgText = "geo\n\n\n\n\n" + location.LocationInfo.Latitude.ToString(CultureInfo.InvariantCulture) + "," + location.LocationInfo.Longitude.ToString(CultureInfo.InvariantCulture) + "\n";
		SendMediaMessage(msgText);
	}

	private void SendMediaMessage(string msgText, string fileName = null)
	{
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			if (fileName == null)
			{
				sendMessage(msgText, MsgType.MEDIA);
			}
			else
			{
				SSMServer serverInfo = SSMService.GetServerInfo();
				Message message = _dataService.FirstOrDefaultMessage((Message c) => !string.IsNullOrEmpty(c.MediaFilePath) && c.MediaFilePath.Contains(fileName));
				message.Text = msgText;
				message.ActivityState = Message.State.Typed;
				message.Time = serverInfo.GetEstimatedServerTime();
				SocketService.Instance.SendChatMsg(message.Text, message.NumberID, MsgType.MEDIA);
			}
		});
	}

	private bool CheckAndRequestNickName(string number)
	{
		Buddy buddy = _buddyService.GetBuddy(number);
		if (buddy == null)
		{
			SocketService.Instance.SendNickNameRequestMsg(number);
			return true;
		}
		return false;
	}

	private void NotifyMessageItemsChanged()
	{
		NotifyPropertyChanged(() => MessageItems);
	}

	internal void OpenChatDetail(Guid id)
	{
		_isClosing = false;
		((FrameworkElement)(object)_page).DataContext = this;
		Chat = _dataService.GetChat(id);
		if (_chat.ChatType == ChatType.SINGLE)
		{
			_page.TitleTextBlock.TextWrapping = TextWrapping.NoWrap;
		}
		_chat.IsDeletionMode = false;
		SocketService.Instance.Chat = _chat;
		SendPictureToShare();
		if (!_chat.IsValidSession.Value)
		{
			SplashPopup.Show(_page.LayoutRoot, ResContainer.IDS_CHATON_BODY_BUDDYS_INFORMATION_HAS_CHANGED_RETRY_CHAT_VIA_BUDDY_LIST);
		}
		_initialUnreadMessagesCount = _chat.UnreadMessageCount;
		_chatService.UpdateChatSummary(_chat);
	}

	private void LoadMessages()
	{
		_chat.ClearMessageItems();
		_chat.LoadMessageItems(isPrev: true);
		UpdateBackgroundTransferedMsg();
		ScrollToRecentMessage();
		NotifyMessageItemsChanged();
	}

	private void SendPictureToShare()
	{
		if (ChatOnService.Instance.StreamToShare != null)
		{
			ChatOnService.Instance.StreamToCrop = ChatOnService.Instance.StreamToShare;
			ChatOnService.Instance.StreamToShare = null;
			((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
			{
				ImageCropPage.CropCompleted += ImageCropPage_CropCompleted;
				PageNavigationService.OpenImageCropPage((PhoneApplicationPage)(object)_page);
			});
		}
	}

	private void ImageCropPage_CropCompleted(object sender, object arg)
	{
		AttachedPhoto file = new AttachedPhoto(arg as WriteableBitmap, Chat.SessionID);
		Message message = AddMediaMessage(file);
		SSMService sSMService = new SSMService();
		sSMService.Tag = message;
		sSMService.UploadFileCompleted += ssmService_UploadFileCompleted;
		sSMService.UploadProgressChanged += ssmService_UploadProgressChanged;
		sSMService.UploadFileAsync(file);
		message.Tag = sSMService;
	}

	private void _bw_DoWork(object sender, DoWorkEventArgs e)
	{
		_bw.DoWork -= _bw_DoWork;
		Thread.Sleep(1000);
		if (!_isClosing)
		{
			SocketService.Instance.Init();
		}
	}

	private void sendMessage(string text, MsgType type)
	{
		_chat.IsChanged = true;
		SSMServer serverInfo = SSMService.GetServerInfo();
		Message message = new Message();
		message.Text = text;
		message.Sender = RegistrationService.GetUserNumber();
		message.NumberID = SocketMessage.CreateMsgID();
		message.ActivityState = Message.State.Typed;
		message.Type = type.ToString().ToLower();
		message.Receiver = _chat.Members;
		message.Time = serverInfo.GetEstimatedServerTime();
		_chatService.AddMessageToShow(_chat, message);
		_dataService.MessageDBSubmitChanges();
		_chatService.GetLastMessage(_chat);
		NotificationObject.IsBlockChangedNotification = true;
		_chatService.UpdateChatSummary(_chat);
		NotificationObject.IsBlockChangedNotification = false;
		ScrollToRecentMessage();
		SocketService.Instance.SendChatMsg(message.Text, message.NumberID, type);
	}

	internal void SendMessage()
	{
		sendMessage(_inputTextMsg, MsgType.TEXT);
	}

	internal void ScrollToRecentMessage()
	{
		NotifyMessageItemsChanged();
		if (MessageItems.Count > 0)
		{
			_currentViewMessage = MessageItems.Last();
			_scrollCmdCount = 2;
		}
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			_page.MessageList.UpdateLayout();
		});
	}

	internal void CloseChat()
	{
		if (!string.IsNullOrEmpty(_chat.SessionID))
		{
			LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
			_page.LayoutRoot.Children.Add(value);
			SocketService.Instance.SendCloseMsg();
		}
		else
		{
			CloseAndShowPivotPage();
		}
	}

	private void CloseAndShowPivotPage()
	{
		_chatService.CloseChat(_chat);
		OnClose();
		JournalEntry val = ((Page)_page).NavigationService.BackStack.FirstOrDefault((JournalEntry c) => c.Source.OriginalString.Contains("PivotPage.xaml"));
		if (val == null)
		{
			PageNavigationService.OpenPivotPage((PhoneApplicationPage)(object)_page);
		}
		else
		{
			Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
		}
	}

	internal void OnClose()
	{
		_isClosing = true;
		_timer.Stop();
		Disconnect();
		if (!_chat.IsChanged)
		{
			_dataService.DeleteChat(_chat);
		}
		else
		{
			_chatService.UpdateChatSummary(_chat);
		}
		_chatService.UpdateTileUnreadCount();
	}

	private void Disconnect()
	{
		SocketService.Instance.Disconnect();
	}

	internal void MoveToTrunk()
	{
		PageNavigationService.OpenTrunkItemList(_chat, (PhoneApplicationPage)(object)_page);
	}

	internal void LoadRemainListItems(bool isPrev)
	{
		if (isPrev)
		{
			if (!_chat.IsRemainLoadingItems())
			{
				return;
			}
		}
		else if (_chatService.IsLastMessageLoaded(_chat))
		{
			return;
		}
		Utility.ShowSystemTrayProgress((PhoneApplicationPage)(object)_page, ResContainer.IDS_CHATON_BODY_LOADING_ING);
		ScrollViewer scrollViewer = null;
		if (VisualTreeHelper.GetChild(_page.MessageList, 0) is FrameworkElement frameworkElement)
		{
			scrollViewer = (ScrollViewer)frameworkElement.FindName("ScrollViewer");
		}
		if (scrollViewer != null)
		{
			scrollViewer.UpdateLayout();
			_ = scrollViewer.ScrollableHeight;
		}
		if (_chat.MessageItems.Count > 0)
		{
			if (isPrev)
			{
				_currentViewMessage = _chat.MessageItems.First();
			}
			else
			{
				_currentViewMessage = _chat.MessageItems.Last();
			}
		}
		_chat.LoadMessageItems(isPrev);
		_scrollCmdCount = 2;
		_page.MessageList.UpdateLayout();
		Utility.HideSystemTrayProgress((PhoneApplicationPage)(object)_page, HideProgressOnly: true);
	}

	internal void ScrollToCurrentView(double oldValue, double newValue)
	{
		if (_scrollCmdCount == 0)
		{
			return;
		}
		ScrollViewer scrollViewer = (ScrollViewer)(VisualTreeHelper.GetChild(_page.MessageList, 0) as FrameworkElement).FindName("ScrollViewer");
		double num = 0.0;
		if (_currentViewMessage == MessageItems.LastOrDefault())
		{
			num = newValue;
		}
		else
		{
			foreach (UIElement child in _page.ListPanel.Children)
			{
				Message message = (child as FrameworkElement).DataContext as Message;
				num += child.DesiredSize.Height;
				if (message == _currentViewMessage)
				{
					num -= 300.0;
					break;
				}
			}
		}
		if (num > 0.0)
		{
			scrollViewer.ScrollToVerticalOffset(num);
		}
		_scrollCmdCount--;
	}

	internal void InviteBuddies()
	{
		int num = ChatService.MAX_CHAT_MEMBERS;
		if (_chat.ChatType == ChatType.BROADCAST)
		{
			num = ChatService.MAX_BROADCAST_MEMBERS;
		}
		if (num - _chat.MemberList.Count - 1 == 0)
		{
			string iDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_REACHED = ResContainer.IDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_REACHED;
			iDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_REACHED = iDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_REACHED.Replace("%d", "{0:d}");
			iDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_REACHED = string.Format(iDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_REACHED, num - 1);
			MessageBox.Show(iDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_REACHED);
		}
		else
		{
			SelectBuddyPage.SelectionCompleted += SelectBuddyPage_SelectionCompleted;
			SelectBuddyPage.ExceptionNumbers = _chat.MemberList;
			SelectBuddyPage.SelectionCountLimit = num - _chat.MemberList.Count - 1;
			PageNavigationService.OpenSelectBuddyPage((PhoneApplicationPage)(object)_page);
		}
	}

	private void SelectBuddyPage_SelectionCompleted(object sender, object arg)
	{
		_invitingBuddies.Clear();
		SelectBuddyPage.SelectionCompleted -= SelectBuddyPage_SelectionCompleted;
		ObservableCollection<BuddySummary> observableCollection = arg as ObservableCollection<BuddySummary>;
		if (observableCollection.Count == 0)
		{
			return;
		}
		List<string> list = new List<string>();
		foreach (BuddySummary item in observableCollection)
		{
			list.Add(item.Buddy.PhoneNumber);
			_invitingBuddies.Add(item.Buddy);
		}
		if (_chat.ChatType == ChatType.SINGLE)
		{
			Disconnect();
			list.Add(_chat.Sender);
			string member = string.Join(",", list);
			string userNumber = RegistrationService.GetUserNumber();
			ChatService chatService = new ChatService(_dataService, _buddyService, userNumber);
			Chat chat = chatService.StartChat(list[0], member, ChatType.GROUP);
			PageNavigationService.OpenChatDetailPage(chat, (PhoneApplicationPage)(object)_page);
			LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
			_page.LayoutRoot.Children.Add(value);
			return;
		}
		if (_chat.IsChanged)
		{
			SocketService.Instance.SendInviteChatRequestMsg(SocketMessage.CreateMsgID(), list);
		}
		else
		{
			foreach (Buddy invitingBuddy in _invitingBuddies)
			{
				_chatService.EnterMember(_chat, invitingBuddy.PhoneNumber);
			}
			_chatService.UpdateChatSummary(_chat);
		}
		Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
	}

	internal void OnClickMessage(Message msg)
	{
		//IL_00cb: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
		//IL_0208: Unknown result type (might be due to invalid IL or missing references)
		//IL_020f: Expected O, but got Unknown
		string text = msg.Text;
		string[] array = Utility.Split(text, '\n');
		if (!string.IsNullOrEmpty(msg.MediaFilePath))
		{
			if (msg.Sender == RegistrationService.GetUserNumber() && !msg.MediaFilePath.Contains('\\'))
			{
				msg.MediaFilePath = Chat.SessionID + "\\" + msg.MediaFilePath;
			}
			if (array[0] == "image")
			{
				if (AMSDecoder.ContainsAMSMessage(msg.MediaFilePath))
				{
					PageNavigationService.OpenAMSPreviewPage((PhoneApplicationPage)(object)_page, msg.MediaFilePath, autoPlay: false);
				}
				else
				{
					PageNavigationService.OpenImageViewerPage((PhoneApplicationPage)(object)_page, "?source=" + msg.MediaFilePath);
				}
			}
			else if (array[0] == "video" || array[0] == "audio")
			{
				MediaPlayerLauncher val = new MediaPlayerLauncher();
				val.Media = new Uri(msg.MediaFilePath, UriKind.Relative);
				val.Location = (MediaLocationType)2;
				val.Controls = (MediaPlaybackControls)3;
				val.Orientation = (MediaPlayerOrientation)1;
				val.Show();
			}
			else if (array[0] == "contact")
			{
				SaveContact(msg.MediaFilePath, array[5]);
			}
			else if (array[0] == "calendar")
			{
				ShowCalendarDetail(msg.MediaFilePath);
			}
		}
		else if (array[0] == "video" || array[0] == "audio" || array[0] == "image" || array[0] == "contact" || array[0] == "calendar")
		{
			if (!msg.IsDownloading)
			{
				string server = array[2];
				string fileName = array[3];
				string buddyUid = array[4];
				SSMService sSMService = new SSMService();
				sSMService.Tag = msg;
				sSMService.DownloadFileCompleted += ssmService_DownloadFileCompleted;
				sSMService.DownloadProgressChanged += ssmService_DownloadProgressChanged;
				sSMService.DownloadFileUsingBackground(server, fileName, buddyUid);
				msg.IsDownloading = true;
				msg.Tag = sSMService;
			}
		}
		else if (array[0] == "geo")
		{
			try
			{
				string[] array2 = Utility.Split(array[5]);
				BingMapsTask val2 = new BingMapsTask();
				val2.Center = new GeoCoordinate(double.Parse(array2[0], CultureInfo.InvariantCulture), double.Parse(array2[1], CultureInfo.InvariantCulture));
				val2.ZoomLevel = 15.0;
				val2.Show();
			}
			catch (Exception)
			{
			}
		}
	}

	private void ssmService_DownloadProgressChanged(object sender, SSMCompletedEventArgs e)
	{
		Message message = (sender as SSMService).Tag as Message;
		if (!message.IsDownloading)
		{
			message.IsDownloading = true;
		}
		message.ProgressValue = (int)e.Value;
	}

	private void ssmService_DownloadFileCompleted(object sender, SSMCompletedEventArgs e)
	{
		Message message = (sender as SSMService).Tag as Message;
		string text = message.Text;
		string[] array = Utility.Split(text, '\n');
		message.IsDownloading = false;
		if (!(array[0] == "video") && !(array[0] == "audio") && !(array[0] == "image") && !(array[0] == "contact") && !(array[0] == "calendar"))
		{
			return;
		}
		string text2 = array[3];
		string sessionID = message.Chat.SessionID;
		message.MediaFilePath = sessionID + "\\" + text2;
		_dataService.MessageDBSubmitChanges();
		IsolatedStorageFile userStoreForApplication = IsolatedStorageFile.GetUserStoreForApplication();
		if (!userStoreForApplication.DirectoryExists(sessionID))
		{
			userStoreForApplication.CreateDirectory(sessionID);
		}
		if (e.BackTransferRequest != null)
		{
			if (userStoreForApplication.FileExists(e.BackTransferRequest.DownloadLocation.OriginalString))
			{
				if (userStoreForApplication.FileExists(message.MediaFilePath))
				{
					userStoreForApplication.DeleteFile(message.MediaFilePath);
				}
				userStoreForApplication.MoveFile(e.BackTransferRequest.DownloadLocation.OriginalString, message.MediaFilePath);
			}
		}
		else
		{
			IsolatedStorageFileStream isolatedStorageFileStream = userStoreForApplication.CreateFile(message.MediaFilePath);
			(e.Value as Stream).CopyTo(isolatedStorageFileStream);
			isolatedStorageFileStream.Close();
			userStoreForApplication.Dispose();
			(e.Value as Stream).Close();
		}
	}

	internal void SaveContact(string filePath, string name)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		SaveContactTask val = new SaveContactTask();
		((ChooserBase<SaveContactResult>)(object)val).Completed += saveContactTask_Completed;
		string text = Utility.ByteArrayToStr(Utility.FileToByteArray(filePath));
		vCard_t vCard_t = new vCard_t();
		vCard_t.pEncodedData = text;
		vCard_t.nEncodedDataLen = text.Length;
		List<Vitemnode> delTaglist = new List<Vitemnode>();
		vCardDecoder.DecodevCard(vCard_t, delTaglist);
		try
		{
			if (name.Length > 0)
			{
				int num = name.LastIndexOf(' ');
				if (num > 0)
				{
					val.FirstName = name.Substring(0, num);
					if (num < name.Length - 1)
					{
						val.LastName = name.Substring(num + 1);
					}
					else
					{
						val.LastName = string.Empty;
					}
				}
				else
				{
					val.FirstName = name;
				}
			}
			else
			{
				val.FirstName = string.Empty;
				val.LastName = string.Empty;
			}
			val.PersonalEmail = vCard_t.EMAILList[0].email;
			val.WorkPhone = vCard_t.TELList[1].number;
			val.HomePhone = vCard_t.TELList[2].number;
			val.MobilePhone = vCard_t.TELList[3].number;
			((ChooserBase<SaveContactResult>)(object)val).Show();
		}
		catch (InvalidOperationException)
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ERROR_OCCURRED_TRY_AGAIN);
		}
	}

	private void saveContactTask_Completed(object sender, SaveContactResult e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_0019: Expected I4, but got Unknown
		TaskResult taskResult = ((TaskEventArgs)e).TaskResult;
		switch ((int)taskResult)
		{
		case 1:
			MessageBox.Show(ResContainer.IDS_CHATON_POP_CONTACT_ADDED);
			break;
		case 0:
			MessageBox.Show(ResContainer.IDS_CHATON_POP_FAILED_TO_SAVE_CONTACT);
			break;
		case 2:
			break;
		}
	}

	internal void ShowCalendarDetail(string filePath)
	{
		PageNavigationService.OpenAttachCalendarDetailPage((PhoneApplicationPage)(object)_page, filePath);
	}

	internal void OnCancelMessage(Message msg)
	{
		SSMService sSMService = msg.Tag as SSMService;
		sSMService.CancelWebClientOperation(Utility.Split(msg.Text, '\n')[3]);
		msg.IsDownloading = false;
		msg.ProgressValue = 0;
	}

	internal void OpenBuddyProfile(string number)
	{
		Buddy buddy = _buddyService.GetBuddy(number);
		if (buddy != null)
		{
			if (buddy.IsBlocked)
			{
				SplashPopup.Show(_page.LayoutRoot, ResContainer.IDS_CHATON_POP_BUDDY_BLOCKED_TO_UNBLOCK_GO_TO_SETTINGS_BLOCK_LIST);
			}
			else
			{
				PageNavigationService.OpenBuddyProfilePage((PhoneApplicationPage)(object)_page, number);
			}
		}
		else
		{
			AddUnknownBuddyPage.BuddyAdded += AddUnknownBuddyPage_BuddyAdded;
			PageNavigationService.OpenAddUnknownBuddyPage((PhoneApplicationPage)(object)_page, number);
		}
	}

	private void AddUnknownBuddyPage_BuddyAdded(object sender, object arg)
	{
		Buddy buddy = arg as Buddy;
		foreach (Message messageItem in _chat.MessageItems)
		{
			if (buddy.PhoneNumber == messageItem.Sender)
			{
				messageItem.NotifySenderUpdated();
			}
		}
		_chatService.UpdateChatSummary(_chat);
	}

	internal void OpenMessageItemContextMenu(FrameworkElement element)
	{
		if (element.DataContext is Message message)
		{
			LightContextMenu lightContextMenu = new LightContextMenu();
			if (message.Type == "text")
			{
				LightMenuItem lightMenuItem = new LightMenuItem(ResContainer.IDS_CHATON_OPT_COPY);
				lightMenuItem.Tag = message;
				lightMenuItem.OnExecute += copy_OnExecute;
				lightContextMenu.MenuItems.Add(lightMenuItem);
			}
			LightMenuItem lightMenuItem2 = new LightMenuItem(ResContainer.IDS_CHATON_OPT_DELETE_ABB);
			lightMenuItem2.Tag = message;
			lightMenuItem2.OnExecute += delete_OnExecute;
			lightContextMenu.MenuItems.Add(lightMenuItem2);
			lightContextMenu.Open((PhoneApplicationPage)(object)_page, _page.LayoutRoot, element);
		}
	}

	private void delete_OnExecute(object sender, EventArgs e)
	{
		if (MessageBoxResult.OK == MessageBox.Show(ResContainer.IDS_CHATON_POP_DELETE_Q, ResContainer.IDS_CHATON_BODY_DELETE_MESSAGE, MessageBoxButton.OKCancel))
		{
			Message msg = (sender as LightMenuItem).Tag as Message;
			DeleteMessage(msg);
		}
	}

	private void copy_OnExecute(object sender, EventArgs e)
	{
		Message message = (sender as LightMenuItem).Tag as Message;
		Clipboard.SetText(message.Text);
	}

	internal void OpenChatProfilePage()
	{
		if (_chat.ChatType != ChatType.SINGLE)
		{
			PageNavigationService.OpenChatProfilePage(_chat, (PhoneApplicationPage)(object)_page);
		}
	}

	internal void ToggleDeletionMode()
	{
		_chat.IsDeletionMode = !_chat.IsDeletionMode;
		_chat.AddDateHeaderAndCheckbox();
		if (_chat.IsDeletionMode)
		{
			_chatService.SelectAllMessages(_chat, isSelectAll: false);
			_page.AddDeleteApplicationBarButtons();
		}
		else
		{
			_page.AddChatApplicationBarButtons();
		}
	}

	internal void DeleteSelectedMessages()
	{
		_chatService.DeleteSelectedMessages(_chat);
		ToggleDeletionMode();
	}

	internal void DeleteMessage(Message msg)
	{
		_chatService.DeleteMessage(_chat, msg);
	}

	internal void SelectAllMessages()
	{
		_isSelectAll = !_isSelectAll;
		_isSelectReceived = (_isSelectSent = _isSelectAll);
		_chatService.SelectAllMessages(_chat, _isSelectAll);
		_page.EnableDoneButton(_chatService.IsEnableDeleteMessage(_chat));
	}

	internal void SelectReceivedMessages()
	{
		_isSelectReceived = !_isSelectReceived;
		_isSelectAll = _isSelectReceived && _isSelectSent;
		_chatService.SelectReceivedMessages(_chat, _isSelectReceived);
		_chatService.UpdateDateHeaderCheckBox(_chat);
		_page.EnableDoneButton(_chatService.IsEnableDeleteMessage(_chat));
	}

	internal void SelectSentMessages()
	{
		_isSelectSent = !_isSelectSent;
		_isSelectAll = _isSelectReceived && _isSelectSent;
		_chatService.SelectSentMessages(_chat, _isSelectSent);
		_chatService.UpdateDateHeaderCheckBox(_chat);
		_page.EnableDoneButton(_chatService.IsEnableDeleteMessage(_chat));
	}

	internal void OnClickDateHeaderCheckBox(Message msg)
	{
		_chatService.UpdateDateHeaderCheckBox(_chat, msg);
		_page.EnableDoneButton(_chatService.IsEnableDeleteMessage(_chat));
	}

	internal void OnClickCheckBox(Message clickedMessage)
	{
		_chatService.UpdateDateHeaderCheckBox(_chat);
		_page.EnableDoneButton(_chatService.IsEnableDeleteMessage(_chat));
	}

	internal void OnCancelUploadFile(Message msg)
	{
		if (msg.Tag != null)
		{
			(msg.Tag as SSMService).CancelUploadAsync(Utility.Split(msg.Text, '\n')[3]);
		}
		msg.ActivityState = Message.State.UploadingFailed;
		EnableAttachButton();
	}

	internal void ReSendMessage(Message msg)
	{
		if (msg.ActivityState == Message.State.UploadingFailed)
		{
			msg.ActivityState = Message.State.Uploading;
			DisableAttachButton();
			SSMService sSMService = msg.Tag as SSMService;
			if (sSMService == null)
			{
				sSMService = (SSMService)(msg.Tag = new SSMService());
			}
			sSMService.Tag = msg;
			sSMService.UploadFileCompleted += ssmService_UploadFileCompleted;
			sSMService.UploadProgressChanged += ssmService_UploadProgressChanged;
			sSMService.ResumeUploadFileAsync();
		}
		else if (msg.ActivityState == Message.State.SendingFailed)
		{
			msg.ActivityState = Message.State.Typed;
			SocketService.Instance.SendChatMsg(msg.Text, msg.NumberID, (!(msg.Type == "text")) ? MsgType.MEDIA : MsgType.TEXT);
		}
	}

	internal void OnNavigatedTo(bool isFirst)
	{
		if (!SocketService.Instance.IsConnected)
		{
			_chatService.SetFailedMessage(_chat, _uploadingMsg, isBlockNotify: false, out var isUploadingFailed);
			if (isUploadingFailed)
			{
				_isUploading = false;
			}
			_uploadingMsg = null;
			Connect(isFirst);
		}
		else
		{
			OnConnected();
		}
	}

	internal void Connect(bool isFirst = false)
	{
		if (SocketService.Instance.IsConnected)
		{
			return;
		}
		if (isFirst)
		{
			((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
			{
				LoadMessages();
			});
			_bw.DoWork += _bw_DoWork;
			_bw.RunWorkerAsync();
		}
		else
		{
			SocketService.Instance.Init();
		}
	}

	internal void UpdateBackgroundImage()
	{
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Invalid comparison between Unknown and I4
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_001c: Invalid comparison between Unknown and I4
		if ((int)((PhoneApplicationPage)_page).Orientation == 18 || (int)((PhoneApplicationPage)_page).Orientation == 34)
		{
			if (SettingService.GetBGType() == 0)
			{
				_page.BG.Stretch = Stretch.Fill;
				return;
			}
			_page.BG.Stretch = Stretch.None;
			BackgroundImage = SettingService.GetSelectedBG(isLandscape: true);
		}
		else
		{
			_page.BG.Stretch = Stretch.None;
			BackgroundImage = SettingService.GetSelectedBG();
		}
	}

	internal void UpdateBackgroundTransferedMsg()
	{
		bool flag = false;
		if (BackgroundFileService.RequestList == null || BackgroundFileService.RequestList.Count <= 0)
		{
			return;
		}
		for (int num = BackgroundFileService.RequestList.Count - 1; num >= 0; num--)
		{
			BackgroundFileRequestInfo backgroundFileRequestInfo = BackgroundFileService.RequestList[num];
			if (backgroundFileRequestInfo.Status != BackgroundFileRequestInfo.RequestStatus.Canceled && backgroundFileRequestInfo.Status != BackgroundFileRequestInfo.RequestStatus.Failed && backgroundFileRequestInfo.Status != BackgroundFileRequestInfo.RequestStatus.Updated)
			{
				foreach (Message message in _chat.Messages)
				{
					if (!(backgroundFileRequestInfo.MessagID == message.MessageID))
					{
						continue;
					}
					if (backgroundFileRequestInfo.Status == BackgroundFileRequestInfo.RequestStatus.Transferring)
					{
						SSMService sSMService = (SSMService)(message.Tag = new SSMService());
						sSMService.Tag = message;
						if (backgroundFileRequestInfo.Mode == BackgroundFileRequestInfo.RequestMode.DownloadMode)
						{
							sSMService.DownloadFileCompleted += ssmService_DownloadFileCompleted;
							sSMService.DownloadProgressChanged += ssmService_DownloadProgressChanged;
						}
						sSMService.ResumeFileTransferEventHandler();
						break;
					}
					if (backgroundFileRequestInfo.Mode == BackgroundFileRequestInfo.RequestMode.DownloadMode)
					{
						string[] array = Utility.Split(message.Text, '\n');
						message.IsDownloading = false;
						if (array[0] == "video" || array[0] == "audio" || array[0] == "image" || array[0] == "contact" || array[0] == "calendar")
						{
							string text = array[3];
							string sessionID = message.Chat.SessionID;
							message.MediaFilePath = sessionID + "\\" + text;
						}
					}
					BackgroundFileService.RequestList.RemoveAt(num);
					flag = true;
					break;
				}
			}
		}
		if (flag)
		{
			_dataService.MessageDBSubmitChanges();
			BackgroundFileService.SaveRequestList();
		}
	}

	internal void OnPushReceived(string senderID, string sessionID, ChatType msgChatType)
	{
		if (_chat.ChatType != ChatType.BROADCAST)
		{
			if (msgChatType == ChatType.BROADCAST && _chat.ChatType == ChatType.SINGLE && senderID == _chat.Sender)
			{
				SocketService.Instance.SendAllowChatRequestMsg();
			}
			else if (!(_chat.SessionID != sessionID))
			{
				SocketService.Instance.SendAllowChatRequestMsg();
			}
		}
	}
}
