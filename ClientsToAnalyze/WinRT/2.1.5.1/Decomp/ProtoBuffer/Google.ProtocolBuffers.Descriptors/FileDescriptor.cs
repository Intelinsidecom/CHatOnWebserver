using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using Google.ProtocolBuffers.DescriptorProtos;

namespace Google.ProtocolBuffers.Descriptors;

public sealed class FileDescriptor : IDescriptor<FileDescriptorProto>, IDescriptor
{
	public delegate ExtensionRegistry InternalDescriptorAssigner(FileDescriptor descriptor);

	private FileDescriptorProto proto;

	private readonly IList<MessageDescriptor> messageTypes;

	private readonly IList<EnumDescriptor> enumTypes;

	private readonly IList<ServiceDescriptor> services;

	private readonly IList<FieldDescriptor> extensions;

	private readonly IList<FileDescriptor> dependencies;

	private readonly DescriptorPool pool;

	private CSharpFileOptions csharpFileOptions;

	private readonly object optionsLock = new object();

	public FileDescriptorProto Proto => proto;

	public Google.ProtocolBuffers.DescriptorProtos.FileOptions Options => proto.Options;

	public CSharpFileOptions CSharpOptions
	{
		get
		{
			lock (optionsLock)
			{
				if (csharpFileOptions == null)
				{
					csharpFileOptions = BuildOrFakeWithDefaultOptions(CSharpFileOptions.DefaultInstance);
				}
			}
			return csharpFileOptions;
		}
	}

	public string Name => proto.Name;

	public string Package => proto.Package;

	public IList<MessageDescriptor> MessageTypes => messageTypes;

	public IList<EnumDescriptor> EnumTypes => enumTypes;

	public IList<ServiceDescriptor> Services => services;

	public IList<FieldDescriptor> Extensions => extensions;

	public IList<FileDescriptor> Dependencies => dependencies;

	string IDescriptor.FullName => Name;

	FileDescriptor IDescriptor.File => this;

	IMessage IDescriptor.Proto => Proto;

	internal DescriptorPool DescriptorPool => pool;

	private FileDescriptor(FileDescriptorProto proto, FileDescriptor[] dependencies, DescriptorPool pool)
	{
		this.pool = pool;
		this.proto = proto;
		this.dependencies = new ReadOnlyCollection<FileDescriptor>((FileDescriptor[])dependencies.Clone());
		pool.AddPackage(Package, this);
		IList<DescriptorProto> messageTypeList = proto.MessageTypeList;
		DescriptorUtil.IndexedConverter<DescriptorProto, MessageDescriptor> converter = (DescriptorProto message, int index) => new MessageDescriptor(message, this, null, index);
		messageTypes = DescriptorUtil.ConvertAndMakeReadOnly(messageTypeList, converter);
		enumTypes = DescriptorUtil.ConvertAndMakeReadOnly(proto.EnumTypeList, (EnumDescriptorProto enumType, int index) => new EnumDescriptor(enumType, this, null, index));
		services = DescriptorUtil.ConvertAndMakeReadOnly(proto.ServiceList, (ServiceDescriptorProto service, int index) => new ServiceDescriptor(service, this, index));
		extensions = DescriptorUtil.ConvertAndMakeReadOnly(proto.ExtensionList, (FieldDescriptorProto field, int index) => new FieldDescriptor(field, this, null, index, isExtension: true));
	}

	internal void ConfigureWithDefaultOptions(CSharpFileOptions options)
	{
		csharpFileOptions = BuildOrFakeWithDefaultOptions(options);
	}

	private CSharpFileOptions BuildOrFakeWithDefaultOptions(CSharpFileOptions defaultOptions)
	{
		if (proto.Package == "google.protobuf")
		{
			string fileName = Path.GetFileName(proto.Name);
			if (fileName == "descriptor.proto")
			{
				CSharpFileOptions.Builder builder = new CSharpFileOptions.Builder();
				builder.Namespace = "Google.ProtocolBuffers.DescriptorProtos";
				builder.UmbrellaClassname = "DescriptorProtoFile";
				builder.NestClasses = false;
				builder.MultipleFiles = false;
				builder.PublicClasses = true;
				builder.OutputDirectory = defaultOptions.OutputDirectory;
				builder.IgnoreGoogleProtobuf = defaultOptions.IgnoreGoogleProtobuf;
				return builder.Build();
			}
			if (fileName == "csharp_options.proto")
			{
				CSharpFileOptions.Builder builder2 = new CSharpFileOptions.Builder();
				builder2.Namespace = "Google.ProtocolBuffers.DescriptorProtos";
				builder2.UmbrellaClassname = "CSharpOptions";
				builder2.NestClasses = false;
				builder2.MultipleFiles = false;
				builder2.PublicClasses = true;
				builder2.OutputDirectory = defaultOptions.OutputDirectory;
				builder2.IgnoreGoogleProtobuf = defaultOptions.IgnoreGoogleProtobuf;
				return builder2.Build();
			}
		}
		CSharpFileOptions.Builder builder3 = defaultOptions.ToBuilder();
		if (proto.Options.HasExtension(Google.ProtocolBuffers.DescriptorProtos.CSharpOptions.CSharpFileOptions))
		{
			builder3.MergeFrom(proto.Options.GetExtension(Google.ProtocolBuffers.DescriptorProtos.CSharpOptions.CSharpFileOptions));
		}
		if (!builder3.HasNamespace)
		{
			builder3.Namespace = Package;
		}
		if (!builder3.HasUmbrellaClassname)
		{
			int num = Name.LastIndexOf('/');
			string text = Name.Substring(num + 1);
			builder3.UmbrellaClassname = NameHelpers.UnderscoresToPascalCase(NameHelpers.StripProto(text));
		}
		if (!builder3.NestClasses && !builder3.HasUmbrellaNamespace)
		{
			bool flag = false;
			foreach (MessageDescriptor messageType in MessageTypes)
			{
				flag |= ((IDescriptor)messageType).Name == builder3.UmbrellaClassname;
			}
			foreach (ServiceDescriptor service in Services)
			{
				flag |= ((IDescriptor)service).Name == builder3.UmbrellaClassname;
			}
			foreach (EnumDescriptor enumType in EnumTypes)
			{
				flag |= ((IDescriptor)enumType).Name == builder3.UmbrellaClassname;
			}
			if (flag)
			{
				builder3.UmbrellaNamespace = "Proto";
			}
		}
		return builder3.Build();
	}

	public T FindTypeByName<T>(string name) where T : class, IDescriptor
	{
		if (name.IndexOf('.') != -1)
		{
			return null;
		}
		if (Package.Length > 0)
		{
			name = Package + "." + name;
		}
		T val = pool.FindSymbol<T>(name);
		if (val != null && val.File == this)
		{
			return val;
		}
		return null;
	}

	public static FileDescriptor BuildFrom(FileDescriptorProto proto, FileDescriptor[] dependencies)
	{
		if (dependencies == null)
		{
			dependencies = new FileDescriptor[0];
		}
		DescriptorPool descriptorPool = new DescriptorPool(dependencies);
		FileDescriptor fileDescriptor = new FileDescriptor(proto, dependencies, descriptorPool);
		if (dependencies.Length != proto.DependencyCount)
		{
			throw new DescriptorValidationException(fileDescriptor, "Dependencies passed to FileDescriptor.BuildFrom() don't match those listed in the FileDescriptorProto.");
		}
		for (int i = 0; i < proto.DependencyCount; i++)
		{
			if (dependencies[i].Name != proto.DependencyList[i])
			{
				throw new DescriptorValidationException(fileDescriptor, "Dependencies passed to FileDescriptor.BuildFrom() don't match those listed in the FileDescriptorProto.");
			}
		}
		fileDescriptor.CrossLink();
		return fileDescriptor;
	}

	private void CrossLink()
	{
		foreach (MessageDescriptor messageType in messageTypes)
		{
			messageType.CrossLink();
		}
		foreach (ServiceDescriptor service in services)
		{
			service.CrossLink();
		}
		foreach (FieldDescriptor extension in extensions)
		{
			extension.CrossLink();
		}
		foreach (MessageDescriptor messageType2 in messageTypes)
		{
			messageType2.CheckRequiredFields();
		}
	}

	public static FileDescriptor InternalBuildGeneratedFileFrom(byte[] descriptorData, FileDescriptor[] dependencies)
	{
		return InternalBuildGeneratedFileFrom(descriptorData, dependencies, (FileDescriptor x) => (ExtensionRegistry)null);
	}

	public static FileDescriptor InternalBuildGeneratedFileFrom(byte[] descriptorData, FileDescriptor[] dependencies, InternalDescriptorAssigner descriptorAssigner)
	{
		FileDescriptorProto fileDescriptorProto;
		try
		{
			fileDescriptorProto = FileDescriptorProto.ParseFrom(descriptorData);
		}
		catch (InvalidProtocolBufferException innerException)
		{
			throw new ArgumentException("Failed to parse protocol buffer descriptor for generated code.", innerException);
		}
		FileDescriptor fileDescriptor;
		try
		{
			fileDescriptor = BuildFrom(fileDescriptorProto, dependencies);
		}
		catch (DescriptorValidationException innerException2)
		{
			throw new ArgumentException("Invalid embedded descriptor for \"" + fileDescriptorProto.Name + "\".", innerException2);
		}
		ExtensionRegistry extensionRegistry = descriptorAssigner(fileDescriptor);
		if (extensionRegistry != null)
		{
			try
			{
				fileDescriptorProto = FileDescriptorProto.ParseFrom(descriptorData, extensionRegistry);
			}
			catch (InvalidProtocolBufferException innerException3)
			{
				throw new ArgumentException("Failed to parse protocol buffer descriptor for generated code.", innerException3);
			}
			fileDescriptor.ReplaceProto(fileDescriptorProto);
		}
		return fileDescriptor;
	}

	private void ReplaceProto(FileDescriptorProto newProto)
	{
		proto = newProto;
		for (int i = 0; i < messageTypes.Count; i++)
		{
			messageTypes[i].ReplaceProto(proto.GetMessageType(i));
		}
		for (int j = 0; j < enumTypes.Count; j++)
		{
			enumTypes[j].ReplaceProto(proto.GetEnumType(j));
		}
		for (int k = 0; k < services.Count; k++)
		{
			services[k].ReplaceProto(proto.GetService(k));
		}
		for (int l = 0; l < extensions.Count; l++)
		{
			extensions[l].ReplaceProto(proto.GetExtension(l));
		}
	}
}
