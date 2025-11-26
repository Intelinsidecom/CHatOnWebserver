namespace Google.ProtocolBuffers.Descriptors;

public interface IDescriptor
{
	string Name { get; }

	string FullName { get; }

	FileDescriptor File { get; }

	IMessage Proto { get; }
}
public interface IDescriptor<TProto> : IDescriptor where TProto : IMessage
{
	new TProto Proto { get; }
}
