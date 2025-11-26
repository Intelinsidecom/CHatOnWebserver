using System.IO;
using SharpCompress.IO;

namespace SharpCompress.Common.Rar.Headers;

internal class RarHeader
{
	internal const short BaseBlockSize = 7;

	internal const short LONG_BLOCK = short.MinValue;

	protected long ReadBytes { get; private set; }

	protected short HeadCRC { get; private set; }

	internal HeaderType HeaderType { get; private set; }

	protected short Flags { get; private set; }

	protected short HeaderSize { get; private set; }

	protected uint AdditionalSize { get; private set; }

	private void FillBase(RarHeader baseHeader)
	{
		HeadCRC = baseHeader.HeadCRC;
		HeaderType = baseHeader.HeaderType;
		Flags = baseHeader.Flags;
		HeaderSize = baseHeader.HeaderSize;
		AdditionalSize = baseHeader.AdditionalSize;
		ReadBytes = baseHeader.ReadBytes;
	}

	internal static RarHeader Create(MarkingBinaryReader reader)
	{
		try
		{
			RarHeader rarHeader = new RarHeader();
			reader.Mark();
			rarHeader.ReadFromReader(reader);
			rarHeader.ReadBytes += reader.CurrentReadByteCount;
			return rarHeader;
		}
		catch (EndOfStreamException)
		{
			return null;
		}
	}

	protected virtual void ReadFromReader(MarkingBinaryReader reader)
	{
		HeadCRC = reader.ReadInt16();
		HeaderType = (HeaderType)(reader.ReadByte() & 0xFF);
		Flags = reader.ReadInt16();
		HeaderSize = reader.ReadInt16();
		if (FlagUtility.HasFlag(Flags, short.MinValue))
		{
			AdditionalSize = reader.ReadUInt32();
		}
	}

	internal T PromoteHeader<T>(MarkingBinaryReader reader) where T : RarHeader, new()
	{
		T result = new T();
		result.FillBase(this);
		reader.Mark();
		result.ReadFromReader(reader);
		long readBytes = result.ReadBytes + reader.CurrentReadByteCount;
		result.ReadBytes = readBytes;
		int num = result.HeaderSize - (int)result.ReadBytes;
		if (num > 0)
		{
			reader.ReadBytes(num);
		}
		return result;
	}

	protected virtual void PostReadingBytes(MarkingBinaryReader reader)
	{
	}
}
