using System;

namespace Samsung.Device.PDI;

public sealed class DayLight
{
	public bool IsEnabled { get; set; }

	public TimeSpan DayLightOffset { get; set; }

	public DateTime Begin { get; set; }

	public DateTime End { get; set; }

	public string[] Names { get; set; }
}
