using System;

namespace ChatOn.Services;

public class PushServiceEventArgs : EventArgs
{
	private string _errorSummary;

	private string _errorDetail;

	private bool _hasToNotify;

	private PushServiceErrorType _errorType;

	public string ErrorSummary => _errorSummary;

	public string ErrorDetail => _errorDetail;

	public bool HasToNotify => _hasToNotify;

	public PushServiceErrorType ErrorType => _errorType;

	public PushServiceEventArgs(PushServiceErrorType errorType, string errorSummary, string errorDetail, bool hasToNotify)
	{
		_errorType = errorType;
		_errorSummary = errorSummary;
		_errorDetail = errorDetail;
		_hasToNotify = hasToNotify;
	}
}
