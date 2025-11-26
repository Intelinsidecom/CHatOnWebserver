using Google.ProtocolBuffers.DescriptorProtos;

namespace Google.ProtocolBuffers.Descriptors;

public sealed class MethodDescriptor : IndexedDescriptorBase<MethodDescriptorProto, MethodOptions>
{
	private readonly ServiceDescriptor service;

	private MessageDescriptor inputType;

	private MessageDescriptor outputType;

	public ServiceDescriptor Service => service;

	public MessageDescriptor InputType => inputType;

	public MessageDescriptor OutputType => outputType;

	internal MethodDescriptor(MethodDescriptorProto proto, FileDescriptor file, ServiceDescriptor parent, int index)
		: base(proto, file, parent.FullName + "." + proto.Name, index)
	{
		service = parent;
		file.DescriptorPool.AddSymbol(this);
	}

	internal void CrossLink()
	{
		IDescriptor descriptor = base.File.DescriptorPool.LookupSymbol(base.Proto.InputType, this);
		if (!(descriptor is MessageDescriptor))
		{
			throw new DescriptorValidationException(this, "\"" + base.Proto.InputType + "\" is not a message type.");
		}
		inputType = (MessageDescriptor)descriptor;
		descriptor = base.File.DescriptorPool.LookupSymbol(base.Proto.OutputType, this);
		if (!(descriptor is MessageDescriptor))
		{
			throw new DescriptorValidationException(this, "\"" + base.Proto.OutputType + "\" is not a message type.");
		}
		outputType = (MessageDescriptor)descriptor;
	}
}
