using System;

namespace ChatOn.Services;

public class GPSService : IDisposable
{
	protected virtual void Dispose(bool disposing)
	{
	}

	public void Dispose()
	{
		Dispose(disposing: true);
		GC.SuppressFinalize(this);
	}

	public void StartGPS()
	{
	}

	public void StopGPS()
	{
	}
}
