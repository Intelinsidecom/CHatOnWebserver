using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.InfraStructure;
using ChatOn_WoA.Services;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class SamsungAccountSignupDialog : UserControl, IComponentConnector
{
	private SamsungAccountService _ssaService;

	private SSMService _ssmService;

	private string _email;

	private string _signInUrl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid SamsungAccountSignInGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private WebView SamsungAccountWebBrowser;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public SamsungAccountSignupDialog()
	{
		InitializeComponent();
		_ssaService = new SamsungAccountService();
		_ssmService = new SSMService();
		_ssmService.SetMappingDeviceCompleted += _ssmService_SetMappingDeviceCompleted;
		_ssmService.UpdateUserProfileCompleted += _ssmService_UpdateUserProfileCompleted;
	}

	private void SamsungAccountSigninDialog_Loaded(object sender, RoutedEventArgs e)
	{
		((UIElement)SamsungAccountWebBrowser).put_Visibility((Visibility)0);
		_signInUrl = _ssaService.GetSignInUrl();
		SamsungAccountWebBrowser.Navigate(new Uri(_signInUrl, UriKind.Absolute));
	}

	private async void SamsungAccountWebBrowser_LoadCompleted(object sender, NavigationEventArgs e)
	{
		string url = e.Uri.OriginalString;
		LoadingIndicator.StopLoading();
		if (url.Contains("code"))
		{
			Dictionary<string, string> ResponseDic = new Dictionary<string, string>();
			int start = url.IndexOf("?") + 1;
			int end = url.Length;
			((UIElement)SamsungAccountWebBrowser).put_Visibility((Visibility)1);
			new LoadingIndicator(null, (Panel)(object)SamsungAccountSignInGrid, Utility.GetResourceString("IDS_CHATON_BODY_SIGNING_IN_ING"));
			string Jsonstr = url.Substring(start, end - start);
			StringTokenizer token = new StringTokenizer(Jsonstr, "&");
			while (token.hasMoreTokens())
			{
				string dataLine = token.nextToken();
				StringTokenizer stringTokenizer = new StringTokenizer(dataLine, "=");
				string key = stringTokenizer.nextToken();
				string value = stringTokenizer.nextToken();
				ResponseDic.Add(key, value);
			}
			if (ResponseDic.ContainsKey("error_code"))
			{
				await Utility.ShowOKCancleMessageDialog(ResponseDic["error_description"]);
				return;
			}
			SamsungAccountServiceResult result = await _ssaService.GetAccessToken(ResponseDic["code"]);
			if (result != null && result.ResultType == SamsungAccountServiceResultType.SUCCESS)
			{
				_email = (await _ssaService.GetUserEmail()).ResultString;
				LoadingIndicator.StopLoading();
				if (string.IsNullOrEmpty(RegistrationService.ChatOnID))
				{
					PageNavigationService.OpenInputNamePage(GetParentPopup().Page, "?mode=SamsungAccount&code=" + SamsungAccountService.AccessToken + "&email=" + _email);
				}
				else
				{
					_ssmService.SetMappingDeviceAsync(_email, SamsungAccountService.AccessToken);
				}
			}
		}
		else if (url.Contains("about:blank") || url.Contains("close=true"))
		{
			Utility.SafetyGoBack(null);
		}
	}

	private void _ssmService_SetMappingDeviceCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode != HttpStatusCode.OK)
		{
			SSMService.ShowCommonErrorMessage(e);
			Utility.SafetyGoBack(null);
		}
		else
		{
			_ssmService.UpdateUserProfileAsync(SSMService.MakeProfileParam("samsungemail", _email));
		}
	}

	private void _ssmService_UpdateUserProfileCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK)
		{
			UserProfile userProfile = RegistrationService.GetUserProfile();
			userProfile.Email = _email;
			RegistrationService.SaveUserProfile(userProfile);
			ChatOnService.Instance.ReUpdateBuddyList = true;
			ChatOnService.Instance.ReUpdateChatList = true;
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
		Utility.SafetyGoBack(null);
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
			Application.LoadComponent((object)this, new Uri("ms-appx:///SamsungAccountSignupDialog.xaml"), (ComponentResourceLocation)0);
			SamsungAccountSignInGrid = (Grid)((FrameworkElement)this).FindName("SamsungAccountSignInGrid");
			SamsungAccountWebBrowser = (WebView)((FrameworkElement)this).FindName("SamsungAccountWebBrowser");
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
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(SamsungAccountSigninDialog_Loaded));
			break;
		}
		case 2:
		{
			WebView val = (WebView)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<LoadCompletedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(WebView.add_LoadCompleted)), new Action<EventRegistrationToken>(val, (nint)__ldftn(WebView.remove_LoadCompleted)), new LoadCompletedEventHandler(SamsungAccountWebBrowser_LoadCompleted));
			break;
		}
		}
		_contentLoaded = true;
	}
}
