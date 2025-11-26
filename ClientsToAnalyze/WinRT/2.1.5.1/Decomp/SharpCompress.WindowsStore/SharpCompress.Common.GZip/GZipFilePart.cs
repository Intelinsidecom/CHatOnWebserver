using System;
using System.Collections.Generic;
using System.IO;
using SharpCompress.Common.Tar.Headers;
using SharpCompress.Compressor;
using SharpCompress.Compressor.Deflate;

namespace SharpCompress.Common.GZip;

internal class GZipFilePart : FilePart
{
	private string name;

	private readonly Stream stream;

	internal DateTime? DateModified { get; private set; }

	internal override string FilePartName => name;

	internal GZipFilePart(Stream stream)
	{
		ReadAndValidateGzipHeader(stream);
		this.stream = stream;
	}

	internal override Stream GetCompressedStream()
	{
		return new DeflateStream(stream, CompressionMode.Decompress);
	}

	internal override Stream GetRawStream()
	{
		return stream;
	}

	private void ReadAndValidateGzipHeader(Stream stream)
	{
		byte[] array = new byte[10];
		switch (stream.Read(array, 0, array.Length))
		{
		case 0:
			break;
		default:
			throw new ZlibException("Not a valid GZIP stream.");
		case 10:
		{
			if (array[0] != 31 || array[1] != 139 || array[2] != 8)
			{
				throw new ZlibException("Bad GZIP header.");
			}
			int num = BitConverter.ToInt32(array, 4);
			DateModified = TarHeader.Epoch.AddSeconds(num);
			if ((array[3] & 4) == 4)
			{
				int num2 = stream.Read(array, 0, 2);
				short num3 = (short)(array[0] + array[1] * 256);
				byte[] array2 = new byte[num3];
				num2 = stream.Read(array2, 0, array2.Length);
				if (num2 != num3)
				{
					throw new ZlibException("Unexpected end-of-file reading GZIP header.");
				}
			}
			if ((array[3] & 8) == 8)
			{
				name = ReadZeroTerminatedString(stream);
			}
			if ((array[3] & 0x10) == 16)
			{
				ReadZeroTerminatedString(stream);
			}
			if ((array[3] & 2) == 2)
			{
				stream.ReadByte();
			}
			break;
		}
		}
	}

	private static string ReadZeroTerminatedString(Stream stream)
	{
		byte[] array = new byte[1];
		List<byte> list = new List<byte>();
		bool flag = false;
		do
		{
			int num = stream.Read(array, 0, 1);
			if (num != 1)
			{
				throw new ZlibException("Unexpected EOF reading GZIP header.");
			}
			if (array[0] == 0)
			{
				flag = true;
			}
			else
			{
				list.Add(array[0]);
			}
		}
		while (!flag);
		byte[] array2 = list.ToArray();
		return ArchiveEncoding.Default.GetString(array2, 0, array2.Length);
	}
}
