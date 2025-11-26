using System;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using ChatON_WoA.InfraStructure;
using ChatOn.Infrastructure;
using ChatOn.Services;

namespace ChatON_WoA.Services;

public class TwitterService
{
	private const string _BOUNDARY_STRING = "MULTIPART-FORM-DATA-BOUNDARY";

	private const string _PREFIX = "--";

	private const string _NEWLINE = "\r\n";

	internal static OauthBase _oauthBase = new OauthBase();

	private static string _baseUrl = "https://api.twitter.com/1.1/";

	private static string _twitterUrl = "https://api.twitter.com/oauth/authorize";

	private static string _requestTokenUrl = "https://api.twitter.com/oauth/request_token";

	private static string _accessTokenUrl = "https://api.twitter.com/oauth/access_token";

	private static string _friendsListUrl = "http://api.twitter.com/1.1/friends/list.json?cursor={0}&screen_name={1}&skip_status=true&include_user_entities=false";

	private static string _friendsInfoUrl = "http://api.twitter.com/1.1/users/show.json?screen_name={0}";

	private static string _logoutUrl = "http://www.twitter.com/logout.php?next={0}&access_token={1}";

	private static string _scope = "read_friendlists,publish_stream";

	private static string _appId = "rD4dpEFBVOiglTTXNRkDw";

	private static string _appSecret = "pZVW1JerQKNwVSx3gq8ksFNI36bqJaEw8TZxFK1gN8";

	private static string _redirectUri = "http://www.chaton.com/";

	private static string _accessToken;

	public static string TwitterUrl => _twitterUrl;

	public static string RequestTokenUrl => _requestTokenUrl;

	public static string AccessTokenUrl => _accessTokenUrl;

	public static string Scope => _scope;

	public static string AppId => _appId;

	public static string AppSecret => _appSecret;

	public static string RedirectUri => _redirectUri;

	public static string AccessToken
	{
		get
		{
			_accessToken = SettingService.GetTwitterAccessToken();
			return _accessToken;
		}
		set
		{
			_accessToken = value;
			SettingService.SetTwitterAcessToken(_accessToken);
		}
	}

	public static string UserName { get; set; }

	public static string Oauth_Token { get; set; }

	public static string Oauth_Token_Secret { get; set; }

	public static async Task<TwitterUser> GetMyInformation()
	{
		string requestUri = string.Format(_friendsInfoUrl, new object[1] { SettingService.GetTwitterAccountName() });
		_ = string.Empty;
		try
		{
			return TwitterJsonSerializer.Deserialize<TwitterUser>(await OauthBase.GetTwitterApi(requestUri, AppId, AppSecret, SettingService.GetTwitterAccessToken(), SettingService.GetTwitterAccessTokenSecret(), SettingService.GetTwitterOauthVerifier()));
		}
		catch (Exception)
		{
		}
		return null;
	}

	public static async Task<TwitterFriends> GetFriendsList(string cursor)
	{
		string requestUri = string.Format(_friendsListUrl, new object[2]
		{
			cursor,
			SettingService.GetTwitterAccountName()
		});
		_ = string.Empty;
		try
		{
			return TwitterJsonSerializer.Deserialize<TwitterFriends>(await OauthBase.GetTwitterApi(requestUri, AppId, AppSecret, SettingService.GetTwitterAccessToken(), SettingService.GetTwitterAccessTokenSecret(), SettingService.GetTwitterOauthVerifier()));
		}
		catch (Exception)
		{
		}
		return null;
	}

	public static async Task<bool> PostMessage(string message)
	{
		string requestUri = string.Format("http://api.twitter.com/1.1/statuses/update.json?status=" + WebUtility.UrlEncode(message));
		string messageData = "status=" + WebUtility.UrlEncode(message);
		try
		{
			await OauthBase.PostTwitterApi(requestUri, messageData, AppId, AppSecret, SettingService.GetTwitterAccessToken(), SettingService.GetTwitterAccessTokenSecret(), SettingService.GetTwitterOauthVerifier());
			return true;
		}
		catch (Exception)
		{
			return false;
		}
	}

	public static async Task<bool> PostPhoto(string msg, byte[] photoData)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			string twitterUrl = "http://api.twitter.com/1.1/statuses/update_with_media.json";
			if (!(await OauthBase.PostImageTwitterApi(twitterUrl, msg, photoData, AppId, AppSecret, SettingService.GetTwitterAccessToken(), SettingService.GetTwitterAccessTokenSecret(), SettingService.GetTwitterOauthVerifier(), Utility.ComputeMD5(msg))).Contains("id_str"))
			{
				return false;
			}
			return true;
		}
		catch (Exception)
		{
			return false;
		}
	}

	private static byte[] BuildPostData(string message, byte[] photoData)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("--").Append(Utility.ComputeMD5(message)).Append("\r\n");
		stringBuilder.Append("Content-Disposition: form-data; name=\"status\"");
		stringBuilder.AppendLine();
		stringBuilder.AppendLine();
		stringBuilder.Append(message);
		stringBuilder.AppendLine();
		stringBuilder.Append("--").Append(Utility.ComputeMD5(message)).Append("\r\n");
		stringBuilder.Append("Content-Disposition: file; name=\"media[]\" filename=\"ChatONPhoto.png\"").AppendLine();
		stringBuilder.Append("Content-Type: image/jpeg").AppendLine().AppendLine();
		byte[] bytes = Encoding.UTF8.GetBytes(stringBuilder.ToString());
		byte[] bytes2 = Encoding.UTF8.GetBytes("\r\n" + "--" + "MULTIPART-FORM-DATA-BOUNDARY" + "--" + "\r\n");
		byte[] array = new byte[bytes.Length + photoData.Length + bytes2.Length];
		Buffer.BlockCopy(bytes, 0, array, 0, bytes.Length);
		Buffer.BlockCopy(photoData, 0, array, bytes.Length, photoData.Length);
		Buffer.BlockCopy(bytes2, 0, array, bytes.Length + photoData.Length, bytes2.Length);
		return array;
	}

	private static string buildSigRequestTokenParam()
	{
		string nonce = OauthBase.GetNonce();
		string text = Utility.GetTimeStamp().ToString();
		string text2 = "oauth_consumer_key=" + _appId;
		text2 = text2 + "&oauth_callback=" + RedirectUri;
		text2 = text2 + "&oauth_nonce=" + nonce;
		text2 += "&oauth_signature_method=HMAC-SHA1";
		text2 = text2 + "&oauth_timestamp=" + text;
		text2 += "&oauth_version=1.0";
		string text3 = "POST&";
		return text3 + Uri.EscapeDataString(RequestTokenUrl) + "&" + Uri.EscapeDataString(text2);
	}

	public static string GetLoginUri()
	{
		return TwitterUrl;
	}

	public static Uri GetAccessTokenUri(string code)
	{
		return new Uri(string.Format(_accessTokenUrl, new object[3] { _appId, _appSecret, code }), UriKind.Absolute);
	}

	public static Uri GetLogoutUri()
	{
		return new Uri(string.Format(_logoutUrl, new object[2] { _redirectUri, _accessToken }), UriKind.Absolute);
	}

	public static async Task<string> GetRequestToken()
	{
		string nonce = OauthBase.GetNonce();
		string timeStamp = OauthBase.GetTimeStamp();
		string sigBaseStringParams = "oauth_callback=" + WebUtility.UrlEncode(RedirectUri);
		sigBaseStringParams = sigBaseStringParams + "&oauth_consumer_key=" + AppId;
		sigBaseStringParams = sigBaseStringParams + "&oauth_nonce=" + nonce;
		sigBaseStringParams += "&oauth_signature_method=HMAC-SHA1";
		sigBaseStringParams = sigBaseStringParams + "&oauth_timestamp=" + timeStamp;
		sigBaseStringParams += "&oauth_version=1.0";
		string sigBaseString = "POST&";
		sigBaseString = sigBaseString + Uri.EscapeDataString(RequestTokenUrl) + "&" + Uri.EscapeDataString(sigBaseStringParams);
		string signature = OauthBase.GenerateSignature(sigBaseString, AppSecret);
		return await OauthBase.PostData(Data: "OAuth oauth_callback=\"" + WebUtility.UrlEncode(RedirectUri) + "\",oauth_consumer_key=\"" + WebUtility.UrlEncode(AppId) + "\",oauth_nonce=\"" + WebUtility.UrlEncode(nonce) + "\",oauth_signature=\"" + WebUtility.UrlEncode(signature) + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"" + WebUtility.UrlEncode(timeStamp) + "\",oauth_version=\"1.0\"", Url: RequestTokenUrl);
	}

	public static async Task<bool> GetAccessToken(string token, string verifier)
	{
		string nonce = OauthBase.GetNonce();
		string timeStamp = OauthBase.GetTimeStamp();
		string sigBaseStringParams = "oauth_consumer_key=" + AppId;
		sigBaseStringParams = sigBaseStringParams + "&oauth_nonce=" + nonce;
		sigBaseStringParams += "&oauth_signature_method=HMAC-SHA1";
		sigBaseStringParams = sigBaseStringParams + "&oauth_token=" + WebUtility.UrlEncode(token);
		sigBaseStringParams = sigBaseStringParams + "&oauth_verifier=" + WebUtility.UrlEncode(verifier);
		sigBaseStringParams = sigBaseStringParams + "&oauth_timestamp=" + timeStamp;
		sigBaseStringParams += "&oauth_version=1.0";
		string sigBaseString = "POST&";
		sigBaseString = sigBaseString + Uri.EscapeDataString(AccessTokenUrl) + "&" + Uri.EscapeDataString(sigBaseStringParams);
		string responseText = await OauthBase.OauthPostData(postData: sigBaseStringParams + "&oauth_signature=" + Uri.EscapeDataString(OauthBase.GenerateSignature(sigBaseString, AppSecret, Oauth_Token_Secret)), url: AccessTokenUrl);
		if (!string.IsNullOrEmpty(responseText))
		{
			string twitterAcessToken = null;
			string twitterAcessTokenSecret = null;
			string twitterAccountName = null;
			string[] array = responseText.Split('&');
			for (int i = 0; i < array.Length; i++)
			{
				string[] array2 = array[i].Split('=');
				switch (array2[0])
				{
				case "oauth_token":
					twitterAcessToken = array2[1];
					break;
				case "oauth_token_secret":
					twitterAcessTokenSecret = array2[1];
					break;
				case "screen_name":
					twitterAccountName = array2[1];
					break;
				}
			}
			SettingService.SetTwitterAcessToken(twitterAcessToken);
			SettingService.SetTwitterAcessTokenSecret(twitterAcessTokenSecret);
			SettingService.SetTwitterAccountName(twitterAccountName);
			SettingService.SetSignedOnTwitter(loggedinStatus: true);
			return true;
		}
		return false;
	}

	internal static async Task<string> GetTwitterLoginUrl()
	{
		string requestToken = await GetRequestToken();
		if (!string.IsNullOrEmpty(requestToken))
		{
			string text = null;
			string oauth_Token_Secret = null;
			string[] array = requestToken.Split('&');
			for (int i = 0; i < array.Length; i++)
			{
				string[] array2 = array[i].Split('=');
				switch (array2[0])
				{
				case "oauth_token":
					text = array2[1];
					break;
				case "oauth_token_secret":
					oauth_Token_Secret = array2[1];
					break;
				case "xoauth_request_auth_url":
					_ = array2[1];
					break;
				}
			}
			Oauth_Token = text;
			Oauth_Token_Secret = oauth_Token_Secret;
			return GetLoginUri() + "?oauth_token=" + text;
		}
		return null;
	}

	public static string GetRequestUrl()
	{
		string nonce = OauthBase.GetNonce();
		string timeStamp = OauthBase.GetTimeStamp();
		string text = "oauth_consumer_key=" + AppId;
		text = text + "&oauth_nonce=" + nonce;
		text += "&oauth_signature_method=HMAC-SHA1";
		text = text + "&oauth_timestamp=" + timeStamp;
		text += "&oauth_version=1.0";
		string text2 = "POST&";
		text2 = text2 + Uri.EscapeDataString(RequestTokenUrl) + "&" + Uri.EscapeDataString(text);
		string stringToEscape = OauthBase.GenerateSignature(text2, AppSecret);
		return RequestTokenUrl + text + "&oauth_signature=" + Uri.EscapeDataString(stringToEscape);
	}

	public static async Task<bool> Logout()
	{
		string requestUri = string.Format(_logoutUrl, new object[2] { _redirectUri, _accessToken });
		bool bResult = false;
		try
		{
			HttpWebRequest request = (HttpWebRequest)WebRequest.Create(requestUri);
			request.Method = "GET";
			HttpWebResponse httpWebResponse = (await request.GetResponseAsync()) as HttpWebResponse;
			HttpWebResponse response = httpWebResponse;
			bResult = response.StatusCode == HttpStatusCode.OK;
		}
		catch (Exception)
		{
		}
		return bResult;
	}
}
