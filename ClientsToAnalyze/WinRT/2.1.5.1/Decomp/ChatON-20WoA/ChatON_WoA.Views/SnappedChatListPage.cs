using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using com.sec.ssm.common;
using Windows.UI;
using Windows.UI.Core;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class SnappedChatListPage : Page, IComponentConnector
{
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LeftCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton ChatButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock textNoChats;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView ChatListView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Border EmptyChatGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public SnappedChatListPage()
	{
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)PivotPage.ActiveInstance.ViewModel);
		if (PivotPage.ActiveInstance.ViewModel.ChatItems == null || PivotPage.ActiveInstance.ViewModel.ChatItems.Count == 0)
		{
			PivotPage.ActiveInstance.ViewModel.EmptyChatGridVisibility = (Visibility)0;
		}
		else
		{
			PivotPage.ActiveInstance.ViewModel.EmptyChatGridVisibility = (Visibility)1;
		}
		PivotPage.ActiveInstance.CloseAllPopup();
		ChatButton.Text = "";
	}

	private void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		Chat chat = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as Chat;
		ChatOnService.Instance.RecentChat = chat;
		if (chat != null)
		{
			((Page)this).Frame.Navigate(typeof(SnappedChatPage), (object)chat);
		}
	}

	protected unsafe override void OnNavigatedTo(NavigationEventArgs e)
	{
		//IL_0025: Unknown result type (might be due to invalid IL or missing references)
		//IL_002f: Expected O, but got Unknown
		Window current = Window.Current;
		WindowsRuntimeMarshal.AddEventHandler(new Func<WindowSizeChangedEventHandler, EventRegistrationToken>(current, (nint)__ldftn(Window.add_SizeChanged)), new Action<EventRegistrationToken>(current, (nint)__ldftn(Window.remove_SizeChanged)), new WindowSizeChangedEventHandler(Current_SizeChanged));
		ClearSelection();
	}

	protected unsafe override void OnNavigatedFrom(NavigationEventArgs e)
	{
		//IL_0017: Unknown result type (might be due to invalid IL or missing references)
		//IL_0021: Expected O, but got Unknown
		WindowsRuntimeMarshal.RemoveEventHandler<WindowSizeChangedEventHandler>(new Action<EventRegistrationToken>(Window.Current, (nint)__ldftn(Window.remove_SizeChanged)), new WindowSizeChangedEventHandler(Current_SizeChanged));
	}

	private void Current_SizeChanged(object sender, WindowSizeChangedEventArgs e)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		if ((int)ApplicationView.Value == 2)
		{
			return;
		}
		if (ChatListPage.ActiveInstance != null)
		{
			try
			{
				ChatListPage.ActiveInstance.ClearSelection();
				ChatListPage.ActiveInstance.ToggleEmoticonChooser(forceHide: true);
			}
			catch
			{
			}
		}
		Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
		if ((object)((Page)this).Frame.CurrentSourcePageType == typeof(PivotPage))
		{
			ChatOnService.Instance.RecentChat = null;
		}
	}

	private void StartChat_Click(object sender, RoutedEventArgs e)
	{
		ApplicationView.TryUnsnap();
		SelectBuddyPage.ChatType = ChatType.GROUP;
		SelectBuddyPage.SelectionCompleted += SelectBuddyPage_SelectionCompleted;
		SelectBuddyPage.SelectionCountLimit = ChatService.MAX_CHAT_MEMBERS - 1;
		((Page)this).Frame.Navigate(typeof(SelectBuddyPage));
	}

	private async void SelectBuddyPage_SelectionCompleted(object sender, object arg)
	{
		DataService dataService = new DataService();
		SSMService ssmService = new SSMService();
		BuddyService buddyService = new BuddyService(dataService, ssmService);
		SelectBuddyPage.SelectionCompleted -= SelectBuddyPage_SelectionCompleted;
		ObservableCollection<BuddySummary> observableCollection = arg as ObservableCollection<BuddySummary>;
		if (observableCollection.Count == 0)
		{
			Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
			PivotPage.ActiveInstance.OpenChat();
			PivotPage.ActiveInstance.ViewModel.UpdateChatList();
			PivotPage.ActiveInstance.ViewModel.SelectedIndex = 1;
			((Page)this).Frame.Navigate(typeof(PivotPage));
			return;
		}
		List<string> list = new List<string>();
		foreach (BuddySummary item in observableCollection)
		{
			list.Add(item.Buddy.PhoneNumber);
		}
		string member = string.Join(",", list);
		string chatOnID = RegistrationService.ChatOnID;
		ChatService chatService = new ChatService(dataService, buddyService, chatOnID);
		ChatType chatType = SelectBuddyPage.ChatType;
		if (chatType == ChatType.GROUP && list.Count() == 1)
		{
			chatType = ChatType.SINGLE;
		}
		Chat chat = chatService.StartChat(disconnect: false, list[0], member, chatType);
		PivotPage.ActiveInstance.OpenChat(chat);
		ChatOnService.Instance.RecentChat = chat;
		PivotPage.ActiveInstance.ViewModel.UpdateChatList();
		PivotPage.ActiveInstance.ViewModel.SelectedIndex = 1;
		Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SnappedChatListPage.xaml"), (ComponentResourceLocation)0);
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			LeftCommands = (StackPanel)((FrameworkElement)this).FindName("LeftCommands");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			ChatButton = (ImageButton)((FrameworkElement)this).FindName("ChatButton");
			textNoChats = (TextBlock)((FrameworkElement)this).FindName("textNoChats");
			ChatListView = (ListView)((FrameworkElement)this).FindName("ChatListView");
			EmptyChatGrid = (Border)((FrameworkElement)this).FindName("EmptyChatGrid");
			Text1 = (TextBlock)((FrameworkElement)this).FindName("Text1");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_001b: Expected O, but got Unknown
		//IL_003a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0044: Expected O, but got Unknown
		//IL_0053: Unknown result type (might be due to invalid IL or missing references)
		//IL_005d: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 2:
			((ImageButton)target).Click += new RoutedEventHandler(StartChat_Click);
			break;
		}
		_contentLoaded = true;
	}
}
