using System;
using System.Collections.Generic;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public abstract class ExtendableBuilder<TMessage, TBuilder> : GeneratedBuilder<TMessage, TBuilder> where TMessage : ExtendableMessage<TMessage, TBuilder> where TBuilder : GeneratedBuilder<TMessage, TBuilder>
{
	public override object this[FieldDescriptor field, int index]
	{
		set
		{
			if (field.IsExtension)
			{
				ExtendableMessage<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
				messageBeingBuilt.VerifyContainingType(field);
				messageBeingBuilt.Extensions[field, index] = value;
			}
			else
			{
				base[field, index] = value;
			}
		}
	}

	public override object this[FieldDescriptor field]
	{
		set
		{
			if (field.IsExtension)
			{
				ExtendableMessage<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
				messageBeingBuilt.VerifyContainingType(field);
				messageBeingBuilt.Extensions[field] = value;
			}
			else
			{
				base[field] = value;
			}
		}
	}

	public bool HasExtension<TExtension>(GeneratedExtensionBase<TExtension> extension)
	{
		TMessage messageBeingBuilt = MessageBeingBuilt;
		return messageBeingBuilt.HasExtension(extension);
	}

	public int GetExtensionCount<TExtension>(GeneratedExtensionBase<IList<TExtension>> extension)
	{
		TMessage messageBeingBuilt = MessageBeingBuilt;
		return messageBeingBuilt.GetExtensionCount(extension);
	}

	public TExtension GetExtension<TExtension>(GeneratedExtensionBase<TExtension> extension)
	{
		TMessage messageBeingBuilt = MessageBeingBuilt;
		return messageBeingBuilt.GetExtension(extension);
	}

	public TExtension GetExtension<TExtension>(GeneratedExtensionBase<IList<TExtension>> extension, int index)
	{
		TMessage messageBeingBuilt = MessageBeingBuilt;
		return messageBeingBuilt.GetExtension(extension, index);
	}

	public TBuilder SetExtension<TExtension>(GeneratedExtensionBase<TExtension> extension, TExtension value)
	{
		ExtendableMessage<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
		messageBeingBuilt.VerifyExtensionContainingType(extension);
		messageBeingBuilt.Extensions[extension.Descriptor] = extension.ToReflectionType(value);
		return ThisBuilder;
	}

	public TBuilder SetExtension<TExtension>(GeneratedExtensionBase<IList<TExtension>> extension, int index, TExtension value)
	{
		ExtendableMessage<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
		messageBeingBuilt.VerifyExtensionContainingType(extension);
		messageBeingBuilt.Extensions[extension.Descriptor, index] = extension.SingularToReflectionType(value);
		return ThisBuilder;
	}

	public TBuilder AddExtension<TExtension>(GeneratedExtensionBase<IList<TExtension>> extension, TExtension value)
	{
		ExtendableMessage<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
		messageBeingBuilt.VerifyExtensionContainingType(extension);
		messageBeingBuilt.Extensions.AddRepeatedField(extension.Descriptor, extension.SingularToReflectionType(value));
		return ThisBuilder;
	}

	public TBuilder ClearExtension<TExtension>(GeneratedExtensionBase<TExtension> extension)
	{
		ExtendableMessage<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
		messageBeingBuilt.VerifyExtensionContainingType(extension);
		messageBeingBuilt.Extensions.ClearField(extension.Descriptor);
		return ThisBuilder;
	}

	[CLSCompliant(false)]
	protected override bool ParseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistry extensionRegistry, uint tag)
	{
		return unknownFields.MergeFieldFrom(input, extensionRegistry, this, tag);
	}

	public override TBuilder ClearField(FieldDescriptor field)
	{
		if (field.IsExtension)
		{
			ExtendableMessage<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
			messageBeingBuilt.VerifyContainingType(field);
			messageBeingBuilt.Extensions.ClearField(field);
			return ThisBuilder;
		}
		return base.ClearField(field);
	}

	public override TBuilder AddRepeatedField(FieldDescriptor field, object value)
	{
		if (field.IsExtension)
		{
			ExtendableMessage<TMessage, TBuilder> messageBeingBuilt = MessageBeingBuilt;
			messageBeingBuilt.VerifyContainingType(field);
			messageBeingBuilt.Extensions.AddRepeatedField(field, value);
			return ThisBuilder;
		}
		return base.AddRepeatedField(field, value);
	}

	protected void MergeExtensionFields(ExtendableMessage<TMessage, TBuilder> other)
	{
		TMessage messageBeingBuilt = MessageBeingBuilt;
		messageBeingBuilt.Extensions.MergeFrom(other.Extensions);
	}
}
