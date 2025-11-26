using System;
using System.IO;
using SharpCompress.IO;

namespace SharpCompress.Common.Rar.Headers;

internal class FileHeader : RarHeader
{
	private const byte SALT_SIZE = 8;

	private const byte NEWLHD_SIZE = 32;

	internal long DataStartPosition { get; set; }

	internal HostOS HostOS { get; private set; }

	internal uint FileCRC { get; private set; }

	internal DateTime? FileLastModifiedTime { get; private set; }

	internal DateTime? FileCreatedTime { get; private set; }

	internal DateTime? FileLastAccessedTime { get; private set; }

	internal DateTime? FileArchivedTime { get; private set; }

	internal byte RarVersion { get; private set; }

	internal byte PackingMethod { get; private set; }

	internal int FileAttributes { get; private set; }

	internal FileFlags FileFlags => (FileFlags)base.Flags;

	internal long CompressedSize { get; private set; }

	internal long UncompressedSize { get; private set; }

	internal string FileName { get; private set; }

	internal byte[] SubData { get; private set; }

	internal int RecoverySectors { get; private set; }

	internal byte[] Salt { get; private set; }

	public Stream PackedStream { get; set; }

	protected override void ReadFromReader(MarkingBinaryReader reader)
	{
		uint num = reader.ReadUInt32();
		HostOS = (HostOS)reader.ReadByte();
		FileCRC = reader.ReadUInt32();
		FileLastModifiedTime = Utility.DosDateToDateTime(reader.ReadInt32());
		RarVersion = reader.ReadByte();
		PackingMethod = reader.ReadByte();
		short num2 = reader.ReadInt16();
		FileAttributes = reader.ReadInt32();
		uint x = 0u;
		uint x2 = 0u;
		if (FileFlags.HasFlag(FileFlags.LARGE))
		{
			x = reader.ReadUInt32();
			x2 = reader.ReadUInt32();
		}
		else if (num == uint.MaxValue)
		{
			num = uint.MaxValue;
			x2 = 2147483647u;
		}
		CompressedSize = UInt32To64(x, base.AdditionalSize);
		UncompressedSize = UInt32To64(x2, num);
		num2 = (short)((num2 > 4096) ? 4096 : num2);
		byte[] array = reader.ReadBytes(num2);
		switch (base.HeaderType)
		{
		case HeaderType.FileHeader:
			if (FileFlags.HasFlag(FileFlags.UNICODE))
			{
				int i;
				for (i = 0; i < array.Length && array[i] != 0; i++)
				{
				}
				if (i != num2)
				{
					i++;
					FileName = FileNameDecoder.Decode(array, i);
				}
				else
				{
					FileName = DecodeDefault(array);
				}
			}
			else
			{
				FileName = DecodeDefault(array);
			}
			FileName = ConvertPath(FileName, HostOS);
			break;
		case HeaderType.NewSubHeader:
		{
			int num3 = base.HeaderSize - 32 - num2;
			if (FileFlags.HasFlag(FileFlags.SALT))
			{
				num3 -= 8;
			}
			if (num3 > 0)
			{
				SubData = reader.ReadBytes(num3);
			}
			if (NewSubHeaderType.SUBHEAD_TYPE_RR.Equals(array))
			{
				RecoverySectors = SubData[8] + (SubData[9] << 8) + (SubData[10] << 16) + (SubData[11] << 24);
			}
			break;
		}
		}
		if (FileFlags.HasFlag(FileFlags.SALT))
		{
			Salt = reader.ReadBytes(8);
		}
		if (FileFlags.HasFlag(FileFlags.EXTTIME))
		{
			ushort extendedFlags = reader.ReadUInt16();
			FileLastModifiedTime = ProcessExtendedTime(extendedFlags, FileLastModifiedTime, reader, 0);
			FileCreatedTime = ProcessExtendedTime(extendedFlags, null, reader, 1);
			FileLastAccessedTime = ProcessExtendedTime(extendedFlags, null, reader, 2);
			FileArchivedTime = ProcessExtendedTime(extendedFlags, null, reader, 3);
		}
	}

	private string DecodeDefault(byte[] bytes)
	{
		return ArchiveEncoding.Default.GetString(bytes, 0, bytes.Length);
	}

	private long UInt32To64(uint x, uint y)
	{
		long num = x;
		num <<= 32;
		return num + y;
	}

	private static DateTime? ProcessExtendedTime(ushort extendedFlags, DateTime? time, MarkingBinaryReader reader, int i)
	{
		uint num = (uint)extendedFlags >> (3 - i) * 4;
		if ((num & 8) == 0)
		{
			return null;
		}
		if (i != 0)
		{
			uint iTime = reader.ReadUInt32();
			time = Utility.DosDateToDateTime(iTime);
		}
		if ((num & 4) == 0)
		{
			time = time.Value.AddSeconds(1.0);
		}
		uint num2 = 0u;
		int num3 = (int)(num & 3);
		for (int j = 0; j < num3; j++)
		{
			byte b = reader.ReadByte();
			num2 |= (uint)(b << (j + 3 - num3) * 8);
		}
		return time.Value.AddMilliseconds((double)num2 * Math.Pow(10.0, -4.0));
	}

	private static string ConvertPath(string path, HostOS os)
	{
		return path.Replace('\\', '/');
	}

	public override string ToString()
	{
		return FileName;
	}
}
