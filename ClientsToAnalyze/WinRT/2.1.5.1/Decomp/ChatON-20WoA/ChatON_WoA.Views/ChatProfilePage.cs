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
using com.sec.ssm.common;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media.Imaging;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class ChatProfilePage : Page, IComponentConnector
{
	private string oldGroupName;

	private ChatProfilePageViewModel _viewModel;

	private static ChatProfilePage _activeInstance;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LeftCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton CloseChatButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton InviteButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock BuddyCountControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ToggleSwitch ToggleAllertEnable;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button btnRename;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox ChatNameControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public ChatProfilePageViewModel ViewModel
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

	public static ChatProfilePage ActiveInstance => _activeInstance;

	public ChatProfilePage()
	{
		InitializeComponent();
		_activeInstance = this;
		_viewModel = new ChatProfilePageViewModel(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		CloseChatButton.Text = Utility.GetResourceString("IDS_CHATON_OPT_CLOSE_CHAT");
		InviteButton.Text = Utility.GetResourceString("IDS_CHATON_OPT_INVITE_BUDDY");
	}

	private void ChatProfilePage_Loaded(object sender, RoutedEventArgs e)
	{
		_viewModel.UpdateChatName();
		oldGroupName = ChatNameControl.Text;
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	protected unsafe override void OnNavigatedTo(NavigationEventArgs e)
	{
		Chat chat = e.Parameter as Chat;
		_viewModel.CheckAlert(chat);
		_viewModel.Update(chat);
		if (ChatDetailPage.ActiveInstance == null || chat != SocketService.Instance.Chat)
		{
			AppBar val = appBar;
			WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val, (nint)__ldftn(AppBar.add_Opened)), new Action<EventRegistrationToken>(val, (nint)__ldftn(AppBar.remove_Opened)), delegate
			{
				appBar.put_IsOpen(false);
			});
		}
		else if (ChatDetailPage.ActiveInstance.ViewModel.Chat == null)
		{
			ChatDetailPage.ActiveInstance.ViewModel.Chat = chat;
		}
	}

	public void SetBuddyCountText(string text)
	{
		BuddyCountControl.put_Text(text);
	}

	private async void ProfileImage_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (_viewModel.Chat.ChatType != ChatType.GROUP || string.IsNullOrEmpty(_viewModel.Chat.SessionID) || string.IsNullOrEmpty(_viewModel.Chat.FilePath))
		{
			_viewModel.SelectProfileImage();
		}
		else
		{
			_viewModel.SelectProfileImage();
		}
	}

	private void ChatNameControl_LostFocus_1(object sender, RoutedEventArgs e)
	{
		_viewModel.CheckAndSaveName(ChatNameControl.Text);
	}

	private void SaveGroup_Click_1(object sender, RoutedEventArgs e)
	{
		_viewModel.SaveAsGroup();
	}

	private void alertToogle_OnSwitch(object sender, RoutedEventArgs e)
	{
		_viewModel.UpdateAlert(ToggleAllertEnable.IsOn);
	}

	private void AddButton_Click_1(object sender, RoutedEventArgs e)
	{
		_viewModel.AddBuddy(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as ChatBuddy);
	}

	internal void OpenAddGroupDialog(AddGroupDialog dialog)
	{
		foreach (UIElement item in (IEnumerable<UIElement>)((Panel)LayoutRoot).Children)
		{
			if ((object)((object)item).GetType() == typeof(CustomPopup))
			{
				((ICollection<UIElement>)((Panel)LayoutRoot).Children).Remove(item);
				break;
			}
		}
		new CustomPopup((Page)(object)this, (Panel)(object)LayoutRoot, (FrameworkElement)(object)dialog);
	}

	private void CloseChat_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
		ChatDetailPage.ActiveInstance.ViewModel.CloseChat();
	}

	private void InviteBuddies_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
		ChatDetailPage.ActiveInstance.ViewModel.InviteBuddies();
	}

	internal void ShowLoading()
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
	}

	private void BuddyImage_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		ChatBuddy chatBuddy = null;
		if (((ICollection<UIElement>)((Panel)LayoutRoot).Children).Count > 0)
		{
			UIElement val = null;
			if ((val = ((IEnumerable<UIElement>)((Panel)LayoutRoot).Children).FirstOrDefault((UIElement x) => (object)((object)x).GetType() == typeof(CustomPopup))) != null)
			{
				CustomPopup customPopup = null;
				if (val is CustomPopup customPopup2)
				{
					customPopup2.Close();
				}
			}
		}
		if (!(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is ChatBuddy { Buddy: not null } chatBuddy2))
		{
			return;
		}
		if (!chatBuddy2.Buddy.IsBlocked)
		{
			BuddyProfileDialog buddyProfileDialog = new BuddyProfileDialog();
			buddyProfileDialog.BuddyInfo = chatBuddy2.Buddy;
			((FrameworkElement)buddyProfileDialog).put_HorizontalAlignment((HorizontalAlignment)1);
			((FrameworkElement)buddyProfileDialog).put_VerticalAlignment((VerticalAlignment)1);
			buddyProfileDialog.ParentPage = (Page)(object)this;
			buddyProfileDialog.StartChatTapped += dialog_StartChatTapped;
			buddyProfileDialog.BlockBuddyTapped += dialog_BlockBuddyTapped;
			new CustomPopup((Page)(object)this, (Panel)(object)LayoutRoot, (FrameworkElement)(object)buddyProfileDialog);
			return;
		}
		UnknownBuddyProfileDialog unknownBuddyProfileDialog = new UnknownBuddyProfileDialog();
		UnknownUser unknownUser = new UnknownUser(chatBuddy2.Buddy.Name, chatBuddy2.Buddy.PhoneNumber);
		if (unknownUser != null)
		{
			unknownUser.IsBlocked = true;
			unknownBuddyProfileDialog.BuddyInfo = unknownUser;
			((FrameworkElement)unknownBuddyProfileDialog).put_HorizontalAlignment((HorizontalAlignment)1);
			((FrameworkElement)unknownBuddyProfileDialog).put_VerticalAlignment((VerticalAlignment)1);
			unknownBuddyProfileDialog.ParentPage = (Page)(object)this;
			new CustomPopup((Page)(object)this, (Panel)(object)LayoutRoot, (FrameworkElement)(object)unknownBuddyProfileDialog);
		}
	}

	private void dialog_BlockBuddyTapped(object sender, ProfileDialogEventArgs e)
	{
		List<ChatBuddy> buddyItems = _viewModel.BuddyItems;
		int num = buddyItems.Count((ChatBuddy x) => x.Buddy != null && x.Buddy.IsBlocked) + 1;
		if (num == buddyItems.Count)
		{
			_viewModel.CreateGroupVisibility = (Visibility)1;
		}
	}

	private async void dialog_StartChatTapped(object sender, ProfileDialogEventArgs e)
	{
		await PivotPage.ActiveInstance.OpenChatAsync(e.Buddy);
		((Page)this).Frame.Navigate(typeof(PivotPage));
	}

	internal void OpenDialog(UserControl dialog)
	{
		new CustomPopup((Page)(object)this, (Panel)(object)LayoutRoot, (FrameworkElement)(object)dialog);
	}

	private void BuddyImageProfile_Loaded(object sender, RoutedEventArgs e)
	{
		//IL_0069: Unknown result type (might be due to invalid IL or missing references)
		//IL_0073: Expected O, but got Unknown
		//IL_007e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0085: Expected O, but got Unknown
		//IL_009d: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a7: Expected O, but got Unknown
		FrameworkElement val = (FrameworkElement)((sender is FrameworkElement) ? sender : null);
		if (val.Tag != null && (bool)val.Tag)
		{
			return;
		}
		SSMService sSMService = new SSMService();
		ChatBuddy chatBuddy = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is ChatBuddy chatBuddy2)
		{
			if (chatBuddy2.PhoneNumber == RegistrationService.ChatOnID)
			{
				ChatOnService.Instance.UserProfile.ProfileImage = new BitmapImage(sSMService.GetBuddyProfileImageUri(chatBuddy2.PhoneNumber));
				object obj = ((sender is Image) ? sender : null);
				DependencyProperty sourceProperty = Image.SourceProperty;
				Binding val2 = new Binding();
				val2.put_Source((object)ChatOnService.Instance.UserProfile);
				val2.put_Path(new PropertyPath("ProfileImage"));
				((FrameworkElement)obj).SetBinding(sourceProperty, (BindingBase)(object)val2);
			}
			((FrameworkElement)((sender is FrameworkElement) ? sender : null)).put_Tag((object)true);
		}
	}

	public void OpenBuddyProfile(string number)
	{
		Buddy buddyFromNumber = PivotPage.ActiveInstance.ViewModel.GetBuddyFromNumber(number);
		if (((ICollection<UIElement>)((Panel)LayoutRoot).Children).Count > 0)
		{
			UIElement val = null;
			if ((val = ((IEnumerable<UIElement>)((Panel)LayoutRoot).Children).FirstOrDefault((UIElement x) => (object)((object)x).GetType() == typeof(CustomPopup))) != null)
			{
				CustomPopup customPopup = null;
				if (val is CustomPopup customPopup2)
				{
					customPopup2.Close();
				}
			}
		}
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
			}
			else
			{
				BuddyProfileDialog buddyProfileDialog = new BuddyProfileDialog();
				buddyProfileDialog.BuddyInfo = buddyFromNumber;
				((FrameworkElement)buddyProfileDialog).put_HorizontalAlignment((HorizontalAlignment)1);
				((FrameworkElement)buddyProfileDialog).put_VerticalAlignment((VerticalAlignment)1);
				new CustomPopup((Page)(object)this, (Panel)(object)LayoutRoot, (FrameworkElement)(object)buddyProfileDialog);
			}
		}
		else
		{
			_viewModel.OpenUnknownBuddyProfile(number);
		}
	}

	private void AddButton_Loaded(object sender, RoutedEventArgs e)
	{
		ChatBuddy member = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as ChatBuddy;
		DataService dataService = new DataService();
		UnknownUser unknownUser = dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == member.PhoneNumber);
		if (unknownUser != null && !unknownUser.IsAddible)
		{
			((UIElement)((sender is FrameworkElement) ? sender : null)).put_Visibility((Visibility)1);
		}
	}

	private void Rename_OnClick(object sender, RoutedEventArgs e)
	{
		_viewModel.CheckAndSaveName(ChatNameControl.Text);
		oldGroupName = ChatNameControl.Text;
	}

	private void ChatName_GotFocus(object sender, RoutedEventArgs e)
	{
		ChatNameControl.SelectAll();
	}

	private void btnCancel_Click(object sender, RoutedEventArgs e)
	{
		ChatNameControl.put_Text(oldGroupName);
	}

	public void ShowSplashPopup(string text)
	{
		Utility.ShowSimpleToastNotification(text);
	}

	private void ChatName_LostFocus(object sender, RoutedEventArgs e)
	{
		ChatNameControl.put_Text(ChatNameControl.Text.Trim());
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
		//IL_011f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0129: Expected O, but got Unknown
		//IL_0135: Unknown result type (might be due to invalid IL or missing references)
		//IL_013f: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///ChatProfilePage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			LeftCommands = (StackPanel)((FrameworkElement)this).FindName("LeftCommands");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			CloseChatButton = (ImageButton)((FrameworkElement)this).FindName("CloseChatButton");
			InviteButton = (ImageButton)((FrameworkElement)this).FindName("InviteButton");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			BuddyCountControl = (TextBlock)((FrameworkElement)this).FindName("BuddyCountControl");
			ToggleAllertEnable = (ToggleSwitch)((FrameworkElement)this).FindName("ToggleAllertEnable");
			btnRename = (Button)((FrameworkElement)this).FindName("btnRename");
			ChatNameControl = (TextBox)((FrameworkElement)this).FindName("ChatNameControl");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0040: Unknown result type (might be due to invalid IL or missing references)
		//IL_0046: Expected O, but got Unknown
		//IL_0065: Unknown result type (might be due to invalid IL or missing references)
		//IL_006f: Expected O, but got Unknown
		//IL_0075: Unknown result type (might be due to invalid IL or missing references)
		//IL_007b: Expected O, but got Unknown
		//IL_009a: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a4: Expected O, but got Unknown
		//IL_00aa: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b0: Expected O, but got Unknown
		//IL_00cf: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d9: Expected O, but got Unknown
		//IL_00da: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e1: Expected O, but got Unknown
		//IL_0102: Unknown result type (might be due to invalid IL or missing references)
		//IL_010c: Expected O, but got Unknown
		//IL_0112: Unknown result type (might be due to invalid IL or missing references)
		//IL_0119: Expected O, but got Unknown
		//IL_013a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0144: Expected O, but got Unknown
		//IL_0156: Unknown result type (might be due to invalid IL or missing references)
		//IL_0160: Expected O, but got Unknown
		//IL_0172: Unknown result type (might be due to invalid IL or missing references)
		//IL_017c: Expected O, but got Unknown
		//IL_0182: Unknown result type (might be due to invalid IL or missing references)
		//IL_0189: Expected O, but got Unknown
		//IL_01aa: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b4: Expected O, but got Unknown
		//IL_01ba: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c1: Expected O, but got Unknown
		//IL_01e2: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ec: Expected O, but got Unknown
		//IL_01f2: Unknown result type (might be due to invalid IL or missing references)
		//IL_01f9: Expected O, but got Unknown
		//IL_021a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0224: Expected O, but got Unknown
		//IL_022a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0231: Expected O, but got Unknown
		//IL_0252: Unknown result type (might be due to invalid IL or missing references)
		//IL_025c: Expected O, but got Unknown
		//IL_0262: Unknown result type (might be due to invalid IL or missing references)
		//IL_0269: Expected O, but got Unknown
		//IL_028a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0294: Expected O, but got Unknown
		//IL_0295: Unknown result type (might be due to invalid IL or missing references)
		//IL_029c: Expected O, but got Unknown
		//IL_02bd: Unknown result type (might be due to invalid IL or missing references)
		//IL_02c7: Expected O, but got Unknown
		//IL_02ca: Unknown result type (might be due to invalid IL or missing references)
		//IL_02d1: Expected O, but got Unknown
		//IL_02f2: Unknown result type (might be due to invalid IL or missing references)
		//IL_02fc: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val12 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val12, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val12, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(ChatProfilePage_Loaded));
			break;
		}
		case 2:
		{
			UIElement val11 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val11, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val11, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BuddyImage_Tapped_1));
			break;
		}
		case 3:
		{
			ButtonBase val9 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(AddButton_Click_1));
			FrameworkElement val10 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(AddButton_Loaded));
			break;
		}
		case 4:
		{
			FrameworkElement val8 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(BuddyImageProfile_Loaded));
			break;
		}
		case 5:
			((ImageButton)target).Click += new RoutedEventHandler(CloseChat_Click);
			break;
		case 6:
			((ImageButton)target).Click += new RoutedEventHandler(InviteBuddies_Click);
			break;
		case 7:
		{
			ButtonBase val7 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(SaveGroup_Click_1));
			break;
		}
		case 8:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ProfileImage_Tapped_1));
			break;
		}
		case 9:
		{
			ToggleSwitch val5 = (ToggleSwitch)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(ToggleSwitch.add_Toggled)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(ToggleSwitch.remove_Toggled)), new RoutedEventHandler(alertToogle_OnSwitch));
			break;
		}
		case 10:
		{
			ButtonBase val4 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Rename_OnClick));
			break;
		}
		case 11:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_GotFocus)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_GotFocus)), new RoutedEventHandler(ChatName_GotFocus));
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_LostFocus)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_LostFocus)), new RoutedEventHandler(ChatName_LostFocus));
			break;
		}
		case 12:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
