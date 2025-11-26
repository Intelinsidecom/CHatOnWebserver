using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using ChatOn.Models;
using Windows.Foundation;
using Windows.Storage;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Services;

public class SettingService
{
	public enum ListByType
	{
		ByBuddies,
		ByInteraction
	}

	public static string CustomBGPath = "CustomBG.jpg";

	internal static int GetBGType()
	{
		int num = IsoSettingHelper.Get("BGType", 1);
		if (num > 5)
		{
			IsoSettingHelper.Set("BGType", 1);
			num = 1;
		}
		return num;
	}

	internal static async Task<BitmapImage> GetSelectedBG(bool isLandscape = false)
	{
		int index = GetBGType();
		if (index == 0)
		{
			string fileName = GetCustomBGFileName();
			if (string.IsNullOrEmpty(fileName))
			{
				index = 1;
				return LoadBGImage(index);
			}
			if (await Utility.IsFileExist(fileName) == null)
			{
				index = 1;
				return LoadBGImage(index);
			}
			return new BitmapImage(new Uri(relativeUri: ApplicationData.Current.LocalFolder.Path + "\\" + fileName, baseUri: new Uri("ms-appx://")));
		}
		return LoadBGImage(index);
	}

	private static BitmapImage LoadBGImage(int index)
	{
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0032: Expected O, but got Unknown
		string text = $"/Images/Background/chat_bg_{index:D2}.png";
		return new BitmapImage(new Uri("ms-appx://" + text));
	}

	internal static bool IsUsingCustomBG()
	{
		return IsoSettingHelper.Get("CustomBG", defaultValue: false);
	}

	internal static bool IsShowingBirthday()
	{
		return IsoSettingHelper.Get("ShowBirthday", defaultValue: true);
	}

	public static bool IsUsingPushNotification()
	{
		return IsoSettingHelper.Get("PushNotification", defaultValue: false);
	}

	public static bool IsUsingNewUpdatesPushNotification()
	{
		return IsoSettingHelper.Get("NewUpdatesPushNotification", defaultValue: false);
	}

	public static bool IsToggleNewUpdatesPushNotificationEnable()
	{
		return IsoSettingHelper.Get("ToggleNewUpdatesPushNotification", defaultValue: false);
	}

	public static bool IsUsingPushMarketingNotification()
	{
		return IsoSettingHelper.Get("PushMarketingNotification", defaultValue: false);
	}

	public static bool IsTogglePushMarketingNotificationEnable()
	{
		return IsoSettingHelper.Get("TogglePushMarketingNotification", defaultValue: false);
	}

	public static bool IsFirstRun()
	{
		return IsoSettingHelper.Get("FirstRun", defaultValue: true);
	}

	public static bool IsShowAddBuddyFromPeoplePopup()
	{
		return IsoSettingHelper.Get("ShowAddBuddyFromPeoplePopup", defaultValue: true);
	}

	public static bool IsAllowLocation()
	{
		return IsoSettingHelper.Get("AllowLocation", defaultValue: false);
	}

	internal static bool IsSignedOnToFacebook()
	{
		return IsoSettingHelper.Get("SignedOnToFacebook", defaultValue: false);
	}

	internal static int GetBubbleType()
	{
		int num = IsoSettingHelper.Get("BubbleType", 1);
		if (num > 5)
		{
			SetBubbleType(1);
			num = 1;
		}
		return num;
	}

	internal static int GetMyBubbleType()
	{
		return IsoSettingHelper.Get("MyBubbleType", 1);
	}

	public static int GetFontSizeType()
	{
		return IsoSettingHelper.Get("FontSizeType", 2);
	}

	public static double GetFontSize()
	{
		return GetFontSizeType() switch
		{
			0 => 14.0, 
			1 => 18.0, 
			2 => 22.0, 
			3 => 26.0, 
			4 => 58.0, 
			_ => 0.0, 
		};
	}

	public static int GetPictureSizeType()
	{
		return IsoSettingHelper.Get("PictureSizeType", 1);
	}

	public static Size GetPictureSize()
	{
		return GetPictureSizeType() switch
		{
			0 => new Size(640.0, 480.0), 
			1 => new Size(800.0, 600.0), 
			2 => new Size(1024.0, 768.0), 
			_ => new Size(0.0, 0.0), 
		};
	}

	public static ListByType GetListByType()
	{
		return IsoSettingHelper.Get("ListByType", ListByType.ByBuddies);
	}

	public static bool GetSendEnterKey()
	{
		return IsoSettingHelper.Get("SendEnterKey", defaultValue: true);
	}

	public static string GetPassword()
	{
		return IsoSettingHelper.Get("Password", "");
	}

	public static int GetPasswordHintType()
	{
		return IsoSettingHelper.Get("PasswordHintType", 0);
	}

	public static string GetPasswordHint()
	{
		return IsoSettingHelper.Get("PasswordHint", "");
	}

	public static bool GetCheckPassword()
	{
		return IsoSettingHelper.Get("CheckPassword", defaultValue: true);
	}

	public static bool GetShowSuggestions()
	{
		return IsoSettingHelper.Get("ShowSuggestions", defaultValue: true);
	}

	public static string GetProfileImageFileName()
	{
		return IsoSettingHelper.Get("ProfileImageFileName", "");
	}

	public static string GetPushChannelUri()
	{
		return IsoSettingHelper.Get("PushChannelUri", string.Empty);
	}

	public static string GetCustomBGFileName()
	{
		return IsoSettingHelper.Get("CustomBGFileName", "");
	}

	public static long GetCodeSentTime()
	{
		return IsoSettingHelper.Get("CodeSentTime", 0L);
	}

	public static string GetFacebookAccessToken()
	{
		return IsoSettingHelper.Get("FacebookAccessToken", string.Empty);
	}

	public static int GetSelectedIndex()
	{
		return IsoSettingHelper.Get("SelectedIndex", 0);
	}

	internal static void SetSelectedIndex(int index)
	{
		IsoSettingHelper.Set("SelectedIndex", index);
	}

	internal static void SetBGType(int index)
	{
		IsoSettingHelper.Set("BGType", index);
	}

	internal static void SetBubbleType(int index)
	{
		IsoSettingHelper.Set("BubbleType", index);
	}

	internal static void SetMyBubbleType(int index)
	{
		IsoSettingHelper.Set("MyBubbleType", index);
	}

	internal static void SetUsingCustomBG()
	{
		IsoSettingHelper.Set("CustomBG", true);
	}

	internal static void SetShowingBirthday(bool show)
	{
		IsoSettingHelper.Set("ShowBirthday", show);
	}

	public static void SetFontSizeType(int index)
	{
		IsoSettingHelper.Set("FontSizeType", index);
	}

	public static void SetListByType(ListByType type)
	{
		IsoSettingHelper.Set("ListByType", type);
	}

	public static void SetUsingPushNotification(bool isUsed)
	{
		IsoSettingHelper.Set("PushNotification", isUsed);
	}

	public static void SetUsingNewUpdatesPushNotification(bool isUsed)
	{
		IsoSettingHelper.Set("NewUpdatesPushNotification", isUsed);
	}

	public static void SetToggleNewUpdatesPushNotification(bool isUsed)
	{
		IsoSettingHelper.Set("ToggleNewUpdatesPushNotification", isUsed);
	}

	public static void SetUsingPushMarketingNotification(bool isUsed)
	{
		IsoSettingHelper.Set("PushMarketingNotification", isUsed);
	}

	public static void SetTogglePushMarketingNotification(bool isUsed)
	{
		IsoSettingHelper.Set("TogglePushMarketingNotification", isUsed);
	}

	public static void SetFirstRun(bool isFirst)
	{
		IsoSettingHelper.Set("FirstRun", isFirst);
	}

	public static void SetShowAddBuddyFromPeoplePopup(bool value)
	{
		IsoSettingHelper.Set("ShowAddBuddyFromPeoplePopup", value);
	}

	public static void SetAllowLocation(bool allow)
	{
		IsoSettingHelper.Set("AllowLocation", allow);
	}

	public static void SetSendEnterKey(bool value)
	{
		IsoSettingHelper.Set("SendEnterKey", value);
	}

	public static void SetPassword(string value)
	{
		IsoSettingHelper.Set("Password", value);
		SetCheckPassword(value: true);
	}

	public static void SetPictureSizeType(int value)
	{
		IsoSettingHelper.Set("PictureSizeType", value);
	}

	public static void SetPasswordHintType(int value)
	{
		IsoSettingHelper.Set("PasswordHintType", value);
	}

	public static void SetPasswordHint(string value)
	{
		IsoSettingHelper.Set("PasswordHint", value);
	}

	public static void SetCheckPassword(bool value)
	{
		IsoSettingHelper.Set("CheckPassword", value);
	}

	public static void SetShowSuggestions(bool allow)
	{
		IsoSettingHelper.Set("ShowSuggestions", allow);
	}

	public static void SetProfileImageFileName(string fileName)
	{
		IsoSettingHelper.Set("ProfileImageFileName", fileName);
	}

	public static void SetPushChannelUri(string uri)
	{
		IsoSettingHelper.Set("PushChannelUri", uri);
	}

	public static void SetCustomBGFileName(string fileName)
	{
		IsoSettingHelper.Set("CustomBGFileName", fileName);
	}

	public static void SetCodeSentTime(long time)
	{
		IsoSettingHelper.Set("CodeSentTime", time);
	}

	public static void SetFacebookAcessToken(string accessToken)
	{
		IsoSettingHelper.Set("FacebookAccessToken", accessToken);
	}

	internal static void SetSignedOnToFacebook(bool isSignedOn)
	{
		IsoSettingHelper.Set("SignedOnToFacebook", isSignedOn);
	}

	public static string GetSamsungAccountAccessToken()
	{
		return IsoSettingHelper.Get("SamsungAccountAccessToken", string.Empty);
	}

	public static void SetSamsungAccountAcessToken(string accessToken)
	{
		IsoSettingHelper.Set("SamsungAccountAccessToken", accessToken);
	}

	public static bool GetSignedOnSamsungAccount()
	{
		return IsoSettingHelper.Get("SignedOntoSamsungAccount", defaultValue: false);
	}

	public static void SetSignedOnSamsungAccount(bool loggedinStatus)
	{
		IsoSettingHelper.Set("SignedOntoSamsungAccount", loggedinStatus);
	}

	public static string GetSamsungEmail()
	{
		return IsoSettingHelper.Get("SamsungAccountEmail", "");
	}

	public static void SetSamsungEmail(string samsungEmail)
	{
		IsoSettingHelper.Set("SamsungAccountEmail", samsungEmail);
	}

	public static string GetTwitterAccessToken()
	{
		return IsoSettingHelper.Get("TwitterAccessToken", string.Empty);
	}

	public static void SetTwitterAcessToken(string accessToken)
	{
		IsoSettingHelper.Set("TwitterAccessToken", accessToken);
	}

	public static string GetTwitterAccessTokenSecret()
	{
		return IsoSettingHelper.Get("TwitterAccessTokenSecret", string.Empty);
	}

	public static void SetTwitterAcessTokenSecret(string accessToken)
	{
		IsoSettingHelper.Set("TwitterAccessTokenSecret", accessToken);
	}

	public static bool GetSignedOnTwitter()
	{
		return IsoSettingHelper.Get("SignedOntoTwitter", defaultValue: false);
	}

	public static void SetSignedOnTwitter(bool loggedinStatus)
	{
		IsoSettingHelper.Set("SignedOntoTwitter", loggedinStatus);
	}

	public static string GetFacebookEmail()
	{
		return IsoSettingHelper.Get("FacebookAccountEmail", "");
	}

	public static void SetFacebookEmail(string facebookEmail)
	{
		IsoSettingHelper.Set("FacebookAccountEmail", facebookEmail);
	}

	public static string GetTwitterAccountName()
	{
		return IsoSettingHelper.Get("TwitterAccountName", "");
	}

	public static void SetTwitterAccountName(string twitterUsername)
	{
		IsoSettingHelper.Set("TwitterAccountName", twitterUsername);
	}

	public static string GetTwitterOauthVerifier()
	{
		return IsoSettingHelper.Get("TwitterOauthVerifier", "");
	}

	public static void SetTwitterOauthVerifier(string oauthVerifier)
	{
		IsoSettingHelper.Set("TwitterOauthVerifier", oauthVerifier);
	}

	public static int GetDatabaseVersion()
	{
		return IsoSettingHelper.Get("DatabaseVersion", 0);
	}

	public static void SetDatabaseVersion(int databaseVersion)
	{
		IsoSettingHelper.Set("DatabaseVersion", databaseVersion);
	}

	public static void SetRecentAnicons(List<Anicon> list)
	{
		string text = "";
		foreach (Anicon item in list)
		{
			text = text + "," + item.ID;
		}
		IsoSettingHelper.Set("RecentAnicons", text);
	}

	public static void SetHadShownUpdate(bool option)
	{
		IsoSettingHelper.Set("HadShownUpdate", option);
	}

	public static bool GetHadShownUpdate()
	{
		return IsoSettingHelper.Get("HadShownUpdate", defaultValue: false);
	}

	public static void SetFirstTimeBuddySyncFinished(bool option)
	{
		IsoSettingHelper.Set("FirstTimeBuddySyncFinished", option);
	}

	public static bool IsFirstTimeBuddySyncFinished()
	{
		return IsoSettingHelper.Get("FirstTimeBuddySyncFinished", defaultValue: false);
	}
}
