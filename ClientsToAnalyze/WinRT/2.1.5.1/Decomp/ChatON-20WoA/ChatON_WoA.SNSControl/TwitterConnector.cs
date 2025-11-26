using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.Services;
using ChatOn.Controls;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.SNSControl;

public sealed class TwitterConnector : UserControl, IComponentConnector
{
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private WebView TwitterWebView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public TwitterConnector()
	{
		InitializeComponent();
	}

	public unsafe async void Login()
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			string RequestToken = await TwitterService.GetRequestToken();
			WebView twitterWebView = TwitterWebView;
			WindowsRuntimeMarshal.AddEventHandler(new Func<LoadCompletedEventHandler, EventRegistrationToken>(twitterWebView, (nint)__ldftn(WebView.add_LoadCompleted)), new Action<EventRegistrationToken>(twitterWebView, (nint)__ldftn(WebView.remove_LoadCompleted)), new LoadCompletedEventHandler(TwitterWebView_LoginLoaded));
			if (!string.IsNullOrEmpty(RequestToken))
			{
				string text = null;
				string[] array = RequestToken.Split('&');
				for (int i = 0; i < array.Length; i++)
				{
					string[] array2 = array[i].Split('=');
					switch (array2[0])
					{
					case "oauth_token":
						text = array2[1];
						break;
					case "oauth_token_secret":
						_ = array2[1];
						break;
					case "xoauth_request_auth_url":
						_ = array2[1];
						break;
					}
				}
				string uriString = TwitterService.GetLoginUri() + "?oauth_token=" + text;
				TwitterWebView.Navigate(new Uri(uriString));
			}
			new LoadingIndicator(null, (Panel)(object)LayoutRoot);
		}
		catch (Exception)
		{
		}
	}

	private CustomPopup GetParentPopup()
	{
		DependencyObject parent = ((FrameworkElement)this).Parent;
		Grid val = (Grid)(object)((parent is Grid) ? parent : null);
		return ((FrameworkElement)val).Parent as CustomPopup;
	}

	private void TwitterWebView_LoginLoaded(object sender, NavigationEventArgs e)
	{
		LoadingIndicator.StopLoading();
		((UIElement)TwitterWebView).put_Visibility((Visibility)0);
		((Control)this).Focus((FocusState)2);
	}

	private void TwitterWebView_Loaded(object sender, RoutedEventArgs e)
	{
		Login();
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SNSControl/TwitterConnector.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TwitterWebView = (WebView)((FrameworkElement)this).FindName("TwitterWebView");
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
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(TwitterWebView_Loaded));
		}
		_contentLoaded = true;
	}
}
