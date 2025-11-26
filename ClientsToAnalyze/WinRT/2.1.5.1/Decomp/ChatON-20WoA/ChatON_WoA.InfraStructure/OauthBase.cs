using System;
using System.IO;
using System.IO.Compression;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading;
using System.Threading.Tasks;
using Windows.Security.Cryptography;
using Windows.Security.Cryptography.Core;
using Windows.Storage.Streams;

namespace ChatON_WoA.InfraStructure;

public class OauthBase
{
	public delegate void OauthBaseEventHandler(object sender, OauthBasePostResult e);

	public event OauthBaseEventHandler PostImagetoTwitter;

	public static string GenerateSignature(string sigBaseString, string consumerSecret, string tokenSecret = null)
	{
		string text = string.Format("{0}&{1}", new object[2]
		{
			consumerSecret,
			(!string.IsNullOrEmpty(tokenSecret)) ? tokenSecret : ""
		});
		IBuffer val = CryptographicBuffer.ConvertStringToBinary(text, (BinaryStringEncoding)0);
		MacAlgorithmProvider val2 = MacAlgorithmProvider.OpenAlgorithm("HMAC_SHA1");
		CryptographicKey val3 = val2.CreateKey(val);
		IBuffer val4 = CryptographicBuffer.ConvertStringToBinary(sigBaseString, (BinaryStringEncoding)0);
		IBuffer val5 = CryptographicEngine.Sign(val3, val4);
		return CryptographicBuffer.EncodeToBase64String(val5);
	}

	public static async Task<string> OauthPostData(string url, string postData)
	{
		try
		{
			HttpClient httpClient = new HttpClient();
			httpClient.MaxResponseContentBufferSize = 2147483647L;
			httpClient.DefaultRequestHeaders.ExpectContinue = false;
			HttpRequestMessage requestMsg = new HttpRequestMessage();
			requestMsg.Content = new StringContent(postData);
			requestMsg.Method = new HttpMethod("POST");
			requestMsg.RequestUri = new Uri(url, UriKind.Absolute);
			requestMsg.Content.Headers.ContentType = new MediaTypeHeaderValue("application/x-www-form-urlencoded");
			return await (await httpClient.SendAsync(requestMsg)).Content.ReadAsStringAsync();
		}
		catch (Exception)
		{
			throw;
		}
	}

	public static async Task<string> PostData(string Url, string Data)
	{
		try
		{
			HttpWebRequest Request = (HttpWebRequest)WebRequest.Create(Url);
			Request.Method = "POST";
			Request.Accept = "*/*";
			Request.Headers["Authorization"] = Data;
			HttpWebResponse httpWebResponse = (HttpWebResponse)(await Request.GetResponseAsync());
			HttpWebResponse Response = httpWebResponse;
			StreamReader ResponseDataStream = new StreamReader(Response.GetResponseStream());
			return await ResponseDataStream.ReadToEndAsync();
		}
		catch (Exception)
		{
			throw;
		}
	}

	public static string GetNonce()
	{
		Random random = new Random();
		return random.Next(1000000000).ToString();
	}

	public static string GetTimeStamp()
	{
		return Convert.ToInt64((DateTime.UtcNow - new DateTime(1970, 1, 1, 0, 0, 0, 0)).TotalSeconds).ToString();
	}

	public static async Task<string> GetTwitterApi(string url, string consumerKey, string consumerSecret, string accessToken, string accessTokenSecret, string oauthVerifier)
	{
		string nonce = GetNonce();
		string timeStamp = GetTimeStamp();
		try
		{
			HttpClient httpClient = new HttpClient();
			httpClient.MaxResponseContentBufferSize = 2147483647L;
			httpClient.DefaultRequestHeaders.ExpectContinue = false;
			HttpRequestMessage requestMsg = new HttpRequestMessage
			{
				Method = new HttpMethod("GET")
			};
			string normalizedUri = url.Split('?')[0];
			string msg = url.Split('?')[1];
			requestMsg.RequestUri = new Uri(url, UriKind.Absolute);
			string sigBaseStringParams = "oauth_consumer_key=" + consumerKey;
			sigBaseStringParams = sigBaseStringParams + "&oauth_nonce=" + nonce;
			sigBaseStringParams += "&oauth_signature_method=HMAC-SHA1";
			sigBaseStringParams = sigBaseStringParams + "&oauth_timestamp=" + timeStamp;
			sigBaseStringParams = sigBaseStringParams + "&oauth_token=" + accessToken;
			sigBaseStringParams += "&oauth_version=1.0";
			sigBaseStringParams = sigBaseStringParams + "&" + ParseQueryParameter(msg);
			string sigBaseString = "GET&";
			string sigBaseEncoded = WebUtility.UrlEncode(sigBaseStringParams);
			if (ParseInfoParameter(msg).Length > 0)
			{
				string text = sigBaseString;
				sigBaseString = text + WebUtility.UrlEncode(normalizedUri) + "&" + WebUtility.UrlEncode(ParseInfoParameter(msg)) + WebUtility.UrlEncode("&") + EncodeTwitter(sigBaseEncoded);
			}
			else
			{
				sigBaseString = sigBaseString + WebUtility.UrlEncode(normalizedUri) + "&" + EncodeTwitter(sigBaseEncoded);
			}
			string signature = GenerateSignature(sigBaseString, consumerSecret, accessTokenSecret);
			string data = "oauth_consumer_key=\"" + WebUtility.UrlEncode(consumerKey) + "\",oauth_nonce=\"" + WebUtility.UrlEncode(nonce) + "\",oauth_signature=\"" + WebUtility.UrlEncode(signature) + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"" + WebUtility.UrlEncode(timeStamp) + "\",oauth_token=\"" + WebUtility.UrlEncode(accessToken) + "\",oauth_version=\"1.0\"";
			requestMsg.Headers.Authorization = new AuthenticationHeaderValue("OAuth", data);
			return await (await httpClient.SendAsync(requestMsg)).Content.ReadAsStringAsync();
		}
		catch (Exception)
		{
			throw;
		}
	}

	public static async Task<string> PostTwitterApi(string url, string msg, string consumerKey, string consumerSecret, string accessToken, string accessTokenSecret, string oauthVerifier)
	{
		string nonce = GetNonce();
		string timeStamp = GetTimeStamp();
		try
		{
			HttpClient httpClient = new HttpClient();
			httpClient.MaxResponseContentBufferSize = 2147483647L;
			httpClient.DefaultRequestHeaders.ExpectContinue = false;
			HttpRequestMessage requestMsg = new HttpRequestMessage();
			string normalizedUri = url.Split('?')[0];
			string normalizedData = EncodeTwitter(msg);
			requestMsg.Method = new HttpMethod("POST");
			requestMsg.RequestUri = new Uri(normalizedUri, UriKind.Absolute);
			requestMsg.Content = new StringContent(normalizedData);
			string sigBaseStringParams = "oauth_consumer_key=" + consumerKey;
			sigBaseStringParams = sigBaseStringParams + "&oauth_nonce=" + nonce;
			sigBaseStringParams += "&oauth_signature_method=HMAC-SHA1";
			sigBaseStringParams = sigBaseStringParams + "&oauth_timestamp=" + timeStamp;
			sigBaseStringParams = sigBaseStringParams + "&oauth_token=" + accessToken;
			sigBaseStringParams += "&oauth_version=1.0";
			string text = sigBaseStringParams;
			sigBaseStringParams = text + "&" + msg.Split('=')[0] + "=" + WebUtility.UrlEncode(msg.Split('=')[1]);
			string sigBaseString = string.Concat("POST&", str3: EncodeTwitter(WebUtility.UrlEncode(sigBaseStringParams)), str1: WebUtility.UrlEncode(normalizedUri), str2: "&");
			string signature = GenerateSignature(sigBaseString, consumerSecret, accessTokenSecret);
			string data = "oauth_consumer_key=\"" + WebUtility.UrlEncode(consumerKey) + "\",oauth_nonce=\"" + WebUtility.UrlEncode(nonce) + "\",oauth_signature=\"" + WebUtility.UrlEncode(signature) + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"" + WebUtility.UrlEncode(timeStamp) + "\",oauth_token=\"" + WebUtility.UrlEncode(accessToken) + "\",oauth_version=\"1.0\"";
			requestMsg.Content.Headers.ContentType = new MediaTypeHeaderValue("application/x-www-form-urlencoded");
			requestMsg.Headers.Authorization = new AuthenticationHeaderValue("OAuth", data);
			return await (await httpClient.SendAsync(requestMsg)).Content.ReadAsStringAsync();
		}
		catch (Exception)
		{
			throw;
		}
	}

	public static async Task<string> PostImageTwitterApi(string url, string msg, byte[] photo, string consumerKey, string consumerSecret, string accessToken, string accessTokenSecret, string oauthVerifier, string boundary = "")
	{
		string nonce = GetNonce();
		string timeStamp = GetTimeStamp();
		try
		{
			HttpClient httpClient = new HttpClient();
			httpClient.MaxResponseContentBufferSize = 2147483647L;
			httpClient.DefaultRequestHeaders.ExpectContinue = false;
			HttpRequestMessage requestMsg = new HttpRequestMessage();
			string normalizedUri = url.Split('?')[0];
			requestMsg.Method = new HttpMethod("POST");
			requestMsg.RequestUri = new Uri(normalizedUri, UriKind.Absolute);
			requestMsg.Headers.Add("Accept", "*/*");
			requestMsg.Headers.ExpectContinue = false;
			MultipartFormDataContent formData = new MultipartFormDataContent
			{
				{
					new StringContent(msg),
					"status"
				},
				{
					new ByteArrayContent(photo),
					"media[]",
					"ChatOnPhoto.png"
				}
			};
			string sigBaseStringParams = "oauth_consumer_key=" + consumerKey;
			sigBaseStringParams = sigBaseStringParams + "&oauth_nonce=" + nonce;
			sigBaseStringParams += "&oauth_signature_method=HMAC-SHA1";
			sigBaseStringParams = sigBaseStringParams + "&oauth_timestamp=" + timeStamp;
			sigBaseStringParams = sigBaseStringParams + "&oauth_token=" + accessToken;
			sigBaseStringParams += "&oauth_version=1.0";
			string sigBaseString = string.Concat("POST&", str3: EncodeTwitter(WebUtility.UrlEncode(sigBaseStringParams)), str1: WebUtility.UrlEncode(normalizedUri), str2: "&");
			string signature = GenerateSignature(sigBaseString, consumerSecret, accessTokenSecret);
			string data = "oauth_consumer_key=\"" + WebUtility.UrlEncode(consumerKey) + "\",oauth_nonce=\"" + WebUtility.UrlEncode(nonce) + "\",oauth_signature=\"" + WebUtility.UrlEncode(signature) + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"" + WebUtility.UrlEncode(timeStamp) + "\",oauth_token=\"" + WebUtility.UrlEncode(accessToken) + "\",oauth_version=\"1.0\"";
			httpClient.DefaultRequestHeaders.Authorization = new AuthenticationHeaderValue("OAuth", data);
			httpClient.DefaultRequestHeaders.Referrer = new Uri("http://twitter.com");
			return await (await httpClient.PostAsync(normalizedUri, formData)).Content.ReadAsStringAsync();
		}
		catch (Exception)
		{
			throw;
		}
	}

	public static string EncodeTwitter(string str)
	{
		if (str.Contains("%252B"))
		{
			str = str.Replace("%252B", "%2520");
		}
		if (str.Contains("%252523"))
		{
			str = str.Replace("%252523", "%2523");
		}
		if (str.Contains("%252540"))
		{
			str = str.Replace("%252540", "%2540");
		}
		if (str.Contains("%252527"))
		{
			str = str.Replace("%252527", "%2527");
		}
		if (str.Contains("!%25250A"))
		{
			str = str.Replace("!%25250A", "%2521%2520");
		}
		if (str.Contains("!%0A"))
		{
			str = str.Replace("!%0A", "%21+");
		}
		return str;
	}

	private static string ParseQueryParameter(string str)
	{
		int num = 0;
		string text = "";
		string text2 = "";
		string[] array = str.Split('&');
		string empty = string.Empty;
		for (int i = 0; i < array.Length; i++)
		{
			string[] array2 = array[i].Split('=');
			switch (array2[0])
			{
			case "screen_name":
				text = array2[0] + "=" + array2[1];
				num++;
				break;
			case "skip_status":
				text2 = "&" + array2[0] + "=" + array2[1];
				num++;
				break;
			}
		}
		return text + text2;
	}

	private static string ParseInfoParameter(string str)
	{
		string text = string.Empty;
		string text2 = string.Empty;
		string[] array = str.Split('&');
		string empty = string.Empty;
		for (int i = 0; i < array.Length; i++)
		{
			string[] array2 = array[i].Split('=');
			switch (array2[0])
			{
			case "cursor":
				text = array2[0] + "=" + array2[1];
				break;
			case "include_user_entities":
				text2 = "&" + array2[0] + "=" + array2[1];
				break;
			}
		}
		return text + text2;
	}

	internal static byte[] DecompressGzip(byte[] data)
	{
		using GZipStream gZipStream = new GZipStream(new MemoryStream(data), CompressionMode.Decompress);
		byte[] buffer = new byte[4096];
		using MemoryStream memoryStream = new MemoryStream();
		int num = 0;
		do
		{
			num = gZipStream.Read(buffer, 0, 4096);
			if (num > 0)
			{
				memoryStream.Write(buffer, 0, num);
			}
		}
		while (num > 0);
		return memoryStream.ToArray();
	}

	internal async Task<OauthBasePostResult> HttpPostImageRequest(string url, byte[] photo, string consumerKey, string consumerSecret, string accessToken, string accessTokenSecret, string oauthVerifier, string boundary = "")
	{
		OauthBasePostResult result = new OauthBasePostResult();
		string resultString = null;
		string nonce = GetNonce();
		string timeStamp = GetTimeStamp();
		string normalizedUri = url.Split('?')[0];
		Uri uri = new Uri(normalizedUri);
		string sigBaseStringParams = "oauth_consumer_key=" + consumerKey;
		sigBaseStringParams = sigBaseStringParams + "&oauth_nonce=" + nonce;
		sigBaseStringParams += "&oauth_signature_method=HMAC-SHA1";
		sigBaseStringParams = sigBaseStringParams + "&oauth_timestamp=" + timeStamp;
		sigBaseStringParams = sigBaseStringParams + "&oauth_token=" + accessToken;
		sigBaseStringParams += "&oauth_version=1.0";
		string sigBaseString = string.Concat("POST&", str3: EncodeTwitter(WebUtility.UrlEncode(sigBaseStringParams)), str1: WebUtility.UrlEncode(normalizedUri), str2: "&");
		string signature = GenerateSignature(sigBaseString, consumerSecret, accessTokenSecret);
		string data = "oauth_consumer_key=\"" + WebUtility.UrlEncode(consumerKey) + "\",oauth_nonce=\"" + WebUtility.UrlEncode(nonce) + "\",oauth_signature=\"" + WebUtility.UrlEncode(signature) + "\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"" + WebUtility.UrlEncode(timeStamp) + "\",oauth_token=\"" + WebUtility.UrlEncode(accessToken) + "\",oauth_version=\"1.0\"";
		HttpWebRequest httpRequest = (HttpWebRequest)WebRequest.Create(uri);
		httpRequest.Method = "POST";
		httpRequest.ContentType = "multipart/form-data";
		httpRequest.Headers["Authorization"] = "OAuth " + data;
		Stream postStream = null;
		await Task.Run(delegate
		{
			ManualResetEvent allDone = new ManualResetEvent(initialState: false);
			httpRequest.BeginGetRequestStream(delegate(IAsyncResult r)
			{
				try
				{
					postStream = httpRequest.EndGetRequestStream(r);
					postStream.Write(photo, 0, photo.Length);
					postStream.Dispose();
				}
				catch (WebException ex)
				{
					if (ex.Response != null)
					{
						result.Response = ex.Message;
					}
				}
				allDone.Set();
			}, httpRequest);
			allDone.WaitOne();
		});
		HttpWebResponse httpResponse = null;
		await Task.Run(delegate
		{
			ManualResetEvent allDone2 = new ManualResetEvent(initialState: false);
			httpRequest.BeginGetResponse(delegate(IAsyncResult r2)
			{
				try
				{
					httpResponse = (HttpWebResponse)httpRequest.EndGetResponse(r2);
				}
				catch (WebException ex)
				{
					if (ex.Response != null)
					{
						result.Response = ex.Message;
					}
				}
				allDone2.Set();
			}, httpRequest);
			allDone2.WaitOne();
		});
		if (httpResponse != null)
		{
			result.StatusCode = httpResponse.StatusCode;
			Stream responseStream = httpResponse.GetResponseStream();
			if (responseStream != null)
			{
				StreamReader streamReader = new StreamReader(responseStream);
				resultString = streamReader.ReadToEnd();
				streamReader.Dispose();
			}
		}
		result.Response = resultString;
		return result;
	}

	public async void PostImageTwitterAsync(string url, byte[] photo, string consumerKey, string consumerSecret, string accessToken, string accessTokenSecret, string oauthVerifier, string boundary = "")
	{
		OauthBasePostResult result = await HttpPostImageRequest(url, photo, consumerKey, consumerSecret, accessToken, accessTokenSecret, oauthVerifier);
		try
		{
			if (this.PostImagetoTwitter != null)
			{
				this.PostImagetoTwitter(this, result);
			}
		}
		catch (Exception)
		{
		}
	}
}
