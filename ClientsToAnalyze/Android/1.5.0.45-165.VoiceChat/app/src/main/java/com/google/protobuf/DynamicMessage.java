package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Descriptors;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes.dex */
public final class DynamicMessage extends AbstractMessage {
    private final FieldSet<Descriptors.FieldDescriptor> fields;
    private int memoizedSize;
    private final Descriptors.Descriptor type;
    private final UnknownFieldSet unknownFields;

    private DynamicMessage(Descriptors.Descriptor type, FieldSet<Descriptors.FieldDescriptor> fields, UnknownFieldSet unknownFields) {
        this.memoizedSize = -1;
        this.type = type;
        this.fields = fields;
        this.unknownFields = unknownFields;
    }

    /* synthetic */ DynamicMessage(Descriptors.Descriptor descriptor, FieldSet fieldSet, UnknownFieldSet unknownFieldSet, DynamicMessage dynamicMessage) {
        this(descriptor, fieldSet, unknownFieldSet);
    }

    public static DynamicMessage getDefaultInstance(Descriptors.Descriptor type) {
        return new DynamicMessage(type, FieldSet.emptySet(), UnknownFieldSet.getDefaultInstance());
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, CodedInputStream input) throws IOException {
        return newBuilder(type).mergeFrom(input).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, CodedInputStream input, ExtensionRegistry extensionRegistry) throws IOException {
        return newBuilder(type).mergeFrom(input, (ExtensionRegistryLite) extensionRegistry).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, ByteString data) throws InvalidProtocolBufferException {
        return newBuilder(type).mergeFrom(data).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, ByteString data, ExtensionRegistry extensionRegistry) throws InvalidProtocolBufferException {
        return newBuilder(type).mergeFrom(data, (ExtensionRegistryLite) extensionRegistry).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, byte[] data) throws InvalidProtocolBufferException {
        return newBuilder(type).mergeFrom(data).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, byte[] data, ExtensionRegistry extensionRegistry) throws InvalidProtocolBufferException {
        return newBuilder(type).mergeFrom(data, (ExtensionRegistryLite) extensionRegistry).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, InputStream input) throws IOException {
        return newBuilder(type).mergeFrom(input).buildParsed();
    }

    public static DynamicMessage parseFrom(Descriptors.Descriptor type, InputStream input, ExtensionRegistry extensionRegistry) throws IOException {
        return newBuilder(type).mergeFrom(input, (ExtensionRegistryLite) extensionRegistry).buildParsed();
    }

    public static Builder newBuilder(Descriptors.Descriptor type) {
        return new Builder(type, null);
    }

    public static Builder newBuilder(Message prototype) {
        return new Builder(prototype.getDescriptorForType(), null).mergeFrom(prototype);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return this.type;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public DynamicMessage getDefaultInstanceForType() {
        return getDefaultInstance(this.type);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return this.fields.getAllFields();
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor field) {
        verifyContainingType(field);
        return this.fields.hasField(field);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor field) {
        verifyContainingType(field);
        Object result = this.fields.getField(field);
        if (result == null) {
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return getDefaultInstance(field.getMessageType());
            }
            return field.getDefaultValue();
        }
        return result;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
        verifyContainingType(field);
        return this.fields.getRepeatedFieldCount(field);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
        verifyContainingType(field);
        return this.fields.getRepeatedField(field, index);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isInitialized(Descriptors.Descriptor type, FieldSet<Descriptors.FieldDescriptor> fields) {
        for (Descriptors.FieldDescriptor field : type.getFields()) {
            if (field.isRequired() && !fields.hasField(field)) {
                return false;
            }
        }
        return fields.isInitialized();
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return isInitialized(this.type, this.fields);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream output) throws IOException {
        if (this.type.getOptions().getMessageSetWireFormat()) {
            this.fields.writeMessageSetTo(output);
            this.unknownFields.writeAsMessageSetTo(output);
        } else {
            this.fields.writeTo(output);
            this.unknownFields.writeTo(output);
        }
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size;
        int size2 = this.memoizedSize;
        if (size2 != -1) {
            return size2;
        }
        if (this.type.getOptions().getMessageSetWireFormat()) {
            size = this.fields.getMessageSetSerializedSize() + this.unknownFields.getSerializedSizeAsMessageSet();
        } else {
            size = this.fields.getSerializedSize() + this.unknownFields.getSerializedSize();
        }
        this.memoizedSize = size;
        return size;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return new Builder(this.type, null);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return newBuilderForType().mergeFrom((Message) this);
    }

    private void verifyContainingType(Descriptors.FieldDescriptor field) {
        if (field.getContainingType() != this.type) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }

    public static final class Builder extends AbstractMessage.Builder<Builder> {
        private FieldSet<Descriptors.FieldDescriptor> fields;
        private final Descriptors.Descriptor type;
        private UnknownFieldSet unknownFields;

        private Builder(Descriptors.Descriptor type) {
            this.type = type;
            this.fields = FieldSet.newFieldSet();
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
        }

        /* synthetic */ Builder(Descriptors.Descriptor descriptor, Builder builder) {
            this(descriptor);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            if (this.fields == null) {
                throw new IllegalStateException("Cannot call clear() after build().");
            }
            this.fields.clear();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message other) {
            if (!(other instanceof DynamicMessage)) {
                return (Builder) super.mergeFrom(other);
            }
            DynamicMessage otherDynamicMessage = (DynamicMessage) other;
            if (otherDynamicMessage.type == this.type) {
                this.fields.mergeFrom(otherDynamicMessage.fields);
                mergeUnknownFields(otherDynamicMessage.unknownFields);
                return this;
            }
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DynamicMessage build() {
            if (this.fields != null && !isInitialized()) {
                throw newUninitializedMessageException((Message) new DynamicMessage(this.type, this.fields, this.unknownFields, null));
            }
            return buildPartial();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DynamicMessage buildParsed() throws InvalidProtocolBufferException {
            if (!isInitialized()) {
                throw newUninitializedMessageException((Message) new DynamicMessage(this.type, this.fields, this.unknownFields, null)).asInvalidProtocolBufferException();
            }
            return buildPartial();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public DynamicMessage buildPartial() {
            DynamicMessage dynamicMessage = null;
            if (this.fields == null) {
                throw new IllegalStateException("build() has already been called on this Builder.");
            }
            this.fields.makeImmutable();
            DynamicMessage result = new DynamicMessage(this.type, this.fields, this.unknownFields, dynamicMessage);
            this.fields = null;
            this.unknownFields = null;
            return result;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* renamed from: clone */
        public Builder m3102clone() {
            Builder result = new Builder(this.type);
            result.fields.mergeFrom(this.fields);
            return result;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return DynamicMessage.isInitialized(this.type, this.fields);
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return this.type;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DynamicMessage getDefaultInstanceForType() {
            return DynamicMessage.getDefaultInstance(this.type);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return this.fields.getAllFields();
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder newBuilderForField(Descriptors.FieldDescriptor field) {
            verifyContainingType(field);
            if (field.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
            }
            return new Builder(field.getMessageType());
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor field) {
            verifyContainingType(field);
            return this.fields.hasField(field);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor field) {
            verifyContainingType(field);
            Object result = this.fields.getField(field);
            if (result == null) {
                if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return DynamicMessage.getDefaultInstance(field.getMessageType());
                }
                return field.getDefaultValue();
            }
            return result;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor field, Object value) {
            verifyContainingType(field);
            this.fields.setField(field, value);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor field) {
            verifyContainingType(field);
            this.fields.clearField(field);
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
            verifyContainingType(field);
            return this.fields.getRepeatedFieldCount(field);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
            verifyContainingType(field);
            return this.fields.getRepeatedField(field, index);
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            verifyContainingType(field);
            this.fields.setRepeatedField(field, index, value);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            verifyContainingType(field);
            this.fields.addRepeatedField(field, value);
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        @Override // com.google.protobuf.Message.Builder
        public Builder setUnknownFields(UnknownFieldSet unknownFields) {
            this.unknownFields = unknownFields;
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFields).build();
            return this;
        }

        private void verifyContainingType(Descriptors.FieldDescriptor field) {
            if (field.getContainingType() != this.type) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }
}
