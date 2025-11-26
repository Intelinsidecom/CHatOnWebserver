using System.Xml.Serialization;

namespace ChatON_WoA.DataModel;

public class Additional
{
	[XmlElement("comment")]
	public string comment { get; set; }
}
