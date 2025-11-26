using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.Foundation;
using Windows.System;
using Windows.UI.ApplicationSettings;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media.Animation;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class PivotPage : Page, IComponentConnector
{
	private PivotPageViewModel _viewModel;

	private Popup settingsPopup;

	private static PivotPage _activeInstance;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid titleGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Frame Current;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid GridSearchAndSuggestion;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock SuggestionsText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock UpdateText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public PivotPageViewModel ViewModel
	{
		get
		{
			return _viewModel;
		}
		set
		{
			_viewModel = value;
		}
	}

	public static PivotPage ActiveInstance => _activeInstance;

	public unsafe PivotPage()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_004e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0058: Expected O, but got Unknown
		//IL_007d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0087: Expected O, but got Unknown
		//IL_0191: Unknown result type (might be due to invalid IL or missing references)
		//IL_019b: Expected O, but got Unknown
		InitializeComponent();
		WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(PivotPage_Loaded));
		WindowsRuntimeMarshal.RemoveEventHandler<WindowSizeChangedEventHandler>(new Action<EventRegistrationToken>(Window.Current, (nint)__ldftn(Window.remove_SizeChanged)), new WindowSizeChangedEventHandler(MainPage.Current_SizeChanged));
		Window current = Window.Current;
		WindowsRuntimeMarshal.AddEventHandler(new Func<WindowSizeChangedEventHandler, EventRegistrationToken>(current, (nint)__ldftn(Window.add_SizeChanged)), new Action<EventRegistrationToken>(current, (nint)__ldftn(Window.remove_SizeChanged)), new WindowSizeChangedEventHandler(Current_SizeChanged));
		WindowsRuntimeMarshal.RemoveEventHandler<TypedEventHandler<SettingsPane, SettingsPaneCommandsRequestedEventArgs>>(new Action<EventRegistrationToken>(SettingsPane.GetForCurrentView(), (nint)__ldftn(SettingsPane.remove_CommandsRequested)), MainPage.CommandsRequested);
		SettingsPane forCurrentView = SettingsPane.GetForCurrentView();
		WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<SettingsPane, SettingsPaneCommandsRequestedEventArgs>, EventRegistrationToken>(forCurrentView, (nint)__ldftn(SettingsPane.add_CommandsRequested)), new Action<EventRegistrationToken>(forCurrentView, (nint)__ldftn(SettingsPane.remove_CommandsRequested)), PivotPage_CommandsRequested);
		InputPane forCurrentView2 = InputPane.GetForCurrentView();
		WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<InputPane, InputPaneVisibilityEventArgs>, EventRegistrationToken>(forCurrentView2, (nint)__ldftn(InputPane.add_Showing)), new Action<EventRegistrationToken>(forCurrentView2, (nint)__ldftn(InputPane.remove_Showing)), PivotPage_Showing);
		InputPane forCurrentView3 = InputPane.GetForCurrentView();
		WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<InputPane, InputPaneVisibilityEventArgs>, EventRegistrationToken>(forCurrentView3, (nint)__ldftn(InputPane.add_Hiding)), new Action<EventRegistrationToken>(forCurrentView3, (nint)__ldftn(InputPane.remove_Hiding)), PivotPage_Hiding);
		_activeInstance = this;
		_viewModel = new PivotPageViewModel(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		_viewModel.SelectedIndex = 0;
		SetSuggestionsCount(0);
		Window current2 = Window.Current;
		WindowsRuntimeMarshal.AddEventHandler(new Func<WindowVisibilityChangedEventHandler, EventRegistrationToken>(current2, (nint)__ldftn(Window.add_VisibilityChanged)), new Action<EventRegistrationToken>(current2, (nint)__ldftn(Window.remove_VisibilityChanged)), new WindowVisibilityChangedEventHandler(Current_VisibilityChanged));
	}

	private void PivotPage_Hiding(InputPane sender, InputPaneVisibilityEventArgs args)
	{
		if (ChatDetailPage.ActiveInstance != null)
		{
			ChatDetailPage.ActiveInstance.OnInputPaneHiding();
		}
	}

	private void PivotPage_Showing(InputPane sender, InputPaneVisibilityEventArgs args)
	{
		if (ChatDetailPage.ActiveInstance != null)
		{
			ChatDetailPage.ActiveInstance.OnInputPaneShowing(args);
		}
	}

	private void Current_VisibilityChanged(object sender, VisibilityChangedEventArgs e)
	{
		if (e.Visible)
		{
			OpenPasswordPage();
		}
	}

	private void OpenPasswordPage()
	{
		//IL_003d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0043: Expected O, but got Unknown
		DispatchedHandler val = null;
		if ((object)((Page)this).Frame.CurrentSourcePageType == typeof(InputPasswordPage) || string.IsNullOrEmpty(SettingService.GetPassword()) || !SettingService.GetCheckPassword())
		{
			return;
		}
		CoreDispatcher dispatcher = ((DependencyObject)this).Dispatcher;
		if (val == null)
		{
			val = (DispatchedHandler)delegate
			{
				((Page)this).Frame.Navigate(typeof(InputPasswordPage), (object)"Activated");
			};
		}
		dispatcher.RunAsync((CoreDispatcherPriority)0, val);
	}

	private void PivotPage_CommandsRequested(SettingsPane sender, SettingsPaneCommandsRequestedEventArgs args)
	{
		//IL_002f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0039: Expected O, but got Unknown
		//IL_0034: Unknown result type (might be due to invalid IL or missing references)
		//IL_003e: Expected O, but got Unknown
		//IL_008e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0098: Expected O, but got Unknown
		//IL_0093: Unknown result type (might be due to invalid IL or missing references)
		//IL_009d: Expected O, but got Unknown
		//IL_00ed: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f7: Expected O, but got Unknown
		//IL_00f2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fc: Expected O, but got Unknown
		//IL_014c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0156: Expected O, but got Unknown
		//IL_0151: Unknown result type (might be due to invalid IL or missing references)
		//IL_015b: Expected O, but got Unknown
		//IL_01ab: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b5: Expected O, but got Unknown
		//IL_01b0: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ba: Expected O, but got Unknown
		try
		{
			args.Request.ApplicationCommands.Clear();
			SettingsCommand command = new SettingsCommand((object)"1", Utility.GetResourceString("IDS_CHATON_BODY_ABOUT_CHATON"), new UICommandInvokedHandler(onSettingsCommand));
			SettingsCommand val = args.Request.ApplicationCommands.FirstOrDefault((SettingsCommand x) => x.Id == command.Id && x.Label == command.Label);
			if (val == null)
			{
				args.Request.ApplicationCommands.Add(command);
			}
			command = new SettingsCommand((object)"2", Utility.GetResourceString("IDS_CHATON_BUTTON_SETTINGS"), new UICommandInvokedHandler(onSettingsCommand));
			SettingsCommand val2 = args.Request.ApplicationCommands.FirstOrDefault((SettingsCommand x) => x.Id == command.Id && x.Label == command.Label);
			if (val2 == null)
			{
				args.Request.ApplicationCommands.Add(command);
			}
			command = new SettingsCommand((object)"3", Utility.GetResourceString("IDS_CHATON_SK1_TERMS_AND_CONDITIONS"), new UICommandInvokedHandler(onSettingsCommand));
			SettingsCommand val3 = args.Request.ApplicationCommands.FirstOrDefault((SettingsCommand x) => x.Id == command.Id && x.Label == command.Label);
			if (val3 == null)
			{
				args.Request.ApplicationCommands.Add(command);
			}
			command = new SettingsCommand((object)"4", Utility.GetResourceString("IDS_CHATON_SK1_PRIVACY_POLICY"), new UICommandInvokedHandler(onSettingsCommand));
			SettingsCommand val4 = args.Request.ApplicationCommands.FirstOrDefault((SettingsCommand x) => x.Id == command.Id && x.Label == command.Label);
			if (val4 == null)
			{
				args.Request.ApplicationCommands.Add(command);
			}
			command = new SettingsCommand((object)"5", Utility.GetResourceString("setting_notificiation_service_notification"), new UICommandInvokedHandler(onSettingsCommand));
			SettingsCommand val5 = args.Request.ApplicationCommands.FirstOrDefault((SettingsCommand x) => x.Id == command.Id && x.Label == command.Label);
			if (val5 == null)
			{
				args.Request.ApplicationCommands.Add(command);
			}
		}
		catch (Exception)
		{
		}
	}

	public void onSettingsCommand(IUICommand command)
	{
		//IL_0019: Unknown result type (might be due to invalid IL or missing references)
		//IL_001f: Expected O, but got Unknown
		if ((object)((Page)this).Frame.CurrentSourcePageType == typeof(InputPasswordPage))
		{
			return;
		}
		SettingsCommand val = (SettingsCommand)command;
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		if (val.Id == "3")
		{
			Launcher.LaunchUriAsync(new Uri("http://smm.samsung.com/mwv/disclaimer.html?c=" + userAccount.Mcc));
			return;
		}
		if (val.Id == "4")
		{
			Launcher.LaunchUriAsync(new Uri("http://smm.samsung.com/mwv/disclaimer.html?c=" + userAccount.Mcc + "&f=PP"));
			return;
		}
		if (val.Id == "5")
		{
			Launcher.LaunchUriAsync(new Uri("http://smm.samsung.com/mwv/disclaimer.html?c=" + userAccount.Mcc + "&f=SMM"));
			return;
		}
		if (val.Id == "1")
		{
			ShowAboutPage();
			return;
		}
		UIElement content = Window.Current.Content;
		if ((object)((Frame)((content is Frame) ? content : null)).CurrentSourcePageType != typeof(SettingsPage))
		{
			UIElement content2 = Window.Current.Content;
			((Frame)((content2 is Frame) ? content2 : null)).Navigate(typeof(SettingsPage), (object)((val.Id as string == "1") ? "About" : null));
		}
	}

	private unsafe void ShowAboutPage()
	{
		//IL_000b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0015: Expected O, but got Unknown
		//IL_006d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0077: Expected O, but got Unknown
		//IL_00b3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bd: Expected O, but got Unknown
		//IL_00c8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ce: Expected O, but got Unknown
		//IL_00cf: Unknown result type (might be due to invalid IL or missing references)
		//IL_0122: Unknown result type (might be due to invalid IL or missing references)
		double num = 468.0;
		settingsPopup = new Popup();
		Popup val = settingsPopup;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val, (nint)__ldftn(Popup.add_Closed)), new Action<EventRegistrationToken>(val, (nint)__ldftn(Popup.remove_Closed)), settingsPopup_Closed);
		Window current = Window.Current;
		WindowsRuntimeMarshal.AddEventHandler(new Func<WindowActivatedEventHandler, EventRegistrationToken>(current, (nint)__ldftn(Window.add_Activated)), new Action<EventRegistrationToken>(current, (nint)__ldftn(Window.remove_Activated)), new WindowActivatedEventHandler(Current_Activated));
		settingsPopup.put_IsLightDismissEnabled(true);
		((FrameworkElement)settingsPopup).put_Width(num);
		((FrameworkElement)settingsPopup).put_Height(Window.Current.Bounds.Height);
		settingsPopup.put_ChildTransitions(new TransitionCollection());
		TransitionCollection childTransitions = settingsPopup.ChildTransitions;
		PaneThemeTransition val2 = new PaneThemeTransition();
		val2.put_Edge((EdgeTransitionLocation)(((int)SettingsPane.Edge == 0) ? 2 : 0));
		((ICollection<Transition>)childTransitions).Add((Transition)(object)val2);
		AboutPage aboutPage = new AboutPage();
		((FrameworkElement)aboutPage).put_Width(num);
		((FrameworkElement)aboutPage).put_Height(Window.Current.Bounds.Height);
		settingsPopup.put_Child((UIElement)(object)aboutPage);
		((DependencyObject)settingsPopup).SetValue(Canvas.LeftProperty, (object)(((int)SettingsPane.Edge == 0) ? (Window.Current.Bounds.Width - num) : 0.0));
		((DependencyObject)settingsPopup).SetValue(Canvas.TopProperty, (object)0);
		settingsPopup.put_IsOpen(true);
	}

	private void Current_Activated(object sender, WindowActivatedEventArgs e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Invalid comparison between Unknown and I4
		if ((int)e.WindowActivationState == 1)
		{
			settingsPopup.put_IsOpen(false);
		}
	}

	private unsafe void settingsPopup_Closed(object sender, object e)
	{
		//IL_0017: Unknown result type (might be due to invalid IL or missing references)
		//IL_0021: Expected O, but got Unknown
		WindowsRuntimeMarshal.RemoveEventHandler<WindowActivatedEventHandler>(new Action<EventRegistrationToken>(Window.Current, (nint)__ldftn(Window.remove_Activated)), new WindowActivatedEventHandler(Current_Activated));
	}

	private void Current_SizeChanged(object sender, WindowSizeChangedEventArgs e)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_0023: Unknown result type (might be due to invalid IL or missing references)
		//IL_0025: Invalid comparison between Unknown and I4
		//IL_0034: Unknown result type (might be due to invalid IL or missing references)
		ApplicationViewState value = ApplicationView.Value;
		if ((object)((Page)this).Frame.CurrentSourcePageType != typeof(InputPasswordPage))
		{
			UpdateView();
		}
		if ((int)value == 1)
		{
			((UIElement)GridSearchAndSuggestion).put_Visibility((Visibility)1);
		}
		else if ((int)value == 0)
		{
			((UIElement)GridSearchAndSuggestion).put_Visibility((Visibility)0);
		}
	}

	public void UpdateView()
	{
		//IL_002f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0035: Invalid comparison between Unknown and I4
		if ((object)((Page)this).Frame.CurrentSourcePageType == typeof(SnappedChatListPage) || (object)((Page)this).Frame.CurrentSourcePageType == typeof(SnappedChatPage))
		{
			return;
		}
		if ((int)ApplicationView.Value == 2)
		{
			if (BuddyListPage.ActiveInstance != null)
			{
				BuddyListPage.ActiveInstance.SwitchAppBar(isOpen: false);
			}
			if ((object)((Page)this).Frame.CurrentSourcePageType == typeof(SelectBuddyPage))
			{
				Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
			}
			if (ChatListPage.ActiveInstance != null && ChatListPage.ActiveInstance.IsInChatMode)
			{
				((Page)this).Frame.Navigate(typeof(SnappedChatListPage));
				((Page)this).Frame.Navigate(typeof(SnappedChatPage), (object)ChatDetailPage.ActiveInstance.ViewModel.Chat);
			}
			else
			{
				((Page)this).Frame.Navigate(typeof(SnappedChatListPage));
			}
		}
		else if (BuddyListPage.ActiveInstance != null)
		{
			BuddyListPage.ActiveInstance.SwitchAppBar(isOpen: true);
		}
	}

	private void PivotPage_Loaded(object sender, RoutedEventArgs e)
	{
		//IL_003c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0042: Invalid comparison between Unknown and I4
		//IL_0052: Unknown result type (might be due to invalid IL or missing references)
		if (_viewModel != null)
		{
			_viewModel.PivotHeaderHeight = ((FrameworkElement)titleGrid).Height;
			_viewModel.PivotFooterHeight = ((FrameworkElement)Current).Margin.Bottom;
		}
		if ((int)ApplicationView.Value == 1)
		{
			((UIElement)GridSearchAndSuggestion).put_Visibility((Visibility)1);
		}
		else if ((int)ApplicationView.Value == 0)
		{
			((UIElement)GridSearchAndSuggestion).put_Visibility((Visibility)0);
		}
		foreach (UIElement item in (IEnumerable<UIElement>)((Panel)LayoutRoot).Children)
		{
			if ((object)((object)item).GetType() == typeof(CustomPopup))
			{
				CustomPopup customPopup = item as CustomPopup;
				if ((object)((object)customPopup.Child).GetType() == typeof(AddGroupDialog))
				{
					customPopup.Close();
					break;
				}
			}
		}
		UpdateView();
	}

	public void ShowSelectedIndexFrame(int index)
	{
		switch (index)
		{
		case 1:
			OpenChatListPage();
			break;
		case 2:
			OpenMyPage();
			break;
		}
	}

	public void ShowBuddyListFrame(bool showBuddyList)
	{
		if (!showBuddyList && _viewModel.SelectedIndex == 0)
		{
			Current.Navigate(typeof(EmptyBuddyListPage));
		}
		else if (_viewModel.SelectedIndex == 0)
		{
			Current.Navigate(typeof(BuddyListPage), (object)this);
		}
	}

	public void ShowLoading(string text = "Loading...")
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot, text);
	}

	protected override async void OnNavigatedTo(NavigationEventArgs e)
	{
		if (string.IsNullOrEmpty(ChatOnService.Instance.LaunchArg) && !SettingService.IsFirstRun())
		{
			_viewModel.SelectedIndex = SettingService.GetSelectedIndex();
		}
		ViewModel.CheckTermsAndConditionsUpdate();
		if (ChatOnService.Instance.IsChatStyleUpdated)
		{
			ChatOnService.Instance.IsChatStyleUpdated = false;
			if (ChatDetailPage.ActiveInstance != null)
			{
				ChatDetailPage.ActiveInstance.UpdateStyle();
			}
		}
		if (ChatOnService.Instance.IsChatFontOrBubbleUpdated)
		{
			ChatOnService.Instance.IsChatFontOrBubbleUpdated = false;
			if (ChatDetailPage.ActiveInstance != null)
			{
				ChatDetailPage.ActiveInstance.ViewModel.LoadMessages();
			}
		}
		if ((int)e.NavigationMode != 1)
		{
			await Task.Run(delegate
			{
				ViewModel.UpdateList();
			});
			ViewModel.ShowBuddyOrTellFriends();
			ViewModel.LoadProfileData();
			ViewModel.GetBuddyList();
			if (_viewModel.SelectedIndex != 1)
			{
				ViewModel.LoadChatList();
			}
			if (_viewModel.SelectedIndex == 1)
			{
				ViewModel.UpdateAllChatSummary();
			}
			if (ChatOnService.Instance.IsBuddiesUpdated)
			{
				ChatOnService.Instance.IsBuddiesUpdated = false;
				ActiveInstance.ViewModel.UpdateList();
			}
			if (ChatOnService.Instance.IsUnreadTrunkCommentUpdated)
			{
				ChatOnService.Instance.IsUnreadTrunkCommentUpdated = false;
			}
			if (ChatOnService.Instance.IsRecommendeeUpdated)
			{
				ChatOnService.Instance.IsRecommendeeUpdated = false;
			}
			ChatOnService.Instance.ReUpdateBuddyList = false;
			ChatOnService.Instance.IsProfileUpdated = false;
			if (!string.IsNullOrEmpty(ChatOnService.Instance.SearchArg))
			{
				ShowSearchResult(ChatOnService.Instance.SearchArg);
				ChatOnService.Instance.SearchArg = "";
			}
			if (!PushService.Instance.IsEnable())
			{
				await ViewModel.GetUnreadMessage();
			}
			await ViewModel.UpdateUserProfile();
			await ViewModel.UpdateMemoList();
			if (string.IsNullOrEmpty(ChatOnService.Instance.LaunchArg) && !SettingService.IsFirstRun() && SelectBuddyPage.ActiveInstance == null)
			{
				ShowSelectedIndexFrame(SettingService.GetSelectedIndex());
			}
			if (ViewModel.SelectedIndex == 0 && BuddyListPage.ActiveInstance != null)
			{
				BuddyListPage.ActiveInstance.StickyAppBar();
			}
			ViewModel.DeleteAllSpecialBuddyChat();
			if (ChatOnService.Instance.ReUpdateChatList)
			{
				ChatOnService.Instance.ReUpdateChatList = false;
				ViewModel.UpdateChatList();
			}
			if (ChatOnService.Instance.IsGetAllMessage)
			{
				ChatOnService.Instance.IsGetAllMessage = false;
				ViewModel.GetAllMessageAllChat();
			}
			ViewModel.ActivateSearchPane();
		}
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		if (ViewModel.SelectedIndex == 1 && ChatDetailPage.ActiveInstance != null)
		{
			ChatDetailPage.ActiveInstance.KeepCurrentState();
			if (!Utility.IsRelatedChat(e.SourcePageType))
			{
				ChatDetailPage.ActiveInstance.Disconnect(IsNullChat: false);
			}
		}
		if (BuddyListPage.ActiveInstance != null)
		{
			BuddyListPage.ActiveInstance.SwitchAppBar(isOpen: false);
		}
		((Page)this).OnNavigatedFrom(e);
	}

	private async void Buddyitem_Tap(object sender, TappedRoutedEventArgs e)
	{
		BuddySummary buddySummary;
		BuddySummary item = (buddySummary = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as BuddySummary);
		if (buddySummary != null)
		{
			await _viewModel.StartChat(item.Buddy);
		}
	}

	internal async void OpenChat(BuddySummary item)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			Chat chat = await _viewModel.StartChat(item.Buddy);
			Current.Navigate(typeof(ChatListPage), (object)chat);
		}
		catch
		{
		}
	}

	internal async void OpenChat(Buddy buddy)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			if (buddy != null)
			{
				Chat chat = await _viewModel.StartChat(buddy);
				Current.Navigate(typeof(ChatListPage), (object)chat);
			}
		}
		catch
		{
		}
	}

	internal async Task OpenChatAsync(Buddy buddy)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			if (buddy != null)
			{
				Chat chat = await _viewModel.StartChat(buddy);
				Current.Navigate(typeof(ChatListPage), (object)chat);
				ViewModel.SelectedIndex = 1;
				SettingService.SetSelectedIndex(1);
			}
		}
		catch
		{
		}
	}

	internal void OpenChat(Chat chat)
	{
		//IL_000b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0011: Invalid comparison between Unknown and I4
		try
		{
			_viewModel.UpdateChatList();
			if ((int)ApplicationView.Value == 2)
			{
				((Page)this).Frame.Navigate(typeof(SnappedChatPage), (object)chat);
			}
			else
			{
				Current.Navigate(typeof(ChatListPage), (object)chat);
			}
			ViewModel.SelectedIndex = 1;
			SettingService.SetSelectedIndex(1);
		}
		catch
		{
		}
	}

	internal void OpenChat()
	{
		//IL_000b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0011: Invalid comparison between Unknown and I4
		try
		{
			_viewModel.UpdateChatList();
			if ((int)ApplicationView.Value == 2)
			{
				((Page)this).Frame.Navigate(typeof(SnappedChatPage));
			}
			else
			{
				Current.Navigate(typeof(ChatListPage));
			}
			ViewModel.SelectedIndex = 1;
			SettingService.SetSelectedIndex(1);
		}
		catch
		{
		}
	}

	private void Next_Click_1(object sender, RoutedEventArgs e)
	{
	}

	private void semanticZoom_ViewChangeCompleted_1(object sender, SemanticZoomViewChangedEventArgs e)
	{
		if (!e.IsSourceZoomedInView)
		{
			((UIElement)titleGrid).put_Visibility((Visibility)0);
		}
		else
		{
			((UIElement)titleGrid).put_Visibility((Visibility)1);
		}
	}

	private void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		_ = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext;
	}

	public void buddies_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		//IL_002a: Expected O, but got Unknown
		ViewModel.SelectedIndex = 0;
		SettingService.SetSelectedIndex(0);
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			if (_viewModel.BuddyItems.Count() == 0)
			{
				Current.Navigate(typeof(EmptyBuddyListPage));
			}
			else
			{
				Current.Navigate(typeof(BuddyListPage), (object)this);
			}
			if (EmoticonChooser.ActiveInstance != null)
			{
				ChatListPage.ActiveInstance.ToggleEmoticonChooser(forceHide: true);
			}
		});
	}

	private void chat_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		UpdateChatList();
	}

	public void OpenChatListPage()
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		//IL_002a: Expected O, but got Unknown
		ViewModel.SelectedIndex = 1;
		SettingService.SetSelectedIndex(1);
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			if (ViewModel.ChatItems.Count == 0)
			{
				Current.Navigate(typeof(EmptyChatListPage));
			}
			else
			{
				if (!SettingService.IsUsingPushNotification())
				{
					_viewModel.GetUnreadMessage();
				}
				_viewModel.UpdateChatList();
				Current.Navigate(typeof(ChatListPage));
			}
		});
	}

	private void mypage_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		OpenMyPage();
	}

	internal void SetSuggestionsCount(int p)
	{
		SuggestionsText.put_Text(Utility.GetResourceString("IDS_CHATON_ITAB_SUGGESTIONS") + "(" + p + ")");
	}

	private void Trunk_Click(object sender, RoutedEventArgs e)
	{
		if (ChatOnService.Instance.RecentChat != null)
		{
			((Page)ActiveInstance).Frame.Navigate(typeof(TrunkPage), (object)ChatOnService.Instance.RecentChat.ChatID);
		}
	}

	public void UpdateChatList(bool openChatList = true)
	{
		_viewModel.UpdateChatList();
		if (openChatList)
		{
			OpenChatListPage();
		}
	}

	public void OpenMyPage()
	{
		//IL_003a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0044: Expected O, but got Unknown
		IsoSettingHelper.Set("LastSelectedIndex", ViewModel.SelectedIndex);
		ViewModel.SelectedIndex = 2;
		SettingService.SetSelectedIndex(2);
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			Current.Navigate(typeof(MyPage), (object)this);
			if (EmoticonChooser.ActiveInstance != null)
			{
				ChatListPage.ActiveInstance.ToggleEmoticonChooser(forceHide: true);
			}
		});
	}

	public void OpenBuddyPage()
	{
		//IL_003a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0044: Expected O, but got Unknown
		IsoSettingHelper.Set("LastSelectedIndex", ViewModel.SelectedIndex);
		ViewModel.SelectedIndex = 0;
		SettingService.SetSelectedIndex(0);
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			Current.Navigate(typeof(Buddy), (object)this);
		});
	}

	public void ShowSplashPopup(string text)
	{
		Utility.ShowSimpleToastNotification(text);
	}

	public void OpenBuddyProfile(string number)
	{
		//IL_0099: Unknown result type (might be due to invalid IL or missing references)
		//IL_009f: Expected O, but got Unknown
		if (((ICollection<UIElement>)((Panel)LayoutRoot).Children).Count > 0)
		{
			DispatchedHandler val = null;
			if (BuddyListPage.ActiveInstance != null)
			{
				BuddyListPage.ActiveInstance.CloseProfileDialog();
			}
			if (ChatListPage.ActiveInstance != null)
			{
				ChatListPage.ActiveInstance.CloseProfileDialog();
			}
			UIElement existPopup = null;
			if ((existPopup = ((IEnumerable<UIElement>)((Panel)LayoutRoot).Children).FirstOrDefault((UIElement x) => (object)((object)x).GetType() == typeof(CustomPopup))) != null)
			{
				CoreDispatcher dispatcher = ((DependencyObject)this).Dispatcher;
				if (val == null)
				{
					val = (DispatchedHandler)delegate
					{
						((ICollection<UIElement>)((Panel)LayoutRoot).Children).Remove(existPopup);
					};
				}
				dispatcher.RunAsync((CoreDispatcherPriority)0, val);
			}
		}
		Buddy buddyFromNumber = _viewModel.GetBuddyFromNumber(number);
		if (buddyFromNumber != null)
		{
			if (buddyFromNumber.IsBlocked)
			{
				UnknownUser unknownUser = new UnknownUser(buddyFromNumber.Name, buddyFromNumber.PhoneNumber);
				unknownUser.SetMessage(unknownUser.Name);
				unknownUser.IsBlocked = true;
				UnknownBuddyProfileDialog unknownBuddyProfileDialog = new UnknownBuddyProfileDialog();
				unknownBuddyProfileDialog.BuddyInfo = unknownUser;
				UnknownBuddyProfileDialog control = unknownBuddyProfileDialog;
				new CustomPopup((Page)(object)this, (Panel)(object)LayoutRoot, (FrameworkElement)(object)control);
				return;
			}
			BuddyProfileDialog buddyProfileDialog = new BuddyProfileDialog();
			buddyProfileDialog.BuddyInfo = buddyFromNumber;
			((FrameworkElement)buddyProfileDialog).put_HorizontalAlignment((HorizontalAlignment)1);
			((FrameworkElement)buddyProfileDialog).put_VerticalAlignment((VerticalAlignment)1);
			new CustomPopup((Page)(object)this, (Panel)(object)LayoutRoot, (FrameworkElement)(object)buddyProfileDialog);
			if (BuddyListPage.ActiveInstance != null)
			{
				BuddyListPage.ActiveInstance.SwitchAppBar(isOpen: false);
			}
		}
		else
		{
			_viewModel.OpenUnknownBuddyPopup(number);
		}
	}

	internal void OpenDialog(UserControl dialog, bool closePrevPopup = false)
	{
		if (closePrevPopup)
		{
			CloseAllPopup();
		}
		new CustomPopup((Page)(object)this, (Panel)(object)LayoutRoot, (FrameworkElement)(object)dialog);
	}

	public bool IsPopupActive()
	{
		if (((IEnumerable<UIElement>)((Panel)LayoutRoot).Children).FirstOrDefault((UIElement x) => (object)((object)x).GetType() == typeof(CustomPopup)) is FrameworkElement)
		{
			return true;
		}
		return false;
	}

	internal void CloseAllPopup()
	{
		int count = ((ICollection<UIElement>)((Panel)LayoutRoot).Children).Count;
		for (int num = count - 1; num >= 0; num--)
		{
			UIElement val = ((IList<UIElement>)((Panel)LayoutRoot).Children)[num];
			if ((object)((object)val).GetType() == typeof(CustomPopup))
			{
				((ICollection<UIElement>)((Panel)LayoutRoot).Children).Remove(val);
			}
		}
	}

	private void SuggestionsText_Tapped(object sender, TappedRoutedEventArgs e)
	{
		((Page)this).Frame.Navigate(typeof(SuggestionsPage));
	}

	private void UpdateText_Tapped(object sender, TappedRoutedEventArgs e)
	{
		((Page)this).Frame.Navigate(typeof(NewUpdatesPage));
	}

	internal async void OpenChat(BuddyGroup group)
	{
		Chat chat = await _viewModel.StartGroupChat(group);
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			OpenChat(chat);
		});
	}

	internal void ShowSearchResult(string p)
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			((Page)this).Frame.Navigate(typeof(SearchBuddyPage), (object)p);
		});
	}

	private void Current_Navigating(object sender, NavigatingCancelEventArgs e)
	{
	}

	public void CloseApp()
	{
		Application.Current.Exit();
	}

	private void Search_Tapped(object sender, TappedRoutedEventArgs e)
	{
		((Page)this).Frame.Navigate(typeof(SearchBuddyPage), (object)"");
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
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///PivotPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			titleGrid = (Grid)((FrameworkElement)this).FindName("titleGrid");
			Current = (Frame)((FrameworkElement)this).FindName("Current");
			GridSearchAndSuggestion = (Grid)((FrameworkElement)this).FindName("GridSearchAndSuggestion");
			SuggestionsText = (TextBlock)((FrameworkElement)this).FindName("SuggestionsText");
			UpdateText = (TextBlock)((FrameworkElement)this).FindName("UpdateText");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0032: Expected O, but got Unknown
		//IL_0051: Unknown result type (might be due to invalid IL or missing references)
		//IL_005b: Expected O, but got Unknown
		//IL_0061: Unknown result type (might be due to invalid IL or missing references)
		//IL_0067: Expected O, but got Unknown
		//IL_0086: Unknown result type (might be due to invalid IL or missing references)
		//IL_0090: Expected O, but got Unknown
		//IL_0096: Unknown result type (might be due to invalid IL or missing references)
		//IL_009c: Expected O, but got Unknown
		//IL_00bb: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c5: Expected O, but got Unknown
		//IL_00cb: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d2: Expected O, but got Unknown
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		//IL_0103: Unknown result type (might be due to invalid IL or missing references)
		//IL_010a: Expected O, but got Unknown
		//IL_012b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0135: Expected O, but got Unknown
		//IL_0138: Unknown result type (might be due to invalid IL or missing references)
		//IL_013f: Expected O, but got Unknown
		//IL_0160: Unknown result type (might be due to invalid IL or missing references)
		//IL_016a: Expected O, but got Unknown
		//IL_016d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0174: Expected O, but got Unknown
		//IL_0195: Unknown result type (might be due to invalid IL or missing references)
		//IL_019f: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			Frame val7 = (Frame)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<NavigatingCancelEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(Frame.add_Navigating)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(Frame.remove_Navigating)), new NavigatingCancelEventHandler(Current_Navigating));
			break;
		}
		case 2:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(buddies_Tapped_1));
			break;
		}
		case 3:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(chat_Tapped_1));
			break;
		}
		case 4:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(mypage_Tapped_1));
			break;
		}
		case 5:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(UpdateText_Tapped));
			break;
		}
		case 6:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(SuggestionsText_Tapped));
			break;
		}
		case 7:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Search_Tapped));
			break;
		}
		}
		_contentLoaded = true;
	}
}
