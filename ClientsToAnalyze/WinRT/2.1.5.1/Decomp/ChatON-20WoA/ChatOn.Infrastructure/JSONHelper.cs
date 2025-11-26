using System.IO;
using System.Runtime.Serialization.Json;
using System.Text;

namespace ChatOn.Infrastructure;

public static class JSONHelper
{
	public static T Deserialize<T>(string json)
	{
		byte[] bytes = Encoding.Unicode.GetBytes(json);
		using MemoryStream stream = new MemoryStream(bytes);
		DataContractJsonSerializer dataContractJsonSerializer = new DataContractJsonSerializer(typeof(T));
		return (T)dataContractJsonSerializer.ReadObject(stream);
	}

	public static string Serialize(object instance)
	{
		using MemoryStream memoryStream = new MemoryStream();
		DataContractJsonSerializer dataContractJsonSerializer = new DataContractJsonSerializer(instance.GetType());
		dataContractJsonSerializer.WriteObject(memoryStream, instance);
		memoryStream.Position = 0L;
		using StreamReader streamReader = new StreamReader(memoryStream);
		return streamReader.ReadToEnd();
	}
}
