using System;

namespace Google.ProtocolBuffers;

public static class RpcUtil
{
	public static Action<T> SpecializeCallback<T>(Action<IMessage> action) where T : IMessage<T>
	{
		return delegate(T message)
		{
			action(message);
		};
	}

	public static Action<IMessage> GeneralizeCallback<TMessage, TBuilder>(Action<TMessage> action, TMessage defaultInstance) where TMessage : class, IMessage<TMessage, TBuilder> where TBuilder : IBuilder<TMessage, TBuilder>
	{
		return delegate(IMessage message)
		{
			TMessage val = message as TMessage;
			if (val == null)
			{
				val = defaultInstance.CreateBuilderForType().MergeFrom(message).Build();
			}
			action(val);
		};
	}
}
