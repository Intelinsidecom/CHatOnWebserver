using System.IO;

namespace SharpCompress.Common.Zip.Headers;

internal class LocalEntryHeader : ZipFileEntry
{
	internal ushort Version { get; private set; }

	public LocalEntryHeader()
		: base(ZipHeaderType.LocalEntry)
	{
	}

	internal override void Read(BinaryReader reader)
	{
		Version = reader.ReadUInt16();
		base.Flags = (HeaderFlags)reader.ReadUInt16();
		base.CompressionMethod = (ZipCompressionMethod)reader.ReadUInt16();
		base.LastModifiedTime = reader.ReadUInt16();
		base.LastModifiedDate = reader.ReadUInt16();
		base.Crc = reader.ReadUInt32();
		base.CompressedSize = reader.ReadUInt32();
		base.UncompressedSize = reader.ReadUInt32();
		ushort count = reader.ReadUInt16();
		ushort count2 = reader.ReadUInt16();
		byte[] str = reader.ReadBytes(count);
		byte[] extra = reader.ReadBytes(count2);
		base.Name = DecodeString(str);
		LoadExtra(extra);
	}

	internal override void Write(BinaryWriter writer)
	{
		writer.Write(Version);
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
		writer.Write(array);
	}
}
