package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public interface Message extends MessageLite, MessageOrBuilder {

    public interface Builder extends MessageLite.Builder, MessageOrBuilder {
        Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        Message build();

        Message buildPartial();

        Builder clear();

        Builder clearField(Descriptors.FieldDescriptor fieldDescriptor);

        /* renamed from: clone */
        Builder m3102clone();

        @Override // com.google.protobuf.MessageOrBuilder
        Descriptors.Descriptor getDescriptorForType();

        boolean mergeDelimitedFrom(InputStream inputStream) throws IOException;

        boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        Builder mergeFrom(ByteString byteString) throws InvalidProtocolBufferException;

        Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        Builder mergeFrom(CodedInputStream codedInputStream) throws IOException;

        Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        Builder mergeFrom(Message message);

        Builder mergeFrom(InputStream inputStream) throws IOException;

        Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        Builder mergeFrom(byte[] bArr) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet);

        Builder newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor);

        Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj);

        Builder setUnknownFields(UnknownFieldSet unknownFieldSet);
    }

    boolean equals(Object obj);

    int hashCode();

    Builder newBuilderForType();

    Builder toBuilder();

    String toString();
}
