using System;
using ChatON_WoA;
using ChatON_WoA.Views;
using ChatOn.ViewModels;
using Windows.UI.Core;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace ChatOn.Services;

public class PageNavigationService
{
	public enum LoginMode
	{
		SHARE,
		INVITATION,
		TELLFRIENDS
	}

	internal static void OpenChatChooserPage(Page page)
	{
	}

	internal static void OpenProfileImageViewerPage(Page page)
	{
	}

	internal static void OpenDisclaimerPage(Page page)
	{
	}

	internal static void OpenCalendarDetailPage(Page page, string vCalData)
	{
		StartNavigation(typeof(CalendarDetailPage), page, vCalData);
	}

	internal static void OpenTellFriendsFacebookPage(Page page)
	{
		StartNavigation(typeof(TellFriendsFacebookPage), page);
	}

	internal static void OpenTellFriendsTwitterPage(Page page)
	{
		StartNavigation(typeof(TellFriendsTwitterPage), page);
	}

	internal static void OpenPivotPage(Page page, string param = "")
	{
		string text = "/Views/PivotPage.xaml";
		text += param;
		StartNavigation(typeof(PivotPage), page);
	}

	internal static void OpenSplashScreen(Page page)
	{
		StartNavigation(typeof(SplashScreenPage), page);
	}

	internal static void OpenInputNamePage(Page page, string param)
	{
		StartNavigation(typeof(InputNamePage), page, param);
	}

	internal static void OpenSelectLanguagePage(Page page)
	{
		StartNavigation(typeof(SelectLanguagePage), page);
	}

	internal static void OpenSelectBuddyPage(Page page)
	{
	}

	internal static void OpenSettingPage(Page page, string param = null)
	{
		StartNavigation(typeof(SettingsPage), page, param);
	}

	internal static void OpenLoginOauthPage(string siteName, int mode, Page page)
	{
		string text = "/Views/SNSLoginPage.xaml";
		text = text + "?SITE=" + siteName;
		text = text + "&MODE=" + mode;
		StartNavigation(typeof(TellFriendsFacebookPage), page, text);
	}

	internal static void OpenInvitationPage(Page page, bool isFacebookAvailable)
	{
		StartNavigation(typeof(InvitationPage), page, isFacebookAvailable);
	}

	internal static void OpenInvitationTwitterPage(Page page, bool isTwitterAvailable)
	{
		StartNavigation(typeof(InvitationTwitterPage), page, isTwitterAvailable);
	}

	internal static void OpenInvitationTwitterPage(Page page, string friendName)
	{
		StartNavigation(typeof(InvitationTwitterPage), page, friendName);
	}

	internal static void OpenSNSLoginPage(string siteName, Page page)
	{
		if (siteName.ToLower().Equals("facebook"))
		{
			StartNavigation(typeof(TellFriendsFacebookPage), page, siteName);
		}
	}

	internal static void OpenContactDetailPage(Page page, string vCardInfo)
	{
		StartNavigation(typeof(ContactDetailPage), page, vCardInfo);
	}

	internal static void OpenTrunkDetailPage(TrunkItemParameter param)
	{
		//IL_000a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0015: Expected O, but got Unknown
		StartNavigation(typeof(TrunkDetailPage), new Page(), param);
	}

	internal static void OpenSyncIntroPage(Page page)
	{
		StartNavigation(typeof(SyncIntroPage), page);
	}

	private static void StartNavigation(Type destination, Page page, object parameter = null)
	{
		//IL_0033: Unknown result type (might be due to invalid IL or missing references)
		//IL_0039: Expected O, but got Unknown
		DispatchedHandler val = null;
		try
		{
			CoreDispatcher dispatcher = ((DependencyObject)page).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)delegate
				{
					page.Frame.Navigate(destination, parameter);
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		}
		catch (Exception)
		{
		}
	}
}
