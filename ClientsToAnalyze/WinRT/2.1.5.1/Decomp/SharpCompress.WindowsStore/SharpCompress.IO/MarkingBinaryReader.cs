using System;
using System.IO;
using System.Linq;

namespace SharpCompress.IO;

internal class MarkingBinaryReader : BinaryReader
{
	public long CurrentReadByteCount { get; protected set; }

	public MarkingBinaryReader(Stream stream)
		: base(stream)
	{
	}

	public void Mark()
	{
		CurrentReadByteCount = 0L;
	}

	public override int Read()
	{
		CurrentReadByteCount += 4L;
		return base.Read();
	}

	public override int Read(byte[] buffer, int index, int count)
	{
		CurrentReadByteCount += count;
		return base.Read(buffer, index, count);
	}

	public override int Read(char[] buffer, int index, int count)
	{
		throw new NotImplementedException();
	}

	public override bool ReadBoolean()
	{
		CurrentReadByteCount++;
		return base.ReadBoolean();
	}

	public override byte ReadByte()
	{
		return ReadBytes(1).Single();
	}

	public override byte[] ReadBytes(int count)
	{
		CurrentReadByteCount += count;
		return base.ReadBytes(count);
	}

	public override char ReadChar()
	{
		throw new NotImplementedException();
	}

	public override char[] ReadChars(int count)
	{
		throw new NotImplementedException();
	}

	public override decimal ReadDecimal()
	{
		return ByteArrayToDecimal(ReadBytes(16), 0);
	}

	private decimal ByteArrayToDecimal(byte[] src, int offset)
	{
		int num = BitConverter.ToInt32(src, offset);
		int num2 = BitConverter.ToInt32(src, offset + 4);
		int num3 = BitConverter.ToInt32(src, offset + 8);
		int num4 = BitConverter.ToInt32(src, offset + 12);
		return new decimal(new int[4] { num, num2, num3, num4 });
	}

	public override double ReadDouble()
	{
		return BitConverter.ToDouble(ReadBytes(8), 0);
	}

	public override short ReadInt16()
	{
		return BitConverter.ToInt16(ReadBytes(2), 0);
	}

	public override int ReadInt32()
	{
		return BitConverter.ToInt32(ReadBytes(4), 0);
	}

	public override long ReadInt64()
	{
		return BitConverter.ToInt64(ReadBytes(8), 0);
	}

	public override sbyte ReadSByte()
	{
		return (sbyte)ReadByte();
	}

	public override float ReadSingle()
	{
		return BitConverter.ToSingle(ReadBytes(4), 0);
	}

	public override string ReadString()
	{
		throw new NotImplementedException();
	}

	public override ushort ReadUInt16()
	{
		return BitConverter.ToUInt16(ReadBytes(2), 0);
	}

	public override uint ReadUInt32()
	{
		return BitConverter.ToUInt32(ReadBytes(4), 0);
	}

	public override ulong ReadUInt64()
	{
		return BitConverter.ToUInt64(ReadBytes(8), 0);
	}
}
