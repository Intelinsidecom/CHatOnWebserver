using System;
using System.Windows.Media.Imaging;
using System.Xml.Linq;
using ChatOn.Infrastructure;
using ChatOn.Models;

namespace ChatOn.Services;

public class RegistrationService
{
	public static string DefaultProfilePath = "Cache\\profile.jpg";

	public static UserProfile GetUserProfile()
	{
		UserProfile userProfile = IsoSettingHelper.Get<UserProfile>("UserProfile", null);
		if (userProfile == null)
		{
			userProfile = new UserProfile();
		}
		return userProfile;
	}

	public static void SaveUserProfile(UserProfile profile)
	{
		IsoSettingHelper.Set("UserProfile", profile);
	}

	public static void SaveUserProfileImage(WriteableBitmap wb)
	{
		UserProfile userProfile = GetUserProfile();
		userProfile.ProfileImagePath = DefaultProfilePath;
		SaveUserProfile(userProfile);
		Utility.SaveToJpeg(userProfile.ProfileImagePath, wb, wb.PixelWidth, wb.PixelHeight);
	}

	public static void DeleteUserProfileImage()
	{
		UserProfile userProfile = GetUserProfile();
		userProfile.ProfileImagePath = "";
		SaveUserProfile(userProfile);
	}

	public static UserProfile ParseUserProfileFromXml(XElement xe)
	{
		string name = "";
		string status = "";
		string text = "";
		foreach (XNode item in xe.Nodes())
		{
			XElement xElement = item as XElement;
			if (xElement.Name == "name")
			{
				name = xElement.Value;
			}
			else if (xElement.Name == "birthday")
			{
				text = xElement.Value;
			}
			else if (xElement.Name == "status")
			{
				status = xElement.Value;
			}
		}
		UserProfile userProfile = new UserProfile();
		if (!string.IsNullOrEmpty(text))
		{
			userProfile.Birthday = DateTime.Parse(text);
		}
		userProfile.Status = status;
		userProfile.Name = name;
		return userProfile;
	}

	public static UserAccountInfo GetUserAccount()
	{
		return IsoSettingHelper.Get<UserAccountInfo>("UserAccount", null);
	}

	public static string GetUserNumber()
	{
		UserAccountInfo userAccount = GetUserAccount();
		if (userAccount == null)
		{
			return "";
		}
		return userAccount.MSISDN;
	}

	public static string GetUserContryCode()
	{
		return GetUserAccount().CountryCode;
	}

	public static void SaveUID(string uid)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.Uid = uid;
		IsoSettingHelper.Set("UserAccount", userAccount);
		IsoSettingHelper.Set("UserUID", uid);
	}

	public static void SaveName(string name)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.Name = name;
		IsoSettingHelper.Set("UserAccount", userAccount);
	}

	public static void SaveMSISDN(string msisdn)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.MSISDN = msisdn;
		IsoSettingHelper.Set("UserAccount", userAccount);
	}

	public static void SaveSMSToken(string token)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.SMSToken = token;
		IsoSettingHelper.Set("UserAccount", userAccount);
	}

	public static void SaveACSToken(string token)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.ACSToken = token;
		IsoSettingHelper.Set("UserAccount", userAccount);
	}

	public static void RegisterAccount(string phoneNumber, string code)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.PhoneNumber = phoneNumber;
		userAccount.CountryCode = code;
		IsoSettingHelper.Set("UserAccount", userAccount);
	}

	public static void RegisterAccount(string mcc)
	{
		UserAccountInfo userAccountInfo = GetUserAccount();
		if (userAccountInfo == null)
		{
			userAccountInfo = new UserAccountInfo();
		}
		userAccountInfo.IMEI = Utility.GetDeviceUniqueID();
		userAccountInfo.Mcc = mcc;
		userAccountInfo.IMSI = userAccountInfo.Mcc + "00";
		userAccountInfo.Model = Utility.GetDeviceName();
		userAccountInfo.Version = Utility.GetAssemblyVersion();
		IsoSettingHelper.Set("UserAccount", userAccountInfo);
		IsoSettingHelper.Set("UserIMEI", userAccountInfo.IMEI);
	}
}
