using System;

namespace Google.ProtocolBuffers.Descriptors;

public sealed class DescriptorValidationException : Exception
{
	private readonly string name;

	private readonly IMessage proto;

	private readonly string description;

	public string ProblemSymbolName => name;

	public IMessage ProblemProto => proto;

	public string Description => description;

	internal DescriptorValidationException(IDescriptor problemDescriptor, string description)
		: base(problemDescriptor.FullName + ": " + description)
	{
		name = problemDescriptor.FullName;
		proto = problemDescriptor.Proto;
		this.description = description;
	}

	internal DescriptorValidationException(IDescriptor problemDescriptor, string description, Exception cause)
		: base(problemDescriptor.FullName + ": " + description, cause)
	{
		name = problemDescriptor.FullName;
		proto = problemDescriptor.Proto;
		this.description = description;
	}
}
