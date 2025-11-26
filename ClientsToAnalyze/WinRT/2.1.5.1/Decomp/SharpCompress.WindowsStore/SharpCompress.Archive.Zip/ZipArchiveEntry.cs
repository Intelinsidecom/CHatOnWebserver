using System.IO;
using System.Linq;
using SharpCompress.Common;
using SharpCompress.Common.Zip;

namespace SharpCompress.Archive.Zip;

public class ZipArchiveEntry : ZipEntry, IArchiveEntry, IEntry
{
	private ZipArchive archive;

	public bool IsComplete => true;

	public string Comment => (Parts.Single() as SeekableZipFilePart).Comment;

	internal ZipArchiveEntry(ZipArchive archive, SeekableZipFilePart part)
		: base(part)
	{
		this.archive = archive;
	}

	public virtual Stream OpenEntryStream()
	{
		return Parts.Single().GetCompressedStream();
	}

	public void WriteTo(Stream streamToWriteTo)
	{
		this.Extract(archive, streamToWriteTo);
	}
}
