using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public interface IMessage
{
	MessageDescriptor DescriptorForType { get; }

	IDictionary<FieldDescriptor, object> AllFields { get; }

	object this[FieldDescriptor field] { get; }

	object this[FieldDescriptor field, int index] { get; }

	UnknownFieldSet UnknownFields { get; }

	bool IsInitialized { get; }

	int SerializedSize { get; }

	IMessage WeakDefaultInstanceForType { get; }

	bool HasField(FieldDescriptor field);

	int GetRepeatedFieldCount(FieldDescriptor field);

	void WriteTo(CodedOutputStream output);

	void WriteDelimitedTo(Stream output);

	new bool Equals(object other);

	new int GetHashCode();

	new string ToString();

	ByteString ToByteString();

	byte[] ToByteArray();

	void WriteTo(Stream output);

	IBuilder WeakCreateBuilderForType();

	IBuilder WeakToBuilder();
}
public interface IMessage<TMessage> : IMessage
{
	TMessage DefaultInstanceForType { get; }
}
public interface IMessage<TMessage, TBuilder> : IMessage<TMessage>, IMessage where TMessage : IMessage<TMessage, TBuilder> where TBuilder : IBuilder<TMessage, TBuilder>
{
	TBuilder CreateBuilderForType();

	TBuilder ToBuilder();
}
