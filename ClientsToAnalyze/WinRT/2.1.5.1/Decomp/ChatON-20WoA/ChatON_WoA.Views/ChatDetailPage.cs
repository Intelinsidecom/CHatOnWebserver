using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.InfraStructure;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using ChatOn.ViewModels;
using com.sec.ssm.common;
using Windows.ApplicationModel.Contacts;
using Windows.ApplicationModel.DataTransfer;
using Windows.Foundation;
using Windows.Media.Capture;
using Windows.Storage;
using Windows.Storage.Pickers;
using Windows.UI;
using Windows.UI.Core;
using Windows.UI.Input;
using Windows.UI.Popups;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class ChatDetailPage : Page, IComponentConnector
{
	public bool IsNavigatedToTrunk;

	public static readonly DependencyProperty ListVerticalOffsetProperty = DependencyProperty.Register("ListVerticalOffset", typeof(double), typeof(ChatDetailPage), new PropertyMetadata((object)null, new PropertyChangedCallback(OnListVerticalOffsetChanged)));

	public static readonly DependencyProperty ListVerticalOffsetMediatorProperty = DependencyProperty.Register("ListVerticalOffsetMediator", typeof(double), typeof(ChatDetailPage), new PropertyMetadata((object)new PropertyChangedCallback(OnListVerticalOffsetMediatorChanged)));

	private bool _isFocused;

	private bool _isMouseMove;

	public static bool IsKeyboardShow = false;

	private bool _sendEnterKey;

	private long _lastAddedTick;

	private bool _isFirstOffsetChanged = true;

	private bool _sendButton;

	private bool _isDefaultMessage;

	private int _keyboardheight;

	public static bool IsAppBarShow = false;

	private bool _isMouseHold;

	private object _tmpSender;

	private GestureRecognizer _gr;

	private IndeterminateProgressbar _progressControl = new IndeterminateProgressbar();

	private DateTime _scrollToEndTime;

	private Message _scrollTarget;

	private bool _isShowing;

	public int MessageToRender;

	public double VerticalOffset;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LeftCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands2;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands3;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton InviteButtonSnapped;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton DeleteMessageButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton Button5;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton CloseChatButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton DeleteAllRecordButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton DeleteButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton InviteButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton InfoButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton Button1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton Button2;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton Button3;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid HeaderGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid MessagePreviewGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid gridErrorMessage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid gridMessage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton AttachButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton EmoticonButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Border InputBoxBorder;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button SendButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox InputBox;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtErrorMessage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView MessageList;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid UnknownBuddyGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock LoadingTextBlock;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock UnknownBuddyNoticeBlock;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton TrunkButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid ChatItemImageGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock textTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image ProfileImageControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static ChatDetailPage ActiveInstance { get; set; }

	public static ChatDetailPage SnappedActiveInstance { get; set; }

	public double ListVerticalOffset
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(ListVerticalOffsetProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(ListVerticalOffsetProperty, (object)value);
		}
	}

	public double ListVerticalOffsetMediator
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(ListVerticalOffsetMediatorProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(ListVerticalOffsetMediatorProperty, (object)value);
		}
	}

	public ChatDetailPageViewModel ViewModel => ((FrameworkElement)this).DataContext as ChatDetailPageViewModel;

	public long LastAddedTick
	{
		get
		{
			return _lastAddedTick;
		}
		set
		{
			_lastAddedTick = value;
		}
	}

	public bool IsMouseHold
	{
		get
		{
			return _isMouseHold;
		}
		set
		{
			_isMouseHold = value;
		}
	}

	public object TmpSender
	{
		get
		{
			return _tmpSender;
		}
		set
		{
			_tmpSender = value;
		}
	}

	public GestureRecognizer Gr
	{
		get
		{
			return _gr;
		}
		set
		{
			_gr = value;
		}
	}

	public unsafe ChatDetailPage()
	{
		//IL_0128: Unknown result type (might be due to invalid IL or missing references)
		//IL_0132: Expected O, but got Unknown
		//IL_0157: Unknown result type (might be due to invalid IL or missing references)
		//IL_0161: Expected O, but got Unknown
		//IL_0201: Unknown result type (might be due to invalid IL or missing references)
		//IL_0207: Invalid comparison between Unknown and I4
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)new ChatDetailPageViewModel(this));
		Button1.Text = Utility.GetResourceString("IDS_CHATON_BUTTON_SELECT_ALL");
		Button2.Text = Utility.GetResourceString("IDS_CHATON_BODY_RECEIVED_ABB");
		Button3.Text = Utility.GetResourceString("IDS_CHATON_BODY_SENT_ABB");
		DeleteMessageButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON2_DELETE");
		DeleteAllRecordButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON_DELETE_ALL_CHAT_RECORDS");
		Button5.Text = Utility.GetResourceString("IDS_CHATON_OPT_CANCEL_ABB");
		DeleteButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON2_DELETE");
		CloseChatButton.Text = Utility.GetResourceString("IDS_CHATON_HEADER_CLOSE_CHAT");
		InviteButton.Text = Utility.GetResourceString("IDS_CHATON_OPT_INVITE_BUDDY");
		InfoButton.Text = Utility.GetResourceString("IDS_CHATON_MBODY_CHAT_INFO");
		LoadingTextBlock.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_LOADING_ING"));
		WindowsRuntimeMarshal.RemoveEventHandler<WindowVisibilityChangedEventHandler>(new Action<EventRegistrationToken>(Window.Current, (nint)__ldftn(Window.remove_VisibilityChanged)), new WindowVisibilityChangedEventHandler(Current_VisibilityChanged));
		Window current = Window.Current;
		WindowsRuntimeMarshal.AddEventHandler(new Func<WindowVisibilityChangedEventHandler, EventRegistrationToken>(current, (nint)__ldftn(Window.add_VisibilityChanged)), new Action<EventRegistrationToken>(current, (nint)__ldftn(Window.remove_VisibilityChanged)), new WindowVisibilityChangedEventHandler(Current_VisibilityChanged));
		WindowsRuntimeMarshal.RemoveEventHandler<TypedEventHandler<InputPane, InputPaneVisibilityEventArgs>>(new Action<EventRegistrationToken>(InputPane.GetForCurrentView(), (nint)__ldftn(InputPane.remove_Showing)), ChatDetailPage_Showing);
		WindowsRuntimeMarshal.RemoveEventHandler<TypedEventHandler<InputPane, InputPaneVisibilityEventArgs>>(new Action<EventRegistrationToken>(InputPane.GetForCurrentView(), (nint)__ldftn(InputPane.remove_Hiding)), ChatDetailPage_Hiding);
		InputPane forCurrentView = InputPane.GetForCurrentView();
		WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<InputPane, InputPaneVisibilityEventArgs>, EventRegistrationToken>(forCurrentView, (nint)__ldftn(InputPane.add_Showing)), new Action<EventRegistrationToken>(forCurrentView, (nint)__ldftn(InputPane.remove_Showing)), ChatDetailPage_Showing);
		InputPane forCurrentView2 = InputPane.GetForCurrentView();
		WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<InputPane, InputPaneVisibilityEventArgs>, EventRegistrationToken>(forCurrentView2, (nint)__ldftn(InputPane.add_Hiding)), new Action<EventRegistrationToken>(forCurrentView2, (nint)__ldftn(InputPane.remove_Hiding)), ChatDetailPage_Hiding);
		if ((int)ApplicationView.Value != 2)
		{
			EmoticonChooser.Completed += EmoticonChooserControl_Completed;
			EmoticonChooser.Tapped += EmoticonChooser_Tapped;
			EmoticonChooser.Closed += EmoticonChooser_Closed;
		}
	}

	private unsafe void InitGestureSettings()
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected O, but got Unknown
		_gr = new GestureRecognizer();
		_gr.put_GestureSettings((GestureSettings)8);
		GestureRecognizer gr = _gr;
		WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<GestureRecognizer, HoldingEventArgs>, EventRegistrationToken>(gr, (nint)__ldftn(GestureRecognizer.add_Holding)), new Action<EventRegistrationToken>(gr, (nint)__ldftn(GestureRecognizer.remove_Holding)), gr_Holding);
	}

	private void gr_Holding(GestureRecognizer sender, HoldingEventArgs args)
	{
		if (ViewModel == null)
		{
			return;
		}
		if (TmpSender != null)
		{
			Message message = null;
			object tmpSender = TmpSender;
			if (((FrameworkElement)((tmpSender is FrameworkElement) ? tmpSender : null)).DataContext is Message message2)
			{
				if (message2.Type == "media")
				{
					if (string.IsNullOrEmpty(message2.MediaFilePath))
					{
						return;
					}
					ViewModel.OpenImaegContextMenu(TmpSender, message2);
				}
				else
				{
					ViewModel.OnClickMessage(TmpSender, message2);
				}
			}
			IsMouseHold = true;
		}
		sender.CompleteGesture();
	}

	private void ChatDetailPage_Hiding(InputPane sender, InputPaneVisibilityEventArgs args)
	{
		ViewModel.PositionHeight = 0.0;
		_keyboardheight = 0;
	}

	private void ChatDetailPage_Showing(InputPane sender, InputPaneVisibilityEventArgs args)
	{
		_keyboardheight = (int)args.OccludedRect.Height;
		ViewModel.PositionHeight = (double)_keyboardheight - ViewModel.FooterHeight;
	}

	private void ChatDetailPage_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		//IL_0021: Unknown result type (might be due to invalid IL or missing references)
		//IL_0027: Invalid comparison between Unknown and I4
		if ((int)ApplicationView.Value == 2)
		{
			appBar.put_IsOpen(false);
			return;
		}
		((UIElement)SendButton).put_Visibility((Visibility)0);
		if ((int)ApplicationView.Value != 2 && !EmoticonChooser.IsEventAlreadyRegister())
		{
			EmoticonChooser.Completed += EmoticonChooserControl_Completed;
			EmoticonChooser.Tapped += EmoticonChooser_Tapped;
			EmoticonChooser.Closed += EmoticonChooser_Closed;
			((FrameworkElement)InputBoxBorder).put_Width(double.NaN);
			((FrameworkElement)InputBoxBorder).put_Margin(new Thickness(10.0, 1.0, 10.0, -3.0));
			((FrameworkElement)InputBox).put_Width(double.NaN);
			((FrameworkElement)SendButton).put_Margin(new Thickness(0.0, -3.0, 20.0, -5.0));
			((FrameworkElement)SendButton).put_Width(100.0);
		}
	}

	private static void OnListVerticalOffsetMediatorChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		if (obj is ChatDetailPage)
		{
			ChatDetailPage chatDetailPage = obj as ChatDetailPage;
			ScrollViewer messageScrollViewer = chatDetailPage.GetMessageScrollViewer();
			messageScrollViewer.ScrollToVerticalOffset((double)e.NewValue);
		}
	}

	private void Current_VisibilityChanged(object sender, VisibilityChangedEventArgs e)
	{
		if (e.Visible)
		{
			if (!ViewModel.IsConnected && ViewModel.Chat != null)
			{
				ViewModel.ReConnect();
			}
		}
		else
		{
			Disconnect(IsNullChat: false);
		}
	}

	public unsafe void OnLoaded()
	{
		//IL_014a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0150: Invalid comparison between Unknown and I4
		int count = ((ICollection<UIElement>)((Panel)LayoutRoot).Children).Count;
		for (int num = count - 1; num >= 0; num--)
		{
			UIElement val = ((IList<UIElement>)((Panel)LayoutRoot).Children)[num];
			if ((object)((object)val).GetType() == typeof(CustomPopup))
			{
				((ICollection<UIElement>)((Panel)LayoutRoot).Children).Remove(val);
			}
		}
		ViewModel.HeaderHeight = Utility.GetElementRect((FrameworkElement)(object)HeaderGrid).Height;
		if (ViewModel != null && ViewModel.Chat != null)
		{
			if (!IsNavigatedToTrunk)
			{
				ViewModel.OpenChatDetail(ViewModel.Chat.ChatID);
			}
			else
			{
				ViewModel.ReConnect();
				IsNavigatedToTrunk = false;
			}
			if (ViewModel.Chat.ChatType == ChatType.BROADCAST)
			{
				((Control)TrunkButton).put_IsEnabled(false);
			}
			else
			{
				((Control)TrunkButton).put_IsEnabled(true);
			}
		}
		if (InputBox.Text.Trim() == string.Empty || InputBox.Text == Utility.GetResourceString("IDS_CHATON_BODY_ENTER_MESSAGE"))
		{
			((Control)SendButton).put_IsEnabled(false);
		}
		else
		{
			((Control)SendButton).put_IsEnabled(true);
		}
		((Page)this).BottomAppBar.put_IsOpen(false);
		if ((int)ApplicationView.Value == 2)
		{
			WindowsRuntimeMarshal.RemoveEventHandler<EventHandler<object>>(new Action<EventRegistrationToken>(appBar, (nint)__ldftn(AppBar.remove_Opened)), appBarEnable);
			AppBar val2 = appBar;
			WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val2, (nint)__ldftn(AppBar.add_Opened)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(AppBar.remove_Opened)), appBarEnable);
			((UIElement)AttachButton).put_Visibility((Visibility)1);
			((UIElement)EmoticonButton).put_Visibility((Visibility)1);
			((UIElement)RightCommands).put_Visibility((Visibility)1);
			((UIElement)RightCommands2).put_Visibility((Visibility)1);
			((UIElement)RightCommands3).put_Visibility((Visibility)0);
			UpdateStyle();
			if (!ViewModel.IsConnected && ViewModel.Chat != null)
			{
				ViewModel.ReConnect();
			}
			_sendEnterKey = SettingService.GetSendEnterKey();
			ViewModel.FooterHeight = 0.0;
		}
		else
		{
			if (ActiveInstance != null && ActiveInstance.ViewModel.Chat == null)
			{
				ViewModel.AppBarVisibility = (Visibility)1;
				appBar.put_IsOpen(false);
			}
			((UIElement)AttachButton).put_Visibility((Visibility)0);
			((UIElement)EmoticonButton).put_Visibility((Visibility)0);
			((UIElement)RightCommands3).put_Visibility((Visibility)1);
			OnToggleDeletionMode();
			if (!ViewModel.IsConnected)
			{
				ViewModel.ReConnect();
			}
			_sendEnterKey = SettingService.GetSendEnterKey();
			AppBar val3 = appBar;
			WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val3, (nint)__ldftn(AppBar.add_Opened)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(AppBar.remove_Opened)), appBar_Opened);
			ViewModel.FooterHeight = PivotPage.ActiveInstance.ViewModel.PivotFooterHeight - 5.0;
		}
		ApplySendEnterKeySetting();
		if (ActiveInstance != null && ChatOnService.Instance.RecentChat != null && ChatOnService.Instance.RecentChat.Messages.Count == 0 && ChatListPage.ActiveInstance.IsChatDetailOpened)
		{
			((Control)InputBox).Focus((FocusState)3);
		}
	}

	public void FocusInputText()
	{
		if (ViewModel != null && ViewModel.IsEnableToChat)
		{
			((Control)InputBox).Focus((FocusState)3);
		}
	}

	private void appBarEnable(object sender, object e)
	{
		appBar.put_IsOpen(true);
	}

	private unsafe void ChatDetailPage_Loaded(object sender, RoutedEventArgs e)
	{
		//IL_007c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0082: Invalid comparison between Unknown and I4
		if (InputBox.Text.Trim() == string.Empty || InputBox.Text == Utility.GetResourceString("IDS_CHATON_BODY_ENTER_MESSAGE"))
		{
			((Control)SendButton).put_IsEnabled(false);
		}
		else
		{
			((Control)SendButton).put_IsEnabled(true);
		}
		ViewModel.HeaderHeight = Utility.GetElementRect((FrameworkElement)(object)HeaderGrid).Height;
		((Page)this).BottomAppBar.put_IsOpen(false);
		if ((int)ApplicationView.Value == 2)
		{
			((UIElement)AttachButton).put_Visibility((Visibility)1);
			((UIElement)EmoticonButton).put_Visibility((Visibility)1);
			WindowsRuntimeMarshal.RemoveEventHandler<EventHandler<object>>(new Action<EventRegistrationToken>(appBar, (nint)__ldftn(AppBar.remove_Opened)), appBarEnable);
			AppBar val = appBar;
			WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val, (nint)__ldftn(AppBar.add_Opened)), new Action<EventRegistrationToken>(val, (nint)__ldftn(AppBar.remove_Opened)), appBarEnable);
			((UIElement)RightCommands).put_Visibility((Visibility)1);
			((UIElement)RightCommands2).put_Visibility((Visibility)1);
			((UIElement)RightCommands3).put_Visibility((Visibility)0);
			UpdateStyle();
			if (!ViewModel.IsConnected && ViewModel.Chat != null)
			{
				ViewModel.ReConnect();
			}
			_sendEnterKey = SettingService.GetSendEnterKey();
			ViewModel.FooterHeight = 0.0;
		}
		else
		{
			if (ActiveInstance != null && ActiveInstance.ViewModel.Chat == null)
			{
				ViewModel.AppBarVisibility = (Visibility)1;
				appBar.put_IsOpen(false);
			}
			((UIElement)AttachButton).put_Visibility((Visibility)0);
			((UIElement)EmoticonButton).put_Visibility((Visibility)0);
			((UIElement)RightCommands3).put_Visibility((Visibility)1);
			OnToggleDeletionMode();
			if (ViewModel.Chat != null && !ViewModel.IsConnected)
			{
				ViewModel.ReConnect();
			}
			_sendEnterKey = SettingService.GetSendEnterKey();
			AppBar val2 = appBar;
			WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val2, (nint)__ldftn(AppBar.add_Opened)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(AppBar.remove_Opened)), appBar_Opened);
			ViewModel.FooterHeight = PivotPage.ActiveInstance.ViewModel.PivotFooterHeight - 5.0;
		}
		ApplySendEnterKeySetting();
		((FrameworkElement)this).put_DataContext((object)ViewModel);
	}

	private void EmoticonChooser_Closed(object sender, object e)
	{
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_001f: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			ChatListPage.ActiveInstance.ToggleEmoticonChooser(forceHide: true);
		});
	}

	private unsafe void appBar_Opened(object sender, object e)
	{
		WindowsRuntimeMarshal.RemoveEventHandler<EventHandler<object>>(new Action<EventRegistrationToken>(appBar, (nint)__ldftn(AppBar.remove_Opened)), appBar_Opened);
		UpdateDeleteAppBarButton();
	}

	public void UpdateDeleteAppBarButton()
	{
		if (!ViewModel.IsChecked())
		{
			((UIElement)DeleteMessageButton).put_Visibility((Visibility)1);
		}
		else
		{
			((UIElement)DeleteMessageButton).put_Visibility((Visibility)0);
		}
	}

	private static void OnListVerticalOffsetChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		//IL_015e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0164: Expected O, but got Unknown
		//IL_01ea: Unknown result type (might be due to invalid IL or missing references)
		//IL_01f1: Expected O, but got Unknown
		DispatchedHandler val = null;
		DispatchedHandler val2 = null;
		ChatDetailPage page;
		if ((page = obj as ChatDetailPage) == null)
		{
			return;
		}
		if (page._isFirstOffsetChanged)
		{
			page._isFirstOffsetChanged = false;
			return;
		}
		ScrollViewer messageScrollViewer = page.GetMessageScrollViewer();
		if (messageScrollViewer == null)
		{
			page.ViewModel.MessagePreviewVisibility = (Visibility)1;
			return;
		}
		if (page.ViewModel != null)
		{
			page.ViewModel.ScrollVerticalOffset = messageScrollViewer.VerticalOffset;
			page.ViewModel.ScrollScrollableHeight = messageScrollViewer.ScrollableHeight;
		}
		if (messageScrollViewer.ScrollableHeight - 3.0 <= messageScrollViewer.VerticalOffset || Math.Abs(messageScrollViewer.VerticalOffset - messageScrollViewer.ScrollableHeight) < 1.0)
		{
			page.ViewModel.MessagePreviewVisibility = (Visibility)1;
		}
		if (messageScrollViewer.VerticalOffset <= 2.0)
		{
			if (!(TimeSpan.FromTicks(DateTime.UtcNow.Ticks - page._lastAddedTick).TotalMilliseconds > 1000.0))
			{
				return;
			}
			page._lastAddedTick = DateTime.UtcNow.Ticks;
			CoreDispatcher dispatcher = ((DependencyObject)page).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)delegate
				{
					if (page.ViewModel != null)
					{
						page.ViewModel.LoadRemainListItems(isPrev: true);
					}
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		}
		else
		{
			if (!(messageScrollViewer.VerticalOffset >= messageScrollViewer.ScrollableHeight - 2.0) || !(TimeSpan.FromTicks(DateTime.UtcNow.Ticks - page._lastAddedTick).TotalMilliseconds > 1000.0))
			{
				return;
			}
			page._lastAddedTick = DateTime.UtcNow.Ticks;
			CoreDispatcher dispatcher2 = ((DependencyObject)page).Dispatcher;
			if (val2 == null)
			{
				val2 = (DispatchedHandler)delegate
				{
					if (page.ViewModel != null)
					{
						page.ViewModel.LoadRemainListItems(isPrev: false);
					}
				};
			}
			dispatcher2.RunAsync((CoreDispatcherPriority)0, val2);
		}
	}

	private void ApplySendEnterKeySetting()
	{
		if (_sendEnterKey)
		{
			InputBox.put_AcceptsReturn(false);
		}
		else
		{
			InputBox.put_AcceptsReturn(true);
		}
	}

	private void EmoticonChooserControl_Completed(object sender, object e)
	{
		//IL_00c1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00cb: Expected O, but got Unknown
		Anicon anicon = e as Anicon;
		if (anicon != null)
		{
			PreviewAniconDialog previewAniconDialog = new PreviewAniconDialog();
			previewAniconDialog.AniconID = anicon.ID;
			((FrameworkElement)previewAniconDialog).put_HorizontalAlignment((HorizontalAlignment)1);
			((FrameworkElement)previewAniconDialog).put_VerticalAlignment((VerticalAlignment)1);
			previewAniconDialog.AcceptCompleted += delegate
			{
				//IL_0030: Unknown result type (might be due to invalid IL or missing references)
				//IL_003a: Expected O, but got Unknown
				ViewModel.SendAnicon(anicon);
				((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
				{
					ChatListPage.ActiveInstance.ToggleEmoticonChooser();
				});
			};
			PivotPage.ActiveInstance.OpenDialog((UserControl)(object)previewAniconDialog);
			return;
		}
		Brush foreground = ((Control)InputBox).Foreground;
		if (((SolidColorBrush)((foreground is SolidColorBrush) ? foreground : null)).Color == Colors.Gray)
		{
			InputBox.put_Text("");
			((Control)InputBox).put_Foreground((Brush)((IDictionary<object, object>)Application.Current.Resources)[(object)"TextBoxForegroundThemeBrush"]);
		}
		string text = InputBox.Text;
		string text2 = e as string;
		if (text.Length + text2.Length > 2001)
		{
			return;
		}
		int selectionStart = InputBox.SelectionStart;
		int num = InputBox.SelectionStart;
		for (int num2 = 0; num2 < num && num2 < text.Length; num2++)
		{
			if (text[num2] == '\r')
			{
				num++;
			}
		}
		int selectionLength = InputBox.SelectionLength;
		if (selectionLength > 0)
		{
			text = text.Remove(num, selectionLength);
		}
		text = text.Insert(num, text2);
		InputBox.put_Text(text);
		InputBox.put_SelectionStart(selectionStart + text2.Length);
		InputBox.put_SelectionLength(0);
		((Control)InputBox).Focus((FocusState)1);
	}

	private void EmoticonChooser_Tapped(object sender, object e)
	{
		((Control)InputBox).Focus((FocusState)3);
	}

	private unsafe void MessageList_Loaded(object sender, RoutedEventArgs e)
	{
		ScrollViewer messageScrollViewer = GetMessageScrollViewer();
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<ScrollViewerViewChangedEventArgs>, EventRegistrationToken>(messageScrollViewer, (nint)__ldftn(ScrollViewer.add_ViewChanged)), new Action<EventRegistrationToken>(messageScrollViewer, (nint)__ldftn(ScrollViewer.remove_ViewChanged)), scroll_ViewChanged);
	}

	private void scroll_ViewChanged(object sender, ScrollViewerViewChangedEventArgs e)
	{
		//IL_0165: Unknown result type (might be due to invalid IL or missing references)
		//IL_016b: Expected O, but got Unknown
		DispatchedHandler val = null;
		ViewModel.IsIntermediate = e.IsIntermediate;
		ViewModel.VerticalOffset = ((ScrollViewer)((sender is ScrollViewer) ? sender : null)).VerticalOffset;
		ViewModel.ScrollableHeight = ((ScrollViewer)((sender is ScrollViewer) ? sender : null)).ScrollableHeight;
		ViewModel.ExtentHeight = ((ScrollViewer)((sender is ScrollViewer) ? sender : null)).ExtentHeight;
		ViewModel.IsScrollTop = ((ScrollViewer)((sender is ScrollViewer) ? sender : null)).VerticalOffset <= 2.0;
		ViewModel.NotifyPropertyChanged("");
		ViewModel.NotifyMessagePreview();
		if (ViewModel.IsOnBottomPage)
		{
			ViewModel.MessagePreviewVisibility = (Visibility)1;
		}
		if ((ViewModel.IsOnBottomPage || ViewModel.IsBottomChatRoom()) && ViewModel.LastMessage != null)
		{
			_ = ViewModel.LastMessage.HasShownPreview;
			if (!ViewModel.LastMessage.HasShownPreview)
			{
				ViewModel.LastMessage.HasShownPreview = true;
			}
		}
		if (!ViewModel.IsScrollTop || !(TimeSpan.FromTicks(DateTime.UtcNow.Ticks - _lastAddedTick).TotalMilliseconds > 1000.0))
		{
			return;
		}
		_lastAddedTick = DateTime.UtcNow.Ticks;
		CoreDispatcher dispatcher = ((DependencyObject)this).Dispatcher;
		if (val == null)
		{
			val = (DispatchedHandler)delegate
			{
				if (ViewModel != null)
				{
					ViewModel.LoadRemainListItems(isPrev: true);
				}
			};
		}
		dispatcher.RunAsync((CoreDispatcherPriority)0, val);
	}

	public void OnCollectionChanged(NotifyCollectionChangedEventArgs e)
	{
		if (ViewModel == null || ViewModel.Chat == null || (ViewModel.Chat != null && ViewModel.Chat.MessageItems == null) || e.NewItems == null)
		{
			return;
		}
		Message message = null;
		foreach (Message newItem in e.NewItems)
		{
			if (message == null)
			{
				message = newItem;
			}
			else if (message.Time < newItem.Time)
			{
				message = newItem;
			}
		}
	}

	public void ActivateChat(Chat chat)
	{
		if (ChatListPage.ActiveInstance != null)
		{
			ChatListPage.ActiveInstance.IsInChatMode = true;
		}
		_lastAddedTick = DateTime.UtcNow.Ticks;
		IsNavigatedToTrunk = false;
		if (chat != null)
		{
			ViewModel.Chat = chat;
			ViewModel.NotifyPropertyChanged("");
			ChatOnService.Instance.RecentChat = chat;
			ViewModel.AppBarVisibility = (Visibility)0;
		}
		else
		{
			appBar.put_IsOpen(false);
		}
		InputBox.put_Text("");
		ShowEnterMessage();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		ShowEnterMessage();
		if (e.Content != null)
		{
			ChatDetailPageType chatDetailPageType = ChatDetailPageType.FullScreen;
			if (e.Parameter != null)
			{
				chatDetailPageType = (ChatDetailPageType)e.Parameter;
			}
			switch (chatDetailPageType)
			{
			case ChatDetailPageType.FullScreen:
				ActiveInstance = this;
				break;
			case ChatDetailPageType.Snapped:
				SnappedActiveInstance = this;
				break;
			default:
				ActiveInstance = this;
				break;
			}
		}
	}

	protected override void OnNavigatingFrom(NavigatingCancelEventArgs e)
	{
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
	}

	private async void OnSendMessage()
	{
		string text = InputBox.Text;
		if (string.IsNullOrEmpty(text.Trim()))
		{
			return;
		}
		bool isEmpty = true;
		string text2 = InputBox.Text;
		foreach (char c in text2)
		{
			if (c != ' ' && c != '\r' && c != '\n')
			{
				isEmpty = false;
				break;
			}
		}
		if (isEmpty || ((SolidColorBrush)/*isinst with value type is only supported in some contexts*/).Color == Colors.Gray)
		{
			return;
		}
		if (text.Length > ChatService.MAX_TEXT_LENGTH)
		{
			MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_MAXIMUM_CHARACTER_LIMIT_EXCEEDED"));
			await dialog.ShowAsync();
			return;
		}
		ViewModel.SendMessage(text);
		InputBox.put_Text("");
		if (ChatListPage.ActiveInstance != null)
		{
			ChatListPage.ActiveInstance.ToggleEmoticonChooser(forceHide: true);
		}
		((Control)InputBox).Focus((FocusState)2);
	}

	private void Button_Click_1(object sender, RoutedEventArgs e)
	{
		_sendButton = true;
		OnSendMessage();
	}

	private void EmoticonButton_Click_1(object sender, RoutedEventArgs e)
	{
		//IL_0023: Unknown result type (might be due to invalid IL or missing references)
		//IL_002d: Expected O, but got Unknown
		if (ViewModel.IsEnableToChat)
		{
			((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
			{
				ChatListPage.ActiveInstance.ToggleEmoticonChooser();
			});
		}
	}

	private async void AttachButton_Click_1(object sender, RoutedEventArgs e)
	{
		if (!ViewModel.IsEnableToChat)
		{
			return;
		}
		PopupMenu menu = new PopupMenu();
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BODY_PHOTO"), (UICommandInvokedHandler)null, (object)1));
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_TAKE_A_PHOTO"), (UICommandInvokedHandler)null, (object)2));
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_HEADER_VIDEO"), (UICommandInvokedHandler)null, (object)3));
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_RECORD_VIDEO_ABB"), (UICommandInvokedHandler)null, (object)4));
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_SK3_CONTACT"), (UICommandInvokedHandler)null, (object)5));
		SettingService.SetSelectedIndex(1);
		Rect rect = Utility.GetElementRect((FrameworkElement)sender);
		if (_keyboardheight != 0)
		{
			rect.Y += _keyboardheight - 75;
		}
		try
		{
			IUICommand chosenCommand = await menu.ShowForSelectionAsync(rect);
			if (chosenCommand == null)
			{
				return;
			}
			switch ((int)chosenCommand.Id)
			{
			case 1:
			{
				FileOpenPicker pk = new FileOpenPicker();
				pk.put_ViewMode((PickerViewMode)1);
				pk.put_SuggestedStartLocation((PickerLocationId)6);
				pk.FileTypeFilter.Add(".jpg");
				pk.FileTypeFilter.Add(".jpeg");
				pk.FileTypeFilter.Add(".png");
				pk.FileTypeFilter.Add(".bmp");
				pk.FileTypeFilter.Add(".gif");
				StorageFile file2 = await pk.PickSingleFileAsync();
				if (file2 != null)
				{
					CropPage.Init();
					CropPage.IsChat = true;
					CropPage.CropCompleted += async delegate(object s2, object p)
					{
						await ViewModel.AttachPhoto((StorageFile)((p is StorageFile) ? p : null));
					};
					CropPage.CroppedAspectRatio = SettingService.GetPictureSize();
					((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(CropPage), (object)file2);
				}
				break;
			}
			case 2:
				try
				{
					CameraCaptureUI dialog2 = new CameraCaptureUI();
					dialog2.PhotoSettings.put_MaxResolution((CameraCaptureUIMaxPhotoResolution)3);
					StorageFile file3 = await dialog2.CaptureFileAsync((CameraCaptureUIMode)1);
					if (file3 != null)
					{
						await ViewModel.AttachPhoto(file3);
					}
					break;
				}
				catch (Exception)
				{
					Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_CAMERA_NOT_AVAILABLE"), showCancel: false, Utility.GetResourceString("IDS_CHATON_BODY_ERROR"));
					break;
				}
			case 3:
			{
				FileOpenPicker pk2 = new FileOpenPicker();
				pk2.put_ViewMode((PickerViewMode)1);
				pk2.put_SuggestedStartLocation((PickerLocationId)7);
				pk2.FileTypeFilter.Add(".mp4");
				pk2.FileTypeFilter.Add(".3gp");
				StorageFile file4 = await pk2.PickSingleFileAsync();
				if (file4 != null)
				{
					if ((await file4.GetBasicPropertiesAsync()).Size > 10485760)
					{
						await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_UNABLE_TO_SEND_FILE_SIZE_TOO_LARGE"), showCancel: false);
					}
					else
					{
						await ViewModel.AttachVideo(file4);
					}
				}
				break;
			}
			case 4:
				try
				{
					CameraCaptureUI dialog = new CameraCaptureUI();
					dialog.VideoSettings.put_MaxResolution((CameraCaptureUIMaxVideoResolution)1);
					dialog.VideoSettings.put_MaxDurationInSeconds(60f);
					dialog.VideoSettings.put_Format((CameraCaptureUIVideoFormat)0);
					StorageFile file = await dialog.CaptureFileAsync((CameraCaptureUIMode)2);
					if (file != null)
					{
						if ((await file.GetBasicPropertiesAsync()).Size > 10485760)
						{
							await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_UNABLE_TO_SEND_FILE_SIZE_TOO_LARGE"), showCancel: false);
						}
						else
						{
							await ViewModel.AttachVideo(file);
						}
					}
					break;
				}
				catch (Exception)
				{
					Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_CAMERA_NOT_AVAILABLE"), showCancel: false, Utility.GetResourceString("IDS_CHATON_BODY_ERROR"));
					break;
				}
			case 5:
			{
				ContactPicker picker = new ContactPicker();
				picker.put_CommitButtonText(Utility.GetResourceString("IDS_CHATON_BUTTON_UPLOAD"));
				picker.put_SelectionMode((ContactSelectionMode)0);
				ContactInformation result = await picker.PickSingleContactAsync();
				if (result != null)
				{
					if (result.PhoneNumbers.Count >= 1 || result.Emails.Count >= 1)
					{
						await ViewModel.AttachContact(result);
					}
					else
					{
						await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_BODY_CONTACT_NOT_FOUND"), showCancel: false);
					}
				}
				break;
			}
			}
		}
		catch (Exception)
		{
		}
	}

	private async void CustomCameraCapture_CameraCompleted(object sender, object arg)
	{
		CustomCameraCapture.CameraCompleted -= CustomCameraCapture_CameraCompleted;
		StorageFile file = await Utility.CreateLocalFile(Guid.NewGuid().ToString() + ".jpg", "", replaceExisting: true);
		((StorageFile)((arg is StorageFile) ? arg : null)).CopyAndReplaceAsync((IStorageFile)(object)file);
		if (sender is CustomCameraCapture customCameraCapture && ((Page)customCameraCapture).Frame.CanGoBack)
		{
			((Page)customCameraCapture).Frame.GoBack();
		}
		if (file != null)
		{
			await ViewModel.AttachPhoto(file);
		}
	}

	private void SelectContactCompleted(IAsyncOperation<IReadOnlyList<ContactInformation>> result, AsyncStatus asyncStatus)
	{
		result.GetResults();
	}

	private void DummyGrid_SizeChanged_1(object sender, SizeChangedEventArgs e)
	{
		((FrameworkElement)((sender is FrameworkElement) ? sender : null)).put_Tag((object)e.NewSize.Width);
	}

	private void ChatProfile_Click(object sender, RoutedEventArgs e)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		if ((int)ApplicationView.Value != 2)
		{
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(ChatProfilePage), (object)ViewModel.Chat);
		}
	}

	private void ContentControl_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		((Control)TrunkButton).Focus((FocusState)2);
		Message msg = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as Message;
		ViewModel.OnClickMessage(sender, msg);
	}

	private void CloseChat_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.CloseChat();
	}

	private void ToggleDeleteMessage_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.ToggleDeletionMode();
		OnToggleDeletionMode();
	}

	public void OnToggleDeletionMode()
	{
		if (ViewModel.Chat == null)
		{
			return;
		}
		if (ViewModel.Chat.IsDeletionMode)
		{
			((UIElement)RightCommands).put_Visibility((Visibility)1);
			((UIElement)RightCommands2).put_Visibility((Visibility)0);
			if (ViewModel.Chat.ChatType == ChatType.BROADCAST)
			{
				((UIElement)Button2).put_Visibility((Visibility)1);
			}
			appBar.put_IsSticky(true);
			UpdateDeleteAppBarButton();
		}
		else
		{
			((UIElement)RightCommands).put_Visibility((Visibility)0);
			((UIElement)RightCommands2).put_Visibility((Visibility)1);
			((UIElement)Button2).put_Visibility((Visibility)0);
			appBar.put_IsSticky(false);
			appBar.put_IsOpen(false);
		}
	}

	private void CancelDeleteMessage_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.ToggleDeletionMode();
		OnToggleDeletionMode();
	}

	private void DeleteMessage_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.DeleteSelectedMessages();
	}

	private void SelectAll_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.SelectAllMessages();
	}

	private void SelectReceived_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.SelectReceivedMessages();
	}

	private void SelectSent_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.SelectSentMessages();
	}

	private void InviteBuddies_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.InviteBuddies();
	}

	private void BuddyProfileImage_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		//IL_0016: Unknown result type (might be due to invalid IL or missing references)
		//IL_001c: Invalid comparison between Unknown and I4
		Message message = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is Message message2 && (int)ApplicationView.Value != 2)
		{
			ViewModel.OpenBuddyProfile(message2.Sender);
		}
	}

	private void InputBox_KeyDown_1(object sender, KeyRoutedEventArgs e)
	{
		//IL_000a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0011: Invalid comparison between Unknown and I4
		//IL_0014: Unknown result type (might be due to invalid IL or missing references)
		if (_sendEnterKey && (int)e.Key == 13 && e.KeyStatus.RepeatCount == 0)
		{
			OnSendMessage();
		}
	}

	private void InputBox_GotFocus_1(object sender, RoutedEventArgs e)
	{
		//IL_0031: Unknown result type (might be due to invalid IL or missing references)
		//IL_0051: Unknown result type (might be due to invalid IL or missing references)
		//IL_005b: Expected O, but got Unknown
		Brush foreground = ((Control)InputBox).Foreground;
		if (((SolidColorBrush)((foreground is SolidColorBrush) ? foreground : null)).Color == Colors.Gray)
		{
			InputBox.put_Text("");
			new AccessibilitySettings();
			((Control)InputBox).put_Foreground((Brush)((IDictionary<object, object>)Application.Current.Resources)[(object)"TextBoxForegroundThemeBrush"]);
		}
		if (InputBox.Text.Trim() == string.Empty)
		{
			((Control)SendButton).put_IsEnabled(false);
		}
		else
		{
			((Control)SendButton).put_IsEnabled(true);
		}
		_isFocused = true;
	}

	private void InputBox_LostFocus_1(object sender, RoutedEventArgs e)
	{
		_isFocused = false;
		if (string.IsNullOrEmpty(InputBox.Text))
		{
			ShowEnterMessage();
		}
		if (ViewModel != null)
		{
			ViewModel.ShowUnknownBuddyGrid();
		}
	}

	private void ShowEnterMessage()
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		InputBox.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_ENTER_MESSAGE"));
		_isDefaultMessage = true;
		((Control)InputBox).put_Foreground((Brush)new SolidColorBrush(Colors.Gray));
	}

	private void DateHeaderCheckBox_Click_1(object sender, RoutedEventArgs e)
	{
		Message msg = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as Message;
		ViewModel.OnClickDateHeaderCheckBox(msg);
	}

	private void CheckBox_Click_1(object sender, RoutedEventArgs e)
	{
		Message clickedMessage = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as Message;
		ViewModel.OnClickCheckBox(clickedMessage);
	}

	public void UpdateStyle()
	{
		ViewModel.UpdateStyle();
	}

	public void Disconnect(bool IsNullChat = true)
	{
		ViewModel.IsConnected = false;
		ViewModel.Disconnect(IsNullChat);
	}

	internal void OnToastNotification(string senderID, string sessionID, ChatType msgChatType)
	{
		if (Window.Current == null || Window.Current.Visible)
		{
			ViewModel.OnPushReceived(senderID, sessionID, msgChatType);
		}
	}

	private void ReSend_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		Message msg = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as Message;
		ViewModel.ReSendMessage(msg);
	}

	private void Delete_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		Message msg = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as Message;
		ViewModel.DeleteMessage(msg);
	}

	private void Image_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		Message msg = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as Message;
		ViewModel.OnCancelUploadFile(msg);
	}

	private void Image_Tapped_2(object sender, TappedRoutedEventArgs e)
	{
		Message msg = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as Message;
		ViewModel.OnCancelDownloading(msg);
	}

	internal void OnDestroy()
	{
		((FrameworkElement)this).put_DataContext((object)null);
	}

	public void ShowSplashPopup(string text)
	{
		Utility.ShowSimpleToastNotification(text);
	}

	public void ShowErrorMessage(string text)
	{
		((UIElement)gridMessage).put_Visibility((Visibility)1);
	}

	internal void CheckScrollToEnd(Message msg, bool heightUpdated)
	{
		//IL_00a0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a6: Expected O, but got Unknown
		if (_scrollTarget == null)
		{
			ScrollViewer messageScrollViewer = GetMessageScrollViewer();
			if (messageScrollViewer != null)
			{
				messageScrollViewer.ScrollToVerticalOffset(VerticalOffset);
			}
		}
		else if ((TimeSpan.FromTicks(DateTime.Now.Ticks - _scrollToEndTime.Ticks).TotalSeconds < 10.0 && (ViewModel.IsOnBottomPage || ViewModel.IsBottomChatRoom())) || (msg == _scrollTarget && msg.ProgressValue != 100 && (msg.ActivityState != Message.State.Uploading || ViewModel.IsOnBottomPage || ViewModel.IsBottomChatRoom())))
		{
			SemanticZoomLocation val = new SemanticZoomLocation();
			val.put_Item((object)_scrollTarget);
			((ListViewBase)MessageList).MakeVisible(val);
		}
	}

	public void ScrollToMessage(Message msg)
	{
		_scrollToEndTime = DateTime.Now;
		_scrollTarget = msg;
	}

	public void ScrollToSelectedMessage(Message msg)
	{
		//IL_0012: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Expected O, but got Unknown
		_scrollToEndTime = DateTime.Now;
		_scrollTarget = msg;
		SemanticZoomLocation val = new SemanticZoomLocation();
		val.put_Item((object)_scrollTarget);
		((ListViewBase)MessageList).MakeVisible(val);
	}

	public void ScrollToExactEnd()
	{
		if (ViewModel != null && ViewModel.MessageItems != null)
		{
			_scrollToEndTime = DateTime.Now;
			_scrollTarget = ViewModel.MessageItems.LastOrDefault();
			ScrollViewer messageScrollViewer = GetMessageScrollViewer();
			if (messageScrollViewer != null)
			{
				messageScrollViewer.ScrollToVerticalOffset(messageScrollViewer.ScrollableHeight);
			}
		}
	}

	public bool IsBottomChatRoom()
	{
		ScrollViewer messageScrollViewer = GetMessageScrollViewer();
		if (messageScrollViewer != null)
		{
			if (Math.Abs(messageScrollViewer.VerticalOffset - messageScrollViewer.ScrollableHeight) < 10.0 || messageScrollViewer.VerticalOffset >= messageScrollViewer.ScrollableHeight - 2.0)
			{
				return true;
			}
			return false;
		}
		return true;
	}

	public void KeepCurrentState(Message msg = null)
	{
		_scrollToEndTime = DateTime.Now;
		_scrollTarget = msg;
		ScrollViewer messageScrollViewer = GetMessageScrollViewer();
		if (messageScrollViewer != null)
		{
			if (messageScrollViewer.VerticalOffset == messageScrollViewer.ScrollableHeight)
			{
				ScrollToEnd();
			}
			else
			{
				messageScrollViewer.ScrollToVerticalOffset(messageScrollViewer.VerticalOffset);
			}
			if (ViewModel != null && ViewModel.Chat != null && ViewModel.Chat.MessageItems != null)
			{
				MessageToRender = ViewModel.Chat.MessageItems.Count * 2;
				VerticalOffset = messageScrollViewer.VerticalOffset;
			}
		}
	}

	public void ScrollToEnd()
	{
		if (ViewModel == null || ViewModel.MessageItems == null)
		{
			return;
		}
		if (ViewModel.LastMessage != null)
		{
			_ = ViewModel.LastMessage.HasShownPreview;
			if (!ViewModel.LastMessage.HasShownPreview)
			{
				ViewModel.LastMessage.HasShownPreview = true;
			}
		}
		_scrollToEndTime = DateTime.Now;
		_scrollTarget = ViewModel.MessageItems.LastOrDefault();
		ScrollToSelectedMessage(_scrollTarget);
	}

	internal ScrollViewer GetMessageScrollViewer()
	{
		ScrollViewer val = null;
		try
		{
			return ((DependencyObject)(object)MessageList).GetFirstDescendantOfType<ScrollViewer>();
		}
		catch
		{
			return null;
		}
	}

	public void ShowProgress()
	{
		if (!_isShowing)
		{
			_progressControl.Show((Panel)(object)LayoutRoot);
			_isShowing = true;
		}
	}

	public void HideProgress()
	{
		_progressControl.Hide();
		_isShowing = false;
	}

	internal void UpdateListLayout()
	{
		((UIElement)MessageList).UpdateLayout();
	}

	internal void OnInputPaneShowing()
	{
		throw new NotImplementedException();
	}

	internal void OnInputPaneShowing(InputPaneVisibilityEventArgs args)
	{
		IsKeyboardShow = true;
		if (ViewModel.Chat != null && ViewModel.Chat.MessageItems.Count < 5)
		{
			((FrameworkElement)this).put_Margin(new Thickness(0.0, 0.0, 0.0, ((FrameworkElement)this).ActualHeight - args.OccludedRect.Height));
		}
	}

	internal void OnInputPaneHiding()
	{
		IsKeyboardShow = false;
		((FrameworkElement)this).put_Margin(new Thickness(0.0, 0.0, 0.0, 0.0));
	}

	private void Button_Click_2(object sender, RoutedEventArgs e)
	{
		((Control)((sender is Button) ? sender : null)).put_IsEnabled(false);
		ViewModel.LoadRemainListItems(isPrev: true);
	}

	private void ProfileImage_Loaded_1(object sender, RoutedEventArgs e)
	{
		//IL_006a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0071: Expected O, but got Unknown
		//IL_0080: Unknown result type (might be due to invalid IL or missing references)
		//IL_008a: Expected O, but got Unknown
		FrameworkElement val = (FrameworkElement)((sender is FrameworkElement) ? sender : null);
		if (val.Tag == null || !(bool)val.Tag)
		{
			Message msg = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as Message;
			DataService dataService = new DataService();
			Buddy buddy = dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == msg.Sender);
			if (buddy != null)
			{
				object obj = ((sender is Image) ? sender : null);
				DependencyProperty sourceProperty = Image.SourceProperty;
				Binding val2 = new Binding();
				val2.put_Source((object)buddy);
				val2.put_Path(new PropertyPath("ProfileImage"));
				((FrameworkElement)obj).SetBinding(sourceProperty, (BindingBase)(object)val2);
			}
			((FrameworkElement)((sender is FrameworkElement) ? sender : null)).put_Tag((object)true);
		}
	}

	private void MessageList_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (ChatListPage.ActiveInstance != null)
		{
			ChatListPage.ActiveInstance.ToggleEmoticonChooser(forceHide: true);
		}
	}

	public void AddtoUnknownMessage(string msg)
	{
		((UIElement)UnknownBuddyGrid).put_Visibility((Visibility)0);
		UnknownBuddyNoticeBlock.put_Text(msg);
	}

	public void HideUnknownMessage()
	{
		ViewModel.UnknownMessageVisibility = (Visibility)1;
	}

	private void BuddyMessageProfile_Loaded(object sender, RoutedEventArgs e)
	{
		Grid val = (Grid)((sender is Grid) ? sender : null);
		Message msg = ((FrameworkElement)val).DataContext as Message;
		ViewModel.LoadBuddyProfileImage(val, msg);
	}

	private void AddBuddyBtn_Click(object sender, RoutedEventArgs e)
	{
		string senderPhone = ViewModel.Chat.Sender;
		DataService dataService = new DataService();
		UnknownUser buddy = dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == senderPhone);
		ViewModel.AddBuddy(buddy);
	}

	private void BlockBuddyBtn_Click(object sender, RoutedEventArgs e)
	{
		string senderPhone = ViewModel.Chat.Sender;
		DataService dataService = new DataService();
		UnknownUser buddy = dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == senderPhone);
		ViewModel.BlockBuddy(buddy);
	}

	private void DeleteAllMessage_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.AppBarVisibility = (Visibility)1;
		appBar.put_IsOpen(false);
		PopupControl popupControl = new PopupControl();
		((FrameworkElement)popupControl).put_HorizontalAlignment((HorizontalAlignment)2);
		((FrameworkElement)popupControl).put_VerticalAlignment((VerticalAlignment)2);
		((FrameworkElement)popupControl).put_Margin(new Thickness(0.0, 0.0, 250.0, 0.0));
		popupControl.DetailText = Utility.GetResourceString("IDS_CHATON_POP_THIS_CONTENT_WILL_BE_DELETED");
		popupControl.ShowCancel = true;
		popupControl.OKButtonText = Utility.GetResourceString("IDS_CHATON_BUTTON_OK");
		popupControl.CancelButtonText = Utility.GetResourceString("IDS_CHATON_BUTTON_CANCEL");
		popupControl.TitleText = Utility.GetResourceString("IDS_CHATON_BUTTON_DELETE_ALL_CHAT_RECORDS");
		popupControl.ChatOnPopupCompleted += dialog_ChatOnPopupCompleted;
		OpenDialog((UserControl)(object)popupControl);
	}

	private void dialog_ChatOnPopupCompleted(object sender, object e)
	{
		if (sender is PopupControl)
		{
			(sender as PopupControl).ChatOnPopupCompleted -= dialog_ChatOnPopupCompleted;
			if ((bool)e)
			{
				ViewModel.DeleteAllChatRecords();
			}
			ViewModel.AppBarVisibility = (Visibility)0;
			appBar.put_IsOpen(true);
		}
	}

	public void CheckButtonSend(bool isConnected)
	{
		if (isConnected)
		{
			((Control)SendButton).put_IsEnabled(true);
		}
		else
		{
			((Control)SendButton).put_IsEnabled(false);
		}
	}

	public void ShowWarning()
	{
		((UIElement)gridMessage).put_Visibility((Visibility)1);
		((UIElement)gridErrorMessage).put_Visibility((Visibility)0);
	}

	public void ResetWarning()
	{
		((UIElement)gridMessage).put_Visibility((Visibility)0);
		((UIElement)gridErrorMessage).put_Visibility((Visibility)1);
	}

	internal void OpenDialog(UserControl dialog)
	{
		new CustomPopup(null, (Panel)(object)LayoutRoot, (FrameworkElement)(object)dialog);
	}

	private void ContentControl_Hold_1(object sender, HoldingRoutedEventArgs e)
	{
		Message message = null;
		if (!(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is Message message2))
		{
			return;
		}
		if (message2.Type == "media" && !message2.Text.Contains("/download/anicon"))
		{
			if (!string.IsNullOrEmpty(message2.MediaFilePath))
			{
				ViewModel.OpenImaegContextMenu(sender, message2);
			}
		}
		else
		{
			ViewModel.OnClickMessage(sender, message2);
		}
	}

	private void Error_Tapped(object sender, TappedRoutedEventArgs e)
	{
		//IL_002e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0034: Expected O, but got Unknown
		//IL_004a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0050: Expected O, but got Unknown
		Image val = (Image)((sender is Image) ? sender : null);
		((UIElement)val).put_Visibility((Visibility)1);
		DependencyObject parent = ((FrameworkElement)val).Parent;
		if (parent != null)
		{
			DependencyObject child = VisualTreeHelper.GetChild(parent, 1);
			Image val2 = (Image)((FrameworkElement)((child is FrameworkElement) ? child : null)).FindName("btnResend");
			DependencyObject child2 = VisualTreeHelper.GetChild(parent, 2);
			Image val3 = (Image)((FrameworkElement)((child2 is FrameworkElement) ? child2 : null)).FindName("btnCancel");
			if (val2 != null && val3 != null)
			{
				((UIElement)val2).put_Visibility((Visibility)0);
				((UIElement)val3).put_Visibility((Visibility)0);
			}
		}
	}

	private void LayoutRoot_OnTapped(object sender, TappedRoutedEventArgs e)
	{
		if (((RoutedEventArgs)e).OriginalSource != null && ((RoutedEventArgs)e).OriginalSource.ToString().Contains("Border") && !_sendButton)
		{
			((Control)TrunkButton).Focus((FocusState)2);
		}
		else
		{
			_sendButton = false;
		}
	}

	private void InviteBuddiesSnapped_Click(object sender, RoutedEventArgs e)
	{
		ApplicationView.TryUnsnap();
		ViewModel.InviteBuddies();
	}

	internal void ShowLoading()
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
	}

	private void Trunk_Tapped(object sender, TappedRoutedEventArgs e)
	{
		//IL_000c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0012: Invalid comparison between Unknown and I4
		if (ChatOnService.Instance.RecentChat != null)
		{
			if ((int)ApplicationView.Value == 2)
			{
				ApplicationView.TryUnsnap();
			}
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(TrunkPage), (object)ChatOnService.Instance.RecentChat.ChatID);
			ViewModel.Disconnect(isNullChat: false);
			IsNavigatedToTrunk = true;
		}
	}

	private Rect GetTextBoxRect(TextBox t)
	{
		Rect empty = Rect.Empty;
		try
		{
			empty = t.GetRectFromCharacterIndex(t.SelectionStart, false);
		}
		catch (Exception)
		{
			empty = default(Rect);
		}
		GeneralTransform val = ((UIElement)t).TransformToVisual((UIElement)null);
		Point location = val.TransformPoint(default(Point));
		location.X += empty.X;
		location.Y += empty.Y;
		return new Rect(location, new Size(empty.Width, empty.Height));
	}

	private async void InputBox_ContextMenuOpening(object sender, ContextMenuEventArgs e)
	{
		try
		{
			e.put_Handled(true);
			TextBox t = (TextBox)sender;
			PopupMenu p = new PopupMenu();
			DataPackageView temp = Clipboard.GetContent();
			bool isClipboardEmpty = (int)temp.RequestedOperation == 0;
			if (string.IsNullOrEmpty(t.Text))
			{
				if (isClipboardEmpty)
				{
					p.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BODY_PASTE"), (UICommandInvokedHandler)null, (object)2));
				}
			}
			else
			{
				if (string.IsNullOrEmpty(t.SelectedText))
				{
					if (isClipboardEmpty)
					{
						p.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BODY_PASTE"), (UICommandInvokedHandler)null, (object)2));
					}
				}
				else
				{
					p.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_KPD_OPT_CUT"), (UICommandInvokedHandler)null, (object)0));
					p.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_COPY"), (UICommandInvokedHandler)null, (object)1));
					if (isClipboardEmpty)
					{
						p.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BODY_PASTE"), (UICommandInvokedHandler)null, (object)2));
					}
				}
				p.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BUTTON_SELECT_ALL"), (UICommandInvokedHandler)null, (object)3));
				p.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BUTTON2_DELETE"), (UICommandInvokedHandler)null, (object)4));
			}
			IUICommand selectedCommand = await p.ShowForSelectionAsync(GetTextBoxRect(t));
			if (selectedCommand == null)
			{
				return;
			}
			switch ((int)selectedCommand.Id)
			{
			case 0:
				if (!string.IsNullOrEmpty(t.SelectedText))
				{
					string text = t.SelectedText;
					t.put_SelectedText("");
					DataPackage d = new DataPackage();
					d.SetText(text);
					Clipboard.SetContent(d);
				}
				break;
			case 1:
			{
				string text = t.SelectedText;
				DataPackage d = new DataPackage();
				d.SetText(text);
				Clipboard.SetContent(d);
				break;
			}
			case 2:
				t.put_SelectedText(await Clipboard.GetContent().GetTextAsync());
				break;
			case 3:
				t.SelectAll();
				break;
			case 4:
				t.put_Text("");
				break;
			}
		}
		catch
		{
		}
	}

	private void InputBox_TextChanged(object sender, TextChangedEventArgs e)
	{
		if (InputBox.Text.Trim() == string.Empty || InputBox.Text == Utility.GetResourceString("IDS_CHATON_BODY_ENTER_MESSAGE"))
		{
			((Control)SendButton).put_IsEnabled(false);
		}
		else
		{
			((Control)SendButton).put_IsEnabled(true);
		}
	}

	private void ChatBubble_PointerPressed_1(object sender, PointerRoutedEventArgs e)
	{
		_isMouseMove = false;
		if (_gr == null)
		{
			InitGestureSettings();
		}
		try
		{
			IList<PointerPoint> intermediatePoints = e.GetIntermediatePoints((UIElement)null);
			if (_gr != null && intermediatePoints != null && intermediatePoints.Count > 0)
			{
				_gr.ProcessDownEvent(intermediatePoints[0]);
				e.put_Handled(true);
				TmpSender = sender;
			}
		}
		catch
		{
		}
	}

	private void ChatBubble_PointerReleased_1(object sender, PointerRoutedEventArgs e)
	{
		IList<PointerPoint> intermediatePoints = e.GetIntermediatePoints((UIElement)null);
		if (intermediatePoints != null && intermediatePoints.Count > 0 && _gr != null)
		{
			_gr.ProcessUpEvent(intermediatePoints[0]);
			e.put_Handled(true);
			_gr.CompleteGesture();
		}
	}

	private void ChatBubble_PointerMoved_1(object sender, PointerRoutedEventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_002d: Invalid comparison between Unknown and I4
		if (_gr != null)
		{
			_gr.ProcessMoveEvents(e.GetIntermediatePoints((UIElement)null));
			e.put_Handled(true);
			if ((int)e.Pointer.PointerDeviceType == 2)
			{
				_isMouseMove = true;
			}
		}
	}

	private void MessagePreviewTapped(object sender, TappedRoutedEventArgs e)
	{
		if (ViewModel.LastMessage != null)
		{
			ScrollToEnd();
			ScrollToEnd();
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
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
		//IL_018d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0197: Expected O, but got Unknown
		//IL_01a3: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ad: Expected O, but got Unknown
		//IL_01b9: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c3: Expected O, but got Unknown
		//IL_01cf: Unknown result type (might be due to invalid IL or missing references)
		//IL_01d9: Expected O, but got Unknown
		//IL_01e5: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ef: Expected O, but got Unknown
		//IL_0227: Unknown result type (might be due to invalid IL or missing references)
		//IL_0231: Expected O, but got Unknown
		//IL_023d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0247: Expected O, but got Unknown
		//IL_0253: Unknown result type (might be due to invalid IL or missing references)
		//IL_025d: Expected O, but got Unknown
		//IL_0269: Unknown result type (might be due to invalid IL or missing references)
		//IL_0273: Expected O, but got Unknown
		//IL_027f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0289: Expected O, but got Unknown
		//IL_0295: Unknown result type (might be due to invalid IL or missing references)
		//IL_029f: Expected O, but got Unknown
		//IL_02ab: Unknown result type (might be due to invalid IL or missing references)
		//IL_02b5: Expected O, but got Unknown
		//IL_02c1: Unknown result type (might be due to invalid IL or missing references)
		//IL_02cb: Expected O, but got Unknown
		//IL_02ed: Unknown result type (might be due to invalid IL or missing references)
		//IL_02f7: Expected O, but got Unknown
		//IL_0303: Unknown result type (might be due to invalid IL or missing references)
		//IL_030d: Expected O, but got Unknown
		//IL_0319: Unknown result type (might be due to invalid IL or missing references)
		//IL_0323: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///ChatDetailPage.xaml"), (ComponentResourceLocation)0);
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			LeftCommands = (StackPanel)((FrameworkElement)this).FindName("LeftCommands");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			RightCommands2 = (StackPanel)((FrameworkElement)this).FindName("RightCommands2");
			RightCommands3 = (StackPanel)((FrameworkElement)this).FindName("RightCommands3");
			InviteButtonSnapped = (ImageButton)((FrameworkElement)this).FindName("InviteButtonSnapped");
			DeleteMessageButton = (ImageButton)((FrameworkElement)this).FindName("DeleteMessageButton");
			Button5 = (ImageButton)((FrameworkElement)this).FindName("Button5");
			CloseChatButton = (ImageButton)((FrameworkElement)this).FindName("CloseChatButton");
			DeleteAllRecordButton = (ImageButton)((FrameworkElement)this).FindName("DeleteAllRecordButton");
			DeleteButton = (ImageButton)((FrameworkElement)this).FindName("DeleteButton");
			InviteButton = (ImageButton)((FrameworkElement)this).FindName("InviteButton");
			InfoButton = (ImageButton)((FrameworkElement)this).FindName("InfoButton");
			Button1 = (ImageButton)((FrameworkElement)this).FindName("Button1");
			Button2 = (ImageButton)((FrameworkElement)this).FindName("Button2");
			Button3 = (ImageButton)((FrameworkElement)this).FindName("Button3");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			HeaderGrid = (Grid)((FrameworkElement)this).FindName("HeaderGrid");
			MessagePreviewGrid = (Grid)((FrameworkElement)this).FindName("MessagePreviewGrid");
			gridErrorMessage = (Grid)((FrameworkElement)this).FindName("gridErrorMessage");
			gridMessage = (Grid)((FrameworkElement)this).FindName("gridMessage");
			AttachButton = (ImageButton)((FrameworkElement)this).FindName("AttachButton");
			EmoticonButton = (ImageButton)((FrameworkElement)this).FindName("EmoticonButton");
			InputBoxBorder = (Border)((FrameworkElement)this).FindName("InputBoxBorder");
			SendButton = (Button)((FrameworkElement)this).FindName("SendButton");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
			txtErrorMessage = (TextBlock)((FrameworkElement)this).FindName("txtErrorMessage");
			MessageList = (ListView)((FrameworkElement)this).FindName("MessageList");
			UnknownBuddyGrid = (Grid)((FrameworkElement)this).FindName("UnknownBuddyGrid");
			LoadingTextBlock = (TextBlock)((FrameworkElement)this).FindName("LoadingTextBlock");
			UnknownBuddyNoticeBlock = (TextBlock)((FrameworkElement)this).FindName("UnknownBuddyNoticeBlock");
			TrunkButton = (ImageButton)((FrameworkElement)this).FindName("TrunkButton");
			ChatItemImageGrid = (Grid)((FrameworkElement)this).FindName("ChatItemImageGrid");
			textTitle = (TextBlock)((FrameworkElement)this).FindName("textTitle");
			ProfileImageControl = (Image)((FrameworkElement)this).FindName("ProfileImageControl");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_00b4: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ba: Expected O, but got Unknown
		//IL_00d9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e3: Expected O, but got Unknown
		//IL_00e4: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ea: Expected O, but got Unknown
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Expected O, but got Unknown
		//IL_0119: Unknown result type (might be due to invalid IL or missing references)
		//IL_011f: Expected O, but got Unknown
		//IL_013e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0148: Expected O, but got Unknown
		//IL_014e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0155: Expected O, but got Unknown
		//IL_0176: Unknown result type (might be due to invalid IL or missing references)
		//IL_0180: Expected O, but got Unknown
		//IL_0186: Unknown result type (might be due to invalid IL or missing references)
		//IL_018d: Expected O, but got Unknown
		//IL_01ae: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b8: Expected O, but got Unknown
		//IL_01be: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c5: Expected O, but got Unknown
		//IL_01e6: Unknown result type (might be due to invalid IL or missing references)
		//IL_01f0: Expected O, but got Unknown
		//IL_01f6: Unknown result type (might be due to invalid IL or missing references)
		//IL_01fd: Expected O, but got Unknown
		//IL_021e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0228: Expected O, but got Unknown
		//IL_0229: Unknown result type (might be due to invalid IL or missing references)
		//IL_0230: Expected O, but got Unknown
		//IL_0251: Unknown result type (might be due to invalid IL or missing references)
		//IL_025b: Expected O, but got Unknown
		//IL_025c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0263: Expected O, but got Unknown
		//IL_0284: Unknown result type (might be due to invalid IL or missing references)
		//IL_028e: Expected O, but got Unknown
		//IL_028f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0296: Expected O, but got Unknown
		//IL_02b7: Unknown result type (might be due to invalid IL or missing references)
		//IL_02c1: Expected O, but got Unknown
		//IL_02c2: Unknown result type (might be due to invalid IL or missing references)
		//IL_02c9: Expected O, but got Unknown
		//IL_02ea: Unknown result type (might be due to invalid IL or missing references)
		//IL_02f4: Expected O, but got Unknown
		//IL_02fa: Unknown result type (might be due to invalid IL or missing references)
		//IL_0301: Expected O, but got Unknown
		//IL_0322: Unknown result type (might be due to invalid IL or missing references)
		//IL_032c: Expected O, but got Unknown
		//IL_0332: Unknown result type (might be due to invalid IL or missing references)
		//IL_0339: Expected O, but got Unknown
		//IL_035a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0364: Expected O, but got Unknown
		//IL_036a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0371: Expected O, but got Unknown
		//IL_0392: Unknown result type (might be due to invalid IL or missing references)
		//IL_039c: Expected O, but got Unknown
		//IL_03a2: Unknown result type (might be due to invalid IL or missing references)
		//IL_03a9: Expected O, but got Unknown
		//IL_03ca: Unknown result type (might be due to invalid IL or missing references)
		//IL_03d4: Expected O, but got Unknown
		//IL_03da: Unknown result type (might be due to invalid IL or missing references)
		//IL_03e1: Expected O, but got Unknown
		//IL_0402: Unknown result type (might be due to invalid IL or missing references)
		//IL_040c: Expected O, but got Unknown
		//IL_0412: Unknown result type (might be due to invalid IL or missing references)
		//IL_0419: Expected O, but got Unknown
		//IL_043a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0444: Expected O, but got Unknown
		//IL_044a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0451: Expected O, but got Unknown
		//IL_0472: Unknown result type (might be due to invalid IL or missing references)
		//IL_047c: Expected O, but got Unknown
		//IL_0482: Unknown result type (might be due to invalid IL or missing references)
		//IL_0489: Expected O, but got Unknown
		//IL_04aa: Unknown result type (might be due to invalid IL or missing references)
		//IL_04b4: Expected O, but got Unknown
		//IL_04ba: Unknown result type (might be due to invalid IL or missing references)
		//IL_04c1: Expected O, but got Unknown
		//IL_04e2: Unknown result type (might be due to invalid IL or missing references)
		//IL_04ec: Expected O, but got Unknown
		//IL_04ed: Unknown result type (might be due to invalid IL or missing references)
		//IL_04f4: Expected O, but got Unknown
		//IL_0515: Unknown result type (might be due to invalid IL or missing references)
		//IL_051f: Expected O, but got Unknown
		//IL_0525: Unknown result type (might be due to invalid IL or missing references)
		//IL_052c: Expected O, but got Unknown
		//IL_054d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0557: Expected O, but got Unknown
		//IL_055d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0564: Expected O, but got Unknown
		//IL_0585: Unknown result type (might be due to invalid IL or missing references)
		//IL_058f: Expected O, but got Unknown
		//IL_0595: Unknown result type (might be due to invalid IL or missing references)
		//IL_059c: Expected O, but got Unknown
		//IL_05bd: Unknown result type (might be due to invalid IL or missing references)
		//IL_05c7: Expected O, but got Unknown
		//IL_05c8: Unknown result type (might be due to invalid IL or missing references)
		//IL_05cf: Expected O, but got Unknown
		//IL_05f0: Unknown result type (might be due to invalid IL or missing references)
		//IL_05fa: Expected O, but got Unknown
		//IL_05fb: Unknown result type (might be due to invalid IL or missing references)
		//IL_0602: Expected O, but got Unknown
		//IL_0623: Unknown result type (might be due to invalid IL or missing references)
		//IL_062d: Expected O, but got Unknown
		//IL_062e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0635: Expected O, but got Unknown
		//IL_0656: Unknown result type (might be due to invalid IL or missing references)
		//IL_0660: Expected O, but got Unknown
		//IL_0661: Unknown result type (might be due to invalid IL or missing references)
		//IL_0668: Expected O, but got Unknown
		//IL_0689: Unknown result type (might be due to invalid IL or missing references)
		//IL_0693: Expected O, but got Unknown
		//IL_0699: Unknown result type (might be due to invalid IL or missing references)
		//IL_06a0: Expected O, but got Unknown
		//IL_06c1: Unknown result type (might be due to invalid IL or missing references)
		//IL_06cb: Expected O, but got Unknown
		//IL_06dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_06e7: Expected O, but got Unknown
		//IL_06f9: Unknown result type (might be due to invalid IL or missing references)
		//IL_0703: Expected O, but got Unknown
		//IL_0715: Unknown result type (might be due to invalid IL or missing references)
		//IL_071f: Expected O, but got Unknown
		//IL_0731: Unknown result type (might be due to invalid IL or missing references)
		//IL_073b: Expected O, but got Unknown
		//IL_074d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0757: Expected O, but got Unknown
		//IL_0769: Unknown result type (might be due to invalid IL or missing references)
		//IL_0773: Expected O, but got Unknown
		//IL_0785: Unknown result type (might be due to invalid IL or missing references)
		//IL_078f: Expected O, but got Unknown
		//IL_07a1: Unknown result type (might be due to invalid IL or missing references)
		//IL_07ab: Expected O, but got Unknown
		//IL_07bd: Unknown result type (might be due to invalid IL or missing references)
		//IL_07c7: Expected O, but got Unknown
		//IL_07d9: Unknown result type (might be due to invalid IL or missing references)
		//IL_07e3: Expected O, but got Unknown
		//IL_07f5: Unknown result type (might be due to invalid IL or missing references)
		//IL_07ff: Expected O, but got Unknown
		//IL_0805: Unknown result type (might be due to invalid IL or missing references)
		//IL_080c: Expected O, but got Unknown
		//IL_082d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0837: Expected O, but got Unknown
		//IL_0849: Unknown result type (might be due to invalid IL or missing references)
		//IL_0853: Expected O, but got Unknown
		//IL_0865: Unknown result type (might be due to invalid IL or missing references)
		//IL_086f: Expected O, but got Unknown
		//IL_0875: Unknown result type (might be due to invalid IL or missing references)
		//IL_087c: Expected O, but got Unknown
		//IL_089d: Unknown result type (might be due to invalid IL or missing references)
		//IL_08a7: Expected O, but got Unknown
		//IL_08ad: Unknown result type (might be due to invalid IL or missing references)
		//IL_08b4: Expected O, but got Unknown
		//IL_08d5: Unknown result type (might be due to invalid IL or missing references)
		//IL_08df: Expected O, but got Unknown
		//IL_08e0: Unknown result type (might be due to invalid IL or missing references)
		//IL_08e7: Expected O, but got Unknown
		//IL_0908: Unknown result type (might be due to invalid IL or missing references)
		//IL_0912: Expected O, but got Unknown
		//IL_0913: Unknown result type (might be due to invalid IL or missing references)
		//IL_091a: Expected O, but got Unknown
		//IL_093b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0945: Expected O, but got Unknown
		//IL_0946: Unknown result type (might be due to invalid IL or missing references)
		//IL_094d: Expected O, but got Unknown
		//IL_096e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0978: Expected O, but got Unknown
		//IL_0979: Unknown result type (might be due to invalid IL or missing references)
		//IL_0980: Expected O, but got Unknown
		//IL_09a1: Unknown result type (might be due to invalid IL or missing references)
		//IL_09ab: Expected O, but got Unknown
		//IL_09b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_09b8: Expected O, but got Unknown
		//IL_09d9: Unknown result type (might be due to invalid IL or missing references)
		//IL_09e3: Expected O, but got Unknown
		//IL_09e9: Unknown result type (might be due to invalid IL or missing references)
		//IL_09f0: Expected O, but got Unknown
		//IL_0a11: Unknown result type (might be due to invalid IL or missing references)
		//IL_0a1b: Expected O, but got Unknown
		//IL_0a21: Unknown result type (might be due to invalid IL or missing references)
		//IL_0a28: Expected O, but got Unknown
		//IL_0a49: Unknown result type (might be due to invalid IL or missing references)
		//IL_0a53: Expected O, but got Unknown
		//IL_0a54: Unknown result type (might be due to invalid IL or missing references)
		//IL_0a5b: Expected O, but got Unknown
		//IL_0a7c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0a86: Expected O, but got Unknown
		//IL_0a8c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0a93: Expected O, but got Unknown
		//IL_0ab4: Unknown result type (might be due to invalid IL or missing references)
		//IL_0abe: Expected O, but got Unknown
		//IL_0ac1: Unknown result type (might be due to invalid IL or missing references)
		//IL_0ac8: Expected O, but got Unknown
		//IL_0ae9: Unknown result type (might be due to invalid IL or missing references)
		//IL_0af3: Expected O, but got Unknown
		//IL_0af6: Unknown result type (might be due to invalid IL or missing references)
		//IL_0afd: Expected O, but got Unknown
		//IL_0b1e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0b28: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val42 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val42, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val42, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(ChatDetailPage_Loaded));
			FrameworkElement val43 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SizeChangedEventHandler, EventRegistrationToken>(val43, (nint)__ldftn(FrameworkElement.add_SizeChanged)), new Action<EventRegistrationToken>(val43, (nint)__ldftn(FrameworkElement.remove_SizeChanged)), new SizeChangedEventHandler(ChatDetailPage_SizeChanged));
			break;
		}
		case 2:
		{
			ButtonBase val41 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val41, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val41, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Button_Click_2));
			break;
		}
		case 3:
		{
			ButtonBase val40 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val40, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val40, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(CheckBox_Click_1));
			break;
		}
		case 4:
		{
			FrameworkElement val39 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SizeChangedEventHandler, EventRegistrationToken>(val39, (nint)__ldftn(FrameworkElement.add_SizeChanged)), new Action<EventRegistrationToken>(val39, (nint)__ldftn(FrameworkElement.remove_SizeChanged)), new SizeChangedEventHandler(DummyGrid_SizeChanged_1));
			break;
		}
		case 5:
		{
			ButtonBase val38 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val38, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val38, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(CheckBox_Click_1));
			break;
		}
		case 6:
		{
			UIElement val33 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<HoldingEventHandler, EventRegistrationToken>(val33, (nint)__ldftn(UIElement.add_Holding)), new Action<EventRegistrationToken>(val33, (nint)__ldftn(UIElement.remove_Holding)), new HoldingEventHandler(ContentControl_Hold_1));
			UIElement val34 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<PointerEventHandler, EventRegistrationToken>(val34, (nint)__ldftn(UIElement.add_PointerMoved)), new Action<EventRegistrationToken>(val34, (nint)__ldftn(UIElement.remove_PointerMoved)), new PointerEventHandler(ChatBubble_PointerMoved_1));
			UIElement val35 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<PointerEventHandler, EventRegistrationToken>(val35, (nint)__ldftn(UIElement.add_PointerPressed)), new Action<EventRegistrationToken>(val35, (nint)__ldftn(UIElement.remove_PointerPressed)), new PointerEventHandler(ChatBubble_PointerPressed_1));
			UIElement val36 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<PointerEventHandler, EventRegistrationToken>(val36, (nint)__ldftn(UIElement.add_PointerReleased)), new Action<EventRegistrationToken>(val36, (nint)__ldftn(UIElement.remove_PointerReleased)), new PointerEventHandler(ChatBubble_PointerReleased_1));
			UIElement val37 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val37, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val37, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ContentControl_Tapped_1));
			break;
		}
		case 7:
		{
			UIElement val32 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val32, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val32, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Delete_Tapped_1));
			break;
		}
		case 8:
		{
			UIElement val31 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val31, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val31, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Error_Tapped));
			break;
		}
		case 9:
		{
			UIElement val30 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val30, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val30, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ReSend_Tapped_1));
			break;
		}
		case 10:
		{
			UIElement val29 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val29, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val29, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Delete_Tapped_1));
			break;
		}
		case 11:
		{
			UIElement val28 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val28, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val28, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ReSend_Tapped_1));
			break;
		}
		case 12:
		{
			UIElement val27 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val27, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val27, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Delete_Tapped_1));
			break;
		}
		case 13:
		{
			UIElement val26 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val26, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val26, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_1));
			break;
		}
		case 14:
		{
			UIElement val25 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val25, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val25, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_2));
			break;
		}
		case 15:
		{
			FrameworkElement val23 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val23, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val23, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(BuddyMessageProfile_Loaded));
			UIElement val24 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val24, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val24, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BuddyProfileImage_Tapped_1));
			break;
		}
		case 16:
		{
			FrameworkElement val22 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SizeChangedEventHandler, EventRegistrationToken>(val22, (nint)__ldftn(FrameworkElement.add_SizeChanged)), new Action<EventRegistrationToken>(val22, (nint)__ldftn(FrameworkElement.remove_SizeChanged)), new SizeChangedEventHandler(DummyGrid_SizeChanged_1));
			break;
		}
		case 17:
		{
			ButtonBase val21 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val21, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val21, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(CheckBox_Click_1));
			break;
		}
		case 18:
		{
			UIElement val16 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<HoldingEventHandler, EventRegistrationToken>(val16, (nint)__ldftn(UIElement.add_Holding)), new Action<EventRegistrationToken>(val16, (nint)__ldftn(UIElement.remove_Holding)), new HoldingEventHandler(ContentControl_Hold_1));
			UIElement val17 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<PointerEventHandler, EventRegistrationToken>(val17, (nint)__ldftn(UIElement.add_PointerMoved)), new Action<EventRegistrationToken>(val17, (nint)__ldftn(UIElement.remove_PointerMoved)), new PointerEventHandler(ChatBubble_PointerMoved_1));
			UIElement val18 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<PointerEventHandler, EventRegistrationToken>(val18, (nint)__ldftn(UIElement.add_PointerPressed)), new Action<EventRegistrationToken>(val18, (nint)__ldftn(UIElement.remove_PointerPressed)), new PointerEventHandler(ChatBubble_PointerPressed_1));
			UIElement val19 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<PointerEventHandler, EventRegistrationToken>(val19, (nint)__ldftn(UIElement.add_PointerReleased)), new Action<EventRegistrationToken>(val19, (nint)__ldftn(UIElement.remove_PointerReleased)), new PointerEventHandler(ChatBubble_PointerReleased_1));
			UIElement val20 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val20, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val20, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ContentControl_Tapped_1));
			break;
		}
		case 19:
		{
			ButtonBase val15 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val15, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val15, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(DateHeaderCheckBox_Click_1));
			break;
		}
		case 20:
			((ImageButton)target).Click += new RoutedEventHandler(InviteBuddiesSnapped_Click);
			break;
		case 21:
			((ImageButton)target).Click += new RoutedEventHandler(DeleteMessage_Click);
			break;
		case 22:
			((ImageButton)target).Click += new RoutedEventHandler(CancelDeleteMessage_Click);
			break;
		case 23:
			((ImageButton)target).Click += new RoutedEventHandler(CloseChat_Click);
			break;
		case 24:
			((ImageButton)target).Click += new RoutedEventHandler(DeleteAllMessage_Click);
			break;
		case 25:
			((ImageButton)target).Click += new RoutedEventHandler(ToggleDeleteMessage_Click);
			break;
		case 26:
			((ImageButton)target).Click += new RoutedEventHandler(InviteBuddies_Click);
			break;
		case 27:
			((ImageButton)target).Click += new RoutedEventHandler(ChatProfile_Click);
			break;
		case 28:
			((ImageButton)target).Click += new RoutedEventHandler(SelectAll_Click);
			break;
		case 29:
			((ImageButton)target).Click += new RoutedEventHandler(SelectReceived_Click);
			break;
		case 30:
			((ImageButton)target).Click += new RoutedEventHandler(SelectSent_Click);
			break;
		case 31:
		{
			UIElement val14 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val14, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val14, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(LayoutRoot_OnTapped));
			break;
		}
		case 32:
			((ImageButton)target).Click += new RoutedEventHandler(AttachButton_Click_1);
			break;
		case 33:
			((ImageButton)target).Click += new RoutedEventHandler(EmoticonButton_Click_1);
			break;
		case 34:
		{
			ButtonBase val13 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val13, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val13, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Button_Click_1));
			break;
		}
		case 35:
		{
			TextBox val8 = (TextBox)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ContextMenuOpeningEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(TextBox.add_ContextMenuOpening)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(TextBox.remove_ContextMenuOpening)), new ContextMenuOpeningEventHandler(InputBox_ContextMenuOpening));
			UIElement val9 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(UIElement.add_GotFocus)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(UIElement.remove_GotFocus)), new RoutedEventHandler(InputBox_GotFocus_1));
			UIElement val10 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<KeyEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(UIElement.add_KeyDown)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(UIElement.remove_KeyDown)), new KeyEventHandler(InputBox_KeyDown_1));
			UIElement val11 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val11, (nint)__ldftn(UIElement.add_LostFocus)), new Action<EventRegistrationToken>(val11, (nint)__ldftn(UIElement.remove_LostFocus)), new RoutedEventHandler(InputBox_LostFocus_1));
			TextBox val12 = (TextBox)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TextChangedEventHandler, EventRegistrationToken>(val12, (nint)__ldftn(TextBox.add_TextChanged)), new Action<EventRegistrationToken>(val12, (nint)__ldftn(TextBox.remove_TextChanged)), new TextChangedEventHandler(InputBox_TextChanged));
			break;
		}
		case 36:
		{
			UIElement val7 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(MessagePreviewTapped));
			break;
		}
		case 37:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(MessagePreviewTapped));
			break;
		}
		case 38:
		{
			FrameworkElement val4 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(MessageList_Loaded));
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(MessageList_Tapped_1));
			break;
		}
		case 39:
		{
			ButtonBase val3 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(AddBuddyBtn_Click));
			break;
		}
		case 40:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(BlockBuddyBtn_Click));
			break;
		}
		case 41:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Trunk_Tapped));
			break;
		}
		}
		_contentLoaded = true;
	}
}
