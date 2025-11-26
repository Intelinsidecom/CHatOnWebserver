using System.Xml.Serialization;

namespace ChatON_WoA.DataModel;

public class Sender
{
	[XmlElement("buddy")]
	public UpdateBuddy buddy { get; set; }
}
