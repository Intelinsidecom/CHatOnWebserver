using System;
using System.Device.Location;

namespace ChatOn.Services;

public class GPSService : IDisposable
{
	public delegate void GetGPSStatusChangedEventHandler(GeoPositionStatus status, GeoPositionPermission permission);

	public delegate void GetGPSPositionChangedEventHandler(GeoCoordinate location);

	private GeoCoordinateWatcher _watcher;

	public GeoCoordinateWatcher Watcher => _watcher;

	public event GetGPSStatusChangedEventHandler GetGPSStatusChanged;

	public event GetGPSPositionChangedEventHandler GetGPSPositionChanged;

	protected virtual void Dispose(bool disposing)
	{
		if (disposing)
		{
			_watcher.Dispose();
		}
	}

	public void Dispose()
	{
		Dispose(disposing: true);
		GC.SuppressFinalize(this);
	}

	public void StartGPS()
	{
		if (_watcher == null)
		{
			_watcher = new GeoCoordinateWatcher(GeoPositionAccuracy.High);
			_watcher.MovementThreshold = 20.0;
			_watcher.StatusChanged += watcher_StatusChanged;
			_watcher.PositionChanged += _watcher_PositionChanged;
		}
		_watcher.Start();
	}

	private void watcher_StatusChanged(object sender, GeoPositionStatusChangedEventArgs e)
	{
		switch (e.Status)
		{
		case GeoPositionStatus.Ready:
			_ = _watcher.Permission;
			_ = 2;
			break;
		}
		if (this.GetGPSStatusChanged != null)
		{
			this.GetGPSStatusChanged(e.Status, _watcher.Permission);
		}
	}

	private void _watcher_PositionChanged(object sender, GeoPositionChangedEventArgs<GeoCoordinate> e)
	{
		if (e.Position != null && this.GetGPSPositionChanged != null)
		{
			this.GetGPSPositionChanged(e.Position.Location);
		}
	}

	public void StopGPS()
	{
		if (_watcher != null)
		{
			_watcher.StatusChanged -= watcher_StatusChanged;
			_watcher.PositionChanged -= _watcher_PositionChanged;
			_watcher.Stop();
			_watcher = null;
		}
	}
}
