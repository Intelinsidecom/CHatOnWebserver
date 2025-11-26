using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.CompilerServices;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class ChatSettingPage : Page, IComponentConnector
{
	private static ChatSettingPage _activeInstance;

	private ChatSettingPageViewModel _viewModel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ToggleSwitch ToggleSendWithEnterKey;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel spFontSize;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ChatBubble cbExtraLarge;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ChatBubble cbLarge;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ChatBubble cbMedium;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ChatBubble cbSmall;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ChatBubble cbExtraSmall;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ChatBubble BuddyBubble;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ChatBubble MyBubble;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image SelectedBGImage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static ChatSettingPage ActiveInstance => _activeInstance;

	public ChatSettingPage()
	{
		InitializeComponent();
		ToggleSendWithEnterKey.put_IsOn(SettingService.GetSendEnterKey());
		_activeInstance = this;
		OpenBGImage();
		_viewModel = new ChatSettingPageViewModel();
		((FrameworkElement)this).put_DataContext((object)_viewModel);
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		SettingsPage.ActiveInstance.StopLoading();
		((Page)this).OnNavigatedFrom(e);
	}

	private async void OpenBGImage()
	{
		Image obj = SelectedBGImage;
		TaskAwaiter<BitmapImage> taskAwaiter = SettingService.GetSelectedBG().GetAwaiter();
		if (!taskAwaiter.IsCompleted)
		{
			Image val = obj;
			object obj2 = val;
			await taskAwaiter;
			Image val2 = (Image)obj2;
			obj = val2;
			TaskAwaiter<BitmapImage> taskAwaiter2 = default(TaskAwaiter<BitmapImage>);
			taskAwaiter = taskAwaiter2;
		}
		obj.put_Source((ImageSource)(object)taskAwaiter.GetResult());
	}

	private void ToggleSendWithEnterKey_Toggled_1(object sender, RoutedEventArgs e)
	{
		SettingService.SetSendEnterKey(ToggleSendWithEnterKey.IsOn);
	}

	private void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		SelectBubbleStylePopup selectBubbleStylePopup = new SelectBubbleStylePopup();
		((FrameworkElement)selectBubbleStylePopup).put_HorizontalAlignment((HorizontalAlignment)2);
		((FrameworkElement)selectBubbleStylePopup).put_VerticalAlignment((VerticalAlignment)1);
		((FrameworkElement)selectBubbleStylePopup).put_Margin(new Thickness(0.0, 0.0, 100.0, 0.0));
		SettingsPage.ActiveInstance.OpenDialog((UserControl)(object)selectBubbleStylePopup);
	}

	public void Update()
	{
		OpenBGImage();
		BuddyBubble.Type = 1;
		BuddyBubble.Type = 0;
		MyBubble.Type = 0;
		MyBubble.Type = 1;
		cbExtraLarge.Type = 1;
		cbExtraLarge.Type = 0;
		cbExtraSmall.Type = 1;
		cbExtraSmall.Type = 0;
		cbSmall.Type = 1;
		cbSmall.Type = 0;
		cbMedium.Type = 1;
		cbMedium.Type = 0;
		cbLarge.Type = 1;
		cbLarge.Type = 0;
	}

	private void BG_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		SelectBackgroundPopup selectBackgroundPopup = new SelectBackgroundPopup();
		((FrameworkElement)selectBackgroundPopup).put_HorizontalAlignment((HorizontalAlignment)2);
		((FrameworkElement)selectBackgroundPopup).put_VerticalAlignment((VerticalAlignment)1);
		((FrameworkElement)selectBackgroundPopup).put_Margin(new Thickness(0.0, 0.0, 100.0, 0.0));
		SettingsPage.ActiveInstance.OpenDialog((UserControl)(object)selectBackgroundPopup);
	}

	private void spFontSize_Tapped(object sender, TappedRoutedEventArgs e)
	{
		FontSizePopUp fontSizePopUp = new FontSizePopUp();
		((FrameworkElement)fontSizePopUp).put_HorizontalAlignment((HorizontalAlignment)2);
		((FrameworkElement)fontSizePopUp).put_VerticalAlignment((VerticalAlignment)1);
		((FrameworkElement)fontSizePopUp).put_Margin(new Thickness(0.0, 0.0, 100.0, 0.0));
		SettingsPage.ActiveInstance.OpenDialog((UserControl)(object)fontSizePopUp);
	}

	public void UpdateFontSize(int value)
	{
		_viewModel.SelectedFontSize = value;
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
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///ChatSettingPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			ToggleSendWithEnterKey = (ToggleSwitch)((FrameworkElement)this).FindName("ToggleSendWithEnterKey");
			spFontSize = (StackPanel)((FrameworkElement)this).FindName("spFontSize");
			cbExtraLarge = (ChatBubble)((FrameworkElement)this).FindName("cbExtraLarge");
			cbLarge = (ChatBubble)((FrameworkElement)this).FindName("cbLarge");
			cbMedium = (ChatBubble)((FrameworkElement)this).FindName("cbMedium");
			cbSmall = (ChatBubble)((FrameworkElement)this).FindName("cbSmall");
			cbExtraSmall = (ChatBubble)((FrameworkElement)this).FindName("cbExtraSmall");
			BuddyBubble = (ChatBubble)((FrameworkElement)this).FindName("BuddyBubble");
			MyBubble = (ChatBubble)((FrameworkElement)this).FindName("MyBubble");
			SelectedBGImage = (Image)((FrameworkElement)this).FindName("SelectedBGImage");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
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
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BG_Tapped_1));
			break;
		}
		case 2:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 3:
		{
			ToggleSwitch val2 = (ToggleSwitch)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ToggleSwitch.add_Toggled)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ToggleSwitch.remove_Toggled)), new RoutedEventHandler(ToggleSendWithEnterKey_Toggled_1));
			break;
		}
		case 4:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(spFontSize_Tapped));
			break;
		}
		}
		_contentLoaded = true;
	}
}
