using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class FileDescriptorProto : GeneratedMessage<FileDescriptorProto, FileDescriptorProto.Builder>, IDescriptorProto<FileOptions>
{
	public sealed class Builder : GeneratedBuilder<FileDescriptorProto, Builder>
	{
		private FileDescriptorProto result = new FileDescriptorProto();

		protected override Builder ThisBuilder => this;

		protected override FileDescriptorProto MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override FileDescriptorProto DefaultInstanceForType => DefaultInstance;

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

		public bool HasPackage => result.HasPackage;

		public string Package
		{
			get
			{
				return result.Package;
			}
			set
			{
				SetPackage(value);
			}
		}

		public IPopsicleList<string> DependencyList => result.dependency_;

		public int DependencyCount => result.DependencyCount;

		public IPopsicleList<DescriptorProto> MessageTypeList => result.messageType_;

		public int MessageTypeCount => result.MessageTypeCount;

		public IPopsicleList<EnumDescriptorProto> EnumTypeList => result.enumType_;

		public int EnumTypeCount => result.EnumTypeCount;

		public IPopsicleList<ServiceDescriptorProto> ServiceList => result.service_;

		public int ServiceCount => result.ServiceCount;

		public IPopsicleList<FieldDescriptorProto> ExtensionList => result.extension_;

		public int ExtensionCount => result.ExtensionCount;

		public bool HasOptions => result.HasOptions;

		public FileOptions Options
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
			result = new FileDescriptorProto();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override FileDescriptorProto BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.dependency_.MakeReadOnly();
			result.messageType_.MakeReadOnly();
			result.enumType_.MakeReadOnly();
			result.service_.MakeReadOnly();
			result.extension_.MakeReadOnly();
			FileDescriptorProto fileDescriptorProto = result;
			result = null;
			return fileDescriptorProto;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is FileDescriptorProto)
			{
				return MergeFrom((FileDescriptorProto)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(FileDescriptorProto other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasName)
			{
				Name = other.Name;
			}
			if (other.HasPackage)
			{
				Package = other.Package;
			}
			if (other.dependency_.Count != 0)
			{
				AddRange(other.dependency_, result.dependency_);
			}
			if (other.messageType_.Count != 0)
			{
				AddRange(other.messageType_, result.messageType_);
			}
			if (other.enumType_.Count != 0)
			{
				AddRange(other.enumType_, result.enumType_);
			}
			if (other.service_.Count != 0)
			{
				AddRange(other.service_, result.service_);
			}
			if (other.extension_.Count != 0)
			{
				AddRange(other.extension_, result.extension_);
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
					Package = input.ReadString();
					continue;
				case 26u:
					AddDependency(input.ReadString());
					continue;
				case 34u:
				{
					DescriptorProto.Builder builder6 = DescriptorProto.CreateBuilder();
					input.ReadMessage(builder6, extensionRegistry);
					AddMessageType(builder6.BuildPartial());
					continue;
				}
				case 42u:
				{
					EnumDescriptorProto.Builder builder5 = EnumDescriptorProto.CreateBuilder();
					input.ReadMessage(builder5, extensionRegistry);
					AddEnumType(builder5.BuildPartial());
					continue;
				}
				case 50u:
				{
					ServiceDescriptorProto.Builder builder4 = ServiceDescriptorProto.CreateBuilder();
					input.ReadMessage(builder4, extensionRegistry);
					AddService(builder4.BuildPartial());
					continue;
				}
				case 58u:
				{
					FieldDescriptorProto.Builder builder3 = FieldDescriptorProto.CreateBuilder();
					input.ReadMessage(builder3, extensionRegistry);
					AddExtension(builder3.BuildPartial());
					continue;
				}
				case 66u:
				{
					FileOptions.Builder builder2 = FileOptions.CreateBuilder();
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

		public Builder SetPackage(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasPackage = true;
			result.package_ = value;
			return this;
		}

		public Builder ClearPackage()
		{
			result.hasPackage = false;
			result.package_ = "";
			return this;
		}

		public string GetDependency(int index)
		{
			return result.GetDependency(index);
		}

		public Builder SetDependency(int index, string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.dependency_[index] = value;
			return this;
		}

		public Builder AddDependency(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.dependency_.Add(value);
			return this;
		}

		public Builder AddRangeDependency(IEnumerable<string> values)
		{
			AddRange(values, result.dependency_);
			return this;
		}

		public Builder ClearDependency()
		{
			result.dependency_.Clear();
			return this;
		}

		public DescriptorProto GetMessageType(int index)
		{
			return result.GetMessageType(index);
		}

		public Builder SetMessageType(int index, DescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.messageType_[index] = value;
			return this;
		}

		public Builder SetMessageType(int index, DescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.messageType_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddMessageType(DescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.messageType_.Add(value);
			return this;
		}

		public Builder AddMessageType(DescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.messageType_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeMessageType(IEnumerable<DescriptorProto> values)
		{
			AddRange(values, result.messageType_);
			return this;
		}

		public Builder ClearMessageType()
		{
			result.messageType_.Clear();
			return this;
		}

		public EnumDescriptorProto GetEnumType(int index)
		{
			return result.GetEnumType(index);
		}

		public Builder SetEnumType(int index, EnumDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.enumType_[index] = value;
			return this;
		}

		public Builder SetEnumType(int index, EnumDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.enumType_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddEnumType(EnumDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.enumType_.Add(value);
			return this;
		}

		public Builder AddEnumType(EnumDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.enumType_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeEnumType(IEnumerable<EnumDescriptorProto> values)
		{
			AddRange(values, result.enumType_);
			return this;
		}

		public Builder ClearEnumType()
		{
			result.enumType_.Clear();
			return this;
		}

		public ServiceDescriptorProto GetService(int index)
		{
			return result.GetService(index);
		}

		public Builder SetService(int index, ServiceDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.service_[index] = value;
			return this;
		}

		public Builder SetService(int index, ServiceDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.service_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddService(ServiceDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.service_.Add(value);
			return this;
		}

		public Builder AddService(ServiceDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.service_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeService(IEnumerable<ServiceDescriptorProto> values)
		{
			AddRange(values, result.service_);
			return this;
		}

		public Builder ClearService()
		{
			result.service_.Clear();
			return this;
		}

		public FieldDescriptorProto GetExtension(int index)
		{
			return result.GetExtension(index);
		}

		public Builder SetExtension(int index, FieldDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.extension_[index] = value;
			return this;
		}

		public Builder SetExtension(int index, FieldDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.extension_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddExtension(FieldDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.extension_.Add(value);
			return this;
		}

		public Builder AddExtension(FieldDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.extension_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeExtension(IEnumerable<FieldDescriptorProto> values)
		{
			AddRange(values, result.extension_);
			return this;
		}

		public Builder ClearExtension()
		{
			result.extension_.Clear();
			return this;
		}

		public Builder SetOptions(FileOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasOptions = true;
			result.options_ = value;
			return this;
		}

		public Builder SetOptions(FileOptions.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.hasOptions = true;
			result.options_ = builderForValue.Build();
			return this;
		}

		public Builder MergeOptions(FileOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			if (result.HasOptions && result.options_ != FileOptions.DefaultInstance)
			{
				result.options_ = FileOptions.CreateBuilder(result.options_).MergeFrom(value).BuildPartial();
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
			result.options_ = FileOptions.DefaultInstance;
			return this;
		}
	}

	public const int NameFieldNumber = 1;

	public const int PackageFieldNumber = 2;

	public const int DependencyFieldNumber = 3;

	public const int MessageTypeFieldNumber = 4;

	public const int EnumTypeFieldNumber = 5;

	public const int ServiceFieldNumber = 6;

	public const int ExtensionFieldNumber = 7;

	public const int OptionsFieldNumber = 8;

	private static readonly FileDescriptorProto defaultInstance;

	private bool hasName;

	private string name_ = "";

	private bool hasPackage;

	private string package_ = "";

	private PopsicleList<string> dependency_ = new PopsicleList<string>();

	private PopsicleList<DescriptorProto> messageType_ = new PopsicleList<DescriptorProto>();

	private PopsicleList<EnumDescriptorProto> enumType_ = new PopsicleList<EnumDescriptorProto>();

	private PopsicleList<ServiceDescriptorProto> service_ = new PopsicleList<ServiceDescriptorProto>();

	private PopsicleList<FieldDescriptorProto> extension_ = new PopsicleList<FieldDescriptorProto>();

	private bool hasOptions;

	private FileOptions options_ = FileOptions.DefaultInstance;

	private int memoizedSerializedSize = -1;

	public static FileDescriptorProto DefaultInstance => defaultInstance;

	public override FileDescriptorProto DefaultInstanceForType => defaultInstance;

	protected override FileDescriptorProto ThisMessage => this;

	public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_FileDescriptorProto__Descriptor;

	protected override FieldAccessorTable<FileDescriptorProto, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_FileDescriptorProto__FieldAccessorTable;

	public bool HasName => hasName;

	public string Name => name_;

	public bool HasPackage => hasPackage;

	public string Package => package_;

	public IList<string> DependencyList => Lists.AsReadOnly(dependency_);

	public int DependencyCount => dependency_.Count;

	public IList<DescriptorProto> MessageTypeList => messageType_;

	public int MessageTypeCount => messageType_.Count;

	public IList<EnumDescriptorProto> EnumTypeList => enumType_;

	public int EnumTypeCount => enumType_.Count;

	public IList<ServiceDescriptorProto> ServiceList => service_;

	public int ServiceCount => service_.Count;

	public IList<FieldDescriptorProto> ExtensionList => extension_;

	public int ExtensionCount => extension_.Count;

	public bool HasOptions => hasOptions;

	public FileOptions Options => options_;

	public override bool IsInitialized
	{
		get
		{
			foreach (DescriptorProto messageType in MessageTypeList)
			{
				if (!messageType.IsInitialized)
				{
					return false;
				}
			}
			foreach (EnumDescriptorProto enumType in EnumTypeList)
			{
				if (!enumType.IsInitialized)
				{
					return false;
				}
			}
			foreach (ServiceDescriptorProto service in ServiceList)
			{
				if (!service.IsInitialized)
				{
					return false;
				}
			}
			foreach (FieldDescriptorProto extension in ExtensionList)
			{
				if (!extension.IsInitialized)
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
			if (HasPackage)
			{
				num += CodedOutputStream.ComputeStringSize(2, Package);
			}
			int num2 = 0;
			foreach (string dependency in DependencyList)
			{
				num2 += CodedOutputStream.ComputeStringSizeNoTag(dependency);
			}
			num += num2;
			num += dependency_.Count;
			foreach (DescriptorProto messageType in MessageTypeList)
			{
				num += CodedOutputStream.ComputeMessageSize(4, messageType);
			}
			foreach (EnumDescriptorProto enumType in EnumTypeList)
			{
				num += CodedOutputStream.ComputeMessageSize(5, enumType);
			}
			foreach (ServiceDescriptorProto service in ServiceList)
			{
				num += CodedOutputStream.ComputeMessageSize(6, service);
			}
			foreach (FieldDescriptorProto extension in ExtensionList)
			{
				num += CodedOutputStream.ComputeMessageSize(7, extension);
			}
			if (HasOptions)
			{
				num += CodedOutputStream.ComputeMessageSize(8, Options);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public string GetDependency(int index)
	{
		return dependency_[index];
	}

	public DescriptorProto GetMessageType(int index)
	{
		return messageType_[index];
	}

	public EnumDescriptorProto GetEnumType(int index)
	{
		return enumType_[index];
	}

	public ServiceDescriptorProto GetService(int index)
	{
		return service_[index];
	}

	public FieldDescriptorProto GetExtension(int index)
	{
		return extension_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasName)
		{
			output.WriteString(1, Name);
		}
		if (HasPackage)
		{
			output.WriteString(2, Package);
		}
		if (dependency_.Count > 0)
		{
			foreach (string item in dependency_)
			{
				output.WriteString(3, item);
			}
		}
		foreach (DescriptorProto messageType in MessageTypeList)
		{
			output.WriteMessage(4, messageType);
		}
		foreach (EnumDescriptorProto enumType in EnumTypeList)
		{
			output.WriteMessage(5, enumType);
		}
		foreach (ServiceDescriptorProto service in ServiceList)
		{
			output.WriteMessage(6, service);
		}
		foreach (FieldDescriptorProto extension in ExtensionList)
		{
			output.WriteMessage(7, extension);
		}
		if (HasOptions)
		{
			output.WriteMessage(8, Options);
		}
		UnknownFields.WriteTo(output);
	}

	public static FileDescriptorProto ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static FileDescriptorProto ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static FileDescriptorProto ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static FileDescriptorProto ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static FileDescriptorProto ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static FileDescriptorProto ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static FileDescriptorProto ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static FileDescriptorProto ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static FileDescriptorProto ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static FileDescriptorProto ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(FileDescriptorProto prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static FileDescriptorProto()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
	}
}
