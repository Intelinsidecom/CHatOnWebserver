namespace Microsoft.Phone.Controls.Maps.Core;

internal sealed class TfeCoverageMapState
{
	internal TfeCoverageMapCallback Callback { get; private set; }

	internal object UserState { get; private set; }

	internal TfeCoverageMapState(TfeCoverageMapCallback callback, object userState)
	{
		Callback = callback;
		UserState = userState;
	}
}
