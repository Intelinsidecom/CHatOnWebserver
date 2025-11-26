using System;
using SharpCompress.Common.Rar.Headers;

namespace SharpCompress.Common.Rar;

public abstract class RarEntry : Entry
{
	internal abstract FileHeader FileHeader { get; }

	public override uint Crc => FileHeader.FileCRC;

	public override string FilePath => FileHeader.FileName;

	public override DateTime? LastModifiedTime => FileHeader.FileLastModifiedTime;

	public override DateTime? CreatedTime => FileHeader.FileCreatedTime;

	public override DateTime? LastAccessedTime => FileHeader.FileLastAccessedTime;

	public override DateTime? ArchivedTime => FileHeader.FileArchivedTime;

	public override bool IsEncrypted => FileHeader.FileFlags.HasFlag(FileFlags.PASSWORD);

	public override bool IsDirectory => FileHeader.FileFlags.HasFlag(FileFlags.WINDOWMASK);

	public override bool IsSplit => FileHeader.FileFlags.HasFlag(FileFlags.SPLIT_AFTER);

	public override string ToString()
	{
		return $"Entry Path: {FilePath} Compressed Size: {CompressedSize} Uncompressed Size: {Size} CRC: {Crc}";
	}
}
