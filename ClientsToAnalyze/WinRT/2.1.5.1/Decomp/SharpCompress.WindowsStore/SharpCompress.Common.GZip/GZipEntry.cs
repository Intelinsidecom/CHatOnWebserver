using System;
using System.Collections.Generic;
using System.IO;

namespace SharpCompress.Common.GZip;

public class GZipEntry : Entry
{
	private readonly GZipFilePart filePart;

	public override CompressionType CompressionType => CompressionType.GZip;

	public override uint Crc => 0u;

	public override string FilePath => filePart.FilePartName;

	public override long CompressedSize => 0L;

	public override long Size => 0L;

	public override DateTime? LastModifiedTime => filePart.DateModified;

	public override DateTime? CreatedTime => null;

	public override DateTime? LastAccessedTime => null;

	public override DateTime? ArchivedTime => null;

	public override bool IsEncrypted => false;

	public override bool IsDirectory => false;

	public override bool IsSplit => false;

	internal override IEnumerable<FilePart> Parts => ((FilePart)filePart).AsEnumerable();

	internal GZipEntry(GZipFilePart filePart)
	{
		this.filePart = filePart;
	}

	internal static IEnumerable<GZipEntry> GetEntries(Stream stream)
	{
		yield return new GZipEntry(new GZipFilePart(stream));
	}

	internal override void Close()
	{
	}
}
