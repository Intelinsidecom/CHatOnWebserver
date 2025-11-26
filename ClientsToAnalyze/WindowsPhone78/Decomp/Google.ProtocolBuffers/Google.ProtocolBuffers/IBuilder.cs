using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public interface IBuilder
{
	bool IsInitialized { get; }

	IDictionary<FieldDescriptor, object> AllFields { get; }

	object this[FieldDescriptor field] { get; set; }

	MessageDescriptor DescriptorForType { get; }

	object this[FieldDescriptor field, int index] { get; set; }

	UnknownFieldSet UnknownFields { get; set; }

	IMessage WeakDefaultInstanceForType { get; }

	IBuilder SetField(FieldDescriptor field, object value);

	IBuilder SetRepeatedField(FieldDescriptor field, int index, object value);

	int GetRepeatedFieldCount(FieldDescriptor field);

	bool HasField(FieldDescriptor field);

	IBuilder CreateBuilderForField(FieldDescriptor field);

	IBuilder WeakAddRepeatedField(FieldDescriptor field, object value);

	IBuilder WeakClear();

	IBuilder WeakClearField(FieldDescriptor field);

	IBuilder WeakMergeFrom(IMessage message);

	IBuilder WeakMergeFrom(ByteString data);

	IBuilder WeakMergeFrom(ByteString data, ExtensionRegistry registry);

	IBuilder WeakMergeFrom(CodedInputStream input);

	IBuilder WeakMergeFrom(CodedInputStream input, ExtensionRegistry registry);

	IMessage WeakBuild();

	IMessage WeakBuildPartial();

	IBuilder WeakClone();
}
public interface IBuilder<TMessage, TBuilder> : IBuilder where TMessage : IMessage<TMessage, TBuilder> where TBuilder : IBuilder<TMessage, TBuilder>
{
	TMessage DefaultInstanceForType { get; }

	TBuilder SetUnknownFields(UnknownFieldSet unknownFields);

	TBuilder Clear();

	TBuilder MergeFrom(TMessage other);

	TBuilder MergeFrom(IMessage other);

	TMessage Build();

	TMessage BuildPartial();

	TBuilder Clone();

	TBuilder MergeFrom(CodedInputStream input);

	TBuilder MergeFrom(CodedInputStream input, ExtensionRegistry extensionRegistry);

	TBuilder ClearField(FieldDescriptor field);

	TBuilder AddRepeatedField(FieldDescriptor field, object value);

	TBuilder MergeUnknownFields(UnknownFieldSet unknownFields);

	TBuilder MergeDelimitedFrom(Stream input);

	TBuilder MergeDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry);

	TBuilder MergeFrom(ByteString data);

	TBuilder MergeFrom(ByteString data, ExtensionRegistry extensionRegistry);

	TBuilder MergeFrom(byte[] data);

	TBuilder MergeFrom(byte[] data, ExtensionRegistry extensionRegistry);

	TBuilder MergeFrom(Stream input);

	TBuilder MergeFrom(Stream input, ExtensionRegistry extensionRegistry);
}
