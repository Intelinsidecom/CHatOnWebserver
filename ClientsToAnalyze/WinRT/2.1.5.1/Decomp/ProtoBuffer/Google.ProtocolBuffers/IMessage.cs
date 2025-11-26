using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public interface IMessage : IMessageLite
{
	MessageDescriptor DescriptorForType { get; }

	IDictionary<FieldDescriptor, object> AllFields { get; }

	object this[FieldDescriptor field] { get; }

	object this[FieldDescriptor field, int index] { get; }

	UnknownFieldSet UnknownFields { get; }

	new bool IsInitialized { get; }

	new int SerializedSize { get; }

	new IMessage WeakDefaultInstanceForType { get; }

	bool HasField(FieldDescriptor field);

	int GetRepeatedFieldCount(FieldDescriptor field);

	new void WriteTo(CodedOutputStream output);

	new void WriteDelimitedTo(Stream output);

	new bool Equals(object other);

	new int GetHashCode();

	new string ToString();

	new ByteString ToByteString();

	new byte[] ToByteArray();

	new void WriteTo(Stream output);

	new IBuilder WeakCreateBuilderForType();

	new IBuilder WeakToBuilder();
}
public interface IMessage<TMessage> : IMessage, IMessageLite<TMessage>, IMessageLite
{
	new TMessage DefaultInstanceForType { get; }
}
public interface IMessage<TMessage, TBuilder> : IMessage<TMessage>, IMessage, IMessageLite<TMessage, TBuilder>, IMessageLite<TMessage>, IMessageLite where TMessage : IMessage<TMessage, TBuilder> where TBuilder : IBuilder<TMessage, TBuilder>
{
	new TBuilder CreateBuilderForType();

	new TBuilder ToBuilder();
}
