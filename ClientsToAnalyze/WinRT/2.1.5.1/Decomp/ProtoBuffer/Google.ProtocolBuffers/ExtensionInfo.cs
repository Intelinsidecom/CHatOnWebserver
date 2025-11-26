using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public sealed class ExtensionInfo : IGeneratedExtensionLite
{
	public FieldDescriptor Descriptor { get; private set; }

	IFieldDescriptorLite IGeneratedExtensionLite.Descriptor => Descriptor;

	public IMessageLite DefaultInstance { get; private set; }

	int IGeneratedExtensionLite.Number => Descriptor.FieldNumber;

	object IGeneratedExtensionLite.ContainingType => Descriptor;

	IMessageLite IGeneratedExtensionLite.MessageDefaultInstance => DefaultInstance;

	internal ExtensionInfo(FieldDescriptor descriptor)
		: this(descriptor, null)
	{
	}

	internal ExtensionInfo(FieldDescriptor descriptor, IMessageLite defaultInstance)
	{
		Descriptor = descriptor;
		DefaultInstance = defaultInstance;
	}
}
