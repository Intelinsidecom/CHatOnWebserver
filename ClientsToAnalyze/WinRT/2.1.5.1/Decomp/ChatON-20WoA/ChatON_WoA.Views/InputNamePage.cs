using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using ChatON_WoA.Controls;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Core;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class InputNamePage : Page, IComponentConnector
{
	private SSMService _ssmService;

	private BuddyService _buddyService;

	private ChatService _chatService;

	private DataService _dataService;

	private bool _loadBuddyCompleted;

	private bool _loadChatCompleted;

	private bool _loadMessageCompleted;

	private int GetAllMessageRun;

	private bool _isNew = true;

	private string _mode = "";

	private string _email = "";

	private string _code = "";

	private bool _loadInteractionCompleted;

	private bool _loadRecommendedBuddyCompleted;

	private bool _loadTrunkCompleted;

	private bool _loadHideInteractionCompleted;

	private bool _errorAlreadyDetected;

	private List<Chat> ChatList;

	private bool _syncCompleted;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton NextButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SubText2;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox InputName;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SubText1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button NextBtn;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public InputNamePage()
	{
		InitializeComponent();
		_dataService = new DataService();
		_ssmService = new SSMService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.ChatOnID);
		_ssmService.RegisterUserCompleted += ssmService_RegisterUserCompleted;
		_ssmService.GetBuddyCompleted += _ssmService_GetBuddyCompleted;
		_ssmService.GetChatListInfoCompleted += _ssmService_GetChatListInfoCompleted;
		_ssmService.RegisterUserWithoutAuthCompleted += _ssmService_RegisterUserWithoutAuthCompleted;
		_ssmService.GetServerAddressForWebCompleted += _ssmService_GetServerAddressForWebCompleted;
		_ssmService.RegisterUserFromSamsungAccountCompleted += _ssmService_RegisterUserFromSamsungAccountCompleted;
		_ssmService.GetBuddyRecommendListCompleted += _ssmService_GetBuddyRecommendListCompleted;
		_ssmService.GetTrunkListCompleted += _ssmService_GetTrunkListCompleted;
		_ssmService.GetLatestVersionCompleted += _ssmService_GetLatestVersionCompleted;
		_ssmService.GetVersionCompleted += _ssmService_GetVersionCompleted;
		_ssmService.GetServerAddress4Completed += _ssmService_GetServerAddress4Completed;
		SubText2.put_Text(Utility.GetResourceString("IDS_CHATON_HEADER_ENTER_NAME"));
		pageTitle.put_Text(Utility.GetResourceString("IDS_CHATON_HEADER_REGISTRATION"));
		NextButton.Text = Utility.GetResourceString("IDS_CHATON_SK_NEXT");
		SubText1.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_ENTER_YOUR_REAL_NAME_SO_YOUR_FRIENDS_CAN_RECOGNISE_YOU_EASILY"));
	}

	private void _ssmService_GetLatestVersionCompleted(object sender, SSMCompletedEventArgs e)
	{
	}

	private void InputNamePage_Loaded(object sender, RoutedEventArgs e)
	{
		SettingService.SetSendEnterKey(value: true);
	}

	private async void _ssmService_GetServerAddress4Completed(object sender, SSMCompletedEventArgs e)
	{
		try
		{
			appBar.put_IsOpen(false);
			appBar.put_IsSticky(false);
			((Control)appBar).put_IsEnabled(false);
			LoadingIndicator.StopLoading();
			SyncLoadingIndicator.StopLoading();
			if (!string.IsNullOrEmpty(e.ErrorMessage))
			{
				await SSMService.ShowCommonErrorMessage(e);
				appBar.put_IsOpen(true);
				appBar.put_IsSticky(true);
				((Control)appBar).put_IsEnabled(true);
			}
			else if (e.Error != null)
			{
				if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR")))
				{
					if (LoadingIndicator.ActiveIndicator != null)
					{
						LoadingIndicator.StopLoading();
					}
					LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
					_ssmService.GetServerAddress4Async();
				}
				appBar.put_IsOpen(true);
				appBar.put_IsSticky(true);
				((Control)appBar).put_IsEnabled(true);
			}
			else if (_mode == "SamsungAccount")
			{
				new SyncLoadingIndicator((Page)(object)this, (Panel)(object)LayoutRoot);
				_ssmService.RegisterUserFromSamsungAccountAsync(_code, _email);
			}
			else
			{
				_ssmService.RegisterUserWithoutAuthAsync();
			}
		}
		catch (Exception)
		{
		}
	}

	private async void _ssmService_GetVersionCompleted(object sender, SSMCompletedEventArgs e)
	{
		await ((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			_ssmService.GetVersionCompleted -= _ssmService_GetVersionCompleted;
			SSMServer serverinfo = SSMService.GetServerInfo();
			if (string.IsNullOrEmpty(serverinfo.Key))
			{
				if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR")))
				{
					_ssmService.GetVersionAsync(forceUpdate: true);
				}
				else
				{
					LoadingIndicator.StopLoading();
					SyncLoadingIndicator.StopLoading();
					EnableControl();
				}
			}
			else
			{
				SyncData();
			}
		});
	}

	private void SyncData()
	{
		_ssmService.GetLatestVersionAsync();
		SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
		_ssmService.GetBuddyListAsync();
		_ssmService.GetChatListInfoAsync();
		_ssmService.GetBuddyRecommendListAsync();
	}

	private void _ssmService_GetAllMessageCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)(-1), (DispatchedHandler)delegate
		{
			try
			{
				if (e.StatusCode != HttpStatusCode.NoContent)
				{
					if (e.StatusCode == HttpStatusCode.OK)
					{
						if (e.Xml != null)
						{
							MessageService messageService = new MessageService(_dataService, _ssmService);
							Chat chat = _dataService.ChatItems.Where((Chat x) => x.SessionID == e.Param.ToString()).FirstOrDefault();
							bool isHasMore;
							List<Message> list = messageService.ParseAllMessageFromXml(e.Xml, chat, out isHasMore);
							if (list.Count == 0)
							{
								return;
							}
							chat.LastSyncTid = long.Parse(list.Last().Tid) - 1;
							List<Message> list2 = list.Where((Message x) => x.Type == "noti").ToList();
							if (list2.Count == list.Count && isHasMore)
							{
								Task.Run(delegate
								{
									_ssmService.GetAllMessageAsync(chat.SessionID, chat.LastSyncTid.ToString(), "5");
								});
								return;
							}
							foreach (Message item in list)
							{
								_chatService.AddMessageToShow(chat, item, addToDB: true, toPrev: true);
							}
							_chatService.GetLastMessage(chat);
							_chatService.UpdateChatSummary(chat);
							if (isHasMore)
							{
								chat.PrevMsgStatus = Chat.PrevMsgLoadingStatus.Loading;
							}
							else
							{
								chat.PrevMsgStatus = Chat.PrevMsgLoadingStatus.None;
							}
							_dataService.MessageDBSubmitChanges();
							_dataService.ChatDBSubmitChanges();
						}
						else
						{
							NotifySyncError(e);
						}
					}
					if (GetAllMessageRun == ChatList.Count - 1)
					{
						_loadMessageCompleted = true;
						NotifySyncCompleted();
					}
					GetAllMessageRun++;
				}
			}
			catch
			{
				NotifySyncError(e);
			}
		});
	}

	private void _ssmService_GetInteractionCompleted(object sender, SSMCompletedEventArgs e)
	{
		try
		{
			if (e.StatusCode == HttpStatusCode.OK)
			{
				if (e.Xml == null)
				{
					throw e.Error;
				}
				_buddyService.ApplyRankFromXml(e.Xml);
				_dataService.BuddyDBSubmitChanges();
				_loadInteractionCompleted = true;
				NotifySyncCompleted();
			}
		}
		catch (Exception)
		{
			NotifySyncError(e);
		}
	}

	private void _ssmService_GetInteractionHideListCompleted(object sender, SSMCompletedEventArgs e)
	{
		try
		{
			if (e.Xml != null)
			{
				_buddyService.ApplyInteractionHideListFromXml(e.Xml);
				_loadHideInteractionCompleted = true;
				NotifySyncCompleted();
				return;
			}
			throw e.Error;
		}
		catch (Exception)
		{
			NotifySyncError(e);
		}
	}

	private async void _ssmService_GetTrunkListCompleted(object sender, SSMCompletedEventArgs e)
	{
		try
		{
			if (e.Xml == null)
			{
				if (e.StatusCode == HttpStatusCode.NoContent)
				{
					_loadTrunkCompleted = true;
					NotifySyncCompleted();
					return;
				}
				throw e.Error;
			}
			List<UnreadTrunkInfo> unreadTrunkFromXml = TrunkService.GetUnreadTrunkFromXml(e.Xml);
			foreach (UnreadTrunkInfo item in unreadTrunkFromXml)
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
			ChatList = _dataService.ChatItems.Where((Chat x) => !string.IsNullOrEmpty(x.SessionID)).ToList();
			_dataService.SubmitAllChanges();
			_loadTrunkCompleted = true;
			NotifySyncCompleted();
		}
		catch (Exception)
		{
			NotifySyncError(e);
		}
	}

	private void _ssmService_GetBuddyRecommendListCompleted(object sender, SSMCompletedEventArgs e)
	{
		try
		{
			if (e.Xml == null)
			{
				if (e.StatusCode != HttpStatusCode.NoContent && (e.StatusCode != 0 || e.Error != null || !string.IsNullOrEmpty(e.ErrorMessage)))
				{
					throw e.Error;
				}
				_loadRecommendedBuddyCompleted = true;
				NotifySyncCompleted();
			}
			else
			{
				_buddyService.AddRecommendBuddyFromXml(e.Xml);
				_loadRecommendedBuddyCompleted = true;
				NotifySyncCompleted();
			}
		}
		catch (Exception)
		{
			NotifySyncError(e);
		}
	}

	private async void _ssmService_GetChatListInfoCompleted(object sender, SSMCompletedEventArgs e)
	{
		try
		{
			if (e.Xml == null)
			{
				if (e.StatusCode != HttpStatusCode.NoContent && (e.StatusCode != 0 || e.Error != null || !string.IsNullOrEmpty(e.ErrorMessage)))
				{
					throw e.Error;
				}
				_loadChatCompleted = true;
				NotifySyncCompleted();
			}
			else
			{
				await Task.Run(delegate
				{
					_chatService.ApplyChatInfoAllusingJoinTime(e.Xml, ((DependencyObject)this).Dispatcher);
				});
				_ssmService.GetTrunkListByTimestampAsync(_dataService);
				_loadChatCompleted = true;
				NotifySyncCompleted();
			}
		}
		catch (Exception)
		{
			NotifySyncError(e);
		}
	}

	private void _ssmService_GetBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		try
		{
			if (e.Xml == null)
			{
				if (e.StatusCode != HttpStatusCode.NoContent && (e.StatusCode != 0 || e.Error != null || !string.IsNullOrEmpty(e.ErrorMessage)))
				{
					throw e.Error;
				}
				_loadBuddyCompleted = true;
				NotifySyncCompleted();
			}
			else
			{
				_buddyService.AddBuddyFromXml(e.Xml);
				_buddyService.RemoveEmptyBuddyGroup();
				_buddyService.LoadBuddiesProfileImage();
				_loadBuddyCompleted = true;
				NotifySyncCompleted();
			}
		}
		catch (Exception)
		{
			NotifySyncError(e);
		}
	}

	private void NotifySyncCompleted()
	{
		if (!_syncCompleted && _loadBuddyCompleted && _loadChatCompleted && _loadRecommendedBuddyCompleted)
		{
			_syncCompleted = true;
			SSMService.SaveBuddySayBlindSetting(isBlind: true);
			SettingService.SetFirstTimeBuddySyncFinished(option: true);
			_chatService.UpdateAllChatSummary();
			ChatOnService.Instance.IsGetAllMessage = true;
			SyncLoadingIndicator.StopLoading();
			PageNavigationService.OpenPivotPage((Page)(object)this);
		}
	}

	private async void NotifySyncError(SSMCompletedEventArgs e)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			if (e.StatusCode == HttpStatusCode.NoContent)
			{
				_errorAlreadyDetected = true;
				SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
				SSMService.SaveBuddySayBlindSetting(isBlind: true);
				SSMService.SetForceUpdateChatListInfo();
				SyncLoadingIndicator.StopLoading();
				PageNavigationService.OpenPivotPage((Page)(object)this);
			}
			if (!_errorAlreadyDetected && PivotPage.ActiveInstance == null)
			{
				if (!_errorAlreadyDetected && await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_ERROR_OCCURRED_TRY_AGAIN")))
				{
					((Control)appBar).put_IsEnabled(true);
					appBar.put_IsOpen(true);
					_ssmService.GetBuddyListAsync();
				}
				else
				{
					_errorAlreadyDetected = true;
					SyncLoadingIndicator.StopLoading();
					LoadingIndicator.StopLoading();
					EnableControl();
				}
			}
		}
		catch (Exception)
		{
		}
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			if (e.Parameter != null)
			{
				IDictionary<string, string> dictionary = Utility.BuildParameter(e.Parameter as string);
				if (dictionary.ContainsKey("mode"))
				{
					_mode = dictionary["mode"];
				}
				if (dictionary.ContainsKey("code"))
				{
					_code = dictionary["code"];
				}
				if (dictionary.ContainsKey("email"))
				{
					_email = dictionary["email"];
				}
				if (_mode == "SamsungAccount")
				{
					RegistrationService.RegisterAccount(RegistrationService.TempMcc);
				}
			}
		}
		((Page)this).OnNavigatedTo(e);
	}

	protected override async void OnNavigatedFrom(NavigationEventArgs e)
	{
		_ssmService.GetPushUpdateCompleted += _ssmService_GetPushUpdateCompleted;
		_ssmService.GetPushUpdates(isActive: true);
	}

	private void _ssmService_GetPushUpdateCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ssmService.GetPushUpdateCompleted -= _ssmService_GetPushUpdateCompleted;
		if (e.StatusCode != HttpStatusCode.NoContent && e.StatusCode == HttpStatusCode.OK)
		{
			if (e.ResultString == "true")
			{
				SettingService.SetUsingNewUpdatesPushNotification(isUsed: true);
			}
			else
			{
				SettingService.SetUsingNewUpdatesPushNotification(isUsed: false);
			}
		}
	}

	private void InputName_Loaded(object sender, RoutedEventArgs e)
	{
		((Control)InputName).Focus((FocusState)1);
	}

	private async void NextButton_Click_1(object sender, RoutedEventArgs e)
	{
		InputName.put_Text(InputName.Text.Trim());
		if (string.IsNullOrEmpty(InputName.Text))
		{
			return;
		}
		if (Utility.IsEmojiIconIncluded(InputName.Text))
		{
			await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("WP7_FST_EMOJI_NOT_SUPPORTED"), showCancel: false);
			return;
		}
		ResetState();
		((Control)InputName).put_IsEnabled(false);
		((Control)InputName).put_IsEnabled(true);
		appBar.put_IsOpen(false);
		appBar.put_IsSticky(false);
		((Control)appBar).put_IsEnabled(false);
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
		RegistrationService.SaveName(InputName.Text);
		if (string.IsNullOrEmpty(RegistrationService.ChatOnID))
		{
			_ssmService.GetServerAddress4Async();
			return;
		}
		new SyncLoadingIndicator((Page)(object)this, (Panel)(object)LayoutRoot);
		SyncData();
	}

	private void ResetState()
	{
		_loadBuddyCompleted = false;
		_loadChatCompleted = false;
		_loadHideInteractionCompleted = false;
		_loadInteractionCompleted = false;
		_loadMessageCompleted = false;
		_loadRecommendedBuddyCompleted = false;
		_loadTrunkCompleted = false;
		_errorAlreadyDetected = false;
	}

	public void EnableControl()
	{
		((Control)InputName).put_IsEnabled(true);
		appBar.put_IsOpen(true);
		appBar.put_IsSticky(true);
		((Control)appBar).put_IsEnabled(true);
		((Control)NextButton).put_IsEnabled(true);
	}

	private async void ssmService_RegisterUserCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		SyncLoadingIndicator.StopLoading();
		appBar.put_IsOpen(false);
		appBar.put_IsSticky(false);
		((Control)appBar).put_IsEnabled(false);
		if (e.StatusCode != HttpStatusCode.OK)
		{
			if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR")))
			{
				if (LoadingIndicator.ActiveIndicator != null)
				{
					LoadingIndicator.StopLoading();
				}
				LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
				_ssmService.RegisterUserAsync();
			}
			appBar.put_IsOpen(true);
			appBar.put_IsSticky(true);
			((Control)appBar).put_IsEnabled(true);
		}
		else
		{
			RegistrationService.SaveMSISDN(RegistrationService.TempMSISDN);
			((Page)this).Frame.Navigate(typeof(PivotPage));
		}
	}

	private async void _ssmService_RegisterUserWithoutAuthCompleted(object sender, SSMCompletedEventArgs e)
	{
		SyncLoadingIndicator.StopLoading();
		appBar.put_IsOpen(false);
		appBar.put_IsSticky(false);
		((Control)appBar).put_IsEnabled(false);
		if (e.StatusCode != HttpStatusCode.OK)
		{
			if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_ERROR_OCCURRED_TRY_AGAIN")))
			{
				new SyncLoadingIndicator((Page)(object)this, (Panel)(object)LayoutRoot);
				_ssmService.RegisterUserWithoutAuthAsync();
				return;
			}
			appBar.put_IsOpen(true);
			appBar.put_IsSticky(true);
			((Control)appBar).put_IsEnabled(true);
			await SSMService.ShowCommonErrorMessage(e);
		}
		else
		{
			PageNavigationService.OpenPivotPage((Page)(object)this);
		}
	}

	private async void _ssmService_GetServerAddressForWebCompleted(object sender, SSMCompletedEventArgs e)
	{
		try
		{
			appBar.put_IsOpen(false);
			appBar.put_IsSticky(false);
			((Control)appBar).put_IsEnabled(false);
			LoadingIndicator.StopLoading();
			SyncLoadingIndicator.StopLoading();
			if (!string.IsNullOrEmpty(e.ErrorMessage))
			{
				await SSMService.ShowCommonErrorMessage(e);
				appBar.put_IsOpen(true);
				appBar.put_IsSticky(true);
				((Control)appBar).put_IsEnabled(true);
			}
			else if (e.Error != null)
			{
				if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR")))
				{
					if (LoadingIndicator.ActiveIndicator != null)
					{
						LoadingIndicator.StopLoading();
					}
					LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
					_ssmService.GetServerAddress4Async();
				}
				appBar.put_IsOpen(true);
				appBar.put_IsSticky(true);
				((Control)appBar).put_IsEnabled(true);
			}
			else if (_mode == "SamsungAccount")
			{
				new SyncLoadingIndicator((Page)(object)this, (Panel)(object)LayoutRoot);
				_ssmService.RegisterUserFromSamsungAccountAsync(_code, _email);
			}
			else
			{
				_ssmService.RegisterUserWithoutAuthAsync();
			}
		}
		catch (Exception)
		{
		}
	}

	private async void _ssmService_RegisterUserFromSamsungAccountCompleted(object sender, SSMCompletedEventArgs e)
	{
		DispatchedHandler val = null;
		try
		{
			if (e.StatusCode != HttpStatusCode.OK)
			{
				if (e.ErrorMessage == null)
				{
					if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR")))
					{
						if (LoadingIndicator.ActiveIndicator != null)
						{
							LoadingIndicator.StopLoading();
						}
						LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
						_ssmService.RegisterUserFromSamsungAccountAsync(_code, _email);
					}
					else
					{
						LoadingIndicator.StopLoading();
						SyncLoadingIndicator.StopLoading();
						EnableControl();
					}
				}
				else if (e.ErrorMessage.Contains("CCS-11023"))
				{
					string msg = Utility.GetResourceString("IDS_CHATON_POP_PD_DEVICES_ARE_ALREADY_CONNECTED_DISCONNECT_A_DEVICE_AND_TRY_AGAIN");
					msg = msg.Replace("%d", "5");
					SyncLoadingIndicator.StopLoading();
					if (await Utility.ShowRetryCancleMessageDialog(msg))
					{
						new SyncLoadingIndicator((Page)(object)this, (Panel)(object)LayoutRoot);
						_ssmService.RegisterUserFromSamsungAccountAsync(_code, _email);
					}
					else
					{
						SettingService.SetSignedOnSamsungAccount(loggedinStatus: false);
						SettingService.SetSamsungEmail("");
						Application.Current.Exit();
					}
				}
				else
				{
					appBar.put_IsOpen(true);
					appBar.put_IsSticky(true);
					((Control)appBar).put_IsEnabled(true);
					await SSMService.ShowCommonErrorMessage(e);
				}
				return;
			}
			CoreDispatcher dispatcher = ((DependencyObject)this).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)delegate
				{
					_ssmService.GetVersionAsync(forceUpdate: true);
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		}
		catch (Exception)
		{
			appBar.put_IsOpen(true);
			appBar.put_IsSticky(true);
			((Control)appBar).put_IsEnabled(true);
			SyncLoadingIndicator.StopLoading();
		}
	}

	private void backButton_Click_1(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private void InputName_Focus(object sender, RoutedEventArgs e)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		new AccessibilitySettings();
		((Control)InputName).Focus((FocusState)2);
	}

	private void InputName_TextChanged(object sender, TextChangedEventArgs e)
	{
		InputName.put_Text(Regex.Replace(InputName.Text, "(?:\\r\\n|\\r(?!\\n)|(?!<\\r)\\n){1,}", " "));
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
		//IL_00dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Expected O, but got Unknown
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///InputNamePage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			NextButton = (ImageButton)((FrameworkElement)this).FindName("NextButton");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			SubText2 = (TextBlock)((FrameworkElement)this).FindName("SubText2");
			InputName = (TextBox)((FrameworkElement)this).FindName("InputName");
			SubText1 = (TextBlock)((FrameworkElement)this).FindName("SubText1");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
			NextBtn = (Button)((FrameworkElement)this).FindName("NextBtn");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0024: Unknown result type (might be due to invalid IL or missing references)
		//IL_002a: Expected O, but got Unknown
		//IL_0049: Unknown result type (might be due to invalid IL or missing references)
		//IL_0053: Expected O, but got Unknown
		//IL_0065: Unknown result type (might be due to invalid IL or missing references)
		//IL_006f: Expected O, but got Unknown
		//IL_0075: Unknown result type (might be due to invalid IL or missing references)
		//IL_007b: Expected O, but got Unknown
		//IL_009a: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a4: Expected O, but got Unknown
		//IL_00a5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ab: Expected O, but got Unknown
		//IL_00ca: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d4: Expected O, but got Unknown
		//IL_00d5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00dc: Expected O, but got Unknown
		//IL_00fd: Unknown result type (might be due to invalid IL or missing references)
		//IL_0107: Expected O, but got Unknown
		//IL_010a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0111: Expected O, but got Unknown
		//IL_0132: Unknown result type (might be due to invalid IL or missing references)
		//IL_013c: Expected O, but got Unknown
		//IL_013f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0146: Expected O, but got Unknown
		//IL_0167: Unknown result type (might be due to invalid IL or missing references)
		//IL_0171: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val6 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(InputNamePage_Loaded));
			break;
		}
		case 2:
			((ImageButton)target).Click += new RoutedEventHandler(NextButton_Click_1);
			break;
		case 3:
		{
			TextBox val3 = (TextBox)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TextChangedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(TextBox.add_TextChanged)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(TextBox.remove_TextChanged)), new TextChangedEventHandler(InputName_TextChanged));
			FrameworkElement val4 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(InputName_Loaded));
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_GotFocus)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_GotFocus)), new RoutedEventHandler(InputName_Focus));
			break;
		}
		case 4:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click_1));
			break;
		}
		case 5:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(NextButton_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
