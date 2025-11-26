using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.Linq;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Queue;
using ChatOn.Services;
using com.sec.ssm.common;
using vitemapi;
using Windows.ApplicationModel.Contacts;
using Windows.ApplicationModel.DataTransfer;
using Windows.Foundation;
using Windows.Networking.Sockets;
using Windows.Storage;
using Windows.Storage.FileProperties;
using Windows.System;
using Windows.UI;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

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

	private static List<Buddy> _invitingBuddies;

	private Visibility _emoticonChooserVisibiliey;

	private BitmapImage _backgroundImage;

	private bool _isSelectAll;

	private bool _isSelectReceived;

	private bool _isSelectSent;

	private DispatcherTimer _timer;

	private DispatcherTimer _timerCheckButton;

	private int _initialUnreadMessagesCount;

	private bool _isFirst = true;

	private Message _activeMsg;

	private bool Connecting;

	private List<MessageNotificationInfo> _messagePropertyNotiList = new List<MessageNotificationInfo>();

	private List<MessageNotificationInfo> _removemessagePropertyNotiList = new List<MessageNotificationInfo>();

	private bool _isClosing;

	private bool _isConnected;

	private Message _reservedMsg;

	private MsgType _reservedType;

	private Message msgTemp = new Message();

	private long _scrollCmdTick;

	private long _scrollCmdCount;

	private Visibility _appBarVisibility = (Visibility)1;

	private UnknownUser _buddy;

	private string _unknownMessage = "";

	private Visibility _unknownMessageVisibility = (Visibility)1;

	private IAsyncOperation<IUICommand> asyncCommand;

	private Visibility _messagePreviewVisibility = (Visibility)1;

	private Message _lastMessage;

	private bool _shownAlertMessage;

	public bool IsDisconnectedByRequest;

	public string title = "";

	private Visibility _loadingControlVisibilty = (Visibility)1;

	public double ScrollVerticalOffset;

	public double ScrollScrollableHeight;

	public double HeaderHeight;

	public double PositionHeight;

	public double FooterHeight;

	private Message _LastShownMessage;

	private bool _AllowSeeMessageList;

	private int _newTrunkCommentCount;

	private bool _isContextMenuDisabled;

	private double _verticalOffset;

	private double _scrollableHeight;

	private DispatcherTimer delayLoadTimer;

	private int delayLoadTimerCounter;

	private static SolidColorBrush colorTransparent = new SolidColorBrush(Colors.Transparent);

	private static SolidColorBrush colorOrange = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));

	public Visibility LoadingControlVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _loadingControlVisibilty;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_loadingControlVisibilty = value;
			NotifyPropertyChanged(() => LoadingControlVisibility);
		}
	}

	public Visibility MessagePreviewVisibility
	{
		get
		{
			//IL_0045: Unknown result type (might be due to invalid IL or missing references)
			if (IsBottomChatRoom())
			{
				return (Visibility)1;
			}
			if (IsOnBottomPage)
			{
				return (Visibility)1;
			}
			if (LastMessage == null)
			{
				return (Visibility)1;
			}
			if (LastMessage.Sender != null && LastMessage.Sender == RegistrationService.ChatOnID)
			{
				return (Visibility)1;
			}
			return _messagePreviewVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_messagePreviewVisibility = value;
			NotifyPropertyChanged(() => MessagePreviewVisibility);
		}
	}

	public Message LastMessage
	{
		get
		{
			if (SocketService.Instance == null)
			{
				MessagePreviewVisibility = (Visibility)1;
				return null;
			}
			if (SocketService.Instance != null && SocketService.Instance.Chat == null)
			{
				MessagePreviewVisibility = (Visibility)1;
				return null;
			}
			if (SocketService.Instance != null && SocketService.Instance.Chat != null)
			{
				Message message = (from x in SocketService.Instance.Chat.MessageItems
					where x.Type != "noti" && (x.ActivityState == Message.State.Sent || x.ActivityState == Message.State.Received)
					orderby x.Time descending
					select x).FirstOrDefault();
				if (message == null)
				{
					MessagePreviewVisibility = (Visibility)1;
					return null;
				}
				if (message != null && message.Sender == RegistrationService.ChatOnID)
				{
					MessagePreviewVisibility = (Visibility)1;
					return null;
				}
				if (message.HasShownPreview)
				{
					MessagePreviewVisibility = (Visibility)1;
					return null;
				}
				_LastShownMessage = message;
				return message;
			}
			MessagePreviewVisibility = (Visibility)1;
			return null;
		}
	}

	public string UnknownMessage
	{
		get
		{
			return _unknownMessage;
		}
		set
		{
			_unknownMessage = value;
			NotifyPropertyChanged(() => UnknownMessage);
		}
	}

	public Visibility UnknownMessageVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _unknownMessageVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_unknownMessageVisibility = value;
			NotifyPropertyChanged(() => UnknownMessageVisibility);
		}
	}

	public UnknownUser UnknownBuddy
	{
		get
		{
			return _buddy;
		}
		set
		{
			_buddy = value;
			NotifyPropertyChanged(() => UnknownBuddy);
		}
	}

	public bool IsConnected
	{
		get
		{
			return _isConnected;
		}
		set
		{
			_isConnected = value;
			NotifyPropertyChanged(() => IsConnected);
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

	public bool AllowSeeMessageList
	{
		get
		{
			return _AllowSeeMessageList;
		}
		set
		{
			_AllowSeeMessageList = true;
			NotifyPropertyChanged("MessageItems");
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

	public Visibility TextBoxMessage { get; set; }

	public Visibility EmoticonChooserVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _emoticonChooserVisibiliey;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_emoticonChooserVisibiliey = value;
			NotifyPropertyChanged(() => EmoticonChooserVisibility);
		}
	}

	public Visibility AppBarVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _appBarVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_appBarVisibility = value;
			NotifyPropertyChanged("");
		}
	}

	public int NewTrunkCommentCount
	{
		get
		{
			return _newTrunkCommentCount;
		}
		set
		{
			_newTrunkCommentCount = value;
			NotifyPropertyChanged(() => NewTrunkCommentCount);
		}
	}

	public bool IsEnableToChat
	{
		get
		{
			if (_chat == null)
			{
				return false;
			}
			if (SocketService.Instance.IsConnected)
			{
				if (_chat.IsBoradcastChat())
				{
					return true;
				}
				if (string.IsNullOrEmpty(_chat.SessionID) && SocketService.Instance.IsHasInitChat)
				{
					return false;
				}
				return true;
			}
			return false;
		}
	}

	public bool IsIntermediate { get; set; }

	public bool IsScrollTop { get; set; }

	public double VerticalOffset
	{
		get
		{
			return _verticalOffset;
		}
		set
		{
			_verticalOffset = value;
			NotifyPropertyChanged(() => VerticalOffset);
			NotifyPropertyChanged(() => IsOnBottomPage);
		}
	}

	public double ScrollableHeight
	{
		get
		{
			return _scrollableHeight;
		}
		set
		{
			_scrollableHeight = value;
			NotifyPropertyChanged(() => ScrollableHeight);
			NotifyPropertyChanged(() => IsOnBottomPage);
		}
	}

	public double ExtentHeight { get; set; }

	public bool IsOnBottomPage => Math.Abs(ScrollableHeight - VerticalOffset) <= 0.0;

	public Visibility ShowErrorMessageVisibility { get; set; }

	public string ErrorChatDetailMessage { get; set; }

	public void NotifyMessagePreview()
	{
		NotifyPropertyChanged(() => IsOnBottomPage);
		NotifyPropertyChanged(() => MessagePreviewVisibility);
	}

	public unsafe ChatDetailPageViewModel(ChatDetailPage page)
	{
		//IL_002a: Unknown result type (might be due to invalid IL or missing references)
		//IL_003c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_0055: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ef: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fb: Unknown result type (might be due to invalid IL or missing references)
		//IL_0105: Expected O, but got Unknown
		//IL_014f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0159: Expected O, but got Unknown
		_page = page;
		_invitingBuddies = new List<Buddy>();
		_regService = new RegistrationService();
		_ssmService = new SSMService();
		_dataService = new DataService();
		_msgService = new MessageService(_dataService, _ssmService);
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_ssmService, _dataService, _buddyService, RegistrationService.ChatOnID);
		_attachmentService = AttachmentService.Instance;
		_emoticonChooserVisibiliey = (Visibility)1;
		UpdateStyle();
		_timer = new DispatcherTimer();
		_timer.put_Interval(TimeSpan.FromSeconds(40.0));
		DispatcherTimer timer = _timer;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(timer, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(timer, (nint)__ldftn(DispatcherTimer.remove_Tick)), _timer_Tick);
		delayLoadTimer = new DispatcherTimer();
		delayLoadTimer.put_Interval(new TimeSpan(0, 0, 0, 0, 500));
		DispatcherTimer val = delayLoadTimer;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(val, (nint)__ldftn(DispatcherTimer.remove_Tick)), delayLoadTimer_Tick);
	}

	private void MessageItems_CollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
	{
		_page.OnCollectionChanged(e);
	}

	private async void delayLoadTimer_Tick(object sender, object e)
	{
		delayLoadTimerCounter++;
		_page.HideProgress();
		if (delayLoadTimerCounter < 6)
		{
			if (delayLoadTimerCounter == 1)
			{
				AllowSeeMessageList = true;
			}
			return;
		}
		delayLoadTimer.Stop();
		if (Chat == null)
		{
			return;
		}
		if (Chat.IsGroupChat())
		{
			await _chatService.UpdateGroupChatProfileImageUrl(_chat);
		}
		else if (_chat.IsSingleChat() && _chat.SingleChatBuddy != null)
		{
			try
			{
				await _chatService.UpdateChatProfileImageAsync(_chat);
			}
			catch
			{
			}
		}
		if (_chat != null && _chat.PrevMsgStatus == Chat.PrevMsgLoadingStatus.InitialLoading)
		{
			if (_chat != null && _chat.ChatType == ChatType.BROADCAST)
			{
				return;
			}
			if (!string.IsNullOrEmpty(_chat.SessionID))
			{
				LoadingControlVisibility = (Visibility)0;
				try
				{
					await _chatService.GetAllMessageAsync(_chat, _chat.SessionID, "0", "10");
				}
				catch
				{
				}
				LoadingControlVisibility = (Visibility)1;
				ScrollToRecentMessage();
			}
			else
			{
				_chat.PrevMsgStatus = Chat.PrevMsgLoadingStatus.None;
			}
		}
		if (Chat != null && Chat.ChatType == ChatType.BROADCAST)
		{
			await PivotPage.ActiveInstance.ViewModel.GetUnreadMessage();
		}
		await PivotPage.ActiveInstance.ViewModel.UpdateTrunkList();
	}

	private void InitConnection()
	{
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
		if (_chat != null)
		{
			SocketService.Instance.Chat = _chat;
			if (!_chat.IsValidSession)
			{
				_page.ShowWarning();
			}
			UpdateTrunkUnreadCount(_chat);
		}
	}

	private void UpdateTrunkUnreadCount()
	{
		NewTrunkCommentCount = _chatService.UpdateTrunkUnreadCount();
	}

	private void UpdateTrunkUnreadCount(Chat chat)
	{
		NewTrunkCommentCount = _chatService.UpdateTrunkUnreadCount(chat);
		NotifyPropertyChanged(() => NewTrunkCommentCount);
	}

	private void Instance_AllowChatReplyReceived(object sender, object arg)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_002d: Expected O, but got Unknown
		DispatchedHandler val = null;
		AllowChatReply allowChatReply = null;
		if (!(arg is AllowChatReply allowChatReply2))
		{
			return;
		}
		CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
		if (val == null)
		{
			val = (DispatchedHandler)delegate
			{
				_page.HideProgress();
				NotifyPropertyChanged(() => IsEnableToChat);
			};
		}
		dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		if (allowChatReply2.Result.ResultCode == 3006)
		{
			if (asyncCommand != null)
			{
				((IAsyncInfo)asyncCommand).Cancel();
			}
			CloseChatFromOtherDevice(_chat);
			return;
		}
		if (allowChatReply2.Result.ResultCode == 7005)
		{
			ShowMappingErrorChatReplyReceived(allowChatReply2.Result.ResultCode);
		}
		if (allowChatReply2.Result.ResultCode == 7003)
		{
			_chat.LastMergedTimeStamp = allowChatReply2.Result.SessionMergeResult.LastSessionMergeTimestamp;
		}
		else if (allowChatReply2.Result.ResultCode == 7002)
		{
			_chat.SessionID = allowChatReply2.Result.SessionMergeResult.TransitedSessionId;
		}
		if (_isFirst)
		{
			_isFirst = false;
		}
	}

	private void _timer_Tick(object sender, object e)
	{
		if (!SocketService.Instance.DisconnectRequested || !SocketService.Instance.IsConnected)
		{
			if (SocketService.Instance.IsConnected)
			{
				Connecting = false;
				_timer.Stop();
			}
			else
			{
				Connect();
			}
		}
	}

	private void _socketService_OnSocketError(object sender, object arg)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			Exception ex = arg as Exception;
			SocketErrorStatus val = (SocketErrorStatus)0;
			if (ex != null)
			{
				val = SocketError.GetStatus(ex.HResult);
				if ((int)val != 1 && LoadingIndicator.ActiveIndicator != null)
				{
					LoadingIndicator.StopLoading();
				}
			}
			_chatService.SetFailedMessage(_chat, null, isBlockNotify: true);
			_chatService.NotifyFailedMessages(_chat);
			IsConnected = false;
			Connecting = false;
			if (!IsDisconnectedByRequest)
			{
				if (!SocketService.Instance.IsConnected && (int)val != 1)
				{
					Connect();
				}
				_timer.Start();
			}
			else
			{
				_timer.Stop();
			}
		});
	}

	private void _socketService_InviteChatReplyReceived(object sender, object arg)
	{
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		InviteChatReply msg = arg as InviteChatReply;
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			ShowMappingErrorChatReplyReceived(msg.Result.ResultCode);
			if (_chat.ChatType != ChatType.BROADCAST || msg.Result.ResultCode != 5005)
			{
				SetChatDetailErrorMessage(msg.Result.ResultCode);
			}
			Message message = new Message
			{
				Type = "noti"
			};
			if (msg.MsgReceivedTime == 0)
			{
				message.Time = Utility.GetTimeStamp();
			}
			else
			{
				message.Time = msg.MsgReceivedTime;
			}
			message.NumberID = msg.MsgID;
			message.ActivityState = Message.State.Received;
			foreach (Buddy invitingBuddy in _invitingBuddies)
			{
				object text = message.Text;
				message.Text = string.Concat(text, ChangeStatus.ENTER.ToString(), ',', invitingBuddy.PhoneNumber, ',', invitingBuddy.Name, '\n');
				_chatService.EnterMember(_chat, invitingBuddy.PhoneNumber);
			}
			BuddyGroup buddyGroup = _dataService.BuddyGroups.FirstOrDefault((BuddyGroup c) => c.DirectChatID == _chat.ChatID);
			if (buddyGroup != null)
			{
				buddyGroup.DirectChatID = Guid.Empty;
				_dataService.GroupDBSubmitChanges();
			}
			_invitingBuddies.Clear();
			_chatService.AddMessageToShow(_chat, message);
			_chatService.UpdateChatSummary(_chat);
			_chat.AddDateHeaderAndCheckbox();
			ScrollToRecentMessage();
			_dataService.MessageDBSubmitChanges();
			_dataService.ChatDBSubmitChanges();
		});
	}

	private void _socketService_NickNameReplyReceived(object sender, object arg)
	{
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		NicknameReply nicknameMsg = arg as NicknameReply;
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
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
		//IL_005a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0060: Expected O, but got Unknown
		//IL_0036: Unknown result type (might be due to invalid IL or missing references)
		//IL_003c: Expected O, but got Unknown
		DispatchedHandler val = null;
		DispatchedHandler val2 = null;
		if (_chat != null)
		{
			CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)delegate
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
					_dataService.MessageDBSubmitChanges();
					_dataService.ChatDBSubmitChanges();
					foreach (MessageNotificationInfo messagePropertyNoti in _messagePropertyNotiList)
					{
						messagePropertyNoti.Msg.NotifyPropertyChanged(messagePropertyNoti.Name);
					}
					_chatService.NotifyAnswerbackCountChanged(_chat);
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
			return;
		}
		CoreDispatcher dispatcher2 = ((DependencyObject)_page).Dispatcher;
		if (val2 == null)
		{
			val2 = (DispatchedHandler)delegate
			{
				AnswerBack answerBack = arg as AnswerBack;
				foreach (AnswerbackItem answerback in answerBack.AnswerbackItemsList)
				{
					IEnumerable<Message> messageItems = _dataService.MessageItems;
					Func<Message, bool> predicate = (Message p) => p.NumberID == answerback.MsgID;
					Message message = messageItems.Where(predicate).FirstOrDefault();
					if (message == null)
					{
						return;
					}
					long time = message.Time;
					_chatService.ReflectAnswerBackMessage(message, answerback.Receiver, time);
					if (message != null && message.ActivityState != Message.State.Sent)
					{
						message.BlockNotificationCount++;
						message.ActivityState = Message.State.Sent;
						message.BlockNotificationCount--;
					}
				}
				_dataService.MessageDBSubmitChanges();
				_dataService.ChatDBSubmitChanges();
			};
		}
		dispatcher2.RunAsync((CoreDispatcherPriority)0, val2);
	}

	private void _socketService_EndChatReplyReceived(object sender, object arg)
	{
		//IL_001c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Expected O, but got Unknown
		//IL_008c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0092: Expected O, but got Unknown
		//IL_00b4: Unknown result type (might be due to invalid IL or missing references)
		//IL_00be: Expected O, but got Unknown
		DispatchedHandler val = null;
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			LoadingIndicator.StopLoading();
		});
		EndChatReply endChatReply = null;
		if (!(arg is EndChatReply endChatReply2))
		{
			return;
		}
		if (endChatReply2.Result.ResultCode == 1000 || endChatReply2.Result.ResultCode == 3006 || endChatReply2.Result.ResultCode == 3003)
		{
			CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)delegate
				{
					CloseAndShowPivotPage();
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		}
		else
		{
			((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
			{
				//IL_000a: Unknown result type (might be due to invalid IL or missing references)
				//IL_0010: Expected O, but got Unknown
				MessageDialog val2 = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_ERROR_OCCURRED_TRY_AGAIN"));
				val2.ShowAsync().AsTask<IUICommand>().ConfigureAwait(continueOnCapturedContext: false);
			});
		}
	}

	private void _socketService_ChatReplyReceived(object sender, object arg)
	{
		//IL_006a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0074: Expected O, but got Unknown
		NotifyPropertyChanged(() => IsEnableToChat);
		if (_chat == null)
		{
			return;
		}
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			_ = DateTime.UtcNow.Ticks;
			ChatReply chatReply = arg as ChatReply;
			Message message = _chatService.GetMessage(_chat, chatReply.MsgID);
			if (message != null)
			{
				message.ChatID = _chat.ChatID;
				message.BlockNotificationCount++;
				message.SessionID = chatReply.SessionID;
				message.Time = chatReply.MsgReceivedTime;
				message.ActivityState = Message.State.Sent;
				if (!(message.Sender.Substring(0, 4) == "0999"))
				{
					HandleFailedMessage(chatReply.Result.ResultCode, message);
					message.BlockNotificationCount--;
					_dataService.MessageDBSubmitChanges();
					_activeMsg = message;
					ShowMappingErrorChatReplyReceived(chatReply.Result.ResultCode);
					if (_chat.ChatType != ChatType.BROADCAST || chatReply.Result.ResultCode != 5005)
					{
						SetChatDetailErrorMessage(chatReply.Result.ResultCode);
					}
					message.NotifyPropertyChanged("Time");
					message.NotifyPropertyChanged("ActivityState");
					_chat.SortMessage();
					_chatService.GetLastMessage(_chat);
					_chatService.UpdateChatSummary(_chat);
					_chat.AddDateHeaderAndCheckbox();
					if (_chat != null)
					{
						_chatService.UpdateChatSummary(_chat);
					}
					PivotPage.ActiveInstance.ViewModel.UpdateChatList();
					if (LastMessage != null)
					{
						NotifyPropertyChanged(() => LastMessage);
					}
				}
			}
		});
	}

	private void HandleFailedMessage(int ret, Message savedMsg)
	{
		if (ret != 1000 && ret != 1001)
		{
			savedMsg.ActivityState = Message.State.SendingFailed;
			if (ret == 6002)
			{
				TextBoxMessage = (Visibility)1;
				_chat.IsValidSession = false;
				NotifyPropertyChanged("");
			}
		}
	}

	private void _socketService_DeliveryChatCompleted(object sender, object arg)
	{
		//IL_0063: Unknown result type (might be due to invalid IL or missing references)
		//IL_006d: Expected O, but got Unknown
		//IL_00db: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e5: Expected O, but got Unknown
		DeliveryChat msg = arg as DeliveryChat;
		List<Message> newMessageList = new List<Message>();
		new List<Message>();
		List<string> members = null;
		if (_chat == null)
		{
			return;
		}
		bool isUnreadUpdated = _chat.UnreadMessageCount > 0;
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			//IL_00c0: Unknown result type (might be due to invalid IL or missing references)
			//IL_00c6: Expected O, but got Unknown
			if (_chat != null)
			{
				_chatService.UpdateChatSummary(_chat);
			}
			foreach (InboxMessage inboxMessage in msg.InboxMessageList)
			{
				DispatchedHandler val = null;
				Message findedMsg = _chatService.GetMessage(_chat, inboxMessage.MsgID);
				if (inboxMessage.MsgType == MsgType.ANS)
				{
					if (findedMsg != null && findedMsg.ActivityState != Message.State.Sent)
					{
						CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
						if (val == null)
						{
							val = (DispatchedHandler)delegate
							{
								findedMsg.ActivityState = Message.State.Sent;
								findedMsg.NotifyPropertyChanged("AnswerBackCount");
								_messagePropertyNotiList.Add(new MessageNotificationInfo(findedMsg, "ActivityState"));
							};
						}
						dispatcher.RunAsync((CoreDispatcherPriority)(-1), val);
					}
					_chatService.ReflectAnswerBackMessage(_chat, inboxMessage.ReceiversList[0], inboxMessage.SentTime);
				}
				else
				{
					if (inboxMessage.MsgType == MsgType.NOTI)
					{
						members = new List<string>(inboxMessage.ReceiversList);
						string[] array = Utility.Split(inboxMessage.ChatMsg);
						if (array[0] == "ENTER")
						{
							_chatService.EnterMember(_chat, array[1]);
						}
						else if (array[0] == "LEAVE")
						{
							_chatService.LeaveMember(_chat, array[1]);
						}
					}
					if (findedMsg != null && findedMsg.Chat != null)
					{
						_chatService.DeleteMessage(findedMsg.Chat, findedMsg);
					}
					Message message = new Message();
					message.BlockNotificationCount++;
					message.Type = inboxMessage.MsgType.ToString().ToLower();
					message.SessionID = msg.SessionID;
					message.Time = inboxMessage.SentTime;
					message.Sender = inboxMessage.Sender;
					message.Receiver = string.Join(",", inboxMessage.ReceiversList);
					message.Text = inboxMessage.ChatMsg;
					message.NumberID = inboxMessage.MsgID;
					if (message.Sender == RegistrationService.ChatOnID)
					{
						message.ActivityState = Message.State.Sent;
					}
					else
					{
						message.ActivityState = Message.State.Received;
					}
					if (_chat == null)
					{
						if (string.IsNullOrEmpty(msg.SessionID))
						{
							return;
						}
						_chat = _dataService.ChatItems.FirstOrDefault((Chat x) => x.SessionID.Equals(msg.SessionID) && x.IsValidSession);
						if (_chat == null)
						{
							return;
						}
					}
					message.ChatID = _chat.ChatID;
					message.Chat = _chat;
					message.BlockNotificationCount--;
					if (message.Sender.Substring(0, 4) == "0999")
					{
						return;
					}
					if (message.Type == "media" && message.Text.Contains("ams\n") && !message.Text.Contains("image") && !message.Text.Contains("video") && !message.Text.Contains("anicon") && !message.Text.Contains("audio") && !message.Text.Contains("mixed") && !message.Text.Contains("calendar") && !message.Text.Contains("geo") && !message.Text.Contains("contact"))
					{
						message.Text = message.Text.Replace("ams", "image");
					}
					if (message.Type == "media" && message.Text.Contains("video"))
					{
						if (message.Text.Contains("http://http://"))
						{
							message.Text.Replace("http://http://", "http://");
						}
						else if (message.Text.Contains("https://https://"))
						{
							message.Text.Replace("https://https://", "https://");
						}
					}
					if ((message.Type == "media" && message.Text.Contains("doc\n") && message.Text.Contains("doc\nxls")) || message.Text.Contains("doc\ndoc") || message.Text.Contains("doc\nppt") || message.Text.Contains("doc\npdf") || message.Text.Contains("doc\nhwp") || message.Text.Contains("doc\ngul"))
					{
						message.Text = Utility.GetResourceString("IDS_CHATON_BODY_UNSUPPORTED_FILE_TYPE");
						message.Type = "text";
					}
					if (_chat.Messages.Count == 0 && newMessageList.Count == 0)
					{
						members = new List<string>(inboxMessage.ReceiversList);
						members.Add(message.Sender);
					}
					newMessageList.Add(message);
				}
			}
			if (newMessageList.Count < 50)
			{
				newMessageList.Sort((Message m2, Message m1) => m2.Time.CompareTo(m1.Time));
			}
			foreach (Message newMsg in newMessageList)
			{
				IEnumerable<Message> messageItems = _dataService.MessageItems;
				Func<Message, bool> predicate = (Message x) => x.NumberID == newMsg.NumberID;
				Message message2 = messageItems.FirstOrDefault(predicate);
				if (message2 == null || !(message2.Text == newMsg.Text))
				{
					if (message2 != null && message2.Text != newMsg.Text)
					{
						_dataService.DeleteMessage(message2);
					}
					_dataService.AddMessage(newMsg);
				}
			}
			_dataService.MessageDBSubmitChanges();
			_dataService.ChatDBSubmitChanges();
			if (isUnreadUpdated)
			{
				_chatService.UpdateTileUnreadCount();
				_dataService.ChatDBSubmitChanges();
				PivotPage.ActiveInstance.ViewModel.UpdateChatUnreadCount();
			}
			foreach (MessageNotificationInfo messagePropertyNoti in _messagePropertyNotiList)
			{
				messagePropertyNoti.Msg.NotifyPropertyChanged(messagePropertyNoti.Name);
				_removemessagePropertyNotiList.Add(messagePropertyNoti);
			}
			foreach (MessageNotificationInfo removemessagePropertyNoti in _removemessagePropertyNotiList)
			{
				_messagePropertyNotiList.Remove(removemessagePropertyNoti);
			}
			_chatService.NotifyAnswerbackCountChanged(_chat);
			if (newMessageList.Count < 50 && newMessageList.Count > 0)
			{
				foreach (Message item in newMessageList)
				{
					_chatService.AddMessageToShow(_chat, item, addToDB: false);
				}
				_chat.SortMessage();
				_chat.AddDateHeaderAndCheckbox();
			}
			else if (newMessageList.Count > 0)
			{
				foreach (Message item2 in newMessageList)
				{
					_chatService.AddMessage(_chat, item2);
				}
				_chat.ReflectMessageInfo(newMessageList.Last());
				_chatService.SortAllMessages(_chat);
				_chatService.GetLastMessage(_chat);
				LoadMessages();
			}
			_chatService.UpdateChatSummary(_chat);
			NotifyPropertyChanged(() => LastMessage);
			if (!IsOnBottomPage && !IsBottomChatRoom())
			{
				MessagePreviewVisibility = (Visibility)0;
			}
			else if (newMessageList.Count > 0)
			{
				_page.ScrollToExactEnd();
			}
			PivotPage.ActiveInstance.ViewModel.UpdateChatList();
		});
		if (_reservedMsg != null)
		{
			string text = _chat.MemberList.FirstOrDefault((string c) => c == _reservedMsg.Receiver);
			if (text != null)
			{
				SocketService.Instance.SendChatMsg(_reservedMsg.Text, _reservedMsg.NumberID, _reservedType);
			}
			_reservedMsg = null;
		}
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			if (_chat != null)
			{
				_chat.UnreadMessageCount = 0;
			}
			PivotPage.ActiveInstance.ViewModel.NewChatCount = _chatService.UpdateTileUnreadCount();
			PivotPage.ActiveInstance.ViewModel.NotifyPropertyChanged("NewChatCount");
		});
	}

	public bool IsBottomChatRoom()
	{
		if (Math.Abs(VerticalOffset - ScrollableHeight) < 10.0 || VerticalOffset >= ScrollableHeight - 2.0)
		{
			return true;
		}
		return false;
	}

	private void _socketService_AnnounceChangeReceived(object sender, object arg)
	{
		//IL_00f8: Unknown result type (might be due to invalid IL or missing references)
		//IL_0102: Expected O, but got Unknown
		if (!(arg is AnnounceChange))
		{
			return;
		}
		AnnounceChange msg = arg as AnnounceChange;
		Message newMsg = new Message();
		newMsg.BlockNotificationCount++;
		newMsg.Type = "noti";
		newMsg.SessionID = msg.SessionID;
		newMsg.Time = msg.SentTime;
		newMsg.NumberID = msg.MsgID;
		newMsg.ActivityState = Message.State.Received;
		newMsg.Sender = msg.Inviter;
		if (!string.IsNullOrEmpty(newMsg.Sender) && newMsg.Sender.Substring(0, 4) == "0999")
		{
			return;
		}
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			foreach (ChangeMemberList changeMemberList in msg.ChangeMemberListList)
			{
				Message message = newMsg;
				object text = message.Text;
				message.Text = string.Concat(text, changeMemberList.Status.ToString(), ',', changeMemberList.Member, ',', changeMemberList.Name, '\n');
				if (changeMemberList.Status == ChangeStatus.ENTER)
				{
					_chatService.EnterMember(_chat, changeMemberList.Member);
				}
				else
				{
					_chatService.LeaveMember(_chat, changeMemberList.Member);
				}
			}
			newMsg.ChatID = _chat.ChatID;
			newMsg.BlockNotificationCount--;
			_dataService.AddMessage(newMsg);
			_dataService.ChatDBSubmitChanges();
			_dataService.MessageDBSubmitChanges();
			foreach (ChangeMemberList changeMemberList2 in msg.ChangeMemberListList)
			{
				_buddyService.SaveOrUpdateUnknownUser(changeMemberList2.Member, changeMemberList2.Name);
			}
			_chatService.AddMessageToShow(_chat, newMsg, addToDB: false);
			_chatService.UpdateChatSummary(_chat);
			_chat.AddDateHeaderAndCheckbox();
		});
	}

	private void _socketService_InitChatReplyReceived(object sender, object arg)
	{
		//IL_0036: Unknown result type (might be due to invalid IL or missing references)
		//IL_003c: Expected O, but got Unknown
		DispatchedHandler val = null;
		try
		{
			if (_chat == null)
			{
				return;
			}
			CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)delegate
				{
					_page.HideProgress();
					if (arg is InitChatReply)
					{
						InitChatReply initChatReply = arg as InitChatReply;
						Message message = _chatService.GetMessage(_chat, initChatReply.MsgID);
						if (message == null)
						{
							return;
						}
						message.BlockNotificationCount++;
						message.SessionID = initChatReply.SessionID;
						message.Time = initChatReply.MsgReceivedTime;
						message.ActivityState = Message.State.Sent;
						if (message.Sender.Substring(0, 4) == "0999")
						{
							return;
						}
						HandleFailedMessage(initChatReply.Result.ResultCode, message);
						message.BlockNotificationCount--;
						ShowMappingInitChatReplyReceived(initChatReply.Result.ResultCode);
						if (_chat.ChatType != ChatType.BROADCAST || initChatReply.Result.ResultCode != 5005)
						{
							SetChatDetailErrorMessage(initChatReply.Result.ResultCode);
						}
						_chat.SortMessage();
						_chatService.GetLastMessage(_chat);
						_chatService.UpdateChatSummary(_chat);
						message.NotifyPropertyChanged("Time");
						message.NotifyPropertyChanged("ActivityState");
						_chat.AddDateHeaderAndCheckbox();
						PivotPage.ActiveInstance.UpdateChatList();
					}
					if (ChatDetailPage.ActiveInstance != null && ChatDetailPage.ActiveInstance.ViewModel != null)
					{
						ChatDetailPage.ActiveInstance.ViewModel.NotifyPropertyChanged("");
					}
					if (ChatDetailPage.SnappedActiveInstance != null && ChatDetailPage.SnappedActiveInstance.ViewModel != null)
					{
						ChatDetailPage.SnappedActiveInstance.ViewModel.NotifyPropertyChanged("");
					}
					_page.FocusInputText();
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		}
		catch
		{
		}
	}

	private void ShowSendingError(int ret)
	{
		switch (ret)
		{
		case 6002:
			ChatDetailPage.ActiveInstance.ShowSplashPopup(Utility.GetResourceString("IDS_CHATON_BODY_BUDDYS_INFORMATION_HAS_CHANGED_RETRY_CHAT_VIA_BUDDY_LIST"));
			break;
		case 5009:
			ChatDetailPage.ActiveInstance.ShowSplashPopup(Utility.GetResourceString("IDS_CHATON_POP_UNABLE_TO_SEND_BUDDY_BLOCKED"));
			break;
		case 4002:
			ChatDetailPage.ActiveInstance.ShowSplashPopup(Utility.GetResourceString("IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID"));
			break;
		case 5005:
			ChatDetailPage.ActiveInstance.ShowSplashPopup(Utility.GetResourceString("IDS_CHATON_POP_THERE_ARE_NO_BUDDIES_AVAILABLE_TO_CHAT_WITH"));
			break;
		}
	}

	private void ShowMappingErrorChatReplyReceived(int ret)
	{
		if (ret == 7005)
		{
			string resourceString = Utility.GetResourceString("IDS_CHATON_POP_A_BUDDYS_ACCOUNT_INFORMATION_IS_CURRENTLY_BEING_CHANGED_TRY_LATER");
			resourceString = resourceString.Replace("%s", "");
			ChatDetailPage.ActiveInstance.ShowSplashPopup(resourceString);
		}
	}

	private void ShowMappingInitChatReplyReceived(int ret)
	{
		if (ret == 7005)
		{
			string resourceString = Utility.GetResourceString("IDS_CHATON_POP_PSS_SAMSUNG_ACCOUNT_IS_SYNCHRONISING_WITH_CHATON_TRY_LATER");
			resourceString = resourceString.Replace("%s", "");
			resourceString = resourceString.Replace("'s", "").Trim();
			ChatDetailPage.ActiveInstance.ShowSplashPopup(resourceString);
		}
	}

	private void SetChatDetailErrorMessage(int ret)
	{
		//IL_00f5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fb: Expected O, but got Unknown
		if (ret == 1000)
		{
			return;
		}
		switch (ret)
		{
		case 6002:
			ShowErrorMessageVisibility = (Visibility)0;
			TextBoxMessage = (Visibility)1;
			_chat.IsValidSession = false;
			ErrorChatDetailMessage = Utility.GetResourceString("IDS_CHATON_BODY_UNABLE_TO_CHAT_IN_THIS_CHAT_ROOM");
			_page.ShowWarning();
			break;
		case 5009:
		{
			ShowErrorMessageVisibility = (Visibility)0;
			UnknownMessageVisibility = (Visibility)1;
			TextBoxMessage = (Visibility)1;
			_chat.IsValidSession = false;
			ErrorChatDetailMessage = Utility.GetResourceString("IDS_CHATON_BODY_UNABLE_TO_CHAT_IN_THIS_CHAT_ROOM");
			_page.ShowWarning();
			string text = Utility.sprintf(Utility.GetResourceString("IDS_CHATON_BODY_PS_BLOCKED"), _chat.Title);
			MessageDialog val = new MessageDialog(text);
			try
			{
				val.ShowAsync();
			}
			catch (Exception)
			{
			}
			break;
		}
		case 4002:
			ShowErrorMessageVisibility = (Visibility)0;
			TextBoxMessage = (Visibility)1;
			_chat.IsValidSession = false;
			ErrorChatDetailMessage = Utility.GetResourceString("IDS_CHATON_BODY_UNABLE_TO_CHAT_IN_THIS_CHAT_ROOM");
			_page.ShowWarning();
			break;
		case 3003:
			ShowErrorMessageVisibility = (Visibility)0;
			TextBoxMessage = (Visibility)1;
			_chat.IsValidSession = false;
			ErrorChatDetailMessage = Utility.GetResourceString("IDS_CHATON_BODY_UNABLE_TO_CHAT_IN_THIS_CHAT_ROOM");
			_page.ShowWarning();
			break;
		case 5010:
			ChatDetailPage.ActiveInstance.ShowSplashPopup(Utility.GetResourceString("IDS_CHATON_POP_MAXIMUM_CHARACTER_LIMIT_EXCEEDED"));
			break;
		}
		_dataService.ChatDBSubmitChanges();
		NotifyPropertyChanged(() => ShowErrorMessageVisibility);
		NotifyPropertyChanged(() => TextBoxMessage);
		NotifyPropertyChanged(() => ErrorChatDetailMessage);
	}

	private void _socketService_Connected(object sender, SocketEventArgs e)
	{
		_timer.Stop();
		IsConnected = true;
		Connecting = false;
		NotifyPropertyChanged("");
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
			Message message = AddMediaMessage(file);
			SSMService sSMService = new SSMService();
			sSMService.Tag = message;
			sSMService.UploadFileCompleted += ssmService_UploadFileCompleted;
			sSMService.UploadProgressChanged += ssmService_UploadProgressChanged;
			message.Tag = sSMService;
			break;
		}
		case Attachment.MediaType.LOCATION:
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
		case Attachment.MediaType.ANICON:
			text = "image\n";
			text2 = "jpg\n";
			break;
		case Attachment.MediaType.VIDEO:
			text = "video\n";
			text2 = "mp4\n";
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
		SSMService.GetServerInfo();
		string text3 = text + text2;
		text3 += "dummy\n";
		text3 = text3 + file.FileName + "\n";
		text3 = text3 + RegistrationService.GetUserAccount().Uid + "\n";
		text3 += file.Title;
		message.MediaFilePath = file.FilePath;
		message.Text = text3;
		message.Sender = RegistrationService.ChatOnID;
		message.NumberID = SocketMessage.CreateMsgID();
		message.ActivityState = Message.State.Uploading;
		message.Type = "media";
		message.SessionID = _chat.SessionID;
		message.Receiver = _chat.Members;
		message.Time = Utility.GetTimeStamp();
		_chatService.DisplaySendMessage(_chat, message);
		_chatService.GetLastMessage(_chat);
		_chatService.UpdateChatSummary(_chat);
		_dataService.MessageDBSubmitChanges();
		ScrollToRecentMessage();
		return message;
	}

	private async void ssmService_UploadFileCompleted(object sender, SSMCompletedEventArgs e)
	{
		DispatchedHandler val = null;
		Message msg = null;
		SSMService sSMService;
		SSMService ssmService = (sSMService = sender as SSMService);
		if (sSMService == null || (msg = ssmService.Tag as Message) == null)
		{
			return;
		}
		try
		{
			if (msg.Time == 0)
			{
				msg.Time = Utility.GetTimeStamp();
			}
		}
		catch (Exception)
		{
		}
		CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
		if (val == null)
		{
			val = (DispatchedHandler)delegate
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
					Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_FAILED_TO_UPLOAD_FILE"));
				}
				else
				{
					msg.ActivityState = Message.State.Typed;
				}
			};
		}
		dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		if (_isClosing || e == null)
		{
			return;
		}
		_ = string.Empty;
		string queryString = e.Value.ToString();
		string[] mediaMessageInfo = await MakeMediaMessageInfo(queryString);
		if (_chat == null)
		{
			_chat = msg.Chat;
		}
		if (_chat != null)
		{
			if (_chat.SessionID == msg.SessionID)
			{
				SendMediaMessage(mediaMessageInfo[0], mediaMessageInfo[1]);
				_chat.IsChanged = true;
			}
			else
			{
				msg.ActivityState = Message.State.UploadingFailed;
				msg.ProgressValue = 0;
			}
		}
		else
		{
			msg.ActivityState = Message.State.UploadingFailed;
			msg.ProgressValue = 0;
		}
		_dataService.MessageDBSubmitChanges();
	}

	private async void ssmService_ForwardUploadFileCompleted(object sender, SSMCompletedEventArgs e)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			SSMService sSMService;
			SSMService ssmService = (sSMService = sender as SSMService);
			if (sSMService == null)
			{
				return;
			}
			Message message;
			Message msg = (message = ssmService.Tag as Message);
			if (message == null)
			{
				return;
			}
			msg.Time = Utility.GetTimeStamp();
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
				PivotPage.ActiveInstance.ShowSplashPopup(Utility.GetResourceString("IDS_CHATON_POP_FAILED_TO_UPLOAD_FILE"));
			}
			else
			{
				msg.ActivityState = Message.State.Typed;
			}
			if (_isClosing || e == null)
			{
				return;
			}
			_ = string.Empty;
			string queryString = e.Value.ToString();
			string[] mediaMessageInfo = await MakeMediaMessageInfo(queryString);
			if (_chat != null)
			{
				if (_chat.SessionID == msg.SessionID)
				{
					if (SocketService.Instance.Chat == null)
					{
						SocketService.Instance.Chat = _chat;
					}
					SendMediaMessage(mediaMessageInfo[0], mediaMessageInfo[1]);
					_chat.IsChanged = true;
				}
				else
				{
					msg.ActivityState = Message.State.UploadingFailed;
					msg.ProgressValue = 0;
				}
			}
			else
			{
				msg.ActivityState = Message.State.UploadingFailed;
				msg.ProgressValue = 0;
			}
			_dataService.MessageDBSubmitChanges();
			HighlightCurrentChat();
		}
		catch (Exception)
		{
		}
	}

	internal async void CloseChatFromOtherDevice(Chat _chat)
	{
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			try
			{
				if (ChatOnService.Instance.InActiveChat.Contains(_chat))
				{
					MessageDialog val = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_THIS_CHAT_ROOM_HAS_BEEN_CLOSED_ON_ANOTHER_DEVICE"));
					asyncCommand = val.ShowAsync();
					_dataService.DeleteChat(_chat);
					ChatOnService.Instance.InActiveChat.Remove(_chat);
					if (ChatOnService.Instance.InActiveChat.Count == 0)
					{
						ChatOnService.Instance.InActiveChat.Clear();
					}
					_dataService.ChatDBSubmitChanges();
					ChatOnService.Instance.ReUpdateChatList = true;
					PivotPage.ActiveInstance.ViewModel.UpdateChatList();
				}
			}
			catch
			{
			}
		});
	}

	private async Task<string[]> MakeMediaMessageInfo(string uploadResult)
	{
		string[] addressInfo = Utility.Split(uploadResult, '?');
		string[] messageInfo = Utility.Split(addressInfo[1], '&');
		string mediaType = string.Empty;
		string fileFormat = string.Empty;
		string misc = string.Empty;
		string fileName = Utility.Split(messageInfo[2], '=')[1];
		if (messageInfo[3].Contains("image"))
		{
			mediaType = "image\n";
			fileFormat = "jpg\n";
			misc = fileName;
		}
		else if (messageInfo[3].Contains("video"))
		{
			mediaType = "video\n";
			fileFormat = "mp4\n";
			misc = fileName;
		}
		else if (messageInfo[3].Contains("vcard"))
		{
			mediaType = "contact\n";
			fileFormat = "VCF\n";
			string vCardData = Utility.ByteArrayToStr(await Utility.FileToByteArray(Chat.ChatID.ToString() + "\\" + fileName));
			vCard_t vCard_decoder = new vCard_t
			{
				pEncodedData = vCardData,
				nEncodedDataLen = vCardData.Length
			};
			List<Vitemnode> node = new List<Vitemnode>();
			vCardDecoder.DecodevCard(vCard_decoder, node);
			misc = vCard_decoder.FN;
		}
		else if (messageInfo[3].Contains("vcal"))
		{
			mediaType = "calendar\n";
			fileFormat = "VCS\n";
		}
		string mediaMessage = mediaType + fileFormat;
		mediaMessage = mediaMessage + addressInfo[0] + "\n";
		mediaMessage = mediaMessage + fileName + "\n";
		mediaMessage = mediaMessage + RegistrationService.GetUserAccount().Uid + "\n";
		mediaMessage += misc;
		return new string[2] { mediaMessage, fileName };
	}

	private void ssmService_UploadProgressChanged(object sender, SSMCompletedEventArgs e)
	{
		Message message = null;
		SSMService sSMService = null;
		if (sender is SSMService { Tag: Message tag })
		{
			tag.ActivityState = Message.State.Uploading;
			tag.ProgressValue = (int)e.Value;
		}
	}

	public void SendAnicon(Anicon anicon)
	{
		string msgText = "image\njpg\n" + anicon.MsgUrl + "\n" + anicon.DelegateImageName + "\n" + RegistrationService.GetUserAccount().Uid;
		SendMediaMessage(msgText);
	}

	private void SendMediaMessage(string msgText, string fileName = null)
	{
		//IL_002e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0038: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			if (fileName == null)
			{
				sendMessage(msgText, MsgType.MEDIA);
			}
			else
			{
				SSMService.GetServerInfo();
				Message message = _dataService.FirstOrDefaultMessage((Message c) => !string.IsNullOrEmpty(c.MediaFilePath) && c.MediaFilePath.Contains(fileName));
				if (message == null)
				{
					return;
				}
				message.Text = msgText;
				message.ActivityState = Message.State.Typed;
				if (message.Time == 0)
				{
					message.Time = Utility.GetTimeStamp();
				}
				if (SocketService.Instance.Chat == null)
				{
					SocketService.Instance.Chat = message.Chat;
				}
				SocketService.Instance.SendChatMsg(message.Text, message.NumberID, MsgType.MEDIA);
			}
			NotifyPropertyChanged("IsEnableToChat");
		});
	}

	private bool CheckAndRequestNickName(string number)
	{
		try
		{
			Buddy buddy = _buddyService.GetBuddy(number);
			if (buddy == null)
			{
				SocketService.Instance.SendNickNameRequestMsg(number);
				return true;
			}
			return false;
		}
		catch (Exception)
		{
			return false;
		}
	}

	private void NotifyMessageItemsChanged()
	{
		NotifyPropertyChanged(() => MessageItems);
	}

	internal async void OpenChatDetail(Guid id)
	{
		DispatchedHandler val = null;
		if ((int)ApplicationView.Value == 2)
		{
			if (ChatDetailPage.ActiveInstance != null && ChatDetailPage.ActiveInstance.ViewModel != null)
			{
				await ChatDetailPage.ActiveInstance.ViewModel.Disconnect();
			}
		}
		else if (ChatDetailPage.SnappedActiveInstance != null && ChatDetailPage.SnappedActiveInstance.ViewModel != null)
		{
			await ChatDetailPage.SnappedActiveInstance.ViewModel.Disconnect(isNullChat: false);
		}
		_page.ResetWarning();
		_page.HideUnknownMessage();
		Chat = _dataService.GetChat(id);
		Chat.MessageItems.CollectionChanged -= MessageItems_CollectionChanged;
		Chat.MessageItems.CollectionChanged += MessageItems_CollectionChanged;
		_chat.UnreadMessageCount = 0;
		PivotPage.ActiveInstance.ViewModel.NewChatCount = _chatService.UpdateTileUnreadCount();
		PivotPage.ActiveInstance.ViewModel.NotifyPropertyChanged("NewChatCount");
		Connect();
		_chatService.CancelUpdateChatProfileImage();
		_chatService.CancelUpdateGroupChatProfileImageUrl();
		_chatService.CancelCreateGetAllMessageAsync();
		AllowSeeMessageList = false;
		if (Chat != null)
		{
			Chat deleteChat = ChatOnService.Instance.InActiveChat.FirstOrDefault((Chat c) => c.ChatID == Chat.ChatID);
			if (deleteChat != null)
			{
				MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_THIS_CHAT_ROOM_HAS_BEEN_CLOSED_ON_ANOTHER_DEVICE"));
				await dialog.ShowAsync();
				_dataService.DeleteChat(deleteChat);
				ChatOnService.Instance.InActiveChat.Remove(deleteChat);
				if (ChatOnService.Instance.InActiveChat.Count == 0)
				{
					ChatOnService.Instance.InActiveChat.Clear();
				}
				_dataService.ChatDBSubmitChanges();
				ChatOnService.Instance.ReUpdateChatList = true;
				if (ChatListPage.ActiveInstance != null)
				{
					ChatListPage.ActiveInstance.IsInChatMode = false;
					ChatListPage.ActiveInstance.MakeSelectChatNoticeGridVisible();
					AppBarVisibility = (Visibility)1;
				}
				PivotPage.ActiveInstance.ViewModel.UpdateChatList();
				return;
			}
		}
		if (Chat == null)
		{
			Chat = _dataService.GetChat(id);
			_initialUnreadMessagesCount = 0;
		}
		if (Chat == null)
		{
			Chat = PivotPage.ActiveInstance.ViewModel.ChatItems[0];
		}
		if (Chat != null)
		{
			Chat.Background = colorOrange;
			if (!Chat.IsValidSession)
			{
				CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
				if (val == null)
				{
					val = (DispatchedHandler)delegate
					{
						_page.ShowWarning();
					};
				}
				dispatcher.RunAsync((CoreDispatcherPriority)0, val);
			}
			Chat.IsDeletionMode = false;
			if (!string.IsNullOrEmpty(Chat.SessionID) || !Chat.IsGroupChat())
			{
				Chat.IsInfoAvailableMode = true;
			}
			else
			{
				Chat.IsInfoAvailableMode = false;
			}
			_initialUnreadMessagesCount = _chat.UnreadMessageCount;
			_chatService.UpdateChatSummary(Chat);
			LoadMessages();
			UpdateTrunkUnreadCount(_chat);
		}
		NotifyPropertyChanged("");
		_isSelectAll = false;
		_isSelectReceived = false;
		_isSelectSent = false;
		_isClosing = false;
		ShowUnknownBuddyGrid();
		if (Chat != null && Chat.ChatType != ChatType.BROADCAST)
		{
			_page.ShowProgress();
		}
		if (delayLoadTimer != null && delayLoadTimer.IsEnabled)
		{
			delayLoadTimer.Stop();
		}
		delayLoadTimer.Start();
	}

	public void LoadMessages()
	{
		if (_chat != null)
		{
			_chat.ClearMessageItems();
			_chat.LoadMessageItems(isPrev: true);
			ScrollToRecentMessage();
			NotifyMessageItemsChanged();
		}
	}

	private void ImageCropPage_CropCompleted(object sender, object arg)
	{
		AttachedPhoto file = new AttachedPhoto((WriteableBitmap)((arg is WriteableBitmap) ? arg : null), Chat.ChatID.ToString());
		Message message = AddMediaMessage(file);
		SSMService sSMService = new SSMService();
		sSMService.Tag = message;
		sSMService.UploadFileCompleted += ssmService_UploadFileCompleted;
		sSMService.UploadProgressChanged += ssmService_UploadProgressChanged;
		message.Tag = sSMService;
	}

	internal async Task AttachPhoto(StorageFile s, bool isForward = false)
	{
		try
		{
			AttachedPhoto photo = new AttachedPhoto(Chat.ChatID.ToString());
			await photo.SetFile(s);
			Message msg = AddMediaMessage(photo);
			msg.SessionID = Chat.SessionID;
			await Utility.CreateImageThumbnail(s, "thumb_" + photo.FileName, Chat.ChatID.ToString(), (ThumbnailMode)0);
			await msg.LoadImageThumbnail();
			msg.MediaFilePath = string.Concat(Chat.ChatID, "\\", photo.FileName);
			SSMService ssmService = new SSMService
			{
				Tag = msg
			};
			if (!isForward)
			{
				ssmService.UploadFileCompleted += ssmService_UploadFileCompleted;
			}
			else
			{
				ssmService.UploadFileCompleted += ssmService_ForwardUploadFileCompleted;
			}
			ssmService.UploadProgressChanged += ssmService_UploadProgressChanged;
			ssmService.UploadFileAsync(photo, s);
			msg.Tag = ssmService;
		}
		catch (Exception)
		{
		}
	}

	internal async Task AttachVideo(StorageFile s)
	{
		long timeStamp = Utility.GetTimeStamp();
		Attachment video = new Attachment();
		video.AttachedMediaType = Attachment.MediaType.VIDEO;
		video.ContentType = "video/mp4";
		video.FileName = timeStamp + ".mp4";
		video.FilePath = Chat.ChatID.ToString() + "\\" + video.FileName;
		StorageFile copiedFile = await Utility.CopyFileAsync(s, video.FileName, Chat.ChatID.ToString());
		StorageFile thumb = await Utility.CreateVideoThumbnail2(s, "thumb_" + timeStamp + ".jpg", Chat.ChatID.ToString(), (ThumbnailMode)1);
		Message msg = AddMediaMessage(video);
		msg.MediaFilePath = string.Concat(Chat.ChatID, "\\", video.FileName);
		if (thumb != null)
		{
			msg.LoadVideoThumbnail();
		}
		SSMService ssmService = new SSMService();
		ssmService.Tag = msg;
		ssmService.UploadFileCompleted += ssmService_UploadFileCompleted;
		ssmService.UploadProgressChanged += ssmService_UploadProgressChanged;
		ssmService.UploadFileAsync(video, copiedFile);
		msg.Tag = ssmService;
	}

	internal async Task AttachContact(ContactInformation info)
	{
		AttachedContact contact = new AttachedContact(Chat.ChatID.ToString());
		StorageFile file = await contact.SetFile(info);
		if (file != null)
		{
			Message msg = AddMediaMessage(contact);
			msg.MediaFilePath = contact.FilePath;
			SSMService ssmService = new SSMService();
			ssmService.Tag = msg;
			ssmService.UploadFileCompleted += ssmService_UploadFileCompleted;
			ssmService.UploadProgressChanged += ssmService_UploadProgressChanged;
			ssmService.UploadFileAsync(contact, file);
			msg.Tag = ssmService;
		}
	}

	private void sendMessage(string text, MsgType type)
	{
		//IL_00da: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e4: Expected O, but got Unknown
		if (_chat == null)
		{
			return;
		}
		_chat.IsChanged = true;
		SSMService.GetServerInfo();
		Message msg = new Message();
		msg.Text = text.Replace("\r\n", "\n");
		msg.Sender = RegistrationService.ChatOnID;
		msg.NumberID = SocketMessage.CreateMsgID();
		msg.ActivityState = Message.State.Typed;
		msg.Type = type.ToString().ToLower();
		msg.Receiver = _chat.Members;
		msg.Time = Utility.GetTimeStamp();
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			_chatService.DisplaySendMessage(_chat, msg);
			_dataService.MessageDBSubmitChanges();
			_chatService.GetLastMessage(_chat);
			ScrollToRecentMessage();
			if (!SocketService.Instance.IsConnected)
			{
				_reservedMsg = msg;
				_reservedType = type;
				Connect();
			}
		});
		SocketService.Instance.SendChatMsg(msg.Text, msg.NumberID, type);
		NotifyPropertyChanged("IsEnableToChat");
	}

	private void sendMessage(Chat chats, string text, MsgType type)
	{
		//IL_00d2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00dc: Expected O, but got Unknown
		if (chats == null)
		{
			return;
		}
		chats.IsChanged = true;
		SSMService.GetServerInfo();
		Message msg = new Message();
		msg.Text = text;
		msg.Sender = RegistrationService.ChatOnID;
		msg.NumberID = SocketMessage.CreateMsgID();
		msg.ActivityState = Message.State.Typed;
		msg.Type = type.ToString().ToLower();
		msg.Receiver = chats.Members;
		msg.Time = Utility.GetTimeStamp();
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			_chatService.AddMessageToShow(chats, msg);
			_dataService.MessageDBSubmitChanges();
			_chatService.GetLastMessage(chats);
			_chatService.UpdateChatSummary(chats);
			PivotPage.ActiveInstance.ViewModel.UpdateChatList();
			ScrollToRecentMessage();
			if (!SocketService.Instance.IsConnected)
			{
				_reservedMsg = msg;
				_reservedType = type;
				Connect();
			}
		});
		SocketService.Instance.SendChatMsg(msg.Text, msg.NumberID, type);
	}

	internal void SendMessage(string text)
	{
		if (!string.IsNullOrEmpty(text.Trim()))
		{
			sendMessage(text, MsgType.TEXT);
			NotifyPropertyChanged("IsEnableToChat");
		}
	}

	internal async void CloseChat(bool isClose = true)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			if (!isClose || await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_THIS_CONTENT_WILL_BE_DELETED")))
			{
				if (!string.IsNullOrEmpty(_chat.SessionID))
				{
					PivotPage.ActiveInstance.ShowLoading();
					SocketService.Instance.SendCloseMsg();
				}
				else
				{
					CloseAndShowPivotPage();
				}
			}
		}
		catch (Exception)
		{
			MessageDialog val = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_ERROR_OCCURRED_TRY_AGAIN"));
			val.ShowAsync().AsTask<IUICommand>().ConfigureAwait(continueOnCapturedContext: false);
		}
	}

	private void CloseAndShowPivotPage()
	{
		//IL_0053: Unknown result type (might be due to invalid IL or missing references)
		//IL_0059: Expected O, but got Unknown
		try
		{
			ChatOnService.Instance.RecentChat = null;
			_chatService.CloseChat(_chat);
			OnClose();
			if (ChatListPage.ActiveInstance != null)
			{
				ChatListPage.ActiveInstance.IsInChatMode = false;
				AppBarVisibility = (Visibility)1;
			}
			PivotPage.ActiveInstance.UpdateChatList();
		}
		catch (Exception)
		{
			MessageDialog val = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_ERROR_OCCURRED_TRY_AGAIN"));
			val.ShowAsync().AsTask<IUICommand>().ConfigureAwait(continueOnCapturedContext: false);
		}
	}

	internal void OnClose()
	{
		//IL_0093: Unknown result type (might be due to invalid IL or missing references)
		//IL_0099: Expected O, but got Unknown
		try
		{
			_isClosing = true;
			_timer.Stop();
			if (_chat != null)
			{
				if (!_chat.IsChanged)
				{
					_dataService.DeleteChat(_chat);
					PivotPage.ActiveInstance.UpdateChatList();
				}
				else
				{
					_chatService.UpdateChatSummary(_chat);
				}
				_chatService.UpdateTileUnreadCount();
				Utility.DeleteFolder(_chat.ChatID.ToString());
			}
		}
		catch (Exception)
		{
			MessageDialog val = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_ERROR_OCCURRED_TRY_AGAIN"));
			val.ShowAsync().AsTask<IUICommand>().ConfigureAwait(continueOnCapturedContext: false);
		}
	}

	public async Task Disconnect(bool isNullChat = true)
	{
		try
		{
			IsDisconnectedByRequest = true;
			Connecting = false;
			_timer.Stop();
			SocketService.Instance.Disconnect();
			if (isNullChat)
			{
				_chat = null;
				SocketService.Instance.Chat = null;
			}
		}
		catch (Exception)
		{
		}
	}

	internal async void LoadRemainListItems(bool isPrev)
	{
		if (_chat == null || (_chat != null && _chat.ChatType == ChatType.BROADCAST))
		{
			return;
		}
		if (isPrev)
		{
			if (_chat != null && _chat.PrevMsgStatus == Chat.PrevMsgLoadingStatus.None && _shownAlertMessage)
			{
				_shownAlertMessage = false;
				string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_CANNOT_LOAD_OLDER_MESSAGES_MESSAGES_ARE_ONLY_KEPT_FOR_PD_DAYS");
				resourceString = resourceString.Replace("%d", "15");
				ChatDetailPage.ActiveInstance.ShowSplashPopup(resourceString);
				return;
			}
			if (_chat != null && _chat.PrevMsgStatus == Chat.PrevMsgLoadingStatus.Loading)
			{
				LoadingControlVisibility = (Visibility)0;
				if (_chat != null)
				{
					await _chatService.GetAllMessageAsync(_chat, _chat.SessionID, _chat.LastSyncTid.ToString(), "10");
					if (_chat != null)
					{
						if (_chat.PrevMsgStatus == Chat.PrevMsgLoadingStatus.InitialLoading)
						{
							_page.ScrollToEnd();
						}
						if (_chat.PrevMsgStatus == Chat.PrevMsgLoadingStatus.None)
						{
							_shownAlertMessage = true;
						}
					}
				}
				LoadingControlVisibility = (Visibility)1;
			}
		}
		else if (_chatService.IsLastMessageLoaded(_chat))
		{
			return;
		}
		if (!isPrev)
		{
			_page.ShowProgress();
		}
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			Message msg = _chat.LoadMessageItems(isPrev);
			if (!IsOnBottomPage)
			{
				_page.ScrollToMessage(msg);
			}
			_page.UpdateListLayout();
		});
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			if (!isPrev)
			{
				_page.HideProgress();
			}
		});
	}

	internal void ScrollToRecentMessage()
	{
		_page.ScrollToEnd();
	}

	public void InviteBuddies()
	{
		//IL_0067: Unknown result type (might be due to invalid IL or missing references)
		//IL_006d: Expected O, but got Unknown
		int num = ChatService.MAX_CHAT_MEMBERS;
		if (_chat.ChatType == ChatType.BROADCAST)
		{
			num = ChatService.MAX_BROADCAST_MEMBERS;
		}
		if (num - _chat.MemberList.Count - 1 == 0)
		{
			string resourceString = Utility.GetResourceString("IDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_REACHED");
			resourceString = resourceString.Replace("%d", "{0:d}");
			resourceString = string.Format(resourceString, new object[1] { num - 1 });
			MessageDialog val = new MessageDialog(resourceString);
			val.ShowAsync();
		}
		else
		{
			SelectBuddyPage.SelectionCompleted += SelectBuddyPage_SelectionCompleted;
			SelectBuddyPage.Mode = SelectBuddyMode.InviteBuddy;
			SelectBuddyPage.isRemoveMode = false;
			SelectBuddyPage.ExceptionNumbers = _chat.MemberList;
			SelectBuddyPage.SelectionCountLimit = num - _chat.MemberList.Count - 1;
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
		}
	}

	private async void SelectBuddyPage_SelectionCompleted(object sender, object arg)
	{
		_invitingBuddies.Clear();
		SelectBuddyPage.SelectionCompleted -= SelectBuddyPage_SelectionCompleted;
		if (!(sender is SelectBuddyPage))
		{
			return;
		}
		List<BuddySummary> list = (arg as ObservableCollection<BuddySummary>).ToList();
		if (list.Count == 0)
		{
			Utility.SafetyGoBackPageNavigation(((Page)PivotPage.ActiveInstance).Frame);
			return;
		}
		List<string> list2 = new List<string>();
		foreach (BuddySummary item in list)
		{
			list2.Add(item.Buddy.PhoneNumber);
			_invitingBuddies.Add(item.Buddy);
		}
		((Page)(sender as SelectBuddyPage)).Frame.SetNavigationState("1,0");
		((Page)(sender as SelectBuddyPage)).Frame.Navigate(typeof(PivotPage));
		if (_chat == null)
		{
			if (ChatOnService.Instance.RecentChat == null)
			{
				return;
			}
			_chat = ChatOnService.Instance.RecentChat;
		}
		if (_chat.ChatType == ChatType.SINGLE)
		{
			list2.Add(_chat.Sender);
			string member = string.Join(",", list2);
			Chat chat = (_chat = _chatService.StartChat(disconnect: false, list2[0], member, ChatType.GROUP));
			PivotPage.ActiveInstance.OpenChat(chat);
			PivotPage.ActiveInstance.ViewModel.UpdateChatList();
			if (ChatListPage.ActiveInstance != null)
			{
				ChatListPage.ActiveInstance.ActivateChat(chat, forceRefresh: true);
			}
			return;
		}
		if (_chat.IsChanged)
		{
			if (SocketService.Instance.Chat == null)
			{
				SocketService.Instance.Chat = _chat;
			}
			SocketService.Instance.SendInviteChatRequestMsg(SocketMessage.CreateMsgID(), list2);
			return;
		}
		foreach (Buddy invitingBuddy in _invitingBuddies)
		{
			_chatService.EnterMember(_chat, invitingBuddy.PhoneNumber);
		}
		_chatService.UpdateChatSummary(_chat);
	}

	private async void ForwardMessage_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= ForwardMessage_SelectionCompleted;
		try
		{
			List<BuddySummary> list = (arg as ObservableCollection<BuddySummary>).ToList();
			if (list.Count == 0)
			{
				Utility.SafetyGoBackPageNavigation(((Page)PivotPage.ActiveInstance).Frame);
				return;
			}
			string txtMsg = await Clipboard.GetContent().GetTextAsync();
			await OpenForwadedChat(list);
			sendMessage(_chat, txtMsg, MsgType.TEXT);
			Utility.SafetyGoBackPageNavigation(((Page)PivotPage.ActiveInstance).Frame);
		}
		catch (Exception)
		{
		}
	}

	private async Task OpenForwadedChat(IList<BuddySummary> list)
	{
		if (list.Count == 1)
		{
			_chat = await StartChat(list.FirstOrDefault().Buddy);
		}
		else
		{
			List<string> list2 = list.Select((BuddySummary x) => x.Buddy.PhoneNumber).ToList();
			string member = string.Join(",", list2);
			_chat = _chatService.StartChat(disconnect: false, list2[0], member, ChatType.GROUP);
		}
		ChatDetailPage.ActiveInstance.ActivateChat(_chat);
		ChatDetailPage.ActiveInstance.OnLoaded();
		ChatDetailPage.ActiveInstance.ViewModel.HighlightCurrentChat();
	}

	private async void ForwardVideo_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= ForwardVideo_SelectionCompleted;
		try
		{
			List<BuddySummary> buddyList = (arg as ObservableCollection<BuddySummary>).ToList();
			if (buddyList == null || buddyList.Count == 0)
			{
				Utility.SafetyGoBackPageNavigation(((Page)PivotPage.ActiveInstance).Frame);
				return;
			}
			StorageFile file = await Utility.IsFileExist(await Clipboard.GetContent().GetTextAsync());
			StorageFolder folder = ApplicationData.Current.LocalFolder;
			StorageFile FiletoUpload = await file.CopyAsync((IStorageFolder)(object)folder, file.Name, (NameCollisionOption)1);
			await OpenForwadedChat(buddyList);
			await ChatDetailPage.ActiveInstance.ViewModel.AttachVideo(FiletoUpload);
			Utility.SafetyGoBackPageNavigation(((Page)PivotPage.ActiveInstance).Frame);
		}
		catch (Exception)
		{
		}
	}

	private async void ForwardPhoto_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= ForwardPhoto_SelectionCompleted;
		try
		{
			List<BuddySummary> list = (arg as ObservableCollection<BuddySummary>).ToList();
			if (list == null || list.Count == 0)
			{
				Utility.SafetyGoBackPageNavigation(((Page)PivotPage.ActiveInstance).Frame);
				return;
			}
			StorageFile file = await Utility.IsFileExist(await Clipboard.GetContent().GetTextAsync());
			StorageFolder folder = ApplicationData.Current.LocalFolder;
			StorageFile FiletoUpload = await file.CopyAsync((IStorageFolder)(object)folder, file.Name, (NameCollisionOption)1);
			await OpenForwadedChat(list);
			await Task.Delay(500);
			await ChatDetailPage.ActiveInstance.ViewModel.AttachPhoto(FiletoUpload, isForward: true);
			Utility.SafetyGoBackPageNavigation(((Page)PivotPage.ActiveInstance).Frame);
		}
		catch (Exception)
		{
		}
	}

	internal void OpenForwardChatDetail(Guid id)
	{
		//IL_0068: Unknown result type (might be due to invalid IL or missing references)
		//IL_0072: Expected O, but got Unknown
		_isSelectAll = false;
		_isSelectReceived = false;
		_isSelectSent = false;
		if (_chat.PrevMsgStatus == Chat.PrevMsgLoadingStatus.InitialLoading && string.IsNullOrEmpty(_chat.SessionID))
		{
			_chat.PrevMsgStatus = Chat.PrevMsgLoadingStatus.None;
		}
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			if (_chat == null)
			{
				_chat = _dataService.GetChat(id);
			}
			_chat.ClearMessageItems();
			_chat.LoadMessageItems(isPrev: true);
			NotifyMessageItemsChanged();
			HighlightCurrentChat();
		});
	}

	private void HighlightCurrentChat()
	{
		//IL_0044: Unknown result type (might be due to invalid IL or missing references)
		//IL_004e: Expected O, but got Unknown
		//IL_0086: Unknown result type (might be due to invalid IL or missing references)
		//IL_0090: Expected O, but got Unknown
		IEnumerable<Chat> enumerable = _dataService.ChatItems.Where((Chat c) => c.Background != null && c.Background.Color != Colors.Transparent);
		foreach (Chat item in enumerable)
		{
			item.Background = new SolidColorBrush(Colors.Transparent);
		}
		if (_chat != null)
		{
			_chat.Background = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
		}
	}

	public async Task<Chat> StartChat(Buddy buddy)
	{
		Chat result = _chatService.StartChat(disconnect: false, buddy.PhoneNumber, buddy.PhoneNumber, ChatType.SINGLE);
		PivotPage.ActiveInstance.UpdateChatList();
		return result;
	}

	internal async void OnClickMessage(object sender, Message msg)
	{
		if (_isContextMenuDisabled)
		{
			_isContextMenuDisabled = false;
			return;
		}
		if (msg.Type != "media")
		{
			PopupMenu menu = new PopupMenu();
			menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_COPY"), (UICommandInvokedHandler)null, (object)1));
			menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_FORWARD"), (UICommandInvokedHandler)null, (object)2));
			menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_DELETE"), (UICommandInvokedHandler)null, (object)3));
			try
			{
				Rect rect = Utility.GetElementRect((FrameworkElement)sender);
				Placement placement = (Placement)0;
				rect.Y += PositionHeight;
				if (rect.Y < PivotPage.ActiveInstance.ViewModel.PivotHeaderHeight + HeaderHeight + rect.Height)
				{
					placement = (Placement)2;
				}
				IUICommand chosenCommand = await menu.ShowForSelectionAsync(rect, placement);
				if (chosenCommand == null)
				{
					return;
				}
				switch ((int)chosenCommand.Id)
				{
				case 1:
				{
					DataPackage val2 = new DataPackage();
					val2.SetText(msg.Text);
					Clipboard.SetContent(val2);
					break;
				}
				case 2:
				{
					DataPackage val = new DataPackage();
					val.SetText(msg.Text);
					Clipboard.SetContent(val);
					SelectBuddyPage.SelectionCompleted += ForwardMessage_SelectionCompleted;
					if ((int)ApplicationView.Value == 2)
					{
						ApplicationView.TryUnsnap();
					}
					((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
					break;
				}
				case 3:
					DeleteMessage(msg);
					break;
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		string text = msg.Text;
		string[] info = Utility.Split(text, '\n');
		if (text.Contains("/download/anicon"))
		{
			PopupMenu menu2 = new PopupMenu();
			menu2.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_DELETE"), (UICommandInvokedHandler)null, (object)1));
			try
			{
				Rect rect2 = Utility.GetElementRect((FrameworkElement)sender);
				Placement placement2 = (Placement)0;
				rect2.Y += PositionHeight;
				if (rect2.Y < PivotPage.ActiveInstance.ViewModel.PivotHeaderHeight + HeaderHeight + rect2.Height)
				{
					placement2 = (Placement)2;
				}
				IUICommand chosenCommand2 = await menu2.ShowForSelectionAsync(rect2, placement2);
				if (chosenCommand2 != null && (int)chosenCommand2.Id == 1)
				{
					DeleteMessage(msg);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		if (!string.IsNullOrEmpty(msg.MediaFilePath))
		{
			if (msg.Sender == RegistrationService.ChatOnID && !msg.MediaFilePath.Contains("\\"))
			{
				msg.MediaFilePath = string.Concat(Chat.ChatID, "\\", msg.MediaFilePath);
			}
			if (info[0] == "image" || (info.Length > 6 && info[0] == "mixed" && info[1] == "image"))
			{
				if ((int)ApplicationView.Value == 2)
				{
					StorageFile file = await Utility.IsFileExist(msg.MediaFilePath);
					if (file != null)
					{
						await Launcher.LaunchFileAsync((IStorageFile)(object)file);
					}
				}
				else
				{
					OpenTrunkDetail(msg, msg.MediaFilePath, "image");
				}
			}
			else if (info[0] == "video" || info[0] == "audio")
			{
				if (info[0] == "video")
				{
					if (info[3].Contains("3gp") || info[1].Equals("3gp"))
					{
						_page.ShowSplashPopup(Utility.GetResourceString("IDS_CHATON_POP_UNSUPPORTED_MEDIA_TYPE"));
						return;
					}
					if ((int)ApplicationView.Value == 2)
					{
						StorageFile file2 = await Utility.IsFileExist(msg.MediaFilePath);
						if (file2 != null)
						{
							await Launcher.LaunchFileAsync((IStorageFile)(object)file2);
						}
					}
					else
					{
						OpenTrunkDetail(msg, msg.MediaFilePath, "video");
					}
				}
				else
				{
					_page.ShowSplashPopup(Utility.GetResourceString("IDS_CHATON_POP_UNSUPPORTED_MEDIA_TYPE"));
				}
				Disconnect(isNullChat: false);
			}
			else if (info[0] == "mixed")
			{
				if (info[1] == "video")
				{
					if (info[3].Contains("3gp") || info[1].Equals("3gp"))
					{
						_page.ShowSplashPopup(Utility.GetResourceString("IDS_CHATON_POP_UNSUPPORTED_MEDIA_TYPE"));
						return;
					}
					OpenTrunkDetail(msg, msg.MediaFilePath, "video");
				}
				else
				{
					_page.ShowSplashPopup(Utility.GetResourceString("IDS_CHATON_POP_UNSUPPORTED_MEDIA_TYPE"));
				}
				Disconnect(isNullChat: false);
			}
			else if (info[0] == "contact")
			{
				ShowContactDetail(msg.MediaFilePath);
			}
			else if (info[0] == "calendar" && msg.ActivityState == Message.State.Received)
			{
				ShowCalendarDetail(msg.MediaFilePath);
			}
		}
		else if (info[0] == "video" || info[0] == "audio" || info[0] == "image" || info[0] == "contact" || info[0] == "calendar")
		{
			if (!msg.IsDownloading)
			{
				string server = info[2];
				string fileName = info[3];
				string buddyUid = info[4];
				SSMService sSMService = new SSMService();
				sSMService.Tag = msg;
				sSMService.DownloadFileCompleted += ssmService_DownloadFileCompleted;
				sSMService.DownloadProgressChanged += ssmService_DownloadProgressChanged;
				sSMService.DownloadFileUsingBackground(server, fileName, buddyUid);
				msg.IsDownloading = true;
				if (msg.Sender != RegistrationService.ChatOnID)
				{
					msg.ActivityState = Message.State.Downloading;
				}
				msg.Tag = sSMService;
			}
		}
		else if (info[0] == "mixed" && (info[1] == "image" || info[1] == "video"))
		{
			if (!msg.IsDownloading)
			{
				string server2 = info[2];
				string fileName2 = info[3];
				string buddyUid2 = info[4];
				SSMService sSMService2 = new SSMService();
				sSMService2.Tag = msg;
				sSMService2.DownloadFileCompleted += ssmService_DownloadFileCompleted;
				sSMService2.DownloadProgressChanged += ssmService_DownloadProgressChanged;
				sSMService2.DownloadFileUsingBackground(server2, fileName2, buddyUid2);
				msg.IsDownloading = true;
				if (msg.Sender != RegistrationService.ChatOnID)
				{
					msg.ActivityState = Message.State.Downloading;
				}
				msg.Tag = sSMService2;
			}
		}
		else if (info[0] == "geo" || info[1] == "geo")
		{
			try
			{
				Utility.Split(info[5]);
				_page.ShowSplashPopup(Utility.GetResourceString("IDS_CHATON_POP_FORMAT_NOT_SUPPORTED"));
			}
			catch (Exception)
			{
			}
		}
	}

	public async void OpenResendContextMenu(object sender, Message msg)
	{
		PopupMenu menu = new PopupMenu();
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BUTTON_RESEND"), (UICommandInvokedHandler)null, (object)1));
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_CANCEL_ABB"), (UICommandInvokedHandler)null, (object)2));
		try
		{
			IUICommand chosenCommand = await menu.ShowForSelectionAsync(Utility.GetElementRect((FrameworkElement)sender));
			if (chosenCommand != null)
			{
				switch ((int)chosenCommand.Id)
				{
				case 1:
					ReSendMessage(msg);
					break;
				case 2:
					DeleteMessage(msg);
					break;
				}
			}
		}
		catch (Exception)
		{
		}
	}

	public async void OpenImaegContextMenu(object sender, Message msg)
	{
		PopupMenu menu = new PopupMenu();
		if (!msg.IsUnforwardedMessageFormat())
		{
			menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_FORWARD"), (UICommandInvokedHandler)null, (object)1));
		}
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_DELETE"), (UICommandInvokedHandler)null, (object)2));
		try
		{
			Rect rect = Utility.GetElementRect((FrameworkElement)sender);
			Placement placement = (Placement)0;
			rect.Y += PositionHeight;
			if (rect.Y < PivotPage.ActiveInstance.ViewModel.PivotHeaderHeight + HeaderHeight + rect.Height)
			{
				placement = (Placement)2;
			}
			IUICommand chosenCommand = await menu.ShowForSelectionAsync(rect, placement);
			if (chosenCommand != null)
			{
				switch ((int)chosenCommand.Id)
				{
				case 1:
				{
					string[] array = Utility.Split(msg.Text, '\n');
					DataPackage val = new DataPackage();
					val.SetText(msg.MediaFilePath);
					Clipboard.SetContent(val);
					if ((int)ApplicationView.Value == 2)
					{
						ApplicationView.TryUnsnap();
					}
					if (array[0] == "video")
					{
						SelectBuddyPage.SelectionCompleted += ForwardVideo_SelectionCompleted;
						((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
					}
					else
					{
						SelectBuddyPage.SelectionCompleted += ForwardPhoto_SelectionCompleted;
						((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
					}
					break;
				}
				case 2:
					DeleteMessage(msg);
					break;
				}
			}
			ChatDetailPage.ActiveInstance.TmpSender = null;
			ChatDetailPage.ActiveInstance.IsMouseHold = false;
			ChatDetailPage.ActiveInstance.Gr = null;
		}
		catch (Exception)
		{
		}
	}

	private void _ssmService_GetTrunkItemListCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ssmService.GetTrunkItemListCompleted -= _ssmService_GetTrunkItemListCompleted;
		if (e.StatusCode != HttpStatusCode.NoContent)
		{
			Trunk trunk = new Trunk();
			List<TrunkItem> temp = new List<TrunkItem>();
			DataService dataService = new DataService();
			TrunkService trunkService = new TrunkService(dataService);
			temp = trunkService.ParseTrunkItemListFromXml(e.Xml, trunk, temp);
			string[] array = msgTemp.MediaFilePath.Split('\\');
			string fileName = array[1];
			TrunkItem trunkItem = temp.FirstOrDefault((TrunkItem c) => c.CachedFileName == fileName);
			if (trunkItem != null)
			{
				TrunkItemParameter trunkItemParameter = new TrunkItemParameter();
				trunkItemParameter.Chat = Chat;
				trunkItemParameter.Item = trunkItem;
				((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(TrunkDetailPage), (object)trunkItemParameter);
			}
		}
	}

	internal async void OpenTrunkDetail(Message msg, string filePath = null, string type = null)
	{
		msgTemp = msg;
		if (filePath != null)
		{
			TrunkItemParameter param = new TrunkItemParameter
			{
				TempFile = await Utility.IsFileExist(msg.MediaFilePath),
				Chat = Chat,
				Msg = msg,
				MediaType = type
			};
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(TrunkDetailPage), (object)param);
			_page.IsNavigatedToTrunk = true;
			Disconnect(isNullChat: false);
		}
		else
		{
			_ssmService.GetTrunkItemListCompleted += _ssmService_GetTrunkItemListCompleted;
			_ssmService.GetTrunkItemListByTimeStampAsync(msg.SessionID, 30, "0", msg.Time.ToString(), msg.Time.ToString());
		}
	}

	private void ssmService_DownloadProgressChanged(object sender, SSMCompletedEventArgs e)
	{
		Message message = null;
		SSMService sSMService = null;
		if (sender is SSMService { Tag: Message tag })
		{
			if (!tag.IsDownloading)
			{
				tag.IsDownloading = true;
			}
			tag.ProgressValue = (int)e.Value;
		}
	}

	private async void ssmService_DownloadFileCompleted(object sender, SSMCompletedEventArgs e)
	{
		Message message;
		Message msg = (message = (sender as SSMService).Tag as Message);
		if (message == null)
		{
			return;
		}
		string text = msg.Text;
		string[] info = Utility.Split(text, '\n');
		msg.IsDownloading = false;
		if (msg.Sender == RegistrationService.ChatOnID)
		{
			msg.ActivityState = Message.State.Sent;
		}
		else
		{
			msg.ActivityState = Message.State.Received;
		}
		if (info[0] == "video" || info[0] == "audio" || info[0] == "image" || info[0] == "contact" || info[0] == "calendar")
		{
			string text2 = info[3];
			string text3 = msg.Chat.ChatID.ToString();
			msg.MediaFilePath = text3 + "\\" + text2;
			if (info[0] == "video")
			{
				msg.LoadVideoThumbnail();
			}
			_dataService.MessageDBSubmitChanges();
		}
		else if (info[0] == "mixed" && (info[1] == "image" || info[1] == "video"))
		{
			string text4 = info[3];
			string text5 = msg.Chat.ChatID.ToString();
			msg.MediaFilePath = text5 + "\\" + text4;
			if (info[1] == "video")
			{
				msg.LoadVideoThumbnail();
			}
			_dataService.MessageDBSubmitChanges();
		}
		await msg.CheckMediaPathFileAsync();
		_dataService.MessageDBSubmitChanges();
	}

	internal async void ShowContactDetail(string filePath)
	{
		PageNavigationService.OpenContactDetailPage(vCardInfo: Utility.ByteArrayToStr(await Utility.FileToByteArray(filePath)), page: (Page)(object)PivotPage.ActiveInstance);
	}

	internal async void ShowCalendarDetail(string filePath)
	{
		PageNavigationService.OpenCalendarDetailPage(vCalData: Utility.ByteArrayToStr(await Utility.FileToByteArray(filePath)), page: (Page)(object)PivotPage.ActiveInstance);
	}

	internal async void OnCancelDownloading(Message msg)
	{
		SSMService sSMService;
		SSMService ssmService = (sSMService = msg.Tag as SSMService);
		if (sSMService != null)
		{
			ssmService.CancelDownloading(Utility.Split(msg.Text, '\n')[3]);
			msg.IsDownloading = false;
			if (msg.Sender == RegistrationService.ChatOnID)
			{
				msg.ActivityState = Message.State.Sent;
			}
			else
			{
				msg.ActivityState = Message.State.Received;
			}
			msg.ProgressValue = 0;
			if (!string.IsNullOrEmpty(msg.MediaFilePath))
			{
				msg.MediaFilePath = "";
			}
			await msg.CheckMediaPathFileAsync();
			_dataService.MessageDBSubmitChanges();
		}
	}

	internal async void CancelAllActiveUpload()
	{
		if (_chat == null)
		{
			return;
		}
		if (_chat.Messages != null)
		{
			IEnumerable<Message> enumerable = _chat.Messages.Where((Message x) => x.Type == "media" && x.ActivityState == Message.State.Uploading);
			foreach (Message item in enumerable)
			{
				if (item.Tag is SSMService sSMService)
				{
					sSMService.CancelUploadAsync(Utility.Split(item.Text, '\n')[3]);
					item.ProgressValue = 0;
					item.ActivityState = Message.State.UploadingFailed;
				}
			}
		}
		_dataService.MessageDBSubmitChanges();
	}

	internal void OpenBuddyProfile(string number)
	{
		PivotPage.ActiveInstance.OpenBuddyProfile(number);
	}

	private void AddUnknownBuddyPage_BuddyAdded(object sender, object arg)
	{
		Buddy buddy = null;
		if (!(arg is Buddy buddy2))
		{
			return;
		}
		foreach (Message messageItem in _chat.MessageItems)
		{
			if (buddy2.PhoneNumber == messageItem.Sender)
			{
				messageItem.NotifySenderUpdated();
			}
		}
		_chatService.UpdateChatSummary(_chat);
	}

	internal void OpenMessageItemContextMenu(FrameworkElement element)
	{
	}

	private void delete_OnExecute(object sender, EventArgs e)
	{
	}

	private void copy_OnExecute(object sender, EventArgs e)
	{
	}

	internal void ToggleDeletionMode()
	{
		_chat.IsDeletionMode = !_chat.IsDeletionMode;
		_chat.AddDateHeaderAndCheckbox();
		if (_chat.IsDeletionMode)
		{
			_chatService.SelectAllMessages(_chat, isSelectAll: false);
		}
	}

	internal async void DeleteSelectedMessages()
	{
		if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_BODY_DELETE_MESSAGE")))
		{
			_chatService.DeleteSelectedMessages(_chat);
			ToggleDeletionMode();
			_page.OnToggleDeletionMode();
		}
	}

	internal void DeleteAllChatRecords()
	{
		if (!string.IsNullOrEmpty(_chat.SessionID) || _chat.IsBoradcastChat())
		{
			_chatService.DeleteAllMessages(_chat);
			_chat.UnreadMessageCount = 0;
			_chat.LastMergedTimeStamp = Utility.GetTimeStamp();
			_dataService.ChatDBSubmitChanges();
			if (_chat.ChatType != ChatType.BROADCAST)
			{
				_ssmService.DeleteAllTrunkItemAsync(_chat.SessionID);
				_ssmService.DeleteTrunkItemCompleted += _ssmService_DeleteTrunkItemCompleted;
			}
		}
	}

	private async void _ssmService_DeleteTrunkItemCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ssmService.DeleteTrunkItemCompleted -= _ssmService_DeleteTrunkItemCompleted;
		if (e.StatusCode != HttpStatusCode.OK)
		{
			await SSMService.ShowCommonErrorMessage(e);
			return;
		}
		_chat.UnreadTrunkMessageCount = 0;
		PivotPage.ActiveInstance.ViewModel.UpdateTrunkUnreadCount();
	}

	internal void DeleteMessage(Message msg)
	{
		_chatService.DeleteMessage(_chat, msg);
		_chat.AddDateHeaderAndCheckbox();
		_chat.UpdateChatSummary(_buddyService);
	}

	internal void SelectAllMessages()
	{
		_isSelectAll = !_isSelectAll;
		_isSelectReceived = (_isSelectSent = _isSelectAll);
		_chatService.SelectAllMessages(_chat, _isSelectAll);
		_page.UpdateDeleteAppBarButton();
	}

	internal void SelectReceivedMessages()
	{
		_isSelectReceived = !_isSelectReceived;
		_isSelectAll = _isSelectReceived && _isSelectSent;
		_chatService.SelectReceivedMessages(_chat, _isSelectReceived);
		_chatService.UpdateDateHeaderCheckBox(_chat);
		_page.UpdateDeleteAppBarButton();
	}

	internal void SelectSentMessages()
	{
		_isSelectSent = !_isSelectSent;
		_isSelectAll = _isSelectReceived && _isSelectSent;
		_chatService.SelectSentMessages(_chat, _isSelectSent);
		_chatService.UpdateDateHeaderCheckBox(_chat);
		_page.UpdateDeleteAppBarButton();
	}

	internal void OnClickDateHeaderCheckBox(Message msg)
	{
		_chatService.UpdateDateHeaderCheckBox(_chat, msg);
		_page.UpdateDeleteAppBarButton();
	}

	internal void OnClickCheckBox(Message clickedMessage)
	{
		_chatService.UpdateDateHeaderCheckBox(_chat);
		_page.UpdateDeleteAppBarButton();
	}

	internal void OnCancelUploadFile(Message msg)
	{
		if (msg.Tag != null)
		{
			(msg.Tag as SSMService).CancelUploadAsync(Utility.Split(msg.Text, '\n')[3]);
		}
		msg.ProgressValue = 0;
		msg.ActivityState = Message.State.UploadingFailed;
	}

	internal void ReSendMessage(Message msg)
	{
		if (msg.ActivityState == Message.State.UploadingFailed)
		{
			msg.ActivityState = Message.State.Uploading;
			if (msg.Tag != null)
			{
				SSMService sSMService = null;
				if (msg.Tag is SSMService sSMService2)
				{
					sSMService2.UploadFileCompleted += ssmService_UploadFileCompleted;
					sSMService2.UploadProgressChanged += ssmService_UploadProgressChanged;
					sSMService2.ResumeUploadFileAsync();
				}
			}
			else
			{
				SSMService sSMService3 = new SSMService();
				sSMService3.Tag = msg;
				sSMService3.UploadFileCompleted += ssmService_UploadFileCompleted;
				sSMService3.UploadProgressChanged += ssmService_UploadProgressChanged;
				sSMService3.ResumeUploadFileAsync();
				msg.Tag = sSMService3;
			}
		}
		else
		{
			if (msg.ActivityState != Message.State.SendingFailed)
			{
				return;
			}
			msg.ActivityState = Message.State.Typed;
			if (!(msg.ChatID == _chat.ChatID))
			{
				return;
			}
			if (msg.Type == "media" || msg.Text.Contains("dummy"))
			{
				msg.ActivityState = Message.State.Uploading;
				if (msg.Tag != null)
				{
					SSMService sSMService4 = null;
					if (msg.Tag is SSMService sSMService5)
					{
						sSMService5.UploadProgressChanged += ssmService_UploadProgressChanged;
						sSMService5.UploadFileCompleted += ssmService_UploadFileCompleted;
						sSMService5.ResumeUploadFileAsync();
					}
				}
				else
				{
					SSMService sSMService6 = new SSMService();
					sSMService6.Tag = msg;
					sSMService6.UploadFileCompleted += ssmService_UploadFileCompleted;
					sSMService6.UploadProgressChanged += ssmService_UploadProgressChanged;
					sSMService6.ResumeUploadFileAsync();
					msg.Tag = sSMService6;
				}
			}
			else
			{
				SocketService.Instance.SendChatMsg(msg.Text, msg.NumberID, (!(msg.Type == "text")) ? MsgType.MEDIA : MsgType.TEXT);
			}
		}
	}

	internal void ReConnect()
	{
		if (!Connecting)
		{
			Connect();
		}
	}

	internal void Connect()
	{
		if (!Connecting)
		{
			IsDisconnectedByRequest = false;
			Connecting = true;
			InitConnection();
			SocketService.Instance.Init();
		}
	}

	internal void UpdateBackgroundImage()
	{
	}

	internal void OnPushReceived(string senderID, string sessionID, ChatType msgChatType)
	{
		_ = ((Page)PivotPage.ActiveInstance).Frame;
		if (_chat != null && _chat.ChatType != ChatType.BROADCAST && (_chat.SingleChatBuddy == null || (!_chat.SingleChatBuddy.IsSpecialBuddy && !(_chat.SingleChatBuddy.PhoneNumber.Substring(0, 4) == "0999"))))
		{
			if (msgChatType == ChatType.BROADCAST && _chat.ChatType == ChatType.SINGLE && senderID == _chat.Sender && ((Page)PivotPage.ActiveInstance).Frame.CurrentSourcePageType.Name == "PivotPage")
			{
				SocketService.Instance.SendAllowChatRequestMsg();
			}
			else if (!(_chat.SessionID != sessionID) && ((Page)PivotPage.ActiveInstance).Frame.CurrentSourcePageType.Name == "PivotPage")
			{
				SocketService.Instance.SendAllowChatRequestMsg();
			}
		}
	}

	internal async void UpdateStyle()
	{
		BackgroundImage = await SettingService.GetSelectedBG();
	}

	internal bool IsChecked()
	{
		if (_chat == null)
		{
			return false;
		}
		if (!string.IsNullOrEmpty(_chat.SessionID) || !_chat.IsGroupChat())
		{
			_chat.IsInfoAvailableMode = true;
		}
		else
		{
			_chat.IsInfoAvailableMode = false;
		}
		return _chatService.IsCheckedToDelete(_chat);
	}

	internal void AddFlagImage(Grid grid, UnknownUser user)
	{
		QueueEngine queueEngine = null;
		if (!(((IDictionary<object, object>)Application.Current.Resources)[(object)"QueueEngine"] is QueueEngine queueEngine2))
		{
			return;
		}
		GetNationalFlag_QueueItem getNationalFlag_QueueItem = new GetNationalFlag_QueueItem(_ssmService, user.CountryCode);
		getNationalFlag_QueueItem.InvokeBack = delegate(object o, Exception e)
		{
			//IL_0000: Unknown result type (might be due to invalid IL or missing references)
			//IL_0006: Expected O, but got Unknown
			Image val = new Image();
			((FrameworkElement)val).put_Margin(new Thickness(0.0, 0.0, 3.0, 3.0));
			((FrameworkElement)val).put_Width(29.0);
			((FrameworkElement)val).put_Height(20.0);
			((FrameworkElement)val).put_HorizontalAlignment((HorizontalAlignment)2);
			((FrameworkElement)val).put_VerticalAlignment((VerticalAlignment)2);
			if (o != null)
			{
				val.put_Source((ImageSource)((o is BitmapImage) ? o : null));
			}
			((ICollection<UIElement>)((Panel)grid).Children).Add((UIElement)(object)val);
			Logger.Log("Chat Detail Page ViewModel -> National Flag Retreived --> w :" + ((BitmapSource)((o is BitmapImage) ? o : null)).PixelWidth + " h : " + ((BitmapSource)((o is BitmapImage) ? o : null)).PixelHeight);
		};
		queueEngine2.Add(getNationalFlag_QueueItem);
	}

	internal void AddWarningImage(Grid grid)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		//IL_0076: Unknown result type (might be due to invalid IL or missing references)
		//IL_0080: Expected O, but got Unknown
		Image val = new Image();
		((FrameworkElement)val).put_Margin(new Thickness(0.0, 0.0, 3.0, 3.0));
		((FrameworkElement)val).put_Width(29.0);
		((FrameworkElement)val).put_Height(20.0);
		((FrameworkElement)val).put_HorizontalAlignment((HorizontalAlignment)2);
		((FrameworkElement)val).put_VerticalAlignment((VerticalAlignment)2);
		val.put_Source((ImageSource)new BitmapImage(new Uri(new Uri("ms-appx://"), "/Images/icon_noti.png")));
		((ICollection<UIElement>)((Panel)grid).Children).Add((UIElement)(object)val);
	}

	public void ShowUnknownBuddyGrid()
	{
		if (_chat == null)
		{
			return;
		}
		if (_chat.ChatType == ChatType.SINGLE)
		{
			string number = "";
			if (_chat.MemberList.Count == 0)
			{
				number = Chat.Sender;
			}
			else
			{
				number = Chat.MemberList[0];
			}
			Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy x) => x.PhoneNumber == number);
			if (buddy == null)
			{
				UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == number);
				if (unknownUser == null)
				{
					unknownUser = new UnknownUser(_chat.Title, number);
					_dataService.AddUnknownUser(unknownUser);
				}
				UnknownBuddy = unknownUser;
				unknownUser.SetMessage(_chat.Title);
				string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_PS_MAY_NOT_BE_YOUR_BUDDY_BE_CAREFUL_IF_THIS_USER_REQUESTS_PRIVATE_INFORMATION_OR_MONEY_FROM_YOU");
				resourceString = resourceString.Replace("%s", "{0:}");
				resourceString = string.Format(resourceString, new object[1] { _chat.Title });
				if (unknownUser.IsDeregistered)
				{
					string resourceString2 = Utility.GetResourceString("IDS_CHATON_POP_PSS_INFORMATION_HAS_CHANGED_RETRY_CHAT_VIA_BUDDY_LIST");
					resourceString2 = resourceString2.Replace("%s", "{0:}");
					resourceString2 = string.Format(resourceString2, new object[1] { _chat.Title });
					UnknownMessageVisibility = (Visibility)1;
					ErrorChatDetailMessage = resourceString2;
				}
				else
				{
					if (unknownUser.IsBlocked)
					{
						UnknownMessageVisibility = (Visibility)1;
					}
					ErrorChatDetailMessage = Utility.GetResourceString("IDS_CHATON_BODY_UNABLE_TO_CHAT_IN_THIS_CHAT_ROOM");
				}
				UnknownMessage = resourceString;
				if (unknownUser.IsAddible && !unknownUser.IsDeregistered && !unknownUser.IsBlocked)
				{
					UnknownMessageVisibility = (Visibility)0;
				}
			}
			else
			{
				string resourceString3 = Utility.GetResourceString("IDS_CHATON_POP_PSS_INFORMATION_HAS_CHANGED_RETRY_CHAT_VIA_BUDDY_LIST");
				resourceString3 = resourceString3.Replace("%s", "{0:}");
				ErrorChatDetailMessage = string.Format(resourceString3, new object[1] { buddy.Name });
				ShowErrorMessageVisibility = (Visibility)0;
			}
		}
		else
		{
			UnknownMessageVisibility = (Visibility)1;
		}
	}

	public void LoadBuddyProfileImage(Grid grid, Message msg)
	{
		//IL_003a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0040: Expected O, but got Unknown
		//IL_00e0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e6: Expected O, but got Unknown
		//IL_0156: Unknown result type (might be due to invalid IL or missing references)
		//IL_0160: Expected O, but got Unknown
		if (((ICollection<UIElement>)((Panel)grid).Children).Count > 2)
		{
			return;
		}
		Image val = new Image();
		((FrameworkElement)val).put_Margin(new Thickness(1.0, 0.0, 0.0, 3.0));
		((FrameworkElement)val).put_Width(58.0);
		((FrameworkElement)val).put_Height(58.0);
		((FrameworkElement)val).put_HorizontalAlignment((HorizontalAlignment)0);
		((FrameworkElement)val).put_VerticalAlignment((VerticalAlignment)0);
		Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == msg.Sender);
		if (buddy != null)
		{
			val.put_Source((ImageSource)(object)buddy.ProfileImage);
			((IList<UIElement>)((Panel)grid).Children).Insert(1, (UIElement)(object)val);
		}
		else
		{
			Image val2 = new Image();
			((FrameworkElement)val2).put_Margin(new Thickness(1.0, 0.0, 0.0, 3.0));
			((FrameworkElement)val2).put_Width(58.0);
			((FrameworkElement)val2).put_Height(58.0);
			((FrameworkElement)val2).put_HorizontalAlignment((HorizontalAlignment)0);
			((FrameworkElement)val2).put_VerticalAlignment((VerticalAlignment)0);
			val2.put_Source((ImageSource)new BitmapImage(new Uri(new Uri("ms-appx://"), "/Images/buddies_profile_image.png")));
			((IList<UIElement>)((Panel)grid).Children).Insert(0, (UIElement)(object)val2);
			UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == msg.Sender);
			BitmapImage val3 = null;
			if (unknownUser != null)
			{
				if (unknownUser.ProfileImageUri == null)
				{
					unknownUser.ProfileImageUri = _ssmService.GetBuddyProfileImageUri(msg.Sender);
				}
				if (unknownUser.ProfileImageUri != null)
				{
					unknownUser.LoadProfileImage();
					val3 = unknownUser.ProfileImage;
				}
			}
			else
			{
				unknownUser = new UnknownUser();
				unknownUser.PhoneNumber = msg.Sender;
				unknownUser.ProfileImageUri = _ssmService.GetBuddyProfileImageUri(msg.Sender);
				_dataService.AddUnknownUser(unknownUser);
			}
			val.put_Source((ImageSource)(object)val3);
			((IList<UIElement>)((Panel)grid).Children).Insert(2, (UIElement)(object)val);
		}
		if (_chat.ChatType != ChatType.SINGLE || buddy != null)
		{
			return;
		}
		UnknownUser user = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == msg.Sender);
		SSMService sSMService = new SSMService();
		sSMService.CheckBuddyProfileCompleted += delegate(object s, SSMCompletedEventArgs e)
		{
			if (e.Xml != null)
			{
				string text = _buddyService.ParseUnknownBuddyInfo(e.Xml);
				if (!string.IsNullOrEmpty(text))
				{
					user.CountryCode = text;
					AddFlagImage(grid, user);
				}
				else
				{
					AddWarningImage(grid);
				}
			}
			else if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("CCS-25009"))
			{
				_page.HideUnknownMessage();
			}
		};
		sSMService.CheckBuddyProfileAsync(user.PhoneNumber);
	}

	internal void AddBuddy(UnknownUser buddy)
	{
		_page.ShowLoading();
		_buddy = buddy;
		if (_buddy == null)
		{
			_page.HideUnknownMessage();
			return;
		}
		_ssmService.AddBuddyCompleted -= _ssmService_AddBuddyCompleted;
		_ssmService.AddBuddyCompleted += _ssmService_AddBuddyCompleted;
		string phoneNumber = (_buddy.PhoneNumber.StartsWith("+") ? _buddy.PhoneNumber : ("+" + _buddy.PhoneNumber));
		_ssmService.AddBuddyAsync(phoneNumber);
	}

	internal void BlockBuddy(UnknownUser buddy)
	{
		_buddy = buddy;
		if (_buddy == null)
		{
			_page.HideUnknownMessage();
			return;
		}
		_ssmService.BlockBuddyCompleted -= _ssmService_BlockBuddyCompleted;
		_ssmService.BlockBuddyCompleted += _ssmService_BlockBuddyCompleted;
		_ssmService.BlockBuddyAsync(_buddy.PhoneNumber);
	}

	private async void _ssmService_AddBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		MessageDialog dialog;
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			_ = string.Empty;
			if (await BuddyService.ShowAddBuddyResult(phoneNumber: (!string.IsNullOrEmpty(e.Param as string)) ? (e.Param as string) : _buddy.PhoneNumber, e: e))
			{
				ChatOnService.Instance.IsBuddiesUpdated = true;
				List<Buddy> list = _buddyService.AddBuddyFromXml(e.Xml);
				if (list.Count > 0)
				{
					list[0].LoadProfileImage(_ssmService.GetBuddyProfileImageUri(list[0].PhoneNumber));
				}
				PivotPage.ActiveInstance.ViewModel.UpdateList();
				if (list.Count > 0)
				{
					Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_PS_ADDED").Replace("%s", list[0].Name));
				}
				else
				{
					string resourceString = Utility.GetResourceString("IDS_CHATON_POP_ADDED_TO_BUDDY_LIST");
					dialog = new MessageDialog(resourceString);
					dialog.ShowAsync();
				}
				_page.HideUnknownMessage();
			}
			if (!string.IsNullOrEmpty(e.ErrorMessage) && e.ErrorMessage.Contains("25005"))
			{
				if (SocketService.Instance != null && SocketService.Instance.Chat != null && SocketService.Instance.Chat.SingleChatBuddy != null)
				{
					_ssmService.GetBuddyListAsync();
				}
				_page.HideUnknownMessage();
			}
		});
	}

	private async void _ssmService_BlockBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		DispatchedHandler val = null;
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			UnknownBuddy.IsBlocked = true;
			UnknownBuddy.SetMessage(_chat.Title);
			Buddy buddy = new Buddy();
			buddy.Name = _buddy.Name;
			buddy.Id = default(Guid);
			buddy.BuddyID = _buddy.UnknownUserID;
			buddy.PhoneNumber = _buddy.PhoneNumber;
			_buddyService.BlockBuddy(buddy);
			ChatOnService.Instance.IsBuddiesUpdated = true;
			ChatOnService.Instance.ReUpdateInteraction = true;
			CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
			if (val == null)
			{
				MessageDialog dialog;
				val = (DispatchedHandler)delegate
				{
					//IL_002d: Unknown result type (might be due to invalid IL or missing references)
					//IL_0037: Expected O, but got Unknown
					string text = Utility.sprintf(Utility.GetResourceString("IDS_CHATON_POP_PS_BLOCKED"), _chat.Title);
					dialog = new MessageDialog(text);
					dialog.ShowAsync();
					_page.UpdateListLayout();
					UnknownMessageVisibility = (Visibility)1;
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		}
		else
		{
			await SSMService.ShowCommonErrorMessage(e);
		}
	}

	internal void UpdateBuddyProfile(Buddy buddy)
	{
		try
		{
			if (_chat == null)
			{
				return;
			}
			if (Chat.IsSingleChat() && Chat.SingleChatBuddy.PhoneNumber == buddy.PhoneNumber)
			{
				_chat.NotifyChatProfileImageUpdated();
			}
			List<Message> list = MessageItems.Where((Message x) => x.Sender == buddy.PhoneNumber).ToList();
			foreach (Message item in list)
			{
				item.NotifyImageUpdated();
			}
		}
		catch (Exception)
		{
		}
	}

	internal void DisableContextMenu()
	{
		_isContextMenuDisabled = true;
	}

	internal void UpdateMessageProfile(Buddy buddy)
	{
		if (_chat == null)
		{
			return;
		}
		IEnumerable<Message> enumerable = Chat.MessageItems.Where((Message x) => x.Sender == buddy.PhoneNumber);
		foreach (Message item in enumerable)
		{
			item.NotifyImageUpdated();
		}
	}

	internal void UpdateUnknownBuddyProfile(UnknownUser buddy)
	{
		try
		{
			if (MessageItems == null)
			{
				return;
			}
			List<Message> list = MessageItems.Where((Message x) => x.Sender == buddy.PhoneNumber).ToList();
			foreach (Message item in list)
			{
				item.NotifyImageUpdated();
			}
		}
		catch (Exception)
		{
		}
	}
}
