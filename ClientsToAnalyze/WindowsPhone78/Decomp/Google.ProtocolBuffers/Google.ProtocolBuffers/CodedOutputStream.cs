using System;
using System.IO;
using System.Text;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public sealed class CodedOutputStream
{
	public sealed class OutOfSpaceException : IOException
	{
		internal OutOfSpaceException()
			: base("CodedOutputStream was writing to a flat byte array and ran out of space.")
		{
		}
	}

	private const int LittleEndian64Size = 8;

	private const int LittleEndian32Size = 4;

	public static readonly int DefaultBufferSize = 4096;

	private readonly byte[] buffer;

	private readonly int limit;

	private int position;

	private readonly Stream output;

	public int SpaceLeft
	{
		get
		{
			if (output == null)
			{
				return limit - position;
			}
			throw new InvalidOperationException("SpaceLeft can only be called on CodedOutputStreams that are writing to a flat array.");
		}
	}

	private CodedOutputStream(byte[] buffer, int offset, int length)
	{
		output = null;
		this.buffer = buffer;
		position = offset;
		limit = offset + length;
	}

	private CodedOutputStream(Stream output, byte[] buffer)
	{
		this.output = output;
		this.buffer = buffer;
		position = 0;
		limit = buffer.Length;
	}

	public static CodedOutputStream CreateInstance(Stream output)
	{
		return CreateInstance(output, DefaultBufferSize);
	}

	public static CodedOutputStream CreateInstance(Stream output, int bufferSize)
	{
		return new CodedOutputStream(output, new byte[bufferSize]);
	}

	public static CodedOutputStream CreateInstance(byte[] flatArray)
	{
		return CreateInstance(flatArray, 0, flatArray.Length);
	}

	public static CodedOutputStream CreateInstance(byte[] flatArray, int offset, int length)
	{
		return new CodedOutputStream(flatArray, offset, length);
	}

	public void WriteDouble(int fieldNumber, double value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Fixed64);
		WriteDoubleNoTag(value);
	}

	public void WriteFloat(int fieldNumber, float value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Fixed32);
		WriteFloatNoTag(value);
	}

	[CLSCompliant(false)]
	public void WriteUInt64(int fieldNumber, ulong value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Varint);
		WriteRawVarint64(value);
	}

	public void WriteInt64(int fieldNumber, long value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Varint);
		WriteRawVarint64((ulong)value);
	}

	public void WriteInt32(int fieldNumber, int value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Varint);
		if (value >= 0)
		{
			WriteRawVarint32((uint)value);
		}
		else
		{
			WriteRawVarint64((ulong)value);
		}
	}

	[CLSCompliant(false)]
	public void WriteFixed64(int fieldNumber, ulong value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Fixed64);
		WriteRawLittleEndian64(value);
	}

	[CLSCompliant(false)]
	public void WriteFixed32(int fieldNumber, uint value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Fixed32);
		WriteRawLittleEndian32(value);
	}

	public void WriteBool(int fieldNumber, bool value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Varint);
		WriteRawByte((byte)(value ? 1 : 0));
	}

	public void WriteString(int fieldNumber, string value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.LengthDelimited);
		int byteCount = Encoding.UTF8.GetByteCount(value);
		WriteRawVarint32((uint)byteCount);
		if (limit - position >= byteCount)
		{
			Encoding.UTF8.GetBytes(value, 0, value.Length, buffer, position);
			position += byteCount;
		}
		else
		{
			byte[] bytes = Encoding.UTF8.GetBytes(value);
			WriteRawBytes(bytes);
		}
	}

	public void WriteGroup(int fieldNumber, IMessage value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.StartGroup);
		value.WriteTo(this);
		WriteTag(fieldNumber, WireFormat.WireType.EndGroup);
	}

	public void WriteUnknownGroup(int fieldNumber, UnknownFieldSet value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.StartGroup);
		value.WriteTo(this);
		WriteTag(fieldNumber, WireFormat.WireType.EndGroup);
	}

	public void WriteMessage(int fieldNumber, IMessage value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.LengthDelimited);
		WriteRawVarint32((uint)value.SerializedSize);
		value.WriteTo(this);
	}

	public void WriteBytes(int fieldNumber, ByteString value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.LengthDelimited);
		byte[] array = value.ToByteArray();
		WriteRawVarint32((uint)array.Length);
		WriteRawBytes(array);
	}

	[CLSCompliant(false)]
	public void WriteUInt32(int fieldNumber, uint value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Varint);
		WriteRawVarint32(value);
	}

	public void WriteEnum(int fieldNumber, int value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Varint);
		WriteRawVarint32((uint)value);
	}

	public void WriteSFixed32(int fieldNumber, int value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Fixed32);
		WriteRawLittleEndian32((uint)value);
	}

	public void WriteSFixed64(int fieldNumber, long value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Fixed64);
		WriteRawLittleEndian64((ulong)value);
	}

	public void WriteSInt32(int fieldNumber, int value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Varint);
		WriteRawVarint32(EncodeZigZag32(value));
	}

	public void WriteSInt64(int fieldNumber, long value)
	{
		WriteTag(fieldNumber, WireFormat.WireType.Varint);
		WriteRawVarint64(EncodeZigZag64(value));
	}

	public void WriteMessageSetExtension(int fieldNumber, IMessage value)
	{
		WriteTag(1, WireFormat.WireType.StartGroup);
		WriteUInt32(2, (uint)fieldNumber);
		WriteMessage(3, value);
		WriteTag(1, WireFormat.WireType.EndGroup);
	}

	public void WriteRawMessageSetExtension(int fieldNumber, ByteString value)
	{
		WriteTag(1, WireFormat.WireType.StartGroup);
		WriteUInt32(2, (uint)fieldNumber);
		WriteBytes(3, value);
		WriteTag(1, WireFormat.WireType.EndGroup);
	}

	public void WriteField(FieldType fieldType, int fieldNumber, object value)
	{
		switch (fieldType)
		{
		case FieldType.Double:
			WriteDouble(fieldNumber, (double)value);
			break;
		case FieldType.Float:
			WriteFloat(fieldNumber, (float)value);
			break;
		case FieldType.Int64:
			WriteInt64(fieldNumber, (long)value);
			break;
		case FieldType.UInt64:
			WriteUInt64(fieldNumber, (ulong)value);
			break;
		case FieldType.Int32:
			WriteInt32(fieldNumber, (int)value);
			break;
		case FieldType.Fixed64:
			WriteFixed64(fieldNumber, (ulong)value);
			break;
		case FieldType.Fixed32:
			WriteFixed32(fieldNumber, (uint)value);
			break;
		case FieldType.Bool:
			WriteBool(fieldNumber, (bool)value);
			break;
		case FieldType.String:
			WriteString(fieldNumber, (string)value);
			break;
		case FieldType.Group:
			WriteGroup(fieldNumber, (IMessage)value);
			break;
		case FieldType.Message:
			WriteMessage(fieldNumber, (IMessage)value);
			break;
		case FieldType.Bytes:
			WriteBytes(fieldNumber, (ByteString)value);
			break;
		case FieldType.UInt32:
			WriteUInt32(fieldNumber, (uint)value);
			break;
		case FieldType.SFixed32:
			WriteSFixed32(fieldNumber, (int)value);
			break;
		case FieldType.SFixed64:
			WriteSFixed64(fieldNumber, (long)value);
			break;
		case FieldType.SInt32:
			WriteSInt32(fieldNumber, (int)value);
			break;
		case FieldType.SInt64:
			WriteSInt64(fieldNumber, (long)value);
			break;
		case FieldType.Enum:
			WriteEnum(fieldNumber, ((EnumValueDescriptor)value).Number);
			break;
		}
	}

	public void WriteFieldNoTag(FieldType fieldType, object value)
	{
		switch (fieldType)
		{
		case FieldType.Double:
			WriteDoubleNoTag((double)value);
			break;
		case FieldType.Float:
			WriteFloatNoTag((float)value);
			break;
		case FieldType.Int64:
			WriteInt64NoTag((long)value);
			break;
		case FieldType.UInt64:
			WriteUInt64NoTag((ulong)value);
			break;
		case FieldType.Int32:
			WriteInt32NoTag((int)value);
			break;
		case FieldType.Fixed64:
			WriteFixed64NoTag((ulong)value);
			break;
		case FieldType.Fixed32:
			WriteFixed32NoTag((uint)value);
			break;
		case FieldType.Bool:
			WriteBoolNoTag((bool)value);
			break;
		case FieldType.String:
			WriteStringNoTag((string)value);
			break;
		case FieldType.Group:
			WriteGroupNoTag((IMessage)value);
			break;
		case FieldType.Message:
			WriteMessageNoTag((IMessage)value);
			break;
		case FieldType.Bytes:
			WriteBytesNoTag((ByteString)value);
			break;
		case FieldType.UInt32:
			WriteUInt32NoTag((uint)value);
			break;
		case FieldType.SFixed32:
			WriteSFixed32NoTag((int)value);
			break;
		case FieldType.SFixed64:
			WriteSFixed64NoTag((long)value);
			break;
		case FieldType.SInt32:
			WriteSInt32NoTag((int)value);
			break;
		case FieldType.SInt64:
			WriteSInt64NoTag((long)value);
			break;
		case FieldType.Enum:
			WriteEnumNoTag(((EnumValueDescriptor)value).Number);
			break;
		}
	}

	public void WriteDoubleNoTag(double value)
	{
		byte[] bytes = BitConverter.GetBytes(value);
		WriteRawBytes(bytes, 0, 8);
	}

	public void WriteFloatNoTag(float value)
	{
		byte[] bytes = BitConverter.GetBytes(value);
		uint value2 = BitConverter.ToUInt32(bytes, 0);
		WriteRawLittleEndian32(value2);
	}

	[CLSCompliant(false)]
	public void WriteUInt64NoTag(ulong value)
	{
		WriteRawVarint64(value);
	}

	public void WriteInt64NoTag(long value)
	{
		WriteRawVarint64((ulong)value);
	}

	public void WriteInt32NoTag(int value)
	{
		if (value >= 0)
		{
			WriteRawVarint32((uint)value);
		}
		else
		{
			WriteRawVarint64((ulong)value);
		}
	}

	[CLSCompliant(false)]
	public void WriteFixed64NoTag(ulong value)
	{
		WriteRawLittleEndian64(value);
	}

	[CLSCompliant(false)]
	public void WriteFixed32NoTag(uint value)
	{
		WriteRawLittleEndian32(value);
	}

	public void WriteBoolNoTag(bool value)
	{
		WriteRawByte((byte)(value ? 1 : 0));
	}

	public void WriteStringNoTag(string value)
	{
		int byteCount = Encoding.UTF8.GetByteCount(value);
		WriteRawVarint32((uint)byteCount);
		if (limit - position >= byteCount)
		{
			Encoding.UTF8.GetBytes(value, 0, value.Length, buffer, position);
			position += byteCount;
		}
		else
		{
			byte[] bytes = Encoding.UTF8.GetBytes(value);
			WriteRawBytes(bytes);
		}
	}

	public void WriteGroupNoTag(IMessage value)
	{
		value.WriteTo(this);
	}

	public void WriteMessageNoTag(IMessage value)
	{
		WriteRawVarint32((uint)value.SerializedSize);
		value.WriteTo(this);
	}

	public void WriteBytesNoTag(ByteString value)
	{
		byte[] array = value.ToByteArray();
		WriteRawVarint32((uint)array.Length);
		WriteRawBytes(array);
	}

	[CLSCompliant(false)]
	public void WriteUInt32NoTag(uint value)
	{
		WriteRawVarint32(value);
	}

	public void WriteEnumNoTag(int value)
	{
		WriteRawVarint32((uint)value);
	}

	public void WriteSFixed32NoTag(int value)
	{
		WriteRawLittleEndian32((uint)value);
	}

	public void WriteSFixed64NoTag(long value)
	{
		WriteRawLittleEndian64((ulong)value);
	}

	public void WriteSInt32NoTag(int value)
	{
		WriteRawVarint32(EncodeZigZag32(value));
	}

	public void WriteSInt64NoTag(long value)
	{
		WriteRawVarint64(EncodeZigZag64(value));
	}

	[CLSCompliant(false)]
	public void WriteTag(int fieldNumber, WireFormat.WireType type)
	{
		WriteRawVarint32(WireFormat.MakeTag(fieldNumber, type));
	}

	private void SlowWriteRawVarint32(uint value)
	{
		while ((value & -128) != 0)
		{
			WriteRawByte((value & 0x7F) | 0x80);
			value >>= 7;
		}
		WriteRawByte(value);
	}

	[CLSCompliant(false)]
	public void WriteRawVarint32(uint value)
	{
		if (position + 5 > limit)
		{
			SlowWriteRawVarint32(value);
			return;
		}
		while ((value & -128) != 0)
		{
			buffer[position++] = (byte)((value & 0x7F) | 0x80);
			value >>= 7;
		}
		buffer[position++] = (byte)value;
	}

	[CLSCompliant(false)]
	public void WriteRawVarint64(ulong value)
	{
		while ((value & 0xFFFFFFFFFFFFFF80uL) != 0)
		{
			WriteRawByte((uint)(((int)value & 0x7F) | 0x80));
			value >>= 7;
		}
		WriteRawByte((uint)value);
	}

	[CLSCompliant(false)]
	public void WriteRawLittleEndian32(uint value)
	{
		WriteRawByte((byte)value);
		WriteRawByte((byte)(value >> 8));
		WriteRawByte((byte)(value >> 16));
		WriteRawByte((byte)(value >> 24));
	}

	[CLSCompliant(false)]
	public void WriteRawLittleEndian64(ulong value)
	{
		WriteRawByte((byte)value);
		WriteRawByte((byte)(value >> 8));
		WriteRawByte((byte)(value >> 16));
		WriteRawByte((byte)(value >> 24));
		WriteRawByte((byte)(value >> 32));
		WriteRawByte((byte)(value >> 40));
		WriteRawByte((byte)(value >> 48));
		WriteRawByte((byte)(value >> 56));
	}

	public void WriteRawByte(byte value)
	{
		if (position == limit)
		{
			RefreshBuffer();
		}
		buffer[position++] = value;
	}

	[CLSCompliant(false)]
	public void WriteRawByte(uint value)
	{
		WriteRawByte((byte)value);
	}

	public void WriteRawBytes(byte[] value)
	{
		WriteRawBytes(value, 0, value.Length);
	}

	public void WriteRawBytes(byte[] value, int offset, int length)
	{
		if (limit - position >= length)
		{
			Array.Copy(value, offset, buffer, position, length);
			position += length;
			return;
		}
		int num = limit - position;
		Array.Copy(value, offset, buffer, position, num);
		offset += num;
		length -= num;
		position = limit;
		RefreshBuffer();
		if (length <= limit)
		{
			Array.Copy(value, offset, buffer, 0, length);
			position = length;
		}
		else
		{
			output.Write(value, offset, length);
		}
	}

	public static int ComputeDoubleSize(int fieldNumber, double value)
	{
		return ComputeTagSize(fieldNumber) + 8;
	}

	public static int ComputeFloatSize(int fieldNumber, float value)
	{
		return ComputeTagSize(fieldNumber) + 4;
	}

	[CLSCompliant(false)]
	public static int ComputeUInt64Size(int fieldNumber, ulong value)
	{
		return ComputeTagSize(fieldNumber) + ComputeRawVarint64Size(value);
	}

	public static int ComputeInt64Size(int fieldNumber, long value)
	{
		return ComputeTagSize(fieldNumber) + ComputeRawVarint64Size((ulong)value);
	}

	public static int ComputeInt32Size(int fieldNumber, int value)
	{
		if (value >= 0)
		{
			return ComputeTagSize(fieldNumber) + ComputeRawVarint32Size((uint)value);
		}
		return ComputeTagSize(fieldNumber) + 10;
	}

	[CLSCompliant(false)]
	public static int ComputeFixed64Size(int fieldNumber, ulong value)
	{
		return ComputeTagSize(fieldNumber) + 8;
	}

	[CLSCompliant(false)]
	public static int ComputeFixed32Size(int fieldNumber, uint value)
	{
		return ComputeTagSize(fieldNumber) + 4;
	}

	public static int ComputeBoolSize(int fieldNumber, bool value)
	{
		return ComputeTagSize(fieldNumber) + 1;
	}

	public static int ComputeStringSize(int fieldNumber, string value)
	{
		int byteCount = Encoding.UTF8.GetByteCount(value);
		return ComputeTagSize(fieldNumber) + ComputeRawVarint32Size((uint)byteCount) + byteCount;
	}

	public static int ComputeGroupSize(int fieldNumber, IMessage value)
	{
		return ComputeTagSize(fieldNumber) * 2 + value.SerializedSize;
	}

	public static int ComputeUnknownGroupSize(int fieldNumber, UnknownFieldSet value)
	{
		return ComputeTagSize(fieldNumber) * 2 + value.SerializedSize;
	}

	public static int ComputeMessageSize(int fieldNumber, IMessage value)
	{
		int serializedSize = value.SerializedSize;
		return ComputeTagSize(fieldNumber) + ComputeRawVarint32Size((uint)serializedSize) + serializedSize;
	}

	public static int ComputeBytesSize(int fieldNumber, ByteString value)
	{
		return ComputeTagSize(fieldNumber) + ComputeRawVarint32Size((uint)value.Length) + value.Length;
	}

	[CLSCompliant(false)]
	public static int ComputeUInt32Size(int fieldNumber, uint value)
	{
		return ComputeTagSize(fieldNumber) + ComputeRawVarint32Size(value);
	}

	public static int ComputeEnumSize(int fieldNumber, int value)
	{
		return ComputeTagSize(fieldNumber) + ComputeRawVarint32Size((uint)value);
	}

	public static int ComputeSFixed32Size(int fieldNumber, int value)
	{
		return ComputeTagSize(fieldNumber) + 4;
	}

	public static int ComputeSFixed64Size(int fieldNumber, long value)
	{
		return ComputeTagSize(fieldNumber) + 8;
	}

	public static int ComputeSInt32Size(int fieldNumber, int value)
	{
		return ComputeTagSize(fieldNumber) + ComputeRawVarint32Size(EncodeZigZag32(value));
	}

	public static int ComputeSInt64Size(int fieldNumber, long value)
	{
		return ComputeTagSize(fieldNumber) + ComputeRawVarint64Size(EncodeZigZag64(value));
	}

	public static int ComputeDoubleSizeNoTag(double value)
	{
		return 8;
	}

	public static int ComputeFloatSizeNoTag(float value)
	{
		return 4;
	}

	[CLSCompliant(false)]
	public static int ComputeUInt64SizeNoTag(ulong value)
	{
		return ComputeRawVarint64Size(value);
	}

	public static int ComputeInt64SizeNoTag(long value)
	{
		return ComputeRawVarint64Size((ulong)value);
	}

	public static int ComputeInt32SizeNoTag(int value)
	{
		if (value >= 0)
		{
			return ComputeRawVarint32Size((uint)value);
		}
		return 10;
	}

	[CLSCompliant(false)]
	public static int ComputeFixed64SizeNoTag(ulong value)
	{
		return 8;
	}

	[CLSCompliant(false)]
	public static int ComputeFixed32SizeNoTag(uint value)
	{
		return 4;
	}

	public static int ComputeBoolSizeNoTag(bool value)
	{
		return 1;
	}

	public static int ComputeStringSizeNoTag(string value)
	{
		int byteCount = Encoding.UTF8.GetByteCount(value);
		return ComputeRawVarint32Size((uint)byteCount) + byteCount;
	}

	public static int ComputeGroupSizeNoTag(IMessage value)
	{
		return value.SerializedSize;
	}

	public static int ComputeUnknownGroupSizeNoTag(UnknownFieldSet value)
	{
		return value.SerializedSize;
	}

	public static int ComputeMessageSizeNoTag(IMessage value)
	{
		int serializedSize = value.SerializedSize;
		return ComputeRawVarint32Size((uint)serializedSize) + serializedSize;
	}

	public static int ComputeBytesSizeNoTag(ByteString value)
	{
		return ComputeRawVarint32Size((uint)value.Length) + value.Length;
	}

	[CLSCompliant(false)]
	public static int ComputeUInt32SizeNoTag(uint value)
	{
		return ComputeRawVarint32Size(value);
	}

	public static int ComputeEnumSizeNoTag(int value)
	{
		return ComputeRawVarint32Size((uint)value);
	}

	public static int ComputeSFixed32SizeNoTag(int value)
	{
		return 4;
	}

	public static int ComputeSFixed64SizeNoTag(long value)
	{
		return 8;
	}

	public static int ComputeSInt32SizeNoTag(int value)
	{
		return ComputeRawVarint32Size(EncodeZigZag32(value));
	}

	public static int ComputeSInt64SizeNoTag(long value)
	{
		return ComputeRawVarint64Size(EncodeZigZag64(value));
	}

	public static int ComputeMessageSetExtensionSize(int fieldNumber, IMessage value)
	{
		return ComputeTagSize(1) * 2 + ComputeUInt32Size(2, (uint)fieldNumber) + ComputeMessageSize(3, value);
	}

	public static int ComputeRawMessageSetExtensionSize(int fieldNumber, ByteString value)
	{
		return ComputeTagSize(1) * 2 + ComputeUInt32Size(2, (uint)fieldNumber) + ComputeBytesSize(3, value);
	}

	[CLSCompliant(false)]
	public static int ComputeRawVarint32Size(uint value)
	{
		if ((value & 0xFFFFFF80u) == 0)
		{
			return 1;
		}
		if ((value & 0xFFFFC000u) == 0)
		{
			return 2;
		}
		if ((value & 0xFFE00000u) == 0)
		{
			return 3;
		}
		if ((value & 0xF0000000u) == 0)
		{
			return 4;
		}
		return 5;
	}

	[CLSCompliant(false)]
	public static int ComputeRawVarint64Size(ulong value)
	{
		if ((value & 0xFFFFFFFFFFFFFF80uL) == 0)
		{
			return 1;
		}
		if ((value & 0xFFFFFFFFFFFFC000uL) == 0)
		{
			return 2;
		}
		if ((value & 0xFFFFFFFFFFE00000uL) == 0)
		{
			return 3;
		}
		if ((value & 0xFFFFFFFFF0000000uL) == 0)
		{
			return 4;
		}
		if ((value & 0xFFFFFFF800000000uL) == 0)
		{
			return 5;
		}
		if ((value & 0xFFFFFC0000000000uL) == 0)
		{
			return 6;
		}
		if ((value & 0xFFFE000000000000uL) == 0)
		{
			return 7;
		}
		if ((value & 0xFF00000000000000uL) == 0)
		{
			return 8;
		}
		if ((value & 0x8000000000000000uL) == 0)
		{
			return 9;
		}
		return 10;
	}

	public static int ComputeFieldSize(FieldType fieldType, int fieldNumber, object value)
	{
		return fieldType switch
		{
			FieldType.Double => ComputeDoubleSize(fieldNumber, (double)value), 
			FieldType.Float => ComputeFloatSize(fieldNumber, (float)value), 
			FieldType.Int64 => ComputeInt64Size(fieldNumber, (long)value), 
			FieldType.UInt64 => ComputeUInt64Size(fieldNumber, (ulong)value), 
			FieldType.Int32 => ComputeInt32Size(fieldNumber, (int)value), 
			FieldType.Fixed64 => ComputeFixed64Size(fieldNumber, (ulong)value), 
			FieldType.Fixed32 => ComputeFixed32Size(fieldNumber, (uint)value), 
			FieldType.Bool => ComputeBoolSize(fieldNumber, (bool)value), 
			FieldType.String => ComputeStringSize(fieldNumber, (string)value), 
			FieldType.Group => ComputeGroupSize(fieldNumber, (IMessage)value), 
			FieldType.Message => ComputeMessageSize(fieldNumber, (IMessage)value), 
			FieldType.Bytes => ComputeBytesSize(fieldNumber, (ByteString)value), 
			FieldType.UInt32 => ComputeUInt32Size(fieldNumber, (uint)value), 
			FieldType.SFixed32 => ComputeSFixed32Size(fieldNumber, (int)value), 
			FieldType.SFixed64 => ComputeSFixed64Size(fieldNumber, (long)value), 
			FieldType.SInt32 => ComputeSInt32Size(fieldNumber, (int)value), 
			FieldType.SInt64 => ComputeSInt64Size(fieldNumber, (long)value), 
			FieldType.Enum => ComputeEnumSize(fieldNumber, ((EnumValueDescriptor)value).Number), 
			_ => throw new ArgumentOutOfRangeException("Invalid field type " + fieldType), 
		};
	}

	public static int ComputeFieldSizeNoTag(FieldType fieldType, object value)
	{
		return fieldType switch
		{
			FieldType.Double => ComputeDoubleSizeNoTag((double)value), 
			FieldType.Float => ComputeFloatSizeNoTag((float)value), 
			FieldType.Int64 => ComputeInt64SizeNoTag((long)value), 
			FieldType.UInt64 => ComputeUInt64SizeNoTag((ulong)value), 
			FieldType.Int32 => ComputeInt32SizeNoTag((int)value), 
			FieldType.Fixed64 => ComputeFixed64SizeNoTag((ulong)value), 
			FieldType.Fixed32 => ComputeFixed32SizeNoTag((uint)value), 
			FieldType.Bool => ComputeBoolSizeNoTag((bool)value), 
			FieldType.String => ComputeStringSizeNoTag((string)value), 
			FieldType.Group => ComputeGroupSizeNoTag((IMessage)value), 
			FieldType.Message => ComputeMessageSizeNoTag((IMessage)value), 
			FieldType.Bytes => ComputeBytesSizeNoTag((ByteString)value), 
			FieldType.UInt32 => ComputeUInt32SizeNoTag((uint)value), 
			FieldType.SFixed32 => ComputeSFixed32SizeNoTag((int)value), 
			FieldType.SFixed64 => ComputeSFixed64SizeNoTag((long)value), 
			FieldType.SInt32 => ComputeSInt32SizeNoTag((int)value), 
			FieldType.SInt64 => ComputeSInt64SizeNoTag((long)value), 
			FieldType.Enum => ComputeEnumSizeNoTag(((EnumValueDescriptor)value).Number), 
			_ => throw new ArgumentOutOfRangeException("Invalid field type " + fieldType), 
		};
	}

	public static int ComputeTagSize(int fieldNumber)
	{
		return ComputeRawVarint32Size(WireFormat.MakeTag(fieldNumber, WireFormat.WireType.Varint));
	}

	[CLSCompliant(false)]
	public static uint EncodeZigZag32(int n)
	{
		return (uint)((n << 1) ^ (n >> 31));
	}

	[CLSCompliant(false)]
	public static ulong EncodeZigZag64(long n)
	{
		return (ulong)((n << 1) ^ (n >> 63));
	}

	private void RefreshBuffer()
	{
		if (output == null)
		{
			throw new OutOfSpaceException();
		}
		output.Write(buffer, 0, position);
		position = 0;
	}

	public void Flush()
	{
		if (output != null)
		{
			RefreshBuffer();
		}
	}

	public void CheckNoSpaceLeft()
	{
		if (SpaceLeft != 0)
		{
			throw new InvalidOperationException("Did not write as much data as expected.");
		}
	}
}
