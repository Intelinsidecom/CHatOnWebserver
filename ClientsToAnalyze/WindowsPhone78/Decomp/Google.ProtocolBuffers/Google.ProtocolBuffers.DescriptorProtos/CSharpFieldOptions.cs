using System;
using System.IO;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class CSharpFieldOptions : GeneratedMessage<CSharpFieldOptions, CSharpFieldOptions.Builder>
{
	public sealed class Builder : GeneratedBuilder<CSharpFieldOptions, Builder>
	{
		private CSharpFieldOptions result = new CSharpFieldOptions();

		protected override Builder ThisBuilder => this;

		protected override CSharpFieldOptions MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override CSharpFieldOptions DefaultInstanceForType => DefaultInstance;

		public bool HasPropertyName => result.HasPropertyName;

		public string PropertyName
		{
			get
			{
				return result.PropertyName;
			}
			set
			{
				SetPropertyName(value);
			}
		}

		public override Builder Clear()
		{
			result = new CSharpFieldOptions();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override CSharpFieldOptions BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			CSharpFieldOptions cSharpFieldOptions = result;
			result = null;
			return cSharpFieldOptions;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is CSharpFieldOptions)
			{
				return MergeFrom((CSharpFieldOptions)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(CSharpFieldOptions other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasPropertyName)
			{
				PropertyName = other.PropertyName;
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
					PropertyName = input.ReadString();
					continue;
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

		public Builder SetPropertyName(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasPropertyName = true;
			result.propertyName_ = value;
			return this;
		}

		public Builder ClearPropertyName()
		{
			result.hasPropertyName = false;
			result.propertyName_ = "";
			return this;
		}
	}

	public const int PropertyNameFieldNumber = 1;

	private static readonly CSharpFieldOptions defaultInstance;

	private bool hasPropertyName;

	private string propertyName_ = "";

	private int memoizedSerializedSize = -1;

	public static CSharpFieldOptions DefaultInstance => defaultInstance;

	public override CSharpFieldOptions DefaultInstanceForType => defaultInstance;

	protected override CSharpFieldOptions ThisMessage => this;

	public static MessageDescriptor Descriptor => CSharpOptions.internal__static_google_protobuf_CSharpFieldOptions__Descriptor;

	protected override FieldAccessorTable<CSharpFieldOptions, Builder> InternalFieldAccessors => CSharpOptions.internal__static_google_protobuf_CSharpFieldOptions__FieldAccessorTable;

	public bool HasPropertyName => hasPropertyName;

	public string PropertyName => propertyName_;

	public override bool IsInitialized => true;

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
			if (HasPropertyName)
			{
				num += CodedOutputStream.ComputeStringSize(1, PropertyName);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasPropertyName)
		{
			output.WriteString(1, PropertyName);
		}
		UnknownFields.WriteTo(output);
	}

	public static CSharpFieldOptions ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static CSharpFieldOptions ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static CSharpFieldOptions ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static CSharpFieldOptions ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static CSharpFieldOptions ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static CSharpFieldOptions ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static CSharpFieldOptions ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static CSharpFieldOptions ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static CSharpFieldOptions ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static CSharpFieldOptions ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(CSharpFieldOptions prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static CSharpFieldOptions()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(CSharpOptions.Descriptor, null);
	}
}
