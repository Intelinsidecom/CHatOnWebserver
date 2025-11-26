using System;

namespace Google.ProtocolBuffers.Descriptors;

[AttributeUsage(AttributeTargets.Field)]
internal sealed class FieldMappingAttribute : Attribute
{
	internal MappedType MappedType { get; private set; }

	internal WireFormat.WireType WireType { get; private set; }

	internal FieldMappingAttribute(MappedType mappedType, WireFormat.WireType wireType)
	{
		MappedType = mappedType;
		WireType = wireType;
	}
}
