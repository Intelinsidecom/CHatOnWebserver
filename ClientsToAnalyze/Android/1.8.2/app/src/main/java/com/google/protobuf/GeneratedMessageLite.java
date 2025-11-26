package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {
    private static final long serialVersionUID = 1;

    public interface ExtendableMessageOrBuilder extends MessageLiteOrBuilder {
        Object getExtension(GeneratedExtension generatedExtension);

        Object getExtension(GeneratedExtension generatedExtension, int i);

        int getExtensionCount(GeneratedExtension generatedExtension);

        boolean hasExtension(GeneratedExtension generatedExtension);
    }

    protected GeneratedMessageLite() {
    }

    protected GeneratedMessageLite(Builder builder) {
    }

    public abstract class Builder extends AbstractMessageLite.Builder {
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public abstract GeneratedMessageLite getDefaultInstanceForType();

        public abstract Builder mergeFrom(GeneratedMessageLite generatedMessageLite);

        protected Builder() {
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder clear() {
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo7542clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        protected boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) {
            return codedInputStream.skipField(i);
        }
    }

    public abstract class ExtendableMessage extends GeneratedMessageLite implements ExtendableMessageOrBuilder {
        private final FieldSet extensions;

        protected ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        protected ExtendableMessage(ExtendableBuilder extendableBuilder) {
            this.extensions = extendableBuilder.buildExtensions();
        }

        private void verifyExtensionContainingType(GeneratedExtension generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final boolean hasExtension(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(generatedExtension.descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final int getExtensionCount(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedFieldCount(generatedExtension.descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final Object getExtension(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Object field = this.extensions.getField(generatedExtension.descriptor);
            if (field != null) {
                return field;
            }
            return generatedExtension.defaultValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final Object getExtension(GeneratedExtension generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedField(generatedExtension.descriptor, i);
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public class ExtensionWriter {
            private final Iterator iter;
            private final boolean messageSetWireFormat;
            private Map.Entry next;

            private ExtensionWriter(boolean z) {
                this.iter = ExtendableMessage.this.extensions.iterator();
                if (this.iter.hasNext()) {
                    this.next = (Map.Entry) this.iter.next();
                }
                this.messageSetWireFormat = z;
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (this.next != null && ((ExtensionDescriptor) this.next.getKey()).getNumber() < i) {
                    ExtensionDescriptor extensionDescriptor = (ExtensionDescriptor) this.next.getKey();
                    if (this.messageSetWireFormat && extensionDescriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !extensionDescriptor.isRepeated()) {
                        codedOutputStream.writeMessageSetExtension(extensionDescriptor.getNumber(), (MessageLite) this.next.getValue());
                    } else {
                        FieldSet.writeField(extensionDescriptor, this.next.getValue(), codedOutputStream);
                    }
                    if (this.iter.hasNext()) {
                        this.next = (Map.Entry) this.iter.next();
                    } else {
                        this.next = null;
                    }
                }
            }
        }

        protected ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(false);
        }

        protected ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(true);
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }
    }

    public abstract class ExtendableBuilder extends Builder implements ExtendableMessageOrBuilder {
        private FieldSet extensions = FieldSet.emptySet();
        private boolean extensionsIsMutable;

        protected ExtendableBuilder() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public ExtendableBuilder clear() {
            this.extensions.clear();
            this.extensionsIsMutable = false;
            return (ExtendableBuilder) super.clear();
        }

        private void ensureExtensionsIsMutable() {
            if (!this.extensionsIsMutable) {
                this.extensions = this.extensions.m7543clone();
                this.extensionsIsMutable = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FieldSet buildExtensions() {
            this.extensions.makeImmutable();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        private void verifyExtensionContainingType(GeneratedExtension generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final boolean hasExtension(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(generatedExtension.descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final int getExtensionCount(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedFieldCount(generatedExtension.descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final Object getExtension(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Object field = this.extensions.getField(generatedExtension.descriptor);
            if (field != null) {
                return field;
            }
            return generatedExtension.defaultValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final Object getExtension(GeneratedExtension generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedField(generatedExtension.descriptor, i);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public ExtendableBuilder mo7542clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final ExtendableBuilder setExtension(GeneratedExtension generatedExtension, Object obj) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.setField(generatedExtension.descriptor, obj);
            return this;
        }

        public final ExtendableBuilder setExtension(GeneratedExtension generatedExtension, int i, Object obj) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(generatedExtension.descriptor, i, obj);
            return this;
        }

        public final ExtendableBuilder addExtension(GeneratedExtension generatedExtension, Object obj) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(generatedExtension.descriptor, obj);
            return this;
        }

        public final ExtendableBuilder clearExtension(GeneratedExtension generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.clearField(generatedExtension.descriptor);
            return this;
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        protected boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws InvalidProtocolBufferException {
            boolean z;
            Object objFindValueByNumber;
            MessageLite.Builder builderNewBuilderForType;
            MessageLite messageLite;
            boolean z2 = false;
            int tagWireType = WireFormat.getTagWireType(i);
            GeneratedExtension generatedExtensionFindLiteExtensionByNumber = extensionRegistryLite.findLiteExtensionByNumber(getDefaultInstanceForType(), WireFormat.getTagFieldNumber(i));
            if (generatedExtensionFindLiteExtensionByNumber == null) {
                z = true;
            } else if (tagWireType == FieldSet.getWireFormatForFieldType(generatedExtensionFindLiteExtensionByNumber.descriptor.getLiteType(), false)) {
                z = false;
            } else if (generatedExtensionFindLiteExtensionByNumber.descriptor.isRepeated && generatedExtensionFindLiteExtensionByNumber.descriptor.type.isPackable() && tagWireType == FieldSet.getWireFormatForFieldType(generatedExtensionFindLiteExtensionByNumber.descriptor.getLiteType(), true)) {
                z = false;
                z2 = true;
            } else {
                z = true;
            }
            if (z) {
                return codedInputStream.skipField(i);
            }
            if (z2) {
                int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                if (generatedExtensionFindLiteExtensionByNumber.descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
                    while (codedInputStream.getBytesUntilLimit() > 0) {
                        Internal.EnumLite enumLiteFindValueByNumber = generatedExtensionFindLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(codedInputStream.readEnum());
                        if (enumLiteFindValueByNumber == null) {
                            return true;
                        }
                        ensureExtensionsIsMutable();
                        this.extensions.addRepeatedField(generatedExtensionFindLiteExtensionByNumber.descriptor, enumLiteFindValueByNumber);
                    }
                } else {
                    while (codedInputStream.getBytesUntilLimit() > 0) {
                        Object primitiveField = FieldSet.readPrimitiveField(codedInputStream, generatedExtensionFindLiteExtensionByNumber.descriptor.getLiteType());
                        ensureExtensionsIsMutable();
                        this.extensions.addRepeatedField(generatedExtensionFindLiteExtensionByNumber.descriptor, primitiveField);
                    }
                }
                codedInputStream.popLimit(iPushLimit);
            } else {
                switch (generatedExtensionFindLiteExtensionByNumber.descriptor.getLiteJavaType()) {
                    case MESSAGE:
                        if (generatedExtensionFindLiteExtensionByNumber.descriptor.isRepeated() || (messageLite = (MessageLite) this.extensions.getField(generatedExtensionFindLiteExtensionByNumber.descriptor)) == null) {
                            builderNewBuilderForType = null;
                        } else {
                            builderNewBuilderForType = messageLite.toBuilder();
                        }
                        if (builderNewBuilderForType == null) {
                            builderNewBuilderForType = generatedExtensionFindLiteExtensionByNumber.messageDefaultInstance.newBuilderForType();
                        }
                        if (generatedExtensionFindLiteExtensionByNumber.descriptor.getLiteType() == WireFormat.FieldType.GROUP) {
                            codedInputStream.readGroup(generatedExtensionFindLiteExtensionByNumber.getNumber(), builderNewBuilderForType, extensionRegistryLite);
                        } else {
                            codedInputStream.readMessage(builderNewBuilderForType, extensionRegistryLite);
                        }
                        objFindValueByNumber = builderNewBuilderForType.build();
                        break;
                    case ENUM:
                        objFindValueByNumber = generatedExtensionFindLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(codedInputStream.readEnum());
                        if (objFindValueByNumber == null) {
                            return true;
                        }
                        break;
                    default:
                        objFindValueByNumber = FieldSet.readPrimitiveField(codedInputStream, generatedExtensionFindLiteExtensionByNumber.descriptor.getLiteType());
                        break;
                }
                if (generatedExtensionFindLiteExtensionByNumber.descriptor.isRepeated()) {
                    ensureExtensionsIsMutable();
                    this.extensions.addRepeatedField(generatedExtensionFindLiteExtensionByNumber.descriptor, objFindValueByNumber);
                } else {
                    ensureExtensionsIsMutable();
                    this.extensions.setField(generatedExtensionFindLiteExtensionByNumber.descriptor, objFindValueByNumber);
                }
            }
            return true;
        }

        protected final void mergeExtensionFields(ExtendableMessage extendableMessage) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(extendableMessage.extensions);
        }
    }

    public static GeneratedExtension newSingularGeneratedExtension(MessageLite messageLite, Object obj, MessageLite messageLite2, Internal.EnumLiteMap enumLiteMap, int i, WireFormat.FieldType fieldType) {
        boolean z = false;
        return new GeneratedExtension(messageLite, obj, messageLite2, new ExtensionDescriptor(enumLiteMap, i, fieldType, z, z));
    }

    public static GeneratedExtension newRepeatedGeneratedExtension(MessageLite messageLite, MessageLite messageLite2, Internal.EnumLiteMap enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z) {
        return new GeneratedExtension(messageLite, Collections.emptyList(), messageLite2, new ExtensionDescriptor(enumLiteMap, i, fieldType, true, z));
    }

    final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite {
        private final Internal.EnumLiteMap enumTypeMap;
        private final boolean isPacked;
        private final boolean isRepeated;
        private final int number;
        private final WireFormat.FieldType type;

        private ExtensionDescriptor(Internal.EnumLiteMap enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.enumTypeMap = enumLiteMap;
            this.number = i;
            this.type = fieldType;
            this.isRepeated = z;
            this.isPacked = z2;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public Internal.EnumLiteMap getEnumType() {
            return this.enumTypeMap;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }

        @Override // java.lang.Comparable
        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.number - extensionDescriptor.number;
        }
    }

    public final class GeneratedExtension {
        private final MessageLite containingTypeDefaultInstance;
        private final Object defaultValue;
        private final ExtensionDescriptor descriptor;
        private final MessageLite messageDefaultInstance;

        private GeneratedExtension(MessageLite messageLite, Object obj, MessageLite messageLite2, ExtensionDescriptor extensionDescriptor) {
            if (messageLite == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (extensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite2 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.containingTypeDefaultInstance = messageLite;
            this.defaultValue = obj;
            this.messageDefaultInstance = messageLite2;
            this.descriptor = extensionDescriptor;
        }

        public MessageLite getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public int getNumber() {
            return this.descriptor.getNumber();
        }

        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }
    }

    final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private byte[] asBytes;
        private String messageClassName;

        SerializedForm(MessageLite messageLite) {
            this.messageClassName = messageLite.getClass().getName();
            this.asBytes = messageLite.toByteArray();
        }

        protected Object readResolve() {
            try {
                MessageLite.Builder builder = (MessageLite.Builder) Class.forName(this.messageClassName).getMethod("newBuilder", new Class[0]).invoke(null, new Object[0]);
                builder.mergeFrom(this.asBytes);
                return builder.buildPartial();
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException("Unable to understand proto buffer", e);
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Unable to find proto buffer class", e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Unable to call newBuilder method", e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("Unable to find newBuilder method", e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Error calling newBuilder", e5.getCause());
            }
        }
    }

    protected Object writeReplace() {
        return new SerializedForm(this);
    }
}
