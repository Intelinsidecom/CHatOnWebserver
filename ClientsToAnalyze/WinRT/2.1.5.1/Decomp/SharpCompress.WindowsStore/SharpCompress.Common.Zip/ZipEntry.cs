using System;
using System.Collections.Generic;
using SharpCompress.Common.Zip.Headers;

namespace SharpCompress.Common.Zip;

public class ZipEntry : Entry
{
	private readonly ZipFilePart filePart;

	private readonly DateTime? lastModifiedTime;

	public override CompressionType CompressionType => filePart.Header.CompressionMethod switch
	{
		ZipCompressionMethod.BZip2 => CompressionType.BZip2, 
		ZipCompressionMethod.Deflate => CompressionType.Deflate, 
		ZipCompressionMethod.LZMA => CompressionType.LZMA, 
		ZipCompressionMethod.PPMd => CompressionType.PPMd, 
		ZipCompressionMethod.None => CompressionType.None, 
		_ => CompressionType.Unknown, 
	};

	public override uint Crc => filePart.Header.Crc;

	public override string FilePath => filePart.Header.Name;

	public override long CompressedSize => filePart.Header.CompressedSize;

	public override long Size => filePart.Header.UncompressedSize;

	public override DateTime? LastModifiedTime => lastModifiedTime;

	public override DateTime? CreatedTime => null;

	public override DateTime? LastAccessedTime => null;

	public override DateTime? ArchivedTime => null;

	public override bool IsEncrypted => FlagUtility.HasFlag(filePart.Header.Flags, HeaderFlags.Encrypted);

	public override bool IsDirectory => filePart.Header.IsDirectory;

	public override bool IsSplit => false;

	internal override IEnumerable<FilePart> Parts => ((FilePart)filePart).AsEnumerable();

	internal ZipEntry(ZipFilePart filePart)
	{
		if (filePart != null)
		{
			this.filePart = filePart;
			lastModifiedTime = Utility.DosDateToDateTime(filePart.Header.LastModifiedDate, filePart.Header.LastModifiedTime);
		}
	}

	internal override void Close()
	{
	}
}
