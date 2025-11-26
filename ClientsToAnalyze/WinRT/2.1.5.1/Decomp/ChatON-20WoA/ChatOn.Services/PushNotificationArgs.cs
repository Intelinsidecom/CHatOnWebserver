using Windows.Data.Xml.Dom;

namespace ChatOn.Services;

public class PushNotificationArgs
{
	public XmlDocument XmlArgs { get; private set; }

	public string StringArgs { get; private set; }

	public PushNotificationArgs(XmlDocument xml)
	{
		XmlArgs = xml;
	}

	public PushNotificationArgs(string s)
	{
		StringArgs = s;
	}
}
