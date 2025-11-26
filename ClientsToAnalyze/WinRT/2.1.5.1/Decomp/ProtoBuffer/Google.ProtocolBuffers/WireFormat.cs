using System;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public static class WireFormat
{
	[CLSCompliant(false)]
	public enum WireType : uint
	{
		Varint,
		Fixed64,
		LengthDelimited,
		StartGroup,
		EndGroup,
		Fixed32
	}

	internal static class MessageSetField
	{
		internal const int Item = 1;

		internal const int TypeID = 2;

		internal const int Message = 3;
	}

	internal static class MessageSetTag
	{
		internal static readonly uint ItemStart = MakeTag(1, WireType.StartGroup);

		internal static readonly uint ItemEnd = MakeTag(1, WireType.EndGroup);

		internal static readonly uint TypeID = MakeTag(2, WireType.Varint);

		internal static readonly uint Message = MakeTag(3, WireType.LengthDelimited);
	}

	internal const int Fixed32Size = 4;

	internal const int Fixed64Size = 8;

	internal const int SFixed32Size = 4;

	internal const int SFixed64Size = 8;

	internal const int FloatSize = 4;

	internal const int DoubleSize = 8;

	internal const int BoolSize = 1;

	private const int TagTypeBits = 3;

	private const uint TagTypeMask = 7u;

	[CLSCompliant(false)]
	public static WireType GetTagWireType(uint tag)
	{
		return (WireType)(tag & 7);
	}

	[CLSCompliant(false)]
	public static bool IsEndGroupTag(uint tag)
	{
		return (tag & 7) == 4;
	}

	[CLSCompliant(false)]
	public static int GetTagFieldNumber(uint tag)
	{
		return (int)tag >> 3;
	}

	[CLSCompliant(false)]
	public static uint MakeTag(int fieldNumber, WireType wireType)
	{
		return (uint)(fieldNumber << 3) | (uint)wireType;
	}

	[CLSCompliant(false)]
	public static uint MakeTag(FieldDescriptor field)
	{
		return MakeTag(field.FieldNumber, GetWireType(field));
	}

	internal static WireType GetWireType(FieldDescriptor descriptor)
	{
		if (!descriptor.IsPacked)
		{
			return GetWireType(descriptor.FieldType);
		}
		return WireType.LengthDelimited;
	}

	[CLSCompliant(false)]
	public static WireType GetWireType(FieldType fieldType)
	{
		switch (fieldType)
		{
		case FieldType.Double:
			return WireType.Fixed64;
		case FieldType.Float:
			return WireType.Fixed32;
		case FieldType.Int64:
		case FieldType.UInt64:
		case FieldType.Int32:
			return WireType.Varint;
		case FieldType.Fixed64:
			return WireType.Fixed64;
		case FieldType.Fixed32:
			return WireType.Fixed32;
		case FieldType.Bool:
			return WireType.Varint;
		case FieldType.String:
			return WireType.LengthDelimited;
		case FieldType.Group:
			return WireType.StartGroup;
		case FieldType.Message:
		case FieldType.Bytes:
			return WireType.LengthDelimited;
		case FieldType.UInt32:
			return WireType.Varint;
		case FieldType.SFixed32:
			return WireType.Fixed32;
		case FieldType.SFixed64:
			return WireType.Fixed64;
		case FieldType.SInt32:
		case FieldType.SInt64:
		case FieldType.Enum:
			return WireType.Varint;
		default:
			throw new ArgumentOutOfRangeException("No such field type");
		}
	}
}
