using System;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public class ExtensionDescriptorLite : IFieldDescriptorLite, IComparable<IFieldDescriptorLite>
{
	private readonly string fullName;

	private readonly IEnumLiteMap enumTypeMap;

	private readonly int number;

	private readonly FieldType type;

	private readonly bool isRepeated;

	private readonly bool isPacked;

	private readonly MappedType mapType;

	private readonly object defaultValue;

	public string FullName => fullName;

	public bool IsRepeated => isRepeated;

	public bool IsRequired => false;

	public bool IsPacked => isPacked;

	public bool IsExtension => true;

	public bool MessageSetWireFormat => false;

	public int FieldNumber => number;

	public IEnumLiteMap EnumType => enumTypeMap;

	public FieldType FieldType => type;

	public MappedType MappedType => mapType;

	public object DefaultValue => defaultValue;

	public ExtensionDescriptorLite(string fullName, IEnumLiteMap enumTypeMap, int number, FieldType type, object defaultValue, bool isRepeated, bool isPacked)
	{
		this.fullName = fullName;
		this.enumTypeMap = enumTypeMap;
		this.number = number;
		this.type = type;
		mapType = FieldMappingAttribute.MappedTypeFromFieldType(type);
		this.isRepeated = isRepeated;
		this.isPacked = isPacked;
		this.defaultValue = defaultValue;
	}

	public int CompareTo(IFieldDescriptorLite other)
	{
		return FieldNumber.CompareTo(other.FieldNumber);
	}
}
