package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public abstract class GeneratedMessage extends AbstractMessage implements Serializable {
    protected static boolean alwaysUseFieldBuilders = false;
    private static final long serialVersionUID = 1;
    private final UnknownFieldSet unknownFields;

    protected interface BuilderParent {
        void markDirty();
    }

    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageOrBuilder {
        <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension);

        <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i);

        <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension);

        <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension);
    }

    private interface ExtensionDescriptorRetriever {
        Descriptors.FieldDescriptor getDescriptor();
    }

    protected abstract FieldAccessorTable internalGetFieldAccessorTable();

    protected abstract Message.Builder newBuilderForType(BuilderParent builderParent);

    protected GeneratedMessage() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
    }

    protected GeneratedMessage(Builder<?> builder) {
        this.unknownFields = builder.getUnknownFields();
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        alwaysUseFieldBuilders = true;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return internalGetFieldAccessorTable().descriptor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
        TreeMap<Descriptors.FieldDescriptor, Object> result = new TreeMap<>();
        Descriptors.Descriptor descriptor = internalGetFieldAccessorTable().descriptor;
        for (Descriptors.FieldDescriptor field : descriptor.getFields()) {
            if (field.isRepeated()) {
                List<?> value = (List) getField(field);
                if (!value.isEmpty()) {
                    result.put(field, value);
                }
            } else if (hasField(field)) {
                result.put(field, getField(field));
            }
        }
        return result;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        for (Descriptors.FieldDescriptor field : getDescriptorForType().getFields()) {
            if (field.isRequired() && !hasField(field)) {
                return false;
            }
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (field.isRepeated()) {
                    List<Message> messageList = (List) getField(field);
                    for (Message element : messageList) {
                        if (!element.isInitialized()) {
                            return false;
                        }
                    }
                } else if (hasField(field) && !((Message) getField(field)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable());
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).has(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).get(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).getRepeatedCount(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
        return internalGetFieldAccessorTable().getField(field).getRepeated(this, index);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public static abstract class Builder<BuilderType extends Builder> extends AbstractMessage.Builder<BuilderType> {
        private BuilderParent builderParent;
        private boolean isClean;
        private Builder<BuilderType>.BuilderParentImpl meAsParent;
        private UnknownFieldSet unknownFields;

        protected abstract FieldAccessorTable internalGetFieldAccessorTable();

        protected Builder() {
            this(null);
        }

        protected Builder(BuilderParent builderParent) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            this.builderParent = builderParent;
        }

        void dispose() {
            this.builderParent = null;
        }

        protected void onBuilt() {
            if (this.builderParent != null) {
                markClean();
            }
        }

        protected void markClean() {
            this.isClean = true;
        }

        protected boolean isClean() {
            return this.isClean;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* renamed from: clone */
        public BuilderType m3102clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            onChanged();
            return this;
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return internalGetFieldAccessorTable().descriptor;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
            TreeMap<Descriptors.FieldDescriptor, Object> result = new TreeMap<>();
            Descriptors.Descriptor descriptor = internalGetFieldAccessorTable().descriptor;
            for (Descriptors.FieldDescriptor field : descriptor.getFields()) {
                if (field.isRepeated()) {
                    List value = (List) getField(field);
                    if (!value.isEmpty()) {
                        result.put(field, value);
                    }
                } else if (hasField(field)) {
                    result.put(field, getField(field));
                }
            }
            return result;
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor field) {
            return internalGetFieldAccessorTable().getField(field).newBuilder();
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor field) {
            return internalGetFieldAccessorTable().getField(field).has(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor field) {
            Object object = internalGetFieldAccessorTable().getField(field).get(this);
            if (field.isRepeated()) {
                return Collections.unmodifiableList((List) object);
            }
            return object;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType setField(Descriptors.FieldDescriptor field, Object value) {
            internalGetFieldAccessorTable().getField(field).set(this, value);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType clearField(Descriptors.FieldDescriptor field) {
            internalGetFieldAccessorTable().getField(field).clear(this);
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
            return internalGetFieldAccessorTable().getField(field).getRepeatedCount(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
            return internalGetFieldAccessorTable().getField(field).getRepeated(this, index);
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            internalGetFieldAccessorTable().getField(field).setRepeated(this, index, value);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            internalGetFieldAccessorTable().getField(field).addRepeated(this, value);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public final BuilderType setUnknownFields(UnknownFieldSet unknownFields) {
            this.unknownFields = unknownFields;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final BuilderType mergeUnknownFields(UnknownFieldSet unknownFields) {
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFields).build();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            for (Descriptors.FieldDescriptor field : getDescriptorForType().getFields()) {
                if (field.isRequired() && !hasField(field)) {
                    return false;
                }
                if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (field.isRepeated()) {
                        List<Message> messageList = (List) getField(field);
                        for (Message element : messageList) {
                            if (!element.isInitialized()) {
                                return false;
                            }
                        }
                    } else if (hasField(field) && !((Message) getField(field)).isInitialized()) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        protected boolean parseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            return unknownFields.mergeFieldFrom(tag, input);
        }

        private class BuilderParentImpl implements BuilderParent {
            private BuilderParentImpl() {
            }

            /* synthetic */ BuilderParentImpl(Builder builder, BuilderParentImpl builderParentImpl) {
                this();
            }

            @Override // com.google.protobuf.GeneratedMessage.BuilderParent
            public void markDirty() {
                Builder.this.onChanged();
            }
        }

        protected BuilderParent getParentForChildren() {
            if (this.meAsParent == null) {
                this.meAsParent = new BuilderParentImpl(this, null);
            }
            return this.meAsParent;
        }

        protected final void onChanged() {
            if (this.isClean && this.builderParent != null) {
                this.builderParent.markDirty();
                this.isClean = false;
            }
        }
    }

    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessage implements ExtendableMessageOrBuilder<MessageType> {
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        protected ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        protected ExtendableMessage(ExtendableBuilder<MessageType, ?> builder) {
            super(builder);
            this.extensions = builder.buildExtensions();
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> extension) {
            if (extension.getDescriptor().getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("Extension is for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(generatedExtension.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> extension) {
            verifyExtensionContainingType(extension);
            Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
            return this.extensions.getRepeatedFieldCount(descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Descriptors.FieldDescriptor descriptor = generatedExtension.getDescriptor();
            Object field = this.extensions.getField(descriptor);
            if (field == null) {
                if (descriptor.isRepeated()) {
                    return (Type) Collections.emptyList();
                }
                if (descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return (Type) generatedExtension.getMessageDefaultInstance();
                }
                return (Type) generatedExtension.fromReflectionType(descriptor.getDefaultValue());
            }
            return (Type) generatedExtension.fromReflectionType(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return (Type) generatedExtension.singularFromReflectionType(this.extensions.getRepeatedField(generatedExtension.getDescriptor(), i));
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return super.isInitialized() && extensionsAreInitialized();
        }

        protected class ExtensionWriter {
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter;
            private final boolean messageSetWireFormat;
            private Map.Entry<Descriptors.FieldDescriptor, Object> next;

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
                    Descriptors.FieldDescriptor descriptor = this.next.getKey();
                    if (this.messageSetWireFormat && descriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !descriptor.isRepeated()) {
                        output.writeMessageSetExtension(descriptor.getNumber(), (Message) this.next.getValue());
                    } else {
                        FieldSet.writeField(descriptor, this.next.getValue(), output);
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

        protected Map<Descriptors.FieldDescriptor, Object> getExtensionFields() {
            return this.extensions.getAllFields();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map<Descriptors.FieldDescriptor, Object> result = getAllFieldsMutable();
            result.putAll(getExtensionFields());
            return Collections.unmodifiableMap(result);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor field) {
            if (!field.isExtension()) {
                return super.hasField(field);
            }
            verifyContainingType(field);
            return this.extensions.hasField(field);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor field) {
            if (field.isExtension()) {
                verifyContainingType(field);
                Object value = this.extensions.getField(field);
                if (value == null) {
                    if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        return DynamicMessage.getDefaultInstance(field.getMessageType());
                    }
                    return field.getDefaultValue();
                }
                return value;
            }
            return super.getField(field);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
            if (!field.isExtension()) {
                return super.getRepeatedFieldCount(field);
            }
            verifyContainingType(field);
            return this.extensions.getRepeatedFieldCount(field);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
            if (!field.isExtension()) {
                return super.getRepeatedField(field, index);
            }
            verifyContainingType(field);
            return this.extensions.getRepeatedField(field, index);
        }

        private void verifyContainingType(Descriptors.FieldDescriptor field) {
            if (field.getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage, BuilderType extends ExtendableBuilder> extends Builder<BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<Descriptors.FieldDescriptor> extensions;

        protected ExtendableBuilder() {
            this.extensions = FieldSet.emptySet();
        }

        protected ExtendableBuilder(BuilderParent parent) {
            super(parent);
            this.extensions = FieldSet.emptySet();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            this.extensions = FieldSet.emptySet();
            return (BuilderType) super.clear();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* renamed from: clone */
        public BuilderType m3102clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.m3101clone();
            }
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> extension) {
            if (extension.getDescriptor().getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("Extension is for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(generatedExtension.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> extension) {
            verifyExtensionContainingType(extension);
            Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
            return this.extensions.getRepeatedFieldCount(descriptor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Descriptors.FieldDescriptor descriptor = generatedExtension.getDescriptor();
            Object field = this.extensions.getField(descriptor);
            if (field == null) {
                if (descriptor.isRepeated()) {
                    return (Type) Collections.emptyList();
                }
                if (descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return (Type) generatedExtension.getMessageDefaultInstance();
                }
                return (Type) generatedExtension.fromReflectionType(descriptor.getDefaultValue());
            }
            return (Type) generatedExtension.fromReflectionType(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return (Type) generatedExtension.singularFromReflectionType(this.extensions.getRepeatedField(generatedExtension.getDescriptor(), i));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, Type> generatedExtension, Type value) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor descriptor = generatedExtension.getDescriptor();
            this.extensions.setField(descriptor, generatedExtension.toReflectionType(value));
            onChanged();
            return this;
        }

        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, List<Type>> extension, int index, Type value) {
            verifyExtensionContainingType(extension);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
            this.extensions.setRepeatedField(descriptor, index, extension.singularToReflectionType(value));
            onChanged();
            return this;
        }

        public final <Type> BuilderType addExtension(GeneratedExtension<MessageType, List<Type>> extension, Type value) {
            verifyExtensionContainingType(extension);
            ensureExtensionsIsMutable();
            Descriptors.FieldDescriptor descriptor = extension.getDescriptor();
            this.extensions.addRepeatedField(descriptor, extension.singularToReflectionType(value));
            onChanged();
            return this;
        }

        public final <Type> BuilderType clearExtension(GeneratedExtension<MessageType, ?> extension) {
            verifyExtensionContainingType(extension);
            ensureExtensionsIsMutable();
            this.extensions.clearField(extension.getDescriptor());
            onChanged();
            return this;
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FieldSet<Descriptors.FieldDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            return this.extensions;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return super.isInitialized() && extensionsAreInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected boolean parseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            return AbstractMessage.Builder.mergeFieldFrom(input, unknownFields, extensionRegistry, this, tag);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map allFieldsMutable = getAllFieldsMutable();
            allFieldsMutable.putAll(this.extensions.getAllFields());
            return Collections.unmodifiableMap(allFieldsMutable);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor field) {
            if (field.isExtension()) {
                verifyContainingType(field);
                Object value = this.extensions.getField(field);
                if (value == null) {
                    if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        return DynamicMessage.getDefaultInstance(field.getMessageType());
                    }
                    return field.getDefaultValue();
                }
                return value;
            }
            return super.getField(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
            if (!field.isExtension()) {
                return super.getRepeatedFieldCount(field);
            }
            verifyContainingType(field);
            return this.extensions.getRepeatedFieldCount(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
            if (!field.isExtension()) {
                return super.getRepeatedField(field, index);
            }
            verifyContainingType(field);
            return this.extensions.getRepeatedField(field, index);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor field) {
            if (!field.isExtension()) {
                return super.hasField(field);
            }
            verifyContainingType(field);
            return this.extensions.hasField(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType setField(Descriptors.FieldDescriptor field, Object value) {
            if (!field.isExtension()) {
                return (ExtendableBuilder) super.setField(field, value);
            }
            verifyContainingType(field);
            ensureExtensionsIsMutable();
            this.extensions.setField(field, value);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType clearField(Descriptors.FieldDescriptor field) {
            if (!field.isExtension()) {
                return (ExtendableBuilder) super.clearField(field);
            }
            verifyContainingType(field);
            ensureExtensionsIsMutable();
            this.extensions.clearField(field);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            if (!field.isExtension()) {
                return (ExtendableBuilder) super.setRepeatedField(field, index, value);
            }
            verifyContainingType(field);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(field, index, value);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            if (!field.isExtension()) {
                return (ExtendableBuilder) super.addRepeatedField(field, value);
            }
            verifyContainingType(field);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(field, value);
            onChanged();
            return this;
        }

        protected final void mergeExtensionFields(ExtendableMessage other) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(other.extensions);
            onChanged();
        }

        private void verifyContainingType(Descriptors.FieldDescriptor field) {
            if (field.getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newMessageScopedGeneratedExtension(final Message scope, final int descriptorIndex, Class singularType, Message defaultInstance) {
        return new GeneratedExtension<>(new ExtensionDescriptorRetriever() { // from class: com.google.protobuf.GeneratedMessage.1
            @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
            public Descriptors.FieldDescriptor getDescriptor() {
                return scope.getDescriptorForType().getExtensions().get(descriptorIndex);
            }
        }, singularType, defaultInstance, null);
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newFileScopedGeneratedExtension(Class cls, Message message) {
        return new GeneratedExtension<>(null, cls, message, 0 == true ? 1 : 0);
    }

    public static final class GeneratedExtension<ContainingType extends Message, Type> {

        /* renamed from: $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType */
        private static /* synthetic */ int[] f54xfcc84f65;
        private ExtensionDescriptorRetriever descriptorRetriever;
        private final Method enumGetValueDescriptor;
        private final Method enumValueOf;
        private final Message messageDefaultInstance;
        private final Class singularType;

        /* renamed from: $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType */
        static /* synthetic */ int[] m3xfcc84f65() {
            int[] iArr = f54xfcc84f65;
            if (iArr == null) {
                iArr = new int[Descriptors.FieldDescriptor.JavaType.valuesCustom().length];
                try {
                    iArr[Descriptors.FieldDescriptor.JavaType.BOOLEAN.ordinal()] = 5;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.JavaType.BYTE_STRING.ordinal()] = 7;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.JavaType.DOUBLE.ordinal()] = 4;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.JavaType.ENUM.ordinal()] = 8;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.JavaType.FLOAT.ordinal()] = 3;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.JavaType.INT.ordinal()] = 1;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.JavaType.LONG.ordinal()] = 2;
                } catch (NoSuchFieldError e7) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.JavaType.MESSAGE.ordinal()] = 9;
                } catch (NoSuchFieldError e8) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.JavaType.STRING.ordinal()] = 6;
                } catch (NoSuchFieldError e9) {
                }
                f54xfcc84f65 = iArr;
            }
            return iArr;
        }

        private GeneratedExtension(ExtensionDescriptorRetriever descriptorRetriever, Class singularType, Message messageDefaultInstance) {
            if (Message.class.isAssignableFrom(singularType) && !singularType.isInstance(messageDefaultInstance)) {
                throw new IllegalArgumentException("Bad messageDefaultInstance for " + singularType.getName());
            }
            this.descriptorRetriever = descriptorRetriever;
            this.singularType = singularType;
            this.messageDefaultInstance = messageDefaultInstance;
            if (!ProtocolMessageEnum.class.isAssignableFrom(singularType)) {
                this.enumValueOf = null;
                this.enumGetValueDescriptor = null;
            } else {
                this.enumValueOf = GeneratedMessage.getMethodOrDie(singularType, "valueOf", Descriptors.EnumValueDescriptor.class);
                this.enumGetValueDescriptor = GeneratedMessage.getMethodOrDie(singularType, "getValueDescriptor", new Class[0]);
            }
        }

        /* synthetic */ GeneratedExtension(ExtensionDescriptorRetriever extensionDescriptorRetriever, Class cls, Message message, GeneratedExtension generatedExtension) {
            this(extensionDescriptorRetriever, cls, message);
        }

        public void internalInit(final Descriptors.FieldDescriptor descriptor) {
            if (this.descriptorRetriever != null) {
                throw new IllegalStateException("Already initialized.");
            }
            this.descriptorRetriever = new ExtensionDescriptorRetriever() { // from class: com.google.protobuf.GeneratedMessage.GeneratedExtension.1
                @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
                public Descriptors.FieldDescriptor getDescriptor() {
                    return descriptor;
                }
            };
        }

        public Descriptors.FieldDescriptor getDescriptor() {
            if (this.descriptorRetriever == null) {
                throw new IllegalStateException("getDescriptor() called before internalInit()");
            }
            return this.descriptorRetriever.getDescriptor();
        }

        public Message getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object fromReflectionType(Object value) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (descriptor.isRepeated()) {
                if (descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE || descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                    List result = new ArrayList();
                    for (Object element : (List) value) {
                        result.add(singularFromReflectionType(element));
                    }
                    return result;
                }
                return value;
            }
            return singularFromReflectionType(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object singularFromReflectionType(Object value) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            switch (m3xfcc84f65()[descriptor.getJavaType().ordinal()]) {
                case 9:
                    if (!this.singularType.isInstance(value)) {
                        break;
                    }
                    break;
            }
            return value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object toReflectionType(Object value) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (descriptor.isRepeated()) {
                if (descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) {
                    return value;
                }
                List result = new ArrayList();
                for (Object element : (List) value) {
                    result.add(singularToReflectionType(element));
                }
                return result;
            }
            return singularToReflectionType(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object singularToReflectionType(Object value) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            switch (m3xfcc84f65()[descriptor.getJavaType().ordinal()]) {
                case 8:
                    return GeneratedMessage.invokeOrDie(this.enumGetValueDescriptor, value, new Object[0]);
                default:
                    return value;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method getMethodOrDie(Class clazz, String name, Class... params) {
        try {
            return clazz.getMethod(name, params);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + clazz.getName() + "\" missing method \"" + name + "\".", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object invokeOrDie(Method method, Object object, Object... params) throws Throwable {
        try {
            return method.invoke(object, params);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static final class FieldAccessorTable {
        private final Descriptors.Descriptor descriptor;
        private final FieldAccessor[] fields;

        private interface FieldAccessor {
            void addRepeated(Builder builder, Object obj);

            void clear(Builder builder);

            Object get(Builder builder);

            Object get(GeneratedMessage generatedMessage);

            Object getRepeated(Builder builder, int i);

            Object getRepeated(GeneratedMessage generatedMessage, int i);

            int getRepeatedCount(Builder builder);

            int getRepeatedCount(GeneratedMessage generatedMessage);

            boolean has(Builder builder);

            boolean has(GeneratedMessage generatedMessage);

            Message.Builder newBuilder();

            void set(Builder builder, Object obj);

            void setRepeated(Builder builder, int i, Object obj);
        }

        public FieldAccessorTable(Descriptors.Descriptor descriptor, String[] camelCaseNames, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
            this.descriptor = descriptor;
            this.fields = new FieldAccessor[descriptor.getFields().size()];
            for (int i = 0; i < this.fields.length; i++) {
                Descriptors.FieldDescriptor field = descriptor.getFields().get(i);
                if (field.isRepeated()) {
                    if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        this.fields[i] = new RepeatedMessageFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
                    } else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                        this.fields[i] = new RepeatedEnumFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
                    } else {
                        this.fields[i] = new RepeatedFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
                    }
                } else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    this.fields[i] = new SingularMessageFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
                } else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                    this.fields[i] = new SingularEnumFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
                } else {
                    this.fields[i] = new SingularFieldAccessor(field, camelCaseNames[i], messageClass, builderClass);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FieldAccessor getField(Descriptors.FieldDescriptor field) {
            if (field.getContainingType() != this.descriptor) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
            if (field.isExtension()) {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
            return this.fields[field.getIndex()];
        }

        private static class SingularFieldAccessor implements FieldAccessor {
            protected final Method clearMethod;
            protected final Method getMethod;
            protected final Method getMethodBuilder;
            protected final Method hasMethod;
            protected final Method hasMethodBuilder;
            protected final Method setMethod;
            protected final Class<?> type;

            SingularFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                this.getMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName, new Class[0]);
                this.getMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName, new Class[0]);
                this.type = this.getMethod.getReturnType();
                this.setMethod = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName, this.type);
                this.hasMethod = GeneratedMessage.getMethodOrDie(messageClass, "has" + camelCaseName, new Class[0]);
                this.hasMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "has" + camelCaseName, new Class[0]);
                this.clearMethod = GeneratedMessage.getMethodOrDie(builderClass, "clear" + camelCaseName, new Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage message) {
                return GeneratedMessage.invokeOrDie(this.getMethod, message, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder builder) {
                return GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder builder, Object value) throws Throwable {
                GeneratedMessage.invokeOrDie(this.setMethod, builder, value);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage message, int index) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder builder, int index) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder builder, int index, Object value) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder builder, Object value) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage message) {
                return ((Boolean) GeneratedMessage.invokeOrDie(this.hasMethod, message, new Object[0])).booleanValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder builder) {
                return ((Boolean) GeneratedMessage.invokeOrDie(this.hasMethodBuilder, builder, new Object[0])).booleanValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage message) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder builder) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder builder) throws Throwable {
                GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }
        }

        private static class RepeatedFieldAccessor implements FieldAccessor {
            protected final Method addRepeatedMethod;
            protected final Method clearMethod;
            protected final Method getCountMethod;
            protected final Method getCountMethodBuilder;
            protected final Method getMethod;
            protected final Method getMethodBuilder;
            protected final Method getRepeatedMethod;
            protected final Method getRepeatedMethodBuilder;
            protected final Method setRepeatedMethod;
            protected final Class type;

            RepeatedFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                this.getMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName + "List", new Class[0]);
                this.getMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName + "List", new Class[0]);
                this.getRepeatedMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName, Integer.TYPE);
                this.getRepeatedMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName, Integer.TYPE);
                this.type = this.getRepeatedMethod.getReturnType();
                this.setRepeatedMethod = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName, Integer.TYPE, this.type);
                this.addRepeatedMethod = GeneratedMessage.getMethodOrDie(builderClass, "add" + camelCaseName, this.type);
                this.getCountMethod = GeneratedMessage.getMethodOrDie(messageClass, "get" + camelCaseName + "Count", new Class[0]);
                this.getCountMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "get" + camelCaseName + "Count", new Class[0]);
                this.clearMethod = GeneratedMessage.getMethodOrDie(builderClass, "clear" + camelCaseName, new Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage message) {
                return GeneratedMessage.invokeOrDie(this.getMethod, message, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder builder) {
                return GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder builder, Object value) throws Throwable {
                clear(builder);
                for (Object element : (List) value) {
                    addRepeated(builder, element);
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage message, int index) {
                return GeneratedMessage.invokeOrDie(this.getRepeatedMethod, message, Integer.valueOf(index));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder builder, int index) {
                return GeneratedMessage.invokeOrDie(this.getRepeatedMethodBuilder, builder, Integer.valueOf(index));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder builder, int index, Object value) throws Throwable {
                GeneratedMessage.invokeOrDie(this.setRepeatedMethod, builder, Integer.valueOf(index), value);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder builder, Object value) throws Throwable {
                GeneratedMessage.invokeOrDie(this.addRepeatedMethod, builder, value);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage message) {
                throw new UnsupportedOperationException("hasField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder builder) {
                throw new UnsupportedOperationException("hasField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage message) {
                return ((Integer) GeneratedMessage.invokeOrDie(this.getCountMethod, message, new Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder builder) {
                return ((Integer) GeneratedMessage.invokeOrDie(this.getCountMethodBuilder, builder, new Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder builder) throws Throwable {
                GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }
        }

        private static final class SingularEnumFieldAccessor extends SingularFieldAccessor {
            private Method getValueDescriptorMethod;
            private Method valueOfMethod;

            SingularEnumFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                super(descriptor, camelCaseName, messageClass, builderClass);
                this.valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", Descriptors.EnumValueDescriptor.class);
                this.getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage message) {
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(message), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder builder) {
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.get(builder), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder builder, Object value) throws Throwable {
                super.set(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, value));
            }
        }

        private static final class RepeatedEnumFieldAccessor extends RepeatedFieldAccessor {
            private final Method getValueDescriptorMethod;
            private final Method valueOfMethod;

            RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                super(descriptor, camelCaseName, messageClass, builderClass);
                this.valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, "valueOf", Descriptors.EnumValueDescriptor.class);
                this.getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage message) {
                List newList = new ArrayList();
                for (Object element : (List) super.get(message)) {
                    newList.add(GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, element, new Object[0]));
                }
                return Collections.unmodifiableList(newList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder builder) {
                List newList = new ArrayList();
                for (Object element : (List) super.get(builder)) {
                    newList.add(GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, element, new Object[0]));
                }
                return Collections.unmodifiableList(newList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage message, int index) {
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(message, index), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder builder, int index) {
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, super.getRepeated(builder, index), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder builder, int index, Object value) throws Throwable {
                super.setRepeated(builder, index, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, value));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder builder, Object value) throws Throwable {
                super.addRepeated(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, value));
            }
        }

        private static final class SingularMessageFieldAccessor extends SingularFieldAccessor {
            private final Method newBuilderMethod;

            SingularMessageFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                super(descriptor, camelCaseName, messageClass, builderClass);
                this.newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);
            }

            private Object coerceType(Object value) {
                if (this.type.isInstance(value)) {
                    return value;
                }
                return ((Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) value).build();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder builder, Object value) throws Throwable {
                super.set(builder, coerceType(value));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
            }
        }

        private static final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
            private final Method newBuilderMethod;

            RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                super(descriptor, camelCaseName, messageClass, builderClass);
                this.newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);
            }

            private Object coerceType(Object value) {
                if (this.type.isInstance(value)) {
                    return value;
                }
                return ((Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) value).build();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder builder, int index, Object value) throws Throwable {
                super.setRepeated(builder, index, coerceType(value));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder builder, Object value) throws Throwable {
                super.addRepeated(builder, coerceType(value));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
            }
        }
    }

    protected Object writeReplace() throws ObjectStreamException {
        return new GeneratedMessageLite.SerializedForm(this);
    }
}
