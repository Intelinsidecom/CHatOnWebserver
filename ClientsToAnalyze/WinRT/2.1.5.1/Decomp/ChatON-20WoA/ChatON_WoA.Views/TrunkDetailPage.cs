using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.Foundation;
using Windows.UI;
using Windows.UI.Core;
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

public sealed class TrunkDetailPage : Page, IComponentConnector
{
	private bool lockToBottom = true;

	private TrunkItemPageViewModel _viewModel;

	private bool _sendEnterKey;

	private Point Position;

	public static readonly DependencyProperty ListVerticalOffsetProperty = DependencyProperty.Register("ListVerticalOffset", typeof(double), typeof(TrunkDetailPage), new PropertyMetadata((object)null, new PropertyChangedCallback(OnListVerticalOffsetChanged)));

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LeftCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton DeleteButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton ShareButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton SaveButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView CommentList;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox InputBox;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button DoneButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image VideoIcon;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public bool LockToBottom
	{
		get
		{
			return lockToBottom;
		}
		set
		{
			lockToBottom = value;
		}
	}

	private static void OnListVerticalOffsetChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		//IL_0088: Unknown result type (might be due to invalid IL or missing references)
		//IL_008e: Expected O, but got Unknown
		if (!(obj is TrunkDetailPage))
		{
			return;
		}
		DispatchedHandler val = null;
		TrunkDetailPage page = obj as TrunkDetailPage;
		ScrollViewer messageScrollViewer = page.GetMessageScrollViewer();
		double num = (double)e.NewValue;
		if (messageScrollViewer != null && num == 0.0)
		{
			messageScrollViewer.ScrollToVerticalOffset((double)e.OldValue);
			num = (double)e.OldValue;
		}
		if (messageScrollViewer == null || !(num <= 2.0))
		{
			return;
		}
		CoreDispatcher dispatcher = ((DependencyObject)page).Dispatcher;
		if (val == null)
		{
			val = (DispatchedHandler)delegate
			{
				page._viewModel.LoadMoreComment();
			};
		}
		dispatcher.RunAsync((CoreDispatcherPriority)0, val);
	}

	internal ScrollViewer GetMessageScrollViewer()
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Expected O, but got Unknown
		DependencyObject child = VisualTreeHelper.GetChild((DependencyObject)(object)CommentList, 0);
		FrameworkElement val = (FrameworkElement)(object)((child is FrameworkElement) ? child : null);
		if (val != null)
		{
			return (ScrollViewer)val.FindName("ScrollViewer");
		}
		return null;
	}

	public unsafe TrunkDetailPage()
	{
		//IL_008b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0095: Expected O, but got Unknown
		InitializeComponent();
		_viewModel = new TrunkItemPageViewModel(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		DeleteButton.Text = Utility.GetResourceString("IDS_CHATON_OPT_DELETE");
		SaveButton.Text = Utility.GetResourceString("IDS_CHATON_HEADER_SAVE");
		ShareButton.Text = Utility.GetResourceString("IDS_CHATON_BODY_SHARE");
		WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(TrunkDetailPage_Loaded));
	}

	private void TrunkDetailPage_ManipulationCompleted(object sender, ManipulationCompletedRoutedEventArgs e)
	{
		double num = Position.X - e.Position.X;
		if (num > 200.0)
		{
			_viewModel.NextTrunkItem();
		}
		if (num < -200.0)
		{
			_viewModel.PrevTrunkItem();
		}
	}

	private void TrunkDetailPage_ManipulationStarted(object sender, ManipulationStartedRoutedEventArgs e)
	{
		Position = e.Position;
	}

	private void TrunkDetailPage_Loaded(object sender, RoutedEventArgs e)
	{
		GetMessageScrollViewer();
	}

	private void CommentList_Loaded_1(object sender, RoutedEventArgs e)
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Expected O, but got Unknown
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0032: Expected O, but got Unknown
		//IL_003f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0049: Expected O, but got Unknown
		DependencyObject child = VisualTreeHelper.GetChild((DependencyObject)(object)CommentList, 0);
		FrameworkElement val = (FrameworkElement)(object)((child is FrameworkElement) ? child : null);
		if (val != null)
		{
			ScrollViewer val2 = (ScrollViewer)val.FindName("ScrollViewer");
			DependencyProperty listVerticalOffsetProperty = ListVerticalOffsetProperty;
			Binding val3 = new Binding();
			val3.put_Source((object)val2);
			val3.put_Path(new PropertyPath("VerticalOffset"));
			val3.put_Mode((BindingMode)3);
			((FrameworkElement)this).SetBinding(listVerticalOffsetProperty, (BindingBase)(object)val3);
		}
	}

	public void ScrollToBottom(bool isToBottom = false)
	{
		if (isToBottom)
		{
			int num = ((ICollection<object>)((ItemsControl)CommentList).Items).Count - 1;
			if (num >= 0)
			{
				((Selector)CommentList).put_SelectedIndex(num);
				((UIElement)CommentList).UpdateLayout();
				((ListViewBase)CommentList).ScrollIntoView(((Selector)CommentList).SelectedItem);
			}
		}
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_000f: Invalid comparison between Unknown and I4
		//IL_0077: Unknown result type (might be due to invalid IL or missing references)
		//IL_007d: Invalid comparison between Unknown and I4
		_ = e.NavigationMode;
		TrunkItemParameter trunkItemParameter = null;
		if ((int)ApplicationView.Value != 2)
		{
			if (ChatDetailPage.ActiveInstance != null)
			{
				ChatDetailPage.ActiveInstance.Disconnect(IsNullChat: false);
			}
		}
		else if (ChatDetailPage.SnappedActiveInstance != null)
		{
			ChatDetailPage.SnappedActiveInstance.Disconnect(IsNullChat: false);
		}
		if (e.Parameter is TrunkItemParameter trunkItemParameter2)
		{
			if (trunkItemParameter2 != null && trunkItemParameter2.TempFile != null)
			{
				_viewModel.OpenTrunkItemDetail(trunkItemParameter2.Chat, null, trunkItemParameter2.TempFile, trunkItemParameter2.Msg, trunkItemParameter2.MediaType);
			}
			else if ((int)e.NavigationMode == 1)
			{
				_viewModel.OpenLastTrunkDetail(trunkItemParameter2.Chat, trunkItemParameter2.Item);
			}
			else
			{
				_viewModel.OpenTrunkItemDetail(trunkItemParameter2.Chat, trunkItemParameter2.Item);
			}
		}
	}

	public unsafe void SwitchAppBar(bool isOpen)
	{
		((Control)appBar).put_IsEnabled(isOpen);
		if (isOpen)
		{
			((UIElement)appBar).put_Visibility((Visibility)0);
			return;
		}
		AppBar val = appBar;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val, (nint)__ldftn(AppBar.add_Opened)), new Action<EventRegistrationToken>(val, (nint)__ldftn(AppBar.remove_Opened)), delegate
		{
			appBar.put_IsOpen(false);
		});
		((UIElement)appBar).put_Visibility((Visibility)1);
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		//IL_002a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0030: Invalid comparison between Unknown and I4
		if (ChatDetailPage.ActiveInstance != null && ChatDetailPage.ActiveInstance.ViewModel.Chat != null && !ChatDetailPage.ActiveInstance.ViewModel.IsConnected && (int)e.NavigationMode == 1 && (object)e.SourcePageType != typeof(TrunkPage))
		{
			ChatDetailPage.ActiveInstance.ViewModel.ReConnect();
		}
		((Page)this).OnNavigatedFrom(e);
		_viewModel.OnNavigatedFrom();
	}

	private void InputBox_GotFocus_1(object sender, RoutedEventArgs e)
	{
		//IL_004b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0055: Expected O, but got Unknown
		Brush foreground = ((Control)InputBox).Foreground;
		if (((SolidColorBrush)((foreground is SolidColorBrush) ? foreground : null)).Color == Colors.Gray)
		{
			InputBox.put_Text("");
			((Control)InputBox).put_Foreground((Brush)((IDictionary<object, object>)Application.Current.Resources)[(object)"TextBoxForegroundThemeBrush"]);
		}
	}

	private void InputBox_LostFocus_1(object sender, RoutedEventArgs e)
	{
		//IL_0032: Unknown result type (might be due to invalid IL or missing references)
		//IL_003c: Expected O, but got Unknown
		if (string.IsNullOrEmpty(InputBox.Text))
		{
			InputBox.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_ENTER_MESSAGE"));
			((Control)InputBox).put_Foreground((Brush)new SolidColorBrush(Colors.Gray));
		}
	}

	private void DoneButton_Click_1(object sender, RoutedEventArgs e)
	{
		OnSendMessage();
	}

	private void OnSendMessage()
	{
		//IL_00a9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b3: Expected O, but got Unknown
		string text = InputBox.Text;
		if (string.IsNullOrEmpty(text))
		{
			return;
		}
		bool flag = true;
		string text2 = text;
		foreach (char c in text2)
		{
			if (c != '\r' && c != '\n')
			{
				flag = false;
				break;
			}
		}
		if (flag || ((SolidColorBrush)/*isinst with value type is only supported in some contexts*/).Color == Colors.Gray)
		{
			return;
		}
		if (!string.IsNullOrEmpty(text))
		{
			if (Utility.IsEmojiIconIncluded(text))
			{
				Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("WP7_FST_EMOJI_NOT_SUPPORTED"), showCancel: false);
				return;
			}
			_viewModel.UploadComment(text);
		}
		((Control)InputBox).put_Foreground((Brush)new SolidColorBrush(Colors.Gray));
		((Control)InputBox).Focus((FocusState)2);
		_viewModel.IsUpdateNewCommentList = true;
	}

	private async void Delete_Click(object sender, RoutedEventArgs e)
	{
		if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_DELETE_Q")))
		{
			_viewModel.DeleteItem();
		}
	}

	public void ShowLoading()
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
	}

	private async void Comment_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (!(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is TrunkComment))
		{
			return;
		}
		TrunkComment trunkComment;
		TrunkComment comment = (trunkComment = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as TrunkComment);
		if (trunkComment == null || comment.WriterId != "ME")
		{
			return;
		}
		PopupMenu menu = new PopupMenu();
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BUTTON2_DELETE"), (UICommandInvokedHandler)null, (object)1));
		try
		{
			IUICommand chosenCommand = await menu.ShowForSelectionAsync(Utility.GetElementRect((FrameworkElement)sender));
			if (chosenCommand != null)
			{
				int num = (int)chosenCommand.Id;
				if (num == 1)
				{
					_viewModel.DeleteTrunkComment(comment.Cid);
				}
			}
		}
		catch (Exception)
		{
		}
	}

	private void More_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		_viewModel.LoadMoreComment();
	}

	private void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		_viewModel.OpenFile();
	}

	private void backButton_Click_1(object sender, RoutedEventArgs e)
	{
		Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
	}

	private void ShareButton_Click_1(object sender, RoutedEventArgs e)
	{
		((Control)DoneButton).Focus((FocusState)1);
		try
		{
			_viewModel.ShareTrunkItem();
		}
		catch (Exception)
		{
		}
	}

	private void SaveButton_Click_1(object sender, RoutedEventArgs e)
	{
		_viewModel.SaveTrunkItem();
	}

	public void ShowSplashPopup(string text, bool warning)
	{
		Utility.ShowSimpleToastNotification(text);
	}

	private void Image_Loaded_1(object sender, RoutedEventArgs e)
	{
		//IL_00d3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00da: Expected O, but got Unknown
		//IL_00e9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f3: Expected O, but got Unknown
		FrameworkElement val = (FrameworkElement)((sender is FrameworkElement) ? sender : null);
		if (val.Tag != null && (bool)val.Tag)
		{
			return;
		}
		TrunkComment comment = null;
		if ((comment = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as TrunkComment) == null)
		{
			return;
		}
		if (comment.WriterId == RegistrationService.GetUserNumber() || comment.WriterId == "ME")
		{
			((Image)((sender is Image) ? sender : null)).put_Source((ImageSource)(object)ChatOnService.Instance.UserProfile.ProfileImage);
		}
		else
		{
			DataService dataService = new DataService();
			Buddy buddy = dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == comment.WriterId);
			if (buddy != null)
			{
				object obj = ((sender is Image) ? sender : null);
				DependencyProperty sourceProperty = Image.SourceProperty;
				Binding val2 = new Binding();
				val2.put_Source((object)buddy);
				val2.put_Path(new PropertyPath("ProfileImage"));
				((FrameworkElement)obj).SetBinding(sourceProperty, (BindingBase)(object)val2);
			}
		}
		((FrameworkElement)((sender is FrameworkElement) ? sender : null)).put_Tag((object)true);
	}

	private void InputBox_KeyUp(object sender, KeyRoutedEventArgs e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0008: Invalid comparison between Unknown and I4
		//IL_008a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0094: Expected O, but got Unknown
		if ((int)e.Key == 13)
		{
			InputBox.put_Text(InputBox.Text.Replace("\r\n", ""));
			OnSendMessage();
			e.put_Handled(true);
			Brush foreground = ((Control)InputBox).Foreground;
			if (((SolidColorBrush)((foreground is SolidColorBrush) ? foreground : null)).Color == Colors.Gray)
			{
				InputBox.put_Text("");
				((Control)InputBox).put_Foreground((Brush)((IDictionary<object, object>)Application.Current.Resources)[(object)"TextBoxForegroundThemeBrush"]);
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
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
		//IL_00dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Expected O, but got Unknown
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Expected O, but got Unknown
		//IL_011f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0129: Expected O, but got Unknown
		//IL_0135: Unknown result type (might be due to invalid IL or missing references)
		//IL_013f: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///TrunDetailPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			LeftCommands = (StackPanel)((FrameworkElement)this).FindName("LeftCommands");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			DeleteButton = (ImageButton)((FrameworkElement)this).FindName("DeleteButton");
			ShareButton = (ImageButton)((FrameworkElement)this).FindName("ShareButton");
			SaveButton = (ImageButton)((FrameworkElement)this).FindName("SaveButton");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			CommentList = (ListView)((FrameworkElement)this).FindName("CommentList");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
			DoneButton = (Button)((FrameworkElement)this).FindName("DoneButton");
			VideoIcon = (Image)((FrameworkElement)this).FindName("VideoIcon");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_003c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0042: Expected O, but got Unknown
		//IL_0061: Unknown result type (might be due to invalid IL or missing references)
		//IL_006b: Expected O, but got Unknown
		//IL_0071: Unknown result type (might be due to invalid IL or missing references)
		//IL_0077: Expected O, but got Unknown
		//IL_0096: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a0: Expected O, but got Unknown
		//IL_00b2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bc: Expected O, but got Unknown
		//IL_00ce: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d8: Expected O, but got Unknown
		//IL_00ea: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f4: Expected O, but got Unknown
		//IL_00fa: Unknown result type (might be due to invalid IL or missing references)
		//IL_0100: Expected O, but got Unknown
		//IL_011f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0129: Expected O, but got Unknown
		//IL_012a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0131: Expected O, but got Unknown
		//IL_0152: Unknown result type (might be due to invalid IL or missing references)
		//IL_015c: Expected O, but got Unknown
		//IL_0162: Unknown result type (might be due to invalid IL or missing references)
		//IL_0169: Expected O, but got Unknown
		//IL_018a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0194: Expected O, but got Unknown
		//IL_019a: Unknown result type (might be due to invalid IL or missing references)
		//IL_01a1: Expected O, but got Unknown
		//IL_01c2: Unknown result type (might be due to invalid IL or missing references)
		//IL_01cc: Expected O, but got Unknown
		//IL_01d2: Unknown result type (might be due to invalid IL or missing references)
		//IL_01d9: Expected O, but got Unknown
		//IL_01fa: Unknown result type (might be due to invalid IL or missing references)
		//IL_0204: Expected O, but got Unknown
		//IL_0205: Unknown result type (might be due to invalid IL or missing references)
		//IL_020c: Expected O, but got Unknown
		//IL_022d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0237: Expected O, but got Unknown
		//IL_0238: Unknown result type (might be due to invalid IL or missing references)
		//IL_023f: Expected O, but got Unknown
		//IL_0260: Unknown result type (might be due to invalid IL or missing references)
		//IL_026a: Expected O, but got Unknown
		//IL_026d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0274: Expected O, but got Unknown
		//IL_0295: Unknown result type (might be due to invalid IL or missing references)
		//IL_029f: Expected O, but got Unknown
		//IL_02a2: Unknown result type (might be due to invalid IL or missing references)
		//IL_02a9: Expected O, but got Unknown
		//IL_02ca: Unknown result type (might be due to invalid IL or missing references)
		//IL_02d4: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val11 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val11, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val11, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(TrunkDetailPage_Loaded));
			break;
		}
		case 2:
		{
			UIElement val10 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Comment_Tapped_1));
			break;
		}
		case 3:
			((ImageButton)target).Click += new RoutedEventHandler(Delete_Click);
			break;
		case 4:
			((ImageButton)target).Click += new RoutedEventHandler(ShareButton_Click_1);
			break;
		case 5:
			((ImageButton)target).Click += new RoutedEventHandler(SaveButton_Click_1);
			break;
		case 6:
		{
			UIElement val8 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationStartedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(UIElement.add_ManipulationStarted)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(UIElement.remove_ManipulationStarted)), new ManipulationStartedEventHandler(TrunkDetailPage_ManipulationStarted));
			UIElement val9 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationCompletedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(UIElement.add_ManipulationCompleted)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(UIElement.remove_ManipulationCompleted)), new ManipulationCompletedEventHandler(TrunkDetailPage_ManipulationCompleted));
			break;
		}
		case 7:
		{
			UIElement val7 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 8:
		{
			FrameworkElement val6 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(CommentList_Loaded_1));
			break;
		}
		case 9:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_GotFocus)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_GotFocus)), new RoutedEventHandler(InputBox_GotFocus_1));
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_LostFocus)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_LostFocus)), new RoutedEventHandler(InputBox_LostFocus_1));
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<KeyEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_KeyUp)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_KeyUp)), new KeyEventHandler(InputBox_KeyUp));
			break;
		}
		case 10:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(DoneButton_Click_1));
			break;
		}
		case 11:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
