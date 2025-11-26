using System;
using System.Collections;
using System.Collections.Generic;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public abstract class AbstractBuilder<TMessage, TBuilder> : AbstractBuilderLite<TMessage, TBuilder>, IBuilder<TMessage, TBuilder>, IBuilder, IBuilderLite<TMessage, TBuilder>, IBuilderLite where TMessage : AbstractMessage<TMessage, TBuilder> where TBuilder : AbstractBuilder<TMessage, TBuilder>
{
	public abstract UnknownFieldSet UnknownFields { get; set; }

	public abstract IDictionary<FieldDescriptor, object> AllFields { get; }

	public abstract object this[FieldDescriptor field] { get; set; }

	public abstract MessageDescriptor DescriptorForType { get; }

	public abstract object this[FieldDescriptor field, int index] { get; set; }

	IMessage IBuilder.WeakDefaultInstanceForType => DefaultInstanceForType;

	public abstract int GetRepeatedFieldCount(FieldDescriptor field);

	public abstract bool HasField(FieldDescriptor field);

	public abstract IBuilder CreateBuilderForField(FieldDescriptor field);

	public abstract TBuilder ClearField(FieldDescriptor field);

	public abstract TBuilder AddRepeatedField(FieldDescriptor field, object value);

	public TBuilder SetUnknownFields(UnknownFieldSet fields)
	{
		UnknownFields = fields;
		return ThisBuilder;
	}

	public override TBuilder Clear()
	{
		foreach (FieldDescriptor key in AllFields.Keys)
		{
			ClearField(key);
		}
		return ThisBuilder;
	}

	public sealed override TBuilder MergeFrom(IMessageLite other)
	{
		if (other is IMessage)
		{
			return MergeFrom((IMessage)other);
		}
		throw new ArgumentException("MergeFrom(Message) can only merge messages of the same type.");
	}

	public abstract TBuilder MergeFrom(TMessage other);

	public virtual TBuilder MergeFrom(IMessage other)
	{
		if (other.DescriptorForType != DescriptorForType)
		{
			throw new ArgumentException("MergeFrom(IMessage) can only merge messages of the same type.");
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
			else if (key.MappedType == MappedType.Message)
			{
				IMessageLite messageLite = (IMessageLite)this[key];
				if (messageLite == messageLite.WeakDefaultInstanceForType)
				{
					this[key] = allField.Value;
				}
				else
				{
					this[key] = messageLite.WeakCreateBuilderForType().WeakMergeFrom(messageLite).WeakMergeFrom((IMessageLite)allField.Value)
						.WeakBuild();
				}
			}
			else
			{
				this[key] = allField.Value;
			}
		}
		MergeUnknownFields(other.UnknownFields);
		return ThisBuilder;
	}

	public override TBuilder MergeFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
	{
		UnknownFieldSet.Builder builder = UnknownFieldSet.CreateBuilder(UnknownFields);
		builder.MergeFrom(input, extensionRegistry, this);
		UnknownFields = builder.Build();
		return ThisBuilder;
	}

	public virtual TBuilder MergeUnknownFields(UnknownFieldSet unknownFields)
	{
		UnknownFields = UnknownFieldSet.CreateBuilder(UnknownFields).MergeFrom(unknownFields).Build();
		return ThisBuilder;
	}

	public virtual IBuilder SetField(FieldDescriptor field, object value)
	{
		this[field] = value;
		return ThisBuilder;
	}

	public virtual IBuilder SetRepeatedField(FieldDescriptor field, int index, object value)
	{
		this[field, index] = value;
		return ThisBuilder;
	}

	IMessage IBuilder.WeakBuild()
	{
		return Build();
	}

	IBuilder IBuilder.WeakAddRepeatedField(FieldDescriptor field, object value)
	{
		return AddRepeatedField(field, value);
	}

	IBuilder IBuilder.WeakClear()
	{
		return Clear();
	}

	IBuilder IBuilder.WeakMergeFrom(IMessage message)
	{
		return MergeFrom(message);
	}

	IBuilder IBuilder.WeakMergeFrom(CodedInputStream input)
	{
		return MergeFrom(input);
	}

	IBuilder IBuilder.WeakMergeFrom(CodedInputStream input, ExtensionRegistry registry)
	{
		return MergeFrom(input, registry);
	}

	IBuilder IBuilder.WeakMergeFrom(ByteString data)
	{
		return MergeFrom(data);
	}

	IBuilder IBuilder.WeakMergeFrom(ByteString data, ExtensionRegistry registry)
	{
		return MergeFrom(data, registry);
	}

	IMessage IBuilder.WeakBuildPartial()
	{
		return BuildPartial();
	}

	IBuilder IBuilder.WeakClone()
	{
		return Clone();
	}

	IBuilder IBuilder.WeakClearField(FieldDescriptor field)
	{
		return ClearField(field);
	}
}
