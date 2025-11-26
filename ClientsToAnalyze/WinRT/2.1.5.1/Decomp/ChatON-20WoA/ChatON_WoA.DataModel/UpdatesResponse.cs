using System.Collections.Generic;
using System.Xml.Serialization;

namespace ChatON_WoA.DataModel;

[XmlRoot("return")]
public class UpdatesResponse
{
	[XmlElement("hasmore")]
	public string hasmore { get; set; }

	[XmlElement("newupdate")]
	public List<NewUpdate> newupdate { get; set; }
}
