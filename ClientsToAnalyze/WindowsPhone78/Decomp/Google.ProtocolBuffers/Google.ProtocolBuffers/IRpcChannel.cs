using System;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public interface IRpcChannel
{
	void CallMethod(MethodDescriptor method, IRpcController controller, IMessage request, IMessage responsePrototype, Action<IMessage> done);
}
