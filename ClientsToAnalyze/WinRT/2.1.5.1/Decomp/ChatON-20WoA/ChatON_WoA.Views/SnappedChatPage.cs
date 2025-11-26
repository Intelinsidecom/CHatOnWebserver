using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Core;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class SnappedChatPage : Page, IComponentConnector
{
	public static bool IsInstantiated;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Frame CurrentChatFrame;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock ChatTitleControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public SnappedChatPage()
	{
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)PivotPage.ActiveInstance.ViewModel);
		if (!IsInstantiated)
		{
			CurrentChatFrame.Navigate(typeof(ChatDetailPage), (object)ChatDetailPageType.Snapped);
			IsInstantiated = true;
		}
	}

	protected unsafe override void OnNavigatedTo(NavigationEventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		//IL_003e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0044: Invalid comparison between Unknown and I4
		//IL_00a5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ab: Expected O, but got Unknown
		DispatchedHandler val = null;
		Window current = Window.Current;
		WindowsRuntimeMarshal.AddEventHandler(new Func<WindowSizeChangedEventHandler, EventRegistrationToken>(current, (nint)__ldftn(Window.add_SizeChanged)), new Action<EventRegistrationToken>(current, (nint)__ldftn(Window.remove_SizeChanged)), new WindowSizeChangedEventHandler(Current_SizeChanged));
		Chat chat = e.Parameter as Chat;
		if ((int)e.NavigationMode == 1)
		{
			return;
		}
		if (chat != null)
		{
			if (ChatDetailPage.SnappedActiveInstance != null && ChatDetailPage.SnappedActiveInstance.ViewModel != null)
			{
				((FrameworkElement)ChatTitleControl).put_DataContext((object)chat);
				ChatDetailPage.SnappedActiveInstance.ViewModel.title = "Snapped";
				ChatDetailPage.SnappedActiveInstance.ActivateChat(chat);
				ChatDetailPage.SnappedActiveInstance.OnLoaded();
			}
			return;
		}
		CoreDispatcher dispatcher = ((DependencyObject)this).Dispatcher;
		if (val == null)
		{
			val = (DispatchedHandler)delegate
			{
				if (ChatOnService.Instance.RecentChat == null)
				{
					Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
					if ((object)((Page)this).Frame.CurrentSourcePageType != typeof(SnappedChatListPage))
					{
						((Page)this).Frame.Navigate(typeof(SnappedChatListPage));
					}
				}
				else
				{
					ChatDetailPage.SnappedActiveInstance.ViewModel.title = "Snapped";
					ChatDetailPage.SnappedActiveInstance.ActivateChat(ChatOnService.Instance.RecentChat);
					ChatDetailPage.SnappedActiveInstance.OnLoaded();
				}
			};
		}
		dispatcher.RunAsync((CoreDispatcherPriority)0, val);
	}

	protected unsafe override void OnNavigatedFrom(NavigationEventArgs e)
	{
		//IL_0017: Unknown result type (might be due to invalid IL or missing references)
		//IL_0021: Expected O, but got Unknown
		//IL_0029: Unknown result type (might be due to invalid IL or missing references)
		//IL_002f: Invalid comparison between Unknown and I4
		WindowsRuntimeMarshal.RemoveEventHandler<WindowSizeChangedEventHandler>(new Action<EventRegistrationToken>(Window.Current, (nint)__ldftn(Window.remove_SizeChanged)), new WindowSizeChangedEventHandler(Current_SizeChanged));
		if (ChatDetailPage.SnappedActiveInstance != null && (int)e.NavigationMode != 1)
		{
			ChatDetailPage.SnappedActiveInstance.Disconnect();
		}
	}

	private void Image_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
		if ((object)((Page)this).Frame.CurrentSourcePageType != typeof(SnappedChatListPage))
		{
			if ((object)((Page)this).Frame.CurrentSourcePageType == typeof(MainPage))
			{
				((Page)this).Frame.GoForward();
			}
			((Page)this).Frame.Navigate(typeof(SnappedChatListPage));
		}
	}

	private void Current_SizeChanged(object sender, WindowSizeChangedEventArgs e)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		if ((int)ApplicationView.Value != 2)
		{
			Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
			while ((object)((Page)this).Frame.CurrentSourcePageType != typeof(PivotPage))
			{
				Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
			}
			if (ChatListPage.ActiveInstance != null)
			{
				ChatListPage.ActiveInstance.ChangeChatRoomFromSnap(ChatOnService.Instance.RecentChat);
			}
		}
	}

	private void Page_Loaded(object sender, RoutedEventArgs e)
	{
		PivotPage.ActiveInstance.CloseAllPopup();
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SnappedChatPage.xaml"), (ComponentResourceLocation)0);
			CurrentChatFrame = (Frame)((FrameworkElement)this).FindName("CurrentChatFrame");
			ChatTitleControl = (TextBlock)((FrameworkElement)this).FindName("ChatTitleControl");
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
		//IL_0047: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		//IL_006c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0076: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val2 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(Page_Loaded));
			break;
		}
		case 2:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
