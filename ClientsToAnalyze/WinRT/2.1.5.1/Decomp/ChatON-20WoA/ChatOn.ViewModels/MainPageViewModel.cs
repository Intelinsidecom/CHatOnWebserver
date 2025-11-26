using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using com.sec.ssm.common;
using Windows.Data.Xml.Dom;
using Windows.UI.Core;
using Windows.UI.Notifications;
using Windows.UI.Popups;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace ChatOn.ViewModels;

public class MainPageViewModel
{
	private const int _timeOutSec = 30;

	private Page _page;

	private RegistrationService _regService;

	private string _uri;

	public MainPageViewModel(Page page)
	{
		_page = page;
		_regService = new RegistrationService();
		try
		{
			PushService.Instance.GetToastNotificationReceived += MainPage_GetToastNotificationReceived;
			TileUpdateManager.CreateTileUpdaterForApplication().EnableNotificationQueue(true);
		}
		catch (Exception)
		{
		}
	}

	private void facebookEvents_FacebookEvent(object sender, string accessToken)
	{
		if (!string.IsNullOrEmpty(accessToken))
		{
			SettingService.SetSignedOnToFacebook(isSignedOn: true);
		}
	}

	public async void CheckisAllowedCountry()
	{
		UserAccountInfo account = RegistrationService.GetUserAccount();
		if (account != null && SelectCountryCodePageViewModel.CodeData.Where((CountryCode x) => x.MCC == account.Mcc).Count() == 0)
		{
			string msg = "This service is not available in your country";
			MessageDialog dialog = new MessageDialog(msg);
			await dialog.ShowAsync();
			Application.Current.Exit();
		}
		else if (account != null && SelectCountryCodePageViewModel.CodeData.Where((CountryCode x) => Utility.GetIsoCodeFromCountryName(x.Name) == account.ISO).Count() == 0)
		{
			string msg2 = "This service is not available in your country";
			MessageDialog dialog2 = new MessageDialog(msg2);
			await dialog2.ShowAsync();
			Application.Current.Exit();
		}
	}

	internal async Task<bool> CheckUserAge()
	{
		string text = Utility.GetResourceString("WP7_CHATON_AGECHECK");
		text = text.Replace("%d", "13");
		return await Utility.ShowOKCancleMessageDialog(text);
	}

	internal async Task<bool> WarnDataPackageUse()
	{
		string text = Utility.GetResourceString("IDS_CHATON_POP_CHATON_IS_FREE_TO_USE_HOWEVER_ACCESSING_A_NETWORK_SERVICE_SUCH_AS_3G_MAY_INCUR_ADDITIONAL_CHARGES");
		return await Utility.ShowOKCancleMessageDialog(text);
	}

	internal async Task<bool> CheckPushUsed()
	{
		return await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("WP7_CHATON_POP_TURNON_PUSH"));
	}

	internal async Task<bool> ShowPushOffAlert()
	{
		return await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("WP7_CHATON_POP_ALERT_PUSHOFF"), showCancel: false);
	}

	public void OnNavigatedTo(string uri)
	{
		_uri = uri;
	}

	internal async void FindPushService()
	{
		if (await PushService.Instance.InitService())
		{
			string pushChannelUri = PushService.Instance.GetPushChannelUri();
			if (!pushChannelUri.Equals(SettingService.GetPushChannelUri()))
			{
				SettingService.SetPushChannelUri(PushService.Instance.GetPushChannelUri());
				if (!SettingService.IsFirstRun())
				{
					SSMService sSMService = new SSMService();
					sSMService.GetVersionCompleted += ssmService_GetVersionCompleted;
					sSMService.GetVersionAsync(forceUpdate: true);
				}
				else
				{
					LoadingIndicator.StopLoading();
				}
			}
			else
			{
				LoadingIndicator.StopLoading();
			}
		}
		else
		{
			LoadingIndicator.StopLoading();
			MessageDialog dialog = new MessageDialog(Utility.GetResourceString("WP7_CHATON_POP_CANNOT_FIND_PUSH"), Utility.GetResourceString("IDS_CHATON_BODY_PUSH_NOTIFICATIONS"));
			await dialog.ShowAsync();
			PushService.Instance.StopService();
		}
		OpenNextPage();
	}

	private void ssmService_GetVersionCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_003c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0046: Expected O, but got Unknown
		(sender as SSMService).GetVersionCompleted -= ssmService_GetVersionCompleted;
		LoadingIndicator.StopLoading();
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			if (e.Error != null && !string.IsNullOrEmpty(e.Error.ToString()))
			{
				Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_FAILED_TO_REGISTER_FOR_PUSH_NOTIFICATIONS"), showCancel: false);
				SettingService.SetUsingPushNotification(isUsed: false);
				SettingService.SetToggleNewUpdatesPushNotification(isUsed: false);
				SettingService.SetTogglePushMarketingNotification(isUsed: false);
			}
		});
	}

	internal void OpenNextPage()
	{
		//IL_0030: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		//IL_006b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0071: Expected O, but got Unknown
		DispatchedHandler val = null;
		DispatchedHandler val2 = null;
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		if (userAccount == null || string.IsNullOrEmpty(userAccount.Uid))
		{
			CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)delegate
				{
					_page.Frame.Navigate(typeof(SyncIntroPage));
					ApplicationView.TryUnsnap();
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		}
		else
		{
			if (!string.IsNullOrEmpty(SettingService.GetPassword()) && SettingService.GetCheckPassword())
			{
				CoreDispatcher dispatcher2 = ((DependencyObject)_page).Dispatcher;
				if (val2 == null)
				{
					val2 = (DispatchedHandler)delegate
					{
						_page.Frame.Navigate(typeof(InputPasswordPage));
					};
				}
				dispatcher2.RunAsync((CoreDispatcherPriority)0, val2);
				return;
			}
			if (!_uri.Contains("sessionID") && !_uri.Contains("Pinned"))
			{
				if (_uri.Contains("FileId"))
				{
					PageNavigationService.OpenChatChooserPage(_page);
				}
				else if (userAccount != null && !string.IsNullOrEmpty(userAccount.Uid))
				{
					if (ChatDetailPage.ActiveInstance != null)
					{
						return;
					}
					PageNavigationService.OpenSplashScreen(_page);
				}
			}
		}
		SettingService.SetCheckPassword(value: true);
	}

	public async void MainPage_GetToastNotificationReceived(object sender, PushNotificationArgs args)
	{
		string title = string.Empty;
		string value = string.Empty;
		XmlElement val = (XmlElement)args.XmlArgs.SelectSingleNode("/toast");
		XmlNodeList elementsByTagName = val.GetElementsByTagName("text");
		string xml = val.GetXml();
		if (!xml.ToString().Contains("msgType") || !xml.ToString().Contains("chatType"))
		{
			return;
		}
		foreach (IXmlNode item in (IEnumerable<IXmlNode>)elementsByTagName)
		{
			XmlNamedNodeMap attributes = item.Attributes;
			foreach (IXmlNode item2 in (IEnumerable<IXmlNode>)attributes)
			{
				if (item2.NodeValue.ToString().Equals("1"))
				{
					title = ((IXmlNodeSerializer)item).InnerText;
				}
				if (item2.NodeValue.ToString().Equals("2"))
				{
					value = ((IXmlNodeSerializer)item).InnerText;
				}
			}
		}
		string attribute = val.GetAttribute("launch");
		SSMServer serverInfo = SSMService.GetServerInfo();
		long estimatedServerTime = serverInfo.GetEstimatedServerTime();
		Utility.GetDateTimeFromMiliseconds(estimatedServerTime);
		string[] array = attribute.Split('?', '&');
		string sessionID = "";
		string senderNumber = "";
		string address = "";
		int port = 0;
		long numberID = 0L;
		int receiverCount = 0;
		ChatType type = ChatType.SINGLE;
		MsgType msgType = MsgType.TEXT;
		string[] array2 = array;
		foreach (string text in array2)
		{
			string[] array3 = text.Split('=');
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
		value = WebUtility.HtmlDecode(value);
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
		newMsg.Text = value.Replace("\\", "");
		if (newMsg.Sender.Substring(0, 4) == "0999")
		{
			TileUpdateManager.CreateTileUpdaterForApplication().Clear();
			return;
		}
		if (Utility.IsAllEmoticon(newMsg.Text))
		{
			TileUpdateManager.CreateTileUpdaterForApplication().Clear();
		}
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			SSMService ssmService = new SSMService();
			DataService dataService = new DataService();
			BuddyService buddyService = new BuddyService(dataService, ssmService);
			ChatService chatService = new ChatService(dataService, buddyService, RegistrationService.ChatOnID);
			dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == senderNumber);
			Message exsitingMessage = dataService.MessageItems.FirstOrDefault((Message m) => m.NumberID == newMsg.NumberID || (m.Text == newMsg.Text && m.Time == newMsg.Time));
			if (exsitingMessage != null)
			{
				return;
			}
			Chat chat = await chatService.ReflectUnreadMessage(newMsg);
			chatService.AddMessageToShow(chat, newMsg);
			if (chat != null)
			{
				chatService.UpdateChatSummary(chat);
			}
			if (chat.MemberList.Count != receiverCount)
			{
				ssmService.GetChatMemberListCompleted += async delegate(object s2, SSMCompletedEventArgs e2)
				{
					if (e2.StatusCode == HttpStatusCode.OK)
					{
						if (e2.Xml != null)
						{
							chatService.ApplyChatMemberList(chat, e2.Xml);
						}
					}
					else if (e2.Error != null)
					{
						await SSMService.ShowCommonErrorMessage(e2);
					}
				};
				ssmService.GetChatMemberListAsync(sessionID);
			}
			Buddy buddy = buddyService.GetBuddy(senderNumber);
			if (buddy == null)
			{
				buddyService.SaveOrUpdateUnknownUser(senderNumber, title);
			}
			else
			{
				MyContact myContact = dataService.ContactItems.FirstOrDefault((MyContact c) => buddy.OrgNumber.Contains(c.PhoneNumber) || c.PhoneNumber.Contains(buddy.OrgNumber));
				if (myContact == null && string.IsNullOrEmpty(buddy.SamsungEmail))
				{
					buddy.Name = title;
				}
			}
			dataService.BuddyDBSubmitChanges();
			dataService.ChatDBSubmitChanges();
			try
			{
				if (ChatDetailPage.ActiveInstance != null && ChatListPage.ActiveInstance.IsOpened)
				{
					ChatDetailPage.ActiveInstance.OnToastNotification(senderNumber, sessionID, type);
				}
				if (PivotPage.ActiveInstance != null)
				{
					PivotPage.ActiveInstance.ViewModel.UpdateChatUnreadCount();
					PivotPage.ActiveInstance.UpdateChatList(openChatList: false);
				}
			}
			catch (Exception ex)
			{
				Logger.Log("Error Received Toast => " + ex.Message, LogType.Critical);
			}
		});
	}

	private void LogRecievedMessage(Message newMsg)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.AppendLine("Msg ID : " + newMsg.NumberID);
		stringBuilder.AppendLine("Session ID : " + newMsg.SessionID);
		stringBuilder.AppendLine("Server IP : " + newMsg.Address);
		stringBuilder.AppendLine("Receive Time : " + newMsg.Time);
		stringBuilder.AppendLine("Type : " + newMsg.Type);
		stringBuilder.AppendLine("Content : " + newMsg.Text);
	}
}
