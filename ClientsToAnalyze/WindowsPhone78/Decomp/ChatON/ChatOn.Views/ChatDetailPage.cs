using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Navigation;
using System.Windows.Threading;
using ChatOn.Controls;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.ViewModels;
using com.sec.ssm.common;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class ChatDetailPage : PhoneApplicationPage
{
	public static readonly DependencyProperty ListVerticalOffsetProperty = DependencyProperty.Register("ListVerticalOffset", typeof(double), typeof(ChatDetailPage), new PropertyMetadata(OnListVerticalOffsetChanged));

	public static readonly DependencyProperty ListScrollableHeightProperty = DependencyProperty.Register("ListScrollableHeight", typeof(double), typeof(ChatDetailPage), new PropertyMetadata(OnListScrollableHeightChanged));

	public static readonly DependencyProperty TranslateYProperty = DependencyProperty.Register("TranslateY", typeof(double), typeof(ChatDetailPage), new PropertyMetadata(0.0, OnRenderYPropertyChanged));

	private ChatDetailPageViewModel _viewModel;

	private bool _isNew = true;

	private long _lastAddedTick;

	private bool _isFirstOffsetChanged = true;

	private Panel _listPanel;

	private bool _isFocused;

	internal Grid LayoutRoot;

	internal Grid MainGrid;

	internal Image BG;

	internal TextBlock TitleTextBlock;

	internal ListBox MessageList;

	internal EmoticonChooser EmoticonPanel;

	internal ScrollViewer InputScroll;

	internal TextBox InputBox;

	private bool _contentLoaded;

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

	public double ListScrollableHeight
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(ListScrollableHeightProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(ListScrollableHeightProperty, (object)value);
		}
	}

	public double TranslateY
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(TranslateYProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(TranslateYProperty, (object)value);
		}
	}

	public Panel ListPanel
	{
		get
		{
			return _listPanel;
		}
		set
		{
			_listPanel = value;
		}
	}

	private static void OnRenderYPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		//IL_00ad: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b4: Invalid comparison between Unknown and I4
		//IL_0070: Unknown result type (might be due to invalid IL or missing references)
		//IL_0077: Invalid comparison between Unknown and I4
		//IL_00b7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00be: Invalid comparison between Unknown and I4
		//IL_007a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0081: Invalid comparison between Unknown and I4
		Thickness margin = new Thickness(5.0, 0.0 - (double)e.NewValue - 72.0, 5.0, 0.0);
		if (margin.Top < 0.0)
		{
			margin.Top = 0.0;
		}
		ChatDetailPage chatDetailPage = (ChatDetailPage)(object)d;
		if (chatDetailPage.EmoticonPanel.Visibility == Visibility.Visible && ((int)((PhoneApplicationPage)chatDetailPage).Orientation == 18 || (int)((PhoneApplicationPage)chatDetailPage).Orientation == 34))
		{
			margin.Top = 0.0;
		}
		chatDetailPage.MessageList.Margin = margin;
		double num = (double)e.NewValue;
		if ((int)((PhoneApplicationPage)chatDetailPage).Orientation == 18 || (int)((PhoneApplicationPage)chatDetailPage).Orientation == 34)
		{
			chatDetailPage.MainGrid.Margin = new Thickness(0.0, 0.0, 0.0, 0.0);
		}
		else if (num >= -30.0)
		{
			chatDetailPage.MainGrid.Margin = new Thickness(0.0, 0.0, 0.0, 0.0);
		}
		else
		{
			chatDetailPage.MainGrid.Margin = new Thickness(0.0, 0.0, 0.0, -50.0);
		}
	}

	private static void OnListVerticalOffsetChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		ChatDetailPage page = obj as ChatDetailPage;
		if (page._isFirstOffsetChanged)
		{
			page._isFirstOffsetChanged = false;
			return;
		}
		ScrollViewer scrollViewer = (ScrollViewer)(VisualTreeHelper.GetChild(page.MessageList, 0) as FrameworkElement).FindName("ScrollViewer");
		if (scrollViewer.VerticalOffset <= 2.0)
		{
			if (TimeSpan.FromTicks(DateTime.UtcNow.Ticks - page._lastAddedTick).TotalMilliseconds > 1000.0)
			{
				page._lastAddedTick = DateTime.UtcNow.Ticks;
				((DependencyObject)(object)page).Dispatcher.BeginInvoke(delegate
				{
					page._viewModel.LoadRemainListItems(isPrev: true);
				});
			}
		}
		else if (scrollViewer.VerticalOffset >= scrollViewer.ScrollableHeight - 2.0 && TimeSpan.FromTicks(DateTime.UtcNow.Ticks - page._lastAddedTick).TotalMilliseconds > 1000.0)
		{
			page._lastAddedTick = DateTime.UtcNow.Ticks;
			((DependencyObject)(object)page).Dispatcher.BeginInvoke(delegate
			{
				page._viewModel.LoadRemainListItems(isPrev: false);
			});
		}
	}

	private static void OnListScrollableHeightChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		ChatDetailPage chatDetailPage = obj as ChatDetailPage;
		_ = (ScrollViewer)(VisualTreeHelper.GetChild(chatDetailPage.MessageList, 0) as FrameworkElement).FindName("ScrollViewer");
		chatDetailPage._viewModel.ScrollToCurrentView((double)e.OldValue, (double)e.NewValue);
	}

	public ChatDetailPage()
	{
		InitializeComponent();
		_viewModel = new ChatDetailPageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
		MessageList.Loaded += MessageList_Loaded;
		((FrameworkElement)this).Loaded += ChatDetailPage_Loaded;
		((PhoneApplicationPage)this).OrientationChanged += ChatDetailPage_OrientationChanged;
		AddChatApplicationBarButtons();
		ChatOnService.Instance.ChatDetailPage = this;
		ShowEnterMessage();
	}

	private void ChatDetailPage_OrientationChanged(object sender, OrientationChangedEventArgs e)
	{
		_viewModel.UpdateBackgroundImage();
		UpdateEmoticonPanelSize();
		LightContextMenu.HandleMenuBackKey();
	}

	private void UpdateEmoticonPanelSize()
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0008: Invalid comparison between Unknown and I4
		//IL_000b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0012: Invalid comparison between Unknown and I4
		if ((int)((PhoneApplicationPage)this).Orientation == 18 || (int)((PhoneApplicationPage)this).Orientation == 34)
		{
			EmoticonPanel.Height = 130.0;
		}
		else
		{
			EmoticonPanel.Height = 130.0;
		}
	}

	private void ChatDetailPage_Loaded(object sender, RoutedEventArgs e)
	{
		((DependencyObject)this).Dispatcher.BeginInvoke(delegate
		{
			UIElement rootVisual = Application.Current.RootVisual;
			PhoneApplicationFrame val = (PhoneApplicationFrame)(object)((rootVisual is PhoneApplicationFrame) ? rootVisual : null);
			if (val != null)
			{
				TransformGroup transformGroup = (TransformGroup)((UIElement)(object)val).RenderTransform;
				if (transformGroup != null)
				{
					TranslateTransform source = (TranslateTransform)transformGroup.Children[0];
					Binding binding = new Binding("Y")
					{
						Source = source
					};
					((FrameworkElement)this).SetBinding(TranslateYProperty, binding);
				}
			}
			LoadingIndicator.StopLoading();
		});
		UpdateEmoticonPanelSize();
	}

	private void MessageList_Loaded(object sender, RoutedEventArgs e)
	{
		ScrollViewer source = (ScrollViewer)(VisualTreeHelper.GetChild(MessageList, 0) as FrameworkElement).FindName("ScrollViewer");
		((FrameworkElement)this).SetBinding(ListVerticalOffsetProperty, new Binding
		{
			Source = source,
			Path = new PropertyPath("VerticalOffset"),
			Mode = BindingMode.OneWay
		});
		((FrameworkElement)this).SetBinding(ListScrollableHeightProperty, new Binding
		{
			Source = source,
			Path = new PropertyPath("ScrollableHeight"),
			Mode = BindingMode.OneWay
		});
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			while (((Page)this).NavigationService.BackStack.Count() > 0)
			{
				string originalString = ((Page)this).NavigationService.BackStack.First().Source.OriginalString;
				if (originalString.Contains("PivotPage.xaml") || originalString.Contains("MainPage.xaml"))
				{
					break;
				}
				((Page)this).NavigationService.RemoveBackEntry();
			}
			_isNew = false;
			IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
			if (!queryString.ContainsKey("ID"))
			{
				throw new NotImplementedException();
			}
			Guid id = Guid.Parse(queryString["ID"]);
			_viewModel.OpenChatDetail(id);
			_viewModel.OnNavigatedTo(isFirst: true);
		}
		else
		{
			_viewModel.OnNavigatedTo(isFirst: false);
		}
		((Page)this).OnNavigatedTo(e);
	}

	protected override void OnNavigatingFrom(NavigatingCancelEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (e.NavigationMode == NavigationMode.Back)
		{
			_viewModel.OnClose();
			JournalEntry val = ((Page)this).NavigationService.BackStack.FirstOrDefault((JournalEntry c) => c.Source.OriginalString.Contains("PivotPage.xaml"));
			if (val == null)
			{
				PageNavigationService.OpenPivotPage((PhoneApplicationPage)(object)this);
				e.Cancel = true;
			}
			((Page)this).OnNavigatingFrom(e);
		}
	}

	protected override void OnBackKeyPress(CancelEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (LightContextMenu.HandleMenuBackKey())
		{
			e.Cancel = true;
		}
		if (LoadingIndicator.HandleBackKey())
		{
			e.Cancel = true;
		}
		((PhoneApplicationPage)this).OnBackKeyPress(e);
	}

	private void SendBarIcon_Click(object sender, EventArgs e)
	{
		if (string.IsNullOrEmpty(InputBox.Text) || (InputBox.Foreground as SolidColorBrush).Color == Colors.Gray)
		{
			return;
		}
		if (InputBox.Text.Length > ChatService.MAX_TEXT_LENGTH)
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_MAXIMUM_CHARACTER_LIMIT_EXCEEDED);
			return;
		}
		_viewModel.EmoticonChooserVisibility = Visibility.Collapsed;
		_viewModel.SendMessage();
		bool isFocused = _isFocused;
		((Control)this).Focus();
		InputBox.Text = "";
		if (isFocused)
		{
			InputBox.Focus();
		}
		else
		{
			ShowEnterMessage();
		}
	}

	private void ShowEnterMessage()
	{
		InputBox.Text = ResContainer.IDS_CHATON_BODY_ENTER_MESSAGE;
		InputBox.Foreground = new SolidColorBrush(Colors.Gray);
	}

	private void AttachBarIcon_Click(object sender, EventArgs e)
	{
		_viewModel.EmoticonChooserVisibility = Visibility.Collapsed;
		_viewModel.AttachFile();
	}

	private void CloseChatBarMenuItem_Click(object sender, EventArgs e)
	{
		if (MessageBoxResult.OK == MessageBox.Show(ResContainer.IDS_CHATON_POP_CHAT_AND_TRUNK_WILL_BE_DELETED, ResContainer.IDS_CHATON_SK2_CLOSE_CHAT, MessageBoxButton.OKCancel))
		{
			InputBox.IsEnabled = false;
			InputBox.IsEnabled = true;
			_viewModel.CloseChat();
		}
	}

	private void StackPanel_Loaded(object sender, RoutedEventArgs e)
	{
		_listPanel = sender as Panel;
	}

	private void InviteBarIconButton_Click(object sender, EventArgs e)
	{
		_viewModel.EmoticonChooserVisibility = Visibility.Collapsed;
		_viewModel.InviteBuddies();
	}

	private void EmoticonBarIconButton_Click(object sender, EventArgs e)
	{
		if (_viewModel.EmoticonChooserVisibility == Visibility.Collapsed)
		{
			_viewModel.EmoticonChooserVisibility = Visibility.Visible;
			EmoticonPanel.LoadEmoticons();
		}
		else
		{
			_viewModel.EmoticonChooserVisibility = Visibility.Collapsed;
		}
	}

	private void Message_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		Message msg = (sender as FrameworkElement).DataContext as Message;
		_viewModel.OnClickMessage(msg);
	}

	private void CancelButton_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		Message msg = (sender as FrameworkElement).DataContext as Message;
		_viewModel.OnCancelMessage(msg);
	}

	private void CancelSendButton_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		Message msg = (sender as FrameworkElement).DataContext as Message;
		_viewModel.OnCancelUploadFile(msg);
	}

	private void EmoticonChooser_Completed(object sender, object e)
	{
		if ((InputBox.Foreground as SolidColorBrush).Color == Colors.Gray)
		{
			InputBox.Text = "";
			InputBox.Foreground = new SolidColorBrush(Colors.Black);
		}
		long ticks = DateTime.UtcNow.Ticks;
		string text = e as string;
		int selectionStart = InputBox.SelectionStart;
		int selectionLength = InputBox.SelectionLength;
		string text2 = InputBox.Text;
		if (selectionLength > 0)
		{
			text2 = text2.Remove(selectionStart, selectionLength);
		}
		text2 = text2.Insert(selectionStart, text);
		InputBox.Text = text2;
		InputBox.SelectionStart = selectionStart + text.Length;
		InputBox.SelectionLength = 0;
		long ticks2 = DateTime.UtcNow.Ticks;
		TimeSpan.FromTicks(ticks2 - ticks);
	}

	private void EmoticonChooser_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
	}

	private void ProfileImage_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		Message message = (sender as FrameworkElement).DataContext as Message;
		_viewModel.OpenBuddyProfile(message.Sender);
	}

	private void Message_Hold(object sender, System.Windows.Input.GestureEventArgs e)
	{
		_viewModel.OpenMessageItemContextMenu(sender as FrameworkElement);
	}

	private void ChatTitle_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		_viewModel.OpenChatProfilePage();
	}

	private void Delete_Click(object sender, EventArgs e)
	{
		_viewModel.EmoticonChooserVisibility = Visibility.Collapsed;
		_viewModel.ToggleDeletionMode();
	}

	internal void AddChatApplicationBarButtons()
	{
		//IL_001b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0021: Expected O, but got Unknown
		//IL_006c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0072: Expected O, but got Unknown
		//IL_00bd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c3: Expected O, but got Unknown
		//IL_010e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0114: Expected O, but got Unknown
		//IL_0169: Unknown result type (might be due to invalid IL or missing references)
		//IL_016f: Expected O, but got Unknown
		//IL_01a9: Unknown result type (might be due to invalid IL or missing references)
		//IL_01af: Expected O, but got Unknown
		((PhoneApplicationPage)this).ApplicationBar.Buttons.Clear();
		ApplicationBarIconButton val = new ApplicationBarIconButton(new Uri("/icons/appbtn_add buddy.png", UriKind.Relative));
		val.Text = ResContainer.IDS_CHATON_SK2_INVITE;
		val.Click += InviteBarIconButton_Click;
		val.IsEnabled = _viewModel.IsConnected;
		((PhoneApplicationPage)this).ApplicationBar.Buttons.Add(val);
		val = new ApplicationBarIconButton(new Uri("/icons/appbtn_attach.png", UriKind.Relative));
		val.Text = ResContainer.IDS_CHATON_HEADER_ATTACH_ABB;
		val.Click += AttachBarIcon_Click;
		val.IsEnabled = _viewModel.IsConnected;
		((PhoneApplicationPage)this).ApplicationBar.Buttons.Add(val);
		val = new ApplicationBarIconButton(new Uri("/icons/appbtn_emoticon.png", UriKind.Relative));
		val.Text = ResContainer.IDS_CHATON_SK3_EMOTICON;
		val.Click += EmoticonBarIconButton_Click;
		val.IsEnabled = _viewModel.IsConnected;
		((PhoneApplicationPage)this).ApplicationBar.Buttons.Add(val);
		val = new ApplicationBarIconButton(new Uri("/icons/appbtn_send.png", UriKind.Relative));
		val.Text = ResContainer.IDS_CHATON_BUTTON_SEND;
		val.Click += SendBarIcon_Click;
		val.IsEnabled = _viewModel.IsConnected;
		((PhoneApplicationPage)this).ApplicationBar.Buttons.Add(val);
		((PhoneApplicationPage)this).ApplicationBar.MenuItems.Clear();
		ApplicationBarMenuItem val2 = new ApplicationBarMenuItem(ResContainer.IDS_CHATON_OPT1_CLOSE_CHAT);
		val2.Click += CloseChatBarMenuItem_Click;
		val2.IsEnabled = _viewModel.IsConnected;
		((PhoneApplicationPage)this).ApplicationBar.MenuItems.Add(val2);
		val2 = new ApplicationBarMenuItem(ResContainer.IDS_CHATON_OPT_DELETE_ABB);
		val2.Click += Delete_Click;
		((PhoneApplicationPage)this).ApplicationBar.MenuItems.Add(val2);
	}

	internal void AddDeleteApplicationBarButtons()
	{
		//IL_002b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		//IL_0072: Unknown result type (might be due to invalid IL or missing references)
		//IL_0078: Expected O, but got Unknown
		((PhoneApplicationPage)this).ApplicationBar.Buttons.Clear();
		((PhoneApplicationPage)this).ApplicationBar.MenuItems.Clear();
		ApplicationBarIconButton val = new ApplicationBarIconButton(new Uri("/Images/appbtn_done.png", UriKind.Relative));
		val.Text = ResContainer.IDS_CHATON_BUTTON_DONE;
		val.Click += DoneButton_Click;
		val.IsEnabled = false;
		((PhoneApplicationPage)this).ApplicationBar.Buttons.Add(val);
		val = new ApplicationBarIconButton(new Uri("/Images/appbtn_cancel.png", UriKind.Relative));
		val.Text = ResContainer.IDS_CHATON_BUTTON_CANCEL;
		val.Click += CancelButton_Click;
		((PhoneApplicationPage)this).ApplicationBar.Buttons.Add(val);
	}

	internal void EnableDoneButton(bool isEnable)
	{
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).IsEnabled = isEnable;
	}

	private void DoneButton_Click(object sender, EventArgs e)
	{
		if (MessageBoxResult.OK == MessageBox.Show(ResContainer.IDS_CHATON_POP_DELETE_Q, ResContainer.IDS_CHATON_BODY_DELETE_MESSAGE, MessageBoxButton.OKCancel))
		{
			_viewModel.DeleteSelectedMessages();
		}
	}

	private void CancelButton_Click(object sender, EventArgs e)
	{
		_viewModel.ToggleDeletionMode();
	}

	private void SelectAll_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.SelectAllMessages();
	}

	private void Received_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.SelectReceivedMessages();
	}

	private void Sent_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.SelectSentMessages();
	}

	private void DateHeaderCheckBox_Click(object sender, RoutedEventArgs e)
	{
		Message msg = (sender as FrameworkElement).DataContext as Message;
		_viewModel.OnClickDateHeaderCheckBox(msg);
	}

	private void CheckBox_Click(object sender, RoutedEventArgs e)
	{
		Message clickedMessage = (sender as FrameworkElement).DataContext as Message;
		_viewModel.OnClickCheckBox(clickedMessage);
	}

	private void DeleteMessage_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		((Control)this).Focus();
		Message msg = (sender as FrameworkElement).DataContext as Message;
		_viewModel.DeleteMessage(msg);
	}

	private void ReSend_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		Message msg = (sender as FrameworkElement).DataContext as Message;
		_viewModel.ReSendMessage(msg);
	}

	internal void OnToastNotification(string senderID, string sessionID, ChatType msgChatType)
	{
		_viewModel.OnPushReceived(senderID, sessionID, msgChatType);
	}

	private void Trunk_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		_viewModel.MoveToTrunk();
	}

	private void InputBox_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		Rect rectFromCharacterIndex = InputBox.GetRectFromCharacterIndex(InputBox.SelectionStart);
		double verticalOffset = InputScroll.VerticalOffset;
		double num = Math.Abs(rectFromCharacterIndex.Top - verticalOffset);
		if (num > InputScroll.ViewportHeight - InputBox.BaselineOffset)
		{
			num = InputScroll.ViewportHeight - InputBox.BaselineOffset;
		}
		double offset = rectFromCharacterIndex.Top - num;
		InputScroll.ScrollToVerticalOffset(offset);
	}

	private void DummyGrid_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		(sender as FrameworkElement).Tag = e.NewSize.Width;
	}

	private void timer_Tick(object sender, EventArgs e)
	{
		(sender as DispatcherTimer).Stop();
		MessageList.UpdateLayout();
	}

	private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
	{
		string text = (sender as TextBox).Text;
		_viewModel.InputTextMsg = text;
	}

	private void InputBox_GotFocus(object sender, RoutedEventArgs e)
	{
		if ((InputBox.Foreground as SolidColorBrush).Color == Colors.Gray)
		{
			InputBox.Text = "";
			InputBox.Foreground = new SolidColorBrush(Colors.Black);
		}
		_viewModel.ScrollToRecentMessage();
		DispatcherTimer dispatcherTimer = new DispatcherTimer();
		dispatcherTimer.Interval = TimeSpan.FromMilliseconds(500.0);
		dispatcherTimer.Tick += timer_Tick;
		dispatcherTimer.Start();
		_isFocused = true;
	}

	private void InputBox_LostFocus(object sender, RoutedEventArgs e)
	{
		_isFocused = false;
		if (string.IsNullOrEmpty(InputBox.Text))
		{
			ShowEnterMessage();
		}
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/ChatDetailPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			MainGrid = (Grid)((FrameworkElement)this).FindName("MainGrid");
			BG = (Image)((FrameworkElement)this).FindName("BG");
			TitleTextBlock = (TextBlock)((FrameworkElement)this).FindName("TitleTextBlock");
			MessageList = (ListBox)((FrameworkElement)this).FindName("MessageList");
			EmoticonPanel = (EmoticonChooser)((FrameworkElement)this).FindName("EmoticonPanel");
			InputScroll = (ScrollViewer)((FrameworkElement)this).FindName("InputScroll");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
		}
	}
}
