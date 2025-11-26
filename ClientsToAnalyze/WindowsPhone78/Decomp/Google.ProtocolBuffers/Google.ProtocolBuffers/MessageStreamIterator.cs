using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Reflection;

namespace Google.ProtocolBuffers;

public class MessageStreamIterator<TMessage> : IEnumerable<TMessage>, IEnumerable where TMessage : IMessage<TMessage>
{
	private readonly StreamProvider streamProvider;

	private readonly ExtensionRegistry extensionRegistry;

	private readonly int sizeLimit;

	private static readonly Type[] EmptyTypes = new Type[0];

	private static readonly Func<CodedInputStream, ExtensionRegistry, TMessage> messageReader = BuildMessageReader();

	private static Exception typeInitializationException;

	private static readonly uint ExpectedTag = WireFormat.MakeTag(1, WireFormat.WireType.LengthDelimited);

	private static Func<CodedInputStream, ExtensionRegistry, TMessage> BuildMessageReader()
	{
		try
		{
			Type type = FindBuilderType();
			MethodInfo method = typeof(TMessage).GetMethod("CreateBuilder", EmptyTypes);
			Delegate firstArgument = Delegate.CreateDelegate(typeof(Func<>).MakeGenericType(type), null, method);
			MethodInfo method2 = typeof(MessageStreamIterator<TMessage>).GetMethod("BuildImpl", BindingFlags.Static | BindingFlags.NonPublic).MakeGenericMethod(typeof(TMessage), type);
			return (Func<CodedInputStream, ExtensionRegistry, TMessage>)Delegate.CreateDelegate(typeof(Func<CodedInputStream, ExtensionRegistry, TMessage>), firstArgument, method2);
		}
		catch (ArgumentException ex)
		{
			typeInitializationException = ex;
		}
		catch (InvalidOperationException ex2)
		{
			typeInitializationException = ex2;
		}
		catch (InvalidCastException ex3)
		{
			typeInitializationException = ex3;
		}
		return null;
	}

	private static Type FindBuilderType()
	{
		MethodInfo method = typeof(TMessage).GetMethod("CreateBuilder", EmptyTypes);
		if ((object)method == null)
		{
			throw new ArgumentException("Message type " + typeof(TMessage).FullName + " has no CreateBuilder method.");
		}
		if ((object)method.ReturnType == typeof(void))
		{
			throw new ArgumentException("CreateBuilder method in " + typeof(TMessage).FullName + " has void return type");
		}
		Type returnType = method.ReturnType;
		Type type = typeof(IMessage<, >).MakeGenericType(typeof(TMessage), returnType);
		Type type2 = typeof(IBuilder<, >).MakeGenericType(typeof(TMessage), returnType);
		if (Array.IndexOf(typeof(TMessage).GetInterfaces(), type) == -1)
		{
			throw new ArgumentException(string.Concat("Message type ", typeof(TMessage), " doesn't implement ", type.FullName));
		}
		if (Array.IndexOf(returnType.GetInterfaces(), type2) == -1)
		{
			throw new ArgumentException(string.Concat("Builder type ", typeof(TMessage), " doesn't implement ", type2.FullName));
		}
		return returnType;
	}

	private static TMessage BuildImpl<TMessage2, TBuilder>(Func<TBuilder> builderBuilder, CodedInputStream input, ExtensionRegistry registry) where TMessage2 : TMessage, IMessage<TMessage2, TBuilder> where TBuilder : IBuilder<TMessage2, TBuilder>
	{
		TBuilder val = builderBuilder();
		input.ReadMessage(val, registry);
		return (TMessage)(object)val.Build();
	}

	private MessageStreamIterator(StreamProvider streamProvider, ExtensionRegistry extensionRegistry, int sizeLimit)
	{
		if (messageReader == null)
		{
			throw typeInitializationException;
		}
		this.streamProvider = streamProvider;
		this.extensionRegistry = extensionRegistry;
		this.sizeLimit = sizeLimit;
	}

	private MessageStreamIterator(StreamProvider streamProvider, ExtensionRegistry extensionRegistry)
		: this(streamProvider, extensionRegistry, 67108864)
	{
	}

	public MessageStreamIterator<TMessage> WithExtensionRegistry(ExtensionRegistry newRegistry)
	{
		return new MessageStreamIterator<TMessage>(streamProvider, newRegistry, sizeLimit);
	}

	public MessageStreamIterator<TMessage> WithSizeLimit(int newSizeLimit)
	{
		return new MessageStreamIterator<TMessage>(streamProvider, extensionRegistry, newSizeLimit);
	}

	public static MessageStreamIterator<TMessage> FromFile(string file)
	{
		return new MessageStreamIterator<TMessage>(() => File.OpenRead(file), ExtensionRegistry.Empty);
	}

	public static MessageStreamIterator<TMessage> FromStreamProvider(StreamProvider streamProvider)
	{
		return new MessageStreamIterator<TMessage>(streamProvider, ExtensionRegistry.Empty);
	}

	public IEnumerator<TMessage> GetEnumerator()
	{
		using Stream stream = streamProvider();
		CodedInputStream input = CodedInputStream.CreateInstance(stream);
		input.SetSizeLimit(sizeLimit);
		while (true)
		{
			uint num;
			uint tag = (num = input.ReadTag());
			if (num != 0)
			{
				if (tag != ExpectedTag)
				{
					throw InvalidProtocolBufferException.InvalidMessageStreamTag();
				}
				yield return messageReader(input, extensionRegistry);
				input.ResetSizeCounter();
				continue;
			}
			break;
		}
	}

	IEnumerator IEnumerable.GetEnumerator()
	{
		return GetEnumerator();
	}
}
