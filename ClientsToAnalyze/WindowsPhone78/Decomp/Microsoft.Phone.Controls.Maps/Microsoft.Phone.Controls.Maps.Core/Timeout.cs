using System;
using System.Windows.Threading;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class Timeout
{
	private readonly Action action;

	private readonly DispatcherTimer timer = new DispatcherTimer();

	public Timeout(Action action, long timeout)
	{
		this.action = action;
		timer.Tick += OnTimeout;
		timer.Interval = TimeSpan.FromTicks(timeout);
		timer.Start();
	}

	private void OnTimeout(object sender, EventArgs e)
	{
		action();
		timer.Tick -= OnTimeout;
		timer.Stop();
	}

	public void DoItNow()
	{
		if (timer.IsEnabled)
		{
			OnTimeout(this, null);
		}
	}

	public void Cancel()
	{
		timer.Tick -= OnTimeout;
		if (timer.IsEnabled)
		{
			timer.Stop();
		}
	}
}
