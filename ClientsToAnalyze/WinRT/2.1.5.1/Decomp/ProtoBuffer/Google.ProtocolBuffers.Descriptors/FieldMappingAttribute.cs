using System;
using System.Collections.Generic;
using System.Reflection;
using Google.ProtocolBuffers.Collections;

namespace Google.ProtocolBuffers.Descriptors;

[AttributeUsage(AttributeTargets.Field)]
internal sealed class FieldMappingAttribute : Attribute
{
	private static readonly IDictionary<FieldType, FieldMappingAttribute> FieldTypeToMappedTypeMap = MapFieldTypes();

	internal MappedType MappedType { get; private set; }

	internal WireFormat.WireType WireType { get; private set; }

	internal FieldMappingAttribute(MappedType mappedType, WireFormat.WireType wireType)
	{
		MappedType = mappedType;
		WireType = wireType;
	}

	private static IDictionary<FieldType, FieldMappingAttribute> MapFieldTypes()
	{
		Dictionary<FieldType, FieldMappingAttribute> dictionary = new Dictionary<FieldType, FieldMappingAttribute>();
		foreach (FieldInfo declaredField in typeof(FieldType).GetTypeInfo().DeclaredFields)
		{
			FieldType key = (FieldType)declaredField.GetValue(null);
			List<Attribute> list = new List<Attribute>(CustomAttributeExtensions.GetCustomAttributes(declaredField, typeof(FieldMappingAttribute), inherit: false));
			FieldMappingAttribute value = (FieldMappingAttribute)list[0];
			dictionary[key] = value;
		}
		return Dictionaries.AsReadOnly(dictionary);
	}

	internal static MappedType MappedTypeFromFieldType(FieldType type)
	{
		return FieldTypeToMappedTypeMap[type].MappedType;
	}

	internal static WireFormat.WireType WireTypeFromFieldType(FieldType type, bool packed)
	{
		if (!packed)
		{
			return FieldTypeToMappedTypeMap[type].WireType;
		}
		return WireFormat.WireType.LengthDelimited;
	}
}
