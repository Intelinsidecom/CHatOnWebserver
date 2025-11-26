using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class ServiceDescriptorProto : GeneratedMessage<ServiceDescriptorProto, ServiceDescriptorProto.Builder>, IDescriptorProto<ServiceOptions>
{
	public sealed class Builder : GeneratedBuilder<ServiceDescriptorProto, Builder>
	{
		private ServiceDescriptorProto result = new ServiceDescriptorProto();

		protected override Builder ThisBuilder => this;

		protected override ServiceDescriptorProto MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override ServiceDescriptorProto DefaultInstanceForType => DefaultInstance;

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

		public IPopsicleList<MethodDescriptorProto> MethodList => result.method_;

		public int MethodCount => result.MethodCount;

		public bool HasOptions => result.HasOptions;

		public ServiceOptions Options
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
			result = new ServiceDescriptorProto();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override ServiceDescriptorProto BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.method_.MakeReadOnly();
			ServiceDescriptorProto serviceDescriptorProto = result;
			result = null;
			return serviceDescriptorProto;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is ServiceDescriptorProto)
			{
				return MergeFrom((ServiceDescriptorProto)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(ServiceDescriptorProto other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasName)
			{
				Name = other.Name;
			}
			if (other.method_.Count != 0)
			{
				AddRange(other.method_, result.method_);
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
					MethodDescriptorProto.Builder builder3 = MethodDescriptorProto.CreateBuilder();
					input.ReadMessage(builder3, extensionRegistry);
					AddMethod(builder3.BuildPartial());
					continue;
				}
				case 26u:
				{
					ServiceOptions.Builder builder2 = ServiceOptions.CreateBuilder();
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

		public MethodDescriptorProto GetMethod(int index)
		{
			return result.GetMethod(index);
		}

		public Builder SetMethod(int index, MethodDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.method_[index] = value;
			return this;
		}

		public Builder SetMethod(int index, MethodDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.method_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddMethod(MethodDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.method_.Add(value);
			return this;
		}

		public Builder AddMethod(MethodDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.method_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeMethod(IEnumerable<MethodDescriptorProto> values)
		{
			AddRange(values, result.method_);
			return this;
		}

		public Builder ClearMethod()
		{
			result.method_.Clear();
			return this;
		}

		public Builder SetOptions(ServiceOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasOptions = true;
			result.options_ = value;
			return this;
		}

		public Builder SetOptions(ServiceOptions.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.hasOptions = true;
			result.options_ = builderForValue.Build();
			return this;
		}

		public Builder MergeOptions(ServiceOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			if (result.HasOptions && result.options_ != ServiceOptions.DefaultInstance)
			{
				result.options_ = ServiceOptions.CreateBuilder(result.options_).MergeFrom(value).BuildPartial();
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
			result.options_ = ServiceOptions.DefaultInstance;
			return this;
		}
	}

	public const int NameFieldNumber = 1;

	public const int MethodFieldNumber = 2;

	public const int OptionsFieldNumber = 3;

	private static readonly ServiceDescriptorProto defaultInstance;

	private bool hasName;

	private string name_ = "";

	private PopsicleList<MethodDescriptorProto> method_ = new PopsicleList<MethodDescriptorProto>();

	private bool hasOptions;

	private ServiceOptions options_ = ServiceOptions.DefaultInstance;

	private int memoizedSerializedSize = -1;

	public static ServiceDescriptorProto DefaultInstance => defaultInstance;

	public override ServiceDescriptorProto DefaultInstanceForType => defaultInstance;

	protected override ServiceDescriptorProto ThisMessage => this;

	public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_ServiceDescriptorProto__Descriptor;

	protected override FieldAccessorTable<ServiceDescriptorProto, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_ServiceDescriptorProto__FieldAccessorTable;

	public bool HasName => hasName;

	public string Name => name_;

	public IList<MethodDescriptorProto> MethodList => method_;

	public int MethodCount => method_.Count;

	public bool HasOptions => hasOptions;

	public ServiceOptions Options => options_;

	public override bool IsInitialized
	{
		get
		{
			foreach (MethodDescriptorProto method in MethodList)
			{
				if (!method.IsInitialized)
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
			foreach (MethodDescriptorProto method in MethodList)
			{
				num += CodedOutputStream.ComputeMessageSize(2, method);
			}
			if (HasOptions)
			{
				num += CodedOutputStream.ComputeMessageSize(3, Options);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public MethodDescriptorProto GetMethod(int index)
	{
		return method_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasName)
		{
			output.WriteString(1, Name);
		}
		foreach (MethodDescriptorProto method in MethodList)
		{
			output.WriteMessage(2, method);
		}
		if (HasOptions)
		{
			output.WriteMessage(3, Options);
		}
		UnknownFields.WriteTo(output);
	}

	public static ServiceDescriptorProto ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static ServiceDescriptorProto ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static ServiceDescriptorProto ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static ServiceDescriptorProto ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static ServiceDescriptorProto ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static ServiceDescriptorProto ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static ServiceDescriptorProto ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static ServiceDescriptorProto ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static ServiceDescriptorProto ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static ServiceDescriptorProto ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(ServiceDescriptorProto prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static ServiceDescriptorProto()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
	}
}
