using System;
using System.IO;
using SharpCompress.Archive.GZip;
using SharpCompress.Archive.Rar;
using SharpCompress.Archive.Tar;
using SharpCompress.Archive.Zip;
using SharpCompress.Common;
using SharpCompress.Compressor;
using SharpCompress.Compressor.BZip2;
using SharpCompress.Compressor.Deflate;
using SharpCompress.IO;
using SharpCompress.Reader.GZip;
using SharpCompress.Reader.Rar;
using SharpCompress.Reader.Tar;
using SharpCompress.Reader.Zip;

namespace SharpCompress.Reader;

public static class ReaderFactory
{
	public static IReader Open(Stream stream, Options options = Options.KeepStreamsOpen)
	{
		stream.CheckNotNull("stream");
		RewindableStream rewindableStream = new RewindableStream(stream);
		rewindableStream.StartRecording();
		if (ZipArchive.IsZipFile(rewindableStream))
		{
			rewindableStream.Rewind(stopRecording: true);
			return ZipReader.Open(rewindableStream, null, options);
		}
		rewindableStream.Rewind(stopRecording: false);
		if (GZipArchive.IsGZipFile(rewindableStream))
		{
			rewindableStream.Rewind(stopRecording: false);
			GZipStream stream2 = new GZipStream(rewindableStream, CompressionMode.Decompress);
			if (TarArchive.IsTarFile(stream2))
			{
				rewindableStream.Rewind(stopRecording: true);
				return new TarReader(rewindableStream, CompressionType.GZip, options);
			}
			rewindableStream.Rewind(stopRecording: true);
			return GZipReader.Open(rewindableStream, options);
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
		}
		rewindableStream.Rewind(stopRecording: false);
		if (TarArchive.IsTarFile(rewindableStream))
		{
			rewindableStream.Rewind(stopRecording: true);
			return TarReader.Open(rewindableStream, options);
		}
		rewindableStream.Rewind(stopRecording: false);
		if (RarArchive.IsRarFile(rewindableStream, options))
		{
			rewindableStream.Rewind(stopRecording: true);
			return RarReader.Open(rewindableStream, options);
		}
		throw new InvalidOperationException("Cannot determine compressed stream type.  Supported Reader Formats: Zip, GZip, BZip2, Tar, Rar");
	}
}
