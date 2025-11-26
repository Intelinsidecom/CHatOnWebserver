using System.Xml.Serialization;

namespace ChatON_WoA.DataModel;

public class UpdateBuddy
{
	[XmlAttribute("index")]
	public string index { get; set; }

	[XmlElement("id")]
	public string id { get; set; }

	[XmlElement("name")]
	public string name { get; set; }
}
