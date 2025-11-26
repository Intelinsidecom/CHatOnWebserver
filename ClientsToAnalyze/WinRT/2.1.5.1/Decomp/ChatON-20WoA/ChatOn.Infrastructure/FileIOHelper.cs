using System.Threading.Tasks;
using Windows.Storage;

namespace ChatOn.InfraStructure;

public static class FileIOHelper
{
	public static async void WriteToFiles(StorageFile file, string content)
	{
		await FileIO.WriteTextAsync((IStorageFile)(object)file, content);
	}

	public static async Task<string> ReadGuidfromFiles(StorageFile file)
	{
		return await FileIO.ReadTextAsync((IStorageFile)(object)file);
	}
}
