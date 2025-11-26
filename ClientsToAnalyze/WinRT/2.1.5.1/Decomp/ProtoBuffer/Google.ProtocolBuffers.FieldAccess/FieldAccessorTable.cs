using System;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers.FieldAccess;

public sealed class FieldAccessorTable<TMessage, TBuilder> where TMessage : IMessage<TMessage, TBuilder> where TBuilder : IBuilder<TMessage, TBuilder>
{
	private readonly IFieldAccessor<TMessage, TBuilder>[] accessors;

	private readonly MessageDescriptor descriptor;

	public MessageDescriptor Descriptor => descriptor;

	internal IFieldAccessor<TMessage, TBuilder> this[FieldDescriptor field]
	{
		get
		{
			if (field.ContainingType != descriptor)
			{
				throw new ArgumentException("FieldDescriptor does not match message type.");
			}
			if (field.IsExtension)
			{
				throw new ArgumentException("This type does not have extensions.");
			}
			return accessors[field.Index];
		}
	}

	public FieldAccessorTable(MessageDescriptor descriptor, string[] propertyNames)
	{
		this.descriptor = descriptor;
		accessors = new IFieldAccessor<TMessage, TBuilder>[descriptor.Fields.Count];
		for (int i = 0; i < accessors.Length; i++)
		{
			accessors[i] = CreateAccessor(descriptor.Fields[i], propertyNames[i]);
		}
	}

	private static IFieldAccessor<TMessage, TBuilder> CreateAccessor(FieldDescriptor field, string name)
	{
		if (field.IsRepeated)
		{
			return field.MappedType switch
			{
				MappedType.Message => new RepeatedMessageAccessor<TMessage, TBuilder>(name), 
				MappedType.Enum => new RepeatedEnumAccessor<TMessage, TBuilder>(field, name), 
				_ => new RepeatedPrimitiveAccessor<TMessage, TBuilder>(name), 
			};
		}
		return field.MappedType switch
		{
			MappedType.Message => new SingleMessageAccessor<TMessage, TBuilder>(name), 
			MappedType.Enum => new SingleEnumAccessor<TMessage, TBuilder>(field, name), 
			_ => new SinglePrimitiveAccessor<TMessage, TBuilder>(name), 
		};
	}
}
