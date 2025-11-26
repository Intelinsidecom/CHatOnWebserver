using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Xml.Linq;
using ChatON_WoA.Services;
using ChatOn.Infrastructure;
using ChatOn.Services;
using ChatOn.ViewModels;

namespace ChatOn_WoA.Services;

internal class SamsungAccountService
{
	private const string CLIENT_ID = "p62020g0mz";

	private const string CLIENT_SECRET = "D5CABF6A10CB9F63C030E48EB7C7A8E0";

	private const string SignUpUrl = "https://account.samsung.com/mobile/account/check.do?serviceID={0}&actionID=SignupAP&countryCode={1}&languageCode={2}";

	private const string SignInUrl = "https://account.samsung.com/mobile/account/check.do?serviceID={0}&actionID=StartOAuth2&countryCode={1}&languageCode={2}&returnType=url";

	private const string AccessTokenUrl = "https://auth.samsungosp.com/auth/oauth2/token?grant_type={0}&code={1}&client_id={2}&client_secret={3}";

	private static string _userID;

	public static string AccessToken
	{
		get
		{
			return SettingService.GetSamsungAccountAccessToken();
		}
		set
		{
			SettingService.SetSamsungAccountAcessToken(value);
		}
	}

	public static string UserID
	{
		get
		{
			return _userID;
		}
		set
		{
			_userID = value;
		}
	}

	public static string LanguageCode => CultureInfo.CurrentUICulture.TwoLetterISOLanguageName;

	public string GetSignUpUrl()
	{
		Utility.Split(CultureInfo.CurrentUICulture.Name, '-');
		string text = "";
		string twoLetterISOLanguageName = CultureInfo.CurrentUICulture.TwoLetterISOLanguageName;
		string twoLetterISORegionName = RegionInfo.CurrentRegion.TwoLetterISORegionName;
		return string.Format("https://account.samsung.com/mobile/account/check.do?serviceID={0}&actionID=SignupAP&countryCode={1}&languageCode={2}", new object[3] { "p62020g0mz", twoLetterISORegionName, twoLetterISOLanguageName });
	}

	public string GetSignInUrl()
	{
		Utility.Split(CultureInfo.CurrentUICulture.TextInfo.CultureName, '-');
		string text = "";
		string twoLetterISOLanguageName = CultureInfo.CurrentUICulture.TwoLetterISOLanguageName;
		string twoLetterISORegionName = RegionInfo.CurrentRegion.TwoLetterISORegionName;
		return string.Format("https://account.samsung.com/mobile/account/check.do?serviceID={0}&actionID=StartOAuth2&countryCode={1}&languageCode={2}&returnType=url", new object[3] { "p62020g0mz", twoLetterISORegionName, twoLetterISOLanguageName });
	}

	public async Task<SamsungAccountServiceResult> GetAccessToken(string authorizationCode)
	{
		SamsungAccountServiceResult result = null;
		string requestUrl = string.Format("https://auth.samsungosp.com/auth/oauth2/token?grant_type={0}&code={1}&client_id={2}&client_secret={3}", "authorization_code", authorizationCode, "p62020g0mz", "D5CABF6A10CB9F63C030E48EB7C7A8E0");
		HttpWebRequest request = (HttpWebRequest)WebRequest.Create(requestUrl);
		request.Method = "POST";
		request.ContentType = "application/json";
		HttpWebResponse response = null;
		await Task.Run(delegate
		{
			ManualResetEvent allDone = new ManualResetEvent(initialState: false);
			request.BeginGetResponse(delegate(IAsyncResult r)
			{
				try
				{
					response = (HttpWebResponse)request.EndGetResponse(r);
					Stream responseStream = response.GetResponseStream();
					StreamReader streamReader = new StreamReader(responseStream);
					SerializerData.AccessTokenRePonseData accessTokenRePonseData = JsonSerializer.Deserialize<SerializerData.AccessTokenRePonseData>(streamReader.ReadToEnd());
					UserID = accessTokenRePonseData.userId;
					AccessToken = accessTokenRePonseData.access_token;
					result = new SamsungAccountServiceResult(accessTokenRePonseData.access_token);
					result.ResultType = SamsungAccountServiceResultType.SUCCESS;
				}
				catch (WebException)
				{
					result = new SamsungAccountServiceResult("");
					result.ResultType = SamsungAccountServiceResultType.NETWORK_ERROR;
				}
				allDone.Set();
			}, request);
			allDone.WaitOne();
		});
		return result;
	}

	public async Task<SamsungAccountServiceResult> GetUserEmail()
	{
		SamsungAccountServiceResult result = null;
		string requestUrl = $"http://api.samsungosp.net/v2/profile/user/user/{UserID}";
		HttpWebRequest request = (HttpWebRequest)WebRequest.Create(requestUrl);
		request.Method = "GET";
		request.Headers["x-osp-appId"] = "p62020g0mz";
		request.Headers["x-osp-userId"] = UserID;
		string str = "p62020g0mz:D5CABF6A10CB9F63C030E48EB7C7A8E0";
		byte[] base64Bytes = Encoding.Unicode.GetBytes(str);
		str = Convert.ToBase64String(base64Bytes);
		request.Headers["Authorization"] = "Basic " + str;
		await Task.Run(delegate
		{
			ManualResetEvent allDone = new ManualResetEvent(initialState: false);
			request.BeginGetResponse(delegate(IAsyncResult r)
			{
				try
				{
					HttpWebResponse httpWebResponse = (HttpWebResponse)request.EndGetResponse(r);
					Stream responseStream = httpWebResponse.GetResponseStream();
					using StreamReader streamReader = new StreamReader(responseStream);
					XElement xElement = XElement.Load(new StringReader(streamReader.ReadToEnd()));
					IEnumerable<XElement> enumerable = from item in xElement.Descendants("loginID")
						select (item);
					string isoCode = (from item in xElement.Descendants("countryCode")
						select (item)).First().Value;
					if (enumerable != null && isoCode != null)
					{
						if (SelectCountryCodePageViewModel.CodeData.Where((CountryCode x) => Utility.GetIsoCodeFromCountryName(x.Name) == isoCode).Count() == 0)
						{
							result = new SamsungAccountServiceResult(enumerable.First().Value);
							result.ResultType = SamsungAccountServiceResultType.NOT_ALLOWED_COUNTRY;
						}
						else
						{
							CountryCode countryCode = SelectCountryCodePageViewModel.CodeData.FirstOrDefault((CountryCode x) => Utility.GetIsoCodeFromCountryName(x.Name) == isoCode);
							if (countryCode != null)
							{
								RegistrationService.TempMcc = countryCode.MCC;
							}
							else
							{
								RegistrationService.TempMcc = "450";
							}
							result = new SamsungAccountServiceResult(enumerable.First().Value);
							result.ResultType = SamsungAccountServiceResultType.SUCCESS;
							RegistrationService.TempEmail = enumerable.First().Value;
							RegistrationService.SaveIsoCode(isoCode);
						}
					}
					else
					{
						result = new SamsungAccountServiceResult("");
						result.ResultType = SamsungAccountServiceResultType.NO_RESULT;
					}
				}
				catch (WebException)
				{
				}
				allDone.Set();
			}, request);
			allDone.WaitOne();
		});
		return result;
	}
}
