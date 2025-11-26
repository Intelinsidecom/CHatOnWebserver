using System.IO;

namespace Google.ProtocolBuffers;

public interface IMessageLite
{
	bool IsInitialized { get; }

	int SerializedSize { get; }

	IMessageLite WeakDefaultInstanceForType { get; }

	void WriteTo(CodedOutputStream output);

	void WriteDelimitedTo(Stream output);

	new bool Equals(object other);

	new int GetHashCode();

	new string ToString();

	void PrintTo(TextWriter writer);

	ByteString ToByteString();

	byte[] ToByteArray();

	void WriteTo(Stream output);

	IBuilderLite WeakCreateBuilderForType();

	IBuilderLite WeakToBuilder();
}
public interface IMessageLite<TMessage> : IMessageLite
{
	TMessage DefaultInstanceForType { get; }
}
public interface IMessageLite<TMessage, TBuilder> : IMessageLite<TMessage>, IMessageLite where TMessage : IMessageLite<TMessage, TBuilder> where TBuilder : IBuilderLite<TMessage, TBuilder>
{
	TBuilder CreateBuilderForType();

	TBuilder ToBuilder();
}
