using System;
using System.IO;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class CSharpFileOptions : GeneratedMessage<CSharpFileOptions, CSharpFileOptions.Builder>
{
	public sealed class Builder : GeneratedBuilder<CSharpFileOptions, Builder>
	{
		private CSharpFileOptions result = new CSharpFileOptions();

		protected override Builder ThisBuilder => this;

		protected override CSharpFileOptions MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override CSharpFileOptions DefaultInstanceForType => DefaultInstance;

		public bool HasNamespace => result.HasNamespace;

		public string Namespace
		{
			get
			{
				return result.Namespace;
			}
			set
			{
				SetNamespace(value);
			}
		}

		public bool HasUmbrellaClassname => result.HasUmbrellaClassname;

		public string UmbrellaClassname
		{
			get
			{
				return result.UmbrellaClassname;
			}
			set
			{
				SetUmbrellaClassname(value);
			}
		}

		public bool HasPublicClasses => result.HasPublicClasses;

		public bool PublicClasses
		{
			get
			{
				return result.PublicClasses;
			}
			set
			{
				SetPublicClasses(value);
			}
		}

		public bool HasMultipleFiles => result.HasMultipleFiles;

		public bool MultipleFiles
		{
			get
			{
				return result.MultipleFiles;
			}
			set
			{
				SetMultipleFiles(value);
			}
		}

		public bool HasNestClasses => result.HasNestClasses;

		public bool NestClasses
		{
			get
			{
				return result.NestClasses;
			}
			set
			{
				SetNestClasses(value);
			}
		}

		public bool HasCodeContracts => result.HasCodeContracts;

		public bool CodeContracts
		{
			get
			{
				return result.CodeContracts;
			}
			set
			{
				SetCodeContracts(value);
			}
		}

		public bool HasExpandNamespaceDirectories => result.HasExpandNamespaceDirectories;

		public bool ExpandNamespaceDirectories
		{
			get
			{
				return result.ExpandNamespaceDirectories;
			}
			set
			{
				SetExpandNamespaceDirectories(value);
			}
		}

		public bool HasClsCompliance => result.HasClsCompliance;

		public bool ClsCompliance
		{
			get
			{
				return result.ClsCompliance;
			}
			set
			{
				SetClsCompliance(value);
			}
		}

		public bool HasFileExtension => result.HasFileExtension;

		public string FileExtension
		{
			get
			{
				return result.FileExtension;
			}
			set
			{
				SetFileExtension(value);
			}
		}

		public bool HasUmbrellaNamespace => result.HasUmbrellaNamespace;

		public string UmbrellaNamespace
		{
			get
			{
				return result.UmbrellaNamespace;
			}
			set
			{
				SetUmbrellaNamespace(value);
			}
		}

		public bool HasOutputDirectory => result.HasOutputDirectory;

		public string OutputDirectory
		{
			get
			{
				return result.OutputDirectory;
			}
			set
			{
				SetOutputDirectory(value);
			}
		}

		public bool HasIgnoreGoogleProtobuf => result.HasIgnoreGoogleProtobuf;

		public bool IgnoreGoogleProtobuf
		{
			get
			{
				return result.IgnoreGoogleProtobuf;
			}
			set
			{
				SetIgnoreGoogleProtobuf(value);
			}
		}

		public override Builder Clear()
		{
			result = new CSharpFileOptions();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override CSharpFileOptions BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			CSharpFileOptions cSharpFileOptions = result;
			result = null;
			return cSharpFileOptions;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is CSharpFileOptions)
			{
				return MergeFrom((CSharpFileOptions)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(CSharpFileOptions other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasNamespace)
			{
				Namespace = other.Namespace;
			}
			if (other.HasUmbrellaClassname)
			{
				UmbrellaClassname = other.UmbrellaClassname;
			}
			if (other.HasPublicClasses)
			{
				PublicClasses = other.PublicClasses;
			}
			if (other.HasMultipleFiles)
			{
				MultipleFiles = other.MultipleFiles;
			}
			if (other.HasNestClasses)
			{
				NestClasses = other.NestClasses;
			}
			if (other.HasCodeContracts)
			{
				CodeContracts = other.CodeContracts;
			}
			if (other.HasExpandNamespaceDirectories)
			{
				ExpandNamespaceDirectories = other.ExpandNamespaceDirectories;
			}
			if (other.HasClsCompliance)
			{
				ClsCompliance = other.ClsCompliance;
			}
			if (other.HasFileExtension)
			{
				FileExtension = other.FileExtension;
			}
			if (other.HasUmbrellaNamespace)
			{
				UmbrellaNamespace = other.UmbrellaNamespace;
			}
			if (other.HasOutputDirectory)
			{
				OutputDirectory = other.OutputDirectory;
			}
			if (other.HasIgnoreGoogleProtobuf)
			{
				IgnoreGoogleProtobuf = other.IgnoreGoogleProtobuf;
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
					Namespace = input.ReadString();
					continue;
				case 18u:
					UmbrellaClassname = input.ReadString();
					continue;
				case 24u:
					PublicClasses = input.ReadBool();
					continue;
				case 32u:
					MultipleFiles = input.ReadBool();
					continue;
				case 40u:
					NestClasses = input.ReadBool();
					continue;
				case 48u:
					CodeContracts = input.ReadBool();
					continue;
				case 56u:
					ExpandNamespaceDirectories = input.ReadBool();
					continue;
				case 64u:
					ClsCompliance = input.ReadBool();
					continue;
				case 1770u:
					FileExtension = input.ReadString();
					continue;
				case 1778u:
					UmbrellaNamespace = input.ReadString();
					continue;
				case 1786u:
					OutputDirectory = input.ReadString();
					continue;
				case 1792u:
					IgnoreGoogleProtobuf = input.ReadBool();
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

		public Builder SetNamespace(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasNamespace = true;
			result.namespace_ = value;
			return this;
		}

		public Builder ClearNamespace()
		{
			result.hasNamespace = false;
			result.namespace_ = "";
			return this;
		}

		public Builder SetUmbrellaClassname(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasUmbrellaClassname = true;
			result.umbrellaClassname_ = value;
			return this;
		}

		public Builder ClearUmbrellaClassname()
		{
			result.hasUmbrellaClassname = false;
			result.umbrellaClassname_ = "";
			return this;
		}

		public Builder SetPublicClasses(bool value)
		{
			result.hasPublicClasses = true;
			result.publicClasses_ = value;
			return this;
		}

		public Builder ClearPublicClasses()
		{
			result.hasPublicClasses = false;
			result.publicClasses_ = true;
			return this;
		}

		public Builder SetMultipleFiles(bool value)
		{
			result.hasMultipleFiles = true;
			result.multipleFiles_ = value;
			return this;
		}

		public Builder ClearMultipleFiles()
		{
			result.hasMultipleFiles = false;
			result.multipleFiles_ = false;
			return this;
		}

		public Builder SetNestClasses(bool value)
		{
			result.hasNestClasses = true;
			result.nestClasses_ = value;
			return this;
		}

		public Builder ClearNestClasses()
		{
			result.hasNestClasses = false;
			result.nestClasses_ = false;
			return this;
		}

		public Builder SetCodeContracts(bool value)
		{
			result.hasCodeContracts = true;
			result.codeContracts_ = value;
			return this;
		}

		public Builder ClearCodeContracts()
		{
			result.hasCodeContracts = false;
			result.codeContracts_ = false;
			return this;
		}

		public Builder SetExpandNamespaceDirectories(bool value)
		{
			result.hasExpandNamespaceDirectories = true;
			result.expandNamespaceDirectories_ = value;
			return this;
		}

		public Builder ClearExpandNamespaceDirectories()
		{
			result.hasExpandNamespaceDirectories = false;
			result.expandNamespaceDirectories_ = false;
			return this;
		}

		public Builder SetClsCompliance(bool value)
		{
			result.hasClsCompliance = true;
			result.clsCompliance_ = value;
			return this;
		}

		public Builder ClearClsCompliance()
		{
			result.hasClsCompliance = false;
			result.clsCompliance_ = true;
			return this;
		}

		public Builder SetFileExtension(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasFileExtension = true;
			result.fileExtension_ = value;
			return this;
		}

		public Builder ClearFileExtension()
		{
			result.hasFileExtension = false;
			result.fileExtension_ = ".cs";
			return this;
		}

		public Builder SetUmbrellaNamespace(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasUmbrellaNamespace = true;
			result.umbrellaNamespace_ = value;
			return this;
		}

		public Builder ClearUmbrellaNamespace()
		{
			result.hasUmbrellaNamespace = false;
			result.umbrellaNamespace_ = "";
			return this;
		}

		public Builder SetOutputDirectory(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasOutputDirectory = true;
			result.outputDirectory_ = value;
			return this;
		}

		public Builder ClearOutputDirectory()
		{
			result.hasOutputDirectory = false;
			result.outputDirectory_ = ".";
			return this;
		}

		public Builder SetIgnoreGoogleProtobuf(bool value)
		{
			result.hasIgnoreGoogleProtobuf = true;
			result.ignoreGoogleProtobuf_ = value;
			return this;
		}

		public Builder ClearIgnoreGoogleProtobuf()
		{
			result.hasIgnoreGoogleProtobuf = false;
			result.ignoreGoogleProtobuf_ = false;
			return this;
		}
	}

	public const int NamespaceFieldNumber = 1;

	public const int UmbrellaClassnameFieldNumber = 2;

	public const int PublicClassesFieldNumber = 3;

	public const int MultipleFilesFieldNumber = 4;

	public const int NestClassesFieldNumber = 5;

	public const int CodeContractsFieldNumber = 6;

	public const int ExpandNamespaceDirectoriesFieldNumber = 7;

	public const int ClsComplianceFieldNumber = 8;

	public const int FileExtensionFieldNumber = 221;

	public const int UmbrellaNamespaceFieldNumber = 222;

	public const int OutputDirectoryFieldNumber = 223;

	public const int IgnoreGoogleProtobufFieldNumber = 224;

	private static readonly CSharpFileOptions defaultInstance;

	private bool hasNamespace;

	private string namespace_ = "";

	private bool hasUmbrellaClassname;

	private string umbrellaClassname_ = "";

	private bool hasPublicClasses;

	private bool publicClasses_ = true;

	private bool hasMultipleFiles;

	private bool multipleFiles_;

	private bool hasNestClasses;

	private bool nestClasses_;

	private bool hasCodeContracts;

	private bool codeContracts_;

	private bool hasExpandNamespaceDirectories;

	private bool expandNamespaceDirectories_;

	private bool hasClsCompliance;

	private bool clsCompliance_ = true;

	private bool hasFileExtension;

	private string fileExtension_ = ".cs";

	private bool hasUmbrellaNamespace;

	private string umbrellaNamespace_ = "";

	private bool hasOutputDirectory;

	private string outputDirectory_ = ".";

	private bool hasIgnoreGoogleProtobuf;

	private bool ignoreGoogleProtobuf_;

	private int memoizedSerializedSize = -1;

	public static CSharpFileOptions DefaultInstance => defaultInstance;

	public override CSharpFileOptions DefaultInstanceForType => defaultInstance;

	protected override CSharpFileOptions ThisMessage => this;

	public static MessageDescriptor Descriptor => CSharpOptions.internal__static_google_protobuf_CSharpFileOptions__Descriptor;

	protected override FieldAccessorTable<CSharpFileOptions, Builder> InternalFieldAccessors => CSharpOptions.internal__static_google_protobuf_CSharpFileOptions__FieldAccessorTable;

	public bool HasNamespace => hasNamespace;

	public string Namespace => namespace_;

	public bool HasUmbrellaClassname => hasUmbrellaClassname;

	public string UmbrellaClassname => umbrellaClassname_;

	public bool HasPublicClasses => hasPublicClasses;

	public bool PublicClasses => publicClasses_;

	public bool HasMultipleFiles => hasMultipleFiles;

	public bool MultipleFiles => multipleFiles_;

	public bool HasNestClasses => hasNestClasses;

	public bool NestClasses => nestClasses_;

	public bool HasCodeContracts => hasCodeContracts;

	public bool CodeContracts => codeContracts_;

	public bool HasExpandNamespaceDirectories => hasExpandNamespaceDirectories;

	public bool ExpandNamespaceDirectories => expandNamespaceDirectories_;

	public bool HasClsCompliance => hasClsCompliance;

	public bool ClsCompliance => clsCompliance_;

	public bool HasFileExtension => hasFileExtension;

	public string FileExtension => fileExtension_;

	public bool HasUmbrellaNamespace => hasUmbrellaNamespace;

	public string UmbrellaNamespace => umbrellaNamespace_;

	public bool HasOutputDirectory => hasOutputDirectory;

	public string OutputDirectory => outputDirectory_;

	public bool HasIgnoreGoogleProtobuf => hasIgnoreGoogleProtobuf;

	public bool IgnoreGoogleProtobuf => ignoreGoogleProtobuf_;

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
			if (HasNamespace)
			{
				num += CodedOutputStream.ComputeStringSize(1, Namespace);
			}
			if (HasUmbrellaClassname)
			{
				num += CodedOutputStream.ComputeStringSize(2, UmbrellaClassname);
			}
			if (HasPublicClasses)
			{
				num += CodedOutputStream.ComputeBoolSize(3, PublicClasses);
			}
			if (HasMultipleFiles)
			{
				num += CodedOutputStream.ComputeBoolSize(4, MultipleFiles);
			}
			if (HasNestClasses)
			{
				num += CodedOutputStream.ComputeBoolSize(5, NestClasses);
			}
			if (HasCodeContracts)
			{
				num += CodedOutputStream.ComputeBoolSize(6, CodeContracts);
			}
			if (HasExpandNamespaceDirectories)
			{
				num += CodedOutputStream.ComputeBoolSize(7, ExpandNamespaceDirectories);
			}
			if (HasClsCompliance)
			{
				num += CodedOutputStream.ComputeBoolSize(8, ClsCompliance);
			}
			if (HasFileExtension)
			{
				num += CodedOutputStream.ComputeStringSize(221, FileExtension);
			}
			if (HasUmbrellaNamespace)
			{
				num += CodedOutputStream.ComputeStringSize(222, UmbrellaNamespace);
			}
			if (HasOutputDirectory)
			{
				num += CodedOutputStream.ComputeStringSize(223, OutputDirectory);
			}
			if (HasIgnoreGoogleProtobuf)
			{
				num += CodedOutputStream.ComputeBoolSize(224, IgnoreGoogleProtobuf);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasNamespace)
		{
			output.WriteString(1, Namespace);
		}
		if (HasUmbrellaClassname)
		{
			output.WriteString(2, UmbrellaClassname);
		}
		if (HasPublicClasses)
		{
			output.WriteBool(3, PublicClasses);
		}
		if (HasMultipleFiles)
		{
			output.WriteBool(4, MultipleFiles);
		}
		if (HasNestClasses)
		{
			output.WriteBool(5, NestClasses);
		}
		if (HasCodeContracts)
		{
			output.WriteBool(6, CodeContracts);
		}
		if (HasExpandNamespaceDirectories)
		{
			output.WriteBool(7, ExpandNamespaceDirectories);
		}
		if (HasClsCompliance)
		{
			output.WriteBool(8, ClsCompliance);
		}
		if (HasFileExtension)
		{
			output.WriteString(221, FileExtension);
		}
		if (HasUmbrellaNamespace)
		{
			output.WriteString(222, UmbrellaNamespace);
		}
		if (HasOutputDirectory)
		{
			output.WriteString(223, OutputDirectory);
		}
		if (HasIgnoreGoogleProtobuf)
		{
			output.WriteBool(224, IgnoreGoogleProtobuf);
		}
		UnknownFields.WriteTo(output);
	}

	public static CSharpFileOptions ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static CSharpFileOptions ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static CSharpFileOptions ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static CSharpFileOptions ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static CSharpFileOptions ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static CSharpFileOptions ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static CSharpFileOptions ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static CSharpFileOptions ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static CSharpFileOptions ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static CSharpFileOptions ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(CSharpFileOptions prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static CSharpFileOptions()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(CSharpOptions.Descriptor, null);
	}
}
