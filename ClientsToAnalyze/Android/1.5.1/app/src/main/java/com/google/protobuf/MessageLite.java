package com.google.protobuf;

import java.io.InputStream;

/* loaded from: classes.dex */
public interface MessageLite {

    public interface Builder extends Cloneable {
        MessageLite build();

        Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        Builder mergeFrom(InputStream inputStream);

        Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

        Builder mergeFrom(byte[] bArr, int i, int i2);

        Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite);
    }

    MessageLite getDefaultInstanceForType();

    int getSerializedSize();

    Builder newBuilderForType();

    byte[] toByteArray();

    void writeTo(CodedOutputStream codedOutputStream);
}
