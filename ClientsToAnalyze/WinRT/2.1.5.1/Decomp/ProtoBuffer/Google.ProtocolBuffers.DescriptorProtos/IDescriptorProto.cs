namespace Google.ProtocolBuffers.DescriptorProtos;

public interface IDescriptorProto<TOptions>
{
	string Name { get; }

	TOptions Options { get; }
}
