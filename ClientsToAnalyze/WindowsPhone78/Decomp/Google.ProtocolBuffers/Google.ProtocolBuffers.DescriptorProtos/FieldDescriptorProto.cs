using System;
using System.IO;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class FieldDescriptorProto : GeneratedMessage<FieldDescriptorProto, FieldDescriptorProto.Builder>, IDescriptorProto<FieldOptions>
{
	public static class Types
	{
		public enum Type
		{
			TYPE_DOUBLE = 1,
			TYPE_FLOAT,
			TYPE_INT64,
			TYPE_UINT64,
			TYPE_INT32,
			TYPE_FIXED64,
			TYPE_FIXED32,
			TYPE_BOOL,
			TYPE_STRING,
			TYPE_GROUP,
			TYPE_MESSAGE,
			TYPE_BYTES,
			TYPE_UINT32,
			TYPE_ENUM,
			TYPE_SFIXED32,
			TYPE_SFIXED64,
			TYPE_SINT32,
			TYPE_SINT64
		}

		public enum Label
		{
			LABEL_OPTIONAL = 1,
			LABEL_REQUIRED,
			LABEL_REPEATED
		}
	}

	public sealed class Builder : GeneratedBuilder<FieldDescriptorProto, Builder>
	{
		private FieldDescriptorProto result = new FieldDescriptorProto();

		protected override Builder ThisBuilder => this;

		protected override FieldDescriptorProto MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override FieldDescriptorProto DefaultInstanceForType => DefaultInstance;

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

		public bool HasLabel => result.HasLabel;

		public Types.Label Label
		{
			get
			{
				return result.Label;
			}
			set
			{
				SetLabel(value);
			}
		}

		public bool HasType => result.HasType;

		public Types.Type Type
		{
			get
			{
				return result.Type;
			}
			set
			{
				SetType(value);
			}
		}

		public bool HasTypeName => result.HasTypeName;

		public string TypeName
		{
			get
			{
				return result.TypeName;
			}
			set
			{
				SetTypeName(value);
			}
		}

		public bool HasExtendee => result.HasExtendee;

		public string Extendee
		{
			get
			{
				return result.Extendee;
			}
			set
			{
				SetExtendee(value);
			}
		}

		public bool HasDefaultValue => result.HasDefaultValue;

		public string DefaultValue
		{
			get
			{
				return result.DefaultValue;
			}
			set
			{
				SetDefaultValue(value);
			}
		}

		public bool HasOptions => result.HasOptions;

		public FieldOptions Options
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
			result = new FieldDescriptorProto();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override FieldDescriptorProto BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			FieldDescriptorProto fieldDescriptorProto = result;
			result = null;
			return fieldDescriptorProto;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is FieldDescriptorProto)
			{
				return MergeFrom((FieldDescriptorProto)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(FieldDescriptorProto other)
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
			if (other.HasLabel)
			{
				Label = other.Label;
			}
			if (other.HasType)
			{
				Type = other.Type;
			}
			if (other.HasTypeName)
			{
				TypeName = other.TypeName;
			}
			if (other.HasExtendee)
			{
				Extendee = other.Extendee;
			}
			if (other.HasDefaultValue)
			{
				DefaultValue = other.DefaultValue;
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
				case 18u:
					Extendee = input.ReadString();
					continue;
				case 24u:
					Number = input.ReadInt32();
					continue;
				case 32u:
				{
					int num2 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(Types.Label), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(4, (ulong)num2);
					}
					else
					{
						Label = (Types.Label)num2;
					}
					continue;
				}
				case 40u:
				{
					int num3 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(Types.Type), num3))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(5, (ulong)num3);
					}
					else
					{
						Type = (Types.Type)num3;
					}
					continue;
				}
				case 50u:
					TypeName = input.ReadString();
					continue;
				case 58u:
					DefaultValue = input.ReadString();
					continue;
				case 66u:
				{
					FieldOptions.Builder builder2 = FieldOptions.CreateBuilder();
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

		public Builder SetLabel(Types.Label value)
		{
			result.hasLabel = true;
			result.label_ = value;
			return this;
		}

		public Builder ClearLabel()
		{
			result.hasLabel = false;
			result.label_ = Types.Label.LABEL_OPTIONAL;
			return this;
		}

		public Builder SetType(Types.Type value)
		{
			result.hasType = true;
			result.type_ = value;
			return this;
		}

		public Builder ClearType()
		{
			result.hasType = false;
			result.type_ = Types.Type.TYPE_DOUBLE;
			return this;
		}

		public Builder SetTypeName(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasTypeName = true;
			result.typeName_ = value;
			return this;
		}

		public Builder ClearTypeName()
		{
			result.hasTypeName = false;
			result.typeName_ = "";
			return this;
		}

		public Builder SetExtendee(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasExtendee = true;
			result.extendee_ = value;
			return this;
		}

		public Builder ClearExtendee()
		{
			result.hasExtendee = false;
			result.extendee_ = "";
			return this;
		}

		public Builder SetDefaultValue(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasDefaultValue = true;
			result.defaultValue_ = value;
			return this;
		}

		public Builder ClearDefaultValue()
		{
			result.hasDefaultValue = false;
			result.defaultValue_ = "";
			return this;
		}

		public Builder SetOptions(FieldOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasOptions = true;
			result.options_ = value;
			return this;
		}

		public Builder SetOptions(FieldOptions.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.hasOptions = true;
			result.options_ = builderForValue.Build();
			return this;
		}

		public Builder MergeOptions(FieldOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			if (result.HasOptions && result.options_ != FieldOptions.DefaultInstance)
			{
				result.options_ = FieldOptions.CreateBuilder(result.options_).MergeFrom(value).BuildPartial();
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
			result.options_ = FieldOptions.DefaultInstance;
			return this;
		}
	}

	public const int NameFieldNumber = 1;

	public const int NumberFieldNumber = 3;

	public const int LabelFieldNumber = 4;

	public const int TypeFieldNumber = 5;

	public const int TypeNameFieldNumber = 6;

	public const int ExtendeeFieldNumber = 2;

	public const int DefaultValueFieldNumber = 7;

	public const int OptionsFieldNumber = 8;

	private static readonly FieldDescriptorProto defaultInstance;

	private bool hasName;

	private string name_ = "";

	private bool hasNumber;

	private int number_;

	private bool hasLabel;

	private Types.Label label_ = Types.Label.LABEL_OPTIONAL;

	private bool hasType;

	private Types.Type type_ = Types.Type.TYPE_DOUBLE;

	private bool hasTypeName;

	private string typeName_ = "";

	private bool hasExtendee;

	private string extendee_ = "";

	private bool hasDefaultValue;

	private string defaultValue_ = "";

	private bool hasOptions;

	private FieldOptions options_ = FieldOptions.DefaultInstance;

	private int memoizedSerializedSize = -1;

	public static FieldDescriptorProto DefaultInstance => defaultInstance;

	public override FieldDescriptorProto DefaultInstanceForType => defaultInstance;

	protected override FieldDescriptorProto ThisMessage => this;

	public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_FieldDescriptorProto__Descriptor;

	protected override FieldAccessorTable<FieldDescriptorProto, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_FieldDescriptorProto__FieldAccessorTable;

	public bool HasName => hasName;

	public string Name => name_;

	public bool HasNumber => hasNumber;

	public int Number => number_;

	public bool HasLabel => hasLabel;

	public Types.Label Label => label_;

	public bool HasType => hasType;

	public Types.Type Type => type_;

	public bool HasTypeName => hasTypeName;

	public string TypeName => typeName_;

	public bool HasExtendee => hasExtendee;

	public string Extendee => extendee_;

	public bool HasDefaultValue => hasDefaultValue;

	public string DefaultValue => defaultValue_;

	public bool HasOptions => hasOptions;

	public FieldOptions Options => options_;

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
				num += CodedOutputStream.ComputeInt32Size(3, Number);
			}
			if (HasLabel)
			{
				num += CodedOutputStream.ComputeEnumSize(4, (int)Label);
			}
			if (HasType)
			{
				num += CodedOutputStream.ComputeEnumSize(5, (int)Type);
			}
			if (HasTypeName)
			{
				num += CodedOutputStream.ComputeStringSize(6, TypeName);
			}
			if (HasExtendee)
			{
				num += CodedOutputStream.ComputeStringSize(2, Extendee);
			}
			if (HasDefaultValue)
			{
				num += CodedOutputStream.ComputeStringSize(7, DefaultValue);
			}
			if (HasOptions)
			{
				num += CodedOutputStream.ComputeMessageSize(8, Options);
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
		if (HasExtendee)
		{
			output.WriteString(2, Extendee);
		}
		if (HasNumber)
		{
			output.WriteInt32(3, Number);
		}
		if (HasLabel)
		{
			output.WriteEnum(4, (int)Label);
		}
		if (HasType)
		{
			output.WriteEnum(5, (int)Type);
		}
		if (HasTypeName)
		{
			output.WriteString(6, TypeName);
		}
		if (HasDefaultValue)
		{
			output.WriteString(7, DefaultValue);
		}
		if (HasOptions)
		{
			output.WriteMessage(8, Options);
		}
		UnknownFields.WriteTo(output);
	}

	public static FieldDescriptorProto ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static FieldDescriptorProto ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static FieldDescriptorProto ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static FieldDescriptorProto ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static FieldDescriptorProto ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static FieldDescriptorProto ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static FieldDescriptorProto ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static FieldDescriptorProto ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static FieldDescriptorProto ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static FieldDescriptorProto ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(FieldDescriptorProto prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static FieldDescriptorProto()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
	}
}
