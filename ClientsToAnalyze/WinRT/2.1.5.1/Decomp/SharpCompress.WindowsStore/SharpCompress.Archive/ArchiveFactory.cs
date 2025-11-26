using System;
using System.IO;
using SharpCompress.Archive.GZip;
using SharpCompress.Archive.Rar;
using SharpCompress.Archive.SevenZip;
using SharpCompress.Archive.Tar;
using SharpCompress.Archive.Zip;
using SharpCompress.Common;

namespace SharpCompress.Archive;

public class ArchiveFactory
{
	public static IArchive Open(Stream stream, Options options = Options.KeepStreamsOpen)
	{
		stream.CheckNotNull("stream");
		if (!stream.CanRead || !stream.CanSeek)
		{
			throw new ArgumentException("Stream should be readable and seekable");
		}
		if (ZipArchive.IsZipFile(stream))
		{
			stream.Seek(0L, SeekOrigin.Begin);
			return ZipArchive.Open(stream, options);
		}
		stream.Seek(0L, SeekOrigin.Begin);
		if (RarArchive.IsRarFile(stream, Options.KeepStreamsOpen | Options.LookForHeader))
		{
			stream.Seek(0L, SeekOrigin.Begin);
			return RarArchive.Open(stream, options);
		}
		stream.Seek(0L, SeekOrigin.Begin);
		if (TarArchive.IsTarFile(stream))
		{
			stream.Seek(0L, SeekOrigin.Begin);
			return TarArchive.Open(stream, options);
		}
		stream.Seek(0L, SeekOrigin.Begin);
		if (SevenZipArchive.IsSevenZipFile(stream))
		{
			stream.Seek(0L, SeekOrigin.Begin);
			return SevenZipArchive.Open(stream, options);
		}
		stream.Seek(0L, SeekOrigin.Begin);
		if (GZipArchive.IsGZipFile(stream))
		{
			stream.Seek(0L, SeekOrigin.Begin);
			return GZipArchive.Open(stream, options);
		}
		throw new InvalidOperationException("Cannot determine compressed stream type.  Supported Archive Formats: Zip, GZip, Tar, Rar, 7Zip");
	}

	public static IArchive Create(ArchiveType type)
	{
		return type switch
		{
			ArchiveType.Zip => ZipArchive.Create(), 
			ArchiveType.Tar => TarArchive.Create(), 
			_ => throw new NotSupportedException("Cannot create Archives of type: " + type), 
		};
	}
}
