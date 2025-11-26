using System;
using System.Collections.Generic;
using System.IO;
using SharpCompress.Common;
using SharpCompress.IO;

namespace SharpCompress.Archive.Tar;

internal class TarWritableArchiveEntry : TarArchiveEntry
{
	private string path;

	private long size;

	private DateTime? lastModified;

	private bool closeStream;

	public override uint Crc => 0u;

	public override string FilePath => path;

	public override long CompressedSize => 0L;

	public override long Size => size;

	public override DateTime? LastModifiedTime => lastModified;

	public override DateTime? CreatedTime => null;

	public override DateTime? LastAccessedTime => null;

	public override DateTime? ArchivedTime => null;

	public override bool IsEncrypted => false;

	public override bool IsDirectory => false;

	public override bool IsSplit => false;

	internal override IEnumerable<FilePart> Parts
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	internal Stream Stream { get; private set; }

	internal TarWritableArchiveEntry(TarArchive archive, Stream stream, CompressionType compressionType, string path, long size, DateTime? lastModified, bool closeStream)
		: base(archive, null, compressionType)
	{
		Stream = stream;
		this.path = path;
		this.size = size;
		this.lastModified = lastModified;
		this.closeStream = closeStream;
	}

	public override Stream OpenEntryStream()
	{
		return new NonDisposingStream(Stream);
	}

	internal override void Close()
	{
		if (closeStream)
		{
			Stream.Dispose();
		}
	}
}
