using System.Collections.Generic;
using Google.ProtocolBuffers.DescriptorProtos;

namespace Google.ProtocolBuffers.Descriptors;

public sealed class MessageDescriptor : IndexedDescriptorBase<DescriptorProto, MessageOptions>
{
	private readonly MessageDescriptor containingType;

	private readonly IList<MessageDescriptor> nestedTypes;

	private readonly IList<EnumDescriptor> enumTypes;

	private readonly IList<FieldDescriptor> fields;

	private readonly IList<FieldDescriptor> extensions;

	private bool hasRequiredFields;

	public MessageDescriptor ContainingType => containingType;

	public IList<FieldDescriptor> Fields => fields;

	public IList<FieldDescriptor> Extensions => extensions;

	public IList<MessageDescriptor> NestedTypes => nestedTypes;

	public IList<EnumDescriptor> EnumTypes => enumTypes;

	internal bool HasRequiredFields => hasRequiredFields;

	internal MessageDescriptor(DescriptorProto proto, FileDescriptor file, MessageDescriptor parent, int typeIndex)
		: base(proto, file, DescriptorBase<DescriptorProto, MessageOptions>.ComputeFullName(file, parent, proto.Name), typeIndex)
	{
		MessageDescriptor parent2 = this;
		containingType = parent;
		IList<DescriptorProto> nestedTypeList = proto.NestedTypeList;
		DescriptorUtil.IndexedConverter<DescriptorProto, MessageDescriptor> converter = (DescriptorProto type, int index) => new MessageDescriptor(type, file, parent2, index);
		nestedTypes = DescriptorUtil.ConvertAndMakeReadOnly(nestedTypeList, converter);
		enumTypes = DescriptorUtil.ConvertAndMakeReadOnly(proto.EnumTypeList, (EnumDescriptorProto type, int index) => new EnumDescriptor(type, file, parent2, index));
		fields = DescriptorUtil.ConvertAndMakeReadOnly(proto.FieldList, (FieldDescriptorProto field, int index) => new FieldDescriptor(field, file, parent2, index, isExtension: false));
		extensions = DescriptorUtil.ConvertAndMakeReadOnly(proto.ExtensionList, (FieldDescriptorProto field, int index) => new FieldDescriptor(field, file, parent2, index, isExtension: true));
		file.DescriptorPool.AddSymbol(this);
	}

	public bool IsExtensionNumber(int number)
	{
		foreach (DescriptorProto.Types.ExtensionRange extensionRange in base.Proto.ExtensionRangeList)
		{
			if (extensionRange.Start <= number && number < extensionRange.End)
			{
				return true;
			}
		}
		return false;
	}

	public FieldDescriptor FindFieldByName(string name)
	{
		return base.File.DescriptorPool.FindSymbol<FieldDescriptor>(base.FullName + "." + name);
	}

	public FieldDescriptor FindFieldByNumber(int number)
	{
		return base.File.DescriptorPool.FindFieldByNumber(this, number);
	}

	public FieldDescriptor FindFieldByPropertyName(string propertyName)
	{
		foreach (FieldDescriptor field in Fields)
		{
			if (field.CSharpOptions.PropertyName == propertyName)
			{
				return field;
			}
		}
		return null;
	}

	public T FindDescriptor<T>(string name) where T : class, IDescriptor
	{
		return base.File.DescriptorPool.FindSymbol<T>(base.FullName + "." + name);
	}

	internal void CrossLink()
	{
		foreach (MessageDescriptor nestedType in nestedTypes)
		{
			nestedType.CrossLink();
		}
		foreach (FieldDescriptor field in fields)
		{
			field.CrossLink();
		}
		foreach (FieldDescriptor extension in extensions)
		{
			extension.CrossLink();
		}
	}

	internal void CheckRequiredFields()
	{
		IDictionary<MessageDescriptor, byte> alreadySeen = new Dictionary<MessageDescriptor, byte>();
		hasRequiredFields = CheckRequiredFields(alreadySeen);
	}

	private bool CheckRequiredFields(IDictionary<MessageDescriptor, byte> alreadySeen)
	{
		if (alreadySeen.ContainsKey(this))
		{
			return false;
		}
		alreadySeen[this] = 0;
		if (base.Proto.ExtensionRangeCount != 0)
		{
			return true;
		}
		foreach (FieldDescriptor field in Fields)
		{
			if (field.IsRequired)
			{
				return true;
			}
			if (field.MappedType == MappedType.Message && field.MessageType.CheckRequiredFields(alreadySeen))
			{
				return true;
			}
		}
		return false;
	}

	internal override void ReplaceProto(DescriptorProto newProto)
	{
		base.ReplaceProto(newProto);
		for (int i = 0; i < nestedTypes.Count; i++)
		{
			nestedTypes[i].ReplaceProto(newProto.GetNestedType(i));
		}
		for (int j = 0; j < enumTypes.Count; j++)
		{
			enumTypes[j].ReplaceProto(newProto.GetEnumType(j));
		}
		for (int k = 0; k < fields.Count; k++)
		{
			fields[k].ReplaceProto(newProto.GetField(k));
		}
		for (int l = 0; l < extensions.Count; l++)
		{
			extensions[l].ReplaceProto(newProto.GetExtension(l));
		}
	}
}
