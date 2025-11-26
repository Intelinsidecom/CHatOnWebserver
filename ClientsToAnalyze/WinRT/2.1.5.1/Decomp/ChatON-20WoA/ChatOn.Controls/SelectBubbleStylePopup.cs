using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.InfraStructure;
using ChatON_WoA.Views;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public class SelectBubbleStylePopup : UserControl, IComponentConnector
{
	private SelectBubbleStylePopupViewModel _viewModel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private SampleChatBubble BuddyBubbleControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private SampleChatBubble MyBubbleControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public SelectBubbleStylePopup()
	{
		InitializeComponent();
		_viewModel = new SelectBubbleStylePopupViewModel(isBGSelection: false);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
	}

	private void BubbleItem_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		SkinItem item = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as SkinItem;
		_viewModel.OnSelectBubble(item);
		ChatBubbleProvider.Instance.LoadBubble();
		ChatSettingPage.ActiveInstance.Update();
		BuddyBubbleControl.Type = 1;
		BuddyBubbleControl.Type = 0;
		MyBubbleControl.Type = 0;
		MyBubbleControl.Type = 1;
		ChatOnService.Instance.IsChatFontOrBubbleUpdated = true;
	}

	private void MyBubbleItem_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		SkinItem item = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as SkinItem;
		_viewModel.OnSelectMyBubble(item);
		ChatBubbleProvider.Instance.LoadBubble();
		ChatSettingPage.ActiveInstance.Update();
		BuddyBubbleControl.Type = 1;
		BuddyBubbleControl.Type = 0;
		MyBubbleControl.Type = 0;
		MyBubbleControl.Type = 1;
		ChatOnService.Instance.IsChatFontOrBubbleUpdated = true;
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SelectBubbleStylePopup.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			BuddyBubbleControl = (SampleChatBubble)((FrameworkElement)this).FindName("BuddyBubbleControl");
			MyBubbleControl = (SampleChatBubble)((FrameworkElement)this).FindName("MyBubbleControl");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
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
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(MyBubbleItem_Tapped_1));
			break;
		}
		case 2:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BubbleItem_Tapped_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
