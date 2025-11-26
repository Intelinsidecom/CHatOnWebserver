using System;
using System.Device.Location;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class BadFetchState
{
	internal DateTime TryAgainAt { get; private set; }

	internal Credentials CredentialsLastUsed { get; private set; }

	internal GeoCoordinate Location { get; private set; }

	internal BadFetchState(DateTime againAt, Credentials credentials, GeoCoordinate location)
	{
		TryAgainAt = againAt;
		CredentialsLastUsed = credentials;
		Location = location;
	}
}
