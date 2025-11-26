namespace ChatOn.Services;

public enum PushServiceErrorType
{
	CannotOpenPushChannel,
	CannotClosePushChannel,
	BatteryTooLow,
	PushSpeedTooHigh,
	ErrorTypeUnknown
}
