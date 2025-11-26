using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Models;
using ChatOn.Services;
using com.sec.ssm.common;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class ChatListPage : Page, IComponentConnector
{
	private static ChatListPage _activeInstance;

	private SSMService _ssmService;

	private DataService _dataService;

	private BuddyService _buddyService;

	public static bool IsInstantiated = false;

	private bool _isOpened;

	private Chat _lastOpenedDialogBuddy;

	private bool _isChatDetailOpened;

	private bool _isInChatMode;

	private DispatcherTimer delayLoadTimer;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Frame CurrentChatFrame;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid BuddyProfileContainer;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid SelectChatNoticeGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView ChatListView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private EmoticonChooser EmoticonChooserControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static ChatListPage ActiveInstance => _activeInstance;

	public bool IsOpened
	{
		get
		{
			return _isOpened;
		}
		set
		{
			_isOpened = value;
		}
	}

	public bool IsChatDetailOpened
	{
		get
		{
			return _isChatDetailOpened;
		}
		set
		{
			_isChatDetailOpened = value;
		}
	}

	public bool IsInChatMode
	{
		get
		{
			return _isInChatMode;
		}
		set
		{
			_isInChatMode = value;
		}
	}

	public unsafe ChatListPage()
	{
		//IL_0063: Unknown result type (might be due to invalid IL or missing references)
		//IL_006d: Expected O, but got Unknown
		InitializeComponent();
		_activeInstance = this;
		_ssmService = new SSMService();
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_ssmService.GetAllMessageCompleted += _ssmService_GetAllMessageCompleted;
		CurrentChatFrame.put_CacheSize(0);
		delayLoadTimer = new DispatcherTimer();
		DispatcherTimer val = delayLoadTimer;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(val, (nint)__ldftn(DispatcherTimer.remove_Tick)), delayLoadTimer_Tick);
		delayLoadTimer.put_Interval(new TimeSpan(0, 0, 2));
	}

	private async void delayLoadTimer_Tick(object sender, object e)
	{
		delayLoadTimer.Stop();
		if (PivotPage.ActiveInstance != null && PivotPage.ActiveInstance.ViewModel != null)
		{
			if (!SettingService.IsUsingPushNotification())
			{
				await PivotPage.ActiveInstance.ViewModel.GetUnreadMessage();
			}
			PivotPage.ActiveInstance.ViewModel.DeleteAllSpecialBuddyChat();
			PivotPage.ActiveInstance.ViewModel.GetChatListInfoAsync();
			PivotPage.ActiveInstance.ViewModel.UpdateChatList();
		}
	}

	private async void _ssmService_GetAllMessageCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.NoContent || e.StatusCode != HttpStatusCode.OK)
		{
			return;
		}
		if (e.Xml != null)
		{
			DataService dataService = new DataService();
			BuddyService buddyService = new BuddyService(dataService, _ssmService);
			ChatService chatService = new ChatService(dataService, buddyService, RegistrationService.ChatOnID);
			MessageService messageService = new MessageService(dataService, _ssmService);
			new Chat();
			Chat chat = dataService.ChatItems.Where((Chat x) => x.SessionID == e.Param).FirstOrDefault();
			if (chat == null)
			{
				chat = ChatOnService.Instance.RecentChat;
			}
			bool isHasMore;
			List<Message> list = messageService.ParseAllMessageFromXml(e.Xml, chat, out isHasMore);
			if (list.Count == 0)
			{
				return;
			}
			chat.LastSyncTid = long.Parse(list.Last().Tid) - 1;
			foreach (Message item in list)
			{
				chatService.AddMessageToShow(chat, item, addToDB: true, toPrev: true);
			}
			chat.RemoveLatestMessagesForPrevMessagesByMemoryLimit();
			chat.AddDateHeaderAndCheckbox();
			if (isHasMore)
			{
				chat.PrevMsgStatus = Chat.PrevMsgLoadingStatus.Loading;
			}
			else
			{
				chat.PrevMsgStatus = Chat.PrevMsgLoadingStatus.None;
			}
			dataService.MessageDBSubmitChanges();
			dataService.ChatDBSubmitChanges();
			chatService.UpdateChatSummary(chat);
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
	}

	private void ChatListPage_Loaded(object sender, RoutedEventArgs e)
	{
		ChatDetailPage.ActiveInstance.ViewModel.title = "ChatList";
		ChatOnService instance = ChatOnService.Instance;
		if (instance != null && instance.RecentChat != null)
		{
			ActivateChat(instance.RecentChat);
		}
		if (ChatDetailPage.ActiveInstance.ViewModel.Chat == null)
		{
			((UIElement)SelectChatNoticeGrid).put_Visibility((Visibility)0);
			((UIElement)CurrentChatFrame).put_Visibility((Visibility)1);
		}
		else
		{
			((UIElement)SelectChatNoticeGrid).put_Visibility((Visibility)1);
			((UIElement)CurrentChatFrame).put_Visibility((Visibility)0);
		}
	}

	protected override async void OnNavigatedTo(NavigationEventArgs e)
	{
		if (!IsInstantiated)
		{
			CurrentChatFrame.Navigate(typeof(ChatDetailPage));
			IsInstantiated = true;
		}
		if (PivotPage.ActiveInstance.ViewModel != null)
		{
			PivotPage.ActiveInstance.ViewModel.SelectedIndex = 1;
		}
		PivotPage.ActiveInstance.ViewModel.NewTrunkCommentCount = 0;
		_isOpened = true;
		if (!(e.Parameter is Chat chat))
		{
			if (delayLoadTimer != null)
			{
				delayLoadTimer.Start();
			}
			return;
		}
		ActivateChat(chat);
		ScrollSelectedItemIntoView(chat);
		if (delayLoadTimer != null)
		{
			delayLoadTimer.Start();
		}
		PivotPage.ActiveInstance.CloseAllPopup();
	}

	public void ScrollSelectedItemIntoView(object item)
	{
		if (item != null)
		{
			((UIElement)ChatListView).UpdateLayout();
			((ListViewBase)ChatListView).ScrollIntoView(item);
		}
	}

	protected override async void OnNavigatedFrom(NavigationEventArgs e)
	{
		if (delayLoadTimer != null)
		{
			delayLoadTimer.Stop();
		}
		try
		{
			if (!isRelatedChat(e.SourcePageType) && ChatDetailPage.ActiveInstance != null)
			{
				IsInChatMode = false;
				ChatDetailPage.ActiveInstance.ViewModel.AppBarVisibility = (Visibility)1;
				ChatDetailPage.ActiveInstance.Disconnect();
			}
			bool flag = false;
			if (e.Content is ChatListPage chatListPage && (object)((object)chatListPage).GetType() == typeof(ChatListPage))
			{
				flag = chatListPage.IsOpened;
			}
			CloseOpenedDialog(BuddyProfileContainer);
			if (ChatOnService.Instance.RecentChat != null && ChatOnService.Instance.RecentChat.LastMessage == null && !ChatOnService.Instance.RecentChat.IsChanged && !isRelatedChat(e.SourcePageType))
			{
				_dataService.DeleteChat(ChatOnService.Instance.RecentChat);
				PivotPage.ActiveInstance.ViewModel.UpdateChatList();
				ChatOnService.Instance.RecentChat = null;
				int num = PivotPage.ActiveInstance.ViewModel.ChatItems.IndexOf(ChatOnService.Instance.RecentChat);
				((Selector)ChatListView).put_SelectedIndex(num + 1);
				if (((Selector)ChatListView).SelectedItem is Chat chat)
				{
					PivotPage.ActiveInstance.ViewModel.UpdateTrunkUnreadCount(chat);
					if (chat != null)
					{
						PivotPage.ActiveInstance.ViewModel.TrunkButtonVisibility = (Visibility)0;
						((UIElement)CurrentChatFrame).put_Visibility((Visibility)0);
						((UIElement)SelectChatNoticeGrid).put_Visibility((Visibility)1);
						((Control)EmoticonChooserControl).Focus((FocusState)1);
						_isChatDetailOpened = false;
					}
				}
			}
			if (!flag || (flag && ChatOnService.Instance.RecentChat == null))
			{
				((UIElement)CurrentChatFrame).put_Visibility((Visibility)1);
				((UIElement)SelectChatNoticeGrid).put_Visibility((Visibility)0);
				_isChatDetailOpened = true;
				if (ChatOnService.Instance.RecentChat != null)
				{
					ChatOnService.Instance.RecentChat.Background = new SolidColorBrush(Colors.Transparent);
					ChatOnService.Instance.RecentChat = null;
					ClearSelection();
				}
			}
			if (ChatOnService.Instance.RecentChat == null)
			{
				((Selector)ChatListView).put_SelectedIndex(-1);
			}
			else
			{
				((Selector)ChatListView).put_SelectedIndex(((IList<object>)((ItemsControl)ChatListView).Items).IndexOf((object)ChatOnService.Instance.RecentChat));
			}
		}
		catch
		{
		}
	}

	private bool isRelatedChat(Type page)
	{
		if ((object)page == typeof(SelectBuddyPage))
		{
			return true;
		}
		if ((object)page == typeof(ChatListPage))
		{
			return true;
		}
		if ((object)page == typeof(TrunkDetailFullViewPage))
		{
			return true;
		}
		if ((object)page == typeof(TrunkDetailPage))
		{
			return true;
		}
		if ((object)page == typeof(TrunkPage))
		{
			return true;
		}
		if ((object)page == typeof(DownloadSettingPage))
		{
			return true;
		}
		if ((object)page == typeof(ChatProfilePage))
		{
			return true;
		}
		return false;
	}

	private void ChatItem_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (ChatDetailPage.ActiveInstance != null && ChatDetailPage.ActiveInstance.ViewModel != null && ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is Chat chat)
		{
			if (_lastOpenedDialogBuddy != null)
			{
				CloseOpenedDialog(BuddyProfileContainer);
			}
			PivotPage.ActiveInstance.ViewModel.TrunkButtonVisibility = (Visibility)0;
			ActivateChat(chat);
		}
	}

	public void ActivateChat(Chat chat, bool forceRefresh = false)
	{
		if (chat == null || (ChatDetailPage.ActiveInstance.ViewModel.Chat != null && ChatDetailPage.ActiveInstance.ViewModel.Chat == chat && !forceRefresh))
		{
			return;
		}
		ChatOnService.Instance.RecentChat = chat;
		((UIElement)CurrentChatFrame).put_Visibility((Visibility)0);
		((UIElement)SelectChatNoticeGrid).put_Visibility((Visibility)1);
		_isChatDetailOpened = true;
		foreach (Chat chatItem in PivotPage.ActiveInstance.ViewModel.ChatItems)
		{
			chatItem.Background = ((chatItem == chat) ? Chat.colorOrange : Chat.colorTransparent);
			chatItem.UpdateChatSummary(_buddyService);
		}
		ChatDetailPage.ActiveInstance.ViewModel.CancelAllActiveUpload();
		ChatDetailPage.ActiveInstance.ActivateChat(chat);
		ChatDetailPage.ActiveInstance.OnLoaded();
	}

	public void ToggleEmoticonChooser(bool forceHide = false)
	{
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		if (forceHide)
		{
			((UIElement)EmoticonChooserControl).put_Visibility((Visibility)1);
			return;
		}
		if ((int)((UIElement)EmoticonChooserControl).Visibility == 0)
		{
			((UIElement)EmoticonChooserControl).put_Visibility((Visibility)1);
			return;
		}
		((UIElement)EmoticonChooserControl).put_Visibility((Visibility)0);
		EmoticonChooserControl.Load();
	}

	private void ChatItemImageGrid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		Chat chat = null;
		if (!(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is Chat chat2))
		{
			return;
		}
		if (chat2.ChatType == ChatType.SINGLE)
		{
			if (chat2.Sender == RegistrationService.ChatOnID)
			{
				if (chat2.SingleChatBuddy != null)
				{
					chat2.SingleChatBuddy.PhoneNumber.ToString();
				}
			}
			else
			{
				if (ChatDetailPage.IsKeyboardShow)
				{
					((Control)ChatDetailPage.ActiveInstance).Focus((FocusState)1);
				}
				DisplayBuddyProfileDialog(chat2, BuddyProfileContainer);
			}
			_ = chat2.Sender;
		}
		else if (chat2.ChatType == ChatType.GROUP)
		{
			if (!string.IsNullOrEmpty(chat2.SessionID))
			{
				((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(ChatProfilePage), (object)chat2);
			}
		}
		else if (chat2.ChatType == ChatType.BROADCAST)
		{
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(ChatProfilePage), (object)chat2);
		}
	}

	private void DisplayBuddyProfileDialog(Chat item, Grid grid)
	{
		//IL_0115: Unknown result type (might be due to invalid IL or missing references)
		//IL_011f: Expected O, but got Unknown
		//IL_0153: Unknown result type (might be due to invalid IL or missing references)
		//IL_015d: Expected O, but got Unknown
		//IL_0132: Unknown result type (might be due to invalid IL or missing references)
		//IL_013c: Expected O, but got Unknown
		if (((ICollection<UIElement>)((Panel)grid).Children).Count > 0)
		{
			UIElement val = null;
			if ((val = ((IEnumerable<UIElement>)((Panel)grid).Children).FirstOrDefault((UIElement x) => (object)((object)x).GetType() == typeof(CustomPopup))) != null)
			{
				CustomPopup customPopup = null;
				if (val is CustomPopup customPopup2)
				{
					customPopup2.Close();
				}
			}
		}
		UserControl val2 = null;
		Buddy singleChatBuddy = item.SingleChatBuddy;
		if (singleChatBuddy == null)
		{
			UnknownUser unknownUser = new UnknownUser();
			unknownUser.LoadProfileImage(applyTheme: true);
			unknownUser.Name = item.Title;
			unknownUser.PhoneNumber = item.Sender;
			unknownUser.SetMessage(unknownUser.Name);
			UnknownBuddyProfileDialog unknownBuddyProfileDialog = new UnknownBuddyProfileDialog();
			unknownBuddyProfileDialog.BuddyInfo = unknownUser;
			val2 = (UserControl)(object)unknownBuddyProfileDialog;
		}
		else if (singleChatBuddy.IsBlocked)
		{
			UnknownUser unknownUser2 = new UnknownUser(singleChatBuddy.Name, singleChatBuddy.PhoneNumber);
			unknownUser2.SetMessage(unknownUser2.Name);
			unknownUser2.IsBlocked = true;
			UnknownBuddyProfileDialog unknownBuddyProfileDialog2 = new UnknownBuddyProfileDialog();
			unknownBuddyProfileDialog2.BuddyInfo = unknownUser2;
			val2 = (UserControl)(object)unknownBuddyProfileDialog2;
		}
		else
		{
			val2 = GetBuddyProfileDialog(item, grid, singleChatBuddy);
		}
		((UIElement)grid).put_Visibility((Visibility)0);
		Chat recentChat = ChatOnService.Instance.RecentChat;
		if (recentChat != null)
		{
			recentChat.Background = new SolidColorBrush(Colors.Transparent);
		}
		if (_lastOpenedDialogBuddy != null)
		{
			_lastOpenedDialogBuddy.Background = new SolidColorBrush(Colors.Transparent);
		}
		item.Background = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
		if (_lastOpenedDialogBuddy == null)
		{
			((ICollection<UIElement>)((Panel)grid).Children).Add((UIElement)(object)val2);
			_lastOpenedDialogBuddy = item;
		}
		else if (_lastOpenedDialogBuddy != null && _lastOpenedDialogBuddy.Id != item.Id)
		{
			((ICollection<UIElement>)((Panel)grid).Children).Clear();
			((ICollection<UIElement>)((Panel)grid).Children).Add((UIElement)(object)val2);
			_lastOpenedDialogBuddy = item;
		}
		else
		{
			CloseOpenedDialog(grid);
		}
	}

	private UserControl GetBuddyProfileDialog(Chat item, Grid grid, Buddy buddy)
	{
		BuddyProfileDialog buddyProfileDialog = new BuddyProfileDialog();
		buddyProfileDialog.BuddyInfo = buddy;
		BuddyProfileDialog buddyProfileDialog2 = buddyProfileDialog;
		buddyProfileDialog2.DialogClosedTapped += delegate
		{
			CloseOpenedDialog(BuddyProfileContainer);
		};
		buddyProfileDialog2.StartChatTapped += delegate
		{
			Chat chat = item;
			if (item != null)
			{
				((UIElement)CurrentChatFrame).put_Visibility((Visibility)0);
				((UIElement)SelectChatNoticeGrid).put_Visibility((Visibility)1);
				ActivateChat(chat);
			}
		};
		return (UserControl)(object)buddyProfileDialog2;
	}

	private void CloseOpenedDialog(Grid grid)
	{
		//IL_0013: Unknown result type (might be due to invalid IL or missing references)
		//IL_001d: Expected O, but got Unknown
		//IL_005b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0065: Expected O, but got Unknown
		try
		{
			if (_lastOpenedDialogBuddy != null)
			{
				_lastOpenedDialogBuddy.Background = new SolidColorBrush(Colors.Transparent);
				_lastOpenedDialogBuddy = null;
				((ICollection<UIElement>)((Panel)grid).Children).Clear();
				((UIElement)grid).put_Visibility((Visibility)1);
			}
			Chat recentChat = ChatOnService.Instance.RecentChat;
			if (recentChat != null)
			{
				recentChat.Background = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
			}
		}
		catch (Exception)
		{
		}
	}

	public void CloseProfileDialog()
	{
		CloseOpenedDialog(BuddyProfileContainer);
	}

	private async void ProfileImageControl_Loaded(object sender, RoutedEventArgs e)
	{
		Chat item = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as Chat;
		if (item.ChatType == ChatType.SINGLE && item.SingleChatBuddy == null)
		{
			DataService dataService = new DataService();
			UnknownUser unknownUser = dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == item.Sender);
			BitmapImage val;
			if (unknownUser != null)
			{
				unknownUser.LoadProfileImage();
				val = unknownUser.ProfileImage;
			}
			else
			{
				val = new BitmapImage(_ssmService.GetBuddyProfileImageUri(item.Sender));
			}
			((Image)((sender is Image) ? sender : null)).put_Source((ImageSource)(object)val);
		}
	}

	public void ChangeChatRoomFromSnap(Chat chat)
	{
		((UIElement)CurrentChatFrame).put_Visibility((Visibility)0);
		((UIElement)SelectChatNoticeGrid).put_Visibility((Visibility)1);
		ActivateChat(chat, forceRefresh: true);
		ScrollSelectedItemIntoView(chat);
	}

	public void ClearSelection()
	{
		//IL_0056: Unknown result type (might be due to invalid IL or missing references)
		//IL_0060: Expected O, but got Unknown
		List<object> list = ((IEnumerable<object>)((ItemsControl)ChatListView).Items).Where((object x) => x is Chat && (x as Chat).Background.Color != Colors.Transparent).ToList();
		foreach (object item in list)
		{
			Chat chat = null;
			if (item is Chat chat2)
			{
				chat2.Background = new SolidColorBrush(Colors.Transparent);
			}
		}
	}

	public void MakeSelectChatNoticeGridVisible()
	{
		((UIElement)SelectChatNoticeGrid).put_Visibility((Visibility)0);
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
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///ChatListPage.xaml"), (ComponentResourceLocation)0);
			CurrentChatFrame = (Frame)((FrameworkElement)this).FindName("CurrentChatFrame");
			BuddyProfileContainer = (Grid)((FrameworkElement)this).FindName("BuddyProfileContainer");
			SelectChatNoticeGrid = (Grid)((FrameworkElement)this).FindName("SelectChatNoticeGrid");
			ChatListView = (ListView)((FrameworkElement)this).FindName("ChatListView");
			EmoticonChooserControl = (EmoticonChooser)((FrameworkElement)this).FindName("EmoticonChooserControl");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Expected O, but got Unknown
		//IL_0045: Unknown result type (might be due to invalid IL or missing references)
		//IL_004f: Expected O, but got Unknown
		//IL_0055: Unknown result type (might be due to invalid IL or missing references)
		//IL_005b: Expected O, but got Unknown
		//IL_007a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0084: Expected O, but got Unknown
		//IL_0087: Unknown result type (might be due to invalid IL or missing references)
		//IL_008d: Expected O, but got Unknown
		//IL_00ac: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b6: Expected O, but got Unknown
		//IL_00b9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c0: Expected O, but got Unknown
		//IL_00e1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00eb: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val4 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(ChatListPage_Loaded));
			break;
		}
		case 2:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ChatItemImageGrid_Tapped_1));
			break;
		}
		case 3:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ChatItem_Tapped_1));
			break;
		}
		case 4:
		{
			FrameworkElement val = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(ProfileImageControl_Loaded));
			break;
		}
		}
		_contentLoaded = true;
	}
}
