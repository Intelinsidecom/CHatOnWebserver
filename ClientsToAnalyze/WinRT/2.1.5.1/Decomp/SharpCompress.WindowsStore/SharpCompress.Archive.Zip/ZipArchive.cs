using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using SharpCompress.Common;
using SharpCompress.Common.Zip;
using SharpCompress.Common.Zip.Headers;
using SharpCompress.Compressor.Deflate;
using SharpCompress.Reader;
using SharpCompress.Reader.Zip;
using SharpCompress.Writer.Zip;

namespace SharpCompress.Archive.Zip;

public class ZipArchive : AbstractWritableArchive<ZipArchiveEntry, ZipVolume>
{
	private SeekableZipHeaderFactory headerFactory;

	public CompressionLevel DeflateCompressionLevel { get; set; }

	public static ZipArchive Open(Stream stream, string password = null)
	{
		stream.CheckNotNull("stream");
		return Open(stream, Options.None, password);
	}

	public static ZipArchive Open(Stream stream, Options options, string password = null)
	{
		stream.CheckNotNull("stream");
		return new ZipArchive(stream, options, password);
	}

	public static bool IsZipFile(Stream stream, string password = null)
	{
		StreamingZipHeaderFactory streamingZipHeaderFactory = new StreamingZipHeaderFactory(password);
		try
		{
			ZipHeader zipHeader = streamingZipHeaderFactory.ReadStreamHeader(stream).FirstOrDefault((ZipHeader x) => x.ZipHeaderType != ZipHeaderType.Split);
			if (zipHeader == null)
			{
				return false;
			}
			return Enum.IsDefined(typeof(ZipHeaderType), zipHeader.ZipHeaderType);
		}
		catch (CryptographicException)
		{
			return true;
		}
		catch
		{
			return false;
		}
	}

	internal ZipArchive()
		: base(ArchiveType.Zip)
	{
	}

	internal ZipArchive(Stream stream, Options options, string password = null)
		: base(ArchiveType.Zip, stream.AsEnumerable(), options)
	{
		headerFactory = new SeekableZipHeaderFactory(password);
	}

	protected override IEnumerable<ZipVolume> LoadVolumes(IEnumerable<Stream> streams, Options options)
	{
		return new ZipVolume(streams.First(), options).AsEnumerable();
	}

	protected override IEnumerable<ZipArchiveEntry> LoadEntries(IEnumerable<ZipVolume> volumes)
	{
		ZipVolume volume = volumes.Single();
		Stream stream = volumes.Single().Stream;
		foreach (DirectoryEntryHeader h in headerFactory.ReadSeekableHeader(stream))
		{
			if (h != null)
			{
				switch (h.ZipHeaderType)
				{
				case ZipHeaderType.DirectoryEntry:
					yield return new ZipArchiveEntry(this, new SeekableZipFilePart(headerFactory, h as DirectoryEntryHeader, stream));
					break;
				case ZipHeaderType.DirectoryEnd:
				{
					byte[] comment = (h as DirectoryEndHeader).Comment;
					volume.Comment = ArchiveEncoding.Default.GetString(comment, 0, comment.Length);
					yield break;
				}
				}
			}
		}
	}

	protected override void SaveTo(Stream stream, CompressionInfo compressionInfo, IEnumerable<ZipArchiveEntry> oldEntries, IEnumerable<ZipArchiveEntry> newEntries)
	{
		using ZipWriter zipWriter = new ZipWriter(stream, compressionInfo, string.Empty);
		foreach (ZipArchiveEntry item in from x in oldEntries.Concat(newEntries)
			where !x.IsDirectory
			select x)
		{
			using Stream source = item.OpenEntryStream();
			zipWriter.Write(item.FilePath, source, item.LastModifiedTime, string.Empty);
		}
	}

	protected override ZipArchiveEntry CreateEntry(string filePath, Stream source, long size, DateTime? modified, bool closeStream)
	{
		return new ZipWritableArchiveEntry(this, source, filePath, size, modified, closeStream);
	}

	public static ZipArchive Create()
	{
		return new ZipArchive();
	}

	protected override IReader CreateReaderForSolidExtraction()
	{
		Stream stream = base.Volumes.Single().Stream;
		stream.Position = 0L;
		return ZipReader.Open(stream);
	}
}
