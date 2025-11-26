using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Infrastructure;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class EmptyChatListPage : Page, IComponentConnector
{
	private static EmptyChatListPage _activeInstance;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button Button1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static EmptyChatListPage ActiveInstance => _activeInstance;

	public EmptyChatListPage()
	{
		InitializeComponent();
		_activeInstance = this;
		((ContentControl)Button1).put_Content((object)Utility.GetResourceString("IDS_CHATON_SK3_START_CHAT"));
		Text1.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_AFTER_YOU_CHAT_WITH_YOUR_BUDDIES_THE_LIST_OF_CHATS_WILL_BE_SHOWN"));
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (PivotPage.ActiveInstance.ViewModel != null)
		{
			PivotPage.ActiveInstance.ViewModel.SelectedIndex = 1;
		}
	}

	private void Button_Click_1(object sender, RoutedEventArgs e)
	{
		PivotPage.ActiveInstance.ViewModel.OnStartChat();
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///EmptyChatListPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			Button1 = (Button)((FrameworkElement)this).FindName("Button1");
			Text1 = (TextBlock)((FrameworkElement)this).FindName("Text1");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Expected O, but got Unknown
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		if (connectionId == 1)
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Button_Click_1));
		}
		_contentLoaded = true;
	}
}
