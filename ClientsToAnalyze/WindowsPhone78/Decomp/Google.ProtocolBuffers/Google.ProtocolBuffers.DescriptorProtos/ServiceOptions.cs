using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class ServiceOptions : ExtendableMessage<ServiceOptions, ServiceOptions.Builder>
{
	public sealed class Builder : ExtendableBuilder<ServiceOptions, Builder>
	{
		private ServiceOptions result = new ServiceOptions();

		protected override Builder ThisBuilder => this;

		protected override ServiceOptions MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override ServiceOptions DefaultInstanceForType => DefaultInstance;

		public IPopsicleList<UninterpretedOption> UninterpretedOptionList => result.uninterpretedOption_;

		public int UninterpretedOptionCount => result.UninterpretedOptionCount;

		public override Builder Clear()
		{
			result = new ServiceOptions();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override ServiceOptions BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.uninterpretedOption_.MakeReadOnly();
			ServiceOptions serviceOptions = result;
			result = null;
			return serviceOptions;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is ServiceOptions)
			{
				return MergeFrom((ServiceOptions)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(ServiceOptions other)
		{
			if (other == DefaultInstance)
			{
				return this;
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

	public const int UninterpretedOptionFieldNumber = 999;

	private static readonly ServiceOptions defaultInstance;

	private PopsicleList<UninterpretedOption> uninterpretedOption_ = new PopsicleList<UninterpretedOption>();

	private int memoizedSerializedSize = -1;

	public static ServiceOptions DefaultInstance => defaultInstance;

	public override ServiceOptions DefaultInstanceForType => defaultInstance;

	protected override ServiceOptions ThisMessage => this;

	public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_ServiceOptions__Descriptor;

	protected override FieldAccessorTable<ServiceOptions, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_ServiceOptions__FieldAccessorTable;

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
		foreach (UninterpretedOption uninterpretedOption in UninterpretedOptionList)
		{
			output.WriteMessage(999, uninterpretedOption);
		}
		extensionWriter.WriteUntil(536870912, output);
		UnknownFields.WriteTo(output);
	}

	public static ServiceOptions ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static ServiceOptions ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static ServiceOptions ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static ServiceOptions ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static ServiceOptions ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static ServiceOptions ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static ServiceOptions ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static ServiceOptions ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static ServiceOptions ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static ServiceOptions ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(ServiceOptions prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static ServiceOptions()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
	}
}
