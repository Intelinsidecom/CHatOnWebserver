using System.IO;
using System.Runtime.Serialization.Json;
using System.Text;

namespace ChatON_WoA.Services;

public static class TwitterJsonSerializer
{
	public static T Deserialize<T>(string jsonString) where T : class
	{
		DataContractJsonSerializer dataContractJsonSerializer = new DataContractJsonSerializer(typeof(T));
		byte[] bytes = Encoding.UTF8.GetBytes(jsonString);
		MemoryStream memoryStream = new MemoryStream(bytes);
		T result = dataContractJsonSerializer.ReadObject(memoryStream) as T;
		memoryStream.Dispose();
		return result;
	}
}
