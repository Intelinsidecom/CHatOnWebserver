using System;
using System.Collections.Generic;
using System.IO;
using SharpCompress.Archive.GZip;
using SharpCompress.Archive.Tar;
using SharpCompress.Common;
using SharpCompress.Common.Tar;
using SharpCompress.Compressor;
using SharpCompress.Compressor.BZip2;
using SharpCompress.Compressor.Deflate;
using SharpCompress.IO;

namespace SharpCompress.Reader.Tar;

public class TarReader : AbstractReader<TarEntry, TarVolume>
{
	private readonly TarVolume volume;

	private readonly CompressionType compressionType;

	public override TarVolume Volume => volume;

	internal TarReader(Stream stream, CompressionType compressionType, Options options)
		: base(options, ArchiveType.Tar)
	{
		this.compressionType = compressionType;
		volume = new TarVolume(stream, options);
	}

	internal override Stream RequestInitialStream()
	{
		Stream stream = base.RequestInitialStream();
		return compressionType switch
		{
			CompressionType.BZip2 => new BZip2Stream(stream, CompressionMode.Decompress), 
			CompressionType.GZip => new GZipStream(stream, CompressionMode.Decompress), 
			CompressionType.None => stream, 
			_ => throw new NotSupportedException("Invalid compression type: " + compressionType), 
		};
	}

	public static TarReader Open(Stream stream, Options options = Options.KeepStreamsOpen)
	{
		stream.CheckNotNull("stream");
		RewindableStream rewindableStream = new RewindableStream(stream);
		rewindableStream.StartRecording();
		if (GZipArchive.IsGZipFile(rewindableStream))
		{
			rewindableStream.Rewind(stopRecording: false);
			GZipStream stream2 = new GZipStream(rewindableStream, CompressionMode.Decompress);
			if (TarArchive.IsTarFile(stream2))
			{
				rewindableStream.Rewind(stopRecording: true);
				return new TarReader(rewindableStream, CompressionType.GZip, options);
			}
			throw new InvalidFormatException("Not a tar file.");
		}
		rewindableStream.Rewind(stopRecording: false);
		if (BZip2Stream.IsBZip2(rewindableStream))
		{
			rewindableStream.Rewind(stopRecording: false);
			BZip2Stream stream3 = new BZip2Stream(rewindableStream, CompressionMode.Decompress);
			if (TarArchive.IsTarFile(stream3))
			{
				rewindableStream.Rewind(stopRecording: true);
				return new TarReader(rewindableStream, CompressionType.BZip2, options);
			}
			throw new InvalidFormatException("Not a tar file.");
		}
		rewindableStream.Rewind(stopRecording: true);
		return new TarReader(rewindableStream, CompressionType.None, options);
	}

	internal override IEnumerable<TarEntry> GetEntries(Stream stream)
	{
		return TarEntry.GetEntries(StreamingMode.Streaming, stream, compressionType);
	}
}
