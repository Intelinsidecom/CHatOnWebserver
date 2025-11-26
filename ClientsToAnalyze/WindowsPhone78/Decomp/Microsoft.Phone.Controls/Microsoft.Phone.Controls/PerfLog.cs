using Microsoft.Phone.Logging;

namespace Microsoft.Phone.Controls;

internal class PerfLog
{
	internal static string Panorama = "Panorama";

	internal static string PanoramaPanel = "PanoramaPanel";

	internal static string PanoramaItem = "PanoramaItem";

	internal static string PanningLayer = "PanningLayer";

	internal static string Pivot = "Pivot";

	internal static string PivotItem = "PivotItem";

	internal static string PivotHeadersControl = "PivotHeadersControl";

	internal static void BeginLogMarker(PerfMarkerEvents EventCode, string Message)
	{
		LogPerfMarker((LogFlags)65793, EventCode, Message);
	}

	internal static void EndLogMarker(PerfMarkerEvents EventCode, string Message)
	{
		LogPerfMarker((LogFlags)131329, EventCode, Message);
	}

	internal static void InfoLogMarker(PerfMarkerEvents EventCode, string Message)
	{
		LogPerfMarker((LogFlags)257, EventCode, Message);
	}

	private static void LogPerfMarker(LogFlags logFlag, PerfMarkerEvents EventCode, string Message)
	{
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		Logger.YLogEvent(2147483654u, (uint)EventCode, logFlag, Message);
	}
}
