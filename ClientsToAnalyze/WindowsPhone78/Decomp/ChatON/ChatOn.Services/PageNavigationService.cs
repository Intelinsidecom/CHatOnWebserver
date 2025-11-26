using System;
using System.Windows.Controls;
using ChatOn.Models;
using Microsoft.Phone.Controls;

namespace ChatOn.Services;

public class PageNavigationService
{
	internal static void OpenMainPage(PhoneApplicationPage page)
	{
		string destination = "/Views/MainPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenChatTextViewer(PhoneApplicationPage page, string id)
	{
		string text = "/Views/ChatTextViewer.xaml";
		text = text + "?ID=" + id;
		StartNavigation(text, page);
	}

	internal static void OpenAllowLocationPage(PhoneApplicationPage page)
	{
		string destination = "/Views/AllowLocationPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenChatChooserPage(PhoneApplicationPage page)
	{
		string destination = "/Views/ChatChooserPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenProfileImageViewerPage(PhoneApplicationPage page)
	{
		string destination = "/Views/ProfileImageViewerPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenDisclaimerPage(PhoneApplicationPage page)
	{
		string destination = "/Views/DisclaimerPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenSkinSettingPage(PhoneApplicationPage page)
	{
		string destination = "/Views/SkinSettingPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenFontSettingPage(PhoneApplicationPage page)
	{
		string destination = "/Views/FontSettingPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenAddBuddyPage(PhoneApplicationPage page)
	{
		string destination = "/Views/AddBuddyPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenChatDetailPage(Chat chat, PhoneApplicationPage page)
	{
		string text = "/Views/ChatDetailPage.xaml";
		text = text + "?ID=" + chat.ChatID;
		StartNavigation(text, page);
	}

	internal static void OpenChatProfilePage(Chat chat, PhoneApplicationPage page)
	{
		string text = "/Views/ChatProfilePage.xaml";
		text = text + "?ID=" + chat.ChatID;
		StartNavigation(text, page);
	}

	internal static void OpenTrunkItemList(Chat chat, PhoneApplicationPage page)
	{
		string text = "/Views/TrunkItemListPage.xaml";
		text = text + "?ID=" + chat.ChatID;
		StartNavigation(text, page);
	}

	internal static void OpenTrunkItem(TrunkItem item, Chat chat, PhoneApplicationPage page)
	{
		string text = "/Views/TrunkItemPage.xaml";
		text = text + "?itemID=" + item.TrunkItemID;
		text = text + "&ID=" + chat.ChatID;
		StartNavigation(text, page);
	}

	internal static void OpenTrunkSort(PhoneApplicationPage page)
	{
		string destination = "/Views/TrunkSortPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenTrunkComment(TrunkItem item, Chat chat, PhoneApplicationPage page)
	{
		string text = "/Views/TrunkCommentPage.xaml";
		text = text + "?itemID=" + item.TrunkItemID;
		text = text + "&ID=" + chat.ChatID;
		StartNavigation(text, page);
	}

	internal static void OpenAttachListPage(PhoneApplicationPage page)
	{
		string destination = "/Views/AttachListPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenAttachLocationPage(PhoneApplicationPage page)
	{
		string destination = "/Views/AttachLocationPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenAttachCalendarPage(PhoneApplicationPage page)
	{
		string destination = "/Views/AttachCalendarPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenAttachCalendarDetailPage(PhoneApplicationPage page, string filePath)
	{
		string text = "/Views/AttachCalendarDetailPage.xaml";
		text = text + "?filePath=" + filePath;
		StartNavigation(text, page);
	}

	internal static void OpenGroupProfilePage(PhoneApplicationPage page, string id)
	{
		string text = "/Views/GroupProfilePage.xaml";
		text = text + "?ID=" + id;
		StartNavigation(text, page);
	}

	internal static void OpenTellFriendsPage(PhoneApplicationPage page)
	{
		string destination = "/Views/TellFriendsPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenAMSPage(PhoneApplicationPage page)
	{
		string destination = "/AnimationMessage/Views/AMSHomePage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenAMSPreviewPage(PhoneApplicationPage page, string filePath, bool autoPlay)
	{
		string text = "/AnimationMessage/Views/AMSPreview.xaml";
		text = text + "?MessagePath=" + filePath;
		if (autoPlay)
		{
			text += "&AutoPlay=true";
		}
		StartNavigation(text, page);
	}

	internal static void OpenPivotPage(PhoneApplicationPage page, string param = "")
	{
		string text = "/Views/PivotPage.xaml";
		text += param;
		StartNavigation(text, page);
	}

	internal static void OpenInputPhoneNumberPage(PhoneApplicationPage page)
	{
		string destination = "/Views/InputPhoneNumberPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenInputVerificationCodePage(PhoneApplicationPage page, string amsOption)
	{
		string text = "/Views/InputVerificationCodePage.xaml";
		if (!string.IsNullOrEmpty(amsOption))
		{
			text = text + "?ACS=" + amsOption;
		}
		StartNavigation(text, page);
	}

	internal static void OpenSelectACSOptionPage(PhoneApplicationPage page)
	{
		string destination = "/Views/SelectACSOptionPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenInputNamePage(PhoneApplicationPage page)
	{
		string destination = "/Views/InputNamePage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenAddUnknownBuddyPage(PhoneApplicationPage page, string phoneNumber)
	{
		string text = "/Views/AddUnknownBuddyPage.xaml";
		text = text + "?PhoneNumber=" + phoneNumber;
		StartNavigation(text, page);
	}

	internal static void OpenSelectCountryCodePage(PhoneApplicationPage page, bool isLanguage)
	{
		string text = "/Views/SelectCountryCodePage.xaml";
		if (isLanguage)
		{
			text += "?language=true";
		}
		StartNavigation(text, page);
	}

	internal static void OpenSelectLanguagePage(PhoneApplicationPage page)
	{
		string destination = "/Views/SelectLanguagePage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenInteractionRankPage(PhoneApplicationPage page)
	{
		string destination = "/Views/InteractionRankPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenAddBirthdayPage(PhoneApplicationPage page)
	{
		string destination = "/Views/AddBirthdayPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenSelectBuddyPage(PhoneApplicationPage page)
	{
		string destination = "/Views/SelectBuddyPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenSettingPage(PhoneApplicationPage page)
	{
		string destination = "/Views/SettingPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenBlockListPage(PhoneApplicationPage page)
	{
		string destination = "/Views/BlockListPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenInteractionHideListPage(PhoneApplicationPage page)
	{
		string destination = "/Views/InteractionHideListPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenHelpPage(PhoneApplicationPage page)
	{
		string destination = "/Views/HelpPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenAboutPage(PhoneApplicationPage page)
	{
		string destination = "/Views/AboutPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenEditGroupPage(PhoneApplicationPage page)
	{
		string destination = "/Views/EditGroupPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenAddGroupPage(PhoneApplicationPage page, string id = "")
	{
		string text = "/Views/AddGroupPage.xaml";
		if (!string.IsNullOrEmpty(id))
		{
			text = text + "?ID=" + id;
		}
		StartNavigation(text, page);
	}

	internal static void OpenShowPhoneNumberSettingPage(PhoneApplicationPage page)
	{
		string destination = "/Views/ShowPhoneNumberSettingPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenProfileEditPage(PhoneApplicationPage page)
	{
		string destination = "/Views/ProfileEditPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenAddTextProfileInfoPage(PhoneApplicationPage page, string param)
	{
		string text = "/Views/AddTextProfileInfoPage.xaml";
		text = text + "?Param=" + param;
		StartNavigation(text, page);
	}

	internal static void OpenAddCommentPage(PhoneApplicationPage page, string phoneNumber)
	{
		string text = "/Views/AddCommentPage.xaml";
		text = text + "?PhoneNumber=" + phoneNumber;
		StartNavigation(text, page);
	}

	internal static void OpenBuddyProfilePage(PhoneApplicationPage page, string phoneNumber)
	{
		string text = "/Views/BuddyProfilePage.xaml";
		text = text + "?PhoneNumber=" + phoneNumber;
		StartNavigation(text, page);
	}

	internal static void OpenMediaPlayerPage(PhoneApplicationPage page, string param)
	{
		string text = "/Views/MediaPlayerPage.xaml";
		text = text + "?source=" + param;
		StartNavigation(text, page);
	}

	internal static void OpenImageViewerPage(PhoneApplicationPage page, string param)
	{
		string text = "/Views/ImageViewerPage.xaml";
		text += param;
		StartNavigation(text, page);
	}

	internal static void OpenSearchBuddyPage(PhoneApplicationPage page)
	{
		string destination = "/Views/SearchBuddyPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenImageCropPage(PhoneApplicationPage page, int fixedRatioWidth = 0, int fixedRatioHeight = 0, bool isStretch = false)
	{
		string text = "/Views/ImageCropPage.xaml";
		if (fixedRatioWidth > 0)
		{
			object obj = text;
			text = string.Concat(obj, "?width=", fixedRatioWidth, "&height=", fixedRatioHeight);
		}
		if (isStretch)
		{
			text += "&stretch=true";
		}
		StartNavigation(text, page);
	}

	internal static void OpenLoginPage(string siteName, PhoneApplicationPage page)
	{
		string text = "/Views/LoginPage.xaml";
		text = text + "?SITE=" + siteName;
		StartNavigation(text, page);
	}

	internal static void OpenLoginOauthPage(string siteName, int mode, PhoneApplicationPage page)
	{
		string text = "/Views/LoginOauthPage.xaml";
		text = text + "?SITE=" + siteName;
		text = text + "&MODE=" + mode;
		StartNavigation(text, page);
	}

	internal static void OpenShareDetailPage(PhoneApplicationPage page)
	{
		string destination = "/Views/ShareDetailPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenShareListPage(PhoneApplicationPage page)
	{
		string destination = "/Views/ShareListPage.xaml";
		StartNavigation(destination, page);
	}

	internal static void OpenWebBrowsingPage(PhoneApplicationPage page, string address, string path)
	{
		string text = "/views/WebBrowsingPage.xaml";
		text = text + "?httpAddress=" + address;
		text = text + "&filePath=" + path;
		StartNavigation(text, page);
	}

	internal static void OpenInvitationPage(string siteName, int mode, PhoneApplicationPage page)
	{
		string text = "/views/InvitationPage.xaml";
		text = text + "?SITE=" + siteName;
		text = text + "&MODE=" + mode;
		StartNavigation(text, page);
	}

	internal static void OpenSNSAccountPage(string siteName, PhoneApplicationPage page)
	{
		string text = "/views/SNSAccountPage.xaml";
		text = text + "?SITE=" + siteName;
		StartNavigation(text, page);
	}

	private static void StartNavigation(string destination, PhoneApplicationPage page)
	{
		try
		{
			((Page)page).NavigationService.Navigate(new Uri(destination, UriKind.Relative));
		}
		catch (Exception)
		{
		}
	}
}
