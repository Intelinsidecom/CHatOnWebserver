using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using SharpCompress.Common;
using SharpCompress.Common.Rar;
using SharpCompress.Common.Rar.Headers;
using SharpCompress.Compressor.Rar;
using SharpCompress.IO;
using SharpCompress.Reader;
using SharpCompress.Reader.Rar;

namespace SharpCompress.Archive.Rar;

public class RarArchive : AbstractArchive<RarArchiveEntry, RarVolume>
{
	private readonly Unpack unpack = new Unpack();

	internal Unpack Unpack => unpack;

	public override bool IsSolid => base.Volumes.First().IsSolidArchive;

	internal RarArchive(IEnumerable<Stream> streams, Options options)
		: base(ArchiveType.Rar, streams, options)
	{
	}

	protected override IEnumerable<RarArchiveEntry> LoadEntries(IEnumerable<RarVolume> volumes)
	{
		return RarArchiveEntryFactory.GetEntries(this, volumes);
	}

	protected override IEnumerable<RarVolume> LoadVolumes(IEnumerable<Stream> streams, Options options)
	{
		return RarArchiveVolumeFactory.GetParts(streams, options);
	}

	protected override IReader CreateReaderForSolidExtraction()
	{
		Stream stream = base.Volumes.First().Stream;
		stream.Position = 0L;
		return RarReader.Open(stream);
	}

	public static RarArchive Open(Stream stream)
	{
		stream.CheckNotNull("stream");
		return Open(stream.AsEnumerable());
	}

	public static RarArchive Open(Stream stream, Options options)
	{
		stream.CheckNotNull("stream");
		return Open(stream.AsEnumerable(), options);
	}

	public static RarArchive Open(IEnumerable<Stream> streams)
	{
		streams.CheckNotNull("streams");
		return new RarArchive(streams, Options.KeepStreamsOpen);
	}

	public static RarArchive Open(IEnumerable<Stream> streams, Options options)
	{
		streams.CheckNotNull("streams");
		return new RarArchive(streams, options);
	}

	public static bool IsRarFile(Stream stream)
	{
		return IsRarFile(stream, Options.None);
	}

	public static bool IsRarFile(Stream stream, Options options)
	{
		try
		{
			RarHeaderFactory rarHeaderFactory = new RarHeaderFactory(StreamingMode.Seekable, options);
			RarHeader rarHeader = rarHeaderFactory.ReadHeaders(stream).FirstOrDefault();
			if (rarHeader == null)
			{
				return false;
			}
			return Enum.IsDefined(typeof(HeaderType), rarHeader.HeaderType);
		}
		catch
		{
			return false;
		}
	}
}
