using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public sealed class CodedInputStream
{
	internal const int DefaultRecursionLimit = 64;

	internal const int DefaultSizeLimit = 67108864;

	internal const int BufferSize = 4096;

	private readonly byte[] buffer;

	private int bufferSize;

	private int bufferSizeAfterLimit;

	private int bufferPos;

	private readonly Stream input;

	private uint lastTag;

	private int totalBytesRetired;

	private int currentLimit = int.MaxValue;

	private int recursionDepth;

	private int recursionLimit = 64;

	private int sizeLimit = 67108864;

	public bool ReachedLimit
	{
		get
		{
			if (currentLimit == int.MaxValue)
			{
				return false;
			}
			int num = totalBytesRetired + bufferPos;
			return num >= currentLimit;
		}
	}

	public bool IsAtEnd
	{
		get
		{
			if (bufferPos == bufferSize)
			{
				return !RefillBuffer(mustSucceed: false);
			}
			return false;
		}
	}

	public static CodedInputStream CreateInstance(Stream input)
	{
		return new CodedInputStream(input);
	}

	public static CodedInputStream CreateInstance(byte[] buf)
	{
		return new CodedInputStream(buf);
	}

	private CodedInputStream(byte[] buffer)
	{
		this.buffer = buffer;
		bufferSize = buffer.Length;
		input = null;
	}

	private CodedInputStream(Stream input)
	{
		buffer = new byte[4096];
		bufferSize = 0;
		this.input = input;
	}

	[CLSCompliant(false)]
	public void CheckLastTagWas(uint value)
	{
		if (lastTag != value)
		{
			throw InvalidProtocolBufferException.InvalidEndTag();
		}
	}

	[CLSCompliant(false)]
	public uint ReadTag()
	{
		if (IsAtEnd)
		{
			lastTag = 0u;
			return 0u;
		}
		lastTag = ReadRawVarint32();
		if (lastTag == 0)
		{
			throw InvalidProtocolBufferException.InvalidTag();
		}
		return lastTag;
	}

	public double ReadDouble()
	{
		byte[] value = ReadRawBytes(8);
		return BitConverter.ToDouble(value, 0);
	}

	public float ReadFloat()
	{
		uint value = ReadRawLittleEndian32();
		byte[] bytes = BitConverter.GetBytes(value);
		return BitConverter.ToSingle(bytes, 0);
	}

	[CLSCompliant(false)]
	public ulong ReadUInt64()
	{
		return ReadRawVarint64();
	}

	public long ReadInt64()
	{
		return (long)ReadRawVarint64();
	}

	public int ReadInt32()
	{
		return (int)ReadRawVarint32();
	}

	[CLSCompliant(false)]
	public ulong ReadFixed64()
	{
		return ReadRawLittleEndian64();
	}

	[CLSCompliant(false)]
	public uint ReadFixed32()
	{
		return ReadRawLittleEndian32();
	}

	public bool ReadBool()
	{
		return ReadRawVarint32() != 0;
	}

	public string ReadString()
	{
		int num = (int)ReadRawVarint32();
		if (num == 0)
		{
			return "";
		}
		if (num <= bufferSize - bufferPos)
		{
			string result = Encoding.UTF8.GetString(buffer, bufferPos, num);
			bufferPos += num;
			return result;
		}
		return Encoding.UTF8.GetString(ReadRawBytes(num), 0, num);
	}

	public void ReadGroup(int fieldNumber, IBuilder builder, ExtensionRegistry extensionRegistry)
	{
		if (recursionDepth >= recursionLimit)
		{
			throw InvalidProtocolBufferException.RecursionLimitExceeded();
		}
		recursionDepth++;
		builder.WeakMergeFrom(this, extensionRegistry);
		CheckLastTagWas(WireFormat.MakeTag(fieldNumber, WireFormat.WireType.EndGroup));
		recursionDepth--;
	}

	public void ReadUnknownGroup(int fieldNumber, UnknownFieldSet.Builder builder)
	{
		if (recursionDepth >= recursionLimit)
		{
			throw InvalidProtocolBufferException.RecursionLimitExceeded();
		}
		recursionDepth++;
		builder.MergeFrom(this);
		CheckLastTagWas(WireFormat.MakeTag(fieldNumber, WireFormat.WireType.EndGroup));
		recursionDepth--;
	}

	public void ReadMessage(IBuilder builder, ExtensionRegistry extensionRegistry)
	{
		int byteLimit = (int)ReadRawVarint32();
		if (recursionDepth >= recursionLimit)
		{
			throw InvalidProtocolBufferException.RecursionLimitExceeded();
		}
		int oldLimit = PushLimit(byteLimit);
		recursionDepth++;
		builder.WeakMergeFrom(this, extensionRegistry);
		CheckLastTagWas(0u);
		recursionDepth--;
		PopLimit(oldLimit);
	}

	public ByteString ReadBytes()
	{
		int num = (int)ReadRawVarint32();
		if (num < bufferSize - bufferPos && num > 0)
		{
			ByteString result = ByteString.CopyFrom(buffer, bufferPos, num);
			bufferPos += num;
			return result;
		}
		return ByteString.CopyFrom(ReadRawBytes(num));
	}

	[CLSCompliant(false)]
	public uint ReadUInt32()
	{
		return ReadRawVarint32();
	}

	public int ReadEnum()
	{
		return (int)ReadRawVarint32();
	}

	public int ReadSFixed32()
	{
		return (int)ReadRawLittleEndian32();
	}

	public long ReadSFixed64()
	{
		return (long)ReadRawLittleEndian64();
	}

	public int ReadSInt32()
	{
		return DecodeZigZag32(ReadRawVarint32());
	}

	public long ReadSInt64()
	{
		return DecodeZigZag64(ReadRawVarint64());
	}

	public object ReadPrimitiveField(FieldType fieldType)
	{
		return fieldType switch
		{
			FieldType.Double => ReadDouble(), 
			FieldType.Float => ReadFloat(), 
			FieldType.Int64 => ReadInt64(), 
			FieldType.UInt64 => ReadUInt64(), 
			FieldType.Int32 => ReadInt32(), 
			FieldType.Fixed64 => ReadFixed64(), 
			FieldType.Fixed32 => ReadFixed32(), 
			FieldType.Bool => ReadBool(), 
			FieldType.String => ReadString(), 
			FieldType.Bytes => ReadBytes(), 
			FieldType.UInt32 => ReadUInt32(), 
			FieldType.SFixed32 => ReadSFixed32(), 
			FieldType.SFixed64 => ReadSFixed64(), 
			FieldType.SInt32 => ReadSInt32(), 
			FieldType.SInt64 => ReadSInt64(), 
			FieldType.Group => throw new ArgumentException("ReadPrimitiveField() cannot handle nested groups."), 
			FieldType.Message => throw new ArgumentException("ReadPrimitiveField() cannot handle embedded messages."), 
			FieldType.Enum => throw new ArgumentException("ReadPrimitiveField() cannot handle enums."), 
			_ => throw new ArgumentOutOfRangeException("Invalid field type " + fieldType), 
		};
	}

	private uint SlowReadRawVarint32()
	{
		int num = ReadRawByte();
		if (num < 128)
		{
			return (uint)num;
		}
		int num2 = num & 0x7F;
		if ((num = ReadRawByte()) < 128)
		{
			num2 |= num << 7;
		}
		else
		{
			num2 |= (num & 0x7F) << 7;
			if ((num = ReadRawByte()) < 128)
			{
				num2 |= num << 14;
			}
			else
			{
				num2 |= (num & 0x7F) << 14;
				if ((num = ReadRawByte()) < 128)
				{
					num2 |= num << 21;
				}
				else
				{
					num2 |= (num & 0x7F) << 21;
					num2 |= (num = ReadRawByte()) << 28;
					if (num >= 128)
					{
						for (int i = 0; i < 5; i++)
						{
							if (ReadRawByte() < 128)
							{
								return (uint)num2;
							}
						}
						throw InvalidProtocolBufferException.MalformedVarint();
					}
				}
			}
		}
		return (uint)num2;
	}

	[CLSCompliant(false)]
	public uint ReadRawVarint32()
	{
		if (bufferPos + 5 > bufferSize)
		{
			return SlowReadRawVarint32();
		}
		int num = buffer[bufferPos++];
		if (num < 128)
		{
			return (uint)num;
		}
		int num2 = num & 0x7F;
		if ((num = buffer[bufferPos++]) < 128)
		{
			num2 |= num << 7;
		}
		else
		{
			num2 |= (num & 0x7F) << 7;
			if ((num = buffer[bufferPos++]) < 128)
			{
				num2 |= num << 14;
			}
			else
			{
				num2 |= (num & 0x7F) << 14;
				if ((num = buffer[bufferPos++]) < 128)
				{
					num2 |= num << 21;
				}
				else
				{
					num2 |= (num & 0x7F) << 21;
					num2 |= (num = buffer[bufferPos++]) << 28;
					if (num >= 128)
					{
						for (int i = 0; i < 5; i++)
						{
							if (ReadRawByte() < 128)
							{
								return (uint)num2;
							}
						}
						throw InvalidProtocolBufferException.MalformedVarint();
					}
				}
			}
		}
		return (uint)num2;
	}

	internal static uint ReadRawVarint32(Stream input)
	{
		int num = 0;
		int i;
		for (i = 0; i < 32; i += 7)
		{
			int num2 = input.ReadByte();
			if (num2 == -1)
			{
				throw InvalidProtocolBufferException.TruncatedMessage();
			}
			num |= (num2 & 0x7F) << i;
			if ((num2 & 0x80) == 0)
			{
				return (uint)num;
			}
		}
		for (; i < 64; i += 7)
		{
			int num3 = input.ReadByte();
			if (num3 == -1)
			{
				throw InvalidProtocolBufferException.TruncatedMessage();
			}
			if ((num3 & 0x80) == 0)
			{
				return (uint)num;
			}
		}
		throw InvalidProtocolBufferException.MalformedVarint();
	}

	[CLSCompliant(false)]
	public ulong ReadRawVarint64()
	{
		int i = 0;
		ulong num = 0uL;
		for (; i < 64; i += 7)
		{
			byte b = ReadRawByte();
			num |= (ulong)((long)(b & 0x7F) << i);
			if ((b & 0x80) == 0)
			{
				return num;
			}
		}
		throw InvalidProtocolBufferException.MalformedVarint();
	}

	[CLSCompliant(false)]
	public uint ReadRawLittleEndian32()
	{
		uint num = ReadRawByte();
		uint num2 = ReadRawByte();
		uint num3 = ReadRawByte();
		uint num4 = ReadRawByte();
		return num | (num2 << 8) | (num3 << 16) | (num4 << 24);
	}

	[CLSCompliant(false)]
	public ulong ReadRawLittleEndian64()
	{
		ulong num = ReadRawByte();
		ulong num2 = ReadRawByte();
		ulong num3 = ReadRawByte();
		ulong num4 = ReadRawByte();
		ulong num5 = ReadRawByte();
		ulong num6 = ReadRawByte();
		ulong num7 = ReadRawByte();
		ulong num8 = ReadRawByte();
		return num | (num2 << 8) | (num3 << 16) | (num4 << 24) | (num5 << 32) | (num6 << 40) | (num7 << 48) | (num8 << 56);
	}

	[CLSCompliant(false)]
	public static int DecodeZigZag32(uint n)
	{
		return (int)((n >> 1) ^ (0 - (n & 1)));
	}

	[CLSCompliant(false)]
	public static long DecodeZigZag64(ulong n)
	{
		return (long)((n >> 1) ^ (0L - (n & 1)));
	}

	public int SetRecursionLimit(int limit)
	{
		if (limit < 0)
		{
			throw new ArgumentOutOfRangeException("Recursion limit cannot be negative: " + limit);
		}
		int result = recursionLimit;
		recursionLimit = limit;
		return result;
	}

	public int SetSizeLimit(int limit)
	{
		if (limit < 0)
		{
			throw new ArgumentOutOfRangeException("Size limit cannot be negative: " + limit);
		}
		int result = sizeLimit;
		sizeLimit = limit;
		return result;
	}

	public void ResetSizeCounter()
	{
		totalBytesRetired = 0;
	}

	public int PushLimit(int byteLimit)
	{
		if (byteLimit < 0)
		{
			throw InvalidProtocolBufferException.NegativeSize();
		}
		byteLimit += totalBytesRetired + bufferPos;
		int num = currentLimit;
		if (byteLimit > num)
		{
			throw InvalidProtocolBufferException.TruncatedMessage();
		}
		currentLimit = byteLimit;
		RecomputeBufferSizeAfterLimit();
		return num;
	}

	private void RecomputeBufferSizeAfterLimit()
	{
		bufferSize += bufferSizeAfterLimit;
		int num = totalBytesRetired + bufferSize;
		if (num > currentLimit)
		{
			bufferSizeAfterLimit = num - currentLimit;
			bufferSize -= bufferSizeAfterLimit;
		}
		else
		{
			bufferSizeAfterLimit = 0;
		}
	}

	public void PopLimit(int oldLimit)
	{
		currentLimit = oldLimit;
		RecomputeBufferSizeAfterLimit();
	}

	private bool RefillBuffer(bool mustSucceed)
	{
		if (bufferPos < bufferSize)
		{
			throw new InvalidOperationException("RefillBuffer() called when buffer wasn't empty.");
		}
		if (totalBytesRetired + bufferSize == currentLimit)
		{
			if (mustSucceed)
			{
				throw InvalidProtocolBufferException.TruncatedMessage();
			}
			return false;
		}
		totalBytesRetired += bufferSize;
		bufferPos = 0;
		bufferSize = ((input != null) ? input.Read(buffer, 0, buffer.Length) : 0);
		if (bufferSize < 0)
		{
			throw new InvalidOperationException("Stream.Read returned a negative count");
		}
		if (bufferSize == 0)
		{
			if (mustSucceed)
			{
				throw InvalidProtocolBufferException.TruncatedMessage();
			}
			return false;
		}
		RecomputeBufferSizeAfterLimit();
		int num = totalBytesRetired + bufferSize + bufferSizeAfterLimit;
		if (num > sizeLimit || num < 0)
		{
			throw InvalidProtocolBufferException.SizeLimitExceeded();
		}
		return true;
	}

	public byte ReadRawByte()
	{
		if (bufferPos == bufferSize)
		{
			RefillBuffer(mustSucceed: true);
		}
		return buffer[bufferPos++];
	}

	public byte[] ReadRawBytes(int size)
	{
		if (size < 0)
		{
			throw InvalidProtocolBufferException.NegativeSize();
		}
		if (totalBytesRetired + bufferPos + size > currentLimit)
		{
			SkipRawBytes(currentLimit - totalBytesRetired - bufferPos);
			throw InvalidProtocolBufferException.TruncatedMessage();
		}
		if (size <= bufferSize - bufferPos)
		{
			byte[] array = new byte[size];
			Array.Copy(buffer, bufferPos, array, 0, size);
			bufferPos += size;
			return array;
		}
		if (size < 4096)
		{
			byte[] array2 = new byte[size];
			int num = bufferSize - bufferPos;
			Array.Copy(buffer, bufferPos, array2, 0, num);
			bufferPos = bufferSize;
			RefillBuffer(mustSucceed: true);
			while (size - num > bufferSize)
			{
				Array.Copy(buffer, 0, array2, num, bufferSize);
				num += bufferSize;
				bufferPos = bufferSize;
				RefillBuffer(mustSucceed: true);
			}
			Array.Copy(buffer, 0, array2, num, size - num);
			bufferPos = size - num;
			return array2;
		}
		int num2 = bufferPos;
		int num3 = bufferSize;
		totalBytesRetired += bufferSize;
		bufferPos = 0;
		bufferSize = 0;
		int num4 = size - (num3 - num2);
		List<byte[]> list = new List<byte[]>();
		while (num4 > 0)
		{
			byte[] array3 = new byte[Math.Min(num4, 4096)];
			int num5;
			for (int i = 0; i < array3.Length; i += num5)
			{
				num5 = ((input == null) ? (-1) : input.Read(array3, i, array3.Length - i));
				if (num5 <= 0)
				{
					throw InvalidProtocolBufferException.TruncatedMessage();
				}
				totalBytesRetired += num5;
			}
			num4 -= array3.Length;
			list.Add(array3);
		}
		byte[] array4 = new byte[size];
		int num6 = num3 - num2;
		Array.Copy(buffer, num2, array4, 0, num6);
		foreach (byte[] item in list)
		{
			Array.Copy(item, 0, array4, num6, item.Length);
			num6 += item.Length;
		}
		return array4;
	}

	[CLSCompliant(false)]
	public bool SkipField(uint tag)
	{
		switch (WireFormat.GetTagWireType(tag))
		{
		case WireFormat.WireType.Varint:
			ReadInt32();
			return true;
		case WireFormat.WireType.Fixed64:
			ReadRawLittleEndian64();
			return true;
		case WireFormat.WireType.LengthDelimited:
			SkipRawBytes((int)ReadRawVarint32());
			return true;
		case WireFormat.WireType.StartGroup:
			SkipMessage();
			CheckLastTagWas(WireFormat.MakeTag(WireFormat.GetTagFieldNumber(tag), WireFormat.WireType.EndGroup));
			return true;
		case WireFormat.WireType.EndGroup:
			return false;
		case WireFormat.WireType.Fixed32:
			ReadRawLittleEndian32();
			return true;
		default:
			throw InvalidProtocolBufferException.InvalidWireType();
		}
	}

	public void SkipMessage()
	{
		uint num;
		do
		{
			num = ReadTag();
		}
		while (num != 0 && SkipField(num));
	}

	public void SkipRawBytes(int size)
	{
		if (size < 0)
		{
			throw InvalidProtocolBufferException.NegativeSize();
		}
		if (totalBytesRetired + bufferPos + size > currentLimit)
		{
			SkipRawBytes(currentLimit - totalBytesRetired - bufferPos);
			throw InvalidProtocolBufferException.TruncatedMessage();
		}
		if (size <= bufferSize - bufferPos)
		{
			bufferPos += size;
			return;
		}
		int num = bufferSize - bufferPos;
		totalBytesRetired += num;
		bufferPos = 0;
		bufferSize = 0;
		if (num < size)
		{
			if (input == null)
			{
				throw InvalidProtocolBufferException.TruncatedMessage();
			}
			SkipImpl(size - num);
			totalBytesRetired += size - num;
		}
	}

	private void SkipImpl(int amountToSkip)
	{
		if (input.CanSeek)
		{
			long position = input.Position;
			input.Position += amountToSkip;
			if (input.Position != position + amountToSkip)
			{
				throw InvalidProtocolBufferException.TruncatedMessage();
			}
			return;
		}
		byte[] array = new byte[1024];
		while (amountToSkip > 0)
		{
			int num = input.Read(array, 0, array.Length);
			if (num <= 0)
			{
				throw InvalidProtocolBufferException.TruncatedMessage();
			}
			amountToSkip -= num;
		}
	}
}
