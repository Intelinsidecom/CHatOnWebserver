package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {
    private static final long serialVersionUID = 1;

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
        <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension);

        <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i);

        <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension);

        <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension);
    }

    protected GeneratedMessageLite() {
    }

    protected GeneratedMessageLite(Builder builder) {
    }

    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public abstract MessageType getDefaultInstanceForType();

        public abstract BuilderType mergeFrom(MessageType messagetype);

        protected Builder() {
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* renamed from: clone */
        public BuilderType m3102clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        protected boolean parseUnknownField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            return input.skipField(tag);
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        private final FieldSet<ExtensionDescriptor> extensions;

        protected ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        protected ExtendableMessage(ExtendableBuilder<MessageType, ?> builder) {
            this.extensions = builder.buildExtensions();
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> extension) {
            if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(((GeneratedExtension) generatedExtension).descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> extension) {
            verifyExtensionContainingType(extension);
            return this.extensions.getRepeatedFieldCount(((GeneratedExtension) extension).descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Type type = (Type) this.extensions.getField(((GeneratedExtension) generatedExtension).descriptor);
            if (type != null) {
                return type;
            }
            return (Type) ((GeneratedExtension) generatedExtension).defaultValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return (Type) this.extensions.getRepeatedField(((GeneratedExtension) generatedExtension).descriptor, i);
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        protected class ExtensionWriter {
            private final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<ExtensionDescriptor, Object> next;

            /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z, ExtensionWriter extensionWriter) {
                this(z);
            }

            private ExtensionWriter(boolean messageSetWireFormat) {
                this.iter = ExtendableMessage.this.extensions.iterator();
                if (this.iter.hasNext()) {
                    this.next = this.iter.next();
                }
                this.messageSetWireFormat = messageSetWireFormat;
            }

            public void writeUntil(int end, CodedOutputStream output) throws IOException {
                while (this.next != null && this.next.getKey().getNumber() < end) {
                    ExtensionDescriptor extension = this.next.getKey();
                    if (this.messageSetWireFormat && extension.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !extension.isRepeated()) {
                        output.writeMessageSetExtension(extension.getNumber(), (MessageLite) this.next.getValue());
                    } else {
                        FieldSet.writeField(extension, this.next.getValue(), output);
                    }
                    if (this.iter.hasNext()) {
                        this.next = this.iter.next();
                    } else {
                        this.next = null;
                    }
                }
            }
        }

        protected ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        protected ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType;
        private FieldSet<ExtensionDescriptor> extensions = FieldSet.emptySet();
        private boolean extensionsIsMutable;

        static /* synthetic */ int[] $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType() {
            int[] iArr = $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType;
            if (iArr == null) {
                iArr = new int[WireFormat.JavaType.valuesCustom().length];
                try {
                    iArr[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[WireFormat.JavaType.ENUM.ordinal()] = 8;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[WireFormat.JavaType.FLOAT.ordinal()] = 3;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[WireFormat.JavaType.INT.ordinal()] = 1;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[WireFormat.JavaType.LONG.ordinal()] = 2;
                } catch (NoSuchFieldError e7) {
                }
                try {
                    iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
                } catch (NoSuchFieldError e8) {
                }
                try {
                    iArr[WireFormat.JavaType.STRING.ordinal()] = 6;
                } catch (NoSuchFieldError e9) {
                }
                $SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType = iArr;
            }
            return iArr;
        }

        protected ExtendableBuilder() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            this.extensions.clear();
            this.extensionsIsMutable = false;
            return (BuilderType) super.clear();
        }

        private void ensureExtensionsIsMutable() {
            if (!this.extensionsIsMutable) {
                this.extensions = this.extensions.m3101clone();
                this.extensionsIsMutable = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FieldSet<ExtensionDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> extension) {
            if (extension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(((GeneratedExtension) generatedExtension).descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> extension) {
            verifyExtensionContainingType(extension);
            return this.extensions.getRepeatedFieldCount(((GeneratedExtension) extension).descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Type type = (Type) this.extensions.getField(((GeneratedExtension) generatedExtension).descriptor);
            if (type != null) {
                return type;
            }
            return (Type) ((GeneratedExtension) generatedExtension).defaultValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return (Type) this.extensions.getRepeatedField(((GeneratedExtension) generatedExtension).descriptor, i);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* renamed from: clone */
        public BuilderType m3102clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, Type> generatedExtension, Type value) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.setField(((GeneratedExtension) generatedExtension).descriptor, value);
            return this;
        }

        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, List<Type>> extension, int index, Type value) {
            verifyExtensionContainingType(extension);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(((GeneratedExtension) extension).descriptor, index, value);
            return this;
        }

        public final <Type> BuilderType addExtension(GeneratedExtension<MessageType, List<Type>> extension, Type value) {
            verifyExtensionContainingType(extension);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(((GeneratedExtension) extension).descriptor, value);
            return this;
        }

        public final <Type> BuilderType clearExtension(GeneratedExtension<MessageType, ?> extension) {
            verifyExtensionContainingType(extension);
            ensureExtensionsIsMutable();
            this.extensions.clearField(((GeneratedExtension) extension).descriptor);
            return this;
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        protected boolean parseUnknownField(CodedInputStream input, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            Object objFindValueByNumber;
            MessageLite existingValue;
            int wireType = WireFormat.getTagWireType(tag);
            int fieldNumber = WireFormat.getTagFieldNumber(tag);
            GeneratedExtension<MessageType, ?> extension = extensionRegistry.findLiteExtensionByNumber(getDefaultInstanceForType(), fieldNumber);
            boolean unknown = false;
            boolean packed = false;
            if (extension == null) {
                unknown = true;
            } else if (wireType == FieldSet.getWireFormatForFieldType(((GeneratedExtension) extension).descriptor.getLiteType(), false)) {
                packed = false;
            } else if (((GeneratedExtension) extension).descriptor.isRepeated && ((GeneratedExtension) extension).descriptor.type.isPackable() && wireType == FieldSet.getWireFormatForFieldType(((GeneratedExtension) extension).descriptor.getLiteType(), true)) {
                packed = true;
            } else {
                unknown = true;
            }
            if (unknown) {
                return input.skipField(tag);
            }
            if (packed) {
                int length = input.readRawVarint32();
                int limit = input.pushLimit(length);
                if (((GeneratedExtension) extension).descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
                    while (input.getBytesUntilLimit() > 0) {
                        int rawValue = input.readEnum();
                        Internal.EnumLite value = ((GeneratedExtension) extension).descriptor.getEnumType().findValueByNumber(rawValue);
                        if (value == null) {
                            return true;
                        }
                        ensureExtensionsIsMutable();
                        this.extensions.addRepeatedField(((GeneratedExtension) extension).descriptor, value);
                    }
                } else {
                    while (input.getBytesUntilLimit() > 0) {
                        Object value2 = FieldSet.readPrimitiveField(input, ((GeneratedExtension) extension).descriptor.getLiteType());
                        ensureExtensionsIsMutable();
                        this.extensions.addRepeatedField(((GeneratedExtension) extension).descriptor, value2);
                    }
                }
                input.popLimit(limit);
            } else {
                switch ($SWITCH_TABLE$com$google$protobuf$WireFormat$JavaType()[((GeneratedExtension) extension).descriptor.getLiteJavaType().ordinal()]) {
                    case 8:
                        int rawValue2 = input.readEnum();
                        objFindValueByNumber = ((GeneratedExtension) extension).descriptor.getEnumType().findValueByNumber(rawValue2);
                        if (objFindValueByNumber == null) {
                            return true;
                        }
                        break;
                    case 9:
                        MessageLite.Builder subBuilder = null;
                        if (!((GeneratedExtension) extension).descriptor.isRepeated() && (existingValue = (MessageLite) this.extensions.getField(((GeneratedExtension) extension).descriptor)) != null) {
                            subBuilder = existingValue.toBuilder();
                        }
                        if (subBuilder == null) {
                            subBuilder = ((GeneratedExtension) extension).messageDefaultInstance.newBuilderForType();
                        }
                        if (((GeneratedExtension) extension).descriptor.getLiteType() == WireFormat.FieldType.GROUP) {
                            input.readGroup(extension.getNumber(), subBuilder, extensionRegistry);
                        } else {
                            input.readMessage(subBuilder, extensionRegistry);
                        }
                        objFindValueByNumber = subBuilder.build();
                        break;
                    default:
                        objFindValueByNumber = FieldSet.readPrimitiveField(input, ((GeneratedExtension) extension).descriptor.getLiteType());
                        break;
                }
                if (((GeneratedExtension) extension).descriptor.isRepeated()) {
                    ensureExtensionsIsMutable();
                    this.extensions.addRepeatedField(((GeneratedExtension) extension).descriptor, objFindValueByNumber);
                } else {
                    ensureExtensionsIsMutable();
                    this.extensions.setField(((GeneratedExtension) extension).descriptor, objFindValueByNumber);
                }
            }
            return true;
        }

        protected final void mergeExtensionFields(MessageType other) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(((ExtendableMessage) other).extensions);
        }
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType) {
        boolean z = false;
        return new GeneratedExtension<>(containingtype, type, messageLite, new ExtensionDescriptor(enumLiteMap, i, fieldType, z, z, null), 0 == true ? 1 : 0);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z) {
        return new GeneratedExtension<>(containingtype, Collections.emptyList(), messageLite, new ExtensionDescriptor(enumLiteMap, i, fieldType, true, z, null), 0 == true ? 1 : 0);
    }

    private static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        private final Internal.EnumLiteMap<?> enumTypeMap;
        private final boolean isPacked;
        private final boolean isRepeated;
        private final int number;
        private final WireFormat.FieldType type;

        private ExtensionDescriptor(Internal.EnumLiteMap<?> enumTypeMap, int number, WireFormat.FieldType type, boolean isRepeated, boolean isPacked) {
            this.enumTypeMap = enumTypeMap;
            this.number = number;
            this.type = type;
            this.isRepeated = isRepeated;
            this.isPacked = isPacked;
        }

        /* synthetic */ ExtensionDescriptor(Internal.EnumLiteMap enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2, ExtensionDescriptor extensionDescriptor) {
            this(enumLiteMap, i, fieldType, z, z2);
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
        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder to, MessageLite from) {
            return ((Builder) to).mergeFrom((Builder) from);
        }

        @Override // java.lang.Comparable
        public int compareTo(ExtensionDescriptor other) {
            return this.number - other.number;
        }
    }

    public static final class GeneratedExtension<ContainingType extends MessageLite, Type> {
        private final ContainingType containingTypeDefaultInstance;
        private final Type defaultValue;
        private final ExtensionDescriptor descriptor;
        private final MessageLite messageDefaultInstance;

        private GeneratedExtension(ContainingType containingTypeDefaultInstance, Type defaultValue, MessageLite messageDefaultInstance, ExtensionDescriptor descriptor) {
            if (containingTypeDefaultInstance == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (descriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageDefaultInstance == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.containingTypeDefaultInstance = containingTypeDefaultInstance;
            this.defaultValue = defaultValue;
            this.messageDefaultInstance = messageDefaultInstance;
            this.descriptor = descriptor;
        }

        /* synthetic */ GeneratedExtension(MessageLite messageLite, Object obj, MessageLite messageLite2, ExtensionDescriptor extensionDescriptor, GeneratedExtension generatedExtension) {
            this(messageLite, obj, messageLite2, extensionDescriptor);
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public int getNumber() {
            return this.descriptor.getNumber();
        }

        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }
    }

    static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private byte[] asBytes;
        private String messageClassName;

        SerializedForm(MessageLite regularForm) {
            this.messageClassName = regularForm.getClass().getName();
            this.asBytes = regularForm.toByteArray();
        }

        protected Object readResolve() throws ObjectStreamException, NoSuchMethodException, ClassNotFoundException, SecurityException {
            try {
                Class messageClass = Class.forName(this.messageClassName);
                Method newBuilder = messageClass.getMethod("newBuilder", new Class[0]);
                MessageLite.Builder builder = (MessageLite.Builder) newBuilder.invoke(null, new Object[0]);
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

    protected Object writeReplace() throws ObjectStreamException {
        return new SerializedForm(this);
    }
}
