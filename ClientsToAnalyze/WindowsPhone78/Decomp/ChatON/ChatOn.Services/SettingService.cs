using System;
using System.Windows.Media.Imaging;
using ChatOn.Infrastructure;

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
		return IsoSettingHelper.Get("BGType", 1);
	}

	internal static BitmapImage GetSelectedBG(bool isLandscape = false)
	{
		int bGType = GetBGType();
		if (bGType == 0)
		{
			return Utility.LoadJpeg(CustomBGPath);
		}
		if (isLandscape)
		{
			string uriString = $"\\Images\\ChatBGs\\chat_bg_l_{bGType:D2}.png";
			return new BitmapImage(new Uri(uriString, UriKind.Relative));
		}
		string uriString2 = $"\\Images\\ChatBGs\\chat_bg_{bGType:D2}.png";
		return new BitmapImage(new Uri(uriString2, UriKind.Relative));
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

	public static bool IsFirstRun()
	{
		return IsoSettingHelper.Get("FirstRun", defaultValue: true);
	}

	public static bool IsAllowLocation()
	{
		return IsoSettingHelper.Get("AllowLocation", defaultValue: false);
	}

	internal static int GetBubbleType()
	{
		return IsoSettingHelper.Get("BubbleType", 1);
	}

	public static int GetFontSizeType()
	{
		return IsoSettingHelper.Get("FontSizeType", 2);
	}

	public static int GetFontSize()
	{
		int fontSizeType = GetFontSizeType();
		int num = 24;
		return fontSizeType switch
		{
			0 => num / 2, 
			1 => num * 7 / 10, 
			2 => num, 
			3 => num * 3 / 2, 
			4 => num * 2, 
			_ => 0, 
		};
	}

	public static ListByType GetListByType()
	{
		return IsoSettingHelper.Get("ListByType", ListByType.ByBuddies);
	}

	internal static void SetBGType(int index)
	{
		IsoSettingHelper.Set("BGType", index);
	}

	internal static void SetBubbleType(int index)
	{
		IsoSettingHelper.Set("BubbleType", index);
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

	public static void SetFirstRun(bool isFirst)
	{
		IsoSettingHelper.Set("FirstRun", isFirst);
	}

	public static void SetAllowLocation(bool allow)
	{
		IsoSettingHelper.Set("AllowLocation", allow);
	}
}
