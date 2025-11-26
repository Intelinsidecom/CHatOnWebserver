using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public interface IBuilder : IBuilderLite
{
	new bool IsInitialized { get; }

	IDictionary<FieldDescriptor, object> AllFields { get; }

	object this[FieldDescriptor field] { get; set; }

	MessageDescriptor DescriptorForType { get; }

	object this[FieldDescriptor field, int index] { get; set; }

	UnknownFieldSet UnknownFields { get; set; }

	new IMessage WeakDefaultInstanceForType { get; }

	IBuilder SetField(FieldDescriptor field, object value);

	IBuilder SetRepeatedField(FieldDescriptor field, int index, object value);

	int GetRepeatedFieldCount(FieldDescriptor field);

	bool HasField(FieldDescriptor field);

	IBuilder CreateBuilderForField(FieldDescriptor field);

	IBuilder WeakAddRepeatedField(FieldDescriptor field, object value);

	new IBuilder WeakClear();

	IBuilder WeakClearField(FieldDescriptor field);

	IBuilder WeakMergeFrom(IMessage message);

	new IBuilder WeakMergeFrom(ByteString data);

	new IBuilder WeakMergeFrom(ByteString data, ExtensionRegistry registry);

	new IBuilder WeakMergeFrom(CodedInputStream input);

	new IBuilder WeakMergeFrom(CodedInputStream input, ExtensionRegistry registry);

	new IMessage WeakBuild();

	new IMessage WeakBuildPartial();

	new IBuilder WeakClone();
}
public interface IBuilder<TMessage, TBuilder> : IBuilder, IBuilderLite<TMessage, TBuilder>, IBuilderLite where TMessage : IMessage<TMessage, TBuilder> where TBuilder : IBuilder<TMessage, TBuilder>
{
	new TMessage DefaultInstanceForType { get; }

	TBuilder SetUnknownFields(UnknownFieldSet unknownFields);

	new TBuilder Clear();

	TBuilder MergeFrom(IMessage other);

	new TMessage Build();

	new TMessage BuildPartial();

	new TBuilder Clone();

	new TBuilder MergeFrom(CodedInputStream input);

	new TBuilder MergeFrom(CodedInputStream input, ExtensionRegistry extensionRegistry);

	TBuilder ClearField(FieldDescriptor field);

	TBuilder AddRepeatedField(FieldDescriptor field, object value);

	TBuilder MergeUnknownFields(UnknownFieldSet unknownFields);

	new TBuilder MergeDelimitedFrom(Stream input);

	new TBuilder MergeDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry);

	new TBuilder MergeFrom(ByteString data);

	new TBuilder MergeFrom(ByteString data, ExtensionRegistry extensionRegistry);

	new TBuilder MergeFrom(byte[] data);

	new TBuilder MergeFrom(byte[] data, ExtensionRegistry extensionRegistry);

	new TBuilder MergeFrom(Stream input);

	new TBuilder MergeFrom(Stream input, ExtensionRegistry extensionRegistry);
}
