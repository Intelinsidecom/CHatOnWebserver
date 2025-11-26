using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public sealed class DynamicMessage : AbstractMessage<DynamicMessage, DynamicMessage.Builder>
{
	public sealed class Builder : AbstractBuilder<DynamicMessage, Builder>
	{
		private readonly MessageDescriptor type;

		private FieldSet fields;

		private UnknownFieldSet unknownFields;

		protected override Builder ThisBuilder => this;

		public override bool IsInitialized => fields.IsInitializedWithRespectTo(type);

		public override MessageDescriptor DescriptorForType => type;

		public override DynamicMessage DefaultInstanceForType => GetDefaultInstance(type);

		public override IDictionary<FieldDescriptor, object> AllFields => fields.AllFields;

		public override object this[FieldDescriptor field, int index]
		{
			get
			{
				VerifyContainingType(field);
				return fields[field, index];
			}
			set
			{
				VerifyContainingType(field);
				fields[field, index] = value;
			}
		}

		public override object this[FieldDescriptor field]
		{
			get
			{
				VerifyContainingType(field);
				object obj = fields[field];
				if (obj == null)
				{
					obj = GetDefaultInstance(field.MessageType);
				}
				return obj;
			}
			set
			{
				VerifyContainingType(field);
				fields[field] = value;
			}
		}

		public override UnknownFieldSet UnknownFields
		{
			get
			{
				return unknownFields;
			}
			set
			{
				unknownFields = value;
			}
		}

		internal Builder(MessageDescriptor type)
		{
			this.type = type;
			fields = FieldSet.CreateInstance();
			unknownFields = UnknownFieldSet.DefaultInstance;
		}

		public override Builder Clear()
		{
			fields.Clear();
			return this;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other.DescriptorForType != type)
			{
				throw new ArgumentException("MergeFrom(IMessage) can only merge messages of the same type.");
			}
			fields.MergeFrom(other);
			MergeUnknownFields(other.UnknownFields);
			return this;
		}

		public override Builder MergeFrom(DynamicMessage other)
		{
			return MergeFrom((IMessage)other);
		}

		public override DynamicMessage Build()
		{
			if (fields != null && !IsInitialized)
			{
				throw new UninitializedMessageException(new DynamicMessage(type, fields, unknownFields));
			}
			return BuildPartial();
		}

		internal DynamicMessage BuildParsed()
		{
			if (!IsInitialized)
			{
				throw new UninitializedMessageException(new DynamicMessage(type, fields, unknownFields)).AsInvalidProtocolBufferException();
			}
			return BuildPartial();
		}

		public override DynamicMessage BuildPartial()
		{
			if (fields == null)
			{
				throw new InvalidOperationException("Build() has already been called on this Builder.");
			}
			fields.MakeImmutable();
			DynamicMessage result = new DynamicMessage(type, fields, unknownFields);
			fields = null;
			unknownFields = null;
			return result;
		}

		public override Builder Clone()
		{
			Builder builder = new Builder(type);
			builder.fields.MergeFrom(fields);
			return builder;
		}

		public override Builder MergeFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
		{
			UnknownFieldSet.Builder builder = UnknownFieldSet.CreateBuilder(unknownFields);
			builder.MergeFrom(input, extensionRegistry, this);
			unknownFields = builder.Build();
			return this;
		}

		public override IBuilder CreateBuilderForField(FieldDescriptor field)
		{
			VerifyContainingType(field);
			if (field.MappedType != MappedType.Message)
			{
				throw new ArgumentException("CreateBuilderForField is only valid for fields with message type.");
			}
			return new Builder(field.MessageType);
		}

		public override bool HasField(FieldDescriptor field)
		{
			VerifyContainingType(field);
			return fields.HasField(field);
		}

		public override Builder ClearField(FieldDescriptor field)
		{
			VerifyContainingType(field);
			fields.ClearField(field);
			return this;
		}

		public override int GetRepeatedFieldCount(FieldDescriptor field)
		{
			VerifyContainingType(field);
			return fields.GetRepeatedFieldCount(field);
		}

		public override Builder AddRepeatedField(FieldDescriptor field, object value)
		{
			VerifyContainingType(field);
			fields.AddRepeatedField(field, value);
			return this;
		}

		private void VerifyContainingType(FieldDescriptor field)
		{
			if (field.ContainingType != type)
			{
				throw new ArgumentException("FieldDescriptor does not match message type.");
			}
		}
	}

	private readonly MessageDescriptor type;

	private readonly FieldSet fields;

	private readonly UnknownFieldSet unknownFields;

	private int memoizedSize = -1;

	public override MessageDescriptor DescriptorForType => type;

	public override DynamicMessage DefaultInstanceForType => GetDefaultInstance(type);

	public override IDictionary<FieldDescriptor, object> AllFields => fields.AllFields;

	public override object this[FieldDescriptor field]
	{
		get
		{
			VerifyContainingType(field);
			object obj = fields[field];
			if (obj == null)
			{
				obj = GetDefaultInstance(field.MessageType);
			}
			return obj;
		}
	}

	public override object this[FieldDescriptor field, int index]
	{
		get
		{
			VerifyContainingType(field);
			return fields[field, index];
		}
	}

	public override UnknownFieldSet UnknownFields => unknownFields;

	public bool Initialized => fields.IsInitializedWithRespectTo(type);

	public override int SerializedSize
	{
		get
		{
			int num = memoizedSize;
			if (num != -1)
			{
				return num;
			}
			num = fields.SerializedSize;
			return memoizedSize = ((!type.Options.MessageSetWireFormat) ? (num + unknownFields.SerializedSize) : (num + unknownFields.SerializedSizeAsMessageSet));
		}
	}

	private DynamicMessage(MessageDescriptor type, FieldSet fields, UnknownFieldSet unknownFields)
	{
		this.type = type;
		this.fields = fields;
		this.unknownFields = unknownFields;
	}

	public static DynamicMessage GetDefaultInstance(MessageDescriptor type)
	{
		return new DynamicMessage(type, FieldSet.DefaultInstance, UnknownFieldSet.DefaultInstance);
	}

	public static DynamicMessage ParseFrom(MessageDescriptor type, CodedInputStream input)
	{
		Builder builder = CreateBuilder(type);
		Builder builder2 = builder.MergeFrom(input);
		return builder2.BuildParsed();
	}

	public static DynamicMessage ParseFrom(MessageDescriptor type, CodedInputStream input, ExtensionRegistry extensionRegistry)
	{
		Builder builder = CreateBuilder(type);
		Builder builder2 = builder.MergeFrom(input, extensionRegistry);
		return builder2.BuildParsed();
	}

	public static DynamicMessage ParseFrom(MessageDescriptor type, Stream input)
	{
		Builder builder = CreateBuilder(type);
		Builder builder2 = builder.MergeFrom(input);
		return builder2.BuildParsed();
	}

	public static DynamicMessage ParseFrom(MessageDescriptor type, Stream input, ExtensionRegistry extensionRegistry)
	{
		Builder builder = CreateBuilder(type);
		Builder builder2 = builder.MergeFrom(input, extensionRegistry);
		return builder2.BuildParsed();
	}

	public static DynamicMessage ParseFrom(MessageDescriptor type, ByteString data)
	{
		Builder builder = CreateBuilder(type);
		Builder builder2 = builder.MergeFrom(data);
		return builder2.BuildParsed();
	}

	public static DynamicMessage ParseFrom(MessageDescriptor type, ByteString data, ExtensionRegistry extensionRegistry)
	{
		Builder builder = CreateBuilder(type);
		Builder builder2 = builder.MergeFrom(data, extensionRegistry);
		return builder2.BuildParsed();
	}

	public static DynamicMessage ParseFrom(MessageDescriptor type, byte[] data)
	{
		Builder builder = CreateBuilder(type);
		Builder builder2 = builder.MergeFrom(data);
		return builder2.BuildParsed();
	}

	public static DynamicMessage ParseFrom(MessageDescriptor type, byte[] data, ExtensionRegistry extensionRegistry)
	{
		Builder builder = CreateBuilder(type);
		Builder builder2 = builder.MergeFrom(data, extensionRegistry);
		return builder2.BuildParsed();
	}

	public static Builder CreateBuilder(MessageDescriptor type)
	{
		return new Builder(type);
	}

	public static Builder CreateBuilder(IMessage prototype)
	{
		return new Builder(prototype.DescriptorForType).MergeFrom(prototype);
	}

	public override bool HasField(FieldDescriptor field)
	{
		VerifyContainingType(field);
		return fields.HasField(field);
	}

	public override int GetRepeatedFieldCount(FieldDescriptor field)
	{
		VerifyContainingType(field);
		return fields.GetRepeatedFieldCount(field);
	}

	public override void WriteTo(CodedOutputStream output)
	{
		fields.WriteTo(output);
		if (type.Options.MessageSetWireFormat)
		{
			unknownFields.WriteAsMessageSetTo(output);
		}
		else
		{
			unknownFields.WriteTo(output);
		}
	}

	public override Builder CreateBuilderForType()
	{
		return new Builder(type);
	}

	public override Builder ToBuilder()
	{
		return CreateBuilderForType().MergeFrom(this);
	}

	private void VerifyContainingType(FieldDescriptor field)
	{
		if (field.ContainingType != type)
		{
			throw new ArgumentException("FieldDescriptor does not match message type.");
		}
	}
}
