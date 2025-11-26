using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class EnumDescriptorProto : GeneratedMessage<EnumDescriptorProto, EnumDescriptorProto.Builder>, IDescriptorProto<EnumOptions>
{
	public sealed class Builder : GeneratedBuilder<EnumDescriptorProto, Builder>
	{
		private EnumDescriptorProto result = new EnumDescriptorProto();

		protected override Builder ThisBuilder => this;

		protected override EnumDescriptorProto MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override EnumDescriptorProto DefaultInstanceForType => DefaultInstance;

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

		public IPopsicleList<EnumValueDescriptorProto> ValueList => result.value_;

		public int ValueCount => result.ValueCount;

		public bool HasOptions => result.HasOptions;

		public EnumOptions Options
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
			result = new EnumDescriptorProto();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override EnumDescriptorProto BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.value_.MakeReadOnly();
			EnumDescriptorProto enumDescriptorProto = result;
			result = null;
			return enumDescriptorProto;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is EnumDescriptorProto)
			{
				return MergeFrom((EnumDescriptorProto)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(EnumDescriptorProto other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasName)
			{
				Name = other.Name;
			}
			if (other.value_.Count != 0)
			{
				AddRange(other.value_, result.value_);
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
				{
					EnumValueDescriptorProto.Builder builder3 = EnumValueDescriptorProto.CreateBuilder();
					input.ReadMessage(builder3, extensionRegistry);
					AddValue(builder3.BuildPartial());
					continue;
				}
				case 26u:
				{
					EnumOptions.Builder builder2 = EnumOptions.CreateBuilder();
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

		public EnumValueDescriptorProto GetValue(int index)
		{
			return result.GetValue(index);
		}

		public Builder SetValue(int index, EnumValueDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.value_[index] = value;
			return this;
		}

		public Builder SetValue(int index, EnumValueDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.value_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddValue(EnumValueDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.value_.Add(value);
			return this;
		}

		public Builder AddValue(EnumValueDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.value_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeValue(IEnumerable<EnumValueDescriptorProto> values)
		{
			AddRange(values, result.value_);
			return this;
		}

		public Builder ClearValue()
		{
			result.value_.Clear();
			return this;
		}

		public Builder SetOptions(EnumOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasOptions = true;
			result.options_ = value;
			return this;
		}

		public Builder SetOptions(EnumOptions.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.hasOptions = true;
			result.options_ = builderForValue.Build();
			return this;
		}

		public Builder MergeOptions(EnumOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			if (result.HasOptions && result.options_ != EnumOptions.DefaultInstance)
			{
				result.options_ = EnumOptions.CreateBuilder(result.options_).MergeFrom(value).BuildPartial();
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
			result.options_ = EnumOptions.DefaultInstance;
			return this;
		}
	}

	public const int NameFieldNumber = 1;

	public const int ValueFieldNumber = 2;

	public const int OptionsFieldNumber = 3;

	private static readonly EnumDescriptorProto defaultInstance;

	private bool hasName;

	private string name_ = "";

	private PopsicleList<EnumValueDescriptorProto> value_ = new PopsicleList<EnumValueDescriptorProto>();

	private bool hasOptions;

	private EnumOptions options_ = EnumOptions.DefaultInstance;

	private int memoizedSerializedSize = -1;

	public static EnumDescriptorProto DefaultInstance => defaultInstance;

	public override EnumDescriptorProto DefaultInstanceForType => defaultInstance;

	protected override EnumDescriptorProto ThisMessage => this;

	public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_EnumDescriptorProto__Descriptor;

	protected override FieldAccessorTable<EnumDescriptorProto, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_EnumDescriptorProto__FieldAccessorTable;

	public bool HasName => hasName;

	public string Name => name_;

	public IList<EnumValueDescriptorProto> ValueList => value_;

	public int ValueCount => value_.Count;

	public bool HasOptions => hasOptions;

	public EnumOptions Options => options_;

	public override bool IsInitialized
	{
		get
		{
			foreach (EnumValueDescriptorProto value in ValueList)
			{
				if (!value.IsInitialized)
				{
					return false;
				}
			}
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
			foreach (EnumValueDescriptorProto value in ValueList)
			{
				num += CodedOutputStream.ComputeMessageSize(2, value);
			}
			if (HasOptions)
			{
				num += CodedOutputStream.ComputeMessageSize(3, Options);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public EnumValueDescriptorProto GetValue(int index)
	{
		return value_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasName)
		{
			output.WriteString(1, Name);
		}
		foreach (EnumValueDescriptorProto value in ValueList)
		{
			output.WriteMessage(2, value);
		}
		if (HasOptions)
		{
			output.WriteMessage(3, Options);
		}
		UnknownFields.WriteTo(output);
	}

	public static EnumDescriptorProto ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static EnumDescriptorProto ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static EnumDescriptorProto ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static EnumDescriptorProto ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static EnumDescriptorProto ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static EnumDescriptorProto ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static EnumDescriptorProto ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static EnumDescriptorProto ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static EnumDescriptorProto ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static EnumDescriptorProto ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(EnumDescriptorProto prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static EnumDescriptorProto()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
	}
}
