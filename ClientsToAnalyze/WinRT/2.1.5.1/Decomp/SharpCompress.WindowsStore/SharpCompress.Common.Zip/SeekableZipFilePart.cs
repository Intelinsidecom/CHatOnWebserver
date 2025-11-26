using System.IO;
using SharpCompress.Common.Zip.Headers;

namespace SharpCompress.Common.Zip;

internal class SeekableZipFilePart : ZipFilePart
{
	private bool isLocalHeaderLoaded;

	private readonly SeekableZipHeaderFactory headerFactory;

	internal string Comment => (base.Header as DirectoryEntryHeader).Comment;

	internal SeekableZipFilePart(SeekableZipHeaderFactory headerFactory, DirectoryEntryHeader header, Stream stream)
		: base(header, stream)
	{
		this.headerFactory = headerFactory;
	}

	internal override Stream GetCompressedStream()
	{
		if (!isLocalHeaderLoaded)
		{
			LoadLocalHeader();
			isLocalHeaderLoaded = true;
		}
		return base.GetCompressedStream();
	}

	private void LoadLocalHeader()
	{
		bool hasData = base.Header.HasData;
		base.Header = headerFactory.GetLocalHeader(base.BaseStream, base.Header as DirectoryEntryHeader);
		base.Header.HasData = hasData;
	}

	protected override Stream CreateBaseStream()
	{
		base.BaseStream.Position = base.Header.DataStartPosition.Value;
		return base.BaseStream;
	}
}
