using System.Xml.Linq;

namespace ChatOn.Services;

public class AlbumData
{
	public string ID { get; set; }

	public string Title { get; set; }

	public string PhotoCount { get; set; }

	public AlbumData(XElement value)
	{
		if (value != null)
		{
			if (value.Attribute("id").Value != null)
			{
				ID = value.Attribute("id").Value;
			}
			if (value.Element("title") != null)
			{
				Title = value.Element("title").Value;
			}
			if (value.Element("photoCount") != null)
			{
				PhotoCount = value.Element("photoCount").Value;
			}
		}
	}
}
