using System.IO;
using SharpCompress.Common.Tar.Headers;
using SharpCompress.IO;

namespace SharpCompress.Common.Tar;

internal class TarFilePart : FilePart
{
	private Stream seekableStream;

	internal TarHeader Header { get; private set; }

	internal override string FilePartName => Header.Name;

	internal TarFilePart(TarHeader header, Stream seekableStream)
	{
		this.seekableStream = seekableStream;
		Header = header;
	}

	internal override Stream GetCompressedStream()
	{
		if (seekableStream != null)
		{
			seekableStream.Position = Header.DataStartPosition.Value;
			return new ReadOnlySubStream(seekableStream, Header.Size);
		}
		return Header.PackedStream;
	}

	internal override Stream GetRawStream()
	{
		return null;
	}
}
