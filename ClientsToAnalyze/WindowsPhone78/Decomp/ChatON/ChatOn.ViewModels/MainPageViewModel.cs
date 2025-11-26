using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Threading;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using com.sec.ssm.common;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Notification;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Media;

namespace ChatOn.ViewModels;

public class MainPageViewModel : NotificationObject
{
	private enum CheckingState
	{
		AgeCheck,
		Exit,
		PushCheck,
		PushWait,
		PushNoti,
		Finished
	}

	private const int _timeOutSec = 30;

	private PhoneApplicationPage _page;

	private RegistrationService _regService;

	private IDictionary<string, string> _parameters;

	private DispatcherTimer _timer;

	private DispatcherTimer _idleTimer;

	private CheckingState _state;

	public MainPageViewModel(PhoneApplicationPage page)
	{
		_page = page;
		_regService = new RegistrationService();
		PushService.Instance.GetToastNotificationReceived += MainPage_GetToastNotificationReceived;
		PushService.Instance.PushChannelErrorOccurred += MainPage_PushChannelErrorOccurred;
		_idleTimer = new DispatcherTimer();
		_idleTimer.Interval = TimeSpan.FromMilliseconds(200.0);
		_idleTimer.Tick += _idleTimer_Tick;
	}

	private void _idleTimer_Tick(object sender, EventArgs e)
	{
		//IL_0047: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		if (_state == CheckingState.AgeCheck)
		{
			string wP7_CHATON_AGECHECK = ResContainer.WP7_CHATON_AGECHECK;
			wP7_CHATON_AGECHECK = wP7_CHATON_AGECHECK.Replace("%d", "13");
			if (MessageBoxResult.OK != MessageBox.Show(wP7_CHATON_AGECHECK, ResContainer.IDS_CHATON_BODY_CHATON, MessageBoxButton.OKCancel))
			{
				_state = CheckingState.Exit;
			}
			else
			{
				_state = CheckingState.PushCheck;
			}
			return;
		}
		if (_state == CheckingState.Exit)
		{
			try
			{
				Game val = new Game();
				val.Exit();
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		if (_state == CheckingState.PushCheck)
		{
			if (MessageBoxResult.OK == MessageBox.Show(ResContainer.WP7_CHATON_POP_TURNON_PUSH, ResContainer.IDS_CHATON_BODY_PUSH_NOTIFICATIONS, MessageBoxButton.OKCancel))
			{
				_state = CheckingState.PushWait;
				FindPushService();
			}
			else
			{
				_state = CheckingState.PushNoti;
			}
		}
		else if (_state == CheckingState.PushNoti)
		{
			MessageBox.Show(ResContainer.WP7_CHATON_POP_ALERT_PUSHOFF, ResContainer.IDS_CHATON_BODY_PUSH_NOTIFICATIONS, MessageBoxButton.OK);
			_state = CheckingState.Finished;
		}
		else if (_state == CheckingState.Finished)
		{
			_idleTimer.Stop();
			PageNavigationService.OpenAllowLocationPage(_page);
			SettingService.SetFirstRun(isFirst: false);
		}
	}

	public void OnNavigatedTo(IDictionary<string, string> parameter)
	{
		_parameters = parameter;
		if (SettingService.IsUsingPushNotification())
		{
			FindPushService();
		}
		else
		{
			OpenNextPage();
		}
	}

	private void FindPushService()
	{
		PushService.Instance.PushChannelUpdated += MainPage_PushChannelUpdated;
		PushService.Instance.PushChannelOpenFailed += MainPage_PushChannelOpenFailed;
		PushService.Instance.InitService();
		if (PushService.Instance.IsEnable())
		{
			_state = CheckingState.Finished;
			OpenNextPage();
			return;
		}
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			Utility.ShowSystemTrayProgress(_page, ResContainer.IDS_CHATON_BODY_FINDING_PUSH);
			_timer = new DispatcherTimer();
			_timer.Interval = TimeSpan.FromSeconds(30.0);
			_timer.Tick += delegate
			{
				_timer.Stop();
				_state = CheckingState.Finished;
				Utility.HideSystemTrayProgress(_page);
				if (MessageBoxResult.OK == MessageBox.Show(ResContainer.IDS_CHATON_POP_CANNOT_FIND_PUSH))
				{
					PushService.Instance.StopService();
					OpenNextPage();
				}
			};
			_timer.Start();
		});
	}

	private void MainPage_PushChannelUpdated(object sender, NotificationChannelUriEventArgs e)
	{
		_state = CheckingState.Finished;
		PushService.Instance.PushChannelUpdated -= MainPage_PushChannelUpdated;
		if (!SettingService.IsFirstRun())
		{
			SSMService sSMService = new SSMService();
			sSMService.GetVersionAsync(forceUpdate: true);
		}
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			if (_timer != null && _timer.IsEnabled)
			{
				_timer.Stop();
			}
			OpenNextPage();
		});
	}

	private void MainPage_PushChannelOpenFailed(object sender, PushServiceEventArgs e)
	{
		_state = CheckingState.Finished;
		PushService.Instance.PushChannelOpenFailed -= MainPage_PushChannelOpenFailed;
		if (!e.HasToNotify)
		{
			return;
		}
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			_timer.Stop();
			if (MessageBoxResult.OK == MessageBox.Show(e.ErrorDetail))
			{
				OpenNextPage();
			}
		});
	}

	private void MainPage_PushChannelErrorOccurred(object sender, PushServiceEventArgs e)
	{
		if (!e.HasToNotify)
		{
			return;
		}
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			if (string.IsNullOrEmpty(e.ErrorSummary))
			{
				MessageBox.Show(e.ErrorDetail, e.ErrorSummary, MessageBoxButton.OK);
			}
			else
			{
				MessageBox.Show(e.ErrorDetail);
			}
		});
	}

	internal void OpenNextPage()
	{
		//IL_01e7: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ee: Expected O, but got Unknown
		if (SettingService.IsFirstRun())
		{
			if (!_idleTimer.IsEnabled)
			{
				_state = CheckingState.AgeCheck;
				_idleTimer.Start();
			}
			return;
		}
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		if (SettingService.IsFirstRun())
		{
			PageNavigationService.OpenAllowLocationPage(_page);
			SettingService.SetFirstRun(isFirst: false);
		}
		else if (userAccount == null || string.IsNullOrEmpty(userAccount.Uid))
		{
			PageNavigationService.OpenSelectLanguagePage(_page);
		}
		else if (_parameters.ContainsKey("sessionID"))
		{
			string text = _parameters["senderID"];
			string s = _parameters["chatType"];
			ChatType chatType = (ChatType)int.Parse(s);
			SSMService ssmService = new SSMService();
			DataService dataService = new DataService();
			BuddyService buddyService = new BuddyService(dataService, ssmService);
			ChatService chatService = new ChatService(dataService, buddyService, RegistrationService.GetUserNumber());
			Chat chat = chatService.StartChat(text, text, (chatType != ChatType.BROADCAST) ? chatType : ChatType.SINGLE, _parameters["sessionID"]);
			chat.Address = _parameters["IP"];
			chat.Port = int.Parse(_parameters["PORT"]);
			chat.IsChanged = true;
			chatService.UpdateChatSummary(chat);
			PageNavigationService.OpenChatDetailPage(chat, _page);
			buddyService.LoadBuddiesProfileImage();
		}
		else if (_parameters.ContainsKey("Pinned"))
		{
			string text2 = _parameters["Pinned"];
			SSMService ssmService2 = new SSMService();
			DataService dataService2 = new DataService();
			BuddyService buddyService2 = new BuddyService(dataService2, ssmService2);
			ChatService chatService2 = new ChatService(dataService2, buddyService2, RegistrationService.GetUserNumber());
			Chat chat2 = chatService2.StartChat(text2, text2, ChatType.SINGLE);
			chatService2.UpdateChatSummary(chat2);
			PageNavigationService.OpenChatDetailPage(chat2, _page);
			buddyService2.LoadBuddiesProfileImage();
		}
		else if (_parameters.ContainsKey("FileId"))
		{
			_ = _parameters["FileId"];
			MediaLibrary val = new MediaLibrary();
			Picture pictureFromToken = val.GetPictureFromToken(_parameters["FileId"]);
			ChatOnService.Instance.StreamToShare = pictureFromToken.GetImage();
			PageNavigationService.OpenChatChooserPage(_page);
			val.Dispose();
		}
		else if (userAccount != null && !string.IsNullOrEmpty(userAccount.Uid))
		{
			PageNavigationService.OpenPivotPage(_page);
		}
	}

	public void MainPage_GetToastNotificationReceived(object sender, NotificationEventArgs e)
	{
		SSMServer serverInfo = SSMService.GetServerInfo();
		long estimatedServerTime = serverInfo.GetEstimatedServerTime();
		Utility.GetDateTimeFromMiliseconds(estimatedServerTime);
		string title = string.Empty;
		string content = string.Empty;
		string text = string.Empty;
		try
		{
			title = e.Collection["wp:Text1"];
			content = e.Collection["wp:Text2"];
			text = e.Collection["wp:Param"];
		}
		catch (Exception)
		{
			((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
			});
		}
		string[] array = text.Split('?', '&');
		string sessionID = "";
		string senderNumber = "";
		string address = "";
		int port = 0;
		long numberID = 0L;
		int receiverCount = 0;
		ChatType type = ChatType.SINGLE;
		MsgType msgType = MsgType.TEXT;
		string[] array2 = array;
		foreach (string text2 in array2)
		{
			string[] array3 = text2.Split('=');
			if (array3[0] == "IP")
			{
				address = array3[1];
			}
			else if (array3[0] == "PORT")
			{
				port = int.Parse(array3[1]);
			}
			else if (array3[0] == "msgID")
			{
				numberID = long.Parse(array3[1]);
			}
			else if (array3[0] == "senderID")
			{
				senderNumber = array3[1];
			}
			else if (array3[0] == "msgType")
			{
				msgType = (MsgType)int.Parse(array3[1]);
			}
			else if (array3[0] == "chatType")
			{
				type = (ChatType)int.Parse(array3[1]);
			}
			else if (array3[0] == "sessionID")
			{
				sessionID = array3[1];
			}
			else if (array3[0] == "rc")
			{
				receiverCount = int.Parse(array3[1]);
			}
		}
		Message newMsg = new Message();
		newMsg.Sender = senderNumber;
		newMsg.NumberID = numberID;
		newMsg.SessionID = sessionID;
		newMsg.Time = estimatedServerTime;
		newMsg.ActivityState = Message.State.Received;
		newMsg.ChatType = type;
		newMsg.Address = address;
		newMsg.Port = port;
		newMsg.Type = msgType.ToString().ToLower();
		newMsg.ReceiverCount = receiverCount;
		newMsg.Tid = "";
		newMsg.Text = content;
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			//IL_00c8: Unknown result type (might be due to invalid IL or missing references)
			//IL_00d2: Expected O, but got Unknown
			SSMService ssmService = new SSMService();
			DataService dataService = new DataService();
			BuddyService buddyService = new BuddyService(dataService, ssmService);
			ChatService chatService = new ChatService(dataService, buddyService, RegistrationService.GetUserNumber());
			Chat chat = chatService.ReflectUnreadMessage(newMsg);
			if (chat != null)
			{
				chatService.UpdateChatSummary(chat);
			}
			Buddy buddy = buddyService.GetBuddy(senderNumber);
			if (buddy == null)
			{
				buddyService.SaveOrUpdateUnknownUser(senderNumber, title);
			}
			else
			{
				MyContact myContact = dataService.ContactItems.FirstOrDefault((MyContact c) => buddy.OrgNumber.Contains(c.PhoneNumber) || c.PhoneNumber.Contains(buddy.OrgNumber));
				if (myContact == null)
				{
					buddy.Name = title;
				}
			}
			dataService.SubmitChanges();
			PhoneApplicationPage page = default(PhoneApplicationPage);
			ref PhoneApplicationPage reference = ref page;
			object content2 = ((ContentControl)(PhoneApplicationFrame)Application.Current.RootVisual).Content;
			reference = (PhoneApplicationPage)((content2 is PhoneApplicationPage) ? content2 : null);
			if (page is ChatDetailPage chatDetailPage)
			{
				chatDetailPage.OnToastNotification(senderNumber, sessionID, type);
			}
			if (page is PivotPage pivotPage)
			{
				pivotPage.OnMessageReceived();
			}
			Utility.ShowSystemTrayProgress(page, title + "-" + content, isIndeterminate: false);
			DispatcherTimer timer = new DispatcherTimer();
			timer.Interval = TimeSpan.FromSeconds(5.0);
			timer.Tick += delegate
			{
				timer.Stop();
				if (((object)page).GetType() == typeof(PivotPage) || ((object)page).GetType() == typeof(ChatChooserPage) || ((object)page).GetType() == typeof(SelectBuddyPage))
				{
					Utility.HideSystemTrayProgress(page);
				}
				else
				{
					Utility.HideSystemTrayProgress(page, HideProgressOnly: true);
				}
			};
			timer.Start();
		});
	}

	private void ssmService_UnreadMessageCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Xml == null)
		{
			return;
		}
		((DependencyObject)(object)_page).Dispatcher.BeginInvoke(delegate
		{
			//IL_005d: Unknown result type (might be due to invalid IL or missing references)
			//IL_0067: Expected O, but got Unknown
			SSMService ssmService = new SSMService();
			DataService dataService = new DataService();
			BuddyService buddyService = new BuddyService(dataService, ssmService);
			MessageService messageService = new MessageService(dataService, ssmService);
			ChatService chatService = new ChatService(dataService, buddyService, RegistrationService.GetUserNumber());
			messageService.ParseFromXml(e.Xml);
			chatService.ReflectUnreadMessage(e.Value as string);
			object content = ((ContentControl)(PhoneApplicationFrame)Application.Current.RootVisual).Content;
			PhoneApplicationPage val = (PhoneApplicationPage)((content is PhoneApplicationPage) ? content : null);
			if (val is PivotPage pivotPage)
			{
				pivotPage.OnMessageReceived();
			}
		});
	}
}
