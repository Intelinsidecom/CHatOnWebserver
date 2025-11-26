using System.Collections.Generic;
using System.IO;
using System.Linq;
using SharpCompress.Common;
using SharpCompress.Common.Rar;
using SharpCompress.Common.Rar.Headers;
using SharpCompress.Compressor.Rar;

namespace SharpCompress.Archive.Rar;

public class RarArchiveEntry : RarEntry, IArchiveEntry, IEntry
{
	private readonly ICollection<RarFilePart> parts;

	public override CompressionType CompressionType => CompressionType.Rar;

	private RarArchive Archive { get; set; }

	internal override IEnumerable<FilePart> Parts => parts.Cast<FilePart>();

	internal override FileHeader FileHeader => parts.First().FileHeader;

	public override uint Crc
	{
		get
		{
			CheckIncomplete();
			return (from fp in parts
				select fp.FileHeader into fh
				where !fh.FileFlags.HasFlag(FileFlags.SPLIT_AFTER)
				select fh).Single().FileCRC;
		}
	}

	public override long Size
	{
		get
		{
			CheckIncomplete();
			return parts.First().FileHeader.UncompressedSize;
		}
	}

	public override long CompressedSize
	{
		get
		{
			CheckIncomplete();
			return parts.Aggregate(0L, (long total, RarFilePart fp) => total + fp.FileHeader.CompressedSize);
		}
	}

	public bool IsComplete => parts.Select((RarFilePart fp) => fp.FileHeader).Any((FileHeader fh) => !fh.FileFlags.HasFlag(FileFlags.SPLIT_AFTER));

	internal RarArchiveEntry(RarArchive archive, IEnumerable<RarFilePart> parts)
	{
		this.parts = parts.ToList();
		Archive = archive;
	}

	public Stream OpenEntryStream()
	{
		return new RarStream(Archive.Unpack, FileHeader, new MultiVolumeReadOnlyStream(Parts.Cast<RarFilePart>(), Archive));
	}

	public void WriteTo(Stream streamToWriteTo)
	{
		CheckIncomplete();
		if (Archive.IsSolidArchive())
		{
			throw new InvalidFormatException("Cannot use Archive random access on SOLID Rar files.");
		}
		if (IsEncrypted)
		{
			throw new PasswordProtectedException("Entry is password protected and cannot be extracted.");
		}
		this.Extract(Archive, streamToWriteTo);
	}

	private void CheckIncomplete()
	{
		if (!IsComplete)
		{
			throw new IncompleteArchiveException("ArchiveEntry is incomplete and cannot perform this operation.");
		}
	}

	internal override void Close()
	{
	}
}
