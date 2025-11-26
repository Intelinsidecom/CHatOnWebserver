using System.IO;
using SharpCompress.Common;
using SharpCompress.Common.SevenZip;

namespace SharpCompress.Archive.SevenZip;

public class SevenZipArchiveEntry : SevenZipEntry, IArchiveEntry, IEntry
{
	private SevenZipArchive archive;

	public bool IsComplete => true;

	public bool IsAnti => base.FilePart.Header.IsAnti;

	internal SevenZipArchiveEntry(SevenZipArchive archive, SevenZipFilePart part)
		: base(part)
	{
		this.archive = archive;
	}

	public Stream OpenEntryStream()
	{
		return base.FilePart.GetCompressedStream();
	}

	public void WriteTo(Stream stream)
	{
		if (IsEncrypted)
		{
			throw new PasswordProtectedException("Entry is password protected and cannot be extracted.");
		}
		this.Extract(archive, stream);
	}
}
