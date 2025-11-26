using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.Controls;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class EmptyBuddyListPage : Page, IComponentConnector
{
	private static EmptyBuddyListPage _activeInstance;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LeftCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton SuggestionsButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton AddBuddyButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button btnAdd;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button btnContactSync;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button btnTellFriends;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static EmptyBuddyListPage ActiveInstance => _activeInstance;

	public EmptyBuddyListPage()
	{
		InitializeComponent();
		_activeInstance = this;
		Text1.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_WHO_WILL_BE_YOUR_FIRST_BUDDY_Q"));
		((ContentControl)btnAdd).put_Content((object)Utility.GetResourceString("IDS_CHATON_OPT_ADD_BUDDY"));
		AddBuddyButton.Text = Utility.GetResourceString("IDS_CHATON_OPT_ADD_BUDDY");
		SuggestionsButton.Text = Utility.GetResourceString("IDS_CHATON_ITAB_SUGGESTIONS");
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (PivotPage.ActiveInstance.ViewModel != null)
		{
			PivotPage.ActiveInstance.ViewModel.SelectedIndex = 0;
		}
		((FrameworkElement)this).put_DataContext((object)PivotPage.ActiveInstance.ViewModel);
	}

	private void AddBuddy_Click(object sender, RoutedEventArgs e)
	{
		AddBuddyDialog.OpenAddBuddyDialog();
		appBar.put_IsOpen(false);
	}

	private void popup_Closed(object sender, object e)
	{
	}

	private void Suggestions_Click(object sender, RoutedEventArgs e)
	{
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SuggestionsPage));
	}

	private void SamsungAccount_Click(object sender, RoutedEventArgs e)
	{
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SyncIntroPage));
	}

	private async void SyncNow_Clik(object sender, RoutedEventArgs e)
	{
		if (string.IsNullOrEmpty(RegistrationService.GetUserAccount().MSISDN))
		{
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(InputPhoneNumberPage));
		}
		else if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_BODY_ALL_CONTACTS_WILL_BE_IMPORTED_AND_ADDED_AS_BUDDIES"), showCancel: false))
		{
			new SyncLoadingIndicator((Page)(object)this, (Panel)(object)LayoutRoot);
			PivotPage.ActiveInstance.ViewModel.SyncContact();
		}
	}

	private void TellFriends_Clik(object sender, RoutedEventArgs e)
	{
		AddBuddyDialog.OpenAddBuddyDialog(3);
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///EmptyBuddyListPage.xaml"), (ComponentResourceLocation)0);
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			LeftCommands = (StackPanel)((FrameworkElement)this).FindName("LeftCommands");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			SuggestionsButton = (ImageButton)((FrameworkElement)this).FindName("SuggestionsButton");
			AddBuddyButton = (ImageButton)((FrameworkElement)this).FindName("AddBuddyButton");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			btnAdd = (Button)((FrameworkElement)this).FindName("btnAdd");
			btnContactSync = (Button)((FrameworkElement)this).FindName("btnContactSync");
			btnTellFriends = (Button)((FrameworkElement)this).FindName("btnTellFriends");
			Text1 = (TextBlock)((FrameworkElement)this).FindName("Text1");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0030: Unknown result type (might be due to invalid IL or missing references)
		//IL_003a: Expected O, but got Unknown
		//IL_004c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0056: Expected O, but got Unknown
		//IL_005c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0062: Expected O, but got Unknown
		//IL_0081: Unknown result type (might be due to invalid IL or missing references)
		//IL_008b: Expected O, but got Unknown
		//IL_008e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0094: Expected O, but got Unknown
		//IL_00b3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bd: Expected O, but got Unknown
		//IL_00c0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c6: Expected O, but got Unknown
		//IL_00e5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ef: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
			((ImageButton)target).Click += new RoutedEventHandler(Suggestions_Click);
			break;
		case 2:
			((ImageButton)target).Click += new RoutedEventHandler(AddBuddy_Click);
			break;
		case 3:
		{
			ButtonBase val3 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(AddBuddy_Click));
			break;
		}
		case 4:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(SyncNow_Clik));
			break;
		}
		case 5:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(TellFriends_Clik));
			break;
		}
		}
		_contentLoaded = true;
	}
}
