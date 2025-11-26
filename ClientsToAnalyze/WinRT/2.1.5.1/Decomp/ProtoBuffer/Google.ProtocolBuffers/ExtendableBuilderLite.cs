using System;
using System.Collections.Generic;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public abstract class ExtendableBuilderLite<TMessage, TBuilder> : GeneratedBuilderLite<TMessage, TBuilder> where TMessage : ExtendableMessageLite<TMessage, TBuilder> where TBuilder : GeneratedBuilderLite<TMessage, TBuilder>
{
	public object this[IFieldDescriptorLite field, int index]
	{
		set
		{
			if (field.IsExtension)
			{
				ExtendableMessageLite<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
				messageBeingBuilt.Extensions[field, index] = value;
				return;
			}
			throw new NotSupportedException("Not supported in the lite runtime.");
		}
	}

	public object this[IFieldDescriptorLite field]
	{
		set
		{
			if (field.IsExtension)
			{
				ExtendableMessageLite<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
				messageBeingBuilt.Extensions[field] = value;
				return;
			}
			throw new NotSupportedException("Not supported in the lite runtime.");
		}
	}

	public bool HasExtension<TExtension>(GeneratedExtensionLite<TMessage, TExtension> extension)
	{
		TMessage messageBeingBuilt = MessageBeingBuilt;
		return messageBeingBuilt.HasExtension(extension);
	}

	public int GetExtensionCount<TExtension>(GeneratedExtensionLite<TMessage, IList<TExtension>> extension)
	{
		TMessage messageBeingBuilt = MessageBeingBuilt;
		return messageBeingBuilt.GetExtensionCount(extension);
	}

	public TExtension GetExtension<TExtension>(GeneratedExtensionLite<TMessage, TExtension> extension)
	{
		TMessage messageBeingBuilt = MessageBeingBuilt;
		return messageBeingBuilt.GetExtension(extension);
	}

	public TExtension GetExtension<TExtension>(GeneratedExtensionLite<TMessage, IList<TExtension>> extension, int index)
	{
		TMessage messageBeingBuilt = MessageBeingBuilt;
		return messageBeingBuilt.GetExtension(extension, index);
	}

	public TBuilder SetExtension<TExtension>(GeneratedExtensionLite<TMessage, TExtension> extension, TExtension value)
	{
		ExtendableMessageLite<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
		messageBeingBuilt.VerifyExtensionContainingType(extension);
		messageBeingBuilt.Extensions[extension.Descriptor] = extension.ToReflectionType(value);
		return ThisBuilder;
	}

	public TBuilder SetExtension<TExtension>(GeneratedExtensionLite<TMessage, IList<TExtension>> extension, int index, TExtension value)
	{
		ExtendableMessageLite<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
		messageBeingBuilt.VerifyExtensionContainingType(extension);
		messageBeingBuilt.Extensions[extension.Descriptor, index] = extension.SingularToReflectionType(value);
		return ThisBuilder;
	}

	public TBuilder AddExtension<TExtension>(GeneratedExtensionLite<TMessage, IList<TExtension>> extension, TExtension value)
	{
		ExtendableMessageLite<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
		messageBeingBuilt.VerifyExtensionContainingType(extension);
		messageBeingBuilt.Extensions.AddRepeatedField(extension.Descriptor, extension.SingularToReflectionType(value));
		return ThisBuilder;
	}

	public TBuilder ClearExtension<TExtension>(GeneratedExtensionLite<TMessage, TExtension> extension)
	{
		ExtendableMessageLite<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
		messageBeingBuilt.VerifyExtensionContainingType(extension);
		messageBeingBuilt.Extensions.ClearField(extension.Descriptor);
		return ThisBuilder;
	}

	[CLSCompliant(false)]
	protected override bool ParseUnknownField(CodedInputStream input, ExtensionRegistry extensionRegistry, uint tag)
	{
		TMessage messageBeingBuilt = MessageBeingBuilt;
		FieldSet extensions = messageBeingBuilt.Extensions;
		WireFormat.WireType tagWireType = WireFormat.GetTagWireType(tag);
		int tagFieldNumber = WireFormat.GetTagFieldNumber(tag);
		IGeneratedExtensionLite generatedExtensionLite = extensionRegistry[DefaultInstanceForType, tagFieldNumber];
		bool flag = false;
		bool flag2 = false;
		if (generatedExtensionLite == null)
		{
			flag = true;
		}
		else if (tagWireType == FieldMappingAttribute.WireTypeFromFieldType(generatedExtensionLite.Descriptor.FieldType, packed: false))
		{
			flag2 = false;
		}
		else if (generatedExtensionLite.Descriptor.IsRepeated && tagWireType == FieldMappingAttribute.WireTypeFromFieldType(generatedExtensionLite.Descriptor.FieldType, packed: true))
		{
			flag2 = true;
		}
		else
		{
			flag = true;
		}
		if (flag)
		{
			return input.SkipField(tag);
		}
		if (flag2)
		{
			int byteLimit = (int)Math.Min(2147483647u, input.ReadRawVarint32());
			int oldLimit = input.PushLimit(byteLimit);
			if (generatedExtensionLite.Descriptor.FieldType == FieldType.Enum)
			{
				while (!input.ReachedLimit)
				{
					int number = input.ReadEnum();
					object obj = generatedExtensionLite.Descriptor.EnumType.FindValueByNumber(number);
					if (obj == null)
					{
						return true;
					}
					extensions.AddRepeatedField(generatedExtensionLite.Descriptor, obj);
				}
			}
			else
			{
				while (!input.ReachedLimit)
				{
					object value = input.ReadPrimitiveField(generatedExtensionLite.Descriptor.FieldType);
					extensions.AddRepeatedField(generatedExtensionLite.Descriptor, value);
				}
			}
			input.PopLimit(oldLimit);
		}
		else
		{
			object obj2;
			switch (generatedExtensionLite.Descriptor.MappedType)
			{
			case MappedType.Message:
			{
				IBuilderLite builderLite = null;
				if (!generatedExtensionLite.Descriptor.IsRepeated && extensions[generatedExtensionLite.Descriptor] is IMessageLite messageLite)
				{
					builderLite = messageLite.WeakToBuilder();
				}
				if (builderLite == null)
				{
					builderLite = generatedExtensionLite.MessageDefaultInstance.WeakCreateBuilderForType();
				}
				if (generatedExtensionLite.Descriptor.FieldType == FieldType.Group)
				{
					input.ReadGroup(generatedExtensionLite.Number, builderLite, extensionRegistry);
				}
				else
				{
					input.ReadMessage(builderLite, extensionRegistry);
				}
				obj2 = builderLite.WeakBuild();
				break;
			}
			case MappedType.Enum:
			{
				int number2 = input.ReadEnum();
				obj2 = generatedExtensionLite.Descriptor.EnumType.FindValueByNumber(number2);
				if (obj2 == null)
				{
					return true;
				}
				break;
			}
			default:
				obj2 = input.ReadPrimitiveField(generatedExtensionLite.Descriptor.FieldType);
				break;
			}
			if (generatedExtensionLite.Descriptor.IsRepeated)
			{
				extensions.AddRepeatedField(generatedExtensionLite.Descriptor, obj2);
			}
			else
			{
				extensions[generatedExtensionLite.Descriptor] = obj2;
			}
		}
		return true;
	}

	public TBuilder ClearField(IFieldDescriptorLite field)
	{
		if (field.IsExtension)
		{
			ExtendableMessageLite<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
			messageBeingBuilt.Extensions.ClearField(field);
			return ThisBuilder;
		}
		throw new NotSupportedException("Not supported in the lite runtime.");
	}

	public TBuilder AddRepeatedField(IFieldDescriptorLite field, object value)
	{
		if (field.IsExtension)
		{
			ExtendableMessageLite<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
			messageBeingBuilt.Extensions.AddRepeatedField(field, value);
			return ThisBuilder;
		}
		throw new NotSupportedException("Not supported in the lite runtime.");
	}

	protected void MergeExtensionFields(ExtendableMessageLite<TMessage, TBuilder> other)
	{
		TMessage messageBeingBuilt = MessageBeingBuilt;
		messageBeingBuilt.Extensions.MergeFrom(other.Extensions);
	}
}
