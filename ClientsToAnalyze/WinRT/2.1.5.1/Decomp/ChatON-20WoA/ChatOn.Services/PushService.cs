using System;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using Windows.Foundation;
using Windows.Networking.PushNotifications;

namespace ChatOn.Services;

public class PushService
{
	private const string _sid = "ms-app://s-1-15-2-3912383789-1976489096-3212746222-2312592706-1801185371-3680571184-684364216";

	private const string _secret = "eWNsenzOpUD5fZvgN203pv/9l+qJs2LX";

	private static PushService _instance;

	private static PushNotificationChannel _pushChannel;

	public static PushService Instance
	{
		get
		{
			if (_instance == null)
			{
				_instance = new PushService();
			}
			return _instance;
		}
	}

	public string SID => "ms-app://s-1-15-2-3912383789-1976489096-3212746222-2312592706-1801185371-3680571184-684364216";

	public string Secret => Uri.EscapeDataString("eWNsenzOpUD5fZvgN203pv/9l+qJs2LX");

	public event EventHandler<PushNotificationArgs> GetToastNotificationReceived;

	public event EventHandler<string> GetPushChannelOpenFailed;

	public PushService()
	{
		_pushChannel = null;
	}

	public void ResetChannelUpdatedEventHandler()
	{
	}

	public unsafe async Task<bool> InitService()
	{
		SettingService.SetUsingPushNotification(isUsed: true);
		SettingService.SetToggleNewUpdatesPushNotification(isUsed: true);
		SettingService.SetTogglePushMarketingNotification(isUsed: true);
		try
		{
			_pushChannel = await PushNotificationChannelManager.CreatePushNotificationChannelForApplicationAsync();
		}
		catch (Exception)
		{
			return false;
		}
		if (_pushChannel != null && _pushChannel.Uri != null)
		{
			PushNotificationChannel pushChannel = _pushChannel;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<PushNotificationChannel, PushNotificationReceivedEventArgs>, EventRegistrationToken>(pushChannel, (nint)__ldftn(PushNotificationChannel.add_PushNotificationReceived)), new Action<EventRegistrationToken>(pushChannel, (nint)__ldftn(PushNotificationChannel.remove_PushNotificationReceived)), PushChannel_NotificationReceived);
		}
		return _pushChannel != null && _pushChannel.Uri != null;
	}

	private void PushChannel_NotificationReceived(PushNotificationChannel sender, PushNotificationReceivedEventArgs args)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_002f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0035: Invalid comparison between Unknown and I4
		//IL_0038: Unknown result type (might be due to invalid IL or missing references)
		try
		{
			if ((int)args.NotificationType == 0)
			{
				if (this.GetToastNotificationReceived != null)
				{
					this.GetToastNotificationReceived(sender, new PushNotificationArgs(args.ToastNotification.Content));
				}
			}
			else if ((int)args.NotificationType != 1)
			{
				_ = args.NotificationType;
				_ = 2;
			}
		}
		catch (Exception)
		{
		}
	}

	public void StopService()
	{
		SettingService.SetUsingPushNotification(isUsed: false);
		SettingService.SetToggleNewUpdatesPushNotification(isUsed: false);
		SettingService.SetTogglePushMarketingNotification(isUsed: false);
		if (_pushChannel == null)
		{
			return;
		}
		try
		{
			_pushChannel.Close();
		}
		catch (Exception)
		{
		}
	}

	public bool IsEnable()
	{
		if (_pushChannel != null)
		{
			return _pushChannel.Uri != null;
		}
		return false;
	}

	public string GetPushChannelUri()
	{
		if (_pushChannel == null || _pushChannel.Uri == null)
		{
			return string.Empty;
		}
		return Uri.EscapeUriString(_pushChannel.Uri);
	}

	public string GetPushChannel()
	{
		if (_pushChannel == null || _pushChannel.Uri == null)
		{
			return string.Empty;
		}
		return _pushChannel.Uri;
	}
}
