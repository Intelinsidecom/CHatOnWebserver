using System.Collections.Generic;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public class GeneratedExtensionLite<TContainingType, TExtensionType> : IGeneratedExtensionLite where TContainingType : IMessageLite
{
	private readonly TContainingType containingTypeDefaultInstance;

	private readonly TExtensionType defaultValue;

	private readonly IMessageLite messageDefaultInstance;

	private readonly ExtensionDescriptorLite descriptor;

	private static readonly IList<object> Empty = new object[0];

	public IFieldDescriptorLite Descriptor => descriptor;

	public TExtensionType DefaultValue => defaultValue;

	object IGeneratedExtensionLite.ContainingType => ContainingTypeDefaultInstance;

	public TContainingType ContainingTypeDefaultInstance => containingTypeDefaultInstance;

	public int Number => descriptor.FieldNumber;

	public IMessageLite MessageDefaultInstance => messageDefaultInstance;

	protected GeneratedExtensionLite(TContainingType containingTypeDefaultInstance, TExtensionType defaultValue, IMessageLite messageDefaultInstance, ExtensionDescriptorLite descriptor)
	{
		this.containingTypeDefaultInstance = containingTypeDefaultInstance;
		this.messageDefaultInstance = messageDefaultInstance;
		this.defaultValue = defaultValue;
		this.descriptor = descriptor;
	}

	public GeneratedExtensionLite(string fullName, TContainingType containingTypeDefaultInstance, TExtensionType defaultValue, IMessageLite messageDefaultInstance, IEnumLiteMap enumTypeMap, int number, FieldType type)
		: this(containingTypeDefaultInstance, defaultValue, messageDefaultInstance, new ExtensionDescriptorLite(fullName, enumTypeMap, number, type, defaultValue, isRepeated: false, isPacked: false))
	{
	}

	protected GeneratedExtensionLite(string fullName, TContainingType containingTypeDefaultInstance, TExtensionType defaultValue, IMessageLite messageDefaultInstance, IEnumLiteMap enumTypeMap, int number, FieldType type, bool isPacked)
		: this(containingTypeDefaultInstance, defaultValue, messageDefaultInstance, new ExtensionDescriptorLite(fullName, enumTypeMap, number, type, Empty, isRepeated: true, isPacked))
	{
	}

	public virtual object ToReflectionType(object value)
	{
		return SingularToReflectionType(value);
	}

	public object SingularToReflectionType(object value)
	{
		if (descriptor.MappedType != MappedType.Enum)
		{
			return value;
		}
		return descriptor.EnumType.FindValueByNumber((int)value);
	}

	public virtual object FromReflectionType(object value)
	{
		return SingularFromReflectionType(value);
	}

	public object SingularFromReflectionType(object value)
	{
		switch (Descriptor.MappedType)
		{
		case MappedType.Message:
			if (value is TExtensionType)
			{
				return value;
			}
			return MessageDefaultInstance.WeakCreateBuilderForType().WeakMergeFrom((IMessageLite)value).WeakBuild();
		case MappedType.Enum:
		{
			IEnumLite enumLite = (IEnumLite)value;
			return enumLite.Number;
		}
		default:
			return value;
		}
	}
}
