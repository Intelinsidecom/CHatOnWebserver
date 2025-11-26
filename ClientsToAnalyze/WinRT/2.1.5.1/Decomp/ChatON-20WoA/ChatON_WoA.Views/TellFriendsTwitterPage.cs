using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.Services;
using ChatON_WoA.ViewModels;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class TellFriendsTwitterPage : Page, IComponentConnector
{
	private TellFriendsTwitterPageViewModel _viewModel;

	private WebView _webView;

	private static TellFriendsTwitterPage _instance;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid RootFrame;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid DefaultGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid FriendsGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private GridView FriendsGridView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid AccountGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static TellFriendsTwitterPage ActiveInstance => _instance;

	public TellFriendsTwitterPage()
	{
		InitializeComponent();
		_instance = this;
		_viewModel = new TellFriendsTwitterPageViewModel(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		_viewModel.GetMyInformation();
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_000c: Invalid comparison between Unknown and I4
		if ((int)((UIElement)FriendsGrid).Visibility == 1)
		{
			((Page)this).Frame.GoBack();
		}
		else
		{
			ChangeVisibleGrid(IsDefaultOn: true);
		}
	}

	private void ChangeVisibleGrid(bool IsDefaultOn)
	{
		if (IsDefaultOn)
		{
			((UIElement)DefaultGrid).put_Visibility((Visibility)0);
			((UIElement)FriendsGrid).put_Visibility((Visibility)1);
			return;
		}
		((UIElement)DefaultGrid).put_Visibility((Visibility)1);
		((UIElement)FriendsGrid).put_Visibility((Visibility)0);
		_viewModel.FriendsItems.OrderBy((TwitterUser c) => c.Name);
	}

	private async void PostMeButton_Click(object sender, RoutedEventArgs e)
	{
		if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_SHARE_CHATON_INVITATION_MESSAGE_Q"), showCancel: true, Utility.GetResourceString("IDS_CHATON_HEADER_TWITTER")))
		{
			if (LoadingIndicator.ActiveIndicator != null)
			{
				LoadingIndicator.StopLoading();
			}
			LoadingIndicator.StartLoading(null, (Panel)(object)RootFrame, Utility.GetResourceString("IDS_CHATON_POP_POSTING_ING_FACEBOOK"));
			bool result = await _viewModel.PostInvitationMessage();
			LoadingIndicator.StopLoading();
			if (result)
			{
				await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_POSTED"), showCancel: false);
			}
			else
			{
				await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_POSTING_FAILED"), showCancel: false);
			}
		}
	}

	private async void PostFriendButton_Click(object sender, RoutedEventArgs e)
	{
		ChangeVisibleGrid(IsDefaultOn: false);
		if (_viewModel.FriendsItems.Count >= 1)
		{
			return;
		}
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading(null, (Panel)(object)RootFrame);
		if (_viewModel.FriendsItems.Count > 0)
		{
			ChangeVisibleGrid(IsDefaultOn: true);
			return;
		}
		TwitterServiceArgument result = await _viewModel.MakeFriendsList();
		LoadingIndicator.StopLoading();
		if (result.ResultType == TwitterServiceResultType.NETWORK_ERROR)
		{
			LoadingIndicator.StopLoading();
			await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR_OCCURRED_TRY_AGAIN"), showCancel: false);
			if (_viewModel.FriendsItems.Count < 1)
			{
				ChangeVisibleGrid(IsDefaultOn: true);
			}
		}
		else if (result.ResultType == TwitterServiceResultType.NO_RESULT)
		{
			LoadingIndicator.StopLoading();
			await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_HEADER_NO_BUDDIES"), showCancel: false);
			if (_viewModel.FriendsItems.Count < 1)
			{
				ChangeVisibleGrid(IsDefaultOn: true);
			}
		}
	}

	private async void InviteButton_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.PostInvitationCard(((FrameworkElement)((sender is Button) ? sender : null)).Tag.ToString());
	}

	private unsafe void dialog_SelectCompleted(object sender, object e)
	{
		//IL_0029: Unknown result type (might be due to invalid IL or missing references)
		//IL_0033: Expected O, but got Unknown
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		if ((bool)e)
		{
			if (LoadingIndicator.ActiveIndicator != null)
			{
				LoadingIndicator.StopLoading();
			}
			LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)RootFrame);
			_webView = new WebView();
			WebView webView = _webView;
			WindowsRuntimeMarshal.AddEventHandler(new Func<LoadCompletedEventHandler, EventRegistrationToken>(webView, (nint)__ldftn(WebView.add_LoadCompleted)), new Action<EventRegistrationToken>(webView, (nint)__ldftn(WebView.remove_LoadCompleted)), new LoadCompletedEventHandler(_webView_LoadCompleted));
			_webView.Navigate(TwitterService.GetLogoutUri());
		}
	}

	private void AccountGrid_Tapped(object sender, TappedRoutedEventArgs e)
	{
		SignOutDialog signOutDialog = new SignOutDialog();
		((FrameworkElement)signOutDialog).put_HorizontalAlignment((HorizontalAlignment)0);
		((FrameworkElement)signOutDialog).put_VerticalAlignment((VerticalAlignment)0);
		((FrameworkElement)signOutDialog).put_Margin(new Thickness(250.0, 130.0, 0.0, 0.0));
		signOutDialog.SelectCompleted += dialog_SelectCompleted;
		OpenDialog((UserControl)(object)signOutDialog, closePrevPopup: true);
	}

	internal void OpenDialog(UserControl dialog, bool closePrevPopup = false)
	{
		if (closePrevPopup)
		{
			int count = ((ICollection<UIElement>)((Panel)RootFrame).Children).Count;
			for (int num = count - 1; num >= 0; num--)
			{
				UIElement val = ((IList<UIElement>)((Panel)RootFrame).Children)[num];
				if ((object)((object)val).GetType() == typeof(CustomPopup))
				{
					((ICollection<UIElement>)((Panel)RootFrame).Children).Remove(val);
				}
			}
		}
		new CustomPopup((Page)(object)this, (Panel)(object)RootFrame, (FrameworkElement)(object)dialog);
	}

	private void _webView_LoadCompleted(object sender, NavigationEventArgs e)
	{
		LoadingIndicator.StopLoading();
		SettingService.SetTwitterAccountName("");
		SettingService.SetTwitterAcessToken("");
		SettingService.SetTwitterAcessTokenSecret("");
		SettingService.SetTwitterOauthVerifier("");
		SettingService.SetSignedOnTwitter(loggedinStatus: false);
		((Page)this).Frame.GoBack();
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
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///TellFriendsTwitterPage.xaml"), (ComponentResourceLocation)0);
			RootFrame = (Grid)((FrameworkElement)this).FindName("RootFrame");
			DefaultGrid = (Grid)((FrameworkElement)this).FindName("DefaultGrid");
			FriendsGrid = (Grid)((FrameworkElement)this).FindName("FriendsGrid");
			FriendsGridView = (GridView)((FrameworkElement)this).FindName("FriendsGridView");
			AccountGrid = (Grid)((FrameworkElement)this).FindName("AccountGrid");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0024: Unknown result type (might be due to invalid IL or missing references)
		//IL_002a: Expected O, but got Unknown
		//IL_0049: Unknown result type (might be due to invalid IL or missing references)
		//IL_0053: Expected O, but got Unknown
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_005f: Expected O, but got Unknown
		//IL_007e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0088: Expected O, but got Unknown
		//IL_008e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0094: Expected O, but got Unknown
		//IL_00b3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bd: Expected O, but got Unknown
		//IL_00c0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c7: Expected O, but got Unknown
		//IL_00e8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f2: Expected O, but got Unknown
		//IL_00f5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fc: Expected O, but got Unknown
		//IL_011d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0127: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			ButtonBase val5 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(InviteButton_Click));
			break;
		}
		case 2:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(AccountGrid_Tapped));
			break;
		}
		case 3:
		{
			ButtonBase val3 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(PostMeButton_Click));
			break;
		}
		case 4:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(PostFriendButton_Click));
			break;
		}
		case 5:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
