using Google.ProtocolBuffers.DescriptorProtos;

namespace Google.ProtocolBuffers.Descriptors;

public abstract class IndexedDescriptorBase<TProto, TOptions> : DescriptorBase<TProto, TOptions> where TProto : IMessage<TProto>, IDescriptorProto<TOptions>
{
	private readonly int index;

	public int Index => index;

	protected IndexedDescriptorBase(TProto proto, FileDescriptor file, string fullName, int index)
		: base(proto, file, fullName)
	{
		this.index = index;
	}
}
