using System.Collections.Generic;
using Google.ProtocolBuffers.DescriptorProtos;

namespace Google.ProtocolBuffers.Descriptors;

public sealed class EnumDescriptor : IndexedDescriptorBase<EnumDescriptorProto, EnumOptions>, IEnumLiteMap<EnumValueDescriptor>, IEnumLiteMap
{
	private readonly MessageDescriptor containingType;

	private readonly IList<EnumValueDescriptor> values;

	public MessageDescriptor ContainingType => containingType;

	public IList<EnumValueDescriptor> Values => values;

	internal EnumDescriptor(EnumDescriptorProto proto, FileDescriptor file, MessageDescriptor parent, int index)
		: base(proto, file, DescriptorBase<EnumDescriptorProto, EnumOptions>.ComputeFullName(file, parent, proto.Name), index)
	{
		EnumDescriptor parent2 = this;
		containingType = parent;
		if (proto.ValueCount == 0)
		{
			throw new DescriptorValidationException(this, "Enums must contain at least one value.");
		}
		values = DescriptorUtil.ConvertAndMakeReadOnly(proto.ValueList, (EnumValueDescriptorProto value, int i) => new EnumValueDescriptor(value, file, parent2, i));
		base.File.DescriptorPool.AddSymbol(this);
	}

	public bool IsValidValue(IEnumLite value)
	{
		if (value is EnumValueDescriptor)
		{
			return ((EnumValueDescriptor)value).EnumDescriptor == this;
		}
		return false;
	}

	public EnumValueDescriptor FindValueByNumber(int number)
	{
		return base.File.DescriptorPool.FindEnumValueByNumber(this, number);
	}

	IEnumLite IEnumLiteMap.FindValueByNumber(int number)
	{
		return FindValueByNumber(number);
	}

	internal EnumValueDescriptor FindValueByName(string name)
	{
		return base.File.DescriptorPool.FindSymbol<EnumValueDescriptor>(base.FullName + "." + name);
	}

	internal override void ReplaceProto(EnumDescriptorProto newProto)
	{
		base.ReplaceProto(newProto);
		for (int i = 0; i < values.Count; i++)
		{
			values[i].ReplaceProto(newProto.GetValue(i));
		}
	}
}
