using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.Services;
using ChatON_WoA.ViewModels;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.Security.Authentication.Web;
using Windows.Storage;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA;

public sealed class ManageAccountPage : Page, IComponentConnector
{
	private ManageAccountPageViewModel _viewModel;

	private SSMService _ssmService;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel StackSamsung;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel StackFB;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel StackTwitter;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock EmailTwitterText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock EmailFBText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock EmailText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public ManageAccountPage()
	{
		_viewModel = new ManageAccountPageViewModel(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		InitializeComponent();
		_ssmService = new SSMService();
		_ssmService.DeRegisterUserCompleted += _ssmService_DeRegisterUserCompleted;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
	}

	private void OnTwitterSigninTapped(object sender, TappedRoutedEventArgs e)
	{
		SettingsPage.ActiveInstance.ShowLoading();
		OpenTwitterLogin();
	}

	internal void OpenDialog(UserControl dialog, bool closePrevPopup = false)
	{
		if (closePrevPopup)
		{
			CloseAllPopup();
		}
		new CustomPopup((Page)(object)SettingsPage.ActiveInstance, (Panel)(object)LayoutRoot, (FrameworkElement)(object)dialog);
	}

	private async void OpenTwitterLogin()
	{
		try
		{
			string twitterLoginUrl = await TwitterService.GetTwitterLoginUrl();
			if (twitterLoginUrl == null)
			{
				return;
			}
			WebAuthenticationResult WebAuthenticationResult = await WebAuthenticationBroker.AuthenticateAsync((WebAuthenticationOptions)0, new Uri(twitterLoginUrl), new Uri(TwitterService.RedirectUri));
			if ((int)WebAuthenticationResult.ResponseStatus == 0)
			{
				if (string.IsNullOrEmpty(WebAuthenticationResult.ResponseData.ToString()))
				{
					return;
				}
				string oauth_token = null;
				string oauth_verifier = null;
				string[] keyValPairs = WebAuthenticationResult.ResponseData.ToString().Split('&');
				for (int i = 0; i < keyValPairs.Length; i++)
				{
					string[] array = keyValPairs[i].Split('=');
					switch (array[0].Replace(TwitterService.RedirectUri + "?", ""))
					{
					case "oauth_token":
						oauth_token = array[1];
						break;
					case "oauth_verifier":
						oauth_verifier = array[1];
						break;
					}
				}
				SettingService.SetTwitterOauthVerifier(oauth_verifier);
				if (await TwitterService.GetAccessToken(oauth_token, oauth_verifier))
				{
					_viewModel.CheckButton();
					_viewModel.SharetoTwitter();
				}
			}
			else
			{
				_ = WebAuthenticationResult.ResponseStatus;
				_ = 2;
			}
		}
		catch (Exception)
		{
			Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"), showCancel: true, Utility.GetResourceString("IDS_CHATON_BODY_ERROR"));
		}
		finally
		{
			LoadingIndicator.StopLoading();
		}
	}

	internal void CloseAllPopup()
	{
		int count = ((ICollection<UIElement>)((Panel)LayoutRoot).Children).Count;
		for (int num = count - 1; num >= 0; num--)
		{
			UIElement val = ((IList<UIElement>)((Panel)LayoutRoot).Children)[num];
			if ((object)((object)val).GetType() == typeof(CustomPopup))
			{
				((ICollection<UIElement>)((Panel)LayoutRoot).Children).Remove(val);
			}
		}
	}

	private async void OnTwitClick(object sender, RoutedEventArgs e)
	{
		await TwitterService.PostMessage("@alysangadji test mention");
	}

	private async void OpenFacebookLogin()
	{
		try
		{
			string FacebookUrl = FacebookService.GetLoginUri().ToString();
			WebAuthenticationResult WebAuthenticationResult = await WebAuthenticationBroker.AuthenticateAsync((WebAuthenticationOptions)0, new Uri(FacebookUrl), new Uri(FacebookService.RedirectUri));
			if ((int)WebAuthenticationResult.ResponseStatus == 0)
			{
				if (!string.IsNullOrEmpty(WebAuthenticationResult.ResponseData.ToString()) && FacebookService.TryParseOAuthCallbackUri(new Uri(WebAuthenticationResult.ResponseData.ToString())))
				{
					if (FacebookService.OAuthResult.IsSuccess)
					{
						FacebookUser me = await FacebookService.GetMyInfomation();
						FacebookService.UserName = me.Name;
						SettingService.SetFacebookEmail(me.Name);
						SettingService.SetSignedOnToFacebook(isSignedOn: true);
						EmailFBText.put_Text(FacebookService.UserName);
						_viewModel.CheckButton();
						_viewModel.SharetoFacebook(me);
					}
					else
					{
						_viewModel.CheckButton();
					}
				}
			}
			else
			{
				_ = WebAuthenticationResult.ResponseStatus;
				_ = 2;
			}
		}
		catch (Exception)
		{
		}
	}

	private void OnFacebookSigninTapped(object sender, TappedRoutedEventArgs e)
	{
		OpenFacebookLogin();
	}

	private void OnSamsungAccountSigninTapped(object sender, TappedRoutedEventArgs e)
	{
		PageNavigationService.OpenSyncIntroPage((Page)(object)PivotPage.ActiveInstance);
	}

	private async void OnSingoutSamsungAccountTapped(object sender, TappedRoutedEventArgs e)
	{
		if (string.IsNullOrEmpty(RegistrationService.GetUserProfile().Email))
		{
			if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_BODY_DELETING_ACCOUNT_WILL_DELETE_ALL_DATA"), showCancel: true, Utility.GetResourceString("IDS_CHATON_BODY_DELETE_ACCOUNT")))
			{
				SettingsPage.ActiveInstance.ShowLoading();
				_ssmService.DeRegisterUserAsync();
			}
			return;
		}
		string msg = Utility.GetResourceString("IDS_CHATON_POP_ALL_YOUR_CHATON_DATA_WILL_BE_DELETED_FROM_ACCOUNT_C_PS");
		msg = msg.Replace("%s", RegistrationService.GetUserProfile().Email);
		if (await Utility.ShowOKCancleMessageDialog(msg, showCancel: true, Utility.GetResourceString("IDS_CHATON_BODY_DELETE_ACCOUNT")))
		{
			SettingsPage.ActiveInstance.ShowLoading();
			await _ssmService.DeRegisterUserAsync();
		}
	}

	private async void _ssmService_DeRegisterUserCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		try
		{
			bool isInvalidUser = false;
			if (!string.IsNullOrEmpty(e.ErrorMessage) && (e.ErrorMessage.Contains("CCS-00012") || e.ErrorMessage.Contains("CCS-00011")))
			{
				await SSMService.ShowCommonErrorMessage(e);
				isInvalidUser = true;
			}
			if (e.StatusCode == HttpStatusCode.OK || isInvalidUser)
			{
				Utility.UpdateMainTileCount(0);
				await Utility.ClearTileInformation();
				try
				{
					await ApplicationData.Current.ClearAsync();
				}
				catch (Exception)
				{
				}
				MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_APPLICATION_WILL_BE_CLOSED"));
				await dialog.ShowAsync();
				Application.Current.Exit();
			}
			else
			{
				SSMService.ShowCommonErrorMessage(e);
			}
		}
		catch (Exception)
		{
		}
	}

	private void OnFacebookSignoutTapped(object sender, TappedRoutedEventArgs e)
	{
		_viewModel.FacebookLogout();
	}

	private async void OnTwitterSignOutTapped(object sender, TappedRoutedEventArgs e)
	{
		if (!string.IsNullOrEmpty(_viewModel.TwitterName))
		{
			string msg = Utility.GetResourceString("IDS_S_BODY_DELETE_ACCOUNT_PS");
			msg = msg.Replace("% s", _viewModel.TwitterName);
			if (await Utility.ShowOKCancleMessageDialog(msg, showCancel: true, Utility.GetResourceString("IDS_CHATON_BODY_DELETE_ACCOUNT")))
			{
				_viewModel.TwitterLogout();
			}
		}
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
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///ManageAccountPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			StackSamsung = (StackPanel)((FrameworkElement)this).FindName("StackSamsung");
			StackFB = (StackPanel)((FrameworkElement)this).FindName("StackFB");
			StackTwitter = (StackPanel)((FrameworkElement)this).FindName("StackTwitter");
			EmailTwitterText = (TextBlock)((FrameworkElement)this).FindName("EmailTwitterText");
			EmailFBText = (TextBlock)((FrameworkElement)this).FindName("EmailFBText");
			EmailText = (TextBlock)((FrameworkElement)this).FindName("EmailText");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
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
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(OnTwitterSigninTapped));
			break;
		}
		case 2:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(OnTwitterSignOutTapped));
			break;
		}
		case 3:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(OnFacebookSigninTapped));
			break;
		}
		case 4:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(OnFacebookSignoutTapped));
			break;
		}
		case 5:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(OnSamsungAccountSigninTapped));
			break;
		}
		}
		_contentLoaded = true;
	}
}
