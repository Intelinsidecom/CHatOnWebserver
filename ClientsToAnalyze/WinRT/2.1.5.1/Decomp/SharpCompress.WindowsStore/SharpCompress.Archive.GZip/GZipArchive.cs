using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using SharpCompress.Common;
using SharpCompress.Common.GZip;
using SharpCompress.Reader;
using SharpCompress.Reader.GZip;
using SharpCompress.Writer.GZip;

namespace SharpCompress.Archive.GZip;

public class GZipArchive : AbstractWritableArchive<GZipArchiveEntry, GZipVolume>
{
	public static GZipArchive Open(Stream stream)
	{
		stream.CheckNotNull("stream");
		return Open(stream, Options.None);
	}

	public static GZipArchive Open(Stream stream, Options options)
	{
		stream.CheckNotNull("stream");
		return new GZipArchive(stream, options);
	}

	public static bool IsGZipFile(Stream stream)
	{
		byte[] array = new byte[10];
		switch (stream.Read(array, 0, array.Length))
		{
		case 0:
			return false;
		default:
			return false;
		case 10:
			if (array[0] != 31 || array[1] != 139 || array[2] != 8)
			{
				return false;
			}
			return true;
		}
	}

	internal GZipArchive(Stream stream, Options options)
		: base(ArchiveType.GZip, stream.AsEnumerable(), options)
	{
	}

	internal GZipArchive()
		: base(ArchiveType.GZip)
	{
	}

	public void SaveTo(Stream stream)
	{
		SaveTo(stream, CompressionType.GZip);
	}

	protected override GZipArchiveEntry CreateEntry(string filePath, Stream source, long size, DateTime? modified, bool closeStream)
	{
		if (Entries.Any())
		{
			throw new InvalidOperationException("Only one entry is allowed in a GZip Archive");
		}
		return new GZipWritableArchiveEntry(this, source, filePath, size, modified, closeStream);
	}

	protected override void SaveTo(Stream stream, CompressionInfo compressionInfo, IEnumerable<GZipArchiveEntry> oldEntries, IEnumerable<GZipArchiveEntry> newEntries)
	{
		if (Entries.Count > 1)
		{
			throw new InvalidOperationException("Only one entry is allowed in a GZip Archive");
		}
		using GZipWriter gZipWriter = new GZipWriter(stream);
		foreach (GZipArchiveEntry item in from x in oldEntries.Concat(newEntries)
			where !x.IsDirectory
			select x)
		{
			using Stream source = item.OpenEntryStream();
			gZipWriter.Write(item.FilePath, source, item.LastModifiedTime);
		}
	}

	protected override IEnumerable<GZipVolume> LoadVolumes(IEnumerable<Stream> streams, Options options)
	{
		return new GZipVolume(streams.First(), options).AsEnumerable();
	}

	protected override IEnumerable<GZipArchiveEntry> LoadEntries(IEnumerable<GZipVolume> volumes)
	{
		Stream stream = volumes.Single().Stream;
		yield return new GZipArchiveEntry(this, new GZipFilePart(stream));
	}

	protected override IReader CreateReaderForSolidExtraction()
	{
		Stream stream = base.Volumes.Single().Stream;
		stream.Position = 0L;
		return GZipReader.Open(stream);
	}
}
