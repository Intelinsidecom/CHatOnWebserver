namespace Google.ProtocolBuffers.Descriptors;

internal sealed class PackageDescriptor : IDescriptor<IMessage>, IDescriptor
{
	private readonly string name;

	private readonly string fullName;

	private readonly FileDescriptor file;

	public IMessage Proto => file.Proto;

	public string Name => name;

	public string FullName => fullName;

	public FileDescriptor File => file;

	internal PackageDescriptor(string name, string fullName, FileDescriptor file)
	{
		this.file = file;
		this.fullName = fullName;
		this.name = name;
	}
}
