using System;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public interface IService
{
	ServiceDescriptor DescriptorForType { get; }

	void CallMethod(MethodDescriptor method, IRpcController controller, IMessage request, Action<IMessage> done);

	IMessage GetRequestPrototype(MethodDescriptor method);

	IMessage GetResponsePrototype(MethodDescriptor method);
}
