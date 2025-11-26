using System.Xml.Serialization;
using ChatOn.Infrastructure;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatON_WoA.DataModel;

public class NewUpdate : NotificationObject
{
	[XmlIgnore]
	private BitmapImage _thumbProfile;

	[XmlAttribute("created")]
	public string created { get; set; }

	[XmlAttribute("status")]
	public string status { get; set; }

	[XmlElement("service")]
	public string service { get; set; }

	[XmlElement("action")]
	public string action { get; set; }

	[XmlElement("sender")]
	public Sender sender { get; set; }

	[XmlElement("push_message")]
	public string push_message { get; set; }

	[XmlElement("url_scheme")]
	public string url_scheme { get; set; }

	[XmlElement("additional")]
	public Additional additional { get; set; }

	[XmlIgnore]
	public BitmapImage thumbProfile
	{
		get
		{
			return _thumbProfile;
		}
		set
		{
			_thumbProfile = value;
			NotifyPropertyChanged(() => thumbProfile);
		}
	}
}
