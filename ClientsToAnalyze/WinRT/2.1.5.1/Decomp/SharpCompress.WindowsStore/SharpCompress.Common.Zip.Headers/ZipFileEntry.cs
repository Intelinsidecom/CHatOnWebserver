using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace SharpCompress.Common.Zip.Headers;

internal abstract class ZipFileEntry : ZipHeader
{
	internal bool IsDirectory => Name.EndsWith("/");

	internal Stream PackedStream { get; set; }

	internal string Name { get; set; }

	internal HeaderFlags Flags { get; set; }

	internal ZipCompressionMethod CompressionMethod { get; set; }

	internal uint CompressedSize { get; set; }

	internal long? DataStartPosition { get; set; }

	internal uint UncompressedSize { get; set; }

	internal List<ExtraData> Extra { get; set; }

	internal PkwareTraditionalEncryptionData PkwareTraditionalEncryptionData { get; set; }

	internal ushort LastModifiedDate { get; set; }

	internal ushort LastModifiedTime { get; set; }

	internal uint Crc { get; set; }

	internal ZipFilePart Part { get; set; }

	protected ZipFileEntry(ZipHeaderType type)
		: base(type)
	{
		Extra = new List<ExtraData>();
	}

	protected string DecodeString(byte[] str)
	{
		if (FlagUtility.HasFlag(Flags, HeaderFlags.UTF8))
		{
			return Encoding.UTF8.GetString(str, 0, str.Length);
		}
		return ArchiveEncoding.Default.GetString(str, 0, str.Length);
	}

	protected byte[] EncodeString(string str)
	{
		if (FlagUtility.HasFlag(Flags, HeaderFlags.UTF8))
		{
			return Encoding.UTF8.GetBytes(str);
		}
		return ArchiveEncoding.Default.GetBytes(str);
	}

	protected void LoadExtra(byte[] extra)
	{
		ushort num;
		for (int i = 0; i < extra.Length; i += num + 4)
		{
			ExtraDataType extraDataType = (ExtraDataType)BitConverter.ToUInt16(extra, i);
			if (!Enum.IsDefined(typeof(ExtraDataType), extraDataType))
			{
				break;
			}
			num = BitConverter.ToUInt16(extra, i + 2);
			byte[] array = new byte[num];
			Buffer.BlockCopy(extra, i + 4, array, 0, num);
			Extra.Add(new ExtraData
			{
				Type = extraDataType,
				Length = num,
				DataBytes = array
			});
		}
	}
}
