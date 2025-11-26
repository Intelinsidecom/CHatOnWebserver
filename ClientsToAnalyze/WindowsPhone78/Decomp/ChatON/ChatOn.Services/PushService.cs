using System;
using ChatOn.Res;
using Microsoft.Phone.Notification;

namespace ChatOn.Services;

public class PushService
{
	private const string _CHATON_PUSHCHANNELNAME = "ChatOnChannel";

	private static PushService _instance;

	private static HttpNotificationChannel _pushChannel;

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

	public event EventHandler<NotificationEventArgs> GetToastNotificationReceived;

	public event EventHandler<NotificationChannelUriEventArgs> PushChannelUpdated;

	public event EventHandler<PushServiceEventArgs> PushChannelErrorOccurred;

	public event EventHandler<PushServiceEventArgs> PushChannelOpenFailed;

	public PushService()
	{
		_pushChannel = null;
	}

	public void ResetChannelUpdatedEventHandler()
	{
		this.PushChannelUpdated = null;
	}

	public void InitService()
	{
		_pushChannel = HttpNotificationChannel.Find("ChatOnChannel");
		if (_pushChannel == null)
		{
			CreateNewPushChannel();
		}
		else if (_pushChannel.ChannelUri != null)
		{
			SettingService.SetUsingPushNotification(isUsed: true);
			AddEventHandler();
		}
		else
		{
			_pushChannel.Close();
			CreateNewPushChannel();
		}
	}

	public void StopService()
	{
		SettingService.SetUsingPushNotification(isUsed: false);
		_pushChannel = HttpNotificationChannel.Find("ChatOnChannel");
		if (_pushChannel == null)
		{
			return;
		}
		try
		{
			_pushChannel.Close();
		}
		catch (Exception ex)
		{
			PushServiceEventArgs e = new PushServiceEventArgs(PushServiceErrorType.CannotClosePushChannel, null, ex.Message, hasToNotify: true);
			if (this.PushChannelErrorOccurred != null)
			{
				this.PushChannelErrorOccurred(this, e);
			}
		}
	}

	public bool IsEnable()
	{
		_pushChannel = HttpNotificationChannel.Find("ChatOnChannel");
		if (_pushChannel != null)
		{
			return _pushChannel.ChannelUri != null;
		}
		return false;
	}

	private void CreateNewPushChannel()
	{
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_000f: Expected O, but got Unknown
		_pushChannel = new HttpNotificationChannel("ChatOnChannel");
		AddEventHandler();
		try
		{
			_pushChannel.Open();
			_pushChannel.BindToShellToast();
			_pushChannel.BindToShellTile();
		}
		catch (Exception)
		{
			SettingService.SetUsingPushNotification(isUsed: false);
			PushServiceEventArgs e = new PushServiceEventArgs(PushServiceErrorType.CannotOpenPushChannel, ResContainer.WP7_CHATON_PUSHERROR_POPUPTITLE, ResContainer.WP7_CHATON_PUSHERROR_CHANNELOPENFAILED, hasToNotify: true);
			if (this.PushChannelOpenFailed != null)
			{
				this.PushChannelOpenFailed(this, e);
			}
		}
	}

	private void AddEventHandler()
	{
		_pushChannel.ChannelUriUpdated += PushChannel_ChannelUriUpdated;
		_pushChannel.ErrorOccurred += PushChannel_ErrorOccurred;
		_pushChannel.ShellToastNotificationReceived += PushChannel_ShellToastNotificationReceived;
		_pushChannel.ConnectionStatusChanged += PushChannel_ConnectionStatusChanged;
	}

	private void PushChannel_ConnectionStatusChanged(object sender, NotificationChannelConnectionEventArgs e)
	{
	}

	public string GetPushChannelUri()
	{
		if (_pushChannel == null || _pushChannel.ChannelUri == null)
		{
			return string.Empty;
		}
		return _pushChannel.ChannelUri.ToString();
	}

	private void PushChannel_ChannelUriUpdated(object sender, NotificationChannelUriEventArgs e)
	{
		SettingService.SetUsingPushNotification(isUsed: true);
		if (this.PushChannelUpdated != null)
		{
			this.PushChannelUpdated(sender, e);
		}
	}

	private void PushChannel_ErrorOccurred(object sender, NotificationChannelErrorEventArgs e)
	{
		//IL_0003: Unknown result type (might be due to invalid IL or missing references)
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0027: Expected I4, but got Unknown
		//IL_007f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0080: Unknown result type (might be due to invalid IL or missing references)
		//IL_0081: Unknown result type (might be due to invalid IL or missing references)
		//IL_0082: Unknown result type (might be due to invalid IL or missing references)
		//IL_0094: Expected I4, but got Unknown
		PushServiceEventArgs e2 = null;
		ChannelErrorType errorType = e.ErrorType;
		switch ((int)errorType)
		{
		case 0:
			if (this.PushChannelOpenFailed != null)
			{
				e2 = new PushServiceEventArgs(PushServiceErrorType.CannotOpenPushChannel, ResContainer.WP7_CHATON_PUSHERROR_POPUPTITLE, ResContainer.WP7_CHATON_PUSHERROR_CHANNELOPENFAILED, hasToNotify: true);
				this.PushChannelOpenFailed(sender, e2);
				return;
			}
			break;
		case 1:
			StopService();
			InitService();
			break;
		case 3:
			e2 = new PushServiceEventArgs(PushServiceErrorType.PushSpeedTooHigh, ResContainer.WP7_CHATON_PUSHERROR_POPUPTITLE, ResContainer.WP7_CHATON_PUSHERROR_RATETOOHIGH, hasToNotify: true);
			break;
		case 4:
		{
			ChannelPowerLevel val = (ChannelPowerLevel)e.ErrorAdditionalData;
			ChannelPowerLevel val2 = val;
			switch ((int)val2)
			{
			case 1:
			case 2:
				e2 = new PushServiceEventArgs(PushServiceErrorType.BatteryTooLow, ResContainer.WP7_CHATON_PUSHERROR_POPUPTITLE, ResContainer.WP7_CHATON_PUSHERROR_BATTERYTOOLOW, hasToNotify: true);
				break;
			}
			break;
		}
		case 5:
			e2 = new PushServiceEventArgs(PushServiceErrorType.ErrorTypeUnknown, ResContainer.WP7_CHATON_PUSHERROR_POPUPTITLE, ResContainer.WP7_CHATON_PUSHERROR_NEEDTOREBOOT, hasToNotify: true);
			break;
		}
		if (this.PushChannelErrorOccurred != null && e2 != null)
		{
			this.PushChannelErrorOccurred(sender, e2);
		}
	}

	private void PushChannel_ShellToastNotificationReceived(object sender, NotificationEventArgs e)
	{
		if (this.GetToastNotificationReceived != null)
		{
			this.GetToastNotificationReceived(sender, e);
		}
	}
}
