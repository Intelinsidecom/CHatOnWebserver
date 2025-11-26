using System.IO;
using SharpCompress.Common.Zip.Headers;
using SharpCompress.Compressor.Deflate;
using SharpCompress.IO;

namespace SharpCompress.Common.Zip;

internal class StreamingZipFilePart : ZipFilePart
{
	private Stream decompressionStream;

	internal StreamingZipFilePart(ZipFileEntry header, Stream stream)
		: base(header, stream)
	{
	}

	protected override Stream CreateBaseStream()
	{
		return base.Header.PackedStream;
	}

	internal override Stream GetCompressedStream()
	{
		if (!base.Header.HasData)
		{
			return Stream.Null;
		}
		decompressionStream = CreateDecompressionStream(GetCryptoStream(CreateBaseStream()));
		if (base.LeaveStreamOpen)
		{
			return new NonDisposingStream(decompressionStream);
		}
		return decompressionStream;
	}

	internal BinaryReader FixStreamedFileLocation(ref RewindableStream rewindableStream)
	{
		if (base.Header.IsDirectory)
		{
			return new BinaryReader(rewindableStream);
		}
		if (base.Header.HasData)
		{
			if (decompressionStream == null)
			{
				decompressionStream = GetCompressedStream();
			}
			decompressionStream.SkipAll();
			if (decompressionStream is DeflateStream deflateStream)
			{
				rewindableStream.Rewind(deflateStream.InputBuffer);
			}
		}
		BinaryReader result = new BinaryReader(rewindableStream);
		decompressionStream = null;
		return result;
	}
}
