package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import com.infraware.office.evengine.InterfaceC0507E;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AbstractMessage extends AbstractMessageLite implements Message {
    private int memoizedSize = -1;

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        for (Descriptors.FieldDescriptor field : getDescriptorForType().getFields()) {
            if (field.isRequired() && !hasField(field)) {
                return false;
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : getAllFields().entrySet()) {
            Descriptors.FieldDescriptor field2 = entry.getKey();
            if (field2.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (field2.isRepeated()) {
                    for (Message element : (List) entry.getValue()) {
                        if (!element.isInitialized()) {
                            return false;
                        }
                    }
                } else if (!((Message) entry.getValue()).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Message
    public final String toString() {
        return TextFormat.printToString(this);
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream output) throws IOException {
        boolean isMessageSet = getDescriptorForType().getOptions().getMessageSetWireFormat();
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : getAllFields().entrySet()) {
            Descriptors.FieldDescriptor field = entry.getKey();
            Object value = entry.getValue();
            if (isMessageSet && field.isExtension() && field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !field.isRepeated()) {
                output.writeMessageSetExtension(field.getNumber(), (Message) value);
            } else {
                FieldSet.writeField(field, value, output);
            }
        }
        UnknownFieldSet unknownFields = getUnknownFields();
        if (isMessageSet) {
            unknownFields.writeAsMessageSetTo(output);
        } else {
            unknownFields.writeTo(output);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size;
        int size2 = this.memoizedSize;
        if (size2 != -1) {
            return size2;
        }
        int size3 = 0;
        boolean isMessageSet = getDescriptorForType().getOptions().getMessageSetWireFormat();
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : getAllFields().entrySet()) {
            Descriptors.FieldDescriptor field = entry.getKey();
            Object value = entry.getValue();
            if (isMessageSet && field.isExtension() && field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !field.isRepeated()) {
                size3 += CodedOutputStream.computeMessageSetExtensionSize(field.getNumber(), (Message) value);
            } else {
                size3 += FieldSet.computeFieldSize(field, value);
            }
        }
        UnknownFieldSet unknownFields = getUnknownFields();
        if (isMessageSet) {
            size = size3 + unknownFields.getSerializedSizeAsMessageSet();
        } else {
            size = size3 + unknownFields.getSerializedSize();
        }
        this.memoizedSize = size;
        return size;
    }

    @Override // com.google.protobuf.Message
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Message)) {
            return false;
        }
        Message otherMessage = (Message) other;
        if (getDescriptorForType() != otherMessage.getDescriptorForType()) {
            return false;
        }
        return getAllFields().equals(otherMessage.getAllFields()) && getUnknownFields().equals(otherMessage.getUnknownFields());
    }

    @Override // com.google.protobuf.Message
    public int hashCode() {
        int hash = getDescriptorForType().hashCode() + InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SHEET_INSERT_COL_EVENT;
        return (hashFields(hash, getAllFields()) * 29) + getUnknownFields().hashCode();
    }

    protected int hashFields(int hash, Map<Descriptors.FieldDescriptor, Object> map) {
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor field = entry.getKey();
            Object value = entry.getValue();
            int hash2 = (hash * 37) + field.getNumber();
            if (field.getType() != Descriptors.FieldDescriptor.Type.ENUM) {
                hash = (hash2 * 53) + value.hashCode();
            } else if (field.isRepeated()) {
                List<? extends Internal.EnumLite> list = (List) value;
                hash = (hash2 * 53) + hashEnumList(list);
            } else {
                hash = (hash2 * 53) + hashEnum((Internal.EnumLite) value);
            }
        }
        return hash;
    }

    protected static int hashLong(long n) {
        return (int) ((n >>> 32) ^ n);
    }

    protected static int hashBoolean(boolean b) {
        return b ? 1231 : 1237;
    }

    protected static int hashEnum(Internal.EnumLite e) {
        return e.getNumber();
    }

    protected static int hashEnumList(List<? extends Internal.EnumLite> list) {
        int hash = 1;
        for (Internal.EnumLite e : list) {
            hash = (hash * 31) + hashEnum(e);
        }
        return hash;
    }

    public static abstract class Builder<BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> implements Message.Builder {

        /* renamed from: $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type */
        private static /* synthetic */ int[] f30x792aeea3;

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* renamed from: clone */
        public abstract BuilderType m3102clone();

        /* renamed from: $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type */
        static /* synthetic */ int[] m0x792aeea3() {
            int[] iArr = f30x792aeea3;
            if (iArr == null) {
                iArr = new int[Descriptors.FieldDescriptor.Type.valuesCustom().length];
                try {
                    iArr[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 8;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 12;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 1;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 14;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 7;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 6;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 2;
                } catch (NoSuchFieldError e7) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 10;
                } catch (NoSuchFieldError e8) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 5;
                } catch (NoSuchFieldError e9) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 3;
                } catch (NoSuchFieldError e10) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 11;
                } catch (NoSuchFieldError e11) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 15;
                } catch (NoSuchFieldError e12) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 16;
                } catch (NoSuchFieldError e13) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 17;
                } catch (NoSuchFieldError e14) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 18;
                } catch (NoSuchFieldError e15) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 9;
                } catch (NoSuchFieldError e16) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 13;
                } catch (NoSuchFieldError e17) {
                }
                try {
                    iArr[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 4;
                } catch (NoSuchFieldError e18) {
                }
                f30x792aeea3 = iArr;
            }
            return iArr;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : getAllFields().entrySet()) {
                clearField(entry.getKey());
            }
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(Message other) {
            if (other.getDescriptorForType() != getDescriptorForType()) {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : other.getAllFields().entrySet()) {
                Descriptors.FieldDescriptor field = entry.getKey();
                if (field.isRepeated()) {
                    for (Object element : (List) entry.getValue()) {
                        addRepeatedField(field, element);
                    }
                } else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    Message existingValue = (Message) getField(field);
                    if (existingValue == existingValue.getDefaultInstanceForType()) {
                        setField(field, entry.getValue());
                    } else {
                        setField(field, existingValue.newBuilderForType().mergeFrom(existingValue).mergeFrom((Message) entry.getValue()).build());
                    }
                } else {
                    setField(field, entry.getValue());
                }
            }
            mergeUnknownFields(other.getUnknownFields());
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream codedInputStream) throws IOException {
            return (BuilderType) mergeFrom(codedInputStream, (ExtensionRegistryLite) ExtensionRegistry.getEmptyRegistry());
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            int tag;
            UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
            do {
                tag = input.readTag();
                if (tag == 0) {
                    break;
                }
            } while (mergeFieldFrom(input, unknownFields, extensionRegistry, this, tag));
            setUnknownFields(unknownFields.build());
            return this;
        }

        static boolean mergeFieldFrom(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, Message.Builder builder, int tag) throws IOException {
            Descriptors.FieldDescriptor field;
            Object objFindValueByNumber;
            Message.Builder subBuilder;
            Message.Builder subBuilder2;
            ExtensionRegistry.ExtensionInfo extension;
            Descriptors.Descriptor type = builder.getDescriptorForType();
            if (type.getOptions().getMessageSetWireFormat() && tag == WireFormat.MESSAGE_SET_ITEM_TAG) {
                mergeMessageSetExtensionFromCodedStream(input, unknownFields, extensionRegistry, builder);
                return true;
            }
            int wireType = WireFormat.getTagWireType(tag);
            int fieldNumber = WireFormat.getTagFieldNumber(tag);
            Message defaultInstance = null;
            if (type.isExtensionNumber(fieldNumber)) {
                if (!(extensionRegistry instanceof ExtensionRegistry) || (extension = ((ExtensionRegistry) extensionRegistry).findExtensionByNumber(type, fieldNumber)) == null) {
                    field = null;
                } else {
                    field = extension.descriptor;
                    defaultInstance = extension.defaultInstance;
                    if (defaultInstance == null && field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        throw new IllegalStateException("Message-typed extension lacked default instance: " + field.getFullName());
                    }
                }
            } else {
                field = type.findFieldByNumber(fieldNumber);
            }
            boolean unknown = false;
            boolean packed = false;
            if (field == null) {
                unknown = true;
            } else if (wireType == FieldSet.getWireFormatForFieldType(field.getLiteType(), false)) {
                packed = false;
            } else if (field.isPackable() && wireType == FieldSet.getWireFormatForFieldType(field.getLiteType(), true)) {
                packed = true;
            } else {
                unknown = true;
            }
            if (unknown) {
                return unknownFields.mergeFieldFrom(tag, input);
            }
            if (packed) {
                int length = input.readRawVarint32();
                int limit = input.pushLimit(length);
                if (field.getLiteType() == WireFormat.FieldType.ENUM) {
                    while (input.getBytesUntilLimit() > 0) {
                        Descriptors.EnumValueDescriptor value = field.getEnumType().findValueByNumber(input.readEnum());
                        if (value == null) {
                            return true;
                        }
                        builder.addRepeatedField(field, value);
                    }
                } else {
                    while (input.getBytesUntilLimit() > 0) {
                        builder.addRepeatedField(field, FieldSet.readPrimitiveField(input, field.getLiteType()));
                    }
                }
                input.popLimit(limit);
            } else {
                switch (m0x792aeea3()[field.getType().ordinal()]) {
                    case 10:
                        if (defaultInstance != null) {
                            subBuilder2 = defaultInstance.newBuilderForType();
                        } else {
                            subBuilder2 = builder.newBuilderForField(field);
                        }
                        if (!field.isRepeated()) {
                            subBuilder2.mergeFrom((Message) builder.getField(field));
                        }
                        input.readGroup(field.getNumber(), subBuilder2, extensionRegistry);
                        objFindValueByNumber = subBuilder2.build();
                        break;
                    case 11:
                        if (defaultInstance != null) {
                            subBuilder = defaultInstance.newBuilderForType();
                        } else {
                            subBuilder = builder.newBuilderForField(field);
                        }
                        if (!field.isRepeated()) {
                            subBuilder.mergeFrom((Message) builder.getField(field));
                        }
                        input.readMessage(subBuilder, extensionRegistry);
                        objFindValueByNumber = subBuilder.build();
                        break;
                    case 12:
                    case 13:
                    default:
                        objFindValueByNumber = FieldSet.readPrimitiveField(input, field.getLiteType());
                        break;
                    case 14:
                        int rawValue = input.readEnum();
                        objFindValueByNumber = field.getEnumType().findValueByNumber(rawValue);
                        if (objFindValueByNumber == null) {
                            unknownFields.mergeVarintField(fieldNumber, rawValue);
                            return true;
                        }
                        break;
                }
                if (field.isRepeated()) {
                    builder.addRepeatedField(field, objFindValueByNumber);
                } else {
                    builder.setField(field, objFindValueByNumber);
                }
            }
            return true;
        }

        private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, Message.Builder builder) throws IOException {
            ExtensionRegistry.ExtensionInfo extension;
            Descriptors.Descriptor type = builder.getDescriptorForType();
            int typeId = 0;
            ByteString rawBytes = null;
            Message.Builder subBuilder = null;
            Descriptors.FieldDescriptor field = null;
            while (true) {
                int tag = input.readTag();
                if (tag == 0) {
                    break;
                }
                if (tag == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                    typeId = input.readUInt32();
                    if (typeId != 0) {
                        if (extensionRegistry instanceof ExtensionRegistry) {
                            extension = ((ExtensionRegistry) extensionRegistry).findExtensionByNumber(type, typeId);
                        } else {
                            extension = null;
                        }
                        if (extension != null) {
                            field = extension.descriptor;
                            subBuilder = extension.defaultInstance.newBuilderForType();
                            Message originalMessage = (Message) builder.getField(field);
                            if (originalMessage != null) {
                                subBuilder.mergeFrom(originalMessage);
                            }
                            if (rawBytes != null) {
                                subBuilder.mergeFrom(CodedInputStream.newInstance(rawBytes.newInput()));
                                rawBytes = null;
                            }
                        } else if (rawBytes != null) {
                            unknownFields.mergeField(typeId, UnknownFieldSet.Field.newBuilder().addLengthDelimited(rawBytes).build());
                            rawBytes = null;
                        }
                    }
                } else if (tag == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                    if (typeId == 0) {
                        rawBytes = input.readBytes();
                    } else if (subBuilder == null) {
                        unknownFields.mergeField(typeId, UnknownFieldSet.Field.newBuilder().addLengthDelimited(input.readBytes()).build());
                    } else {
                        input.readMessage(subBuilder, extensionRegistry);
                    }
                } else if (!input.skipField(tag)) {
                    break;
                }
            }
            input.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
            if (subBuilder != null) {
                builder.setField(field, subBuilder.build());
            }
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType mergeUnknownFields(UnknownFieldSet unknownFields) {
            setUnknownFields(UnknownFieldSet.newBuilder(getUnknownFields()).mergeFrom(unknownFields).build());
            return this;
        }

        protected static UninitializedMessageException newUninitializedMessageException(Message message) {
            return new UninitializedMessageException(findMissingFields(message));
        }

        private static List<String> findMissingFields(Message message) {
            List<String> results = new ArrayList<>();
            findMissingFields(message, "", results);
            return results;
        }

        private static void findMissingFields(Message message, String prefix, List<String> results) {
            for (Descriptors.FieldDescriptor field : message.getDescriptorForType().getFields()) {
                if (field.isRequired() && !message.hasField(field)) {
                    results.add(String.valueOf(prefix) + field.getName());
                }
            }
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : message.getAllFields().entrySet()) {
                Descriptors.FieldDescriptor field2 = entry.getKey();
                Object value = entry.getValue();
                if (field2.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (field2.isRepeated()) {
                        int i = 0;
                        for (Object element : (List) value) {
                            findMissingFields((Message) element, subMessagePrefix(prefix, field2, i), results);
                            i++;
                        }
                    } else if (message.hasField(field2)) {
                        findMissingFields((Message) value, subMessagePrefix(prefix, field2, -1), results);
                    }
                }
            }
        }

        private static String subMessagePrefix(String prefix, Descriptors.FieldDescriptor field, int index) {
            StringBuilder result = new StringBuilder(prefix);
            if (field.isExtension()) {
                result.append('(').append(field.getFullName()).append(')');
            } else {
                result.append(field.getName());
            }
            if (index != -1) {
                result.append('[').append(index).append(']');
            }
            result.append('.');
            return result.toString();
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString data) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(data);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(data, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] data) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(data);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(data, off, len);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(data, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (BuilderType) super.mergeFrom(data, off, len, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream input) throws IOException {
            return (BuilderType) super.mergeFrom(input);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BuilderType) super.mergeFrom(input, extensionRegistry);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream input) throws IOException {
            return super.mergeDelimitedFrom(input);
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return super.mergeDelimitedFrom(input, extensionRegistry);
        }
    }
}
