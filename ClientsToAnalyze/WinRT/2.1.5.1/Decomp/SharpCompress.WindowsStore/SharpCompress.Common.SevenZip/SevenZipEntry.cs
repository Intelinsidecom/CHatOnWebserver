using System;
using System.Collections.Generic;

namespace SharpCompress.Common.SevenZip;

public class SevenZipEntry : Entry
{
	internal SevenZipFilePart FilePart { get; private set; }

	public override CompressionType CompressionType => FilePart.CompressionType;

	public override uint Crc => FilePart.Header.Crc ?? 0;

	public override string FilePath => FilePart.Header.Name;

	public override long CompressedSize => 0L;

	public override long Size => FilePart.Header.Size;

	public override DateTime? LastModifiedTime
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	public override DateTime? CreatedTime
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	public override DateTime? LastAccessedTime
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	public override DateTime? ArchivedTime
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	public override bool IsEncrypted => false;

	public override bool IsDirectory => FilePart.Header.IsDir;

	public override bool IsSplit => false;

	internal override IEnumerable<FilePart> Parts => ((FilePart)FilePart).AsEnumerable();

	internal SevenZipEntry(SevenZipFilePart filePart)
	{
		FilePart = filePart;
	}

	internal override void Close()
	{
	}
}
