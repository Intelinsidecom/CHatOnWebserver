using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class FileOptions : ExtendableMessage<FileOptions, FileOptions.Builder>
{
	public static class Types
	{
		public enum OptimizeMode
		{
			SPEED = 1,
			CODE_SIZE,
			LITE_RUNTIME
		}
	}

	public sealed class Builder : ExtendableBuilder<FileOptions, Builder>
	{
		private FileOptions result = new FileOptions();

		protected override Builder ThisBuilder => this;

		protected override FileOptions MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override FileOptions DefaultInstanceForType => DefaultInstance;

		public bool HasJavaPackage => result.HasJavaPackage;

		public string JavaPackage
		{
			get
			{
				return result.JavaPackage;
			}
			set
			{
				SetJavaPackage(value);
			}
		}

		public bool HasJavaOuterClassname => result.HasJavaOuterClassname;

		public string JavaOuterClassname
		{
			get
			{
				return result.JavaOuterClassname;
			}
			set
			{
				SetJavaOuterClassname(value);
			}
		}

		public bool HasJavaMultipleFiles => result.HasJavaMultipleFiles;

		public bool JavaMultipleFiles
		{
			get
			{
				return result.JavaMultipleFiles;
			}
			set
			{
				SetJavaMultipleFiles(value);
			}
		}

		public bool HasOptimizeFor => result.HasOptimizeFor;

		public Types.OptimizeMode OptimizeFor
		{
			get
			{
				return result.OptimizeFor;
			}
			set
			{
				SetOptimizeFor(value);
			}
		}

		public bool HasCcGenericServices => result.HasCcGenericServices;

		public bool CcGenericServices
		{
			get
			{
				return result.CcGenericServices;
			}
			set
			{
				SetCcGenericServices(value);
			}
		}

		public bool HasJavaGenericServices => result.HasJavaGenericServices;

		public bool JavaGenericServices
		{
			get
			{
				return result.JavaGenericServices;
			}
			set
			{
				SetJavaGenericServices(value);
			}
		}

		public bool HasPyGenericServices => result.HasPyGenericServices;

		public bool PyGenericServices
		{
			get
			{
				return result.PyGenericServices;
			}
			set
			{
				SetPyGenericServices(value);
			}
		}

		public IPopsicleList<UninterpretedOption> UninterpretedOptionList => result.uninterpretedOption_;

		public int UninterpretedOptionCount => result.UninterpretedOptionCount;

		public override Builder Clear()
		{
			result = new FileOptions();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override FileOptions BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.uninterpretedOption_.MakeReadOnly();
			FileOptions fileOptions = result;
			result = null;
			return fileOptions;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is FileOptions)
			{
				return MergeFrom((FileOptions)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(FileOptions other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasJavaPackage)
			{
				JavaPackage = other.JavaPackage;
			}
			if (other.HasJavaOuterClassname)
			{
				JavaOuterClassname = other.JavaOuterClassname;
			}
			if (other.HasJavaMultipleFiles)
			{
				JavaMultipleFiles = other.JavaMultipleFiles;
			}
			if (other.HasOptimizeFor)
			{
				OptimizeFor = other.OptimizeFor;
			}
			if (other.HasCcGenericServices)
			{
				CcGenericServices = other.CcGenericServices;
			}
			if (other.HasJavaGenericServices)
			{
				JavaGenericServices = other.JavaGenericServices;
			}
			if (other.HasPyGenericServices)
			{
				PyGenericServices = other.PyGenericServices;
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
				case 10u:
					JavaPackage = input.ReadString();
					continue;
				case 66u:
					JavaOuterClassname = input.ReadString();
					continue;
				case 72u:
				{
					int num2 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(Types.OptimizeMode), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(9, (ulong)num2);
					}
					else
					{
						OptimizeFor = (Types.OptimizeMode)num2;
					}
					continue;
				}
				case 80u:
					JavaMultipleFiles = input.ReadBool();
					continue;
				case 128u:
					CcGenericServices = input.ReadBool();
					continue;
				case 136u:
					JavaGenericServices = input.ReadBool();
					continue;
				case 144u:
					PyGenericServices = input.ReadBool();
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

		public Builder SetJavaPackage(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasJavaPackage = true;
			result.javaPackage_ = value;
			return this;
		}

		public Builder ClearJavaPackage()
		{
			result.hasJavaPackage = false;
			result.javaPackage_ = "";
			return this;
		}

		public Builder SetJavaOuterClassname(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasJavaOuterClassname = true;
			result.javaOuterClassname_ = value;
			return this;
		}

		public Builder ClearJavaOuterClassname()
		{
			result.hasJavaOuterClassname = false;
			result.javaOuterClassname_ = "";
			return this;
		}

		public Builder SetJavaMultipleFiles(bool value)
		{
			result.hasJavaMultipleFiles = true;
			result.javaMultipleFiles_ = value;
			return this;
		}

		public Builder ClearJavaMultipleFiles()
		{
			result.hasJavaMultipleFiles = false;
			result.javaMultipleFiles_ = false;
			return this;
		}

		public Builder SetOptimizeFor(Types.OptimizeMode value)
		{
			result.hasOptimizeFor = true;
			result.optimizeFor_ = value;
			return this;
		}

		public Builder ClearOptimizeFor()
		{
			result.hasOptimizeFor = false;
			result.optimizeFor_ = Types.OptimizeMode.SPEED;
			return this;
		}

		public Builder SetCcGenericServices(bool value)
		{
			result.hasCcGenericServices = true;
			result.ccGenericServices_ = value;
			return this;
		}

		public Builder ClearCcGenericServices()
		{
			result.hasCcGenericServices = false;
			result.ccGenericServices_ = true;
			return this;
		}

		public Builder SetJavaGenericServices(bool value)
		{
			result.hasJavaGenericServices = true;
			result.javaGenericServices_ = value;
			return this;
		}

		public Builder ClearJavaGenericServices()
		{
			result.hasJavaGenericServices = false;
			result.javaGenericServices_ = true;
			return this;
		}

		public Builder SetPyGenericServices(bool value)
		{
			result.hasPyGenericServices = true;
			result.pyGenericServices_ = value;
			return this;
		}

		public Builder ClearPyGenericServices()
		{
			result.hasPyGenericServices = false;
			result.pyGenericServices_ = true;
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

	public const int JavaPackageFieldNumber = 1;

	public const int JavaOuterClassnameFieldNumber = 8;

	public const int JavaMultipleFilesFieldNumber = 10;

	public const int OptimizeForFieldNumber = 9;

	public const int CcGenericServicesFieldNumber = 16;

	public const int JavaGenericServicesFieldNumber = 17;

	public const int PyGenericServicesFieldNumber = 18;

	public const int UninterpretedOptionFieldNumber = 999;

	private static readonly FileOptions defaultInstance;

	private bool hasJavaPackage;

	private string javaPackage_ = "";

	private bool hasJavaOuterClassname;

	private string javaOuterClassname_ = "";

	private bool hasJavaMultipleFiles;

	private bool javaMultipleFiles_;

	private bool hasOptimizeFor;

	private Types.OptimizeMode optimizeFor_ = Types.OptimizeMode.SPEED;

	private bool hasCcGenericServices;

	private bool ccGenericServices_ = true;

	private bool hasJavaGenericServices;

	private bool javaGenericServices_ = true;

	private bool hasPyGenericServices;

	private bool pyGenericServices_ = true;

	private PopsicleList<UninterpretedOption> uninterpretedOption_ = new PopsicleList<UninterpretedOption>();

	private int memoizedSerializedSize = -1;

	public static FileOptions DefaultInstance => defaultInstance;

	public override FileOptions DefaultInstanceForType => defaultInstance;

	protected override FileOptions ThisMessage => this;

	public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_FileOptions__Descriptor;

	protected override FieldAccessorTable<FileOptions, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_FileOptions__FieldAccessorTable;

	public bool HasJavaPackage => hasJavaPackage;

	public string JavaPackage => javaPackage_;

	public bool HasJavaOuterClassname => hasJavaOuterClassname;

	public string JavaOuterClassname => javaOuterClassname_;

	public bool HasJavaMultipleFiles => hasJavaMultipleFiles;

	public bool JavaMultipleFiles => javaMultipleFiles_;

	public bool HasOptimizeFor => hasOptimizeFor;

	public Types.OptimizeMode OptimizeFor => optimizeFor_;

	public bool HasCcGenericServices => hasCcGenericServices;

	public bool CcGenericServices => ccGenericServices_;

	public bool HasJavaGenericServices => hasJavaGenericServices;

	public bool JavaGenericServices => javaGenericServices_;

	public bool HasPyGenericServices => hasPyGenericServices;

	public bool PyGenericServices => pyGenericServices_;

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
			if (HasJavaPackage)
			{
				num += CodedOutputStream.ComputeStringSize(1, JavaPackage);
			}
			if (HasJavaOuterClassname)
			{
				num += CodedOutputStream.ComputeStringSize(8, JavaOuterClassname);
			}
			if (HasJavaMultipleFiles)
			{
				num += CodedOutputStream.ComputeBoolSize(10, JavaMultipleFiles);
			}
			if (HasOptimizeFor)
			{
				num += CodedOutputStream.ComputeEnumSize(9, (int)OptimizeFor);
			}
			if (HasCcGenericServices)
			{
				num += CodedOutputStream.ComputeBoolSize(16, CcGenericServices);
			}
			if (HasJavaGenericServices)
			{
				num += CodedOutputStream.ComputeBoolSize(17, JavaGenericServices);
			}
			if (HasPyGenericServices)
			{
				num += CodedOutputStream.ComputeBoolSize(18, PyGenericServices);
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
		if (HasJavaPackage)
		{
			output.WriteString(1, JavaPackage);
		}
		if (HasJavaOuterClassname)
		{
			output.WriteString(8, JavaOuterClassname);
		}
		if (HasOptimizeFor)
		{
			output.WriteEnum(9, (int)OptimizeFor);
		}
		if (HasJavaMultipleFiles)
		{
			output.WriteBool(10, JavaMultipleFiles);
		}
		if (HasCcGenericServices)
		{
			output.WriteBool(16, CcGenericServices);
		}
		if (HasJavaGenericServices)
		{
			output.WriteBool(17, JavaGenericServices);
		}
		if (HasPyGenericServices)
		{
			output.WriteBool(18, PyGenericServices);
		}
		foreach (UninterpretedOption uninterpretedOption in UninterpretedOptionList)
		{
			output.WriteMessage(999, uninterpretedOption);
		}
		extensionWriter.WriteUntil(536870912, output);
		UnknownFields.WriteTo(output);
	}

	public static FileOptions ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static FileOptions ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static FileOptions ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static FileOptions ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static FileOptions ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static FileOptions ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static FileOptions ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static FileOptions ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static FileOptions ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static FileOptions ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(FileOptions prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static FileOptions()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
	}
}
