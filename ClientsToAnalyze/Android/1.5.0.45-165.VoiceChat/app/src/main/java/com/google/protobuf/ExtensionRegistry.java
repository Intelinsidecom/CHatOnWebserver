package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessage;
import com.infraware.office.evengine.InterfaceC0507E;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ExtensionRegistry extends ExtensionRegistryLite {
    private static final ExtensionRegistry EMPTY = new ExtensionRegistry(true);
    private final Map<String, ExtensionInfo> extensionsByName;
    private final Map<DescriptorIntPair, ExtensionInfo> extensionsByNumber;

    public static ExtensionRegistry newInstance() {
        return new ExtensionRegistry();
    }

    public static ExtensionRegistry getEmptyRegistry() {
        return EMPTY;
    }

    @Override // com.google.protobuf.ExtensionRegistryLite
    public ExtensionRegistry getUnmodifiable() {
        return new ExtensionRegistry(this);
    }

    public static final class ExtensionInfo {
        public final Message defaultInstance;
        public final Descriptors.FieldDescriptor descriptor;

        private ExtensionInfo(Descriptors.FieldDescriptor descriptor) {
            this.descriptor = descriptor;
            this.defaultInstance = null;
        }

        private ExtensionInfo(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
            this.descriptor = descriptor;
            this.defaultInstance = defaultInstance;
        }

        /* synthetic */ ExtensionInfo(Descriptors.FieldDescriptor fieldDescriptor, Message message, ExtensionInfo extensionInfo) {
            this(fieldDescriptor, message);
        }
    }

    public ExtensionInfo findExtensionByName(String fullName) {
        return this.extensionsByName.get(fullName);
    }

    public ExtensionInfo findExtensionByNumber(Descriptors.Descriptor containingType, int fieldNumber) {
        return this.extensionsByNumber.get(new DescriptorIntPair(containingType, fieldNumber));
    }

    public void add(GeneratedMessage.GeneratedExtension<?, ?> generatedExtension) {
        ExtensionInfo extensionInfo = null;
        byte b = 0;
        byte b2 = 0;
        if (generatedExtension.getDescriptor().getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            if (generatedExtension.getMessageDefaultInstance() == null) {
                throw new IllegalStateException("Registered message-type extension had null default instance: " + generatedExtension.getDescriptor().getFullName());
            }
            add(new ExtensionInfo(generatedExtension.getDescriptor(), generatedExtension.getMessageDefaultInstance(), extensionInfo));
            return;
        }
        add(new ExtensionInfo(generatedExtension.getDescriptor(), b2 == true ? 1 : 0, b == true ? 1 : 0));
    }

    public void add(Descriptors.FieldDescriptor fieldDescriptor) {
        Message message = null;
        byte b = 0;
        if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
        }
        add(new ExtensionInfo(fieldDescriptor, message, b == true ? 1 : 0));
    }

    public void add(Descriptors.FieldDescriptor type, Message defaultInstance) {
        if (type.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
        }
        add(new ExtensionInfo(type, defaultInstance, null));
    }

    private ExtensionRegistry() {
        this.extensionsByName = new HashMap();
        this.extensionsByNumber = new HashMap();
    }

    private ExtensionRegistry(ExtensionRegistry other) {
        super(other);
        this.extensionsByName = Collections.unmodifiableMap(other.extensionsByName);
        this.extensionsByNumber = Collections.unmodifiableMap(other.extensionsByNumber);
    }

    private ExtensionRegistry(boolean empty) {
        super(ExtensionRegistryLite.getEmptyRegistry());
        this.extensionsByName = Collections.emptyMap();
        this.extensionsByNumber = Collections.emptyMap();
    }

    private void add(ExtensionInfo extension) {
        if (!extension.descriptor.isExtension()) {
            throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
        }
        this.extensionsByName.put(extension.descriptor.getFullName(), extension);
        this.extensionsByNumber.put(new DescriptorIntPair(extension.descriptor.getContainingType(), extension.descriptor.getNumber()), extension);
        Descriptors.FieldDescriptor field = extension.descriptor;
        if (field.getContainingType().getOptions().getMessageSetWireFormat() && field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && field.isOptional() && field.getExtensionScope() == field.getMessageType()) {
            this.extensionsByName.put(field.getMessageType().getFullName(), extension);
        }
    }

    private static final class DescriptorIntPair {
        private final Descriptors.Descriptor descriptor;
        private final int number;

        DescriptorIntPair(Descriptors.Descriptor descriptor, int number) {
            this.descriptor = descriptor;
            this.number = number;
        }

        public int hashCode() {
            return (this.descriptor.hashCode() * InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT) + this.number;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof DescriptorIntPair)) {
                return false;
            }
            DescriptorIntPair other = (DescriptorIntPair) obj;
            return this.descriptor == other.descriptor && this.number == other.number;
        }
    }
}
