using System.IO;
using SharpCompress.Common.Rar;
using SharpCompress.Common.Rar.Headers;

namespace SharpCompress.Archive.Rar;

internal class SeekableStreamFilePart : RarFilePart
{
	internal Stream Stream { get; private set; }

	internal override string FilePartName => "Unknown Stream - File Entry: " + base.FileHeader.FileName;

	internal SeekableStreamFilePart(MarkHeader mh, FileHeader fh, Stream stream)
		: base(mh, fh)
	{
		Stream = stream;
	}

	internal override Stream GetCompressedStream()
	{
		Stream.Position = base.FileHeader.DataStartPosition;
		return Stream;
	}
}
