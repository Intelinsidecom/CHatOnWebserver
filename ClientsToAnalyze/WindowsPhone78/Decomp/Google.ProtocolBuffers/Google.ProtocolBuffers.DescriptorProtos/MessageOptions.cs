using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class MessageOptions : ExtendableMessage<MessageOptions, MessageOptions.Builder>
{
	public sealed class Builder : ExtendableBuilder<MessageOptions, Builder>
	{
		private MessageOptions result = new MessageOptions();

		protected override Builder ThisBuilder => this;

		protected override MessageOptions MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override MessageOptions DefaultInstanceForType => DefaultInstance;

		public bool HasMessageSetWireFormat => result.HasMessageSetWireFormat;

		public bool MessageSetWireFormat
		{
			get
			{
				return result.MessageSetWireFormat;
			}
			set
			{
				SetMessageSetWireFormat(value);
			}
		}

		public IPopsicleList<UninterpretedOption> UninterpretedOptionList => result.uninterpretedOption_;

		public int UninterpretedOptionCount => result.UninterpretedOptionCount;

		public override Builder Clear()
		{
			result = new MessageOptions();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override MessageOptions BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.uninterpretedOption_.MakeReadOnly();
			MessageOptions messageOptions = result;
			result = null;
			return messageOptions;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is MessageOptions)
			{
				return MergeFrom((MessageOptions)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(MessageOptions other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasMessageSetWireFormat)
			{
				MessageSetWireFormat = other.MessageSetWireFormat;
			}
			if (other.uninterpretedOption_.Count != 0)
			{
				AddRange(other.uninterpretedOption_, result.uninterpretedOption_);
			}
			MergeExtensionFields(other);
			MergeUnknownFields(other.UnknownFields);
			return this;
		}

		public override Builder MergeFrom(CodedInputStream input)
		{
			return MergeFrom(input, ExtensionRegistry.Empty);
		}

		public override Builder MergeFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
		{
			UnknownFieldSet.Builder builder = null;
			while (true)
			{
				uint num = input.ReadTag();
				switch (num)
				{
				case 0u:
					if (builder != null)
					{
						UnknownFields = builder.Build();
					}
					return this;
				case 8u:
					MessageSetWireFormat = input.ReadBool();
					continue;
				case 7994u:
				{
					UninterpretedOption.Builder builder2 = UninterpretedOption.CreateBuilder();
					input.ReadMessage(builder2, extensionRegistry);
					AddUninterpretedOption(builder2.BuildPartial());
					continue;
				}
				}
				if (WireFormat.IsEndGroupTag(num))
				{
					if (builder != null)
					{
						UnknownFields = builder.Build();
					}
					return this;
				}
				if (builder == null)
				{
					builder = UnknownFieldSet.CreateBuilder(UnknownFields);
				}
				ParseUnknownField(input, builder, extensionRegistry, num);
			}
		}

		public Builder SetMessageSetWireFormat(bool value)
		{
			result.hasMessageSetWireFormat = true;
			result.messageSetWireFormat_ = value;
			return this;
		}

		public Builder ClearMessageSetWireFormat()
		{
			result.hasMessageSetWireFormat = false;
			result.messageSetWireFormat_ = false;
			return this;
		}

		public UninterpretedOption GetUninterpretedOption(int index)
		{
			return result.GetUninterpretedOption(index);
		}

		public Builder SetUninterpretedOption(int index, UninterpretedOption value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.uninterpretedOption_[index] = value;
			return this;
		}

		public Builder SetUninterpretedOption(int index, UninterpretedOption.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.uninterpretedOption_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddUninterpretedOption(UninterpretedOption value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.uninterpretedOption_.Add(value);
			return this;
		}

		public Builder AddUninterpretedOption(UninterpretedOption.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.uninterpretedOption_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeUninterpretedOption(IEnumerable<UninterpretedOption> values)
		{
			AddRange(values, result.uninterpretedOption_);
			return this;
		}

		public Builder ClearUninterpretedOption()
		{
			result.uninterpretedOption_.Clear();
			return this;
		}
	}

	public const int MessageSetWireFormatFieldNumber = 1;

	public const int UninterpretedOptionFieldNumber = 999;

	private static readonly MessageOptions defaultInstance;

	private bool hasMessageSetWireFormat;

	private bool messageSetWireFormat_;

	private PopsicleList<UninterpretedOption> uninterpretedOption_ = new PopsicleList<UninterpretedOption>();

	private int memoizedSerializedSize = -1;

	public static MessageOptions DefaultInstance => defaultInstance;

	public override MessageOptions DefaultInstanceForType => defaultInstance;

	protected override MessageOptions ThisMessage => this;

	public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_MessageOptions__Descriptor;

	protected override FieldAccessorTable<MessageOptions, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_MessageOptions__FieldAccessorTable;

	public bool HasMessageSetWireFormat => hasMessageSetWireFormat;

	public bool MessageSetWireFormat => messageSetWireFormat_;

	public IList<UninterpretedOption> UninterpretedOptionList => uninterpretedOption_;

	public int UninterpretedOptionCount => uninterpretedOption_.Count;

	public override bool IsInitialized
	{
		get
		{
			foreach (UninterpretedOption uninterpretedOption in UninterpretedOptionList)
			{
				if (!uninterpretedOption.IsInitialized)
				{
					return false;
				}
			}
			if (!base.ExtensionsAreInitialized)
			{
				return false;
			}
			return true;
		}
	}

	public override int SerializedSize
	{
		get
		{
			int num = memoizedSerializedSize;
			if (num != -1)
			{
				return num;
			}
			num = 0;
			if (HasMessageSetWireFormat)
			{
				num += CodedOutputStream.ComputeBoolSize(1, MessageSetWireFormat);
			}
			foreach (UninterpretedOption uninterpretedOption in UninterpretedOptionList)
			{
				num += CodedOutputStream.ComputeMessageSize(999, uninterpretedOption);
			}
			num += base.ExtensionsSerializedSize;
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public UninterpretedOption GetUninterpretedOption(int index)
	{
		return uninterpretedOption_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		ExtensionWriter extensionWriter = CreateExtensionWriter(this);
		if (HasMessageSetWireFormat)
		{
			output.WriteBool(1, MessageSetWireFormat);
		}
		foreach (UninterpretedOption uninterpretedOption in UninterpretedOptionList)
		{
			output.WriteMessage(999, uninterpretedOption);
		}
		extensionWriter.WriteUntil(536870912, output);
		UnknownFields.WriteTo(output);
	}

	public static MessageOptions ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static MessageOptions ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static MessageOptions ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static MessageOptions ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static MessageOptions ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static MessageOptions ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static MessageOptions ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static MessageOptions ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static MessageOptions ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static MessageOptions ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static Builder CreateBuilder()
	{
		return new Builder();
	}

	public override Builder ToBuilder()
	{
		return CreateBuilder(this);
	}

	public override Builder CreateBuilderForType()
	{
		return new Builder();
	}

	public static Builder CreateBuilder(MessageOptions prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static MessageOptions()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
	}
}
