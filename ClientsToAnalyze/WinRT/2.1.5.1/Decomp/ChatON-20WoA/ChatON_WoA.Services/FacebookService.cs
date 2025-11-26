using System;
using System.IO;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using ChatOn.Services;

namespace ChatON_WoA.Services;

internal class FacebookService
{
	private const string _BOUNDARY_STRING = "MULTIPART-FORM-DATA-BOUNDARY";

	private const string _PREFIX = "--";

	private const string _NEWLINE = "\r\n";

	private static FacebookOAuthResult _oauthResult;

	private static string _facebookUrl = "https://www.facebook.com/dialog/oauth";

	private static string _loginUrl = "https://www.facebook.com/dialog/oauth?client_id={0}&redirect_uri=http://www.facebook.com/connect/login_success.html&response_type=token&display=popup&scope={1}";

	private static string _accessTokenUrl = "https://graph.facebook.com/oauth/access_token?client_id={0}&redirect_uri=http://www.facebook.com/connect/login_success.html&client_secret={1}&code={2}";

	private static string _friendsListUrl = "https://graph.facebook.com/me/friends?access_token={0}";

	private static string _friendsAppListUrl = "https://graph.facebook.com/me/friends?fields=id,name,installed&access_token={0}";

	private static string _myInfoUrl = "https://graph.facebook.com/me?access_token={0}";

	private static string _logoutUrl = "https://www.facebook.com/logout.php?next={0}&access_token={1}";

	private static string _scope = "read_friendlists,publish_stream";

	private static string _appId = "203533356441472";

	private static string _appSecret = "8800a51d382a873668cc274685156445";

	private static string _redirectUri = "http://www.facebook.com/connect/login_success.html";

	private static string _accessToken;

	public static FacebookOAuthResult OAuthResult => _oauthResult;

	public static string FacebookUrl => _facebookUrl;

	public static string LoginUrl => _loginUrl;

	public static string AccessTokenUrl => _accessToken;

	public static string Scope => _scope;

	public static string AppId => _appId;

	public static string AppSecret => _appSecret;

	public static string RedirectUri => _redirectUri;

	public static string AccessToken
	{
		get
		{
			_accessToken = SettingService.GetFacebookAccessToken();
			return _accessToken;
		}
		set
		{
			_accessToken = value;
			SettingService.SetFacebookAcessToken(_accessToken);
		}
	}

	public static string UserName { get; set; }

	public static async Task<FacebookUser> GetMyInfomation()
	{
		string requestUri = string.Format(_myInfoUrl, new object[1] { AccessToken });
		_ = string.Empty;
		try
		{
			HttpWebRequest request = (HttpWebRequest)WebRequest.Create(requestUri);
			request.Method = "GET";
			HttpWebResponse httpWebResponse = (await request.GetResponseAsync()) as HttpWebResponse;
			HttpWebResponse response = httpWebResponse;
			StreamReader reader = new StreamReader(response.GetResponseStream());
			string resultString = reader.ReadToEnd();
			reader.Dispose();
			return JsonSerializer.Deserialize<FacebookUser>(resultString);
		}
		catch (Exception)
		{
		}
		return null;
	}

	public static async Task<FacebookFriends> GetFriendsList()
	{
		string requestUri = string.Format(_friendsAppListUrl, new object[1] { AccessToken });
		_ = string.Empty;
		try
		{
			HttpWebRequest request = (HttpWebRequest)WebRequest.Create(requestUri);
			request.Method = "GET";
			HttpWebResponse httpWebResponse = (await request.GetResponseAsync()) as HttpWebResponse;
			HttpWebResponse response = httpWebResponse;
			StreamReader reader = new StreamReader(response.GetResponseStream());
			string resultString = reader.ReadToEnd();
			reader.Dispose();
			return JsonSerializer.Deserialize<FacebookFriends>(resultString);
		}
		catch (Exception)
		{
		}
		return null;
	}

	public static async Task<FacebookFriends> GetFriendsAppList()
	{
		string requestUri = string.Format(_friendsAppListUrl, new object[1] { AccessToken });
		_ = string.Empty;
		try
		{
			HttpWebRequest request = (HttpWebRequest)WebRequest.Create(requestUri);
			request.Method = "GET";
			HttpWebResponse httpWebResponse = (await request.GetResponseAsync()) as HttpWebResponse;
			HttpWebResponse response = httpWebResponse;
			StreamReader reader = new StreamReader(response.GetResponseStream());
			string resultString = reader.ReadToEnd();
			reader.Dispose();
			return JsonSerializer.Deserialize<FacebookFriends>(resultString);
		}
		catch (Exception)
		{
		}
		return null;
	}

	public static async Task<bool> PostMessage(string receiverId, string message)
	{
		string requestUri = string.Format("https://graph.facebook.com/{0}/feed?access_token={1}&message={2}", new object[3] { receiverId, AccessToken, message });
		try
		{
			HttpWebRequest request = (HttpWebRequest)WebRequest.Create(requestUri);
			request.Method = "POST";
			HttpWebResponse httpWebResponse = (await request.GetResponseAsync()) as HttpWebResponse;
			HttpWebResponse response = httpWebResponse;
			return response.StatusCode == HttpStatusCode.OK;
		}
		catch (Exception)
		{
			return false;
		}
	}

	public static async Task<bool> PostPhoto(string msg, byte[] photoData)
	{
		try
		{
			HttpWebRequest request = (HttpWebRequest)WebRequest.Create($"https://graph.facebook.com/me/photos?access_token={AccessToken}");
			request.ContentType = "multipart/form-data; boundary=MULTIPART-FORM-DATA-BOUNDARY";
			request.Method = "POST";
			byte[] postData = BuildPostData(msg, photoData);
			Stream postStream = await request.GetRequestStreamAsync();
			postStream.Write(postData, 0, postData.Length);
			postStream.Dispose();
			HttpWebResponse httpWebResponse = (await request.GetResponseAsync()) as HttpWebResponse;
			HttpWebResponse response = httpWebResponse;
			return response.StatusCode == HttpStatusCode.OK;
		}
		catch (Exception)
		{
			return false;
		}
	}

	private static byte[] BuildPostData(string message, byte[] photoData)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("--").Append("MULTIPART-FORM-DATA-BOUNDARY").Append("\r\n");
		stringBuilder.Append("Content-Disposition: form-data; name=\"message\"");
		stringBuilder.AppendLine();
		stringBuilder.AppendLine();
		stringBuilder.Append(message);
		stringBuilder.AppendLine();
		stringBuilder.Append("--").Append("MULTIPART-FORM-DATA-BOUNDARY").Append("\r\n");
		stringBuilder.Append("Content-Disposition: form-data; filename=\"ChatON Photo\"").AppendLine();
		stringBuilder.Append("Content-Type: image/jpeg").AppendLine().AppendLine();
		byte[] bytes = Encoding.UTF8.GetBytes(stringBuilder.ToString());
		byte[] bytes2 = Encoding.UTF8.GetBytes("\r\n" + "--" + "MULTIPART-FORM-DATA-BOUNDARY" + "--" + "\r\n");
		byte[] array = new byte[bytes.Length + photoData.Length + bytes2.Length];
		Buffer.BlockCopy(bytes, 0, array, 0, bytes.Length);
		Buffer.BlockCopy(photoData, 0, array, bytes.Length, photoData.Length);
		Buffer.BlockCopy(bytes2, 0, array, bytes.Length + photoData.Length, bytes2.Length);
		return array;
	}

	public static Uri GetLoginUri()
	{
		return new Uri(string.Format(_loginUrl, new object[2] { _appId, _scope }), UriKind.Absolute);
	}

	public static Uri GetAccessTokenUri(string code)
	{
		return new Uri(string.Format(_accessTokenUrl, new object[3] { _appId, _appSecret, code }), UriKind.Absolute);
	}

	public static Uri GetLogoutUri()
	{
		return new Uri(string.Format(_logoutUrl, new object[2] { _redirectUri, _accessToken }), UriKind.Absolute);
	}

	public static bool TryParseOAuthCallbackUri(Uri uri)
	{
		string text = uri.ToString();
		if (text.Contains("access_token"))
		{
			string[] array = Utility.Split(text, '#');
			string[] array2 = Utility.Split(array[1], '&');
			string[] array3 = Utility.Split(array2[0], '=');
			AccessToken = array3[1];
			_oauthResult = new FacebookOAuthResult(!string.IsNullOrEmpty(_accessToken), _accessToken);
			return true;
		}
		return false;
	}

	public static bool IsLoginSuccess(string navigatedUri)
	{
		bool flag = false;
		if (navigatedUri.Contains("access_token"))
		{
			AccessToken = navigatedUri.Substring(navigatedUri.IndexOf('=') + 1, navigatedUri.LastIndexOf('&'));
			return true;
		}
		return false;
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
