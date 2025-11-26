using System;

namespace Google.ProtocolBuffers;

public interface IRpcController
{
	bool Failed { get; }

	string ErrorText { get; }

	void Reset();

	void StartCancel();

	void SetFailed(string reason);

	bool isCanceled();

	void NotifyOnCancel(Action<object> callback);
}
