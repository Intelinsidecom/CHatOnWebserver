using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatON_WoA.Controls;
using ChatON_WoA.InfraStructure;
using ChatOn_WoA.Services;
using ChatON_WoA.Services;
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

public sealed class SamsungAccountSigninDialog : UserControl, IComponentConnector
{
	private SamsungAccountService _ssaService;

	private SSMService _ssmService;

	private string _email;

	private string _signInUrl;

	public static string Type;

	private DataService _dataService;

	private BuddyService _buddyService;

	private ChatService _chatService;

	private bool _loadBuddyCompleted;

	private bool _loadChatCompleted;

	private static SamsungAccountSigninDialog _activeIndicator;

	private List<Chat> ChatList;

	private bool _loadMessageCompleted;

	private int GetAllMessageRun;

	private bool IsPageResendEmail;

	private Page _page;

	private bool _isCancelable;

	private bool _isAlreadySuccesLogined;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid SamsungAccountSignInGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private WebView SamsungAccountWebBrowser;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static SamsungAccountSigninDialog ActiveIndicator => _activeIndicator;

	public static bool HandleBackKey()
	{
		if (_activeIndicator != null && !_activeIndicator._isCancelable)
		{
			return true;
		}
		if (_activeIndicator != null)
		{
			_activeIndicator.Close();
		}
		return false;
	}

	public static void StopLoading()
	{
		if (_activeIndicator != null)
		{
			_activeIndicator.Close();
		}
	}

	internal void Close()
	{
		_activeIndicator = null;
		if (_page != null)
		{
			if (_page.BottomAppBar != null)
			{
				((UIElement)_page.BottomAppBar).put_Visibility((Visibility)0);
			}
			((UIElement)_page).put_IsHitTestVisible(true);
		}
		DependencyObject parent = ((FrameworkElement)this).Parent;
		Panel val = (Panel)(object)((parent is Panel) ? parent : null);
		if (val != null)
		{
			((ICollection<UIElement>)val.Children).Remove((UIElement)(object)this);
		}
	}

	public unsafe SamsungAccountSigninDialog(Page page, Panel root, bool isCancelable = false)
	{
		//IL_00e2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ec: Expected O, but got Unknown
		//IL_0112: Unknown result type (might be due to invalid IL or missing references)
		//IL_011c: Expected O, but got Unknown
		//IL_0171: Unknown result type (might be due to invalid IL or missing references)
		//IL_017b: Expected O, but got Unknown
		InitializeComponent();
		_ssaService = new SamsungAccountService();
		_ssmService = new SSMService();
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.ChatOnID);
		_ssmService.GetBuddyCompleted += _ssmService_GetBuddyCompleted;
		_ssmService.GetChatListInfoCompleted += _ssmService_GetChatListInfoCompleted;
		_ssmService.SetMappingDeviceCompleted += _ssmService_SetMappingDeviceCompleted;
		_ssmService.UpdateUserProfileCompleted += _ssmService_UpdateUserProfileCompleted;
		WebView samsungAccountWebBrowser = SamsungAccountWebBrowser;
		WindowsRuntimeMarshal.AddEventHandler(new Func<LoadCompletedEventHandler, EventRegistrationToken>(samsungAccountWebBrowser, (nint)__ldftn(WebView.add_LoadCompleted)), new Action<EventRegistrationToken>(samsungAccountWebBrowser, (nint)__ldftn(WebView.remove_LoadCompleted)), new LoadCompletedEventHandler(SamsungAccountWebBrowser_LoadCompleted));
		WebView samsungAccountWebBrowser2 = SamsungAccountWebBrowser;
		WindowsRuntimeMarshal.AddEventHandler(new Func<WebViewNavigationFailedEventHandler, EventRegistrationToken>(samsungAccountWebBrowser2, (nint)__ldftn(WebView.add_NavigationFailed)), new Action<EventRegistrationToken>(samsungAccountWebBrowser2, (nint)__ldftn(WebView.remove_NavigationFailed)), new WebViewNavigationFailedEventHandler(SamsungAccountWebBrowser_NavigationFailed));
		Grid.SetRowSpan((FrameworkElement)(object)this, 99);
		Grid.SetColumnSpan((FrameworkElement)(object)this, 99);
		_activeIndicator = this;
		_isCancelable = isCancelable;
		_page = page;
		((ICollection<UIElement>)root.Children).Add((UIElement)(object)this);
		Window current = Window.Current;
		WindowsRuntimeMarshal.AddEventHandler(new Func<WindowActivatedEventHandler, EventRegistrationToken>(current, (nint)__ldftn(Window.add_Activated)), new Action<EventRegistrationToken>(current, (nint)__ldftn(Window.remove_Activated)), new WindowActivatedEventHandler(Current_Activated));
	}

	private void Current_Activated(object sender, WindowActivatedEventArgs e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		//IL_000e: Invalid comparison between Unknown and I4
		if ((int)e.WindowActivationState == 0 && (int)ApplicationView.Value != 2 && SamsungAccountWebBrowser.Source.IsAbsoluteUri && !SamsungAccountWebBrowser.Source.AbsoluteUri.Contains("account/signInOAuth2.do") && !IsPageResendEmail)
		{
			ReCancel();
		}
	}

	private void _ssmService_GetAllMessageCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)(-1), (DispatchedHandler)async delegate
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
							if (list.Count != 0)
							{
								chat.LastSyncTid = long.Parse(list.Last().Tid) - 1;
								List<Message> list2 = list.Where((Message x) => x.Type == "noti").ToList();
								if (list2.Count == list.Count && isHasMore)
								{
									Task.Run(delegate
									{
										_ssmService.GetAllMessageAsync(chat.SessionID, chat.LastSyncTid.ToString(), "5");
									});
								}
								else
								{
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
							}
						}
					}
					else
					{
						HandleNetworkErrorRetrySync();
						GetAllMessageRun = 0;
					}
				}
			}
			catch
			{
			}
		});
		GetAllMessageRun++;
		if (GetAllMessageRun == ChatList.Count - 1)
		{
			_loadMessageCompleted = true;
			NotifySyncCompleted();
		}
	}

	private async void _ssmService_GetChatListInfoCompleted(object sender, SSMCompletedEventArgs e)
	{
		try
		{
			if (e.StatusCode == HttpStatusCode.OK)
			{
				if (e.Xml != null)
				{
					_chatService.ApplyChatInfoAllusingJoinTime(e.Xml);
				}
				_loadChatCompleted = true;
				ChatList = _dataService.ChatItems.Where((Chat x) => !string.IsNullOrEmpty(x.SessionID)).ToList();
				NotifySyncCompleted();
			}
			else if (e.StatusCode == HttpStatusCode.NoContent)
			{
				_loadChatCompleted = true;
				NotifySyncCompleted();
			}
			else
			{
				HandleNetworkErrorRetrySync();
			}
		}
		catch (Exception)
		{
		}
	}

	private void NotifySyncCompleted()
	{
		//IL_0024: Unknown result type (might be due to invalid IL or missing references)
		//IL_002e: Expected O, but got Unknown
		if (_loadBuddyCompleted && _loadChatCompleted)
		{
			((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
			{
				SyncLoadingIndicator.StopLoading();
				_chatService.UpdateAllChatSummary();
				PivotPage.ActiveInstance.ViewModel.BuddyItems.Clear();
				PivotPage.ActiveInstance.ViewModel.ShowingItems.Clear();
				SSMService.SaveBuddySayBlindSetting(isBlind: true);
				PivotPage.ActiveInstance.ViewModel.UpdateList();
				PivotPage.ActiveInstance.UpdateView();
				PivotPage.ActiveInstance.ViewModel.SelectedPivotIndex = 0;
				PageNavigationService.OpenPivotPage(_page);
			});
		}
	}

	private async void _ssmService_GetBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		DispatchedHandler val = null;
		try
		{
			if (e.Xml != null)
			{
				_buddyService.AddBuddyFromXml(e.Xml);
				_buddyService.RemoveEmptyBuddyGroup();
				SSMService.SetForceUpdateInteraction();
				InteractionRankService.Instance.LoadInteractionRankAsync();
			}
			else if (!string.IsNullOrEmpty(e.ErrorMessage))
			{
				if (e.ErrorMessage.Contains("CCS-00900"))
				{
					CoreDispatcher dispatcher = ((DependencyObject)this).Dispatcher;
					if (val == null)
					{
						val = (DispatchedHandler)async delegate
						{
							if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_ERROR_OCCURRED_TRY_AGAIN")))
							{
								_ssmService.GetBuddyListAsync();
							}
						};
					}
					dispatcher.RunAsync((CoreDispatcherPriority)0, val);
				}
			}
			else if (e.Error != null)
			{
				if (e.StatusCode == HttpStatusCode.NoContent)
				{
					_loadBuddyCompleted = true;
					NotifySyncCompleted();
					return;
				}
				HandleNetworkErrorRetrySync();
			}
			_loadBuddyCompleted = true;
			NotifySyncCompleted();
		}
		catch (Exception)
		{
		}
	}

	private async void SamsungAccountWebBrowser_NavigationFailed(object sender, WebViewNavigationFailedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (!_isAlreadySuccesLogined)
		{
			await HandleNetworkErrorRetryLogin();
		}
	}

	private async Task HandleNetworkErrorRetryLogin()
	{
		if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR")))
		{
			if (LoadingIndicator.ActiveIndicator != null)
			{
				LoadingIndicator.StopLoading();
			}
			LoadingIndicator.StartLoading(null, (Panel)(object)SamsungAccountSignInGrid, Utility.GetResourceString("IDS_CHATON_BODY_PLEASE_WAIT_ING"));
			if (Type == "signup")
			{
				_signInUrl = _ssaService.GetSignInUrl();
			}
			else
			{
				_signInUrl = _ssaService.GetSignInUrl();
			}
			SamsungAccountWebBrowser.Navigate(new Uri(_signInUrl, UriKind.Absolute));
		}
	}

	private async void HandleNetworkErrorRetrySync()
	{
		if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR")))
		{
			_loadBuddyCompleted = false;
			_loadChatCompleted = false;
			_loadMessageCompleted = false;
			SSMService.SaveBuddySayBlindSetting(isBlind: true);
			SettingService.SetSendEnterKey(value: true);
			_ssmService.UpdateUserProfileAsync(SSMService.MakeProfileParam("samsungemail", _email));
		}
	}

	private void SamsungAccountSigninDialog_Loaded(object sender, RoutedEventArgs e)
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading(null, (Panel)(object)SamsungAccountSignInGrid, Utility.GetResourceString("IDS_CHATON_BODY_PLEASE_WAIT_ING"));
		if (Type == "signup")
		{
			_signInUrl = _ssaService.GetSignInUrl();
		}
		else
		{
			_signInUrl = _ssaService.GetSignInUrl();
		}
		SamsungAccountWebBrowser.Navigate(new Uri(_signInUrl, UriKind.Absolute));
	}

	private async void SamsungAccountWebBrowser_LoadCompleted(object sender, NavigationEventArgs e)
	{
		try
		{
			((UIElement)SamsungAccountWebBrowser).put_Visibility((Visibility)0);
			string url = e.Uri.OriginalString;
			LoadingIndicator.StopLoading();
			if (url.Contains("account/confirmEmailValidationOAuth2.do"))
			{
				await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_SAPPS_ACTIVATE_YOUR_ACCOUT"), showCancel: false);
				IsPageResendEmail = true;
				return;
			}
			IsPageResendEmail = false;
			if (url.Contains("https://account.samsung.com/mobile/account/userVerifySSN.do"))
			{
				string englishText = "Signing up in ChatON occasionally could not be possible due to Active X installation error in case of using Metro UI.\n";
				englishText += "If you would like to join ChatON service, please use desktop mode then go to Samsung Account.\n";
				_ = englishText + "(URL :  https://account.samsung.com/)";
				string koreanTitle = "챗온을 이용하시는 고객님께 감사드립니다.";
				string koreanText = "Metro UI를 사용하시는 경우 보안키보드(Active X) 설치 오류가 발생하는 경우가 있습니다.\n";
				koreanText += "가입을 원하시면 데스크탑 모드로 이동하신 후 삼성어카운트에 접속하여 가입해주시길 바랍니다.";
				koreanText += "(URL :  https://account.samsung.com/)";
				await Utility.ShowSingleCustomMessageBox(koreanText, koreanTitle, "Confirm");
				ReCancel();
			}
			else if (url.Contains("code"))
			{
				new LoadingIndicator(null, (Panel)(object)SamsungAccountSignInGrid, Utility.GetResourceString("IDS_CHATON_BODY_SIGNING_IN_ING"));
				Dictionary<string, string> ResponseDic = new Dictionary<string, string>();
				SyncIntroPage syncIntroPage;
				SyncIntroPage syncPage = (syncIntroPage = _page as SyncIntroPage);
				if (syncIntroPage != null)
				{
					syncPage.DisableSkipButton();
				}
				int start = url.IndexOf("?") + 1;
				int end = url.Length;
				((UIElement)SamsungAccountWebBrowser).put_Visibility((Visibility)1);
				string Jsonstr = url.Substring(start, end - start);
				StringTokenizer token = new StringTokenizer(Jsonstr, "&");
				while (token.hasMoreTokens())
				{
					string dataLine = token.nextToken();
					StringTokenizer stringTokenizer = new StringTokenizer(dataLine, "=");
					string key = stringTokenizer.nextToken();
					string value = stringTokenizer.nextToken();
					ResponseDic.Add(key, value);
				}
				if (ResponseDic.ContainsKey("error_code"))
				{
					await Utility.ShowOKCancleMessageDialog(ResponseDic["error_description"]);
					return;
				}
				SamsungAccountServiceResult result = await _ssaService.GetAccessToken(ResponseDic["code"]);
				if (result != null && result.ResultType == SamsungAccountServiceResultType.SUCCESS)
				{
					_email = (await _ssaService.GetUserEmail()).ResultString;
					LoadingIndicator.StopLoading();
					if (string.IsNullOrEmpty(RegistrationService.ChatOnID))
					{
						_isAlreadySuccesLogined = true;
						PageNavigationService.OpenInputNamePage(_page, "?mode=SamsungAccount&code=" + SamsungAccountService.AccessToken + "&email=" + _email);
						SettingService.SetSignedOnSamsungAccount(loggedinStatus: true);
						SettingService.SetSamsungEmail(_email);
					}
					else
					{
						LoadingIndicator.StopLoading();
						new SyncLoadingIndicator(null, (Panel)(object)SamsungAccountSignInGrid);
						_ssmService.SetMappingDeviceAsync(_email, SamsungAccountService.AccessToken);
					}
				}
			}
			else if (url.Contains("about:blank") || url.Contains("close=true"))
			{
				ReCancel();
			}
		}
		catch (Exception ex)
		{
			HandleNetworkErrorRetryLogin();
			Logger.Log("[Error Web Samsung Account] => " + ex.Message, LogType.Critical);
		}
	}

	private async void _ssmService_SetMappingDeviceCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode != HttpStatusCode.OK)
		{
			if (e.StatusCode != HttpStatusCode.NoContent)
			{
				await HandleNetworkErrorRetryLogin();
			}
		}
		else
		{
			SSMService.SetForceUpdateChatListInfo();
			_ssmService.UpdateUserProfileAsync(SSMService.MakeProfileParam("samsungemail", _email));
		}
	}

	private void ReSynchronize()
	{
		_ssmService.UpdateUserProfileAsync(SSMService.MakeProfileParam("samsungemail", _email));
	}

	private async void _ssmService_UpdateUserProfileCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK)
		{
			UserProfile userProfile = RegistrationService.GetUserProfile();
			userProfile.Email = _email;
			RegistrationService.SaveUserProfile(userProfile);
			SettingService.SetSignedOnSamsungAccount(loggedinStatus: true);
			SettingService.SetSamsungEmail(_email);
			SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
			SSMService.SetForceUpdateChatListInfo();
			ChatOnService.Instance.ReUpdateBuddyList = true;
			ChatOnService.Instance.ReUpdateChatList = true;
			_ssmService.GetBuddyListAsync();
			_ssmService.GetChatListInfoAsync();
		}
		else if (e.StatusCode != HttpStatusCode.NoContent)
		{
			HandleNetworkErrorRetrySync();
		}
	}

	private CustomPopup GetParentPopup()
	{
		DependencyObject parent = ((FrameworkElement)this).Parent;
		Grid val = (Grid)(object)((parent is Grid) ? parent : null);
		return ((FrameworkElement)val).Parent as CustomPopup;
	}

	public void ReCancel()
	{
		((UIElement)SamsungAccountWebBrowser).put_Visibility((Visibility)1);
		SamsungAccountWebBrowser.Navigate(new Uri(_signInUrl));
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading(null, (Panel)(object)SamsungAccountSignInGrid, Utility.GetResourceString("IDS_CHATON_BODY_PLEASE_WAIT_ING"));
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SamsungAccountSigninDialog.xaml"), (ComponentResourceLocation)0);
			SamsungAccountSignInGrid = (Grid)((FrameworkElement)this).FindName("SamsungAccountSignInGrid");
			SamsungAccountWebBrowser = (WebView)((FrameworkElement)this).FindName("SamsungAccountWebBrowser");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Expected O, but got Unknown
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		if (connectionId == 1)
		{
			FrameworkElement val = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(SamsungAccountSigninDialog_Loaded));
		}
		_contentLoaded = true;
	}
}
