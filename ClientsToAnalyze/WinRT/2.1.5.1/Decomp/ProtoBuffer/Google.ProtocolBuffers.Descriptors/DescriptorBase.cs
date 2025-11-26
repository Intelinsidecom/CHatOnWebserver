using Google.ProtocolBuffers.DescriptorProtos;

namespace Google.ProtocolBuffers.Descriptors;

public abstract class DescriptorBase<TProto, TOptions> : IDescriptor<TProto>, IDescriptor where TProto : IMessage, IDescriptorProto<TOptions>
{
	private TProto proto;

	private readonly FileDescriptor file;

	private readonly string fullName;

	IMessage IDescriptor.Proto => proto;

	public TProto Proto => proto;

	public TOptions Options => proto.Options;

	public string FullName => fullName;

	public string Name => proto.Name;

	public FileDescriptor File => file;

	protected DescriptorBase(TProto proto, FileDescriptor file, string fullName)
	{
		this.proto = proto;
		this.file = file;
		this.fullName = fullName;
	}

	internal virtual void ReplaceProto(TProto newProto)
	{
		proto = newProto;
	}

	protected static string ComputeFullName(FileDescriptor file, MessageDescriptor parent, string name)
	{
		if (parent != null)
		{
			return parent.FullName + "." + name;
		}
		if (file.Package.Length > 0)
		{
			return file.Package + "." + name;
		}
		return name;
	}
}
