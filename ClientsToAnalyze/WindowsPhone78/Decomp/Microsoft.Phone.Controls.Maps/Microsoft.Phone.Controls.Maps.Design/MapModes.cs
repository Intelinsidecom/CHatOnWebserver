namespace Microsoft.Phone.Controls.Maps.Design;

internal static class MapModes
{
	public static AerialMode Aerial => new AerialMode(labels: false);

	public static AerialMode AerialWithLabels => new AerialMode(labels: true);

	public static RoadMode Road => new RoadMode();
}
