using System;
using System.Collections;
using System.Collections.Generic;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers;

public abstract class GeneratedBuilder<TMessage, TBuilder> : AbstractBuilder<TMessage, TBuilder> where TMessage : GeneratedMessage<TMessage, TBuilder> where TBuilder : GeneratedBuilder<TMessage, TBuilder>
{
	protected abstract TMessage MessageBeingBuilt { get; }

	protected internal FieldAccessorTable<TMessage, TBuilder> InternalFieldAccessors
	{
		get
		{
			TMessage messageBeingBuilt = MessageBeingBuilt;
			return messageBeingBuilt.FieldAccessorsFromBuilder;
		}
	}

	public override bool IsInitialized
	{
		get
		{
			TMessage messageBeingBuilt = MessageBeingBuilt;
			return messageBeingBuilt.IsInitialized;
		}
	}

	public override IDictionary<FieldDescriptor, object> AllFields
	{
		get
		{
			TMessage messageBeingBuilt = MessageBeingBuilt;
			return messageBeingBuilt.AllFields;
		}
	}

	public override object this[FieldDescriptor field]
	{
		get
		{
			if (!field.IsRepeated)
			{
				TMessage messageBeingBuilt = MessageBeingBuilt;
				return messageBeingBuilt[field];
			}
			return InternalFieldAccessors[field].GetRepeatedWrapper(ThisBuilder);
		}
		set
		{
			InternalFieldAccessors[field].SetValue(ThisBuilder, value);
		}
	}

	public override MessageDescriptor DescriptorForType
	{
		get
		{
			TMessage messageBeingBuilt = MessageBeingBuilt;
			return messageBeingBuilt.DescriptorForType;
		}
	}

	public override object this[FieldDescriptor field, int index]
	{
		get
		{
			TMessage messageBeingBuilt = MessageBeingBuilt;
			return messageBeingBuilt[field, index];
		}
		set
		{
			InternalFieldAccessors[field].SetRepeated(ThisBuilder, index, value);
		}
	}

	public override UnknownFieldSet UnknownFields
	{
		get
		{
			TMessage messageBeingBuilt = MessageBeingBuilt;
			return messageBeingBuilt.UnknownFields;
		}
		set
		{
			TMessage messageBeingBuilt = MessageBeingBuilt;
			messageBeingBuilt.SetUnknownFields(value);
		}
	}

	protected void AddRange<T>(IEnumerable<T> source, IList<T> destination)
	{
		ThrowHelper.ThrowIfNull(source);
		if (default(T) == null)
		{
			ThrowHelper.ThrowIfAnyNull(source);
		}
		if (destination is List<T> list)
		{
			list.AddRange(source);
			return;
		}
		foreach (T item in source)
		{
			destination.Add(item);
		}
	}

	[CLSCompliant(false)]
	protected virtual bool ParseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistry extensionRegistry, uint tag)
	{
		return unknownFields.MergeFieldFrom(tag, input);
	}

	public override int GetRepeatedFieldCount(FieldDescriptor field)
	{
		TMessage messageBeingBuilt = MessageBeingBuilt;
		return messageBeingBuilt.GetRepeatedFieldCount(field);
	}

	public override bool HasField(FieldDescriptor field)
	{
		TMessage messageBeingBuilt = MessageBeingBuilt;
		return messageBeingBuilt.HasField(field);
	}

	public override IBuilder CreateBuilderForField(FieldDescriptor field)
	{
		return InternalFieldAccessors[field].CreateBuilder();
	}

	public override TBuilder ClearField(FieldDescriptor field)
	{
		InternalFieldAccessors[field].Clear(ThisBuilder);
		return ThisBuilder;
	}

	public override TBuilder MergeFrom(TMessage other)
	{
		if (other.DescriptorForType != InternalFieldAccessors.Descriptor)
		{
			throw new ArgumentException("Message type mismatch");
		}
		foreach (KeyValuePair<FieldDescriptor, object> allField in other.AllFields)
		{
			FieldDescriptor key = allField.Key;
			if (key.IsRepeated)
			{
				foreach (object item in (IEnumerable)allField.Value)
				{
					AddRepeatedField(key, item);
				}
			}
			else if (key.MappedType == MappedType.Message && HasField(key))
			{
				IMessageLite messageLite = (IMessageLite)this[key];
				this[key] = messageLite.WeakCreateBuilderForType().WeakMergeFrom(messageLite).WeakMergeFrom((IMessageLite)allField.Value)
					.WeakBuildPartial();
			}
			else
			{
				this[key] = allField.Value;
			}
		}
		MergeUnknownFields(other.UnknownFields);
		return ThisBuilder;
	}

	public override TBuilder MergeUnknownFields(UnknownFieldSet unknownFields)
	{
		if (unknownFields != UnknownFieldSet.DefaultInstance)
		{
			TMessage messageBeingBuilt = MessageBeingBuilt;
			UnknownFieldSet unknownFields2 = UnknownFieldSet.CreateBuilder(messageBeingBuilt.UnknownFields).MergeFrom(unknownFields).Build();
			messageBeingBuilt.SetUnknownFields(unknownFields2);
		}
		return ThisBuilder;
	}

	public override TBuilder AddRepeatedField(FieldDescriptor field, object value)
	{
		InternalFieldAccessors[field].AddRepeated(ThisBuilder, value);
		return ThisBuilder;
	}

	public TMessage BuildParsed()
	{
		if (!IsInitialized)
		{
			throw new UninitializedMessageException(MessageBeingBuilt).AsInvalidProtocolBufferException();
		}
		return BuildPartial();
	}

	public override TMessage Build()
	{
		if (MessageBeingBuilt != null && !IsInitialized)
		{
			throw new UninitializedMessageException(MessageBeingBuilt);
		}
		return BuildPartial();
	}
}
