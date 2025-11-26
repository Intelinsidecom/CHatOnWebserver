using System;
using System.IO;
using System.Text;
using SharpCompress.Common.Zip;
using SharpCompress.Common.Zip.Headers;

namespace SharpCompress.Writer.Zip;

internal class ZipCentralDirectoryEntry
{
	internal string FileName { get; set; }

	internal DateTime? ModificationTime { get; set; }

	internal string Comment { get; set; }

	internal uint Crc { get; set; }

	internal uint HeaderOffset { get; set; }

	internal uint Compressed { get; set; }

	internal uint Decompressed { get; set; }

	internal uint Write(Stream outputStream, ZipCompressionMethod compression)
	{
		byte[] bytes = Encoding.UTF8.GetBytes(FileName);
		byte[] bytes2 = Encoding.UTF8.GetBytes(Comment);
		outputStream.Write(new byte[8] { 80, 75, 1, 2, 63, 0, 10, 0 }, 0, 8);
		HeaderFlags headerFlags = HeaderFlags.UTF8;
		if (!outputStream.CanSeek)
		{
			headerFlags |= HeaderFlags.UsePostDataDescriptor;
			if (compression == ZipCompressionMethod.LZMA)
			{
				headerFlags |= HeaderFlags.Bit1;
			}
		}
		outputStream.Write(BitConverter.GetBytes((ushort)headerFlags), 0, 2);
		outputStream.Write(BitConverter.GetBytes((ushort)compression), 0, 2);
		outputStream.Write(BitConverter.GetBytes(ModificationTime.DateTimeToDosTime()), 0, 4);
		outputStream.Write(BitConverter.GetBytes(Crc), 0, 4);
		outputStream.Write(BitConverter.GetBytes(Compressed), 0, 4);
		outputStream.Write(BitConverter.GetBytes(Decompressed), 0, 4);
		outputStream.Write(BitConverter.GetBytes((ushort)bytes.Length), 0, 2);
		outputStream.Write(BitConverter.GetBytes((ushort)0), 0, 2);
		outputStream.Write(BitConverter.GetBytes((ushort)bytes2.Length), 0, 2);
		outputStream.Write(BitConverter.GetBytes((ushort)0), 0, 2);
		outputStream.Write(BitConverter.GetBytes((ushort)0), 0, 2);
		outputStream.Write(BitConverter.GetBytes((ushort)0), 0, 2);
		outputStream.Write(BitConverter.GetBytes((ushort)33024), 0, 2);
		outputStream.Write(BitConverter.GetBytes(HeaderOffset), 0, 4);
		outputStream.Write(bytes, 0, bytes.Length);
		outputStream.Write(bytes2, 0, bytes2.Length);
		return (uint)(46 + bytes.Length + bytes2.Length);
	}
}
