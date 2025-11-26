using System.Linq;

namespace SharpCompress.Archive.Rar;

public static class RarArchiveExtensions
{
	public static bool IsFirstVolume(this RarArchive archive)
	{
		return archive.Volumes.First().IsFirstVolume;
	}

	public static bool IsMultipartVolume(this RarArchive archive)
	{
		return archive.Volumes.First().IsMultiVolume;
	}

	public static bool IsSolidArchive(this RarArchive archive)
	{
		return archive.IsSolid;
	}
}
