using System;
using System.Net;
using System.Xml.Linq;
using ChatOn.Infrastructure;
using ChatOn.Models;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Services;

public class RegistrationService
{
	private static string _chatOnID;

	public static string DefaultProfilePath = "profile.jpg";

	public static string ChatOnID
	{
		get
		{
			if (string.IsNullOrEmpty(_chatOnID))
			{
				_chatOnID = IsoSettingHelper.Get<string>("ChatONID", null);
			}
			if (string.IsNullOrEmpty(_chatOnID))
			{
				return GetUserNumber();
			}
			return _chatOnID;
		}
		set
		{
			_chatOnID = value;
			IsoSettingHelper.Set("ChatONID", value);
		}
	}

	public static string TempMSISDN
	{
		get
		{
			return IsoSettingHelper.Get<string>("TempMSISDN", null);
		}
		set
		{
			IsoSettingHelper.Set("TempMSISDN", value);
		}
	}

	public static string TempEmail
	{
		get
		{
			return IsoSettingHelper.Get<string>("TempEmail", null);
		}
		set
		{
			IsoSettingHelper.Set("TempEmail", value);
		}
	}

	public static string TempMcc
	{
		get
		{
			return IsoSettingHelper.Get<string>("TempMcc", null);
		}
		set
		{
			IsoSettingHelper.Set("TempMcc", value);
		}
	}

	public static UserProfile GetUserProfile()
	{
		UserProfile userProfile = new UserProfile();
		userProfile.Birthday = new DateTime(IsoSettingHelper.Get("profile.Birthday", 0L));
		userProfile.Name = IsoSettingHelper.Get("profile.Name", "");
		userProfile.PhoneNumber = IsoSettingHelper.Get("profile.PhoneNumber", "");
		userProfile.Status = IsoSettingHelper.Get("profile.Status", "");
		userProfile.ProfileImagePath = IsoSettingHelper.Get("profile.ProfileImagePath", "");
		userProfile.BirthdayDisplayType = IsoSettingHelper.Get("profile.BirthdayDisplayType", 2);
		userProfile.ShowYear = IsoSettingHelper.Get("profile.ShowYear", defaultValue: false);
		userProfile.Email = IsoSettingHelper.Get("profile.Email", "");
		userProfile.ImageStatus = IsoSettingHelper.Get("profile.ImageStatus", 0);
		userProfile.ProfileImageId = IsoSettingHelper.Get("profile.ProfileImageId", "");
		return userProfile;
	}

	public static void SaveUserProfile(UserProfile profile)
	{
		IsoSettingHelper.Set("profile.Birthday", profile.Birthday.Ticks);
		IsoSettingHelper.Set("profile.Name", profile.Name);
		IsoSettingHelper.Set("profile.PhoneNumber", profile.PhoneNumber);
		IsoSettingHelper.Set("profile.Status", profile.Status);
		IsoSettingHelper.Set("profile.ProfileImagePath", profile.ProfileImagePath);
		IsoSettingHelper.Set("profile.BirthdayDisplayType", profile.BirthdayDisplayType);
		IsoSettingHelper.Set("profile.ShowYear", profile.ShowYear);
		IsoSettingHelper.Set("profile.Email", profile.Email);
		IsoSettingHelper.Set("profile.ImageStatus", profile.ImageStatus);
		IsoSettingHelper.Set("profile.ProfileImageId", profile.ProfileImageId);
	}

	public static void SaveUserProfileImage(WriteableBitmap wb)
	{
		UserProfile userProfile = GetUserProfile();
		userProfile.ProfileImagePath = DefaultProfilePath;
		SaveUserProfile(userProfile);
		Utility.SaveToJpeg(userProfile.ProfileImagePath, wb, ((BitmapSource)wb).PixelWidth, ((BitmapSource)wb).PixelHeight);
	}

	public static void DeleteUserProfileImage()
	{
		UserProfile userProfile = GetUserProfile();
		userProfile.ProfileImagePath = "";
		SaveUserProfile(userProfile);
	}

	public static UserProfile ParseUserProfileFromXml(XElement xe)
	{
		string value = "";
		string status = "";
		string text = "";
		string email = "";
		int num = 2;
		int day = 1;
		int month = 1;
		int imageStatus = 2;
		foreach (XNode item in xe.Nodes())
		{
			XElement xElement = item as XElement;
			if (xElement.Name == "name")
			{
				value = xElement.Value;
			}
			else if (xElement.Name == "birthday")
			{
				text = xElement.Value;
				if (!string.IsNullOrEmpty(text))
				{
					string[] array = text.Split('-');
					if (array == null || array[0] == "0000")
					{
						text = "";
					}
					else if (array == null || array.Length == 2)
					{
						num = 1;
						month = int.Parse(array[0]);
						day = int.Parse(array[1]);
					}
					else
					{
						num = 0;
					}
				}
			}
			else if (xElement.Name == "status")
			{
				status = xElement.Value;
			}
			else if (xElement.Name == "samsungemail")
			{
				email = xElement.Value;
			}
			else if (xElement.Name == "imgstatus")
			{
				imageStatus = int.Parse(xElement.Value);
			}
		}
		UserProfile userProfile = GetUserProfile();
		if (!string.IsNullOrEmpty(text))
		{
			if (num == 0)
			{
				userProfile.Birthday = DateTime.Parse(text);
				userProfile.ShowYear = true;
			}
			else
			{
				userProfile.Birthday = new DateTime(2012, month, day);
				userProfile.ShowYear = false;
			}
		}
		userProfile.ImageStatus = imageStatus;
		userProfile.Status = status;
		userProfile.Name = WebUtility.HtmlDecode(value);
		userProfile.Email = email;
		userProfile.BirthdayDisplayType = num;
		return userProfile;
	}

	public static bool ParseCheckParam(XElement xe)
	{
		bool result = false;
		foreach (XNode item in xe.Nodes())
		{
			XElement xElement = item as XElement;
			if (xElement.Name == "exist_msisdn")
			{
				result = bool.Parse(xElement.Value);
			}
		}
		return result;
	}

	public static UserAccountInfo GetUserAccount()
	{
		UserAccountInfo userAccountInfo = new UserAccountInfo();
		userAccountInfo.ACSToken = IsoSettingHelper.Get<string>("account.ACSToken", null);
		userAccountInfo.CountryCode = IsoSettingHelper.Get<string>("account.CountryCode", null);
		userAccountInfo.IMEI = IsoSettingHelper.Get<string>("account.IMEI", null);
		userAccountInfo.IMSI = IsoSettingHelper.Get<string>("account.IMSI", null);
		userAccountInfo.Mcc = IsoSettingHelper.Get<string>("account.Mcc", null);
		userAccountInfo.PhoneNumberMCC = IsoSettingHelper.Get<string>("account.PhoneNumberMCC", null);
		userAccountInfo.Model = IsoSettingHelper.Get<string>("account.Model", null);
		userAccountInfo.MSISDN = IsoSettingHelper.Get<string>("account.MSISDN", null);
		userAccountInfo.Name = IsoSettingHelper.Get<string>("account.Name", null);
		userAccountInfo.PhoneNumber = IsoSettingHelper.Get<string>("account.PhoneNumber", null);
		userAccountInfo.SMSToken = IsoSettingHelper.Get<string>("account.SMSToken", null);
		userAccountInfo.Uid = IsoSettingHelper.Get<string>("account.Uid", null);
		userAccountInfo.ISO = IsoSettingHelper.Get<string>("account.ISO", null);
		userAccountInfo.Version = IsoSettingHelper.Get<string>("account.Version", null);
		return userAccountInfo;
	}

	public static string GetUserNumber()
	{
		UserAccountInfo userAccount = GetUserAccount();
		if (userAccount != null)
		{
			if (userAccount.MSISDN == null)
			{
				return "";
			}
			return userAccount.MSISDN;
		}
		return "";
	}

	public static string GetUserContryCode()
	{
		return GetUserAccount().CountryCode;
	}

	public static void SaveUID(string uid)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.Uid = uid;
		SaveUserAccount(userAccount);
		IsoSettingHelper.Set("UserUID", uid);
	}

	public static void SaveName(string name)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.Name = name;
		SaveUserAccount(userAccount);
	}

	public static void SaveMSISDN(string msisdn)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.MSISDN = msisdn;
		SaveUserAccount(userAccount);
	}

	public static void SaveSMSToken(string token)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.SMSToken = token;
		SaveUserAccount(userAccount);
	}

	public static void SaveACSToken(string token)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.ACSToken = token;
		SaveUserAccount(userAccount);
	}

	public static void RegisterAccount(string phoneNumber, string code, string phoneNumberMCC)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.PhoneNumber = phoneNumber;
		userAccount.CountryCode = code;
		userAccount.PhoneNumberMCC = phoneNumberMCC;
		SaveUserAccount(userAccount);
	}

	private static void SaveUserAccount(UserAccountInfo account)
	{
		IsoSettingHelper.Set("account.ACSToken", account.ACSToken);
		IsoSettingHelper.Set("account.CountryCode", account.CountryCode);
		IsoSettingHelper.Set("account.IMEI", account.IMEI);
		IsoSettingHelper.Set("account.IMSI", account.IMSI);
		IsoSettingHelper.Set("account.Mcc", account.Mcc);
		IsoSettingHelper.Set("account.PhoneNumberMCC", account.PhoneNumberMCC);
		IsoSettingHelper.Set("account.Model", account.Model);
		IsoSettingHelper.Set("account.MSISDN", account.MSISDN);
		IsoSettingHelper.Set("account.Name", account.Name);
		IsoSettingHelper.Set("account.PhoneNumber", account.PhoneNumber);
		IsoSettingHelper.Set("account.SMSToken", account.SMSToken);
		IsoSettingHelper.Set("account.Uid", account.Uid);
		IsoSettingHelper.Set("account.ISO", account.ISO);
		IsoSettingHelper.Set("account.Version", account.Version);
	}

	public static async void RegisterAccount(string mcc)
	{
		UserAccountInfo account = GetUserAccount();
		if (account == null)
		{
			account = new UserAccountInfo();
		}
		account.IMEI = await Utility.GetDeviceUniqueID();
		account.Mcc = mcc;
		account.IMSI = account.Mcc + "00";
		account.Model = Utility.GetDeviceName();
		account.Version = Utility.GetAssemblyVersion();
		SaveUserAccount(account);
		IsoSettingHelper.Set("UserIMEI", account.IMEI);
	}

	public static void SaveCountryCode(string code)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.CountryCode = code;
		SaveUserAccount(userAccount);
	}

	public static void SaveIsoCode(string iso)
	{
		UserAccountInfo userAccount = GetUserAccount();
		userAccount.ISO = iso;
		SaveUserAccount(userAccount);
	}
}
