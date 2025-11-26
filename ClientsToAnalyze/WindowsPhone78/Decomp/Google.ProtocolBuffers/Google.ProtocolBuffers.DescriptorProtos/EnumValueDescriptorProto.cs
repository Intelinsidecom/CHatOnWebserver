using System;
using System.IO;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class EnumValueDescriptorProto : GeneratedMessage<EnumValueDescriptorProto, EnumValueDescriptorProto.Builder>, IDescriptorProto<EnumValueOptions>
{
	public sealed class Builder : GeneratedBuilder<EnumValueDescriptorProto, Builder>
	{
		private EnumValueDescriptorProto result = new EnumValueDescriptorProto();

		protected override Builder ThisBuilder => this;

		protected override EnumValueDescriptorProto MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override EnumValueDescriptorProto DefaultInstanceForType => DefaultInstance;

		public bool HasName => result.HasName;

		public string Name
		{
			get
			{
				return result.Name;
			}
			set
			{
				SetName(value);
			}
		}

		public bool HasNumber => result.HasNumber;

		public int Number
		{
			get
			{
				return result.Number;
			}
			set
			{
				SetNumber(value);
			}
		}

		public bool HasOptions => result.HasOptions;

		public EnumValueOptions Options
		{
			get
			{
				return result.Options;
			}
			set
			{
				SetOptions(value);
			}
		}

		public override Builder Clear()
		{
			result = new EnumValueDescriptorProto();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override EnumValueDescriptorProto BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			EnumValueDescriptorProto enumValueDescriptorProto = result;
			result = null;
			return enumValueDescriptorProto;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is EnumValueDescriptorProto)
			{
				return MergeFrom((EnumValueDescriptorProto)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(EnumValueDescriptorProto other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasName)
			{
				Name = other.Name;
			}
			if (other.HasNumber)
			{
				Number = other.Number;
			}
			if (other.HasOptions)
			{
				MergeOptions(other.Options);
			}
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
				case 10u:
					Name = input.ReadString();
					continue;
				case 16u:
					Number = input.ReadInt32();
					continue;
				case 26u:
				{
					EnumValueOptions.Builder builder2 = EnumValueOptions.CreateBuilder();
					if (HasOptions)
					{
						builder2.MergeFrom(Options);
					}
					input.ReadMessage(builder2, extensionRegistry);
					Options = builder2.BuildPartial();
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

		public Builder SetName(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasName = true;
			result.name_ = value;
			return this;
		}

		public Builder ClearName()
		{
			result.hasName = false;
			result.name_ = "";
			return this;
		}

		public Builder SetNumber(int value)
		{
			result.hasNumber = true;
			result.number_ = value;
			return this;
		}

		public Builder ClearNumber()
		{
			result.hasNumber = false;
			result.number_ = 0;
			return this;
		}

		public Builder SetOptions(EnumValueOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasOptions = true;
			result.options_ = value;
			return this;
		}

		public Builder SetOptions(EnumValueOptions.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.hasOptions = true;
			result.options_ = builderForValue.Build();
			return this;
		}

		public Builder MergeOptions(EnumValueOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			if (result.HasOptions && result.options_ != EnumValueOptions.DefaultInstance)
			{
				result.options_ = EnumValueOptions.CreateBuilder(result.options_).MergeFrom(value).BuildPartial();
			}
			else
			{
				result.options_ = value;
			}
			result.hasOptions = true;
			return this;
		}

		public Builder ClearOptions()
		{
			result.hasOptions = false;
			result.options_ = EnumValueOptions.DefaultInstance;
			return this;
		}
	}

	public const int NameFieldNumber = 1;

	public const int NumberFieldNumber = 2;

	public const int OptionsFieldNumber = 3;

	private static readonly EnumValueDescriptorProto defaultInstance;

	private bool hasName;

	private string name_ = "";

	private bool hasNumber;

	private int number_;

	private bool hasOptions;

	private EnumValueOptions options_ = EnumValueOptions.DefaultInstance;

	private int memoizedSerializedSize = -1;

	public static EnumValueDescriptorProto DefaultInstance => defaultInstance;

	public override EnumValueDescriptorProto DefaultInstanceForType => defaultInstance;

	protected override EnumValueDescriptorProto ThisMessage => this;

	public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_EnumValueDescriptorProto__Descriptor;

	protected override FieldAccessorTable<EnumValueDescriptorProto, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_EnumValueDescriptorProto__FieldAccessorTable;

	public bool HasName => hasName;

	public string Name => name_;

	public bool HasNumber => hasNumber;

	public int Number => number_;

	public bool HasOptions => hasOptions;

	public EnumValueOptions Options => options_;

	public override bool IsInitialized
	{
		get
		{
			if (HasOptions && !Options.IsInitialized)
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
			if (HasName)
			{
				num += CodedOutputStream.ComputeStringSize(1, Name);
			}
			if (HasNumber)
			{
				num += CodedOutputStream.ComputeInt32Size(2, Number);
			}
			if (HasOptions)
			{
				num += CodedOutputStream.ComputeMessageSize(3, Options);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasName)
		{
			output.WriteString(1, Name);
		}
		if (HasNumber)
		{
			output.WriteInt32(2, Number);
		}
		if (HasOptions)
		{
			output.WriteMessage(3, Options);
		}
		UnknownFields.WriteTo(output);
	}

	public static EnumValueDescriptorProto ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static EnumValueDescriptorProto ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static EnumValueDescriptorProto ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static EnumValueDescriptorProto ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static EnumValueDescriptorProto ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static EnumValueDescriptorProto ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static EnumValueDescriptorProto ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static EnumValueDescriptorProto ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static EnumValueDescriptorProto ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static EnumValueDescriptorProto ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(EnumValueDescriptorProto prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static EnumValueDescriptorProto()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
	}
}
