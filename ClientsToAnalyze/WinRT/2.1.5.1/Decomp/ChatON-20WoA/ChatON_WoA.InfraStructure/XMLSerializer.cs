using System.IO;
using System.Xml;
using System.Xml.Serialization;

namespace ChatON_WoA.InfraStructure;

public class XMLSerializer
{
	public static T Deserialize<T>(string xmlString)
	{
		TextReader input = new StringReader(xmlString);
		XmlReaderSettings xmlReaderSettings = new XmlReaderSettings();
		xmlReaderSettings.DtdProcessing = DtdProcessing.Ignore;
		XmlReaderSettings settings = xmlReaderSettings;
		using XmlReader xmlReader = XmlReader.Create(input, settings);
		XmlSerializer xmlSerializer = new XmlSerializer(typeof(T));
		T result;
		try
		{
			return (T)xmlSerializer.Deserialize(xmlReader);
		}
		catch
		{
			result = default(T);
		}
		return result;
	}

	public static string Serialize<T>(T t)
	{
		string result = string.Empty;
		MemoryStream memoryStream = new MemoryStream();
		XmlSerializer xmlSerializer = new XmlSerializer(typeof(T));
		try
		{
			xmlSerializer.Serialize(memoryStream, t);
			memoryStream.Position = 0L;
			StreamReader streamReader = new StreamReader(memoryStream);
			result = streamReader.ReadToEnd();
			streamReader.Dispose();
		}
		catch
		{
		}
		return result;
	}
}
