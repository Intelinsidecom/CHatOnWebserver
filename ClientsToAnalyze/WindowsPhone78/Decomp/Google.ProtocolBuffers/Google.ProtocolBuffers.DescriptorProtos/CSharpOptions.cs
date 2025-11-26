using System;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public static class CSharpOptions
{
	public const int CSharpFileOptionsFieldNumber = 1000;

	public const int CSharpFieldOptionsFieldNumber = 1000;

	public static GeneratedExtensionBase<CSharpFileOptions> CSharpFileOptions;

	public static GeneratedExtensionBase<CSharpFieldOptions> CSharpFieldOptions;

	internal static MessageDescriptor internal__static_google_protobuf_CSharpFileOptions__Descriptor;

	internal static FieldAccessorTable<CSharpFileOptions, CSharpFileOptions.Builder> internal__static_google_protobuf_CSharpFileOptions__FieldAccessorTable;

	internal static MessageDescriptor internal__static_google_protobuf_CSharpFieldOptions__Descriptor;

	internal static FieldAccessorTable<CSharpFieldOptions, CSharpFieldOptions.Builder> internal__static_google_protobuf_CSharpFieldOptions__FieldAccessorTable;

	private static FileDescriptor descriptor;

	public static FileDescriptor Descriptor => descriptor;

	public static void RegisterAllExtensions(ExtensionRegistry registry)
	{
		registry.Add(CSharpFileOptions);
		registry.Add(CSharpFieldOptions);
	}

	static CSharpOptions()
	{
		byte[] descriptorData = Convert.FromBase64String("CiRnb29nbGUvcHJvdG9idWYvY3NoYXJwX29wdGlvbnMucHJvdG8SD2dvb2dsZS5wcm90b2J1ZhogZ29vZ2xlL3Byb3RvYnVmL2Rlc2NyaXB0b3IucHJvdG8izAEKEUNTaGFycEZpbGVPcHRpb25zEhEKCW5hbWVzcGFjZRgBIAEoCRIaChJ1bWJyZWxsYV9jbGFzc25hbWUYAiABKAkSHAoOcHVibGljX2NsYXNzZXMYAyABKAg6BHRydWUSFgoObXVsdGlwbGVfZmlsZXMYBCABKAgSFAoMbmVzdF9jbGFzc2VzGAUgASgIEhYKDmNvZGVfY29udHJhY3RzGAYgASgIEiQKHGV4cGFuZF9uYW1lc3BhY2VfZGlyZWN0b3JpZXMYByABKAgiKwoSQ1NoYXJwRmllbGRPcHRpb25zEhUKDXByb3BlcnR5X25hbWUYASABKAk6XgoTY3NoYXJwX2ZpbGVfb3B0aW9ucxIcLmdvb2dsZS5wcm90b2J1Zi5GaWxlT3B0aW9ucxjoByABKAsyIi5nb29nbGUucHJvdG9idWYuQ1NoYXJwRmlsZU9wdGlvbnM6YQoUY3NoYXJwX2ZpZWxkX29wdGlvbnMSHS5nb29nbGUucHJvdG9idWYuRmllbGRPcHRpb25zGOgHIAEoCzIjLmdvb2dsZS5wcm90b2J1Zi5DU2hhcnBGaWVsZE9wdGlvbnM=");
		FileDescriptor.InternalDescriptorAssigner descriptorAssigner = delegate(FileDescriptor root)
		{
			descriptor = root;
			internal__static_google_protobuf_CSharpFileOptions__Descriptor = Descriptor.MessageTypes[0];
			internal__static_google_protobuf_CSharpFileOptions__FieldAccessorTable = new FieldAccessorTable<CSharpFileOptions, CSharpFileOptions.Builder>(internal__static_google_protobuf_CSharpFileOptions__Descriptor, new string[7] { "Namespace", "UmbrellaClassname", "PublicClasses", "MultipleFiles", "NestClasses", "CodeContracts", "ExpandNamespaceDirectories" });
			internal__static_google_protobuf_CSharpFieldOptions__Descriptor = Descriptor.MessageTypes[1];
			internal__static_google_protobuf_CSharpFieldOptions__FieldAccessorTable = new FieldAccessorTable<CSharpFieldOptions, CSharpFieldOptions.Builder>(internal__static_google_protobuf_CSharpFieldOptions__Descriptor, new string[1] { "PropertyName" });
			CSharpFileOptions = GeneratedSingleExtension<Google.ProtocolBuffers.DescriptorProtos.CSharpFileOptions>.CreateInstance(Descriptor.Extensions[0]);
			CSharpFieldOptions = GeneratedSingleExtension<Google.ProtocolBuffers.DescriptorProtos.CSharpFieldOptions>.CreateInstance(Descriptor.Extensions[1]);
			return (ExtensionRegistry)null;
		};
		FileDescriptor.InternalBuildGeneratedFileFrom(descriptorData, new FileDescriptor[1] { DescriptorProtoFile.Descriptor }, descriptorAssigner);
	}
}
