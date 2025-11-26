namespace Microsoft.Phone.Controls.Maps.Core;

internal class MapConfigurationGetSectionRequest
{
	public string Version { get; private set; }

	public string SectionName { get; private set; }

	public string Culture { get; private set; }

	public MapConfigurationCallback Callback { get; private set; }

	public object UserState { get; private set; }

	public MapConfigurationGetSectionRequest(string version, string sectionName, string culture, MapConfigurationCallback callback, object userState)
	{
		Version = version;
		SectionName = sectionName;
		Culture = culture;
		Callback = callback;
		UserState = userState;
	}
}
