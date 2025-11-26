using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.Services;
using ChatOn.Controls;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.SNSControl;

public sealed class FacebookConnector : UserControl, IComponentConnector
{
	private readonly Uri _loginUrl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private WebView FacebookWebView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public FacebookConnector()
	{
		_loginUrl = FacebookService.GetLoginUri();
		InitializeComponent();
	}

	private void FacebookWebView_Loaded(object sender, RoutedEventArgs e)
	{
		Login();
	}

	public unsafe void Login()
	{
		//IL_0026: Unknown result type (might be due to invalid IL or missing references)
		//IL_0030: Expected O, but got Unknown
		WebView facebookWebView = FacebookWebView;
		WindowsRuntimeMarshal.AddEventHandler(new Func<LoadCompletedEventHandler, EventRegistrationToken>(facebookWebView, (nint)__ldftn(WebView.add_LoadCompleted)), new Action<EventRegistrationToken>(facebookWebView, (nint)__ldftn(WebView.remove_LoadCompleted)), new LoadCompletedEventHandler(FacebookWebView_LoginLoadCompleted));
		FacebookWebView.Navigate(_loginUrl);
		new LoadingIndicator(null, (Panel)(object)LayoutRoot);
	}

	private async void FacebookWebView_LoginLoadCompleted(object sender, NavigationEventArgs e)
	{
		LoadingIndicator.StopLoading();
		((UIElement)FacebookWebView).put_Visibility((Visibility)0);
		((Control)this).Focus((FocusState)2);
		if (FacebookService.TryParseOAuthCallbackUri(e.Uri))
		{
			((UIElement)FacebookWebView).put_Visibility((Visibility)1);
			new LoadingIndicator(null, (Panel)(object)LayoutRoot);
			if (FacebookService.OAuthResult.IsSuccess)
			{
				FacebookService.UserName = (await FacebookService.GetMyInfomation()).Name;
				PageNavigationService.OpenTellFriendsFacebookPage(GetParentPopup().Page);
			}
			GetParentPopup().Close();
		}
		else if (e.Uri.OriginalString.StartsWith(FacebookService.RedirectUri) && e.Uri.Query.Contains("error_reason"))
		{
			GetParentPopup().Close();
		}
	}

	private CustomPopup GetParentPopup()
	{
		DependencyObject parent = ((FrameworkElement)this).Parent;
		Grid val = (Grid)(object)((parent is Grid) ? parent : null);
		return ((FrameworkElement)val).Parent as CustomPopup;
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
			Application.LoadComponent((object)this, new Uri("ms-appx:///SNSControl/FacebookConnector.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			FacebookWebView = (WebView)((FrameworkElement)this).FindName("FacebookWebView");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Expected O, but got Unknown
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		if (connectionId == 1)
		{
			FrameworkElement val = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(FacebookWebView_Loaded));
		}
		_contentLoaded = true;
	}
}
