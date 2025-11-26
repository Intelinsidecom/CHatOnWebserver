using System.IO;

namespace SharpCompress.Common.Zip.Headers;

internal class DirectoryEntryHeader : ZipFileEntry
{
	internal ushort Version { get; private set; }

	public ushort VersionNeededToExtract { get; set; }

	public uint RelativeOffsetOfEntryHeader { get; set; }

	public uint ExternalFileAttributes { get; set; }

	public ushort InternalFileAttributes { get; set; }

	public ushort DiskNumberStart { get; set; }

	public string Comment { get; private set; }

	public DirectoryEntryHeader()
		: base(ZipHeaderType.DirectoryEntry)
	{
	}

	internal override void Read(BinaryReader reader)
	{
		Version = reader.ReadUInt16();
		VersionNeededToExtract = reader.ReadUInt16();
		base.Flags = (HeaderFlags)reader.ReadUInt16();
		base.CompressionMethod = (ZipCompressionMethod)reader.ReadUInt16();
		base.LastModifiedTime = reader.ReadUInt16();
		base.LastModifiedDate = reader.ReadUInt16();
		base.Crc = reader.ReadUInt32();
		base.CompressedSize = reader.ReadUInt32();
		base.UncompressedSize = reader.ReadUInt32();
		ushort count = reader.ReadUInt16();
		ushort count2 = reader.ReadUInt16();
		ushort count3 = reader.ReadUInt16();
		DiskNumberStart = reader.ReadUInt16();
		InternalFileAttributes = reader.ReadUInt16();
		ExternalFileAttributes = reader.ReadUInt32();
		RelativeOffsetOfEntryHeader = reader.ReadUInt32();
		byte[] str = reader.ReadBytes(count);
		base.Name = DecodeString(str);
		byte[] extra = reader.ReadBytes(count2);
		byte[] str2 = reader.ReadBytes(count3);
		Comment = DecodeString(str2);
		LoadExtra(extra);
	}

	internal override void Write(BinaryWriter writer)
	{
		writer.Write(Version);
		writer.Write(VersionNeededToExtract);
		writer.Write((ushort)base.Flags);
		writer.Write((ushort)base.CompressionMethod);
		writer.Write(base.LastModifiedTime);
		writer.Write(base.LastModifiedDate);
		writer.Write(base.Crc);
		writer.Write(base.CompressedSize);
		writer.Write(base.UncompressedSize);
		byte[] array = EncodeString(base.Name);
		writer.Write((ushort)array.Length);
		writer.Write((ushort)0);
		writer.Write((ushort)Comment.Length);
		writer.Write(DiskNumberStart);
		writer.Write(InternalFileAttributes);
		writer.Write(ExternalFileAttributes);
		writer.Write(RelativeOffsetOfEntryHeader);
		writer.Write(array);
		writer.Write(Comment);
	}
}
