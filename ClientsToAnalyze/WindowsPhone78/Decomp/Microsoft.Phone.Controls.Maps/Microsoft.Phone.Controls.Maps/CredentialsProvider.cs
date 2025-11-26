using System;

namespace Microsoft.Phone.Controls.Maps;

public abstract class CredentialsProvider
{
	public abstract void GetCredentials(Action<Credentials> callback);
}
