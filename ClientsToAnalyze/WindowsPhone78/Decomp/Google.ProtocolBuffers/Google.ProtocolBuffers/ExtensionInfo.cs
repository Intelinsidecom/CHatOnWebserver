using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public sealed class ExtensionInfo
{
	public FieldDescriptor Descriptor { get; private set; }

	public IMessage DefaultInstance { get; private set; }

	internal ExtensionInfo(FieldDescriptor descriptor)
		: this(descriptor, null)
	{
	}

	internal ExtensionInfo(FieldDescriptor descriptor, IMessage defaultInstance)
	{
		Descriptor = descriptor;
		DefaultInstance = defaultInstance;
	}
}
