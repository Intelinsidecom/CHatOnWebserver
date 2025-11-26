using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Xml.Linq;
using ChatON_WoA.DataModel;
using ChatOn.Infrastructure;
using ChatOn.Models;
using Windows.Foundation;
using Windows.Networking.BackgroundTransfer;
using Windows.Storage;
using Windows.Storage.FileProperties;
using Windows.Storage.Streams;
using Windows.UI.Popups;
using Windows.UI.StartScreen;
using Windows.UI.Xaml;

namespace ChatOn.Services;

public class SSMService
{
	public delegate void SSMServiceEventHandler(object sender, SSMCompletedEventArgs e);

	private const int MINIMUM_BUF_SIZE = 1024;

	public static string http = "https://";

	private static readonly TimeSpan BuddySyncInteval = TimeSpan.FromSeconds(1.0);

	private static readonly TimeSpan UnreadSyncInteval = TimeSpan.FromSeconds(1.0);

	private static readonly TimeSpan TrunkSyncInteval = TimeSpan.FromSeconds(1.0);

	private static readonly TimeSpan LatestVersionSyncInteval = TimeSpan.FromHours(1.0);

	private static readonly TimeSpan InteractionRankSyncInteval = TimeSpan.FromDays(1.0);

	private static IAsyncOperation<IUICommand> asyncCommand;

	public SSMServer _svrAddress;

	public UserAccountInfo _account;

	private object _tag;

	private HttpWebRequest _uploadRequest;

	private bool _isUploadingAborted;

	private static long _userProfileImageTimeStamp = 0L;

	public static readonly string BIGJOE_SERVER_PROD = "https://ew1.reg.bigdata.ssp.samsung.com";

	public static readonly string BIGJOE_SERVER_STG1 = "http://STG1-Registration-243671819.eu-west-1.elb.amazonaws.com:443";

	public static readonly string BIGJOE_SERVER_STG2 = "https://STG2-Registration-965007815.eu-west-1.elb.amazonaws.com";

	public static readonly string BIGJOE_SERVER_DEV = "http://54.228.232.87";

	public object Tag
	{
		get
		{
			return _tag;
		}
		set
		{
			_tag = value;
		}
	}

	public static long UserProfileImageTimeStamp
	{
		get
		{
			return _userProfileImageTimeStamp;
		}
		set
		{
			_userProfileImageTimeStamp = value;
		}
	}

	public UserAccountInfo Account => _account;

	public SSMServer SrvAddress => _svrAddress;

	public event SSMServiceEventHandler RegisterUserCompleted;

	public event SSMServiceEventHandler DeRegisterUserCompleted;

	public event SSMServiceEventHandler GetServerAddressCompleted;

	public event SSMServiceEventHandler GetServerAddress3Completed;

	public event SSMServiceEventHandler GetServerAddress4Completed;

	public event SSMServiceEventHandler GetSMSTokenCompleted;

	public event SSMServiceEventHandler GetACSTokenCompleted;

	public event SSMServiceEventHandler SendSMSCompleted;

	public event SSMServiceEventHandler SendACSCompleted;

	public event SSMServiceEventHandler ValidateSMSAuthCompleted;

	public event SSMServiceEventHandler GetBuddyCompleted;

	public event SSMServiceEventHandler UploadAddressCompleted;

	public event SSMServiceEventHandler AddBuddyCompleted;

	public event SSMServiceEventHandler UploadFileCompleted;

	public event SSMServiceEventHandler UploadProgressChanged;

	public event SSMServiceEventHandler UnreadMessageCompleted;

	public event SSMServiceEventHandler GetVersionCompleted;

	public event SSMServiceEventHandler GetMyProfileCompleted;

	public event SSMServiceEventHandler GetMemoListCompleted;

	public event SSMServiceEventHandler GetBlindListCompleted;

	public event SSMServiceEventHandler UploadBlindListCompleted;

	public event SSMServiceEventHandler GetUserPrivacyCompleted;

	public event SSMServiceEventHandler SetUserPrivacyCompleted;

	public event SSMServiceEventHandler WriteMemoCompleted;

	public event SSMServiceEventHandler DeleteMemoCompleted;

	public event SSMServiceEventHandler GetInteractionCompleted;

	public event SSMServiceEventHandler UpdateUserProfileCompleted;

	public event SSMServiceEventHandler DownloadFileCompleted;

	public event SSMServiceEventHandler DownloadProgressChanged;

	public event SSMServiceEventHandler GetTrunkCompleted;

	public event SSMServiceEventHandler GetTrunkListCompleted;

	public event SSMServiceEventHandler MarkAsReadTrunkItemCompleted;

	public event SSMServiceEventHandler GetTrunkItemListCompleted;

	public event SSMServiceEventHandler GetTrunkItemCompleted;

	public event SSMServiceEventHandler GetTrunkCommentListCompleted;

	public event SSMServiceEventHandler UploadProfileImageCompleted;

	public event SSMServiceEventHandler DeleteProfileImageCompleted;

	public event SSMServiceEventHandler PostTrunkCommentComplet;

	public event SSMServiceEventHandler DeleteTrunkItemCompleted;

	public event SSMServiceEventHandler DeleteTrunkCommentCompleted;

	public event SSMServiceEventHandler BlockBuddyCompleted;

	public event SSMServiceEventHandler BlockBuddyListCompleted;

	public event SSMServiceEventHandler UnBlockBuddyCompleted;

	public event SSMServiceEventHandler GetBlockListCompleted;

	public event SSMServiceEventHandler GetInteractionHideListCompleted;

	public event SSMServiceEventHandler SetInteractionHideCompleted;

	public event SSMServiceEventHandler GetChatBuddyProfileCompleted;

	public event SSMServiceEventHandler GetLatestVersionCompleted;

	public event SSMServiceEventHandler GetBuddyRecommendListCompleted;

	public event SSMServiceEventHandler GetAniconPackageListCompleted;

	public event SSMServiceEventHandler InstallAniconPackageCompleted;

	public event SSMServiceEventHandler DownloadAniconCompleted;

	public event SSMServiceEventHandler InvalidAccountDetected;

	public event SSMServiceEventHandler GetUserProfileImageHistoryCompleted;

	public event SSMServiceEventHandler CheckNoticeCompleted;

	public event SSMServiceEventHandler CheckRegParamCompleted;

	public event SSMServiceEventHandler CheckBuddySayProfileCompleted;

	public event SSMServiceEventHandler GetPushUpdateCompleted;

	public event SSMServiceEventHandler GetMixedMessageCompleted;

	public event SSMServiceEventHandler PushMarketingFeedbackCompleted;

	public event SSMServiceEventHandler UpdateUserProfileFromHistoryCompleted;

	public event SSMServiceEventHandler SetMappingDeviceCompleted;

	public event SSMServiceEventHandler GetServerAddressForWebCompleted;

	public event SSMServiceEventHandler RegisterUserWithoutAuthCompleted;

	public event SSMServiceEventHandler RegisterUserFromSamsungAccountCompleted;

	public event SSMServiceEventHandler UpdateMSISDNCompleted;

	public event SSMServiceEventHandler SetGroupPushCompleted;

	public event SSMServiceEventHandler GetGroupPushCompleted;

	public event SSMServiceEventHandler GetMappingInfoCompleted;

	public event SSMServiceEventHandler GetChatListInfoCompleted;

	public event SSMServiceEventHandler GetBuddyGroupListCompleted;

	public event SSMServiceEventHandler GetChatMemberListCompleted;

	public event SSMServiceEventHandler CheckBuddyProfileCompleted;

	public event SSMServiceEventHandler GetNationalFlagUriCompleted;

	public event SSMServiceEventHandler UpdateBuddyGroupCompleted;

	public event SSMServiceEventHandler UploadImageCompleted;

	public event SSMServiceEventHandler AddUserProfileImageCompleted;

	public event SSMServiceEventHandler DeleteMappingDeviceCompleted;

	public event SSMServiceEventHandler AcceptDisclaimerCompleted;

	public event SSMServiceEventHandler UploadGroupImageCompleted;

	public event SSMServiceEventHandler GetBuddyRecommendIgnoreListCompleted;

	public event SSMServiceEventHandler UploadBuddyRecommendIgnoreListCompleted;

	public event SSMServiceEventHandler SetChatRoomProfileImageCompleted;

	public event SSMServiceEventHandler DeleteChatRoomProfileImageCompleted;

	public event SSMServiceEventHandler DeleteFileChatRoomProfileImageCompleted;

	public event SSMServiceEventHandler GetChatRoomProfileImageCompleted;

	public event SSMServiceEventHandler SetChatRoomTitleInfoCompleted;

	public event SSMServiceEventHandler GetAllMessageCompleted;

	public event SSMServiceEventHandler DeleteGroupProfileImageCompleted;

	public event SSMServiceEventHandler DeregisterOtherDeviceCompleted;

	public event SSMServiceEventHandler NewUpdateCompleted;

	public event SSMServiceEventHandler GetUpdateBuddyCompleted;

	protected virtual void OnInvalidAccountDetected(SSMCompletedEventArgs e)
	{
		this.InvalidAccountDetected?.Invoke(this, e);
	}

	private static TimeSpan GetBuddySyncTimeSpan()
	{
		long num = IsoSettingHelper.Get("BuddySyncTime", 0L);
		return TimeSpan.FromTicks(DateTime.UtcNow.Ticks - num);
	}

	private static void SaveBuddySyncTime()
	{
		IsoSettingHelper.Set("BuddySyncTime", DateTime.UtcNow.Ticks);
	}

	private static TimeSpan GetUnreadMessageSyncTime()
	{
		long num = IsoSettingHelper.Get("UnreadMsgSyncTime", 0L);
		return TimeSpan.FromTicks(DateTime.UtcNow.Ticks - num);
	}

	private static void SaveUnreadMsgSyncTime()
	{
		IsoSettingHelper.Set("UnreadMsgSyncTime", DateTime.UtcNow.Ticks);
	}

	public static void SetUpdateAllBuddyListFlag(bool resetTimeStamp = false)
	{
		IsoSettingHelper.Set("BuddySyncTime", 0L);
		if (resetTimeStamp)
		{
			IsoSettingHelper.Set("GetBuddiesTimeStamp", 0L);
		}
	}

	private static TimeSpan GetLatestVersionSyncTimeSpan()
	{
		long num = IsoSettingHelper.Get("LatestVersionSyncTime", 0L);
		return TimeSpan.FromTicks(DateTime.UtcNow.Ticks - num);
	}

	private static void SaveLatestVersionSyncTime()
	{
		IsoSettingHelper.Set("LatestVersionSyncTime", DateTime.UtcNow.Ticks);
	}

	public static TimeSpan GetTrunkListSyncTimeSpan()
	{
		long num = IsoSettingHelper.Get("TrunkListSyncTime", 0L);
		return TimeSpan.FromTicks(DateTime.UtcNow.Ticks - num);
	}

	public static void SaveTrunkListSyncTime()
	{
		IsoSettingHelper.Set("TrunkListSyncTime", DateTime.UtcNow.Ticks);
	}

	private static TimeSpan GetInteractionSyncTimeSpan()
	{
		long num = IsoSettingHelper.Get("InteractionSyncTime", 0L);
		return TimeSpan.FromTicks(DateTime.UtcNow.Ticks - num);
	}

	private static void SaveInteractionSyncTime()
	{
		IsoSettingHelper.Set("InteractionSyncTime", DateTime.UtcNow.Ticks);
	}

	public static void SetForceUpdateInteraction()
	{
		IsoSettingHelper.Set("InteractionSyncTime", 0L);
	}

	public static void SetForceUpdateChatListInfo()
	{
		IsoSettingHelper.Set("GetChatListInfoTimeStamp", 0L);
	}

	public static void SaveBuddySayBlindSetting(bool isBlind)
	{
		IsoSettingHelper.Set("BuddySayBlindSetting", isBlind);
	}

	public static bool GetBuddySayBlindSetting()
	{
		return IsoSettingHelper.Get("BuddySayBlindSetting", defaultValue: false);
	}

	public SSMService()
	{
		_account = RegistrationService.GetUserAccount();
		_svrAddress = GetServerInfo();
	}

	public SSMService(UserAccountInfo account, SSMServer srvAddress)
	{
		_account = account;
		_svrAddress = srvAddress;
	}

	private static void SaveServerInfo(SSMServer server)
	{
		IsoSettingHelper.Set("SSMServer.ContactServer.Url", server.ContactServer.Url);
		IsoSettingHelper.Set("SSMServer.ContactServer.Port", server.ContactServer.Port);
		IsoSettingHelper.Set("SSMServer.FileServer.Url", server.FileServer.Url);
		IsoSettingHelper.Set("SSMServer.FileServer.Port", server.FileServer.Port);
		IsoSettingHelper.Set("SSMServer.GldServer.Url", server.GldServer.Url);
		IsoSettingHelper.Set("SSMServer.GldServer.Port", server.GldServer.Port);
		IsoSettingHelper.Set("SSMServer.MsgServer.Url", server.MsgServer.Url);
		IsoSettingHelper.Set("SSMServer.MsgServer.Port", server.MsgServer.Port);
		IsoSettingHelper.Set("SSMServer.SMSServer.Url", server.SMSServer.Url);
		IsoSettingHelper.Set("SSMServer.SMSServer.Port", server.SMSServer.Port);
		IsoSettingHelper.Set("SSMServer.DownloadURL", server.DownloadURL);
		IsoSettingHelper.Set("SSMServer.IsCritical", server.IsCritical);
		IsoSettingHelper.Set("SSMServer.Key", server.Key);
		IsoSettingHelper.Set("SSMServer.NewVersion", server.NewVersion);
		IsoSettingHelper.Set("SSMServer.UtcTime", server.UtcTime);
		IsoSettingHelper.Set("SSMServer.UtcTimeUpdatedTick", server.UtcTimeUpdatedTick);
	}

	private static SSMServer LoadServerInfo()
	{
		SSMServer sSMServer = new SSMServer();
		sSMServer.ContactServer.Url = IsoSettingHelper.Get<string>("SSMServer.ContactServer.Url", null);
		sSMServer.ContactServer.Port = IsoSettingHelper.Get<string>("SSMServer.ContactServer.Port", null);
		sSMServer.FileServer.Url = IsoSettingHelper.Get<string>("SSMServer.FileServer.Url", null);
		sSMServer.FileServer.Port = IsoSettingHelper.Get<string>("SSMServer.FileServer.Port", null);
		sSMServer.GldServer.Url = IsoSettingHelper.Get<string>("SSMServer.GldServer.Url", null);
		sSMServer.GldServer.Port = IsoSettingHelper.Get<string>("SSMServer.GldServer.Port", null);
		sSMServer.MsgServer.Url = IsoSettingHelper.Get<string>("SSMServer.MsgServer.Url", null);
		sSMServer.MsgServer.Port = IsoSettingHelper.Get<string>("SSMServer.MsgServer.Port", null);
		sSMServer.SMSServer.Url = IsoSettingHelper.Get<string>("SSMServer.SMSServer.Url", null);
		sSMServer.SMSServer.Port = IsoSettingHelper.Get<string>("SSMServer.SMSServer.Port", null);
		sSMServer.DownloadURL = IsoSettingHelper.Get<string>("SSMServer.DownloadURL", null);
		sSMServer.IsCritical = IsoSettingHelper.Get("SSMServer.IsCritical", defaultValue: false);
		sSMServer.Key = IsoSettingHelper.Get<string>("SSMServer.Key", null);
		sSMServer.NewVersion = IsoSettingHelper.Get<string>("SSMServer.NewVersion", null);
		sSMServer.UtcTime = IsoSettingHelper.Get("SSMServer.UtcTime", 0L);
		sSMServer.UtcTimeUpdatedTick = IsoSettingHelper.Get("SSMServer.UtcTimeUpdatedTick", 0);
		return sSMServer;
	}

	public static SSMServer GetServerInfo()
	{
		SSMServer sSMServer = LoadServerInfo();
		if (string.IsNullOrEmpty(sSMServer.GldServer.Url))
		{
			sSMServer.GldServer.Url = "gld1.samsungchaton.com";
			sSMServer.GldServer.Port = "80";
			SaveServerInfo(sSMServer);
		}
		return sSMServer;
	}

	public Uri GetBuddyProfileImageUri(string phoneNumber, bool isThumbnail = true, bool forceUpdate = true, int size = 0)
	{
		string text = "";
		if (isThumbnail)
		{
			text = string.Concat(http, _svrAddress.ContactServer, "/buddy/", phoneNumber, "/image?uid=", _account.Uid, "&imei=", _account.IMEI, "&size=160");
		}
		else
		{
			text = string.Concat(http, _svrAddress.ContactServer, "/buddy/", phoneNumber, "/image?uid=", _account.Uid, "&imei=", _account.IMEI);
			if (size > 0)
			{
				text = text + "&size=" + size;
			}
		}
		if (forceUpdate)
		{
			text = text + "&timestamp=" + Utility.GetTimeStamp();
		}
		return new Uri(text);
	}

	public Uri GetBuddyProfileImageUriCheck(string phoneNumber, bool isThumbnail = true, bool forceUpdate = true, int size = 0)
	{
		string text = "";
		if (isThumbnail)
		{
			text = string.Concat(http, _svrAddress.ContactServer, "/check/", phoneNumber, "/image?uid=", _account.Uid, "&imei=", _account.IMEI, "&size=160&mode=nonbuddy");
		}
		else
		{
			text = string.Concat(http, _svrAddress.ContactServer, "/check/", phoneNumber, "/image?uid=", _account.Uid, "&imei=", _account.IMEI, "&mode=nonbuddy");
			if (size > 0)
			{
				text = text + "&size=" + size;
			}
		}
		if (forceUpdate)
		{
			text = text + "&timestamp=" + Utility.GetTimeStamp();
		}
		return new Uri(text);
	}

	public void GetBuddyProfileImageAsync(string phoneNumber)
	{
		GetBuddyProfileImageUri(phoneNumber);
	}

	public async Task<byte[]> ConvertImagetoByte(StorageFile image)
	{
		IRandomAccessStream fileStream = await image.OpenAsync((FileAccessMode)0);
		DataReader reader = new DataReader(fileStream.GetInputStreamAt(0uL));
		await (IAsyncOperation<uint>)(object)reader.LoadAsync((uint)fileStream.Size);
		byte[] pixels = new byte[fileStream.Size];
		reader.ReadBytes(pixels);
		return pixels;
	}

	public static async Task<byte[]> ImageToByteArray(StorageFile wb)
	{
		try
		{
			byte[] result = null;
			using (MemoryStream memoryStream = new MemoryStream())
			{
				result = memoryStream.ToArray();
			}
			return result;
		}
		catch (Exception)
		{
			return null;
		}
	}

	private void UploadProgress(UploadOperation upload)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0038: Unknown result type (might be due to invalid IL or missing references)
		//IL_0010: Unknown result type (might be due to invalid IL or missing references)
		//IL_001f: Unknown result type (might be due to invalid IL or missing references)
		if (upload.Progress.TotalBytesToReceive != 0)
		{
			_ = upload.Progress.BytesSent * 100 / upload.Progress.TotalBytesToSend;
		}
		_ = upload.Progress.HasRestarted;
		_ = upload.Progress.HasResponseChanged;
	}

	public async void UploadProfileImageAsync(StorageFile file)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/profileimage?uid=", _account.Uid, "&imei=", _account.IMEI);
		Uri uri = new Uri(address);
		try
		{
			using HttpClient client = new HttpClient();
			IRandomAccessStream stream = await file.OpenAsync((FileAccessMode)1);
			try
			{
				using Stream conv = stream.AsStream();
				using StreamContent content = new StreamContent(conv);
				HttpResponseMessage response = null;
				try
				{
					response = await client.PostAsync(uri, content);
					if (this.UploadProfileImageCompleted != null)
					{
						SSMCompletedEventArgs e = new SSMCompletedEventArgs();
						e.StatusCode = response.StatusCode;
						e.Value = file;
						this.UploadProfileImageCompleted(this, e);
					}
					response.Dispose();
				}
				catch (Exception ex)
				{
					if (this.UploadProfileImageCompleted != null)
					{
						WebException ex2 = ex as WebException;
						SSMCompletedEventArgs e2 = new SSMCompletedEventArgs();
						e2.StatusCode = HttpStatusCode.NotFound;
						if (ex2 != null && ex2.Response != null)
						{
							string serverErrorMessage = GetServerErrorMessage(ex2);
							e2.ErrorMessage = serverErrorMessage;
						}
						this.UploadProfileImageCompleted(this, e2);
					}
					response?.Dispose();
				}
			}
			finally
			{
				((IDisposable)stream)?.Dispose();
			}
		}
		catch (Exception)
		{
		}
	}

	private async Task<SSMCompletedEventArgs> HttpPostRequest(string requestName, string uriString, string param, string contentType = "text/xml", StorageFile wb = null)
	{
		SSMCompletedEventArgs result = new SSMCompletedEventArgs();
		string resultString = null;
		string log = "\n========== " + requestName + " ==========";
		try
		{
			Uri uri = new Uri(uriString);
			log = log + "\n[URI] " + uri;
			log = log + "\n[PARAM] " + param;
			HttpWebRequest httpRequest = (HttpWebRequest)WebRequest.Create(uri);
			httpRequest.Method = "POST";
			httpRequest.ContentType = contentType;
			log = log + "\n[Method] " + httpRequest.Method;
			if (!string.IsNullOrEmpty(param) || wb != null)
			{
				UTF8Encoding encoding = new UTF8Encoding();
				byte[] postBytes = null;
				if (contentType == "text/xml")
				{
					postBytes = encoding.GetBytes(param);
				}
				else
				{
					postBytes = await ConvertImagetoByte(wb);
				}
				Stream postStream = null;
				await Task.Run(delegate
				{
					ManualResetEvent allDone = new ManualResetEvent(initialState: false);
					httpRequest.BeginGetRequestStream(delegate(IAsyncResult r)
					{
						try
						{
							postStream = httpRequest.EndGetRequestStream(r);
							postStream.Write(postBytes, 0, postBytes.Length);
							postStream.Dispose();
						}
						catch (WebException ex2)
						{
							log = log + "\n" + ex2.Message;
							result.Error = ex2;
							if (ex2.Response != null)
							{
								string serverErrorMessage = GetServerErrorMessage(ex2);
								object obj2 = log;
								log = string.Concat(obj2, '\n', "[Error Message]", serverErrorMessage);
								result.ErrorMessage = serverErrorMessage;
							}
						}
						allDone.Set();
					}, httpRequest);
					allDone.WaitOne();
				});
				object obj = log;
				log = string.Concat(obj, "\n[", postBytes.Length, "bytes posted]");
			}
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
					catch (WebException ex2)
					{
						log = log + "\n" + ex2.Message;
						result.Error = ex2;
						if (ex2.Response != null)
						{
							string serverErrorMessage = GetServerErrorMessage(ex2);
							object obj2 = log;
							log = string.Concat(obj2, '\n', "[Error Message]", serverErrorMessage);
							result.ErrorMessage = serverErrorMessage;
						}
					}
					allDone2.Set();
				}, httpRequest);
				allDone2.WaitOne();
			});
			if (httpResponse != null)
			{
				log = log + "\n[Http Response Code] " + httpResponse.StatusCode;
				result.StatusCode = httpResponse.StatusCode;
				Stream responseStream = httpResponse.GetResponseStream();
				if (responseStream == null)
				{
					log += "\nResponseStream is NULL!";
				}
				else
				{
					StreamReader streamReader = new StreamReader(responseStream);
					resultString = streamReader.ReadToEnd();
					streamReader.Dispose();
					log = log + "\n[Payload] " + resultString;
				}
			}
		}
		catch (Exception)
		{
		}
		log = log + "\n====FIN=== " + requestName + " ==========\n";
		result.ResultString = resultString;
		return result;
	}

	private async Task<SSMCompletedEventArgs> HttpDeleteRequest(string requestName, string uriString, string param, string contentType = "text/xml", bool decrypt = false)
	{
		SSMCompletedEventArgs result = new SSMCompletedEventArgs();
		string resultString = null;
		string log = "\n========== " + requestName + " ==========";
		Uri uri = new Uri(uriString);
		log = log + "\n[URI] " + uri;
		log = log + "\n[PARAM] " + param;
		try
		{
			HttpWebRequest httpRequest = (HttpWebRequest)WebRequest.Create(uri);
			httpRequest.Method = "DELETE";
			httpRequest.ContentType = contentType;
			log = log + "\n[Method] " + httpRequest.Method;
			if (param.Length > 0)
			{
				UTF8Encoding encoding = new UTF8Encoding();
				byte[] postBytes = encoding.GetBytes(param);
				Stream postStream = await httpRequest.GetRequestStreamAsync();
				postStream.Write(postBytes, 0, postBytes.Length);
				postStream.Dispose();
				object obj = log;
				log = string.Concat(obj, "\n[", postBytes.Length, "bytes posted]");
			}
			HttpWebResponse httpWebResponse = (await httpRequest.GetResponseAsync()) as HttpWebResponse;
			HttpWebResponse httpResponse = httpWebResponse;
			log = log + "\n[Http Response Code] " + httpResponse.StatusCode;
			Stream resultStream = httpResponse.GetResponseStream();
			if (httpResponse != null)
			{
				result.StatusCode = httpResponse.StatusCode;
				if (resultStream == null)
				{
					log += "\nResponseStream is NULL!";
				}
				else
				{
					if (decrypt)
					{
						log = log + "\n[Decrypt] " + decrypt;
						byte[] array = new byte[resultStream.Length];
						resultStream.Read(array, 0, (int)resultStream.Length);
						Utility.Decrypt(_svrAddress.Key, array, out resultString);
					}
					else
					{
						StreamReader streamReader = new StreamReader(resultStream);
						resultString = streamReader.ReadToEnd();
						streamReader.Dispose();
					}
					log = log + "\n[Payload] " + resultString;
				}
			}
		}
		catch (Exception ex)
		{
			log = log + "\n" + ex.Message;
			result.Error = ex;
			if (ex is WebException { Response: not null } ex2)
			{
				string serverErrorMessage = GetServerErrorMessage(ex2);
				object obj2 = log;
				log = string.Concat(obj2, '\n', "[Error Message]", serverErrorMessage);
				result.ErrorMessage = serverErrorMessage;
			}
		}
		log = log + "\n====FIN=== " + requestName + " ==========\n";
		result.Log = log;
		result.ResultString = resultString;
		return result;
	}

	public async Task<SSMCompletedEventArgs> HttpGetRequestString(string requestName, string uriString, bool decrypt = false, WebHeaderCollection header = null)
	{
		string resultString = null;
		string log = "\n========== " + requestName + " ==========";
		SSMCompletedEventArgs ret = new SSMCompletedEventArgs();
		try
		{
			Uri uri = new Uri(uriString);
			log = log + "\n[URI] " + uri;
			HttpWebRequest httpRequest = (HttpWebRequest)WebRequest.Create(uri);
			httpRequest.Method = "GET";
			if (header != null)
			{
				httpRequest.Headers = header;
				log = log + "\n" + httpRequest.Headers.ToString();
			}
			log = log + "\n[Method] " + httpRequest.Method;
			Stream resultStream = null;
			try
			{
				HttpWebResponse httpWebResponse = (await httpRequest.GetResponseAsync()) as HttpWebResponse;
				HttpWebResponse httpResponse = httpWebResponse;
				log = log + "\n[Http Response Code] " + httpResponse.StatusCode;
				ret.StatusCode = httpResponse.StatusCode;
				resultStream = httpResponse.GetResponseStream();
			}
			catch (Exception ex)
			{
				Exception ex2 = (ret.Error = ex);
				if (ex2 is WebException { Response: not null } ex4)
				{
					string serverErrorMessage = GetServerErrorMessage(ex4);
					object obj = log;
					log = string.Concat(obj, '\n', "[Error Message]", serverErrorMessage);
					ret.ErrorMessage = serverErrorMessage;
				}
			}
			if (resultStream == null)
			{
				log += "\nResponseStream is NULL!";
			}
			else if (resultStream.CanRead)
			{
				if (decrypt)
				{
					log = log + "\n[Decrypt] " + decrypt;
					byte[] array = null;
					using (MemoryStream memoryStream = new MemoryStream())
					{
						resultStream.CopyTo(memoryStream);
						array = memoryStream.ToArray();
					}
					if (array != null)
					{
						Utility.Decrypt(_svrAddress.Key, array, out resultString);
					}
				}
				else
				{
					StreamReader streamReader = new StreamReader(resultStream);
					resultString = streamReader.ReadToEnd();
					streamReader.Dispose();
				}
				log = log + "\n[Payload] " + resultString;
			}
			log = (ret.Log = log + "\n====FIN=== " + requestName + " =========\n");
			ret.ResultString = resultString;
			return ret;
		}
		catch (Exception ex5)
		{
			Exception ex6 = (ret.Error = ex5);
			if (ex6 is WebException { Response: not null } ex8)
			{
				string serverErrorMessage2 = GetServerErrorMessage(ex8);
				object obj2 = log;
				string.Concat(obj2, '\n', "[Error Message]", serverErrorMessage2);
				ret.ErrorMessage = serverErrorMessage2;
			}
			return ret;
		}
	}

	public static string GetServerErrorMessage(WebException ex)
	{
		Stream responseStream = ex.Response.GetResponseStream();
		byte[] array = new byte[responseStream.Length];
		responseStream.Read(array, 0, (int)responseStream.Length);
		UTF8Encoding uTF8Encoding = new UTF8Encoding();
		return uTF8Encoding.GetString(array, 0, array.Length);
	}

	public async void GetServerAddressAsync()
	{
		_svrAddress = GetServerInfo();
		if (!string.IsNullOrEmpty(_svrAddress.ContactServer.Url))
		{
			if (this.GetServerAddressCompleted != null)
			{
				this.GetServerAddressCompleted(this, new SSMCompletedEventArgs("GetServerFinished"));
			}
			return;
		}
		string http = "https://";
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetServerAddressAsync", string.Concat(http, _svrAddress.GldServer, "/prov?imei=", _account.IMEI, "&msisdn=", RegistrationService.TempMSISDN, "&imsi=", _account.IMSI, "&model=", _account.Model, "&platform=", Utility.GetPlatformName(), "&clientversion=", _account.Version));
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			return;
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		IEnumerable<XElement> xmlExpdate = from item in xe.Descendants("expdate")
			select (item);
		foreach (XElement item in xmlExpdate)
		{
			Utility.GetDateTimeFromMiliseconds(long.Parse(item.Value));
		}
		IEnumerable<XElement> xmlQuery = from item in xe.Descendants("primary")
			select (item);
		foreach (XElement item2 in xmlQuery)
		{
			if (item2.Attribute("name").Value == "message")
			{
				_svrAddress.MsgServer.Url = item2.Attribute("address").Value;
				_svrAddress.MsgServer.Port = item2.Attribute("port").Value;
			}
			else if (item2.Attribute("name").Value == "contact")
			{
				_svrAddress.ContactServer.Url = item2.Attribute("address").Value;
				_svrAddress.ContactServer.Port = item2.Attribute("port").Value;
			}
			else if (item2.Attribute("name").Value == "file")
			{
				_svrAddress.FileServer.Url = item2.Attribute("address").Value;
				_svrAddress.FileServer.Port = item2.Attribute("port").Value;
			}
		}
		SaveServerInfo(_svrAddress);
		if (this.GetServerAddressCompleted != null)
		{
			this.GetServerAddressCompleted(this, new SSMCompletedEventArgs("GetServerFinished"));
		}
	}

	public async void GetServerAddress4Async()
	{
		_account = RegistrationService.GetUserAccount();
		_svrAddress = GetServerInfo();
		string http = "https://";
		string address = string.Concat(http, _svrAddress.GldServer, "/prov4?imei=", _account.IMEI, "&imsi=", _account.IMSI, "&model=", _account.Model, "&platform=", Utility.GetPlatformName(), "&clientversion=", _account.Version, "&platform=windows&osversion=8.0&", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetServerAddress4Async", address);
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			if (this.GetServerAddress4Completed != null)
			{
				this.GetServerAddress4Completed(this, ret);
			}
			return;
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		XElement xeKey = xe.Element("expdate");
		if (xeKey.Value != null)
		{
			Utility.GetDateTimeFromMiliseconds(long.Parse(xeKey.Value));
		}
		try
		{
			xeKey = xe.Element("msisdn");
			if (xeKey.Value != null)
			{
				string value = xeKey.Value;
				RegistrationService.TempMSISDN = value;
			}
		}
		catch (Exception)
		{
			RegistrationService.TempMSISDN = "A";
		}
		IEnumerable<XElement> xmlQuery = from item in xe.Descendants("primary")
			select (item);
		foreach (XElement item in xmlQuery)
		{
			if (item.Attribute("name").Value == "message")
			{
				_svrAddress.MsgServer.Url = item.Attribute("address").Value;
				_svrAddress.MsgServer.Port = item.Attribute("port").Value;
			}
			else if (item.Attribute("name").Value == "contact")
			{
				_svrAddress.ContactServer.Url = item.Attribute("address").Value;
				_svrAddress.ContactServer.Port = item.Attribute("port").Value;
			}
			else if (item.Attribute("name").Value == "file")
			{
				_svrAddress.FileServer.Url = item.Attribute("address").Value;
				_svrAddress.FileServer.Port = item.Attribute("port").Value;
			}
			else if (item.Attribute("name").Value == "sms")
			{
				_svrAddress.SMSServer.Url = item.Attribute("address").Value;
				_svrAddress.SMSServer.Port = item.Attribute("port").Value;
			}
		}
		SaveServerInfo(_svrAddress);
		if (this.GetServerAddress4Completed != null)
		{
			this.GetServerAddress4Completed(this, ret);
		}
	}

	public async void GetServerAddress3Async()
	{
		_account = RegistrationService.GetUserAccount();
		_svrAddress = GetServerInfo();
		string http = "https://";
		string address = string.Concat(http, _svrAddress.GldServer, "/prov3?imei=", _account.IMEI, "&countrycallingcode=", _account.CountryCode, "&phonenumber=", _account.PhoneNumber, "&imsi=", _account.IMSI, "&model=", _account.Model, "&platform=", Utility.GetPlatformName(), "&clientversion=", _account.Version, "&", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetServerAddress3Async", address);
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			if (this.GetServerAddress3Completed != null)
			{
				this.GetServerAddress3Completed(this, ret);
			}
			return;
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		XElement xeKey = xe.Element("expdate");
		if (xeKey.Value != null)
		{
			Utility.GetDateTimeFromMiliseconds(long.Parse(xeKey.Value));
		}
		xeKey = xe.Element("msisdn");
		if (xeKey.Value != null)
		{
			string value = xeKey.Value;
			RegistrationService.TempMSISDN = value;
		}
		IEnumerable<XElement> xmlQuery = from item in xe.Descendants("primary")
			select (item);
		foreach (XElement item in xmlQuery)
		{
			if (item.Attribute("name").Value == "message")
			{
				_svrAddress.MsgServer.Url = item.Attribute("address").Value;
				_svrAddress.MsgServer.Port = item.Attribute("port").Value;
			}
			else if (item.Attribute("name").Value == "contact")
			{
				_svrAddress.ContactServer.Url = item.Attribute("address").Value;
				_svrAddress.ContactServer.Port = item.Attribute("port").Value;
			}
			else if (item.Attribute("name").Value == "file")
			{
				_svrAddress.FileServer.Url = item.Attribute("address").Value;
				_svrAddress.FileServer.Port = item.Attribute("port").Value;
			}
			else if (item.Attribute("name").Value == "sms")
			{
				_svrAddress.SMSServer.Url = item.Attribute("address").Value;
				_svrAddress.SMSServer.Port = item.Attribute("port").Value;
			}
		}
		SaveServerInfo(_svrAddress);
		if (this.GetServerAddress3Completed != null)
		{
			this.GetServerAddress3Completed(this, ret);
		}
	}

	public async void GetMSISDNFromServerAddress3Async()
	{
		_account = RegistrationService.GetUserAccount();
		_svrAddress = GetServerInfo();
		string http = "https://";
		string address = string.Concat(http, _svrAddress.GldServer, "/prov3?imei=", _account.IMEI, "&countrycallingcode=", _account.CountryCode, "&phonenumber=", _account.PhoneNumber, "&imsi=", _account.IMSI, "&model=", _account.Model, "&platform=", Utility.GetPlatformName(), "&clientversion=", _account.Version, "&", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetServerAddress3Async", address);
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			if (this.GetServerAddress3Completed != null)
			{
				this.GetServerAddress3Completed(this, ret);
			}
			return;
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		XElement xeKey = xe.Element("expdate");
		if (xeKey.Value != null)
		{
			Utility.GetDateTimeFromMiliseconds(long.Parse(xeKey.Value));
		}
		xeKey = xe.Element("msisdn");
		if (xeKey.Value != null)
		{
			string value = xeKey.Value;
			RegistrationService.TempMSISDN = value;
		}
		if (this.GetServerAddress3Completed != null)
		{
			this.GetServerAddress3Completed(this, ret);
		}
	}

	public async void GetSMSToken()
	{
		_svrAddress = GetServerInfo();
		_account = RegistrationService.GetUserAccount();
		SSMCompletedEventArgs ret = await HttpGetRequestString(header: new WebHeaderCollection
		{
			["sms-encryptedkey"] = "312510e8ca9a4240a243e050e752a376",
			["sms-platform"] = "wm7",
			["sms-version"] = _account.Version
		}, requestName: "GetSMSToken", uriString: string.Concat("https://", _svrAddress.SMSServer, "/sms/v2/authtoken?countrycallingcode=", _account.CountryCode, "&phonenumber=", _account.PhoneNumber, "&did=", Utility.GetDeviceUniqueID(), "&", Utility.GetTimeStamp()));
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			if (this.GetSMSTokenCompleted != null)
			{
				this.GetSMSTokenCompleted(this, ret);
			}
			return;
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		XElement xeKey = xe.Element("token");
		if (xeKey.Value != null)
		{
			RegistrationService.SaveSMSToken(xeKey.Value);
		}
		if (this.GetSMSTokenCompleted != null)
		{
			this.GetSMSTokenCompleted(this, ret);
		}
	}

	public async void GetACSToken()
	{
		_svrAddress = GetServerInfo();
		_account = RegistrationService.GetUserAccount();
		SSMCompletedEventArgs ret = await HttpGetRequestString(header: new WebHeaderCollection
		{
			["sms-encryptedkey"] = "312510e8ca9a4240a243e050e752a376",
			["sms-platform"] = "wm7",
			["sms-version"] = _account.Version
		}, requestName: "GetACSToken", uriString: string.Concat("https://", _svrAddress.SMSServer, "/sms/acs/authtoken?countrycallingcode=", _account.CountryCode, "&phonenumber=", _account.PhoneNumber, "&did=", Utility.GetDeviceUniqueID(), "&", Utility.GetTimeStamp()));
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			if (this.GetACSTokenCompleted != null)
			{
				this.GetACSTokenCompleted(this, ret);
			}
			return;
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		XElement xeKey = xe.Element("token");
		if (xeKey.Value != null)
		{
			RegistrationService.SaveACSToken(xeKey.Value);
		}
		if (this.GetACSTokenCompleted != null)
		{
			this.GetACSTokenCompleted(this, ret);
		}
	}

	public async void SendSMS()
	{
		_account = RegistrationService.GetUserAccount();
		_svrAddress = GetServerInfo();
		SSMCompletedEventArgs ret = await HttpGetRequestString(header: new WebHeaderCollection
		{
			["sms-token"] = _account.SMSToken,
			["sms-platform"] = "wm7",
			["sms-version"] = _account.Version
		}, requestName: "SendSMS", uriString: string.Concat("https://", _svrAddress.SMSServer, "/sms/v3/send?countrycallingcode=", _account.CountryCode, "&phonenumber=", _account.PhoneNumber, "&did=", Utility.GetDeviceUniqueID(), "&msisdn=", RegistrationService.TempMSISDN, "&", Utility.GetTimeStamp()));
		if (this.SendSMSCompleted != null)
		{
			this.SendSMSCompleted(this, ret);
		}
	}

	public async void SendACS(string language)
	{
		_account = RegistrationService.GetUserAccount();
		_svrAddress = GetServerInfo();
		SSMCompletedEventArgs ret = await HttpGetRequestString(header: new WebHeaderCollection
		{
			["sms-token"] = _account.ACSToken,
			["sms-platform"] = "wm7",
			["sms-version"] = _account.Version
		}, requestName: "SendACS", uriString: string.Concat("https://", _svrAddress.SMSServer, "/sms/acs/req?countrycallingcode=", _account.CountryCode, "&phonenumber=", _account.PhoneNumber, "&did=", Utility.GetDeviceUniqueID(), "&lang=", language, "&imsi=", _account.IMSI, "&", Utility.GetTimeStamp()));
		if (this.SendACSCompleted != null)
		{
			this.SendACSCompleted(this, ret);
		}
	}

	public async Task<bool> ValidateSMSAuth(string authNum, bool isACS)
	{
		string address = string.Concat("https://", _svrAddress.ContactServer, "/v2/reg/smsv");
		string token = _account.SMSToken;
		if (isACS)
		{
			token = _account.ACSToken;
		}
		string param = "<param><msisdn>" + RegistrationService.TempMSISDN + "</msisdn><token>" + token + "</token><authnum>" + authNum + "</authnum></param>";
		SSMCompletedEventArgs result = await HttpPostRequest("ValidateSMSAuth", address, param);
		if (this.ValidateSMSAuthCompleted != null)
		{
			this.ValidateSMSAuthCompleted(this, result);
		}
		return true;
	}

	public async void RegisterUserAsync()
	{
		_account = RegistrationService.GetUserAccount();
		string http = "https://";
		string address = string.Concat(http, _svrAddress.ContactServer, "/reg?");
		string param = "<param><msisdn>" + RegistrationService.TempMSISDN + "</msisdn><imei>" + _account.IMEI + "</imei><regid></regid><pushtype>WNS</pushtype><securityid>" + PushService.Instance.SID + "</securityid><secretkey>" + PushService.Instance.Secret + "</secretkey><osversion>" + Utility.GetOSVersion() + "</osversion><imsi>" + _account.IMSI + "</imsi><model>" + _account.Model + "</model><name>" + _account.Name + "</name></param>";
		SSMCompletedEventArgs result = await HttpPostRequest("RegisterUserAsync", address, param);
		string xmlString = result.ResultString;
		if (!string.IsNullOrEmpty(xmlString))
		{
			XElement xElement = XElement.Load(new StringReader(xmlString));
			IEnumerable<XElement> enumerable = from item in xElement.Descendants("uid")
				select (item);
			foreach (XElement item in enumerable)
			{
				_account.Uid = item.Value;
			}
			RegistrationService.SaveUID(_account.Uid);
		}
		try
		{
			if (this.RegisterUserCompleted != null)
			{
				this.RegisterUserCompleted(this, result);
			}
		}
		catch (Exception)
		{
		}
	}

	public async Task<bool> DeRegisterUserAsync()
	{
		string http = "https://";
		SSMCompletedEventArgs ret = await HttpGetRequestString("DeRegisterUserAsync", string.Concat(http, _svrAddress.ContactServer, "/dereg?uid=", _account.Uid, "&imei=", _account.IMEI, "&did=", _account.IMEI));
		if (this.DeRegisterUserCompleted != null)
		{
			this.DeRegisterUserCompleted(this, ret);
		}
		return true;
	}

	public async Task<bool> DeregisterOtherDevice(string ChatonID)
	{
		string http = "https://";
		string.Concat("https://", _svrAddress.ContactServer, "/v2/reg/smsv");
		string address = $"{http}{_svrAddress.ContactServer}/mapping/delete?uid={_account.Uid}&imei={_account.IMEI}";
		string param = "<param><email>" + RegistrationService.GetUserProfile().Email + "</email><chatonid>" + ChatonID + "</chatonid></param>";
		SSMCompletedEventArgs result = await HttpPostRequest("DeregisterOtherDevice", address, param);
		if (this.DeregisterOtherDeviceCompleted != null)
		{
			this.DeregisterOtherDeviceCompleted(this, result);
		}
		return true;
	}

	public async Task<bool> SetReadMessageAsync(List<Message> msgTidList)
	{
		if (msgTidList.Count == 0)
		{
			return true;
		}
		string http = "https://";
		string address = string.Concat(http, _svrAddress.ContactServer, "/inbox?uid=", _account.Uid, "&imei=", _account.IMEI);
		string param = "<param>";
		foreach (Message msgTid in msgTidList)
		{
			param = param + "<msgtid>" + msgTid.Tid + "</msgtid>";
		}
		param += "</param>";
		await HttpPostRequest("SetReadMessageAsync", address, param);
		return true;
	}

	public async void GetUnReadMessageListAsync(string sessionID = "")
	{
		TimeSpan time = GetUnreadMessageSyncTime();
		if (time.Ticks >= 0 && time <= UnreadSyncInteval)
		{
			try
			{
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		SaveUnreadMsgSyncTime();
		string http = "https://";
		string uri = string.Concat(http, _svrAddress.ContactServer, "/inboxes?uid=", _account.Uid, "&imei=", _account.IMEI);
		if (!string.IsNullOrEmpty(sessionID))
		{
			uri = uri + "&sessionid=" + sessionID;
		}
		uri = uri + "&" + Utility.GetTimeStamp();
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetUnReadMessageList", uri);
		ret.Value = sessionID;
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.UnreadMessageCompleted != null)
			{
				this.UnreadMessageCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetVersionAsync(bool forceUpdate)
	{
		_svrAddress = GetServerInfo();
		if (_svrAddress.ContactServer.Url == null)
		{
			return;
		}
		if (!forceUpdate && !string.IsNullOrEmpty(_svrAddress.Key))
		{
			try
			{
				if (this.GetVersionCompleted != null)
				{
					this.GetVersionCompleted(this, new SSMCompletedEventArgs(_svrAddress.Key));
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		string http = "https://";
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetVersionAsync", string.Concat(http, _svrAddress.ContactServer, "/version?uid=", _account.Uid, "&imei=", _account.IMEI, "&version=", _account.Version, "&regid=", PushService.Instance.GetPushChannelUri(), "&pushtype=WNS&securityid=", PushService.Instance.SID, "&secretkey=", PushService.Instance.Secret, "&timestamp=", Utility.GetTimeStamp()));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xElement = XElement.Load(new StringReader(ret.ResultString));
			XElement xElement2 = xElement.Element("key");
			_svrAddress.Key = xElement2.Value;
			SaveServerInfo(_svrAddress);
		}
		ret.ResultString = _svrAddress.Key;
		try
		{
			if (this.GetVersionCompleted != null)
			{
				this.GetVersionCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetLatestVersionAsync()
	{
		SSMCompletedEventArgs ret = new SSMCompletedEventArgs
		{
			StatusCode = HttpStatusCode.OK
		};
		SaveLatestVersionSyncTime();
		ret = await HttpGetRequestString("GetLatestVersionAsync", string.Concat("https://", _svrAddress.ContactServer, "/version/versionnotidis?mcc=", _account.Mcc, "&imei=", _account.IMEI, "&platform=", Utility.GetPlatformName(), "&osversion=", Utility.GetOSVersion(), "&model=", Utility.GetDeviceName(), "&appversion=", Utility.GetAssemblyVersion(), "&language=en_US&timestamp=0&", Utility.GetTimeStamp()));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xElement = XElement.Load(new StringReader(ret.ResultString));
			XElement xElement2 = xElement.Element("downloadurl");
			if (xElement2 != null)
			{
				_svrAddress.DownloadURL = xElement2.Value;
			}
			xElement2 = xElement.Element("newversion");
			if (xElement2 != null)
			{
				_svrAddress.NewVersion = xElement2.Value;
			}
			else
			{
				_svrAddress.NewVersion = "";
			}
			xElement2 = xElement.Element("uptodate");
			if (xElement2 != null && !string.IsNullOrEmpty(xElement2.Value))
			{
				_svrAddress.IsUpToDate = bool.Parse(xElement2.Value);
			}
			xElement2 = xElement.Element("critical");
			if (xElement2 != null && !string.IsNullOrEmpty(xElement2.Value))
			{
				_svrAddress.IsCritical = bool.Parse(xElement2.Value);
			}
			xElement2 = xElement.Element("UTCtimestamp");
			if (xElement2 != null && !string.IsNullOrEmpty(xElement2.Value))
			{
				_svrAddress.UtcTime = long.Parse(xElement2.Value);
			}
			else
			{
				_svrAddress.UtcTime = 0L;
			}
			_svrAddress.UtcTimeUpdatedTick = Environment.TickCount;
			Utility.GetDateTimeFromMiliseconds(_svrAddress.UtcTime);
			SaveServerInfo(_svrAddress);
		}
		try
		{
			if (this.GetLatestVersionCompleted != null)
			{
				this.GetLatestVersionCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetBuddyListAsync()
	{
		TimeSpan time = GetBuddySyncTimeSpan();
		if (time.Ticks >= 0 && time <= BuddySyncInteval)
		{
			try
			{
				if (this.GetBuddyCompleted != null)
				{
					this.GetBuddyCompleted(this, new SSMCompletedEventArgs(""));
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		long timestamp = IsoSettingHelper.Get("GetBuddiesTimeStamp", 0L);
		SaveBuddySyncTime();
		string address = string.Concat("https://", _svrAddress.ContactServer, "/v5/buddies?uid=", _account.Uid, "&");
		string param = "imei=" + _account.IMEI + "&mode=blocked&item=guid|appid|devicetype&timestamp=" + timestamp + "&" + Utility.GetTimeStamp();
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetBuddyListAsync", address + param);
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xElement = XElement.Load(new StringReader(ret.ResultString));
			XElement xElement2 = xElement.Element("timestamp");
			timestamp = long.Parse(xElement2.Value);
			IsoSettingHelper.Set("GetBuddiesTimeStamp", timestamp);
			ret.Xml = xElement;
		}
		try
		{
			if (this.GetBuddyCompleted != null)
			{
				this.GetBuddyCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetBuddyProfileAsync(string phoneNumber)
	{
		string address = string.Concat("https://", _svrAddress.ContactServer, "/buddy/", phoneNumber, "?uid=", _account.Uid, "&");
		string param = "imei=" + _account.IMEI + "&timestamp=0";
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetBuddyProfileAsync", address + param);
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			try
			{
				if (this.GetUpdateBuddyCompleted != null)
				{
					this.GetUpdateBuddyCompleted(this, ret);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		ret.Xml = xe;
		try
		{
			if (this.GetUpdateBuddyCompleted != null)
			{
				this.GetUpdateBuddyCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetBuddyRecommendListAsync()
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/buddyrecommendee/list?uid=", _account.Uid, "&imei=", _account.IMEI, "&", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetBuddyRecommendListAsync", address);
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			try
			{
				if (this.GetBuddyRecommendListCompleted != null)
				{
					this.GetBuddyRecommendListCompleted(this, ret);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		ret.Xml = xe;
		try
		{
			if (this.GetBuddyRecommendListCompleted != null)
			{
				this.GetBuddyRecommendListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetChatBuddyProfileAsync(string sessionID)
	{
		string address = string.Concat("https://", _svrAddress.ContactServer, "/chat/profilelist?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionID, "&", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetChatBuddyProfileAsync", address);
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetChatBuddyProfileCompleted != null)
			{
				this.GetChatBuddyProfileCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void UploadAddressListAsync(string xmlString, bool isUpdate = false)
	{
		SSMCompletedEventArgs ret = new SSMCompletedEventArgs("UploadAddressListAsync");
		if (xmlString != "<param></param>")
		{
			string address = ((!isUpdate) ? string.Concat("https://", _svrAddress.ContactServer, "/address?uid=", _account.Uid, "&imei=", _account.IMEI, "&mode=append") : string.Concat("https://", _svrAddress.ContactServer, "/address?uid=", _account.Uid, "&imei=", _account.IMEI, "&mode=update"));
			ret = await HttpPostRequest("UploadAddressListAsync", address, xmlString);
		}
		else
		{
			ret.StatusCode = HttpStatusCode.OK;
		}
		try
		{
			if (this.UploadAddressCompleted != null)
			{
				this.UploadAddressCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void AddBuddyAsync(string phoneNumber, bool isPrev = false, string name = "")
	{
		string address = string.Concat("https://", _svrAddress.ContactServer, "/v6/buddy?uid=", _account.Uid, "&imei=", _account.IMEI);
		if (isPrev)
		{
			address += "&mode=preview";
		}
		string data = "<param><address>" + phoneNumber + "</address></param>";
		SSMCompletedEventArgs ret = await HttpPostRequest("AddBuddyAsync", address, data);
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			ret.Xml = XElement.Load(new StringReader(ret.ResultString));
		}
		ret.Value = isPrev;
		ret.Param = name;
		try
		{
			if (this.AddBuddyCompleted != null)
			{
				this.AddBuddyCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void AddBuddyAsync(List<string> phoneNumbers, string names)
	{
		string address = string.Concat("https://", _svrAddress.ContactServer, "/v5/buddy?uid=", _account.Uid, "&imei=", _account.IMEI);
		address += "&mode=multiple";
		string data = "<param>";
		foreach (string phoneNumber in phoneNumbers)
		{
			data = data + "<address>" + phoneNumber + "</address>";
		}
		data += "</param>";
		SSMCompletedEventArgs ret = await HttpPostRequest("AddBuddyAsync", address, data);
		ret.Param = names;
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			ret.Xml = XElement.Load(new StringReader(ret.ResultString));
		}
		try
		{
			if (this.AddBuddyCompleted != null)
			{
				this.AddBuddyCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetTrunkListAsync(DataService dataService)
	{
		SSMCompletedEventArgs result = new SSMCompletedEventArgs
		{
			StatusCode = HttpStatusCode.OK
		};
		TimeSpan time = GetTrunkListSyncTimeSpan();
		if (time.Ticks >= 0 && time <= TrunkSyncInteval)
		{
			try
			{
				if (this.GetTrunkListCompleted != null)
				{
					this.GetTrunkListCompleted(this, result);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		SaveTrunkListSyncTime();
		string address = string.Concat("https://", _svrAddress.ContactServer, "/trunklist?uid=", _account.Uid, "&imei=", _account.IMEI);
		string param = "<param>";
		int count = 0;
		foreach (Chat chatItem in dataService.ChatItems)
		{
			if (!string.IsNullOrEmpty(chatItem.SessionID))
			{
				param = param + "<sessionid>" + chatItem.SessionID + "</sessionid>";
				count++;
			}
		}
		param += "</param>";
		if (count > 0)
		{
			result = await HttpPostRequest("GetTrunkListAsync", address, param);
		}
		if (!string.IsNullOrEmpty(result.ResultString))
		{
			result.Xml = XElement.Load(new StringReader(result.ResultString));
		}
		try
		{
			if (this.GetTrunkListCompleted != null)
			{
				this.GetTrunkListCompleted(this, result);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetTrunkListByTimestampAsync(DataService dataService)
	{
		SSMCompletedEventArgs result = new SSMCompletedEventArgs
		{
			StatusCode = HttpStatusCode.OK
		};
		long timestamp = 0L;
		TimeSpan time = GetTrunkListSyncTimeSpan();
		if (time.Ticks >= 0 && time <= BuddySyncInteval)
		{
			try
			{
				if (this.GetTrunkListCompleted != null)
				{
					this.GetTrunkListCompleted(this, new SSMCompletedEventArgs(""));
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		SaveTrunkListSyncTime();
		string address = string.Concat("https://", _svrAddress.ContactServer, "/trunk/all?uid=", _account.Uid, "&timestamp=", timestamp, "&imei=", _account.IMEI);
		string param = "<param>";
		int count = 0;
		foreach (Chat chatItem in dataService.ChatItems)
		{
			if (!string.IsNullOrEmpty(chatItem.SessionID))
			{
				param = param + "<sessionid>" + chatItem.SessionID + "</sessionid>";
				count++;
			}
		}
		_ = param + "</param>";
		if (count > 0)
		{
			result = await HttpGetRequestString("GetTrunkListAsync", address);
		}
		if (!string.IsNullOrEmpty(result.ResultString))
		{
			result.Xml = XElement.Load(new StringReader(result.ResultString));
		}
		try
		{
			if (this.GetTrunkListCompleted != null)
			{
				this.GetTrunkListCompleted(this, result);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetTrunkAsync(string sessionId)
	{
		string http = "https://";
		SSMCompletedEventArgs ret = new SSMCompletedEventArgs
		{
			StatusCode = HttpStatusCode.OK
		};
		if (!string.IsNullOrEmpty(sessionId))
		{
			ret = await HttpGetRequestString("GetTrunkAsync", string.Concat(http, _svrAddress.ContactServer, "/trunk?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&recentItems=", 0, "&unreadItems=", 0, "&thumbnailsize=", 100, "&timestamp=", Utility.GetTimeStamp()));
			if (!string.IsNullOrEmpty(ret.ResultString))
			{
				XElement xml = XElement.Load(new StringReader(ret.ResultString));
				ret.Xml = xml;
			}
		}
		try
		{
			if (this.GetTrunkCompleted != null)
			{
				this.GetTrunkCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetTrunkByTimeStampAsync(string sessionId, string Timestamp)
	{
		string http = "https://";
		SSMCompletedEventArgs ret = new SSMCompletedEventArgs
		{
			StatusCode = HttpStatusCode.OK
		};
		if (!string.IsNullOrEmpty(sessionId))
		{
			ret = await HttpGetRequestString("GetTrunkAsync", string.Concat(http, _svrAddress.ContactServer, "/trunk?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&recentItems=", 0, "&unreadItems=", 0, "&thumbnailsize=", 100, "&timestamp=", Timestamp));
			if (!string.IsNullOrEmpty(ret.ResultString))
			{
				XElement xml = XElement.Load(new StringReader(ret.ResultString));
				ret.Xml = xml;
			}
		}
		try
		{
			if (this.GetTrunkCompleted != null)
			{
				this.GetTrunkCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetTrunkItemListAsync(string sessionId, int RequestCount, string startItemId, string startdttm)
	{
		string type = "recentadded";
		switch (IsoSettingHelper.Get("TrunkSort", 0))
		{
		case 0:
			type = "unread";
			break;
		case 1:
			type = "recentadded";
			break;
		}
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetTrunkItemListAsync", string.Concat("https://", _svrAddress.ContactServer, "/trunk/itemlist?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&startdttm=", startdttm, "&startitemid=", startItemId, "&count=", RequestCount, "&type=", type, "&thumbnailsize=", 239, "&timestamp=", Utility.GetTimeStamp()));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetTrunkItemListCompleted != null)
			{
				this.GetTrunkItemListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetTrunkItemListByTimeStampAsync(string sessionId, int RequestCount, string startItemId, string startdttm, string timestamp)
	{
		string type = "recentadded";
		switch (IsoSettingHelper.Get("TrunkSort", 0))
		{
		case 0:
			type = "unread";
			break;
		case 1:
			type = "recentadded";
			break;
		}
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetTrunkItemListAsync", string.Concat("https://", _svrAddress.ContactServer, "/trunk/itemlist?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&startdttm=", startdttm, "&startitemid=", startItemId, "&count=", RequestCount, "&type=", type, "&thumbnailsize=", 239, "&timestamp=", timestamp));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetTrunkItemListCompleted != null)
			{
				this.GetTrunkItemListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetTrunkItemAsync(string sessionId, string itemId)
	{
		string http = "https://";
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetTrunkItemAsync", string.Concat(http, _svrAddress.ContactServer, "/trunk/item?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&itemid=", itemId, "&thumbnailsize=", 239, "&timestamp=", Utility.GetTimeStamp()));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetTrunkItemCompleted != null)
			{
				this.GetTrunkItemCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetTrunkCommentListAsync(string sessionId, string itemId, int requestCount, string startitem)
	{
		string http = "https://";
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetTrunkCommentListAsync", string.Concat(http, _svrAddress.ContactServer, "/trunk/item/commentlist?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&itemid=", itemId, "&startcommentid=", startitem, "&count=", requestCount, "&timestamp=", Utility.GetTimeStamp()));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetTrunkCommentListCompleted != null)
			{
				this.GetTrunkCommentListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void MarkAsReadTrunkItemAsync(string sessionId, string itemId)
	{
		string http = "https://";
		SSMCompletedEventArgs ret = await HttpGetRequestString("MarkAsReadTrunkItemAsync", string.Concat(http, _svrAddress.ContactServer, "/trunk/item/markAsRead?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&itemid=", itemId, "&timestamp=", Utility.GetTimeStamp()));
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			if (this.MarkAsReadTrunkItemCompleted != null)
			{
				this.MarkAsReadTrunkItemCompleted(this, new SSMCompletedEventArgs(""));
			}
			return;
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		try
		{
			if (this.MarkAsReadTrunkItemCompleted != null)
			{
				this.MarkAsReadTrunkItemCompleted(this, new SSMCompletedEventArgs(xe));
			}
		}
		catch (Exception)
		{
		}
	}

	public async void PostTrunkCommentAsync(string sessionId, string itemId, string comment)
	{
		string http = "https://";
		string address = string.Concat(http, _svrAddress.ContactServer, "/trunk/item/comment?uid=", _account.Uid, "&imei=", _account.IMEI);
		string param = "<param><sessionid>" + sessionId + "</sessionid><itemid>" + itemId + "</itemid><comment><![CDATA[" + comment + "]]></comment></param>";
		SSMCompletedEventArgs result = await HttpPostRequest("PostTrunkCommentAsync", address, param);
		try
		{
			if (this.PostTrunkCommentComplet != null)
			{
				this.PostTrunkCommentComplet(this, result);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void DeleteTrunkItemAsync(string sessionId, string itemId)
	{
		string http = "https://";
		string address = string.Concat(http, _svrAddress.ContactServer, "/trunk/item?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&itemid=", itemId);
		string param = "";
		SSMCompletedEventArgs result = await HttpDeleteRequest("DeleteTrunkItemAsync", address, param);
		try
		{
			if (this.DeleteTrunkItemCompleted != null)
			{
				this.DeleteTrunkItemCompleted(this, result);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void DeleteAllTrunkItemAsync(string sessionId)
	{
		string http = "https://";
		string address = string.Concat(http, _svrAddress.ContactServer, "/trunk/allitem?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId);
		string param = "";
		SSMCompletedEventArgs result = await HttpDeleteRequest("DeleteAllTrunkItemAsync", address, param);
		try
		{
			if (this.DeleteTrunkItemCompleted != null)
			{
				this.DeleteTrunkItemCompleted(this, result);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void DeleteTrunkCommentAsync(string sessionId, string itemId, string commentid)
	{
		string http = "https://";
		string address = string.Concat(http, _svrAddress.ContactServer, "/trunk/item/comment?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&itemid=", itemId, "&commentid=", commentid);
		string param = "";
		SSMCompletedEventArgs result = await HttpDeleteRequest("DeleteTrunkCommentAsync", address, param);
		try
		{
			if (this.DeleteTrunkCommentCompleted != null)
			{
				this.DeleteTrunkCommentCompleted(this, result);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetMemoListAsync(string number)
	{
		string param = "imei=" + _account.IMEI + "&count=30&fulltext=false&length=140&timestamp=" + Utility.GetTimeStamp();
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetMemoListAsync", string.Concat("https://", _svrAddress.ContactServer, "/memo/list/", number, "?uid=", _account.Uid, "&", param));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetMemoListCompleted != null)
			{
				this.GetMemoListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetMemoListAsync(string number, string timestamp)
	{
		string param = "imei=" + _account.IMEI + "&count=30&fulltext=false&length=140&starttime=" + timestamp;
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetMemoListAsync", string.Concat("https://", _svrAddress.ContactServer, "/memo/list/", number, "?uid=", _account.Uid, "&", param));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetMemoListCompleted != null)
			{
				this.GetMemoListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetBlindListAsync()
	{
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetBlindListAsync", string.Concat("https://", _svrAddress.ContactServer, "/memo/blind?uid=", _account.Uid, "&imei=", _account.IMEI));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetBlindListCompleted != null)
			{
				this.GetBlindListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetInteractionHideListAsync()
	{
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetInteractionHideListAsync", string.Concat("https://", _svrAddress.ContactServer, "/interaction/hidelist?uid=", _account.Uid, "&imei=", _account.IMEI, "&", Utility.GetTimeStamp()));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetInteractionHideListCompleted != null)
			{
				this.GetInteractionHideListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	internal static string MakeHideInteractionParam(List<string> list, bool hide)
	{
		string text = "<param>";
		foreach (string item in list)
		{
			string text2 = text;
			text = text2 + "<buddyid hide=\"" + hide.ToString().ToLower() + "\">" + item + "</buddyid>";
		}
		return text + "</param>";
	}

	public async void SetInteractionHideAsync(string phoneNumber, bool hide)
	{
		string xmlString = "<param><buddyid hide=\"" + hide.ToString().ToLower() + "\">" + phoneNumber + "</buddyid></param>";
		string address = string.Concat(http, _svrAddress.ContactServer, "/interaction/hide?uid=", _account.Uid, "&imei=", _account.IMEI);
		SSMCompletedEventArgs ret = await HttpPostRequest("SetInteractionHideAsync", address, xmlString);
		try
		{
			if (this.SetInteractionHideCompleted != null)
			{
				this.SetInteractionHideCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void SetInteractionHideAsync(List<string> list, bool hide)
	{
		string xmlString = MakeHideInteractionParam(list, hide);
		string address = string.Concat("https://", _svrAddress.ContactServer, "/interaction/hide?uid=", _account.Uid, "&imei=", _account.IMEI);
		SSMCompletedEventArgs ret = await HttpPostRequest("SetInteractionHideAsync", address, xmlString);
		ret.Param = hide;
		try
		{
			if (this.SetInteractionHideCompleted != null)
			{
				this.SetInteractionHideCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void UploadBlindListAsync(string xmlString)
	{
		SSMCompletedEventArgs ret = new SSMCompletedEventArgs("UploadBlindListCompleted");
		if (xmlString != "<param></param>")
		{
			string address = string.Concat("https://", _svrAddress.ContactServer, "/memo/blind?uid=", _account.Uid, "&imei=", _account.IMEI);
			ret = await HttpPostRequest("UploadBlindListAsync", address, xmlString);
		}
		else
		{
			ret.StatusCode = HttpStatusCode.OK;
		}
		try
		{
			if (this.UploadBlindListCompleted != null)
			{
				this.UploadBlindListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	internal async void GetUserPrivacyAsync(string type)
	{
		bool isMultiple = false;
		if (type.Contains("|"))
		{
			isMultiple = true;
		}
		string address = string.Concat(http, _svrAddress.ContactServer, "/privacy?uid=", _account.Uid, "&imei=", _account.IMEI, "&type=", type);
		if (isMultiple)
		{
			address += "&mode=multiple";
		}
		address = address + "&" + Utility.GetTimeStamp();
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetUserPrivacyAsync", address);
		XElement xe = null;
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			xe = XElement.Load(new StringReader(ret.ResultString));
		}
		ret.Xml = xe;
		try
		{
			if (this.GetUserPrivacyCompleted != null)
			{
				this.GetUserPrivacyCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	internal async void GetUserPrivacyAsync()
	{
		string address = string.Concat("https://", _svrAddress.ContactServer, "/privacy?uid=", _account.Uid, "&imei=", _account.IMEI, "&type=phonenumber&", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetUserPrivacyAsync", address);
		XElement xe = null;
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			xe = XElement.Load(new StringReader(ret.ResultString));
		}
		ret.Xml = xe;
		try
		{
			if (this.GetUserPrivacyCompleted != null)
			{
				this.GetUserPrivacyCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	internal async void GetUserPrivacyAsync(string type, string buddy = "")
	{
		bool isMultiple = false;
		if (type.Contains("|"))
		{
			isMultiple = true;
		}
		string address = string.Concat(http, _svrAddress.ContactServer, "/privacy?uid=", _account.Uid, "&imei=", _account.IMEI, "&type=", type);
		if (isMultiple)
		{
			address += "&mode=multiple";
		}
		if (buddy != "")
		{
			address = address + "&buddyid=" + buddy;
		}
		address = address + "&" + Utility.GetTimeStamp();
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetUserPrivacyAsync", address);
		XElement xe = null;
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			xe = XElement.Load(new StringReader(ret.ResultString));
		}
		ret.Xml = xe;
		try
		{
			if (this.GetUserPrivacyCompleted != null)
			{
				this.GetUserPrivacyCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	internal async void SetUserPrivacyAsync(bool value, string type)
	{
		string param = "<param><privacy>" + type + "</privacy><value>" + value.ToString().ToLower() + "</value></param>";
		string address = string.Concat(http, _svrAddress.ContactServer, "/privacy?uid=", _account.Uid, "&imei=", _account.IMEI);
		SSMCompletedEventArgs ret = await HttpPostRequest("SetUserPrivacyAsync", address, param);
		try
		{
			if (this.SetUserPrivacyCompleted != null)
			{
				this.SetUserPrivacyCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	internal async void SetUserPrivacyAsync(bool isShowPhoneNumber)
	{
		string param = "<param><privacy>phonenumber</privacy><value>" + isShowPhoneNumber.ToString().ToLower() + "</value></param>";
		string address = string.Concat("https://", _svrAddress.ContactServer, "/privacy?uid=", _account.Uid, "&imei=", _account.IMEI);
		SSMCompletedEventArgs ret = await HttpPostRequest("SetUserPrivacyAsync", address, param);
		try
		{
			if (this.SetUserPrivacyCompleted != null)
			{
				this.SetUserPrivacyCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	internal static string MakeBlindListParam(IEnumerable<BuddySummary> list)
	{
		string text = "<param>";
		foreach (BuddySummary item in list)
		{
			if (item.Buddy != null)
			{
				text = text + "<blind isblind=\"true\">" + item.Buddy.PhoneNumber + "</blind>";
			}
		}
		return text + "</param>";
	}

	internal static string MakeBlindListParam(string phoneNumber, bool isBlind)
	{
		string text = "<param>";
		string text2 = text;
		text = text2 + "<blind isblind=\"" + isBlind.ToString().ToLower() + "\">" + phoneNumber + "</blind>";
		return text + "</param>";
	}

	internal static string MakeBlindListParam(IEnumerable<string> phoneNumbers, bool isBlind)
	{
		string text = "<param>";
		foreach (string phoneNumber in phoneNumbers)
		{
			string text2 = text;
			text = text2 + "<blind isblind=\"" + isBlind.ToString().ToLower() + "\">" + phoneNumber + "</blind>";
		}
		return text + "</param>";
	}

	internal async void BlockBuddyListAsync(List<string> list, bool isBlock)
	{
		string param = "<param>";
		foreach (string item in list)
		{
			string text = param;
			param = text + "<address id=\"" + item + "\" isblock=\"" + isBlock.ToString().ToLower() + "\"></address>";
		}
		param += "</param>";
		string address = string.Concat("https://", _svrAddress.ContactServer, "/blockbuddy?uid=", _account.Uid, "&imei=", _account.IMEI, "&mode=post");
		SSMCompletedEventArgs ret = await HttpPostRequest("BlockBuddyListAsync", address, param);
		try
		{
			if (this.BlockBuddyListCompleted != null)
			{
				this.BlockBuddyListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void BlockBuddyAsync(string phoneNumber)
	{
		string address = string.Concat("https://", _svrAddress.ContactServer, "/block/", phoneNumber, "?uid=", _account.Uid, "&imei=", _account.IMEI);
		SSMCompletedEventArgs ret = await HttpPostRequest("BlockBuddyAsync", address, "");
		ret.ResultString = phoneNumber;
		try
		{
			if (this.BlockBuddyCompleted != null)
			{
				this.BlockBuddyCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async Task UnBlockBuddyAsync(string phoneNumber)
	{
		string address = string.Concat("https://", _svrAddress.ContactServer, "/unblock/", phoneNumber, "?uid=", _account.Uid, "&imei=", _account.IMEI, "&", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpGetRequestString("UnBlockBuddyAsync", address);
		try
		{
			if (this.UnBlockBuddyCompleted != null)
			{
				this.UnBlockBuddyCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetBlockBuddyListAsync()
	{
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetBlockBuddyListAsync", string.Concat("https://", _svrAddress.ContactServer, "/blockbuddy?uid=", _account.Uid, "&imei=", _account.IMEI, "&", Utility.GetTimeStamp()));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetBlockListCompleted != null)
			{
				this.GetBlockListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void WriteMemoAsync(string phonenumber, string memo)
	{
		string http = "https://";
		string address = string.Concat(http, _svrAddress.ContactServer, "/memo?uid=", _account.Uid, "&imei=", _account.IMEI);
		string payload = "<param><memo buddyid=\"" + phonenumber + "\"><![CDATA[" + memo + "]]></memo></param>";
		SSMCompletedEventArgs ret = await HttpPostRequest("WriteMemoAsync", address, payload);
		try
		{
			if (this.WriteMemoCompleted != null)
			{
				this.WriteMemoCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void DeleteMemoAsync(string phonenumber, long timestamp, bool fromMyProfile)
	{
		string http = "https://";
		string address = string.Concat(http, _svrAddress.ContactServer, "/delmemo?uid=", _account.Uid, "&imei=", _account.IMEI, "&buddyid=", phonenumber, "&timestamp=", timestamp, "&isreceiver=", fromMyProfile.ToString());
		SSMCompletedEventArgs ret = await HttpGetRequestString("DeleteMemoAsync", address);
		ret.Value = timestamp;
		try
		{
			if (this.DeleteMemoCompleted != null)
			{
				this.DeleteMemoCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetInteractionAsync(bool isForceUpdate = false)
	{
		SSMCompletedEventArgs ret = new SSMCompletedEventArgs
		{
			StatusCode = HttpStatusCode.OK
		};
		TimeSpan time = GetInteractionSyncTimeSpan();
		if (time.Ticks >= 0 && time <= InteractionRankSyncInteval)
		{
			try
			{
				if (this.GetInteractionCompleted != null)
				{
					this.GetInteractionCompleted(this, ret);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		SaveInteractionSyncTime();
		string timezone = ((!(TimeZoneInfo.Local.BaseUtcOffset.TotalMinutes < 0.0)) ? "+" : "-");
		timezone += string.Format("{0:D2}{1:D2}", new object[2]
		{
			Math.Abs(TimeZoneInfo.Local.BaseUtcOffset.Hours),
			Math.Abs(TimeZoneInfo.Local.BaseUtcOffset.Minutes)
		});
		ret = await HttpGetRequestString("GetInteractionAsync", string.Concat("https://", _svrAddress.ContactServer, "/interaction?uid=", _account.Uid, "&imei=", _account.IMEI, "&timezone=", timezone, "&", Utility.GetTimeStamp()));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetInteractionCompleted != null)
			{
				this.GetInteractionCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetUserProfileAsync()
	{
		string param = "imei=" + _account.IMEI + "&timestamp=" + 0;
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetUserProfileAsync", string.Concat("https://", _svrAddress.ContactServer, "/profile?uid=", _account.Uid, "&", param));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetMyProfileCompleted != null)
			{
				this.GetMyProfileCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetUserProfileImageHistoryAsync()
	{
		string param = "imei=" + _account.IMEI + "&startidx=" + 0 + "&starttime=0";
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetUserProfileImageHistoryList", string.Concat("https://", _svrAddress.ContactServer, "/profile/historyimage/list?uid=", _account.Uid, "&", param));
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetUserProfileImageHistoryCompleted != null)
			{
				this.GetUserProfileImageHistoryCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void DeleteUserProfileImageAsync(string ProfileImageID = null)
	{
		if (ProfileImageID == null)
		{
			ProfileImageID = RegistrationService.GetUserProfile().ProfileImageId;
		}
		SSMCompletedEventArgs ret = await HttpGetRequestString("DeleteUserProfileImageAsync", string.Concat("https://", _svrAddress.ContactServer, "/profile/historyimage/del?uid=", _account.Uid, "&imei=", _account.IMEI, "&mode=returnlist&profileimageid=", ProfileImageID, "&count=", 250, "&", Utility.GetTimeStamp()));
		try
		{
			if (this.DeleteProfileImageCompleted != null)
			{
				this.DeleteProfileImageCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public static string MakeBirthdayParam(DateTime birthday, int type = 0)
	{
		string text = MakeBirthdayString(birthday, type);
		string text2 = "<param><birthday>";
		text2 += text;
		return text2 + "</birthday></param>";
	}

	private static string MakeBirthdayString(DateTime birthday, int type)
	{
		string text = "";
		return type switch
		{
			0 => string.Format("{0:D4}-{1:D2}-{2:D2}", new object[3] { birthday.Year, birthday.Month, birthday.Day }), 
			1 => string.Format("{0:D2}-{1:D2}", new object[2] { birthday.Month, birthday.Day }), 
			_ => "0000-12-31", 
		};
	}

	public static string MakeProfileParam(string param, string value)
	{
		string text = "<param><" + param + ">";
		text = text + "<![CDATA[" + value + "]]>";
		return text + "</" + param + "></param>";
	}

	public static string MakeAllUserProfileParam(string name, string status, DateTime birthday, int birthdayType)
	{
		string text = "<param>";
		text += "<name>";
		text = text + "<![CDATA[" + name + "]]>";
		text += "</name>";
		text += "<status>";
		text = text + "<![CDATA[" + status + "]]>";
		text += "</status>";
		text += "<birthday>";
		text = text + "<![CDATA[" + MakeBirthdayString(birthday, birthdayType) + "]]>";
		text += "</birthday>";
		return text + "</param>";
	}

	public async void UpdateUserProfileFromHistory(string profileID)
	{
		string http = "https://";
		string address = string.Concat(http, _svrAddress.ContactServer, "/profile/setimage?uid=", _account.Uid, "&imei=", _account.IMEI);
		string xmlString = $"<param><profileimageid>{profileID}</profileimageid></param>";
		SSMCompletedEventArgs result = await HttpPostRequest("UpdateUserProfileAsync", address, xmlString);
		try
		{
			if (this.UpdateUserProfileFromHistoryCompleted != null)
			{
				this.UpdateUserProfileFromHistoryCompleted(this, result);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void UpdateUserProfileAsync(string xmlString)
	{
		string http = "https://";
		string address = string.Concat(http, _svrAddress.ContactServer, "/profile?uid=", _account.Uid, "&imei=", _account.IMEI);
		SSMCompletedEventArgs result = await HttpPostRequest("UpdateUserProfileAsync", address, xmlString);
		try
		{
			if (this.UpdateUserProfileCompleted != null)
			{
				this.UpdateUserProfileCompleted(this, result);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void UploadFileAsync(Attachment file, StorageFile s)
	{
		if (file.AttachedMediaType == Attachment.MediaType.PHOTO)
		{
			AttachedPhoto attachedPhoto = file as AttachedPhoto;
			if (attachedPhoto.BitmapImage == null)
			{
				attachedPhoto.LoadBitmapImage();
			}
		}
		RequestUploadFile(data: await Utility.FileToByteArray(s), fileName: file.FileName, contentType: file.ContentType);
	}

	public async void ResumeUploadFileAsync()
	{
		if (!(Tag is Message))
		{
			return;
		}
		Message message;
		Message msg = (message = Tag as Message);
		if (message == null)
		{
			return;
		}
		StorageFile file = await Utility.IsFileExist(msg.MediaFilePath);
		if (file != null)
		{
			byte[] data = await Utility.FileToByteArray(file);
			string contentType = string.Empty;
			string originFilename = Utility.Split(msg.MediaFilePath, '\\')[1];
			if (originFilename.Contains("jpg"))
			{
				contentType = "image/jpeg";
			}
			else if (originFilename.Contains("vcf"))
			{
				contentType = "text/x-vcard";
			}
			else if (originFilename.Contains("vcs"))
			{
				contentType = "text/x-vcal";
			}
			else if (originFilename.Contains("mp4"))
			{
				contentType = "video/mp4";
			}
			_isUploadingAborted = false;
			RequestUploadFile(originFilename, contentType, data);
		}
		else
		{
			msg.ActivityState = Message.State.UploadingFailed;
		}
	}

	private async void RequestUploadFile(string fileName, string contentType, byte[] data)
	{
		string http = "https://";
		string address = string.Concat(http, _svrAddress.FileServer, "/file");
		string param = "?uid=" + _account.Uid + "&imei=" + _account.IMEI + "&filename=" + fileName + "&contenttype=" + contentType;
		object obj = param;
		param = string.Concat(obj, "&filesize=", data.Length, "&filepart=");
		bool remainData = true;
		int bufferLength = data.Length / 3;
		int offset = 0;
		int currentPart = 1;
		while (remainData && !_isUploadingAborted)
		{
			string filePart = currentPart + "/3";
			_uploadRequest = (HttpWebRequest)WebRequest.Create(new Uri(address + param + filePart));
			_uploadRequest.ContentType = contentType;
			_uploadRequest.Method = "POST";
			Stream postStream = null;
			await Task.Run(delegate
			{
				ManualResetEvent allDone = new ManualResetEvent(initialState: false);
				if (_uploadRequest != null)
				{
					try
					{
						_uploadRequest.BeginGetRequestStream(delegate(IAsyncResult r)
						{
							try
							{
								postStream = _uploadRequest.EndGetRequestStream(r);
								if (currentPart == 3)
								{
									bufferLength = data.Length - offset;
								}
								postStream.Write(data, offset, bufferLength);
								postStream.Dispose();
							}
							catch (Exception)
							{
								_isUploadingAborted = true;
							}
							allDone.Set();
						}, _uploadRequest);
					}
					catch
					{
						allDone.Set();
					}
				}
				allDone.WaitOne();
			});
			HttpWebResponse httpResponse = null;
			await Task.Run(delegate
			{
				ManualResetEvent allDone2 = new ManualResetEvent(initialState: false);
				if (_uploadRequest != null)
				{
					try
					{
						_uploadRequest.BeginGetResponse(delegate(IAsyncResult r2)
						{
							try
							{
								httpResponse = (HttpWebResponse)_uploadRequest.EndGetResponse(r2);
							}
							catch (Exception)
							{
								_isUploadingAborted = true;
								if (this.UploadFileCompleted != null)
								{
									this.UploadFileCompleted(this, null);
								}
							}
							allDone2.Set();
						}, _uploadRequest);
					}
					catch
					{
						allDone2.Set();
					}
				}
				allDone2.WaitOne();
			});
			_uploadRequest = null;
			if (httpResponse == null)
			{
				continue;
			}
			if (httpResponse.StatusCode == HttpStatusCode.OK)
			{
				if (httpResponse.ResponseUri.AbsoluteUri.Contains("3/3"))
				{
					if (this.UploadProgressChanged != null)
					{
						this.UploadProgressChanged(this, new SSMCompletedEventArgs(100));
					}
					if (this.UploadFileCompleted != null)
					{
						this.UploadFileCompleted(this, new SSMCompletedEventArgs(httpResponse.ResponseUri));
					}
					remainData = false;
				}
				else
				{
					if (this.UploadProgressChanged != null)
					{
						this.UploadProgressChanged(this, new SSMCompletedEventArgs(currentPart * 33));
					}
					currentPart++;
					offset += bufferLength;
				}
			}
			else
			{
				if (this.UploadFileCompleted != null)
				{
					this.UploadFileCompleted(this, null);
				}
				remainData = false;
			}
			httpResponse.Dispose();
		}
	}

	private void UploadFileReadCallback(IAsyncResult asyncResult, byte[] data)
	{
		_uploadRequest = (HttpWebRequest)asyncResult.AsyncState;
		Stream stream = _uploadRequest.EndGetRequestStream(asyncResult);
		stream.Write(data, 0, data.Length);
		stream.Dispose();
		_uploadRequest.BeginGetResponse(delegate(IAsyncResult ar)
		{
			UploadFileResponseCallback(ar);
		}, _uploadRequest);
	}

	private void UploadFileResponseCallback(IAsyncResult asyncResult)
	{
		try
		{
			_uploadRequest = (HttpWebRequest)asyncResult.AsyncState;
			HttpWebResponse httpWebResponse = (HttpWebResponse)_uploadRequest.EndGetResponse(asyncResult);
			if (this.UploadFileCompleted != null)
			{
				if (httpWebResponse.StatusCode == HttpStatusCode.OK)
				{
					this.UploadFileCompleted(this, new SSMCompletedEventArgs(httpWebResponse.ResponseUri));
				}
				else
				{
					this.UploadFileCompleted(this, null);
				}
			}
			httpWebResponse.Dispose();
		}
		catch (Exception)
		{
			if (this.UploadFileCompleted != null)
			{
				this.UploadFileCompleted(this, null);
			}
		}
		finally
		{
			_uploadRequest = null;
		}
	}

	public void CancelUploadAsync(string filename = null)
	{
		if (_uploadRequest != null)
		{
			try
			{
				_uploadRequest.Abort();
			}
			catch (Exception)
			{
			}
			_uploadRequest = null;
			this.UploadProgressChanged = null;
			this.UploadFileCompleted = null;
			_isUploadingAborted = true;
		}
	}

	private void DownloadProgress(DownloadOperation download)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0010: Unknown result type (might be due to invalid IL or missing references)
		//IL_001f: Unknown result type (might be due to invalid IL or missing references)
		if (download.Progress.TotalBytesToReceive != 0)
		{
			int num = (int)(download.Progress.BytesReceived * 100 / download.Progress.TotalBytesToReceive);
			if (this.DownloadProgressChanged != null)
			{
				this.DownloadProgressChanged(this, new SSMCompletedEventArgs(num));
			}
		}
	}

	public async void DownloadFileUsingBackground(string server, string fileName, string buddyUid)
	{
		try
		{
			if (string.IsNullOrEmpty(server))
			{
				return;
			}
			string address = server + "?uid=" + _account.Uid + "&";
			string param = "imei=" + _account.IMEI + "&buddyid=" + buddyUid + "&filename=" + fileName;
			Uri requestUri = new Uri(Uri.EscapeUriString(address + param));
			Message msg = Tag as Message;
			IReadOnlyList<DownloadOperation> downloads = await BackgroundDownloader.GetCurrentDownloadsAsync();
			Progress<DownloadOperation> progressCallback = new Progress<DownloadOperation>(DownloadProgress);
			StorageFolder localFolder = ApplicationData.Current.LocalFolder;
			StorageFolder folder = null;
			StorageFile file = null;
			bool isResumed = false;
			foreach (DownloadOperation download in downloads)
			{
				if (download.RequestedUri.ToString() == requestUri.ToString())
				{
					isResumed = true;
					await download.AttachAsync().AsTask<DownloadOperation, DownloadOperation>(progressCallback);
					break;
				}
			}
			if (!isResumed)
			{
				folder = await Utility.IsFolderExist(msg.ChatID.ToString());
				if (folder == null)
				{
					folder = await localFolder.CreateFolderAsync(msg.ChatID.ToString(), (CreationCollisionOption)3);
				}
				file = await Utility.IsFileExist(folder, fileName);
				if (file != null)
				{
					await file.DeleteAsync();
					file = null;
				}
			}
			if (!isResumed && file == null)
			{
				BackgroundDownloader downloader = new BackgroundDownloader();
				DownloadOperation newDownload = downloader.CreateDownload(requestUri, (IStorageFile)(object)(await folder.CreateFileAsync(fileName)));
				try
				{
					await newDownload.StartAsync().AsTask<DownloadOperation, DownloadOperation>(progressCallback);
				}
				catch
				{
					if (this != null && msg != null)
					{
						CancelDownloading(Utility.Split(msg.Text, '\n')[3]);
						msg.IsDownloading = false;
						msg.ProgressValue = 0;
						if (!string.IsNullOrEmpty(msg.MediaFilePath))
						{
							msg.MediaFilePath = "";
						}
					}
					return;
				}
			}
			if (this.DownloadFileCompleted != null)
			{
				this.DownloadFileCompleted(this, new SSMCompletedEventArgs());
			}
		}
		catch
		{
		}
	}

	public async void CancelDownloading(string filename = null)
	{
		foreach (DownloadOperation item in await BackgroundDownloader.GetCurrentDownloadsAsync())
		{
			if (item.RequestedUri.ToString().Contains(filename))
			{
				((IAsyncInfo)item.AttachAsync()).Cancel();
				break;
			}
		}
	}

	public Uri GetTrunkFileUri(string server, string fileName, string buddyUid)
	{
		string text = server + "?uid=" + _account.Uid + "&param=";
		string data = "imei=" + _account.IMEI + "&buddyid=" + buddyUid + "&filename=" + fileName;
		data = Utility.HexEncode(Utility.Encrypt(_svrAddress.Key, data));
		return new Uri(Uri.EscapeUriString(text + data));
	}

	public void DownloadFileAsync(string server, string fileName, string buddyUid)
	{
		_ = server + "?uid=" + _account.Uid + "&param=";
		_ = "imei=" + _account.IMEI + "&buddyid=" + buddyUid + "&filename=" + fileName + "&timestamp=" + Utility.GetTimeStamp();
	}

	public void ResumeFileTransferEventHandler()
	{
	}

	public async void GetAniconPackageList()
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			string http = "https://";
			string uri = string.Concat(http, _svrAddress.ContactServer, "/anicon/list-package?uid=", _account.Uid, "&imei=", _account.IMEI, "&lang=", Utility.GetLanguageParam(), "&categoryid=0");
			SSMCompletedEventArgs ret = await HttpGetRequestString("GetAniconPackageList", uri);
			if (!string.IsNullOrEmpty(ret.ResultString))
			{
				XElement xml = XElement.Load(new StringReader(ret.ResultString));
				ret.Xml = xml;
			}
			try
			{
				if (this.GetAniconPackageListCompleted != null)
				{
					this.GetAniconPackageListCompleted(this, ret);
				}
			}
			catch (Exception)
			{
			}
		}
		catch
		{
		}
	}

	public async Task<SSMCompletedEventArgs> InstallAniconPackageAsync(string id)
	{
		string http = "https://";
		string uri = string.Concat(http, _svrAddress.ContactServer, "/anicon/install-package?uid=", _account.Uid, "&imei=", _account.IMEI, "&platform=", Utility.GetPlatformName(), "&osversion=", Utility.GetOSVersion(), "&model=", Utility.GetDeviceName(), "&language=en&packageid=", id, "&filetype=png&pixelsize=240");
		uri = uri + "&" + Utility.GetTimeStamp();
		SSMCompletedEventArgs ret = await HttpGetRequestString("InstallAniconPackage", uri);
		ret.Param = id;
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.InstallAniconPackageCompleted != null)
			{
				this.InstallAniconPackageCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
		return null;
	}

	public async void InstallAniconPackage(string id)
	{
		string http = "https://";
		string uri = string.Concat(http, _svrAddress.ContactServer, "/anicon/install-package?uid=", _account.Uid, "&imei=", _account.IMEI, "&platform=", Utility.GetPlatformName(), "&osversion=", Utility.GetOSVersion(), "&model=", Utility.GetDeviceName(), "&language=en&packageid=", id, "&filetype=png&pixelsize=240");
		uri = uri + "&" + Utility.GetTimeStamp();
		SSMCompletedEventArgs ret = await HttpGetRequestString("InstallAniconPackage", uri);
		ret.Param = id;
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.InstallAniconPackageCompleted != null)
			{
				this.InstallAniconPackageCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void DownloadAnicon(string id)
	{
		string http = "https://";
		string uri = string.Concat(http, _svrAddress.ContactServer, "/anicon/download?uid=", _account.Uid, "&imei=", _account.IMEI, "&aniconid=", id, "&pixelsize=240");
		SSMCompletedEventArgs ret = await HttpGetRequestString("DownloadAnicon", uri);
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.DownloadAniconCompleted != null)
			{
				this.DownloadAniconCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void AcceptDisclaimer()
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/disclaimer/accept");
		string param = "<param>";
		if (string.IsNullOrEmpty(RegistrationService.ChatOnID))
		{
			string text = param;
			param = text + "<imei>" + _account.IMEI + "</imei><iso>" + _account.ISO + "</iso></param>";
		}
		else
		{
			string text2 = param;
			param = text2 + "<disclaimerUID>" + _svrAddress.DisclaimerUID + "</disclaimerUID><imei>" + _account.IMEI + "</imei></param>";
		}
		SSMCompletedEventArgs ret = await HttpPostRequest("AcceptDisclaimer", address, param);
		try
		{
			if (this.AcceptDisclaimerCompleted != null)
			{
				this.AcceptDisclaimerCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public Uri GetUserProfileImageUri(bool isThumbnail = true, bool isForceUpdate = false, int size = 0)
	{
		string text = "";
		if (isThumbnail)
		{
			text = string.Concat("https://", _svrAddress.FileServer, "/profileimage?uid=", _account.Uid, "&imei=", _account.IMEI, "&size=300");
		}
		else
		{
			text = string.Concat("https://", _svrAddress.FileServer, "/profileimage?uid=", _account.Uid, "&imei=", _account.IMEI);
			if (size > 0)
			{
				text = text + "&size=" + size;
			}
		}
		if (isForceUpdate)
		{
			text = text + "&timestamp=0&" + Utility.GetTimeStamp();
		}
		else
		{
			object obj = text;
			text = string.Concat(obj, "&timestamp=", UserProfileImageTimeStamp, "&", Utility.GetTimeStamp());
		}
		return new Uri(text);
	}

	public async void SetMappingDeviceAsync(string email, string authcode)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/mapping?uid=", _account.Uid, "&imei=", _account.IMEI);
		string param = "<param><email>" + email + "</email><authcode>" + authcode + "</authcode></param>";
		SSMCompletedEventArgs ret = await HttpPostRequest("SetMappingDeviceAsync", address, param);
		string xmlString = ret.ResultString;
		if (!string.IsNullOrEmpty(xmlString))
		{
			XElement xElement = XElement.Load(new StringReader(xmlString));
			XElement xElement2 = xElement.Element("chatonid");
			if (xElement2 != null)
			{
				RegistrationService.ChatOnID = xElement2.Value;
			}
		}
		try
		{
			if (this.SetMappingDeviceCompleted != null)
			{
				this.SetMappingDeviceCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetServerAddressForWeb()
	{
		_svrAddress = GetServerInfo();
		_account = RegistrationService.GetUserAccount();
		string url = string.Concat(http, _svrAddress.GldServer, "/provweb?imei=", _account.IMEI, "&imsi=", _account.IMSI, "&model=", _account.Model, "&clientversion=", _account.Version, "&email=", RegistrationService.TempEmail, "&platform=", Utility.GetPlatformName(), "&", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetServerAddressForWeb", url);
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			if (this.GetServerAddressForWebCompleted != null)
			{
				this.GetServerAddressForWebCompleted(this, ret);
			}
			return;
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		XElement xeKey = xe.Element("expdate");
		if (xeKey.Value != null)
		{
			Utility.GetDateTimeFromMiliseconds(long.Parse(xeKey.Value));
		}
		IEnumerable<XElement> xmlQuery = from item in xe.Descendants("primary")
			select (item);
		foreach (XElement item in xmlQuery)
		{
			if (item.Attribute("name").Value == "message")
			{
				_svrAddress.MsgServer.Url = item.Attribute("address").Value;
				_svrAddress.MsgServer.Port = item.Attribute("port").Value;
			}
			else if (item.Attribute("name").Value == "contact")
			{
				_svrAddress.ContactServer.Url = item.Attribute("address").Value;
				_svrAddress.ContactServer.Port = item.Attribute("port").Value;
			}
			else if (item.Attribute("name").Value == "file")
			{
				_svrAddress.FileServer.Url = item.Attribute("address").Value;
				_svrAddress.FileServer.Port = item.Attribute("port").Value;
			}
			else if (item.Attribute("name").Value == "sms")
			{
				_svrAddress.SMSServer.Url = item.Attribute("address").Value;
				_svrAddress.SMSServer.Port = item.Attribute("port").Value;
			}
		}
		if (_svrAddress != null)
		{
			SaveServerInfo(_svrAddress);
		}
		if (this.GetServerAddressForWebCompleted != null)
		{
			this.GetServerAddressForWebCompleted(this, ret);
		}
	}

	public async void RegisterUserWithoutAuthAsync()
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/auth/join?");
		string param = "<param><imei>" + _account.IMEI + "</imei><regid></regid><pushtype>WNS</pushtype><osversion>" + Utility.GetOSVersion() + "</osversion><imsi>" + _account.IMSI + "</imsi><model>" + _account.Model + "</model><name>" + _account.Name + "</name></param>";
		SSMCompletedEventArgs result = await HttpPostRequest("RegisterUserWithoutAuthAsync", address, param);
		string xmlString = result.ResultString;
		if (!string.IsNullOrEmpty(xmlString))
		{
			XElement xElement = XElement.Load(new StringReader(xmlString));
			XElement xElement2 = xElement.Element("uid");
			if (xElement2 != null)
			{
				_account.Uid = xElement2.Value;
			}
			xElement2 = xElement.Element("chatonid");
			if (xElement2 != null)
			{
				RegistrationService.ChatOnID = xElement2.Value;
			}
			if (!string.IsNullOrEmpty(_account.Uid))
			{
				RegistrationService.SaveUID(_account.Uid);
			}
		}
		try
		{
			if (this.RegisterUserWithoutAuthCompleted != null)
			{
				this.RegisterUserWithoutAuthCompleted(this, result);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void RegisterUserFromSamsungAccountAsync(string code, string email)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/reg/ssa?");
		string param = "<param><imei>" + _account.IMEI + "</imei><imsi>" + _account.IMSI + "</imsi><authcode>" + code + "</authcode><emailsamsung>" + email + "</emailsamsung><regid></regid><pushtype>MPNS</pushtype><osversion>" + Utility.GetOSVersion() + "</osversion><model>" + _account.Model + "</model><name>" + WebUtility.HtmlEncode(_account.Name) + "</name></param>";
		SSMCompletedEventArgs result = await HttpPostRequest("RegisterUserFromSamsungAccountAsync", address, param);
		string xmlString = result.ResultString;
		if (!string.IsNullOrEmpty(xmlString))
		{
			XElement xElement = XElement.Load(new StringReader(xmlString));
			XElement xElement2 = xElement.Element("uid");
			if (xElement2 != null)
			{
				_account.Uid = xElement2.Value;
			}
			xElement2 = xElement.Element("chatonid");
			if (xElement2 != null)
			{
				RegistrationService.ChatOnID = xElement2.Value;
			}
			if (!string.IsNullOrEmpty(_account.Uid))
			{
				RegistrationService.SaveUID(_account.Uid);
			}
		}
		try
		{
			if (this.RegisterUserFromSamsungAccountCompleted != null)
			{
				this.RegisterUserFromSamsungAccountCompleted(this, result);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void UpdateMSISDNAsync(string authNum, bool isACS)
	{
		string token = _account.SMSToken;
		if (isACS)
		{
			token = _account.ACSToken;
		}
		string address = string.Concat(http, _svrAddress.ContactServer, "/auth/msisdn/validate?uid=", _account.Uid, "&imei=", _account.IMEI);
		string param = "<param><msisdn>" + RegistrationService.TempMSISDN + "</msisdn><token>" + token + "</token><authnum>" + authNum + "</authnum></param>";
		SSMCompletedEventArgs result = await HttpPostRequest("UpdateMSISDNAsync", address, param);
		try
		{
			if (this.UpdateMSISDNCompleted != null)
			{
				this.UpdateMSISDNCompleted(this, result);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void SetGroupPushAsync(string sessionid, int pushType)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/grouppush?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionid, "&pushtype=", pushType);
		_ = "<param><pushtype>" + pushType + "</pushtype></param>";
		SSMCompletedEventArgs result = await HttpPostRequest("SetGroupPushAsync", address, "");
		try
		{
			if (this.SetGroupPushCompleted != null)
			{
				this.SetGroupPushCompleted(this, result);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetGroupPushAsync()
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/grouppush?uid=", _account.Uid, "&imei=", _account.IMEI);
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetGroupPushAsync", address);
		string xmlString = ret.ResultString;
		if (!string.IsNullOrEmpty(xmlString))
		{
			XElement xml = XElement.Load(new StringReader(xmlString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetGroupPushCompleted != null)
			{
				this.GetGroupPushCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetMappingInfoAsync()
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/mapping/info?uid=", _account.Uid, "&imei=", _account.IMEI, "&", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetMappingInfoAsync", address);
		string xmlString = ret.ResultString;
		if (!string.IsNullOrEmpty(xmlString))
		{
			XElement xml = XElement.Load(new StringReader(xmlString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetMappingInfoCompleted != null)
			{
				this.GetMappingInfoCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetChatListInfoAsync()
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			long timestamp = IsoSettingHelper.Get("GetChatListInfoTimeStamp", 0L);
			string address = string.Concat(http, _svrAddress.ContactServer, "/chat/infoall?uid=", _account.Uid, "&imei=", _account.IMEI, "&lastupdatetime=", timestamp, "&", Utility.GetTimeStamp());
			SSMCompletedEventArgs ret = await HttpGetRequestString("GetChatListInfoAsync", address);
			string xmlString = ret.ResultString;
			if (!string.IsNullOrEmpty(xmlString))
			{
				XElement xElement = (ret.Xml = XElement.Load(new StringReader(xmlString)));
				timestamp = long.Parse(xElement.Attribute("lastupdatetime").Value);
				IsoSettingHelper.Set("GetChatListInfoTimeStamp", timestamp);
			}
			try
			{
				if (this.GetChatListInfoCompleted != null)
				{
					this.GetChatListInfoCompleted(this, ret);
				}
			}
			catch (Exception)
			{
			}
		}
		catch
		{
		}
	}

	public async void GetBuddyGroupListAsync()
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/buddy/group/all?uid=", _account.Uid, "&imei=", _account.IMEI, "&mode=filename&", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetBuddyGroupListAsync", address);
		string xmlString = ret.ResultString;
		if (!string.IsNullOrEmpty(xmlString))
		{
			XElement xml = XElement.Load(new StringReader(xmlString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetBuddyGroupListCompleted != null)
			{
				this.GetBuddyGroupListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void UpdateBuddyGroupAsync(string xmlString)
	{
		new SSMCompletedEventArgs("UploadBuddyGroupListAsync");
		string address = string.Concat(http, _svrAddress.ContactServer, "/address?uid=", _account.Uid, "&imei=", _account.IMEI, "&mode=group");
		SSMCompletedEventArgs ret = await HttpPostRequest("UploadBuddyGroupListAsync", address, xmlString);
		try
		{
			if (this.UpdateBuddyGroupCompleted != null)
			{
				this.UpdateBuddyGroupCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetChatMemberListAsync(string sessionID)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/chat/memberlist?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionID);
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetChatMemberListAsync", address);
		string xmlString = ret.ResultString;
		if (!string.IsNullOrEmpty(xmlString))
		{
			XElement xml = XElement.Load(new StringReader(xmlString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetChatMemberListCompleted != null)
			{
				this.GetChatMemberListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public string CreateCheckBuddyProfileAsync(string buddyid)
	{
		return string.Concat(http, _svrAddress.ContactServer, "/v5/check/", buddyid, "?uid=", _account.Uid, "&imei=", _account.IMEI, "&mode=nonbuddy&item=preview");
	}

	public async void CheckBuddyProfileAsync(string buddyid)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/v5/check/", buddyid, "?uid=", _account.Uid, "&imei=", _account.IMEI, "&mode=nonbuddy&item=preview");
		SSMCompletedEventArgs ret = await HttpGetRequestString("CheckBuddyProfileAsync", address);
		string xmlString = ret.ResultString;
		if (!string.IsNullOrEmpty(xmlString))
		{
			XElement xml = XElement.Load(new StringReader(xmlString));
			ret.Xml = xml;
		}
		try
		{
			if (this.CheckBuddyProfileCompleted != null)
			{
				this.CheckBuddyProfileCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void CheckBuddySayProfileAsync(string buddyid)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/v5/check/", buddyid, "?uid=", _account.Uid, "&imei=", _account.IMEI, "&mode=nonbuddy&item=preview");
		SSMCompletedEventArgs ret = await HttpGetRequestString("CheckBuddyProfileAsync", address);
		string xmlString = ret.ResultString;
		if (!string.IsNullOrEmpty(xmlString))
		{
			XElement xml = XElement.Load(new StringReader(xmlString));
			ret.Xml = xml;
			ret.ResultString = buddyid;
		}
		try
		{
			if (this.CheckBuddySayProfileCompleted != null)
			{
				this.CheckBuddySayProfileCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	internal string ParseFlagUri(XElement xe)
	{
		IEnumerable<XElement> enumerable = from item in xe.Descendants("fileurl")
			select (item);
		string result = "";
		foreach (XElement item in enumerable)
		{
			result = item.Value;
			result = result.Replace("&amp;", "&");
		}
		return result;
	}

	public async void GetNationalFlagUri(string countrycode)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/nationalflag?uid=", _account.Uid, "&imei=", _account.IMEI, "&contrycode=", countrycode);
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetNationalFlagUri", address);
		string xmlString = ret.ResultString;
		if (!string.IsNullOrEmpty(xmlString))
		{
			XElement xml = XElement.Load(new StringReader(xmlString));
			ret.Xml = xml;
		}
		try
		{
			if (this.GetNationalFlagUriCompleted != null)
			{
				this.GetNationalFlagUriCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void UploadChatRoomImageAsync(StorageFile targetImg)
	{
		new SSMCompletedEventArgs("UploadChatRoomImageAsync");
		string fileName = Utility.GetTimeStamp() + ".jpg";
		string address = string.Concat("https://", _svrAddress.FileServer, "/file/image?uid=", _account.Uid, "&imei=", _account.IMEI, "&filename=", fileName);
		SSMCompletedEventArgs ret = await HttpPostRequest("UploadChatRoomImageAsync", address, "", "image/jpeg", targetImg);
		ret.Param = fileName;
		ret.Value = string.Concat("https://", _svrAddress.FileServer, "/file/", _account.Uid, "/");
		try
		{
			if (this.UploadImageCompleted != null)
			{
				this.UploadImageCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void AddUserProfileImage(string fileName)
	{
		new SSMCompletedEventArgs("AddUserProfileImage");
		string address = string.Concat(http, _svrAddress.ContactServer, "/profile/historyimage/add?uid=", _account.Uid, "&imei=", _account.IMEI);
		string imageUrl = "/file/" + _account.Uid + "/" + fileName;
		string xmlString = string.Concat("<param><profileimageurl>", imageUrl, "</profileimageurl><contenttype>image/jpeg</contenttype><hosturl>https://", _svrAddress.FileServer, "</hosturl></param>");
		SSMCompletedEventArgs ret = await HttpPostRequest("AddUserProfileImage", address, xmlString);
		try
		{
			if (this.AddUserProfileImageCompleted != null)
			{
				this.AddUserProfileImageCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void UploadImageAsync(StorageFile targetImg)
	{
		new SSMCompletedEventArgs("UploadImageAsync");
		string fileName = Utility.GetTimeStamp() + ".jpg";
		BasicProperties prop = await targetImg.GetBasicPropertiesAsync();
		string address = string.Concat("https://", _svrAddress.FileServer, "/file?uid=", _account.Uid, "&imei=", _account.IMEI, "&filename=", fileName, "&contenttype=image/jpeg&option=1&filepart=1/1&filesize=", prop.Size);
		SSMCompletedEventArgs ret = await HttpPostRequest("UploadImageAsync", address, "", "image/jpeg", targetImg);
		ret.Param = fileName;
		ret.Value = targetImg;
		try
		{
			if (this.UploadImageCompleted != null)
			{
				this.UploadImageCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void DeleteMappingDeviceAsync(string email)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/mapping/delete?uid=", _account.Uid, "&imei=", _account.IMEI);
		string param = "<param><email>" + email + "</email></param>";
		SSMCompletedEventArgs ret = await HttpPostRequest("DeleteMappingDeviceAsync", address, param);
		try
		{
			if (this.DeleteMappingDeviceCompleted != null)
			{
				this.DeleteMappingDeviceCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void UploadGroupImageAsync(string groupName, StorageFile targetImg)
	{
		new SSMCompletedEventArgs("UploadGroupImageAsync");
		string fileName = Utility.GetTimeStamp() + ".jpg";
		string address = string.Concat("https://", _svrAddress.FileServer, "/buddy/group/", groupName.Replace(" ", ","), "/image?uid=", _account.Uid, "&imei=", _account.IMEI, "&filename=", fileName, "&option=1");
		SSMCompletedEventArgs ret = await HttpPostRequest("UploadGroupImageAsync", address, "", "image/jpeg", targetImg);
		ret.Param = fileName;
		ret.Value = targetImg;
		try
		{
			if (this.UploadGroupImageCompleted != null)
			{
				this.UploadGroupImageCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public Uri GetGroupProfileImageUri(string groupName, bool isThumbnail = true, bool forceUpdate = true)
	{
		string text = "";
		text = ((!isThumbnail) ? string.Concat("https://", _svrAddress.FileServer, "/buddy/group/", groupName.Replace(" ", ","), "/image?uid=", _account.Uid, "&imei=", _account.IMEI) : string.Concat("https://", _svrAddress.FileServer, "/buddy/group/", groupName.Replace(" ", ","), "/image?uid=", _account.Uid, "&imei=", _account.IMEI, "&size=160"));
		if (forceUpdate)
		{
			text = text + "&timestamp=" + Utility.GetTimeStamp();
		}
		return new Uri(text);
	}

	public async void DeleteGroupProfileImageAsync(string groupName)
	{
		string address = string.Concat(http, _svrAddress.FileServer, "/delgroupimage?uid=", _account.Uid, "&imei=", _account.IMEI, "&groupname=", groupName);
		SSMCompletedEventArgs ret = await HttpGetRequestString("DeleteGroupProfileImageAsync", address);
		string xmlString = ret.ResultString;
		if (!string.IsNullOrEmpty(xmlString))
		{
			XElement xml = XElement.Load(new StringReader(xmlString));
			ret.Xml = xml;
		}
		try
		{
			if (this.DeleteGroupProfileImageCompleted != null)
			{
				this.DeleteGroupProfileImageCompleted(this, ret);
			}
		}
		catch (Exception ex)
		{
			ret.ErrorMessage = ex.Message;
			this.DeleteGroupProfileImageCompleted(this, ret);
		}
	}

	public async void GetBuddyRecommendIgnoreListAsync()
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/buddyrecommendee/ignorelist?uid=", _account.Uid, "&imei=", _account.IMEI, "&", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetBuddyRecommendIgnoreListAsync", address);
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			try
			{
				if (this.GetBuddyRecommendIgnoreListCompleted != null)
				{
					this.GetBuddyRecommendIgnoreListCompleted(this, ret);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		ret.Xml = xe;
		try
		{
			if (this.GetBuddyRecommendIgnoreListCompleted != null)
			{
				this.GetBuddyRecommendIgnoreListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void UploadBuddyRecommendIgnoreListAsync(string number)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/buddyrecommendee/ignorelist?uid=", _account.Uid, "&imei=", _account.IMEI);
		string param = "<param><ignore isignore=\"true\">" + number + "</ignore></param>";
		SSMCompletedEventArgs ret = await HttpPostRequest("UploadBuddyRecommendIgnoreListAsync", address, param);
		try
		{
			if (this.UploadBuddyRecommendIgnoreListCompleted != null)
			{
				this.UploadBuddyRecommendIgnoreListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void UploadBuddyRecommendIgnoreListAsync(List<string> number)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/buddyrecommendee/ignorelist?uid=", _account.Uid, "&imei=", _account.IMEI);
		string param = "<param>";
		foreach (string item in number)
		{
			param = param + "<ignore isignore=\"true\">" + item + "</ignore>";
		}
		param += "</param>";
		SSMCompletedEventArgs ret = await HttpPostRequest("UploadBuddyRecommendIgnoreListAsync", address, param);
		try
		{
			if (this.UploadBuddyRecommendIgnoreListCompleted != null)
			{
				this.UploadBuddyRecommendIgnoreListCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void SetChatRoomProfileImageAsync(string sessionId, string imageAddress, string imagePath)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/chat/profileimage?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&imageaddr=", imageAddress, "&imagefilepath=", imagePath, "&r=", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpPostRequest("SetChatRoomProfileImageAsync", address, "");
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			try
			{
				if (this.SetChatRoomProfileImageCompleted != null)
				{
					this.SetChatRoomProfileImageCompleted(this, ret);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		ret.Xml = xe;
		try
		{
			if (this.SetChatRoomProfileImageCompleted != null)
			{
				this.SetChatRoomProfileImageCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public string CreateGetChatRoomProfileImageAsync(string sessionId, string imageAddress, string imagePath)
	{
		return string.Concat(http, _svrAddress.ContactServer, "/chat/profileimage?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&", Utility.GetTimeStamp());
	}

	public async Task<string> CreateGetChatRoomProfileImageUrlAsync(string sessionId)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/chat/profileimage?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&", Utility.GetTimeStamp());
		return (await HttpGetRequestString("CreateGetChatRoomProfileImageUrlAsync", address)).ResultString;
	}

	public void CreateGetTrunkListAsync(DataService _dataService, out string addressResult, out string paramResult)
	{
		string text = string.Concat("https://", _svrAddress.ContactServer, "/trunklist?uid=", _account.Uid, "&imei=", _account.IMEI);
		string text2 = "<param>";
		int num = 0;
		foreach (Chat chatItem in _dataService.ChatItems)
		{
			if (!string.IsNullOrEmpty(chatItem.SessionID))
			{
				text2 = text2 + "<sessionid>" + chatItem.SessionID + "</sessionid>";
				num++;
			}
		}
		text2 += "</param>";
		addressResult = text;
		paramResult = text2;
	}

	public async void GetChatRoomProfileImageAsync(string sessionId, string imageAddress, string imagePath)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/chat/profileimage?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetChatRoomProfileImageAsync", address);
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			try
			{
				if (this.GetChatRoomProfileImageCompleted != null)
				{
					this.GetChatRoomProfileImageCompleted(this, ret);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		ret.Xml = xe;
		try
		{
			if (this.GetChatRoomProfileImageCompleted != null)
			{
				this.GetChatRoomProfileImageCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void DeleteChatRoomProfileImageAsync(string sessionId, string imageAddress, string imagePath)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/chat/profileimage?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&r=", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpDeleteRequest("DeleteChatRoomProfileImageAsync", address, "");
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			try
			{
				if (this.DeleteChatRoomProfileImageCompleted != null)
				{
					this.DeleteChatRoomProfileImageCompleted(this, ret);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		ret.Xml = xe;
		try
		{
			if (this.DeleteChatRoomProfileImageCompleted != null)
			{
				this.DeleteChatRoomProfileImageCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void DeleteFileChatRoomProfileImageAsync(string sessionId, string imageAddress, string imagePath)
	{
		string addressHttp = string.Concat(http, _svrAddress.FileServer, "/file/image?uid=", _account.Uid, "&imei=", _account.IMEI, "&filename=", imagePath);
		SSMCompletedEventArgs ret2 = await HttpDeleteRequest("DeleteFileChatRoomProfileImageAsync", addressHttp, "");
		if (string.IsNullOrEmpty(ret2.ResultString))
		{
			try
			{
				if (this.DeleteFileChatRoomProfileImageCompleted != null)
				{
					this.DeleteFileChatRoomProfileImageCompleted(this, ret2);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		XElement xe = XElement.Load(new StringReader(ret2.ResultString));
		ret2.Xml = xe;
		try
		{
			if (this.DeleteFileChatRoomProfileImageCompleted != null)
			{
				this.DeleteFileChatRoomProfileImageCompleted(this, ret2);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void SetChatRoomTitleAsync(string sessionId, string title)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/chat/title?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&title=", title);
		SSMCompletedEventArgs ret = await HttpPostRequest("SetChatRoomTitleAsync", address, "");
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			try
			{
				if (this.SetChatRoomTitleInfoCompleted != null)
				{
					this.SetChatRoomTitleInfoCompleted(this, ret);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		ret.Xml = xe;
		try
		{
			if (this.SetChatRoomTitleInfoCompleted != null)
			{
				this.SetChatRoomTitleInfoCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public string CreateGetAllMessageAsync(string sessionId, string tId, string count)
	{
		return string.Concat(http, _svrAddress.ContactServer, "/chat/allmessages?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&tid=", tId, "&count=", count, "&", Utility.GetTimeStamp());
	}

	public async void GetAllMessageAsync(string sessionId, string tId, string count)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/chat/allmessages?uid=", _account.Uid, "&imei=", _account.IMEI, "&sessionid=", sessionId, "&tid=", tId, "&count=", count, "&", Utility.GetTimeStamp());
		SSMCompletedEventArgs ret = await HttpClientGetString("GetAllMessageAsync", address);
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			try
			{
				if (this.GetAllMessageCompleted != null)
				{
					this.GetAllMessageCompleted(this, ret);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		ret.Xml = xe;
		ret.Param = sessionId;
		try
		{
			if (this.GetAllMessageCompleted != null)
			{
				this.GetAllMessageCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void CheckNoticeAsync(string lang)
	{
		string address = "https://smm.samsung.com/resws/mwv/notice/windows%20mobile/" + lang + "/list.json";
		SSMCompletedEventArgs ret = await HttpGetRequestString("CheckNoticeAsync", address);
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			try
			{
				if (this.CheckNoticeCompleted != null)
				{
					this.CheckNoticeCompleted(this, ret);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		ret.Param = ret.ResultString;
		try
		{
			if (this.CheckNoticeCompleted != null)
			{
				this.CheckNoticeCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void CheckRegParamAsync(string parameter, bool isUpdateMsisdn)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/reg/checkin?uid=", _account.Uid, "&imei=", _account.IMEI);
		string param = "<param>";
		param = param + "<msisdn>" + parameter + "</msisdn>";
		param = param + "<imei>" + _account.IMEI + "</imei>";
		param += "</param>";
		SSMCompletedEventArgs ret = await HttpPostRequest("CheckinRegParamAsync", address, param);
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			try
			{
				if (this.CheckRegParamCompleted != null)
				{
					this.CheckRegParamCompleted(this, ret);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		ret.Xml = xe;
		try
		{
			if (this.CheckRegParamCompleted != null)
			{
				this.CheckRegParamCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public static async Task ShowCommonErrorMessage(SSMCompletedEventArgs e)
	{
		try
		{
			if (e.StatusCode == HttpStatusCode.NoContent || (e.StatusCode == (HttpStatusCode)0 && e.Error == null && string.IsNullOrEmpty(e.ErrorMessage)))
			{
				return;
			}
			if (asyncCommand != null)
			{
				((IAsyncInfo)asyncCommand).Cancel();
			}
			if (string.IsNullOrEmpty(e.ErrorMessage))
			{
				try
				{
					MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"));
					asyncCommand = dialog.ShowAsync();
					return;
				}
				catch
				{
					return;
				}
			}
			if (e.ErrorMessage.Contains("CCS-00012") || e.ErrorMessage.Contains("CCS-00011"))
			{
				try
				{
					MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NUMBER_ALREADY_IN_USE_REGISTER_AGAIN_WITH_ANOTHER_NUMBER"));
					await dialog.ShowAsync();
					Utility.UpdateMainTileCount(0);
					await Utility.ClearTileInformation();
					try
					{
						await ApplicationData.Current.ClearAsync();
					}
					catch (Exception)
					{
					}
					if ((await SecondaryTile.FindAllAsync()).Count == 0)
					{
						Application.Current.Exit();
					}
					return;
				}
				catch
				{
					return;
				}
			}
			if (e.ErrorMessage.Contains("13003"))
			{
				try
				{
					MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_INVALID_PHONE_NUMBER_FORMAT"));
					asyncCommand = dialog.ShowAsync();
					return;
				}
				catch
				{
					return;
				}
			}
			if (e.ErrorMessage.Contains("CCS-41900"))
			{
				try
				{
					MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NO_RESPONSE_FROM_SERVER"));
					asyncCommand = dialog.ShowAsync();
					return;
				}
				catch
				{
					return;
				}
			}
			if (e.ErrorMessage.Contains("CSS-11002"))
			{
				try
				{
					MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_INVALID_PHONE_NUMBER_FORMAT"));
					asyncCommand = dialog.ShowAsync();
					return;
				}
				catch
				{
					return;
				}
			}
			if (e.ErrorMessage.Contains("CCS-93403"))
			{
				try
				{
					MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_COMMENT_ALREADY_POSTED_ON_BUDDIES_SAY"));
					asyncCommand = dialog.ShowAsync();
					return;
				}
				catch
				{
					return;
				}
			}
			if (e.ErrorMessage.Contains("CCS-89405"))
			{
				try
				{
					MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_COMMENT_ALREADY_POSTED"));
					asyncCommand = dialog.ShowAsync();
					return;
				}
				catch
				{
					return;
				}
			}
			if (e.ErrorMessage.Contains("CCS-00013"))
			{
				try
				{
					string msg = Utility.GetResourceString("IDS_CHATON_POP_THIS_DEVICE_WAS_RESET_OVER_THE_WEB_REGISTER_IT_AGAIN_TO_USE_IT");
					MessageDialog dialog = new MessageDialog(msg);
					await dialog.ShowAsync();
					Utility.UpdateMainTileCount(0);
					await Utility.ClearTileInformation();
					try
					{
						await ApplicationData.Current.ClearAsync();
					}
					catch (Exception)
					{
					}
					Application.Current.Exit();
					return;
				}
				catch
				{
					return;
				}
			}
			if (e.ErrorMessage.Contains("00800"))
			{
				try
				{
					string resourceString = Utility.GetResourceString("IDS_CHATON_POP_PSS_SAMSUNG_ACCOUNT_IS_SYNCHRONISING_WITH_CHATON_TRY_LATER");
					resourceString = resourceString.Replace("%s", "");
					MessageDialog dialog = new MessageDialog(resourceString);
					asyncCommand = dialog.ShowAsync();
					return;
				}
				catch
				{
					return;
				}
			}
			if (e.ErrorMessage.Contains("50005"))
			{
				try
				{
					string resourceString2 = Utility.GetResourceString("IDS_CHATON_POP_PSS_SAMSUNG_ACCOUNT_IS_SYNCHRONISING_WITH_CHATON_TRY_LATER");
					resourceString2 = resourceString2.Replace("%s", "");
					MessageDialog dialog = new MessageDialog(resourceString2);
					asyncCommand = dialog.ShowAsync();
					return;
				}
				catch
				{
					return;
				}
			}
			if (e.ErrorMessage.Contains("CCS-11023"))
			{
				try
				{
					string resourceString3 = Utility.GetResourceString("IDS_CHATON_POP_PD_DEVICES_ARE_ALREADY_CONNECTED_DISCONNECT_A_DEVICE_AND_TRY_AGAIN");
					resourceString3 = resourceString3.Replace("%d", "5");
					MessageDialog dialog = new MessageDialog(resourceString3);
					asyncCommand = dialog.ShowAsync();
					return;
				}
				catch
				{
					return;
				}
			}
			try
			{
				MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"));
				asyncCommand = dialog.ShowAsync();
			}
			catch
			{
			}
		}
		catch (Exception)
		{
		}
	}

	public async Task<SSMCompletedEventArgs> HttpClientGetString(string requestName, string uriString, bool decrypt = false, int timeout = 30)
	{
		string resultString = null;
		string log = "\n========== " + requestName + " ==========";
		SSMCompletedEventArgs ret = new SSMCompletedEventArgs();
		try
		{
			Uri uri = new Uri(uriString);
			log = log + "\n[URI] " + uri;
			HttpMessageHandler requestHandler = new HttpClientHandler();
			HttpClient client = new HttpClient(requestHandler)
			{
				Timeout = TimeSpan.FromSeconds(timeout)
			};
			Stream resultStream = null;
			try
			{
				HttpResponseMessage response = await client.GetAsync(uri);
				log = log + "\n[Http Response Code] " + response.StatusCode;
				ret.StatusCode = response.StatusCode;
				resultStream = await response.Content.ReadAsStreamAsync();
			}
			catch (Exception ex)
			{
				Exception ex2 = (ret.Error = ex);
				if (ex2 is WebException { Response: not null } ex4)
				{
					string serverErrorMessage = GetServerErrorMessage(ex4);
					object obj = log;
					log = string.Concat(obj, '\n', "[Error Message]", serverErrorMessage);
					ret.ErrorMessage = serverErrorMessage;
				}
			}
			if (resultStream == null)
			{
				log += "\nResponseStream is NULL!";
			}
			else if (resultStream.CanRead)
			{
				if (decrypt)
				{
					log = log + "\n[Decrypt] " + decrypt;
					byte[] array = null;
					using (MemoryStream memoryStream = new MemoryStream())
					{
						resultStream.CopyTo(memoryStream);
						array = memoryStream.ToArray();
					}
					if (array != null)
					{
						Utility.Decrypt(_svrAddress.Key, array, out resultString);
					}
				}
				else
				{
					StreamReader streamReader = new StreamReader(resultStream);
					resultString = streamReader.ReadToEnd();
					streamReader.Dispose();
				}
				log = log + "\n[Payload] " + resultString;
			}
			log = (ret.Log = log + "\n====FIN=== " + requestName + " =========\n");
			ret.ResultString = resultString;
			return ret;
		}
		catch (Exception ex5)
		{
			Exception ex6 = (ret.Error = ex5);
			if (ex6 is WebException { Response: not null } ex8)
			{
				string serverErrorMessage2 = GetServerErrorMessage(ex8);
				object obj2 = log;
				string.Concat(obj2, '\n', "[Error Message]", serverErrorMessage2);
				ret.ErrorMessage = serverErrorMessage2;
			}
			return ret;
		}
	}

	public async void GetNewUpdateListAsync(long timeStamp)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/newupdate/list?uid=", _account.Uid, "&imei=", _account.IMEI, "&count=100&timestamp=", timeStamp);
		SSMCompletedEventArgs ret = await HttpGetRequestString("GetBuddyRecommendListAsync", address);
		if (!string.IsNullOrEmpty(ret.ResultString))
		{
			XElement xml = XElement.Load(new StringReader(ret.ResultString));
			ret.Xml = xml;
		}
		try
		{
			if (this.NewUpdateCompleted != null)
			{
				this.NewUpdateCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetMixedMessage(bool isActive)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/compatibility?uid=", _account.Uid, "&imei=", _account.IMEI);
		string param = "<param>";
		param += "<compatibility>";
		param += "<type>mixed message</type>";
		param = param + "<value>" + isActive.ToString().ToLower() + "</value>";
		param += "</compatibility>";
		param += "</param>";
		SSMCompletedEventArgs ret = await HttpPostRequest("GetPushUpdatesAsync", address, param);
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			try
			{
				ret.ResultString = isActive.ToString().ToLower();
				if (this.GetMixedMessageCompleted != null)
				{
					this.GetMixedMessageCompleted(this, ret);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		ret.Xml = xe;
		try
		{
			if (this.GetMixedMessageCompleted != null)
			{
				this.GetMixedMessageCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void GetPushUpdates(bool isActive)
	{
		string address = string.Concat(http, _svrAddress.ContactServer, "/compatibility?uid=", _account.Uid, "&imei=", _account.IMEI);
		string param = "<param>";
		param += "<compatibility>";
		param += "<type>feed push</type>";
		param = param + "<value>" + isActive.ToString().ToLower() + "</value>";
		param += "</compatibility>";
		param += "</param>";
		SSMCompletedEventArgs ret = await HttpPostRequest("GetPushUpdatesAsync", address, param);
		if (string.IsNullOrEmpty(ret.ResultString))
		{
			try
			{
				ret.ResultString = isActive.ToString().ToLower();
				if (this.GetPushUpdateCompleted != null)
				{
					this.GetPushUpdateCompleted(this, ret);
				}
				return;
			}
			catch (Exception)
			{
				return;
			}
		}
		XElement xe = XElement.Load(new StringReader(ret.ResultString));
		ret.Xml = xe;
		try
		{
			if (this.GetPushUpdateCompleted != null)
			{
				this.GetPushUpdateCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public async void PushMarketingFeedbackAsync(string mid, FeedbackEvent.FeedbackID fbId, string userFeedbackValue)
	{
		string http = BIGJOE_SERVER_PROD;
		if (PushService.Instance.GetPushChannelUri() == null || PushService.Instance.GetPushChannelUri() == "")
		{
			return;
		}
		string platform = "wm_wns";
		string packageName = "com.sec.chaton";
		int try_count_max = 5;
		int try_count = 0;
		string address = http + "/feedback/wm/" + mid;
		WebHeaderCollection header = new WebHeaderCollection { ["model"] = Utility.GetDeviceName() };
		string pushRegID = PushService.Instance.GetPushChannel();
		string param = ((!(userFeedbackValue != "")) ? ("{\"service\":\"" + packageName + "\",\"fbId\":" + (int)fbId + ",\"time\":\"" + Utility.GetTimeStamp() + "\",\"platform\":\"" + platform + "\",\"pushRegId\":\"" + pushRegID + "\"}") : ("{\"service\":\"" + packageName + "\",\"fbId\":" + (int)fbId + ",\"time\":\"" + Utility.GetTimeStamp() + "\",\"userFeedbackValue\":\"" + userFeedbackValue + "\",\"platform\":\"" + platform + "\",\"pushRegId\":\"" + PushService.Instance.GetPushChannelUri() + "\"}"));
		SSMCompletedEventArgs ret;
		do
		{
			ret = await HttpPostRequestUsingHeaderJSON("PushMarketingFeedback", address, param, header);
			try_count++;
		}
		while (ret != null && (ret.Error.Message.Contains("500") || ret.Error.Message.Contains("503") || ret.Error.Message.Contains("560")) && try_count_max > try_count);
		try
		{
			if (this.PushMarketingFeedbackCompleted != null)
			{
				this.PushMarketingFeedbackCompleted(this, ret);
			}
		}
		catch (Exception)
		{
		}
	}

	public string EncodeURLPushMarketing(string url)
	{
		url = url.Replace(":", "%253A");
		url = url.Replace("/", "%252F");
		return url;
	}

	public async void AppAgreePushMarketingAsync(string pkgName, string netMcc = "", string simMcc = "", string mnc = "")
	{
		string http = BIGJOE_SERVER_PROD;
		string address = http + "/app/agree/" + WebUtility.UrlEncode(PushService.Instance.GetPushChannelUri());
		WebHeaderCollection header = new WebHeaderCollection { ["model"] = Utility.GetDeviceName() };
		if (netMcc != "")
		{
			header["netMcc"] = "";
		}
		if (simMcc != "")
		{
			header["simMcc"] = "";
		}
		if (mnc != "")
		{
			header["mnc"] = "";
		}
		string param = "{\"service\":\"com.sec.chaton\"}";
		(await HttpPostRequestUsingHeaderJSON("AppAgreePushMarketing", address, param, header)).Error.ToString();
	}

	public async void AppDisagreePushMarketingAsync(string pkgName, string netMcc = "", string simMcc = "", string mnc = "")
	{
		string http = BIGJOE_SERVER_PROD;
		string address = http + "/app/disagree/" + WebUtility.UrlEncode(PushService.Instance.GetPushChannelUri());
		WebHeaderCollection header = new WebHeaderCollection { ["model"] = Utility.GetDeviceName() };
		if (netMcc != "")
		{
			header["netMcc"] = "";
		}
		if (simMcc != "")
		{
			header["simMcc"] = "";
		}
		if (mnc != "")
		{
			header["mnc"] = "";
		}
		string param = "<param>";
		if (pkgName != null)
		{
			param = param + "<service>" + pkgName + "</service>";
		}
		param += "</param>";
		await HttpPostRequestUsingHeader("AppDisagreePushMarketing", address, param, header);
	}

	public async void AppDeregisterPushMarketingAsync(string pkgName, string netMcc = "", string simMcc = "", string mnc = "")
	{
		string http = BIGJOE_SERVER_PROD;
		string address = http + "/app/deregistration/" + WebUtility.UrlEncode(PushService.Instance.GetPushChannelUri());
		WebHeaderCollection header = new WebHeaderCollection { ["model"] = Utility.GetDeviceName() };
		if (netMcc != "")
		{
			header["netMcc"] = "";
		}
		if (simMcc != "")
		{
			header["simMcc"] = "";
		}
		if (mnc != "")
		{
			header["mnc"] = "";
		}
		string param = "<param>";
		if (pkgName != null)
		{
			param = param + "<service>" + pkgName + "</service>";
		}
		param += "</param>";
		await HttpPostRequestUsingHeader("AppDeregisterPushMarketing", address, param, header);
	}

	private async Task<SSMCompletedEventArgs> HttpPostRequestUsingHeaderJSON(string requestName, string uriString, string param, WebHeaderCollection header = null, string contentType = "application/json", StorageFile wb = null)
	{
		SSMCompletedEventArgs result = new SSMCompletedEventArgs();
		string resultString = null;
		string log = "\n========== " + requestName + " ==========";
		try
		{
			new Uri(uriString);
			log = log + "\n[URI] " + uriString;
			log = log + "\n[PARAM] " + param;
			HttpWebRequest httpRequest = (HttpWebRequest)WebRequest.Create(uriString);
			httpRequest.Method = "POST";
			httpRequest.ContentType = contentType;
			httpRequest.Headers = header;
			log = log + "\n[Method] " + httpRequest.Method;
			if (!string.IsNullOrEmpty(param) || wb != null)
			{
				UTF8Encoding encoding = new UTF8Encoding();
				byte[] postBytes = null;
				if (contentType == "application/json")
				{
					postBytes = encoding.GetBytes(param);
				}
				else
				{
					postBytes = await ConvertImagetoByte(wb);
				}
				Stream postStream = null;
				await Task.Run(delegate
				{
					ManualResetEvent allDone = new ManualResetEvent(initialState: false);
					httpRequest.BeginGetRequestStream(delegate(IAsyncResult r)
					{
						try
						{
							postStream = httpRequest.EndGetRequestStream(r);
							postStream.Write(postBytes, 0, postBytes.Length);
							postStream.Dispose();
						}
						catch (WebException ex2)
						{
							log = log + "\n" + ex2.Message;
							result.Error = ex2;
							if (ex2.Response != null)
							{
								string serverErrorMessage = GetServerErrorMessage(ex2);
								object obj2 = log;
								log = string.Concat(obj2, '\n', "[Error Message]", serverErrorMessage);
								result.ErrorMessage = serverErrorMessage;
							}
						}
						allDone.Set();
					}, httpRequest);
					allDone.WaitOne();
				});
				object obj = log;
				log = string.Concat(obj, "\n[", postBytes.Length, "bytes posted]");
			}
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
					catch (WebException ex2)
					{
						log = log + "\n" + ex2.Message;
						result.Error = ex2;
						if (ex2.Response != null)
						{
							string serverErrorMessage = GetServerErrorMessage(ex2);
							object obj2 = log;
							log = string.Concat(obj2, '\n', "[Error Message]", serverErrorMessage);
							result.ErrorMessage = serverErrorMessage;
						}
					}
					allDone2.Set();
				}, httpRequest);
				allDone2.WaitOne();
			});
			if (httpResponse != null)
			{
				log = log + "\n[Http Response Code] " + httpResponse.StatusCode;
				result.StatusCode = httpResponse.StatusCode;
				Stream responseStream = httpResponse.GetResponseStream();
				if (responseStream == null)
				{
					log += "\nResponseStream is NULL!";
				}
				else
				{
					StreamReader streamReader = new StreamReader(responseStream);
					resultString = streamReader.ReadToEnd();
					streamReader.Dispose();
					log = log + "\n[Payload] " + resultString;
				}
			}
		}
		catch (Exception)
		{
		}
		log = log + "\n====FIN=== " + requestName + " ==========\n";
		result.ResultString = resultString;
		return result;
	}

	private async Task<SSMCompletedEventArgs> HttpPostRequestUsingHeader(string requestName, string uriString, string param, WebHeaderCollection header, string contentType = "text/xml", StorageFile wb = null)
	{
		SSMCompletedEventArgs result = new SSMCompletedEventArgs();
		string resultString = null;
		string log = "\n========== " + requestName + " ==========";
		try
		{
			Uri uri = new Uri(uriString);
			log = log + "\n[URI] " + uri;
			log = log + "\n[PARAM] " + param;
			HttpWebRequest httpRequest = (HttpWebRequest)WebRequest.Create(uri);
			if (header != null)
			{
				httpRequest.Headers = header;
			}
			httpRequest.Method = "POST";
			httpRequest.ContentType = contentType;
			log = log + "\n[Method] " + httpRequest.Method;
			if (!string.IsNullOrEmpty(param) || wb != null)
			{
				UTF8Encoding encoding = new UTF8Encoding();
				byte[] postBytes = null;
				if (contentType == "text/xml")
				{
					postBytes = encoding.GetBytes(param);
				}
				else
				{
					postBytes = await ConvertImagetoByte(wb);
				}
				Stream postStream = null;
				await Task.Run(delegate
				{
					ManualResetEvent allDone = new ManualResetEvent(initialState: false);
					httpRequest.BeginGetRequestStream(delegate(IAsyncResult r)
					{
						try
						{
							postStream = httpRequest.EndGetRequestStream(r);
							postStream.Write(postBytes, 0, postBytes.Length);
							postStream.Dispose();
						}
						catch (WebException ex2)
						{
							log = log + "\n" + ex2.Message;
							result.Error = ex2;
							if (ex2.Response != null)
							{
								string serverErrorMessage = GetServerErrorMessage(ex2);
								object obj2 = log;
								log = string.Concat(obj2, '\n', "[Error Message]", serverErrorMessage);
								result.ErrorMessage = serverErrorMessage;
							}
						}
						allDone.Set();
					}, httpRequest);
					allDone.WaitOne();
				});
				object obj = log;
				log = string.Concat(obj, "\n[", postBytes.Length, "bytes posted]");
			}
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
					catch (WebException ex2)
					{
						log = log + "\n" + ex2.Message;
						result.Error = ex2;
						if (ex2.Response != null)
						{
							string serverErrorMessage = GetServerErrorMessage(ex2);
							object obj2 = log;
							log = string.Concat(obj2, '\n', "[Error Message]", serverErrorMessage);
							result.ErrorMessage = serverErrorMessage;
						}
					}
					allDone2.Set();
				}, httpRequest);
				allDone2.WaitOne();
			});
			if (httpResponse != null)
			{
				log = log + "\n[Http Response Code] " + httpResponse.StatusCode;
				result.StatusCode = httpResponse.StatusCode;
				Stream responseStream = httpResponse.GetResponseStream();
				if (responseStream == null)
				{
					log += "\nResponseStream is NULL!";
				}
				else
				{
					StreamReader streamReader = new StreamReader(responseStream);
					resultString = streamReader.ReadToEnd();
					streamReader.Dispose();
					log = log + "\n[Payload] " + resultString;
				}
			}
		}
		catch (Exception)
		{
		}
		log = log + "\n====FIN=== " + requestName + " ==========\n";
		result.ResultString = resultString;
		return result;
	}
}
