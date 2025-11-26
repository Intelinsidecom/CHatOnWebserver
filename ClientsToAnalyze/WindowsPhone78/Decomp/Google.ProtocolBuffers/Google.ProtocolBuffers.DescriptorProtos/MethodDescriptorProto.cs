using System;
using System.IO;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class MethodDescriptorProto : GeneratedMessage<MethodDescriptorProto, MethodDescriptorProto.Builder>, IDescriptorProto<MethodOptions>
{
	public sealed class Builder : GeneratedBuilder<MethodDescriptorProto, Builder>
	{
		private MethodDescriptorProto result = new MethodDescriptorProto();

		protected override Builder ThisBuilder => this;

		protected override MethodDescriptorProto MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override MethodDescriptorProto DefaultInstanceForType => DefaultInstance;

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

		public bool HasInputType => result.HasInputType;

		public string InputType
		{
			get
			{
				return result.InputType;
			}
			set
			{
				SetInputType(value);
			}
		}

		public bool HasOutputType => result.HasOutputType;

		public string OutputType
		{
			get
			{
				return result.OutputType;
			}
			set
			{
				SetOutputType(value);
			}
		}

		public bool HasOptions => result.HasOptions;

		public MethodOptions Options
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
			result = new MethodDescriptorProto();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override MethodDescriptorProto BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			MethodDescriptorProto methodDescriptorProto = result;
			result = null;
			return methodDescriptorProto;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is MethodDescriptorProto)
			{
				return MergeFrom((MethodDescriptorProto)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(MethodDescriptorProto other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasName)
			{
				Name = other.Name;
			}
			if (other.HasInputType)
			{
				InputType = other.InputType;
			}
			if (other.HasOutputType)
			{
				OutputType = other.OutputType;
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
					InputType = input.ReadString();
					continue;
				case 26u:
					OutputType = input.ReadString();
					continue;
				case 34u:
				{
					MethodOptions.Builder builder2 = MethodOptions.CreateBuilder();
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

		public Builder SetInputType(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasInputType = true;
			result.inputType_ = value;
			return this;
		}

		public Builder ClearInputType()
		{
			result.hasInputType = false;
			result.inputType_ = "";
			return this;
		}

		public Builder SetOutputType(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasOutputType = true;
			result.outputType_ = value;
			return this;
		}

		public Builder ClearOutputType()
		{
			result.hasOutputType = false;
			result.outputType_ = "";
			return this;
		}

		public Builder SetOptions(MethodOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasOptions = true;
			result.options_ = value;
			return this;
		}

		public Builder SetOptions(MethodOptions.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.hasOptions = true;
			result.options_ = builderForValue.Build();
			return this;
		}

		public Builder MergeOptions(MethodOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			if (result.HasOptions && result.options_ != MethodOptions.DefaultInstance)
			{
				result.options_ = MethodOptions.CreateBuilder(result.options_).MergeFrom(value).BuildPartial();
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
			result.options_ = MethodOptions.DefaultInstance;
			return this;
		}
	}

	public const int NameFieldNumber = 1;

	public const int InputTypeFieldNumber = 2;

	public const int OutputTypeFieldNumber = 3;

	public const int OptionsFieldNumber = 4;

	private static readonly MethodDescriptorProto defaultInstance;

	private bool hasName;

	private string name_ = "";

	private bool hasInputType;

	private string inputType_ = "";

	private bool hasOutputType;

	private string outputType_ = "";

	private bool hasOptions;

	private MethodOptions options_ = MethodOptions.DefaultInstance;

	private int memoizedSerializedSize = -1;

	public static MethodDescriptorProto DefaultInstance => defaultInstance;

	public override MethodDescriptorProto DefaultInstanceForType => defaultInstance;

	protected override MethodDescriptorProto ThisMessage => this;

	public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_MethodDescriptorProto__Descriptor;

	protected override FieldAccessorTable<MethodDescriptorProto, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_MethodDescriptorProto__FieldAccessorTable;

	public bool HasName => hasName;

	public string Name => name_;

	public bool HasInputType => hasInputType;

	public string InputType => inputType_;

	public bool HasOutputType => hasOutputType;

	public string OutputType => outputType_;

	public bool HasOptions => hasOptions;

	public MethodOptions Options => options_;

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
			if (HasInputType)
			{
				num += CodedOutputStream.ComputeStringSize(2, InputType);
			}
			if (HasOutputType)
			{
				num += CodedOutputStream.ComputeStringSize(3, OutputType);
			}
			if (HasOptions)
			{
				num += CodedOutputStream.ComputeMessageSize(4, Options);
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
		if (HasInputType)
		{
			output.WriteString(2, InputType);
		}
		if (HasOutputType)
		{
			output.WriteString(3, OutputType);
		}
		if (HasOptions)
		{
			output.WriteMessage(4, Options);
		}
		UnknownFields.WriteTo(output);
	}

	public static MethodDescriptorProto ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static MethodDescriptorProto ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static MethodDescriptorProto ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static MethodDescriptorProto ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static MethodDescriptorProto ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static MethodDescriptorProto ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static MethodDescriptorProto ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static MethodDescriptorProto ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static MethodDescriptorProto ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static MethodDescriptorProto ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(MethodDescriptorProto prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static MethodDescriptorProto()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
	}
}
